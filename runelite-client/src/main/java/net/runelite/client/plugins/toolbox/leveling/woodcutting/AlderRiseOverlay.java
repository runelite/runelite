package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import org.apache.commons.lang3.tuple.Pair;

import javax.inject.Inject;
import java.awt.*;

public class AlderRiseOverlay extends OverlayPanel {

    AlderRisePlugin plugin;

    @Inject
    AlderRiseOverlay(AlderRisePlugin plugin) {
        super(plugin);
        setPosition(OverlayPosition.DYNAMIC);
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        return super.render(graphics);
    }
}