package net.runelite.client.plugins.raids3.Warden;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Iterator;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.TOA_Rooms;
import net.runelite.client.plugins.raids3Util.OverlayUtility;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer;

public class WardenRoomOverlay extends Overlay {
  private final Raids3Config config;
  private final Raids3Plugin plugin;
  private final ModelOutlineRenderer modelOutlineRenderer;
  private final Client client;
  private static final Color GREEN = new Color(0, 200, 33);
  private final int danger_windmill = 2234;
  private final int safe_windmill = 2236;
  private final int unstable_bolt_shadow = 1446;
  private final int lightning_skull_explosion = 2198;

  @Inject
  private WardenRoomOverlay(Client client, Raids3Plugin plugin, Raids3Config config, ModelOutlineRenderer modelOutlineRenderer) {
    this.plugin = plugin;
    this.config = config;
    this.client = client;
    this.modelOutlineRenderer = modelOutlineRenderer;
    this.setPosition(OverlayPosition.DYNAMIC);
    this.setLayer(OverlayLayer.ABOVE_SCENE);
    this.setPriority(OverlayPriority.HIGH);
  }

  public Dimension render(Graphics2D graphics) {
    if (this.plugin.currentRoom != TOA_Rooms.WARDEN_ROOM) {
      return null;
    } else {
      this.HandleWardenBoss(graphics);
      return null;
    }
  }

  private void HandleWardenBoss(Graphics2D graphics) {
    if (this.config.HighlightWardenSlamTiles()) {
      this.HandleWardenSlamAttack(graphics);
    }

    Iterator var2 = this.client.getGraphicsObjects().iterator();

    while(var2.hasNext()) {
      GraphicsObject graphicsObject = (GraphicsObject)var2.next();
      if (this.config.HighlightWardenWindmillBeam()) {
        this.HandleWindmillBeam(graphics, graphicsObject);
      }
    }

    if (this.plugin.wardenRoom.ufoObjects.size() > 0) {
      var2 = this.plugin.wardenRoom.ufoObjects.iterator();

      while(var2.hasNext()) {
        GameObject ufoObject = (GameObject)var2.next();
        OverlayUtil.renderTileOverlay(graphics, ufoObject, "UFO", GREEN);
      }
    }

  }

  private void HandleWindmillBeam(Graphics2D graphics, GraphicsObject graphicsObject) {
    Color color;
    if (graphicsObject.getId() == 2234) {
      color = this.config.WardenWindmillDanger();
      color = new Color(color.getRed(), color.getGreen(), color.getBlue(), this.config.OverlayAlpha());
      color = OverlayUtility.setBrightness(color, (float)this.config.OverlayBrightness());
      this.renderTile(graphics, graphicsObject.getLocation(), Color.black, 1.0D, color);
    } else if (graphicsObject.getId() == 2236) {
      color = this.config.WardenWindmillSafe();
      color = new Color(color.getRed(), color.getGreen(), color.getBlue(), this.config.OverlayAlpha());
      color = OverlayUtility.setBrightness(color, (float)this.config.OverlayBrightness());
      this.renderTile(graphics, graphicsObject.getLocation(), Color.black, 1.0D, color);
    }

  }

  private void HandleWardenSlamAttack(Graphics2D graphics) {
    if (this.plugin.wardenRoom.phase == WardenPhase.phase3) {
      if (this.plugin.wardenRoom.phase3Center != null) {
        if (!this.plugin.wardenRoom.isSiphonPhaseOn) {
          if (!this.plugin.wardenRoom.isUnstableBoltsActive) {
            for(int yOffset = 0; yOffset < 9; ++yOffset) {
              for(int offset = -1; offset <= 1; ++offset) {
                LocalPoint localLocation = LocalPoint.fromScene(this.plugin.wardenRoom.phase3Center.getX() + offset, this.plugin.wardenRoom.phase3Center.getY() + yOffset);
                Color color = this.config.WardenWindmillDanger();
                if (offset == this.plugin.wardenRoom.columnOrder[this.plugin.wardenRoom.slamSafeTileIndex]) {
                  color = this.config.WardenSlamSafeColor();
                }

                int alpha = this.config.WardenSlamAlpha();
                if (this.client.getLocalPlayer().getLocalLocation().getSceneX() == this.plugin.wardenRoom.phase3Center.getX() + offset) {
                  alpha = (int)((double)alpha * 1.75D);
                }

                color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
                color = OverlayUtility.setBrightness(color, (float)this.config.OverlayBrightness());
                this.renderTile(graphics, localLocation, Color.BLACK, 1.0D, color);
              }
            }

          }
        }
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
}