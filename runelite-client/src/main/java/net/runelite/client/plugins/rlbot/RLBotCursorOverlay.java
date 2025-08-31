package net.runelite.client.plugins.rlbot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.AlphaComposite;
import java.util.LinkedList;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

public class RLBotCursorOverlay extends Overlay
{
    private final RLBotConfig config;
    private final RLBotPlugin plugin;
    private static final int TRAIL_LENGTH = 50; // Increased trail length
    private static final int TRAIL_FADE_DURATION = 500; // Increased fade duration in milliseconds
    private final LinkedList<TrailPoint> trail;
    private Point lastKnownPosition;

    private static class TrailPoint {
        Point point;
        long timestamp;

        TrailPoint(Point point, long timestamp) {
            this.point = point;
            this.timestamp = timestamp;
        }
    }

    @Inject
    private RLBotCursorOverlay(RLBotConfig config, RLBotPlugin plugin)
    {
        super(plugin);
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGH);
        this.config = config;
        this.plugin = plugin;
        this.trail = new LinkedList<>();
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!config.showCursorOverlay())
        {
            return null;
        }

        Point mousePos = plugin.getLastMouseLocation();
        if (mousePos != null)
        {
            lastKnownPosition = mousePos;
        }
        else if (lastKnownPosition != null)
        {
            mousePos = lastKnownPosition;
        }

        if (mousePos != null)
        {
            // Update trail
            long currentTime = System.currentTimeMillis();
            trail.addFirst(new TrailPoint(new Point(mousePos), currentTime));
            
            // Remove old trail points
            while (trail.size() > TRAIL_LENGTH) {
                trail.removeLast();
            }

            // Draw trail with improved effect
            Point lastPoint = null;
            for (int i = 0; i < trail.size(); i++) {
                TrailPoint trailPoint = trail.get(i);
                Point point = trailPoint.point;
                
                if (lastPoint != null) {
                    // Calculate alpha based on age with smoother fade
                    long age = currentTime - trailPoint.timestamp;
                    float alpha = Math.max(0f, 1f - (float)age / TRAIL_FADE_DURATION);
                    alpha = (float)Math.pow(alpha, 2); // Quadratic falloff for smoother fade
                    
                    // Calculate thickness based on age
                    float thickness = 3f * alpha;
                    
                    // Set color with alpha and draw thicker line
                    graphics.setColor(new Color(255, 0, 0, (int)(alpha * 255)));
                    graphics.setStroke(new java.awt.BasicStroke(thickness));
                    graphics.drawLine(lastPoint.x, lastPoint.y, point.x, point.y);
                }
                lastPoint = point;
            }

            // Reset stroke for cursor drawing
            graphics.setStroke(new java.awt.BasicStroke(1f));

            // Draw cursor crosshair with glow effect
            graphics.setColor(new Color(255, 0, 0, 64));
            int glowSize = 12;
            graphics.drawLine(
                mousePos.x - glowSize,
                mousePos.y,
                mousePos.x + glowSize,
                mousePos.y
            );
            graphics.drawLine(
                mousePos.x,
                mousePos.y - glowSize,
                mousePos.x,
                mousePos.y + glowSize
            );
            
            // Draw main cursor
            graphics.setColor(Color.RED);
            int size = 10;
            graphics.drawLine(
                mousePos.x - size,
                mousePos.y,
                mousePos.x + size,
                mousePos.y
            );
            graphics.drawLine(
                mousePos.x,
                mousePos.y - size,
                mousePos.x,
                mousePos.y + size
            );
            
            // Draw circle around cursor with glow
            graphics.setColor(new Color(255, 0, 0, 128));
            int outerCircleSize = 7;
            graphics.drawOval(
                mousePos.x - outerCircleSize,
                mousePos.y - outerCircleSize,
                outerCircleSize * 2,
                outerCircleSize * 2
            );
            
            graphics.setColor(Color.RED);
            int circleSize = 5;
            graphics.drawOval(
                mousePos.x - circleSize,
                mousePos.y - circleSize,
                circleSize * 2,
                circleSize * 2
            );

            // Draw coordinates with shadow effect
            String coords = "(" + mousePos.x + ", " + mousePos.y + ")";
            graphics.setColor(new Color(0, 0, 0, 128));
            graphics.drawString(coords, mousePos.x + 16, mousePos.y + 16);
            graphics.setColor(Color.RED);
            graphics.drawString(coords, mousePos.x + 15, mousePos.y + 15);
        }
        return null;
    }
} 