package net.runelite.client.plugins.timeofguthix;

import net.runelite.api.Client;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;
import java.time.temporal.ChronoUnit;

public class TimeOfGuthixOverlay extends Overlay {

    @Inject
    private TimeOfGuthix plugin;

    @Inject
    private PanelComponent panelComponent = new PanelComponent();

    @Inject
    private Client client;

    @Inject
    private TimeOfGuthixTimer timeOfGuthixTimer;


    @Inject
    private TimeOfGuthixOverlay(Client client, TimeOfGuthix plugin)
    {
        super(plugin);
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_MAP);
        this.client = client;
        this.plugin = plugin;
    }

    @Override @Schedule(period = 1, unit = ChronoUnit.SECONDS)
    public Dimension render(Graphics2D graphics)
    {
        String time = timeOfGuthixTimer.getTime();
        if(time.equals("-1") || client.getLocalPlayer().getWorldLocation().getRegionID() != 13878) // CHANGE WITH 12948 WHEN DONE
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
