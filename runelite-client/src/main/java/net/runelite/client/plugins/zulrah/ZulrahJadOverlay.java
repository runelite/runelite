package net.runelite.client.plugins.zulrah;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class ZulrahJadOverlay extends Overlay {
    private final ZulrahConfig config;
    private final ZulrahPlugin plugin;
    private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);

    private final SpriteManager spriteManager;
    private final PanelComponent imagePanelComponent = new PanelComponent();

    @Inject
    private Client client;

    @Inject
    private ZulrahJadOverlay(ZulrahConfig config, ZulrahPlugin plugin, SpriteManager spriteManager) {
        this.config = config;
        this.plugin = plugin;
        this.spriteManager = spriteManager;
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPosition(OverlayPosition.BOTTOM_RIGHT);
        setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!config.ZulrahJadHelper()) {
            return null;
        }
        NPC Zulrah = plugin.Zulrah;
        if (Zulrah != null) {
            if (plugin.jadphase > 0) {
                if (plugin.jadphase == 1) {
                    if (plugin.jadflip) {
                        final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
                        imagePanelComponent.getChildren().clear();
                        imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
                        imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)
                                ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                                : NOT_ACTIVATED_BACKGROUND_COLOR);
                    } else {
                        final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
                        imagePanelComponent.getChildren().clear();
                        imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
                        imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
                                ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                                : NOT_ACTIVATED_BACKGROUND_COLOR);
                    }
                } else if (plugin.jadphase == 2) {
                    if (plugin.jadflip) {
                        final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
                        imagePanelComponent.getChildren().clear();
                        imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
                        imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
                                ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                                : NOT_ACTIVATED_BACKGROUND_COLOR);
                    } else {
                        final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
                        imagePanelComponent.getChildren().clear();
                        imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
                        imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)
                                ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                                : NOT_ACTIVATED_BACKGROUND_COLOR);
                    }
                }
                return imagePanelComponent.render(graphics);
            }
        }
        return null;
    }
}
