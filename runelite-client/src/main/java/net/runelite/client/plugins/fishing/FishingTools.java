/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.fishing;


import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
public enum FishingTools
{
	SMALL_FISHING_NET(
		ItemID.SMALL_FISHING_NET,
		ItemID.SMALL_FISHING_NET_6209
	),
	BIG_FISHING_NET(
		ItemID.BIG_FISHING_NET
	),
	FISHING_ROD(
		ItemID.FISHING_ROD,
		ItemID.PEARL_FISHING_ROD
	),
	FLY_FISHING_ROD(
		ItemID.FLY_FISHING_ROD,
		ItemID.PEARL_FLY_FISHING_ROD
	),
	OILY_FISHING_ROD(
		ItemID.OILY_FISHING_ROD,
		ItemID.OILY_PEARL_FISHING_ROD
	),
	BARBARIAN_ROD(
		ItemID.BARBARIAN_ROD,
		ItemID.PEARL_BARBARIAN_ROD
	),
	HARPOON(
		ItemID.HARPOON,
		ItemID.BARBTAIL_HARPOON,
		ItemID.DRAGON_HARPOON,
		ItemID.DRAGON_HARPOON_OR,
		ItemID.INFERNAL_HARPOON,
		ItemID.INFERNAL_HARPOON_OR,
		ItemID.INFERNAL_HARPOON_UNCHARGED,
		ItemID.INFERNAL_HARPOON_UNCHARGED_25367,
		ItemID.CRYSTAL_HARPOON,
		ItemID.CRYSTAL_HARPOON_23864,
		ItemID.CRYSTAL_HARPOON_INACTIVE,
		ItemID.TRAILBLAZER_HARPOON
	),
	LOBSTER_POT(
		ItemID.LOBSTER_POT
	),
	KARAMBWAN_VESSEL(
		ItemID.KARAMBWAN_VESSEL,
		ItemID.KARAMBWAN_VESSEL_3159
	),
	CORMORANTS_GLOVE(
		ItemID.CORMORANTS_GLOVE,
		ItemID.CORMORANTS_GLOVE_22817
	),
	FISHBOWL_NET(
		ItemID.FISHBOWL_AND_NET
	);
	@Getter
	private final int[] tools;

	FishingTools(int... itemIDs)
	{
		this.tools = itemIDs;
	}

	public static FishingTools getToolType(int itemID)
	{
		for (FishingTools toolType : FishingTools.values())
		{
			for (int toolID : toolType.getTools())
			{
				if (toolID == itemID)
				{
					return toolType;
				}
			}
		}
		// ItemID provided was not a fishing tool
		return null;
	}
}
