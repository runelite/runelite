package net.runelite.client.plugins.timetracking.clocks;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TimerTest {

    @Test
    public void whenCreatingTimer_thenCanCreateTimer() {
        Timer sut = new Timer("Timertest", 1000);
    }

    @Test
    public void givenDuration_whenCreatingTimer_thenGetDisplayTimeReturnsDuration() {
        Timer sut = new Timer("Timertest", 1000);
        assertEquals(sut.getDisplayTime(), 1000);
    }

    @Test
    public void givenStartedTimer_whenCreatingTimer_thenTimerDisplayDoesNotReturnInitialDuration() throws InterruptedException {
        Timer sut = new Timer("Timertest", 1000);
        sut.start();
        TimeUnit.SECONDS.sleep(2);
        assertNotEquals(sut.getDisplayTime(), 1000);

    }

    @Test
    public void givenStartedTimer_whenCreatingTimer_thenPausedTimerDisplaysRemainingSeconds() throws InterruptedException {
        Timer sut = new Timer("Timertest", 1000);
        sut.start();
        TimeUnit.SECONDS.sleep(2);
        sut.pause();
        assertEquals(sut.getDisplayTime(), 998);
    }

    @Test
    public void givenStartedTimer_whenCreatingTimer_thenResetTimerDisplaysOriginalDuration() throws InterruptedException {
        Timer sut = new Timer("Timertest", 1000);
        sut.start();
        TimeUnit.SECONDS.sleep(2);
        sut.reset();
        assertEquals(sut.getDisplayTime(), 1000);
    }

    @Test
    public void givenModifiedRunningTimer_whenCreatingTimer_thenGetAndSetMethodsWorkCorrectly() throws InterruptedException {
        Timer sut = new Timer("Timertest", 5);
        sut.start();
        sut.setDuration(2);
        assertEquals(sut.getDuration(), 2);
        assertEquals(sut.getDisplayTime(), 5);
        TimeUnit.SECONDS.sleep(2);
        assertEquals(sut.getDisplayTime(), 3);
        sut.setRemaining(5800);
        assertEquals(sut.getRemaining(), 5800);

    }

    @Test
    public void getRemaining() {
    }

    @Test
    public void setDuration() {
    }

    @Test
    public void setRemaining() {
    }
}