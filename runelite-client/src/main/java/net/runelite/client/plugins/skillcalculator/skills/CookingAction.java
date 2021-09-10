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

@AllArgsConstructor
@Getter
public enum CookingAction implements SkillAction
{
	SINEW("Sinew", 1, 3, ItemID.SINEW),
	SHRIMPS("Shrimps", 1, 30, ItemID.SHRIMPS),
	COOKED_CHICKEN("Cooked chicken", 1, 30, ItemID.COOKED_CHICKEN),
	COOKED_MEAT("Cooked meat", 1, 30, ItemID.COOKED_MEAT),
	COOKED_RABBIT("Cooked rabbit", 1, 30, ItemID.COOKED_RABBIT),
	ANCHOVIES("Anchovies", 1, 30, ItemID.ANCHOVIES),
	SARDINE("Sardine", 1, 40, ItemID.SARDINE),
	POISON_KARAMBWAN("Poison karambwan", 1, 80, ItemID.POISON_KARAMBWAN),
	UGTHANKI_MEAT("Ugthanki meat", 1, 40, ItemID.UGTHANKI_MEAT),
	BREAD("Bread", 1, 40, ItemID.BREAD),
	HERRING("Herring", 5, 50, ItemID.HERRING),
	FRUIT_BLAST("Fruit blast", 6, 50, ItemID.FRUIT_BLAST),
	BAKED_POTATO("Baked potato", 7, 15, ItemID.BAKED_POTATO),
	GUPPY("Guppy", 7, 12, ItemID.GUPPY),
	PINEAPPLE_PUNCH("Pineapple punch", 8, 70, ItemID.PINEAPPLE_PUNCH),
	SPICY_SAUCE("Spicy sauce", 9, 25, ItemID.SPICY_SAUCE),
	MACKEREL("Mackerel", 10, 60, ItemID.MACKEREL),
	REDBERRY_PIE("Redberry pie", 10, 78, ItemID.REDBERRY_PIE),
	TOAD_CRUNCHIES("Toad crunchies", 10, 100, ItemID.TOAD_CRUNCHIES),
	CHILLI_CON_CARNE("Chilli con carne", 11, 55, ItemID.CHILLI_CON_CARNE),
	ROAST_BIRD_MEAT("Roast bird meat", 11, 62.5f, ItemID.ROAST_BIRD_MEAT),
	THIN_SNAIL_MEAT("Thin snail meat", 12, 70, ItemID.THIN_SNAIL_MEAT),
	SPICY_CRUNCHIES("Spicy crunchies", 12, 100, ItemID.SPICY_CRUNCHIES),
	SCRAMBLED_EGG("Scrambled egg", 13, 50, ItemID.SCRAMBLED_EGG),
	CIDER("Cider", 14, 182, ItemID.CIDER),
	WORM_CRUNCHIES("Worm crunchies", 14, 104, ItemID.WORM_CRUNCHIES),
	TROUT("Trout", 15, 70, ItemID.TROUT),
	SPIDER_ON_STICK("Spider on stick", 16, 80, ItemID.SPIDER_ON_STICK),
	SPIDER_ON_SHAFT("Spider on shaft", 16, 80, ItemID.SPIDER_ON_SHAFT),
	ROAST_RABBIT("Roast rabbit", 16, 72.5f, ItemID.ROAST_RABBIT),
	CHOCCHIP_CRUNCHIES("Chocchip crunchies", 16, 100, ItemID.CHOCCHIP_CRUNCHIES),
	LEAN_SNAIL_MEAT("Lean snail meat", 17, 80, ItemID.LEAN_SNAIL_MEAT),
	COD("Cod", 18, 75, ItemID.COD),
	WIZARD_BLIZZARD("Wizard blizzard", 18, 110, ItemID.WIZARD_BLIZZARD),
	DWARVEN_STOUT("Dwarven stout", 19, 215, ItemID.DWARVEN_STOUT),
	SHORT_GREEN_GUY("Short green guy", 20, 120, ItemID.SHORT_GREEN_GUY),
	MEAT_PIE("Meat pie", 20, 110, ItemID.MEAT_PIE),
	PIKE("Pike", 20, 80, ItemID.PIKE),
	CUP_OF_TEA("Cup of tea", 20, 52, ItemID.CUP_OF_TEA),
	CAVEFISH("Cavefish", 20, 23, ItemID.CAVEFISH),
	ROAST_BEAST_MEAT("Roast beast meat", 21, 82.5f, ItemID.ROAST_BEAST_MEAT),
	COOKED_CRAB_MEAT("Cooked crab meat", 21, 100, ItemID.COOKED_CRAB_MEAT),
	POT_OF_CREAM("Pot of cream", 21, 18, ItemID.POT_OF_CREAM),
	FAT_SNAIL_MEAT("Fat snail meat", 22, 95, ItemID.FAT_SNAIL_MEAT),
	EGG_AND_TOMATO("Egg and tomato", 23, 50, ItemID.EGG_AND_TOMATO),
	ASGARNIAN_ALE("Asgarnian ale", 24, 248, ItemID.ASGARNIAN_ALE),
	SALMON("Salmon", 25, 90, ItemID.SALMON),
	STEW("Stew", 25, 117, ItemID.STEW),
	FRUIT_BATTA("Fruit batta", 25, 150, ItemID.FRUIT_BATTA),
	TOAD_BATTA("Toad batta", 26, 152, ItemID.TOAD_BATTA),
	WORM_BATTA("Worm batta", 27, 154, ItemID.WORM_BATTA),
	VEGETABLE_BATTA("Vegetable batta", 28, 156, ItemID.VEGETABLE_BATTA),
	SWEETCORN("Sweetcorn", 28, 104, ItemID.COOKED_SWEETCORN),
	COOKED_SLIMY_EEL("Cooked slimy eel", 28, 95, ItemID.COOKED_SLIMY_EEL),
	MUD_PIE("Mud pie", 29, 128, ItemID.MUD_PIE),
	GREENMANS_ALE("Greenman's ale", 29, 281, ItemID.GREENMANS_ALE),
	CHEESE_AND_TOMATO_BATTA("Cheese and tomato Batta", 29, 158, ItemID.CHEESETOM_BATTA),
	TUNA("Tuna", 30, 100, ItemID.TUNA),
	APPLE_PIE("Apple pie", 30, 130, ItemID.APPLE_PIE),
	WORM_HOLE("Worm hole", 30, 170, ItemID.WORM_HOLE),
	COOKED_KARAMBWAN("Cooked karambwan", 30, 190, ItemID.COOKED_KARAMBWAN),
	ROASTED_CHOMPY("Roasted chompy", 30, 100, ItemID.COOKED_CHOMPY),
	FISHCAKE("Fishcake", 31, 100, ItemID.COOKED_FISHCAKE),
	DRUNK_DRAGON("Drunk dragon", 32, 160, ItemID.DRUNK_DRAGON),
	CHOC_SATURDAY("Choc saturday", 33, 170, ItemID.CHOC_SATURDAY),
	TETRA("Tetra", 33, 31, ItemID.TETRA),
	GARDEN_PIE("Garden pie", 34, 138, ItemID.GARDEN_PIE),
	WIZARDS_MIND_BOMB("Wizard's mind bomb", 34, 314, ItemID.WIZARDS_MIND_BOMB),
	JUG_OF_WINE("Jug of wine", 35, 200, ItemID.JUG_OF_WINE),
	PLAIN_PIZZA("Plain pizza", 35, 143, ItemID.PLAIN_PIZZA),
	RAINBOW_FISH("Rainbow fish", 35, 110, ItemID.RAINBOW_FISH),
	VEG_BALL("Veg ball", 35, 175, ItemID.VEG_BALL),
	BLURBERRY_SPECIAL("Blurberry special", 37, 180, ItemID.BLURBERRY_SPECIAL),
	CAVE_EEL("Cave eel", 38, 115, ItemID.CAVE_EEL),
	PAT_OF_BUTTER("Pat of butter", 38, 40.5f, ItemID.PAT_OF_BUTTER),
	DRAGON_BITTER("Dragon bitter", 39, 347, ItemID.DRAGON_BITTER),
	POTATO_WITH_BUTTER("Potato with butter", 39, 40, ItemID.POTATO_WITH_BUTTER),
	LOBSTER("Lobster", 40, 120, ItemID.LOBSTER),
	CAKE("Cake", 40, 180, ItemID.CAKE),
	TANGLED_TOADS_LEGS("Tangled toad's legs", 40, 185, ItemID.TANGLED_TOADS_LEGS),
	CHILLI_POTATO("Chilli potato", 41, 165.5f, ItemID.CHILLI_POTATO),
	COOKED_JUBBLY("Cooked jubbly", 41, 160, ItemID.COOKED_JUBBLY),
	CHOCOLATE_BOMB("Chocolate bomb", 42, 190, ItemID.CHOCOLATE_BOMB),
	FRIED_ONIONS("Fried onions", 42, 60, ItemID.FRIED_ONIONS),
	BASS("Bass", 43, 130, ItemID.BASS),
	MOONLIGHT_MEAD("Moonlight mead", 44, 380, ItemID.MOONLIGHT_MEAD),
	SWORDFISH("Swordfish", 45, 140, ItemID.SWORDFISH),
	MEAT_PIZZA("Meat pizza", 45, 169, ItemID.MEAT_PIZZA),
	FRIED_MUSHROOMS("Fried mushrooms", 46, 60, ItemID.FRIED_MUSHROOMS),
	CATFISH("Catfish", 46, 43, ItemID.CATFISH),
	FISH_PIE("Fish pie", 47, 164, ItemID.FISH_PIE),
	POTATO_WITH_CHEESE("Potato with cheese", 47, 40, ItemID.POTATO_WITH_CHEESE),
	CHEESE("Cheese", 48, 64, ItemID.CHEESE),
	AXEMANS_FOLLY("Axeman's folly", 49, 413, ItemID.AXEMANS_FOLLY),
	COOKED_OOMLIE_WRAP("Cooked oomlie wrap", 50, 30, ItemID.COOKED_OOMLIE_WRAP),
	CHOCOLATE_CAKE("Chocolate cake", 50, 210, ItemID.CHOCOLATE_CAKE),
	EGG_POTATO("Egg potato", 51, 195.5f, ItemID.EGG_POTATO),
	BOTANICAL_PIE("Botanical pie", 52, 180, ItemID.BOTANICAL_PIE),
	LAVA_EEL("Lava eel", 53, 30, ItemID.LAVA_EEL),
	CHEFS_DELIGHT("Chef's Delight", 54, 446, ItemID.CHEFS_DELIGHT),
	ANCHOVY_PIZZA("Anchovy pizza", 55, 182, ItemID.ANCHOVY_PIZZA),
	MUSHROOM_AND_ONION("Mushroom & onion", 57, 120, ItemID.MUSHROOM__ONION),
	UGTHANKI_KEBAB_FRESH("Ugthanki kebab (Fresh)", 58, 80, ItemID.UGTHANKI_KEBAB),
	PITTA_BREAD("Pitta bread", 58, 40, ItemID.PITTA_BREAD),
	SLAYERS_RESPITE("Slayer's respite", 59, 479, ItemID.SLAYERS_RESPITE),
	CURRY("Curry", 60, 280, ItemID.CURRY),
	MUSHROOM_PIE("Mushroom pie", 60, 200, ItemID.MUSHROOM_PIE),
	MONKFISH("Monkfish", 62, 150, ItemID.MONKFISH),
	MUSHROOM_POTATO("Mushroom potato", 64, 270.5f, ItemID.MUSHROOM_POTATO),
	PINEAPPLE_PIZZA("Pineapple pizza", 65, 188, ItemID.PINEAPPLE_PIZZA),
	WINE_OF_ZAMORAK("Wine of zamorak", 65, 200, ItemID.WINE_OF_ZAMORAK),
	TUNA_AND_CORN("Tuna and corn", 67, 204, ItemID.TUNA_AND_CORN),
	TUNA_POTATO("Tuna potato", 68, 309.5f, ItemID.TUNA_POTATO),
	ADMIRAL_PIE("Admiral pie", 70, 210, ItemID.ADMIRAL_PIE),
	SACRED_EEL("Sacred eel", 72, 109, ItemID.SACRED_EEL),
	DRAGONFRUIT_PIE("Dragonfruit pie", 73, 220, ItemID.DRAGONFRUIT_PIE),
	SHARK("Shark", 80, 210, ItemID.SHARK),
	SEA_TURTLE("Sea turtle", 82, 211.3f, ItemID.SEA_TURTLE),
	ANGLERFISH("Anglerfish", 84, 230, ItemID.ANGLERFISH),
	WILD_PIE("Wild pie", 85, 240, ItemID.WILD_PIE),
	DARK_CRAB("Dark crab", 90, 215, ItemID.DARK_CRAB),
	MANTA_RAY("Manta ray", 91, 216.3f, ItemID.MANTA_RAY),
	SUMMER_PIE("Summer pie", 95, 260, ItemID.SUMMER_PIE),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
}
