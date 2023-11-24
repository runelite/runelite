package net.runelite.client.plugins.raids3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Prayer;

public class PrayerPriorityQue {
  public int currentTick = 0;
  public List<PrayerRequest> que = new ArrayList();
  public Prayer prayerPriority = null;
  public boolean isReadyToSwitch = false;
  public int switchTick = 0;
  public int endTick = 0;
  Raids3Plugin plugin;

  public PrayerPriorityQue(Raids3Plugin plugin) {
    this.plugin = plugin;
  }

  public void AddPrayerRequest(Prayer prayer, int switchSpeed, Color textColor) {
    PrayerRequest prayerRequest = new PrayerRequest(prayer, switchSpeed, this.currentTick, textColor);
    this.que.add(prayerRequest);
    if (this.que.size() == 1) {
      this.prayerPriority = this.que.get(0).prayer;
      this.switchTick = this.que.get(0).switchTick;
      this.endTick = this.que.get(0).endTick;
    }

  }

  public void onGameTick() {
    ++this.currentTick;
  }

  public void HandleQue() {
    if (this.currentTick >= this.switchTick) {
      this.isReadyToSwitch = true;
    }

    if (this.que.size() != 0) {
      if (this.currentTick > this.que.get(0).endTick) {
        this.que.remove(0);
        if (this.que.size() > 0) {
          this.switchTick = this.que.get(0).switchTick;
          this.endTick = this.que.get(0).endTick;
          this.prayerPriority = this.que.get(0).prayer;
        }

        this.isReadyToSwitch = false;
      }

    }
  }
}