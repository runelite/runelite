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
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;

import javax.inject.Inject;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ChompyHuntingToadOverlay extends Overlay
{
	private final Client client;
	private final ChompyHuntingConfig config;
	private final ChompyHuntingPlugin plugin;
	private final TextComponent textComponent = new TextComponent();
	private static final int STRING_GAP = 15;
	private final Map<WorldPoint, Integer> offsetMap = new HashMap<>();

	@Inject
	ChompyHuntingToadOverlay(Client client, ChompyHuntingConfig config, ChompyHuntingPlugin plugin)
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
		if (!config.highlightBloatedToads() && !config.showExplosionTimer())
		{
			return null;
		}
		Map<NPC, Integer> toads = plugin.getToads();
		if (toads == null)
		{
			return null;
		}
		offsetMap.clear();
		for (NPC toad : toads.keySet())
		{
			renderToad(graphics, toad, toads.get(toad));
		}
		return null;
	}

	private void renderToad(Graphics2D graphics, NPC actor, Integer ticks)
	{
		Polygon objectTile = actor.getCanvasTilePoly();
		NPCComposition composition = actor.getComposition();
		final LocalPoint groundPoint = LocalPoint.fromWorld(client, actor.getWorldLocation());

		final net.runelite.api.Point textPoint = Perspective.getCanvasTextLocation(client,
			graphics,
			groundPoint,
			Integer.toString(ticks), 0);

		if (textPoint != null)
		{
			if (config.highlightBloatedToads())
			{
				if (objectTile != null)
				{
					graphics.setColor(config.toadColor());
					graphics.setStroke(new BasicStroke(2));
					graphics.draw(objectTile);
					graphics.setColor(new Color(config.toadColor().getRed(), config.toadColor().getGreen(),
						config.toadColor().getBlue(), 20));
					graphics.fill(objectTile);
				}
			}
			if (config.showExplosionTimer())
			{
				final int textX = textPoint.getX();
				final int textY = textPoint.getY();

				textComponent.setText(Integer.toString(ticks));
				textComponent.setColor(config.explosionTimerColor());
				textComponent.setPosition(new Point(textX, textY));
				textComponent.render(graphics);
			}
		}
	}
}
