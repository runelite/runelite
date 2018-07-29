package net.runelite.client.plugins.mining;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import java.awt.*;

public class miningOverlay extends Overlay {

    private final Client client;
    private final miningPlugin plugin;
    private final PanelComponent panelComponent = new PanelComponent();


    @Inject
    private miningOverlay(Client client, miningPlugin plugin)
    {
        setPosition(OverlayPosition.TOP_LEFT);
        this.client = client;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {

        if(!miningPlugin.menuInt)
        {
            return null;
        }
        panelComponent.getChildren().clear();
        if((System.currentTimeMillis() - plugin.getTimeLastMined())/1000 < plugin.getDisplaySinceLastMined()) {

            panelComponent.getChildren().add(TitleComponent.builder()
                    .preferredLocation(new Point(40,200))
                    .text("Mining")
                    .build());


            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Ores mined:")
                    .right(Integer.toString(plugin.getOresMined()))
                    .build());

            return panelComponent.render(graphics);

        } else {
            return null;
        }



    }
    
}
