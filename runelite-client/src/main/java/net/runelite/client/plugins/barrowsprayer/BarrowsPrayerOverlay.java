package net.runelite.client.plugins.barrowsprayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class BarrowsPrayerOverlay extends Overlay
{
    private final Client client;
    private final  BarrowsPrayerConfig config;
    private final  BarrowsPrayerPlugin plugin;

    @Inject
    private  BarrowsPrayerOverlay(Client client,  BarrowsPrayerConfig config,  BarrowsPrayerPlugin plugin)
    {
        super(plugin);
        this.plugin = plugin;
        this.client = client;
        this.config = config;
        //setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {

        if (plugin.getRenderNpcTile()){
            //System.out.println("rendering");
            renderTile(graphics, plugin.getNpcLocation(), config.highlightTileColor());
        }



        return null;
    }

    private void renderTile(final Graphics2D graphics, final LocalPoint dest, final Color color)
    {
        if (dest == null)
        {
            return;
        }

        final Polygon poly = Perspective.getCanvasTilePoly(client, dest);

        if (poly == null)
        {
            return;
        }

        OverlayUtil.renderPolygon(graphics, poly, color);
    }
}
