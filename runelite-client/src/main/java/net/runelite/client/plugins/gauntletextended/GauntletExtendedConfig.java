/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, kThisIsCvpv <https://github.com/kThisIsCvpv>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/Kyleeld>
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

package net.runelite.client.plugins.gauntletextended;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup("gauntlet")
public interface GauntletExtendedConfig extends Config
{
	// Sections
	@ConfigSection(
		name = "Resources",
		description = "Resources section.",
		position = 0
	)
	String resourcesSection = "Resources";

	@ConfigSection(
		name = "Utilities",
		description = "Utilities section.",
		position = 1
	)
	String utilitiesSection = "Utilities";

	@ConfigSection(
		name = "Npcs",
		description = "Other npcs section.",
		position = 2
	)
	String npcSection = "Npcs";

	@ConfigSection(
		name = "Hunllef",
		description = "Hunllef section.",
		position = 3
	)
	String hunllefSection = "Hunllef";

	@ConfigSection(
		name = "Projectiles",
		description = "Projectiles section.",
		position = 4
	)
	String projectilesSection = "Projectiles";

	@ConfigSection(
		name = "Tornadoes",
		description = "Tornadoes section.",
		position = 5
	)
	String tornadoesSection = "Tornadoes";

	@ConfigSection(
		name = "Player",
		description = "Player section.",
		position = 6
	)
	String playerSection = "Player";

	@ConfigSection(
		name = "Timer",
		description = "Timer section.",
		position = 7
	)
	String timerSection = "Timer";

	@ConfigSection(
		name = "Other",
		description = "Other section.",
		position = 8
	)
	String otherSection = "Other";

	// Resources Section

	@ConfigItem(
		name = "Overlay resource icon and tile",
		description = "Overlay resources with a respective icon and tile outline.",
		position = 0,
		keyName = "resourceOverlay",
		section = resourcesSection
	)
	default boolean resourceOverlay()
	{
		return false;
	}

	@Range(
		min = 12,
		max = 64
	)
	@ConfigItem(
		name = "Icon size",
		description = "Change the size of the resource icons.",
		position = 1,
		keyName = "resourceIconSize",
		section = resourcesSection
	)

	default int resourceIconSize()
	{
		return 18;
	}

	@Range(
		min = 1,
		max = 8
	)
	@ConfigItem(
		name = "Tile outline width",
		description = "Change the width of the resource tile outline.",
		position = 2,
		keyName = "resourceTileOutlineWidth",
		section = resourcesSection
	)

	default int resourceTileOutlineWidth()
	{
		return 1;
	}

	@Alpha
	@ConfigItem(
		name = "Tile outline color",
		description = "Change the tile outline color of resources.",
		position = 3,
		keyName = "resourceTileOutlineColor",
		section = resourcesSection
	)
	default Color resourceTileOutlineColor()
	{
		return Color.YELLOW;
	}

	@Alpha
	@ConfigItem(
		name = "Tile fill color",
		description = "Change the tile fill color of resources.",
		position = 4,
		keyName = "resourceTileFillColor",
		section = resourcesSection
	)
	default Color resourceTileFillColor()
	{
		return new Color(255, 255, 255, 50);
	}

	@ConfigItem(
		name = "Outline resources",
		description = "Outline resources with a colored outline.",
		position = 5,
		keyName = "resourceOutline",
		section = resourcesSection
	)
	default boolean resourceOutline()
	{
		return false;
	}

	@Range(
		min = 1,
		max = 8
	)
	@ConfigItem(
		name = "Outline width",
		description = "Change the width of the resource outline.",
		position = 6,
		keyName = "resourceOutlineWidth",
		section = resourcesSection
	)

	default int resourceOutlineWidth()
	{
		return 1;
	}

