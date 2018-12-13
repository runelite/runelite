/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.telemetry;

import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
public enum FishingTools
{
	FISHING_HARPOON(ItemID.DRAGON_HARPOON, ItemID.INFERNAL_HARPOON, ItemID.INFERNAL_HARPOON_UNCHARGED, ItemID.HARPOON, ItemID.BARBTAIL_HARPOON),
	FISHING_BIG_NET(ItemID.BIG_FISHING_NET),
	FISHING_SMALL_NET(ItemID.SMALL_FISHING_NET, ItemID.SMALL_FISHING_NET_6209),
	FISHING_ROD(ItemID.FISHING_ROD),
	FISHING_FLY_ROD(ItemID.FLY_FISHING_ROD),
	FISHING_BARB_ROD(ItemID.BARBARIAN_ROD),
	FISHING_OILY_ROD(ItemID.OILY_FISHING_ROD),
	// Lobster pot also include HARPOON
	FISHING_LOBSTER_POT(ItemID.LOBSTER_POT, ItemID.DRAGON_HARPOON, ItemID.INFERNAL_HARPOON, ItemID.INFERNAL_HARPOON_UNCHARGED, ItemID.HARPOON, ItemID.BARBTAIL_HARPOON),
	FISHING_KARAMBWAN_VESSEL(ItemID.KARAMBWAN_VESSEL, ItemID.KARAMBWAN_VESSEL_3159);

	private final int[] tools;

	FishingTools(int... tools)
	{
		this.tools = tools;
	}
}
