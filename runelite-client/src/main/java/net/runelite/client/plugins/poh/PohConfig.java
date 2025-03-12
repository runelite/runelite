/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.poh;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Notification;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;

@ConfigGroup("poh")
public interface PohConfig extends Config
{
	@ConfigSection(
		name = "Incense burners",
		description = "All settings for incense burner overlays and notifications.",
		position = 1
	)
	String burnerSection = "burners";

	@ConfigItem(
		keyName = "showPortals",
		name = "Show portals",
		description = "Configures whether to display teleport portals."
	)
	default boolean showPortals()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAltar",
		name = "Show altar",
		description = "Configures whether or not the altar is displayed."
	)
	default boolean showAltar()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showGlory",
		name = "Show glory mount",
		description = "Configures whether or not the mounted glory is displayed."
	)
	default boolean showGlory()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPools",
		name = "Show pools",
		description = "Configures whether or not the pools are displayed."
	)
	default boolean showPools()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRepairStand",
		name = "Show repair stand",
		description = "Configures whether or not the repair stand is displayed."
	)
	default boolean showRepairStand()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showExitPortal",
		name = "Show exit portal",
		description = "Configures whether or not the exit portal is displayed."
	)
	default boolean showExitPortal()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSpellbook",
		name = "Show spellbook altar",
		description = "Configures whether or not the spellbook altar is displayed."
	)
	default boolean showSpellbook()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showJewelleryBox",
		name = "Show jewellery box",
		description = "Configures whether or not the jewellery box is displayed."
	)
	default boolean showJewelleryBox()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMagicTravel",
		name = "Show fairy/ spirit tree/ obelisk",
		description = "Configures whether or not the fairy ring, spirit tree or obelisk is displayed."
	)
	default boolean showMagicTravel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPortalNexus",
		name = "Show portal nexus",
		description = "Configures whether or not the portal nexus is displayed."
	)
	default boolean showPortalNexus()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDigsitePendant",
		name = "Show digsite pendant",
		description = "Configures whether or not the digsite pendant is displayed."
	)
	default boolean showDigsitePendant()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showXericsTalisman",
		name = "Show Xeric's talisman",
		description = "Configures whether or not the Xeric's talisman is displayed."
	)
	default boolean showXericsTalisman()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMythicalCape",
		name = "Show mythical cape",
		description = "Configures whether or not the mythical cape is displayed."
	)
	default boolean showMythicalCape()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBurner",
		name = "Show incense burner timers",
		description = "Configures whether or not unlit/lit burner timers are displayed.",
		section = burnerSection,
		position = 0
	)
	default boolean showBurner()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "burnerCertainTimerColor",
		name = "Certain timer color",
		description = "Configures the color for the certain burner timer.",
		section = burnerSection,
		position = 1
	)
	default Color burnerCertainTimerColor()
	{
		return Color.GREEN;
	}

	@Alpha
	@ConfigItem(
		keyName = "burnerRandomTimerColor",
		name = "Random timer color",
		description = "Configures the color for the random burner timer.",
		section = burnerSection,
		position = 2
	)
	default Color burnerRandomTimerColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		keyName = "burnerNotifyOnUnlit",
		name = "Notify on unlit burner",
		description = "Configures whether or not to notify you when lit burners become unlit.",
		section = burnerSection,
		position = 3
	)
	default Notification burnerNotifyOnUnlit()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "burnerNotifyOnExpiring",
		name = "Notify on expiring burner",
		description = "Configures whether or not to notify you when lit burners enter their random expiring phase.",
		section = burnerSection,
		position = 4
	)
	default Notification burnerNotifyOnExpiring()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "burnerNotificationLeadTime",
		name = "Notification lead time",
		description = "Configures how soon (in ticks) to preemptively send the expiring burner notification.",
		section = burnerSection,
		position = 5
	)
	@Range(
		max = 200 // 201 is the minimum certain timer duration at 1 Firemaking. Capped to avoid negative lead times.
	)
	@Units(Units.TICKS)
	default int burnerNotificationLeadTime()
	{
		return 0;
	}
}
