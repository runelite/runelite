package net.runelite.http.api.pvpperformancetracker;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FightPerformanceRecord
{
    private String playerName;
    private int playerAttackCount;
    private int playerSuccessCount;

    private String opponentName;
    private int opponentAttackCount;
    private int opponentSuccessCount;
    private Instant time;
}
