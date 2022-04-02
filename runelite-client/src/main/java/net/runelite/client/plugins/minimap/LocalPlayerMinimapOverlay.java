package net.runelite.client.plugins.minimap;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

class LocalPlayerMinimapOverlay extends Overlay
{

    private final Client client;
    private final MinimapConfig config;
    private final MinimapPlugin plugin;

    @Inject
    private LocalPlayerMinimapOverlay(Client client, MinimapConfig config, MinimapPlugin plugin)
    {
        this.client = client;
        this.config = config;
        this.plugin = plugin;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.LOW);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (config.localColor() == null)
        {
            return null;
        }

        drawOnMinimap(graphics);
        return null;
    }

    private void drawOnMinimap(Graphics2D graphics)
    {

        Point posOnMinimap = Perspective.localToMinimap(client, client.getLocalPlayer().getLocalLocation());
        if (posOnMinimap == null)
        {
            return;
        }

        int size = config.localPlayerSize();
        graphics.setColor(config.localColor());
        graphics.fillRect(posOnMinimap.getX() - 1, posOnMinimap.getY() - 1, size, size);

    }
}
