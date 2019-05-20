/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.ztob;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Stub;

@ConfigGroup("Theatre")

public interface TheatreConfig extends Config
{
	@ConfigItem(
		keyName = "maidenStub",
		name = "Maiden",
		description = "",
		position = 0
	)
	default Stub maidenStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 1,
		keyName = "MaidenBlood",
		name = "Maiden blood attack",
		description = "",
		parent = "maidenStub"
	)
	default boolean MaidenBlood()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "MaidenSpawns",
		name = "Maiden blood spawns",
		description = "",
		parent = "maidenStub"
	)
	default boolean MaidenSpawns()
	{
		return true;
	}

	@ConfigItem(
		keyName = "bloatStub",
		name = "Bloat",
		description = "",
		position = 3
	)
	default Stub bloatStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 4,
		keyName = "BloatIndicator",
		name = "Bloat Indicator",
		description = "",
		parent = "bloatStub"
	)
	default boolean BloatIndicator()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "bloat Timer",
		name = "Bloat Timer",
		description = "",
		parent = "bloatStub"
	)
	default boolean bloatTimer()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "bloatFeet",
		name = "Bloat Feet",
		description = "",
		parent = "bloatStub"
	)
	default boolean bloatFeetIndicator()
	{
		return true;
	}

	@ConfigItem(
		keyName = "nylocasStub",
		name = "Nylocas",
		description = "",
		position = 7
	)
	default Stub NylocasStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 8,
		keyName = "NyloPillars",
		name = "Nylocas pillar health",
		description = "",
		parent = "nylocasStub"
	)
	default boolean NyloPillars()
	{
		return true;
	}


	@ConfigItem(
		position = 9,
		keyName = "NyloBlasts",
		name = "Nylocas explosions",
		description = "",
		parent = "nylocasStub"
	)
	default boolean NyloBlasts()
	{
		return true;
	}

	@ConfigItem(
		position = 10,
		keyName = "NyloMenu",
		name = "Hide Attack options for Nylocas",
		description = "",
		parent = "nylocasStub"
	)

	default boolean NyloMenu()
	{
		return true;
	}

	@ConfigItem(
		keyName = "sotetsegStub",
		name = "Sotetseg",
		description = "",
		position = 11
	)
	default Stub sotetsegStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 12,
		keyName = "highlightSote",
		name = "Sotetseg Missiles",
		description = "Highlight Sotetseg's Missiles with pray type",
		parent = "sotetsegStub"
	)
	default boolean highlightSote()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "SotetsegMaze1",
		name = "Sotetseg maze",
		description = "",
		parent = "sotetsegStub"
	)
	default boolean SotetsegMaze1()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "SotetsegMaze2",
		name = "Sotetseg maze (solo mode)",
		description = "",
		parent = "sotetsegStub"
	)
	default boolean SotetsegMaze2()
	{
		return true;
	}

	@ConfigItem(
		keyName = "xarpusStub",
		name = "Xarpus",
		description = "",
		position = 15
	)
	default Stub xarpusStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 16,
		keyName = "XarpusExhumed",
		name = "Xarpus Exhumed",
		description = "",
		parent = "xarpusStub"
	)
	default boolean XarpusExhumed()
	{
		return true;
	}

	@ConfigItem(
		position = 17,
		keyName = "XarpusTick",
		name = "Xarpus Tick",
		description = "",
		parent = "xarpusStub"
	)
	default boolean XarpusTick()
	{
		return false;
	}

	@ConfigItem(
		position = 18,
		keyName = "xarpusExhumes",
		name = "Xarpus Exhume Counter",
		description = "",
		parent = "xarpusStub"
	)
	default boolean XarpusExhumeOverlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "verzikStub",
		name = "Verzik",
		description = "",
		position = 19
	)
	default Stub verzikStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 20,
		keyName = "VerzikCupcakes",
		name = "Verzik Projectile Markers",
		description = "",
		parent = "verzikStub"
	)
	default boolean VerzikCupcakes()
	{
		return false;
	}

	@ConfigItem(
		position = 21,
		keyName = "VerzikTick",
		name = "Verzik P3 Tick",
		description = "",
		parent = "verzikStub"
	)
	default boolean VerzikTick()
	{
		return false;
	}

	@ConfigItem(
		position = 22,
		keyName = "VerzikMelee",
		name = "Verzik P3 Melee Range",
		description = "",
		parent = "verzikStub"
	)
	default boolean VerzikMelee()
	{
		return false;
	}

	@ConfigItem(
		position = 23,
		keyName = "VerzikYellow",
		name = "Verzik Yellow Timing",
		description = "",
		parent = "verzikStub"
	)
	default boolean VerzikYellow()
	{
		return false;
	}

	@ConfigItem(
		keyName = "verzikOverlayStub",
		name = "Overlay",
		description = "",
		position = 24,
		parent = "verzikStub"
	)
	default Stub verzikOverlayStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 25,
		keyName = "Verzik Nylo",
		name = "Verzik Nylo Overlay",
		description = "",
		parent = "verzikOverlayStub"
	)
	default boolean NyloTargetOverlay()
	{
		return false;
	}

	@ConfigItem(
		position = 26,
		keyName = "VerzikTankTile",
		name = "Verzik P3 Tile Overlay",
		description = "",
		parent = "verzikOverlayStub"
	)
	default boolean verzikTankTile()
	{
		return true;
	}
}