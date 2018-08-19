/*
 * Copyright (c) 2018, Benjamin <benwhitehead21@gmail.com>
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

package net.runelite.client.plugins.fletching;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.inject.Inject;
import static net.runelite.api.AnimationID.FLETCHING_BOW_CUTTING;
import static net.runelite.api.AnimationID.FLETCHING_STRING_NORMAL_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_OAK_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_WILLOW_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_MAPLE_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_YEW_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_MAGIC_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_NORMAL_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_OAK_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_WILLOW_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_MAPLE_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_YEW_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_MAGIC_LONGBOW;

public class FletchingOverlay extends Overlay
{

    private final Client client;
    private final FletchingPlugin plugin;
    private final FletchingConfig config;
    private final XpTrackerService xpTrackerService;

    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    public FletchingOverlay(Client client, FletchingPlugin plugin, FletchingConfig config, XpTrackerService xpTrackerService)
    {
        setPosition(OverlayPosition.TOP_LEFT);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        this.xpTrackerService = xpTrackerService;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (plugin.getSession() == null && isPlayerFletching(client.getLocalPlayer().getAnimation()))
        {
            plugin.setSession(new FletchingSession());
            plugin.getSession().setLastFletchedItem();
        }

        if (plugin.getSession() == null)
        {
            return null;
        }

        panelComponent.getChildren().clear();
        boolean fletching = isPlayerFletching(client.getLocalPlayer().getAnimation());
        if (fletching)
        {
            panelComponent.getChildren().add(TitleComponent.builder()
                    .text("Fletching")
                    .color(Color.GREEN)
                    .build());
        }
        else
        {
            panelComponent.getChildren().add(TitleComponent.builder()
                    .text("NOT fletching")
                    .color(Color.RED)
                    .build());
        }
        if (config.enableTotalActions())
        {
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Items made:")
                    .right(String.valueOf(xpTrackerService.getActions(Skill.FLETCHING)))
                    .build());
        }
        if (config.enableActionsPerHour())
        {
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Items/hr:")
                    .right(String.valueOf(xpTrackerService.getActionsHr(Skill.FLETCHING)))
                    .build());
        }
        return panelComponent.render(graphics);
    }

    public boolean isPlayerFletching(int animationID)
    {
        switch (animationID)
        {
            case FLETCHING_BOW_CUTTING: return true;
            case FLETCHING_STRING_NORMAL_SHORTBOW: return true;
            case FLETCHING_STRING_OAK_SHORTBOW: return true;
            case FLETCHING_STRING_WILLOW_SHORTBOW: return true;
            case FLETCHING_STRING_MAPLE_SHORTBOW: return true;
            case FLETCHING_STRING_YEW_SHORTBOW: return true;
            case FLETCHING_STRING_MAGIC_SHORTBOW: return true;
            case FLETCHING_STRING_NORMAL_LONGBOW: return true;
            case FLETCHING_STRING_OAK_LONGBOW: return true;
            case FLETCHING_STRING_WILLOW_LONGBOW: return true;
            case FLETCHING_STRING_MAPLE_LONGBOW: return true;
            case FLETCHING_STRING_YEW_LONGBOW: return true;
            case FLETCHING_STRING_MAGIC_LONGBOW: return true;
        }
        return false;
    }
}
