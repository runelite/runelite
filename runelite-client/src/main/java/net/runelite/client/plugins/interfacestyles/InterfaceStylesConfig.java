/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.interfacestyles;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("interfaceStyles")
public interface InterfaceStylesConfig extends Config
{
	@ConfigItem(
		keyName = "gameframe",
		name = "Gameframe",
		description = "The gameframe to use for the interface."
	)
	default Skin skin()
	{
		return Skin.AROUND_2010;
	}

	@ConfigItem(
		keyName = "hdHealthBars",
		name = "High detail health bars",
		description = "Replaces health bars with the RuneScape high detail mode design."
	)
	default boolean hdHealthBars()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hdMenu",
		name = "High detail menu",
		description = "Replaces game menu with the RuneScape high detail mode design."
	)
	default boolean hdMenu()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rsCrossSprites",
		name = "RuneScape cross sprites",
		description = "Replaces left-click cross sprites with the ones in RuneScape."
	)
	default boolean rsCrossSprites()
	{
		return false;
	}

	@ConfigItem(
		keyName = "alwaysStack",
		name = "Always stack bottom bar",
		description = "Always stack the bottom bar in resizable."
	)
	default boolean alwaysStack()
	{
		return false;
	}

	@Range(
		max = 255
	)
	@ConfigItem(
		keyName = "menuAlpha",
		name = "Menu alpha",
		description = "Configures the transparency of the right-click menu."
	)
	default int menuAlpha()
	{
		return 255;
	}

	@ConfigItem(
		keyName = "condensePlayerOptions",
		name = "Condense player options",
		description = "Move player options like Follow and Trade with to submenus."
	)
	default boolean condensePlayerOptions()
	{
		return false;
	}
}