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
package net.runelite.client.plugins.timers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "timers",
	name = "Timers",
	description = "Configuration for the timers plugin"
)
public interface TimersConfig extends Config
{
	@ConfigItem(
		keyName = "showStamina",
		name = "Stamina timer",
		description = "Configures whether stamina timer is displayed"
	)
	default boolean showStamina()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAntiFire",
		name = "AntiFire timer",
		description = "Configures whether antifire timer is displayed"
	)
	default boolean showAntiFire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showExAntiFire",
		name = "Extended antifire timer",
		description = "Configures whether extended antifire timer is displayed"
	)
	default boolean showExAntiFire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showOverload",
		name = "Overload timer",
		description = "Configures whether overload timer is displayed"
	)
	default boolean showOverload()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCannon",
		name = "Cannon timer",
		description = "Configures whether cannon timer is displayed"
	)
	default boolean showCannon()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMagicImbue",
		name = "Magic imbue timer",
		description = "Configures whether magic imbue timer is displayed"
	)
	default boolean showMagicImbue()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTeleblock",
		name = "Teleblock timer",
		description = "Configures whether teleblock timer is displayed"
	)
	default boolean showTeleblock()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAntiVenomPlus",
		name = "Anti-venom+ timer",
		description = "Configures whether anti venom+ timer is displayed"
	)
	default boolean showAntiVenomPlus()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSuperAntiFire",
		name = "Super antifire timer",
		description = "Configures whether super antifire timer is displayed"
	)
	default boolean showSuperAntiFire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAntidotePlusPlus",
		name = "Antidote++ timer",
		description = "Configures whether antidote++ timer is displayed"
	)
	default boolean showAntidotePlusPlus()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showImbuedHeart",
		name = "Imbued heart timer",
		description = "Configures whether imbued heart timer is displayed"
	)
	default boolean showImbuedHeart()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showVengeance",
		name = "Vengeance timer",
		description = "Configures whether vengeance timer is displayed"
	)
	default boolean showVengeance()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFreezes",
		name = "Freeze timer",
		description = "Configures whether freeze timer is displayed"
	)
	default boolean showFreezes()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showExSuperAntifire",
		name = "Extended super antifire timer",
		description = "Configures whether extended super antifire timer is displayed"
	)
	default boolean showExSuperAntifire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSanfew",
		name = "Sanfew serum timer",
		description = "Configures whether sanfew serum timer is displayed"
	)
	default boolean showSanfew()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAntidotePlus",
		name = "Antidote+ timer",
		description = "Configures whether antidote+ timer is displayed"
	)
	default boolean showAntidotePlus()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAntiVenom",
		name = "Anti-venom timer",
		description = "Configures whether antivenom timer is displayed"
	)
	default boolean showAntiVenom()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPrayerEnhance",
		name = "Prayer enhance timer",
		description = "Configures whether prayer enhance timer is displayed"
	)
	default boolean showPrayerEnhance()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showGodWarsAltar",
		name = "God wars altar timer",
		description = "Configures whether god wars altar timer is displayed"
	)
	default boolean showGodWarsAltar()
	{
		return true;
	}
}
