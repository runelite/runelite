package net.runelite.client.plugins.raids3.overlays;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.client.plugins.raids3.ImagePanelComponent;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.util.ImageUtil;

public class PrayerOverlay extends Overlay {
  private final Client client;
  private final Raids3Plugin plugin;
  private final Raids3Config config;
  private final ClientUI clientUI;
  private boolean soundHasPlayed = false;

  @Inject
  PrayerOverlay(Client client, Raids3Plugin plugin, Raids3Config config, ClientUI clientUI) {
    this.setPosition(OverlayPosition.BOTTOM_RIGHT);
    this.setPriority(OverlayPriority.MED);
    this.client = client;
    this.plugin = plugin;
    this.config = config;
    this.clientUI = clientUI;
  }

  public Dimension render(Graphics2D graphics) {
    if (this.config.PrayerOverlay() && this.plugin.currentProtectionPrayer != null) {
      BufferedImage prayerImage;
      if (this.plugin.currentProtectionPrayer == Prayer.PROTECT_FROM_MELEE) {
        prayerImage = ImageUtil.loadImageResource(Raids3Plugin.class, "ProtectMelee.png");
      } else if (this.plugin.currentProtectionPrayer == Prayer.PROTECT_FROM_MAGIC) {
        prayerImage = ImageUtil.loadImageResource(Raids3Plugin.class, "ProtectMagic.png");
      } else {
        prayerImage = ImageUtil.loadImageResource(Raids3Plugin.class, "ProtectRange.png");
      }

      ImagePanelComponent imagePanelComponent = new ImagePanelComponent(this.config, this.plugin);

      if (!this.client.isPrayerActive(this.plugin.currentProtectionPrayer)) {
        imagePanelComponent.setBackgroundColor(this.config.WrongColor());

        if (config.prayerSound()) {
          if (!soundHasPlayed) {
            SoundPlayer.playSound("/changePrayer.wav");
            soundHasPlayed = true;
          }
        }
      } else {
        imagePanelComponent.setBackgroundColor(this.config.CorrectColor());
        soundHasPlayed = false;
      }

      imagePanelComponent.setImage(prayerImage);
      return imagePanelComponent.render(graphics);
    } else {
      return null;
    }
  }
}