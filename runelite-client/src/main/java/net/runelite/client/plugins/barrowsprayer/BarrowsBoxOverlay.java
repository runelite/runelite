package net.runelite.client.plugins.barrowsprayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class BarrowsBoxOverlay extends Overlay {
    private final Client client;
    private final BarrowsPrayerConfig config;
    private final BarrowsPrayerPlugin plugin;
    private final PanelComponent panelComponent = new PanelComponent();
    private String isAttack = "";

    @Inject
    private BarrowsBoxOverlay(Client client, BarrowsPrayerConfig config, BarrowsPrayerPlugin plugin) {
        this.plugin = plugin;
        this.client = client;
        this.config = config;
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        //setPosition(OverlayPosition.DYNAMIC);
        //setLayer(OverlayLayer.ABOVE_SCENE);
        //setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        panelComponent.getChildren().clear();
        String overlayTitle = plugin.brotherName;
        panelComponent.getChildren().add(TitleComponent.builder()
                .text(overlayTitle).color(Color.GREEN)
                .build());
        panelComponent.setPreferredSize(new Dimension(graphics.getFontMetrics()
                .stringWidth(overlayTitle)+100,0));
        panelComponent.getChildren().add(LineComponent.builder().left("count:").right(Integer.toString(plugin.tickCounter)).build());
        panelComponent.getChildren().add(LineComponent.builder().left("Speed:").right(Integer.toString(plugin.npcAttkSpeed)).build());

        if (!plugin.getInCombat()) {
            isAttack = "not_in_combat";
        } else {
            if (plugin.getRenderNpcTile()) {
                //System.out.println("rendering");
                isAttack = "attacking";
            } else {
                isAttack = "waiting";
            }
        }
        //panelComponent.getChildren().add(LineComponent.builder().left(isAttack).right("").build());


        return panelComponent.render((graphics));
    }
}