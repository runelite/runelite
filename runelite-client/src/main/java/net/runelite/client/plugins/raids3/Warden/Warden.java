package net.runelite.client.plugins.raids3.Warden;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.SpeedInvocation;
import net.runelite.client.plugins.raids3.AttackContainers.GroundAttack;
import net.runelite.client.plugins.raids3Util.MovementFlag2;
import net.runelite.client.plugins.raids3Util.Timer;

public class Warden {
  public static final int LEFT = -1;
  public static final int CENTER = 0;
  public static final int RIGHT = 1;
  Client client;
  Raids3Plugin plugin;
  final int redUFOGameObjectID = 45750;
  final int yellowUFOGameObjectID = 45751;
  final int zebakRangeUnopenedAttackID = 2178;
  final int zebakRangeUnopenedAttack2ID = 2179;
  final int zebakRangeShrapnelAttackID = 2187;
  final int zebakMagicUnopenedAttackID = 2176;
  final int zebakMagicUnopenedAttack2ID = 2177;
  final int zebakMagicShrapnelAttackID = 2181;
  private final int redScimitarProjectileID = 2204;
  private final int whiteArrowProjectileID = 2206;
  private final int blueSpellProjectileID = 2208;
  private final int redSkullProjectileID = 2224;
  private final int normalSkullProjectileID = 2241;
  private final int akkhaPhantomRangeProjectileID = 2255;
  private final int akkhaPhantomMageProjectileID = 2253;
  Timer slamAttackTimer = new Timer(601, 605);
  int unstableBoltWaveIndex = 0;
  private final int[] slam_attack_IDS = new int[]{2220, 2221, 2222, 2223};
  private final int unstable_bolt_shadow = 1446;
  private final int lightning_skull = 2225;
  private final int[] imprisonment_projectiles = new int[]{2210, 1447};
  public Point phase3Center = null;
  List<GameObject> ufoObjects = new ArrayList();
  public List<NPC> energySiphons = new ArrayList();
  public int[] columnOrder = new int[]{-1, 1, 0};
  public int slamSafeTileIndex = 0;
  private final int[] baba_BoulderIDs = new int[]{2250, 2251};
  public WardenPhase phase;
  public boolean isSiphonPhaseOn;
  boolean isUnstableBoltsActive;
  int[] siphonExplosionIDs;
  private int slamTick;
  private boolean isSlamAttackOn;
  public NPC elidinisWardenNPC;

  public Warden(Client client, Raids3Plugin raids3Plugin) {
    this.phase = WardenPhase.phase1;
    this.isSiphonPhaseOn = false;
    this.isUnstableBoltsActive = false;
    this.siphonExplosionIDs = new int[]{2156, 2157, 2158, 2159};
    this.slamTick = 0;
    this.elidinisWardenNPC = null;
    this.client = client;
    this.plugin = raids3Plugin;
  }

  public void onGameObjectDespawned(GameObjectDespawned event) {
    switch(event.getGameObject().getId()) {
      case 45750:
      case 45751:
        this.ufoObjects.clear();
      default:
    }
  }

  public void onBeforeRender() {
  }

  public void onGameObjectSpawned(GameObjectSpawned event) {
    switch(event.getGameObject().getId()) {
      case 45750:
      case 45751:
        this.ufoObjects.add(event.getGameObject());
      default:
    }
  }

  public void onGameTick() {
    if (this.elidinisWardenNPC != null) {
      if (this.elidinisWardenNPC.isDead()) {
        System.out.println("Elidnis Warden has Died");
        this.plugin.prayerQue.prayerPriority = null;
        this.elidinisWardenNPC = null;
      } else if (this.elidinisWardenNPC.getId() == 11755) {
        this.plugin.prayerQue.prayerPriority = null;
      }
    }

    if (this.plugin.testWardenNPC != null && (this.phase3Center == null || this.plugin.testWardenNPC.getLocalLocation().getSceneX() != this.phase3Center.getX() && this.plugin.testWardenNPC.getLocalLocation().getSceneY() != this.phase3Center.getY())) {
      this.phase3Center = new Point(this.plugin.testWardenNPC.getLocalLocation().getSceneX(), this.plugin.testWardenNPC.getLocalLocation().getSceneY() + 3);
    }

    if (this.isUnstableBoltsActive) {
      ++this.unstableBoltWaveIndex;
      if (this.unstableBoltWaveIndex == 4) {
        this.unstableBoltWaveIndex = 1;
      }
    }

    if (this.isSlamAttackOn) {
      int slamSpeed = this.plugin.config.SpeedInvocation().equals(SpeedInvocation.Normal) ? 4 : 2;
      if (this.slamTick >= slamSpeed) {
        this.slamTick = 0;
        this.slamSafeTileIndex = (this.slamSafeTileIndex + 1) % 3;
        this.isSlamAttackOn = false;
      } else {
        ++this.slamTick;
      }
    }

  }

