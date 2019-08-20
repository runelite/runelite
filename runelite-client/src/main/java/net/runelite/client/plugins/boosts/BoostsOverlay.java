/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.boosts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

@Singleton
class BoostsOverlay extends Overlay
{
	private final Client client;
	private final PanelComponent panelComponent = new PanelComponent();
	private final BoostsPlugin plugin;

	@Inject
	private BoostsOverlay(final Client client, final BoostsPlugin plugin)
	{
		super(plugin);
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.MED);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Boosts overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isDisplayInfoboxes() || plugin.isDisplayIcons())
		{
			return null;
		}

		panelComponent.getChildren().clear();

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		int nextChange = plugin.getChangeDownTicks();

		if (nextChange != -1)
		{
			tableComponent.addRow("Next + restore:", String.valueOf(plugin.getChangeTime(nextChange)));
		}

		nextChange = plugin.getChangeUpTicks();

		if (nextChange != -1)
		{
			tableComponent.addRow("Next - restore:", String.valueOf(plugin.getChangeTime(nextChange)));
		}

		if (plugin.canShowBoosts())
		{
			for (Skill skill : plugin.getShownSkills())
			{
				final int boosted = client.getBoostedSkillLevel(skill);
				final int base = client.getRealSkillLevel(skill);

				if (boosted == base)
				{
					continue;
				}

				final int boost = boosted - base;
				final Color strColor = getTextColor(boost);
				String str;

				if (plugin.isUseRelativeBoost())
				{
					str = String.valueOf(boost);
					if (boost > 0)
					{
						str = "+" + str;
					}
				}
				else
				{
					str = ColorUtil.prependColorTag(Integer.toString(boosted), strColor)
						+ ColorUtil.prependColorTag("/" + base, Color.WHITE);
				}

				tableComponent.addRow(skill.getName() + ":", str);
			}
		}

		panelComponent.getChildren().add(tableComponent);

		return panelComponent.render(graphics);
	}

	private Color getTextColor(int boost)
	{
		if (boost < 0)
		{
			return new Color(238, 51, 51);
		}

		return boost <= plugin.getBoostThreshold() ? Color.YELLOW : Color.GREEN;

	}
}
