/*
 * Copyright (c) 2018, https://openosrs.com
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
import net.runelite.client.config.ConfigSection;
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
	@ConfigSection(
		name = "Individual Prayers",
		description = "",
		position = 0,
		keyName = "individualPrayersSection"
	)
	default boolean individualPrayersSection()
	{
		return false;
	}

	@ConfigSection(
		name = "PvM Prayers",
		description = "",
		position = 1,
		keyName = "pvmSection"
	)
	default boolean pvmSection()
	{
		return false;
	}

	@ConfigSection(
		name = "PvP Prayers",
		description = "",
		position = 2,
		keyName = "pvpSection"
	)
	default boolean pvpSection()
	{
		return false;
	}
	
	@ConfigItem(
		position = 0,
		keyName = "showindividualprayers",
		name = "Hide Individual Prayers",
		description = "Hide/Show Prayers.",
		section = "individualPrayersSection",
		disabledBy = "getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean showindividualprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "ShowTHICK_SKIN",
		name = "Show Thick Skin",
		description = "Hide/Show Thick Skin",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowTHICK_SKIN()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "ShowBURST_OF_STRENGTH",
		name = "Show Burst of Strength",
		description = "Hide/Show Burst of Strength",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowBURST_OF_STRENGTH()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "ShowCLARITY_OF_THOUGHT",
		name = "Show Clarity of Thought",
		description = "Hide/Show Clarity of Thought",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "Showindividualprayers"
	)
	default boolean ShowCLARITY_OF_THOUGHT()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "ShowSHARP_EYE",
		name = "Show Sharp Eye",
		description = "Hide/Show Sharp Eye",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowSHARP_EYE()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "ShowMYSTIC_WILL",
		name = "Show Mystic Will",
		description = "Hide/Show Mystic Will",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowMYSTIC_WILL()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "ShowROCK_SKIN",
		name = "Show Rock Skin",
		description = "Hide/Show Rock Skin",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowROCK_SKIN()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "ShowSUPERHUMAN_STRENGTH",
		name = "Show Super Human Strength",
		description = "Hide/Show Super Human Strength",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowSUPERHUMAN_STRENGTH()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "ShowIMPROVED_REFLEXES",
		name = "Show Improved_Reflexes",
		description = "Hide/Show Improved_Reflexes",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowIMPROVED_REFLEXES()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "ShowRapidRestore",
		name = "Show Rapid Restore",
		description = "Hide/Show Rapid Restore",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowRapidRestore()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "ShowRapidHeal",
		name = "Show Rapid Heal",
		description = "Hide/Show Rapid Heal",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowRapidHeal()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "ShowProtectItem",
		name = "Show Protect Item",
		description = "Hide/Show Protect Item",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowProtectItem()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "ShowHAWK_EYE",
		name = "Show Hawk Eye",
		description = "Hide/Show Hawk Eye",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowHAWK_EYE()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "ShowMYSTIC_LORE",
		name = "Show Mystic Lore",
		description = "Hide/Show Mystic Lore",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowMYSTIC_LORE()
	{
		return false;
	}


	@ConfigItem(
		position = 14,
		keyName = "ShowSteelSkin",
		name = "Show Steel Skin",
		description = "Hide/Show Steel skin",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowSteelSkin()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "ShowUltimateStrength",
		name = "Show Ultimate Strength",
		description = "Hide/Show Ultimate strength",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowUltimateStrength()
	{
		return false;
	}

	@ConfigItem(
		position = 16,
		keyName = "ShowIncredibleReflex",
		name = "Show Incredible Reflex",
		description = "Hide/Show Incredible Reflex",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowIncredibleReflex()
	{
		return false;
	}

	@ConfigItem(
		position = 17,
		keyName = "ShowPTFMagic",
		name = "Show Protect From Magic",
		description = "Hide/Show Protect From Magic",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowPTFMagic()
	{
		return false;
	}

	@ConfigItem(
		position = 18,
		keyName = "ShowPTFRange",
		name = "Show Protect From Range",
		description = "Hide/Show Protect from Range",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowPTFRange()
	{
		return false;
	}

	@ConfigItem(
		position = 19,
		keyName = "ShowPTFMelee",
		name = "Show Protect From Melee",
		description = "Hide/Show Protect From Melee",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowPTFMelee()
	{
		return false;
	}

	@ConfigItem(
		position = 20,
		keyName = "ShowEagle",
		name = "Show Eagle Eye",
		description = "Hide/Show Eagle Eye",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowEagle()
	{
		return false;
	}

	@ConfigItem(
		position = 19,
		keyName = "ShowMystic",
		name = "Show Mystic Might",
		description = "Hide/Show Mystic Might",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowMystic()
	{
		return false;
	}

	@ConfigItem(
		position = 21,
		keyName = "ShowRETRIBUTION",
		name = "Show Retribution",
		description = "Hide/Show Retribution",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowRETRIBUTION()
	{
		return false;
	}

	@ConfigItem(
		position = 22,
		keyName = "ShowRedemption",
		name = "Show Redemption",
		description = "Hide/Show Redemption",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowRedemption()
	{
		return false;
	}

	@ConfigItem(
		position = 23,
		keyName = "ShowSmite",
		name = "Show Smite",
		description = "Hide/Show Smite",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowSmite()
	{
		return false;
	}

	@ConfigItem(
		position = 24,
		keyName = "ShowPreserve",
		name = "Show Preserve",
		description = "Hide/Show Preserve",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowPreserve()
	{
		return false;
	}

	@ConfigItem(
		position = 25,
		keyName = "ShowChivalry",
		name = "Show Chivalry",
		description = "Hide/Show Chivalry",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowChivalry()
	{
		return false;
	}

	@ConfigItem(
		position = 26,
		keyName = "ShowPiety",
		name = "Show Piety",
		description = "Hide/Show Piety",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowPiety()
	{
		return false;
	}

	@ConfigItem(
		position = 27,
		keyName = "ShowRigour",
		name = "Show Rigour",
		description = "Hide/Show Rigour",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowRigour()
	{
		return false;
	}

	@ConfigItem(
		position = 28,
		keyName = "ShowAugury",
		name = "Show Augury",
		description = "Hide/Show Augury",
		section = "individualPrayersSection",
		hidden = true,
		unhide = "showindividualprayers"
	)
	default boolean ShowAugury()
	{
		return false;
	}

// ----------------------------------------------------------- //

	@ConfigItem(
		position = 0,
		keyName = "getarmadylprayers",
		name = "enable Armadyl Prayers",
		description = "Shows prayers for Armadyl",
		section = "pvmSection",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers"
	)
	default boolean getarmadylprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "armadyl",
		name = "Armadyl",
		description = "Shows prayers for Armadyl",
		section = "pvmSection",
		hidden = true,
		unhide = "getarmadylprayers"
	)
	default Armadyl armadyl()
	{
		return Armadyl.DISABLED;
	}

	@ConfigItem(
		position = 2,
		keyName = "getbarrowsprayers",
		name = "enable Barrows Prayers",
		description = "Shows prayers for Barrows",
		section = "pvmSection",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getarmadylprayers"
	)
	default boolean getbarrowsprayers()
	{
		return false;
	}
	
	@ConfigItem(
		position = 3,
		keyName = "barrows",
		name = "Barrows",
		description = "Shows prayers for Barrows",
		section = "pvmSection",
		hidden = true,
		unhide = "getbarrowsprayers"
	)
	default Barrows barrows()
	{
		return Barrows.DISABLED;
	}

	@ConfigItem(
		position = 4,
		keyName = "getbandosprayers",
		name = "enable Bandos Prayers",
		description = "Shows prayers for Bandos",
		section = "pvmSection",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getbandosprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "bandos",
		name = "Bandos",
		description = "Shows prayers for Bandos",
		section = "pvmSection",
		hidden = true,
		unhide = "getbandosprayers"
	)
	default Bandos bandos()
	{
		return Bandos.DISABLED;
	}

	@ConfigItem(
		position = 6,
		keyName = "getcerberusprayers",
		name = "enable Cerberus Prayers",
		description = "Shows prayers for Cerberus",
		section = "pvmSection",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getcerberusprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "cerberus",
		name = "Cerberus",
		description = "Shows prayers for Cerberus",
		section = "pvmSection",
		hidden = true,
		unhide = "getcerberusprayers"
	)
	default Cerberus cerberus()
	{
		return Cerberus.DISABLED;
	}

	@ConfigItem(
		position = 8,
		keyName = "getsaradominprayers",
		name = "enable Saradomin Prayers",
		description = "Shows prayers for Saradomin",
		section = "pvmSection",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getvorkathprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getsaradominprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "saradomin",
		name = "Saradomin",
		description = "Shows prayers for Saradomin",
		section = "pvmSection",
		hidden = true,
		unhide = "getsaradominprayers"
	)
	default Saradomin saradomin()
	{
		return Saradomin.DISABLED;
	}

	@ConfigItem(
		position = 10,
		keyName = "getvorkathprayers",
		name = "enable Vorkath Prayers",
		description = "Shows prayers for Vorkath",
		section = "pvmSection",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getzamorakprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getvorkathprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "vorkath",
		name = "Vorkath",
		description = "Shows prayers for Vorkath",
		section = "pvmSection",
		hidden = true,
		unhide = "getvorkathprayers"
	)
	default Vorkath vorkath()
	{
		return Vorkath.DISABLED;
	}

	@ConfigItem(
		position = 12,
		keyName = "getzamorakprayers",
		name = "enable Zamorak Prayers",
		description = "Shows prayers for Zamorak",
		section = "pvmSection",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzulrahprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getzamorakprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "zamorak",
		name = "Zamorak",
		description = "Shows prayers for Zamorak",
		section = "pvmSection",
		hidden = true,
		unhide = "getzamorakprayers"
	)
	default Zamorak zamorak()
	{
		return Zamorak.DISABLED;
	}

	@ConfigItem(
		position = 14,
		keyName = "getzulrahprayers",
		name = "enable Zulrah Prayers",
		description = "Shows prayers for Zulrah",
		section = "pvmSection",
		disabledBy = "showindividualprayers || getpvpprayers || HideRapidHealRestore || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getzulrahprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "zulrah",
		name = "Zulrah",
		description = "Shows prayers for Zulrah",
		section = "pvmSection",
		hidden = true,
		unhide = "getzulrahprayers"
	)
	default Zulrah zulrah()
	{
		return Zulrah.DISABLED;
	}

// ----------------------------------------------------------- //

	@ConfigItem(
		position = 0,
		keyName = "getpvpprayers",
		name = "enable PVP Prayers",
		description = "Shows prayers based on prayer build",
		section = "pvpSection",
		disabledBy = "showindividualprayers || getzulrahprayers || getzamorakprayers || getvorkathprayers || getsaradominprayers || getcerberusprayers || getbandosprayers || getbarrowsprayers || getarmadylprayers"
	)
	default boolean getpvpprayers()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "pvpprayers",
		name = "PVP Prayers",
		description = "Shows prayers based on prayer build",
		section = "pvpSection",
		hidden = true,
		unhide = "getpvpprayers"
	)
	default PVPPrayers pvpprayers()
	{
		return PVPPrayers.DISABLED;
	}

	@ConfigItem(
		position = 2,
		keyName = "HideRapidHealRestore",
		name = "Hide Rapid Heal and Rapid Restore",
		description = "Hides the Rapid Heal and Rapid Restore prayers",
		section = "pvpSection",
		hidden = true,
		unhide = "getpvpprayers"
	)
	default boolean HideRapidHealRestore()
	{
		return false;
	}
}
