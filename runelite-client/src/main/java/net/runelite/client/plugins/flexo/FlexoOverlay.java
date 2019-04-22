package net.runelite.client.plugins.flexo;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class FlexoOverlay extends Overlay {

    public static Rectangle clickArea;

    @Inject
    private Client client;

    @Inject
    private FlexoPlugin plugin;

    @Inject
    private FlexoConfig config;

    @Inject
    public FlexoOverlay(@Nullable Client client, FlexoPlugin plugin, FlexoConfig config) {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }


    @Override
    public Dimension render(Graphics2D graphics) {
        if (clickArea!=null)
            graphics.draw(clickArea);
        return null;
    }
}
