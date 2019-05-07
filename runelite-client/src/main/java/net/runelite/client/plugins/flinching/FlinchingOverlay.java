/*
 * Copyright (c) 2018, Fluffeh <berserkfluff@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.flinching;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
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

        Point loc = Perspective.localToCanvas(client, localLoc, client.getPlane());

        ProgressPieComponent pie = new ProgressPieComponent();
        pie.setDiameter(overlaySize);
        pie.setFill(color);
        pie.setBorderColor(borderColor);
        pie.setPosition(loc);
        pie.setProgress(fillAmount);
        pie.render(graphics);
    }
}