package com.gymteam.backend.bff.service.interfaces;

import com.gymteam.backend.bff.dto.client.VoiceCommandResponse;
import com.gymteam.backend.bff.exception.UnknownVoiceCommandException;
import com.gymteam.backend.bff.exception.VoiceNotMatchingException;
import com.gymteam.backend.bff.exception.VoiceNotRegisteredException;
import org.springframework.web.multipart.MultipartFile;

public interface VoiceService {

    VoiceCommandResponse authorizeVoiceCommand(MultipartFile multipart) throws VoiceNotMatchingException, UnknownVoiceCommandException;

    void registerUserVoice(MultipartFile multipartFile) throws VoiceNotRegisteredException;
}
