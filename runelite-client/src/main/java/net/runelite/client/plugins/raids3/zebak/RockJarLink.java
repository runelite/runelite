package net.runelite.client.plugins.raids3.zebak;

import net.runelite.api.Point;

public class RockJarLink {
  public Point rockTile;
  public Point jarTile;
  public Point pushTile;

  public RockJarLink(Point rockTile, Point jarTile, Point pushTile) {
    this.rockTile = rockTile;
    this.jarTile = jarTile;
    this.pushTile = pushTile;
  }
}