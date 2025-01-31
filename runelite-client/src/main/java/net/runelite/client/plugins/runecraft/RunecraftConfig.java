/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.runecraft;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Notification;

@ConfigGroup(RunecraftConfig.GROUP)
public interface RunecraftConfig extends Config
{
	String GROUP = "runecraft";

	@ConfigSection(
		name = "Rift settings",
		description = "Abyss rift overlay settings.",
		position = 99
	)
	String riftSection = "rifts";

	@ConfigItem(
		keyName = "showPouch",
		name = "Show pouch count",
		description = "Configures whether the pouch essence count is displayed.",
		position = 1
	)
	default boolean showPouch()
	{
		return true;
	}

	@ConfigItem(
		keyName = "pouchDegrade",
		name = "Show pouch fills",
		description = "Configures whether the pouch durability is shown as an approximate number of fills remaining.",
		position = 2
	)
	default boolean pouchDegrade()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRifts",
		name = "Show rifts in abyss",
		description = "Configures whether the rifts in the abyss will be displayed.",
		position = 2,
		section = riftSection
	)
	default boolean showRifts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showClickBox",
		name = "Show rift click box",
		description = "Configures whether to display the click box of the rift.",
		position = 3,
		section = riftSection
	)
	default boolean showClickBox()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAir",
		name = "Show air rift",
		description = "Configures whether to display the air rift.",
		position = 4,
		section = riftSection
	)
	default boolean showAir()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBlood",
		name = "Show blood rift",
		description = "Configures whether to display the blood rift.",
		position = 5,
		section = riftSection
	)
	default boolean showBlood()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBody",
		name = "Show body rift",
		description = "Configures whether to display the body rift.",
		position = 6,
		section = riftSection
	)
	default boolean showBody()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showChaos",
		name = "Show chaos rift",
		description = "Configures whether to display the chaos rift.",
		position = 7,
		section = riftSection
	)
	default boolean showChaos()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCosmic",
		name = "Show cosmic rift",
		description = "Configures whether to display the cosmic rift.",
		position = 8,
		section = riftSection
	)
	default boolean showCosmic()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDeath",
		name = "Show death rift",
		description = "Configures whether to display the death rift.",
		position = 9,
		section = riftSection
	)
	default boolean showDeath()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showEarth",
		name = "Show earth rift",
		description = "Configures whether to display the earth rift.",
		position = 10,
		section = riftSection
	)
	default boolean showEarth()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFire",
		name = "Show fire rift",
		description = "Configures whether to display the fire rift.",
		position = 11,
		section = riftSection
	)
	default boolean showFire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLaw",
		name = "Show law rift",
		description = "Configures whether to display the law rift.",
		position = 12,
		section = riftSection
	)
	default boolean showLaw()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMind",
		name = "Show mind rift",
		description = "Configures whether to display the mind rift.",
		position = 13,
		section = riftSection
	)
	default boolean showMind()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showNature",
		name = "Show nature rift",
		description = "Configures whether to display the nature rift.",
		position = 14,
		section = riftSection
	)
	default boolean showNature()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSoul",
		name = "Show soul rift",
		description = "Configures whether to display the soul rift.",
		position = 15,
		section = riftSection
	)
	default boolean showSoul()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWater",
		name = "Show water rift",
		description = "Configures whether to display the water rift.",
		position = 16,
		section = riftSection
	)
	default boolean showWater()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hightlightDarkMage",
		name = "Highlight Dark mage NPC",
		description = "Configures whether to highlight the Dark mage when pouches are degraded.",
		position = 18
	)
	default boolean hightlightDarkMage()
	{
		return true;
	}

	@ConfigItem(
		keyName = "degradingNotification",
		name = "Notify when pouch degrades",
		description = "Send a notification when a pouch degrades.",
		position = 19
	)
	default Notification degradingNotification()
	{
		return Notification.ON;
	}
}
