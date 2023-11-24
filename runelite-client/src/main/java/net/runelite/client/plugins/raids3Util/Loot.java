package net.runelite.client.plugins.raids3Util;

import net.runelite.api.coords.WorldPoint;

public class Loot {
  public String monsterName;
  public int id;
  public WorldPoint worldLocation;
  public int quantity;

  public Loot(String monsterName, int id, WorldPoint worldLocation, int quantity) {
    this.monsterName = monsterName;
    this.id = id;
    this.worldLocation = worldLocation;
    this.quantity = quantity;
  }
}