  public void onGraphicsObjectCreated(GraphicsObject graphicsObject) {
    if (this.plugin.config.HighlightWardenUnstableBolt() && graphicsObject.getId() == 1446) {
      if (!this.isUnstableBoltsActive) {
        this.isUnstableBoltsActive = true;
        this.unstableBoltWaveIndex = 1;
      }

      int attackSpeed = this.plugin.config.SpeedInvocation().equals(SpeedInvocation.Insanity) ? 4 : 5;
      Color color;
      switch(this.unstableBoltWaveIndex) {
        case 1:
          color = this.plugin.config.WardenWave1UnstableBoltColor();
          break;
        case 2:
          color = this.plugin.config.WardenWave2UnstableBoltColor();
          break;
        default:
          color = this.plugin.config.WardenWave3UnstableBoltColor();
      }

      Point sceneLocation = new Point(graphicsObject.getLocation().getSceneX(), graphicsObject.getLocation().getSceneY());
      this.plugin.groundAttacks.add(new GroundAttack(sceneLocation, attackSpeed, color, true, false));
    } else if (Arrays.stream(this.slam_attack_IDS).anyMatch((s) -> {
      return s == graphicsObject.getId();
    })) {
      if (!this.slamAttackTimer.isDone() || this.isSlamAttackOn) {
        return;
      }

      this.slamAttackTimer.Reset();
      this.isSlamAttackOn = true;
      this.slamTick = 0;
    } else {
      Point sceneLocation;
      if (this.plugin.config.HighlightBabaBoulder() && Arrays.stream(this.baba_BoulderIDs).anyMatch((s) -> {
        return s == graphicsObject.getId();
      })) {
        sceneLocation = new Point(graphicsObject.getLocation().getSceneX(), graphicsObject.getLocation().getSceneY());
        int attackSpeed = this.plugin.config.SpeedInvocation().equals(SpeedInvocation.Insanity) ? 6 : 8;
        this.plugin.groundAttacks.add(new GroundAttack(sceneLocation, attackSpeed, this.plugin.config.BabaBoulderColor(), true, false));
      } else if (this.isSiphonPhaseOn && Arrays.stream(this.siphonExplosionIDs).anyMatch((s) -> {
        return s == graphicsObject.getId();
      })) {
        sceneLocation = new Point(graphicsObject.getLocation().getSceneX(), graphicsObject.getLocation().getSceneY());
        if (sceneLocation.getX() == this.phase3Center.getX() && sceneLocation.getY() == this.phase3Center.getY() - 1) {
          this.plugin.DebugLog("Successfully Disabled Siphons");
          if (!this.plugin.config.SpeedInvocation().equals(SpeedInvocation.Insanity)) {
            this.slamSafeTileIndex = 0;
          }
        } else {
          this.plugin.DebugLog("UnSuccessfully Disabled Siphons");
          if (!this.plugin.config.SpeedInvocation().equals(SpeedInvocation.Insanity)) {
            this.slamSafeTileIndex = 2;
          } else {
            this.slamSafeTileIndex = this.slamSafeTileIndex == 0 ? 2 : this.slamSafeTileIndex - 1;
          }
        }

        this.isSiphonPhaseOn = false;
      } else if (this.plugin.config.HighlightWardenImprisonment() && Arrays.stream(this.imprisonment_projectiles).anyMatch((s) -> {
        return s == graphicsObject.getId();
      })) {
        sceneLocation = new Point(graphicsObject.getLocation().getSceneX(), graphicsObject.getLocation().getSceneY());
        this.plugin.groundAttacks.add(new GroundAttack(sceneLocation, 6, this.plugin.config.WardenImprisonmentTileColor(), true, false));
      }
    }

  }

