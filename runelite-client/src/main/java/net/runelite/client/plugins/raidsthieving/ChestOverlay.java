/*
 * Copyright (c) 2018, Tim Lehner <Timothy.Lehner.2011@live.rhul.ac.uk>
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
package net.runelite.client.plugins.raidsthieving;

import java.util.Set;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.raidsthieving.BatSolver.BatSolver;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;

/**
 * Represents the overlay that shows timers on traps that are placed by the
 * player.
 */
@Singleton
public class ChestOverlay extends Overlay
{

	private final Client client;
	private final RaidsThievingPlugin plugin;

	@Inject
	ChestOverlay(final Client client, final RaidsThievingPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		drawChests(graphics);
		return null;
	}

	/**
	 * Iterates over all the traps that were placed by the local player, and
	 * draws a circle or a timer on the trap, depending on the trap state.
	 *
	 * @param graphics
	 */
	private void drawChests(Graphics2D graphics)
	{
		for (Map.Entry<WorldPoint, ThievingChest> entry : plugin.getChests().entrySet())
		{
			ThievingChest chest = entry.getValue();
			WorldPoint pos = entry.getKey();

			if (chest != null)
			{
				if (!plugin.isBatsFound() && !chest.isEverOpened() && shouldDrawChest(pos))
				{
					Color drawColor = new Color(plugin.getPotentialBatColor().getRed(),
						plugin.getPotentialBatColor().getGreen(),
						plugin.getPotentialBatColor().getBlue(),
						getChestOpacity(pos));
					drawCircleOnTrap(graphics, chest, drawColor);
				}
				if (chest.isPoison())
				{
					drawCircleOnTrap(graphics, chest, plugin.getPoisonTrapColor());
				}
			}
		}
	}

	private boolean shouldDrawChest(WorldPoint chestPos)
	{
		if (plugin.numberOfEmptyChestsFound() == 0)
		{
			return true;
		}
		int chestId = plugin.getChestId(chestPos);
		BatSolver solver = plugin.getSolver();
		if (solver != null && chestId != -1)
		{
			Set<Integer> matches = solver.matchSolutions();
			return matches.contains(chestId) || matches.size() == 0;
		}
		return true;
	}

	/**
	 * Draws a timer on a given trap.
	 *
	 * @param graphics
	 * @param chest    The chest on which the circle needs to be drawn
	 * @param fill     The fill color of the timer
	 */
	private void drawCircleOnTrap(Graphics2D graphics, ThievingChest chest, Color fill)
	{
		if (chest.getWorldPoint().getPlane() != client.getPlane())
		{
			return;
		}

		LocalPoint localLoc = LocalPoint.fromWorld(client, chest.getWorldPoint());
		if (localLoc == null)
		{
			return;
		}

		Point loc = Perspective.localToCanvas(client, localLoc, chest.getWorldPoint().getPlane());
		ProgressPieComponent pie = new ProgressPieComponent();
		pie.setFill(fill);
		pie.setBorderColor(Color.BLACK);
		pie.setPosition(loc);
		pie.setProgress(1);
		if (graphics != null && loc != null)
		{
			pie.render(graphics);
		}
	}

	private int getChestOpacity(WorldPoint chestPos)
	{
		int chestId = plugin.getChestId(chestPos);
		BatSolver solver = plugin.getSolver();
		if (solver != null && chestId != -1)
		{
			return (int) (255 * solver.relativeLikelihoodPoison(chestId));
		}
		return 255;
	}
}
