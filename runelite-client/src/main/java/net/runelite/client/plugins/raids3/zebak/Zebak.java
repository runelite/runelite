package net.runelite.client.plugins.raids3.zebak;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.AttackContainers.EnemyProjectile;
import net.runelite.client.plugins.raids3.AttackContainers.GroundAttack;
import net.runelite.client.plugins.raids3.Raids3Plugin;

public class Zebak {
  final int zebakRangeUnopenedAttackID = 2178;
  final int zebakRangeUnopenedAttack2ID = 2179;
  final int zebakRangeShrapnelAttackID = 2187;
  final int zebakMagicUnopenedAttackID = 2176;
  final int zebakMagicUnopenedAttack2ID = 2177;
  final int zebakMagicShrapnelAttackID = 2181;
  final int acidProjectileID = 1555;
  final int acidProjectile2ID = 2194;
  Client client;
  Raids3Plugin plugin;
  List<EnemyProjectile> zebakUnOpenedProjectiles = new ArrayList();
  List<EnemyProjectile> zebakShrapnelProjectiles = new ArrayList();
  public ZebakAcidAttack acidAttack;
  private final int safeRockProjectileID = 2172;
  private final int jarProjectileID = 2173;
  private boolean isLowHP = false;

  public Zebak(Client client, Raids3Plugin raids3Plugin) {
    this.client = client;
    this.plugin = raids3Plugin;
    this.acidAttack = new ZebakAcidAttack(this.plugin, this.plugin.utility);
  }

  public void onGameTick() {
    if (this.zebakUnOpenedProjectiles.size() > 0) {
      System.out.print("Size Check: " + this.zebakUnOpenedProjectiles.size());
      this.zebakUnOpenedProjectiles.removeIf((s) -> {
        return s.projectile.getRemainingCycles() <= 0;
      });
      System.out.println("    :  " + this.zebakUnOpenedProjectiles.size());
      this.zebakShrapnelProjectiles.removeIf((s) -> {
        return s.projectile.getRemainingCycles() <= 0;
      });
    }

    this.acidAttack.gameTick();
  }

  public void onProjectileMoved(Projectile projectile) {
    Prayer prayer = null;
    switch (projectile.getId()) {
      case 2176:
      case 2177:
        prayer = Prayer.PROTECT_FROM_MAGIC;
        break;
      case 2178:
      case 2179:
        prayer = Prayer.PROTECT_FROM_MISSILES;
    }

    if (prayer != null) {
      int attackSpeed = this.GetZebakAttackSpeed();
      Color textColor = attackSpeed == 7 ? Color.CYAN : Color.WHITE;
      this.plugin.prayerQue.AddPrayerRequest(prayer, attackSpeed, textColor);
    }

    switch (projectile.getId()) {
      case 1555:
        this.CreateAcidSplatter(projectile.getTarget());
        if (!this.acidAttack.isOn) {
          this.acidAttack.TurnOn();
        }
        break;
      case 2172:
        this.acidAttack.rocks.add(this.plugin.utility.SceneFromLocal(projectile.getTarget()));
        break;
      case 2173:
        this.acidAttack.jars.add(this.plugin.utility.SceneFromLocal(projectile.getTarget()));
        break;
      case 2194:
        if (projectile.getRemainingCycles() < 100) {
          return;
        }

        Point scenePoint = this.plugin.utility.SceneFromLocal(projectile.getTarget());
        this.plugin.groundAttacks.add(new GroundAttack(scenePoint, 6, Color.YELLOW, true, false));
        this.acidAttack.floorAcid.add(scenePoint);
        if (!this.acidAttack.isOn) {
          this.acidAttack.TurnOn();
        }
    }

  }

  public boolean IsEnraged() {
    if (this.plugin.zebakNpc == null) {
      return false;
    } else {
      double zebakHP = (double)this.plugin.zebakNpc.getHealthRatio() / (double)this.plugin.zebakNpc.getHealthScale() * 100.0;
      return zebakHP <= 25.0;
    }
  }

  private int GetZebakAttackSpeed() {
    int pathLvl = 3;
    switch (pathLvl) {
      case 3:
        int attackSpeed = this.IsEnraged() ? 7 : 9;
        return attackSpeed;
      default:
        throw new IllegalStateException("Unexpected value: " + pathLvl);
    }
  }

  private void CreateAcidSplatter(LocalPoint centerPoint) {
    Point centerScenePoint = this.plugin.utility.SceneFromLocal(centerPoint);
    int radius = this.plugin.config.UpsetStomach() ? 2 : 1;

    for(int x = -radius; x <= radius; ++x) {
      for(int y = -radius; y <= radius; ++y) {
        Point scenePoint = new Point(centerScenePoint.getX() + x, centerScenePoint.getY() + y);
        this.plugin.groundAttacks.add(new GroundAttack(scenePoint, 6, Color.YELLOW, true, false));
        this.acidAttack.floorAcid.add(scenePoint);
      }
    }

  }

  public void Reset() {
    System.out.println("Reset Zebak");
    this.acidAttack.Reset();
    this.isLowHP = false;
  }
}