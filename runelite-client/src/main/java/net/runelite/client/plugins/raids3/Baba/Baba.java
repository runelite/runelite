package net.runelite.client.plugins.raids3.Baba;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.AttackContainers.GroundAttack;
import net.runelite.client.plugins.raids3Util.Utility;

public class Baba {
  Client client;
  Raids3Plugin plugin;
  Raids3Config config;
  Utility utility;
  public int shockWaveTick = 0;
  public List<GraphicsObject> possibleShockWaveTiles = new ArrayList();
  public List<NPC> rollingBoulders = new ArrayList();
  public int boulderAttackCt = 0;

  public Baba(Client client, Utility utility, Raids3Plugin plugin, Raids3Config raids3Config) {
    this.client = client;
    this.plugin = plugin;
    this.utility = utility;
    this.config = raids3Config;
  }

  public void onGraphicsObjectCreated(GraphicsObjectCreated event) {
    int shockWaveID = this.config.ShakingThingsUp() ? 1448 : 1447;
    if (this.config.HighlightShockwave() && event.getGraphicsObject().getId() == shockWaveID) {
      int attackSpeed = this.config.ShakingThingsUp() ? 6 : 5;
      this.AddBabaGroundAttacks(event.getGraphicsObject().getLocation(), attackSpeed);
    } else if (event.getGraphicsObject().getId() == 2111) {
      this.possibleShockWaveTiles.add(event.getGraphicsObject());
    }

  }

  public void onGameTick() {
    if (this.possibleShockWaveTiles.size() > 0) {
      if (this.shockWaveTick >= 1) {
        this.plugin.DebugLog("ShockWave Objects Size: " + this.possibleShockWaveTiles.size());
        if (this.possibleShockWaveTiles.size() >= 9) {
          this.possibleShockWaveTiles.sort(Comparator.comparingInt((s) -> {
            return s.getLocation().getSceneX();
          }));
          int x = ((GraphicsObject)this.possibleShockWaveTiles.get(4)).getLocation().getX();
          this.possibleShockWaveTiles.sort(Comparator.comparingInt((s) -> {
            return s.getLocation().getSceneY();
          }));
          int y = ((GraphicsObject)this.possibleShockWaveTiles.get(4)).getLocation().getY();
          this.plugin.DebugLog("(" + x + "," + y + ")");
          this.AddBabaGroundAttacks(new LocalPoint(x, y), 3);
        }

        this.possibleShockWaveTiles.clear();
        this.shockWaveTick = 0;
      }

      ++this.shockWaveTick;
    }

  }

  private void AddBabaGroundAttacks(LocalPoint centerLocation, int attackSpeed) {
    this.plugin.DebugLog("Creating Baba Ground Attacks");
    int squareRadius = 1;
    int extraTileRadius = 2;
    Color color = this.config.ShadowTileColor();
    if (this.config.ShakingThingsUp()) {
      squareRadius = 2;
      extraTileRadius = 3;
    }

    for(int x = -squareRadius; x <= squareRadius; ++x) {
      for(int y = -squareRadius; y <= squareRadius; ++y) {
        Point sceneLocation = new Point(centerLocation.getSceneX() + x, centerLocation.getSceneY() + y);
        this.plugin.groundAttacks.add(new GroundAttack(sceneLocation, attackSpeed, color, true, false));
      }
    }

    this.plugin.groundAttacks.add(new GroundAttack(new Point(centerLocation.getSceneX() - extraTileRadius, centerLocation.getSceneY()), attackSpeed, color, true, false));
    this.plugin.groundAttacks.add(new GroundAttack(new Point(centerLocation.getSceneX() + extraTileRadius, centerLocation.getSceneY()), attackSpeed, color, true, false));
    this.plugin.groundAttacks.add(new GroundAttack(new Point(centerLocation.getSceneX(), centerLocation.getSceneY() + extraTileRadius), attackSpeed, color, true, false));
    this.plugin.groundAttacks.add(new GroundAttack(new Point(centerLocation.getSceneX(), centerLocation.getSceneY() - extraTileRadius), attackSpeed, color, true, false));
  }

  public void Reset() {
    this.boulderAttackCt = 0;
  }
}