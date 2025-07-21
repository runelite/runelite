/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.plugins.itemstats;

import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.gameval.ItemID;
import static net.runelite.client.plugins.itemstats.Builders.*;
import net.runelite.client.plugins.itemstats.delta.DeltaPercentage;
import net.runelite.client.plugins.itemstats.food.Anglerfish;
import net.runelite.client.plugins.itemstats.food.CookedBream;
import net.runelite.client.plugins.itemstats.food.CookedMossLizard;
import net.runelite.client.plugins.itemstats.special.SunlightMoth;
import net.runelite.client.plugins.itemstats.potions.Ambrosia;
import net.runelite.client.plugins.itemstats.potions.AncientBrew;
import net.runelite.client.plugins.itemstats.potions.MixedPotion;
import net.runelite.client.plugins.itemstats.potions.MoonlightPotion;
import net.runelite.client.plugins.itemstats.potions.PrayerPotion;
import net.runelite.client.plugins.itemstats.potions.SaradominBrew;
import net.runelite.client.plugins.itemstats.potions.StaminaPotion;
import net.runelite.client.plugins.itemstats.potions.SuperRestore;
import net.runelite.client.plugins.itemstats.special.CastleWarsBandage;
import net.runelite.client.plugins.itemstats.special.CaveNightshade;
import net.runelite.client.plugins.itemstats.special.NettleTeaRunEnergy;
import net.runelite.client.plugins.itemstats.special.SpicyStew;
import static net.runelite.client.plugins.itemstats.stats.Stats.*;

@Singleton
@Slf4j
public class ItemStatChanges
{
	ItemStatChanges()
	{
		init();
	}

	public static final SingleEffect ATTACK_POT = boost(ATTACK, perc(.10, 3));
	public static final SingleEffect STRENGTH_POT = boost(STRENGTH, perc(.10, 3));
	public static final SingleEffect DEFENCE_POT = boost(DEFENCE, perc(.10, 3));
	public static final SingleEffect SUPER_ATTACK_POT = boost(ATTACK, perc(.15, 5));
	public static final SingleEffect SUPER_STRENGTH_POT = boost(STRENGTH, perc(.15, 5));
	public static final SingleEffect SUPER_DEFENCE_POT = boost(DEFENCE, perc(.15, 5));

