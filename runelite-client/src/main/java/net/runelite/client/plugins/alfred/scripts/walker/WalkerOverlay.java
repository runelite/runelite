package net.runelite.client.plugins.alfred.scripts.walker;

import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.walk.RSTile;
import net.runelite.client.plugins.alfred.api.rs.walk.astar.AStarNode;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;

public class WalkerOverlay extends Overlay {

    @Inject
    private WalkerOverlay() {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGHEST);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        for (RSTile currentWalkableTile : Alfred.api.walk().getWalkableTiles()) {
            for (AStarNode node : Alfred.api.walk().getPath()) {
                if (currentWalkableTile.getWorldLocation().equals(node.getWorldLocation())) {
                    Polygon poly = currentWalkableTile.getCanvasPolygon();

                    if (poly == null) {
                        continue;
                    }

                    graphics.setColor(Color.BLUE);
                    if (currentWalkableTile.isOperable()) {
                        graphics.setColor(Color.RED);
                    }

                    graphics.drawPolygon(poly);
                }
            }
        }
        return null;
    }
}
