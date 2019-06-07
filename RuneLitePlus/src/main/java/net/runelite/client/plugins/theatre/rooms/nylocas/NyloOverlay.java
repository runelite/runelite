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

import api.Client;
import api.NPC;
import net.runelite.client.plugins.theatre.TheatreConfig;
import net.runelite.client.plugins.theatre.TheatrePlugin;
import net.runelite.client.plugins.theatre.TheatreRoom;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.*;

import static api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

class NyloOverlay extends Overlay 
{

	private final Client client;

	private final TheatrePlugin plugin;
	private final TheatreConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	private NyloHandler nylohandler;

	public NyloOverlay(Client client, TheatrePlugin plugin, TheatreConfig config, NyloHandler nylohandler)
	{
		super(plugin);

		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		setPriority(OverlayPriority.HIGH);

		this.client = client;
		this.plugin = plugin;
		this.config = config;
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
				if (name.equals("Nylocas Hagios"))
				{
					hagios++;
				}
				else if (name.equals("Nylocas Toxobolos"))
				{
					toxobolos++;
				}
				else if (name.equals("Nylocas Ischyros"))
				{
					ischyros++;
				}
			}
		}

		panelComponent.getChildren().clear();
		int nyloCount = (hagios + toxobolos + ischyros);
		if (nylohandler.getWave() < 21)
		{
			if (nyloCount > 12)
			{
				panelComponent.getChildren().add(LineComponent.builder()
						.left("Total Nylocas:")
						.right(nyloCount + " / 12" )
						.rightColor(Color.RED)
						.build());
			} 
			else
			{
				panelComponent.getChildren().add(LineComponent.builder()
						.left("Total Nylocas:")
						.right(nyloCount + " / 12" )
						.rightColor(Color.GREEN)
						.build());

			}

		} 
		else 
		{
			if (nyloCount > 24)
			{
				panelComponent.getChildren().add(LineComponent.builder()
						.left("Total Nylocas:")
						.right(nyloCount + " / 24" )
						.rightColor(Color.RED)
						.build());
			}
			else
			{
				panelComponent.getChildren().add(LineComponent.builder()
						.left("Total Nylocas:")
						.right(nyloCount + " / 24" )
						.rightColor(Color.GREEN)
						.build());
			}
		}


		/**
		 panelComponent.getChildren().add(LineComponent.builder()
		 .left("Ischyros:")
		 .right(Integer.toString(ischyros))
		 .build());

		 panelComponent.getChildren().add(LineComponent.builder()
		 .left("Toxobolos:")
		 .right(Integer.toString(toxobolos))
		 .build());

		 panelComponent.getChildren().add(LineComponent.builder()
		 .left("Hagios:")
		 .right(Integer.toString(hagios))
		 .build());
		 **/
		return panelComponent.render(graphics);
	}
}