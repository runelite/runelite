package net.runelite.client.plugins.raids3.PuzzleRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.NpcChanged;
import net.runelite.client.plugins.raids3.Timer;
import net.runelite.client.plugins.raids3.AttackContainers.GroundAttack;
import net.runelite.client.plugins.raids3Util.Utility;

public class PuzzleRoom {
  public MemoryPillar[][] memoryPillars = new MemoryPillar[5][5];
  public NPC lastPillarInteractedWith = null;
  public int floorNumber = 20;
  public final int ANCIENT_ROCK = 45339;
  public final int SIMON_SAYS_Tile = 45341;
  public List<GroundObject> memoryTiles = new ArrayList();
  public List<GroundAttack> groundAttacks = new ArrayList();
  public int simonSaysTileIndex = 0;
  List<Point> floorNumberSymbols = new ArrayList();
  List<SimonSaysTile> simonSaysTiles = new ArrayList();
  FloorSymbols floorSymbols = new FloorSymbols();
  Timer simonSaysTileTimer = new Timer(1100, 1200);
  Utility utility;

  public void OnChatMessage(String message) {
    if (!message.startsWith("Your party failed to complete the challenge") && message.contains("has been hastily chipped into the stone.")) {
      String numberStr = message.substring(23, 25);

      try {
        int i = Integer.parseInt(numberStr);
        this.SetFloorNumber(i);
      } catch (NumberFormatException var4) {
      }
    }

  }

  public void onGameObjectSpawned(GameObjectSpawned event) {
    switch(event.getGameObject().getId()) {
      case 45339:
        this.SetFloorSymbolLocations(event.getGameObject());
      case 45340:
      default:
        break;
      case 45341:
        this.AddSimonSaysLocations(event);
        break;
      case 45342:
        this.UpdateSimonSaysTiles(event.getGameObject());
    }

  }

  private void UpdateSimonSaysTiles(GameObject gameObject) {
    if (this.simonSaysTiles != null && this.simonSaysTiles.size() != 0) {
      if (gameObject.getLocalLocation().getSceneX() == ((SimonSaysTile)this.simonSaysTiles.get(this.simonSaysTileIndex)).scenePoint.getX() && gameObject.getLocalLocation().getSceneY() == ((SimonSaysTile)this.simonSaysTiles.get(this.simonSaysTileIndex)).scenePoint.getY()) {
        ++this.simonSaysTileIndex;
      }

    }
  }

  public void OnNpcSpawned(NPC npc) {
  }

  public void OnNpcChanged(NpcChanged npcChanged) {
  }

  public void SetFloorSymbolLocations(GameObject ancientRock) {
    Point startingPoint = new Point(ancientRock.getLocalLocation().getSceneX() + 2, ancientRock.getLocalLocation().getSceneY());

    for(int i = 0; i < 5; ++i) {
      for(int y = 0; y < 5; ++y) {
        this.floorSymbols.locations[i][y] = new Point(startingPoint.getX() + i, startingPoint.getY() - y);
      }
    }

  }

  private void AddSimonSaysLocations(GameObjectSpawned gameObjectSpawned) {
    if (this.simonSaysTileTimer.isDone()) {
      this.simonSaysTiles.clear();
    }

    SimonSaysTile simonSaysTile = new SimonSaysTile(new Point(gameObjectSpawned.getGameObject().getLocalLocation().getSceneX(), gameObjectSpawned.getGameObject().getLocalLocation().getSceneY()), this.utility.findTileObject(gameObjectSpawned.getTile(), gameObjectSpawned.getGameObject().getId()));
    this.simonSaysTileTimer.Reset();
    this.simonSaysTiles.add(simonSaysTile);
  }

