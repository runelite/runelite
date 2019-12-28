package net.runelite.client.plugins.timeofguthix;

import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.http.api.chat.ChatClient;
import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class TimeOfGuthixTimer{

    private Instant startTime = Instant.now();

    @Inject
    private TimeOfGuthix timeOfGuthix;

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
        if(client.getLocalPlayer().getWorldLocation().getRegionID() == 12948 && client.getLocalPlayer().getWorldLocation().getX() >= 3254 && client.getLocalPlayer().getWorldLocation().getX() <= 3262)
        {
            elapsed = Duration.between(startTime, now).minusMillis(Constants.GAME_TICK_LENGTH);
            // if time is not calculated yet
            if(allocatedTime == -1)
            {
                allocatedTime = (int) Math.floor(timeOfGuthix.getQp()*.6);
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






}
