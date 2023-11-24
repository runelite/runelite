package net.runelite.client.plugins.raids3.zebak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import net.runelite.api.Point;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3Util.Utility;
import net.runelite.client.plugins.raids3.Raids3Plugin;

public class ZebakAcidAttack {
  public static final int MAX_TICKS = 30;
  public List<Point> rocks = new ArrayList();
  public List<Point> jars = new ArrayList();
  public List<Point> floorAcid = new ArrayList();
  public HashMap<Point, RockJarLink> rockJarLinks = new HashMap();
  public boolean isSolved = false;
  public Utility utility;
  public boolean isOn = false;
  public Raids3Plugin plugin;
  private final int BOULDER_PUSH_DISTANCE = 10;
  public int currentTick = 0;

  public ZebakAcidAttack(Raids3Plugin plugin, Utility utility) {
    this.plugin = plugin;
    this.utility = utility;
  }

  public void Solve() {
    if (!this.isSolved && this.rocks.size() != 0 && this.jars.size() != 0 && this.floorAcid.size() != 0) {
      Iterator var1 = this.jars.iterator();

      while(var1.hasNext()) {
        Point jarLocation = (Point)var1.next();
        RockJarLink rockJarLink = this.GetRockJarLink(this.rocks, jarLocation);
        if (rockJarLink != null) {
          this.rockJarLinks.put(jarLocation, rockJarLink);
        }
      }

      this.isSolved = true;
    }
  }

  private RockJarLink GetRockJarLink(List<Point> rocks, Point jarTile) {
    int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    for (int i = 0; i < dx.length; ++i) {
      for (int distance = 1; distance <= BOULDER_PUSH_DISTANCE; ++distance) {
        int newX = jarTile.getX() + dx[i] * distance;
        int newY = jarTile.getY() + dy[i] * distance;
        Point targetScenePoint = new Point(newX, newY);
        Point pushTile = new Point(jarTile.getX() - dx[i], jarTile.getY() - dy[i]);

        Optional<Point> rockCollisionTile = rocks.stream()
            .filter(rockTile -> rockTile.equals(targetScenePoint))
            .findAny();

        if (rockCollisionTile.isPresent()) {
          return new RockJarLink(rockCollisionTile.get(), jarTile, pushTile);
        }

        // Additional logic for Upset Stomach condition
        if (this.plugin.config.UpsetStomach() && dx[i] == -1) {
          for (Point rockTile : rocks) {
            for (int y = -1; y <= 1; ++y) {
              Point currentTile = new Point(targetScenePoint.getX(), targetScenePoint.getY() + y);
              if (rockTile.equals(currentTile)) {
                System.out.println("Border Collision");
                return new RockJarLink(rockTile, jarTile, pushTile);
              }
            }
          }
        }
      }
    }

    return null;
  }


  public void Reset() {
    this.currentTick = 0;
    this.isOn = false;
    this.isSolved = false;
    this.jars.clear();
    this.rocks.clear();
    this.floorAcid.clear();
    this.rockJarLinks.clear();
  }

  public void gameTick() {
    if (this.isOn) {
      ++this.currentTick;
      if (this.currentTick > 3 && !this.isSolved) {
        this.Solve();
      }

      if (this.currentTick > 30) {
        this.Reset();
      }

    }
  }

  public void TurnOn() {
    this.isOn = true;
  }
}
