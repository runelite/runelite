/*
 * Copyright (c) 2019, Matsyir <https://github.com/matsyir>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.pvpperformancetracker;

import lombok.Getter;

@Getter
public class PvpPerformanceStats
{
    private String playerName;
    private int playerAttackCount;
    private int playerSuccessCount;

    private String opponentName;
    private int opponentAttackCount;
    private int opponentSuccessCount;

    PvpPerformanceStats(String playerName, String opponentName)
    {
        this.playerName = playerName;
        this.opponentName = opponentName;
        playerAttackCount = 0;
        playerSuccessCount = 0;
        opponentAttackCount = 0;
        opponentSuccessCount = 0;
    }


    public void addAttack(String playerName, boolean success)
    {
        if (playerName == playerName)
        {
            playerAttackCount++;
            if (success)
            {
                playerSuccessCount++;
            }
        }
        else if (playerName == opponentName)
        {
            opponentAttackCount++;
            if (success)
            {
                opponentSuccessCount++;
            }
        }
    }
}
