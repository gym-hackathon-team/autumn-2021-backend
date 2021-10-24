package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.recognize.RecognizedVoiceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Base64;

@FeignClient(name = "recognizer-service")
public interface RecognizerClient {

    @RequestMapping(value = "/recognize", method = RequestMethod.POST)
    RecognizedVoiceDto analyzeVoice(@RequestParam("upload_file") String upload_file); // TODO File variable type
}
