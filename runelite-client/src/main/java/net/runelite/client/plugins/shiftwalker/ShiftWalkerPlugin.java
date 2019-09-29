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
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.AbstractComparableEntry;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.HotkeyListener;

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
@Singleton
public class ShiftWalkerPlugin extends Plugin
{

	private static final AbstractComparableEntry WALK = new AbstractComparableEntry()
	{
		private final int hash = "WALK".hashCode() * 79 + getPriority();

		@Override
		public int hashCode()
		{
			return hash;
		}

		@Override
		public boolean equals(Object entry)
		{
			return entry.getClass() == this.getClass() && entry.hashCode() == this.hashCode();
		}

		@Override
		public int getPriority()
		{
			return 99;
		}

		@Override
		public boolean matches(MenuEntry entry)
		{
			return
				entry.getOpcode() == MenuOpcode.WALK.getId() ||
					entry.getOpcode() == MenuOpcode.WALK.getId() + MenuOpcode.MENU_ACTION_DEPRIORITIZE_OFFSET;
		}
	};

	private static final AbstractComparableEntry TAKE = new AbstractComparableEntry()
	{
		private final int hash = "TAKE".hashCode() * 79 + getPriority();

		@Override
		public int hashCode()
		{
			return hash;
		}

		@Override
		public boolean equals(Object entry)
		{
			return entry.getClass() == this.getClass() && entry.hashCode() == this.hashCode();
		}

		@Override
		public int getPriority()
		{
			return 100;
		}

		@Override
		public boolean matches(MenuEntry entry)
		{
			int opcode = entry.getOpcode();
			if (opcode > MenuOpcode.MENU_ACTION_DEPRIORITIZE_OFFSET)
			{
				opcode -= MenuOpcode.MENU_ACTION_DEPRIORITIZE_OFFSET;
			}

			return
				opcode >= MenuOpcode.GROUND_ITEM_FIRST_OPTION.getId() &&
					opcode <= MenuOpcode.GROUND_ITEM_FIFTH_OPTION.getId();
		}
	};

	private static final String EVENTBUS_THING = "shiftwalker shift";
	private static final String SHIFT_CHECK = "shiftwalker hotkey check";
	@Inject
	private Client client;
	@Inject
	private ShiftWalkerConfig config;
	@Inject
	private MenuManager menuManager;
	@Inject
	private KeyManager keyManager;
	@Inject
	private EventBus eventBus;
	@Setter(AccessLevel.PRIVATE)
	private boolean hotkeyActive;
	private boolean shiftWalk;
	private boolean shiftLoot;

	@Provides
	ShiftWalkerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ShiftWalkerConfig.class);
	}

	private final HotkeyListener shift = new HotkeyListener(() -> Keybind.SHIFT)
	{
		@Override
		public void hotkeyPressed()
		{
			startPrioritizing();
			setHotkeyActive(true);
		}

		@Override
		public void hotkeyReleased()
		{
			stopPrioritizing();
			setHotkeyActive(false);
		}
	};

	@Override
	public void startUp()
	{
		this.shiftWalk = config.shiftWalk();
		this.shiftLoot = config.shiftLoot();

		addSubscriptions();
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			keyManager.registerKeyListener(shift);
		}
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);
		keyManager.unregisterKeyListener(shift);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(FocusChanged.class, this, this::onFocusChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN)
		{
			keyManager.unregisterKeyListener(shift);
			return;
		}
		keyManager.registerKeyListener(shift);
	}

	private void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			stopPrioritizing();
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("shiftwalkhere"))
		{
			return;
		}

		if ("shiftWalk".equals(event.getKey()))
		{
			this.shiftWalk = "true".equals(event.getNewValue());
		}
		else
		{
			this.shiftLoot = "true".equals(event.getNewValue());
		}
	}

	private void hotkeyCheck(ClientTick event)
	{
		if (hotkeyActive)
		{
			int i = 0;
			for (boolean bol : client.getPressedKeys())
			{
				if (bol)
				{
					i++;
				}
			}
			if (i == 0)
			{
				stopPrioritizing();
				setHotkeyActive(false);
				eventBus.unregister(SHIFT_CHECK);
			}
		}
	}

	private void startPrioritizing()
	{
		eventBus.subscribe(ClientTick.class, EVENTBUS_THING, this::addEntries);
		eventBus.subscribe(ClientTick.class, SHIFT_CHECK, this::hotkeyCheck);
	}

	private void addEntries(ClientTick event)
	{
		if (this.shiftLoot)
		{
			menuManager.addPriorityEntry(TAKE);
		}
		if (this.shiftWalk)
		{
			menuManager.addPriorityEntry(WALK);
		}

		eventBus.unregister(EVENTBUS_THING);
	}

	private void stopPrioritizing()
	{
		eventBus.subscribe(ClientTick.class, EVENTBUS_THING, this::removeEntries);
	}

	private void removeEntries(ClientTick event)
	{
		menuManager.removePriorityEntry(TAKE);
		menuManager.removePriorityEntry(WALK);
		eventBus.unregister(EVENTBUS_THING);
	}
}
