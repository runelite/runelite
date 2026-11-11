/*
 * Copyright (c) 2026, RuneLite
 * All rights reserved.
 */
package net.runelite.client.plugins.barrows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Locale;
import javax.inject.Inject;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class BarrowsPotentialNpcOverlay extends Overlay
{
	private static final Font FONT = new Font("Arial", Font.PLAIN, 12);
	private static final Color GREEN = Color.GREEN;
	private static final Color RED = Color.RED;

	private final BarrowsPlugin plugin;
	private final BarrowsConfig config;

	@Inject
	BarrowsPotentialNpcOverlay(BarrowsPlugin plugin, BarrowsConfig config)
	{
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInCrypt())
		{
			return null;
		}

		Font oldFont = graphics.getFont();
		graphics.setFont(FONT);
		try
		{
			for (NPC npc : plugin.getTrackedPotentialNpcs())
			{
				String name = npc.getName();
				if (npc.isDead() || !BarrowsPlugin.isPotentialNpc(name)
					|| (BarrowsPlugin.isPotentialBrother(name) && !config.showBrothersPotential()))
				{
					continue;
				}

				String text = getLabel(npc);
				Color color = plugin.shouldPotentialBeRed(npc) ? RED : GREEN;
				Point textLocation = npc.getCanvasTextLocation(graphics, text,
					npc.getLogicalHeight() / 2 + config.enemyPotentialOffset());
				if (textLocation != null)
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, text, color);
				}
			}
		}
		finally
		{
			graphics.setFont(oldFont);
		}
		return null;
	}

	private String getLabel(NPC npc)
	{
		int potentialAfterKill = plugin.getPotentialAfterKilling(npc);
		if (config.showNewPotential())
		{
			return String.format(Locale.ROOT, "%.2f%%",
				potentialAfterKill * 100.0 / BarrowsPlugin.MAX_REWARD_POTENTIAL);
		}

		return String.format(Locale.ROOT, "+%.1f%%",
			(potentialAfterKill - plugin.getRewardPotential()) * 100.0 / BarrowsPlugin.MAX_REWARD_POTENTIAL);
	}
}
