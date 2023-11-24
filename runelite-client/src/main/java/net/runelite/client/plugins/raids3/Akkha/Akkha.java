package net.runelite.client.plugins.raids3.Akkha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.client.plugins.raids3.FloorPuzzle;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.Timer;
import net.runelite.client.plugins.raids3Util.Utility;

public class Akkha {
  Client client;
  Raids3Plugin plugin;
  Raids3Config raids3Config;
  Utility utility;
  final int FLOOR_SKULL = 45871;
  final int FLOOR_STAR = 45870;
  final int FLOOR_BOLT = 45869;
  final int FLOOR_FIRE = 45868;
  public final int[] TRAILING_ORB_IDs = new int[]{11800, 11801, 11802, 11803};
  public List<WorldPoint> floorSkullLocation = new ArrayList();
  public List<WorldPoint> floorStarLocation = new ArrayList();
  public List<WorldPoint> floorBoltLocation = new ArrayList();
  public List<WorldPoint> floorFireLocation = new ArrayList();
  public List<FloorPuzzle> akkhaFloorPuzzle = new ArrayList();
  public int akkhaMemoryTilesIndex = 0;
  public boolean isMemoryAttackStarting;
  public int gameTickCt = 0;
  Timer walkDelayTimer = new Timer(100, 250);
  Timer akkhaPrayerTimer = new Timer(450, 750);
  public HashMap<Point, UnstableOrbTile> orbGameTickMap = new HashMap();
  public HashMap<Point, HashMap<Integer, UnstableOrb>> unstableOrbs = new HashMap();
  public List<NPC> explodingOrbs = new ArrayList();
  HashMap<Integer, UnstableOrb> orbIndexMap = new HashMap();
  int savedAkkhaID = 0;
  public Timer prayerSwitchDelayTimer = new Timer(651, 1200);
  int gearSwitchDelay;
  int gearSwitchTick = 0;
  public Point floor_Skull_Scene_Location;

  public Akkha(Client client, Utility utility, Raids3Plugin raids3Plugin, Raids3Config raids3Config) {
    this.client = client;
    this.plugin = raids3Plugin;
    this.utility = utility;
    this.raids3Config = raids3Config;
    this.gearSwitchDelay = utility.getRandomIntBetweenRange(1, 3);
  }

  public void onBeforeRender() {

    if (this.akkhaPrayerTimer.isDone()) {
      this.akkhaPrayerTimer.Reset();
      this.HandleAkkhaPrayers();
    }

  }

  private void HandleAkkhaPrayers() {
    if (this.unstableOrbs.size() > 0) {
      this.plugin.currentProtectionPrayer = Prayer.PROTECT_FROM_MAGIC;

    } else if (this.plugin.akkhaNpc != null) {
      if (this.savedAkkhaID != this.plugin.akkhaNpc.getId()) {
        this.savedAkkhaID = this.plugin.akkhaNpc.getId();
        this.prayerSwitchDelayTimer.Reset();
      }

      switch(this.savedAkkhaID) {
        case 11790:
          this.plugin.currentProtectionPrayer = Prayer.PROTECT_FROM_MELEE;
          break;
        case 11791:
          this.plugin.currentProtectionPrayer = Prayer.PROTECT_FROM_MISSILES;
          break;
        case 11792:
          this.plugin.currentProtectionPrayer = Prayer.PROTECT_FROM_MAGIC;
          break;
        default:
          this.plugin.currentProtectionPrayer = null;
      }

    }
  }

  private void HandleUnstableOrbs() {
    this.orbGameTickMap.clear();
    if (this.unstableOrbs.size() != 0) {
      Point startPos = new Point(this.floor_Skull_Scene_Location.getX() - 1, this.floor_Skull_Scene_Location.getY() - 1);

      for(int i = 0; i < 11; ++i) {
        this.BuildCircle(startPos.getX(), startPos.getY(), i);
      }

    }
  }

