package net.runelite.client.plugins.safespot;

import javax.inject.*;
import net.runelite.client.ui.overlay.*;
import java.awt.*;
import net.runelite.api.*;

public class SafeSpotOverlay extends Overlay
{
    private final Client client;
    private final SafeSpotPlugin safeSpotPlugin;
    private final SafeSpotConfig config;

    @Inject
    public SafeSpotOverlay( Client client, SafeSpotPlugin safeSpotPlugin,  SafeSpotConfig config) {
        this.client = client;
        this.safeSpotPlugin = safeSpotPlugin;
        this.config = config;
        this.setPosition(OverlayPosition.DYNAMIC);
        this.setPriority(OverlayPriority.LOW);
        this.setLayer(OverlayLayer.ABOVE_SCENE);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (safeSpotPlugin.isSafeSpotsRenderable() && safeSpotPlugin.getSafeSpotList() != null && safeSpotPlugin.getSafeSpotList().size() > 0) {
            safeSpotPlugin.getSafeSpotList().forEach(tile -> {
                Polygon poly;
                if (tile != null && tile.getLocalLocation() != null) {
                    poly = Perspective.getCanvasTilePoly(client, tile.getLocalLocation());
                    if (poly != null) {
                        OverlayUtil.renderPolygon(graphics, poly, config.tileColor());
                    }
                }
                return;
            });
        }
        return null;
    }
}
