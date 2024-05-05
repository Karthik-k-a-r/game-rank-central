package com.intuit.craft.gamerankcentral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerScore {
    private int id;
    private String playerId;
    private int score;
    private String timeStamp;
}
