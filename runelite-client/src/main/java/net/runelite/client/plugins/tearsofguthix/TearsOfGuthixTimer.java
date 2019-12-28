package net.runelite.client.plugins.tearsofguthix;

import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.VarPlayer;
import net.runelite.client.plugins.timeofguthix.TimeOfGuthix;
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
        if(client.getLocalPlayer().getWorldLocation().getRegionID() == 12948 && client.getLocalPlayer().getWorldLocation().getX() >= 3250 && client.getLocalPlayer().getWorldLocation().getX() <= 3262)
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
