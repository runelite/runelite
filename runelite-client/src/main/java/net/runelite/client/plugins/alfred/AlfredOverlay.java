package net.runelite.client.plugins.alfred;

import net.runelite.api.Client;
import net.runelite.client.plugins.alfred.api.rs.walk.RSTile;
import net.runelite.client.plugins.alfred.api.rs.walk.RSWalkableTile;
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
        drawWalkablePoints(graphics);

        Point cursorPosition = Alfred.getMouse().getCurrentMousePosition();
        graphics.setColor(Color.RED);
        graphics.fillOval(cursorPosition.x - 5, cursorPosition.y - 5, 10, 10);

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

    private void drawWalkablePoints(Graphics2D graphics) {
        graphics.setColor(Color.GREEN);

//        for (RSWalkableTile rsWalkableTile : Alfred.api.walk().getWalkableTiles()) {
//
//            Polygon poly = rsWalkableTile.getCanvasPolygon();
//
//            if (poly == null) {
//                continue;
//            }
//
//            graphics.setColor(Color.GREEN);
//            if (rsWalkableTile.isOperable()) {
//                graphics.setColor(Color.YELLOW);
//            }
//
//            graphics.drawPolygon(poly);
//        }

        for (RSTile rsWalkableTile : Alfred.api.walk().getPath()) {

            Polygon poly = rsWalkableTile.getCanvasPolygon();

            if (poly == null) {
                continue;
            }

            graphics.setColor(Color.BLUE);
            if (rsWalkableTile.isOperable()) {
                graphics.setColor(Color.RED);
            }

            graphics.drawPolygon(poly);
        }

    }
}
