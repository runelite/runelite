/*
 * Copyright (c) 2019, hiwilliam36 <https://github.com/hiwilliam36>
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
package net.runelite.client.plugins.tearsofguthix;

import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.VarPlayer;
import net.runelite.http.api.chat.ChatClient;
import javax.inject.Inject;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class TearsOfGuthixTimer {

    private Instant startTime = Instant.now();

    @Inject
    private TearsOfGuthixTimer tearsOfGuthixTimer;

    private int allocatedTime = -1;

    @Inject
    private ChatClient chatClient;

    @Inject
    private Client client;

    @Inject
    private TearsOfGuthixConfig config;

    private static String formatTime(LocalTime time)
    {
        if (time.getHour() > 0)
        {
            return time.format(DateTimeFormatter.ofPattern("HH:mm"));
        }
        else if (time.getMinute() > 9)
        {
            return time.format(DateTimeFormatter.ofPattern("mm:ss"));
        }
        else
        {
            return time.format(DateTimeFormatter.ofPattern("m:ss"));
        }
    }
    String getTime()
    {
        final Instant now = Instant.now();
        Duration elapsed;
        if(!config.time() || client.getLocalPlayer().getWorldLocation().getRegionID() == 12948 && client.getLocalPlayer().getWorldLocation().getX() >= 3250 && client.getLocalPlayer().getWorldLocation().getX() <= 3262)
        {
            elapsed = Duration.between(startTime, now).minusMillis(Constants.GAME_TICK_LENGTH);
            // if time is not calculated yet
            if(allocatedTime == -1)
            {
                allocatedTime = (int) Math.floor(getQp()*.6);
            }
            final long remaining = (allocatedTime) - elapsed.getSeconds();
            if(remaining < 0)
            {
                return "-1";
            }
            return formatTime(LocalTime.ofSecondOfDay(remaining));
        }
        else
        {
            startTime = Instant.now();
        }
        return "-1";
    }

    int getQp() {
        try {
            int qp = client.getVar(VarPlayer.QUEST_POINTS);
            chatClient.submitQp(client.getLocalPlayer().getName(), qp);
            return chatClient.getQp(client.getLocalPlayer().getName());
        }
        catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }





}
