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

@ConfigGroup("chatcommands")
public interface ChatCommandsConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "price",
		name = "Price Command",
		description = "Configures whether the Price command is enabled<br> !price [item]"
	)
	default boolean price()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "lvl",
		name = "Level Command",
		description = "Configures whether the Level command is enabled<br> !lvl [skill]"
	)
	default boolean lvl()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "clue",
		name = "Clue Command",
		description = "Configures whether the Clue command is enabled<br> !clues"
	)
	default boolean clue()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "killcount",
		name = "Killcount Command",
		description = "Configures whether the Killcount command is enabled<br> !kc [boss]"
	)
	default boolean killcount()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "qp",
		name = "QP Command",
		description = "Configures whether the quest point command is enabled<br> !qp"
	)
	default boolean qp()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "pb",
		name = "PB Command",
		description = "Configures whether the personal best command is enabled<br> !pb"
	)
	default boolean pb()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "gc",
		name = "GC Command",
		description = "Configures whether the Barbarian Assault High gamble count command is enabled<br> !gc"
	)
	default boolean gc()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "duels",
		name = "Duels Command",
		description = "Configures whether the duel arena command is enabled<br> !duels"
	)
	default boolean duels()
	{
		return true;
	}

	@ConfigItem(
		position = 8,
		keyName = "clearShortcuts",
		name = "Clear shortcuts",
		description = "Enable shortcuts (ctrl+w and backspace) for clearing the chatbox"
	)
	default boolean clearShortcuts()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "clipboardShortcuts",
		name = "Clipboard shortcuts",
		description = "Enable clipboard shortcuts (ctrl+c and ctrl+v)"
	)
	default boolean clipboardShortcuts()
	{
		return true;
	}
}