package net.runelite.client.plugins.raids3.Akkha.ButterflyTech;

import java.util.HashMap;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.Timer;

public class ButterflyTech {
  HashMap<Integer, ButterflyTechRegion> butterflyTechRegionMap = new HashMap();
  Client client;
  public ButterflyTechRegion currentButterflyTechRegion;
  Raids3Plugin raids3Plugin;
  boolean isOn = false;
  Timer mouseClickTimer = new Timer(350, 850);

  public ButterflyTech(Client client, Raids3Plugin raids3Plugin) {
    this.client = client;
    this.raids3Plugin = raids3Plugin;
  }

  public void onBeforeRender() {
    if (this.butterflyTechRegionMap.size() != 0) {
      if (!this.isOn) {
        this.CheckIfOnButterflyStartingTile();
      } else {
        ButterflyTechTile butterflyTechTile = (ButterflyTechTile)this.currentButterflyTechRegion.getButterflyTechTileList().get(this.currentButterflyTechRegion.getIndex());
        if (!this.IsPlayerMovingToTile(butterflyTechTile)) {
          if (!this.mouseClickTimer.isDone()) {
            return;
          }

          this.mouseClickTimer.Reset();
          this.MoveToTile(butterflyTechTile);
        } else if (this.IsTileConditionMet(butterflyTechTile)) {
          System.out.println("Handling Next Tile");
          this.currentButterflyTechRegion.IncIndex();
        }

      }
    }
  }

  private void CheckIfOnButterflyStartingTile() {
    WorldPoint playerLocation = this.client.getLocalPlayer().getWorldLocation();
    LocalPoint playerLocalPoint = LocalPoint.fromWorld(this.client, playerLocation);
    Point scenePoint = new Point(playerLocalPoint.getSceneX(), playerLocalPoint.getSceneY());
    if (scenePoint.getX() == this.currentButterflyTechRegion.getStartingTile().location.getX() && scenePoint.getY() == this.currentButterflyTechRegion.getStartingTile().location.getY()) {
      if (this.raids3Plugin.akkhaNpc == null) {
        System.out.println("Akkha NPC is NULL??");
        return;
      }

      WorldPoint npcLocation = this.raids3Plugin.akkhaNpc.getWorldLocation();
      LocalPoint npcLocalPoint = LocalPoint.fromWorld(this.client, npcLocation);
      Point playerScenePoint = new Point(playerLocalPoint.getSceneX(), playerLocalPoint.getSceneY());
      Point npcScenePoint = new Point(npcLocalPoint.getSceneX(), npcLocalPoint.getSceneY());
      System.out.println("Distance: " + playerScenePoint.distanceTo(npcScenePoint));
      if (playerScenePoint.distanceTo(npcScenePoint) <= this.currentButterflyTechRegion.getStartingTile().npcDistance) {
        this.isOn = true;
        return;
      }
    }

  }

  private boolean IsPlayerMovingToTile(ButterflyTechTile butterflyTechTile) {
    LocalPoint localDestinationLocation = this.client.getLocalDestinationLocation();
    Point scenePoint;
    if (localDestinationLocation != null) {
      scenePoint = new Point(localDestinationLocation.getSceneX(), localDestinationLocation.getSceneY());
    } else {
      LocalPoint currentLocation = LocalPoint.fromWorld(this.client, this.client.getLocalPlayer().getWorldLocation());
      scenePoint = new Point(currentLocation.getSceneX(), currentLocation.getSceneY());
    }

    return scenePoint.getX() == butterflyTechTile.location.getX() && scenePoint.getY() == butterflyTechTile.location.getY();
  }

  private void MoveToTile(ButterflyTechTile butterflyTechTile) {
    WorldPoint sceneTile = new WorldPoint(butterflyTechTile.location.getX(), butterflyTechTile.location.getY(), this.client.getPlane());
    System.out.println("Moving to tile: " + sceneTile);
    this.raids3Plugin.mouse.ClickSceneTile(sceneTile, 5, 25);
  }

  private boolean IsTileConditionMet(ButterflyTechTile butterflyTechTile) {
    switch(butterflyTechTile.moveType) {
      case standingOn:
        return this.isStandingOn(butterflyTechTile);
      case bossDistance:
        return this.HandleBossDistance(butterflyTechTile);
      default:
        System.out.println("IsTileConditionMet: ERROR");
        return false;
    }
  }

  private boolean isStandingOn(ButterflyTechTile butterflyTechTile) {
    LocalPoint localPoint = LocalPoint.fromWorld(this.client, this.client.getLocalPlayer().getWorldLocation());
    Point scenePoint = new Point(localPoint.getSceneX(), localPoint.getSceneY());
    return scenePoint.getX() == butterflyTechTile.location.getX() && scenePoint.getY() == butterflyTechTile.location.getY();
  }

  private boolean HandleBossDistance(ButterflyTechTile butterflyTechTile) {
    if (!this.isStandingOn(butterflyTechTile)) {
      System.out.println("Not Standing On Tile");
      return false;
    } else if (this.raids3Plugin.akkhaNpc == null) {
      System.out.println("Akkha NPC is NULL??");
      return false;
    } else {
      Point playerSceneLocation = this.GetSceneTile(this.client.getLocalPlayer().getWorldLocation());
      Point npcSceneLocation = this.GetSceneTile(this.raids3Plugin.akkhaNpc.getWorldLocation());
      System.out.println("Distance: " + npcSceneLocation.distanceTo(playerSceneLocation));
      return npcSceneLocation.distanceTo(playerSceneLocation) <= butterflyTechTile.npcDistance;
    }
  }

  private Point GetSceneTile(WorldPoint worldLocation) {
    LocalPoint localPoint = LocalPoint.fromWorld(this.client, worldLocation);
    return new Point(localPoint.getSceneX(), localPoint.getSceneY());
  }

  public ButterflyTechRegion GetPlayerRegion() {
    return (ButterflyTechRegion)this.butterflyTechRegionMap.get(1);
  }

  public void BuildButterflyTechMap(Point floor_Skull_Scene_Location) {
  }

  public void onDeath() {
    this.isOn = false;
    if (this.currentButterflyTechRegion != null) {
      this.currentButterflyTechRegion.index = 0;
    }
  }

  public void onConfigChanged() {
    System.out.println("Updating Config");
    this.butterflyTechRegionMap.clear();
    this.currentButterflyTechRegion = null;
    this.BuildButterflyTechMap(this.raids3Plugin.akkhaRoom.floor_Skull_Scene_Location);
    this.currentButterflyTechRegion = this.GetPlayerRegion();
  }
}