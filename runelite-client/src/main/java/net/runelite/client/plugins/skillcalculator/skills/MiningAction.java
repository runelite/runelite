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
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum MiningAction implements ItemSkillAction
{
	CLAY(ItemID.CLAY, 1, 5),
	RUNE_ESSENCE(ItemID.BLANKRUNE, 1, 5),
	COPPER_ORE(ItemID.COPPER_ORE, 1, 17.5f),
	TIN_ORE(ItemID.TIN_ORE, 1, 17.5f),
	LIMESTONE(ItemID.LIMESTONE, 10, 26.5f),
	BARRONITE_SHARDS(ItemID.CAMDOZAAL_BARRONITE_SHARD_7, 14, 16)
	{
		@Override
		public String getName(final ItemManager itemManager)
		{
			return "Barronite shards";
		}
	},
	BARRONITE_DEPOSIT(ItemID.CAMDOZAAL_BARRONITE_DEPOSIT, 14, 32),
	IRON_ORE(ItemID.IRON_ORE, 15, 35),
	SILVER_ORE(ItemID.SILVER_ORE, 20, 40),
	LEAD_ORE(ItemID.LEAD_ORE, 25, 40.5f),
	PURE_ESSENCE(ItemID.BLANKRUNE_HIGH, 30, 5)
	{
		@Override
		public boolean isMembers(final ItemManager itemManager)
		{
			return true;
		}
	},
	COAL(ItemID.COAL, 30, 50),
	SANDSTONE_1KG(ItemID.ENAKH_SANDSTONE_TINY, 35, 30),
	SANDSTONE_2KG(ItemID.ENAKH_SANDSTONE_SMALL, 35, 40),
	SANDSTONE_5KG(ItemID.ENAKH_SANDSTONE_MEDIUM, 35, 50),
	SANDSTONE_10KG(ItemID.ENAKH_SANDSTONE_LARGE, 35, 60),
	DENSE_ESSENCE_BLOCK(ItemID.ARCEUUS_ESSENCE_BLOCK, 38, 12),
	GEM_ROCKS(ItemID.UNCUT_RED_TOPAZ, 40, 65)
		{
			@Override
			public String getName(final ItemManager itemManager)
			{
				return "Gem rocks";
			}
		},
	GOLD_ORE(ItemID.GOLD_ORE, 40, 65),
	CALCIFIED_ROCKS(ItemID.BLESSED_BONE_SHARD, 41, 33)
	{
		@Override
		public String getName(final ItemManager itemManager)
		{
			return "Calcified rocks";
		}
	},
	GRANITE_500G(ItemID.ENAKH_GRANITE_TINY, 45, 50),
	GRANITE_2KG(ItemID.ENAKH_GRANITE_SMALL, 45, 60),
	GRANITE_5KG(ItemID.ENAKH_GRANITE_MEDIUM, 45, 75),
	RUBIUM_SPLINTERS(ItemID.RUBIUM_SPLINTERS, 48, 72),
	MITHRIL_ORE(ItemID.MITHRIL_ORE, 55, 80),
	SOFT_CLAY(ItemID.SOFTCLAY, 70, 5)
	{
		@Override
		public boolean isMembers(final ItemManager itemManager)
		{
			return true;
		}
	},
	ADAMANTITE_ORE(ItemID.ADAMANTITE_ORE, 70, 95),
	NICKEL_ORE(ItemID.NICKEL_ORE, 74, 80.5f),
	RUNITE_ORE(ItemID.RUNITE_ORE, 85, 125),
	AMETHYST(ItemID.AMETHYST, 92, 240),
	;

	private final int itemId;
	private final int level;
	private final float xp;
}
