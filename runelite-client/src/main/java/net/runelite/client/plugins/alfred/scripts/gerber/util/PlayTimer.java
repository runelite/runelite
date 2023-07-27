package net.runelite.client.plugins.alfred.scripts.gerber.util;

public class PlayTimer {
    private long startTime;
    private int timeout = 0;

    public PlayTimer() {
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public int getElapsedMinutes() {
        long currentTime = System.currentTimeMillis();
        return (int) ((currentTime - startTime) / 1000 / 60);
    }

    public boolean isTimerComplete() {
        if (timeout == 0) {
            return false;
        }

        return getElapsedMinutes() >= timeout;
    }

    public void setRandomTimeout(int min, int max) {
        timeout = min + (int) (Math.random() * (max - min));
    }
}
