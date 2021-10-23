package com.gymteam.backend.bff.dto.client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoiceCommandResponse {

    private boolean decision;

    private VoiceCommand voiceCommand;
}
