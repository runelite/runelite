/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.zcox;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("Cox")

public interface CoxConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "Muttadile",
		name = "Muttadile Marker",
		description = ""
	)
	default boolean Muttadile()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "Tekton",
		name = "Tekton Marker",
		description = ""
	)
	default boolean Tekton()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "Guardians",
		name = "Guardians timing",
		description = ""
	)
	default boolean Guardians()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "OlmSpec",
		name = "Olm Next Spec",
		description = ""
	)
	default boolean OlmSpec()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "OlmTick",
		name = "Olm Tick Counter",
		description = ""
	)
	default boolean OlmTick()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "OlmCrystals",
		name = "Olm AoE Indicator",
		description = ""
	)
	default boolean OlmCrystals()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "LargeCrystals",
		name = "Mark Large AoE Crystals rather then small ones",
		description = ""
	)
	default boolean LargeCrystals()
	{
		return true;
	}

}
