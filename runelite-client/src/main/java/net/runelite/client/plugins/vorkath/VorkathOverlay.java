package net.runelite.client.plugins.vorkath;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;

@Slf4j
public class VorkathOverlay extends Overlay
{
    private final Client client;
    private final VorkathPlugin plugin;

    private PanelComponent panelComponent = new PanelComponent();

    @Inject
    VorkathOverlay(Client client, VorkathPlugin plugin)
    {
        setPosition(OverlayPosition.TOP_LEFT);
        setPriority(OverlayPriority.HIGH);
        this.client = client;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();
        panelComponent.getChildren().add(TitleComponent.builder()
            .text("Attacks Until Spec:")
            .build());

        panelComponent.getChildren().add(TitleComponent.builder()
            .text(Integer.toString(plugin.vorkathAttackCounter))
            .build());

        panelComponent.getChildren().add(TitleComponent.builder()
            .text("Next Special:")
            .build());

        panelComponent.getChildren().add(TitleComponent.builder()
            .text(plugin.vorkathNextSpecial)
            .build());

        if (plugin.findVorkath() != null)
        {
            return panelComponent.render(graphics);
        }
        else
        {
            return null;
        }
    }
}