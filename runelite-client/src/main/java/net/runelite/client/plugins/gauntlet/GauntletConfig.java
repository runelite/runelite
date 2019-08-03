/*
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

package net.runelite.client.plugins.gauntlet;

import java.awt.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;
import net.runelite.client.config.Stub;

@ConfigGroup("Gauntlet")

public interface GauntletConfig extends Config
{
	@Getter
	@AllArgsConstructor
	enum CounterDisplay
	{
		ONBOSS("On Boss"),
		INFOBOX("Info Box"),
		BOTH("Both"),
		NONE("None");

		private String name;

		@Override
		public String toString()
		{
			return getName();
		}
	}

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
		name = "Highlight Resources (Outline)",
		description = "Highlights all the resources in each room with an outline.",
		parent = "resources"
	)
	default boolean highlightResources()
	{
		return false;
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
		name = "Highlight Resources (Icon)",
		description = "Highlights all the icons in each room with an icon.",
		parent = "resources",
		hidden = true,
		unhide = "highlightResources"
	)
	default boolean highlightResourcesIcons()
	{
		return false;
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
		keyName = "countAttacks",
		name = "Count Attacks Display",
		description = "Count the attacks until the Hunllef switches their attack style and prayer.",
		parent = "boss"
	)
	default CounterDisplay countAttacks()
	{
		return CounterDisplay.NONE;
	}

	@ConfigItem(
		position = 7,
		keyName = "highlightWidget",
		name = "Highlight Prayer (Prayer Tab)",
		description = "Highlights the correct prayer to use in your prayer book.",
		parent = "boss"
	)
	default boolean highlightWidget()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "highlightPrayerInfobox",
		name = "Highlight Prayer (InfoBox)",
		description = "Highlights the correct prayer to use in an Infobox.",
		parent = "boss"
	)
	default boolean highlightPrayerInfobox()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "flashOnWrongAttack",
		name = "Flash screen on Wrong Attack",
		description = "This will flash your screen if you attack with the wrong stlye.",
		parent = "boss"
	)
	default boolean flashOnWrongAttack()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "uniquePrayerAudio",
		name = "Prayer Audio Warning",
		description = "Plays a unique sound whenever the boss is about to shut down your prayer.",
		parent = "boss"
	)
	default boolean uniquePrayerAudio()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "uniquePrayerVisual",
		name = "Prayer Attack (Icon)",
		description = "Prayer attacks will have a unique overlay visual.",
		parent = "boss"
	)
	default boolean uniquePrayerVisual()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "uniqueAttackVisual",
		name = "Magic & Range Attack (Icon)",
		description = "Magic and Range attacks will have a unique overlay visual.",
		parent = "boss"
	)
	default boolean uniqueAttackVisual()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "attackVisualOutline",
		name = "Hunllefs' attacks (Outline)",
		description = "Outline the Hunllefs' attacks.",
		parent = "boss"
	)
	default boolean attackVisualOutline()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "overlayBoss",
		name = "Outline Hunllef (Color)",
		description = "Overlay Hunllef while you are on the wrong prayer with an color denoting it's current attack style.",
		parent = "boss"
	)
	default boolean overlayBoss()
	{
		return false;
	}


	@ConfigItem(
		position = 15,
		keyName = "overlayBossPrayer",
		name = "Hunllef Overlay (Icons)",
		description = "Overlay the Hunllef with an icon denoting it's current attack style.",
		parent = "boss"
	)
	default boolean overlayBossPrayer()
	{
		return false;
	}

	@ConfigItem(
		position = 16,
		keyName = "overlayTornadoes",
		name = "Show Tornado Decay",
		description = "Display the amount of ticks left until the tornadoes decay.",
		parent = "boss"
	)
	default boolean overlayTornadoes()
	{
		return false;
	}

	@Range(
		min = 1,
		max = 50
	)
	@ConfigItem(
		position = 17,
		keyName = "projectileIconSize",
		name = "Hunllef Projectile Icon Size",
		description = " change the size of Projectile icons.",
		parent = "boss"
	)
	default int projectileIconSize()
	{
		return 20;
	}

	@ConfigItem(
		position = 18,
		keyName = "timer",
		name = "Timer",
		description = ""
	)
	default Stub timer()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 19,
		keyName = "displayTimerWidget",
		name = "Show Gauntlet timer overlay",
		description = "Display a timer widget that tracks your gauntlet progress.",
		parent = "timer"
	)
	default boolean displayTimerWidget()
	{
		return false;
	}

	@ConfigItem(
		position = 20,
		keyName = "displayTimerChat",
		name = "Show Gauntlet timer chat message",
		description = "Display a chat message that tracks your gauntlet progress.",
		parent = "timer"
	)
	default boolean displayTimerChat()
	{
		return false;
	}
}
