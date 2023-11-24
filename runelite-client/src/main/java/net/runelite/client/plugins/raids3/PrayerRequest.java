package net.runelite.client.plugins.raids3;

import java.awt.Color;
import net.runelite.api.Prayer;
import net.runelite.client.plugins.raids3Util.OneUpUtilityPlugin;

public class PrayerRequest {
  Prayer prayer;
  int endTick;
  int switchTick;
  Color textColor;

  public PrayerRequest(Prayer prayer, int switchSpeed, int currentTick, Color textColor) {
    this.prayer = prayer;
    this.endTick = currentTick + switchSpeed;
    this.textColor = textColor;
    this.switchTick = OneUpUtilityPlugin.getRandomIntBetweenRange(currentTick, this.endTick - 2);
  }
}