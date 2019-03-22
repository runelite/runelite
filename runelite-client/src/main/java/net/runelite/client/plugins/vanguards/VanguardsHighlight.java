package net.runelite.client.plugins.vanguards;

import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;
import java.util.List;

import static java.awt.Color.GRAY;
import static java.awt.Color.ORANGE;
import static java.awt.Color.YELLOW;

public class VanguardsHighlight extends Overlay {

    private final Client client;
    private final VanguardsPlugin plugin;
    private final VanguardsConfig config;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    VanguardsHighlight(Client client, VanguardsPlugin plugin, VanguardsConfig config)
    {
        super(plugin);
        setLayer(OverlayLayer.ABOVE_MAP);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }
    @Override
    public Dimension render(Graphics2D graphics) {
        if(!plugin.inVangs){
            return null;
        }
        if(config.showTile()){
            if(plugin.ranger != null){
                renderNpcOverlay(graphics,plugin.ranger,"Range",Color.GREEN);
            }
            if(plugin.mager != null){
                renderNpcOverlay(graphics,plugin.mager,"Mage",Color.BLUE);
            }
            if(plugin.meleer != null){
                renderNpcOverlay(graphics,plugin.meleer,"Melee",Color.RED);
            }
        }
        return null;
    }


    private void renderNpcOverlay(Graphics2D graphics, NPC actor, String name, Color color)
    {

        Polygon objectClickbox = actor.getConvexHull();

        renderPoly(graphics, color, objectClickbox);

    }

    private void renderPoly(Graphics2D graphics, Color color, Polygon polygon)
    {
        if (polygon != null)
        {
            graphics.setColor(color);
            graphics.setStroke(new BasicStroke(2));
            graphics.draw(polygon);
            graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
            graphics.fill(polygon);
        }
    }
}
