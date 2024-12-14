/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.chatcommands;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@ConfigGroup("chatcommands")
public interface ChatCommandsConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "price",
		name = "Price command",
		description = "Configures whether the price command is enabled: !price [item]"
	)
	default boolean price()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "lvl",
		name = "Level command",
		description = "Configures whether the level command is enabled: !lvl [skill]"
	)
	default boolean lvl()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "clue",
		name = "Clue command",
		description = "Configures whether the clue command is enabled: !clues"
	)
	default boolean clue()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "killcount",
		name = "Killcount command",
		description = "Configures whether the killcount command is enabled: !kc [boss]"
	)
	default boolean killcount()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "qp",
		name = "QP command",
		description = "Configures whether the quest point command is enabled: !qp"
	)
	default boolean qp()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "pb",
		name = "PB command",
		description = "Configures whether the personal best command is enabled: !pb [boss]"
	)
	default boolean pb()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "gc",
		name = "GC command",
		description = "Configures whether the Barbarian Assault high gamble count command is enabled: !gc"
	)
	default boolean gc()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "duels",
		name = "Duels command",
		description = "Configures whether the duel arena command is enabled: !duels"
	)
	default boolean duels()
	{
		return true;
	}

	@ConfigItem(
		position = 8,
		keyName = "bh",
		name = "BH command",
		description = "Configures whether the Bounty Hunter - Hunter command is enabled: !bh"
	)
	default boolean bh()
	{
		return true;
	}

	@ConfigItem(
		position = 9,
		keyName = "bhRogue",
		name = "BH Rogue command",
		description = "Configures whether the Bounty Hunter - Rogue command is enabled: !bhrogue"
	)
	default boolean bhRogue()
	{
		return true;
	}

	@ConfigItem(
		position = 10,
		keyName = "lms",
		name = "LMS command",
		description = "Configures whether the Last Man Standing command is enabled: !lms"
	)
	default boolean lms()
	{
		return true;
	}

	@ConfigItem(
		position = 11,
		keyName = "lp",
		name = "LP command",
		description = "Configures whether the League Points command is enabled: !lp"
	)
	default boolean lp()
	{
		return true;
	}

	@ConfigItem(
		position = 12,
		keyName = "sw",
		name = "SW command",
		description = "Configures whether the Soul Wars Zeal command is enabled: !sw"
	)
	default boolean sw()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "pets",
		name = "Pets command",
		description = "Configures whether the player pet list command is enabled. Update your pet list by looking at the 'All Pets' tab in the collection log."
	)
	default boolean pets()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "ca",
		name = "CA command",
		description = "Configures whether the combat achievements command is enabled: !ca"
	)
	default boolean ca()
	{
		return true;
	}

	@ConfigItem(
		position = 15,
		keyName = "clog",
		name = "CLOG command",
		description = "Configures whether the collection log command is enabled: !clog"
	)
	default boolean clog()
	{
		return true;
	}

	@ConfigItem(
		position = 20,
		keyName = "clearSingleWord",
		name = "Clear single word",
		description = "Enable hotkey to clear single word at a time."
	)
	default Keybind clearSingleWord()
	{
		return new Keybind(KeyEvent.VK_BACK_SPACE, InputEvent.CTRL_DOWN_MASK);
	}

	@ConfigItem(
		position = 21,
		keyName = "clearEntireChatBox",
		name = "Clear chat box",
		description = "Enable hotkey to clear entire chat box."
	)
	default Keybind clearChatBox()
	{
		return Keybind.NOT_SET;
	}
}
