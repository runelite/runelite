/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.theatre;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("Theatre")

public interface TheatreConfig extends Config
{
	@ConfigSection(
		position = 0,
		keyName = "maidenSection",
		name = "Maiden",
		description = ""
	)
	default boolean experimentalSection()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "showMaidenBloodToss",
		name = "Show Maiden Blood Toss",
		description = "Displays the tile location where tossed blood will land.",
		section = "maidenSection"
	)
	default boolean showMaidenBloodToss()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "showMaidenBloodSpawns",
		name = "Show Maiden Blood Spawns",
		description = "Show the tiles that blood spawns will travel to.",
		section = "maidenSection"
	)
	default boolean showMaidenBloodSpawns()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "showNyloFreezeHighlights",
		name = "Show Nylo Freeze Highlights",
		description = "Show when to freeze Nylos at maiden. Say n1,n2,s1,s2 in chat for it to register.",
		section = "maidenSection"
	)
	default boolean showNyloFreezeHighlights()
	{
		return true;
	}

	@ConfigSection(
		position = 4,
		keyName = "bloatSection",
		name = "Bloat",
		description = ""
	)
	default boolean bloatSection()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "showBloatIndicator",
		name = "Show Bloat Status",
		description = "Displays Bloat's status (asleep, wake, and enrage) using color code.",
		section = "bloatSection"
	)
	default boolean showBloatIndicator()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "showBloatHands",
		name = "Show Bloat Hands",
		description = "Highlights the falling hands inside Bloat.",
		section = "bloatSection"
	)
	default boolean showBloatHands()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "bloatFeet",
		name = "Bloat Hands Rave Edition",
		description = "",
		section = "bloatSection"
	)
	default boolean BloatFeetIndicatorRaveEdition()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "showBloatTimer",
		name = "Show Bloat Timer",
		description = "Show the estimated time when Bloat will go down.",
		section = "bloatSection"
	)
	default boolean showBloatTimer()
	{
		return false;
	}

	@ConfigSection(
		position = 9,
		keyName = "nylocasSection",
		name = "Nylocas",
		description = ""
	)
	default boolean nylocasSection()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "showNyloPillarHealth",
		name = "Show Nylocas Pillar Health",
		description = "Show the health bars of the Nylocas pillars.",
		section = "nylocasSection"
	)
	default boolean showNyloPillarHealth()
	{
		return true;
	}

	@ConfigItem(
		position = 11,
		keyName = "showNylocasExplosions",
		name = "Highlight Old Nylocas",
		description = "Either a timer on the nylo counting down to explosion, or a tile underneath.",
		section = "nylocasSection"
	)
	default NYLOOPTION showNylocasExplosions()
	{
		return NYLOOPTION.NONE;
	}

	@ConfigItem(
		position = 12,
		keyName = "showNylocasAmount",
		name = "Show Nylocas Amount",
		description = "An overlay will appear that counts the amount of Nylocas in the room.",
		section = "nylocasSection"
	)
	default boolean showNylocasAmount()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "nylocasMenuSwap",
		name = "Hide Nylocas wrong attack options",
		description = "hides attack options on small nylos of the wrong style",
		section = "nylocasSection"
	)
	default boolean nylocasMenuSwap()
	{
		return true;
	}

	/**
	 * @ConfigItem( position = 8,
	 * keyName = "showNylocasSpawns",
	 * name = "Show Nylocas Pre-spawns",
	 * description = "Know the contents of the next upcoming wave."
	 * )
	 * default boolean showNylocasSpawns()
	 * {
	 * return true;
	 * }
	 * @ConfigItem( position = 9,
	 * keyName = "highlightNyloRoles",
	 * name = "Highlight Nylo Prespawns",
	 * description = "Highlights the next upcoming wave based on role. FOR BEGINNERS"
	 * )
	 * default NYLOCAS highlightNyloRoles()
	 * {
	 * return NYLOCAS.NONE;
	 * }
	 * @ConfigItem( position = 10,
	 * keyName = "highlightNyloParents",
	 * name = "Show Nylo Parents (Un-used)",
	 * description = "Highlight the Nylocas that spawn outside the center."
	 * )
	 * default boolean highlightNyloParents()
	 * {
	 * return true;
	 * }
	 **/

	@ConfigItem(
		position = 14,
		keyName = "highlightNyloAgros",
		name = "Show Nylocas Agros",
		description = "Highlight the Nylocas that are aggressive to the player.",
		section = "nylocasSection"
	)
	default boolean highlightNyloAgros()
	{
		return true;
	}


	@ConfigSection(
		position = 15,
		keyName = "sotetsegSection",
		name = "Sotetseg",
		description = ""
	)
	default boolean sotetsegSection()
	{
		return false;
	}

	@ConfigItem(
		position = 16,
		keyName = "showSotetsegAttacks",
		name = "Show Sotetseg Attacks",
		description = "Highlight the attacks which Sotetseg throws at you.",
		section = "sotetsegSection"
	)
	default boolean showSotetsegAttacks()
	{
		return true;
	}

	@ConfigItem(
		position = 17,
		keyName = "showSotetsegMaze",
		name = "Mark Sotetseg Maze",
		description = "Marks the tiles of Sotetseg's maze while in the overworld.",
		section = "sotetsegSection"
	)
	default boolean showSotetsegMaze()
	{
		return true;
	}

	@ConfigItem(
		position = 18,
		keyName = "showSotetsegSolo",
		name = "Mark Sotetseg Maze (Solo)",
		description = "Marks the tiles of Sotetseg's maze while in the underworld.",
		section = "sotetsegSection"
	)
	default boolean showSotetsegSolo()
	{
		return true;
	}

	@ConfigItem(
		position = 19,
		keyName = "markerColor",
		name = "Sotey Tile Colour",
		description = "Configures the color of marked tile",
		section = "sotetsegSection"
	)
	default Color mazeTileColour()
	{
		return Color.WHITE;
	}

	@ConfigSection(
		position = 20,
		keyName = "xarpusSection",
		name = "Xarpus",
		description = ""
	)
	default boolean xarpusSection()
	{
		return false;
	}

	@ConfigItem(
		position = 21,
		keyName = "showXarpusHeals",
		name = "Show Xarpus Heals",
		description = "Highlights the tiles that Xarpus is healing with.",
		section = "xarpusSection"
	)
	default boolean showXarpusHeals()
	{
		return true;
	}

	@ConfigItem(
		position = 22,
		keyName = "showXarpusTick",
		name = "Show Xarpus Turn Tick",
		description = "Count down the ticks until Xarpus turns their head.",
		section = "xarpusSection"
	)
	default boolean showXarpusTick()
	{
		return true;
	}

	@ConfigSection(
		position = 23,
		keyName = "verzikSection",
		name = "Verzik",
		description = ""
	)
	default boolean verzikSection()
	{
		return false;
	}

	@ConfigItem(
		position = 24,
		keyName = "showVerzikAttacks",
		name = "Show Verzik Attack Tick",
		description = "Count down the ticks until Verzik attacks.",
		section = "verzikSection"
	)
	default boolean showVerzikAttacks()
	{
		return true;
	}

	@ConfigItem(
		position = 25,
		keyName = "showVerzikYellows",
		name = "Show Yellows Tick",
		description = "Count down the ticks until Verzik yellow's damage tick.",
		section = "verzikSection"
	)
	default boolean showVerzikYellows()
	{
		return true;
	}

	@ConfigItem(
		position = 26,
		keyName = "showCrabTargets",
		name = "Show Crab Targets",
		description = "Shows the target of crabs at Verzik.",
		section = "verzikSection"
	)
	default boolean showCrabTargets()
	{
		return true;
	}

	@ConfigItem(
		position = 27,
		keyName = "VerzikTankTile",
		name = "Verzik P3 Tile Overlay",
		description = "",
		section = "verzikSection"
	)
	default boolean VerzikTankTile()
	{
		return false;
	}

	@ConfigItem(
		position = 28,
		keyName = "verzikrangeattacks",
		name = "Show Verzik Range Attacks",
		description = "",
		section = "verzikSection"
	)
	default boolean verzikRangeAttacks()
	{
		return true;
	}

	@ConfigItem(
		position = 29,
		keyName = "extratimers",
		name = "Show Extra Timers",
		description = "",
		section = "verzikSection"
	)
	default boolean extraTimers()
	{
		return false;
	}

	@ConfigItem(
		position = 30,
		keyName = "p1attacks",
		name = "Verzik P1 Timer",
		description = "",
		section = "verzikSection"
	)
	default boolean p1attacks()
	{
		return true;
	}

	@ConfigItem(
		position = 31,
		keyName = "p2attacks",
		name = "Verzik P2 Timer",
		description = "",
		section = "verzikSection"
	)
	default boolean p2attacks()
	{
		return true;
	}

	@ConfigItem(
		position = 32,
		keyName = "p3attacks",
		name = "Verzik P3 Timer",
		description = "",
		section = "verzikSection"
	)
	default boolean p3attacks()
	{
		return true;
	}

	enum NYLOCAS
	{
		NONE,
		MAGE,
		MELEE,
		RANGER
	}

	enum NYLOOPTION
	{
		NONE,
		TILE,
		TIMER
	}
}