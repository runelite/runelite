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
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

public class HydraIndicatorOverlay extends Overlay {
    private final HydraConfig config;
    private final HydraPlugin plugin;

    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private HydraIndicatorOverlay(HydraConfig config, HydraPlugin plugin) {
        this.config = config;
        this.plugin = plugin;
        setPosition(OverlayPosition.BOTTOM_RIGHT);
        setPriority(OverlayPriority.MED);
        panelComponent.setPreferredSize(new Dimension(14, 0));
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
                    panelComponent.getChildren().clear();
                    panelComponent.getChildren().add(LineComponent.builder().right(Integer.toString(val)).build());
                    return panelComponent.render(graphics);
                }
            }
        }
        return null;
    }
}
