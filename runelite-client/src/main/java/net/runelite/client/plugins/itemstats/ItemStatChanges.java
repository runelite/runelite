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
import static net.runelite.api.ItemID.*;
import static net.runelite.client.plugins.itemstats.Builders.*;
import net.runelite.client.plugins.itemstats.food.Anglerfish;
import net.runelite.client.plugins.itemstats.potions.GauntletPotion;
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

	private void init()
	{
		add(food(-5), POISON_KARAMBWAN);
		add(food(1), POTATO, ONION, CABBAGE, POT_OF_CREAM, CHOPPED_ONION, ANCHOVIES, NETTLEWATER, EQUA_LEAVES,
			FRESH_MONKFISH_7943 /* Cooked */, COOKED_CHICKEN_4291 /* Undead */, COOKED_MEAT_4293 /* Undead */);
		add(food(2), TOMATO, CHOPPED_TOMATO, BANANA, SLICED_BANANA, ORANGE, ORANGE_SLICES, ORANGE_CHUNKS,
			PINEAPPLE_RING, PINEAPPLE_CHUNKS, SPICY_SAUCE, CHEESE, SPINACH_ROLL, LEMON, LEMON_CHUNKS, LEMON_SLICES,
			LIME, LIME_CHUNKS, LIME_SLICES, DWELLBERRIES, KING_WORM, MINCED_MEAT, SPICY_TOMATO, WHITE_PEARL);
		add(food(3), SHRIMPS, COOKED_MEAT, COOKED_CHICKEN, ROE, CHOCOLATE_BAR, UGTHANKI_MEAT, TOADS_LEGS, ONION__TOMATO,
			SPICY_MINCED_MEAT, SLICE_OF_BIRTHDAY_CAKE, LOCUST_MEAT);
		add(food(4), SARDINE, CAKE, _23_CAKE, SLICE_OF_CAKE, CHOCOLATEY_MILK, BAKED_POTATO, EDIBLE_SEAWEED, MOONLIGHT_MEAD,
			MOONLIGHT_MEAD4, MOONLIGHT_MEAD3, MOONLIGHT_MEAD2, MOONLIGHT_MEAD1, MONKEY_NUTS);
		add(food(5), BREAD, HERRING, CHOCOLATE_CAKE, _23_CHOCOLATE_CAKE, CHOCOLATE_SLICE, COOKED_RABBIT, CHILLI_CON_CARNE,
			FRIED_MUSHROOMS, FRIED_ONIONS, REDBERRY_PIE, HALF_A_REDBERRY_PIE, CAVIAR, PYSK_FISH_0, COOKED_MYSTERY_MEAT,
			SCRAMBLED_EGG, MONKEY_BAR, TCHIKI_MONKEY_NUTS, TCHIKI_NUT_PASTE, RED_BANANA, SLICED_RED_BANANA);
		add(food(6), CHOCICE, MACKEREL, MEAT_PIE, HALF_A_MEAT_PIE, GUANIC_BAT_0, ROAST_BIRD_MEAT, SQUARE_SANDWICH,
			ROLL, BAGUETTE, TRIANGLE_SANDWICH, GIANT_CARP, MOONLIGHT_MEADM, MOONLIGHT_MEADM4, MOONLIGHT_MEADM3, MOONLIGHT_MEADM2,
			MOONLIGHT_MEADM1, STEAK_SANDWICH, GIANT_FROG_LEGS);
		add(food(7), TROUT, COD, PLAIN_PIZZA, _12_PLAIN_PIZZA, APPLE_PIE, HALF_AN_APPLE_PIE, ROAST_RABBIT,
			PREMADE_CH_CRUNCH, CHOCCHIP_CRUNCHIES, PREMADE_SY_CRUNCH, SPICY_CRUNCHIES);
		add(food(8), PIKE, ROAST_BEAST_MEAT, MEAT_PIZZA, _12_MEAT_PIZZA, PREMADE_WM_CRUN, WORM_CRUNCHIES, PREMADE_TD_CRUNCH,
			TOAD_CRUNCHIES, EGG_AND_TOMATO, PRAEL_BAT_1, PEACH, SUPHI_FISH_1);
		add(food(9), PREMADE_P_PUNCH, PINEAPPLE_PUNCH, PREMADE_FR_BLAST, FRUIT_BLAST, SALMON, ANCHOVY_PIZZA,
			_12_ANCHOVY_PIZZA);
		add(food(10), TUNA, COOKED_CRAB_MEAT, CHOPPED_TUNA, COOKED_CHOMPY, FIELD_RATION, DRAGONFRUIT,
			TUNA_26149 /* Deadman Starter Pack */);
		add(food(11), RAINBOW_FISH, STEW, PINEAPPLE_PIZZA, _12_PINEAPPLE_PIZZA, COOKED_FISHCAKE,
			PREMADE_VEG_BATTA, VEGETABLE_BATTA, PREMADE_WM_BATTA, WORM_BATTA, PREMADE_TD_BATTA, TOAD_BATTA, PREMADE_CT_BATTA,
			CHEESETOM_BATTA, PREMADE_FRT_BATTA, FRUIT_BATTA, MUSHROOM__ONION, GIRAL_BAT_2, LAVA_EEL, LECKISH_FISH_2, BANANA_STEW);
		add(food(12), LOBSTER, PREMADE_WORM_HOLE, WORM_HOLE, PREMADE_VEG_BALL, VEG_BALL);
		add(food(13), BASS, TUNA_AND_CORN);
		add(food(14), POTATO_WITH_BUTTER, CHILLI_POTATO, SWORDFISH, PHLUXIA_BAT_3, PUMPKIN, EASTER_EGG, BRAWK_FISH_3,
			COOKED_OOMLIE_WRAP);
		add(food(15), PREMADE_TTL, TANGLED_TOADS_LEGS, PREMADE_CHOC_BOMB, CHOCOLATE_BOMB, COOKED_JUBBLY);
		add(food(16), MONKFISH, POTATO_WITH_CHEESE, EGG_POTATO);
		add(food(17), MYCIL_FISH_4, KRYKET_BAT_4);
		add(food(18), COOKED_KARAMBWAN, BLIGHTED_KARAMBWAN, COOKED_KARAMBWAN_23533 /* LMS */);
		add(food(19), CURRY, UGTHANKI_KEBAB, UGTHANKI_KEBAB_1885);
		add(food(20), MUSHROOM_POTATO, SHARK, ROQED_FISH_5, MURNG_BAT_5, STUFFED_SNAKE, SHARK_20390 /* LMS */);
		add(food(21), SEA_TURTLE);
		add(food(22), MANTA_RAY, BLIGHTED_MANTA_RAY, DARK_CRAB, TUNA_POTATO);
		add(food(23), KYREN_FISH_6, PSYKK_BAT_6);
		add(new Anglerfish(), ANGLERFISH, BLIGHTED_ANGLERFISH);
		add(food(maxHP -> (int) Math.ceil(maxHP * .06)), STRAWBERRY);
		add(food(maxHP -> (int) Math.ceil(maxHP * .05)), WATERMELON_SLICE);
		add(food(perc(.1, 1)), COOKED_SWEETCORN, SWEETCORN_7088 /* Bowl of cooked sweetcorn */);
		add(combo(food(1), boost(DEFENCE, perc(.02, 1))), CABBAGE_1967 /* Draynor Manor */);
		add(combo(2, food(8), heal(RUN_ENERGY, 5)), PAPAYA_FRUIT);
		add(combo(2, food(3), boost(ATTACK, perc(.02, 2))), CUP_OF_TEA_1978 /* Standard tea */);
		add(combo(2, food(3), new NettleTeaRunEnergy()), NETTLE_TEA, NETTLE_TEA_4240 /* Milky */, CUP_OF_TEA_4242 /* Nettle */, CUP_OF_TEA_4243 /* Milky nettle */);
		add(range(food(5), food(7)), THIN_SNAIL_MEAT);
		add(range(food(5), food(8)), LEAN_SNAIL_MEAT);
		add(range(food(7), food(9)), FAT_SNAIL_MEAT);
		add(range(food(7), food(10)), SPIDER_ON_STICK_6297, SPIDER_ON_SHAFT_6299);

		// Dorgeshuun Cuisine
		add(food(2), BAT_SHISH, COATED_FROGS_LEGS, FILLETS, FINGERS, FROGBURGER, FROGSPAWN_GUMBO, GREEN_GLOOP_SOUP,
			GRUBS__LA_MODE, MUSHROOMS, ROAST_FROG);
		add(food(3), LOACH);
		add(range(food(3), food(6)), FROG_SPAWN);
		add(range(food(6), food(10)), COOKED_SLIMY_EEL);
		add(range(food(8), food(12)), CAVE_EEL);
		add(food(10), EEL_SUSHI);

		// Alcoholic Beverages
		// Many of these retrieved from https://oldschool.runescape.wiki/w/Temporary_skill_drain
		add(combo(food(11), dec(ATTACK, 2)), JUG_OF_WINE);
		add(combo(food(14), dec(ATTACK, 3)), BOTTLE_OF_WINE);
		add(combo(food(7), dec(ATTACK, 2)), HALF_FULL_WINE_JUG);
		add(combo(dec(ATTACK, 3)), JUG_OF_BAD_WINE);
		add(combo(3, food(5), new SimpleStatBoost(STRENGTH, true, perc(.05, 1)), new BoostedStatBoost(ATTACK, false, perc(.02, -3))), PREMADE_SGG, SHORT_GREEN_GUY, BRANDY, GIN, VODKA, WHISKY);
		add(combo(3, food(7), new SimpleStatBoost(STRENGTH, true, perc(.05, 2)), new BoostedStatBoost(ATTACK, false, perc(.02, -3))), PREMADE_BLURB_SP, BLURBERRY_SPECIAL);
		add(combo(3, food(5), new SimpleStatBoost(STRENGTH, true, perc(.05, 2)), new BoostedStatBoost(ATTACK, false, perc(.02, -3))), PREMADE_DR_DRAGON, DRUNK_DRAGON, PREMADE_CHOC_SDY, CHOC_SATURDAY);
		add(combo(3, food(5), new SimpleStatBoost(STRENGTH, true, perc(.06, 1)), new BoostedStatBoost(ATTACK, false, perc(.02, -3))), PREMADE_WIZ_BLZD, WIZARD_BLIZZARD);
		add(combo(3, food(3), new SimpleStatBoost(STRENGTH, true, perc(.04, 1)), new BoostedStatBoost(ATTACK, false, perc(.05, -3))), GROG);
		add(combo(3, food(1), boost(STRENGTH, perc(.02, 1)), new BoostedStatBoost(ATTACK, false, perc(.06, -1))), BEER, BEER_7740);
		add(combo(3, food(4), boost(STRENGTH, perc(.04, 2)), new BoostedStatBoost(ATTACK, false, perc(.1, -2))), BEER_TANKARD);
		add(combo(3, food(15), boost(STRENGTH, perc(.1, 2)), new BoostedStatBoost(ATTACK, false, perc(.5, -4))), KEG_OF_BEER_3801 /* Non-quest version */);
		add(combo(4, boost(ATTACK, 5), boost(STRENGTH, 5), heal(MAGIC, -5), heal(PRAYER, -5)), BLOOD_PINT);
		add(combo(3, food(1), boost(STRENGTH, 2), new BoostedStatBoost(ATTACK, false, perc(.05, -2))), ASGARNIAN_ALE, ASGARNIAN_ALE1, ASGARNIAN_ALE2, ASGARNIAN_ALE3, ASGARNIAN_ALE4, ASGARNIAN_ALE_7744);
		add(combo(3, food(1), boost(STRENGTH, 3), new BoostedStatBoost(ATTACK, false, perc(.05, -3))), ASGARNIAN_ALEM, ASGARNIAN_ALEM1, ASGARNIAN_ALEM2, ASGARNIAN_ALEM3, ASGARNIAN_ALEM4);
		add(combo(4, food(1), boost(WOODCUTTING, 1), new BoostedStatBoost(ATTACK, false, perc(.02, -2)), new BoostedStatBoost(STRENGTH, false, perc(.02, -2))), AXEMANS_FOLLY, AXEMANS_FOLLY1, AXEMANS_FOLLY2, AXEMANS_FOLLY3, AXEMANS_FOLLY4);
		add(combo(4, food(2), boost(WOODCUTTING, 2), new BoostedStatBoost(ATTACK, false, perc(.02, -3)), new BoostedStatBoost(STRENGTH, false, perc(.02, -3))), AXEMANS_FOLLYM, AXEMANS_FOLLYM1, AXEMANS_FOLLYM2, AXEMANS_FOLLYM3, AXEMANS_FOLLYM4);
		add(combo(5, food(1), boost(THIEVING, 1), boost(ATTACK, 1),  new BoostedStatBoost(DEFENCE, false, perc(.06, -3)), new BoostedStatBoost(STRENGTH, false, perc(.06, -3))), BANDITS_BREW);
		add(combo(4, food(1), new SimpleStatBoost(COOKING, true, perc(.05, 1)), new BoostedStatBoost(ATTACK, false, perc(.05, -2)), new BoostedStatBoost(STRENGTH, false, perc(.05, -2))), CHEFS_DELIGHT, CHEFS_DELIGHT1, CHEFS_DELIGHT2, CHEFS_DELIGHT3, CHEFS_DELIGHT4, CHEFS_DELIGHT_7754);
		add(combo(4, food(2), new SimpleStatBoost(COOKING, true, perc(.05, 2)), new BoostedStatBoost(ATTACK, false, perc(.05, -3)), new BoostedStatBoost(STRENGTH, false, perc(.05, -3))), CHEFS_DELIGHTM, CHEFS_DELIGHTM1, CHEFS_DELIGHTM2, CHEFS_DELIGHTM3, CHEFS_DELIGHTM4);
		add(combo(4, food(1), boost(FARMING, 1), new BoostedStatBoost(ATTACK, false, perc(.02, -2)), new BoostedStatBoost(STRENGTH, false, perc(.02, -2))), CIDER, CIDER1, CIDER2, CIDER3, CIDER4, CIDER_7752);
		add(combo(4, food(2), boost(FARMING, 2), new BoostedStatBoost(ATTACK, false, perc(.02, -3)), new BoostedStatBoost(STRENGTH, false, perc(.02, -3))), MATURE_CIDER, CIDERM1, CIDERM2, CIDERM3, CIDERM4);
		add(combo(3, food(1), boost(STRENGTH, 2), new BoostedStatBoost(ATTACK, false, perc(.05, -2))), DRAGON_BITTER, DRAGON_BITTER1, DRAGON_BITTER2, DRAGON_BITTER3, DRAGON_BITTER4, DRAGON_BITTER_7748);
		add(combo(3, food(2), boost(STRENGTH, 3), new BoostedStatBoost(ATTACK, false, perc(.05, -2))), DRAGON_BITTERM, DRAGON_BITTERM1, DRAGON_BITTERM2, DRAGON_BITTERM3, DRAGON_BITTERM4);
		add(combo(6, food(1), boost(MINING, 1), boost(SMITHING, 1), new BoostedStatBoost(ATTACK, false, perc(.04, -2)), new BoostedStatBoost(DEFENCE, false, perc(.04, -2)), new BoostedStatBoost(STRENGTH, false, perc(.04, -2))), DWARVEN_STOUT, DWARVEN_STOUT1, DWARVEN_STOUT2, DWARVEN_STOUT3, DWARVEN_STOUT4);
		add(combo(6, food(2), boost(MINING, 2), boost(SMITHING, 2), new BoostedStatBoost(ATTACK, false, perc(.04, -3)), new BoostedStatBoost(DEFENCE, false, perc(.04, -3)), new BoostedStatBoost(STRENGTH, false, perc(.04, -3))), DWARVEN_STOUTM, DWARVEN_STOUTM1, DWARVEN_STOUTM2, DWARVEN_STOUTM3, DWARVEN_STOUTM4);
		add(combo(5, food(1), boost(HERBLORE, 1), new BoostedStatBoost(ATTACK, false, perc(.04, -2)), new BoostedStatBoost(DEFENCE, false, perc(.04, -2)), new BoostedStatBoost(STRENGTH, false, perc(.04, -2))), GREENMANS_ALE, GREENMANS_ALE1, GREENMANS_ALE2, GREENMANS_ALE3, GREENMANS_ALE4, GREENMANS_ALE_7746);
		add(combo(5, food(2), boost(HERBLORE, 2), new BoostedStatBoost(ATTACK, false, perc(.04, -3)), new BoostedStatBoost(DEFENCE, false, perc(.04, -3)), new BoostedStatBoost(STRENGTH, false, perc(.04, -3))), GREENMANS_ALEM, GREENMANS_ALEM1, GREENMANS_ALEM2, GREENMANS_ALEM3, GREENMANS_ALEM4);
		add(combo(5, food(1), boost(SLAYER, 2), new BoostedStatBoost(ATTACK, false, perc(.02, -2)), new BoostedStatBoost(DEFENCE, false, perc(.02, -2)), new BoostedStatBoost(STRENGTH, false, perc(.02, -2))), SLAYERS_RESPITE, SLAYERS_RESPITE1, SLAYERS_RESPITE2, SLAYERS_RESPITE3, SLAYERS_RESPITE4);
		add(combo(5, food(2), boost(SLAYER, 4), new BoostedStatBoost(ATTACK, false, perc(.02, -3)), new BoostedStatBoost(DEFENCE, false, perc(.02, -3)), new BoostedStatBoost(STRENGTH, false, perc(.02, -3))), SLAYERS_RESPITEM, SLAYERS_RESPITEM1, SLAYERS_RESPITEM2, SLAYERS_RESPITEM3, SLAYERS_RESPITEM4);
		add(combo(5, food(1), new SimpleStatBoost(MAGIC, true, perc(.02, 2)), new BoostedStatBoost(ATTACK, false, perc(.05, -1)), new BoostedStatBoost(DEFENCE, false, perc(.05, -1)), new BoostedStatBoost(STRENGTH, false, perc(.05, -1))), WIZARDS_MIND_BOMB, MIND_BOMB1, MIND_BOMB2, MIND_BOMB3, MIND_BOMB4);
		add(combo(5, food(2), new SimpleStatBoost(MAGIC, true, perc(.02, 3)), new BoostedStatBoost(ATTACK, false, perc(.05, -2)), new BoostedStatBoost(DEFENCE, false, perc(.05, -2)), new BoostedStatBoost(STRENGTH, false, perc(.05, -2))), MATURE_WMB, MIND_BOMBM1, MIND_BOMBM2, MIND_BOMBM3, MIND_BOMBM4);
		add(combo(10, food(14), boost(STRENGTH, 3), boost(MINING, 1), heal(PRAYER, perc(.06, -1)), new BoostedStatBoost(AGILITY, false, perc(.09, -3)), new BoostedStatBoost(ATTACK, false, perc(.06, -1)), new BoostedStatBoost(DEFENCE, false, perc(.08, -2)), new BoostedStatBoost(HERBLORE, false, perc(.06, -1)), new BoostedStatBoost(MAGIC, false, perc(.05, -1)), new BoostedStatBoost(RANGED, false, perc(.06, -1))), BRAINDEATH_RUM);
		add(combo(2, food(2), heal(PRAYER, perc(.04, -2))), BLOODY_BRACER);
		add(combo(3, food(1), boost(AGILITY, 1), heal(STRENGTH, -1)), ELVEN_DAWN);
		add(combo(3, boost(RANGED, 4), new BoostedStatBoost(STRENGTH, false, perc(.04, -2)), new BoostedStatBoost(MAGIC, false, perc(.04, -2))), LIZARDKICKER);

		// Sq'irk Juice
		add(heal(RUN_ENERGY, 5), WINTER_SQIRKJUICE);
		add(combo(heal(RUN_ENERGY, 10), boost(THIEVING, 1)), SPRING_SQIRKJUICE);
		add(combo(heal(RUN_ENERGY, 15), boost(THIEVING, 2)), AUTUMN_SQIRKJUICE);
		add(combo(heal(RUN_ENERGY, 20), boost(THIEVING, 3)), SUMMER_SQIRKJUICE);

		// Combat potions
		add(boost(ATTACK, perc(.10, 3)), ATTACK_POTION1, ATTACK_POTION2, ATTACK_POTION3, ATTACK_POTION4);
		add(boost(STRENGTH, perc(.10, 3)), STRENGTH_POTION1, STRENGTH_POTION2, STRENGTH_POTION3, STRENGTH_POTION4);
		add(boost(DEFENCE, perc(.10, 3)), DEFENCE_POTION1, DEFENCE_POTION2, DEFENCE_POTION3, DEFENCE_POTION4);
		add(boost(MAGIC, 4), MAGIC_POTION1, MAGIC_POTION2, MAGIC_POTION3, MAGIC_POTION4);
		add(boost(RANGED, perc(.10, 4)), RANGING_POTION1, RANGING_POTION2, RANGING_POTION3, RANGING_POTION4,
			RANGING_POTION4_23551, RANGING_POTION3_23553, RANGING_POTION2_23555, RANGING_POTION1_23557 /* LMS */);
		add(combo(2, boost(ATTACK, perc(.10, 3)), boost(STRENGTH, perc(.10, 3))),
			COMBAT_POTION1, COMBAT_POTION2, COMBAT_POTION3, COMBAT_POTION4,
			COMBAT_POTION4_26150, COMBAT_POTION3_26151, COMBAT_POTION2_26152, COMBAT_POTION1_26153 /* Deadman starter pack */);
		add(boost(ATTACK, perc(.15, 5)), SUPER_ATTACK1, SUPER_ATTACK2, SUPER_ATTACK3, SUPER_ATTACK4);
		add(boost(STRENGTH, perc(.15, 5)), SUPER_STRENGTH1, SUPER_STRENGTH2, SUPER_STRENGTH3, SUPER_STRENGTH4);
		add(boost(DEFENCE, perc(.15, 5)), SUPER_DEFENCE1, SUPER_DEFENCE2, SUPER_DEFENCE3, SUPER_DEFENCE4);
		add(boost(MAGIC, 3), MAGIC_ESSENCE1, MAGIC_ESSENCE2, MAGIC_ESSENCE3, MAGIC_ESSENCE4);
		add(combo(3, boost(ATTACK, perc(.15, 5)), boost(STRENGTH, perc(.15, 5)), boost(DEFENCE, perc(.15, 5))), SUPER_COMBAT_POTION1, SUPER_COMBAT_POTION2, SUPER_COMBAT_POTION3, SUPER_COMBAT_POTION4);
		add(combo(3, boost(ATTACK, perc(.20, 2)), boost(STRENGTH, perc(.12, 2)), heal(PRAYER, perc(.10, 0)), new BoostedStatBoost(DEFENCE, false, perc(.10, -2)), new BoostedStatBoost(HITPOINTS, false, perc(-.12, 0))), ZAMORAK_BREW1, ZAMORAK_BREW2, ZAMORAK_BREW3, ZAMORAK_BREW4);
		add(new SaradominBrew(0.15, 0.2, 0.1, 2, 2), SARADOMIN_BREW1, SARADOMIN_BREW2, SARADOMIN_BREW3,
			SARADOMIN_BREW4, SARADOMIN_BREW4_23575, SARADOMIN_BREW3_23577, SARADOMIN_BREW2_23579, SARADOMIN_BREW1_23581 /* LMS */);
		add(boost(RANGED, perc(.15, 5)), SUPER_RANGING_1, SUPER_RANGING_2, SUPER_RANGING_3, SUPER_RANGING_4);
		add(boost(MAGIC, perc(.15, 5)), SUPER_MAGIC_POTION_1, SUPER_MAGIC_POTION_2, SUPER_MAGIC_POTION_3, SUPER_MAGIC_POTION_4);
		add(combo(2, boost(RANGED, perc(0.1, 4)), boost(DEFENCE, perc(0.15, 5))), BASTION_POTION1, BASTION_POTION2, BASTION_POTION3, BASTION_POTION4);
		add(combo(2, boost(MAGIC, 4), boost(DEFENCE, perc(0.15, 5))), BATTLEMAGE_POTION1, BATTLEMAGE_POTION2, BATTLEMAGE_POTION3, BATTLEMAGE_POTION4);
		add(combo(boost(MAGIC, 4), heal(HITPOINTS, -10)), DIVINE_MAGIC_POTION1, DIVINE_MAGIC_POTION2, DIVINE_MAGIC_POTION3, DIVINE_MAGIC_POTION4);
		add(combo(boost(RANGED, perc(.10, 4)), heal(HITPOINTS, -10)), DIVINE_RANGING_POTION1, DIVINE_RANGING_POTION2, DIVINE_RANGING_POTION3, DIVINE_RANGING_POTION4);
		add(combo(boost(ATTACK, perc(.15, 5)), heal(HITPOINTS, -10)), DIVINE_SUPER_ATTACK_POTION1, DIVINE_SUPER_ATTACK_POTION2, DIVINE_SUPER_ATTACK_POTION3, DIVINE_SUPER_ATTACK_POTION4);
		add(combo(boost(STRENGTH, perc(.15, 5)), heal(HITPOINTS, -10)), DIVINE_SUPER_STRENGTH_POTION1, DIVINE_SUPER_STRENGTH_POTION2, DIVINE_SUPER_STRENGTH_POTION3, DIVINE_SUPER_STRENGTH_POTION4);
		add(combo(boost(DEFENCE, perc(.15, 5)), heal(HITPOINTS, -10)), DIVINE_SUPER_DEFENCE_POTION1, DIVINE_SUPER_DEFENCE_POTION2, DIVINE_SUPER_DEFENCE_POTION3, DIVINE_SUPER_DEFENCE_POTION4);
		add(combo(3, boost(ATTACK, perc(.15, 5)), boost(STRENGTH, perc(.15, 5)), boost(DEFENCE, perc(.15, 5)), heal(HITPOINTS, -10)), DIVINE_SUPER_COMBAT_POTION1, DIVINE_SUPER_COMBAT_POTION2, DIVINE_SUPER_COMBAT_POTION3, DIVINE_SUPER_COMBAT_POTION4);
		add(combo(2, boost(RANGED, perc(0.1, 4)), boost(DEFENCE, perc(0.15, 5)), heal(HITPOINTS, -10)), DIVINE_BASTION_POTION1, DIVINE_BASTION_POTION2, DIVINE_BASTION_POTION3, DIVINE_BASTION_POTION4);
		add(combo(2, boost(MAGIC, 4), boost(DEFENCE, perc(0.15, 5)), heal(HITPOINTS, -10)), DIVINE_BATTLEMAGE_POTION1, DIVINE_BATTLEMAGE_POTION2, DIVINE_BATTLEMAGE_POTION3, DIVINE_BATTLEMAGE_POTION4);
		add(combo(5, boost(ATTACK, perc(0.15, 5)), boost(STRENGTH, perc(0.15, 5)), boost(DEFENCE, perc(0.15, 5)), boost(RANGED, perc(0.1, 4)), boost(MAGIC, perc(0.1, 1))),
			CASTLEWARS_BREW4, CASTLEWARS_BREW3, CASTLEWARS_BREW2, CASTLEWARS_BREW1);
		add(combo(2, boost(ATTACK, perc(0.15, 5)), boost(STRENGTH, perc(0.15, 5))),
			SUPER_COMBAT_POTION4_23543, SUPER_COMBAT_POTION3_23545, SUPER_COMBAT_POTION2_23547, SUPER_COMBAT_POTION1_23549 /* LMS */);

		// Regular overload (NMZ)
		add(combo(5, boost(ATTACK, perc(.15, 5)), boost(STRENGTH, perc(.15, 5)), boost(DEFENCE, perc(.15, 5)), boost(RANGED, perc(.15, 5)), boost(MAGIC, perc(.15, 5)), heal(HITPOINTS, -50)), OVERLOAD_1, OVERLOAD_2, OVERLOAD_3, OVERLOAD_4);

		// Bandages (Castle Wars)
		add(new CastleWarsBandage(), BANDAGES);

		// Bandages (Theatre of Blood entry mode)
		add(combo(8, food(20), heal(PRAYER, perc(0.25, 5)), heal(RUN_ENERGY, 20), boost(ATTACK, perc(0.15, 4)), boost(STRENGTH, perc(0.15, 4)), boost(DEFENCE, perc(0.15, 4)), boost(RANGED, perc(0.1, 4)), boost(MAGIC, 4)), BANDAGES_25730);

		// Recovery potions
		add(combo(5, heal(ATTACK, perc(.30, 10)), heal(STRENGTH, perc(.30, 10)), heal(DEFENCE, perc(.30, 10)), heal(RANGED, perc(.30, 10)), heal(MAGIC, perc(.30, 10))), RESTORE_POTION1, RESTORE_POTION2, RESTORE_POTION3, RESTORE_POTION4);
		add(heal(RUN_ENERGY, 10), ENERGY_POTION1, ENERGY_POTION2, ENERGY_POTION3, ENERGY_POTION4);
		add(new PrayerPotion(7), PRAYER_POTION1, PRAYER_POTION2, PRAYER_POTION3, PRAYER_POTION4);
		add(heal(RUN_ENERGY, 20), SUPER_ENERGY1, SUPER_ENERGY2, SUPER_ENERGY3, SUPER_ENERGY4);
		add(new SuperRestore(.25, 8), SUPER_RESTORE1, SUPER_RESTORE2, SUPER_RESTORE3, SUPER_RESTORE4,
			BLIGHTED_SUPER_RESTORE1, BLIGHTED_SUPER_RESTORE2, BLIGHTED_SUPER_RESTORE3, BLIGHTED_SUPER_RESTORE4,
			SUPER_RESTORE4_23567, SUPER_RESTORE3_23569, SUPER_RESTORE2_23571, SUPER_RESTORE1_23573 /* LMS */);
		add(new SuperRestore(.30, 4), SANFEW_SERUM1, SANFEW_SERUM2, SANFEW_SERUM3, SANFEW_SERUM4,
			SANFEW_SERUM4_23559, SANFEW_SERUM3_23561, SANFEW_SERUM2_23563, SANFEW_SERUM1_23565 /* LMS */);
		add(new StaminaPotion(), STAMINA_POTION1, STAMINA_POTION2, STAMINA_POTION3, STAMINA_POTION4);

		// Raids potions (+)
		add(combo(5, boost(ATTACK, perc(.16, 6)), boost(STRENGTH, perc(.16, 6)), boost(DEFENCE, perc(.16, 6)), boost(RANGED, perc(.16, 6)), boost(MAGIC, perc(.16, 6)), heal(HITPOINTS, -50)), OVERLOAD_1_20993, OVERLOAD_2_20994, OVERLOAD_3_20995, OVERLOAD_4_20996);
		add(combo(3, boost(ATTACK, perc(.16, 6)), boost(STRENGTH, perc(.16, 6)), boost(DEFENCE, perc(.16, 6))), ELDER_1_20921, ELDER_2_20922, ELDER_3_20923, ELDER_4_20924);
		add(combo(2, boost(RANGED, perc(.16, 6)), boost(DEFENCE, perc(.16, 6))), TWISTED_1_20933, TWISTED_2_20934, TWISTED_3_20935, TWISTED_4_20936);
		add(combo(2, boost(MAGIC, perc(.16, 6)), boost(DEFENCE, perc(.16, 6))), KODAI_1_20945, KODAI_2_20946, KODAI_3_20947, KODAI_4_20948);
		add(new SuperRestore(.30, 11), REVITALISATION_1_20957, REVITALISATION_2_20958, REVITALISATION_3_20959, REVITALISATION_4_20960);
		add(new SaradominBrew(0.15, 0.2, 0.1, 5, 4), XERICS_AID_1_20981, XERICS_AID_2_20982, XERICS_AID_3_20983, XERICS_AID_4_20984);

		// Raids potions
		add(combo(5, boost(ATTACK, perc(.13, 5)), boost(STRENGTH, perc(.13, 5)), boost(DEFENCE, perc(.13, 5)), boost(RANGED, perc(.13, 5)), boost(MAGIC, perc(.13, 5)), heal(HITPOINTS, -50)), OVERLOAD_1_20989, OVERLOAD_2_20990, OVERLOAD_3_20991, OVERLOAD_4_20992);
		add(combo(3, boost(ATTACK, perc(.13, 5)), boost(STRENGTH, perc(.13, 5)), boost(DEFENCE, perc(.13, 5))), ELDER_POTION_1, ELDER_POTION_2, ELDER_POTION_3, ELDER_POTION_4);
		add(combo(2, boost(RANGED, perc(.13, 5)), boost(DEFENCE, perc(.13, 5))), TWISTED_POTION_1, TWISTED_POTION_2, TWISTED_POTION_3, TWISTED_POTION_4);
		add(combo(2, boost(MAGIC, perc(.13, 5)), boost(DEFENCE, perc(.13, 5))), KODAI_POTION_1, KODAI_POTION_2, KODAI_POTION_3, KODAI_POTION_4);

		// Raids potions (-)
		add(combo(5, boost(ATTACK, perc(.10, 4)), boost(STRENGTH, perc(.10, 4)), boost(DEFENCE, perc(.10, 4)), boost(RANGED, perc(.10, 4)), boost(MAGIC, perc(.10, 4)), heal(HITPOINTS, -50)), OVERLOAD_1_20985, OVERLOAD_2_20986, OVERLOAD_3_20987, OVERLOAD_4_20988);
		add(combo(3, boost(ATTACK, perc(.10, 4)), boost(STRENGTH, perc(.10, 4)), boost(DEFENCE, perc(.10, 4))), ELDER_1, ELDER_2, ELDER_3, ELDER_4);
		add(combo(3, boost(RANGED, perc(.10, 4)), boost(DEFENCE, perc(.10, 4))), TWISTED_1, TWISTED_2, TWISTED_3, TWISTED_4);
		add(combo(3, boost(MAGIC, perc(.10, 4)), boost(DEFENCE, perc(.10, 4))), KODAI_1, KODAI_2, KODAI_3, KODAI_4);

		// Skill potions
		add(boost(AGILITY, 3), AGILITY_POTION1, AGILITY_POTION2, AGILITY_POTION3, AGILITY_POTION4);
		add(boost(FISHING, 3), FISHING_POTION1, FISHING_POTION2, FISHING_POTION3, FISHING_POTION4);
		add(boost(HUNTER, 3), HUNTER_POTION1, HUNTER_POTION2, HUNTER_POTION3, HUNTER_POTION4);
		add(combo(2, boost(HITPOINTS, 5), heal(RUN_ENERGY, 5)), GUTHIX_REST1, GUTHIX_REST2, GUTHIX_REST3, GUTHIX_REST4);

		// Misc/run energy
		add(combo(food(3), range(heal(RUN_ENERGY, 5), heal(RUN_ENERGY, 10))), WHITE_TREE_FRUIT);
		add(heal(RUN_ENERGY, 30), STRANGE_FRUIT);
		add(heal(RUN_ENERGY, 50), MINT_CAKE);
		add(combo(food(12), heal(RUN_ENERGY, 50)), GOUT_TUBER);

		// Pies
		add(combo(2, heal(HITPOINTS, 6), boost(FARMING, 3)), GARDEN_PIE, HALF_A_GARDEN_PIE);
		add(combo(2, heal(HITPOINTS, 6), boost(FISHING, 3)), FISH_PIE, HALF_A_FISH_PIE);
		add(combo(2, heal(HITPOINTS, 7), boost(HERBLORE, 4)), BOTANICAL_PIE, HALF_A_BOTANICAL_PIE);
		add(combo(2, heal(HITPOINTS, 8), boost(CRAFTING, 4)), MUSHROOM_PIE, HALF_A_MUSHROOM_PIE);
		add(combo(2, heal(HITPOINTS, 8), boost(FISHING, 5)), ADMIRAL_PIE, HALF_AN_ADMIRAL_PIE);
		add(combo(2, heal(HITPOINTS, 11), boost(SLAYER, 5), boost(RANGED, 4)), WILD_PIE, HALF_A_WILD_PIE);
		add(combo(2, heal(HITPOINTS, 11), boost(AGILITY, 5), heal(RUN_ENERGY, 10)), SUMMER_PIE, HALF_A_SUMMER_PIE);
		add(combo(2, heal(HITPOINTS, 10), boost(FLETCHING, 4)), DRAGONFRUIT_PIE, HALF_A_DRAGONFRUIT_PIE);

		// Other
		add(combo(range(food(1), food(3)), heal(RUN_ENERGY, 10)), PURPLE_SWEETS_10476);
		add(new SpicyStew(), SPICY_STEW);
		add(boost(MAGIC, perc(.10, 1)), IMBUED_HEART);
		add(combo(boost(ATTACK, 2), boost(STRENGTH, 1), heal(PRAYER, 1), heal(DEFENCE, -1)), JANGERBERRIES);
		add(new CaveNightshade(), CAVE_NIGHTSHADE);

		// Gauntlet items
		add(heal(HITPOINTS, 16), CRYSTAL_PADDLEFISH, CORRUPTED_PADDLEFISH);
		add(heal(HITPOINTS, 20), PADDLEFISH);
		add(new GauntletPotion(), EGNIOL_POTION_1, EGNIOL_POTION_2, EGNIOL_POTION_3, EGNIOL_POTION_4);

		// Soul Wars
		add(combo(2, heal(HITPOINTS, perc(.15, 1)), heal(RUN_ENERGY, 100)), BANDAGES_25202);
		add(combo(6, boost(ATTACK, perc(.15, 5)), boost(STRENGTH, perc(.15, 5)), boost(DEFENCE, perc(.15, 5)), boost(RANGED, perc(.15, 5)), boost(MAGIC, perc(.15, 5)), heal(PRAYER, perc(.25, 8))), POTION_OF_POWER1, POTION_OF_POWER2, POTION_OF_POWER3, POTION_OF_POWER4);

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
