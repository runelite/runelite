package net.runelite.client.plugins.worldposition;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;

public class WorldPositionOverlay extends Overlay {

    private final Client client;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private WorldPositionOverlay(Client client) {
        this.client = client;
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        setPosition(OverlayPosition.BOTTOM_LEFT);
        setPriority(OverlayPriority.HIGHEST);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (client.getGameState().equals(GameState.LOGGED_IN) && client.getLocalPlayer() != null) {
            WorldPoint wp = client.getLocalPlayer().getWorldLocation();
            panelComponent.setBackgroundColor(Color.BLACK);
            panelComponent.setPreferredSize(new Dimension(50, 50));
            panelComponent.getChildren().clear();
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("X " + String.valueOf(wp.getX())).leftColor(Color.WHITE)
                    .build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Y " + String.valueOf(wp.getY())).leftColor(Color.WHITE)
                    .build());
        }
        return panelComponent.render(graphics);
    }

}