  void BuildCircle(int x, int y, int r) {
    double PI = 3.1415926535D;

    for(double i = 0.0D; i < 360.0D; ++i) {
      int x1 = (int)((double)r * Math.cos(i * PI / 180.0D));
      int y1 = (int)((double)r * Math.sin(i * PI / 180.0D));
      WorldPoint worldPoint = new WorldPoint(x + x1, y + y1, this.client.getPlane());
      this.GetUnstableOrbTick(new Point(worldPoint.getX(), worldPoint.getY()));
    }

  }

  private void GetUnstableOrbTick(Point point) {
    int r = 15;

    for(int i = 0; i < r; ++i) {
      for(int Vx = -1; Vx <= 1; ++Vx) {
        for(int Vy = -1; Vy <= 1; ++Vy) {
          HashMap<Integer, UnstableOrb> indexMap = (HashMap)this.unstableOrbs.get(new Point(point.getX() + Vx * i, point.getY() + Vy * i));
          if (indexMap != null) {
            Iterator var7 = indexMap.values().iterator();

            while(var7.hasNext()) {
              UnstableOrb unstableOrb = (UnstableOrb)var7.next();
              if (this.IsVectorsOppositeDirection(new Point(Vx, Vy), unstableOrb.npcOrientation.getValue())) {
                UnstableOrbTile unstableOrbTile = new UnstableOrbTile(new Point(point.getX(), point.getY()), new WorldPoint(point.getX(), point.getY(), unstableOrb.scenePos.getPlane()), i);
                this.orbGameTickMap.put(new Point(point.getX(), point.getY()), unstableOrbTile);
                return;
              }
            }
          }
        }
      }
    }

    UnstableOrbTile unstableOrbTile = new UnstableOrbTile(new Point(point.getX(), point.getY()), new WorldPoint(point.getX(), point.getY(), this.client.getPlane()), 10);
    this.orbGameTickMap.put(new Point(point.getX(), point.getY()), unstableOrbTile);
  }

  private boolean IsVectorsOppositeDirection(Point vector1, Point vector2) {
    return -vector1.getX() == vector2.getX() && -vector1.getY() == vector2.getY();
  }

  public void onGameTick() {
    if (this.plugin.akkhaNpc == null) {
      this.plugin.akkhaNpc = this.utility.FindNPC(11795);
    } else if (this.plugin.akkhaNpc.isDead()) {
      this.plugin.akkhaNpc = null;
    }

    this.GrabUnstableOrbs();
    this.HandleUnstableOrbs();
    if (this.akkhaFloorPuzzle.size() > 0 && this.isMemoryAttackStarting) {
      byte targetTick;
      if (this.raids3Config.feelingSpecial()) {
        targetTick = 1;
      } else {
        targetTick = 3;
      }

      if (this.gameTickCt >= targetTick) {
        ++this.akkhaMemoryTilesIndex;
        this.gameTickCt = -1;
      }

      ++this.gameTickCt;
    }

  }

  private void GrabUnstableOrbs() {
    this.unstableOrbs.clear();
    Iterator var1 = this.client.getNpcs().iterator();

    while(var1.hasNext()) {
      NPC npc = (NPC)var1.next();
      if (npc.getId() == 11804) {
        Point localPoint = new Point(npc.getLocalLocation().getSceneX(), npc.getLocalLocation().getSceneY());
        WorldPoint worldPoint = new WorldPoint(npc.getLocalLocation().getSceneX(), npc.getLocalLocation().getSceneY(), this.client.getPlane());
        HashMap indexMap;
        if (this.unstableOrbs.get(localPoint) == null) {
          indexMap = new HashMap();
          indexMap.put(npc.getIndex(), new UnstableOrb(worldPoint, this.GetNPCOrientation(npc.getOrientation())));
          this.unstableOrbs.put(localPoint, indexMap);
        } else {
          indexMap = (HashMap)this.unstableOrbs.get(localPoint);
          indexMap.put(npc.getIndex(), new UnstableOrb(worldPoint, this.GetNPCOrientation(npc.getOrientation())));
        }
      }
    }

  }

