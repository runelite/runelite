package net.runelite.client.plugins.raids3.AttackContainers;

import java.awt.Color;
import net.runelite.api.Point;

public class GroundAttack {
  public Color color;
  public Point sceneLocation;
  public int attackSpeed;
  public int currentTick;
  public boolean isHighlighting;
  public boolean isTextAboveHead = false;

  public GroundAttack(Point sceneLocation, int attackSpeed, Color color, boolean isHighlighting, boolean isTextAboveHead) {
    this.sceneLocation = sceneLocation;
    this.attackSpeed = attackSpeed;
    this.color = color;
    this.isHighlighting = isHighlighting;
    this.isTextAboveHead = isTextAboveHead;
    this.currentTick = 0;
  }

  public void onGameTick() {
    ++this.currentTick;
  }

  public boolean isOver() {
    return this.currentTick >= this.attackSpeed;
  }
}
