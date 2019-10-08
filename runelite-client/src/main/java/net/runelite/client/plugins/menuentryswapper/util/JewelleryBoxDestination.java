/*
 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
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
package net.runelite.client.plugins.menuentryswapper.util;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.widgets.WidgetInfo;

@RequiredArgsConstructor
@Getter
public enum JewelleryBoxDestination
{
	DUEL_ARENA("Duel Arena", WidgetInfo.JEWELLERY_BOX_DUEL_RING, 5),
	CASTLE_WARS("Castle Wars", WidgetInfo.JEWELLERY_BOX_DUEL_RING, 6),
	CLAN_WARS("Clan Wars", WidgetInfo.JEWELLERY_BOX_DUEL_RING, 7),

	BURTHORPE("Burthorpe", WidgetInfo.JEWELLERY_BOX_GAME_NECK, 5),
	BARB_OUTPOST("Barbarian Outpost", WidgetInfo.JEWELLERY_BOX_GAME_NECK, 6),
	CORP("Corporeal Beast", WidgetInfo.JEWELLERY_BOX_GAME_NECK, 7),
	TEARS_OF_GUTHIX("Tears of Guthix", WidgetInfo.JEWELLERY_BOX_GAME_NECK, 8),
	WINTERTODT("Wintertodt Camp", WidgetInfo.JEWELLERY_BOX_GAME_NECK, 9),

	WARRIOR_GUILD("Warriors' Guild", WidgetInfo.JEWELLERY_BOX_COMB_BRAC, 5),
	CHAMPION_GUILD("Champions' Guild", WidgetInfo.JEWELLERY_BOX_COMB_BRAC, 6),
	MONASTERY("Monastery", WidgetInfo.JEWELLERY_BOX_COMB_BRAC, 7),
	RANGING_GUILD("Ranging Guild", WidgetInfo.JEWELLERY_BOX_COMB_BRAC, 8),

	FISHING_GUILD("Fishing Guild", WidgetInfo.JEWELLERY_BOX_SKIL_NECK, 5),
	MINING_GUILD("Mining Guild", WidgetInfo.JEWELLERY_BOX_SKIL_NECK, 6),
	CRAFTING_GUILD("Crafting Guild", WidgetInfo.JEWELLERY_BOX_SKIL_NECK, 7),
	COOKING_GUILD("Cooking Guild", WidgetInfo.JEWELLERY_BOX_SKIL_NECK, 8),
	WOODCUTTING_GUILD("Woodcutting Guild", WidgetInfo.JEWELLERY_BOX_SKIL_NECK, 9),
	FARMING_GUILD("Farming Guild", WidgetInfo.JEWELLERY_BOX_SKIL_NECK, 10),

	MISCELLANIA("Miscellania", WidgetInfo.JEWELLERY_BOX_RING_OFGP, 5),
	GRAND_EXCHANGE("Grand Exchange", WidgetInfo.JEWELLERY_BOX_RING_OFGP, 6),
	FALADOR_PARK("Falador Park", WidgetInfo.JEWELLERY_BOX_RING_OFGP, 7),
	DONDAKAN("Dondakan's Rock", WidgetInfo.JEWELLERY_BOX_RING_OFGP, 8),

	EDGEVILLE("Edgeville", WidgetInfo.JEWELLERY_BOX_AMUL_GLOR, 5),
	KARAMJA("Karamja", WidgetInfo.JEWELLERY_BOX_AMUL_GLOR, 6),
	DRAYNOR("Draynor Village", WidgetInfo.JEWELLERY_BOX_AMUL_GLOR, 7),
	AL_KHARID("Al Kharid", WidgetInfo.JEWELLERY_BOX_AMUL_GLOR, 8);

	final String option;
	final WidgetInfo parent;
	final int childIndex;

	private static final ImmutableMap<String, JewelleryBoxDestination> map;
	static
	{
		final ImmutableMap.Builder<String, JewelleryBoxDestination> builder = ImmutableMap.builderWithExpectedSize(values().length);
		for (JewelleryBoxDestination val : values())
		{
			builder.put(val.option, val);
		}
		map = builder.build();
	}

	public static JewelleryBoxDestination withOption(String option)
	{
		return map.get(option);
	}
}
