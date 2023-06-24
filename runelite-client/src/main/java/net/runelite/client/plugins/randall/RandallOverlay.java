package net.runelite.client.plugins.randall;

import net.runelite.client.plugins.randall.event.EventHandler;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;

public class RandallOverlay extends Overlay {

    @Inject
    private RandallPlugin plugin;

    @Inject
    private RandallOverlay(RandallPlugin plugin) {
        this.plugin = plugin;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGHEST);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (EventHandler.isBlocking()) {
            Point cursorPosition = plugin.mouse.getMousePos();
            graphics.setColor(Color.RED);
            graphics.fillOval(cursorPosition.x - 5, cursorPosition.y - 5, 10, 10);
        }

        return null;
    }
}
