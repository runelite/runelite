package net.runelite.client.plugins.raids3.overlays;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.raids3.FloorPuzzle;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.Akkha.UnstableOrbTile;
import net.runelite.client.plugins.raids3.AttackContainers.GroundAttack;
import net.runelite.client.plugins.raids3.zebak.RockJarLink;
import net.runelite.client.plugins.raids3.zebak.ZebakAcidAttack;
import net.runelite.client.plugins.raids3Util.OverlayUtility;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer;

public class Raids3Overlay extends Overlay {
  private final Client client;
  private final Raids3Config config;
  private final Raids3Plugin plugin;
  private final ModelOutlineRenderer modelOutlineRenderer;
  private static final Color GREEN = new Color(0, 200, 33);
  private static final Color BLUE = new Color(0, 170, 200);
  private static final Color RED = new Color(200, 0, 47);
  private static final Color ALL = new Color(133, 0, 200);
  private static final Color BLUEGREEN = new Color(0, 200, 140);
  private static final Color ALPHA_RED = new Color(255, 4, 61, 191);
  private static final Color ALPHA_ORANGE = new Color(244, 124, 4, 191);
  private static final Color INTERACTING_COLOR;
  private static final int INTERACTING_SHIFT = -16;
  private static final Polygon ARROW_HEAD;

  public String getName() {
    return "Raids3Overlay";
  }

  @Inject
  private Raids3Overlay(Client client, Raids3Config config, Raids3Plugin plugin, ModelOutlineRenderer modelOutlineRenderer) {
    this.client = client;
    this.config = config;
    this.plugin = plugin;
    this.modelOutlineRenderer = modelOutlineRenderer;
    this.setPosition(OverlayPosition.DYNAMIC);
    this.setLayer(OverlayLayer.ABOVE_SCENE);
    this.setPriority(OverlayPriority.MED);
  }

  public Dimension render(Graphics2D graphics) {
    switch(this.plugin.currentRoom) {
      case BABOON_ROOM:
        this.HandleBaboonRoom(graphics);
        break;
      case BABA_ROOM:
        this.HandleBabaBoss(graphics);
        break;
      case AKKHA_ROOM:
        this.HandleAkkaBoss(graphics);
        break;
      case ZEBAK_ROOM:
        this.HandleZebak(graphics);
        break;
      case WARDEN_ROOM:
        this.WardenOverlays(graphics);
    }

    Iterator var2 = this.plugin.groundAttacks.iterator();

    while(var2.hasNext()) {
      GroundAttack groundAttack = (GroundAttack)var2.next();
      Color tileColor = new Color(groundAttack.color.getRed(), groundAttack.color.getGreen(), groundAttack.color.getBlue(), this.config.OverlayAlpha());
      tileColor = OverlayUtility.setBrightness(tileColor, (float)this.config.OverlayBrightness());
      LocalPoint playerPoint = this.client.getLocalPlayer().getLocalLocation();
      LocalPoint localPoint = LocalPoint.fromScene(groundAttack.sceneLocation.getX(), groundAttack.sceneLocation.getY());
      LocalPoint destinationPoint = this.client.getLocalDestinationLocation();
      if (playerPoint.equals(localPoint) || destinationPoint != null && destinationPoint.equals(localPoint)) {
        tileColor = new Color(tileColor.getRed(), tileColor.getGreen(), tileColor.getBlue(), 255);
      }

      if (groundAttack.isHighlighting) {
        this.renderTile(graphics, localPoint, this.config.BorderColor(), 1.0D, tileColor);
      }

      if (this.config.ProjectileTicks()) {
        this.LabelTile(graphics, localPoint, "" + (groundAttack.attackSpeed - groundAttack.currentTick - 1));
      }
    }

    return null;
  }

