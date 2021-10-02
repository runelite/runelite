/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.NullItemID;

@AllArgsConstructor
@Getter
public enum MiningAction implements NamedSkillAction
{
	CLAY("Clay", 1, 5, ItemID.CLAY),
	RUNE_ESSENCE("Rune essence", 1, 5, ItemID.RUNE_ESSENCE),
	COPPER_ORE("Copper ore", 1, 17.5f, ItemID.COPPER_ORE),
	TIN_ORE("Tin ore", 1, 17.5f, ItemID.TIN_ORE),
	LIMESTONE("Limestone", 10, 26.5f, ItemID.LIMESTONE),
	BARRONITE_SHARDS("Barronite shards", 14, 16, NullItemID.NULL_25683),
	BARRONITE_DEPOSIT("Barronite deposit", 14, 32, ItemID.BARRONITE_DEPOSIT),
	IRON_ORE("Iron ore", 15, 35, ItemID.IRON_ORE),
	SILVER_ORE("Silver ore", 20, 40, ItemID.SILVER_ORE),
	PURE_ESSENCE("Pure essence", 30, 5, ItemID.PURE_ESSENCE),
	COAL("Coal", 30, 50, ItemID.COAL),
	SANDSTONE_1KG("Sandstone (1kg)", 35, 30, ItemID.SANDSTONE_1KG),
	SANDSTONE_2KG("Sandstone (2kg)", 35, 40, ItemID.SANDSTONE_2KG),
	SANDSTONE_5KG("Sandstone (5kg)", 35, 50, ItemID.SANDSTONE_5KG),
	SANDSTONE_10KG("Sandstone (10kg)", 35, 60, ItemID.SANDSTONE_10KG),
	DENSE_ESSENCE_BLOCK("Dense essence block", 38, 12, ItemID.DENSE_ESSENCE_BLOCK),
	GOLD_ORE("Gold ore", 40, 65, ItemID.GOLD_ORE),
	GEM_ROCKS("Gem rocks", 40, 65, ItemID.UNCUT_RED_TOPAZ),
	GRANITE_500G("Granite (500g)", 45, 50, ItemID.GRANITE_500G),
	GRANITE_2KG("Granite (2kg)", 45, 60, ItemID.GRANITE_2KG),
	GRANITE_5KG("Granite (5kg)", 45, 75, ItemID.GRANITE_5KG),
	MITHRIL_ORE("Mithril ore", 55, 80, ItemID.MITHRIL_ORE),
	SOFT_CLAY("Soft clay", 70, 5, ItemID.SOFT_CLAY),
	ADAMANTITE_ORE("Adamantite ore", 70, 95, ItemID.ADAMANTITE_ORE),
	RUNITE_ORE("Runite ore", 85, 125, ItemID.RUNITE_ORE),
	AMETHYST("Amethyst", 92, 240, ItemID.AMETHYST),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
}
