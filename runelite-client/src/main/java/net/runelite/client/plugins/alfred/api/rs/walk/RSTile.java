package net.runelite.client.plugins.alfred.api.rs.walk;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.coords.WorldPoint;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class RSTile {
    private boolean isBlocked;

    @Setter
    @Getter
    private int gCost;
    @Setter
    @Getter
    private int hCost;

    @Getter
    @Setter
    int heapIndex = -1;

    @Getter
    @Setter
    int movementPenalty = 0;

    @Getter
    @Setter
    private RSTile parent;

    public void setBlocked(boolean value) {
        isBlocked = value;
    }

    public boolean getBlocked() {
        return isBlocked;
    }

    public abstract boolean isWalkable(RSTile otherNode);

    public abstract boolean isOperable();

    public abstract WorldPoint getWorldLocation();

    public abstract Polygon getCanvasPolygon();

    public List<RSTile> getNeighbors(List<RSTile> allWalkableTiles) {
        List<RSTile> neighbors = new ArrayList<>();

        List<Point> points = new ArrayList<>();
        points.add(new Point(-1, 0));
        points.add(new Point(1, 0));
        points.add(new Point(0, -1));
        points.add(new Point(0, 1));
        points.add(new Point(-1, -1));
        points.add(new Point(1, 1));
        points.add(new Point(-1, 1));
        points.add(new Point(1, -1));

        for (Point point : points) {
            int checkX = getWorldLocation().getX() + point.x;
            int checkY = getWorldLocation().getY() + point.y;

            for (RSTile walkableTile : allWalkableTiles) {
                if (walkableTile.getWorldLocation().getX() == checkX && walkableTile.getWorldLocation().getY() == checkY) {
                    neighbors.add(walkableTile);
                }
            }
        }


        return neighbors;
    }

    public int getFCost() {
        return gCost + hCost;
    }

    public int heapCompare(RSTile item) {
        int compare = Integer.compare(getFCost(), item.getFCost());
        if (compare == 0) {
            compare = Integer.compare(getHCost(), item.getHCost());
        }
        return -compare;
    }
}
