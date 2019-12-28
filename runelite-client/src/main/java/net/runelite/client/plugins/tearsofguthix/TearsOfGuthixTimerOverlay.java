/*
 * Copyright (c) 2019, hiwilliam36 <https://github.com/hiwilliam36>
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

package net.runelite.client.plugins.tearsofguthix;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;

public class TearsOfGuthixTimerOverlay extends Overlay {

    @Inject
    private PanelComponent panelComponent = new PanelComponent();

    @Inject
    private Client client;

    @Inject
    private TearsOfGuthixTimer tearsOfGuthixTimer;

    @Inject
    private TearsOfGuthixConfig config;

    @Inject
    private TearsOfGuthixTimerOverlay(Client client, TearsOfGuthixPlugin plugin)
    {
        super(plugin);
        setPosition(OverlayPosition.BOTTOM_LEFT);
        this.client = client;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        String time = tearsOfGuthixTimer.getTime();
        // make sure player player is in region or check if timer is over
        if(!config.time() || time.equals("-1") || client.getLocalPlayer().getWorldLocation().getRegionID() != 12948 && client.getLocalPlayer().getWorldLocation().getX() >= 3254 && client.getLocalPlayer().getWorldLocation().getX() <= 3262)
        {
            return null;
        }
        panelComponent.getChildren().clear();
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Time Left: ")
            .right(time)
            .build());
        return panelComponent.render(graphics);
    }

}
