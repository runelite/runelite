package net.runelite.client.plugins.flexo;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class FlexoOverlay extends Overlay {

    public static Rectangle clickArea;
    public ArrayList<Rectangle> clickAreas = new ArrayList<>();
    public ArrayList<Point> clickPoints = new ArrayList<>();

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
        if (config.getDebugNPCs() || config.getDebugGroundItems() || config.getDebugPlayers()) {
            if (clickArea!=null)
                graphics.draw(clickArea);
            if (clickAreas!=null) {
                for (Rectangle clickArea : clickAreas) {
                    if (clickArea!=null)
                        graphics.draw(clickArea);
                }
            }
            if (clickPoints!=null) {
                for (Point p : clickPoints) {
                    if (p!=null) {
                        graphics.setColor(Color.MAGENTA);
                        graphics.draw(new Line2D.Double(p.x, p.y, p.x, p.y));
                        graphics.draw(new Line2D.Double(p.x-1, p.y-1, p.x-1, p.y-1));
                        graphics.draw(new Line2D.Double(p.x+1, p.y+1, p.x+1, p.y+1));
                        graphics.draw(new Line2D.Double(p.x-1, p.y+1, p.x-1, p.y+1));
                        graphics.draw(new Line2D.Double(p.x+1, p.y-1, p.x+1, p.y-1));
                    }
                }
            }
        }
        return null;
    }
}
