/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * Copyright (c) 2019, Aleios <https://github.com/aleios>
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

@ConfigGroup("itemCharge")
public interface ItemChargeConfig extends Config
{
	@ConfigItem(
		keyName = "veryLowWarningColor",
		name = "Very Low Warning Color",
		description = "Configure the color of the overlay when charges are very low",
		position = 1
	)
	default Color veryLowWarningColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "lowWarningColor",
		name = "Low Warning Color",
		description = "Configure the color of the overlay when charges are low",
		position = 2
	)
	default Color lowWarningolor()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
		keyName = "veryLowWarning",
		name = "Very Low Warning",
		description = "Configure the charge count for the very low warning color",
		position = 3
	)
	default int veryLowWarning()
	{
		return 1;
	}

	@ConfigItem(
		keyName = "lowWarning",
		name = "Low Warning",
		description = "Configure the charge count for the low warning color",
		position = 4
	)
	default int lowWarning()
	{
		return 2;
	}

	@ConfigItem(
		keyName = "showTeleportCharges",
		name = "Show Teleport Charges",
		description = "Configures if teleport item count is shown",
		position = 5
	)
	default boolean showTeleportCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDodgyCount",
		name = "Dodgy Necklace Count",
		description = "Configures if Dodgy Necklace charge count is shown",
		position = 6
	)
	default boolean showDodgyCount()
	{
		return true;
	}

	@ConfigItem(
		keyName = "dodgyNotification",
		name = "Dodgy Necklace Notification",
		description = "Configures if the dodgy necklace breaking notification is shown",
		position = 7
	)
	default boolean dodgyNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "dodgyNecklace",
		name = "",
		description = "",
		hidden = true
	)
	default int dodgyNecklace()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "dodgyNecklace",
		name = "",
		description = ""
	)
	void dodgyNecklace(int dodgyNecklace);

	@ConfigItem(
		keyName = "showImpCharges",
		name = "Show Imp-in-a-box charges",
		description = "Configures if imp-in-a-box item charges is shown",
		position = 8
	)
	default boolean showImpCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFungicideCharges",
		name = "Show Fungicide Charges",
		description = "Configures if fungicide item charges is shown",
		position = 9
	)
	default boolean showFungicideCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWateringCanCharges",
		name = "Show Watering Can Charges",
		description = "Configures if watering can item charge is shown",
		position = 10
	)
	default boolean showWateringCanCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWaterskinCharges",
		name = "Show Waterskin Charges",
		description = "Configures if waterskin item charge is shown",
		position = 11
	)
	default boolean showWaterskinCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBellowCharges",
		name = "Show Bellow Charges",
		description = "Configures if ogre bellow item charge is shown",
		position = 12
	)
	default boolean showBellowCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAbyssalBraceletCharges",
		name = "Show Abyssal Bracelet Charges",
		description = "Configures if abyssal bracelet item charge is shown",
		position = 13
	)
	default boolean showAbyssalBraceletCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recoilNotification",
		name = "Ring of Recoil Notification",
		description = "Configures if the ring of recoil breaking notification is shown",
		position = 14
	)
	default boolean recoilNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showBindingNecklaceCharges",
		name = "Show Binding Necklace Charges",
		description = "Configures if binding necklace item charge is shown",
		position = 15
	)
	default boolean showBindingNecklaceCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "bindingNecklace",
		name = "",
		description = "",
		hidden = true
	)
	default int bindingNecklace()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "bindingNecklace",
		name = "",
		description = ""
	)
	void bindingNecklace(int bindingNecklace);

	@ConfigItem(
		keyName = "bindingNotification",
		name = "Binding Necklace Notification",
		description = "Configures if the binding necklace breaking notification is shown",
		position = 16
	)
	default boolean bindingNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showExplorerRingCharges",
		name = "Show Explorer's Ring Alch Charges",
		description = "Configures if explorer's ring alchemy charges are shown",
		position = 17
	)
	default boolean showExplorerRingCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "explorerRing",
		name = "",
		description = "",
		hidden = true
	)
	default int explorerRing()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "explorerRing",
		name = "",
		description = ""
	)
	void explorerRing(int explorerRing);

	@ConfigItem(
		keyName = "showSlayerBracelets",
		name = "Show Slayer Bracelets Charges",
		description = "Configures if slayer bracelets' item charges are shown",
		position = 18
	)
	default boolean showSlayerBracelets()
	{
		return true;
	}


	@ConfigItem(
		keyName = "expeditious",
		name = "",
		description = "",
		hidden = true
	)
	default int expeditious()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "expeditious",
		name = "",
		description = ""
	)
	void expeditious(int expeditious);

	@ConfigItem(
		keyName = "slaughter",
		name = "",
		description = "",
		hidden = true
	)
	default int slaughter()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "slaughter",
		name = "",
		description = ""
	)
	void slaughter(int slaughter);


	@ConfigItem(
		keyName = "xericTalisman",
		name = "",
		description = "",
		hidden = true
	)
	default int xericTalisman()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "xericTalisman",
		name = "",
		description = ""
	)
	void xericTalisman(int xericTalisman);

	@ConfigItem(
		keyName = "showSoulBearerCharges",
		name = "Show Soul Bearer Charges",
		description = "Configures if Soul Bearer item charge is shown",
		position = 19
	)
	default boolean showSoulBearerCharges()
	{
		return false;
	}

	@ConfigItem(
		keyName = "soulBearer",
		name = "",
		description = "",
		hidden = true
	)
	default int soulBearer()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "soulBearer",
		name = "",
		description = ""
	)
	void soulBearer(int soulBearer);

	@ConfigItem(
		keyName = "showChronicleCharges",
		name = "Show Chronicle Charges",
		description = "Configures if Chronicle item charge is shown",
		position = 20
	)
	default boolean showChronicleCharges()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showXericTalismanCharges",
		name = "Show Xeric's Talisman Charges",
		description = "Configures if Xeric's Talisman item charge is shown",
		position = 21
	)
	default boolean showXericTalismanCharges()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showrecoil",
		name = "Show If Recoil is activated",
		description = "Configures if Recoil is activated",
		position = 22
	)
	default boolean showrecoil()
	{
		return false;
	}

	@ConfigItem(
		keyName = "chronicle",
		name = "",
		description = "",
		hidden = true
	)
	default int chronicle()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "chronicle",
		name = "",
		description = ""
	)
	void chronicle(int chronicle);

	@ConfigItem(
		keyName = "showRingOfForgingCount",
		name = "Show Ring of Forging Charges",
		description = "Configures if the Ring of Forging charge count is shown",
		position = 23
	)
	default boolean showRingOfForgingCount()
	{
		return true;
	}

	@ConfigItem(
		keyName = "ringOfForging",
		name = "",
		description = "",
		hidden = true
	)
	default int ringOfForging()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "ringOfForging",
		name = "",
		description = ""
	)
	void ringOfForging(int ringOfForging);

	@ConfigItem(
		keyName = "ringOfForgingNotification",
		name = "Ring of Forging Notification",
		description = "Configures if the Ring of Forging breaking notification is enabled",
		position = 24
	)
	default boolean ringOfForgingNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSackCharges",
		name = "Show Sack Quantity",
		description = "Configures if the number of vegetables in sacks is shown",
		position = 25
	)
	default boolean showSackCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBasketCharges",
		name = "Show Basket Quantity",
		description = "Configures if the number of fruit in a basket is shown",
		position = 26
	)
	default boolean showBasketCharges()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showInfoboxes",
		name = "Show Infoboxes",
		description = "Configures whether to show an infobox equipped charge items",
		position = 27
	)
	default boolean showInfoboxes()
	{
		return false;
	}
}
