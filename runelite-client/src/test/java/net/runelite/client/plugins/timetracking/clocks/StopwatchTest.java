package net.runelite.client.plugins.timetracking.clocks;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StopwatchTest {

    @Test
    public void whenCreatingStopwatch_thenCanCreateStopwatch() {
        Stopwatch sut = new Stopwatch("Stopwatch");
        Assert.assertNotNull(sut);
    }

    @Test
    public void whenCreatingStopwatch_thenCanSetDuration() {
        Stopwatch sut = new Stopwatch("Stopwatch");
        sut.setDuration(100);
        assertEquals(sut.getDisplayTime(), 100);
    }

    @Test
    public void whenCreatingStopwatch_thenCanPerformStopwatchFunctions() {
        Stopwatch sut = new Stopwatch("Stopwatch");
        sut.setDuration(100);
        sut.start();
        sut.pause();
        sut.reset();
    }

    @Test
    public void givenRunningStopwatch_whenCreatingStopwatch_thenCanUseLaps() throws InterruptedException {
        Stopwatch sut = new Stopwatch("Stopwatch");
        sut.setDuration(100);
        sut.start();
        TimeUnit.SECONDS.sleep(2);
        sut.lap();
        TimeUnit.SECONDS.sleep(2);
        sut.lap();
        List<Long> laps = sut.getLaps();
        assertEquals(laps.get(0), new Long(102));
        assertEquals(laps.get(1), new Long(104));
        sut.getElapsed();
    }

    @Test
    public void givenRunningStopwatch_whenCreatingStopWatch_thenCanSetLaps() throws InterruptedException {
        Stopwatch sut = new Stopwatch("Stopwatch");
        sut.setDuration(100);
        sut.start();
        TimeUnit.SECONDS.sleep(1);
        sut.lap();
        TimeUnit.SECONDS.sleep(1);
        sut.lap();
        List<Long> laps = sut.getLaps();
        TimeUnit.SECONDS.sleep(1);
        sut.lap();
        TimeUnit.SECONDS.sleep(1);
        sut.lap();
        sut.setLaps(laps);
        assertEquals(laps, sut.getLaps());

    }

    @Test
    public void givenRunningStopwatch_whenCreatingStopwatch_thenCanSetElapsed() throws InterruptedException {
        Stopwatch sut = new Stopwatch("Stopwatch");
        sut.start();
        TimeUnit.SECONDS.sleep(1);
        sut.pause();
        assertEquals(sut.getElapsed(), 1);
        sut.setElapsed(100);
        sut.start();
        TimeUnit.SECONDS.sleep(1);
        sut.pause();
        assertEquals(sut.getElapsed(), 101);

    }
}

