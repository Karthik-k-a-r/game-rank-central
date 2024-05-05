package com.intuit.craft.gamerankcentral.message;

import com.intuit.craft.gamerankcentral.constants.Constants;
import com.intuit.craft.gamerankcentral.dto.PlayerScore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    private KafkaTemplate<String, PlayerScore> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, PlayerScore> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(PlayerScore playerScore){
        log.info("{}, message={}", Constants.SuccessMessages.MESSAGE_PUBLISHED,playerScore.toString());

        Message<PlayerScore> message = MessageBuilder.withPayload(playerScore)
                        .setHeader(KafkaHeaders.TOPIC,"gameRankCentral")
                                .build();

        kafkaTemplate.send(message);
    }
}
