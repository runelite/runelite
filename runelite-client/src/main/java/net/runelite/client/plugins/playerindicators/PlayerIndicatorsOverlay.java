/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.playerindicators;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Slf4j
public class PlayerIndicatorsOverlay extends Overlay
{
	private static final Color CYAN = new Color(0, 184, 212);
	private static final Color GREEN = new Color(0, 200, 83);
	private static final Color PURPLE = new Color(170, 0, 255);
	private static final Color RED = new Color(255, 0, 0);

	private final Client client;
	private final PlayerIndicatorsConfig config;

	PlayerIndicatorsOverlay(Client client, PlayerIndicatorsConfig config)
	{
		this.config = config;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (!config.drawOwnName() && !config.drawClanMemberNames()
			&& !config.drawFriendNames() && !config.drawNonClanMemberNames())
		{
			return null;
		}

		for (Player player : client.getPlayers())
		{
			if (player == null || player.getName() == null)
			{
				continue;
			}

			boolean isClanMember = player.isClanMember();

			if (player == client.getLocalPlayer())
			{
				if (config.drawOwnName())
				{
					renderPlayerOverlay(graphics, player, CYAN);
				}
			}
			else if (config.drawFriendNames() && player.isFriend())
			{
				renderPlayerOverlay(graphics, player, GREEN);
			}
			else if (config.drawClanMemberNames() && isClanMember)
			{
				renderPlayerOverlay(graphics, player, PURPLE);
			}
			else if (config.drawNonClanMemberNames() && !isClanMember)
			{
				renderPlayerOverlay(graphics, player, RED);
			}
		}

		return null;
	}

	private void renderPlayerOverlay(Graphics2D graphics, Player actor, Color color)
	{
		if (config.drawTiles())
		{
			Polygon poly = actor.getCanvasTilePoly();
			if (poly != null)
			{
				OverlayUtil.renderPolygon(graphics, poly, color);
			}
		}

		final String name = actor.getName().replace('\u00A0', ' ');
		net.runelite.api.Point textLocation = actor
			.getCanvasTextLocation(graphics, name, actor.getLogicalHeight() + 40);

		if (textLocation != null)
		{
			OverlayUtil.renderTextLocation(graphics, textLocation, name, color);
		}
	}
}