  public void onProjectileMoved(ProjectileMoved projectileMovedEvent) {
    if (this.plugin.config.HighlightWardenLightning() && projectileMovedEvent.getProjectile().getId() == 2225) {
      Point sceneLocation = new Point(projectileMovedEvent.getProjectile().getTarget().getSceneX(), projectileMovedEvent.getProjectile().getTarget().getSceneY());
      this.CreateLightningSkullTiles(sceneLocation);
    } else {
      Prayer prayer;
      int attackSpeed;
      switch(projectileMovedEvent.getProjectile().getId()) {
        case 2176:
        case 2177:
        case 2253:
          prayer = Prayer.PROTECT_FROM_MAGIC;
          attackSpeed = this.GetPhantomAttackSpeed();
          break;
        case 2178:
        case 2179:
        case 2255:
          prayer = Prayer.PROTECT_FROM_MISSILES;
          attackSpeed = this.GetPhantomAttackSpeed();
          break;
        case 2204:
          if (this.plugin.prayerQue.que.size() > 0) {
            return;
          }

          prayer = Prayer.PROTECT_FROM_MELEE;
          attackSpeed = 4;
          break;
        case 2206:
        case 2241:
          if (this.plugin.prayerQue.que.size() > 0) {
            return;
          }

          prayer = Prayer.PROTECT_FROM_MISSILES;
          attackSpeed = 4;
          break;
        case 2208:
        case 2224:
          if (this.plugin.prayerQue.que.size() > 0) {
            return;
          }

          prayer = Prayer.PROTECT_FROM_MAGIC;
          attackSpeed = 4;
          break;
        default:
          return;
      }

      this.plugin.prayerQue.AddPrayerRequest(prayer, attackSpeed, Color.WHITE);
    }
  }

  private int GetPhantomAttackSpeed() {
    return this.isUnstableBoltsActive && this.plugin.config.SpeedInvocation().equals(SpeedInvocation.Insanity) ? 7 : 9;
  }

  public void CreateLightningSkullTiles(Point sceneLocation) {
    for(int x = -3; x <= 3; ++x) {
      for(int y = -3; y <= 3; ++y) {
        if ((x != 0 || y >= 0 || y < -2) && (x != 0 || y <= 0 || y > 2) && (y != 0 || x >= 0 || x < -2) && (y != 0 || x <= 0 || x > 2) && (x != 0 || y != 0)) {
          Point location = new Point(sceneLocation.getX() + x, sceneLocation.getY() + y);
          int[][] flags = this.client.getCollisionMaps()[this.client.getPlane()].getFlags();
          int data = flags[location.getX()][location.getY()];
          Set<MovementFlag2> movementFlags = MovementFlag2.getSetFlags(data);
          if (movementFlags.isEmpty()) {
            this.plugin.groundAttacks.add(new GroundAttack(location, 6, this.plugin.config.WardenLightningTileColor(), true, false));
          }
        }
      }
    }

    this.plugin.groundAttacks.add(new GroundAttack(sceneLocation, 6, this.plugin.config.WardenLightningCenterTileColor(), true, false));
  }

  public void StartPhase3() {
    this.phase = WardenPhase.phase3;
    this.slamSafeTileIndex = 0;
    this.unstableBoltWaveIndex = 0;
    this.energySiphons.clear();
    this.isUnstableBoltsActive = false;
    this.isSiphonPhaseOn = false;
  }

  public void Reset() {
    this.slamSafeTileIndex = 0;
    this.phase = WardenPhase.phase1;
    this.unstableBoltWaveIndex = 0;
    this.energySiphons.clear();
    this.isUnstableBoltsActive = false;
    this.isSiphonPhaseOn = false;
  }

  public void onNPCChanged(NpcChanged npcChanged) {
  }

  public void TurnOnSiphonPhase() {
    this.isSiphonPhaseOn = true;
  }

  public int GetSiphonDespawnSpeed() {
    if (this.plugin.testWardenNPC == null) {
      return 12;
    } else {
      double wardenHP = (double)this.plugin.testWardenNPC.getHealthRatio() / (double)this.plugin.testWardenNPC.getHealthScale() * 100.0D;
      if (wardenHP <= 20.0D) {
        return 12;
      } else if (wardenHP <= 40.0D) {
        return 11;
      } else {
        return wardenHP <= 60.0D ? 10 : 9;
      }
    }
  }
}