package net.runelite.client.plugins.alfred;

import net.runelite.api.Client;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;

public class AlfredOverlay extends Overlay {

    @Inject
    private Client client;

    @Inject
    private AlfredOverlay() {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGHEST);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        drawMouse(graphics);
        drawStatusBox(graphics, Alfred.getStatus());
        return null;
    }

    private void drawStatusBox(Graphics2D graphics, String status) {
        FontMetrics fontMetrics = Alfred.getClient().getCanvas().getFontMetrics(FontManager.getRunescapeBoldFont());

        int padding = 5;
        int height = fontMetrics.getHeight() + (padding * 2);
        int width = Math.max(200, fontMetrics.stringWidth(status));

        Rectangle statusBox = new Rectangle(10, 30, width, height);

        // Draw the background
        graphics.setColor(new Color(156, 163, 175, 200));
        graphics.fill(statusBox);

        // Draw the border
        graphics.setColor(new Color(32, 41, 55));
        graphics.setStroke(new BasicStroke(2));
        graphics.draw(statusBox);

        // Draw the text
        graphics.setColor(Color.WHITE);
        graphics.setFont(FontManager.getRunescapeBoldFont());
        graphics.drawString(status, statusBox.x + padding, statusBox.y + padding + fontMetrics.getAscent());
    }

    private void drawMouse(Graphics2D graphics) {
        Point cursorPosition = Alfred.getMouse().getCurrentMousePosition();
        graphics.setColor(Color.RED);
        graphics.fillOval(cursorPosition.x - 5, cursorPosition.y - 5, 10, 10);
    }
}
