package net.runelite.client.plugins.vorkath;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;

public class VorkathOverlay extends Overlay {

    private final VorkathPlugin plugin;

    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private VorkathOverlay(VorkathPlugin plugin)
    {
        setPosition(OverlayPosition.TOP_LEFT);
        setPriority(OverlayPriority.HIGHEST);
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        panelComponent.getChildren().clear();
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Attack Count")
                .right(Integer.toString(plugin.getAttackCount()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Animation ID")
                .right(Integer.toString(plugin.getAnimationID()))
                .build());
        return panelComponent.render(graphics);
    }
}
