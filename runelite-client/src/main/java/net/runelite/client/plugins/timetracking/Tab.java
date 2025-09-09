/*
 * Copyright (c) 2018 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.timetracking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.gameval.ItemID;

@RequiredArgsConstructor
@Getter
public enum Tab
{
	OVERVIEW("Overview", ItemID.DS2_CRANDOR_NOTES),
	CLOCK("Timers & Stopwatches", ItemID.TRAIL_WATCH),
	BIRD_HOUSE("Bird Houses", ItemID.BIRDHOUSE_OAK),
	ALLOTMENT("Allotment Patches", ItemID.CABBAGE),
	FLOWER("Flower Patches", ItemID.FLOWERS_WATERFALL_QUEST_RED),
	HERB("Herb Patches", ItemID.UNIDENTIFIED_RANARR),
	TREE("Tree Patches", ItemID.YEW_LOGS),
	FRUIT_TREE("Fruit Tree Patches", ItemID.PINEAPPLE),
	HOPS("Hops Patches", ItemID.BARLEY),
	BUSH("Bush Patches", ItemID.POISONIVY_BERRIES),
	GRAPE("Grape Patches", ItemID.GRAPES),
	SPECIAL("Special Patches", ItemID.BITTERCAP_MUSHROOM),
	TIME_OFFSET("Farming Tick Offset", ItemID.WATERING_CAN_0);

	public static final Tab[] FARMING_TABS = {HERB, TREE, FRUIT_TREE, SPECIAL, FLOWER, ALLOTMENT, BUSH, GRAPE, HOPS};

	private final String name;
	private final int itemID;
}
