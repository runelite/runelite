package net.runelite.client.plugins.alfred.api.rs.screen;

import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;

public class RSScreenHelper {

    public RSScreenHelper() {
    }

    public Rectangle getBounds() {
        return new Rectangle(Alfred.getClient().getViewportXOffset(), Alfred.getClient().getViewportYOffset(), Alfred.getClient().getViewportWidth(), Alfred.getClient().getViewportHeight());
    }

    public Point getLocalPointToScreenPoint(LocalPoint localPoint, int plane) {
        return Perspective.localToCanvas(Alfred.getClient(), localPoint, plane);
    }

    public Point getWorldPointToScreenPoint(WorldPoint worldPoint) {
        return Perspective.localToCanvas(Alfred.getClient(), worldPoint.getX(), worldPoint.getY(), worldPoint.getPlane());
    }

    private boolean internalIsPointOnScreen(Point point) {
        return getBounds().contains(point.getX(), point.getY());
    }

    public boolean isPointOnScreen(WorldPoint worldPoint) {
        return internalIsPointOnScreen(getWorldPointToScreenPoint(worldPoint));
    }

    public boolean isPointOnScreen(LocalPoint localPoint, int plane) {
        return internalIsPointOnScreen(getLocalPointToScreenPoint(localPoint, plane));
    }

    public boolean isPointOnScreen(Point point) {
        return internalIsPointOnScreen(point);
    }

    public boolean isPointOnScreen(int x, int y) {
        return internalIsPointOnScreen(new Point(x, y));
    }
}
