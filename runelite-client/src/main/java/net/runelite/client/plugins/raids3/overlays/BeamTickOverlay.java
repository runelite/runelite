package net.runelite.client.plugins.raids3.overlays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.plugins.raids3.FontTypes;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.TOA_Rooms;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class BeamTickOverlay extends OverlayPanel {
  private final Client client;
  private final Raids3Plugin plugin;
  private final Raids3Config config;
  private final ClientUI clientUI;
  public Dimension DEFAULT_SIZE = new Dimension(25, 25);
  private static int TITLE_PADDING = 10;
  private static final int MINIMUM_SIZE = 16;

  @Inject
  BeamTickOverlay(Client client, Raids3Plugin plugin, Raids3Config config, ClientUI clientUI) {
    this.setPosition(OverlayPosition.BOTTOM_RIGHT);
    this.setPriority(OverlayPriority.MED);
    this.client = client;
    this.plugin = plugin;
    this.config = config;
    this.clientUI = clientUI;
  }

  public Dimension render(Graphics2D graphics) {
    if (this.config.BeamTickOverlay() && this.plugin.currentRoom == TOA_Rooms.MIRROR_ROOM) {
      if (this.plugin.mirrorRoomBeamCt < 0) {
        return null;
      } else {
        Dimension preferredSize = this.getPreferredSize();
        if (preferredSize == null) {
          preferredSize = this.DEFAULT_SIZE;
          this.setPreferredSize(preferredSize);
        }

        Color color;
        if (this.plugin.mirrorRoomBeamCt == 1) {
          color = this.config.BeamWarningColor();
        } else if (this.plugin.mirrorRoomBeamCt < 1) {
          color = this.config.BeamDamageColor();
        } else {
          color = this.config.BeamSafeColor();
        }

        graphics.setColor(color);
        graphics.fillRect(0, 0, preferredSize.width, preferredSize.height);
        TITLE_PADDING = Math.min(preferredSize.width, preferredSize.height) / 2 - 4;
        int beamTickCt = Math.max(this.plugin.mirrorRoomBeamCt, 0);
        if (this.config.ShowTick()) {
          if (this.config.DisableFontScaling()) {
            graphics.setColor(this.config.NumberColor());
            graphics.drawString(String.valueOf(beamTickCt), TITLE_PADDING, preferredSize.height - TITLE_PADDING);
          } else {
            if (this.config.FontType() == FontTypes.REGULAR) {
              graphics.setFont(new Font(FontManager.getRunescapeFont().getName(), 0, Math.min(preferredSize.width, preferredSize.height)));
            } else {
              graphics.setFont(new Font(this.config.FontType().toString(), 0, Math.min(preferredSize.width, Math.min(preferredSize.width, preferredSize.height))));
            }

            Point tickCounterPoint = new Point(preferredSize.width / 3, preferredSize.height);
            OverlayUtil.renderTextLocation(graphics, tickCounterPoint, String.valueOf(beamTickCt), this.config.NumberColor());
          }
        }

        return preferredSize;
      }
    } else {
      return null;
    }
  }
}