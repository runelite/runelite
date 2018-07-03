/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.fishing;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("fishing")
public interface FishingConfig extends Config
{
	@ConfigItem(
		keyName = "showIcons",
		name = "Display Fish icons",
		description = "Configures whether icons or text is displayed"
	)
	default boolean showIcons()
	{
		return true;
	}

	@ConfigItem(
		keyName = "statTimeout",
		name = "Reset stats (minutes)",
		description = "Configures the time until statistic is reset"
	)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "showShrimp",
		name = "Show Shrimp/Anchovies",
		description = "Configures whether shrimp/anchovies is displayed"
	)
	default boolean showShrimp()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLobster",
		name = "Show Lobster/Swordfish/Tuna",
		description = "Configures whether lobster/swordfish/tuna is displayed"
	)
	default boolean showLobster()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showShark",
		name = "Show Shark",
		description = "Configures whether shark is displayed"
	)
	default boolean showShark()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMonkfish",
		name = "Show Monkfish",
		description = "Configures whether monkfish displayed"
	)
	default boolean showMonkfish()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSalmon",
		name = "Show Salmon/Trout",
		description = "Configures whether salmon/trout is displayed"
	)
	default boolean showSalmon()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBarb",
		name = "Show Barbarian fish",
		description = "Configures whether barbarian fish is displayed"
	)
	default boolean showBarb()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAngler",
		name = "Show Anglerfish",
		description = "Configures whether anglerfish is displayed"
	)
	default boolean showAngler()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMinnow",
		name = "Show Minnow fish",
		description = "Configures whether minnow fish is displayed"
	)
	default boolean showMinnow()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showInfernalEel",
		name = "Show Infernal Eel",
		description = "Configures whether infernal eel is displayed"
	)
	default boolean showInfernalEel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSacredEel",
		name = "Show Sacred Eel",
		description = "Configures whether sacred eel is displayed"
	)
	default boolean showSacredEel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCaveEel",
		name = "Show Cave Eel",
		description = "Configures whether cave eel is displayed"
	)
	default boolean showCaveEel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSlimyEel",
		name = "Show Slimy Eel",
		description = "Configures whether slimy eel is displayed"
	)
	default boolean showSlimyEel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showKarambwanji",
		name = "Show Karambwanji",
		description = "Configures whether karambwanji is displayed"
	)
	default boolean showKarambwanji()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showKarambwan",
		name = "Show Karambwan",
		description = "Configures whether karambwan is displayed"
	)
	default boolean showKarambwan()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFishingStats",
		name = "Show Fishing session stats",
		description = "Configures whether to display the fishing session stats"
	)
	default boolean showFishingStats()
	{
		return true;
	}
}
