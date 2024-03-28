/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * Copyright (c) 2019, Aleios <https://github.com/aleios>
 * Copyright (c) 2020, Unmoon <https://github.com/unmoon>
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
package net.runelite.client.plugins.itemcharges;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(ItemChargeConfig.GROUP)
public interface ItemChargeConfig extends Config
{
	String GROUP = "itemCharge";

	String KEY_AMULET_OF_BOUNTY = "amuletOfBounty";
	String KEY_AMULET_OF_CHEMISTRY = "amuletOfChemistry";
	String KEY_BINDING_NECKLACE = "bindingNecklace";
	String KEY_BRACELET_OF_SLAUGHTER = "braceletOfSlaughter";
	String KEY_CHRONICLE = "chronicle";
	String KEY_DODGY_NECKLACE = "dodgyNecklace";
	String KEY_EXPEDITIOUS_BRACELET = "expeditiousBracelet";
	String KEY_EXPLORERS_RING = "explorerRing";
	String KEY_RING_OF_FORGING = "ringOfForging";
	String KEY_BLOOD_ESSENCE = "bloodEssence";
	String KEY_BRACELET_OF_CLAY = "braceletOfClay";

	@ConfigSection(
		name = "Charge Settings",
		description = "Configuration for which charges should be displayed",
		position = 98
	)
	String chargesSection = "charges";

	@ConfigSection(
		name = "Notification Settings",
		description = "Configuration for notifications",
		position = 99
	)
	String notificationSection = "notifications";

