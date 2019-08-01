/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.gauntlet;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;
import net.runelite.client.config.Stub;

@ConfigGroup("Gauntlet")

public interface GauntletConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "resources",
		name = "Resources",
		description = ""
	)
	default Stub resources()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 1,
		keyName = "highlightResources",
		name = "Highlight Resources",
		description = "Highlights all the resources in each room with a color.",
		parent = "resources"
	)
	default boolean highlightResources()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "highlightResourcesColor",
		name = "Highlight Color",
		description = "Highlights all the resources in each room with this color.",
		parent = "resources",
		hidden = true,
		unhide = "highlightResources"
	)
	default Color highlightResourcesColor()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
		position = 3,
		keyName = "highlightResourcesIcons",
		name = "Highlight Resources with an Icon",
		description = "Highlights all the icons in each room with an icon.",
		parent = "resources",
		hidden = true,
		unhide = "highlightResources"
	)
	default boolean highlightResourcesIcons()
	{
		return true;
	}

	@Range(
		min = 1,
		max = 50
	)
	@ConfigItem(
		position = 4,
		keyName = "resourceIconSize",
		name = "Resource Icon Size",
		description = " change the size of resource icons.",
		hidden = true,
		unhide = "highlightResources",
		parent = "resources"
	)
	default int resourceIconSize()
	{
		return 20;
	}

	@ConfigItem(
		position = 5,
		keyName = "boss",
		name = "Boss",
		description = ""
	)
	default Stub boss()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 6,
		keyName = "countBossAttacks",
		name = "Count Boss Attacks",
		description = "Count the attacks until the boss switches their style.",
		parent = "boss"
	)
	default boolean countBossAttacks()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "countPlayerAttacks",
		name = "Count Player Attacks",
		description = "Count the player attacks until the boss switches their prayer.",
		parent = "boss"
	)
	default boolean countPlayerAttacks()
	{
		return true;
	}

	@ConfigItem(
		position = 8,
		keyName = "highlightWidget",
		name = "Highlight Correct Prayer",
		description = "Highlights correct prayer in your prayer book.",
		parent = "boss"
	)
	default boolean highlightWidget()
	{
		return true;
	}

	@ConfigItem(
		position = 8,
		keyName = "flashOnWrongAttack",
		name = "Flash on Wrong Attack",
		description = "This will flash your screen if you attack with the wrong stlye.",
		parent = "boss"
	)
	default boolean flashOnWrongAttack()
	{
		return true;
	}

	@ConfigItem(
		position = 9,
		keyName = "uniquePrayerAudio",
		name = "Unique Prayer Audio",
		description = "Plays a unique sound whenever the boss is about to shut down your prayer.",
		parent = "boss"
	)
	default boolean uniquePrayerAudio()
	{
		return true;
	}

	@ConfigItem(
		position = 10,
		keyName = "uniquePrayerVisual",
		name = "Unique Prayer Visual",
		description = "Prayer attacks will have a unique overlay visual.",
		parent = "boss"
	)
	default boolean uniquePrayerVisual()
	{
		return true;
	}

	@ConfigItem(
		position = 11,
		keyName = "uniqueAttackVisual",
		name = "Unique Magic & Range Visuals",
		description = "Magic and Range attacks will have a unique overlay visual.",
		parent = "boss"
	)
	default boolean uniqueAttackVisual()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "overlayBoss",
		name = "Overlay the Boss (Color)",
		description = "Overlay the boss with an color denoting it's current attack style.",
		parent = "boss"
	)
	default boolean overlayBoss()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "overlayBossPrayer",
		name = "Overlay the Boss (Icon)",
		description = "Overlay the boss with an icon denoting it's current attack style.",
		parent = "boss"
	)
	default boolean overlayBossPrayer()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "overlayTornadoes",
		name = "Show Tornado Decay",
		description = "Display the amount of ticks left until the tornadoes decay.",
		parent = "boss"
	)
	default boolean overlayTornadoes()
	{
		return true;
	}

	@Range(
		min = 1,
		max = 50
	)
	@ConfigItem(
		position = 15,
		keyName = "projectileIconSize",
		name = "Boss Projectile Icon Size",
		description = " change the size of Projectile icons.",
		parent = "boss"
	)
	default int projectileIconSize()
	{
		return 20;
	}

	@ConfigItem(
		position = 16,
		keyName = "timer",
		name = "Timer",
		description = ""
	)
	default Stub timer()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 17,
		keyName = "displayTimerWidget",
		name = "Show Custom Timer (Widget)",
		description = "Display a timer widget that tracks your gauntlet progress.",
		parent = "timer"
	)
	default boolean displayTimerWidget()
	{
		return true;
	}

	@ConfigItem(
		position = 18,
		keyName = "displayTimerChat",
		name = "Show Custom Timer (Chat)",
		description = "Display a chat message that tracks your gauntlet progress.",
		parent = "timer"
	)
	default boolean displayTimerChat()
	{
		return true;
	}
}
