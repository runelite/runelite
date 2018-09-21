package net.runelite.client.plugins.oddsoverlay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class OddsOverlay extends Overlay {


    private final PanelComponent statsPanel = new PanelComponent();
    private OddsPlugin plugin;
    private Client client;

    @Inject
    public OddsOverlay(Client client, OddsPlugin plugin) {
        this.plugin = plugin;
        this.client = client;
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        setPriority(OverlayPriority.HIGHEST);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
    }

    @Override
    public Dimension render(Graphics2D graphics) {

        if (plugin.getResult() != null) {
            statsPanel.getChildren().clear();
            statsPanel.setPreferredSize(new Dimension(150, 100));
            statsPanel.getChildren().add(TitleComponent.builder().text(plugin.getResult().getPlayer()).build());

            for (Skill skill : plugin.getTheirSkillMap().keySet()) {
                statsPanel.getChildren().add(LineComponent.builder().left(skill.getName()).rightColor(getColor(skill)).right(String.valueOf(plugin.getTheirSkillMap().get(skill))).build());
            }
            statsPanel.getChildren().add(LineComponent.builder().left("Melee Odds").right(String.format("%.2f", plugin.getMeleeOdds())).build());
            statsPanel.getChildren().add(LineComponent.builder().left("Ranged Odds").right(String.format("%.2f", plugin.getRangedOdds())).build());

            statsPanel.render(graphics);
        }

        return null;
    }

    private Color getColor(Skill skill) {
        if (client.getRealSkillLevel(skill) > plugin.getTheirSkillMap().get(skill))
            return Color.GREEN;
        if (client.getRealSkillLevel(skill) < plugin.getTheirSkillMap().get(skill))
            return Color.RED;
        return Color.YELLOW;
    }

}
