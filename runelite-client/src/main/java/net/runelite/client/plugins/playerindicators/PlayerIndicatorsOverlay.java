/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.game.ClanManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.Text;

@Singleton
public class PlayerIndicatorsOverlay extends Overlay
{
	private static final int ACTOR_OVERHEAD_TEXT_MARGIN = 40;
	private static final int ACTOR_HORIZONTAL_TEXT_MARGIN = 10;

	private final PlayerIndicatorsService playerIndicatorsService;
	private final PlayerIndicatorsConfig config;
	private final ClanManager clanManager;

	@Inject
	private PlayerIndicatorsOverlay(PlayerIndicatorsConfig config, PlayerIndicatorsService playerIndicatorsService,
		ClanManager clanManager)
	{
		this.config = config;
		this.playerIndicatorsService = playerIndicatorsService;
		this.clanManager = clanManager;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		playerIndicatorsService.forEachPlayer((player, color) -> renderPlayerOverlay(graphics, player, color));
		return null;
	}

	private void renderPlayerOverlay(Graphics2D graphics, Player actor, Color color)
	{
		final PlayerNameLocation drawPlayerNamesConfig = config.playerNamePosition();
		if (drawPlayerNamesConfig == PlayerNameLocation.DISABLED)
		{
			return;
		}

		final int zOffset;
		switch (drawPlayerNamesConfig)
		{
			case MODEL_CENTER:
			case MODEL_RIGHT:
				zOffset = actor.getLogicalHeight() / 2;
				break;
			default:
				zOffset = actor.getLogicalHeight() + ACTOR_OVERHEAD_TEXT_MARGIN;
		}

		final String name = Text.sanitize(actor.getName());
		Point textLocation = actor.getCanvasTextLocation(graphics, name, zOffset);

		if (drawPlayerNamesConfig == PlayerNameLocation.MODEL_RIGHT)
		{
			textLocation = actor.getCanvasTextLocation(graphics, "", zOffset);

			if (textLocation == null)
			{
				return;
			}

			textLocation = new Point(textLocation.getX() + ACTOR_HORIZONTAL_TEXT_MARGIN, textLocation.getY());
		}

		if (textLocation == null)
		{
			return;
		}

		if (config.showClanRanks() && actor.isClanMember())
		{
			final ClanMemberRank rank = clanManager.getRank(name);

			if (rank != ClanMemberRank.UNRANKED)
			{
				final BufferedImage clanchatImage = clanManager.getClanImage(rank);

				if (clanchatImage != null)
				{
					final int clanImageWidth = clanchatImage.getWidth();
					final int clanImageTextMargin;
					final int clanImageNegativeMargin;

					if (drawPlayerNamesConfig == PlayerNameLocation.MODEL_RIGHT)
					{
						clanImageTextMargin = clanImageWidth;
						clanImageNegativeMargin = 0;
					}
					else
					{
						clanImageTextMargin = clanImageWidth / 2;
						clanImageNegativeMargin = clanImageWidth / 2;
					}

					final int textHeight = graphics.getFontMetrics().getHeight() - graphics.getFontMetrics().getMaxDescent();
					final Point imageLocation = new Point(textLocation.getX() - clanImageNegativeMargin - 1, textLocation.getY() - textHeight / 2 - clanchatImage.getHeight() / 2);
					OverlayUtil.renderImageLocation(graphics, imageLocation, clanchatImage);

					// move text
					textLocation = new Point(textLocation.getX() + clanImageTextMargin, textLocation.getY());
				}
			}
		}

		OverlayUtil.renderTextLocation(graphics, textLocation, name, color);
	}
}
