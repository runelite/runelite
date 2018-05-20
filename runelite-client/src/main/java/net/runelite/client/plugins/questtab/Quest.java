/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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
package net.runelite.client.plugins.questtab;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Quest
{
	A_SOULS_BANE("A Soul's Bane", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	A_TAIL_OF_TWO_CATS("A Tail of Two Cats", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 2, new QuestRequirement()),
	ALFRED_GRIMHANDS_BARCRAWL("Alfred Grimhand's Barcrawl", QuestType.MINIQUEST, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 0, new QuestRequirement()),
	ANIMAL_MAGNETISM("Animal Magnetism", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	ANOTHER_SLICE_OF_HAM("Another Slice of H.A.M.", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	ARCHITECTURAL_ALLIANCE("Architectural Alliance", QuestType.MINIQUEST, QuestDifficulty.EXPERIENCED, QuestLength.VERY_LONG, 0, new QuestRequirement()),
	BEAR_YOUR_SOUL("Bear your Soul", QuestType.MINIQUEST, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 0, new QuestRequirement()),
	BETWEEN_A_ROCK("Between a Rock...", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 2, new QuestRequirement()),
	BIG_CHOMPY_BIRD_HUNTING("Big Chompy Bird Hunting", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.SHORT, 2, new QuestRequirement()),
	BIOHAZARD("Biohazard", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 3, new QuestRequirement()),
	BLACK_KNIGHTS_FORTRESS("Black Knights' Fortress", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 3, new QuestRequirement()),
	BONE_VOYAGE("Bone Voyage", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.SHORT, 1, new QuestRequirement()),
	CABIN_FEVER("Cabin Fever", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 2, new QuestRequirement()),
	CLIENT_OF_KOUREND("Client of Kourend", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	CLOCK_TOWER("Clock Tower", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	COLD_WAR("Cold War", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 1, new QuestRequirement()),
	CONTACT("Contact!", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.MEDIUM, 1, new QuestRequirement()),
	COOKS_ASSISTANT("Cook's Assistant", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	CREATURE_OF_FENKENSTRAIN("Creature of Fenkenstrain", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	CURSE_OF_THE_EMPTY_LORD("Curse of the Empty Lord", QuestType.MINIQUEST, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 0, new QuestRequirement()),
	DARKNESS_OF_HALLOWVALE("Darkness of Hallowvale", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.VERY_LONG, 2, new QuestRequirement()),
	DEATH_PLATEAU("Death Plateau", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	DEATH_TO_THE_DORGESHUUN("Death to the Dorgeshuun", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	DEMON_SLAYER("Demon Slayer", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 3, new QuestRequirement()),
	DESERT_TREASURE("Desert Treasure", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.LONG, 3, new QuestRequirement()),
	DEVIOUS_MINDS("Devious Minds", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.SHORT, 1, new QuestRequirement()),
	DORICS_QUEST("Doric's Quest", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	DRAGON_SLAYER("Dragon Slayer", QuestType.FREE, QuestDifficulty.EXPERIENCED, QuestLength.LONG, 2, new QuestRequirement()),
	DRAGON_SLAYER_II("Dragon Slayer II", QuestType.MEMBERS, QuestDifficulty.GRANDMASTER, QuestLength.VERY_LONG, 5, new QuestRequirement()),
	DREAM_MENTOR("Dream Mentor", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.MEDIUM, 2, new QuestRequirement()),
	DRUIDIC_RITUAL("Druidic Ritual", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 4, new QuestRequirement()),
	DWARF_CANNON("Dwarf Cannon", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	EADGARS_RUSE("Eadgar's Ruse", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.LONG, 1, new QuestRequirement()),
	EAGLES_PEAK("Eagles' Peak", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	ELEMENTAL_WORKSHOP_I("Elemental Workshop I", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	ELEMENTAL_WORKSHOP_II("Elemental Workshop II", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	ENAKHRAS_LAMENT("Enakhra's Lament", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 2, new QuestRequirement()),
	ENCHANTED_KEY("Enchanted Key", QuestType.MINIQUEST, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 0, new QuestRequirement()),
	ENLIGHTENED_JOURNEY("Enlightened Journey", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	ENTER_THE_ABYSS("Enter the Abyss", QuestType.MINIQUEST, QuestDifficulty.NOVICE, QuestLength.SHORT, 0, new QuestRequirement()),
	ERNEST_THE_CHICKEN("Ernest the Chicken", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 4, new QuestRequirement()),
	FAIRYTALE_I_GROWING_PAINS("Fairytale I - Growing Pains", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.LONG, 2, new QuestRequirement()),
	FAIRYTALE_II_CURE_A_QUEEN("Fairytale II - Cure a Queen", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 2, new QuestRequirement()),
	FAMILY_CREST("Family Crest", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 1, new QuestRequirement()),
	FAMILY_PEST("Family Pest", QuestType.MINIQUEST, QuestDifficulty.NOVICE, QuestLength.SHORT, 0, new QuestRequirement()),
	FIGHT_ARENA("Fight Arena", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.SHORT, 2, new QuestRequirement()),
	FISHING_CONTEST("Fishing Contest", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	FORGETTABLE_TALE("Forgettable Tale...", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 2, new QuestRequirement()),
	GARDEN_OF_TRANQUILLITY("Garden of Tranquillity", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 2, new QuestRequirement()),
	GERTRUDES_CAT("Gertrude's Cat", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	GHOSTS_AHOY("Ghosts Ahoy", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 2, new QuestRequirement()),
	GOBLIN_DIPLOMACY("Goblin Diplomacy", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 5, new QuestRequirement()),
	GRIM_TALES("Grim Tales", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.MEDIUM, 1, new QuestRequirement()),
	HAUNTED_MINE("Haunted Mine", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.LONG, 2, new QuestRequirement()),
	HAZEEL_CULT("Hazeel Cult", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	HEROES_QUEST("Heroes' Quest", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 1, new QuestRequirement()),
	HOLY_GRAIL("Holy Grail", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	HORROR_FROM_THE_DEEP("Horror from the Deep", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.SHORT, 2, new QuestRequirement()),
	ICTHLARINS_LITTLE_HELPER("Icthlarin's Little Helper", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 2, new QuestRequirement()),
	IMP_CATCHER("Imp Catcher", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	IN_AID_OF_THE_MYREQUE("In Aid of the Myreque", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 2, new QuestRequirement()),
	IN_SEARCH_OF_THE_MYREQUE("In Search of the Myreque", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.SHORT, 2, new QuestRequirement()),
	JUNGLE_POTION("Jungle Potion", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	KINGS_RANSOM("King's Ransom", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 1, new QuestRequirement()),
	LAIR_OF_TARN_RAZORLOR("Lair of Tarn Razorlor", QuestType.MINIQUEST, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 0, new QuestRequirement()),
	LEGENDS_QUEST("Legends' Quest", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.VERY_LONG, 4, new QuestRequirement()),
	LOST_CITY("Lost City", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.SHORT, 3, new QuestRequirement()),
	LUNAR_DIPLOMACY("Lunar Diplomacy", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.LONG, 2, new QuestRequirement()),
	MAKING_HISTORY("Making History", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 3, new QuestRequirement()),
	MERLINS_CRYSTAL("Merlin's Crystal", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 6, new QuestRequirement()),
	MISTHALIN_MYSTERY("Misthalin Mystery", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	MONKEY_MADNESS_I("Monkey Madness I", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.LONG, 3, new QuestRequirement()),
	MONKEY_MADNESS_II("Monkey Madness II", QuestType.MEMBERS, QuestDifficulty.GRANDMASTER, QuestLength.VERY_LONG, 4, new QuestRequirement()),
	MONKS_FRIEND("Monk's Friend", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	MOUNTAIN_DAUGHTER("Mountain Daughter", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	MOURNINGS_ENDS_PART_I("Mourning's Ends Part I", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.LONG, 2, new QuestRequirement()),
	MOURNINGS_ENDS_PART_II("Mourning's Ends Part II", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.VERY_LONG, 2, new QuestRequirement()),
	MURDER_MYSTERY("Murder Mystery", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 3, new QuestRequirement()),
	MY_ARMS_BIG_ADVENTURE("My Arm's Big Adventure", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	NATURE_SPIRIT("Nature Spirit", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	OBSERVATORY_QUEST("Observatory Quest", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	OLAFS_QUEST("Olaf's Quest", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	ONE_SMALL_FAVOUR("One Small Favour", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.LONG, 2, new QuestRequirement()),
	PIRATES_TREASURE("Pirate's Treasure", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 2, new QuestRequirement()),
	PLAGUE_CITY("Plague City", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	PRIEST_IN_PERIL("Priest in Peril", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	PRINCE_ALI_RESCUE("Prince Ali Rescue", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 3, new QuestRequirement()),
	RAG_AND_BONE_MAN("Rag and Bone Man", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	RAG_AND_BONE_MAN_II("Rag and Bone Man II", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 1, new QuestRequirement()),
	RATCATCHERS("Ratcatchers", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 2, new QuestRequirement()),
	RECIPE_FOR_DISASTER("Recipe for Disaster", QuestType.MEMBERS, QuestDifficulty.GRANDMASTER, QuestLength.VERY_LONG, 10, new QuestRequirement()),
	RECRUITMENT_DRIVE("Recruitment Drive", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	REGICIDE("Regicide", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.LONG, 3, new QuestRequirement()),
	ROMEO_AND_JULIET("Romeo & Juliet", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 5, new QuestRequirement()),
	ROVING_ELVES("Roving Elves", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.MEDIUM, 1, new QuestRequirement()),
	ROYAL_TROUBLE("Royal Trouble", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 1, new QuestRequirement()),
	RUM_DEAL("Rum Deal", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 2, new QuestRequirement()),
	RUNE_MYSTERIES("Rune Mysteries", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	SCORPION_CATCHER("Scorpion Catcher", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.SHORT, 1, new QuestRequirement()),
	SEA_SLUG("Sea Slug", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.SHORT, 1, new QuestRequirement()),
	SHADES_OF_MORTTON("Shades of Mort'ton", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.SHORT, 3, new QuestRequirement()),
	SHADOW_OF_THE_STORM("Shadow of the Storm", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	SHEEP_HERDER("Sheep Herder", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 4, new QuestRequirement()),
	SHEEP_SHEARER("Sheep Shearer", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	SHIELD_OF_ARRAV("Shield of Arrav", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	SHILO_VILLAGE("Shilo Village", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.LONG, 2, new QuestRequirement()),
	SKIPPY_AND_THE_MOGRES("Skippy and the Mogres", QuestType.MINIQUEST, QuestDifficulty.NOVICE, QuestLength.SHORT, 0, new QuestRequirement()),
	SPIRITS_OF_THE_ELID("Spirits of the Elid", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	SWAN_SONG("Swan Song", QuestType.MEMBERS, QuestDifficulty.MASTER, QuestLength.MEDIUM, 2, new QuestRequirement()),
	TAI_BWO_WANNAI_TRIO("Tai Bwo Wannai Trio", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 2, new QuestRequirement()),
	TALE_OF_THE_RIGHTEOUS("Tale of the Righteous", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	TEARS_OF_GUTHIX("Tears of Guthix", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.SHORT, 1, new QuestRequirement()),
	TEMPLE_OF_IKOV("Temple of Ikov", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 1, new QuestRequirement()),
	THE_CORSAIR_CURSE("The Corsair Curse", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 2, new QuestRequirement()),
	THE_DEPTHS_OF_DESPAIR("The Depths of Despair", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	THE_DIG_SITE("The Dig Site", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	THE_EYES_OF_GLOUPHRIE("The Eyes of Glouphrie", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	THE_FEUD("The Feud", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	THE_FREMENNIK_ISLES("The Fremennik Isles", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.LONG, 1, new QuestRequirement()),
	THE_FREMENNIK_TRIALS("The Fremennik Trials", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 3, new QuestRequirement()),
	THE_GENERALS_SHADOW("The General's Shadow", QuestType.MINIQUEST, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 0, new QuestRequirement()),
	THE_GIANT_DWARF("The Giant Dwarf", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 2, new QuestRequirement()),
	THE_GOLEM("The Golem", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	THE_GRAND_TREE("The Grand Tree", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.LONG, 5, new QuestRequirement()),
	THE_GREAT_BRAIN_ROBBERY("The Great Brain Robbery", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 2, new QuestRequirement()),
	THE_HAND_IN_THE_SAND("The Hand in the Sand", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	THE_KNIGHTS_SWORD("The Knight's Sword", QuestType.FREE, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	THE_LOST_TRIBE("The Lost Tribe", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	THE_MAGE_ARENA("The Mage Arena", QuestType.MINIQUEST, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 0, new QuestRequirement()),
	THE_MAGE_ARENA_II("The Mage Arena II", QuestType.MINIQUEST, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 0, new QuestRequirement()),
	THE_QUEEN_OF_THIEVES("The Queen of Thieves", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	THE_RESTLESS_GHOST("The Restless Ghost", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	THE_SLUG_MENACE("The Slug Menace", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	THE_TOURIST_TRAP("The Tourist Trap", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	THRONE_OF_MISCELLANIA("Throne of Miscellania", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 1, new QuestRequirement()),
	TOWER_OF_LIFE("Tower of Life", QuestType.MEMBERS, QuestDifficulty.NOVICE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	TREE_GNOME_VILLAGE("Tree Gnome Village", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 2, new QuestRequirement()),
	TRIBAL_TOTEM("Tribal Totem", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.SHORT, 1, new QuestRequirement()),
	TROLL_ROMANCE("Troll Romance", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.MEDIUM, 2, new QuestRequirement()),
	TROLL_STRONGHOLD("Troll Stronghold", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.SHORT, 1, new QuestRequirement()),
	UNDERGROUND_PASS("Underground Pass", QuestType.MEMBERS, QuestDifficulty.EXPERIENCED, QuestLength.LONG, 5, new QuestRequirement()),
	VAMPIRE_SLAYER("Vampire Slayer", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 3, new QuestRequirement()),
	WANTED("Wanted!", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 1, new QuestRequirement()),
	WATCHTOWER("Watchtower", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.LONG, 4, new QuestRequirement()),
	WATERFALL_QUEST("Waterfall Quest", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	WHAT_LIES_BELOW("What Lies Below", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	WITCHS_HOUSE("Witch's House", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.SHORT, 4, new QuestRequirement()),
	WITCHS_POTION("Witch's Potion", QuestType.FREE, QuestDifficulty.NOVICE, QuestLength.SHORT, 1, new QuestRequirement()),
	ZOGRE_FLESH_EATERS("Zogre Flesh Eaters", QuestType.MEMBERS, QuestDifficulty.INTERMEDIATE, QuestLength.MEDIUM, 1, new QuestRequirement()),
	// UNKNOWN is used when a quest is added but this list has not been updated yet
	UNKNOWN("", QuestType.UNKNOWN, QuestDifficulty.UNKNOWN, QuestLength.UNKNOWN, 0, new QuestRequirement());

	static
	{
		A_SOULS_BANE.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		A_TAIL_OF_TWO_CATS.questRequirement.initReq(new Quest[] {Quest.ICTHLARINS_LITTLE_HELPER}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ALFRED_GRIMHANDS_BARCRAWL.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ANIMAL_MAGNETISM.questRequirement.initReq(new Quest[] {Quest.THE_RESTLESS_GHOST, Quest.ERNEST_THE_CHICKEN, Quest.PRIEST_IN_PERIL}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 35, 0, 0, 0, 19, 0, 0, 0, 0, 0, 18, 0, 0, 0, 0);
		ANOTHER_SLICE_OF_HAM.questRequirement.initReq(new Quest[] {Quest.DEATH_TO_THE_DORGESHUUN, Quest.THE_DIG_SITE, Quest.THE_GIANT_DWARF}, new String[] {}, 0, 64, 0, 15, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ARCHITECTURAL_ALLIANCE.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 42, 0, 0, 0, 0, 0, 0, 0, 0);
		BEAR_YOUR_SOUL.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		BETWEEN_A_ROCK.questRequirement.initReq(new Quest[] {Quest.FISHING_CONTEST, Quest.DWARF_CANNON}, new String[] {}, 0, 75, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 40, 0, 0, 0, 0, 0, 0, 0, 0);
		BIG_CHOMPY_BIRD_HUNTING.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 30, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		BIOHAZARD.questRequirement.initReq(new Quest[] {Quest.PLAGUE_CITY}, new String[] {}, 0, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		BLACK_KNIGHTS_FORTRESS.questRequirement.initReq(new Quest[] {}, new String[] {}, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		BONE_VOYAGE.questRequirement.initReq(new Quest[] {Quest.THE_DIG_SITE}, new String[] {"100 Kudos"}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		CABIN_FEVER.questRequirement.initReq(new Quest[] {Quest.RUM_DEAL, Quest.PIRATES_TREASURE}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 45, 50, 0, 0, 42, 0, 0, 0, 0, 0, 0);
		CLIENT_OF_KOUREND.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		CLOCK_TOWER.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		COLD_WAR.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 30, 0, 0, 0, 0, 10, 34);
		CONTACT.questRequirement.initReq(new Quest[] {Quest.GERTRUDES_CAT, Quest.ICTHLARINS_LITTLE_HELPER, Quest.PRINCE_ALI_RESCUE}, new String[] {}, 0, 191, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		COOKS_ASSISTANT.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		CREATURE_OF_FENKENSTRAIN.questRequirement.initReq(new Quest[] {Quest.PRIEST_IN_PERIL, Quest.THE_RESTLESS_GHOST}, new String[] {}, 0, 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0);
		CURSE_OF_THE_EMPTY_LORD.questRequirement.initReq(new Quest[] {Quest.THE_RESTLESS_GHOST}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		DARKNESS_OF_HALLOWVALE.questRequirement.initReq(new Quest[] {Quest.IN_AID_OF_THE_MYREQUE}, new String[] {}, 0, 0, 0, 0, 0, 40, 0, 0, 0, 33, 0, 0, 0, 0, 0, 32, 0, 20, 0, 26, 22, 0, 0, 0, 0, 5);
		DEATH_PLATEAU.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		DEATH_TO_THE_DORGESHUUN.questRequirement.initReq(new Quest[] {Quest.THE_LOST_TRIBE}, new String[] {}, 0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 23, 0, 0, 0, 0, 0);
		DEMON_SLAYER.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		DESERT_TREASURE.questRequirement.initReq(new Quest[] {Quest.THE_DIG_SITE, Quest.THE_TOURIST_TRAP, Quest.TEMPLE_OF_IKOV, Quest.PRIEST_IN_PERIL, Quest.WATERFALL_QUEST, Quest.TROLL_STRONGHOLD}, new String[] {}, 0, 174, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 53, 10, 0, 0, 0, 0);
		DEVIOUS_MINDS.questRequirement.initReq(new Quest[] {Quest.DORICS_QUEST, Quest.TROLL_STRONGHOLD, Quest.WANTED, Quest.RECRUITMENT_DRIVE}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 65, 0, 0, 0, 0, 0, 0, 50, 0, 0);
		DORICS_QUEST.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		DRAGON_SLAYER.questRequirement.initReq(new Quest[] {}, new String[] {}, 32, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		DRAGON_SLAYER_II.questRequirement.initReq(new Quest[] {Quest.LEGENDS_QUEST, Quest.DREAM_MENTOR, Quest.A_TAIL_OF_TWO_CATS, Quest.ANIMAL_MAGNETISM, Quest.GHOSTS_AHOY, Quest.BONE_VOYAGE, Quest.CLIENT_OF_KOUREND}, new String[] {}, 200, 608, 0, 0, 0, 0, 50, 0, 0, 75, 0, 0, 0, 0, 0, 62, 70, 68, 0, 60, 60, 0, 0, 0, 0, 50);
		DREAM_MENTOR.questRequirement.initReq(new Quest[] {Quest.LUNAR_DIPLOMACY, Quest.EADGARS_RUSE}, new String[] {}, 0, 343, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		DRUIDIC_RITUAL.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		DWARF_CANNON.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		EADGARS_RUSE.questRequirement.initReq(new Quest[] {Quest.DRUIDIC_RITUAL}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 0, 0, 0, 0, 0, 0, 0);
		EAGLES_PEAK.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 27, 0);
		ELEMENTAL_WORKSHOP_I.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 20, 20, 0, 0, 0, 0, 0, 0, 0, 0);
		ELEMENTAL_WORKSHOP_II.questRequirement.initReq(new Quest[] {Quest.ELEMENTAL_WORKSHOP_I}, new String[] {}, 0, 35, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ENAKHRAS_LAMENT.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 43, 39, 0, 0, 0, 0, 45, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ENCHANTED_KEY.questRequirement.initReq(new Quest[] {Quest.MAKING_HISTORY}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ENLIGHTENED_JOURNEY.questRequirement.initReq(new Quest[] {}, new String[] {}, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 36, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0);
		ENTER_THE_ABYSS.questRequirement.initReq(new Quest[] {Quest.RUNE_MYSTERIES}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ERNEST_THE_CHICKEN.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		FAIRYTALE_I_GROWING_PAINS.questRequirement.initReq(new Quest[] {Quest.LOST_CITY, Quest.NATURE_SPIRIT}, new String[] {}, 0, 111, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		FAIRYTALE_II_CURE_A_QUEEN.questRequirement.initReq(new Quest[] {Quest.FAIRYTALE_I_GROWING_PAINS}, new String[] {}, 0, 145, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 57, 0, 40, 0, 49, 0, 0, 0);
		FAMILY_CREST.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 170, 0, 0, 0, 0, 0, 0, 0, 59, 0, 0, 0, 0, 0, 40, 40, 40, 0, 0, 0, 0, 0, 0, 0, 0);
		FAMILY_PEST.questRequirement.initReq(new Quest[] {Quest.FAMILY_CREST}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		FIGHT_ARENA.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 137, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		FISHING_CONTEST.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		FORGETTABLE_TALE.questRequirement.initReq(new Quest[] {Quest.THE_GIANT_DWARF, Quest.FISHING_CONTEST}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0, 0, 0);
		GARDEN_OF_TRANQUILLITY.questRequirement.initReq(new Quest[] {Quest.CREATURE_OF_FENKENSTRAIN}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0);
		GERTRUDES_CAT.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		GHOSTS_AHOY.questRequirement.initReq(new Quest[] {Quest.PRIEST_IN_PERIL, Quest.THE_RESTLESS_GHOST}, new String[] {}, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0);
		GOBLIN_DIPLOMACY.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		GRIM_TALES.questRequirement.initReq(new Quest[] {Quest.WITCHS_HOUSE}, new String[] {}, 0, 138, 0, 0, 0, 0, 0, 0, 0, 0, 0, 71, 0, 0, 0, 0, 0, 0, 52, 59, 58, 0, 45, 0, 0, 0);
		HAUNTED_MINE.questRequirement.initReq(new Quest[] {Quest.PRIEST_IN_PERIL}, new String[] {}, 0, 95, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0);
		HAZEEL_CULT.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		HEROES_QUEST.questRequirement.initReq(new Quest[] {Quest.SHIELD_OF_ARRAV, Quest.LOST_CITY, Quest.MERLINS_CRYSTAL, Quest.DRAGON_SLAYER}, new String[] {}, 55, 111, 0, 0, 0, 0, 0, 0, 0, 0, 53, 0, 0, 53, 0, 0, 0, 50, 25, 0, 0, 0, 0, 0, 0, 0);
		HOLY_GRAIL.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 120, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		HORROR_FROM_THE_DEEP.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0, 0, 0, 0, 0);
		ICTHLARINS_LITTLE_HELPER.questRequirement.initReq(new Quest[] {Quest.GERTRUDES_CAT}, new String[] {}, 0, 91, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		IMP_CATCHER.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		IN_AID_OF_THE_MYREQUE.questRequirement.initReq(new Quest[] {Quest.IN_SEARCH_OF_THE_MYREQUE, Quest.NATURE_SPIRIT}, new String[] {}, 0, 75, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 25, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0);
		IN_SEARCH_OF_THE_MYREQUE.questRequirement.initReq(new Quest[] {Quest.NATURE_SPIRIT}, new String[] {}, 0, 97, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0);
		JUNGLE_POTION.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0);
		KINGS_RANSOM.questRequirement.initReq(new Quest[] {Quest.MERLINS_CRYSTAL, Quest.HOLY_GRAIL, Quest.MURDER_MYSTERY, Quest.BLACK_KNIGHTS_FORTRESS, Quest.ONE_SMALL_FAVOUR}, new String[] {}, 0, 0, 0, 0, 65, 0, 0, 0, 0, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		LAIR_OF_TARN_RAZORLOR.questRequirement.initReq(new Quest[] {Quest.HAUNTED_MINE}, new String[] {}, 0, 69, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0);
		LEGENDS_QUEST.questRequirement.initReq(new Quest[] {Quest.HEROES_QUEST, Quest.FAMILY_CREST, Quest.SHILO_VILLAGE, Quest.UNDERGROUND_PASS, Quest.WATERFALL_QUEST}, new String[] {}, 107, 187, 0, 0, 0, 50, 0, 0, 42, 56, 0, 50, 0, 0, 0, 50, 50, 52, 45, 50, 50, 0, 0, 0, 0, 0);
		LOST_CITY.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 36, 0, 0, 0, 31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		LUNAR_DIPLOMACY.questRequirement.initReq(new Quest[] {Quest.LOST_CITY, Quest.THE_FREMENNIK_TRIALS, Quest.RUNE_MYSTERIES, Quest.SHILO_VILLAGE}, new String[] {}, 0, 111, 0, 0, 40, 0, 0, 0, 0, 65, 0, 55, 0, 0, 49, 61, 0, 60, 5, 0, 0, 0, 0, 0, 0, 0);
		MAKING_HISTORY.questRequirement.initReq(new Quest[] {Quest.PRIEST_IN_PERIL, Quest.THE_RESTLESS_GHOST}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		MERLINS_CRYSTAL.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 39, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		MISTHALIN_MYSTERY.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		MONKEY_MADNESS_I.questRequirement.initReq(new Quest[] {Quest.THE_GRAND_TREE, Quest.TREE_GNOME_VILLAGE}, new String[] {}, 0, 195, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		MONKEY_MADNESS_II.questRequirement.initReq(new Quest[] {Quest.ENLIGHTENED_JOURNEY, Quest.THE_EYES_OF_GLOUPHRIE, Quest.RECIPE_FOR_DISASTER, Quest.TROLL_STRONGHOLD, Quest.WATCHTOWER, Quest.MONKEY_MADNESS_I}, new String[] {}, 0, 378, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 60, 70, 0, 0, 0, 0, 55, 69, 0, 0, 60, 0);
		MONKS_FRIEND.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		MOUNTAIN_DAUGHTER.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0);
		MOURNINGS_ENDS_PART_I.questRequirement.initReq(new Quest[] {Quest.ROVING_ELVES, Quest.BIG_CHOMPY_BIRD_HUNTING, Quest.SHEEP_HERDER}, new String[] {}, 0, 11, 0, 0, 0, 0, 0, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0);
		MOURNINGS_ENDS_PART_II.questRequirement.initReq(new Quest[] {Quest.MOURNINGS_ENDS_PART_I}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		MURDER_MYSTERY.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		MY_ARMS_BIG_ADVENTURE.questRequirement.initReq(new Quest[] {Quest.EADGARS_RUSE, Quest.THE_FEUD, Quest.JUNGLE_POTION}, new String[] {}, 0, 172, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 29, 0, 0, 0);
		NATURE_SPIRIT.questRequirement.initReq(new Quest[] {Quest.PRIEST_IN_PERIL, Quest.THE_RESTLESS_GHOST}, new String[] {}, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		OBSERVATORY_QUEST.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		OLAFS_QUEST.questRequirement.initReq(new Quest[] {Quest.THE_FREMENNIK_TRIALS}, new String[] {}, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ONE_SMALL_FAVOUR.questRequirement.initReq(new Quest[] {Quest.RUNE_MYSTERIES, Quest.SHILO_VILLAGE, Quest.DRUIDIC_RITUAL}, new String[] {}, 0, 92, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 30, 0, 18, 36, 0, 0, 0, 0, 0, 0);
		PIRATES_TREASURE.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		PLAGUE_CITY.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		PRIEST_IN_PERIL.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		PRINCE_ALI_RESCUE.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		RAG_AND_BONE_MAN.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		RAG_AND_BONE_MAN_II.questRequirement.initReq(new Quest[] {Quest.RAG_AND_BONE_MAN, Quest.HORROR_FROM_THE_DEEP, Quest.SKIPPY_AND_THE_MOGRES}, new String[] {}, 0, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		RATCATCHERS.questRequirement.initReq(new Quest[] {Quest.ICTHLARINS_LITTLE_HELPER}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		RECIPE_FOR_DISASTER.questRequirement.initReq(new Quest[] {Quest.COOKS_ASSISTANT, Quest.FISHING_CONTEST, Quest.GOBLIN_DIPLOMACY, Quest.BIG_CHOMPY_BIRD_HUNTING, Quest.MURDER_MYSTERY, Quest.NATURE_SPIRIT, Quest.WITCHS_HOUSE, Quest.GERTRUDES_CAT, Quest.SHADOW_OF_THE_STORM, Quest.FAMILY_CREST, Quest.HEROES_QUEST, Quest.SHILO_VILLAGE, Quest.UNDERGROUND_PASS, Quest.WATERFALL_QUEST, Quest.MONKEY_MADNESS_I, Quest.DESERT_TREASURE, Quest.HORROR_FROM_THE_DEEP}, new String[] {}, 175, 227, 0, 0, 0, 0, 0, 30, 0, 59, 70, 36, 5, 53, 50, 40, 0, 50, 25, 48, 53, 10, 0, 0, 0, 0);
		RECRUITMENT_DRIVE.questRequirement.initReq(new Quest[] {Quest.BLACK_KNIGHTS_FORTRESS, Quest.DRUIDIC_RITUAL}, new String[] {}, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		REGICIDE.questRequirement.initReq(new Quest[] {Quest.UNDERGROUND_PASS}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 56, 0, 0, 0, 0, 0, 0);
		ROMEO_AND_JULIET.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ROVING_ELVES.questRequirement.initReq(new Quest[] {Quest.REGICIDE, Quest.WATERFALL_QUEST}, new String[] {}, 0, 84, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ROYAL_TROUBLE.questRequirement.initReq(new Quest[] {Quest.THRONE_OF_MISCELLANIA}, new String[] {}, 0, 149, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 40, 0, 0, 0, 0);
		RUM_DEAL.questRequirement.initReq(new Quest[] {Quest.ZOGRE_FLESH_EATERS}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 47, 0, 0, 0, 0, 50, 0, 42, 0, 0, 0, 0, 0, 42, 40, 0, 0, 0);
		RUNE_MYSTERIES.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		SCORPION_CATCHER.questRequirement.initReq(new Quest[] {Quest.ALFRED_GRIMHANDS_BARCRAWL}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		SEA_SLUG.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		SHADES_OF_MORTTON.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0);
		SHADOW_OF_THE_STORM.questRequirement.initReq(new Quest[] {Quest.DEMON_SLAYER, Quest.THE_GOLEM}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		SHEEP_HERDER.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		SHEEP_SHEARER.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		SHIELD_OF_ARRAV.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		SHILO_VILLAGE.questRequirement.initReq(new Quest[] {Quest.JUNGLE_POTION}, new String[] {}, 0, 93, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0);
		SKIPPY_AND_THE_MOGRES.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		SPIRITS_OF_THE_ELID.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 75, 0, 0, 0, 0, 0, 37, 0, 33, 0, 0, 0, 0, 0, 0, 0, 37, 0, 0, 37, 0, 0, 0, 0, 0);
		SWAN_SONG.questRequirement.initReq(new Quest[] {Quest.ONE_SMALL_FAVOUR, Quest.GARDEN_OF_TRANQUILLITY}, new String[] {}, 100, 170, 0, 0, 0, 0, 0, 0, 0, 66, 62, 0, 0, 62, 42, 40, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		TAI_BWO_WANNAI_TRIO.questRequirement.initReq(new Quest[] {Quest.JUNGLE_POTION}, new String[] {}, 0, 53, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 5, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0);
		TALE_OF_THE_RIGHTEOUS.questRequirement.initReq(new Quest[] {Quest.CLIENT_OF_KOUREND}, new String[] {"20% Shayzien House Favour"}, 0, 46, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0);
		TEARS_OF_GUTHIX.questRequirement.initReq(new Quest[] {}, new String[] {}, 43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 49, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0);
		TEMPLE_OF_IKOV.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 0, 0, 0, 0, 0);
		THE_CORSAIR_CURSE.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		THE_DEPTHS_OF_DESPAIR.questRequirement.initReq(new Quest[] {Quest.CLIENT_OF_KOUREND}, new String[] {"20% Hosidius House Favour"}, 0, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0);
		THE_DIG_SITE.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 25, 0, 0, 0, 0, 0);
		THE_EYES_OF_GLOUPHRIE.questRequirement.initReq(new Quest[] {Quest.THE_GRAND_TREE}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5);
		THE_FEUD.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 0);
		THE_FREMENNIK_ISLES.questRequirement.initReq(new Quest[] {Quest.THE_FREMENNIK_TRIALS}, new String[] {}, 0, 122, 0, 0, 0, 0, 0, 0, 0, 0, 0, 56, 0, 0, 0, 46, 0, 0, 0, 40, 0, 0, 0, 0, 0, 20);
		THE_FREMENNIK_TRIALS.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 69, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 25, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		THE_GENERALS_SHADOW.questRequirement.initReq(new Quest[] {Quest.CURSE_OF_THE_EMPTY_LORD, Quest.FIGHT_ARENA}, new String[] {}, 0, 160, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		THE_GIANT_DWARF.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 0, 0, 0, 0, 16, 12, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0);
		THE_GOLEM.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0);
		THE_GRAND_TREE.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 172, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0);
		THE_GREAT_BRAIN_ROBBERY.questRequirement.initReq(new Quest[] {Quest.CREATURE_OF_FENKENSTRAIN, Quest.RUM_DEAL, Quest.CABIN_FEVER}, new String[] {}, 0, 190, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30);
		THE_HAND_IN_THE_SAND.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 49, 0, 0, 0, 0, 17, 0, 0, 0, 0, 0);
		THE_KNIGHTS_SWORD.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0);
		THE_LOST_TRIBE.questRequirement.initReq(new Quest[] {Quest.GOBLIN_DIPLOMACY, Quest.RUNE_MYSTERIES}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0, 13, 13, 0, 0, 0, 0, 0);
		THE_MAGE_ARENA.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 112, 0, 0, 0, 0, 0, 0, 0, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		THE_MAGE_ARENA_II.questRequirement.initReq(new Quest[] {Quest.THE_MAGE_ARENA}, new String[] {"Unlocked Claws of Guthix", "Unlocked Saradomin Strike", "Unlocked Flames of Zamorak"}, 0, 348, 0, 0, 0, 0, 0, 0, 0, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		THE_QUEEN_OF_THIEVES.questRequirement.initReq(new Quest[] {Quest.CLIENT_OF_KOUREND}, new String[] {"20% Piscarilius House Favour"}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0);
		THE_RESTLESS_GHOST.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		THE_SLUG_MENACE.questRequirement.initReq(new Quest[] {Quest.SEA_SLUG, Quest.WANTED}, new String[] {}, 0, 62, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 30, 30, 0, 30, 0, 0);
		THE_TOURIST_TRAP.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 47, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		THRONE_OF_MISCELLANIA.questRequirement.initReq(new Quest[] {Quest.HEROES_QUEST, Quest.THE_FREMENNIK_TRIALS}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		TOWER_OF_LIFE.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10);
		TREE_GNOME_VILLAGE.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 112, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		TRIBAL_TOTEM.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 0, 0, 0, 0);
		TROLL_ROMANCE.questRequirement.initReq(new Quest[] {Quest.TROLL_STRONGHOLD}, new String[] {}, 0, 113, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 0, 0, 0, 0, 0, 0);
		TROLL_STRONGHOLD.questRequirement.initReq(new Quest[] {Quest.DEATH_PLATEAU}, new String[] {}, 0, 113, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0);
		UNDERGROUND_PASS.questRequirement.initReq(new Quest[] {Quest.BIOHAZARD}, new String[] {}, 0, 91, 0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		VAMPIRE_SLAYER.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		WANTED.questRequirement.initReq(new Quest[] {Quest.RECRUITMENT_DRIVE, Quest.THE_LOST_TRIBE, Quest.RUNE_MYSTERIES, Quest.PRIEST_IN_PERIL}, new String[] {}, 32, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		WATCHTOWER.questRequirement.initReq(new Quest[] {Quest.DRUIDIC_RITUAL}, new String[] {}, 0, 68, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 40, 14, 25, 15, 0, 0, 0, 0, 0);
		WATERFALL_QUEST.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 84, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		WHAT_LIES_BELOW.questRequirement.initReq(new Quest[] {Quest.RUNE_MYSTERIES}, new String[] {}, 0, 47, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0);
		WITCHS_HOUSE.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 53, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		WITCHS_POTION.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ZOGRE_FLESH_EATERS.questRequirement.initReq(new Quest[] {Quest.JUNGLE_POTION, Quest.BIG_CHOMPY_BIRD_HUNTING}, new String[] {}, 0, 111, 0, 0, 0, 10, 0, 30, 0, 0, 0, 0, 30, 0, 0, 0, 4, 0, 8, 0, 0, 0, 0, 0, 0, 0);
		UNKNOWN.questRequirement.initReq(new Quest[] {}, new String[] {}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

	}

	// Reverse-lookup map for getting a quest from its name
	private static final Map<String, Quest> LOOKUP = new HashMap<>();

	static
	{
		for (Quest q : Quest.values())
		{
			LOOKUP.put(q.getQuestName(), q);
		}
	}

	public static Quest getQuest(String questName)
	{
		return LOOKUP.get(questName);
	}

	@Override
	public String toString()
	{
		return this.questName;
	}

	private final String questName;
	private final QuestType questType;
	private final QuestDifficulty questDifficulty;
	private final QuestLength questLength;
	private final int questPoints;
	private final QuestRequirement questRequirement;
}