  private void WardenOverlays(Graphics2D graphics) {
    try {
      if (this.config.HighlightWeakness() && this.plugin.wardenRoom.elidinisWardenNPC != null && this.plugin.wardenRoom.elidinisWardenNPC.getConvexHull() != null) {
        Color color;
        switch(this.plugin.wardenRoom.elidinisWardenNPC.getId()) {
          case 11753:
            color = this.config.MagicWeaknessColor();
            break;
          case 11754:
            color = this.config.RangeWeaknessColor();
            break;
          case 11755:
            color = this.config.MeleeWeaknessColor();
            break;
          default:
            return;
        }

        OverlayUtil.renderPolygon(graphics, this.plugin.wardenRoom.elidinisWardenNPC.getConvexHull(), color);
      }
    } catch (Exception var3) {
      System.out.println("[HandleAkkaBoss] Error: " + var3.getMessage());
    }

  }

  private void DrawArrow(Graphics2D graphics, Point startPoint, Point endPoint) {
    Point fs = Perspective.localToCanvas(this.client, LocalPoint.fromScene(startPoint.getX(), startPoint.getY()), this.client.getPlane(), this.client.getLocalPlayer().getLogicalHeight() / 2);
    int fsx = fs.getX();
    int fsy = fs.getY() - -16;
    Point ts = Perspective.localToCanvas(this.client, LocalPoint.fromScene(endPoint.getX(), endPoint.getY()), this.client.getPlane(), this.client.getLocalPlayer().getLogicalHeight() / 2);
    if (ts != null) {
      int tsx = ts.getX();
      int tsy = ts.getY() - -16;
      graphics.setColor(INTERACTING_COLOR);
      graphics.drawLine(fsx, fsy, tsx, tsy);
      AffineTransform t = new AffineTransform();
      t.translate((double)tsx, (double)tsy);
      t.rotate((double)(tsx - fsx), (double)(tsy - fsy));
      t.rotate(-1.5707963267948966D);
      AffineTransform ot = graphics.getTransform();
      graphics.setTransform(t);
      graphics.fill(ARROW_HEAD);
      graphics.setTransform(ot);
    }
  }

  private void HandleZebak(Graphics2D graphics) {
    ZebakAcidAttack acidAttack = this.plugin.zebakRoom.acidAttack;
    if (acidAttack.isOn && acidAttack.isSolved) {
      Iterator var3 = acidAttack.rockJarLinks.entrySet().iterator();

      while(var3.hasNext()) {
        Entry<Point, RockJarLink> entry = (Entry)var3.next();
        Point startPoint = entry.getKey();
        RockJarLink rockJarLink = entry.getValue();
        Color color = OverlayUtility.CreateColor(Color.GREEN, this.config.OverlayBrightness(), this.config.OverlayAlpha());
        this.renderSceneTile(graphics, rockJarLink.pushTile, this.config.BorderColor(), 1.0D, color);
        this.DrawArrow(graphics, startPoint, rockJarLink.rockTile);
      }
    }

  }

  public void HighlightUnstableOrbPaths(Graphics2D graphics) {
    if (this.plugin.akkhaRoom.orbGameTickMap.size() != 0) {
      List<NPC> npcs = this.client.getNpcs();
      List<NPC> shadowNPCs = new ArrayList<>();
      if (npcs != null) {
        for (NPC npc : npcs) {
          if (!npc.isDead() && npc.getName().toLowerCase().contains("akkha's shadow")) {
            shadowNPCs.add(npc);
          }
        }
      }

      Iterator<UnstableOrbTile> var4 = this.plugin.akkhaRoom.orbGameTickMap.values().iterator();
      while (var4.hasNext()) {
        UnstableOrbTile unstableOrbTile = var4.next();
        WorldPoint tileWorldPoint = WorldPoint.fromScene(this.client, unstableOrbTile.tileLocation.getX(), unstableOrbTile.tileLocation.getY(), this.client.getPlane());

        if (this.plugin.akkhaNpc != null && this.plugin.akkhaNpc.getWorldArea().contains(tileWorldPoint)) {
          continue;
        }

        final WorldPoint finalTileWorldPoint = tileWorldPoint;
        if (shadowNPCs != null && shadowNPCs.stream().anyMatch(s -> s.getWorldArea().contains(finalTileWorldPoint))) {
          continue;
        }

        Color color = null;
        if (unstableOrbTile.gameTick >= 7 && this.config.HighlightLowDangerTile()) {
          color = this.config.UnstableOrbFar();
        } else if (unstableOrbTile.gameTick >= 3 && unstableOrbTile.gameTick < 7 && this.config.HighlightMidDangerTile()) {
          color = this.config.UnstableOrbMedium();
        } else if (unstableOrbTile.gameTick < 3 && this.config.HighlightMaxDangerTile()) {
          color = this.config.UnstableOrbClose();
        }

        if (color != null) {
          color = OverlayUtility.setBrightness(color, (float) this.config.OverlayBrightness());
          this.HighlightAndLabelTile(graphics, unstableOrbTile.tileLocation, color, Color.WHITE, "" + unstableOrbTile.gameTick);
        }
      }
    }
  }



