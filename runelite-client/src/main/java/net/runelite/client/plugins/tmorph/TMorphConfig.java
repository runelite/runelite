/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.tmorph;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Stub;

@ConfigGroup("TMorph")
public interface TMorphConfig extends Config
{
	@ConfigItem(
		keyName = "swaps",
		name = "Morphers",
		description = "",
		position = 0
	)
	default Stub swaps()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "mageSwap",
		name = "Swap Mage Set",
		description = "this will swap your mage set with the set you've chosen.",
		parent = "swaps",
		position = 1
	)
	default boolean mageSwap()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rangeSwap",
		name = "Swap Range Set",
		description = "this will swap your Range set with the set you've chosen.",
		parent = "swaps",
		position = 2
	)
	default boolean rangeSwap()
	{
		return false;
	}

	@ConfigItem(
		keyName = "meleeSwap",
		name = "Swap Melee Set",
		description = "this will swap your Melee set with the set you've chosen.",
		parent = "swaps",
		position = 3
	)
	default boolean meleeSwap()
	{
		return false;
	}

	@ConfigItem(
		keyName = "experimentalFunctions",
		name = "Experimental Functions",
		description = "May bug out in unintended ways.",
		parent = "swaps",
		position = 4
	)
	default boolean experimentalFunctions()
	{
		return false;
	}

	//////////////////Experimental Functions

	@ConfigItem(
		keyName = "globalAnimSwap",
		name = "Global Animation Swap",
		description = "DO NOT USE WITH ANIMATION SWAP BELOW",

		group = "Experimental Functions",
		hidden = true,
		unhide = "experimentalFunctions"
	)
	default int globalAnimSwap()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "animationSwap",
		name = "Animation Swap",
		description = "ID",
		group = "Experimental Functions",
		hidden = true,
		unhide = "experimentalFunctions"
	)
	default int animationSwap()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "animationTarget",
		name = "Animation Target",
		description = "ID",
		group = "Experimental Functions",
		hidden = true,
		unhide = "experimentalFunctions"
	)
	default int animationTarget()
	{
		return 0;
	}


	//////////////////Mage

	@ConfigItem(
		keyName = "MainhandMage",
		name = "Mainhand",
		description = "ID",
		group = "Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int MainhandMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetMainhandMage",
		name = "Target Mainhand",
		description = "If you're wearing this, then it will swap.",
		group = "Target Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int targetMainhandMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "OffhandMage",
		name = "Offhand",
		description = "Item you want to swap to",
		group = "Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int OffhandMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetOffhandMage",
		name = "Target Offhand",
		description = "If you're wearing this, then it will swap.",
		group = "Target Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int targetOffhandMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "HelmetMage",
		name = "Helmet",
		description = "Item you want to swap to",
		group = "Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int HelmetMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetHelmetMage",
		name = "Target Helmet",
		description = "If you're wearing this, then it will swap.",
		group = "Target Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int targetHelmetMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "CapeMage",
		name = "Cape",
		description = "Item you want to swap to",
		group = "Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int CapeMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetCapeMage",
		name = "Target Cape",
		description = "If you're wearing this, then it will swap.",
		group = "Target Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int targetCapeMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "NeckMage",
		name = "Neck",
		description = "Item you want to swap to",
		group = "Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int NeckMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetNeckMage",
		name = "Target Neck",
		description = "If you're wearing this, then it will swap.",
		group = "Target Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int targetNeckMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "BodyMage",
		name = "Body",
		description = "Item you want to swap to",
		group = "Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int BodyMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetBodyMage",
		name = "Target Body",
		description = "If you're wearing this, then it will swap.",
		group = "Target Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int targetBodyMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "LegsMage",
		name = "Legs",
		description = "Item you want to swap to",
		group = "Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int LegsMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetLegsMage",
		name = "Target Legs",
		description = "If you're wearing this, then it will swap.",
		group = "Target Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int targetLegsMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "BootsMage",
		name = "Boots",
		description = "Item you want to swap to",
		group = "Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int BootsMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetBootsMage",
		name = "Target Boots",
		description = "If you're wearing this, then it will swap.",
		group = "Target Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int targetBootsMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "GlovesMage",
		name = "Gloves",
		description = "Item you want to swap to",
		group = "Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int GlovesMage()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetGlovesMage",
		name = "Target Gloves",
		description = "If you're wearing this, then it will swap.",
		group = "Target Mage Swap",
		hidden = true,
		unhide = "mageSwap"
	)
	default int targetGlovesMage()
	{
		return 0;
	}

	///////////////////Range

	@ConfigItem(
		keyName = "MainhandRange",
		name = "Mainhand",
		description = "ID",
		group = "Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int MainhandRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetMainhandRange",
		name = "Target Mainhand",
		description = "If you're wearing this, then it will swap.",
		group = "Target Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int targetMainhandRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "OffhandRange",
		name = "Offhand",
		description = "Item you want to swap to",
		group = "Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int OffhandRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetOffhandRange",
		name = "Target Offhand",
		description = "If you're wearing this, then it will swap.",
		group = "Target Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int targetOffhandRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "HelmetRange",
		name = "Helmet",
		description = "Item you want to swap to",
		group = "Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int HelmetRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetHelmetRange",
		name = "Target Helmet",
		description = "If you're wearing this, then it will swap.",
		group = "Target Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int targetHelmetRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "CapeRange",
		name = "Cape",
		description = "Item you want to swap to",
		group = "Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int CapeRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetCapeRange",
		name = "Target Cape",
		description = "If you're wearing this, then it will swap.",
		group = "Target Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int targetCapeRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "NeckRange",
		name = "Neck",
		description = "Item you want to swap to",
		group = "Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int NeckRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetNeckRange",
		name = "Target Neck",
		description = "If you're wearing this, then it will swap.",
		group = "Target Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int targetNeckRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "BodyRange",
		name = "Body",
		description = "Item you want to swap to",
		group = "Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int BodyRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetBodyRange",
		name = "Target Body",
		description = "If you're wearing this, then it will swap.",
		group = "Target Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int targetBodyRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "LegsRange",
		name = "Legs",
		description = "Item you want to swap to",
		group = "Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int LegsRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetLegsRange",
		name = "Target Legs",
		description = "If you're wearing this, then it will swap.",
		group = "Target Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int targetLegsRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "BootsRange",
		name = "Boots",
		description = "Item you want to swap to",
		group = "Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int BootsRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetBootsRange",
		name = "Target Boots",
		description = "If you're wearing this, then it will swap.",
		group = "Target Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int targetBootsRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "GlovesRange",
		name = "Gloves",
		description = "Item you want to swap to",
		group = "Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int GlovesRange()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetGlovesRange",
		name = "Target Gloves",
		description = "If you're wearing this, then it will swap.",
		group = "Target Range Swap",
		hidden = true,
		unhide = "rangeSwap"
	)
	default int targetGlovesRange()
	{
		return 0;
	}

	////////////////////MELEE

	@ConfigItem(
		keyName = "MainhandMelee",
		name = "Mainhand",
		description = "ID",
		group = "Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int MainhandMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetMainhandMelee",
		name = "Target Mainhand",
		description = "If you're wearing this, then it will swap.",
		group = "Target Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int targetMainhandMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "OffhandMelee",
		name = "Offhand",
		description = "Item you want to swap to",
		group = "Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int OffhandMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetOffhandMelee",
		name = "Target Offhand",
		description = "If you're wearing this, then it will swap.",
		group = "Target Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int targetOffhandMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "HelmetMelee",
		name = "Helmet",
		description = "Item you want to swap to",
		group = "Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int HelmetMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetHelmetMelee",
		name = "Target Helmet",
		description = "If you're wearing this, then it will swap.",
		group = "Target Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int targetHelmetMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "CapeMelee",
		name = "Cape",
		description = "Item you want to swap to",
		group = "Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int CapeMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetCapeMelee",
		name = "Target Cape",
		description = "If you're wearing this, then it will swap.",
		group = "Target Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int targetCapeMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "NeckMelee",
		name = "Neck",
		description = "Item you want to swap to",
		group = "Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int NeckMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetNeckMelee",
		name = "Target Neck",
		description = "If you're wearing this, then it will swap.",
		group = "Target Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int targetNeckMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "BodyMelee",
		name = "Body",
		description = "Item you want to swap to",
		group = "Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int BodyMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetBodyMelee",
		name = "Target Body",
		description = "If you're wearing this, then it will swap.",
		group = "Target Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int targetBodyMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "LegsMelee",
		name = "Legs",
		description = "Item you want to swap to",
		group = "Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int LegsMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetLegsMelee",
		name = "Target Legs",
		description = "If you're wearing this, then it will swap.",
		group = "Target Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int targetLegsMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "BootsMelee",
		name = "Boots",
		description = "Item you want to swap to",
		group = "Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int BootsMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetBootsMelee",
		name = "Target Boots",
		description = "If you're wearing this, then it will swap.",
		group = "Target Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int targetBootsMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "GlovesMelee",
		name = "Gloves",
		description = "Item you want to swap to",
		group = "Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int GlovesMelee()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "TargetGlovesMelee",
		name = "Target Gloves",
		description = "If you're wearing this, then it will swap.",
		group = "Target Melee Swap",
		hidden = true,
		unhide = "meleeSwap"
	)
	default int targetGlovesMelee()
	{
		return 0;
	}
}
