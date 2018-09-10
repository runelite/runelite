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
import lombok.Setter;
import net.runelite.api.coords.WorldPoint;

@Getter
enum QuestStartLocation
{
	COOKS_ASSISTANT_RFD("Cook's Assistant", new WorldPoint(3211, 3216, 0), new int[][] {{1357, 1}, {1358, 69}}),
	THE_CORSAIR_CURSE("The Corsair Curse", new WorldPoint(3029, 3273, 0), new int[] {1357, 19}),
	DEMON_SLAYER("Demon Slayer", new WorldPoint(3204, 3424, 0), new int[] {1357, 2}),
	DORICS_QUEST("Doric's Quest", new WorldPoint(2952, 3450, 0), new int[] {1357, 3}),
	DRAGON_SLAYER("Dragon Slayer", new WorldPoint(3190, 3362, 0), new int[] {1357, 4}),
	ERNEST_THE_CHICKEN("Ernest the Chicken", new WorldPoint(3109, 3330, 0), new int[] {1357, 5}),
	GOBLIN_DIPLOMACY("Goblin Diplomacy", new WorldPoint(2957, 3509, 0), new int[] {1357, 6}),
	IMP_CATCHER("Imp Catcher", new WorldPoint(3108, 3160, 0), new int[] {1357, 7}),
	THE_KNIGHTS_SWORD("The Knight's Sword", new WorldPoint(2976, 3342, 0), new int[] {1357, 8}),
	MISTHALIN_MYSTERY("Misthalin Mystery", new WorldPoint(3234, 3155, 0), new int[] {1357, 18}),
	PIRATES_TREASURE("Pirate's Treasure", new WorldPoint(3050, 3248, 0), new int[] {1357, 9}),
	PRINCE_ALI_RESCUE("Prince Ali Rescue", new WorldPoint(3301, 3163, 0), new int[] {1357, 10}),
	THE_RESTLESS_GHOST("The Restless Ghost", new WorldPoint(3240, 3210, 0), new int[] {1357, 11}),
	RUNE_MYSTERIES("Rune Mysteries", new WorldPoint(3210, 3220, 0), new int[] {1357, 13}),
	SHEEP_SHEARER("Sheep Shearer", new WorldPoint(3190, 3272, 0), new int[] {1357, 14}),
	SHIELD_OF_ARRAV("Shield of Arrav", new WorldPoint(3208, 3495, 0), new int[] {1357, 15}),
	VAMPIRE_SLAYER("Vampire Slayer", new WorldPoint(3096, 3266, 0), new int[] {1357, 16}),
	WITCHS_POTION("Witch's Potion", new WorldPoint(2967, 3203, 0), new int[] {1357, 17}),
	ANIMAL_MAGNETISM("Animal Magnetism", new WorldPoint(3094, 3360, 0), new int[] {1358, 0}),
	ANOTHER_SLICE_OF_HAM("Another Slice of H.A.M.", new WorldPoint(2799, 5428, 0), new int[] {1358, 105}),
	BETWEEN_A_ROCK("Between a Rock...", new WorldPoint(2823, 10168, 0), new int[] {1358, 1}),
	BIG_CHOMPY_BIRD_HUNTING("Big Chompy Bird Hunting", new WorldPoint(2629, 2981, 0), new int[] {1358, 2}),
	BIOHAZARD("Biohazard", new WorldPoint(2591, 3335, 0), new int[] {1358, 3}),
	BONE_VOYAGE("Bone Voyage", new WorldPoint(3259, 3450, 0), new int[] {1358, 112}),
	CABIN_FEVER("Cabin Fever", new WorldPoint(3674, 3496, 0), new int[] {1358, 4}),
	CLIENT_OF_KOUREND("Client of Kourend", new WorldPoint(1823, 3690, 0), new int[] {1358, 110}),
	CLOCK_TOWER("Clock Tower", new WorldPoint(2568, 3249, 0), new int[] {1358, 5}),
	COLD_WAR("Cold War", new WorldPoint(2593, 3265, 0), new int[] {1358, 99}),
	CONTACT("Contact!", new WorldPoint(3280, 2770, 0), new int[] {1358, 6}),
	CREATURE_OF_FENKENSTRAIN("Creature of Fenkenstrain", new WorldPoint(3487, 3485, 0), new int[] {1358, 8}),
	DARKNESS_OF_HALLOWVALE("Darkness of Hallowvale", new WorldPoint(3494, 9628, 0), new int[] {1358, 9}),
	DEATH_PLATEAU_TROLL_STRONGHOLD("Death Plateau & Troll Stronghold", new WorldPoint(2895, 3528, 0), new int[][] {{1358, 11}, {1358, 95}}),
	DEATH_TO_THE_DORGESHUUN("Death to the Dorgeshuun", new WorldPoint(3316, 9613, 0), new int[] {1358, 10}),
	THE_DEPTHS_OF_DESPAIR("The Depths of Despair", new WorldPoint(1846, 3556, 0), new int[] {1358, 114}),
	DESERT_TREASURE("Desert Treasure", new WorldPoint(3177, 3043, 0), new int[] {1358, 12}),
	DEVIOUS_MINDS("Devious Minds", new WorldPoint(3405, 3492, 0), new int[] {1358, 13}),
	THE_DIG_SITE("The Dig Site", new WorldPoint(3363, 3337, 0), new int[] {1358, 14}),
	DRAGON_SLAYER_II("Dragon Slayer II", new WorldPoint(2456, 2868, 0), new int[] {1358, 115}),
	DREAM_MENTOR("Dream Mentor", new WorldPoint(2144, 10346, 0), new int[] {1358, 106}),
	DRUIDIC_RITUAL("Druidic Ritual", new WorldPoint(2916, 3484, 0), new int[] {1358, 15}),
	DWARF_CANNON("Dwarf Cannon", new WorldPoint(2466, 3461, 0), new int[] {1358, 16}),
	EADGARS_RUSE("Eadgar's Ruse", new WorldPoint(2896, 3426, 0), new int[] {1358, 17}),
	EAGLES_PEAK("Eagles' Peak", new WorldPoint(2605, 3264, 0), new int[] {1358, 18}),
	ELEMENTAL_WORKSHOP("Elemental Workshop I & II", new WorldPoint(2714, 3482, 0), new int[][] {{1358, 19}, {1358, 20}}),
	ENAKHRAS_LAMENT("Enakhra's Lament", new WorldPoint(3190, 2926, 0), new int[] {1358, 21}),
	ENLIGHTENED_JOURNEY("Enlightened Journey", new WorldPoint(2809, 3356, 0), new int[] {1358, 22}),
	THE_EYES_OF_GLOUPHRIE("The Eyes of Glouphrie", new WorldPoint(2400, 3419, 0), new int[] {1358, 23}),
	FAIRYTALE("Fairytale I & II", new WorldPoint(3077, 3258, 0), new int[][] {{1358, 24}, {1358, 25}}),
	FAMILY_CREST("Family Crest", new WorldPoint(3278, 3404, 0), new int[] {1358, 26}),
	THE_FEUD("The Feud", new WorldPoint(3301, 3211, 0), new int[] {1358, 27}),
	FIGHT_ARENA("Fight Arena", new WorldPoint(2565, 3199, 0), new int[] {1358, 28}),
	FISHING_CONTEST_1("Fishing Contest", new WorldPoint(2875, 3483, 0), new int[] {1358, 29}),
	FISHING_CONTEST_2("Fishing Contest", new WorldPoint(2820, 3487, 0), new int[] {1358, 29}),
	FORGETTABLE_TALE("Forgettable Tale...", new WorldPoint(2826, 10215, 0), new int[] {1358, 30}),
	THE_FREMENNIK_ISLES("The Fremennik Isles", new WorldPoint(2645, 3711, 0), new int[] {1358, 100}),
	THE_FREMENNIK_TRIALS("The Fremennik Trials", new WorldPoint(2657, 3669, 0), new int[] {1358, 31}),
	GARDEN_OF_TRANQUILLITY("Garden of Tranquillity", new WorldPoint(3227, 3477, 0), new int[] {1358, 33}),
	GERTRUDES_CAT_RATCATCHERS("Gertrude's Cat & Ratcatchers", new WorldPoint(3150, 3411, 0), new int[][] {{1358, 34}, {1358, 68}}),
	GHOSTS_AHOY("Ghosts Ahoy", new WorldPoint(3677, 3510, 0), new int[] {1358, 35}),
	THE_GIANT_DWARF("The Giant Dwarf", new WorldPoint(2841, 10129, 0), new int[] {1358, 36}),
	THE_GOLEM("The Golem", new WorldPoint(3487, 3089, 0), new int[] {1358, 37}),
	THE_GRAND_TREE_MONKEY_MADNESS("The Grand Tree & Monkey Madness I & II", new WorldPoint(2466, 3497, 0), new int[][] {{1358, 38}, {1358, 55}, {1358, 109}}),
	THE_GREAT_BRAIN_ROBBERY("The Great Brain Robbery", new WorldPoint(3681, 2963, 0), new int[] {1358, 102}),
	GRIM_TALES("Grim Tales", new WorldPoint(2890, 3454, 0), new int[] {1358, 107}),
	THE_HAND_IN_THE_SAND("The Hand in the Sand", new WorldPoint(2552, 3101, 0), new int[] {1358, 39}),
	HAUNTED_MINE("Haunted Mine", new WorldPoint(3443, 3258, 0), new int[] {1358, 40}),
	HAZEEL_CULT("Hazeel Cult", new WorldPoint(2565, 3271, 0), new int[] {1358, 41}),
	HEROES_QUEST("Heroes' Quest", new WorldPoint(2903, 3511, 0), new int[] {1358, 42}),
	HOLY_GRAIL("Holy Grail & Merlin's Crystal", new WorldPoint(2763, 3515, 0), new int[][] {{1358, 54}, {1358, 43}}),
	HORROR_FROM_THE_DEEP("Horror from the Deep", new WorldPoint(2507, 3635, 0), new int[] {1358, 44}),
	ICTHLARINS_LITTLE_HELPER("Icthlarin's Little Helper", new WorldPoint(3314, 2849, 0), new int[] {1358, 45}),
	IN_SEARCH_OF_THE_MYREQUE("In Search of the Myreque", new WorldPoint(3502, 3477, 0), new int[] {1358, 47}),
	JUNGLE_POTION("Jungle Potion", new WorldPoint(2809, 3086, 0), new int[] {1358, 48}),
	KINGS_RANSOM("King's Ransom", new WorldPoint(2741, 3554, 0), new int[] {1358, 108}),
	LEGENDS_QUEST("Legends' Quest", new WorldPoint(2725, 3367, 0), new int[] {1358, 49}),
	LOST_CITY("Lost City", new WorldPoint(3149, 3205, 0), new int[] {1358, 50}),
	THE_LOST_TRIBE("The Lost Tribe", new WorldPoint(3211, 3224, 0), new int[] {1358, 51}),
	LUNAR_DIPLOMACY("Lunar Diplomacy", new WorldPoint(2619, 3689, 0), new int[] {1358, 52}),
	MAKING_FRIENDS_WITH_MY_ARM("Making Friends with My Arm", new WorldPoint(2904, 10092, 0), new int[] {1358, 118}),
	MAKING_HISTORY("Making History", new WorldPoint(2435, 3346, 0), new int[] {1358, 53}),
	MONKS_FRIEND("Monk's Friend", new WorldPoint(2605, 3209, 0), new int[] {1358, 56}),
	MOUNTAIN_DAUGHTER("Mountain Daughter", new WorldPoint(2810, 3672, 0), new int[] {1358, 57}),
	MOURNINGS_ENDS_PART_I("Mourning's Ends Part I", new WorldPoint(2289, 3149, 0), new int[] {1358, 58}),
	MOURNINGS_ENDS_PART_II("Mourning's Ends Part II", new WorldPoint(2352, 3172, 0), new int[] {1358, 59}),
	MURDER_MYSTERY("Murder Mystery", new WorldPoint(2740, 3562, 0), new int[] {1358, 60}),
	MY_ARMS_BIG_ADVENTURE("My Arm's Big Adventure", new WorldPoint(2908, 10088, 0), new int[] {1358, 61}),
	NATURE_SPIRIT("Nature Spirit", new WorldPoint(3440, 9894, 0), new int[] {1358, 62}),
	OBSERVATORY_QUEST("Observatory Quest", new WorldPoint(2438, 3185, 0), new int[] {1358, 63}),
	OLAFS_QUEST("Olaf's Quest", new WorldPoint(2723, 3729, 0), new int[] {1358, 104}),
	ONE_SMALL_FAVOUR("One Small Favour", new WorldPoint(2834, 2985, 0), new int[] {1358, 64}),
	PLAGUE_CITY("Plague City", new WorldPoint(2567, 3334, 0), new int[] {1358, 65}),
	PRIEST_IN_PERIL("Priest in Peril", new WorldPoint(3219, 3473, 0), new int[] {1358, 66}),
	THE_QUEEN_OF_THIEVES("The Queen of Thieves", new WorldPoint(1795, 3782, 0), new int[] {1358, 113}),
	RAG_AND_BONE_MAN("Rag and Bone Man I & II", new WorldPoint(3359, 3504, 0), new int[][] {{1358, 67}, {1358, 111}}),
	RECRUITMENT_DRIVE_BLACK_KNIGHTS_FORTRESS("Recruitment Drive & Black Knights' Fortress", new WorldPoint(2959, 3336, 0), new int[][] {{1358, 70}, {1357, 0}}),
	ROVING_ELVES("Roving Elves", new WorldPoint(2289, 3146, 0), new int[] {1358, 72}),
	RUM_DEAL("Rum Deal", new WorldPoint(3679, 3535, 0), new int[] {1358, 74}),
	SCORPION_CATCHER("Scorpion Catcher", new WorldPoint(2701, 3399, 0), new int[] {1358, 75}),
	SEA_SLUG("Sea Slug", new WorldPoint(2715, 3302, 0), new int[] {1358, 76}),
	SHADES_OF_MORTTON("Shades of Mort'ton", new WorldPoint(3463, 3308, 0), new int[] {1358, 78}),
	SHADOW_OF_THE_STORM("Shadow of the Storm", new WorldPoint(3270, 3159, 0), new int[] {1358, 79}),
	SHEEP_HERDER("Sheep Herder", new WorldPoint(2616, 3299, 0), new int[] {1358, 80}),
	SHILO_VILLAGE("Shilo Village", new WorldPoint(2882, 2951, 0), new int[] {1358, 81}),
	A_SOULS_BANE("A Soul's Bane", new WorldPoint(3307, 3454, 0), new int[] {1358, 82}),
	SPIRITS_OF_THE_ELID("Spirits of the Elid", new WorldPoint(3441, 2911, 0), new int[] {1358, 83}),
	SWAN_SONG("Swan Song", new WorldPoint(2345, 3652, 0), new int[] {1358, 84}),
	TAI_BWO_WANNAI_TRIO("Tai Bwo Wannai Trio", new WorldPoint(2779, 3087, 0), new int[] {1358, 85}),
	A_TAIL_OF_TWO_CATS("A Tail of Two Cats", new WorldPoint(2917, 3557, 0), new int[] {1358, 86}),
	TALE_OF_THE_RIGHTEOUS("Tale of the Righteous", new WorldPoint(1511, 3631, 0), new int[] {1358, 116}),
	A_TASTE_OF_HOPE("A Taste of Hope", new WorldPoint(3668, 3216, 0), new int[] {1358, 117}),
	TEARS_OF_GUTHIX("Tears of Guthix", new WorldPoint(3251, 9517, 0), new int[] {1358, 87}),
	TEMPLE_OF_IKOV("Temple of Ikov", new WorldPoint(2574, 3320, 0), new int[] {1358, 88}),
	THRONE_OF_MISCELLANIA_ROYAL_TROUBLE("Throne of Miscellania & Royal Trouble", new WorldPoint(2497, 3859, 0), new int[][] {{1358, 89}, {1358, 73}}),
	THE_TOURIST_TRAP("The Tourist Trap", new WorldPoint(3302, 3113, 0), new int[] {1358, 90}),
	TOWER_OF_LIFE("Tower of Life", new WorldPoint(2640, 3218, 0), new int[] {1358, 101}),
	TREE_GNOME_VILLAGE("Tree Gnome Village", new WorldPoint(2541, 3169, 0), new int[] {1358, 92}),
	TRIBAL_TOTEM("Tribal Totem", new WorldPoint(2790, 3182, 0), new int[] {1358, 93}),
	TROLL_ROMANCE("Troll Romance", new WorldPoint(2890, 10097, 0), new int[] {1358, 94}),
	UNDERGROUND_PASS_REGICIDE("Underground Pass & Regicide", new WorldPoint(2575, 3293, 0), new int[][] {{1358, 96}, {1358, 71}}),
	WANTED_SLUG_MENACE("Wanted! & The Slug Menace", new WorldPoint(2996, 3373, 0), new int[][] {{1358, 97}, {1358, 77}}),
	WATCHTOWER("Watchtower", new WorldPoint(2545, 3112, 0), new int[] {1358, 98}),
	WATERFALL_QUEST("Waterfall Quest", new WorldPoint(2521, 3498, 0), new int[] {1358, 32}),
	WHAT_LIES_BELOW("What Lies Below", new WorldPoint(3265, 3333, 0), new int[] {1358, 103}),
	WITCHS_HOUSE("Witch's House", new WorldPoint(2927, 3456, 0), new int[] {1358, 91}),
	ZOGRE_FLESH_EATERS("Zogre Flesh Eaters", new WorldPoint(2442, 3051, 0), new int[] {1358, 7});

	private final String tooltip;
	private final WorldPoint location;
	@Setter
	private boolean complete;
	private final int[][] quests;

	QuestStartLocation(String description, WorldPoint location, int[][] quests)
	{
		this.tooltip = "Quest Start - " + description;
		this.location = location;
		this.quests = quests;
		this.complete = true;
	}

	QuestStartLocation(String description, WorldPoint location, int[] quest)
	{
		this(description, location, new int[][] {quest});
	}
}
