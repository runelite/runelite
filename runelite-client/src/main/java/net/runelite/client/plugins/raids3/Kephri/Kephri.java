package net.runelite.client.plugins.raids3.Kephri;

import java.util.Iterator;
import java.util.Set;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Projectile;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.Timer;
import net.runelite.client.plugins.raids3.AttackContainers.GroundAttack;
import net.runelite.client.plugins.raids3Util.MovementFlag2;
import net.runelite.client.plugins.raids3Util.OneUpUtilityPlugin;
import net.runelite.client.plugins.raids3Util.Utility;

public class Kephri {
  Client client;
  Raids3Plugin plugin;
  Raids3Config config;
  Utility utility;
  public final int FireBallProjectileID = 2266;
  public final int explodingBugID = 2147;
  public final int fireBallAttackSpeed = 5;
  public int pathLvl = 0;
  private Timer prayerTimer = new Timer(150, 450);

  public Kephri(Client client, Utility utility, Raids3Plugin raids3Plugin, Raids3Config raids3Config) {
    this.client = client;
    this.plugin = raids3Plugin;
    this.utility = utility;
    this.config = raids3Config;
  }

  public void onProjectileMoved(ProjectileMoved projectileMovedEvent) {
    Point sceneLocation;
    int attackSpeed;
    if (this.config.HightlightKephriFireBall() && projectileMovedEvent.getProjectile().getId() == 2266) {
      sceneLocation = new Point(projectileMovedEvent.getProjectile().getTarget().getSceneX(), projectileMovedEvent.getProjectile().getTarget().getSceneY());
      attackSpeed = this.GetAttackSpeed();
      if (this.config.AerialAssault()) {
        this.CreateFireBallGroundAttacks(sceneLocation, attackSpeed);
      } else {
        this.plugin.groundAttacks.add(new GroundAttack(sceneLocation, attackSpeed, this.config.KephriFireballColor(), true, false));
      }
    } else if (projectileMovedEvent.getProjectile().getId() == 2147) {
      sceneLocation = new Point(projectileMovedEvent.getProjectile().getTarget().getSceneX(), projectileMovedEvent.getProjectile().getTarget().getSceneY());
      attackSpeed = this.GetAttackSpeed();
      if (this.config.AerialAssault()) {
        this.CreateExplodingGroundAttacks(sceneLocation, attackSpeed);
      } else {
        this.plugin.groundAttacks.add(new GroundAttack(sceneLocation, attackSpeed, this.config.KephriFireballColor(), true, false));
      }
    }

  }

  private int GetAttackSpeed() {
    byte attackSpeed;
    switch(this.pathLvl) {
      case 2:
      case 3:
        attackSpeed = 4;
        break;
      case 4:
      case 5:
      case 6:
      case 7:
        attackSpeed = 3;
        break;
      default:
        attackSpeed = 5;
    }

    return attackSpeed;
  }

  private void CreateFireBallGroundAttacks(Point sceneLocation, int attackSpeed) {
    for(int x = -1; x <= 1; ++x) {
      for(int y = -1; y <= 1; ++y) {
        Point location = new Point(sceneLocation.getX() + x, sceneLocation.getY() + y);
        int[][] flags = this.client.getCollisionMaps()[this.client.getPlane()].getFlags();
        int data = flags[location.getX()][location.getY()];
        Set<MovementFlag2> movementFlags = MovementFlag2.getSetFlags(data);
        if (movementFlags.isEmpty()) {
          this.plugin.groundAttacks.add(new GroundAttack(location, attackSpeed, this.config.KephriFireballColor(), true, false));
        }
      }
    }

  }

  private void CreateExplodingGroundAttacks(Point sceneLocation, int attackSpeed) {
    for(int x = -1; x <= 1; ++x) {
      for(int y = -1; y <= 1; ++y) {
        Point location = new Point(sceneLocation.getX() + x, sceneLocation.getY() + y);
        int[][] flags = this.client.getCollisionMaps()[this.client.getPlane()].getFlags();
        int data = flags[location.getX()][location.getY()];
        Set<MovementFlag2> movementFlags = MovementFlag2.getSetFlags(data);
        if (movementFlags.isEmpty()) {
          this.plugin.groundAttacks.add(new GroundAttack(location, attackSpeed, this.config.KephriFireballColor(), true, false));
        }
      }
    }

  }

  public void onGameTick() {
    this.pathLvl = this.GetKephriRaidLevel();
    boolean shouldPrayMelee = false;
    boolean shouldPrayRange = false;
    boolean shouldPrayMage = false;
    Iterator var4 = this.client.getNpcs().iterator();

    while(var4.hasNext()) {
      NPC npc = (NPC)var4.next();
      if (npc.getName() != null) {
        if (npc.getName().equalsIgnoreCase("Soldier Scarab") && OneUpUtilityPlugin.SceneDistance(npc, this.client.getLocalPlayer()) < 3.0D) {
          shouldPrayMelee = true;
          break;
        }

        if (npc.getName().equalsIgnoreCase("Spitting Scarab") || npc.getName().equalsIgnoreCase("Agile Scarab")) {
          shouldPrayRange = true;
        }
      }
    }

    if (shouldPrayMage) {
      this.plugin.currentProtectionPrayer = Prayer.PROTECT_FROM_MAGIC;
      this.prayerTimer.Reset();
      this.plugin.DebugLog("PROTECT_FROM_MAGIC");
    } else if (shouldPrayMelee) {
      this.plugin.currentProtectionPrayer = Prayer.PROTECT_FROM_MELEE;
      this.prayerTimer.Reset();
      this.plugin.DebugLog("PROTECT_FROM_MELEE");
    } else if (shouldPrayRange) {
      this.plugin.currentProtectionPrayer = Prayer.PROTECT_FROM_MISSILES;
      this.prayerTimer.Reset();
      this.plugin.DebugLog("PROTECT_FROM_MISSILES");
    } else {
      this.plugin.currentProtectionPrayer = null;
    }

  }

  private int GetKephriRaidLevel() {
    if (this.client.getWidget(481, 45) != null && !this.client.getWidget(481, 45).isHidden()) {
      int lvl = Integer.parseInt(this.client.getWidget(481, 45).getText());
      return lvl;
    } else {
      return 0;
    }
  }

  public void OnNpcSpawned(NPC npc) {
  }

  public void OnNpcDespawned(NPC npc) {
  }
}