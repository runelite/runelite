package net.runelite.client.plugins.sorceressgarden;

import java.awt.*;
import javax.inject.Inject;
import javax.swing.*;
import javax.swing.table.TableColumn;

import net.runelite.api.Skill;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class SorceressSqirkOverlay extends OverlayPanel
{
    final SorceressGardenPlugin plugin;

    private final SorceressGardenConfig config;

    private final SorceressSession sorceressSession;

    private final XpTrackerService xpTrackerService;

    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    public SorceressSqirkOverlay(final SorceressGardenPlugin plugin, final SorceressGardenConfig config, final SorceressSession sorceressSession, final XpTrackerService xpTrackerService)
    {
        super(plugin);
        this.plugin = plugin;
        this.config = config;
        this.sorceressSession = sorceressSession;
        this.xpTrackerService = xpTrackerService;
        setPosition(OverlayPosition.TOP_LEFT);
        determineLayer();
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!plugin.isInGarden())
        {
            return null;
        }

        renderGardenStats(graphics);

        renderSqirksStats(graphics);

        return super.render(graphics);
    }

    public void determineLayer()
    {
        setLayer(config.mirrorMode() ? OverlayLayer.ALWAYS_ON_TOP : OverlayLayer.ABOVE_SCENE);
    }

    private void renderGardenStats(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();

        if (!config.showGardenStats())
        {
            return;
        }


        //tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

        int farmingActions = xpTrackerService.getActions(Skill.FARMING);
        if (farmingActions > 0)
        {
            panelComponent.getChildren().add(TitleComponent.builder().text("Sorceress' Garden").build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Sq'irks Picked: ")
                    .right(Integer.toString(xpTrackerService.getActions(Skill.FARMING)))
                    .build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Sq'irks/Hr: ")
                    .right(Integer.toString(xpTrackerService.getActionsHr(Skill.FARMING)))
                    .build());
            //tableComponent.addRow("Sq'irks Picked: ", Integer.toString(xpTrackerService.getActions(Skill.FARMING)));
            //tableComponent.addRow("Sq'irks/Hr: ", Integer.toString(xpTrackerService.getActionsHr(Skill.FARMING)));
        }

        //panelComponent.getChildren().add(tableComponent);
    }

    private void renderSqirksStats(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();

        if (!config.showSqirksStats())
        {
            return;
        }
        SorceressSession session = sorceressSession;

        int winterSqirks = session.getWinterSqirk();
        int springSqirks = session.getSpringSqirk();
        int autumnSqirks = session.getAutumnSqirk();
        int summerSqirks = session.getSummerSqirk();

        if (winterSqirks == 0 && springSqirks == 0 && autumnSqirks == 0 && summerSqirks == 0)
        {
            return;
        }

        panelComponent.getChildren().add(TitleComponent.builder().text("Sq'irks").build());
        if (winterSqirks > 0)
        {
            int xpFromWinter = winterSqirks * 70;
            panelComponent.getChildren().add(LineComponent.builder()
            .left("Winter Sq'irks: ")
            .right(winterSqirks + " (" + xpFromWinter + " XP)")
            .build());
        }
        if (springSqirks > 0)
        {
            double xpFromSpring = springSqirks * 337.5;
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Spring Sq'irks: ")
                    .right(winterSqirks + " (" + springSqirks + " XP)")
                    .build());
        }
        if (autumnSqirks > 0)
        {
            double xpFromAutumn = autumnSqirks * 783.3;
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Autumn Sq'irks: ")
                    .right(winterSqirks + " (" + xpFromAutumn + " XP)")
                    .build());
        }
        if (summerSqirks > 0)
        {
            int xpFromSummer = summerSqirks * 1500;
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Summer Sq'irks: ")
                    .right(winterSqirks + " (" + xpFromSummer + " XP)")
                    .build());
        }
    }

}