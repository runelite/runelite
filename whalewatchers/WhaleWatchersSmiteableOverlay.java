package net.runelite.client.plugins.whalewatchers;

import net.runelite.api.*;
import net.runelite.client.ui.overlay.*;
import javax.inject.*;
import java.awt.*;
import net.runelite.client.ui.overlay.components.*;

public class WhaleWatchersSmiteableOverlay extends Overlay
{
    private Client client;
    private WhaleWatchersPlugin plugin;
    private PanelComponent panelComponent;
    
    @Inject
    public WhaleWatchersSmiteableOverlay(final WhaleWatchersPlugin plugin) {
        this.plugin = plugin;
        this.setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.setPriority(OverlayPriority.HIGH);
        this.setPosition(OverlayPosition.BOTTOM_RIGHT);
        this.panelComponent = new PanelComponent();
    }
    
    @Override
    public Dimension render(final Graphics2D graphics) {
        final String subText = "You could be smited in 1 tick";
        this.panelComponent.getChildren().clear();
        if (this.plugin.isDisplaySmiteOverlay()) {
            this.panelComponent.setBackgroundColor(Color.WHITE);
            this.panelComponent.getChildren().add(TitleComponent.builder().text("LOW PRAYER WARNING").color(Color.BLACK).build());
            this.panelComponent.getChildren().add(TitleComponent.builder().text(subText).color(Color.BLACK).build());
            this.panelComponent.setPreferredSize(new Dimension(graphics.getFontMetrics().stringWidth(subText) + 20, 0));
        }
        else {
            this.panelComponent.getChildren().clear();
        }
        return this.panelComponent.render(graphics);
    }
}
