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

    /**
     * Contains the information of the basic overlay background colors
     */
    private final PanelComponent panelComponent = new PanelComponent();
    private static final Color backgroundColor = new Color(70, 61, 50, 156);
    private Color insideStrokeColor = new Color(
            Math.min(255, backgroundColor.getRed() + 20),
            Math.min(255, backgroundColor.getGreen() + 21),
            Math.min(255, backgroundColor.getBlue() + 19),
            255
    );

    private Color warningColor = new Color(231, 73, 0, 100);

    private static final int ATTACKS_BETWEEN_PHASES = 6;

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

        /**
         * Changes the overlay background color if Vorkath
         * attacks with a fireball_aoe attack
         */
        if (plugin.getCurrentProjectile() != null)
            if (plugin.getCurrentProjectile().getId() == ProjectileID.VORKATH_BOMB_AOE)
                panelComponent.setBackgroundColor(Color.RED);
            else
                panelComponent.setBackgroundColor(backgroundColor);

        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Attacks left: ")
                .color(getTextColor())
                .build());

        panelComponent.getChildren().add(TitleComponent.builder()
                .text(Integer.toString(6 - plugin.getAttacksInARow()))
                .build());

        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Next phase: ")
                .color(getTextColor())
                .build());

        panelComponent.getChildren().add(TitleComponent.builder()
                .text(getNextPhaseText())
                .build());

        return panelComponent.render(graphics);
    }

    /**
     * The text to display for the next special phase
     * @return nextPhase
     */
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

    /**
     * The text color, depending on the attacks remaining till the next phase
     * @return color
     */
    private Color getTextColor() {
        Color color = Color.GREEN;
        switch (ATTACKS_BETWEEN_PHASES - plugin.getAttacksInARow()) {
            case 0:
            case 1:
                color = Color.RED;
                break;

            case 2:
            case 3:
                color = Color.ORANGE;
                break;

            default:
                color = Color.GREEN;
                break;
        }

        return color;
    }
}

