package net.runelite.client.plugins.raids3.overlays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.TickOverlayDisplayType;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class NPCTickOverlay extends Overlay {
  private final Client client;
  private final Raids3Plugin plugin;
  private final Raids3Config config;
  Font font;

  @Inject
  NPCTickOverlay(Client client, Raids3Plugin plugin, Raids3Config config) {
    this.setPosition(OverlayPosition.DYNAMIC);
    this.setPriority(OverlayPriority.MED);
    this.setLayer(OverlayLayer.ABOVE_SCENE);
    this.font = new Font(FontManager.getRunescapeFont().getName(), 1, 25);
    this.client = client;
    this.plugin = plugin;
    this.config = config;
  }

  public Dimension render(Graphics2D graphics) {
    if (this.config.AttackTickOverlayType() != TickOverlayDisplayType.Off && this.plugin.currentNPC != null && !this.plugin.currentNPC.isDead() && this.plugin.prayerQue.prayerPriority != null) {
      if (this.plugin.prayerQue.currentTick > this.plugin.prayerQue.endTick) {
        return null;
      } else {
        graphics.setFont(this.font);
        this.DisplayTicks(graphics);
        return null;
      }
    } else {
      return null;
    }
  }

  private void DisplayTicks(Graphics2D graphics) {
    int attackSpeed = this.plugin.prayerQue.endTick;
    int currentTick = this.plugin.prayerQue.currentTick;
    Point localPoint = this.plugin.currentNPC.getCanvasTextLocation(graphics, "" + currentTick, this.client.getPlane());
    localPoint = new Point(localPoint.getX(), localPoint.getY() - this.client.getLocalPlayer().getConvexHull().getBounds().height);
    OverlayUtil.renderTextLocation(graphics, localPoint, "" + (attackSpeed - currentTick), Color.WHITE);
  }
}