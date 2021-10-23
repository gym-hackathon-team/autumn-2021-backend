package com.gymteam.backend.bff.service.impl;

import com.gymteam.backend.bff.client.RecognizerClient;
import com.gymteam.backend.bff.client.UserClient;
import com.gymteam.backend.bff.dto.client.VoiceCommand;
import com.gymteam.backend.bff.dto.client.VoiceCommandResponse;
import com.gymteam.backend.bff.exception.VoiceNotRegisteredException;
import com.gymteam.backend.bff.service.interfaces.VoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class VoiceServiceImpl implements VoiceService {

    private RecognizerClient recognizerClient;

    public UserClient userClient;

    @Override
    public VoiceCommandResponse authorizeVoiceCommand(MultipartFile multipart) {
        // TODO Validate voice here

        VoiceCommandResponse response = new VoiceCommandResponse();
        response.setVoiceCommand(VoiceCommand.ORGANIZATION_PAYMENT);
        return response;
    }

    @Override
    public void registerUserVoice(MultipartFile multipartFile) throws VoiceNotRegisteredException {
        // TODO Update voice_id here
    }
}
