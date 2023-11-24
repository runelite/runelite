package net.runelite.client.plugins.raids3.Akkha.ButterflyTech;

import net.runelite.api.coords.WorldPoint;

public class ButterflyTechTile {
  public int npcDistance;
  ButterflyTechTileType moveType;
  WorldPoint location;

  public ButterflyTechTile(ButterflyTechTileType moveType, WorldPoint worldPoint, int npcDistance) {
    this.moveType = moveType;
    this.location = worldPoint;
    this.npcDistance = npcDistance;
  }
}