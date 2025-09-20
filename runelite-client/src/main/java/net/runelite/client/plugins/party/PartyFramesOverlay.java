/*
 * Copyright (c) 2025, Corentin Rejaud <https://github.com/crejaud>
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
package net.runelite.client.plugins.party;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.util.Iterator;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.client.party.PartyMember;
import net.runelite.client.party.PartyService;
import net.runelite.client.plugins.party.data.PartyData;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;
import net.runelite.client.ui.overlay.components.SplitComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.ImageUtil;

/**
 * Party frames overlay of all party members excluding the local player.
 *
 * Includes the avatar, display name, health bar and prayer bar.
 */
class PartyFramesOverlay extends Overlay
{
    private static final Color HP_FG = new Color(0, 146, 54, 230);
    private static final Color HP_BG = new Color(102, 15, 16, 230);
    private static final Color PRAY_FG = new Color(0, 149, 151);
    private static final Color PRAY_BG = Color.black;
    private static final Color DEFAULT_AVATAR = new Color (30, 30, 30); 
    private static final Color OVERLAY_BG = new Color(18, 18, 18, 180);
    private static final int AVATAR_WIDTH = 32;
    private static final int AVATAR_HEIGHT = 32;
    private static final String PARTY_TITLE = "Party";

    private final BufferedImage defaultAvatar;
    private final PanelComponent panelComponent;
    private final PartyConfig config;
    private final PartyPluginService partyPluginService;
    private final PartyService partyService;

    @Inject
    PartyFramesOverlay(
        final PartyConfig config,
        final PartyPluginService partyPluginService,
        final PartyService partyService)
    {
        this.panelComponent = new PanelComponent();
        this.config = config;
        this.partyPluginService = partyPluginService;
        this.partyService = partyService;

        panelComponent.setOrientation(ComponentOrientation.VERTICAL);
        setPosition(OverlayPosition.TOP_LEFT);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Party overlay");

        this.defaultAvatar = new BufferedImage(AVATAR_WIDTH, AVATAR_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D defaultAvatarGraphics = this.defaultAvatar.createGraphics();
        defaultAvatarGraphics.setColor(DEFAULT_AVATAR);
        defaultAvatarGraphics.fillRect(0, 0, AVATAR_WIDTH, AVATAR_HEIGHT);
        defaultAvatarGraphics.dispose();
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!this.partyService.isInParty())
        {
            return null;
        }
        if (!this.config.showPartyFramesOverlay())
        {
          return null;
        }
    
        PartyMember localMember = this.partyService.getLocalMember();
        Iterator<PartyMember> otherPartyMembers = this.partyService
          .getMembers()
          .stream()
          .filter(partyMember -> partyMember.getMemberId() != localMember.getMemberId())
          .iterator();
        if (!otherPartyMembers.hasNext())
        {
          return null;
        }

        panelComponent.getChildren().clear();
        panelComponent.setBackgroundColor(OVERLAY_BG);
        panelComponent.getChildren().add(TitleComponent.builder()
            .text(PARTY_TITLE)
            .color(Color.GREEN)
            .build());

        while (otherPartyMembers.hasNext())
        {
            PartyMember partyMember = otherPartyMembers.next();
            PartyData partyData = this.partyPluginService.getPartyData(partyMember.getMemberId());
            if (partyData == null)
            {
                continue;
            }

            SplitComponent memberTitle = SplitComponent.builder()
                .first(new ImageComponent(partyMember.getAvatar() != null ? ImageUtil.resizeImage(partyMember.getAvatar(), AVATAR_WIDTH, AVATAR_HEIGHT) : this.defaultAvatar))
                .second(
                    LineComponent.builder()
                        .left(partyMember.getDisplayName())
                        .leftColor(partyMember.isLoggedIn() ? Color.WHITE : Color.GRAY)
                        .build()
                )
                .orientation(ComponentOrientation.HORIZONTAL)
                .gap(new Point(4, 0))
                .build();
            panelComponent.getChildren().add(memberTitle);

            ProgressBarComponent hpBar = new ProgressBarComponent();
            hpBar.setBackgroundColor(HP_BG);
            hpBar.setForegroundColor(HP_FG);
            hpBar.setValue(partyData.getHitpoints());
            hpBar.setMaximum(partyData.getMaxHitpoints());
            hpBar.setLabelDisplayMode(ProgressBarComponent.LabelDisplayMode.FULL);
            panelComponent.getChildren().add(hpBar);

            ProgressBarComponent prayerBar = new ProgressBarComponent();
            prayerBar.setBackgroundColor(PRAY_BG);
            prayerBar.setForegroundColor(PRAY_FG);
            prayerBar.setValue(partyData.getPrayer());
            prayerBar.setMaximum(partyData.getMaxPrayer());
            prayerBar.setLabelDisplayMode(ProgressBarComponent.LabelDisplayMode.FULL);
            panelComponent.getChildren().add(prayerBar);

            if (otherPartyMembers.hasNext()) {
              // Padding
              panelComponent.getChildren().add(LineComponent.builder().left("").build());
            }
        }

        return panelComponent.render(graphics);
    }
}
