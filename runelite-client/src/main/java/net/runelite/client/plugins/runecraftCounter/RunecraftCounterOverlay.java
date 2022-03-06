package net.runelite.client.plugins.runecraftCounter;

import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RunecraftCounterOverlay extends Overlay
{
    private final Client client;
    private final RunecraftCounterSession session;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    public RunecraftCounterOverlay(Client client, RunecraftCounterSession session)
    {
        setPosition(OverlayPosition.TOP_LEFT);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.client = client;
        this.session = session;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if(isRunecrafting()) {
            panelComponent.getChildren().clear();

            panelComponent.getChildren().add(TitleComponent.builder()
                    .text("Runecraft Counter")
                    .color(Color.ORANGE)
                    .build());

            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Chaos: ").right(Integer.toString(session.getChaosRuneCrafted())).build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Cosmic: ").right(Integer.toString(session.getCosmicRuneCrafted())).build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Death: ").right(Integer.toString(session.getDeathRuneCrafted())).build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Nature: ").right(Integer.toString(session.getNatureRuneCrafted())).build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Law: ").right(Integer.toString(session.getLawRuneCrafted())).build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Astral: ").right(Integer.toString(session.getAstralRuneCrafted())).build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Wrath: ").right(Integer.toString(session.getWrathRuneCrafted())).build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left(" ").right(" ").build());

            return panelComponent.render(graphics);
        }

        return null;
    }

    public boolean isRunecrafting() {
        try {
            Set<Item> inventory = new HashSet<>(Arrays.asList(
                    client.getItemContainer(InventoryID.INVENTORY).getItems()
            ));

            return inventory.stream().anyMatch(
                    i -> i.getId() == ItemID.SMALL_POUCH ||
                            i.getId() == ItemID.MEDIUM_POUCH ||
                            i.getId() == ItemID.LARGE_POUCH ||
                            i.getId() == ItemID.GIANT_POUCH);
        } catch (NullPointerException e) {
            return false;
        }
    }
}