/*
 * Copyright (c) 2018 Charlie Waters
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
package net.runelite.client.plugins.combatindicator;

import javax.inject.Inject;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PluginDescriptor(
	name = "Combat Indicator",
	description = "Show an indicator on entities that are interacting with the player",
	tags = { "combat", "tooltips" },
	enabledByDefault = true
)
@Slf4j
public class CombatIndicatorPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private CombatIndicatorConfig config;

	private List<Integer> interactingList;

	@Provides
	CombatIndicatorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CombatIndicatorConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			interactingList.clear();
		}
	}

	@Override
	protected void startUp()
	{
		interactingList = new ArrayList<>();
	}

	@Override
	protected void shutDown() throws Exception
	{
		interactingList = null;
	}

	@Subscribe
	public void onInteractingChanged(final InteractingChanged event)
	{
		final Actor player = client.getLocalPlayer();
		interactingList = client.getNpcs()
				.stream()
				.filter(npc -> player.equals(npc.getInteracting()))
				.map(npc -> npc.getIndex())
				.collect(Collectors.toList());
	}

	@Subscribe
	public void onMenuEntryAdded(final MenuEntryAdded event)
	{
		if (interactingList.isEmpty())
		{
			return;
		}

		final String interactionString = "<col=" + Integer.toHexString(config.getIndicatorColour().getRGB()).substring(2) + ">* ";
		final MenuEntry[] menuEntries = client.getMenuEntries();

		for (MenuEntry menuEntry : menuEntries)
		{
			final String target = menuEntry.getTarget();
			if (!target.startsWith(interactionString) && interactingList.contains(menuEntry.getIdentifier()))
			{
				// TODO: Allow configuring if the indicator is a prefix or suffix?
				menuEntry.setTarget(interactionString + target);
			}
		}

		client.setMenuEntries(menuEntries);
	}
}
