/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.cluescrolls.clues;

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;
import lombok.Getter;
import net.runelite.api.ItemComposition;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.PanelComponent;
import static net.runelite.api.ItemID.*;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.EMOTE_IMAGE;
import static net.runelite.client.plugins.cluescrolls.clues.Emote.*;
import static net.runelite.client.plugins.cluescrolls.clues.Emote.BULL_ROARER;

@Getter
public class EmoteClue extends ClueScroll implements TextClueScroll
{
	private static final Set<EmoteClue> CLUES = ImmutableSet.of(
		new EmoteClue("Show your anger towards the Statue of Saradomin in Ellamaria's garden. Beware of double agents! Equip a zamorak godsword.", new WorldPoint(3230, 3478, 0), ANGRY, ZAMORAK_GODSWORD),
		new EmoteClue("Show your anger at the Wise old man. Beware of double agents! Equip an abyssal whip, a legend's cape and some spined chaps.", new WorldPoint(3088, 3254, 0), ANGRY, ABYSSAL_WHIP, CAPE_OF_LEGENDS, SPINED_CHAPS),
		new EmoteClue("Beckon in the Digsite, near the eastern winch. Bow before you talk to me. Equip a green gnome hat, snakeskin boots and an iron pickaxe.", new WorldPoint(2971, 3331, 0), BECKON, BOW, GREEN_HAT, SNAKESKIN_BOOTS, IRON_PICKAXE),
		new EmoteClue("Beckon in Tai Bwo Wannai. Clap before you talk to me. Equip green dragonhide chaps, a ring of dueling and a mithril medium helmet.", new WorldPoint(2784, 3065, 0), BECKON, CLAP, GREEN_DHIDE_CHAPS, RING_OF_DUELING8, MITHRIL_MED_HELM),
		new EmoteClue("Beckon on the east coast of the Kharazi Jungle. Beware of double agents! Equip any vestment stole and a heraldic rune shield.", new WorldPoint(2954, 2933, 0), BECKON, SARADOMIN_STOLE, RUNE_SHIELD_H1_10667),
		new EmoteClue("Beckon in the combat ring of Shayzien. Show your anger before you talk to me. Equip an adamant platebody, adamant full helm and adamant platelegs.", new WorldPoint(1545, 3594, 0), BECKON, ANGRY, ADAMANT_PLATELEGS, ADAMANT_PLATEBODY, ADAMANT_FULL_HELM),
		new EmoteClue("Bow near Lord Iorwerth. Beware of double agents! Equip a new imbued crystal bow.", new WorldPoint(2205, 3252, 0), BOW, NEW_CRYSTAL_BOW_I),
		new EmoteClue("Bow outside the entrance to the Legends' Guild. Equip iron platelegs, an emerald amulet and an oak longbow.", new WorldPoint(2729, 3349, 0), BOW, IRON_PLATELEGS, OAK_LONGBOW, EMERALD_AMULET),
		new EmoteClue("Bow on the ground floor of the Legend's guild. Equip Legend's cape, a dragon battleaxe and an amulet of glory.", new WorldPoint(2728, 3377, 0), BOW, CAPE_OF_LEGENDS, DRAGON_BATTLEAXE, AMULET_OF_GLORY),
		new EmoteClue("Bow in the ticket office of the Duel Arena. Equip an iron chain body, leather chaps and coif.", new WorldPoint(3314, 3241, 0), BOW, IRON_CHAINBODY, LEATHER_CHAPS, COIF),
		new EmoteClue("Bow at the top of the lighthouse. Beware of double agents! Equip a blue dragonhide body, blue dragonhide vambraces and no jewelry.", new WorldPoint(2511, 3641, 2), BOW, BLUE_DHIDE_BODY, BLUE_DHIDE_VAMB),
		new EmoteClue("Bow upstairs in the Monastery. Equip a completed prayer book.", new WorldPoint(3136, 3513, 0), BOW, HOLY_BOOK, UNHOLY_BOOK, BOOK_OF_BALANCE),
		new EmoteClue("Blow a kiss between the tables in Shilo Village bank. Beware of double agents! Equip a blue mystic hat, bone spear and rune platebody.", new WorldPoint(2851, 2954, 0), BLOW_KISS, MYSTIC_HAT, BONE_SPEAR, RUNE_PLATEBODY),
		new EmoteClue("Blow a kiss in the heart of the lava maze. Equip black dragonhide chaps, a spotted cape and a rolling pin.", new WorldPoint(3069, 3861, 0), BLOW_KISS, BLACK_DHIDE_CHAPS, SPOTTED_CAPE, ROLLING_PIN),
		new EmoteClue("Blow a kiss outside K'ril Tsutsaroth's chamber. Beware of double agents! Equip a zamorak full helm and the shadow sword.", new WorldPoint(2925, 5333, 0), BLOW_KISS, ZAMORAK_FULL_HELM, SHADOW_SWORD),
		new EmoteClue("Cheer at the Druids' Circle. Equip a blue wizard hat, a bronze two-handed sword and HAM boots.", new WorldPoint(2925, 3484, 0), CHEER, BLUE_WIZARD_HAT, BRONZE_2H_SWORD, HAM_BOOTS),
		new EmoteClue("Cheer at the games room. Have nothing equipped at all when you do.", new WorldPoint(2207, 4952, 0), CHEER),
		new EmoteClue("Cheer in the Barbarian Agility Arena. Headbang before you talk to me. Equip a steel platebody, maple shortbow and a Wilderness cape.", new WorldPoint(2552, 3556, 0), CHEER, HEADBANG, STEEL_PLATEBODY, MAPLE_SHORTBOW, TEAM1_CAPE),
		new EmoteClue("Cheer in the Edgeville general store. Dance before you talk to me. Equip a brown apron, leather boots and leather gloves.", new WorldPoint(3080, 3509, 0), CHEER, DANCE, BROWN_APRON, LEATHER_BOOTS, LEATHER_GLOVES),
		new EmoteClue("Cheer in the Ogre Pen in the Training Camp. Show you are angry before you talk to me. Equip a green dragonhide body and chaps and a steel square shield.", new WorldPoint(2527, 3375, 0), CHEER, ANGRY, GREEN_DHIDE_BODY, GREEN_DHIDE_CHAPS, STEEL_SQ_SHIELD),
		new EmoteClue("Cheer in the Shadow dungeon. Equip a rune crossbow, climbing boots and any mitre.", new WorldPoint(2774, 6785, 0), CHEER, RUNE_CROSSBOW, CLIMBING_BOOTS, SARADOMIN_MITRE),
		new EmoteClue("Cheer in the Entrana church. Beware of double agents! Equip a set of full black dragonhide armour.", new WorldPoint(2852, 3349, 0), CHEER, BLACK_DHIDE_VAMB, BLACK_DHIDE_CHAPS, BLACK_DHIDE_BODY),
		new EmoteClue("Cheer for the monks at Port Sarim. Equip a coif, steel plateskirt and a sapphire necklace.", new WorldPoint(2959, 3362, 0), CHEER, COIF, STEEL_PLATESKIRT, SAPPHIRE_NECKLACE),
		new EmoteClue("Cheer at the top of the agility pyramid. Beware of double agents! Equip a blue mystic robe top, and any rune heraldic shield.", new WorldPoint(3043, 4697, 3), CHEER, MYSTIC_ROBE_TOP, RUNE_SHIELD_H1_10667),
		new EmoteClue("Clap in the main exam room in the Exam Centre. Equip a white apron, green gnome boots and leather gloves.", new WorldPoint(3361, 3339, 0), CLAP, WHITE_APRON, GREEN_BOOTS, LEATHER_GLOVES),
		new EmoteClue("Clap on the causeway to the Wizards' Tower. Equip an iron medium helmet, emerald ring and a white apron.", new WorldPoint(3098, 3212, 0), CLAP, IRON_MED_HELM, EMERALD_RING, WHITE_APRON),
		new EmoteClue("Clap on the top level of the mill, north of East Ardougne. Equip a blue gnome robe top, HAM robe bottom and an unenchanted tiara.", new WorldPoint(2635, 3385, 3), CLAP, BLUE_ROBE_TOP, HAM_ROBE, TIARA),
		new EmoteClue("Clap in Seers court house. Spin before you talk to me. Equip an adamant halberd, blue mystic robe bottom and a diamond ring.", new WorldPoint(2735, 3469, 0), CLAP, SPIN, ADAMANT_HALBERD, MYSTIC_ROBE_BOTTOM, DIAMOND_RING),
		new EmoteClue("Clap in the magic axe hut. Beware of double agents. Equip only some flared trousers.", new WorldPoint(3191, 3960, 0), CLAP, FLARED_TROUSERS),
		new EmoteClue("Cry in the Catherby Ranging shop. Bow before you talk to me. Equip blue gnome boots, a hard leather body and an unblessed silver sickle.", new WorldPoint(2823, 3443, 0), CRY, BOW, BLUE_BOOTS, HARDLEATHER_BODY, SILVER_SICKLE),
		new EmoteClue("Cry on the shore of Catherby beach. Laugh before you talk to me. Equip an adamant sq shield, a bone dagger and mithril platebody.", new WorldPoint(3079, 6330, 0), CRY, LAUGH, ADAMANT_SQ_SHIELD, BONE_DAGGER, MITHRIL_PLATELEGS),
		new EmoteClue("Cry on top of the western tree in the Gnome Agility Arena. Indicate 'no' before you talk to me. Equip a steel kiteshield, ring of forging, and green dragonhide chaps.", new WorldPoint(2473, 3420, 0), CRY, NO, STEEL_KITESHIELD, RING_OF_FORGING, GREEN_DHIDE_CHAPS),
		new EmoteClue("Cry in the Tzhaar gem shop. Beware of the double agents! Equip a fire cape and TokTz-Xil-Ul.", new WorldPoint(2463, 5149, 0), CRY, FIRE_CAPE, TOKTZXILUL),
		new EmoteClue("Cry in the Draynor Village jail. Jump for joy before you talk to me. Equip an adamant sword, a sapphire amulet and an adamant plateskirt.", new WorldPoint(3128, 3245, 0), CRY, JUMP_FOR_JOY, ADAMANT_SWORD, SAPPHIRE_AMULET, ADAMANT_PLATESKIRT),
		new EmoteClue("Dance at the crossroads north of Draynor. Equip an iron chain body, a sapphire ring and a longbow.", new WorldPoint(3109, 3294, 0), DANCE, IRON_CHAINBODY, SAPPHIRE_RING, LONGBOW),
		new EmoteClue("Dance in the Party Room. Equip a steel full helmet, steel platebody and an iron plateskirt.", new WorldPoint(2863, 3272, 0), DANCE, STEEL_FULL_HELM, STEEL_PLATEBODY, IRON_PLATESKIRT),
		new EmoteClue("Dance in the shack in Lumbridge Swamp. Equip a bronze dagger, iron full helmet and a gold ring.", new WorldPoint(3203, 3169, 0), DANCE, BRONZE_DAGGER, IRON_FULL_HELM, GOLD_RING),
		new EmoteClue("Dance in the dark caves beneath Lumbridge Swamp. Blow a kiss before you talk to me. Equip an air staff, Bronze full helm and an amulet of power.", new WorldPoint(3223, 9597, 0), DANCE, BLOW_KISS, STAFF_OF_AIR, BRONZE_FULL_HELM, AMULET_OF_POWER),
		new EmoteClue("Dance at the cat-doored pyramid in Sophanem. Beware of double agents! Equip a ring of life, an uncharged amulet of glory and an adamant two-handed sword.", new WorldPoint(3294, 2781, 0), DANCE, RING_OF_LIFE, AMULET_OF_GLORY, ADAMANT_2H_SWORD),
		new EmoteClue("Dance in the centre of Canifis. Bow before you talk to me. Equip a green gnome robe top, mithril plate legs and an iron two-handed sword.", new WorldPoint(3492, 3488, 0), DANCE, BOW, ADAMANT_2H_SWORD, MITHRIL_PLATELEGS, IRON_2H_SWORD),
		new EmoteClue("Dance in the King Black Dragon's lair. Beware of double agents! Equip a black dragonhide body, black dragonhide vambs and a black dragon mask.", new WorldPoint(2271, 4680, 0), DANCE, BLACK_DHIDE_BODY, BLACK_DHIDE_VAMB, BLACK_DRAGON_MASK),
		new EmoteClue("Dance in Iban's temple. Beware of double agents! Equip Iban's staff, a black mystic top, and a black mystic bottom.", new WorldPoint(2011, 4712, 0), DANCE, IBANS_STAFF, MYSTIC_ROBE_TOP_DARK, MYSTIC_ROBE_BOTTOM_DARK),
		new EmoteClue("Dance on the Fishing Platform. Equip barrows gloves, an amulet of glory and a dragon med helm.", new WorldPoint(2782, 3273, 0), DANCE, BARROWS_GLOVES, AMULET_OF_GLORY, DRAGON_MED_HELM),
		new EmoteClue("Dance at the entrance to the Grand Exchange. Equip a pink skirt, pink robe top and a body tiara.", new WorldPoint(3165, 3467, 0), DANCE, PINK_SKIRT, PINK_ROBE_TOP, BODY_TIARA),
		new EmoteClue("Flap at the death altar. Beware of double agents! Equip a death tiara, a legend's cape and any ring of wealth.", new WorldPoint(2205, 4838, 0), FLAP, DEATH_TIARA, CAPE_OF_LEGENDS, RING_OF_WEALTH),
		new EmoteClue("Goblin Salute in the Goblin Village. Beware of double agents! Equip a bandos godsword, a bandos cloak and a bandos platebody.", new WorldPoint(2956, 3505, 0), GOBLIN_SALUTE, BANDOS_PLATEBODY, BANDOS_CLOAK, BANDOS_GODSWORD),
		new EmoteClue("Headbang in the mine north of Al Kharid. Equip a desert shirt, leather gloves and leather boots.", new WorldPoint(3124, 3304, 0), HEADBANG, DESERT_SHIRT, LEATHER_GLOVES, LEATHER_BOOTS),
		new EmoteClue("Headbang at the exam center. Beware of double agents! Equip a mystic fire staff, a diamond bracelet and rune boots.", new WorldPoint(3362, 3340, 0), HEADBANG, MYSTIC_FIRE_STAFF, DIAMOND_BRACELET, RUNE_BOOTS),
		new EmoteClue("Headbang at the top of Slayer Tower. Equip a seercull, a combat bracelet and helm of Neitiznot.", new WorldPoint(3115, 3420, 0), HEADBANG, SEERCULL, COMBAT_BRACELET, HELM_OF_NEITIZNOT),
		new EmoteClue("Headbang in the Fight Arena pub. Equip a pirate bandana, a dragonstone necklace and and a magic longbow.", new WorldPoint(2568, 3149, 0), HEADBANG, PIRATE_BANDANA, DRAGON_NECKLACE, MAGIC_LONGBOW),
		new EmoteClue("Dance a jig by the entrance to the Fishing Guild. Equip an emerald ring, a sapphire amulet, and a bronze chain body.", new WorldPoint(2610, 3391, 0), JIG, EMERALD_RING, SAPPHIRE_AMULET, BRONZE_CHAINBODY),
		new EmoteClue("Dance a jig under Shantay's Awning. Bow before you talk to me. Equip a pointed blue snail helmet, an air staff and a bronze square shield.", new WorldPoint(2983, 3305, 0), JIG, BOW, BRUISE_BLUE_SNELM_3343, STAFF_OF_AIR, BRONZE_SQ_SHIELD),
		new EmoteClue("Jig at Jiggig. Beware of double agents! Equip a Rune spear, rune platelegs and any rune heraldic helm.", new WorldPoint(2477, 3047, 0), JIG, RUNE_SPEAR, RUNE_PLATELEGS, RUNE_HELM_H1),
		new EmoteClue("Do a jig in Varrock's rune store. Equip an air tiara and a staff of water.", new WorldPoint(3253, 3401, 0), JIG, AIR_TIARA, STAFF_OF_WATER),
		new EmoteClue("Do a jig at the barrow's chest. Beware of double agents! Equip any full barrows set.", new WorldPoint(3551, 9694, 0), JIG),
		new EmoteClue("Jump for joy at the beehives. Equip a desert shirt, green gnome robe bottoms and a steel axe.", new WorldPoint(2759, 3445, 0), JUMP_FOR_JOY, DESERT_SHIRT, GREEN_ROBE_BOTTOMS, STEEL_AXE),
		new EmoteClue("Jump for joy in Yanille bank. Dance a jig before you talk to me. Equip a brown apron, adamantite medium helm and snakeskin chaps.", new WorldPoint(2760, 3299, 0), JUMP_FOR_JOY, JIG, BROWN_APRON, ADAMANT_MED_HELM, SNAKESKIN_CHAPS),
		new EmoteClue("Jump for joy in the TzHaar sword shop. Shrug before you talk to me. Equip a Steel longsword, Blue D'hide body and blue mystic gloves.", new WorldPoint(2477, 5146, 0), JUMP_FOR_JOY, SHRUG, STEEL_LONGSWORD, BLUE_DHIDE_BODY, MYSTIC_GLOVES),
		new EmoteClue("Jump for joy in the Ancient Cavern. Equip a granite shield, splitbark body, and any rune heraldic helm.", new WorldPoint(2339, 6787, 0), JUMP_FOR_JOY, GRANITE_SHIELD, SPLITBARK_BODY, RUNE_HELM_H1),
		new EmoteClue("Jump for joy at the Neitiznot rune rock. Equip Rune boots, a proselyte hauberk and a dragonstone ring.", new WorldPoint(2375, 3850, 0), JUMP_FOR_JOY, RUNE_BOOTS, PROSELYTE_HAUBERK, DRAGONSTONE_RING),
		new EmoteClue("Jump for joy in the centre of Zul-Andra. Beware of double agents! Equip a dragon 2h sword, bandos boots and an obsidian cape.", new WorldPoint(2199, 3056, 0), JUMP_FOR_JOY, DRAGON_2H_SWORD, BANDOS_BOOTS, OBSIDIAN_CAPE),
		new EmoteClue("Laugh by the fountain of heroes. Equip splitbark legs, dragon boots and a Rune longsword.", new WorldPoint(2716, 6584, 0), LAUGH, SPLITBARK_LEGS, DRAGON_BOOTS, RUNE_LONGSWORD),
		new EmoteClue("Laugh in Jokul's tent in the Mountain Camp. Beware of double agents! Equip a rune full helmet, blue dragonhide chaps and a fire battlestaff.", new WorldPoint(2812, 3681, 0), LAUGH, RUNE_FULL_HELM, BLUE_DHIDE_CHAPS, FIRE_BATTLESTAFF),
		new EmoteClue("Laugh at the crossroads south of the Sinclair Mansion. Equip a cowl, a blue wizard robe top and an iron scimitar.", new WorldPoint(2741, 3536, 0), LAUGH, LEATHER_COWL, EARTH_RUNE, IRON_SCIMITAR),
		new EmoteClue("Laugh in front of the gem store in Ardougne market. Equip a Castlewars bracelet, a dragonstone amulet and a ring of forging.", new WorldPoint(2666, 3304, 0), LAUGH, CASTLE_WARS_BRACELET3, DRAGONSTONE_AMULET, RING_OF_FORGING),
		new EmoteClue("Panic in the Limestone Mine. Equip bronze platelegs, a steel pickaxe and a steel medium helmet.", new WorldPoint(3372, 3498, 0), PANIC, BRONZE_PLATELEGS, STEEL_PICKAXE, STEEL_MED_HELM),
		new EmoteClue("Panic on the pier where you catch the Fishing trawler. Have nothing equipped at all when you do.", new WorldPoint(2676, 3169, 0), PANIC),
		new EmoteClue("Panic by the mausoleum in Morytania. Wave before you speak to me. Equip a mithril plate skirt, a maple longbow and no boots.", new WorldPoint(3504, 3576, 0), PANIC, WAVE, MITHRIL_PLATESKIRT, MAPLE_LONGBOW),
		new EmoteClue("Panic on the Wilderness volcano bridge. Beware of double agents! Equip any headband and crozier.", new WorldPoint(3368, 3935, 0), PANIC, RED_HEADBAND, SARADOMIN_CROZIER),
		new EmoteClue("Panic in the heart of the Haunted Woods. Beware of double agents! Have no items equipped when you do.", new WorldPoint(3611, 3492, 0), PANIC),
		new EmoteClue("Panic by the pilot on White Wolf Mountain. Beware of double agents! Equip mithril platelegs, a ring of life and a rune axe.", new WorldPoint(2847, 3499, 0), PANIC, MITHRIL_PLATELEGS, RING_OF_LIFE, RUNE_AXE),
		new EmoteClue("Panic by the big egg where no one dare goes and the ground is burnt. Beware of double agents! Equip a dragon med helm, a TokTz-Ket-Xil, a brine sabre, rune platebody and an uncharged amulet of glory.", new WorldPoint(3227, 3831, 0), PANIC, DRAGON_MED_HELM, TOKTZKETXIL, BRINE_SABRE, RUNE_PLATEBODY, AMULET_OF_GLORY),
		new EmoteClue("Panic at the area flowers meet snow. Equip Blue D'hide vambs, a dragon spear and a rune plateskirt.", new WorldPoint(2776, 3781, 0), PANIC, BLUE_DHIDE_VAMB, DRAGON_SPEAR, RUNE_PLATESKIRT, SLED_4084),
		new EmoteClue("Do a push up at the bank of the Warrior's guild. Beware of double agents! Equip a dragon battleaxe, a dragon defender and a slayer helm of any kind.", new WorldPoint(2843, 3543, 0), PUSH_UP, DRAGON_BATTLEAXE, DRAGON_DEFENDER, SLAYER_HELMET),
		new EmoteClue("Blow a raspberry at the bank of the Warrior's guild. Beware of double agents! Eqiup a dragon battleaxe, a dragon defender, and a slayer helmet of any kind.", new WorldPoint(2843, 3543, 0), RASPBERRY, DRAGON_BATTLEAXE, DRAGON_DEFENDER, SLAYER_HELMET),
		new EmoteClue("Blow a raspberry at the monkey cage in Ardougne Zoo. Equip a studded leather body, bronze platelegs and a normal staff with no orb.", new WorldPoint(2607, 3282, 0), RASPBERRY, STUDDED_BODY, BRONZE_PLATELEGS, STAFF),
		new EmoteClue("Blow raspberries outside the entrance to Keep Le Faye. Equip a coif, an iron platebody and leather gloves.", new WorldPoint(2757, 3401, 0), RASPBERRY, COIF, IRON_PLATEBODY, LEATHER_GLOVES),
		new EmoteClue("Blow a raspberry in the Fishing Guild bank. Beware of double agents! Equip an elemental shield, blue dragonhide chaps and a rune warhammer.", new WorldPoint(2588, 3419, 0), RASPBERRY, ELEMENTAL_SHIELD, BLUE_DHIDE_CHAPS, RUNE_WARHAMMER),
		new EmoteClue("Salute in the banana plantation. Beware of double agents! Equip a diamond ring, amulet of power, and nothing on your chest and legs.", new WorldPoint(2918, 3168, 0), SALUTE, DIAMOND_RING, AMULET_OF_POWER),
		new EmoteClue("Salute in the Warriors' guild bank. Equip only a black salamander.", new WorldPoint(2844, 3542, 0), SALUTE, BLACK_SALAMANDER),
		new EmoteClue("Salute in the centre of the mess hall. Beware of double agents! Equip a rune halberd rune platebody, and an amulet of strength.", new WorldPoint(1646, 3632, 0), SALUTE, RUNE_HALBERD, RUNE_PLATEBODY, AMULET_OF_STRENGTH),
		new EmoteClue("Shrug in the mine near Rimmington. Equip a gold necklace, a gold ring and a bronze spear.", new WorldPoint(2873, 3337, 0), SHRUG, GOLD_NECKLACE, GOLD_RING, BRONZE_SPEAR),
		new EmoteClue("Shrug in Catherby bank. Yawn before you talk to me. Equip a maple longbow, green d'hide chaps and an iron med helm.", new WorldPoint(2966, 3291, 0), SHRUG, YAWN, MAPLE_LONGBOW, GREEN_DHIDE_CHAPS, IRON_MED_HELM),
		new EmoteClue("Shrug in the Zamorak temple found in the Eastern Wilderness. Beware of double agents! Equip rune platelegs, an iron platebody and blue dragonhide vambraces.", new WorldPoint(3239, 3611, 0), SHRUG, RUNE_PLATELEGS, IRON_PLATEBODY, BLUE_DHIDE_VAMB),
		new EmoteClue("Shrug in the Shayzien command tent. Equip a blue mystic robe bottom, a rune kiteshield, and any bob shirt.", new WorldPoint(1555, 3537, 0), SHRUG, MYSTIC_ROBE_BOTTOM, RUNE_KITESHIELD, BOBS_BLACK_SHIRT),
		new EmoteClue("Slap your head in the centre of the Kourend catacombs. Beware of double agents! Equip the arclight and the amulet of the damned.", new WorldPoint(1663, 10045, 0), SLAP_HEAD, ARCLIGHT, AMULET_OF_THE_DAMNED),
		new EmoteClue("Spin at the crossroads north of Rimmington. Equip a green gnome hat, cream gnome top and leather chaps.", new WorldPoint(2981, 3276, 0), SPIN, GREEN_HAT, CREAM_ROBE_TOP, LEATHER_CHAPS),
		new EmoteClue("Spin in Draynor Manor by the fountain. Equip an iron platebody, studded leather chaps and a bronze full helmet.", new WorldPoint(3088, 3336, 0), SPIN, IRON_PLATELEGS, STUDDED_CHAPS, BRONZE_FULL_HELM),
		new EmoteClue("Spin in front of the Soul altar. Beware of double agents! Equip a dragon pickaxe, helm of neitiznot and a pair of rune boots.", new WorldPoint(1815, 3856, 0), SPIN, DRAGON_PICKAXE, HELM_OF_NEITIZNOT, RUNE_BOOTS),
		new EmoteClue("Spin in the Varrock Castle courtyard. Equip a black axe, a coif and a ruby ring.", new WorldPoint(3213, 3463, 0), SPIN, BLACK_AXE, COIF, RUBY_RING),
		new EmoteClue("Spin in West Ardougne Church. Equip a dragon spear and red dragonhide chaps.", new WorldPoint(2404, 4326, 0), SPIN, DRAGON_SPEAR, RED_DHIDE_CHAPS),
		new EmoteClue("Spin on the bridge by the Barbarian Village. Salute before you talk to me. Equip purple gloves, a steel kiteshield and a mithril full helmet.", new WorldPoint(3058, 3334, 0), SPIN, SALUTE, PURPLE_GLOVES, STEEL_KITESHIELD, MITHRIL_FULL_HELM),
		new EmoteClue("Stamp in the Enchanted valley west of the waterfall. Beware of double agents! Equip a dragon axe.", new WorldPoint(3034, 4518, 0), STOMP, DRAGON_AXE),
		new EmoteClue("Think in middle of the wheat field by the Lumbridge mill. Equip a blue gnome robetop, a turquoise gnome robe bottom and an oak shortbow.", new WorldPoint(3159, 3298, 0), THINK, BLUE_ROBE_TOP, TURQUOISE_ROBE_BOTTOMS, OAK_SHORTBOW),
		new EmoteClue("Think in the centre of the Observatory. Spin before you talk to me. Equip a mithril chain body, green dragonhide chaps and a ruby amulet.", new WorldPoint(2439, 3161, 0), THINK, SPIN, MITHRIL_CHAINBODY, GREEN_DHIDE_CHAPS, RUBY_AMULET),
		new EmoteClue("Wave along the south fence of the Lumber Yard. Equip a hard leather body, leather chaps and a bronze axe.", new WorldPoint(3307, 3491, 0), WAVE, HARDLEATHER_BODY, LEATHER_CHAPS, BRONZE_AXE),
		new EmoteClue("Wave in the Falador gem store. Equip a Mithril pickaxe, Black platebody and an Iron Kiteshield.", new WorldPoint(2945, 3335, 0), WAVE, MITHRIL_PICKAXE, BLACK_PLATEBODY, IRON_KITESHIELD),
		new EmoteClue("Wave on Mudskipper Point. Equip a black cape, leather chaps and a steel mace.", new WorldPoint(2989, 3110, 0), WAVE, BLACK_CAPE, LEATHER_CHAPS, STEEL_MACE),
		new EmoteClue("Wave on the the nothern wall of Castle Drakan. Beware of double agents! Wear a dragon sq shield, splitbark body and any boater.", new WorldPoint(3560, 3385, 0), WAVE, DRAGON_SQ_SHIELD, SPLITBARK_BODY, RED_BOATER),
		new EmoteClue("Yawn in the 7th room of Pyramid Plunder. Beware of double agents! Equip a pharoah sceptre and a full set of menaphite robes.", new WorldPoint(1944, 4427, 0), YAWN, PHARAOHS_SCEPTRE_3, MENAPHITE_PURPLE_HAT, MENAPHITE_PURPLE_TOP, MENAPHITE_PURPLE_ROBE),
		new EmoteClue("Yawn in the Varrock library. Equip a green gnome robe top, HAM robe bottom and an iron warhammer.", new WorldPoint(3209, 3492, 0), YAWN, GREEN_ROBE_TOP, HAM_ROBE, IRON_WARHAMMER),
		new EmoteClue("Yawn in Draynor Marketplace. Equip studded leather chaps, an iron kiteshield and a steel longsword.", new WorldPoint(3083, 3253, 0), YAWN, STUDDED_CHAPS, IRON_KITESHIELD, STEEL_LONGSWORD),
		new EmoteClue("Yawn in the Castle Wars lobby. Shrug before you talk to me. Equip a ruby amulet, a mithril scimitar and a Wilderness cape.", new WorldPoint(2772, 3251, 0), YAWN, SHRUG, RUBY_AMULET, MITHRIL_SCIMITAR, TEAM1_CAPE),
		new EmoteClue("Yawn in the rogues' general store. Beware of double agents! Equip an adamant square shield, blue dragon vambraces and a rune pickaxe.", new WorldPoint(3026, 3701, 0), YAWN, ADAMANT_SQ_SHIELD, BLUE_DHIDE_VAMB, RUNE_PICKAXE),
		new EmoteClue("Yawn at the top of Trollheim. Equip a lava battlestaff, black dragonhide vambraces and a mind shield.", new WorldPoint(2590, 4452, 0), YAWN, LAVA_BATTLESTAFF, BLACK_DHIDE_VAMB, MIND_SHIELD),
		new EmoteClue("Yawn in the centre of Arceuus library. Nod your head before you talk to me. Equip blue dragonhide vambraces, adamant boots and an adamant dagger.", new WorldPoint(1632, 3807, 0), YAWN, YES, BLUE_DHIDE_VAMB, ADAMANT_BOOTS, ADAMANT_DAGGER),
		new EmoteClue("Swing a bullroarer at the top of the watchtower. Beware of double agents! Equip a dragon plateskirt, climbing boots and a dragon chainbody.", new WorldPoint(2932, 4712, 0), BULL_ROARER, DRAGON_PLATESKIRT, CLIMBING_BOOTS, DRAGON_CHAINBODY_3140)
	);

