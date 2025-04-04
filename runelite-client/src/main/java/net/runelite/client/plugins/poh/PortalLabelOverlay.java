/*
 * Copyright (c) 2020, Nick <WendlerTech@gmail.com>
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
package net.runelite.client.plugins.poh;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.*;

public class PortalLabelOverlay extends Overlay
{

    private final Client client;
    private final PohConfig config;
    private final PohPlugin plugin;

    @Inject
    private PortalLabelOverlay(Client client, PohConfig config, PohPlugin plugin)
    {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.client = client;
        this.config = config;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!config.showPortalLabels())
        {
            return null;
        }

        plugin.getPortals().forEach((tile, portal) -> {
            if (tile.getPlane() != client.getPlane())
            {
                return;
            }

            ObjectComposition portalObject = client.getObjectDefinition(portal.getPortalId());
            String portalName = portalObject.getName();
            if (portalName.equals("") || portalName.equals("null"))
            {
                //These portals (the ones with configurable locations thanks to diaries) don't show up under ObjectID.
                switch (portalObject.getId()) {
                    case NullObjectID.NULL_13620:
                        portalName = "Yanille / Watchtower";
                        break;
                    case NullObjectID.NULL_13615:
                        portalName = "Varrock / Grand Exchange";
                        break;
                    case NullObjectID.NULL_13618:
                        portalName = "Camelot / Seers";
                        break;
                }
            }

            Point canvasTextLocation = Perspective.getCanvasTextLocation(client, graphics,
                    new LocalPoint(portal.getLocalPoint().getX(), portal.getLocalPoint().getY()), portalName, 0);
            if (canvasTextLocation != null)
            {
                OverlayUtil.renderTextLocation(graphics, canvasTextLocation, portalName, Color.WHITE);
            }
        });

        return null;
    }
}
