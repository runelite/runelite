package net.runelite.client.plugins.rlbot.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.inject.Inject;
import lombok.Setter;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

public class RLBotCursorOverlay extends Overlay {
    @Setter
    private Point currentMousePosition;
    
    @Inject
    public RLBotCursorOverlay() {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGH);
    }
    
    @Override
    public Dimension render(Graphics2D graphics) {
        if (currentMousePosition != null) {
            // Draw cursor crosshair
            graphics.setColor(Color.RED);
            int size = 10;
            graphics.drawLine(
                currentMousePosition.x - size,
                currentMousePosition.y,
                currentMousePosition.x + size,
                currentMousePosition.y
            );
            graphics.drawLine(
                currentMousePosition.x,
                currentMousePosition.y - size,
                currentMousePosition.x,
                currentMousePosition.y + size
            );
            
            // Draw circle around cursor
            int circleSize = 5;
            graphics.drawOval(
                currentMousePosition.x - circleSize,
                currentMousePosition.y - circleSize,
                circleSize * 2,
                circleSize * 2
            );
        }
        return null;
    }
} 