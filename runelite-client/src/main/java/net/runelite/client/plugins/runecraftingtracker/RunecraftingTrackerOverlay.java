/*
 * Copyright (c) 2018, Henning Berge <henning@henning.tech>
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
package net.runelite.client.plugins.runecraftingtracker;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

class RunecraftingTrackerOverlay extends Overlay {
    private final Client client;
    private final RunecraftingTrackerPlugin plugin;
    private final RunecraftingTrackerConfig config;
    private final XpTrackerService xpTrackerService;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private RunecraftingTrackerOverlay(Client client, RunecraftingTrackerPlugin plugin, RunecraftingTrackerConfig config, XpTrackerService xpTrackerService) {
        setPosition(OverlayPosition.TOP_LEFT);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        this.xpTrackerService = xpTrackerService;
    }

    @Inject
    ItemManager itemManager;

    private int profitMade() {
        int totalprofit = 0;
        for (Rune rune : this.plugin.getRUNES().values()) {
            if(rune.getCrafted() > 0) {
                int gePrice = itemManager.getItemPrice(rune.getId());
                totalprofit += gePrice * rune.getCrafted();

            }
        }
        return totalprofit;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!config.showRunecraftingStats()) {
            return null;
        }


        RunecraftingTrackerSession session = plugin.getSession();
        if (session == null) {
            return null;
        }

        panelComponent.setPreferredSize(new Dimension(180, 0));

        panelComponent.getChildren().clear();


        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Runecrafting stats")
                .color(Color.GREEN)
                .build());


        int actions = xpTrackerService.getActions(Skill.RUNECRAFT);
        if (actions > 0) {
            for (Rune rune : this.plugin.getRUNES().values()) {
                if(rune.getCrafted() > 0) {
                    panelComponent.getChildren().add(LineComponent.builder()
                            .left(rune.getName() + ":")
                            .right(Integer.toString(rune.getCrafted()))
                            .build());
                }
            }
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("")
                    .build());
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Total Crafted:")
                    .right(Integer.toString(this.plugin.getCraftedRunes()))
                    .build());

            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Profit made:")
                    .right(Integer.toString((this.profitMade()) / 1000) + "k")
                    .rightColor(Color.YELLOW)
                    .build());


        }

        return panelComponent.render(graphics);
    }

}