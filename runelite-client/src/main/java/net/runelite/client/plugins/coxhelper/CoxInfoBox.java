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
import java.awt.image.BufferedImage;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.NpcID;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.*;
import net.runelite.client.util.ImageUtil;

@Singleton
public class CoxInfoBox extends Overlay
{
    private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);
    private final CoxPlugin plugin;
    private final CoxConfig config;
    private final Client client;
    private final Olm olm;
    private final SpriteManager spriteManager;
    private final PanelComponent prayAgainstPanel = new PanelComponent();
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    CoxInfoBox(CoxPlugin plugin, CoxConfig config, Client client, Olm olm, SpriteManager spriteManager)
    {
        this.plugin = plugin;
        this.config = config;
        this.client = client;
        this.olm = olm;
        this.spriteManager = spriteManager;
        this.setPosition(OverlayPosition.BOTTOM_RIGHT);
        this.determineLayer();
        this.setPriority(OverlayPriority.HIGH);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        this.panelComponent.getChildren().clear();
        if (this.plugin.inRaid())
        {
            this.prayAgainstPanel.getChildren().clear();

            final Prayer prayer = this.olm.getPrayer();

            if (System.currentTimeMillis() < this.olm.getLastPrayTime() + 120000 && prayer != null && this.config.prayAgainstOlm())
            {
                final int scale = this.config.prayAgainstOlmSize();
                InfoBoxComponent prayComponent = new InfoBoxComponent();
                BufferedImage prayImg = ImageUtil.resizeImage(
                        this.getPrayerImage(this.olm.getPrayer()), scale, scale
                );
                prayComponent.setImage(prayImg);
                prayComponent.setColor(Color.WHITE);
                prayComponent.setBackgroundColor(this.client.isPrayerActive(prayer)
                        ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                        : NOT_ACTIVATED_BACKGROUND_COLOR
                );
                prayComponent.setPreferredSize(new Dimension(scale + 4, scale + 4));
                this.prayAgainstPanel.getChildren().add(prayComponent);

                this.prayAgainstPanel.setPreferredSize(new Dimension(scale + 4, scale + 4));
                this.prayAgainstPanel.setBorder(new Rectangle(0, 0, 0, 0));
                return this.prayAgainstPanel.render(graphics);
            }
            else
            {
                this.olm.setPrayer(null);
            }

            if (this.config.vangHealth() && this.plugin.getVanguards() > 0)
            {
                this.panelComponent.getChildren().add(TitleComponent.builder()
                        .text("Vanguards")
                        .color(Color.pink)
                        .build());
                PanelComponent panelComponent = new PanelComponent();
                panelComponent.getChildren().clear();
                for (NPCContainer npcs : this.plugin.getNpcContainers().values())
                {
                    float percent = (float) npcs.getNpc().getHealthRatio() / npcs.getNpc().getHealthScale() * 100;
                    switch (npcs.getNpc().getId())
                    {
                        case NpcID.VANGUARD_7527:
                            panelComponent.getChildren().add(LineComponent.builder()
                                    .left("Melee")
                                    .leftColor(npcs.getAttackStyle().getColor())
                                    .right(Integer.toString((int) percent))
                                    .rightColor(npcs.getAttackStyle().getColor())
                                    .build());
                            break;
                        case NpcID.VANGUARD_7528:
                            panelComponent.getChildren().add(LineComponent.builder()
                                    .left("Range")
                                    .leftColor(npcs.getAttackStyle().getColor())
                                    .right(Integer.toString((int) percent))
                                    .rightColor(npcs.getAttackStyle().getColor())
                                    .build());
                            break;
                        case NpcID.VANGUARD_7529:
                            panelComponent.getChildren().add(LineComponent.builder()
                                    .left("Mage")
                                    .leftColor(npcs.getAttackStyle().getColor())
                                    .right(Integer.toString((int) percent))
                                    .rightColor(npcs.getAttackStyle().getColor())
                                    .build());
                            break;
                    }
                }
                return this.panelComponent.render(graphics);
            }
        }
        if (Objects.requireNonNull(this.client.getLocalPlayer()).getWorldLocation().getRegionID() == 4919)
        {
            this.olm.setPrayer(null);
        }
        return null;
    }

    private BufferedImage getPrayerImage(Prayer prayer)
    {
        switch (prayer)
        {
            case PROTECT_FROM_MAGIC:
                return this.spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
            case PROTECT_FROM_MELEE:
                return this.spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MELEE, 0);
            case PROTECT_FROM_MISSILES:
                return this.spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
            default:
                return this.spriteManager.getSprite(SpriteID.BARBARIAN_ASSAULT_EAR_ICON, 0);
        }
    }

    public void determineLayer()
    {
        if (this.config.mirrorMode())
        {
            this.setLayer(OverlayLayer.ALWAYS_ON_TOP);
        }
    }
}*/
package net.runelite.client.plugins.coxhelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.*;

