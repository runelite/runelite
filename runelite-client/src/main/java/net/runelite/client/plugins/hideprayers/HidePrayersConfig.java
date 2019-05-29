/*
 * Copyright (c) 2018, https://runelitepl.us
 * Copyright (c) 2019, Kyle <https://github.com/kyleeld>
 * Copyright (c) 2018, Raiever <https://github.com/Raieverr>
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

package net.runelite.client.plugins.hideprayers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.hideprayers.util.Armadyl;
import net.runelite.client.plugins.hideprayers.util.Bandos;
import net.runelite.client.plugins.hideprayers.util.Barrows;
import net.runelite.client.plugins.hideprayers.util.Cerberus;
import net.runelite.client.plugins.hideprayers.util.PVPPrayers;
import net.runelite.client.plugins.hideprayers.util.Saradomin;
import net.runelite.client.plugins.hideprayers.util.Vorkath;
import net.runelite.client.plugins.hideprayers.util.Zamorak;
import net.runelite.client.plugins.hideprayers.util.Zulrah;

@ConfigGroup("hideprayers")
public interface HidePrayersConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "showindividualprayers",
		name = "Hide Individual Prayers",
		description = "Hide/Show Prayers.",
		group = "Individual Prayers",
		disabledBy = "getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean showindividualprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "HideTHICK_SKIN",
		name = "Hide Thick Skin",
		description = "Hide/Show Thick Skin",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideTHICK_SKIN()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "HideBURST_OF_STRENGTH",
		name = "Hide Burst of Strength",
		description = "Hide/Show Burst of Strength",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideBURST_OF_STRENGTH()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "HideCLARITY_OF_THOUGHT",
		name = "Hide Clarity of Thought",
		description = "Hide/Show Clarity of Thought",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideCLARITY_OF_THOUGHT()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "HideSHARP_EYE",
		name = "Hide Sharp Eye",
		description = "Hide/Show Sharp Eye",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideSHARP_EYE()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "HideMYSTIC_WILL",
		name = "Hide Mystic Will",
		description = "Hide/Show Mystic Will",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideMYSTIC_WILL()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "HideROCK_SKIN",
		name = "Hide Rock Skin",
		description = "Hide/Show Rock Skin",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideROCK_SKIN()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "HideSUPERHUMAN_STRENGTH",
		name = "Hide Super Human Strength",
		description = "Hide/Show Super Human Strength",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideSUPERHUMAN_STRENGTH()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "HideIMPROVED_REFLEXES",
		name = "Hide Improved_Reflexes",
		description = "Hide/Show Improved_Reflexes",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideIMPROVED_REFLEXES()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "HideRapidRestore",
		name = "Hide Rapid Restore",
		description = "Hide/Show Rapid Restore",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideRapidRestore()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "HideRapidHeal",
		name = "Hide Rapid Heal",
		description = "Hide/Show Rapid Heal",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideRapidHeal()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "HideProtectItem",
		name = "Hide Protect Item",
		description = "Hide/Show Protect Item",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideProtectItem()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "HideHAWK_EYE",
		name = "Hide Hawk Eye",
		description = "Hide/Show Hawk Eye",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideHAWK_EYE()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "HideMYSTIC_LORE",
		name = "Hide Mystic Lore",
		description = "Hide/Show Mystic Lore",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideMYSTIC_LORE()
	{
		return false;
	}


	@ConfigItem(
		position = 14,
		keyName = "HideSteelSkin",
		name = "Hide Steel Skin",
		description = "Hide/Show Steel skin",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideSteelSkin()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "HideUltimateStrength",
		name = "Hide Ultimate Strength",
		description = "Hide/Show Ultimate strength",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideUltimateStrength()
	{
		return false;
	}

	@ConfigItem(
		position = 16,
		keyName = "HideIncredibleReflex",
		name = "Hide Incredible Reflex",
		description = "Hide/Show Incredible Reflex",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideIncredibleReflex()
	{
		return false;
	}

	@ConfigItem(
		position = 17,
		keyName = "HidePTFMagic",
		name = "Hide Protect From Magic",
		description = "Hide/Show Protect From Magic",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HidePTFMagic()
	{
		return false;
	}

	@ConfigItem(
		position = 18,
		keyName = "HidePTFRange",
		name = "Hide Protect From Range",
		description = "Hide/Show Protect from Range",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HidePTFRange()
	{
		return false;
	}

	@ConfigItem(
		position = 19,
		keyName = "HidePTFMelee",
		name = "Hide Protect From Melee",
		description = "Hide/Show Protect From Melee",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HidePTFMelee()
	{
		return false;
	}

	@ConfigItem(
		position = 20,
		keyName = "HideEagle",
		name = "Hide Eagle Eye",
		description = "Hide/Show Eagle Eye",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideEagle()
	{
		return false;
	}

	@ConfigItem(
		position = 19,
		keyName = "HideMystic",
		name = "Hide Mystic Might",
		description = "Hide/Show Mystic Might",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideMystic()
	{
		return false;
	}

	@ConfigItem(
		position = 21,
		keyName = "HideRETRIBUTION",
		name = "Hide Retribution",
		description = "Hide/Show Retribution",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideRETRIBUTION()
	{
		return false;
	}

	@ConfigItem(
		position = 22,
		keyName = "HideRedemption",
		name = "Hide Redemption",
		description = "Hide/Show Redemption",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideRedemption()
	{
		return false;
	}

	@ConfigItem(
		position = 23,
		keyName = "HideSmite",
		name = "Hide Smite",
		description = "Hide/Show Smite",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideSmite()
	{
		return false;
	}

	@ConfigItem(
		position = 24,
		keyName = "HidePreserve",
		name = "Hide Preserve",
		description = "Hide/Show Preserve",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HidePreserve()
	{
		return false;
	}

	@ConfigItem(
		position = 25,
		keyName = "HideChivalry",
		name = "Hide Chivalry",
		description = "Hide/Show Chivalry",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideChivalry()
	{
		return false;
	}

	@ConfigItem(
		position = 26,
		keyName = "HidePiety",
		name = "Hide Piety",
		description = "Hide/Show Piety",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HidePiety()
	{
		return false;
	}

	@ConfigItem(
		position = 27,
		keyName = "HideRigour",
		name = "Hide Rigour",
		description = "Hide/Show Rigour",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideRigour()
	{
		return false;
	}

	@ConfigItem(
		position = 28,
		keyName = "HideAugury",
		name = "Hide Augury",
		description = "Hide/Show Augury",
		group = "Individual Prayers",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean HideAugury()
	{
		return false;
	}

// ----------------------------------------------------------- //

	@ConfigItem(
		position = 29,
		keyName = "getarmadylprayers",
		name = "enable Armadyl Prayers",
		description = "Shows prayers for Armadyl",
		group = "PVM Prayers",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers"
	)
	default boolean getarmadylprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 30,
		keyName = "armadyl",
		name = "Armadyl",
		description = "Shows prayers for Armadyl",
		group = "PVM Prayers",
		hidden = true,
		unhide = "getarmadylprayers"
	)
	default Armadyl armadyl()
	{
		return Armadyl.DISABLED;
	}

	@ConfigItem(
		position = 31,
		keyName = "getbarrowsprayers",
		name = "enable Barrows Prayers",
		description = "Shows prayers for Barrows",
		group = "PVM Prayers",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getarmadylprayers"
	)
	default boolean getbarrowsprayers()
	{
		return false;
	}
	
	@ConfigItem(
		position = 32,
		keyName = "barrows",
		name = "Barrows",
		description = "Shows prayers for Barrows",
		group = "PVM Prayers",
		hidden = true,
		unhide = "getbarrowsprayers"
	)
	default Barrows barrows()
	{
		return Barrows.DISABLED;
	}

	@ConfigItem(
		position = 33,
		keyName = "getbandosprayers",
		name = "enable Bandos Prayers",
		description = "Shows prayers for Bandos",
		group = "PVM Prayers",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getbandosprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 34,
		keyName = "bandos",
		name = "Bandos",
		description = "Shows prayers for Bandos",
		group = "PVM Prayers",
		hidden = true,
		unhide = "getbandosprayers"
	)
	default Bandos bandos()
	{
		return Bandos.DISABLED;
	}

	@ConfigItem(
		position = 35,
		keyName = "getcerberusprayers",
		name = "enable Cerberus Prayers",
		description = "Shows prayers for Cerberus",
		group = "PVM Prayers",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getcerberusprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 36,
		keyName = "cerberus",
		name = "Cerberus",
		description = "Shows prayers for Cerberus",
		group = "PVM Prayers",
		hidden = true,
		unhide = "getcerberusprayers"
	)
	default Cerberus cerberus()
	{
		return Cerberus.DISABLED;
	}

	@ConfigItem(
		position = 37,
		keyName = "getsaradominprayers",
		name = "enable Saradomin Prayers",
		description = "Shows prayers for Saradomin",
		group = "PVM Prayers",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getsaradominprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 38,
		keyName = "saradomin",
		name = "Saradomin",
		description = "Shows prayers for Saradomin",
		group = "PVM Prayers",
		hidden = true,
		unhide = "getsaradominprayers"
	)
	default Saradomin saradomin()
	{
		return Saradomin.DISABLED;
	}

	@ConfigItem(
		position = 39,
		keyName = "getvorkathprayers",
		name = "enable Vorkath Prayers",
		description = "Shows prayers for Vorkath",
		group = "PVM Prayers",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getvorkathprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 40,
		keyName = "vorkath",
		name = "Vorkath",
		description = "Shows prayers for Vorkath",
		group = "PVM Prayers",
		hidden = true,
		unhide = "getvorkathprayers"
	)
	default Vorkath vorkath()
	{
		return Vorkath.DISABLED;
	}

	@ConfigItem(
		position = 41,
		keyName = "getzamorakprayers",
		name = "enable Zamorak Prayers",
		description = "Shows prayers for Zamorak",
		group = "PVM Prayers",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getzamorakprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 42,
		keyName = "zamorak",
		name = "Zamorak",
		description = "Shows prayers for Zamorak",
		group = "PVM Prayers",
		hidden = true,
		unhide = "getzamorakprayers"
	)
	default Zamorak zamorak()
	{
		return Zamorak.DISABLED;
	}

	@ConfigItem(
		position = 43,
		keyName = "getzulrahprayers",
		name = "enable Zulrah Prayers",
		description = "Shows prayers for Zulrah",
		group = "PVM Prayers",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getzulrahprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 44,
		keyName = "zulrah",
		name = "Zulrah",
		description = "Shows prayers for Zulrah",
		group = "PVM Prayers",
		hidden = true,
		unhide = "getzulrahprayers"
	)
	default Zulrah zulrah()
	{
		return Zulrah.DISABLED;
	}

// ----------------------------------------------------------- //

	@ConfigItem(
		position = 45,
		keyName = "getpvpprayers",
		name = "enable PVP Prayers",
		description = "Shows prayers based on prayer build",
		group = "PVP Prayers",
		disabledBy = "showindividualprayers || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getpvpprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 46,
		keyName = "pvpprayers",
		name = "PVP Prayers",
		description = "Shows prayers based on prayer build",
		group = "PVP Prayers",
		hidden = true,
		unhide = "getpvpprayers"
	)
	default PVPPrayers pvpprayers()
	{
		return PVPPrayers.DISABLED;
	}

	@ConfigItem(
		position = 47,
		keyName = "HideRapidHealRestore",
		name = "Hide Rapid Heal and Rapid Restore",
		description = "Hides the Rapid Heal and Rapid Restore prayers",
		group = "PVP Prayers",
		hidden = true,
		unhide = "getpvpprayers"
	)
	default boolean HideRapidHealRestore()
	{
		return false;
	}
}