/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
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
import net.runelite.client.plugins.itemstats.potions.SuperRestore;
import static net.runelite.client.plugins.itemstats.Builders.*;
import static net.runelite.client.plugins.itemstats.stats.Stats.*;
import net.runelite.client.plugins.itemstats.food.Anglerfish;
import net.runelite.client.plugins.itemstats.potions.PrayerPotion;

@Singleton
@Slf4j
public class ItemStatChanges
{

	public ItemStatChanges()
	{
		init();
	}

	final void init()
	{
		add(food(-5), POISON_KARAMBWAN);
		add(food(1), POTATO, ONION, CABBAGE, POT_OF_CREAM, CHOPPED_ONION);
		add(food(2), TOMATO, BANANA, ORANGE, PINEAPPLE_CHUNKS, PINEAPPLE_RING, SPICY_SAUCE, CHEESE, SPINACH_ROLL);
		add(food(3), SHRIMPS, COOKED_MEAT, COOKED_CHICKEN, ROE, CAVIAR, CHOCOLATE_BAR);
		add(food(4), SARDINE, CAKE, _23_CAKE, SLICE_OF_CAKE);
		add(food(5), BREAD, HERRING, CHOCOLATE_CAKE, _23_CHOCOLATE_CAKE, CHOCOLATE_SLICE, COOKED_RABBIT, CHILLI_CON_CARNE,
			FRIED_MUSHROOMS, FRIED_ONIONS, REDBERRY_PIE, HALF_A_REDBERRY_PIE);
		add(food(6), CHOCICE, MACKEREL, MEAT_PIE, HALF_A_MEAT_PIE, GUANIC_BAT_0, ROAST_BIRD_MEAT,
			SQUARE_SANDWICH, ROLL, BAGUETTE, TRIANGLE_SANDWICH);
		add(food(7), TROUT, COD, PLAIN_PIZZA, _12_PLAIN_PIZZA, APPLE_PIE, HALF_AN_APPLE_PIE, ROAST_RABBIT, BAKED_POTATO,
			PREMADE_CH_CRUNCH, CHOCCHIP_CRUNCHIES, PREMADE_SY_CRUNCH, SPICY_CRUNCHIES);
		add(food(8), PIKE, ROAST_BEAST_MEAT, MEAT_PIZZA, _12_MEAT_PIZZA, PREMADE_WM_CRUN, WORM_CRUNCHIES, PREMADE_TD_CRUNCH,
			TOAD_CRUNCHIES, EGG_AND_TOMATO, LECKISH_FISH_2, PRAEL_BAT_1);
		add(food(9), PREMADE_P_PUNCH, PINEAPPLE_PUNCH, PREMADE_FR_BLAST, FRUIT_BLAST, SALMON, ANCHOVY_PIZZA,
			_12_ANCHOVY_PIZZA);
		add(food(10), TUNA, COOKED_SWEETCORN, CRAB_MEAT, CHOPPED_TUNA, COOKED_CHOMPY);
		add(food(11), JUG_OF_WINE, RAINBOW_FISH, STEW, PINEAPPLE_PIZZA, _12_PINEAPPLE_PIZZA, COOKED_FISHCAKE,
			PREMADE_VEG_BATTA, VEGETABLE_BATTA, PREMADE_WM_BATTA, WORM_BATTA, PREMADE_TD_BATTA, TOAD_BATTA, PREMADE_CT_BATTA,
			CHEESETOM_BATTA, MUSHROOM__ONION, GIRAL_BAT_2, LAVA_EEL);
		add(food(12), LOBSTER, PREMADE_WORM_HOLE, WORM_HOLE, PREMADE_VEG_BALL, VEG_BALL);
		add(food(13), BASS, TUNA_AND_CORN);
		add(food(14), POTATO_WITH_BUTTER, CHILLI_POTATO, SWORDFISH, PHLUXIA_BAT_3);
		add(food(15), PREMADE_TTL, TANGLED_TOADS_LEGS, PREMADE_CHOC_BOMB, CHOCOLATE_BOMB);
		add(food(16), MONKFISH, POTATO_WITH_CHEESE, EGG_POTATO);
		add(food(17), MYCIL_FISH_4, KRYKET_BAT_4);
		add(food(18), COOKED_KARAMBWAN);
		add(food(19), CURRY, UGTHANKI_KEBAB);
		add(food(20), MUSHROOM_POTATO, SHARK, ROQED_FISH_5, MURNG_BAT_5);
		add(food(21), SEA_TURTLE);
		add(food(22), MANTA_RAY, DARK_CRAB, TUNA_POTATO);
		add(food(23), KYREN_FISH_6, PSYKK_BAT_6);
		add(new Anglerfish(), ANGLERFISH);
		add(food(maxHP -> (int) Math.ceil(maxHP * .06)), STRAWBERRY);
		add(food(maxHP -> (int) Math.ceil(maxHP * .05)), WATERMELON_SLICE);
		add(food(perc(.1, 0)), COOKED_SLIMY_EEL);
		add(food(perc(.1, 1)), SWEETCORN, SWEETCORN_7088);
		add(combo(food(1), boost(DEFENCE, perc(.02, 1))), CABBAGE_1967);
		add(combo(2, food(4), heal(RUN_ENERGY, 5)), PAPAYA_FRUIT);

		// Alcoholic Gnome Cocktails
		add(combo(2, food(5), boost(STRENGTH, 6), heal(ATTACK, -4)), PREMADE_WIZ_BLZD, WIZARD_BLIZZARD);
		add(combo(2, food(5), boost(STRENGTH, 4), heal(ATTACK, -3)), PREMADE_SGG, SHORT_GREEN_GUY);
		add(combo(2, food(5), boost(STRENGTH, 7), heal(ATTACK, -4)), PREMADE_DR_DRAGON, DRUNK_DRAGON);
		add(combo(2, food(5), boost(STRENGTH, 7), heal(ATTACK, -4)), PREMADE_CHOC_SDY, CHOC_SATURDAY);

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
		add(boost(RANGED, perc(.10, 3)), RANGING_POTION1, RANGING_POTION2, RANGING_POTION3, RANGING_POTION4);
		add(combo(2, boost(ATTACK, perc(.10, 3)), boost(STRENGTH, perc(.10, 3))), COMBAT_POTION1, COMBAT_POTION2, COMBAT_POTION3, COMBAT_POTION4);
		add(boost(ATTACK, perc(.15, 5)), SUPER_ATTACK1, SUPER_ATTACK2, SUPER_ATTACK3, SUPER_ATTACK4);
		add(boost(STRENGTH, perc(.15, 5)), SUPER_STRENGTH1, SUPER_STRENGTH2, SUPER_STRENGTH3, SUPER_STRENGTH4);
		add(boost(DEFENCE, perc(.15, 5)), SUPER_DEFENCE1, SUPER_DEFENCE2, SUPER_DEFENCE3, SUPER_DEFENCE4);
		add(boost(MAGIC, 3), MAGIC_ESSENCE1, MAGIC_ESSENCE2, MAGIC_ESSENCE3, MAGIC_ESSENCE4);
		add(combo(3, boost(ATTACK, perc(.15, 5)), boost(STRENGTH, perc(.15, 5)), boost(DEFENCE, perc(.15, 5))), SUPER_COMBAT_POTION1, SUPER_COMBAT_POTION2, SUPER_COMBAT_POTION3, SUPER_COMBAT_POTION4);
		add(combo(3, boost(ATTACK, perc(.20, 2)), boost(STRENGTH, perc(.12, 2)), heal(PRAYER, perc(.10, 0)), heal(DEFENCE, perc(.10, -2)), heal(HITPOINTS, perc(.12, 0))), ZAMORAK_BREW1, ZAMORAK_BREW2, ZAMORAK_BREW3, ZAMORAK_BREW4);
		add(combo(2, boost(HITPOINTS, perc(.15, 2)), boost(DEFENCE, perc(.20, 2)), heal(ATTACK, perc(.10, -2)), heal(RANGED, perc(.10, -2)), heal(MAGIC, perc(.10, -2))), SARADOMIN_BREW1, SARADOMIN_BREW2, SARADOMIN_BREW3, SARADOMIN_BREW4);
		add(boost(RANGED, perc(.15, 5)), SUPER_RANGING_1, SUPER_RANGING_2, SUPER_RANGING_3, SUPER_RANGING_4);
		add(boost(MAGIC, perc(.15, 5)), SUPER_MAGIC_POTION_1, SUPER_MAGIC_POTION_2, SUPER_MAGIC_POTION_3, SUPER_MAGIC_POTION_4);
		add(combo(5, boost(ATTACK, perc(.15, 5)), boost(STRENGTH, perc(.15, 5)), boost(DEFENCE, perc(.15, 5)), boost(RANGED, perc(.15, 5)), boost(MAGIC, perc(.15, 5)), heal(HITPOINTS, -50)), OVERLOAD_1, OVERLOAD_2, OVERLOAD_3, OVERLOAD_4);

		// Recovery potions
		add(combo(5, heal(ATTACK, perc(.30, 10)), heal(STRENGTH, perc(.30, 10)), heal(DEFENCE, perc(.30, 10)), heal(RANGED, perc(.30, 10)), heal(MAGIC, perc(.30, 10))), RESTORE_POTION1, RESTORE_POTION2, RESTORE_POTION3, RESTORE_POTION4);
		add(heal(RUN_ENERGY, 10), ENERGY_POTION1, ENERGY_POTION2, ENERGY_POTION3, ENERGY_POTION4);
		add(new PrayerPotion(7), PRAYER_POTION1, PRAYER_POTION2, PRAYER_POTION3, PRAYER_POTION4);
		add(heal(RUN_ENERGY, 20), SUPER_ENERGY1, SUPER_ENERGY2, SUPER_ENERGY3, SUPER_ENERGY4);
		add(new SuperRestore(8), SUPER_RESTORE1, SUPER_RESTORE2, SUPER_RESTORE3, SUPER_RESTORE4);
		add(new SuperRestore(9), SANFEW_SERUM1, SANFEW_SERUM2, SANFEW_SERUM3, SANFEW_SERUM4);
		add(heal(RUN_ENERGY, 20), STAMINA_POTION1, STAMINA_POTION2, STAMINA_POTION3, STAMINA_POTION4);

		// Skill potions
		add(boost(AGILITY, 3), AGILITY_POTION1, AGILITY_POTION2, AGILITY_POTION3, AGILITY_POTION4);
		add(boost(FISHING, 3), FISHING_POTION1, FISHING_POTION2, FISHING_POTION3, FISHING_POTION4);
		add(boost(HUNTER, 3), HUNTER_POTION1, HUNTER_POTION2, HUNTER_POTION3, HUNTER_POTION4);
		add(combo(2, boost(HITPOINTS, 5), heal(RUN_ENERGY, 5)), GUTHIX_REST1, GUTHIX_REST2, GUTHIX_REST3, GUTHIX_REST4);

		// Misc run energy
		add(heal(RUN_ENERGY, 10), WHITE_TREE_FRUIT);
		add(heal(RUN_ENERGY, 30), STRANGE_FRUIT, BANDAGES);
		add(heal(RUN_ENERGY, 50), MINT_CAKE, GOUT_TUBER);

		// Pies
		add(combo(2, heal(HITPOINTS, 6), boost(FARMING, 3)), GARDEN_PIE, HALF_A_GARDEN_PIE);
		add(combo(2, heal(HITPOINTS, 6), boost(FISHING, 3)), FISH_PIE, HALF_A_FISH_PIE);
		add(combo(2, heal(HITPOINTS, 7), boost(HERBLORE, 4)), BOTANICAL_PIE, HALF_A_BOTANICAL_PIE);
		add(combo(2, heal(HITPOINTS, 8), boost(CRAFTING, 4)), MUSHROOM_PIE, HALF_A_MUSHROOM_PIE);
		add(combo(2, heal(HITPOINTS, 8), boost(FISHING, 5)), ADMIRAL_PIE, HALF_AN_ADMIRAL_PIE);
		add(combo(2, heal(HITPOINTS, 11), boost(SLAYER, 5), boost(RANGED, 4)), WILD_PIE, HALF_A_WILD_PIE);
		add(combo(2, heal(HITPOINTS, 11), boost(AGILITY, 5), heal(RUN_ENERGY, 10)), SUMMER_PIE, HALF_A_SUMMER_PIE);

		// Other
		add(boost(MAGIC, perc(.10, 1)), IMBUED_HEART);
		add(combo(boost(ATTACK, 2), boost(STRENGTH, 1), heal(DEFENCE, -1)), JANGERBERRIES);

		log.debug("{} items; {} behaviours loaded", effects.size(), new HashSet(effects.values()).size());
	}

	private final Map<Integer, Effect> effects = new HashMap<>();

	private void add(Effect effect, int... items)
	{
		assert items.length > 0;
		for (int item : items)
		{
			Effect prev = effects.put(item, effect);
			assert prev == null : "Item already added";
		}
	}

	public Effect get(int id)
	{
		return effects.get(id);
	}

}
