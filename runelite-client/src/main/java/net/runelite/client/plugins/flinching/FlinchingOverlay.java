package net.runelite.client.plugins.Flinching;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

public class FlinchingOverlay extends Overlay
{
    private final Client client;
    private final FlinchingPlugin plugin;
    private final FlinchingConfig config;

    private Color color;
    private Color borderColor;

    private int overlaySize = 25;

    @Inject
    FlinchingOverlay(Client client, FlinchingPlugin plugin, FlinchingConfig config)
    {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.plugin = plugin;
        this.config = config;
        this.client = client;

        overlaySize = this.config.getFlinchOverlaySize();
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        drawOverlays(graphics);
        return null;
    }

    public void updateConfig()
    {
        borderColor = config.getFlinchOverlayColor();
        color = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), 100);

        overlaySize = config.getFlinchOverlaySize();
    }

    private void drawOverlays(Graphics2D graphics)
    {
        for (Map.Entry<Integer, FlinchingTarget> entry : plugin.GetTargets().entrySet())
        {
            FlinchingTarget target = entry.getValue();

            drawFlinchTimer(graphics, target.worldLocation, target.GetRemainingTimePercent());
        }
    }

    private void drawFlinchTimer(Graphics2D graphics, WorldPoint targetLocation, double fillAmount)
    {
        if (targetLocation.getPlane() != client.getPlane())
        {
            return;
        }

        LocalPoint localLoc = LocalPoint.fromWorld(client, targetLocation);
        if (localLoc == null)
        {
            return;
        }

        net.runelite.api.Point loc = Perspective.localToCanvas(client, localLoc, client.getPlane());

        ProgressPieComponent pie = new ProgressPieComponent();
        pie.setDiameter(overlaySize);
        pie.setFill(color);
        pie.setBorderColor(borderColor);
        pie.setPosition(loc);
        pie.setProgress(fillAmount);
        pie.render(graphics);
    }
}