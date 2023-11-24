package net.runelite.client.plugins.raids3Util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CalculationUtils {
  protected static final Random random = new Random();

  public int getRandomIntBetweenRange(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  public long randomDelay(boolean weightedDistribution, int min, int max, int deviation, int target) {
    return weightedDistribution ? (long)this.clamp(-Math.log(Math.abs(random.nextGaussian())) * (double)deviation + (double)target, min, max) : (long)this.clamp((double)Math.round(random.nextGaussian() * (double)deviation + (double)target), min, max);
  }

  private double clamp(double val, int min, int max) {
    return Math.max((double)min, Math.min((double)max, val));
  }

  public static double random(double min, double max) {
    return Math.min(min, max) + random.nextDouble() * Math.abs(max - min);
  }

  public static int random(int min, int max) {
    int n = Math.abs(max - min);
    return Math.min(min, max) + (n == 0 ? 0 : random.nextInt(n));
  }
}