	@Alpha
	@ConfigItem(
		name = "Outline color",
		description = "Change the outline color of resources.",
		position = 7,
		keyName = "resourceOutlineColor",
		section = resourcesSection
	)
	default Color resourceOutlineColor()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
		name = "Track resources",
		description = "Track resources in counter infoboxes.",
		position = 8,
		keyName = "resourceTracker",
		section = resourcesSection
	)
	default ResourceFilter resourceTracker()
	{
		return ResourceFilter.OFF;
	}

	@ConfigItem(
		name = "Ore",
		description = "The desired number of ores to acquire.",
		position = 9,
		keyName = "resourceOre",
		section = resourcesSection
	)
	default int resourceOre()
	{
		return 3;
	}

	@ConfigItem(
		name = "Phren bark",
		description = "The desired number of phren barks to acquire.",
		position = 10,
		keyName = "resourceBark",
		section = resourcesSection
	)
	default int resourceBark()
	{
		return 3;
	}

	@ConfigItem(
		name = "Linum tirinum",
		description = "The desired number of linum tirinums to acquire.",
		position = 11,
		keyName = "resourceTirinum",
		section = resourcesSection
	)
	default int resourceTirinum()
	{
		return 3;
	}

	@ConfigItem(
		name = "Grym leaf",
		description = "The desired number of grym leaves to acquire.",
		position = 12,
		keyName = "resourceGrym",
		section = resourcesSection
	)
	default int resourceGrym()
	{
		return 2;
	}

	@ConfigItem(
		name = "Weapon frames",
		description = "The desired number of weapon frames to acquire.",
		position = 13,
		keyName = "resourceFrame",
		section = resourcesSection
	)
	default int resourceFrame()
	{
		return 2;
	}

	@ConfigItem(
		name = "Paddlefish",
		description = "The desired number of paddlefish to acquire.",
		position = 14,
		keyName = "resourcePaddlefish",
		section = resourcesSection
	)
	default int resourcePaddlefish()
	{
		return 20;
	}

	@ConfigItem(
		name = "Crystal shards",
		description = "The desired number of crystal shards to acquire.",
		position = 15,
		keyName = "resourceShard",
		section = resourcesSection
	)
	default int resourceShard()
	{
		return 320;
	}

	@ConfigItem(
		name = "Bowstring",
		description = "Whether or not to acquire the crystalline or corrupted bowstring.",
		position = 16,
		keyName = "resourceBowstring",
		section = resourcesSection
	)
	default boolean resourceBowstring()
	{
		return false;
	}

	@ConfigItem(
		name = "Spike",
		description = "Whether or not to acquire the crystal or corrupted spike.",
		position = 17,
		keyName = "resourceSpike",
		section = resourcesSection
	)
	default boolean resourceSpike()
	{
		return false;
	}

	@ConfigItem(
		name = "Orb",
		description = "Whether or not to acquire the crystal or corrupted orb.",
		position = 18,
		keyName = "resourceOrb",
		section = resourcesSection
	)
	default boolean resourceOrb()
	{
		return false;
	}

	// Utilities Section

	@ConfigItem(
		name = "Outline starting room utilities",
		description = "Outline various utilities in the starting room.",
		position = 0,
		keyName = "utilitiesOutline",
		section = utilitiesSection
	)
	default boolean utilitiesOutline()
	{
		return false;
	}

	@Range(
		min = 2,
		max = 12
	)
	@ConfigItem(
		name = "Outline width",
		description = "Change the width of the utilities outline.",
		position = 1,
		keyName = "utilitiesOutlineWidth",
		section = utilitiesSection
	)

	default int utilitiesOutlineWidth()
	{
		return 4;
	}

	@Alpha
	@ConfigItem(
		name = "Outline color",
		description = "Change the color of the utilities outline.",
		position = 2,
		keyName = "utilitiesOutlineColor",
		section = utilitiesSection
	)
	default Color utilitiesOutlineColor()
	{
		return Color.MAGENTA;
	}

	// Other Npcs Section

	@ConfigItem(
		name = "Outline demi-bosses",
		description = "Overlay demi-bosses with a colored outline.",
		position = 0,
		keyName = "demibossOutline",
		section = npcSection
	)
	default boolean demibossOutline()
	{
		return false;
	}

	@Range(
		min = 2,
		max = 12
	)
	@ConfigItem(
		name = "Outline width",
		description = "Change the width of the demi-boss outline.",
		position = 1,
		keyName = "demibossOutlineWidth",
		section = npcSection
	)

	default int demibossOutlineWidth()
	{
		return 4;
	}

	@ConfigItem(
		name = "Outline strong npcs",
		description = "Overlay strong npcs with a colored outline.",
		position = 2,
		keyName = "strongNpcOutline",
		section = npcSection
	)
	default boolean strongNpcOutline()
	{
		return false;
	}

	@Range(
		min = 2,
		max = 12
	)
	@ConfigItem(
		name = "Outline width",
		description = "Change the width of the strong npcs outline.",
		position = 3,
		keyName = "strongNpcOutlineWidth",
		section = npcSection
	)

	default int strongNpcOutlineWidth()
	{
		return 2;
	}

	@Alpha
	@ConfigItem(
		name = "Outline color",
		description = "Change the outline color of strong npcs.",
		position = 4,
		keyName = "strongNpcOutlineColor",
		section = npcSection
	)
	default Color strongNpcOutlineColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		name = "Outline weak npcs",
		description = "Overlay weak npcs with a colored outline.",
		position = 5,
		keyName = "weakNpcOutline",
		section = npcSection
	)
	default boolean weakNpcOutline()
	{
		return false;
	}

	@Range(
		min = 2,
		max = 12
	)
	@ConfigItem(
		name = "Outline width",
		description = "Change the width of the weak npcs outline.",
		position = 6,
		keyName = "weakNpcOutlineWidth",
		section = npcSection
	)

	default int weakNpcOutlineWidth()
	{
		return 2;
	}

	@Alpha
	@ConfigItem(
		name = "Outline color",
		description = "Change the outline color of weak npcs.",
		position = 7,
		keyName = "weakNpcOutlineColor",
		section = npcSection
	)
	default Color weakNpcOutlineColor()
	{
		return Color.CYAN;
	}

	// Hunllef Section

	@ConfigItem(
		name = "Display counter on Hunllef",
		description = "Overlay the Hunllef with an attack and prayer counter.",
		position = 0,
		keyName = "hunllefOverlayAttackCounter",
		section = hunllefSection
	)
	default boolean hunllefOverlayAttackCounter()
	{
		return false;
	}

	@ConfigItem(
		name = "Counter font style",
		description = "Change the font style of the attack and prayer counter.",
		position = 1,
		keyName = "hunllefAttackCounterFontStyle",
		section = hunllefSection,
		hidden = true
	)
	default FontStyle hunllefAttackCounterFontStyle()
	{
		return FontStyle.BOLD;
	}

	@Range(
		min = 12,
		max = 64
	)
	@ConfigItem(
		name = "Counter font size",
		description = "Adjust the font size of the attack and prayer counter.",
		position = 2,
		keyName = "hunllefAttackCounterFontSize",
		section = hunllefSection
	)

	default int hunllefAttackCounterFontSize()
	{
		return 22;
	}

	@ConfigItem(
		name = "Outline Hunllef on wrong prayer",
		description = "Outline the Hunllef when incorrectly praying against its current attack style.",
		position = 3,
		keyName = "hunllefOverlayWrongPrayerOutline",
		section = hunllefSection
	)
	default boolean hunllefOverlayWrongPrayerOutline()
	{
		return false;
	}

	@Range(
		min = 2,
		max = 12
	)
	@ConfigItem(
		name = "Outline width",
		description = "Change the width of the wrong prayer outline.",
		position = 4,
		keyName = "hunllefWrongPrayerOutlineWidth",
		section = hunllefSection
	)

	default int hunllefWrongPrayerOutlineWidth()
	{
		return 4;
	}

	@ConfigItem(
		name = "Outline Hunllef tile",
		description = "Outline the Hunllef's tile.",
		position = 5,
		keyName = "hunllefOutlineTile",
		section = hunllefSection
	)
	default boolean hunllefOutlineTile()
	{
		return false;
	}

	@Range(
		min = 1,
		max = 8
	)
	@ConfigItem(
		name = "Tile outline width",
		description = "Change the width of the Hunllef's tile outline.",
		position = 6,
		keyName = "hunllefTileOutlineWidth",
		section = hunllefSection
	)

	default int hunllefTileOutlineWidth()
	{
		return 1;
	}

	@Alpha
	@ConfigItem(
		name = "Tile outline color",
		description = "Change the outline color of the Hunllef's tile.",
		position = 7,
		keyName = "hunllefOutlineColor",
		section = hunllefSection
	)
	default Color hunllefOutlineColor()
	{
		return Color.WHITE;
	}

	@Alpha
	@ConfigItem(
		name = "Tile fill color",
		description = "Change the fill color of the Hunllef's tile.",
		position = 8,
		keyName = "hunllefFillColor",
		section = hunllefSection
	)
	default Color hunllefFillColor()
	{
		return new Color(255, 255, 255, 0);
	}

	@ConfigItem(
		name = "Overlay style icon on Hunllef",
		description = "Overlay a current attack style icon on the Hunllef.",
		position = 9,
		keyName = "hunllefOverlayAttackStyleIcon",
		section = hunllefSection
	)
	default boolean hunllefOverlayAttackStyleIcon()
	{
		return false;
	}

	@Range(
		min = 12,
		max = 64
	)
	@ConfigItem(
		name = "Icon size",
		description = "Change the size of the attack style icon.",
		position = 10,
		keyName = "hunllefAttackStyleIconSize",
		section = hunllefSection
	)

	default int hunllefAttackStyleIconSize()
	{
		return 18;
	}

	@ConfigItem(
		name = "Play audio on prayer attack",
		description = "Play an in-game sound when the Hunllef is about to use its prayer attack.",
		position = 11,
		keyName = "hunllefPrayerAudio",
		section = hunllefSection
	)
	default boolean hunllefPrayerAudio()
	{
		return false;
	}

	// Projectiles Section

	@ConfigItem(
		name = "Outline projectiles",
		description = "Outline projectiles with a blue (magic) or green (range) color.",
		position = 0,
		keyName = "outlineProjectile",
		section = projectilesSection
	)
	default boolean outlineProjectile()
	{
		return false;
	}

	@ConfigItem(
		name = "Overlay projectile icons",
		description = "Overlay projectiles with their respective icon.",
		position = 1,
		keyName = "overlayProjectileIcon",
		section = projectilesSection
	)
	default boolean overlayProjectileIcon()
	{
		return false;
	}

	@Range(
		min = 12,
		max = 64
	)
	@ConfigItem(
		name = "Icon size",
		description = "Change the size of the projectile icons.",
		position = 2,
		keyName = "projectileIconSize",
		section = projectilesSection
	)

	default int projectileIconSize()
	{
		return 18;
	}

	// Tornadoes Section

	@ConfigItem(
		name = "Overlay tornado tick counter",
		description = "Overlay tornadoes with a tick counter.",
		position = 0,
		keyName = "tornadoTickCounter",
		section = tornadoesSection
	)
	default boolean tornadoTickCounter()
	{
		return false;
	}

	@ConfigItem(
		name = "Font style",
		description = "Bold/Italics/Plain",
		position = 1,
		keyName = "tornadoFontStyle",
		section = tornadoesSection,
		hidden = true
	)
	default FontStyle tornadoFontStyle()
	{
		return FontStyle.BOLD;
	}

	@ConfigItem(
		name = "Font shadow",
		description = "Toggle font shadow of the tornado tick counter.",
		position = 2,
		keyName = "tornadoFontShadow",
		section = tornadoesSection
	)
	default boolean tornadoFontShadow()
	{
		return true;
	}

	@Range(
		min = 12,
		max = 64
	)
	@ConfigItem(
		name = "Font size",
		description = "Adjust the font size of the tornado tick counter.",
		position = 3,
		keyName = "tornadoFontSize",
		section = tornadoesSection
	)

	default int tornadoFontSize()
	{
		return 16;
	}

	@Alpha
	@ConfigItem(
		name = "Font color",
		description = "Color of the tornado tick counter font.",
		position = 4,
		keyName = "tornadoFontColor",
		section = tornadoesSection
	)
	default Color tornadoFontColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		name = "Outline tornado tile",
		description = "Outline the tiles of tornadoes.",
		position = 5,
		keyName = "tornadoTileOutline",
		section = tornadoesSection
	)
	default boolean tornadoTileOutline()
	{
		return false;
	}

	@Range(
		min = 1,
		max = 8
	)
	@ConfigItem(
		name = "Tile outline width",
		description = "Change tile outline width of tornadoes.",
		position = 6,
		keyName = "tornadoTileOutlineWidth",
		section = tornadoesSection
	)

	default int tornadoTileOutlineWidth()
	{
		return 1;
	}

	@Alpha
	@ConfigItem(
		name = "Tile outline color",
		description = "Color to outline the tile of a tornado.",
		position = 7,
		keyName = "tornadoOutlineColor",
		section = tornadoesSection
	)
	default Color tornadoOutlineColor()
	{
		return Color.YELLOW;
	}

	@Alpha
	@ConfigItem(
		name = "Tile fill color",
		description = "Color to fill the tile of a tornado.",
		position = 8,
		keyName = "tornadoFillColor",
		section = tornadoesSection
	)
	default Color tornadoFillColor()
	{
		return new Color(255, 255, 0, 50);
	}

	// Player Section

	@ConfigItem(
		name = "Overlay prayer",
		description = "Overlay the correct prayer to use against the Hunllef's current attack style.",
		position = 0,
		keyName = "prayerOverlay",
		section = playerSection
	)
	default PrayerHighlightMode prayerOverlay()
	{
		return PrayerHighlightMode.NONE;
	}

	@ConfigItem(
		name = "Flash on wrong attack style",
		description = "Flash the screen if you use the wrong attack style.",
		position = 1,
		keyName = "flashOnWrongAttack",
		section = playerSection
	)
	default boolean flashOnWrongAttack()
	{
		return false;
	}

	@Range(
		min = 10,
		max = 50
	)
	@ConfigItem(
		name = "Flash duration",
		description = "Change the duration of the flash.",
		position = 2,
		keyName = "flashOnWrongAttackDuration",
		section = playerSection
	)
	default int flashOnWrongAttackDuration()
	{
		return 25;
	}

	@Alpha
	@ConfigItem(
		name = "Flash color",
		description = "Color of the flash notification.",
		position = 3,
		keyName = "flashOnWrongAttackColor",
		section = playerSection
	)
	default Color flashOnWrongAttackColor()
	{
		return new Color(255, 0, 0, 70);
	}

	@ConfigItem(
		name = "Flash on 5:1 method",
		description = "Flash the screen to weapon switch when using 5:1 method.",
		position = 4,
		keyName = "flashOn51Method",
		section = playerSection
	)
	default boolean flashOn51Method()
	{
		return false;
	}

	@Range(
		min = 10,
		max = 50
	)
	@ConfigItem(
		name = "Flash duration",
		description = "Change the duration of the flash.",
		position = 5,
		keyName = "flashOn51MethodDuration",
		section = playerSection
	)
	default int flashOn51MethodDuration()
	{
		return 25;
	}

	@Alpha
	@ConfigItem(
		name = "Flash color",
		description = "Color of the flash notification.",
		position = 6,
		keyName = "flashOn51MethodColor",
		section = playerSection
	)
	default Color flashOn51MethodColor()
	{
		return new Color(255, 190, 0, 50);
	}

	// Timer Section

	@ConfigItem(
		position = 0,
		keyName = "timerOverlay",
		name = "Overlay timer",
		description = "Display an overlay that tracks your gauntlet time.",
		section = timerSection
	)
	default boolean timerOverlay()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "timerChatMessage",
		name = "Chat timer",
		description = "Display a chat message on death with your gauntlet time.",
		section = timerSection
	)
	default boolean timerChatMessage()
	{
		return false;
	}

	// Other Section

	@ConfigItem(
		name = "Render distance",
		description = "Set render distance of various overlays.",
		position = 0,
		keyName = "resourceRenderDistance",
		section = otherSection
	)
	default RenderDistance resourceRenderDistance()
	{
		return RenderDistance.FAR;
	}

	@ConfigItem(
		name = "Disco mode",
		description = "Kill the Hunllef.",
		position = 1,
		keyName = "discoMode",
		section = otherSection
	)
	default boolean discoMode()
	{
		return false;
	}

	// Constants

	@Getter
	@AllArgsConstructor
	enum RenderDistance
	{
		SHORT("Short", 2350),
		MEDIUM("Medium", 3525),
		FAR("Far", 4700),
		UNCAPPED("Uncapped", 0);

		private final String name;
		private final int distance;

		@Override
		public String toString()
		{
			return name;
		}
	}

	@Getter
	@AllArgsConstructor
	enum FontStyle
	{
		BOLD("Bold", Font.BOLD),
		ITALIC("Italic", Font.ITALIC),
		PLAIN("Plain", Font.PLAIN);

		private final String name;
		private final int font;

		@Override
		public String toString()
		{
			return name;
		}
	}

	@AllArgsConstructor
	enum PrayerHighlightMode
	{
		WIDGET("Widget"),
		BOX("Box"),
		BOTH("Both"),
		NONE("None");

		private final String name;

		@Override
		public String toString()
		{
			return name;
		}
	}

	enum ResourceFilter
	{
		ALL, BASIC, CUSTOM, OFF
	}
}
