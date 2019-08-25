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
package net.runelite.client.plugins.theatre.rooms.nylocas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.NPC;
import net.runelite.client.plugins.theatre.TheatrePlugin;
import net.runelite.client.plugins.theatre.TheatreRoom;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

class NyloOverlay extends Overlay
{

	private final Client client;

	private final TheatrePlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	private final NyloHandler nylohandler;

	NyloOverlay(final Client client, final TheatrePlugin plugin, final NyloHandler nylohandler)
	{
		super(plugin);

		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		setPriority(OverlayPriority.HIGH);

		this.client = client;
		this.plugin = plugin;
		this.nylohandler = nylohandler;

		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Nylocas Overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getRoom() != TheatreRoom.NYLOCAS)
		{
			return null;
		}

		int hagios = 0;
		int toxobolos = 0;
		int ischyros = 0;

		for (NPC npc : this.client.getNpcs())
		{
			String name = npc.getName();
			if (name != null)
			{
				switch (name)
				{
					case "Nylocas Hagios":
						hagios++;
						break;
					case "Nylocas Toxobolos":
						toxobolos++;
						break;
					case "Nylocas Ischyros":
						ischyros++;
						break;
				}
			}
		}

		panelComponent.getChildren().clear();
		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		int nyloCount = (hagios + toxobolos + ischyros);
		if (nylohandler.getWave() < 21)
		{
			if (nyloCount > 12)
			{
				tableComponent.addRow("Total Nylocas:", ColorUtil.prependColorTag(nyloCount + " / 12", Color.RED));
			}
			else
			{
				tableComponent.addRow("Total Nylocas:", ColorUtil.prependColorTag(nyloCount + " / 12", Color.GREEN));
			}

		}
		else
		{
			if (nyloCount > 24)
			{
				tableComponent.addRow("Total Nylocas:", ColorUtil.prependColorTag(nyloCount + " / 24", Color.RED));
			}
			else
			{
				tableComponent.addRow("Total Nylocas:", ColorUtil.prependColorTag(nyloCount + " / 24", Color.GREEN));
			}
		}

		panelComponent.getChildren().add(tableComponent);

		return panelComponent.render(graphics);
	}
}