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

@ConfigGroup(
	keyName = "runecraft",
	name = "Runecraft",
	description = "Configuration for the runecrafting plugin"
)
public interface RunecraftConfig extends Config
{
	@ConfigItem(
		keyName = "showPouch",
		name = "Show Pouch count",
		description = "Configures whether the pouch ess count is displayed"
	)
	default boolean showPouch()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBindNeck",
		name = "Show Binding Neck charges",
		description = "Configures whether the binding neck charge is displayed"
	)
	default boolean showBindNeck()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRifts",
		name = "Show Rifts in Abyss",
		description = "Configures whether the rifts in the abyss will be displayed"
	)
	default boolean showRifts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAir",
		name = "Show Air rift",
		description = "Configures whether to display the air rift"
	)
	default boolean showAir()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBlood",
		name = "Show Blood rift",
		description = "Configures whether to display the Blood rift"
	)
	default boolean showBlood()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBody",
		name = "Show Body rift",
		description = "Configures whether to display the Body rift"
	)
	default boolean showBody()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showChaos",
		name = "Show Chaos rift",
		description = "Configures whether to display the Chaos rift"
	)
	default boolean showChaos()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCosmic",
		name = "Show Cosmic rift",
		description = "Configures whether to display the Cosmic rift"
	)
	default boolean showCosmic()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDeath",
		name = "Show Death rift",
		description = "Configures whether to display the Death rift"
	)
	default boolean showDeath()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showEarth",
		name = "Show Earth rift",
		description = "Configures whether to display the Earth rift"
	)
	default boolean showEarth()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFire",
		name = "Show Fire rift",
		description = "Configures whether to display the Fire rift"
	)
	default boolean showFire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLaw",
		name = "Show Law rift",
		description = "Configures whether to display the Law rift"
	)
	default boolean showLaw()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMind",
		name = "Show Mind rift",
		description = "Configures whether to display the Mind rift"
	)
	default boolean showMind()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showNature",
		name = "Show Nature rift",
		description = "Configures whether to display the Nature rift"
	)
	default boolean showNature()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSoul",
		name = "Show Soul rift",
		description = "Configures whether to display the Soul rift"
	)
	default boolean showSoul()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWater",
		name = "Show Water rift",
		description = "Configures whether to display the Water rift"
	)
	default boolean showWater()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showClickBox",
		name = "Show Rift click box",
		description = "Configures whether to display the click box of the rift"
	)
	default boolean showClickBox()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hightlightDarkMage",
		name = "Highlight Dark Mage NPC",
		description = "Configures whether to highlight the Dark Mage when pouches are degraded"
	)
	default boolean hightlightDarkMage()
	{
		return true;
	}
}
