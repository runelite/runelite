/*
 * Copyright (c) 2019, Yani <yani@xenokore.com>
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
package net.runelite.client.plugins.pestcontrol;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;

@Slf4j
@Singleton
public class GangplankOverlay extends Overlay
{
	private final Client client;
	private final PestControlPlugin plugin;
	private final TooltipManager tooltipManager;

	@Inject
	GangplankOverlay(final Client client, final PestControlPlugin plugin, final TooltipManager toolTipManager)
	{
		this.plugin = plugin;
		this.client = client;
		this.tooltipManager = toolTipManager;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isOnPestControlMainIsland())
		{
			return null;
		}

		Player localPlayer = client.getLocalPlayer();

		if (localPlayer == null)
		{
			return null;
		}

		int combatLevel = localPlayer.getCombatLevel();

		Color noviceCbColor = (combatLevel >= 40) ? Color.GREEN : Color.RED;
		Color intermediateCbColor = (combatLevel >= 70) ? Color.GREEN : Color.RED;
		Color veteranCbColor = (combatLevel >= 100) ? Color.GREEN : Color.RED;

		Tile noviceGangplankTile = plugin.getNoviceGangplankTile();
		Tile intermediateGangplankTile = plugin.getIntermediateGangplankTile();
		Tile veteranGangplankTile = plugin.getVeteranGangplankTile();

		Point mousePosition = client.getMouseCanvasPosition();
		String tooltipString = null;

		if (noviceGangplankTile != null)
		{
			Shape polygon = noviceGangplankTile.getGameObjects()[0].getConvexHull();
			if (polygon != null)
			{
				graphics.setColor(noviceCbColor);
				graphics.setStroke(new BasicStroke(2));
				graphics.draw(polygon);
				graphics.setColor(setColorAlpha(noviceCbColor, 45));
				graphics.fill(polygon);

				if (polygon.contains(mousePosition.getX(), mousePosition.getY()))
				{
					tooltipString = ColorUtil.wrapWithColorTag("Combat 40+", noviceCbColor) + " (3 points)";
					graphics.setColor(setColorAlpha(noviceCbColor, 65));
					graphics.fill(polygon);
				}
			}
		}

		if (intermediateGangplankTile != null)
		{
			Shape polygon = intermediateGangplankTile.getGameObjects()[0].getConvexHull();
			if (polygon != null)
			{
				graphics.setColor(intermediateCbColor);
				graphics.setStroke(new BasicStroke(2));
				graphics.draw(polygon);
				graphics.setColor(setColorAlpha(intermediateCbColor, 45));
				graphics.fill(polygon);

				if (polygon.contains(mousePosition.getX(), mousePosition.getY()))
				{
					tooltipString = ColorUtil.wrapWithColorTag("Combat 70+", intermediateCbColor) + " (4 points)";
					graphics.setColor(setColorAlpha(intermediateCbColor, 65));
					graphics.fill(polygon);
				}
			}
		}

		if (veteranGangplankTile != null)
		{
			Shape polygon = veteranGangplankTile.getGameObjects()[0].getConvexHull();
			if (polygon != null)
			{
				graphics.setColor(veteranCbColor);
				graphics.setStroke(new BasicStroke(2));
				graphics.draw(polygon);
				graphics.setColor(setColorAlpha(veteranCbColor, 45));
				graphics.fill(polygon);

				if (polygon.contains(mousePosition.getX(), mousePosition.getY()))
				{
					tooltipString = ColorUtil.wrapWithColorTag("Combat 100+", veteranCbColor) + " (5 points)";
					graphics.setColor(setColorAlpha(veteranCbColor, 65));
					graphics.fill(polygon);
				}
			}
		}

		if (tooltipString != null)
		{
			tooltipManager.add(new Tooltip(tooltipString));
		}

		return null;
	}

	private Color setColorAlpha(Color color, int alpha)
	{
		return new Color(
			color.getRed(),
			color.getGreen(),
			color.getBlue(),
			alpha
		);
	}
}