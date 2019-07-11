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
package net.runelite.client.plugins.skillcalculator.banked.beans;

import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
public enum Secondaries
{
	/**
	 * Herblore
	 */
	UNFINISHED_POTION(new ItemStack(ItemID.VIAL_OF_WATER, 1)),
	SWAMP_TAR(new ItemStack(ItemID.SWAMP_TAR, 15)),
	// Guam
	ATTACK_POTION(new ItemStack(ItemID.EYE_OF_NEWT, 1)),
	// Marrentil
	ANTIPOISON(new ItemStack(ItemID.UNICORN_HORN_DUST, 1)),
	// Tarromin
	STRENGTH_POTION(new ItemStack(ItemID.LIMPWURT_ROOT, 1)),
	SERUM_207(new ItemStack(ItemID.ASHES, 1)),
	// Harralander
	COMPOST_POTION(new ItemStack(ItemID.VOLCANIC_ASH, 1)),
	RESTORE_POTION(new ItemStack(ItemID.RED_SPIDERS_EGGS, 1)),
	ENERGY_POTION(new ItemStack(ItemID.CHOCOLATE_DUST, 1)),
	COMBAT_POTION(new ItemStack(ItemID.GOAT_HORN_DUST, 1)),
	// Ranarr Weed
	DEFENCE_POTION(new ItemStack(ItemID.WHITE_BERRIES, 1)),
	PRAYER_POTION(new ItemStack(ItemID.SNAPE_GRASS, 1)),
	// Toadflax
	AGILITY_POTION(new ItemStack(ItemID.TOADS_LEGS, 1)),
	SARADOMIN_BREW(new ItemStack(ItemID.CRUSHED_NEST, 1)),
	// Irit
	SUPER_ATTACK(new ItemStack(ItemID.EYE_OF_NEWT, 1)),
	SUPERANTIPOISON(new ItemStack(ItemID.UNICORN_HORN_DUST, 1)),
	// Avantoe
	FISHING_POTION(new ItemStack(ItemID.SNAPE_GRASS, 1)),
	SUPER_ENERGY_POTION(new ItemStack(ItemID.MORT_MYRE_FUNGUS, 1)),
	HUNTER_POTION(new ItemStack(ItemID.KEBBIT_TEETH_DUST, 1)),
	// Kwuarm
	SUPER_STRENGTH(new ItemStack(ItemID.LIMPWURT_ROOT, 1)),
	// Snapdragon
	SUPER_RESTORE(new ItemStack(ItemID.RED_SPIDERS_EGGS, 1)),
	SANFEW_SERUM(new ItemStack(ItemID.SNAKE_WEED, 1), new ItemStack(ItemID.UNICORN_HORN_DUST, 1), new ItemStack(ItemID.SUPER_RESTORE4, 1), new ItemStack(ItemID.NAIL_BEAST_NAILS, 1)),
	// Cadantine
	SUPER_DEFENCE_POTION(new ItemStack(ItemID.WHITE_BERRIES, 1)),
	// Lantadyme
	ANTIFIRE_POTION(new ItemStack(ItemID.DRAGON_SCALE_DUST, 1)),
	MAGIC_POTION(new ItemStack(ItemID.POTATO_CACTUS, 1)),
	// Dwarf Weed
	RANGING_POTION(new ItemStack(ItemID.WINE_OF_ZAMORAK, 1)),
	// Torstol
	ZAMORAK_BREW(new ItemStack(ItemID.JANGERBERRIES, 1)),
	SUPER_COMBAT_POTION(new ItemStack(ItemID.SUPER_ATTACK4, 1), new ItemStack(ItemID.SUPER_STRENGTH4, 1), new ItemStack(ItemID.SUPER_DEFENCE4, 1)),
	ANTIVENOM_PLUS(new ItemStack(ItemID.ANTIVENOM4, 1)),

	/**
	 * Smithing
	 */
	COAL_ORE(new ItemStack(ItemID.COAL, 1)),
	COAL_ORE_2(new ItemStack(ItemID.COAL, 2)),
	COAL_ORE_4(new ItemStack(ItemID.COAL, 4)),
	COAL_ORE_6(new ItemStack(ItemID.COAL, 6)),
	COAL_ORE_8(new ItemStack(ItemID.COAL, 8)),

	/**
	 * Crafting
	 */
	GOLD_BAR(new ItemStack(ItemID.GOLD_BAR, 1)),
	SILVER_BAR(new ItemStack(ItemID.SILVER_BAR, 1)),
	WATER_ORB(new ItemStack(ItemID.WATER_ORB, 1)),
	EARTH_ORB(new ItemStack(ItemID.EARTH_ORB, 1)),
	FIRE_ORB(new ItemStack(ItemID.FIRE_ORB, 1)),
	AIR_ORB(new ItemStack(ItemID.AIR_ORB, 1)),

	/**
	 * Construction
	 */
	COINS_100(new ItemStack(ItemID.COINS_995, 100)),
	COINS_250(new ItemStack(ItemID.COINS_995, 250)),
	COINS_500(new ItemStack(ItemID.COINS_995, 500)),
	COINS_1500(new ItemStack(ItemID.COINS_995, 1500)),

	/**
	 * Cooking
	 */
	JUG_OF_WATER(new ItemStack(ItemID.JUG_OF_WATER, 1)),
	;
	private final ItemStack[] items;

	Secondaries(ItemStack... items)
	{
		this.items = items;
	}
}