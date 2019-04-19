/*
 * Copyright (c) 2018, John James Hamilton <https://github.com/johnhamilto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.worldmap;

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

enum QuestStartLocation
{
	//Free Quests
	COOKS_ASSISTANT_RFD("Cook's Assistant", new WorldPoint(3211, 3216, 0)),
	THE_CORSAIR_CURSE("The Corsair Curse", new WorldPoint(3029, 3273, 0)),
	DEMON_SLAYER("Demon Slayer", new WorldPoint(3204, 3424, 0)),
	DORICS_QUEST("Doric's Quest", new WorldPoint(2952, 3450, 0)),
	DRAGON_SLAYER("Dragon Slayer", new WorldPoint(3190, 3362, 0)),
	ERNEST_THE_CHICKEN("Ernest the Chicken", new WorldPoint(3109, 3330, 0)),
	GOBLIN_DIPLOMACY("Goblin Diplomacy", new WorldPoint(2957, 3509, 0)),
	IMP_CATCHER("Imp Catcher", new WorldPoint(3108, 3160, 0)),
	THE_KNIGHTS_SWORD("The Knight's Sword", new WorldPoint(2976, 3342, 0)),
	MISTHALIN_MYSTERY("Misthalin Mystery", new WorldPoint(3234, 3155, 0)),
	PIRATES_TREASURE("Pirate's Treasure", new WorldPoint(3050, 3248, 0)),
	PRINCE_ALI_RESCUE("Prince Ali Rescue", new WorldPoint(3301, 3163, 0)),
	THE_RESTLESS_GHOST("The Restless Ghost", new WorldPoint(3240, 3210, 0)),
	RUNE_MYSTERIES("Rune Mysteries", new WorldPoint(3210, 3220, 0)),
	SHEEP_SHEARER("Sheep Shearer", new WorldPoint(3190, 3272, 0)),
	SHIELD_OF_ARRAV_PHOENIX_GANG("Shield of Arrav (Phoenix Gang)", new WorldPoint(3208, 3495, 0)),
	SHIELD_OF_ARRAV_BLACK_ARM_GANG("Shield of Arrav (Black Arm Gang)", new WorldPoint(3208, 3392, 0)),
	VAMPIRE_SLAYER("Vampire Slayer", new WorldPoint(3096, 3266, 0)),
	WITCHS_POTION("Witch's Potion", new WorldPoint(2967, 3203, 0)),
	X_MARKS_THE_SPOT("X Marks the Spot", new WorldPoint(3227, 3242, 0)),

	//Members' Quests
	ANIMAL_MAGNETISM("Animal Magnetism", new WorldPoint(3094, 3360, 0)),
	ANOTHER_SLICE_OF_HAM("Another Slice of H.A.M.", new WorldPoint(2799, 5428, 0)),
	THE_ASCENT_OF_ARCEUUS("The Ascent of Arceuus", new WorldPoint(1700, 3742, 0)),
	BETWEEN_A_ROCK("Between a Rock...", new WorldPoint(2823, 10168, 0)),
	BIG_CHOMPY_BIRD_HUNTING("Big Chompy Bird Hunting", new WorldPoint(2629, 2981, 0)),
	BIOHAZARD("Biohazard", new WorldPoint(2591, 3335, 0)),
	BONE_VOYAGE("Bone Voyage", new WorldPoint(3259, 3450, 0)),
	CABIN_FEVER("Cabin Fever", new WorldPoint(3674, 3496, 0)),
	CLIENT_OF_KOUREND("Client of Kourend", new WorldPoint(1823, 3690, 0)),
	CLOCK_TOWER("Clock Tower", new WorldPoint(2568, 3249, 0)),
	COLD_WAR("Cold War", new WorldPoint(2593, 3265, 0)),
	CONTACT("Contact!", new WorldPoint(3280, 2770, 0)),
	CREATURE_OF_FENKENSTRAIN("Creature of Fenkenstrain", new WorldPoint(3487, 3485, 0)),
	DARKNESS_OF_HALLOWVALE("Darkness of Hallowvale", new WorldPoint(3494, 9628, 0)),
	DEATH_PLATEAU_TROLL_STRONGHOLD("Death Plateau & Troll Stronghold", new WorldPoint(2895, 3528, 0)),
	DEATH_TO_THE_DORGESHUUN("Death to the Dorgeshuun", new WorldPoint(3316, 9613, 0)),
	THE_DEPTHS_OF_DESPAIR("The Depths of Despair", new WorldPoint(1846, 3556, 0)),
	DESERT_TREASURE("Desert Treasure", new WorldPoint(3177, 3043, 0)),
	DEVIOUS_MINDS("Devious Minds", new WorldPoint(3405, 3492, 0)),
	THE_DIG_SITE("The Dig Site", new WorldPoint(3363, 3337, 0)),
	DRAGON_SLAYER_II("Dragon Slayer II", new WorldPoint(2456, 2868, 0)),
	DREAM_MENTOR("Dream Mentor", new WorldPoint(2144, 10346, 0)),
	DRUIDIC_RITUAL("Druidic Ritual", new WorldPoint(2916, 3484, 0)),
	DWARF_CANNON("Dwarf Cannon", new WorldPoint(2566, 3461, 0)),
	EADGARS_RUSE("Eadgar's Ruse", new WorldPoint(2896, 3426, 0)),
	EAGLES_PEAK("Eagles' Peak", new WorldPoint(2605, 3264, 0)),
	ELEMENTAL_WORKSHOP("Elemental Workshop I & II", new WorldPoint(2714, 3482, 0)),
	ENAKHRAS_LAMENT("Enakhra's Lament", new WorldPoint(3190, 2926, 0)),
	ENLIGHTENED_JOURNEY("Enlightened Journey", new WorldPoint(2809, 3356, 0)),
	THE_EYES_OF_GLOUPHRIE("The Eyes of Glouphrie", new WorldPoint(2400, 3419, 0)),
	FAIRYTALE("Fairytale I & II", new WorldPoint(3077, 3258, 0)),
	FAMILY_CREST("Family Crest", new WorldPoint(3278, 3404, 0)),
	THE_FEUD("The Feud", new WorldPoint(3301, 3211, 0)),
	FIGHT_ARENA("Fight Arena", new WorldPoint(2565, 3199, 0)),
	FISHING_CONTEST_1("Fishing Contest", new WorldPoint(2875, 3483, 0)),
	FISHING_CONTEST_2("Fishing Contest", new WorldPoint(2820, 3487, 0)),
	FORGETTABLE_TALE("Forgettable Tale...", new WorldPoint(2826, 10215, 0)),
	THE_FORSAKEN_TOWER("The Forsaken Tower", new WorldPoint(1484, 3747, 0)),
	THE_FREMENNIK_ISLES("The Fremennik Isles", new WorldPoint(2645, 3711, 0)),
	THE_FREMENNIK_TRIALS("The Fremennik Trials", new WorldPoint(2657, 3669, 0)),
	GARDEN_OF_TRANQUILLITY("Garden of Tranquillity", new WorldPoint(3227, 3477, 0)),
	GERTRUDES_CAT_RATCATCHERS("Gertrude's Cat & Ratcatchers", new WorldPoint(3150, 3411, 0)),
	GHOSTS_AHOY("Ghosts Ahoy", new WorldPoint(3677, 3510, 0)),
	THE_GIANT_DWARF("The Giant Dwarf", new WorldPoint(2841, 10129, 0)),
	THE_GOLEM("The Golem", new WorldPoint(3487, 3089, 0)),
	THE_GRAND_TREE_MONKEY_MADNESS("The Grand Tree & Monkey Madness I & II", new WorldPoint(2466, 3497, 0)),
	THE_GREAT_BRAIN_ROBBERY("The Great Brain Robbery", new WorldPoint(3681, 2963, 0)),
	GRIM_TALES("Grim Tales", new WorldPoint(2890, 3454, 0)),
	THE_HAND_IN_THE_SAND("The Hand in the Sand", new WorldPoint(2552, 3101, 0)),
	HAUNTED_MINE("Haunted Mine", new WorldPoint(3443, 3258, 0)),
	HAZEEL_CULT("Hazeel Cult", new WorldPoint(2565, 3271, 0)),
	HEROES_QUEST("Heroes' Quest", new WorldPoint(2903, 3511, 0)),
	HOLY_GRAIL("Holy Grail & Merlin's Crystal", new WorldPoint(2763, 3515, 0)),
	HORROR_FROM_THE_DEEP("Horror from the Deep", new WorldPoint(2507, 3635, 0)),
	ICTHLARINS_LITTLE_HELPER("Icthlarin's Little Helper", new WorldPoint(3314, 2849, 0)),
	IN_SEARCH_OF_THE_MYREQUE("In Search of the Myreque", new WorldPoint(3502, 3477, 0)),
	JUNGLE_POTION("Jungle Potion", new WorldPoint(2809, 3086, 0)),
	KINGS_RANSOM("King's Ransom", new WorldPoint(2741, 3554, 0)),
	LEGENDS_QUEST("Legends' Quest", new WorldPoint(2725, 3367, 0)),
	LOST_CITY("Lost City", new WorldPoint(3149, 3205, 0)),
	THE_LOST_TRIBE("The Lost Tribe", new WorldPoint(3211, 3224, 0)),
	LUNAR_DIPLOMACY("Lunar Diplomacy", new WorldPoint(2619, 3689, 0)),
	MAKING_FRIENDS_WITH_MY_ARM("Making Friends with My Arm", new WorldPoint(2904, 10092, 0)),
	MAKING_HISTORY("Making History", new WorldPoint(2435, 3346, 0)),
	MONKS_FRIEND("Monk's Friend", new WorldPoint(2605, 3209, 0)),
	MOUNTAIN_DAUGHTER("Mountain Daughter", new WorldPoint(2810, 3672, 0)),
	MOURNINGS_ENDS_PART_I("Mourning's Ends Part I", new WorldPoint(2289, 3149, 0)),
	MOURNINGS_ENDS_PART_II("Mourning's Ends Part II", new WorldPoint(2352, 3172, 0)),
	MURDER_MYSTERY("Murder Mystery", new WorldPoint(2740, 3562, 0)),
	MY_ARMS_BIG_ADVENTURE("My Arm's Big Adventure", new WorldPoint(2908, 10088, 0)),
	NATURE_SPIRIT("Nature Spirit", new WorldPoint(3440, 9894, 0)),
	OBSERVATORY_QUEST("Observatory Quest", new WorldPoint(2438, 3185, 0)),
	OLAFS_QUEST("Olaf's Quest", new WorldPoint(2723, 3729, 0)),
	ONE_SMALL_FAVOUR("One Small Favour", new WorldPoint(2834, 2985, 0)),
	PLAGUE_CITY("Plague City", new WorldPoint(2567, 3334, 0)),
	PRIEST_IN_PERIL("Priest in Peril", new WorldPoint(3219, 3473, 0)),
	THE_QUEEN_OF_THIEVES("The Queen of Thieves", new WorldPoint(1795, 3782, 0)),
	RAG_AND_BONE_MAN("Rag and Bone Man I & II", new WorldPoint(3359, 3504, 0)),
	RECRUITMENT_DRIVE_BLACK_KNIGHTS_FORTRESS("Recruitment Drive & Black Knights' Fortress", new WorldPoint(2959, 3336, 0)),
	ROVING_ELVES("Roving Elves", new WorldPoint(2289, 3146, 0)),
	RUM_DEAL("Rum Deal", new WorldPoint(3679, 3535, 0)),
	SCORPION_CATCHER("Scorpion Catcher", new WorldPoint(2701, 3399, 0)),
	SEA_SLUG("Sea Slug", new WorldPoint(2715, 3302, 0)),
	SHADES_OF_MORTTON("Shades of Mort'ton", new WorldPoint(3463, 3308, 0)),
	SHADOW_OF_THE_STORM("Shadow of the Storm", new WorldPoint(3270, 3159, 0)),
	SHEEP_HERDER("Sheep Herder", new WorldPoint(2616, 3299, 0)),
	SHILO_VILLAGE("Shilo Village", new WorldPoint(2882, 2951, 0)),
	A_SOULS_BANE("A Soul's Bane", new WorldPoint(3307, 3454, 0)),
	SPIRITS_OF_THE_ELID("Spirits of the Elid", new WorldPoint(3441, 2911, 0)),
	SWAN_SONG("Swan Song", new WorldPoint(2345, 3652, 0)),
	TAI_BWO_WANNAI_TRIO("Tai Bwo Wannai Trio", new WorldPoint(2779, 3087, 0)),
	A_TAIL_OF_TWO_CATS("A Tail of Two Cats", new WorldPoint(2917, 3557, 0)),
	TALE_OF_THE_RIGHTEOUS("Tale of the Righteous", new WorldPoint(1511, 3631, 0)),
	A_TASTE_OF_HOPE("A Taste of Hope", new WorldPoint(3668, 3216, 0)),
	TEARS_OF_GUTHIX("Tears of Guthix", new WorldPoint(3251, 9517, 0)),
	TEMPLE_OF_IKOV("Temple of Ikov", new WorldPoint(2574, 3320, 0)),
	THRONE_OF_MISCELLANIA_ROYAL_TROUBLE("Throne of Miscellania & Royal Trouble", new WorldPoint(2497, 3859, 0)),
	THE_TOURIST_TRAP("The Tourist Trap", new WorldPoint(3302, 3113, 0)),
	TOWER_OF_LIFE("Tower of Life", new WorldPoint(2640, 3218, 0)),
	TREE_GNOME_VILLAGE("Tree Gnome Village", new WorldPoint(2541, 3169, 0)),
	TRIBAL_TOTEM("Tribal Totem", new WorldPoint(2790, 3182, 0)),
	TROLL_ROMANCE("Troll Romance", new WorldPoint(2890, 10097, 0)),
	UNDERGROUND_PASS_REGICIDE("Underground Pass & Regicide", new WorldPoint(2575, 3293, 0)),
	WANTED_SLUG_MENACE("Wanted! & The Slug Menace", new WorldPoint(2996, 3373, 0)),
	WATCHTOWER("Watchtower", new WorldPoint(2545, 3112, 0)),
	WATERFALL_QUEST("Waterfall Quest", new WorldPoint(2521, 3498, 0)),
	WHAT_LIES_BELOW("What Lies Below", new WorldPoint(3265, 3333, 0)),
	WITCHS_HOUSE("Witch's House", new WorldPoint(2927, 3456, 0)),
	ZOGRE_FLESH_EATERS("Zogre Flesh Eaters", new WorldPoint(2442, 3051, 0));

	@Getter
	private final String tooltip;

	@Getter
	private final WorldPoint location;

	QuestStartLocation(String description, WorldPoint location)
	{
		this.tooltip = "Quest Start - " + description;
		this.location = location;
	}
}