  public void SetFloorNumber(int floorNumber) {
    this.floorNumber = floorNumber;
    switch(floorNumber) {
      case 20:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[4][1]);
        break;
      case 21:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][0], this.floorSymbols.locations[1][0], this.floorSymbols.locations[2][0], this.floorSymbols.locations[3][0]);
        break;
      case 22:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][4], this.floorSymbols.locations[1][4], this.floorSymbols.locations[2][4], this.floorSymbols.locations[3][4], this.floorSymbols.locations[4][4]);
        break;
      case 23:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][0], this.floorSymbols.locations[1][1], this.floorSymbols.locations[1][2], this.floorSymbols.locations[1][3]);
        break;
      case 24:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][0], this.floorSymbols.locations[0][1], this.floorSymbols.locations[0][3]);
        break;
      case 25:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][2], this.floorSymbols.locations[1][2], this.floorSymbols.locations[2][2], this.floorSymbols.locations[3][2]);
        break;
      case 26:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[1][0], this.floorSymbols.locations[1][1], this.floorSymbols.locations[1][2], this.floorSymbols.locations[1][3], this.floorSymbols.locations[1][4]);
        break;
      case 27:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[1][0], this.floorSymbols.locations[1][1], this.floorSymbols.locations[1][2], this.floorSymbols.locations[1][3], this.floorSymbols.locations[1][4], this.floorSymbols.locations[0][4]);
        break;
      case 28:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][0], this.floorSymbols.locations[1][1], this.floorSymbols.locations[1][2], this.floorSymbols.locations[2][3]);
        break;
      case 29:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][4], this.floorSymbols.locations[1][4], this.floorSymbols.locations[2][4], this.floorSymbols.locations[3][4], this.floorSymbols.locations[3][3], this.floorSymbols.locations[3][2]);
        break;
      case 30:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][0], this.floorSymbols.locations[1][0], this.floorSymbols.locations[2][0], this.floorSymbols.locations[3][0], this.floorSymbols.locations[4][0]);
        break;
      case 31:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][0], this.floorSymbols.locations[1][0], this.floorSymbols.locations[2][0], this.floorSymbols.locations[3][0], this.floorSymbols.locations[4][0], this.floorSymbols.locations[4][1]);
        break;
      case 32:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][0], this.floorSymbols.locations[1][0], this.floorSymbols.locations[2][0], this.floorSymbols.locations[3][0], this.floorSymbols.locations[4][0], this.floorSymbols.locations[4][1], this.floorSymbols.locations[3][1]);
        break;
      case 33:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][4], this.floorSymbols.locations[1][4], this.floorSymbols.locations[2][4], this.floorSymbols.locations[3][4], this.floorSymbols.locations[3][3], this.floorSymbols.locations[3][2], this.floorSymbols.locations[2][2]);
        break;
      case 34:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[1][4], this.floorSymbols.locations[2][4], this.floorSymbols.locations[2][3], this.floorSymbols.locations[2][2], this.floorSymbols.locations[3][2], this.floorSymbols.locations[3][3]);
        break;
      case 35:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][0], this.floorSymbols.locations[1][0], this.floorSymbols.locations[1][1], this.floorSymbols.locations[1][2], this.floorSymbols.locations[1][3], this.floorSymbols.locations[1][4]);
        break;
      case 36:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][0], this.floorSymbols.locations[1][0], this.floorSymbols.locations[2][0], this.floorSymbols.locations[3][0], this.floorSymbols.locations[4][0], this.floorSymbols.locations[4][1], this.floorSymbols.locations[4][2]);
        break;
      case 37:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[1][4], this.floorSymbols.locations[2][4], this.floorSymbols.locations[2][3], this.floorSymbols.locations[2][2], this.floorSymbols.locations[3][2], this.floorSymbols.locations[3][3], this.floorSymbols.locations[4][4]);
        break;
      case 38:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[1][4], this.floorSymbols.locations[2][4], this.floorSymbols.locations[2][3], this.floorSymbols.locations[2][2], this.floorSymbols.locations[3][2], this.floorSymbols.locations[3][3], this.floorSymbols.locations[3][4]);
        break;
      case 39:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[1][4], this.floorSymbols.locations[2][4], this.floorSymbols.locations[2][3], this.floorSymbols.locations[2][2], this.floorSymbols.locations[3][2], this.floorSymbols.locations[3][3], this.floorSymbols.locations[4][2]);
        break;
      case 40:
        this.floorNumberSymbols = Arrays.asList(this.floorSymbols.locations[0][0], this.floorSymbols.locations[1][0], this.floorSymbols.locations[2][0], this.floorSymbols.locations[3][0], this.floorSymbols.locations[4][0], this.floorSymbols.locations[4][1], this.floorSymbols.locations[4][2], this.floorSymbols.locations[4][1], this.floorSymbols.locations[4][23]);
    }

  }

  public PuzzleRoom(Utility utility) {
    this.utility = utility;
  }

  public void Reset() {
    this.memoryTiles.clear();
    this.simonSaysTiles.clear();
    this.simonSaysTileIndex = 0;
    this.floorNumberSymbols = null;
  }
}