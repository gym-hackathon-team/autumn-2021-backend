package com.gymteam.backend.bff.client;

import com.gymteam.backend.bff.dto.recognize.RecognizedVoiceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("recognizer-service")
public interface RecognizerClient {

    @RequestMapping(value = "/recognize", method = RequestMethod.POST)
    RecognizedVoiceDto signInUser(@RequestBody MediaType upload_file); // TODO File variable type
}
