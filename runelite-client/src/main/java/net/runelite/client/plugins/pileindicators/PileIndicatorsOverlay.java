/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.pileindicators;

import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.client.plugins.playerindicators.PlayerIndicatorsService;
import net.runelite.client.ui.overlay.*;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;

public class PileIndicatorsOverlay extends Overlay
{

	private final Client client;
	private final PileIndicatorsPlugin plugin;
	private final PileIndicatorsConfig config;
	private final PlayerIndicatorsService playerIndicatorsService;

	@Inject
	PileIndicatorsOverlay(final Client client, final PileIndicatorsPlugin plugin, final PileIndicatorsConfig config, PlayerIndicatorsService playerIndicatorsService)
	{
		super(plugin);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.playerIndicatorsService = playerIndicatorsService;

		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		ArrayList<ArrayList<Actor>> stackList = plugin.getStacks();
		if (config.drawPileHull())
		{
			playerIndicatorsService.forEachPlayer((player, color) ->
			{
				if (plugin.isPile(player))
				{
					Polygon objectClickbox = player.getConvexHull();

					renderPoly(graphics, config.playerPileColor(), objectClickbox);
				}
			});
		}
		if (stackList != null)
		{
			for (ArrayList<Actor> actorArrayList : stackList)
			{
				PileType pileType = plugin.getPileType(actorArrayList);
				Color pileColor = plugin.getColorByPileType(pileType);

				try 
				{
					Actor actorToRender = actorArrayList.get(0); //guaranteed to have at least two players
					final String text;
					if (config.numberOnly())
					{
						text = "" + actorArrayList.size();
					}
					else
					{
						text = "PILE SIZE: " + actorArrayList.size();
					}

					OverlayUtil.renderPolygon(graphics, actorToRender.getCanvasTilePoly(), pileColor);
					OverlayUtil.renderTextLocation(graphics, actorToRender.getCanvasTextLocation(graphics, text, 40), text, pileColor);
				} 
				catch (Exception ignored)
				{
				}
			}
		}

		return null;
	}

	private void renderPoly(Graphics2D graphics, Color color, Polygon polygon)
	{
		if (polygon != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.draw(polygon);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
			graphics.fill(polygon);
		}
	}

}
