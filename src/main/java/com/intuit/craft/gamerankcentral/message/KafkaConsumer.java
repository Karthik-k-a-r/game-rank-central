package com.intuit.craft.gamerankcentral.message;

import ch.qos.logback.classic.PatternLayout;
import com.intuit.craft.gamerankcentral.constants.Constants;
import com.intuit.craft.gamerankcentral.dto.PlayerScore;
import com.intuit.craft.gamerankcentral.model.entity.Score;
import com.intuit.craft.gamerankcentral.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ScoreRepository scoreRepository;

    @KafkaListener(topics = "gameRankCentral", groupId = "gameRank")
    public void consume(PlayerScore playerScore){
        log.info("{}, message={}", Constants.SuccessMessages.MESSAGE_RECEIVED,playerScore.toString());
        Score score = Score.builder()
                .playerId(playerScore.getPlayerId())
                .score(playerScore.getScore())
                .timeStamp(playerScore.getTimeStamp())
                .build();
        scoreRepository.save(score);
    }
}
