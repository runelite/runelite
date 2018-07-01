package net.runelite.client.plugins.multilines;

import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.awt.*;

import static net.runelite.api.Perspective.LOCAL_TILE_SIZE;

public class MultiLinesOverlay extends Overlay {

    private final Client client;
    private final MultiLinesConfig config;
    private final MultiLinesPlugin plugin;

    @Inject
    MultiLinesOverlay(Client client, MultiLinesConfig config, MultiLinesPlugin plugin) {
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.MED);
        this.client = client;
        this.config = config;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        for (MultiLineBorder border : plugin.multiLineBorders) {
            WorldPoint start;
            WorldPoint end;

            switch (border.getEdge()) {
                case MultiLineBorder.NORTH:
                    start = border.getMulti();
                    end = new WorldPoint(start.getX() + 1, start.getY(), start.getPlane());
                    break;
                case MultiLineBorder.SOUTH:
                    start = border.getSingle();
                    end = new WorldPoint(start.getX() + 1, start.getY(), start.getPlane());
                    break;
                case MultiLineBorder.EAST:
                    start = border.getSingle();
                    end = new WorldPoint(start.getX(), start.getY() - 1, start.getPlane());
                    break;
                case MultiLineBorder.WEST:
                    start = border.getMulti();
                    end = new WorldPoint(start.getX(), start.getY() - 1, start.getPlane());
                    break;
                default:
                    throw new IllegalStateException("Unknown edge type.");
            }

            LocalPoint localPointStart = LocalPoint.fromWorld(client, start);
            LocalPoint localPointEnd = LocalPoint.fromWorld(client, end);

            if (localPointStart != null && localPointEnd != null) {
                Polygon polygon = linePoly(client, localPointStart, localPointEnd);
                if (polygon != null) {
                    OverlayUtil.renderPolygon(graphics, polygon, Color.WHITE);
                }
            }
        }

        return null;
    }

    /**
     * Returns a polygon representing a line between two points. Top left corners.
     */
    private Polygon linePoly(@Nonnull Client client, @Nonnull LocalPoint startLocation, @Nonnull LocalPoint endLocation) {
        Point startPoint = new Point(
                startLocation.getX() - (1 * LOCAL_TILE_SIZE / 2),
                startLocation.getY() + (1 * LOCAL_TILE_SIZE / 2));
        Point endPoint = new Point(
                endLocation.getX() - (1 * LOCAL_TILE_SIZE / 2),
                endLocation.getY() + (1 * LOCAL_TILE_SIZE / 2));

        int plane = client.getPlane();

        Point p1 = Perspective.worldToCanvas(client, startPoint.getX(), startPoint.getY(), plane);
        Point p2 = Perspective.worldToCanvas(client, endPoint.getX(), endPoint.getY(), plane);

        if (p1 != null && p2 != null) {
            Polygon polygon = new Polygon();
            polygon.addPoint(p1.getX(), p1.getY());
            polygon.addPoint(p2.getX(), p2.getY());
            return polygon;
        }

        return null;
    }

}
