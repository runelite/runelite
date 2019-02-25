package net.runelite.client.plugins.timetracking.clocks;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StopwatchTest {

    @Test
    public void whenCreatingStopwatch_thenCanCreateStopwatch() {
        Stopwatch stopwatch = new Stopwatch("Stopwatch");
        Assert.assertNotNull(stopwatch);
    }

    @Test
    public void setDuration() {
    }

    @Test
    public void start() {
    }

    @Test
    public void pause() {
    }

    @Test
    public void lap() {
    }

    @Test
    public void reset() {
    }

    @Test
    public void getElapsed() {
    }

    @Test
    public void getLaps() {
    }

    @Test
    public void setElapsed() {
    }

    @Test
    public void setLaps() {
    }
}