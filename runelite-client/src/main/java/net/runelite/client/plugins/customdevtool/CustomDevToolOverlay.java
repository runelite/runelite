package net.runelite.client.plugins.customdevtool;

import net.runelite.client.ui.overlay.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.AgilityShortcut;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.plugins.Plugin;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

class CustomDevToolOverlay extends Overlay {


    private final Client client;
    private final CustomDevToolConfig config;
    private final CustomDevToolPlugin plugin;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private CustomDevToolOverlay(Client client, CustomDevToolPlugin plugin, CustomDevToolConfig config){
        super(plugin);
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        this.client = client;
        this.config = config;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics){
        panelComponent.getChildren().clear();
        String overlayTitle = "Animation ID:";

        //overlay title
        panelComponent.getChildren().add(TitleComponent.builder()
                                    .text(overlayTitle).color(Color.GREEN)
                                    .build());

        //set width of overlay
        panelComponent.setPreferredSize(new Dimension(graphics.getFontMetrics()
                                                            .stringWidth(overlayTitle)+80,0));

        //add line for the sake of it
        panelComponent.getChildren().add(LineComponent.builder().left("AnimationID:").right(Integer.toString(plugin.animationID)).build());

        //add line for graphic
        panelComponent.getChildren().add(LineComponent.builder().left("TargetAnimationID:").right(Integer.toString(plugin.targetAnimation)).build());

        panelComponent.getChildren().add(LineComponent.builder().left("NpcID:").right(Integer.toString(plugin.targetID)).build());

        //line for game tick
        panelComponent.getChildren().add(LineComponent.builder().left("Tick:").right(Integer.toString(plugin.tickCount)).build());

        //return null;
        return panelComponent.render(graphics);
    }

}