	@ConfigItem(
		keyName = "veryLowWarningColor",
		name = "Very Low Warning",
		description = "The color of the overlay when charges are very low",
		position = 1
	)
	default Color veryLowWarningColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "lowWarningColor",
		name = "Low Warning",
		description = "The color of the overlay when charges are low",
		position = 2
	)
	default Color lowWarningolor()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
		keyName = "veryLowWarning",
		name = "Very Low Warning",
		description = "The charge count for the very low warning color",
		position = 3
	)
	default int veryLowWarning()
	{
		return 1;
	}

	@ConfigItem(
		keyName = "lowWarning",
		name = "Low Warning",
		description = "The charge count for the low warning color",
		position = 4
	)
	default int lowWarning()
	{
		return 2;
	}

	@ConfigItem(
		keyName = "showTeleportCharges",
		name = "Teleport Charges",
		description = "Show teleport item charge counts",
		position = 5,
		section = chargesSection
	)
	default boolean showTeleportCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDodgyCount",
		name = "Dodgy Necklace Count",
		description = "Show Dodgy necklace charges",
		position = 6,
		section = chargesSection
	)
	default boolean showDodgyCount()
	{
		return true;
	}

	@ConfigItem(
		keyName = "dodgyNotification",
		name = "Dodgy Necklace Notification",
		description = "Send a notification when a Dodgy necklace breaks",
		position = 7,
		section = notificationSection
	)
	default boolean dodgyNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showImpCharges",
		name = "Imp-in-a-box charges",
		description = "Show Imp-in-a-box item charges",
		position = 8,
		section = chargesSection
	)
	default boolean showImpCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFungicideCharges",
		name = "Fungicide Charges",
		description = "Show Fungicide item charges",
		position = 9,
		section = chargesSection
	)
	default boolean showFungicideCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWateringCanCharges",
		name = "Watering Can Charges",
		description = "Show Watering can item charges",
		position = 10,
		section = chargesSection
	)
	default boolean showWateringCanCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWaterskinCharges",
		name = "Waterskin Charges",
		description = "Show Waterskin dose counts",
		position = 11,
		section = chargesSection
	)
	default boolean showWaterskinCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBellowCharges",
		name = "Bellows Charges",
		description = "Show Ogre bellows item charges",
		position = 12,
		section = chargesSection
	)
	default boolean showBellowCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBasketCharges",
		name = "Basket Charges",
		description = "Show Fruit basket item counts",
		position = 13,
		section = chargesSection
	)
	default boolean showBasketCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSackCharges",
		name = "Sack Charges",
		description = "Show Sack item counts",
		position = 14,
		section = chargesSection
	)
	default boolean showSackCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAbyssalBraceletCharges",
		name = "Abyssal Bracelet Charges",
		description = "Show Abyssal bracelet item charges",
		position = 15,
		section = chargesSection
	)
	default boolean showAbyssalBraceletCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAmuletOfChemistryCharges",
		name = "Amulet of Chemistry Charges",
		description = "Show Amulet of chemistry item charges",
		position = 16,
		section = chargesSection
	)
	default boolean showAmuletOfChemistryCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAmuletOfBountyCharges",
		name = "Amulet of Bounty Charges",
		description = "Show Amulet of bounty item charges",
		position = 17,
		section = chargesSection
	)
	default boolean showAmuletOfBountyCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recoilNotification",
		name = "Ring of Recoil Notification",
		description = "Send a notification when a Ring of recoil breaks",
		position = 18,
		section = notificationSection
	)
	default boolean recoilNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showBindingNecklaceCharges",
		name = "Binding Necklace Charges",
		description = "Show Binding necklace item charges",
		position = 19,
		section = chargesSection
	)
	default boolean showBindingNecklaceCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "bindingNotification",
		name = "Binding Necklace Notification",
		description = "Send a notification when a Binding necklace breaks",
		position = 20,
		section = notificationSection
	)
	default boolean bindingNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showExplorerRingCharges",
		name = "Explorer's Ring Alch Charges",
		description = "Show Explorer's ring alchemy charges",
		position = 21,
		section = chargesSection
	)
	default boolean showExplorerRingCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRingOfForgingCount",
		name = "Ring of Forging Charges",
		description = "Show Ring of forging item charges",
		position = 22,
		section = chargesSection
	)
	default boolean showRingOfForgingCount()
	{
		return true;
	}

	@ConfigItem(
		keyName = "ringOfForgingNotification",
		name = "Ring of Forging Notification",
		description = "Send a notification when a Ring of forging breaks",
		position = 23,
		section = notificationSection
	)
	default boolean ringOfForgingNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showInfoboxes",
		name = "Infoboxes",
		description = "Show an infobox with remaining charges for equipped items",
		position = 24
	)
	default boolean showInfoboxes()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showPotionDoseCount",
		name = "Potion Doses",
		description = "Show remaining potion doses",
		position = 25,
		section = chargesSection
	)
	default boolean showPotionDoseCount()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showBraceletOfSlaughterCharges",
		name = "Bracelet of Slaughter Charges",
		description = "Show Bracelet of Slaughter item charges",
		position = 26,
		section = chargesSection
	)
	default boolean showBraceletOfSlaughterCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "slaughterNotification",
		name = "Bracelet of Slaughter Notification",
		description = "Send a notification when a Bracelet of Slaughter breaks",
		position = 27,
		section = notificationSection
	)
	default boolean slaughterNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showExpeditiousBraceletCharges",
		name = "Expeditious Bracelet Charges",
		description = "Show Expeditious Bracelet item charges",
		position = 28,
		section = chargesSection
	)
	default boolean showExpeditiousBraceletCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "expeditiousNotification",
		name = "Expeditious Bracelet Notification",
		description = "Send a notification when an Expeditious Bracelet breaks",
		position = 29,
		section = notificationSection
	)
	default boolean expeditiousNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showGuthixRestDoses",
		name = "Guthix Rest Doses",
		description = "Show Guthix Rest doses",
		position = 29,
		section = chargesSection
	)
	default boolean showGuthixRestDoses()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBloodEssenceCharges",
		name = "Blood Essence Charges",
		description = "Show Blood Essence charges",
		position = 30,
		section = chargesSection
	)
	default boolean showBloodEssenceCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBraceletOfClayCharges",
		name = "Bracelet of Clay Charges",
		description = "Show Bracelet of Clay item charges",
		position = 31,
		section = chargesSection
	)
	default boolean showBraceletOfClayCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "braceletOfClayNotification",
		name = "Bracelet of Clay Notification",
		description = "Send a notification when a Bracelet of Clay breaks",
		position = 32,
		section = notificationSection
	)
	default boolean braceletOfClayNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "amuletOfChemistryNotification",
		name = "Amulet of Chemistry Notification",
		description = "Send a notification when an Amulet of Chemistry breaks",
		position = 33,
		section = notificationSection
	)
	default boolean amuletOfChemistryNotification()
	{
		return true;
	}
}
