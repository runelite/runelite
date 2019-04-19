package net.runelite.client.plugins.freezetimers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import net.runelite.api.Player;
import net.runelite.client.plugins.freezetimers.FreezeTimersConfig;
import net.runelite.client.plugins.freezetimers.FreezeTimersService;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class FreezeTimersTileOverlay
extends Overlay {
    private final FreezeTimersService FreezeTimersService;
    private final FreezeTimersConfig config;

    @Inject
    private FreezeTimersTileOverlay(FreezeTimersConfig config, FreezeTimersService FreezeTimersService2) {
        this.config = config;
        this.FreezeTimersService = FreezeTimersService2;
        this.setLayer(OverlayLayer.ABOVE_SCENE);
        this.setPosition(OverlayPosition.DYNAMIC);
        this.setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!this.config.drawTiles()) {
            return null;
        }
        this.FreezeTimersService.forEachPlayer((player, color) -> {
            Polygon poly = player.getCanvasTilePoly();
            if (poly != null) {
                OverlayUtil.renderPolygon(graphics, poly, color);
            }
        });
        return null;
    }
}

