package net.runelite.client.plugins.olmcrippletimer;


import java.awt.*;
import java.util.*;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;


public class OlmCrippleTimerOverlay extends Overlay {


    private final Client client;
    private final OlmCrippleTimerPlugin plugin;

    @Inject
    private OlmCrippleTimerOverlay(Client client, OlmCrippleTimerPlugin plugin){
        this.client = client;
        this.plugin = plugin;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if(plugin.isHandCripple()){
            int tick = plugin.getTimer();
            NPC olmHand = plugin.getHand();
            final String tickStr = String.valueOf(tick);
            Point canvasPoint = olmHand.getCanvasTextLocation(graphics, tickStr, 50);
            renderTextLocation(graphics, tickStr, 12 , Font.BOLD, Color.GRAY, canvasPoint);
        }


        return null;
    }
    //this is just copy pasted btw
    private void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint)
    {
        graphics.setFont(new Font("Arial", fontStyle, fontSize));
        if (canvasPoint != null)
        {
            final Point canvasCenterPoint = new Point(
                    canvasPoint.getX(),
                    canvasPoint.getY());
            final Point canvasCenterPoint_shadow = new Point(
                    canvasPoint.getX() + 1,
                    canvasPoint.getY() + 1) ;
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
        }
    }

}