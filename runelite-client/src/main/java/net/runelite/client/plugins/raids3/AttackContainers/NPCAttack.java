package net.runelite.client.plugins.raids3.AttackContainers;

import java.awt.Color;
import net.runelite.api.NPC;

public class NPCAttack {
  public NPC npc;
  public int currentTick = 0;
  public int attackSpeed;
  public Color color;

  public NPCAttack(int attackSpeed, Color color) {
    this.attackSpeed = attackSpeed;
    this.color = color;
  }

  public void onGameTick() {
    ++this.currentTick;
  }

  public boolean isDone() {
    return this.currentTick > this.attackSpeed;
  }

  public void Reset() {
    this.currentTick = 1;
  }
}
