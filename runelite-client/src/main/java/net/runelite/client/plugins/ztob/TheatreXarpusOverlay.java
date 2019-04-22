package net.runelite.client.plugins.ztob;

import com.google.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import java.awt.*;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

public class TheatreXarpusOverlay extends Overlay {
    private final TheatrePlugin plugin;
    private final TheatreConfig config;
    PanelComponent panelComponent = new PanelComponent();

    @Inject
    private TheatreXarpusOverlay(TheatrePlugin plugin, TheatreConfig config) {
        super(plugin);
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        setPosition(OverlayPosition.DYNAMIC);
        setPosition(OverlayPosition.DETACHED);
        this.plugin = plugin;
        this.config = config;
        getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Theatre xarpus overlay"));

    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (plugin.isRunXarpus()) {
            if (config.XarpusExhumeOverlay()) {
                if (plugin.getXarpus_NPC().getId() == 8339) {
                    panelComponent.getChildren().clear();
                    String overlayTitle = "Exhume Counter";


                    // Build overlay title
                    panelComponent.getChildren().add(TitleComponent.builder()
                            .text(overlayTitle)
                            .color(Color.GREEN)
                            .build());

                    //Set the size of overlay
                    panelComponent.setPreferredSize(new Dimension(
                            graphics.getFontMetrics().stringWidth(overlayTitle) + 30, 0
                    ));

                    panelComponent.getChildren().add(LineComponent.builder()
                            .left("Exhumes: ")
                            .right(String.valueOf(plugin.getExhumecount()))
                            .build());
                }
            }
            return panelComponent.render(graphics);
        }

        return null;

    }


}

