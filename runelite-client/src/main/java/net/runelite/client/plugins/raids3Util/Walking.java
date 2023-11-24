package net.runelite.client.plugins.raids3Util;

import java.util.Iterator;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;

public class Walking {
  MouseUtils mouse;
  Utility utility;
  Client client;

  public Walking(Client client, MouseUtils nexMouseUtils, Utility utility) {
    this.mouse = nexMouseUtils;
    this.utility = utility;
    this.client = client;
  }

  public void WalkToSceneLocation(Point targetTile) {
    if (targetTile == null) {
      System.out.println("WalkToSceneLocation: NULL");
    }

    if (!this.utility.IsSceneTileInRange(targetTile, 10)) {
      System.out.println("Moving to towards the tile");
      this.mouse.ClickSceneTile(this.utility.WorldPointTowardsTile(targetTile));
    } else {
      System.out.println("Clicking Tile: " + targetTile);
      this.mouse.ClickSceneTile(this.RandomTileRadius(targetTile));
    }
  }

  private Point RandomTileRadius(Point targetTile) {
    return new Point(this.utility.getRandomIntBetweenRange(-1, 1) + targetTile.getX(), this.utility.getRandomIntBetweenRange(-1, 1) + targetTile.getY());
  }

  public void WalkToObjectInRange(GameObject nexWaitingRoomDoor, int minDistance) {
    Point scenePoint = new Point(nexWaitingRoomDoor.getLocalLocation().getSceneX(), nexWaitingRoomDoor.getLocalLocation().getSceneY());
    if (!this.utility.IsSceneTileInRange(scenePoint, minDistance)) {
      System.out.println("Moving to GameObject");
      this.mouse.ClickSceneTile(this.utility.WorldPointTowardsTile(scenePoint));
    }
  }

  public void MoveAwayFromNPC(NPC npc) {
    System.out.println("Walking - [MoveAwayFromNPC]");
    Point nexLoc = new Point(npc.getLocalLocation().getSceneX(), npc.getLocalLocation().getSceneY());
    Point playerPos = new Point(this.client.getLocalPlayer().getLocalLocation().getSceneX(), this.client.getLocalPlayer().getLocalLocation().getSceneY());
    int yPos = nexLoc.getY() - playerPos.getY();
    int xPos = nexLoc.getX() - playerPos.getX();
    int targetY;
    if (yPos > 0) {
      targetY = this.utility.getRandomIntBetweenRange(nexLoc.getY() - 10, nexLoc.getY() - 6);
    } else {
      targetY = this.utility.getRandomIntBetweenRange(nexLoc.getY() + 6, nexLoc.getY() + 10);
    }

    int targetX = this.utility.getRandomIntBetweenRange(nexLoc.getX() - 5, nexLoc.getX() + 5);
    WorldPoint targetTile = new WorldPoint(targetX, targetY, 0);
    System.out.println("Walking to safe Spot: " + targetTile);
    this.mouse.ClickSceneTile(new Point(targetTile.getX(), targetTile.getY()));
  }

  public Point GetRandomTileInPlayerClump() {
    int avgX = 0;
    int avgY = 0;
    int playerSize = this.client.getPlayers().size();

    Player player;
    for(Iterator var4 = this.client.getPlayers().iterator(); var4.hasNext(); avgY += player.getLocalLocation().getSceneY()) {
      player = (Player)var4.next();
      avgX += player.getLocalLocation().getSceneX();
    }

    Point avgPos = new Point(avgX / playerSize, avgY / playerSize);
    int minDistance = 1000;
    Point minPoint = avgPos;
    Iterator var7 = this.client.getPlayers().iterator();

    while(var7.hasNext()) {
      player = (Player)var7.next();
      Point localPoint = new Point(player.getLocalLocation().getSceneX(), player.getLocalLocation().getSceneY());
      int distance = localPoint.distanceTo(avgPos);
      if (distance <= minDistance) {
        minDistance = distance;
        minPoint = localPoint;
      }
    }

    System.out.println("Avg pos: " + avgPos);
    return minPoint;
  }
}