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
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;
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

		final MenuEntry[] menu = client.getMenuEntries();
		final int menuSize = menu.length;

		if (menuSize <= 0)
		{
			return null;
		}

		final MenuEntry entry = menu[menuSize - 1];

		if (entry.getParam1() != WidgetInfo.INVENTORY.getId())
		{
			return null;
		}

		final Effect change = statChanges.get(entry.getIdentifier());
		if (change != null)
		{
			final StringBuilder b = new StringBuilder();
			final StatsChanges statsChanges = change.calculate(client);

			for (final StatChange c : statsChanges.getStatChanges())
			{
				b.append(buildStatChangeString(c));
			}

			tooltipManager.add(new Tooltip(b.toString()));
		}

		return null;
	}

	private String buildStatChangeString(StatChange c)
	{
		StringBuilder b = new StringBuilder();
		b.append(ColorUtil.colorTag(Positivity.getColor(config, c.getPositivity())));

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
