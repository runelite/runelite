package net.runelite.client.plugins.fishingbuddy;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

public class FishingBuddyOverlay extends Overlay
{
    private final FishingBuddyPlugin plugin;
    private final FishingBuddyConfig config;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    public FishingBuddyOverlay(FishingBuddyPlugin plugin, FishingBuddyConfig config)
    {
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.TOP_LEFT);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!config.showOverlay())
        {
            return null;
        }

        panelComponent.getChildren().clear();

        panelComponent.getChildren().add(TitleComponent.builder()
                .text("FishingBuddy")
                .color(Color.CYAN)
                .build());

        String status = plugin.isActive() ? "Active" : "Inactive";
        Color statusColor = plugin.isActive() ? Color.GREEN : Color.RED;
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Status:")
                .right(status)
                .rightColor(statusColor)
                .build());

        panelComponent.getChildren().add(LineComponent.builder()
                .left("Switches:")
                .right(plugin.getSpotSwitchCount() + " / " + config.spotSwitchLimit())
                .rightColor(Color.WHITE)
                .build());

        if (plugin.isFlyingFishDetected())
        {
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Flying fish!")
                    .right("Switching!")
                    .rightColor(Color.RED)
                    .build());
        }

        return panelComponent.render(graphics);
    }
}