/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.freezetimers;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class FreezeTimersTileOverlay extends Overlay
{
    private final FreezeTimersService FreezeTimersService;
    private final FreezeTimersConfig config;

    @Inject
    private FreezeTimersTileOverlay(FreezeTimersConfig config, FreezeTimersService FreezeTimersService)
    {
        this.config = config;
        this.FreezeTimersService = FreezeTimersService;
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!config.drawTiles())
        {
            return null;
        }

        FreezeTimersService.forEachPlayer((player, color) ->
        {
            final Polygon poly = player.getCanvasTilePoly();

            if (poly != null)
            {
                OverlayUtil.renderPolygon(graphics, poly, color);
            }
        });

        return null;
    }
}
