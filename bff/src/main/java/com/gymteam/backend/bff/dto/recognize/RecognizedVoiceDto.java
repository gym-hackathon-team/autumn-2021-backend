package com.gymteam.backend.bff.dto.recognize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecognizedVoiceDto {

    private Long voice_id;

    private String words;
}
