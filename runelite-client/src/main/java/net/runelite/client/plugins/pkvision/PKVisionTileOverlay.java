package net.runelite.client.plugins.pkvision;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class PKVisionTileOverlay extends Overlay
{
    private final PKVisionService pkVisionService;
    private final PKVisionConfig config;

    @Inject
    private PKVisionTileOverlay(PKVisionConfig config, PKVisionService pkVisionService)
    {
        this.config = config;
        this.pkVisionService = pkVisionService;
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!config.drawTiles())
            return null;

        pkVisionService.forEachPlayer((player, color) ->
        {
            final Polygon poly = player.getCanvasTilePoly();

            if (poly != null)
                OverlayUtil.renderPolygon(graphics, poly, color);
        });

        return null;
    }
}
