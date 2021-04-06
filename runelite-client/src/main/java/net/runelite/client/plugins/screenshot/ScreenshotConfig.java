/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.screenshot;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.util.ImageUploadStyle;

@ConfigGroup("screenshot")
public interface ScreenshotConfig extends Config
{
	@ConfigSection(
		name = "What to Screenshot",
		description = "All the options that select what to screenshot",
		position = 99
	)
	String whatSection = "what";

	@ConfigItem(
		keyName = "includeFrame",
		name = "Include Client Frame",
		description = "Configures whether or not the client frame is included in screenshots",
		position = 0
	)
	default boolean includeFrame()
	{
		return true;
	}

	@ConfigItem(
		keyName = "displayDate",
		name = "Display Date",
		description = "Configures whether or not the report button shows the date the screenshot was taken",
		position = 1
	)
	default boolean displayDate()
	{
		return true;
	}

	@ConfigItem(
		keyName = "notifyWhenTaken",
		name = "Notify When Taken",
		description = "Configures whether or not you are notified when a screenshot has been taken",
		position = 2
	)
	default boolean notifyWhenTaken()
	{
		return true;
	}

	@ConfigItem(
		keyName = "rewards",
		name = "Screenshot Rewards",
		description = "Configures whether screenshots are taken of clues, barrows, and quest completion",
		position = 3,
		section = whatSection
	)
	default boolean screenshotRewards()
	{
		return true;
	}

	@ConfigItem(
		keyName = "levels",
		name = "Screenshot Levels",
		description = "Configures whether screenshots are taken of level ups",
		position = 4,
		section = whatSection
	)
	default boolean screenshotLevels()
	{
		return true;
	}

	@ConfigItem(
		keyName = "kingdom",
		name = "Screenshot Kingdom Reward",
		description = "Configures whether screenshots are taken of Kingdom Reward",
		position = 5,
		section = whatSection
	)
	default boolean screenshotKingdom()
	{
		return true;
	}

	@ConfigItem(
		keyName = "pets",
		name = "Screenshot Pet",
		description = "Configures whether screenshots are taken of receiving pets",
		position = 6,
		section = whatSection
	)
	default boolean screenshotPet()
	{
		return true;
	}

	@ConfigItem(
		keyName = "uploadScreenshot",
		name = "Upload",
		description = "Configures whether or not screenshots are uploaded to Imgur, or placed on your clipboard",
		position = 7
	)
	default ImageUploadStyle uploadScreenshot()
	{
		return ImageUploadStyle.NEITHER;
	}

	@ConfigItem(
		keyName = "kills",
		name = "Screenshot PvP Kills",
		description = "Configures whether or not screenshots are automatically taken of PvP kills",
		position = 8,
		section = whatSection
	)
	default boolean screenshotKills()
	{
		return false;
	}

	@ConfigItem(
		keyName = "boss",
		name = "Screenshot Boss Kills",
		description = "Configures whether or not screenshots are automatically taken of boss kills",
		position = 9,
		section = whatSection
	)
	default boolean screenshotBossKills()
	{
		return false;
	}

	@ConfigItem(
		keyName = "playerDeath",
		name = "Screenshot Deaths",
		description = "Configures whether or not screenshots are automatically taken when you die.",
		position = 10,
		section = whatSection
	)
	default boolean screenshotPlayerDeath()
	{
		return false;
	}

	@ConfigItem(
		keyName = "friendDeath",
		name = "Screenshot Friend Deaths",
		description = "Configures whether or not screenshots are automatically taken when friends or friends chat members die.",
		position = 11,
		section = whatSection
	)
	default boolean screenshotFriendDeath()
	{
		return false;
	}

	@ConfigItem(
		keyName = "duels",
		name = "Screenshot Duels",
		description = "Configures whether or not screenshots are automatically taken of the duel end screen.",
		position = 12,
		section = whatSection
	)
	default boolean screenshotDuels()
	{
		return false;
	}

	@ConfigItem(
		keyName = "valuableDrop",
		name = "Screenshot Valuable drops",
		description = "Configures whether or not screenshots are automatically taken when you receive a valuable drop.",
		position = 13,
		section = whatSection
	)
	default boolean screenshotValuableDrop()
	{
		return false;
	}

	@ConfigItem(
		keyName = "valuableDropThreshold",
		name = "Valuable Threshold",
		description = "The minimum value to save screenshots of valuable drops.",
		position = 14,
		section = whatSection
	)
	default int valuableDropThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "untradeableDrop",
		name = "Screenshot Untradeable drops",
		description = "Configures whether or not screenshots are automatically taken when you receive an untradeable drop.",
		position = 15,
		section = whatSection
	)
	default boolean screenshotUntradeableDrop()
	{
		return false;
	}

	@ConfigItem(
		keyName = "ccKick",
		name = "Screenshot Kicks from FC",
		description = "Take a screenshot when you kick a user from a friends chat.",
		position = 16,
		section = whatSection
	)
	default boolean screenshotKick()
	{
		return false;
	}

	@ConfigItem(
		keyName = "baHighGamble",
		name = "Screenshot BA high gambles",
		description = "Take a screenshot of your reward from a high gamble at Barbarian Assault.",
		position = 17,
		section = whatSection
	)
	default boolean screenshotHighGamble()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hotkey",
		name = "Screenshot hotkey",
		description = "When you press this key a screenshot will be taken",
		position = 18
	)
	default Keybind hotkey()
	{
		return Keybind.NOT_SET;
	}
}
