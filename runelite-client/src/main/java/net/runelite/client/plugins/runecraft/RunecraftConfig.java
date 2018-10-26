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

@ConfigGroup("runecraft")
public interface RunecraftConfig extends Config
{
	@ConfigItem(
		keyName = "showBindNeck",
		name = "Show Binding Neck charges",
		description = "Configures whether the binding neck charge is displayed",
		position = 2
	)
	default boolean showBindNeck()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRifts",
		name = "Show Rifts in Abyss",
		description = "Configures whether the rifts in the abyss will be displayed",
		position = 3
	)
	default boolean showRifts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAir",
		name = "Show Air rift",
		description = "Configures whether to display the air rift",
		position = 4
	)
	default boolean showAir()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBlood",
		name = "Show Blood rift",
		description = "Configures whether to display the Blood rift",
		position = 5
	)
	default boolean showBlood()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBody",
		name = "Show Body rift",
		description = "Configures whether to display the Body rift",
		position = 6
	)
	default boolean showBody()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showChaos",
		name = "Show Chaos rift",
		description = "Configures whether to display the Chaos rift",
		position = 7
	)
	default boolean showChaos()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCosmic",
		name = "Show Cosmic rift",
		description = "Configures whether to display the Cosmic rift",
		position = 8
	)
	default boolean showCosmic()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDeath",
		name = "Show Death rift",
		description = "Configures whether to display the Death rift",
		position = 9
	)
	default boolean showDeath()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showEarth",
		name = "Show Earth rift",
		description = "Configures whether to display the Earth rift",
		position = 10
	)
	default boolean showEarth()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFire",
		name = "Show Fire rift",
		description = "Configures whether to display the Fire rift",
		position = 11
	)
	default boolean showFire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLaw",
		name = "Show Law rift",
		description = "Configures whether to display the Law rift",
		position = 12
	)
	default boolean showLaw()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMind",
		name = "Show Mind rift",
		description = "Configures whether to display the Mind rift",
		position = 13
	)
	default boolean showMind()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showNature",
		name = "Show Nature rift",
		description = "Configures whether to display the Nature rift",
		position = 14
	)
	default boolean showNature()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSoul",
		name = "Show Soul rift",
		description = "Configures whether to display the Soul rift",
		position = 15
	)
	default boolean showSoul()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWater",
		name = "Show Water rift",
		description = "Configures whether to display the Water rift",
		position = 16
	)
	default boolean showWater()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showClickBox",
		name = "Show Rift click box",
		description = "Configures whether to display the click box of the rift",
		position = 17
	)
	default boolean showClickBox()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hightlightDarkMage",
		name = "Highlight Dark Mage NPC",
		description = "Configures whether to highlight the Dark Mage when pouches are degraded",
		position = 18
	)
	default boolean hightlightDarkMage()
	{
		return true;
	}

	@ConfigItem(
		keyName = "degradingNotification",
		name = "Notify when pouch degrades",
		description = "Send a notification when a pouch degrades",
		position = 19
	)
	default boolean degradingNotification()
	{
		return true;
	}
}
