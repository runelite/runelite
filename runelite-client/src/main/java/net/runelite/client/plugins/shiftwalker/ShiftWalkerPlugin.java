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
import javax.inject.Inject;
import net.runelite.api.events.FocusChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;

/**
 * Shift Walker Plugin. Credit to MenuEntrySwapperPlugin for code some code structure used here.
 */
@PluginDescriptor(
	name = "Shift Walk Under",
	description = "Use Shift to toggle the Walk Here menu option. While pressed you will Walk rather than interact with objects.",
	tags = {"npcs", "items", "objects"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)

public class ShiftWalkerPlugin extends Plugin
{

	private static final String WALK_HERE = "Walk here";

	@Inject
	private ShiftWalkerConfig config;

	@Inject
	private ShiftWalkerInputListener inputListener;

	@Inject
	private MenuManager menuManager;

	@Inject
	private KeyManager keyManager;

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
			stopPrioritizing();
		}
	}

	void startPrioritizing()
	{
		menuManager.addPriorityEntry(WALK_HERE);
	}

	void stopPrioritizing()
	{
		menuManager.removePriorityEntry(WALK_HERE);
	}
}
