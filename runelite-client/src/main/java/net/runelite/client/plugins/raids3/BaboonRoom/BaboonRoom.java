package net.runelite.client.plugins.raids3.BaboonRoom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Projectile;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.Timer;
import net.runelite.client.plugins.raids3Util.OneUpUtilityPlugin;

public class BaboonRoom {
  Client client;
  Raids3Plugin raids3Plugin;
  Timer lastAttackedBaboonTimer = new Timer(1300, 1500);
  public int redSkullGameTick = -1;
  int ventOrPillar = -1;
  final int VENT = 0;
  final int PILLAR = 1;
  private Timer prayerTimer = new Timer(150, 450);

  public BaboonRoom(Client client, Raids3Plugin raids3Plugin) {
    this.client = client;
    this.raids3Plugin = raids3Plugin;
  }

  public void HandleBaboonPrayers() {
    if (!this.raids3Plugin.config.BaboonAutoPray()) {
      this.raids3Plugin.currentProtectionPrayer = null;
    } else {
      List<Projectile> projectiles = new ArrayList<>();
      int baboonMagicProjectileID = 2247; // Corrected the IDs from 'true'
      int baboonRangeProjectileID = 2242;
      int baboonRangeProjectile2ID = 2243;
      Iterator<Projectile> var5 = this.client.getProjectiles().iterator();

      while (var5.hasNext()) {
        Projectile projectile = var5.next();
        if (projectile.getId() == baboonMagicProjectileID ||
            projectile.getId() == baboonRangeProjectileID ||
            projectile.getId() == baboonRangeProjectile2ID) {
          projectiles.add(projectile);
        }
      }

      if (!projectiles.isEmpty()) {
        this.lastAttackedBaboonTimer.Reset();
        projectiles.sort(Comparator.comparing(Projectile::getRemainingCycles));
        int projectileId = projectiles.get(0).getId();
        if (projectileId == baboonMagicProjectileID) {
          this.raids3Plugin.currentProtectionPrayer = Prayer.PROTECT_FROM_MAGIC;
        } else if (projectileId == baboonRangeProjectileID || projectileId == baboonRangeProjectile2ID) {
          this.raids3Plugin.currentProtectionPrayer = Prayer.PROTECT_FROM_MISSILES;
        }
      } else {
        for (NPC npc : this.client.getNpcs()) {
          if ((npc.getName().equalsIgnoreCase("Baboon Thrall") ||
              npc.getName().equalsIgnoreCase("Baboon Brawler")) &&
              OneUpUtilityPlugin.SceneDistance(npc, this.client.getLocalPlayer()) < 3.0D) {
            this.raids3Plugin.currentProtectionPrayer = Prayer.PROTECT_FROM_MELEE;
            return;
          }
        }

        if (this.lastAttackedBaboonTimer.isDone()) {
          this.raids3Plugin.currentProtectionPrayer = null;
        }
      }
    }
  }

  public void HandleBaboonRedSkull(Point point) {
    this.redSkullGameTick = 0;
    if (point.getX() != 56 && point.getX() != 72 || point.getY() != 44 && point.getY() != 52) {
      this.ventOrPillar = 1;
    } else {
      this.ventOrPillar = 0;
    }

  }

  public void onBeforeRender() {
    if (this.raids3Plugin.config.BaboonAutoPray()) {
      if (this.prayerTimer.isDone()) {
        this.prayerTimer.Reset();
        this.raids3Plugin.HandlePrayers();
      }

    }
  }

  public void onGameTick() {
    this.HandleBaboonPrayers();
    if (this.redSkullGameTick != -1) {
      ++this.redSkullGameTick;
    }

  }

  public void onChatMessage(String message) {
    if (message.contains("You repair the damaged roof support.")) {
      this.redSkullGameTick = -1;
    } else if (message.contains("issue with with roof support.")) {
      this.redSkullGameTick = 0;
    } else if (message.contains("sense some strange fumes")) {
      this.redSkullGameTick = 0;
    } else if (message.contains("neutralise the fumes")) {
      this.redSkullGameTick = -1;
    } else if (message.contains("fumes filling the room")) {
      this.redSkullGameTick = -1;
    } else if (message.contains("debris to fall on you")) {
      this.redSkullGameTick = -1;
    }

  }
}