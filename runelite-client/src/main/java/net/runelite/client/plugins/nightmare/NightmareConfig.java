/*
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
package net.runelite.client.plugins.nightmare;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;

@ConfigGroup("nightmareOfAshihama")
public interface NightmareConfig extends Config
{
	@ConfigSection(
		name = "General",
		description = "Configure general settings.",
		position = 0
	)
	String generalSection = "General";

	@ConfigSection(
		name = "Totems",
		description = "Configure Totems settings.",
		position = 1
	)
	String totemsSection = "Totems";

	@ConfigSection(
		name = "Shadows",
		description = "Configure Shadows settings.",
		position = 2
	)
	String shadowsSection = "Shadows";

	@ConfigSection(
		name = "Spores",
		description = "Configure Spores settings.",
		position = 3
	)
	String sporesSection = "Spores";

	@ConfigSection(
		name = "Parasites",
		description = "Configure Parasites settings.",
		position = 4
	)
	String parasitesSection = "Parasites";

	@ConfigSection(
		name = "Husk",
		description = "Configure Husk settings.",
		position = 5
	)
	String huskSection = "Husk";

	@ConfigSection(
		name = "Charge",
		description = "Configure Charge settings.",
		position = 6
	)
	String chargeSection = "Charge";

	//GENERAL SECTION
	@ConfigItem(
		keyName = "prayerHelper",
		name = "Prayer helper",
		description = "Displays the correct prayer to use at various points in the fight.",
		position = 0,
		section = generalSection
	)
	default PrayerDisplay prayerHelper()
	{
		return PrayerDisplay.BOTH;
	}

	@ConfigItem(
		keyName = "tickCounter",
		name = "Show Ticks",
		description = "Displays the number of ticks until next attack",
		position = 1,
		section = generalSection
	)
	default boolean ticksCounter()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideAttackNightmareTotems",
		name = "Hide Attack during Totems",
		description = "Remove the attack option on Nightmare during Totems",
		position = 2,
		section = generalSection
	)
	default boolean hideAttackNightmareTotems()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideAttackNightmareParasites",
		name = "Hide Attack during Parasites",
		description = "Remove the attack option on Nightmare during Parasites",
		position = 3,
		section = generalSection
	)
	default boolean hideAttackNightmareParasites()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideAttackNightmareHusk",
		name = "Hide Attack during Husks",
		description = "Remove the attack option on Nightmare during Husks",
		position = 4,
		section = generalSection
	)
	default boolean hideAttackNightmareHusk()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideAttackNightmareSleepwalkers",
		name = "Hide Attack during Sleepwalkers",
		description = "Remove the attack option on Nightmare during Sleepwalkers (not on last phase of Phosanis)",
		position = 5,
		section = generalSection
	)
	default boolean hideAttackNightmareSleepwalkers()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideAttackSleepwalkers",
		name = "Hide Attack Sleepwalkers Last Phase",
		description = "Remove the attack option on Sleepwalkers during the last phase of Phosanis",
		position = 6,
		section = generalSection
	)
	default boolean hideAttackSleepwalkers()
	{
		return false;
	}

	//TOTEMS SECTION
	@ConfigItem(
		keyName = "highlightTotems",
		name = "Highlight Totems",
		description = "Highlights Totems based on their status",
		position = 0,
		section = totemsSection
	)
	default boolean highlightTotems()
	{
		return true;
	}

	@Range(
		min = 1,
		max = 10
	)
	@ConfigItem(
		name = "Totem Outline Size",
		description = "Change the size of the totem outline.",
		position = 1,
		keyName = "totemOutlineSize",
		section = totemsSection,
		hidden = true
	)
	default int totemOutlineSize()
	{
		return 3;
	}

	//SHADOWS SECTION
	@ConfigItem(
		keyName = "highlightShadows",
		name = "Highlight Shadows",
		description = "Highlights the Shadow Attacks",
		position = 0,
		section = shadowsSection
	)
	default boolean highlightShadows()
	{
		return true;
	}

	@ConfigItem(
		keyName = "shadowsTickCounter",
		name = "Shadows Tick Counter",
		description = "Displays the number of ticks until shadows do damage",
		position = 1,
		section = shadowsSection
	)
	default boolean shadowsTickCounter()
	{
		return true;
	}

	@Range(
		max = 20,
		min = 1
	)
	@ConfigItem(
		keyName = "shadowsRenderDistance",
		name = "Render Distance",
		description = "Render shadows distance in tiles from your player",
		position = 2,
		section = shadowsSection
	)
	@Units("tiles")
	default int shadowsRenderDistance()
	{
		return 5;
	}

	@Alpha
	@ConfigItem(
		keyName = "shadowsBorderColour",
		name = "Shadows border colour",
		description = "Colour the edges of the area highlighted by shadows",
		position = 3,
		section = shadowsSection
	)
	default Color shadowsBorderColour()
	{
		return new Color(0, 255, 255, 100);
	}

	@Alpha
	@ConfigItem(
		keyName = "shadowsColour",
		name = "Shadows colour",
		description = "Colour for shadows highlight",
		position = 4,
		section = shadowsSection
	)
	default Color shadowsColour()
	{
		return new Color(0, 255, 255, 50);
	}

	//SPORES SECTION
	@ConfigItem(
		keyName = "highlightSpores",
		name = "Highlight Spores",
		description = "Highlights spores that will make you yawn",
		position = 0,
		section = sporesSection
	)
	default boolean highlightSpores()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "poisonBorderCol",
		name = "Poison border colour",
		description = "Colour the edges of the area highlighted by poison special will be",
		position = 1,
		section = sporesSection
	)
	default Color poisonBorderCol()
	{
		return new Color(255, 0, 0, 100);
	}

	@Alpha
	@ConfigItem(
		keyName = "poisonCol",
		name = "Poison colour",
		description = "Colour the fill of the area highlighted by poison special will be",
		position = 2,
		section = sporesSection
	)
	default Color poisonCol()
	{
		return new Color(255, 0, 0, 50);
	}

	@ConfigItem(
		keyName = "yawnInfoBox",
		name = "Yawn InfoBox",
		description = "InfoBox telling you the time until your yawning ends",
		position = 3,
		section = sporesSection
	)
	default boolean yawnInfoBox()
	{
		return true;
	}

	//PARASITES SECTION
	@ConfigItem(
		keyName = "showTicksUntilParasite",
		name = "Indicate Parasites",
		description = "Displays a red tick timer on any impregnated players",
		position = 0,
		section = parasitesSection
	)
	default boolean showTicksUntilParasite()
	{
		return true;
	}

	@ConfigItem(
		keyName = "parasitesInfoBox",
		name = "Parasites InfoBox",
		description = "InfoBox telling you the time until parasites",
		position = 1,
		section = parasitesSection
	)
	default boolean parasitesInfoBox()
	{
		return true;
	}

	@ConfigItem(
		keyName = "sanfewReminder",
		name = "Sanfew Reminder",
		description = "Overlay that reminds you to drink a sanfew when impregnated",
		position = 2,
		section = parasitesSection
	)
	default boolean sanfewReminder()
	{
		return true;
	}

	@ConfigItem(
		keyName = "flash",
		name = "Flash screen when impregnated",
		description = "Your Screen flashes when the nightmare infects you with her parasite",
		position = 3,
		section = parasitesSection
	)
	default boolean flash()
	{
		return false;
	}

	//HUSK SECTION
	@ConfigItem(
		keyName = "highlightHusk",
		name = "Highlight Husk",
		description = "Highlights the mage and range husk",
		position = 0,
		section = huskSection
	)
	default boolean huskHighlight()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightHuskTarget",
		name = "Highlight Husk Target(s)",
		description = "Highlights whoever the husks will spawn on",
		position = 1,
		section = huskSection
	)
	default boolean highlightHuskTarget()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "huskBorderCol",
		name = "Husk Target Border Color",
		description = "Colour the edges of the area highlighted by poison special will be",
		position = 2,
		section = huskSection
	)

	default Color huskBorderCol()
	{
		return new Color(255, 0, 0, 100);
	}

	//CHARGE SECTION
	@ConfigItem(
		keyName = "highlightNightmareHitboxOnCharge",
		name = "Highlight Nightmare's Hitbox On Charge",
		description = "Highlights the hitbox of the Nightmare when she charges",
		position = 0,
		section = chargeSection
	)
	default boolean highlightNightmareHitboxOnCharge()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightNightmareChargeRange",
		name = "Highlight Nightmare's Charge Range",
		description = "Highlights the range the Nightmare will damage you with her charge attack",
		position = 1,
		section = chargeSection
	)
	default boolean highlightNightmareChargeRange()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "nightmareChargeBorderCol",
		name = "Nightmare Charge Border Color",
		description = "Color the edges of the area highlighted by the nightmare's charge attack",
		position = 2,
		section = chargeSection
	)

	default Color nightmareChargeBorderCol()
	{
		return new Color(255, 0, 0, 100);
	}

	@Alpha
	@ConfigItem(
		keyName = "nightmareChargeCol",
		name = "Nightmare charge fill color",
		description = "Color the fill of the area highlighted by the nightmare's charge attack",
		position = 3,
		section = chargeSection
	)
	default Color nightmareChargeCol()
	{
		return new Color(255, 0, 0, 50);
	}

	enum PrayerDisplay
	{
		PRAYER_TAB,
		BOTTOM_RIGHT,
		BOTH;

		public boolean showInfoBox()
		{
			switch (this)
			{
				case BOTTOM_RIGHT:
				case BOTH:
					return true;
				default:
					return false;
			}
		}

		public boolean showWidgetHelper()
		{
			switch (this)
			{
				case PRAYER_TAB:
				case BOTH:
					return true;
				default:
					return false;
			}
		}
	}
}
