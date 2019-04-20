/*
 * Copyright (c) 2018, Plinko60
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
package net.runelite.client.plugins.shiftwalker;

import com.google.inject.Provides;
import lombok.Setter;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

import javax.inject.Inject;

/**
 * Shift Walker Plugin. Credit to MenuEntrySwapperPlugin for code some code structure used here.
 */
@PluginDescriptor(
	name = "<font color=\"green\">!Shift To Walk Here</font>",
	description = "Use Shift to toggle the Walk Here menu option. While pressed you will Walk rather than interact with objects.",
	tags = {"npcs", "items", "objects"},
	enabledByDefault = false
)
public class ShiftWalkerPlugin extends Plugin
{

	private static final String WALK_HERE = "WALK HERE";
	private static final String CANCEL = "CANCEL";

	@Inject
	private Client client;

	@Inject
	private ShiftWalkerConfig config;

	@Inject
	private ShiftWalkerInputListener inputListener;

	@Inject
	private ConfigManager configManager;

	@Inject
	private KeyManager keyManager;

	@Setter
	private boolean hotKeyPressed = false;

	@Provides
	ShiftWalkerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ShiftWalkerConfig.class);
	}

	@Override
	public void startUp()
	{
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	public void shutDown()
	{
		keyManager.unregisterKeyListener(inputListener);
	}

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			hotKeyPressed = false;
		}
	}

	/**
	 * Event when a new menu entry was added.
	 * @param event {@link MenuEntryAdded}.
	 */
	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !hotKeyPressed)
		{
			return;
		}

		final String pOptionToReplace = Text.removeTags(event.getOption()).toUpperCase();

		//If the option is already to walk there, or cancel we don't need to swap it with anything
		if (pOptionToReplace.equals(CANCEL) || pOptionToReplace.equals(WALK_HERE))
		{
			return;
		}

		String target = Text.removeTags(event.getTarget().toUpperCase());

		if (config.shiftWalkEverything())
		{
			//swap(pOptionToReplace); //Swap everything with walk here
			stripEntries();
		}
		else if (config.shiftWalkBoxTraps() && ShiftWalkerGroups.BOX_TRAP_TARGETS.contains(target)
				&& ShiftWalkerGroups.BOX_TRAP_KEYWORDS.contains(pOptionToReplace))
		{
			//swap(pOptionToReplace); //Swap only on box traps
			stripEntries();
		}
		else if (config.shiftWalkAttackOption() && ShiftWalkerGroups.ATTACK_OPTIONS_KEYWORDS.contains(pOptionToReplace))
		{
			//swap(pOptionToReplace); //Swap on everything that has an attack keyword as the first option
			stripEntries();
		}
	}

	/**
	 * Strip everything except "Walk here"
	 * Other way was unconventional because if there was multiple targets in the menu entry it wouldn't swap correctly
	 */
	private void stripEntries() {
		MenuEntry walkkHereEntry = null;

		for (MenuEntry entry : client.getMenuEntries()) {
			switch (entry.getOption()) {
				case "Walk here":
					walkkHereEntry = entry;
					break;
			}
		}
		if (walkkHereEntry != null) {
			MenuEntry[] newEntries = new MenuEntry[1];
			newEntries[0] = walkkHereEntry;
			client.setMenuEntries(newEntries);
		}
	}

	/**
	 * Swaps menu entries if the entries could be found. This places Walk Here where the top level menu option was.
	 * @param pOptionToReplace The String containing the Menu Option that needs to be replaced. IE: "Attack", "Chop Down".
	 */
	private void swap(String pOptionToReplace)
	{
		MenuEntry[] entries = client.getMenuEntries();

		Integer walkHereEntry = searchIndex(entries, WALK_HERE);
		Integer entryToReplace = searchIndex(entries, pOptionToReplace);

		if (walkHereEntry != null
			&& entryToReplace != null)
		{
			MenuEntry walkHereMenuEntry = entries[walkHereEntry];
			entries[walkHereEntry] = entries[entryToReplace];
			entries[entryToReplace] = walkHereMenuEntry;

			client.setMenuEntries(entries);
		}
	}

	/**
	 * Finds the index of the menu that contains the verbiage we are looking for.
	 * @param pMenuEntries The list of {@link MenuEntry}s.
	 * @param pMenuEntryToSearchFor The Option in the menu to search for.
	 * @return The index location or null if it was not found.
	 */
	private Integer searchIndex(MenuEntry[] pMenuEntries, String pMenuEntryToSearchFor)
	{
		Integer indexLocation = 0;

		for (MenuEntry menuEntry : pMenuEntries)
		{
			String entryOption = Text.removeTags(menuEntry.getOption()).toUpperCase();

			if (entryOption.equals(pMenuEntryToSearchFor))
			{
				return indexLocation;
			}

			indexLocation++;
		}

		return null;
	}

}