  private void HighlightAndLabelTile(Graphics2D graphics, WorldPoint dest, Color polyColor, Color textColor, String label) {
    if (dest != null) {
      LocalPoint localPoint = LocalPoint.fromScene(dest.getX(), dest.getY());
      if (localPoint != null) {
        Polygon poly = Perspective.getCanvasTilePoly(this.client, localPoint);
        if (poly != null) {
          Point canvasTextLocation = Perspective.getCanvasTextLocation(this.client, graphics, new LocalPoint(localPoint.getX(), localPoint.getY()), label, dest.getPlane());
          if (this.config.ShowUnstableOrbDistance()) {
            OverlayUtil.renderTextLocation(graphics, canvasTextLocation, label, textColor);
          }

          int alpha = localPoint.equals(this.client.getLocalPlayer().getLocalLocation()) ? 225 : this.config.OverlayAlpha();
          polyColor = new Color(polyColor.getRed(), polyColor.getGreen(), polyColor.getBlue(), alpha);
          OverlayUtil.renderPolygon(graphics, poly, Color.BLACK, polyColor, new BasicStroke(1.0F));
        }

      }
    }
  }

  private void HandleBabaBoss(Graphics2D graphics) {
    if (this.config.HighlightBoulder() && this.plugin.babaRoom.rollingBoulders.size() > 0) {
      this.plugin.babaRoom.rollingBoulders.removeIf((s) -> {
        return s.isDead();
      });
      Iterator var2 = this.plugin.babaRoom.rollingBoulders.iterator();

      while(var2.hasNext()) {
        NPC boulder = (NPC)var2.next();
        OverlayUtil.renderActorOverlay(graphics, boulder, "", this.config.BoulderColor());
      }
    }

    if (this.config.MindTheGap() && this.plugin.babaNPC != null && this.plugin.teleportCrystalObject != null) {
      double bossHP = (double)this.plugin.babaNPC.getHealthRatio() / (double)this.plugin.babaNPC.getHealthScale() * 100.0D;
      Color color;
      if (this.plugin.babaRoom.boulderAttackCt == 1 && bossHP <= 36.0D || this.plugin.babaRoom.boulderAttackCt == 0 && bossHP <= 68.0D) {
        color = this.config.MindTheGapWarning2Color();
      } else {
        if ((this.plugin.babaRoom.boulderAttackCt != 1 || bossHP > 43.0D) && (this.plugin.babaRoom.boulderAttackCt != 0 || bossHP > 76.0D)) {
          return;
        }

        color = this.config.MindTheGapWarning1Color();
      }

      color = new Color(color.getRed(), color.getGreen(), color.getBlue(), this.config.OverlayAlpha());
      color = OverlayUtility.setBrightness(color, (float)this.config.OverlayBrightness());

      for(int i = 0; i < 4; ++i) {
        for(int x = 0; x < 21; ++x) {
          this.renderSceneTile(graphics, new WorldPoint(this.plugin.teleportCrystalObject.getLocalLocation().getSceneX() + 4 + x, this.plugin.teleportCrystalObject.getLocalLocation().getSceneY() + 1 - i, 0), color, 1.0D, color);
        }
      }
    }

  }

