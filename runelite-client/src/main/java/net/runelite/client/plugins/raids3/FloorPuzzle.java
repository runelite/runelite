package net.runelite.client.plugins.raids3;

import java.util.List;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;

public class FloorPuzzle {
  public int ID;
  public TileObject tileObject;
  public List<WorldPoint> tileLocations;
  public WorldPoint walkTileLocation;

  public FloorPuzzle(int ID, TileObject tileObject, List<WorldPoint> tileLocations, WorldPoint walkTileLocation) {
    this.ID = ID;
    this.tileObject = tileObject;
    this.tileLocations = tileLocations;
    this.walkTileLocation = walkTileLocation;
  }
}