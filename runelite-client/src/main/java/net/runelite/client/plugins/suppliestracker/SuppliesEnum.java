/*
 * Copyright (c) 2018, Daddy Dozer <Whitedylan7@gmail.com>
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
package net.runelite.client.plugins.suppliestracker;

import net.runelite.api.ItemID;

public enum SuppliesEnum
{
	Food(new String[]{"Lobster - #" + ItemID.LOBSTER,
			"Swordfish - #" + ItemID.SWORDFISH,
			"Potato with Cheese - #" + ItemID.POTATO_WITH_CHEESE,
			"Monkfish - #" + ItemID.MONKFISH,
			"Shark - #" + ItemID.SHARK,
			"Manta Ray - #" + ItemID.MANTA_RAY,
			"Dark Crab - #" + ItemID.DARK_CRAB,
			"Anglerfish - #" + ItemID.ANGLERFISH}),

	Potion(new String[]{"Melee Potions#Combat Potion#" + ItemID.COMBAT_POTION1,
			"Melee Potions#Super Combat Potion#" + ItemID.SUPER_COMBAT_POTION1,
			"Melee Potions#Attack Potion#" + ItemID.ATTACK_POTION1,
			"Melee Potions#Super Attack Potion#" + ItemID.SUPER_ATTACK1,
			"Melee Potions#Strength Potion#" + ItemID.STRENGTH_POTION1,
			"Melee Potions#Super Strength Potion#" + ItemID.SUPER_STRENGTH1,
			"Melee Potions#Defense Potion#" + ItemID.DEFENCE_POTION1,
			"Melee Potions#Super Defense Potion#" + ItemID.SUPER_DEFENCE1,
			"Magic Potions#Magic Potion#" + ItemID.MAGIC_POTION1,
			"Magic Potions#Battlemage Potion#" + ItemID.BATTLEMAGE_POTION1,
			"Range Potions#Ranging Potion#" + ItemID.RANGING_POTION1,
			"Range Potions#Bastion Potion#" + ItemID.BASTION_POTION1,
			"Antifire Potions#Antifire Potion#" + ItemID.ANTIFIRE_POTION4,
			"Antifire Potions#Extended Antifire Potion#" + ItemID.EXTENDED_ANTIFIRE1,
			"Antifire Potions#Super Antifire Potion#" + ItemID.SUPER_ANTIFIRE_POTION1,
			"Antifire Potions#Extended Super Antifire Potion#" + ItemID.EXTENDED_SUPER_ANTIFIRE1,
			"God Brews#Saradomin Brew#" + ItemID.SARADOMIN_BREW1,
			"God Brews#Zamorak Brew#" + ItemID.ZAMORAK_BREW1,
			"Restore Potions#Stat Restore Potion#" + ItemID.RESTORE_POTION1,
			"Restore Potions#Super Restore Potion#" + ItemID.SUPER_RESTORE1,
			"Restore Potions#Prayer Potion#" + ItemID.PRAYER_POTION1,
			"Restore Potions#Sanfew Serum#" + ItemID.SANFEW_SERUM1,
			"Restore Potions#Energy Potion#" + ItemID.ENERGY_POTION1,
			"Restore Potions#Super Energy Potion#" + ItemID.SUPER_ENERGY1,
			"Restore Potions#Stamina Potion#" + ItemID.STAMINA_POTION1,
			"Cure Potions#Antipoison#" + ItemID.ANTIPOISON1,
			"Cure Potions#Super Antipoison#" + ItemID.SUPERANTIPOISON1,
			"Cure Potions#Antidote+#" + ItemID.ANTIDOTE1,
			"Cure Potions#Antidote++#" + ItemID.ANTIDOTE1_5958,
			"Cure Potions#Anti-Venom#" + ItemID.ANTIVENOM1,
			"Cure Potions#Anti-Venom#+" + ItemID.ANTIDOTE1_5958,
			"Cure Potions#Relicym's Balm#" + ItemID.RELICYMS_BALM1}),

	Ammo(new String[]{"Arrows#Bronze Arrows#" + ItemID.BRONZE_ARROW,
			"Arrows#Iron Arrows#" + ItemID.IRON_ARROW,
			"Arrows#Steel Arrows#" + ItemID.STEEL_ARROW,
			"Arrows#Mithril Arrows#" + ItemID.MITHRIL_ARROW,
			"Arrows#Adamant Arrows#" + ItemID.ADAMANT_ARROW,
			"Arrows#Rune Arrows#" + ItemID.RUNE_ARROW,
			"Arrows#Broad Arrows#" + ItemID.BROAD_ARROWS,
			"Arrows#Amethyst Arrows#" + ItemID.AMETHYST_ARROW,
			"Arrows#Dragon Arrows#" + ItemID.DRAGON_ARROW,
			"Bolts#Opal Bolts(e)#" + ItemID.OPAL_BOLTS_E,
			"Bolts#Jade Bolts(e)#" + ItemID.JADE_BOLTS_E,
			"Bolts#Pearl Bolts(e)#" + ItemID.PEARL_BOLTS_E,
			"Bolts#Topaz Bolts(e)#" + ItemID.TOPAZ_BOLTS_E,
			"Bolts#Sapphire Bolts(e)#" + ItemID.SAPPHIRE_BOLTS_E,
			"Bolts#Emerald Bolts(e)#" + ItemID.EMERALD_BOLTS_E,
			"Bolts#Ruby Bolts(e)#" + ItemID.RUBY_BOLTS_E,
			"Bolts#Diamond Bolts(e)#" + ItemID.DIAMOND_BOLTS_E,
			"Bolts#Dragonstone Bolts(e)#" + ItemID.DRAGONSTONE_BOLTS_E,
			"Bolts#Onyx Bolts(e)#" + ItemID.ONYX_BOLTS_E,
			"Bolts#Bone Bolts#" + ItemID.BONE_BOLTS,
			"Bolts#Bolt Rack#" + ItemID.BOLT_RACK,
			"Bolts#Adamant Bolts#" + ItemID.ADAMANT_BOLTS,
			"Bolts#Rune Bolts#" + ItemID.RUNITE_BOLTS,
			"Bolts#Broad Bolts#" + ItemID.BROAD_BOLTS,
			"Dragon Bolts#Dragon Bolts#" + ItemID.DRAGON_BOLTS,
			"Dragon Bolts#Opal Dragon Bolts(e)#" + ItemID.OPAL_DRAGON_BOLTS_E,
			"Dragon Bolts#Jade Dragon Bolts(e)#" + ItemID.JADE_DRAGON_BOLTS_E,
			"Dragon Bolts#Pearl Dragon Bolts(e)#" + ItemID.PEARL_DRAGON_BOLTS_E,
			"Dragon Bolts#Topaz Dragon Bolts(e)#" + ItemID.TOPAZ_DRAGON_BOLTS_E,
			"Dragon Bolts#Sapphire Dragon Bolts(e)#" + ItemID.SAPPHIRE_DRAGON_BOLTS_E,
			"Dragon Bolts#Emerald Dragon Bolts(e)#" + ItemID.EMERALD_DRAGON_BOLTS_E,
			"Dragon Bolts#Ruby Dragon Bolts(e)#" + ItemID.RUBY_DRAGON_BOLTS_E,
			"Dragon Bolts#Diamond Dragon Bolts(e)#" + ItemID.DIAMOND_DRAGON_BOLTS_E,
			"Dragon Bolts#Dragonstone Dragon Bolts(e)#" + ItemID.DRAGONSTONE_DRAGON_BOLTS_E,
			"Dragon Bolts#Onyx Dragon Bolts(e)#" + ItemID.ONYX_DRAGON_BOLTS_E,
			"Chinchompas#Grey Chinchompa#" + ItemID.CHINCHOMPA_10033,
			"Chinchompas#Red Chinchompa#" + ItemID.RED_CHINCHOMPA_10034,
			"Chinchompas#Black Chinchompa#" + ItemID.BLACK_CHINCHOMPA,
			"Darts#Bronze Darts#" + ItemID.BRONZE_DART,
			"Darts#Iron Darts#" + ItemID.IRON_DART,
			"Darts#Steel Darts#" + ItemID.STEEL_DART,
			"Darts#Black Darts#" + ItemID.BLACK_DART,
			"Darts#Mithril Darts#" + ItemID.MITHRIL_DART,
			"Darts#Adamant Darts#" + ItemID.ADAMANT_DART,
			"Darts#Rune Darts#" + ItemID.RUNE_DART,
			"Darts#Dragon Darts#" + ItemID.DRAGON_DART,
			"Javelins#Bronze Javelins#" + ItemID.BRONZE_JAVELIN,
			"Javelins#Iron Javelins#" + ItemID.IRON_JAVELIN,
			"Javelins#Steel Javelins#" + ItemID.STEEL_JAVELIN,
			"Javelins#Mithril Javelins#" + ItemID.MITHRIL_JAVELIN,
			"Javelins#Adamant Javelins#" + ItemID.ADAMANT_JAVELIN,
			"Javelins#Rune Javelins#" + ItemID.RUNE_JAVELIN,
			"Javelins#Amethyst Javelins#" + ItemID.AMETHYST_JAVELIN,
			"Javelins#Dragon Javelins#" + ItemID.DRAGON_JAVELIN,
			"Knives#Bronze Knives#" + ItemID.BRONZE_KNIFE,
			"Knives#Iron Knives#" + ItemID.IRON_KNIFE,
			"Knives#Steel Knives#" + ItemID.STEEL_KNIFE,
			"Knives#Black Knives#" + ItemID.BLACK_KNIFE,
			"Knives#Mithril Knives#" + ItemID.MITHRIL_KNIFE,
			"Knives#Adamant Knives#" + ItemID.ADAMANT_KNIFE,
			"Knives#Rune Knives#" + ItemID.RUNE_KNIFE,
			"Knives#Dragon Knives#" + ItemID.DRAGON_KNIFE,
			"Throwing Axes#Bronze Throwing Axes#" + ItemID.BRONZE_THROWNAXE,
			"Throwing Axes#Iron Throwing Axes#" + ItemID.IRON_THROWNAXE,
			"Throwing Axes#Steel Throwing Axes#" + ItemID.STEEL_THROWNAXE,
			"Throwing Axes#Mithril Throwing Axes#" + ItemID.MITHRIL_THROWNAXE,
			"Throwing Axes#Adamant Throwing Axes#" + ItemID.ADAMANT_THROWNAXE,
			"Throwing Axes#Rune Throwing Axes#" + ItemID.RUNE_THROWNAXE,
			"Throwing Axes#Dragon Throwing Axes#" + ItemID.DRAGON_THROWNAXE}),


	Runes(new String[]{	"Air Rune#" + ItemID.AIR_RUNE,
			"Astral Rune#" + ItemID.ASTRAL_RUNE,
			"Blood Rune#" + ItemID.BLOOD_RUNE,
			"Body Rune#" + ItemID.BODY_RUNE,
			"Chaos Rune#" + ItemID.CHAOS_RUNE,
			"Cosmic Rune#" + ItemID.COSMIC_RUNE,
			"Death Rune#" + ItemID.DEATH_RUNE,
			"Dust Rune#" + ItemID.DUST_RUNE,
			"Earth Rune#" + ItemID.EARTH_RUNE,
			"Fire Rune#" + ItemID.FIRE,
			"Mind Rune#" + ItemID.MIND_RUNE,
			"Mist Rune#" + ItemID.MIST_RUNE,
			"Mud Rune#" + ItemID.MUD_RUNE,
			"Nature Rune#" + ItemID.NATURE_RUNE,
			"Lava Rune#" + ItemID.LAVA_RUNE,
			"Law Rune#" + ItemID.LAW_RUNE,
			"Smoke Rune#" + ItemID.SMOKE_RUNE,
			"Soul Rune#" + ItemID.SOUL_RUNE,
			"Steam Rune#" + ItemID.STEAM_RUNE,
			"Water Rune#" + ItemID.WATER_RUNE,
			"Wrath Rune#" + ItemID.WRATH_RUNE});

	private final String[] itemList;

	SuppliesEnum(String[] items)
	{
		this.itemList = items;
	}


	public String[] MenuItemList()
	{
		return itemList;
	}

}