	private String text;
	private WorldPoint location;
	private Emote firstEmote;
	private Emote secondEmote;
	private int[] itemIds;

	private EmoteClue(String text, WorldPoint location, Emote emote, int... itemIds)
	{
		this(text, location, emote, null, itemIds);
	}

	private EmoteClue(String text, WorldPoint location, Emote firstEmote, Emote secondEmote, int... itemIds)
	{
		this.text = text;
		this.location = location;
		this.firstEmote = firstEmote;
		this.secondEmote = secondEmote;
		this.itemIds = itemIds;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.setTitle("Emote Clue");

		panelComponent.getLines().add(new PanelComponent.Line("Emotes:"));
		panelComponent.getLines().add(new PanelComponent.Line(getFirstEmote().getName(), TITLED_CONTENT_COLOR));
		if (getSecondEmote() != null)
		{
			panelComponent.getLines().add(new PanelComponent.Line(getSecondEmote().getName(), TITLED_CONTENT_COLOR));
		}

		if (getItemIds().length != 0)
		{
			panelComponent.setWidth(160);
			panelComponent.getLines().add(new PanelComponent.Line("Equip:"));

			if (plugin.getEquippedItems() != null)
			{
				for (int itemId : getItemIds())
				{
					ItemComposition itemDefinition = plugin.getClient().getItemDefinition(itemId);

					if (itemDefinition != null)
					{
						if (plugin.getEquippedItems().contains(itemId))
						{
							panelComponent.getLines().add(new PanelComponent.Line(itemDefinition.getName(), TITLED_CONTENT_COLOR, "X", Color.GREEN));
						}
						else
						{
							panelComponent.getLines().add(new PanelComponent.Line(itemDefinition.getName(), TITLED_CONTENT_COLOR, "-", Color.RED));
						}
					}
				}
			}
		}
		else
		{
			panelComponent.setWidth(130);
			panelComponent.getLines().add(new PanelComponent.Line("Items:", "None"));
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		if (!plugin.getClient().hasHintArrow())
		{
			plugin.getClient().setHintArrow(getLocation());
		}

		LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation());

		if (localLocation == null)
		{
			return;
		}

		OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, EMOTE_IMAGE, Color.ORANGE);
	}

	public static EmoteClue forText(String text)
	{
		for (EmoteClue clue : CLUES)
		{
			if (clue.text.equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return null;
	}
}
