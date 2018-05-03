/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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
package net.runelite.client.plugins.chompyhunting;

import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;
import java.util.Map;

public class ChompyHuntingOverlay extends Overlay
{
	private final Client client;
	private final ChompyHuntingConfig config;
	private final ChompyHuntingPlugin plugin;

	@Inject
	ChompyHuntingOverlay(Client client, ChompyHuntingConfig config, ChompyHuntingPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Map<NPC, Boolean> chompies = plugin.getChompies();
		if (chompies == null)
		{
			return null;
		}
		for (NPC chompy : chompies.keySet())
		{
			renderChompy(graphics, chompy, plugin.isChompyDead(chompy));
		}
		return null;
	}

	private void renderChompy(Graphics2D graphics, NPC actor, boolean isDead)
	{
		Polygon objectTile = actor.getCanvasTilePoly();
		NPCComposition composition = actor.getComposition();
		if (isDead)
		{
			if (objectTile != null && config.highlightDeadChompies())
			{
				graphics.setColor(config.deadChompyColor());
				graphics.setStroke(new BasicStroke(2));
				graphics.draw(objectTile);
				graphics.setColor(new Color(config.deadChompyColor().getRed(), config.deadChompyColor().getGreen(), config.deadChompyColor().getBlue(), 20));
				graphics.fill(objectTile);
			}
		}
		else
		{
			if (objectTile != null)
			{
				graphics.setColor(config.liveChompyColor());
				graphics.setStroke(new BasicStroke(2));
				graphics.draw(objectTile);
				graphics.setColor(new Color(config.liveChompyColor().getRed(), config.liveChompyColor().getGreen(), config.liveChompyColor().getBlue(), 20));
				graphics.fill(objectTile);
			}
		}
	}
}
