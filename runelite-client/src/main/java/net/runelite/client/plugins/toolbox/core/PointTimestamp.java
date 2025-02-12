package net.runelite.client.plugins.toolbox.core;

import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;

import java.time.Instant;

public class PointTimestamp {
    private final Point point;
    private final Instant timestamp;

    public PointTimestamp(Point point) {
        this.point = point;
        this.timestamp = Instant.now();
    }


    public PointTimestamp(Point point, Instant timestamp) {
        this.point = point;
        this.timestamp = timestamp;
    }

    public PointTimestamp(int x, int y) {
        this.point = new Point(x, y);
        this.timestamp = Instant.now();
    }

    public Point getPoint() {
        return point;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}

