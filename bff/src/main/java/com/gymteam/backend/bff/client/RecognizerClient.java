package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.recognize.RecognizedVoiceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

//@FeignClient(name = "recognizer-service", url = "http://recognizer:8088/")
@FeignClient(name = "recognizer-service")
public interface RecognizerClient {

    @RequestMapping(value = "/recognize", method = RequestMethod.POST)
    RecognizedVoiceDto analyzeVoice(@RequestBody MultipartFile upload_file); // TODO File variable type
}
