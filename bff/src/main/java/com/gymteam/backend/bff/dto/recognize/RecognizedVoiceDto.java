package com.gymteam.backend.bff.dto.recognize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecognizedVoiceDto {

    private String voiceId;

    private String words;
}