  private void LabelTile(Graphics2D graphics, LocalPoint localPoint, String text) {
    Point canvasTextLocation = Perspective.getCanvasTextLocation(this.client, graphics, localPoint, text, this.client.getPlane());
    Font savedFont = graphics.getFont();
    Font tickFont = new Font(this.config.TickFontType().getName(), 0, this.config.TickFontSize());
    graphics.setFont(tickFont);
    OverlayUtil.renderTextLocation(graphics, canvasTextLocation, text, Color.white);
    graphics.setFont(savedFont);
  }

  private void HandleBaboonRoom(Graphics2D graphics) {
    try {
      if (this.config.ShowWeakness()) {
        Iterator var2 = this.client.getNpcs().iterator();

        while(var2.hasNext()) {
          NPC npc = (NPC)var2.next();
          if (npc != null && !npc.isDead()) {
            if (npc.getName().equalsIgnoreCase("Baboon Brawler")) {
              OverlayUtil.renderActorOverlay(graphics, npc, "Magic", BLUE);
            } else if (npc.getName().equalsIgnoreCase("Baboon Thrower")) {
              OverlayUtil.renderActorOverlay(graphics, npc, "Melee", RED);
            } else if (npc.getName().equalsIgnoreCase("Baboon Mage")) {
              OverlayUtil.renderActorOverlay(graphics, npc, "Ranged", GREEN);
            } else if (npc.getName().equalsIgnoreCase("Baboon Shaman")) {
              OverlayUtil.renderActorOverlay(graphics, npc, "Ranged", GREEN);
            } else if (npc.getName().equalsIgnoreCase("Baboon Thrall")) {
              OverlayUtil.renderActorOverlay(graphics, npc, "ALL", ALL);
            } else if (npc.getName().equalsIgnoreCase("Volatile Baboon")) {
              OverlayUtil.renderActorOverlay(graphics, npc, "Magic/Ranged", BLUEGREEN);
            } else if (npc.getName().equalsIgnoreCase("Cursed Baboon")) {
              OverlayUtil.renderActorOverlay(graphics, npc, "Magic/Ranged", BLUEGREEN);
            }
          }
        }
      }
    } catch (Exception var4) {
    }

  }

  private void HandleAkkaBoss(Graphics2D graphics) {
    if (this.config.ShowUnstableOrbPaths()) {
      this.HighlightUnstableOrbPaths(graphics);
    }

    try {
      if (this.config.HighlightWeakness() && this.plugin.akkhaNpc != null && this.plugin.akkhaNpc.getConvexHull() != null && this.plugin.currentProtectionPrayer != null) {
        Color color = Color.MAGENTA;
        switch(this.plugin.currentProtectionPrayer) {
          case PROTECT_FROM_MELEE:
            color = this.config.MagicWeaknessColor();
            break;
          case PROTECT_FROM_MAGIC:
            color = this.config.RangeWeaknessColor();
            break;
          case PROTECT_FROM_MISSILES:
            color = this.config.MeleeWeaknessColor();
        }

        OverlayUtil.renderPolygon(graphics, this.plugin.akkhaNpc.getConvexHull(), color);
      }
    } catch (Exception var3) {
      System.out.println("[HandleAkkaBoss] Error: " + var3.getMessage());
    }

    if (this.config.MemoryBlast()) {
      this.HandleAkkhaMemoryAttack(graphics);
    }

  }

  private void HandleAkkhaMemoryAttack(Graphics2D graphics) {
    if (this.plugin.akkhaRoom.akkhaMemoryTilesIndex >= this.plugin.akkhaRoom.akkhaFloorPuzzle.size()) {
      this.plugin.akkhaRoom.isMemoryAttackStarting = false;
      this.plugin.akkhaRoom.akkhaMemoryTilesIndex = 0;
      this.plugin.akkhaRoom.gameTickCt = 0;
      this.plugin.akkhaRoom.akkhaFloorPuzzle.clear();
    }

    if (this.plugin.akkhaRoom.akkhaFloorPuzzle.size() > 0) {
      for(int index = this.plugin.akkhaRoom.akkhaMemoryTilesIndex; index < this.plugin.akkhaRoom.akkhaFloorPuzzle.size(); ++index) {
        boolean isSpotTaken = false;

        for(int i = this.plugin.akkhaRoom.akkhaMemoryTilesIndex; i < index; ++i) {
          if (((FloorPuzzle)this.plugin.akkhaRoom.akkhaFloorPuzzle.get(index)).walkTileLocation.equals(((FloorPuzzle)this.plugin.akkhaRoom.akkhaFloorPuzzle.get(i)).walkTileLocation)) {
            isSpotTaken = true;
            break;
          }
        }

        if (!isSpotTaken) {
          this.HighlightMemoryTileArea(graphics, index);
        }
      }
    }

  }