  private ORBOrientation GetNPCOrientation(int orientation) {
    switch(orientation) {
      case 0:
        return ORBOrientation.South;
      case 254:
      case 255:
      case 256:
        return ORBOrientation.South_West;
      case 510:
      case 511:
      case 512:
        return ORBOrientation.West;
      case 765:
      case 767:
      case 768:
        return ORBOrientation.North_West;
      case 1022:
      case 1023:
      case 1024:
        return ORBOrientation.North;
      case 1280:
      case 1281:
      case 1282:
        return ORBOrientation.North_East;
      case 1536:
      case 1537:
      case 1538:
        return ORBOrientation.East;
      case 1792:
      case 1793:
      case 1794:
        return ORBOrientation.South_East;
      default:
        System.out.println("GetNPCOrientation: Invalid orientation value: " + orientation);
        return ORBOrientation.North;
    }
  }

  public void onGameObjectSpawned(GameObjectSpawned event) {
    switch(event.getGameObject().getId()) {
      case 45868:
        this.floorFireLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() + 1, event.getGameObject().getLocalLocation().getSceneY(), 0));
        this.floorFireLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX(), event.getGameObject().getLocalLocation().getSceneY() - 1, 0));
        this.floorFireLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() + 1, event.getGameObject().getLocalLocation().getSceneY() - 1, 0));
        this.akkhaFloorPuzzle.add(new FloorPuzzle(45868, this.utility.findTileObject(event.getTile(), event.getGameObject().getId()), this.floorFireLocation, new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() + 1, event.getGameObject().getLocalLocation().getSceneY() - 1, event.getGameObject().getWorldLocation().getPlane())));
        break;
      case 45869:
        this.floorBoltLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() - 1, event.getGameObject().getLocalLocation().getSceneY(), 0));
        this.floorBoltLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX(), event.getGameObject().getLocalLocation().getSceneY() + 1, 0));
        this.floorBoltLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() - 1, event.getGameObject().getLocalLocation().getSceneY() + 1, 0));
        this.akkhaFloorPuzzle.add(new FloorPuzzle(45869, this.utility.findTileObject(event.getTile(), event.getGameObject().getId()), this.floorBoltLocation, new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() - 1, event.getGameObject().getLocalLocation().getSceneY() + 1, event.getGameObject().getWorldLocation().getPlane())));
        break;
      case 45870:
        this.floorStarLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() + 1, event.getGameObject().getLocalLocation().getSceneY(), 0));
        this.floorStarLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX(), event.getGameObject().getLocalLocation().getSceneY() + 1, 0));
        this.floorStarLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() + 1, event.getGameObject().getLocalLocation().getSceneY() + 1, 0));
        this.akkhaFloorPuzzle.add(new FloorPuzzle(45870, this.utility.findTileObject(event.getTile(), event.getGameObject().getId()), this.floorStarLocation, new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() + 1, event.getGameObject().getLocalLocation().getSceneY() + 1, event.getGameObject().getWorldLocation().getPlane())));
        break;
      case 45871:
        this.floorSkullLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() - 1, event.getGameObject().getLocalLocation().getSceneY(), 0));
        this.floorSkullLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX(), event.getGameObject().getLocalLocation().getSceneY() - 1, 0));
        this.floorSkullLocation.add(new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() - 1, event.getGameObject().getLocalLocation().getSceneY() - 1, 0));
        this.floor_Skull_Scene_Location = new Point(event.getGameObject().getLocalLocation().getSceneX(), event.getGameObject().getLocalLocation().getSceneY());
        this.akkhaFloorPuzzle.add(new FloorPuzzle(45871, this.utility.findTileObject(event.getTile(), event.getGameObject().getId()), this.floorSkullLocation, new WorldPoint(event.getGameObject().getLocalLocation().getSceneX() - 1, event.getGameObject().getLocalLocation().getSceneY() - 1, event.getGameObject().getWorldLocation().getPlane())));
    }

  }

  public void Reset() {
    this.plugin.akkhaNpc = null;
    this.isMemoryAttackStarting = false;
    this.akkhaMemoryTilesIndex = 0;
    this.akkhaFloorPuzzle.clear();
    this.explodingOrbs.clear();
  }

  public void onNpcChanged() {
    this.gearSwitchTick = 0;
    this.prayerSwitchDelayTimer.Reset();
  }
}