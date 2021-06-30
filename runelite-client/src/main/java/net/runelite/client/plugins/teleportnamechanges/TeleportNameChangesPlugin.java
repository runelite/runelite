/*
 * Copyright (c) 2018, Malfuryent <malevolentdev@gmail.com>
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
package net.runelite.client.plugins.teleportnamechanges;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.MenuEntry;
import net.runelite.api.Client;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
	name = "Rename teleports"
)
public class TeleportNameChangesPlugin extends Plugin
{
	@Inject
	private Client client;

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		// Pharaoh staff renaming
		if (event.getOption().equals("Jalsavrah"))
		{
			MenuEntry[] menuEntries = client.getMenuEntries();
			for (MenuEntry object : menuEntries)
			{
				if (object.getOption().equals("Jalsavrah"))
				{
					object.setOption("Pyramid plunder");
				}

				if (object.getOption().equals("Jaleustrophos"))
				{
					object.setOption("Agility pyramid");
				}

				if (object.getOption().equals("Jaldraocht"))
				{
					object.setOption("Desert treasure pyramid");
				}
			}
			client.setMenuEntries(menuEntries);
		}

		// Ancient teleports renaming
		if (event.getOption().equals("Break") || event.getOption().equals("Use") || event.getOption().equals("Withdraw-1"))
		{
			MenuEntry[] menuEntries = client.getMenuEntries();
			for (MenuEntry object : menuEntries)
			{
				if (object.getTarget().equals("<col=ff9040>Kharyrll teleport"))
				{
					object.setTarget("<col=ff9040>Canifis teleport");
				}

				if (object.getTarget().equals("<col=ff9040>Senntisten teleport"))
				{
					object.setTarget("<col=ff9040>Digsite teleport");
				}

				if (object.getTarget().equals("<col=ff9040>Lassar teleport"))
				{
					object.setTarget("<col=ff9040>Ice mountain teleport");
				}

				if (object.getTarget().equals("<col=ff9040>Ghorrock teleport"))
				{
					object.setTarget("<col=ff9040>Ice Plateau teleport");
				}

				if (object.getTarget().equals("<col=ff9040>Paddewwa teleport"))
				{
					object.setTarget("<col=ff9040>Edgeville dungeon teleport");
				}

				if (object.getTarget().equals("<col=ff9040>Dareeyak teleport"))
				{
					object.setTarget("<col=ff9040>Ruins west of banditcamp teleport");
				}

				if (object.getTarget().equals("<col=ff9040>Annakarl teleport"))
				{
					object.setTarget("<col=ff9040>Demonic ruins teleport");
				}

				if (object.getTarget().equals("<col=ff9040>Carrallangar teleport"))
				{
					object.setTarget("<col=ff9040>Graveyard of shadows teleport");
				}
			}
			client.setMenuEntries(menuEntries);
		}
	}
}