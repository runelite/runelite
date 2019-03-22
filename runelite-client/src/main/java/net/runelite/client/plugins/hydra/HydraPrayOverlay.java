package net.runelite.client.plugins.hydra;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class HydraPrayOverlay extends Overlay {
    private final HydraConfig config;
    private final HydraPlugin plugin;

    private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);

    private final SpriteManager spriteManager;
    private final PanelComponent imagePanelComponent = new PanelComponent();


    @Inject
    private Client client;

    @Inject
    private HydraPrayOverlay(HydraConfig config, HydraPlugin plugin, SpriteManager spriteManager) {
        this.config = config;
        this.plugin = plugin;
        setPosition(OverlayPosition.BOTTOM_RIGHT);
        setPriority(OverlayPriority.HIGH);
        this.spriteManager = spriteManager;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!config.PrayerHelper()) {
            return null;
        }

        if (plugin.Hydra != null) {
            if (plugin.hydras.containsKey(plugin.Hydra.getIndex())) {
                int val = plugin.hydras.get(plugin.Hydra.getIndex());
                if (val != 0) {
                    if (plugin.hydraattacks.containsKey(plugin.Hydra.getIndex())) {
                        int attack = plugin.hydraattacks.get(plugin.Hydra.getIndex());
                        if (attack == 8261) {
                            if (val == 3) {
                                final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);

                                imagePanelComponent.getChildren().clear();
                                imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
                                imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
                                        ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                                        : NOT_ACTIVATED_BACKGROUND_COLOR);

                                return imagePanelComponent.render(graphics);
                            } else {
                                final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);

                                imagePanelComponent.getChildren().clear();
                                imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
                                imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)
                                        ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                                        : NOT_ACTIVATED_BACKGROUND_COLOR);

                                return imagePanelComponent.render(graphics);
                            }
                        } else if (attack == 8262) {
                            if (val == 3) {
                                final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);

                                imagePanelComponent.getChildren().clear();
                                imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
                                imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)
                                        ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                                        : NOT_ACTIVATED_BACKGROUND_COLOR);

                                return imagePanelComponent.render(graphics);
                            } else {
                                final BufferedImage prayerImage = spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);

                                imagePanelComponent.getChildren().clear();
                                imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
                                imagePanelComponent.setBackgroundColor(client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)
                                        ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                                        : NOT_ACTIVATED_BACKGROUND_COLOR);

                                return imagePanelComponent.render(graphics);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
