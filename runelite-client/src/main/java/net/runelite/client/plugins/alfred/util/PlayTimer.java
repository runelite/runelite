package net.runelite.client.plugins.alfred.util;

import lombok.Getter;

import java.time.Duration;
import java.util.Date;

public class PlayTimer {
    private long startTime;
    @Getter
    private int timeout = 0;

    public PlayTimer() {
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void reset() {
        startTime = System.currentTimeMillis();
        timeout = 0;
    }

    public void setRandomTimeout(int min, int max) {
        timeout = min + (int) (Math.random() * (max - min));
    }

    public boolean isTimerComplete() {
        if (timeout == 0) {
            return false;
        }

        return getElapsedMinutes() >= timeout;
    }

    public int getTimeRemaining() {
        if (timeout == 0) {
            return 0;
        }

        return timeout - getElapsedMinutes();
    }

    public int getElapsedMinutes() {
        long currentTime = System.currentTimeMillis();
        return (int) ((currentTime - startTime) / 1000 / 60);
    }

    public String getElapsedTimeString() {
        Duration duration = Duration.ofMillis(System.currentTimeMillis() - startTime);
        return String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
    }
}
