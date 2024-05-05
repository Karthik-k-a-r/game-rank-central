package com.intuit.craft.gamerankcentral.controller;

import com.intuit.craft.gamerankcentral.constants.Constants;
import com.intuit.craft.gamerankcentral.dto.PlayerScore;
import com.intuit.craft.gamerankcentral.message.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<Object> publish(@RequestBody PlayerScore playerScore){
        kafkaProducer.sendMessage(playerScore);
        return new ResponseEntity<>(Constants.SuccessMessages.MESSAGE_PUBLISHED,
                HttpStatus.OK);

    }

}