import net.runelite.api.Client;
import net.runelite.api.NpcID;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.*;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;

@Singleton
public class CoxInfoBox extends Overlay
{
    private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);
    private final CoxPlugin plugin;
    private final Client client;
    private final SpriteManager spriteManager;
    private final PanelComponent prayAgainstPanel = new PanelComponent();
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    CoxInfoBox(CoxPlugin plugin, Client client, SpriteManager spriteManager)
    {
        this.plugin = plugin;
        this.client = client;
        this.spriteManager = spriteManager;
        setPosition(OverlayPosition.BOTTOM_RIGHT);
        setPriority(OverlayPriority.HIGH);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();
        if (plugin.inRaid())
        {
            prayAgainstPanel.getChildren().clear();

            final PrayAgainst prayAgainst = plugin.getPrayAgainstOlm();

            if (System.currentTimeMillis() < plugin.getLastPrayTime() + 120000 && prayAgainst != null && plugin.isConfigPrayAgainstOlm())
            {
                final int scale = plugin.getPrayAgainstSize();
                InfoBoxComponent prayComponent = new InfoBoxComponent();
                BufferedImage prayImg = ImageUtil.resizeImage(
                        getPrayerImage(plugin.getPrayAgainstOlm()), scale, scale
                );
                prayComponent.setImage(prayImg);
                prayComponent.setColor(Color.WHITE);
                prayComponent.setBackgroundColor(client.isPrayerActive(prayAgainst.getPrayer())
                        ? ComponentConstants.STANDARD_BACKGROUND_COLOR
                        : NOT_ACTIVATED_BACKGROUND_COLOR
                );
                prayComponent.setPreferredSize(new Dimension(scale + 4, scale + 4));
                prayAgainstPanel.getChildren().add(prayComponent);

                prayAgainstPanel.setPreferredSize(new Dimension(scale + 4, scale + 4));
                prayAgainstPanel.setBorder(new Rectangle(0, 0, 0, 0));
                return prayAgainstPanel.render(graphics);
            }
            else
            {
                plugin.setPrayAgainstOlm(null);
            }

            if (plugin.isVangHealth() && plugin.getVanguards() > 0)
            {
                panelComponent.getChildren().add(TitleComponent.builder()
                        .text("Vanguards")
                        .color(Color.pink)
                        .build());

                for (NPCContainer npcs : plugin.getNpcContainer().values())
                {
                    float percent = (float) npcs.getNpc().getHealthRatio() / npcs.getNpc().getHealthScale() * 100;
                    switch (npcs.getNpc().getId())
                    {
                        case NpcID.VANGUARD_7527:
                            panelComponent.getChildren().add(LineComponent.builder()
                                    .left("Melee")
                                    .leftColor(npcs.getAttackStyle().getColor())
                                    .right(Integer.toString((int) percent))
                                    .rightColor(npcs.getAttackStyle().getColor())
                                    .build());
                            break;
                        case NpcID.VANGUARD_7528:
                            panelComponent.getChildren().add(LineComponent.builder()
                                    .left("Range")
                                    .leftColor(npcs.getAttackStyle().getColor())
                                    .right(Integer.toString((int) percent))
                                    .rightColor(npcs.getAttackStyle().getColor())
                                    .build());
                            break;
                        case NpcID.VANGUARD_7529:
                            panelComponent.getChildren().add(LineComponent.builder()
                                    .left("Mage")
                                    .leftColor(npcs.getAttackStyle().getColor())
                                    .right(Integer.toString((int) percent))
                                    .rightColor(npcs.getAttackStyle().getColor())
                                    .build());
                            break;
                    }
                }


                return panelComponent.render(graphics);
            }
        }
        if (client.getLocalPlayer().getWorldLocation().getRegionID() == 4919)
        {
            plugin.setPrayAgainstOlm(null);
        }
        return null;
    }

    private BufferedImage getPrayerImage(PrayAgainst prayAgainst)
    {
        switch (prayAgainst)
        {
            case MAGIC:
                return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
            case MELEE:
                return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MELEE, 0);
            case RANGED:
                return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
            default:
                return spriteManager.getSprite(SpriteID.BARBARIAN_ASSAULT_EAR_ICON, 0);
        }
    }
}