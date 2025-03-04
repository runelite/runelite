package net.runelite.client.plugins.rlbot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayLayer;

/**
 * RLBot Overlay that displays cursor trail
 */
public class RLBotOverlay extends Overlay {
    private static final Color TRAIL_COLOR = new Color(0, 255, 255, 150);
    private static final long POINT_LIFETIME_MS = 2000; // Points live for 2 seconds
    private static final int MAX_TRAIL_LENGTH = 100; // Limit trail length
    
    private final Client client;
    private final RLBotConfig config;
    
    // Store cursor position history for trail with timestamps
    private final List<TimestampedPoint> cursorTrail = new ArrayList<>();
    
    private static class TimestampedPoint {
        final Point point;
        final long timestamp;
        
        TimestampedPoint(Point point) {
            this.point = new Point(point);
            this.timestamp = System.currentTimeMillis();
        }
        
        /**
         * Calculate opacity based on age of point
         * @return opacity from 0.0 to 1.0
         */
        float getOpacity(long currentTime) {
            long age = currentTime - timestamp;
            if (age >= POINT_LIFETIME_MS) {
                return 0f;
            }
            return 1f - (float)age / POINT_LIFETIME_MS;
        }
    }
    
    @Inject
    private RLBotOverlay(Client client, RLBotConfig config) {
        this.client = client;
        this.config = config;
        
        setPriority(OverlayPriority.HIGH);
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
    }
    
    @Override
    public Dimension render(Graphics2D graphics) {
        // Always render the trail regardless of config setting
        if (!cursorTrail.isEmpty()) {
            Point lastPoint = null;
            long currentTime = System.currentTimeMillis();
            
            // Clean up expired points
            removeExpiredPoints(currentTime);
            
            // Draw the trail
            Iterator<TimestampedPoint> it = cursorTrail.iterator();
            while (it.hasNext()) {
                TimestampedPoint timestampedPoint = it.next();
                Point point = timestampedPoint.point;
                float opacity = timestampedPoint.getOpacity(currentTime);
                
                if (opacity <= 0) {
                    continue; // Skip fully transparent points
                }
                
                // Create a color with the current opacity
                Color pointColor = new Color(
                    TRAIL_COLOR.getRed(),
                    TRAIL_COLOR.getGreen(), 
                    TRAIL_COLOR.getBlue(),
                    Math.round(TRAIL_COLOR.getAlpha() * opacity)
                );
                
                graphics.setColor(pointColor);
                
                // Draw line from previous point if we have one
                if (lastPoint != null) {
                    graphics.drawLine(lastPoint.x, lastPoint.y, point.x, point.y);
                }
                
                // Draw the point
                graphics.fillOval(point.x - 2, point.y - 2, 4, 4);
                lastPoint = point;
            }
        }
        
        return null; // No fixed dimensions needed
    }
    
    /**
     * Remove points that have exceeded their lifetime
     */
    private void removeExpiredPoints(long currentTime) {
        Iterator<TimestampedPoint> it = cursorTrail.iterator();
        while (it.hasNext()) {
            TimestampedPoint point = it.next();
            if (currentTime - point.timestamp > POINT_LIFETIME_MS) {
                it.remove();
            }
        }
    }
    
    /**
     * Updates the cursor position and maintains the trail history
     *
     * @param point The current cursor position
     */
    public void updateCursorPosition(Point point) {
        if (point == null) return;
        
        // Add new point to the trail
        cursorTrail.add(new TimestampedPoint(point));
        
        // Limit trail length to prevent memory issues
        while (cursorTrail.size() > MAX_TRAIL_LENGTH) {
            cursorTrail.remove(0);
        }
    }
    
    /**
     * Clears the cursor trail
     */
    public void clearTrail() {
        cursorTrail.clear();
    }
} 