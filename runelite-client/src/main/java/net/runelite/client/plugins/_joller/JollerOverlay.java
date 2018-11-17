package net.runelite.client.plugins._joller;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

public class JollerOverlay extends Overlay {

    private final PanelComponent panelComponent = new PanelComponent();
    private final Client client;

    @Inject
    private JollerOverlay(Client client) {
        this.client = client;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (text.equals("Lol")) {
            panelComponent.getChildren().add(TitleComponent.builder()
                    .text("Lol")
                    .color(Color.GREEN)
                    .build());
        } else {

            panelComponent.getChildren().clear();
            panelComponent.getChildren().add(TitleComponent.builder()
                    .text("NICE")
                    .color(Color.GREEN)
                    .build());
        }
        return panelComponent.render(graphics);
    }

    private String text = "";

    public void setText(String s) {
        text = s;
    }
}