  private void HighlightMemoryTileArea(Graphics2D graphics, int index) {
    Color color = this.plugin.akkhaRoom.akkhaMemoryTilesIndex == index ? this.config.TileColor() : this.config.NextTileColor();
    OverlayUtil.renderTileOverlay(graphics, ((FloorPuzzle)this.plugin.akkhaRoom.akkhaFloorPuzzle.get(index)).tileObject, "" + (index - this.plugin.akkhaRoom.akkhaMemoryTilesIndex), color);
    color = new Color(color.getRed(), color.getGreen(), color.getBlue(), this.config.OverlayAlpha());
    color = OverlayUtility.setBrightness(color, (float)this.config.OverlayBrightness());
    Iterator var4 = ((FloorPuzzle)this.plugin.akkhaRoom.akkhaFloorPuzzle.get(index)).tileLocations.iterator();

    while(var4.hasNext()) {
      WorldPoint tileLocation = (WorldPoint)var4.next();
      this.renderSceneTile(graphics, tileLocation, Color.BLACK, 1.0D, color);
    }

  }

  private boolean isOnPreExplodingOrb(WorldPoint worldPoint) {
    if (this.plugin.explodingOrbGroundAttacks.size() == 0) {
      return false;
    } else {
      LocalPoint localPoint = LocalPoint.fromWorld(this.client, worldPoint);
      if (localPoint == null) {
        return false;
      } else {
        Iterator var3 = this.plugin.explodingOrbGroundAttacks.iterator();

        GroundAttack groundAttack;
        do {
          if (!var3.hasNext()) {
            return false;
          }

          groundAttack = (GroundAttack)var3.next();
        } while(groundAttack.sceneLocation.getX() != localPoint.getSceneX() || groundAttack.sceneLocation.getY() != localPoint.getSceneY());

        return true;
      }
    }
  }

  private void renderTile(Graphics2D graphics, LocalPoint dest, Color color, double borderWidth, Color fillColor) {
    if (dest != null) {
      Polygon poly = Perspective.getCanvasTilePoly(this.client, dest);
      if (poly != null) {
        OverlayUtil.renderPolygon(graphics, poly, color, fillColor, new BasicStroke((float)borderWidth));
      }
    }
  }

  private void renderSceneTile(Graphics2D graphics, WorldPoint dest, Color color, double borderWidth, Color fillColor) {
    if (dest != null) {
      LocalPoint playerPosLocal = LocalPoint.fromScene(dest.getX(), dest.getY());
      if (playerPosLocal != null) {
        Polygon poly = Perspective.getCanvasTilePoly(this.client, playerPosLocal);
        if (poly != null) {
          OverlayUtil.renderPolygon(graphics, poly, Color.BLACK, fillColor, new BasicStroke((float)borderWidth));
        }
      }
    }
  }

  private void renderSceneTile(Graphics2D graphics, Point dest, Color color, double borderWidth, Color fillColor) {
    if (dest != null) {
      LocalPoint playerPosLocal = LocalPoint.fromScene(dest.getX(), dest.getY());
      if (playerPosLocal != null) {
        Polygon poly = Perspective.getCanvasTilePoly(this.client, playerPosLocal);
        if (poly != null) {
          OverlayUtil.renderPolygon(graphics, poly, Color.BLACK, fillColor, new BasicStroke((float)borderWidth));
        }
      }
    }
  }

  static {
    INTERACTING_COLOR = Color.CYAN;
    ARROW_HEAD = new Polygon(new int[]{0, -3, 3}, new int[]{0, -5, -5}, 3);
  }
}