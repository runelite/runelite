/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.menumodifier;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.MiscUtils;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Menu Modifier",
	description = "Changes right click menu for players",
	tags = {"menu", "modifier", "right", "click", "pk", "bogla"},
	enabledByDefault = false,
	type = PluginType.UTILITY
)
public class MenuModifierPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private MenuModifierConfig config;

	@Inject
	private MenuModifierInputListener inputListener;

	@Inject
	private KeyManager keyManager;

	@Provides
	MenuModifierConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MenuModifierConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(inputListener);
	}

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed;

	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{
		Player localPlayer = client.getLocalPlayer();

		if (localPlayer == null)
		{
			return;
		}

		if (!(MiscUtils.getWildernessLevelFrom(client, localPlayer.getWorldLocation()) >= 0))
		{
			return;
		}

		if (hotKeyPressed)
		{
			return;
		}

		List<MenuEntry> menu_entries = new ArrayList<>();

		for (MenuEntry entry : event.getMenuEntries())
		{
			String option = Text.removeTags(entry.getOption()).toLowerCase();

			if (option.contains("trade with") && config.hideTradeWith())
			{
				continue;
			}

			if (option.contains("lookup") && config.hideLookup())
			{
				continue;
			}

			if (option.contains("report") && config.hideReport())
			{
				continue;
			}

			if (option.contains("examine") && config.hideExamine())
			{
				continue;
			}

			if (option.contains("net") && config.hideNet())
			{
				continue;
			}

			if (option.contains("bait") && config.hideBait())
			{
				continue;
			}

			int identifier = entry.getIdentifier();

			Player[] players = client.getCachedPlayers();
			Player player = null;

			if (identifier >= 0 && identifier < players.length)
			{
				player = players[identifier];
			}

			if (player == null)
			{
				menu_entries.add(entry);
				continue;
			}

			if ((option.contains("attack") || option.contains("cast")) && (player.isFriend() || player.isClanMember()))
			{
				continue;
			}

			menu_entries.add(entry);
		}

		MenuEntry[] updated_menu_entries = new MenuEntry[menu_entries.size()];
		updated_menu_entries = menu_entries.toArray(updated_menu_entries);

		client.setMenuEntries(updated_menu_entries);
	}

/*@Subscribe
public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded)
{
if (true)
return;

if (!inWilderness)
return;

if (hotKeyPressed)
return;

String option = Text.removeTags(menuEntryAdded.getOption()).toLowerCase();

if ((option.contains("trade with") && config.hideTradeWith())
|| (option.contains("lookup") && config.hideLookup())
|| (option.contains("report") && config.hideReport())
|| (option.contains("examine") && config.hideExamine())
|| (option.contains("cancel") && config.hideCancel()))
{
int identifier = menuEntryAdded.getIdentifier();

Player[] players = client.getCachedPlayers();
Player player = null;

if (identifier >= 0 && identifier < players.length)
player = players[identifier];

if (player == null)
return;

//allow trading with friends/clanmates
if (option.contains("trade with") && (player.isFriend() || player.isClanMember()))
return;

MenuEntry[] menuEntries = client.getMenuEntries();

if (menuEntries.length > 0)
client.setMenuEntries(Arrays.copyOf(menuEntries, menuEntries.length - 1));
}
}*/
}
