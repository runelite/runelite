/*
 * Copyright (c) 2019, lyzrds <https://discord.gg/5eb9Fe>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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

/*
package net.runelite.client.plugins.coxhelper;

import java.awt.*;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Singleton
public class CoxDebugBox extends Overlay
{
    private final Client client;
    private final CoxPlugin plugin;
    private final CoxConfig config;
    private final Olm olm;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    CoxDebugBox(Client client, CoxPlugin plugin, CoxConfig config, Olm olm)
    {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        this.olm = olm;
        this.setPosition(OverlayPosition.BOTTOM_LEFT);
        this.determineLayer();
        this.setPriority(OverlayPriority.HIGH);
        this.panelComponent.setPreferredSize(new Dimension(270, 0));
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!this.config.olmDebug() || !plugin.inRaid())
        {
            return null;
        }

        this.panelComponent.getChildren().clear();
        panelComponent.getChildren().add(TitleComponent.builder()
        .text("Here are the values").color(Color.GREEN).build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("ticks")
                .right(String.valueOf(client.getTickCount()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("active")
                .right(String.valueOf(client.getTickCount()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("handAnim")
                .right(String.valueOf(this.olm.getHandAnimation()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("headAnim")
                .right(String.valueOf(this.olm.isFirstPhase()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("firstPhase")
                .right(String.valueOf(this.olm.isFirstPhase()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("finalPhase")
                .right(String.valueOf(this.olm.isFinalPhase()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("attackTicks")
                .right(String.valueOf(this.olm.getTicksUntilNextAttack()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("attackCycle")
                .right(String.valueOf(this.olm.getAttackCycle()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("specialCycle")
                .right(String.valueOf(this.olm.getSpecialCycle()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("portalTicks")
                .right(String.valueOf(this.olm.getPortalTicks()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("handCrippled")
                .right(String.valueOf(this.olm.isCrippled()))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("crippleTicks")
                .right(String.valueOf(this.olm.getCrippleTicks()))
                .build());

        return this.panelComponent.render(graphics);
    }


    public void determineLayer()
    {
        if (this.config.mirrorMode())
        {
            this.setLayer(OverlayLayer.ALWAYS_ON_TOP);
        }
    }
}*/