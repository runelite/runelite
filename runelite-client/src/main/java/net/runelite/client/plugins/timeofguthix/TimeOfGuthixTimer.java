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

    void resetTimer() {
        startTime = Instant.now();
    }
    @Inject
    private TimeOfGuthix timeOfGuthix = new TimeOfGuthix();

    @Inject
    private ChatClient chatClient;

    @Inject
    private Client client;

    private String formatTime(LocalTime time)
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
        final Duration elapsed;
        elapsed = Duration.between(startTime, now).minusMillis(Constants.GAME_TICK_LENGTH);
        final long remaining = timeOfGuthix.allocatedTime() - elapsed.getSeconds();
        if(remaining < 0) {
            return "-1";
        }
        return formatTime(LocalTime.ofSecondOfDay( remaining ) );
    }


}
