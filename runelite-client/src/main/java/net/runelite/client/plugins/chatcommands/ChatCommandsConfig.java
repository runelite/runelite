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

<<<<<<< HEAD
import java.awt.Color;
=======
>>>>>>> upstream/master
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
<<<<<<< HEAD
<<<<<<< HEAD

	@ConfigItem(
		position = 2,
		keyName = "hexColorPublic",
		name = "Public chat",
		description = "Color of Public chat"
	)
	default Color getPublicRecolor()
	{
		return Color.decode("#0000FF");
=======

	@ConfigItem(
		position = 2,
		keyName = "clue",
		name = "Clue Command",
		description = "Configures whether the Clue command is enabled<br> !clues"
	)
	default boolean clue()
	{
		return true;
>>>>>>> upstream/master
	}

	@ConfigItem(
		position = 3,
<<<<<<< HEAD
		keyName = "hexColorPublicH",
		name = "Public chat highlight",
		description = "Color of Public chat highlight"
	)
	default Color getPublicHRecolor()
	{
		return Color.decode("#000000");
=======
		keyName = "killcount",
		name = "Killcount Command",
		description = "Configures whether the Killcount command is enabled<br> !kc [boss]"
	)
	default boolean killcount()
	{
		return true;
>>>>>>> upstream/master
	}

	@ConfigItem(
		position = 4,
<<<<<<< HEAD
		keyName = "hexColorPrivate",
		name = "Private chat",
		description = "Color of Private chat"
	)
	default Color getPrivateRecolor()
	{
		return Color.decode("#0088FF");
=======
		keyName = "qp",
		name = "QP Command",
		description = "Configures whether the quest point command is enabled<br> !qp"
	)
	default boolean qp()
	{
		return true;
>>>>>>> upstream/master
	}

	@ConfigItem(
		position = 5,
<<<<<<< HEAD
		keyName = "hexColorPrivateH",
		name = "Private chat highlight",
		description = "Color of Private chat highlight"
	)
	default Color getPrivateHRecolor()
	{
		return Color.decode("#002783");
=======
		keyName = "pb",
		name = "PB Command",
		description = "Configures whether the personal best command is enabled<br> !pb"
	)
	default boolean pb()
	{
		return true;
>>>>>>> upstream/master
	}

	@ConfigItem(
		position = 6,
<<<<<<< HEAD
		keyName = "hexColorCc",
		name = "Clan chat",
		description = "Color of Clan chat"
	)
	default Color getCcRecolor()
	{
		return Color.decode("#7f0000");
	}

	@ConfigItem(
		position = 7,
		keyName = "hexColorCcH",
		name = "Clan chat Highlight",
		description = "Color of Clan chat highlight"
	)
	default Color getCcHRecolor()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 8,
		keyName = "transparentHexColorPublic",
		name = "Transparent public chat",
		description = "Color of Public chat"
	)
	default Color getTransparentPublicRecolor()
	{
		return Color.decode("#9090FF");
	}

	@ConfigItem(
		position = 9,
		keyName = "transparentHexColorPublicH",
		name = "Transparent public chat highlight",
		description = "Color of Public chat highlight"
	)
	default Color getTransparentPublicHRecolor()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 10,
		keyName = "transparentHexColorPrivate",
		name = "Transparent private chat",
		description = "Color of Private chat"
	)
	default Color getTransparentPrivateRecolor()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 11,
		keyName = "transparentHexColorPrivateH",
		name = "Transparent private chat highlight",
		description = "Color of Private chat highlight"
	)
	default Color getTransparentPrivateHRecolor()
	{
		return Color.decode("#00FFFF");
	}

	@ConfigItem(
		position = 12,
		keyName = "transparentHexColorCc",
		name = "Transparent clan chat",
		description = "Color of Clan chat"
	)
	default Color getTransparentCcRecolor()
	{
		return Color.decode("#Ef5050");
	}

	@ConfigItem(
		position = 13,
		keyName = "transparentHexColorCcH",
		name = "Transparent clan chat Highlight",
		description = "Color of Clan chat highlight"
	)
	default Color getTransparentCcHRecolor()
	{
		return Color.decode("#FFFFFF");
	}
=======
>>>>>>> upstream/master
=======
		keyName = "clearShortcuts",
		name = "Clear shortcuts",
		description = "Enable shortcuts (ctrl+w and backspace) for clearing the chatbox"
	)
	default boolean clearShortcuts()
	{
		return true;
	}
>>>>>>> upstream/master
}
