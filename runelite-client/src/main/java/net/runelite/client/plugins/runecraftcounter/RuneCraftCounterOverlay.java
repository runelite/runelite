/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.runecraftcounter;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;


@SuppressWarnings("ALL")
public class RuneCraftCounterOverlay extends Overlay
{
    private final RuneCraftCounterPlugin plugin;
    private final RuneCraftCounterSession session;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    public RuneCraftCounterOverlay(RuneCraftCounterPlugin plugin, RuneCraftCounterSession session)
    {
        super(plugin);
        setPosition(OverlayPosition.TOP_LEFT);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.plugin = plugin;
        this.session = session;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();

        panelComponent.getChildren().add(TitleComponent.builder()
            .text("Runecraft Counter")
            .color(Color.ORANGE)
            .build());

        panelComponent.getChildren().add(LineComponent.builder()
            .left("Fire: ").right(Integer.toString(session.getFireRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Water: ").right(Integer.toString(session.getWaterRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Air: ").right(Integer.toString(session.getAirRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Earth: ").right(Integer.toString(session.getEarthRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Mind: ").right(Integer.toString(session.getMindRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Body: ").right(Integer.toString(session.getBodyRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Death: ").right(Integer.toString(session.getDeathRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Nature: ").right(Integer.toString(session.getNatureRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Chaos: ").right(Integer.toString(session.getChaosRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Law: ").right(Integer.toString(session.getLawRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Cosmic: ").right(Integer.toString(session.getCosmicRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Blood: ").right(Integer.toString(session.getBloodRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Soul: ").right(Integer.toString(session.getSoulRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Astral: ").right(Integer.toString(session.getAstralRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Wrath: ").right(Integer.toString(session.getWrathRuneCrafted())).build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left(" ").right(" ").build());
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Total Crafted: ").right(Integer.toString(session.getTotalCrafted())).build());

        return panelComponent.render(graphics);
    }
}
