package net.runelite.client.plugins.vorkath;

import java.awt.*;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class VorkathIndicatorOverlay extends Overlay {
    private final VorkathConfig config;
    private final VorkathPlugin plugin;
    private final PanelComponent panelComponent = new PanelComponent();


    @Inject
    private Client client;

    @Inject
    private VorkathIndicatorOverlay(VorkathConfig config, VorkathPlugin plugin) {
        this.config = config;
        this.plugin = plugin;
        setPosition(OverlayPosition.BOTTOM_RIGHT);
        setPriority(OverlayPriority.MED);
        panelComponent.setPreferredSize(new Dimension(150, 0));
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!config.EnableVorkath()) {
            return null;
        }

        NPC Vorkath = plugin.Vorkath;
        if (Vorkath != null) {
            if (config.VorkathBox()) {
                panelComponent.getChildren().clear();
                if (plugin.venomticks != 0) {
                    if (plugin.venomticks + 5 <= plugin.ticks) {
                        panelComponent.getChildren().add(LineComponent.builder().left("Quickfire Barrage:").right(Integer.toString(30 - (plugin.ticks - plugin.venomticks))).rightColor(Color.ORANGE).build());
                    }
                }
                panelComponent.getChildren().add(LineComponent.builder().left("Special Attack:").right(Integer.toString(7 - plugin.hits)).rightColor(config.CounterColor()).build());
                return panelComponent.render(graphics);
            }
        }
        return null;
    }
}
