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

import java.util.HashSet;
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
		validWintertodtRewards = new HashSet<>();
		validWintertodtRewards.add(ItemID.DRAGON_AXE);
		validWintertodtRewards.add(ItemID.PHOENIX);
		validWintertodtRewards.add(ItemID.PYROMANCER_GARB);
		validWintertodtRewards.add(ItemID.PYROMANCER_ROBE);
		validWintertodtRewards.add(ItemID.PYROMANCER_HOOD);
		validWintertodtRewards.add(ItemID.PYROMANCER_BOOTS);
		validWintertodtRewards.add(ItemID.WARM_GLOVES);
		validWintertodtRewards.add(ItemID.BRUMA_TORCH);
		validWintertodtRewards.add(ItemID.TOME_OF_FIRE);
		validWintertodtRewards.add(ItemID.TOME_OF_FIRE_EMPTY);
		validWintertodtRewards.add(ItemID.BURNT_PAGE);
		validWintertodtRewards.add(ItemID.COINS_995);
		validWintertodtRewards.add(ItemID.SALTPETRE);
		validWintertodtRewards.add(ItemID.DYNAMITE);
		validWintertodtRewards.add(ItemID.LIMESTONE_BRICK);
		validWintertodtRewards.add(ItemID.PURE_ESSENCE);
		validWintertodtRewards.add(ItemID.LOGS);
		validWintertodtRewards.add(ItemID.OAK_LOGS);
		validWintertodtRewards.add(ItemID.WILLOW_LOGS);
		validWintertodtRewards.add(ItemID.MAPLE_LOGS);
		validWintertodtRewards.add(ItemID.TEAK_LOGS);
		validWintertodtRewards.add(ItemID.MAHOGANY_LOGS);
		validWintertodtRewards.add(ItemID.YEW_LOGS);
		validWintertodtRewards.add(ItemID.MAGIC_LOGS);
		validWintertodtRewards.add(ItemID.GRIMY_GUAM_LEAF);
		validWintertodtRewards.add(ItemID.IRIT_LEAF);
		validWintertodtRewards.add(ItemID.GRIMY_MARRENTILL);
		validWintertodtRewards.add(ItemID.GRIMY_HARRALANDER);
		validWintertodtRewards.add(ItemID.GRIMY_RANARR_WEED);
		validWintertodtRewards.add(ItemID.GRIMY_AVANTOE);
		validWintertodtRewards.add(ItemID.GRIMY_KWUARM);
		validWintertodtRewards.add(ItemID.GRIMY_CADANTINE);
		validWintertodtRewards.add(ItemID.GRIMY_TORSTOL);
		validWintertodtRewards.add(ItemID.RAW_ANCHOVIES);
		validWintertodtRewards.add(ItemID.RAW_TROUT);
		validWintertodtRewards.add(ItemID.RAW_SALMON);
		validWintertodtRewards.add(ItemID.RAW_LOBSTER);
		validWintertodtRewards.add(ItemID.RAW_SWORDFISH);
		validWintertodtRewards.add(ItemID.RAW_SHARK);
		validWintertodtRewards.add(ItemID.UNCUT_SAPPHIRE);
		validWintertodtRewards.add(ItemID.UNCUT_EMERALD);
		validWintertodtRewards.add(ItemID.UNCUT_RUBY);
		validWintertodtRewards.add(ItemID.UNCUT_DIAMOND);
		validWintertodtRewards.add(ItemID.IRON_ORE);
		validWintertodtRewards.add(ItemID.SILVER_ORE);
		validWintertodtRewards.add(ItemID.COAL);
		validWintertodtRewards.add(ItemID.GOLD_ORE);
		validWintertodtRewards.add(ItemID.MITHRIL_ORE);
		validWintertodtRewards.add(ItemID.ADAMANTITE_ORE);
		validWintertodtRewards.add(ItemID.RUNITE_ORE);
		validWintertodtRewards.add(ItemID.WATERMELON_SEED);
		validWintertodtRewards.add(ItemID.TARROMIN_SEED);
		validWintertodtRewards.add(ItemID.HARRALANDER_SEED);
		validWintertodtRewards.add(ItemID.RANARR_SEED);
		validWintertodtRewards.add(ItemID.TOADFLAX_SEED);
		validWintertodtRewards.add(ItemID.AVANTOE_SEED);
		validWintertodtRewards.add(ItemID.SNAPDRAGON_SEED);
		validWintertodtRewards.add(ItemID.DWARF_WEED_SEED);
		validWintertodtRewards.add(ItemID.ACORN);
		validWintertodtRewards.add(ItemID.WILLOW_SEED);
		validWintertodtRewards.add(ItemID.BANANA_TREE_SEED);
		validWintertodtRewards.add(ItemID.TEAK_SEED);
		validWintertodtRewards.add(ItemID.MAPLE_SEED);
		validWintertodtRewards.add(ItemID.MAHOGANY_SEED);
		validWintertodtRewards.add(ItemID.TORSTOL_SEED);
		validWintertodtRewards.add(ItemID.YEW_SEED);
		validWintertodtRewards.add(ItemID.MAGIC_SEED);
		validWintertodtRewards.add(ItemID.SPIRIT_SEED);
	}
}
