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
        WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

        for (MultiLineBorder border : plugin.multiLineBorders) {
            if (playerLocation.distanceTo(border.getMulti()) > 18) {
                continue;
            }

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
                Polygon multiLine = linePoly(client, localPointStart, localPointEnd, 0, 0);
                Polygon singleLine = linePoly(client, localPointStart, localPointEnd, 2, 2);
                if (multiLine != null && singleLine != null) {
                    OverlayUtil.renderPolygon(graphics, multiLine, config.multiColor());
                    OverlayUtil.renderPolygon(graphics, singleLine, config.singleColor());
                }
            }
        }

        return null;
    }

    /**
     * Returns a polygon representing a line between two points. Top left corners.
     */
    private Polygon linePoly(@Nonnull Client client, @Nonnull LocalPoint startLocation, @Nonnull LocalPoint endLocation, int adjustX, int adjustY) {
        int adjustedPointsX = adjustX * (LOCAL_TILE_SIZE / 8);
        int adjustedPointsY = adjustY * (LOCAL_TILE_SIZE / 8);

        Point startPoint = new Point(
                startLocation.getX() - (LOCAL_TILE_SIZE / 2) + adjustedPointsX,
                startLocation.getY() + (LOCAL_TILE_SIZE / 2) + adjustedPointsY);
        Point endPoint = new Point(
                endLocation.getX() - (LOCAL_TILE_SIZE / 2) + adjustedPointsX,
                endLocation.getY() + (LOCAL_TILE_SIZE / 2) + adjustedPointsY);

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
