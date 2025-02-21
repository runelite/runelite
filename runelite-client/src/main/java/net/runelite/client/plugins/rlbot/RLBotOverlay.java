package net.runelite.client.plugins.rlbot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.BasicStroke;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

public class RLBotOverlay extends Overlay {
    private final RLBotPlugin plugin;
    private final Queue<TrailPoint> cursorTrail;
    private static final int TRAIL_LENGTH = 20; // Increased trail length
    private static final int TRAIL_FADE_DURATION = 5000; // Increased duration to 2 seconds
    private static final float TRAIL_THICKNESS = 3.0f; // Thicker trail
    private static final Color CURSOR_COLOR = new Color(255, 255, 0, 255); // Bright yellow
    private static final Color TRAIL_COLOR = new Color(255, 255, 0, 128); // Semi-transparent yellow

    private static class TrailPoint {
        final Point point;
        final long timestamp;

        TrailPoint(Point point, long timestamp) {
            this.point = point;
            this.timestamp = timestamp;
        }
    }

    @Inject
    RLBotOverlay(RLBotPlugin plugin) {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGH);
        this.plugin = plugin;
        this.cursorTrail = new LinkedList<>();
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        long currentTime = System.currentTimeMillis();
        
        // Update trail
        if (plugin.getLastCursorX() >= 0 && plugin.getLastCursorY() >= 0) {
            Point newPoint = new Point(plugin.getLastCursorX(), plugin.getLastCursorY());
            
            // Only add point if it's different from the last one
            if (cursorTrail.isEmpty() || !((TrailPoint)cursorTrail.peek()).point.equals(newPoint)) {
                cursorTrail.offer(new TrailPoint(newPoint, currentTime));
                if (cursorTrail.size() > TRAIL_LENGTH) {
                    cursorTrail.poll();
                }
            }
        }

        // Remove old points
        Iterator<TrailPoint> iterator = cursorTrail.iterator();
        while (iterator.hasNext()) {
            TrailPoint point = iterator.next();
            if (currentTime - point.timestamp > TRAIL_FADE_DURATION) {
                iterator.remove();
            }
        }

        // Set stroke for thicker lines
        graphics.setStroke(new BasicStroke(TRAIL_THICKNESS, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Draw trail
        if (!cursorTrail.isEmpty()) {
            TrailPoint[] points = cursorTrail.toArray(new TrailPoint[0]);
            for (int i = 0; i < points.length - 1; i++) {
                // Calculate alpha based on both position in trail and time
                float positionAlpha = (float)(i + 1) / points.length;
                float timeAlpha = Math.max(0, 1f - (float)(currentTime - points[i].timestamp) / TRAIL_FADE_DURATION);
                float alpha = positionAlpha * timeAlpha;
                
                Color trailColor = new Color(
                    TRAIL_COLOR.getRed(),
                    TRAIL_COLOR.getGreen(),
                    TRAIL_COLOR.getBlue(),
                    (int)(alpha * TRAIL_COLOR.getAlpha())
                );
                
                graphics.setColor(trailColor);
                graphics.drawLine(
                    points[i].point.x, points[i].point.y,
                    points[i + 1].point.x, points[i + 1].point.y
                );
            }
        }

        // Draw current cursor
        if (plugin.getLastCursorX() >= 0 && plugin.getLastCursorY() >= 0) {
            // Calculate cursor alpha based on time
            float timeAlpha = Math.max(0, 1f - (float)(currentTime - plugin.getLastCursorTime()) / TRAIL_FADE_DURATION);
            Color cursorColorWithAlpha = new Color(
                CURSOR_COLOR.getRed(),
                CURSOR_COLOR.getGreen(),
                CURSOR_COLOR.getBlue(),
                (int)(timeAlpha * CURSOR_COLOR.getAlpha())
            );
            
            graphics.setColor(cursorColorWithAlpha);
            
            int x = plugin.getLastCursorX();
            int y = plugin.getLastCursorY();
            int size = 12; // Larger cursor

            // Draw crosshair with thicker lines
            graphics.setStroke(new BasicStroke(2.0f));
            graphics.drawLine(x - size, y, x + size, y);
            graphics.drawLine(x, y - size, x, y + size);
            
            // Draw a circle around the crosshair
            graphics.drawOval(x - size/2, y - size/2, size, size);
        }

        return null;
    }
} 