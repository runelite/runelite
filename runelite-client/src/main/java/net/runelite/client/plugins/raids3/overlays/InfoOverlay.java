package net.runelite.client.plugins.raids3.overlays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class InfoOverlay extends OverlayPanel {
  private final Raids3Config config;
  private final Raids3Plugin plugin;

  @Inject
  private InfoOverlay(Raids3Plugin plugin, Raids3Config config) {
    this.plugin = plugin;
    this.config = config;
  }

  public Dimension render(Graphics2D graphics) {
    this.panelComponent.setPreferredSize(new Dimension(300, 200));
    if (this.plugin.npcManagerOn) {
      this.panelComponent.getChildren().add(TitleComponent.builder().text("1Up Plugins").color(Color.ORANGE).build());
      this.panelComponent.getChildren().add(TitleComponent.builder().text("1Up Raids3").color(Color.CYAN).build());
      this.panelComponent.getChildren().add(TitleComponent.builder().text("Attention: Your client is expired!").color(Color.RED).build());
      this.panelComponent.getChildren().add(TitleComponent.builder().text("Please download the latest version").color(Color.RED).build());
    }

    return super.render(graphics);
  }
}