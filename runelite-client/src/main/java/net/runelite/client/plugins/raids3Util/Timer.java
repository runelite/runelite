package net.runelite.client.plugins.raids3Util;

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
    return (double)ThreadLocalRandom.current().nextInt(clamp((float)this.minDelay, 0.0F, 5000.0F), clamp((float)(this.maxDelay + 1), 0.0F, 5000.0F));
  }

  public double getStartTime() {
    return this.startTime;
  }

  public void setDelayTime(int min, int max) {
    this.minDelay = min;
    this.maxDelay = max;
    this.currentDelay = this.randomDelay();
    this.startTime = (double)System.currentTimeMillis();
  }

  public void End() {
    this.startTime = 0.0D;
  }

  public boolean isDone() {
    return (double)System.currentTimeMillis() - this.startTime > this.currentDelay;
  }

  public void Reset() {
    this.startTime = (double)System.currentTimeMillis();
    this.currentDelay = this.randomDelay();
  }

  public static int clamp(float val, float min, float max) {
    return (int)Math.max(min, Math.min(max, val));
  }

  public String TimeLeft() {
    return "" + (this.currentDelay - ((double)System.currentTimeMillis() - this.startTime));
  }

  public void SetMin(int value) {
    this.setDelayTime(value, this.maxDelay);
  }

  public void SetMax(int value) {
    this.setDelayTime(this.minDelay, value);
  }

  public int getMin() {
    return this.minDelay;
  }

  public int getMax() {
    return this.maxDelay;
  }
}