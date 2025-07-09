package net.runelite.client.plugins.mobslocator;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.api.Perspective;

public class MobsLocatorMinimapOverlay extends Overlay
{
    private final Client client;
    private final MobsLocatorPlugin plugin;
    private final MobsLocatorConfig config;

    @Inject
    public MobsLocatorMinimapOverlay(Client client, MobsLocatorPlugin plugin, MobsLocatorConfig config)
    {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        setPriority(OverlayPriority.HIGH);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!config.showMinimapDots())
        {
            return null;
        }

        String searchedMob = config.searchedMob().trim().toLowerCase();
        if (searchedMob.isEmpty())
        {
            return null;
        }

        // Draw dots for searched mobs
        for (NPC npc : plugin.getSearchedMobs())
        {
            if (npc == null || npc.getWorldLocation() == null)
            {
                continue;
            }

            LocalPoint localPoint = LocalPoint.fromWorld(client, npc.getWorldLocation());
            if (localPoint == null)
            {
                continue;
            }

            Point minimapPoint = Perspective.localToMinimap(client, localPoint);
            if (minimapPoint == null)
            {
                continue;
            }

            // Draw a dot on the minimap
            graphics.setColor(config.minimapDotColor());
            graphics.fillOval(minimapPoint.getX() - 2, minimapPoint.getY() - 2, 4, 4);
            
            // Draw a border around the dot
            graphics.setColor(Color.BLACK);
            graphics.drawOval(minimapPoint.getX() - 2, minimapPoint.getY() - 2, 4, 4);
        }

        return null;
    }
}