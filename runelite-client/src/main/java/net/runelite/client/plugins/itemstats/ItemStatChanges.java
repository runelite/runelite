package net.runelite.client.plugins.itemstats;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;

import static net.runelite.api.ItemID.*;

@Singleton
@Slf4j
public class ItemStatChanges extends ItemStatChangesMethods
{
	@Inject
	ItemStatChanges(Client client, Stats stats)
	{
	/* TODO: These items are missing
	 * Hint: ItemStatPlugin has a debug flag that you can compile in.
	 *
	 * Raids Fish
	 * Raids Potions
	 * Raids Bats
	 * Beers (Wiki is wrong)
	 * Mixes
	 * Stamina items
	 * Cooked sweetcorn is ?
	 * Pies
	 * http://oldschoolrunescape.wikia.com/wiki/Energy
	 * NMZ absorption counter + pot
	 * purple sweets
	 * Spicy stew
	 */
	/* TODO: There items are added, but may be wrong (ie: At some stats they are correct)
	 * COOKED_SLIMY_EEL
	 * SWEETCORN + SWEETCORN (bowl)
	 * White tree fruit (idk)
	 * raids pots
	 */

	/*
	 * At some point I would like to keep track of effects added to the player.
	 * This is a list of items that I have came across while making this list that add effects
	 * (Super |Extended|)Antifire
	 * Strange fruit
	 * Anti (poision|venom)(++)?
	 * overload?
	 * Imbued heart timeout?
	 */
		super(client, stats);

		// Food
		add(Food(-5), POISON_KARAMBWAN);
		add(Food(1), POTATO, ONION, CABBAGE, POT_OF_CREAM, CHOPPED_ONION);
		add(Food(2), TOMATO, BANANA, ORANGE, PINEAPPLE_CHUNKS, PINEAPPLE_RING, SPICY_SAUCE, CHEESE);
		add(Food(3), SHRIMPS, COOKED_MEAT, COOKED_CHICKEN, ROE, CAVIAR, CHOCOLATE_BAR);
		add(Food(4), SARDINE, CAKE, _23_CAKE, SLICE_OF_CAKE);
		add(Food(5), BREAD, HERRING, CHOCOLATE_CAKE, _23_CHOCOLATE_CAKE, CHOCOLATE_SLICE, COOKED_RABBIT, CHILLI_CON_CARNE,
			FRIED_MUSHROOMS, FRIED_ONIONS, REDBERRY_PIE, HALF_A_REDBERRY_PIE);
		add(Food(6), CHOCICE, MACKEREL, MEAT_PIE, HALF_A_MEAT_PIE);
		add(Food(7), TROUT, COD, PLAIN_PIZZA, _12_PLAIN_PIZZA, APPLE_PIE, HALF_AN_APPLE_PIE, ROAST_RABBIT, BAKED_POTATO,
			PREMADE_CH_CRUNCH, CHOCCHIP_CRUNCHIES, PREMADE_SY_CRUNCH, SPICY_CRUNCHIES);
		add(Food(8), PIKE, ROAST_BEAST_MEAT, MEAT_PIZZA, _12_MEAT_PIZZA, PREMADE_WM_CRUN, WORM_CRUNCHIES, PREMADE_TD_CRUNCH,
			TOAD_CRUNCHIES, EGG_AND_TOMATO);
		add(Food(9), PREMADE_P_PUNCH, PINEAPPLE_PUNCH, PREMADE_FR_BLAST, FRUIT_BLAST, SALMON, ANCHOVY_PIZZA,
			_12_ANCHOVY_PIZZA);
		add(Food(10), TUNA, COOKED_SWEETCORN, CRAB_MEAT, CHOPPED_TUNA, COOKED_CHOMPY);
		add(Food(11), JUG_OF_WINE, RAINBOW_FISH, STEW, PINEAPPLE_PIZZA, _12_PINEAPPLE_PIZZA, COOKED_FISHCAKE,
			PREMADE_VEG_BATTA, VEGETABLE_BATTA, PREMADE_WM_BATTA, WORM_BATTA, PREMADE_TD_BATTA, TOAD_BATTA, PREMADE_TD_BATTA,
			TOAD_BATTA, PREMADE_CT_BATTA, CHEESETOM_BATTA, MUSHROOM__ONION);
		add(Food(12), LOBSTER, PREMADE_WORM_HOLE, WORM_HOLE, PREMADE_VEG_BALL, VEG_BALL);
		add(Food(13), BASS, TUNA_AND_CORN);
		add(Food(14), POTATO_WITH_BUTTER, CHILLI_POTATO, SWORDFISH);
		add(Food(15), PREMADE_TTL, TANGLED_TOADS_LEGS, PREMADE_CHOC_BOMB, CHOCOLATE_BOMB);
		add(Food(16), MONKFISH, POTATO_WITH_CHEESE, EGG_POTATO);
		add(Food(18), COOKED_KARAMBWAN);
		add(Food(19), CURRY, UGTHANKI_KEBAB);
		add(Food(20), MUSHROOM_POTATO, SHARK);
		add(Food(21), SEA_TURTLE);
		add(Food(22), MANTA_RAY, DARK_CRAB, TUNA_POTATO);
		add(new Combo(simple(stats.HITPOINTS, maxHP ->
		{
			int C;
			if (maxHP <= 24)
			{
				C = 2;
			}
			else if (maxHP <= 49)
			{
				C = 4;
			}
			else if (maxHP <= 74)
			{
				C = 6;
			}
			else if (maxHP <= 92)
			{
				C = 8;
			}
			else
			{
				C = 13;
			}
			return (maxHP / 10) + C;
		}, BOOST)), ANGLERFISH);
		add(new Combo(simple(stats.HITPOINTS, maxHP -> (int) Math.ceil(maxHP * .06))), STRAWBERRY);
		add(new Combo(simple(stats.HITPOINTS, maxHP -> (int) Math.ceil(maxHP * .05))), WATERMELON_SLICE);
		add(new Combo(simple(stats.HITPOINTS, perc(.1, 0))), COOKED_SLIMY_EEL);
		add(new Combo(simple(stats.HITPOINTS, perc(.1, 1))), SWEETCORN, SWEETCORN_7088);
		add(new Combo(
			simple(stats.HITPOINTS, add(1)),
			simple(stats.DEFENCE, perc(.02, 1), BOOST)
		), CABBAGE_1967);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(4)),
			simple(stats.RUN_ENERGY, add(5))
		), PAPAYA_FRUIT);

		// Alcoholic Gnome Cocktails
		add(new Combo(2,
			simple(stats.HITPOINTS, add(5)),
			simple(stats.STRENGTH, add(6), BOOST),
			simple(stats.ATTACK, add(-4))
		), PREMADE_WIZ_BLZD, WIZARD_BLIZZARD);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(5)),
			simple(stats.STRENGTH, add(4), BOOST),
			simple(stats.ATTACK, add(-3))
		), PREMADE_SGG, SHORT_GREEN_GUY);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(5)),
			simple(stats.STRENGTH, add(7), BOOST),
			simple(stats.ATTACK, add(-4))
		), PREMADE_DR_DRAGON, DRUNK_DRAGON);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(5)),
			simple(stats.STRENGTH, add(7), BOOST),
			simple(stats.ATTACK, add(-4))
		), PREMADE_CHOC_SDY, CHOC_SATURDAY);

		// Sq'irk Juice
		add(new Combo(simple(stats.RUN_ENERGY, add(5))), WINTER_SQIRKJUICE);
		add(new Combo(2,
			simple(stats.RUN_ENERGY, add(10)),
			simple(stats.THIEVING, add(1), BOOST)
		), SPRING_SQIRKJUICE);
		add(new Combo(2,
			simple(stats.RUN_ENERGY, add(15)),
			simple(stats.THIEVING, add(2), BOOST)
		), AUTUMN_SQIRKJUICE);
		add(new Combo(2,
			simple(stats.RUN_ENERGY, add(20)),
			simple(stats.THIEVING, add(3), BOOST)
		), SUMMER_SQIRKJUICE);

		// Combat Potions
		add(new Combo(
			simple(stats.ATTACK, perc(.10, 3), BOOST)
		), ATTACK_POTION1, ATTACK_POTION2, ATTACK_POTION3, ATTACK_POTION4);
		add(new Combo(
			simple(stats.STRENGTH, perc(.10, 3), BOOST)
		), STRENGTH_POTION1, STRENGTH_POTION2, STRENGTH_POTION3, STRENGTH_POTION4);
		add(new Combo(
			simple(stats.DEFENCE, perc(.10, 3), BOOST)
		), DEFENCE_POTION1, DEFENCE_POTION2, DEFENCE_POTION3, DEFENCE_POTION4);
		add(new Combo(
			simple(stats.MAGIC, add(4), BOOST)
		), MAGIC_POTION1, MAGIC_POTION2, MAGIC_POTION3, MAGIC_POTION4);
		add(new Combo(
			simple(stats.RANGED, perc(.10, 3), BOOST)
		), RANGING_POTION1, RANGING_POTION2, RANGING_POTION3, RANGING_POTION4);
		add(new Combo(2,
			simple(stats.ATTACK, perc(.10, 3), BOOST),
			simple(stats.STRENGTH, perc(.10, 3), BOOST)
		), COMBAT_POTION1, COMBAT_POTION2, COMBAT_POTION3, COMBAT_POTION4);
		add(new Combo(
			simple(stats.ATTACK, perc(.15, 5), BOOST)
		), SUPER_ATTACK1, SUPER_ATTACK2, SUPER_ATTACK3, SUPER_ATTACK4);
		add(new Combo(
			simple(stats.STRENGTH, perc(.15, 5), BOOST)
		), SUPER_STRENGTH1, SUPER_STRENGTH2, SUPER_STRENGTH3, SUPER_STRENGTH4);
		add(new Combo(
			simple(stats.MAGIC, add(3), BOOST)
		), MAGIC_ESSENCE1, MAGIC_ESSENCE2, MAGIC_ESSENCE3, MAGIC_ESSENCE4);
		add(new Combo(
			simple(stats.DEFENCE, perc(.15, 5), BOOST)
		), SUPER_DEFENCE1, SUPER_DEFENCE2, SUPER_DEFENCE3, SUPER_DEFENCE4);
		add(new Combo(3,
			simple(stats.ATTACK, perc(.15, 5), BOOST),
			simple(stats.STRENGTH, perc(.15, 5), BOOST),
			simple(stats.DEFENCE, perc(.15, 5), BOOST)
		), SUPER_COMBAT_POTION1, SUPER_COMBAT_POTION2, SUPER_COMBAT_POTION3, SUPER_COMBAT_POTION4);
		add(new Combo(3,
			simple(stats.ATTACK, perc(.20, 2), BOOST),
			simple(stats.STRENGTH, perc(.12, 2), BOOST),
			simple(stats.PRAYER, perc(.10, 0)),
			simple(stats.DEFENCE, perc(.10, -2)),
			simple(stats.HITPOINTS, perc(.12, 0))
		), ZAMORAK_BREW1, ZAMORAK_BREW2, ZAMORAK_BREW3, ZAMORAK_BREW4);
		add(new Combo(2,
			simple(stats.HITPOINTS, perc(.15, 2), BOOST),
			simple(stats.DEFENCE, perc(.20, 2), BOOST),
			simple(stats.ATTACK, perc(.10, -2)),
			simple(stats.RANGED, perc(.10, -2)),
			simple(stats.MAGIC, perc(.10, -2))
		), SARADOMIN_BREW1, SARADOMIN_BREW2, SARADOMIN_BREW3, SARADOMIN_BREW4);
		add(new Combo(
			simple(stats.RANGED, perc(.15, 5), BOOST)
		), SUPER_RANGING_1, SUPER_RANGING_2, SUPER_RANGING_3, SUPER_RANGING_4);
		add(new Combo(
			simple(stats.MAGIC, perc(.15, 5), BOOST)
		), SUPER_MAGIC_POTION_1, SUPER_MAGIC_POTION_2, SUPER_MAGIC_POTION_3, SUPER_MAGIC_POTION_4);
		add(new Combo(5,
			simple(stats.ATTACK, perc(.15, 5), BOOST),
			simple(stats.STRENGTH, perc(.15, 5), BOOST),
			simple(stats.DEFENCE, perc(.15, 5), BOOST),
			simple(stats.RANGED, perc(.15, 5), BOOST),
			simple(stats.MAGIC, perc(.15, 5), BOOST),
			simple(stats.HITPOINTS, add(-50))
		), OVERLOAD_1, OVERLOAD_2, OVERLOAD_3, OVERLOAD_4);

		// Recovery potions
		add(new Combo(5,
			simple(stats.ATTACK, perc(.30, 10)),
			simple(stats.STRENGTH, perc(.30, 10)),
			simple(stats.DEFENCE, perc(.30, 10)),
			simple(stats.RANGED, perc(.30, 10)),
			simple(stats.MAGIC, perc(.30, 10))
		), RESTORE_POTION1, RESTORE_POTION2, RESTORE_POTION3, RESTORE_POTION4);
		add(new Combo(
			simple(stats.RUN_ENERGY, add(10))
		), ENERGY_POTION1, ENERGY_POTION2, ENERGY_POTION3, ENERGY_POTION4);
		add(new Combo(
			simple(stats.PRAYER, new PrayerCalc(7))
		), PRAYER_POTION1, PRAYER_POTION2, PRAYER_POTION3, PRAYER_POTION4);
		add(new Combo(
			simple(stats.RUN_ENERGY, add(20))
		), SUPER_ENERGY1, SUPER_ENERGY2, SUPER_ENERGY3, SUPER_ENERGY4);
		add(new SuperRestore(8), SUPER_RESTORE1, SUPER_RESTORE2, SUPER_RESTORE3, SUPER_RESTORE4);
		add(new SuperRestore(9), SANFEW_SERUM1, SANFEW_SERUM2, SANFEW_SERUM3, SANFEW_SERUM4);
		add(new Combo(
			simple(stats.RUN_ENERGY, add(20))
		), STAMINA_POTION1, STAMINA_POTION2, STAMINA_POTION3, STAMINA_POTION4);

		// Cures and antipoisions


		// Skill Potions
		add(new Combo(
			simple(stats.AGILITY, add(3), BOOST)
		), AGILITY_POTION1, AGILITY_POTION2, AGILITY_POTION3, AGILITY_POTION4);
		add(new Combo(
			simple(stats.FISHING, add(3), BOOST)
		), FISHING_POTION1, FISHING_POTION2, FISHING_POTION3, FISHING_POTION4);
		add(new Combo(
			simple(stats.HUNTER, add(3), BOOST)
		), HUNTER_POTION1, HUNTER_POTION2, HUNTER_POTION3, HUNTER_POTION4);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(5), BOOST),
			simple(stats.RUN_ENERGY, add(5))
		), GUTHIX_REST1, GUTHIX_REST2, GUTHIX_REST3, GUTHIX_REST4);

		// Misc run energy
		add(new Combo(
			simple(stats.RUN_ENERGY, add(10))
		), WHITE_TREE_FRUIT);
		add(new Combo(
			simple(stats.RUN_ENERGY, add(30))
		), STRANGE_FRUIT, BANDAGES);
		add(new Combo(
			simple(stats.RUN_ENERGY, add(50))
		), MINT_CAKE, GOUT_TUBER);

		// Pies
		add(new Combo(2,
			simple(stats.HITPOINTS, add(6)),
			simple(stats.FARMING, add(3), BOOST)
		), GARDEN_PIE, HALF_A_GARDEN_PIE);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(6)),
			simple(stats.FISHING, add(3), BOOST)
		), FISH_PIE, HALF_A_FISH_PIE);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(7)),
			simple(stats.HERBLORE, add(4), BOOST)
		), BOTANICAL_PIE, HALF_A_BOTANICAL_PIE);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(8)),
			simple(stats.CRAFTING, add(4), BOOST)
		), MUSHROOM_PIE, HALF_A_MUSHROOM_PIE);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(8)),
			simple(stats.FISHING, add(5), BOOST)
		), ADMIRAL_PIE, HALF_AN_ADMIRAL_PIE);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(11)),
			simple(stats.SLAYER, add(5), BOOST),
			simple(stats.RANGED, add(4), BOOST)
		), WILD_PIE, HALF_A_WILD_PIE);
		add(new Combo(2,
			simple(stats.HITPOINTS, add(22)),
			simple(stats.AGILITY, add(5), BOOST),
			simple(stats.RUN_ENERGY, add(10))
		), SUMMER_PIE, HALF_A_SUMMER_PIE);

		// Other
		add(new Combo(
			simple(stats.MAGIC, perc(.10, 1), BOOST)
		), IMBUED_HEART);

		log.debug("{} items; {} behaviours loaded", itemToCalcs.size(), new HashSet(itemToCalcs.values()).size());
	}
}