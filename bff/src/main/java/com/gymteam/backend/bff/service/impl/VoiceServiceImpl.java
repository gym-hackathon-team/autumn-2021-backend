package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.RecognizerClient;
import com.gymteam.backend.bff.client.UserClient;
import com.gymteam.backend.bff.dto.client.VoiceCommand;
import com.gymteam.backend.bff.dto.client.VoiceCommandResponse;
import com.gymteam.backend.bff.dto.recognize.RecognizedVoiceDto;
import com.gymteam.backend.bff.dto.user.UserDto;
import com.gymteam.backend.bff.exception.VoiceNotMatchingException;
import com.gymteam.backend.bff.exception.VoiceNotRegisteredException;
import com.gymteam.backend.bff.security.Authorized;
import com.gymteam.backend.bff.service.interfaces.VoiceService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@AllArgsConstructor
public class VoiceServiceImpl implements VoiceService {

    private RecognizerClient recognizerClient;

    public UserClient userClient;

    @Override
    public VoiceCommandResponse authorizeVoiceCommand(MultipartFile multipart) throws VoiceNotMatchingException {

        VoiceCommandResponse response=new VoiceCommandResponse();
        response.setVoiceCommand(VoiceCommand.USER_TRANSACTION);
        response.setDecision(true);

        return response;
        /*
        RecognizedVoiceDto recognized = recognizerClient.analyzeVoice(multipart);

        Authorized authorized = (Authorized) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto user = userClient.getUser(authorized.getId()); // Пользователь точно будет, ибо иначе авторизация не пустит сюда

        if (!Objects.equals(user.getVoiceId(), recognized.getVoiceId())) {
            throw new VoiceNotMatchingException();
        }

        String[] words = recognized.getWords().split(" ");
        // TODO Math recognized.getWords with enum

        VoiceCommandResponse response = new VoiceCommandResponse();
        response.setDecision(true);
        response.setVoiceCommand(VoiceCommand.ORGANIZATION_PAYMENT);
        return response;

         */
    }

    @Override
    public void registerUserVoice(MultipartFile multipartFile) throws VoiceNotRegisteredException {


        //RecognizedVoiceDto recognized = recognizerClient.analyzeVoice(multipartFile);
        RecognizedVoiceDto recognized = new RecognizedVoiceDto();
        recognized.setWords("окей абоба перевод пользователю андрей");
        double randId=Math.random() * 10;
        recognized.setVoiceId(Double.toString(randId));

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
