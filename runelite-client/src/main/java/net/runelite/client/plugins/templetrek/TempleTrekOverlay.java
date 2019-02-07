package net.runelite.client.plugins.templetrek;

import net.runelite.api.Client;
import net.runelite.api.GroundObject;
import net.runelite.client.ui.overlay.*;

import javax.inject.Inject;
import java.awt.*;

public class TempleTrekOverlay extends Overlay{
    private final Client client;
    private final TempleTrekConfig config;
    private final TempleTrekPlugin plugin;

    private static final Color GREEN = new Color(0, 200, 83);

    @Inject
    private TempleTrekOverlay(Client client, TempleTrekConfig config, TempleTrekPlugin plugin)
    {
        this.client = client;
        this.config = config;
        this.plugin = plugin;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.LOW);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (config.bogMapActive()) {
            for (GroundObject bog : plugin.getBogList()) {
                Polygon bogPoly = bog.getCanvasTilePoly();
                OverlayUtil.renderPolygon(graphics, bogPoly, GREEN);
            }
        }
        return null;
    }
}
