/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.itemstats;

import com.google.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import net.runelite.api.Client;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.QueryRunner;

public class ItemStatOverlay extends Overlay
{
	@Inject
	private QueryRunner queryRunner;

	@Inject
	private Client client;

	@Inject
	private TooltipManager tooltipManager;

	@Inject
	private ItemStatChanges statChanges;

	@Inject
	private ItemStatConfig config;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.isMenuOpen() || (!config.relative() && !config.absolute() && !config.theoretical()))
		{
			return null;
		}

		WidgetItem[] inventory = queryRunner.runQuery(new InventoryWidgetItemQuery());
		Point mousePos = new Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());
		for (WidgetItem item : inventory)
		{
			if (item.getCanvasBounds().contains(mousePos))
			{
				Effect change = statChanges.get(item.getId());
				if (change != null)
				{
					StringBuilder b = new StringBuilder();
					StatsChanges statsChanges = change.calculate(client);
					for (StatChange c : statsChanges.getStatChanges())
					{
						b.append(buildStatChangeString(c));
					}
					tooltipManager.add(new Tooltip(b.toString()));
				}
			}
		}
		return null;
	}

	private String buildStatChangeString(StatChange c)
	{
		StringBuilder b = new StringBuilder();
		b.append("<col=");
		b.append(Integer.toHexString(Positivity.getColor(config, c.getPositivity()).getRGB() & 0xFFFFFF));
		b.append(">");

		if (config.relative())
		{
			b.append(c.getRelative());
		}

		if (config.theoretical())
		{
			if (config.relative())
			{
				b.append("/");
			}
			b.append(c.getTheoretical());
		}

		if (config.absolute() && (config.relative() || config.theoretical()))
		{
			b.append(" (");
		}
		if (config.absolute())
		{
			b.append(c.getAbsolute());
		}

		if (config.absolute() && (config.relative() || config.theoretical()))
		{
			b.append(")");
		}
		b.append(" ").append(c.getStat().getName());
		b.append("</br>");

		return b.toString();
	}
}
