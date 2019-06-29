/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.theatre;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import java.awt.*;

@ConfigGroup("Theatre")

public interface TheatreConfig extends Config
{
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

	@ConfigItem(
		position = 0,
		keyName = "showMaidenBloodToss",
		name = "Show Maiden Blood Toss",
		description = "Displays the tile location where tossed blood will land.",
		group = "Maiden"
	)
	default boolean showMaidenBloodToss() 
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "showMaidenBloodSpawns",
		name = "Show Maiden Blood Spawns",
		description = "Show the tiles that blood spawns will travel to.",
		group = "Maiden"
	)
	default boolean showMaidenBloodSpawns() 
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "showBloatIndicator",
		name = "Show Bloat Status",
		description = "Displays Bloat's status (asleep, wake, and enrage) using color code.",
		group = "Bloat"
	)
	default boolean showBloatIndicator() 
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "showBloatHands",
		name = "Show Bloat Hands",
		description = "Highlights the falling hands inside Bloat.",
		group = "Bloat"
	)
	default boolean showBloatHands() 
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "bloatFeet",
		name = "Bloat Hands Rave Edition",
		description = "",
		group = "Bloat"
	)
	default boolean BloatFeetIndicatorRaveEdition() 
	{ 
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "showBloatTimer",
		name = "Show Bloat Timer",
		description = "Show the estimated time when Bloat will go down.",
		group = "Bloat"
	)
	default boolean showBloatTimer()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "showNyloPillarHealth",
		name = "Show Nylocas Pillar Health",
		description = "Show the health bars of the Nylocas pillars.",
		group = "Nylocas"
	)
	default boolean showNyloPillarHealth()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "showNylocasExplosions",
		name = "Highlight Old Nylocas",
		description = "Either a timer on the nylo counting down to explosion, or a tile underneath.",
		group = "Nylocas"
	)
	default NYLOOPTION showNylocasExplosions()
	{
		return NYLOOPTION.NONE;
	}

	@ConfigItem(
		position = 7,
		keyName = "showNylocasAmount",
		name = "Show Nylocas Amount",
		description = "An overlay will appear that counts the amount of Nylocas in the room.",
		group = "Nylocas"
	)
	default boolean showNylocasAmount() 
	{
		return true;
	}

	/**
	@ConfigItem(
		position = 8,
		keyName = "showNylocasSpawns",
		name = "Show Nylocas Pre-spawns",
		description = "Know the contents of the next upcoming wave."
	)
	default boolean showNylocasSpawns() 
	{
		return true;
	}

	@ConfigItem(
		position = 9,
		keyName = "highlightNyloRoles",
		name = "Highlight Nylo Prespawns",
		description = "Highlights the next upcoming wave based on role. FOR BEGINNERS"
	)
	default NYLOCAS highlightNyloRoles() 
	{
		return NYLOCAS.NONE;
	}

	@ConfigItem(
		position = 10,
		keyName = "highlightNyloParents",
		name = "Show Nylo Parents (Un-used)",
		description = "Highlight the Nylocas that spawn outside the center."
	)
	default boolean highlightNyloParents() 
	{
		return true;
	}
	**/

	@ConfigItem(
		position = 11,
		keyName = "highlightNyloAgros",
		name = "Show Nylocas Agros",
		description = "Highlight the Nylocas that are aggressive to the player.",
		group = "Nylocas"
	)
	default boolean highlightNyloAgros()
	{
		return true;
	}

	@ConfigItem(
		position = 12,
		keyName = "showSotetsegAttacks",
		name = "Show Sotetseg Attacks",
		description = "Highlight the attacks which Sotetseg throws at you.",
		group = "Sotetseg"
	)
	default boolean showSotetsegAttacks()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "showSotetsegMaze",
		name = "Mark Sotetseg Maze",
		description = "Marks the tiles of Sotetseg's maze while in the overworld.",
		group = "Sotetseg"
	)
	default boolean showSotetsegMaze()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "showSotetsegSolo",
		name = "Mark Sotetseg Maze (Solo)",
		description = "Marks the tiles of Sotetseg's maze while in the underworld.",
		group = "Sotetseg"
	)
	default boolean showSotetsegSolo() 
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "markerColor",
		name = "Sotey Tile Colour",
		description = "Configures the color of marked tile",
		group = "Sotetseg"
	)
	default Color mazeTileColour()
	{
		return Color.WHITE;
	}
	@ConfigItem(
		position = 15,
		keyName = "showXarpusHeals",
		name = "Show Xarpus Heals",
		description = "Highlights the tiles that Xarpus is healing with.",
		group = "Xarpus"
	)
	default boolean showXarpusHeals()
	{
		return true;
	}

	@ConfigItem(
		position = 16,
		keyName = "showXarpusTick",
		name = "Show Xarpus Turn Tick",
		description = "Count down the ticks until Xarpus turns their head.",
		group = "Xarpus"
	)
	default boolean showXarpusTick()
	{
		return true;
	}

	@ConfigItem(
		position = 17,
		keyName = "showVerzikAttacks",
		name = "Show Verzik Attack Tick",
		description = "Count down the ticks until Verzik attacks.",
		group = "Verzik"
	)
	default boolean showVerzikAttacks()
	{
		return true;
	}

	@ConfigItem(
		position = 18,
		keyName = "showVerzikYellows",
		name = "Show Yellows Tick",
		description = "Count down the ticks until Verzik yellow's damage tick.",
		group = "Verzik"
	)
	default boolean showVerzikYellows()
	{
		return true;
	}

	@ConfigItem(
		position = 19,
		keyName = "showCrabTargets",
		name = "Show Crab Targets",
		description = "Shows the target of crabs at Verzik.",
		group = "Verzik"
	)
	default boolean showCrabTargets()
	{
		return true;
	}

	@ConfigItem(
		position = 20,
		keyName = "VerzikTankTile",
		name = "Verzik P3 Tile Overlay",
		description = "",
		group = "Verzik"
	)
	default boolean VerzikTankTile()
	{ 
		return false;
	}
	
	@ConfigItem(
		position = 22,
		keyName = "verzikrangeattacks",
		name = "Show Verzik Range Attacks",
		description = "",
		group = "Verzik"
	)
	default boolean verzikRangeAttacks()
	{ 
	return true;
	}
	
	@ConfigItem(
		position = 23,
		keyName = "extratimers",
		name = "Show Extra Timers",
		description = "",
		group = "Verzik"
	)
	default boolean extraTimers()
	{
		return false;
	}
	
	@ConfigItem(
		position = 24,
		keyName = "p1attacks",
		name = "Verzik P1 Timer",
		description = "",
		group = "Verzik"
	)
	default boolean p1attacks()
	{
		return true;
	}
	
	@ConfigItem(
		position = 25,
		keyName = "p2attacks",
		name = "Verzik P2 Timer",
		description = "",
		group = "Verzik"
	)
	default boolean p2attacks()
	{
		return true;
	}
	
	@ConfigItem(
		position = 26,
		keyName = "p3attacks",
		name = "Verzik P3 Timer",
		description = "",
		group = "Verzik"
	)
	default boolean p3attacks()
	{
		return true;
	}
}