	private void init()
	{
		add(food(-5), ItemID.TBWT_POORLY_COOKED_KARAMBWAN);
		add(food(1), ItemID.POTATO, ItemID.ONION, ItemID.CABBAGE, ItemID.POT_OF_CREAM, ItemID.BOWL_ONION, ItemID.ANCHOVIES, ItemID.BOWL_NETTLEWATER, ItemID.EQUA_LEAVES,
			ItemID.SWAN_MONKFISH /* Cooked */, ItemID.COOKED_CHICKEN_UNDEAD /* Undead */, ItemID.COOKED_MEAT_UNDEAD /* Undead */);
		add(food(2), ItemID.TOMATO, ItemID.BOWL_TOMATO, ItemID.BANANA, ItemID.TBWT_SLICED_BANANA, ItemID.ORANGE, ItemID.ORANGE_SLICES, ItemID.ORANGE_CHUNKS,
			ItemID.PINEAPPLE_RING, ItemID.PINEAPPLE_CHUNKS, ItemID.BOWL_CHILLI, ItemID.CHEESE, ItemID.SPINACH_ROLL, ItemID.LEMON, ItemID.LEMON_CHUNKS, ItemID.LEMON_SLICES,
			ItemID.LIME, ItemID.LIME_CHUNKS, ItemID.LIME_SLICES, ItemID.DWELLBERRIES, ItemID.KING_WORM, ItemID.BOWL_CARNE, ItemID.BOWL_SPICYTOMATO, ItemID.MDAUGHTER_WHITE_PEARL_FRUIT);
		add(food(3), ItemID.SHRIMP, ItemID.COOKED_MEAT, ItemID.COOKED_CHICKEN, ItemID.BRUT_ROE, ItemID.CHOCOLATE_BAR, ItemID.COOKED_UGTHANKI_MEAT, ItemID.TOADS_LEGS, ItemID.BOWL_ONIONTOMATO,
			ItemID.BOWL_SPICYMEAT, ItemID.OS_BIRTHDAY_CAKE_SLICE, ItemID.LOCUST_MEAT, ItemID.BRUTAL_RELICYMS_BALM1, ItemID.BRUTAL_RELICYMS_BALM2, ItemID.BRUTAL_1DOSEANTIPOISON,
			ItemID.BRUTAL_2DOSEANTIPOISON);
		add(food(4), ItemID.SARDINE, ItemID.CAKE, ItemID.PARTIAL_CAKE, ItemID.CAKE_SLICE, ItemID.CHOCOLATY_MILK, ItemID.POTATO_BAKED, ItemID.EDIBLE_SEAWEED, ItemID.MOONLIGHT_MEAD,
			ItemID.KEG_MOONLIGHT_MEAD_4, ItemID.KEG_MOONLIGHT_MEAD_3, ItemID.KEG_MOONLIGHT_MEAD_2, ItemID.KEG_MOONLIGHT_MEAD_1, ItemID.MM_MONKEY_NUTS);
		add(food(5), ItemID.BREAD, ItemID.HERRING, ItemID.CHOCOLATE_CAKE, ItemID.PARTIAL_CHOCOLATE_CAKE, ItemID.CHOCOLATE_SLICE, ItemID.COOKED_RABBIT, ItemID.BOWL_CHILLI_CARNE,
			ItemID.BOWL_MUSHROOM_FRIED, ItemID.BOWL_ONION_FRIED, ItemID.REDBERRY_PIE, ItemID.HALF_A_REDBERRY_PIE, ItemID.BRUT_CAVIAR, ItemID.RAIDS_FISH0_COOKED, ItemID.COOKED_MYSTERY_MEAT,
			ItemID.BOWL_EGG_SCRAMBLED, ItemID.MM_MONKEY_BAR, ItemID.HUNDRED_ILM_TCHIKI_MONKEY_NUTS, ItemID.HUNDRED_ILM_TCHIKI_MONKEY_NUT_PASTE, ItemID.HUNDRED_ILM_RED_BANANA, ItemID.HUNDRED_ILM_SLICED_RED_BANANA);
		add(food(6), ItemID.MACKEREL, ItemID.MEAT_PIE, ItemID.HALF_A_MEAT_PIE, ItemID.RAIDS_BAT0_COOKED, ItemID.SPIT_ROASTED_BIRD_MEAT, ItemID.SQUARE_SANDWICH,
			ItemID.ROLL, ItemID.BAGUETTE, ItemID.TRIANGLE_SANDWICH, ItemID.GIANT_CARP, ItemID.MATURE_MOONLIGHT_MEAD, ItemID.KEG_MATURE_MOONLIGHT_MEAD_4, ItemID.KEG_MATURE_MOONLIGHT_MEAD_3, ItemID.KEG_MATURE_MOONLIGHT_MEAD_2,
			ItemID.KEG_MATURE_MOONLIGHT_MEAD_1, ItemID.BIM_STEAK_SANDWICH, ItemID.GIANT_FROG_LEGS, ItemID.BRUTAL_1DOSE1ANTIDRAGON, ItemID.BRUTAL_2DOSE1ANTIDRAGON, ItemID.BRUTAL_1DOSE2ANTIDRAGON,
			ItemID.BRUTAL_2DOSE2ANTIDRAGON, ItemID.BRUTAL_1DOSE3ANTIDRAGON, ItemID.BRUTAL_2DOSE3ANTIDRAGON, ItemID.BRUTAL_1DOSE4ANTIDRAGON,
			ItemID.BRUTAL_2DOSE4ANTIDRAGON, ItemID.BRUTAL_1DOSE2ANTIPOISON, ItemID.BRUTAL_2DOSE2ANTIPOISON, ItemID.BRUTAL_ANTIDOTE_1, ItemID.BRUTAL_ANTIDOTE_2);
		add(food(7), ItemID.ELID_CHOC_ICE, ItemID.TROUT, ItemID.COD, ItemID.PLAIN_PIZZA, ItemID.HALF_PLAIN_PIZZA, ItemID.APPLE_PIE, ItemID.HALF_AN_APPLE_PIE, ItemID.SPIT_ROASTED_RABBIT_MEAT,
			ItemID.PREMADE_CHOCCHIP_CRUNCHIES, ItemID.CHOCCHIP_CRUNCHIES, ItemID.PREMADE_SPICY_CRUNCHIES, ItemID.SPICY_CRUNCHIES);
		add(food(8), ItemID.PIKE, ItemID.SPIT_ROASTED_BEAST_MEAT, ItemID.MEAT_PIZZA, ItemID.HALF_MEAT_PIZZA, ItemID.PREMADE_WORM_CRUNCHIES, ItemID.WORM_CRUNCHIES, ItemID.PREMADE_TOAD_CRUNCHIES,
			ItemID.TOAD_CRUNCHIES, ItemID.BOWL_EGG_TOMATO, ItemID.RAIDS_BAT1_COOKED, ItemID.PEACH, ItemID.RAIDS_FISH1_COOKED);
		add(food(9), ItemID.PREMADE_PINEAPPLE_PUNCH, ItemID.PINEAPPLE_PUNCH, ItemID.PREMADE_FRUIT_BLAST, ItemID.FRUIT_BLAST, ItemID.SALMON, ItemID.ANCHOVIE_PIZZA,
			ItemID.HALF_ANCHOVIE_PIZZA);
		add(food(10), ItemID.TUNA, ItemID.HUNDRED_PIRATE_GIANT_CRAB_MEAT_5, ItemID.BOWL_TUNA, ItemID.COOKED_CHOMPY, ItemID.PEST_FIELD_RATION, ItemID.DRAGONFRUIT,
			ItemID.DEADMAN_STARTER_TUNA /* Deadman Starter Pack */);
		add(food(11), ItemID.HUNTING_FISH_SPECIAL, ItemID.STEW, ItemID.PINEAPPLE_PIZZA, ItemID.HALF_PINEAPPLE_PIZZA, ItemID.HUNDRED_PIRATE_FISHCAKE,
			ItemID.PREMADE_VEGETABLE_BATTA, ItemID.VEGETABLE_BATTA, ItemID.PREMADE_WORM_BATTA, ItemID.WORM_BATTA, ItemID.PREMADE_TOAD_BATTA, ItemID.TOAD_BATTA, ItemID.PREMADE_CHEESE_TOM_BATTA,
			ItemID.CHEESE_TOM_BATTA, ItemID.PREMADE_FRUIT_BATTA, ItemID.FRUIT_BATTA, ItemID.BOWL_MUSHROOM_ONION, ItemID.RAIDS_BAT2_COOKED, ItemID.LAVA_EEL, ItemID.RAIDS_FISH2_COOKED, ItemID.MM_BANANA_STEW);
		add(food(12), ItemID.LOBSTER, ItemID.PREMADE_WORM_HOLE, ItemID.WORM_HOLE, ItemID.PREMADE_VEG_BALL, ItemID.VEG_BALL);
		add(food(13), ItemID.BASS, ItemID.BOWL_TUNA_SWEETCORN);
		add(food(14), ItemID.POTATO_BUTTER, ItemID.POTATO_CHILLI_CARNE, ItemID.SWORDFISH, ItemID.RAIDS_BAT3_COOKED, ItemID.PUMPKIN, ItemID.EASTER_EGG, ItemID.RAIDS_FISH3_COOKED,
			ItemID.COOKED_OOMLIE);
		add(food(15), ItemID.PREMADE_TANGLED_TOADS_LEGS, ItemID.TANGLED_TOADS_LEGS, ItemID.PREMADE_CHOCOLATE_BOMB, ItemID.CHOCOLATE_BOMB, ItemID._100_JUBBLY_MEAT_COOKED);
		add(food(16), ItemID.MONKFISH, ItemID.POTATO_CHEESE, ItemID.POTATO_EGG_TOMATO, ItemID.GAUNTLET_COMBO_FOOD, ItemID.GAUNTLET_COMBO_FOOD_HM);
		add(food(17), ItemID.RAIDS_FISH4_COOKED, ItemID.RAIDS_BAT4_COOKED);
		add(food(18), ItemID.TBWT_COOKED_KARAMBWAN, ItemID.BLIGHTED_KARAMBWAN, ItemID.BR_TBWT_COOKED_KARAMBWAN /* LMS */);
		add(food(19), ItemID.CURRY, ItemID.UGTHANKI_KEBAB_BAD, ItemID.UGTHANKI_KEBAB);
		add(food(20), ItemID.POTATO_MUSHROOM_ONION, ItemID.SHARK, ItemID.RAIDS_FISH5_COOKED, ItemID.RAIDS_BAT5_COOKED, ItemID.HUNDRED_ILM_COOKED_STUFFED_SNAKE, ItemID.BR_SHARK /* LMS */, ItemID.GAUNTLET_FOOD);
		add(food(21), ItemID.SEATURTLE);
		add(food(22), ItemID.MANTARAY, ItemID.BLIGHTED_MANTARAY, ItemID.DARK_CRAB, ItemID.POTATO_TUNA_SWEETCORN);
		add(food(23), ItemID.RAIDS_FISH6_COOKED, ItemID.RAIDS_BAT6_COOKED);
		add(new Anglerfish(), ItemID.ANGLERFISH, ItemID.BLIGHTED_ANGLERFISH);
		add(food(maxHP -> (int) Math.ceil(maxHP * .06)), ItemID.STRAWBERRY);
		add(food(maxHP -> (int) Math.ceil(maxHP * .05)), ItemID.WATERMELON_SLICE);
		add(food(perc(.1, 1)), ItemID.SWEETCORN_COOKED, ItemID.BOWL_SWEETCORN /* Bowl of cooked sweetcorn */);
		add(new CookedBream(), ItemID.BREAM_FISH_COOKED);
		add(new CookedMossLizard(), ItemID.COOKED_LIZARD);
		add(combo(food(1), boost(DEFENCE, perc(.02, 1))), ItemID.MAGIC_CABBAGE /* Draynor Manor */);
		add(combo(food(8), heal(RUN_ENERGY, 5)), ItemID.PAPAYA);
		add(combo(food(3), boost(ATTACK, perc(.02, 2))), ItemID.CUP_OF_TEA /* Standard tea */);
		add(combo(food(3), new NettleTeaRunEnergy()), ItemID.BOWL_NETTLETEA, ItemID.BOWL_NETTLETEA_MILKY /* Milky */, ItemID.CUP_OF_NETTLETEA /* Nettle */, ItemID.CUP_OF_NETTLETEA_MILKY /* Milky nettle */);
		add(range(food(5), food(7)), ItemID.SNAIL_CORPSE_COOKED1);
		add(range(food(5), food(8)), ItemID.SNAIL_CORPSE_COOKED2);
		add(range(food(7), food(9)), ItemID.SNAIL_CORPSE_COOKED3);
		add(range(food(7), food(10)), ItemID.TBW_SPIDER_ON_STICK_COOKED, ItemID.TBW_SPIDER_ON_SHAFT_COOKED);
		add(combo(food(8), food(6)), ItemID.GRAAHK_COOKED);
		add(combo(food(9), food(8)), ItemID.KYATT_COOKED);
		add(combo(food(11), food(8)), ItemID.FENNECFOX_COOKED);
		add(combo(food(13), food(10), heal(RUN_ENERGY, 10)), ItemID.DASHINGKEBBIT_COOKED);
		add(combo(food(12), food(9)), ItemID.ANTELOPESUN_COOKED);
		add(combo(food(14), food(12)), ItemID.ANTELOPEMOON_COOKED);

		// Dorgeshuun Cuisine
		add(food(2), ItemID.DORGESH_BAT_SHISH, ItemID.DORGESH_CRISPY_FROGLEGS, ItemID.DORGESH_CAVE_CRAWLER_FILLETS, ItemID.DORGESH_WALL_BEAST_FINGERS, ItemID.DORGESH_FROG_BURGER, ItemID.DORGESH_FROG_SPAWN_GUMBO, ItemID.DORGESH_GREEN_GLOOP_SOUP,
			ItemID.DORGESH_GRUBS_A_LA_MODE, ItemID.DORGESH_SAUTEED_MUSHROOMS, ItemID.DORGESH_WHOLE_ROASTED_FROG);
		add(food(3), ItemID.DORGESH_STEAMED_POND_LOACH);
		add(range(food(3), food(6)), ItemID.GIANT_FROGSPAWN);
		add(range(food(6), food(10)), ItemID.MORT_SLIMEY_EEL_COOKED);
		add(range(food(8), food(12)), ItemID.CAVE_EEL);
		add(food(10), ItemID.DORGESH_CAVE_EEL_SUSHI);

		// Alcoholic Beverages
		// Many of these retrieved from https://oldschool.runescape.wiki/w/Temporary_skill_drain
		add(combo(food(11), dec(ATTACK, 2)), ItemID.JUG_WINE);
		add(combo(food(14), dec(ATTACK, 3)), ItemID.RAG_BOTTLE_WINE);
		add(combo(food(7), dec(ATTACK, 2)), ItemID.HALF_FULL_WINE_JUG);
		add(dec(ATTACK, 3), ItemID.JUG_BAD_WINE);
		add(combo(food(5), new SimpleStatBoost(STRENGTH, true, perc(.05, 1)), new BoostedStatBoost(ATTACK, false, perc(.02, -3))), ItemID.PREMADE_SGG, ItemID.SGG, ItemID.BRANDY, ItemID.GIN, ItemID.VODKA, ItemID.WHISKY);
		add(combo(food(7), new SimpleStatBoost(STRENGTH, true, perc(.05, 2)), new BoostedStatBoost(ATTACK, false, perc(.02, -3))), ItemID.PREMADE_BLURBERRY_SPECIAL, ItemID.BLURBERRY_SPECIAL);
		add(combo(food(5), new SimpleStatBoost(STRENGTH, true, perc(.05, 2)), new BoostedStatBoost(ATTACK, false, perc(.02, -3))), ItemID.PREMADE_DRUNK_DRAGON, ItemID.DRUNK_DRAGON, ItemID.PREMADE_CHOC_SATURDAY, ItemID.CHOCOLATE_SATURDAY);
		add(combo(food(5), new SimpleStatBoost(STRENGTH, true, perc(.06, 1)), new BoostedStatBoost(ATTACK, false, perc(.02, -3))), ItemID.PREMADE_WIZARD_BLIZZARD, ItemID.WIZARD_BLIZZARD);
		add(combo(food(3), new SimpleStatBoost(STRENGTH, true, perc(.04, 1)), new BoostedStatBoost(ATTACK, false, perc(.05, -3))), ItemID.GROG);
		add(combo(food(1), boost(STRENGTH, perc(.02, 1)), new BoostedStatBoost(ATTACK, false, perc(.06, -1))), ItemID.BEER, ItemID.POH_BEER);
		add(combo(food(4), boost(STRENGTH, perc(.04, 2)), new BoostedStatBoost(ATTACK, false, perc(.1, -2))), ItemID.VIKING_TANKARD_FULL);
		add(combo(food(15), boost(STRENGTH, perc(.1, 2)), new BoostedStatBoost(ATTACK, false, perc(.5, -4))), ItemID.KEG_OF_BEER /* Non-quest version */);
		add(combo(boost(ATTACK, 5), boost(STRENGTH, 5), heal(MAGIC, -5), heal(PRAYER, -5)), ItemID.BLOOD_PINT);
		add(combo(food(1), boost(STRENGTH, 2), new BoostedStatBoost(ATTACK, false, perc(.05, -2))), ItemID.ASGARNIAN_ALE, ItemID.KEG_ASGARNIAN_ALE_1, ItemID.KEG_ASGARNIAN_ALE_2, ItemID.KEG_ASGARNIAN_ALE_3, ItemID.KEG_ASGARNIAN_ALE_4, ItemID.POH_ASGARNIAN_ALE);
		add(combo(food(1), boost(STRENGTH, 3), new BoostedStatBoost(ATTACK, false, perc(.05, -3))), ItemID.MATURE_ASGARNIAN_ALE, ItemID.KEG_MATURE_ASGARNIAN_ALE_1, ItemID.KEG_MATURE_ASGARNIAN_ALE_2, ItemID.KEG_MATURE_ASGARNIAN_ALE_3, ItemID.KEG_MATURE_ASGARNIAN_ALE_4);
		add(combo(food(1), boost(WOODCUTTING, 1), new BoostedStatBoost(ATTACK, false, perc(.02, -2)), new BoostedStatBoost(STRENGTH, false, perc(.02, -2))), ItemID.AXEMANS_FOLLY, ItemID.KEG_AXEMANS_FOLLY_1, ItemID.KEG_AXEMANS_FOLLY_2, ItemID.KEG_AXEMANS_FOLLY_3, ItemID.KEG_AXEMANS_FOLLY_4);
		add(combo(food(2), boost(WOODCUTTING, 2), new BoostedStatBoost(ATTACK, false, perc(.02, -3)), new BoostedStatBoost(STRENGTH, false, perc(.02, -3))), ItemID.MATURE_AXEMANS_FOLLY, ItemID.KEG_MATURE_AXEMANS_FOLLY_1, ItemID.KEG_MATURE_AXEMANS_FOLLY_2, ItemID.KEG_MATURE_AXEMANS_FOLLY_3, ItemID.KEG_MATURE_AXEMANS_FOLLY_4);
		add(combo(food(1), boost(THIEVING, 1), boost(ATTACK, 1),  new BoostedStatBoost(DEFENCE, false, perc(.06, -3)), new BoostedStatBoost(STRENGTH, false, perc(.06, -3))), ItemID.BANDIT_BREW);
		add(combo(food(1), new SimpleStatBoost(COOKING, true, perc(.05, 1)), new BoostedStatBoost(ATTACK, false, perc(.05, -2)), new BoostedStatBoost(STRENGTH, false, perc(.05, -2))), ItemID.CHEFS_DELIGHT, ItemID.KEG_CHEFS_DELIGHT_1, ItemID.KEG_CHEFS_DELIGHT_2, ItemID.KEG_CHEFS_DELIGHT_3, ItemID.KEG_CHEFS_DELIGHT_4, ItemID.POH_CHEFS_DELIGHT);
		add(combo(food(2), new SimpleStatBoost(COOKING, true, perc(.05, 2)), new BoostedStatBoost(ATTACK, false, perc(.05, -3)), new BoostedStatBoost(STRENGTH, false, perc(.05, -3))), ItemID.MATURE_CHEFS_DELIGHT, ItemID.KEG_MATURE_CHEFS_DELIGHT_1, ItemID.KEG_MATURE_CHEFS_DELIGHT_2, ItemID.KEG_MATURE_CHEFS_DELIGHT_3, ItemID.KEG_MATURE_CHEFS_DELIGHT_4);
		add(combo(food(1), boost(FARMING, 1), new BoostedStatBoost(ATTACK, false, perc(.02, -2)), new BoostedStatBoost(STRENGTH, false, perc(.02, -2))), ItemID.CIDER, ItemID.KEG_CIDER_1, ItemID.KEG_CIDER_2, ItemID.KEG_CIDER_3, ItemID.KEG_CIDER_4, ItemID.POH_CIDER);
		add(combo(food(2), boost(FARMING, 2), new BoostedStatBoost(ATTACK, false, perc(.02, -3)), new BoostedStatBoost(STRENGTH, false, perc(.02, -3))), ItemID.MATURE_CIDER, ItemID.KEG_MATURE_CIDER_1, ItemID.KEG_MATURE_CIDER_2, ItemID.KEG_MATURE_CIDER_3, ItemID.KEG_MATURE_CIDER_4);
		add(combo(food(1), boost(STRENGTH, 2), new BoostedStatBoost(ATTACK, false, perc(.05, -2))), ItemID.DRAGON_BITTER, ItemID.KEG_DRAGON_BITTER_1, ItemID.KEG_DRAGON_BITTER_2, ItemID.KEG_DRAGON_BITTER_3, ItemID.KEG_DRAGON_BITTER_4, ItemID.POH_DRAGON_BITTER);
		add(combo(food(2), boost(STRENGTH, 3), new BoostedStatBoost(ATTACK, false, perc(.05, -2))), ItemID.MATURE_DRAGON_BITTER, ItemID.KEG_MATURE_DRAGON_BITTER_1, ItemID.KEG_MATURE_DRAGON_BITTER_2, ItemID.KEG_MATURE_DRAGON_BITTER_3, ItemID.KEG_MATURE_DRAGON_BITTER_4);
		add(combo(food(1), boost(MINING, 1), boost(SMITHING, 1), new BoostedStatBoost(ATTACK, false, perc(.04, -2)), new BoostedStatBoost(DEFENCE, false, perc(.04, -2)), new BoostedStatBoost(STRENGTH, false, perc(.04, -2))), ItemID.DWARVEN_STOUT, ItemID.KEG_DWARVEN_STOUT_1, ItemID.KEG_DWARVEN_STOUT_2, ItemID.KEG_DWARVEN_STOUT_3, ItemID.KEG_DWARVEN_STOUT_4);
		add(combo(food(2), boost(MINING, 2), boost(SMITHING, 2), new BoostedStatBoost(ATTACK, false, perc(.04, -3)), new BoostedStatBoost(DEFENCE, false, perc(.04, -3)), new BoostedStatBoost(STRENGTH, false, perc(.04, -3))), ItemID.MATURE_DWARVEN_STOUT, ItemID.KEG_MATURE_DWARVEN_STOUT_1, ItemID.KEG_MATURE_DWARVEN_STOUT_2, ItemID.KEG_MATURE_DWARVEN_STOUT_3, ItemID.KEG_MATURE_DWARVEN_STOUT_4);
		add(combo(food(1), boost(SMITHING, 4), dec(ATTACK, 2), dec(RANGED, 2), dec(MAGIC, 2)), ItemID.KOVACS_GROG);
		add(combo(food(1), boost(HERBLORE, 1), new BoostedStatBoost(ATTACK, false, perc(.04, -2)), new BoostedStatBoost(DEFENCE, false, perc(.04, -2)), new BoostedStatBoost(STRENGTH, false, perc(.04, -2))), ItemID.GREENMANS_ALE, ItemID.KEG_GREENMANS_ALE_1, ItemID.KEG_GREENMANS_ALE_2, ItemID.KEG_GREENMANS_ALE_3, ItemID.KEG_GREENMANS_ALE_4, ItemID.POH_GREENMANS_ALE);
		add(combo(food(2), boost(HERBLORE, 2), new BoostedStatBoost(ATTACK, false, perc(.04, -3)), new BoostedStatBoost(DEFENCE, false, perc(.04, -3)), new BoostedStatBoost(STRENGTH, false, perc(.04, -3))), ItemID.MATURE_GREENMANS_ALE, ItemID.KEG_MATURE_GREENMANS_ALE_1, ItemID.KEG_MATURE_GREENMANS_ALE_2, ItemID.KEG_MATURE_GREENMANS_ALE_3, ItemID.KEG_MATURE_GREENMANS_ALE_4);
		add(combo(food(1), boost(SLAYER, 2), new BoostedStatBoost(ATTACK, false, perc(.02, -2)), new BoostedStatBoost(DEFENCE, false, perc(.02, -2)), new BoostedStatBoost(STRENGTH, false, perc(.02, -2))), ItemID.SLAYERS_RESPITE, ItemID.KEG_SLAYERS_RESPITE_1, ItemID.KEG_SLAYERS_RESPITE_2, ItemID.KEG_SLAYERS_RESPITE_3, ItemID.KEG_SLAYERS_RESPITE_4);
		add(combo(food(2), boost(SLAYER, 4), new BoostedStatBoost(ATTACK, false, perc(.02, -3)), new BoostedStatBoost(DEFENCE, false, perc(.02, -3)), new BoostedStatBoost(STRENGTH, false, perc(.02, -3))), ItemID.MATURE_SLAYERS_RESPITE, ItemID.KEG_MATURE_SLAYERS_RESPITE_1, ItemID.KEG_MATURE_SLAYERS_RESPITE_2, ItemID.KEG_MATURE_SLAYERS_RESPITE_3, ItemID.KEG_MATURE_SLAYERS_RESPITE_4);
		add(combo(food(1), new SimpleStatBoost(MAGIC, true, perc(.02, 2)), new BoostedStatBoost(ATTACK, false, perc(.05, -1)), new BoostedStatBoost(DEFENCE, false, perc(.05, -1)), new BoostedStatBoost(STRENGTH, false, perc(.05, -1))), ItemID.WIZARDS_MIND_BOMB, ItemID.KEG_WIZARDS_MIND_BOMB_1, ItemID.KEG_WIZARDS_MIND_BOMB_2, ItemID.KEG_WIZARDS_MIND_BOMB_3, ItemID.KEG_WIZARDS_MIND_BOMB_4);
		add(combo(food(2), new SimpleStatBoost(MAGIC, true, perc(.02, 3)), new BoostedStatBoost(ATTACK, false, perc(.05, -2)), new BoostedStatBoost(DEFENCE, false, perc(.05, -2)), new BoostedStatBoost(STRENGTH, false, perc(.05, -2))), ItemID.MATURE_WIZARDS_MIND_BOMB, ItemID.KEG_MATURE_WIZARDS_MIND_BOMB_1, ItemID.KEG_MATURE_WIZARDS_MIND_BOMB_2, ItemID.KEG_MATURE_WIZARDS_MIND_BOMB_3, ItemID.KEG_MATURE_WIZARDS_MIND_BOMB_4);
		add(combo(food(14), boost(STRENGTH, 3), boost(MINING, 1), heal(PRAYER, perc(.06, -1)), new BoostedStatBoost(AGILITY, false, perc(.09, -3)), new BoostedStatBoost(ATTACK, false, perc(.06, -1)), new BoostedStatBoost(DEFENCE, false, perc(.08, -2)), new BoostedStatBoost(HERBLORE, false, perc(.06, -1)), new BoostedStatBoost(MAGIC, false, perc(.05, -1)), new BoostedStatBoost(RANGED, false, perc(.06, -1))), ItemID.FEVER_RUM);
		add(combo(food(2), heal(PRAYER, perc(.04, -2))), ItemID.SLEPE_BLOODY_BRACER);
		add(combo(food(1), boost(AGILITY, 1), heal(STRENGTH, -1)), ItemID.PRIF_ELVEN_DAWN);
		add(combo(boost(RANGED, 4), new BoostedStatBoost(STRENGTH, false, perc(.04, -2)), new BoostedStatBoost(MAGIC, false, perc(.04, -2))), ItemID.SHAYZIEN_LIZARDKICKER);
		add(combo(food(1), boost(HUNTER, 2), dec(STRENGTH, 1), dec(ATTACK, 2)), ItemID.TRAPPERS_TIPPLE);
		add(combo(food(1), boost(AGILITY, 1), boost(STRENGTH, 1), new BoostedStatBoost(ATTACK, false, perc(.05, -1))), ItemID.SUNBEAM_ALE);
		add(combo(food(5), boost(STRENGTH, perc(.05, 1)), new BoostedStatBoost(ATTACK, false, perc(0.02, -3))), ItemID.MOONLITE);
		add(combo(food(5), boost(STRENGTH, perc(.05, 1)), new BoostedStatBoost(ATTACK, false, perc(0.02, -3))), ItemID.SUNSHINE);
		add(combo(food(5), boost(STRENGTH, 5), new BoostedStatBoost(ATTACK, false, perc(.02, -3))), ItemID.RUM);
		add(combo(food(16), boost(WOODCUTTING, 1), heal(ATTACK, -5), heal(FLETCHING, -1)), ItemID.ECLIPSE_WINE);
		add(combo(food(1), boost(MAGIC, 1), boost(MINING, 1), new BoostedStatBoost(ATTACK, false, perc(.05, -3)), new BoostedStatBoost(DEFENCE, false, perc(.05, -3))), ItemID.STEAMFORGE_BREW);
		add(combo(food(16), boost(HUNTER, 1), dec(ATTACK, 5), dec(SLAYER, 1)), ItemID.BLACKBIRD_RED);
		add(combo(food(16), boost(FIREMAKING, 1), dec(ATTACK, 5), dec(COOKING, 1)), ItemID.CHILHUAC_RED);
		add(combo(food(16), boost(FARMING, 1), dec(ATTACK, 5), dec(HERBLORE, 1)), ItemID.IXCOZTIC_WHITE);
		add(combo(food(16), boost(RUNECRAFT, 1), dec(ATTACK, 5), dec(FIREMAKING, 1)), ItemID.METZTONALLI_WHITE);
		add(combo(food(16), boost(PRAYER, 1), dec(ATTACK, 5), dec(THIEVING, 1)), ItemID.TONAMEYO_WHITE);
		add(combo(food(16), boost(HERBLORE, 1), dec(ATTACK, 5), dec(FARMING, 1)), ItemID.CHICHILIHUI_ROSE);
		add(combo(food(16), boost(SLAYER, 1), dec(ATTACK, 5), dec(AGILITY, 1)), ItemID.IMPERIAL_ROSE);

		// Sq'irk Juice
		add(heal(RUN_ENERGY, 5), ItemID.OSMAN_SQUIRK_J_WINTER);
		add(combo(heal(RUN_ENERGY, 10), boost(THIEVING, 1)), ItemID.OSMAN_SQUIRK_J_SPRING);
		add(combo(heal(RUN_ENERGY, 15), boost(THIEVING, 2)), ItemID.OSMAN_SQUIRK_J_AUTUMN);
		add(combo(heal(RUN_ENERGY, 20), boost(THIEVING, 3)), ItemID.OSMAN_SQUIRK_J_SUMMER);

		// Combat potions
		final Effect combatPot = combo(ATTACK_POT, STRENGTH_POT);
		final Effect magicEssence = boost(MAGIC, 3);
		final SingleEffect magicPot = boost(MAGIC, 4);
		final SingleEffect imbuedHeart = boost(MAGIC, perc(.10, 1));
		final SingleEffect rangingPot = boost(RANGED, perc(.10, 4));
		final SingleEffect superMagicPot = boost(MAGIC, perc(.15, 5));
		final SingleEffect superRangingPot = boost(RANGED, perc(.15, 5));
		final SingleEffect divinePot = heal(HITPOINTS, -10);
		final Effect zamorakBrew = combo(boost(ATTACK, perc(.20, 2)), boost(STRENGTH, perc(.12, 2)), heal(PRAYER, perc(.10, 0)), new BoostedStatBoost(DEFENCE, false, perc(.10, -2)), new BoostedStatBoost(HITPOINTS, false, perc(-.12, 0)));
		final Effect ancientBrew = new AncientBrew(.05, 2);
		add(ATTACK_POT, ItemID._1DOSE1ATTACK, ItemID._2DOSE1ATTACK, ItemID._3DOSE1ATTACK, ItemID._4DOSE1ATTACK);
		add(STRENGTH_POT, ItemID._1DOSE1STRENGTH, ItemID._2DOSE1STRENGTH, ItemID._3DOSE1STRENGTH, ItemID.STRENGTH4);
		add(DEFENCE_POT, ItemID._1DOSE1DEFENSE, ItemID._2DOSE1DEFENSE, ItemID._3DOSE1DEFENSE, ItemID._4DOSE1DEFENSE);
		add(magicPot, ItemID._1DOSE1MAGIC, ItemID._2DOSE1MAGIC, ItemID._3DOSE1MAGIC, ItemID._4DOSE1MAGIC);
		add(rangingPot, ItemID._1DOSERANGERSPOTION, ItemID._2DOSERANGERSPOTION, ItemID._3DOSERANGERSPOTION, ItemID._4DOSERANGERSPOTION,
			ItemID.BR_4DOSERANGERSPOTION, ItemID.BR_3DOSERANGERSPOTION, ItemID.BR_2DOSERANGERSPOTION, ItemID.BR_1DOSERANGERSPOTION /* LMS */);
		add(combatPot, ItemID._1DOSECOMBAT, ItemID._2DOSECOMBAT, ItemID._3DOSECOMBAT, ItemID._4DOSECOMBAT,
			ItemID._4DOSECOMBAT_DEADMAN_STARTER, ItemID._3DOSECOMBAT_DEADMAN_STARTER, ItemID._2DOSECOMBAT_DEADMAN_STARTER, ItemID._1DOSECOMBAT_DEADMAN_STARTER /* Deadman starter pack */);
		add(SUPER_ATTACK_POT, ItemID._1DOSE2ATTACK, ItemID._2DOSE2ATTACK, ItemID._3DOSE2ATTACK, ItemID._4DOSE2ATTACK);
		add(SUPER_STRENGTH_POT, ItemID._1DOSE2STRENGTH, ItemID._2DOSE2STRENGTH, ItemID._3DOSE2STRENGTH, ItemID._4DOSE2STRENGTH);
		add(SUPER_DEFENCE_POT, ItemID._1DOSE2DEFENSE, ItemID._2DOSE2DEFENSE, ItemID._3DOSE2DEFENSE, ItemID._4DOSE2DEFENSE);
		add(magicEssence, ItemID._1DOSEMAGICESS, ItemID._2DOSEMAGICESS, ItemID._3DOSEMAGICESS, ItemID._4DOSEMAGICESS);
		add(combo(SUPER_ATTACK_POT, SUPER_STRENGTH_POT, SUPER_DEFENCE_POT), ItemID._1DOSE2COMBAT, ItemID._2DOSE2COMBAT, ItemID._3DOSE2COMBAT, ItemID._4DOSE2COMBAT);
		add(zamorakBrew, ItemID._1DOSEPOTIONOFZAMORAK, ItemID._2DOSEPOTIONOFZAMORAK, ItemID._3DOSEPOTIONOFZAMORAK, ItemID._4DOSEPOTIONOFZAMORAK);
		add(new SaradominBrew(0.15, 0.2, 0.1, 2, 2), ItemID._1DOSEPOTIONOFSARADOMIN, ItemID._2DOSEPOTIONOFSARADOMIN, ItemID._3DOSEPOTIONOFSARADOMIN,
			ItemID._4DOSEPOTIONOFSARADOMIN, ItemID.BR_4DOSEPOTIONOFSARADOMIN, ItemID.BR_3DOSEPOTIONOFSARADOMIN, ItemID.BR_2DOSEPOTIONOFSARADOMIN, ItemID.BR_1DOSEPOTIONOFSARADOMIN /* LMS */);
		add(superRangingPot, ItemID.NZONE1DOSE2RANGERSPOTION, ItemID.NZONE2DOSE2RANGERSPOTION, ItemID.NZONE3DOSE2RANGERSPOTION, ItemID.NZONE4DOSE2RANGERSPOTION);
		add(superMagicPot, ItemID.NZONE1DOSE2MAGICPOTION, ItemID.NZONE2DOSE2MAGICPOTION, ItemID.NZONE3DOSE2MAGICPOTION, ItemID.NZONE4DOSE2MAGICPOTION);
		add(combo(rangingPot, SUPER_DEFENCE_POT), ItemID._1DOSEBASTION, ItemID._2DOSEBASTION, ItemID._3DOSEBASTION, ItemID._4DOSEBASTION);
		add(combo(magicPot, SUPER_DEFENCE_POT), ItemID._1DOSEBATTLEMAGE, ItemID._2DOSEBATTLEMAGE, ItemID._3DOSEBATTLEMAGE, ItemID._4DOSEBATTLEMAGE);
		add(combo(magicPot, divinePot), ItemID._1DOSEDIVINEMAGIC, ItemID._2DOSEDIVINEMAGIC, ItemID._3DOSEDIVINEMAGIC, ItemID._4DOSEDIVINEMAGIC);
		add(combo(rangingPot, divinePot), ItemID._1DOSEDIVINERANGE, ItemID._2DOSEDIVINERANGE, ItemID._3DOSEDIVINERANGE, ItemID._4DOSEDIVINERANGE);
		add(combo(SUPER_ATTACK_POT, divinePot), ItemID._1DOSEDIVINEATTACK, ItemID._2DOSEDIVINEATTACK, ItemID._3DOSEDIVINEATTACK, ItemID._4DOSEDIVINEATTACK);
		add(combo(SUPER_STRENGTH_POT, divinePot), ItemID._1DOSEDIVINESTRENGTH, ItemID._2DOSEDIVINESTRENGTH, ItemID._3DOSEDIVINESTRENGTH, ItemID._4DOSEDIVINESTRENGTH);
		add(combo(SUPER_DEFENCE_POT, divinePot), ItemID._1DOSEDIVINEDEFENCE, ItemID._2DOSEDIVINEDEFENCE, ItemID._3DOSEDIVINEDEFENCE, ItemID._4DOSEDIVINEDEFENCE);
		add(combo(SUPER_ATTACK_POT, SUPER_STRENGTH_POT, SUPER_DEFENCE_POT, divinePot), ItemID._1DOSEDIVINECOMBAT, ItemID._2DOSEDIVINECOMBAT, ItemID._3DOSEDIVINECOMBAT, ItemID._4DOSEDIVINECOMBAT);
		add(combo(rangingPot, SUPER_DEFENCE_POT, divinePot), ItemID._1DOSEDIVINEBASTION, ItemID._2DOSEDIVINEBASTION, ItemID._3DOSEDIVINEBASTION, ItemID._4DOSEDIVINEBASTION);
		add(combo(magicPot, SUPER_DEFENCE_POT, divinePot), ItemID._1DOSEDIVINEBATTLEMAGE, ItemID._2DOSEDIVINEBATTLEMAGE, ItemID._3DOSEDIVINEBATTLEMAGE, ItemID._4DOSEDIVINEBATTLEMAGE);
		add(combo(SUPER_ATTACK_POT, SUPER_STRENGTH_POT, SUPER_DEFENCE_POT, rangingPot, imbuedHeart),
			ItemID._4DOSE_CASTLEWARS_SKILL_POTION, ItemID._3DOSE_CASTLEWARS_SKILL_POTION, ItemID._2DOSE_CASTLEWARS_SKILL_POTION, ItemID._1DOSE_CASTLEWARS_SKILL_POTION);
		add(combo(SUPER_ATTACK_POT, SUPER_STRENGTH_POT),
			ItemID.BR_4DOSE2COMBAT, ItemID.BR_3DOSE2COMBAT, ItemID.BR_2DOSE2COMBAT, ItemID.BR_1DOSE2COMBAT /* LMS */);
		add(ancientBrew, ItemID._1DOSEANCIENTBREW, ItemID._2DOSEANCIENTBREW, ItemID._3DOSEANCIENTBREW, ItemID._4DOSEANCIENTBREW);
		add(new AncientBrew(.08, 3), ItemID._1DOSEFORGOTTENBREW, ItemID._2DOSEFORGOTTENBREW, ItemID._3DOSEFORGOTTENBREW, ItemID._4DOSEFORGOTTENBREW);
		add(new MoonlightPotion(), ItemID._1DOSEMOONLIGHTPOTION, ItemID._2DOSEMOONLIGHTPOTION, ItemID._3DOSEMOONLIGHTPOTION, ItemID._4DOSEMOONLIGHTPOTION);

		// Mixed combat potions
		add(new MixedPotion(3, ATTACK_POT), ItemID.BRUTAL_1DOSE1ATTACK, ItemID.BRUTAL_2DOSE1ATTACK);
		add(new MixedPotion(3, STRENGTH_POT), ItemID.BRUTAL_1DOSE1STRENGTH, ItemID.BRUTAL_2DOSE1STRENGTH);
		add(new MixedPotion(3, combatPot), ItemID.BRUTAL_1DOSECOMBAT, ItemID.BRUTAL_2DOSECOMBAT);
		add(new MixedPotion(6, DEFENCE_POT), ItemID.BRUTAL_1DOSE1DEFENSE, ItemID.BRUTAL_2DOSE1DEFENSE);
		add(new MixedPotion(6, magicPot), ItemID.BRUTAL_1DOSE1MAGIC, ItemID.BRUTAL_2DOSE1MAGIC);
		add(new MixedPotion(6, rangingPot), ItemID.BRUTAL_1DOSERANGERSPOTION, ItemID.BRUTAL_2DOSERANGERSPOTION);
		add(new MixedPotion(6, SUPER_ATTACK_POT), ItemID.BRUTAL_1DOSE2ATTACK, ItemID.BRUTAL_2DOSE2ATTACK);
		add(new MixedPotion(6, SUPER_STRENGTH_POT), ItemID.BRUTAL_1DOSE2STRENGTH, ItemID.BRUTAL_2DOSE2STRENGTH);
		add(new MixedPotion(6, SUPER_DEFENCE_POT), ItemID.BRUTAL_1DOSE2DEFENSE, ItemID.BRUTAL_2DOSE2DEFENSE);
		add(new MixedPotion(6, magicEssence), ItemID.BRUTAL_1DOSEMAGICESS, ItemID.BRUTAL_2DOSEMAGICESS);
		add(new MixedPotion(6, zamorakBrew), ItemID.BRUTAL_1DOSEPOTIONOFZAMORAK, ItemID.BRUTAL_2DOSEPOTIONOFZAMORAK);
		add(new MixedPotion(6, ancientBrew), ItemID.BRUTAL_1DOSEANCIENTBREW, ItemID.BRUTAL_2DOSEANCIENTBREW);

		// Regular overload (NMZ)
		add(combo(SUPER_ATTACK_POT, SUPER_STRENGTH_POT, SUPER_DEFENCE_POT, superRangingPot, superMagicPot, heal(HITPOINTS, -50)), ItemID.NZONE1DOSEOVERLOADPOTION, ItemID.NZONE2DOSEOVERLOADPOTION, ItemID.NZONE3DOSEOVERLOADPOTION, ItemID.NZONE4DOSEOVERLOADPOTION);

		// Bandages (Castle Wars)
		add(new CastleWarsBandage(), ItemID.CASTLEWARS_BANDAGES);

		// Bandages (Theatre of Blood entry mode)
		add(combo(food(20), heal(PRAYER, perc(0.25, 5)), heal(RUN_ENERGY, 20), boost(ATTACK, perc(0.15, 4)), boost(STRENGTH, perc(0.15, 4)), boost(DEFENCE, perc(0.15, 4)), rangingPot, magicPot), ItemID.TOB_BANDAGES);

		// Recovery potions
		final Effect restorePot = combo(heal(ATTACK, perc(.30, 10)), heal(STRENGTH, perc(.30, 10)), heal(DEFENCE, perc(.30, 10)), heal(RANGED, perc(.30, 10)), heal(MAGIC, perc(.30, 10)));
		final Effect energyPot = heal(RUN_ENERGY, 10);
		final SingleEffect prayerPot = new PrayerPotion(7);
		final Effect superEnergyPot = heal(RUN_ENERGY, 20);
		final Effect superRestorePot = new SuperRestore(.25, 8);
		final SingleEffect staminaPot = new StaminaPotion();
		final DeltaPercentage remedyHeal = perc(0.16, 6);
		add(restorePot, ItemID._1DOSESTATRESTORE, ItemID._2DOSESTATRESTORE, ItemID._3DOSESTATRESTORE, ItemID._4DOSESTATRESTORE);
		add(energyPot, ItemID._1DOSE1ENERGY, ItemID._2DOSE1ENERGY, ItemID._3DOSE1ENERGY, ItemID._4DOSE1ENERGY);
		add(prayerPot, ItemID._1DOSEPRAYERRESTORE, ItemID._2DOSEPRAYERRESTORE, ItemID._3DOSEPRAYERRESTORE, ItemID._4DOSEPRAYERRESTORE);
		add(superEnergyPot, ItemID._1DOSE2ENERGY, ItemID._2DOSE2ENERGY, ItemID._3DOSE2ENERGY, ItemID._4DOSE2ENERGY);
		add(superRestorePot, ItemID._1DOSE2RESTORE, ItemID._2DOSE2RESTORE, ItemID._3DOSE2RESTORE, ItemID._4DOSE2RESTORE,
			ItemID.BLIGHTED_1DOSE2RESTORE, ItemID.BLIGHTED_2DOSE2RESTORE, ItemID.BLIGHTED_3DOSE2RESTORE, ItemID.BLIGHTED_4DOSE2RESTORE,
			ItemID.BR_4DOSE2RESTORE, ItemID.BR_3DOSE2RESTORE, ItemID.BR_2DOSE2RESTORE, ItemID.BR_1DOSE2RESTORE /* LMS */);
		add(new SuperRestore(.30, 4), ItemID.SANFEW_SALVE_1_DOSE, ItemID.SANFEW_SALVE_2_DOSE, ItemID.SANFEW_SALVE_3_DOSE, ItemID.SANFEW_SALVE_4_DOSE,
			ItemID.BR_SANFEW_SALVE_4_DOSE, ItemID.BR_SANFEW_SALVE_3_DOSE, ItemID.BR_SANFEW_SALVE_2_DOSE, ItemID.BR_SANFEW_SALVE_1_DOSE /* LMS */);
		add(combo(heal(ATTACK, remedyHeal), heal(STRENGTH, remedyHeal), heal(DEFENCE, remedyHeal), heal(RANGED, remedyHeal), heal(MAGIC, remedyHeal)), ItemID._1DOSESTATRENEWAL, ItemID._2DOSESTATRENEWAL, ItemID._3DOSESTATRENEWAL, ItemID._4DOSESTATRENEWAL);
		add(staminaPot, ItemID._1DOSESTAMINA, ItemID._2DOSESTAMINA, ItemID._3DOSESTAMINA, ItemID._4DOSESTAMINA);

		// Mixed recovery potions
		add(new MixedPotion(3, restorePot), ItemID.BRUTAL_1DOSESTATRESTORE, ItemID.BRUTAL_2DOSESTATRESTORE);
		add(new MixedPotion(3, energyPot), ItemID.BRUTAL_1DOSE1ENERGY, ItemID.BRUTAL_2DOSE1ENERGY);
		add(new MixedPotion(6, prayerPot), ItemID.BRUTAL_1DOSEPRAYERRESTORE, ItemID.BRUTAL_2DOSEPRAYERRESTORE);
		add(new MixedPotion(6, superEnergyPot), ItemID.BRUTAL_1DOSE2ENERGY, ItemID.BRUTAL_2DOSE2ENERGY);
		add(new MixedPotion(6, superRestorePot), ItemID.BRUTAL_1DOSE2RESTORE, ItemID.BRUTAL_2DOSE2RESTORE);
		add(new MixedPotion(6, staminaPot), ItemID.BRUTAL_1DOSESTAMINA, ItemID.BRUTAL_2DOSESTAMINA);

		// Chambers of Xeric potions (+)
		final DeltaPercentage coxPlusPotionBoost = perc(.16, 6);
		add(combo(boost(ATTACK, coxPlusPotionBoost), boost(STRENGTH, coxPlusPotionBoost), boost(DEFENCE, coxPlusPotionBoost), boost(RANGED, coxPlusPotionBoost), boost(MAGIC, coxPlusPotionBoost), heal(HITPOINTS, -50)), ItemID.RAIDS_VIAL_OVERLOAD_STRONG_1, ItemID.RAIDS_VIAL_OVERLOAD_STRONG_2, ItemID.RAIDS_VIAL_OVERLOAD_STRONG_3, ItemID.RAIDS_VIAL_OVERLOAD_STRONG_4);
		add(combo(boost(ATTACK, coxPlusPotionBoost), boost(STRENGTH, coxPlusPotionBoost), boost(DEFENCE, coxPlusPotionBoost)), ItemID.RAIDS_VIAL_ELDER_STRONG_1, ItemID.RAIDS_VIAL_ELDER_STRONG_2, ItemID.RAIDS_VIAL_ELDER_STRONG_3, ItemID.RAIDS_VIAL_ELDER_STRONG_4);
		add(combo(boost(RANGED, coxPlusPotionBoost), boost(DEFENCE, coxPlusPotionBoost)), ItemID.RAIDS_VIAL_TWISTED_STRONG_1, ItemID.RAIDS_VIAL_TWISTED_STRONG_2, ItemID.RAIDS_VIAL_TWISTED_STRONG_3, ItemID.RAIDS_VIAL_TWISTED_STRONG_4);
		add(combo(boost(MAGIC, coxPlusPotionBoost), boost(DEFENCE, coxPlusPotionBoost)), ItemID.RAIDS_VIAL_KODAI_STRONG_1, ItemID.RAIDS_VIAL_KODAI_STRONG_2, ItemID.RAIDS_VIAL_KODAI_STRONG_3, ItemID.RAIDS_VIAL_KODAI_STRONG_4);
		add(new SuperRestore(.30, 11), ItemID.RAIDS_VIAL_REVITALISATION_STRONG_1, ItemID.RAIDS_VIAL_REVITALISATION_STRONG_2, ItemID.RAIDS_VIAL_REVITALISATION_STRONG_3, ItemID.RAIDS_VIAL_REVITALISATION_STRONG_4);
		add(new SaradominBrew(0.15, 0.2, 0.1, 5, 4), ItemID.RAIDS_VIAL_XERICAID_STRONG_1, ItemID.RAIDS_VIAL_XERICAID_STRONG_2, ItemID.RAIDS_VIAL_XERICAID_STRONG_3, ItemID.RAIDS_VIAL_XERICAID_STRONG_4);

		// Chambers of Xeric potions
		final DeltaPercentage coxPotionBoost = perc(.13, 5);
		add(combo(boost(ATTACK, coxPotionBoost), boost(STRENGTH, coxPotionBoost), boost(DEFENCE, coxPotionBoost), boost(RANGED, coxPotionBoost), boost(MAGIC, coxPotionBoost), heal(HITPOINTS, -50)), ItemID.RAIDS_VIAL_OVERLOAD_1, ItemID.RAIDS_VIAL_OVERLOAD_2, ItemID.RAIDS_VIAL_OVERLOAD_3, ItemID.RAIDS_VIAL_OVERLOAD_4);
		add(combo(boost(ATTACK, coxPotionBoost), boost(STRENGTH, coxPotionBoost), boost(DEFENCE, coxPotionBoost)), ItemID.RAIDS_VIAL_ELDER_1, ItemID.RAIDS_VIAL_ELDER_2, ItemID.RAIDS_VIAL_ELDER_3, ItemID.RAIDS_VIAL_ELDER_4);
		add(combo(boost(RANGED, coxPotionBoost), boost(DEFENCE, coxPotionBoost)), ItemID.RAIDS_VIAL_TWISTED_1, ItemID.RAIDS_VIAL_TWISTED_2, ItemID.RAIDS_VIAL_TWISTED_3, ItemID.RAIDS_VIAL_TWISTED_4);
		add(combo(boost(MAGIC, coxPotionBoost), boost(DEFENCE, coxPotionBoost)), ItemID.RAIDS_VIAL_KODAI_1, ItemID.RAIDS_VIAL_KODAI_2, ItemID.RAIDS_VIAL_KODAI_3, ItemID.RAIDS_VIAL_KODAI_4);

		// Chambers of Xeric potions (-)
		final DeltaPercentage coxMinusPotionBoost = perc(.10, 4);
		add(combo(boost(ATTACK, coxMinusPotionBoost), boost(STRENGTH, coxMinusPotionBoost), boost(DEFENCE, coxMinusPotionBoost), boost(RANGED, coxMinusPotionBoost), boost(MAGIC, coxMinusPotionBoost), heal(HITPOINTS, -50)), ItemID.RAIDS_VIAL_OVERLOAD_WEAK_1, ItemID.RAIDS_VIAL_OVERLOAD_WEAK_2, ItemID.RAIDS_VIAL_OVERLOAD_WEAK_3, ItemID.RAIDS_VIAL_OVERLOAD_WEAK_4);
		add(combo(boost(ATTACK, coxMinusPotionBoost), boost(STRENGTH, coxMinusPotionBoost), boost(DEFENCE, coxMinusPotionBoost)), ItemID.RAIDS_VIAL_ELDER_WEAK_1, ItemID.RAIDS_VIAL_ELDER_WEAK_2, ItemID.RAIDS_VIAL_ELDER_WEAK_3, ItemID.RAIDS_VIAL_ELDER_WEAK_4);
		add(combo(boost(RANGED, coxMinusPotionBoost), boost(DEFENCE, coxMinusPotionBoost)), ItemID.RAIDS_VIAL_TWISTED_WEAK_1, ItemID.RAIDS_VIAL_TWISTED_WEAK_2, ItemID.RAIDS_VIAL_TWISTED_WEAK_3, ItemID.RAIDS_VIAL_TWISTED_WEAK_4);
		add(combo(boost(MAGIC, coxMinusPotionBoost), boost(DEFENCE, coxMinusPotionBoost)), ItemID.RAIDS_VIAL_KODAI_WEAK_1, ItemID.RAIDS_VIAL_KODAI_WEAK_2, ItemID.RAIDS_VIAL_KODAI_WEAK_3, ItemID.RAIDS_VIAL_KODAI_WEAK_4);

		// Tombs of Amascut consumables
		final DeltaPercentage nectarDrain = perc(0.2, -5);
		final DeltaPercentage saltBoost = perc(.16, 11);
		final DeltaPercentage tearsRestore = perc(.25, 3);
		add(combo(boost(HITPOINTS, 20), prayerPot), ItemID.TOA_HONEY_LOCUST);
		add(new Ambrosia(), ItemID.TOA_SUPPLY_PANICHEAL_1, ItemID.TOA_SUPPLY_PANICHEAL_2);
		add(combo(heal(PRAYER, 8), heal(PRAYER, (8 * 9))), ItemID.TOA_SUPPLY_PRAYER_OVERTIME_1, ItemID.TOA_SUPPLY_PRAYER_OVERTIME_2);
		add(combo(new SimpleStatBoost(HITPOINTS, true, perc(.15, 3)), new BoostedStatBoost(ATTACK, false, nectarDrain), new BoostedStatBoost(STRENGTH, false, nectarDrain), new BoostedStatBoost(DEFENCE, false, nectarDrain), new BoostedStatBoost(RANGED, false, nectarDrain), new BoostedStatBoost(MAGIC, false, nectarDrain)), ItemID.TOA_SUPPLY_HEAL_1, ItemID.TOA_SUPPLY_HEAL_2, ItemID.TOA_SUPPLY_HEAL_3, ItemID.TOA_SUPPLY_HEAL_4);
		add(combo(heal(HITPOINTS, 5), heal(HITPOINTS, 5 * 20)), ItemID.TOA_SUPPLY_HEAL_OVERTIME_1, ItemID.TOA_SUPPLY_HEAL_OVERTIME_2);
		add(combo(new SimpleStatBoost(ATTACK, true, saltBoost), new SimpleStatBoost(STRENGTH, true, saltBoost), new SimpleStatBoost(DEFENCE, true, saltBoost), new SimpleStatBoost(RANGED, true, saltBoost), new SimpleStatBoost(MAGIC, true, saltBoost)), ItemID.TOA_SUPPLY_STATS_1, ItemID.TOA_SUPPLY_STATS_2);
		add(combo(heal(PRAYER, perc(.25, 10)), heal(ATTACK, tearsRestore), heal(STRENGTH, tearsRestore), heal(DEFENCE, tearsRestore), heal(RANGED, tearsRestore), heal(MAGIC, tearsRestore)), ItemID.TOA_SUPPLY_PRAYER_1, ItemID.TOA_SUPPLY_PRAYER_2, ItemID.TOA_SUPPLY_PRAYER_3, ItemID.TOA_SUPPLY_PRAYER_4);

		// Skill potions
		final Effect agilityPot = boost(AGILITY, 3);
		final Effect fishingPot = boost(FISHING, 3);
		final Effect hunterPot = boost(HUNTER, 3);
		add(agilityPot, ItemID._1DOSE1AGILITY, ItemID._2DOSE1AGILITY, ItemID._3DOSE1AGILITY, ItemID._4DOSE1AGILITY);
		add(fishingPot, ItemID._1DOSEFISHERSPOTION, ItemID._2DOSEFISHERSPOTION, ItemID._3DOSEFISHERSPOTION, ItemID._4DOSEFISHERSPOTION);
		add(hunterPot, ItemID._1DOSEHUNTING, ItemID._2DOSEHUNTING, ItemID._3DOSEHUNTING, ItemID._4DOSEHUNTING);
		add(combo(boost(HITPOINTS, 5), heal(RUN_ENERGY, 5)), ItemID.CUP_GUTHIX_REST_1, ItemID.CUP_GUTHIX_REST_2, ItemID.CUP_GUTHIX_REST_3, ItemID.CUP_GUTHIX_REST_4);

		// Mixed skill potions
		add(new MixedPotion(6, agilityPot), ItemID.BRUTAL_1DOSE1AGILITY, ItemID.BRUTAL_2DOSE1AGILITY);
		add(new MixedPotion(6, fishingPot), ItemID.BRUTAL_1DOSEFISHERSPOTION, ItemID.BRUTAL_2DOSEFISHERSPOTION);
		add(new MixedPotion(6, hunterPot), ItemID.BRUTAL_1DOSE1HUNTING, ItemID.BRUTAL_2DOSE1HUNTING);

		// Misc/run energy
		add(combo(food(3), range(heal(RUN_ENERGY, 5), heal(RUN_ENERGY, 10))), ItemID.GARDEN_WHITE_TREE_FRUIT);
		add(heal(RUN_ENERGY, 30), ItemID.MACRO_TRIFFIDFRUIT);
		add(heal(RUN_ENERGY, 50), ItemID.ALUFT_GNOME_MINT_CAKE);
		add(combo(food(12), heal(RUN_ENERGY, 50)), ItemID.VILLAGE_RARE_TUBER);

		// Pies
		add(combo(heal(HITPOINTS, 6), boost(FARMING, 3)), ItemID.GARDEN_PIE, ItemID.HALF_GARDEN_PIE);
		add(combo(heal(HITPOINTS, 6), boost(FISHING, 3)), ItemID.FISH_PIE, ItemID.HALF_FISH_PIE);
		add(combo(heal(HITPOINTS, 7), boost(HERBLORE, 4)), ItemID.BOTANICAL_PIE, ItemID.HALF_BOTANICAL_PIE);
		add(combo(heal(HITPOINTS, 8), boost(CRAFTING, 4)), ItemID.MUSHROOM_PIE, ItemID.HALF_MUSHROOM_PIE);
		add(combo(heal(HITPOINTS, 8), boost(FISHING, 5)), ItemID.ADMIRAL_PIE, ItemID.HALF_ADMIRAL_PIE);
		add(combo(heal(HITPOINTS, 11), boost(SLAYER, 5), boost(RANGED, 4)), ItemID.WILD_PIE, ItemID.HALF_WILD_PIE);
		add(combo(heal(HITPOINTS, 11), boost(AGILITY, 5), heal(RUN_ENERGY, 10)), ItemID.SUMMER_PIE, ItemID.HALF_SUMMER_PIE);
		add(combo(heal(HITPOINTS, 10), boost(FLETCHING, 4)), ItemID.DRAGONFRUIT_PIE, ItemID.HALF_DRAGONFRUIT_PIE);

		// Other
		add(combo(range(food(1), food(3)), heal(RUN_ENERGY, 10)), ItemID.TRAIL_SWEETS);
		add(new SpicyStew(), ItemID.HUNDRED_DAVE_STEW);
		add(imbuedHeart, ItemID.IMBUED_HEART);
		add(boost(MAGIC, perc(.10, 4)), ItemID.SATURATED_HEART);
		add(combo(boost(ATTACK, 2), boost(STRENGTH, 1), heal(PRAYER, 1), heal(DEFENCE, -1)), ItemID.JANGERBERRIES);
		add(new CaveNightshade(), ItemID.NIGHTSHADE);
		add(combo(food(15), heal(PRAYER, perc(.25, 0)), staminaPot), ItemID.DT2_SCAR_MAZE_STAMINA);

		// Gauntlet
		add(combo(heal(PRAYER, perc(.25, 7)), heal(RUN_ENERGY, 40)), ItemID.GAUNTLET_POTION_1, ItemID.GAUNTLET_POTION_2, ItemID.GAUNTLET_POTION_3, ItemID.GAUNTLET_POTION_4);

		// Soul Wars
		add(combo(heal(HITPOINTS, perc(.15, 1)), heal(RUN_ENERGY, 100)), ItemID.SOUL_WARS_BANDAGES);
		add(combo(boost(ATTACK, perc(.15, 5)), boost(STRENGTH, perc(.15, 5)), boost(DEFENCE, perc(.15, 5)), boost(RANGED, perc(.15, 5)), boost(MAGIC, perc(.15, 5)), heal(PRAYER, perc(.25, 8))), ItemID.SOUL_WARS_BUFF_POTION_1, ItemID.SOUL_WARS_BUFF_POTION_2, ItemID.SOUL_WARS_BUFF_POTION_3, ItemID.SOUL_WARS_BUFF_POTION_4);

		// Moths & Butterflies
		add(new SunlightMoth(.2, 6), ItemID.BUTTERFLY_JAR_SUNMOTH, ItemID.HUNTER_MIX_SUNMOTH_1DOSE, ItemID.HUNTER_MIX_SUNMOTH_2DOSE);
		add(heal(PRAYER, 22), ItemID.BUTTERFLY_JAR_MOONMOTH, ItemID.HUNTER_MIX_MOONMOTH_1DOSE, ItemID.HUNTER_MIX_MOONMOTH_2DOSE);
		add(heal(HITPOINTS, 15), ItemID.BUTTERFLY_JAR_SNOWY);
		add(heal(HITPOINTS, 8), ItemID.HUNTER_MIX_SNOWY_1DOSE, ItemID.HUNTER_MIX_SNOWY_2DOSE);
		add(boost(ATTACK, perc(.15, 4)), ItemID.BUTTERFLY_JAR_RUBY, ItemID.HUNTER_MIX_RUBY_1DOSE, ItemID.HUNTER_MIX_RUBY_2DOSE);
		add(boost(STRENGTH, perc(.15, 4)), ItemID.BUTTERFLY_JAR_WARLOCK, ItemID.HUNTER_MIX_WARLOCK_1DOSE, ItemID.HUNTER_MIX_WARLOCK_2DOSE);
		add(boost(DEFENCE, perc(.15, 4)), ItemID.BUTTERFLY_JAR_GLACIALIS, ItemID.HUNTER_MIX_GLACIALIS_1DOSE, ItemID.HUNTER_MIX_GLACIALIS_2DOSE);

		log.debug("{} items; {} behaviours loaded", effects.size(), new HashSet<>(effects.values()).size());
	}

	private final Map<Integer, Effect> effects = new HashMap<>();

	private void add(Effect effect, int... items)
	{
		assert items.length > 0;
		for (int item : items)
		{
			Effect prev = effects.put(item, effect);
			assert prev == null : "Item already added: " + item;
		}
	}

	public Effect get(int id)
	{
		return effects.get(id);
	}
}
