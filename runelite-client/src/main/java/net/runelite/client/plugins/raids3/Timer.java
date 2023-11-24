package net.runelite.client.plugins.raids3;

import java.util.concurrent.ThreadLocalRandom;

public class Timer {
  private double startTime;
  private int minDelay;
  private int maxDelay;
  private double currentDelay;

  public Timer(int minDelay, int maxDelay) {
    this.minDelay = minDelay;
    this.maxDelay = maxDelay;
    this.currentDelay = this.randomDelay();
    this.startTime = (double)System.currentTimeMillis();
  }

  private double randomDelay() {
    return (double) ThreadLocalRandom.current().nextInt(this.minDelay, this.maxDelay + 1);
  }

  public double getStartTime() {
    return this.startTime;
  }

  public void setStartTime(double startTime) {
    this.startTime = startTime;
  }

  public boolean isDone() {
    return (double)System.currentTimeMillis() - this.startTime > this.currentDelay;
  }

  public void Reset() {
    this.startTime = (double)System.currentTimeMillis();
    this.currentDelay = this.randomDelay();
  }
}