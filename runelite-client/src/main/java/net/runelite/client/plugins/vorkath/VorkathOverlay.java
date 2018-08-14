package net.runelite.client.plugins.vorkath;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;

public class VorkathOverlay extends Overlay {

    private final VorkathPlugin plugin;

    private final Client client;

    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private VorkathOverlay(VorkathPlugin plugin, Client client) {
        setPosition(OverlayPosition.TOP_LEFT);
        setPriority(OverlayPriority.HIGHEST);
        this.plugin = plugin;
        this.client = client;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (client.isInInstancedRegion()) {
            panelComponent.getChildren().clear();
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Attack Count")
                    .right(Integer.toString(plugin.getAttackCount()))
                    .build());
        }
        return panelComponent.render(graphics);
    }
}
