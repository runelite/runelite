package net.runelite.client.plugins.raids3.Akkha;

import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;

public class UnstableOrbTile {
  public Point npcOrientation;
  public WorldPoint tileLocation;
  public int gameTick;

  public UnstableOrbTile(Point objectOrientation, WorldPoint tileLocation, int gameTick) {
    this.npcOrientation = objectOrientation;
    this.tileLocation = tileLocation;
    this.gameTick = gameTick;
  }
}