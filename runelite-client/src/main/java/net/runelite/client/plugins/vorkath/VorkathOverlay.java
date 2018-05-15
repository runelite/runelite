package net.runelite.client.plugins.vorkath;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MapRegionChanged;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VorkathOverlay extends Overlay {

    private final Client client;
    private final VorkathPlugin plugin;
    private final PanelComponent panelComponent = new PanelComponent();

    private LocalPoint fireballProjectileLocation;
    private LocalPoint spiderProjectileLocation;

    private boolean fireballProjectileEnded = true;
    private boolean spiderProjectileEnded = true;

    @Inject
    public VorkathOverlay(Client client, VorkathPlugin plugin) {
        setPosition(OverlayPosition.BOTTOM_LEFT);
        this.client = client;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!plugin.isAtVorkath()) {
            panelComponent.getChildren().clear();
            return null;
        }

        panelComponent.getChildren().clear();

        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Attacks left: ")
                .color(Color.GREEN)
                .build());

        panelComponent.getChildren().add(TitleComponent.builder()
                .text(Integer.toString(6 - plugin.getAttacksInARow()))
                .build());

        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Next phase: ")
                .color(Color.GREEN)
                .build());

        panelComponent.getChildren().add(TitleComponent.builder()
                .text(getNextPhaseText())
                .build());

        return panelComponent.render(graphics);
    }

    private String getNextPhaseText() {
        String nextPhase;
        switch (plugin.getNextPhase()) {
            case -1:
                nextPhase = "Unknown";
                break;

            case 1:
                nextPhase = "Poison Pool";
                break;

            case 2:
                nextPhase = "Zombified Spawn";
                break;

            default:
                nextPhase = "Unknown";
                break;
        }

        return nextPhase;
    }
}

