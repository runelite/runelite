/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2019, gregg1494 <https://github.com/gregg1494>
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
package net.runelite.client.plugins.worldhopper;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.Set;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup(WorldHopperConfig.GROUP)
public interface WorldHopperConfig extends Config
{
	String GROUP = "worldhopper";

	@ConfigItem(
		keyName = "previousKey",
		name = "Quick-hop previous",
		description = "When you press this key you'll hop to the previous world.",
		position = 0
	)
	default Keybind previousKey()
	{
		return new Keybind(KeyEvent.VK_LEFT, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
	}

	@ConfigItem(
		keyName = "nextKey",
		name = "Quick-hop next",
		description = "When you press this key you'll hop to the next world.",
		position = 1
	)
	default Keybind nextKey()
	{
		return new Keybind(KeyEvent.VK_RIGHT, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
	}

	@ConfigItem(
		keyName = "quickhopOutOfDanger",
		name = "Quick-hop out of dangerous worlds",
		description = "Don't hop to a PvP/high risk world when quick-hopping.",
		position = 2
	)
	default boolean quickhopOutOfDanger()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSidebar",
		name = "Show world switcher sidebar",
		description = "Show sidebar containing all worlds that mimics in-game interface.",
		position = 4
	)
	default boolean showSidebar()
	{
		return true;
	}

	@ConfigItem(
		keyName = "ping",
		name = "Show world ping",
		description = "Shows ping to each game world.",
		position = 5
	)
	default boolean ping()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMessage",
		name = "Show world hop message in chat",
		description = "Shows what world is being hopped to in the chat.",
		position = 6
	)
	default boolean showWorldHopMessage()
	{
		return true;
	}

	@ConfigItem(
		keyName = "menuOption",
		name = "Show hop-to menu option",
		description = "Adds Hop-to menu option to the friends list and friends chat members list.",
		position = 7
	)
	default boolean menuOption()
	{
		return true;
	}

	@ConfigItem(
		keyName = "subscriptionFilter",
		name = "Subscription filter",
		description = "Only show free worlds, member worlds, or both types of worlds in sidebar.",
		position = 8
	)
	default SubscriptionFilterMode subscriptionFilter()
	{
		return SubscriptionFilterMode.BOTH;
	}

	@ConfigItem(
		keyName = "regionFilter",
		name = "Region filter",
		description = "Only show and quick-hop to worlds in specific regions.",
		position = 9
	)
	default Set<RegionFilterMode> regionFilter()
	{
		return Collections.emptySet();
	}

	@ConfigItem(
		keyName = "worldTypeFilter",
		name = "World type filter",
		description = "Only show worlds of specific types.",
		position = 10
	)
	default Set<WorldTypeFilter> worldTypeFilter()
	{
		return Collections.emptySet();
	}

	@ConfigItem(
		keyName = "displayPing",
		name = "Display current ping",
		description = "Displays ping to current game world.",
		position = 11
	)
	default boolean displayPing()
	{
		return false;
	}
}
