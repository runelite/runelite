package net.runelite.client.plugins.distractionreducer;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DistractionReducerOverlay extends Overlay {
    private final DistractionReducerConfig config;
    private final Client client;
    private boolean renderOverlay = false;

    @Inject
    private DistractionReducerOverlay(DistractionReducerConfig config, Client client) {
        this.config = config;
        this.client = client;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!renderOverlay) {
            return null;
        }

        Color color = config.overlayColor();
        graphics.setColor(color);
        graphics.fillRect(0, 0, client.getCanvasWidth(), client.getCanvasHeight());

        return new Dimension(client.getCanvasWidth(), client.getCanvasHeight());
    }

    public void setRenderOverlay(boolean render) {
        this.renderOverlay = render;
        log.debug("Overlay rendering set to: {}", render);
    }
}