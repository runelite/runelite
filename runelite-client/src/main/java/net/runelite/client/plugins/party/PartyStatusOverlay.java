/*
 * Copyright (c) 2022, LlemonDuck <napkinorton@gmail.com>
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.gameval.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.party.PartyMember;
import net.runelite.client.party.PartyService;
import net.runelite.client.plugins.party.data.PartyData;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ColorUtil;

@Singleton
class PartyStatusOverlay extends Overlay
{

	private static final Color COLOR_HEALTH_MAX = Color.green;
	private static final Color COLOR_HEALTH_MIN = Color.red;
	private static final Color COLOR_PRAYER = new Color(50, 200, 200);
	private static final Color COLOR_STAMINA = new Color(160, 124, 72);
	private static final Color COLOR_SPEC = new Color(225, 225, 0);
	private static final Font OVERLAY_FONT = FontManager.getRunescapeBoldFont().deriveFont(16f);

	private final Client client;
	private final SpriteManager spriteManager;
	private final PartyConfig config;
	private final PartyService partyService;
	private final PartyPluginService partyPluginService;

	private boolean renderHealth = false;
	private boolean renderPrayer = false;
	private boolean renderStamina = false;
	private boolean renderSpec = false;
	private boolean renderVeng = false;
	private boolean renderSelf = false;

	@Inject
	private PartyStatusOverlay(
		Client client, SpriteManager spriteManager,
		PartyConfig config, PartyService partyService, PartyPluginService partyPluginService
	)
	{
		this.client = client;
		this.spriteManager = spriteManager;
		this.partyService = partyService;
		this.partyPluginService = partyPluginService;
		this.config = config;

		updateConfig();

		setLayer(OverlayLayer.UNDER_WIDGETS);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(PRIORITY_HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!partyService.isInParty())
		{
			return null;
		}

		for (Player player : client.getPlayers())
		{
			if (!renderSelf && player == client.getLocalPlayer())
			{
				continue;
			}

			PartyMember partyMember = findPartyMember(player);
			if (partyMember == null)
			{
				continue;
			}

			PartyData partyData = partyPluginService.getPartyData(partyMember.getMemberId());
			if (partyData == null)
			{
				continue;
			}

			int renderIx = 0;
			graphics.setFont(OVERLAY_FONT);
			if (renderHealth)
			{
				double healthRatio = Math.min(1.0, (double) partyData.getHitpoints() / partyData.getMaxHitpoints());
				Color healthColor = ColorUtil.colorLerp(COLOR_HEALTH_MIN, COLOR_HEALTH_MAX, healthRatio);
				renderPlayerOverlay(graphics, player, String.valueOf(partyData.getHitpoints()), healthColor, renderIx++);
			}
			if (renderPrayer)
			{
				renderPlayerOverlay(graphics, player, String.valueOf(partyData.getPrayer()), COLOR_PRAYER, renderIx++);
			}
			if (renderStamina)
			{
				renderPlayerOverlay(graphics, player, String.valueOf(partyData.getRunEnergy()), COLOR_STAMINA, renderIx++);
			}
			if (renderSpec)
			{
				renderPlayerOverlay(graphics, player, String.valueOf(partyData.getSpecEnergy()), COLOR_SPEC, renderIx);
			}
			if (renderVeng && partyData.isVengeanceActive())
			{
				BufferedImage vengIcon = spriteManager.getSprite(SpriteID.LunarMagicOn.VENGEANCE_OTHER, 0);
				if (vengIcon != null)
				{
					renderPlayerOverlay(graphics, player, vengIcon);
				}
			}
		}

		return null;
	}

	private PartyMember findPartyMember(Player p)
	{
		if (p == null || p.getName() == null)
		{
			return null;
		}

		return partyService.getMemberByDisplayName(p.getName());
	}

	private void renderPlayerOverlay(Graphics2D graphics, Player player, String text, Color color, int renderIx)
	{
		Point point = Perspective.localToCanvas(client, player.getLocalLocation(), client.getPlane(), player.getLogicalHeight());

		if (point != null)
		{
			FontMetrics fm = graphics.getFontMetrics();
			int size = fm.getHeight();
			int zOffset = size * renderIx;

			OverlayUtil.renderTextLocation(
				graphics,
				new Point(point.getX() + size + 5, point.getY() + zOffset),
				text,
				color
			);
		}
	}

	private void renderPlayerOverlay(Graphics2D graphics, Player player, BufferedImage image)
	{
		Point textLocation = player.getCanvasImageLocation(image, player.getLogicalHeight() / 2);
		if (textLocation != null)
		{
			OverlayUtil.renderImageLocation(graphics, textLocation, image);
		}
	}

	void updateConfig()
	{
		this.renderHealth = config.statusOverlayHealth();
		this.renderPrayer = config.statusOverlayPrayer();
		this.renderStamina = config.statusOverlayStamina();
		this.renderSpec = config.statusOverlaySpec();
		this.renderVeng = config.statusOverlayVeng();
		this.renderSelf = config.statusOverlayRenderSelf();
	}
}
