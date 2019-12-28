package net.runelite.client.plugins.tearsofguthix;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;

public class TearsOfGuthixTimerOverlay extends Overlay {

    @Inject
    private PanelComponent panelComponent = new PanelComponent();

    @Inject
    private Client client;

    @Inject
    private TearsOfGuthixTimer tearsOfGuthixTimer;

    @Inject
    private TearsOfGuthixTimerOverlay(Client client, TearsOfGuthixPlugin plugin)
    {
        super(plugin);
        setPosition(OverlayPosition.BOTTOM_LEFT);
        this.client = client;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        String time = tearsOfGuthixTimer.getTime();
        // make sure player player is in region or check if timer is over
        if(time.equals("-1") || client.getLocalPlayer().getWorldLocation().getRegionID() != 12948 && client.getLocalPlayer().getWorldLocation().getX() >= 3250 && client.getLocalPlayer().getWorldLocation().getX() <= 3262)
        {
            return null;
        }
        panelComponent.getChildren().clear();
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Time Left: ")
            .right(time)
            .build());
        return panelComponent.render(graphics);
    }

}
