/*
 * Copyright (c) 2018, Tyler Nichols <tnichols@udel.edu>
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
package net.runelite.client.plugins.loottracker;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import net.runelite.api.ItemID;

// Loot is according to RS wiki [http://oldschoolrunescape.wikia.com/wiki/Wintertodt]
class WintertodtLoot
{
	private static Set<Integer> validWintertodtRewards;

	static boolean isWintertodtLoot(Integer itemID)
	{
		if (validWintertodtRewards == null)
		{
			loadValidWintertodtRewards();
		}

		return validWintertodtRewards.contains(itemID);
	}

	private static void loadValidWintertodtRewards()
	{
		validWintertodtRewards = ImmutableSet.of(
			ItemID.DRAGON_AXE,
			ItemID.PHOENIX,
			ItemID.PYROMANCER_GARB,
			ItemID.PYROMANCER_ROBE,
			ItemID.PYROMANCER_HOOD,
			ItemID.PYROMANCER_BOOTS,
			ItemID.WARM_GLOVES,
			ItemID.BRUMA_TORCH,
			ItemID.TOME_OF_FIRE,
			ItemID.TOME_OF_FIRE_EMPTY,
			ItemID.BURNT_PAGE,
			ItemID.COINS_995,
			ItemID.SALTPETRE,
			ItemID.DYNAMITE,
			ItemID.LIMESTONE_BRICK,
			ItemID.PURE_ESSENCE,
			ItemID.LOGS,
			ItemID.OAK_LOGS,
			ItemID.WILLOW_LOGS,
			ItemID.MAPLE_LOGS,
			ItemID.TEAK_LOGS,
			ItemID.MAHOGANY_LOGS,
			ItemID.YEW_LOGS,
			ItemID.MAGIC_LOGS,
			ItemID.GRIMY_GUAM_LEAF,
			ItemID.IRIT_LEAF,
			ItemID.GRIMY_MARRENTILL,
			ItemID.GRIMY_HARRALANDER,
			ItemID.GRIMY_RANARR_WEED,
			ItemID.GRIMY_AVANTOE,
			ItemID.GRIMY_KWUARM,
			ItemID.GRIMY_CADANTINE,
			ItemID.GRIMY_TORSTOL,
			ItemID.RAW_ANCHOVIES,
			ItemID.RAW_TROUT,
			ItemID.RAW_SALMON,
			ItemID.RAW_LOBSTER,
			ItemID.RAW_SWORDFISH,
			ItemID.RAW_SHARK,
			ItemID.UNCUT_SAPPHIRE,
			ItemID.UNCUT_EMERALD,
			ItemID.UNCUT_RUBY,
			ItemID.UNCUT_DIAMOND,
			ItemID.IRON_ORE,
			ItemID.SILVER_ORE,
			ItemID.COAL,
			ItemID.GOLD_ORE,
			ItemID.MITHRIL_ORE,
			ItemID.ADAMANTITE_ORE,
			ItemID.RUNITE_ORE,
			ItemID.WATERMELON_SEED,
			ItemID.TARROMIN_SEED,
			ItemID.HARRALANDER_SEED,
			ItemID.RANARR_SEED,
			ItemID.TOADFLAX_SEED,
			ItemID.AVANTOE_SEED,
			ItemID.SNAPDRAGON_SEED,
			ItemID.DWARF_WEED_SEED,
			ItemID.ACORN,
			ItemID.WILLOW_SEED,
			ItemID.BANANA_TREE_SEED,
			ItemID.TEAK_SEED,
			ItemID.MAPLE_SEED,
			ItemID.MAHOGANY_SEED,
			ItemID.TORSTOL_SEED,
			ItemID.YEW_SEED,
			ItemID.MAGIC_SEED,
			ItemID.SPIRIT_SEED
		);
	}
}
