package net.runelite.client.plugins.toolbox;

import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import org.apache.commons.lang3.tuple.Pair;

import javax.inject.Inject;
import java.awt.*;

public class ToolBoxOverlay extends OverlayPanel {

    ToolBoxPlugin plugin;

    @Inject
    ToolBoxOverlay(ToolBoxPlugin plugin) {
        super(plugin);
        setPosition(OverlayPosition.DYNAMIC);
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        return super.render(graphics);
    }
}
