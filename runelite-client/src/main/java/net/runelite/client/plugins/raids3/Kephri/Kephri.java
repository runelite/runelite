package net.runelite.client.plugins.raids3.Kephri;

import java.util.Set;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.Timer;
import net.runelite.client.plugins.raids3.AttackContainers.GroundAttack;
import net.runelite.client.plugins.raids3Util.MovementFlag2;
import net.runelite.client.plugins.raids3Util.OneUpUtilityPlugin;
import net.runelite.client.plugins.raids3Util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kephri {
  Client client;
  Raids3Plugin plugin;
  Raids3Config config;
  Utility utility;
  public final int FireBallProjectileID = 2266;
  public final int explodingBugID = 2147;
  public final int fireBallAttackSpeed = 5;
  public int pathLvl = 0;
  private static final Logger logger = LoggerFactory.getLogger(Kephri.class);

  public Kephri(Client client, Utility utility, Raids3Plugin raids3Plugin, Raids3Config raids3Config) {
    this.client = client;
    this.plugin = raids3Plugin;
    this.utility = utility;
    this.config = raids3Config;
  }

  public void onProjectileMoved(ProjectileMoved projectileMovedEvent) {
    Projectile projectile = projectileMovedEvent.getProjectile();
    Point targetSceneLocation = new Point(projectile.getTarget().getSceneX(), projectile.getTarget().getSceneY());
    int projectileId = projectile.getId();

    // Log projectile details
    logger.debug("Projectile ID: {}, Target Scene Location: {}", projectileId, targetSceneLocation);

    int attackSpeed = this.GetAttackSpeed();

    // Handling Kephri Fireball
    if (this.config.HightlightKephriFireBall() && projectileId == 2266) {
      if (this.config.AerialAssault()) {
        this.createFireBallGroundAttacks(targetSceneLocation, attackSpeed);
      } else {
        this.plugin.groundAttacks.add(new GroundAttack(targetSceneLocation, attackSpeed, this.config.KephriFireballColor(), true, false));
      }
    }
    // Handling another projectile type
    else if (projectileId == 2147) {
      if (this.config.AerialAssault()) {
        this.createExplodingGroundAttacks(targetSceneLocation, attackSpeed);
      } else {
        this.plugin.groundAttacks.add(new GroundAttack(targetSceneLocation, attackSpeed, this.config.KephriFireballColor(), true, false));
      }
    }

    // Additional debug information
    logger.debug("Attack Speed: {}, Ground Attacks Count: {}", attackSpeed, this.plugin.groundAttacks.size());
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

  private void createFireBallGroundAttacks(Point sceneLocation, int attackSpeed) {
    int[][] flags = this.client.getCollisionMaps()[this.client.getPlane()].getFlags();
    int maxX = flags.length;
    int maxY = flags[0].length;

    logger.debug("Creating Fire Ball Ground Attacks. maxX: {}, maxY: {}", maxX, maxY);

    for (int x = -1; x <= 1; ++x) {
      for (int y = -1; y <= 1; ++y) {
        int newX = sceneLocation.getX() + x;
        int newY = sceneLocation.getY() + y;

        logger.debug("Processing newX: {}, newY: {}", newX, newY);

        if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY) {
          int data = flags[newX][newY];
          Set<MovementFlag2> movementFlags = MovementFlag2.getSetFlags(data);

          logger.debug("Data: {}, Movement Flags: {}", data, movementFlags);

          if (movementFlags.isEmpty()) {
            Point location = new Point(newX, newY);
            this.plugin.groundAttacks.add(new GroundAttack(location, attackSpeed, this.config.KephriFireballColor(), true, false));
            logger.debug("Added Fire Ball Ground Attack at location: {}", location);
          }
        } else {
          logger.debug("Coordinates out of bounds: newX: {}, newY: {}", newX, newY);
        }
      }
    }
  }

  private void createExplodingGroundAttacks(Point sceneLocation, int attackSpeed) {
    int[][] flags = this.client.getCollisionMaps()[this.client.getPlane()].getFlags();
    int maxX = flags.length;
    int maxY = flags[0].length;

    logger.debug("Creating Exploding Ground Attacks. maxX: {}, maxY: {}", maxX, maxY);

    for (int x = -1; x <= 1; ++x) {
      for (int y = -1; y <= 1; ++y) {
        int newX = sceneLocation.getX() + x;
        int newY = sceneLocation.getY() + y;

        logger.debug("Processing newX: {}, newY: {}", newX, newY);

        if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY) {
          int data = flags[newX][newY];
          Set<MovementFlag2> movementFlags = MovementFlag2.getSetFlags(data);

          logger.debug("Data: {}, Movement Flags: {}", data, movementFlags);

          if (movementFlags.isEmpty()) {
            Point location = new Point(newX, newY);
            this.plugin.groundAttacks.add(new GroundAttack(location, attackSpeed, this.config.KephriFireballColor(), true, false));
            logger.debug("Added Exploding Ground Attack at location: {}", location);
          }
        } else {
          logger.debug("Coordinates out of bounds: newX: {}, newY: {}", newX, newY);
        }
      }
    }
  }

  public void onGameTick() {
    this.pathLvl = this.GetKephriRaidLevel();
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