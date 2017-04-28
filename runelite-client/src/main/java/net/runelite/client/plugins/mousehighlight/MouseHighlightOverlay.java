package net.runelite.client.plugins.mousehighlight;

import net.runelite.api.Client;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;

/**
 * Created by aria on 4/27/17.
 */
public class MouseHighlightOverlay extends Overlay {
    public MouseHighlightOverlay() {
        super(OverlayPosition.DYNAMIC, OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        Client client = RuneLite.getClient();

        String[] options =  client.getMenuOptions();

        return null;
    }
}
