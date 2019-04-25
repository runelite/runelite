/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.ztob;

import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.*;

import javax.inject.Inject;
import java.awt.*;

public class VerzikNyloOverlay extends Overlay {

    private final Client client;
    private final TheatrePlugin plugin;
    private final TheatreConfig config;

    @Inject
    private VerzikNyloOverlay(Client client, TheatrePlugin plugin, TheatreConfig config) {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

    public Dimension render(Graphics2D graphics) {

        if (plugin.isRunVerzik()) {
            if (config.NyloTargetOverlay()) {
                if (plugin.getCrabList().size() > 0) {

                    for (NPC npc : plugin.getCrabList()) {
                        if (npc.isDead()) {
                            continue;
                        }
                        String renderText = "";
                        if (npc.getInteracting() != null) {

                            renderText = npc.getInteracting().getName();
                            Point point = npc.getCanvasTextLocation(graphics, npc.getInteracting().getName(), 0);


                            if (npc.getInteracting().getName().toLowerCase().equals(client.getLocalPlayer().getName().toLowerCase())) {
                                point = npc.getCanvasTextLocation(graphics, client.getLocalPlayer().getName(), 0);
                                renderText = "YOU NIGGA RUN!";

                            } else if (npc.getInteracting().getName().toLowerCase().equals("afyy")) {
                                point = npc.getCanvasTextLocation(graphics, "Ricecup", 0);
                                renderText = "Ricecup";
                            }
                            if (renderText.equals("YOU NIGGA RUN!")) {
                                renderTextLocation(graphics, renderText, 12, Font.BOLD, Color.RED, point);
                            } else {
                                renderTextLocation(graphics, renderText, 12, Font.BOLD, Color.GREEN, point);
                            }
                        }

                    }
                }

            }
        }

        return null;
    }

    private void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint) {
        graphics.setFont(new Font("Arial", fontStyle, fontSize));
        if (canvasPoint != null) {
            final Point canvasCenterPoint = new Point(
                    canvasPoint.getX(),
                    canvasPoint.getY());
            final Point canvasCenterPoint_shadow = new Point(
                    canvasPoint.getX() + 1,
                    canvasPoint.getY() + 1);
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
        }
    }
}
