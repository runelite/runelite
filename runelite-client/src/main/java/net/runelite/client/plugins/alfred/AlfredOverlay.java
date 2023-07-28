package net.runelite.client.plugins.alfred;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;

public class AlfredOverlay extends Overlay {

    @Inject
    private AlfredOverlay() {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGHEST);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        drawMouse(graphics);
        return null;
    }

    private void drawMouse(Graphics2D graphics) {
        Point cursorPosition = Alfred.getMouse().getCurrentMousePosition();
        graphics.setColor(Color.RED);
        graphics.fillOval(cursorPosition.x - 5, cursorPosition.y - 5, 10, 10);
    }
}
