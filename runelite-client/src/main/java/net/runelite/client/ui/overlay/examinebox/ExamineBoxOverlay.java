package net.runelite.client.ui.overlay.examinebox;

import net.runelite.api.Client;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.TooltipComponent;

import javax.inject.Inject;
import java.awt.*;

public class ExamineBoxOverlay extends Overlay
{
    private final ExamineBoxManager examineBoxManager;
    private final RuneLiteConfig runeLiteConfig;

    @Inject
    private ExamineBoxOverlay(ExamineBoxManager examineBoxManager, Client client, final RuneLiteConfig runeLiteConfig){
        this.examineBoxManager = examineBoxManager;
        this.runeLiteConfig = runeLiteConfig;

        setPosition(OverlayPosition.TOOLTIP);
        setPriority(OverlayPriority.HIGHEST);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
    }
    @Override
    public Dimension render(Graphics2D graphics)
    {
        final ExamineBox examineBox = examineBoxManager.getExamineBox();
        if (examineBox == null)
        {
            return null;
        }

        try
        {
            return renderExamine(graphics, examineBox);
        }
        finally
        {
            examineBoxManager.setExamineBox(null);
        }

    }

    private Dimension renderExamine(Graphics2D graphics, ExamineBox examineBox){
        final TooltipComponent tooltipComponent = new TooltipComponent();
        tooltipComponent.setText(examineBox.getText());
        tooltipComponent.setBackgroundColor(runeLiteConfig.overlayBackgroundColor());
        LayoutableRenderableEntity entity = tooltipComponent;
        entity.setPreferredLocation(new Point(examineBox.getX(), examineBox.getY()));
        entity.render(graphics);

        return null;
    }

}
