package net.runelite.client.plugins.raids3.PuzzleRoom;

import net.runelite.api.Point;
import net.runelite.api.TileObject;

public class SimonSaysTile {
  Point scenePoint;
  TileObject tileObject;

  public SimonSaysTile(Point scenePoint, TileObject tileObject) {
    this.scenePoint = scenePoint;
    this.tileObject = tileObject;
  }
}