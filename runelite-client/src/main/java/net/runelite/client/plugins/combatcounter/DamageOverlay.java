/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.combatcounter;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Player;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

class DamageOverlay extends Overlay
{

	private final Client client;

	private final CombatCounter plugin;

	private final CombatCounterConfig config;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public DamageOverlay(Client client, CombatCounter plugin, CombatCounterConfig config)
	{
		super(plugin);

		setPosition(OverlayPosition.DYNAMIC);
		setPosition(OverlayPosition.DETACHED);
		setPosition(OverlayPosition.BOTTOM_RIGHT);

		this.config = config;
		this.client = client;
		this.plugin = plugin;

		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Damage Counter Overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.showDamageCounter())
		{
			panelComponent.getChildren().clear();

			Player local = client.getLocalPlayer();
			if (local == null || local.getName() == null)
			{
				return null;
			}
			panelComponent.setBackgroundColor(config.bgColor());
			panelComponent.getChildren().add(TitleComponent.builder().text("Damage Counter").color(config.titleColor()).build());

			TableComponent tableComponent = new TableComponent();
			tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

			if (plugin.getCounter().isEmpty())
			{
				tableComponent.addRow(local.getName(), "0");
			}
			else
			{
				Map<String, Double> map = this.plugin.playerDamage;
				if (map == null)
				{
					return null;
				}

				for (String name : map.keySet())
				{
					String val = String.format("%.1f", map.get(name));
					if (client.getLocalPlayer().getName().contains(name))
					{
						tableComponent.addRow(ColorUtil.prependColorTag(name, config.selfColor()), ColorUtil.prependColorTag(val, config.selfColor()));
					}
					else
					{
						tableComponent.addRow(ColorUtil.prependColorTag(name, config.otherColor()), ColorUtil.prependColorTag(val, config.otherColor()));
					}
				}

				if (!map.containsKey(local.getName()))
				{
					tableComponent.addRow(ColorUtil.prependColorTag(local.getName(), config.selfColor()), ColorUtil.prependColorTag("0", config.selfColor()));
				}
			}

			if (!tableComponent.isEmpty())
			{
				panelComponent.getChildren().add(tableComponent);
			}

			return panelComponent.render(graphics);
		}
		else
		{
			return null;
		}
	}
}
