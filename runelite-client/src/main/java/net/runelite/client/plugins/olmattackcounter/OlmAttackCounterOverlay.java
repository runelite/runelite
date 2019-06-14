package net.runelite.client.plugins.olmattackcounter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.Duration;
import javax.inject.Inject;
import static net.runelite.api.AnimationID.COOKING_FIRE;
import static net.runelite.api.AnimationID.COOKING_RANGE;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Skill;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;


class OlmAttackCounterOverlay extends Overlay
{
    private final Client client;
    private final PanelComponent panelComponent = new PanelComponent();
    private final OlmAttackCounterPlugin plugin;
    private static final int OLM_PLANE = 0;

    @Inject
    private OlmAttackCounterOverlay(Client client, OlmAttackCounterPlugin plugin)
    {
        super(plugin);
        setPosition(OverlayPosition.TOP_LEFT);
        this.client = client;
        this.plugin = plugin;
        getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Olm Attack Counter overlay"));
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        OlmSession session = plugin.getSession();
        if (session == null) {
            return null;
        }

        panelComponent.getChildren().clear();

        //if (client.getPlane() == OLM_PLANE) {
            panelComponent.getChildren().add(TitleComponent.builder()
                .text("Olm Attack Counter")
                .build());


            panelComponent.getChildren().add(LineComponent.builder()
                .left("Range Counter:")
                .right(session.getRangeCounter() + "")
                .build());


            panelComponent.getChildren().add(LineComponent.builder()
                .left("Mage Counter:")
                .right(session.getMageCounter() + "")
                .build());

            panelComponent.getChildren().add(LineComponent.builder()
                .left("Drip Counter:")
                .right(session.getAcidDripCounter() + "")
                .build());

            panelComponent.getChildren().add(LineComponent.builder()
                .left("Spray Counter:")
                .right(session.getAcidSprayCounter() + "")
                .build());

            panelComponent.getChildren().add(LineComponent.builder()
                .left("Wall Counter:")
                .right(session.getFlameWallCounter() + "")
                .build());

            panelComponent.getChildren().add(LineComponent.builder()
                .left("Burn Counter:")
                .right(session.getBurnCounter() + "")
                .build());

            panelComponent.getChildren().add(LineComponent.builder()
                .left("Fall Counter:")
                .right(session.getFallingCrystalCounter() + "")
                .build());

            panelComponent.getChildren().add(LineComponent.builder()
                .left("Bomb Counter:")
                .right(session.getBombCounter() + "")
                .build());

            panelComponent.getChildren().add(LineComponent.builder()
                .left("Smite Counter:")
                .right(session.getSmiteCounter() + "")
                .build());
        //}

        return panelComponent.render(graphics);

    }
}
