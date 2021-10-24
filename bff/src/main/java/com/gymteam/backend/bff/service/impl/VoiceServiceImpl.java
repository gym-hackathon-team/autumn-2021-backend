package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.RecognizerClient;
import com.gymteam.backend.bff.client.UserClient;
import com.gymteam.backend.bff.dto.client.VoiceCommand;
import com.gymteam.backend.bff.dto.client.VoiceCommandResponse;
import com.gymteam.backend.bff.dto.recognize.RecognizedVoiceDto;
import com.gymteam.backend.bff.dto.user.UserDto;
import com.gymteam.backend.bff.exception.UnknownVoiceCommandException;
import com.gymteam.backend.bff.exception.VoiceNotMatchingException;
import com.gymteam.backend.bff.exception.VoiceNotRegisteredException;
import com.gymteam.backend.bff.security.Authorized;
import com.gymteam.backend.bff.service.interfaces.VoiceService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;

@Service
@AllArgsConstructor
public class VoiceServiceImpl implements VoiceService {

    private RecognizerClient recognizerClient;

    public UserClient userClient;

    @Override
    public VoiceCommandResponse authorizeVoiceCommand(MultipartFile multipart) throws VoiceNotMatchingException, UnknownVoiceCommandException {
        RecognizedVoiceDto recognized = recognizerClient.analyzeVoice(multipart);

        Authorized authorized = (Authorized) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto user = userClient.getUser(authorized.getId()); // Пользователь точно будет, ибо иначе авторизация не пустит сюда

        if (!Objects.equals(user.getVoiceId(), recognized.getVoiceId())) {
            throw new VoiceNotMatchingException();
        }

        VoiceCommandResponse response = new VoiceCommandResponse();
        response.setDecision(true);

        String words = recognized.getWords().toLowerCase(Locale.ROOT);
        boolean foundUserTransaction = words.contains("перевод пользователю");
        boolean foundOrganizationPayment = words.contains("оплатить услугу");

        if (foundUserTransaction) {
            response.setVoiceCommand(VoiceCommand.USER_TRANSACTION);
        } else if (foundOrganizationPayment) {
            response.setVoiceCommand(VoiceCommand.ORGANIZATION_PAYMENT);
        } else {
            throw new UnknownVoiceCommandException();
        }

        return response;
    }

    @Override
    public void registerUserVoice(MultipartFile multipartFile) throws VoiceNotRegisteredException, MalformedURLException, ProtocolException {
        RecognizedVoiceDto recognized = recognizerClient.analyzeVoice(multipartFile);

        Authorized authorized = (Authorized) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto user = userClient.getUser(authorized.getId()); // Пользователь точно будет, ибо иначе авторизация не пустит сюда

        user.setVoiceId(recognized.getVoiceId());
        try {
            userClient.updateUser(user);
        } catch (Exception e) {
            throw new VoiceNotRegisteredException();
        }
    }
}
