package net.runelite.client.plugins.runecraftcounter;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

public class RuneCraftCounterOverlay extends Overlay {

    private final RuneCraftCounterPlugin plugin;
    private final RuneCraftCounterSession session;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    public RuneCraftCounterOverlay(RuneCraftCounterPlugin plugin, RuneCraftCounterSession session) {
        super(plugin);
        setPosition(OverlayPosition.TOP_LEFT);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.plugin = plugin;
        this.session = session;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        panelComponent.getChildren().clear();

        panelComponent.getChildren().add(TitleComponent.builder()
            .text("Runecraft Counter")
            .color(Color.ORANGE)
            .build());

        panelComponent.getChildren().add(LineComponent.builder()
            .left("Fire: ").right(Integer.toString(session.getFireRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Water: ").right(Integer.toString(session.getWaterRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Air: ").right(Integer.toString(session.getAirRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Earth: ").right(Integer.toString(session.getEarthRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Mind: ").right(Integer.toString(session.getMindRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Body: ").right(Integer.toString(session.getBodyRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Death: ").right(Integer.toString(session.getDeathRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Nature: ").right(Integer.toString(session.getNatureRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Chaos: ").right(Integer.toString(session.getChaosRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Law: ").right(Integer.toString(session.getLawRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Cosmic: ").right(Integer.toString(session.getCosmicRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Blood: ").right(Integer.toString(session.getBloodRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Soul: ").right(Integer.toString(session.getSoulRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Astral: ").right(Integer.toString(session.getAstralRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Wrath: ").right(Integer.toString(session.getWrathRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left(" ").right(" ").build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Total Crafted: ").right(Integer.toString(session.getTotalCrafted())).build());

        return panelComponent.render(graphics);
    }
}
