/*
 * Copyright (c) 2018, Kamiel <https://github.com/Kamielvf>
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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.party.PartyService;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class PlayerIndicatorsTileOverlay extends Overlay
{
	private final PlayerIndicatorsService playerIndicatorsService;
	private final PlayerIndicatorsConfig config;
	private final Client client;
	private final PartyService partyService;

	@Inject
	private PlayerIndicatorsTileOverlay(Client client, PlayerIndicatorsConfig config, PlayerIndicatorsService playerIndicatorsService, PartyService partyService)
	{
		this.client = client;
		this.config = config;
		this.playerIndicatorsService = playerIndicatorsService;
		this.partyService = partyService;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(PRIORITY_MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		playerIndicatorsService.forEachPlayer((player, decorations) ->
		{
			if (config.drawTiles())
			{
				final Polygon poly = player.getCanvasTilePoly();

				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, decorations.getColor());
				}
			}

			// Only consider true tile for party members
			if (config.partyDrawTrueTile() && (partyService.isInParty() && partyService.getMemberByDisplayName(player.getName()) != null))
			{
				final LocalPoint lp = LocalPoint.fromWorld(client.getTopLevelWorldView(), player.getWorldLocation());
				if (lp != null)
				{
					final Polygon poly = Perspective.getCanvasTilePoly(client, lp);
					if (poly != null)
					{
						OverlayUtil.renderPolygon(graphics, poly, decorations.getColor());
					}
				}
			}
		});

		return null;
	}
}
