package net.runelite.client.plugins.alfred.scripts.gerber;

import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.AlfredOverlayBuilder;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;

public class GerberOverlay extends Overlay {

    @Inject
    private GerberOverlay() {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGHEST);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        drawStatusBox(graphics);
        return null;
    }

    private void drawStatusBox(Graphics2D graphics) {
        if (Alfred.getClient().getGameState() != GameState.LOGGED_IN) {
            return;
        }

        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.CHATBOX_MESSAGE_LINES);
        if (widget == null || widget.isHidden() || widget.isSelfHidden()) {
            return;
        }

        AlfredOverlayBuilder overlayBuilder = new AlfredOverlayBuilder(graphics, widget.getBounds());
        overlayBuilder.drawBounds();
        overlayBuilder.drawTitle("Alfred Gerber");
        overlayBuilder.drawText("Max Run Time:", Alfred.getPlayTimer().getTimeout() + " minutes", false);
        overlayBuilder.drawText("Elapsed Run Time:", Alfred.getPlayTimer().getElapsedTimeString(), false);

//        overlayBuilder.drawText("", true);
//        overlayBuilder.drawText("", false);

        overlayBuilder.drawText("Task:", Alfred.getTaskStatus(), true);
        overlayBuilder.drawText("Task Status:", Alfred.getTaskSubStatus(), true);

        overlayBuilder.drawText("", false);
        overlayBuilder.drawText("Current Status:", Alfred.getStatus(), true);
    }
}
