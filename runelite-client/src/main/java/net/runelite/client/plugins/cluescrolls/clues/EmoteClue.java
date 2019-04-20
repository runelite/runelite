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
import javax.annotation.Nonnull;
import lombok.Getter;
import net.runelite.api.EquipmentInventorySlot;
import static net.runelite.api.EquipmentInventorySlot.*;
import static net.runelite.api.EquipmentInventorySlot.LEGS;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import static net.runelite.api.ItemID.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.plugins.cluescrolls.clues.emote.AllRequirementsCollection;
import net.runelite.client.plugins.cluescrolls.clues.emote.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.emote.Emote;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.*;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.BULL_ROARER;
import net.runelite.client.plugins.cluescrolls.clues.emote.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.emote.RangeItemRequirement;
import static net.runelite.client.plugins.cluescrolls.clues.emote.STASHUnit.*;
import static net.runelite.client.plugins.cluescrolls.clues.emote.STASHUnit.SHANTAY_PASS;
import net.runelite.client.plugins.cluescrolls.clues.emote.SingleItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.emote.SlotLimitationRequirement;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class EmoteClue extends ClueScroll implements TextClueScroll, LocationClueScroll
{
	private static final Set<EmoteClue> CLUES = ImmutableSet.of(
		new EmoteClue("Beckon on the east coast of the Kharazi Jungle. Beware of double agents! Equip any vestment stole and a heraldic rune shield.", NORTHEAST_CORNER_OF_THE_KHARAZI_JUNGLE, new WorldPoint(2954, 2933, 0), BECKON, any("Any stole", item(GUTHIX_STOLE), item(SARADOMIN_STOLE), item(ZAMORAK_STOLE), item(ARMADYL_STOLE), item(BANDOS_STOLE), item(ANCIENT_STOLE)), any("Any heraldic rune shield", item(RUNE_SHIELD_H1), item(RUNE_SHIELD_H2), item(RUNE_SHIELD_H3), item(RUNE_SHIELD_H4), item(RUNE_SHIELD_H5))),
		new EmoteClue("Cheer in the Barbarian Agility Arena. Headbang before you talk to me. Equip a steel platebody, maple shortbow and a Wilderness cape.", BARBARIAN_OUTPOST_OBSTACLE_COURSE, new WorldPoint(2552, 3556, 0), CHEER, HEADBANG, item(STEEL_PLATEBODY), item(MAPLE_SHORTBOW), range("Any team cape", TEAM1_CAPE, TEAM50_CAPE)),
		new EmoteClue("Bow upstairs in the Edgeville Monastery. Equip a completed prayer book.", SOUTHEAST_CORNER_OF_THE_MONASTERY, new WorldPoint(3056, 3484, 1), BOW, any("Any god book", item(HOLY_BOOK), item(BOOK_OF_BALANCE), item(UNHOLY_BOOK), item(BOOK_OF_LAW), item(BOOK_OF_WAR), item(BOOK_OF_DARKNESS))),
		new EmoteClue("Cheer in the Shadow dungeon. Equip a rune crossbow, climbing boots and any mitre.", ENTRANCE_OF_THE_CAVE_OF_DAMIS, new WorldPoint(2629, 5071, 0), CHEER, any("Any mitre", item(GUTHIX_MITRE), item(SARADOMIN_MITRE), item(ZAMORAK_MITRE), item(ANCIENT_MITRE), item(BANDOS_MITRE), item(ARMADYL_MITRE)), item(RUNE_CROSSBOW), item(CLIMBING_BOOTS), item(RING_OF_VISIBILITY)),
		new EmoteClue("Cheer at the top of the agility pyramid. Beware of double agents! Equip a blue mystic robe top, and any rune heraldic shield.", AGILITY_PYRAMID, new WorldPoint(3043, 4697, 3), CHEER, item(MYSTIC_ROBE_TOP), any("Any rune heraldic shield", item(RUNE_SHIELD_H1), item(RUNE_SHIELD_H2), item(RUNE_SHIELD_H3), item(RUNE_SHIELD_H4), item(RUNE_SHIELD_H5))),
		new EmoteClue("Dance in Iban's temple. Beware of double agents! Equip Iban's staff, a black mystic top and a black mystic bottom.", WELL_OF_VOYAGE, new WorldPoint(2011, 4712, 0), DANCE, any("Any iban's staff", item(IBANS_STAFF), item(IBANS_STAFF_U)), item(MYSTIC_ROBE_TOP_DARK), item(MYSTIC_ROBE_BOTTOM_DARK)),
		new EmoteClue("Dance on the Fishing Platform. Equip barrows gloves, an amulet of glory and a dragon med helm.", SOUTHEAST_CORNER_OF_THE_FISHING_PLATFORM, new WorldPoint(2782, 3273, 0), DANCE, any("Any amulet of glory", item(AMULET_OF_GLORY), item(AMULET_OF_GLORY1), item(AMULET_OF_GLORY2), item(AMULET_OF_GLORY3), item(AMULET_OF_GLORY4), item(AMULET_OF_GLORY5), item(AMULET_OF_GLORY6)), item(BARROWS_GLOVES), item(DRAGON_MED_HELM)),
		new EmoteClue("Flap at the death altar. Beware of double agents! Equip a death tiara, a legend's cape and any ring of wealth.", DEATH_ALTAR, new WorldPoint(2205, 4838, 0), FLAP, any("Any ring of wealth", item(RING_OF_WEALTH), item(RING_OF_WEALTH_1), item(RING_OF_WEALTH_2), item(RING_OF_WEALTH_3), item(RING_OF_WEALTH_4), item(RING_OF_WEALTH_5), item(RING_OF_WEALTH_I), item(RING_OF_WEALTH_I1), item(RING_OF_WEALTH_I2), item(RING_OF_WEALTH_I3), item(RING_OF_WEALTH_I4), item(RING_OF_WEALTH_I5)), item(DEATH_TIARA), item(CAPE_OF_LEGENDS)),
		new EmoteClue("Headbang in the Fight Arena pub. Equip a pirate bandana, a dragonstone necklace and and a magic longbow.", OUTSIDE_THE_BAR_BY_THE_FIGHT_ARENA, new WorldPoint(2568, 3149, 0), HEADBANG, any("Any pirate bandana", item(PIRATE_BANDANA), item(PIRATE_BANDANA_7124), item(PIRATE_BANDANA_7130), item(PIRATE_BANDANA_7136)), item(DRAGON_NECKLACE), item(MAGIC_LONGBOW)),
		new EmoteClue("Do a jig at the barrow's chest. Beware of double agents! Equip any full barrows set.", BARROWS_CHEST, new WorldPoint(3551, 9694, 0), JIG, any("Any full barrows set", all(range(AHRIMS_HOOD_100, AHRIMS_HOOD_0), range(AHRIMS_STAFF_100, AHRIMS_STAFF_0), range(AHRIMS_ROBETOP_100, AHRIMS_ROBETOP_0), range(AHRIMS_ROBESKIRT_100, AHRIMS_ROBESKIRT_0)), all(range(DHAROKS_HELM_100, DHAROKS_HELM_0), range(DHAROKS_GREATAXE_100, DHAROKS_GREATAXE_0), range(DHAROKS_PLATEBODY_100, DHAROKS_PLATEBODY_0), range(DHAROKS_PLATELEGS_100, DHAROKS_PLATELEGS_0)), all(range(GUTHANS_HELM_100, GUTHANS_HELM_0), range(GUTHANS_WARSPEAR_100, GUTHANS_WARSPEAR_0), range(GUTHANS_PLATEBODY_100, GUTHANS_PLATEBODY_0), range(GUTHANS_CHAINSKIRT_100, GUTHANS_CHAINSKIRT_0)), all(range(KARILS_COIF_100, KARILS_COIF_0), range(KARILS_CROSSBOW_100, KARILS_CROSSBOW_0), range(KARILS_LEATHERTOP_100, KARILS_LEATHERTOP_0), range(KARILS_LEATHERSKIRT_100, KARILS_LEATHERSKIRT_0)), all(range(TORAGS_HELM_100, TORAGS_HELM_0), range(TORAGS_HAMMERS_100, TORAGS_HAMMERS_0), range(TORAGS_PLATEBODY_100, TORAGS_PLATEBODY_0), range(TORAGS_PLATELEGS_100, TORAGS_PLATELEGS_0)), all(range(VERACS_HELM_100, VERACS_HELM_0), range(VERACS_FLAIL_100, VERACS_FLAIL_0), range(VERACS_BRASSARD_100, VERACS_BRASSARD_0), range(VERACS_PLATESKIRT_100, VERACS_PLATESKIRT_0)))),
		new EmoteClue("Jig at Jiggig. Beware of double agents! Equip a Rune spear, rune platelegs and any rune heraldic helm.", IN_THE_MIDDLE_OF_JIGGIG, new WorldPoint(2477, 3047, 0), JIG, range("Any rune heraldic helm", RUNE_HELM_H1, RUNE_HELM_H5), item(RUNE_SPEAR), item(RUNE_PLATELEGS)),
		new EmoteClue("Cheer at the games room. Have nothing equipped at all when you do.", null, new WorldPoint(2207, 4952, 0), CHEER, emptySlot("Nothing at all", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue("Panic on the pier where you catch the Fishing trawler. Have nothing equipped at all when you do.", null, new WorldPoint(2676, 3169, 0), PANIC, emptySlot("Nothing at all", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue("Panic in the heart of the Haunted Woods. Beware of double agents! Have no items equipped when you do.", null, new WorldPoint(3611, 3492, 0), PANIC, emptySlot("Nothing at all", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue("Show your anger towards the Statue of Saradomin in Ellamaria's garden. Beware of double agents! Equip a zamorak godsword.", BY_THE_BEAR_CAGE_IN_VARROCK_PALACE_GARDENS, new WorldPoint(3230, 3478, 0), ANGRY, item(ZAMORAK_GODSWORD)),
		new EmoteClue("Show your anger at the Wise old man. Beware of double agents! Equip an abyssal whip, a legend's cape and some spined chaps.", BEHIND_MISS_SCHISM_IN_DRAYNOR_VILLAGE, new WorldPoint(3088, 3254, 0), ANGRY, any("Abyssal whip", item(ABYSSAL_WHIP), item(VOLCANIC_ABYSSAL_WHIP), item(FROZEN_ABYSSAL_WHIP)), item(CAPE_OF_LEGENDS), item(SPINED_CHAPS)),
		new EmoteClue("Beckon in the Digsite, near the eastern winch. Bow before you talk to me. Equip a green gnome hat, snakeskin boots and an iron pickaxe.", DIGSITE, new WorldPoint(3370, 3425, 0), BECKON, BOW, item(GREEN_HAT), item(SNAKESKIN_BOOTS), item(IRON_PICKAXE)),
		new EmoteClue("Beckon in Tai Bwo Wannai. Clap before you talk to me. Equip green dragonhide chaps, a ring of dueling and a mithril medium helmet.", SOUTH_OF_THE_SHRINE_IN_TAI_BWO_WANNAI_VILLAGE, new WorldPoint(2803, 3073, 0), BECKON, CLAP, item(GREEN_DHIDE_CHAPS), any("Ring of dueling", item(RING_OF_DUELING1), item(RING_OF_DUELING2), item(RING_OF_DUELING3), item(RING_OF_DUELING4), item(RING_OF_DUELING5), item(RING_OF_DUELING6), item(RING_OF_DUELING7), item(RING_OF_DUELING8)), item(MITHRIL_MED_HELM)),
		new EmoteClue("Beckon in the combat ring of Shayzien. Show your anger before you talk to me. Equip an adamant platebody, adamant full helm and adamant platelegs.", WEST_OF_THE_SHAYZIEN_COMBAT_RING, new WorldPoint(1545, 3594, 0), BECKON, ANGRY, item(ADAMANT_PLATELEGS), item(ADAMANT_PLATEBODY), item(ADAMANT_FULL_HELM)),
		new EmoteClue("Bow near Lord Iorwerth. Beware of double agents! Equip a new imbued crystal bow.", TENT_IN_LORD_IORWERTHS_ENCAMPMENT, new WorldPoint(2205, 3252, 0), BOW, any("Imbued crystal bow", item(NEW_CRYSTAL_BOW_I), item(CRYSTAL_BOW_FULL_I), item(CRYSTAL_BOW_910_I), item(CRYSTAL_BOW_810_I), item(CRYSTAL_BOW_710_I), item(CRYSTAL_BOW_610_I), item(CRYSTAL_BOW_510_I), item(CRYSTAL_BOW_410_I), item(CRYSTAL_BOW_310_I), item(CRYSTAL_BOW_210_I), item(CRYSTAL_BOW_110_I))),
		new EmoteClue("Bow outside the entrance to the Legends' Guild. Equip iron platelegs, an emerald amulet and an oak longbow.", OUTSIDE_THE_LEGENDS_GUILD_GATES, new WorldPoint(2729, 3349, 0), BOW, item(IRON_PLATELEGS), item(OAK_LONGBOW), item(EMERALD_AMULET)),
		new EmoteClue("Bow on the ground floor of the Legend's guild. Equip Legend's cape, a dragon battleaxe and an amulet of glory.", OUTSIDE_THE_LEGENDS_GUILD_DOOR, new WorldPoint(2728, 3377, 0), BOW, item(CAPE_OF_LEGENDS), item(DRAGON_BATTLEAXE), any("Any amulet of glory", item(AMULET_OF_GLORY), item(AMULET_OF_GLORY1), item(AMULET_OF_GLORY2), item(AMULET_OF_GLORY3), item(AMULET_OF_GLORY4), item(AMULET_OF_GLORY5), item(AMULET_OF_GLORY6))),
		new EmoteClue("Bow in the ticket office of the Duel Arena. Equip an iron chain body, leather chaps and coif.", MUBARIZS_ROOM_AT_THE_DUEL_ARENA, new WorldPoint(3314, 3241, 0), BOW, item(IRON_CHAINBODY), item(LEATHER_CHAPS), item(COIF)),
		new EmoteClue("Bow at the top of the lighthouse. Beware of double agents! Equip a blue dragonhide body, blue dragonhide vambraces and no jewelry.", TOP_FLOOR_OF_THE_LIGHTHOUSE, new WorldPoint(2511, 3641, 2), BOW, item(BLUE_DHIDE_BODY), item(BLUE_DHIDE_VAMB), emptySlot("No jewelry", AMULET, RING)),
		new EmoteClue("Blow a kiss between the tables in Shilo Village bank. Beware of double agents! Equip a blue mystic hat, bone spear and rune platebody.", SHILO_VILLAGE_BANK, new WorldPoint(2851, 2954, 0), BLOW_KISS, item(MYSTIC_HAT), item(BONE_SPEAR), item(RUNE_PLATEBODY)),
		new EmoteClue("Blow a kiss in the heart of the lava maze. Equip black dragonhide chaps, a spotted cape and a rolling pin.", NEAR_A_LADDER_IN_THE_WILDERNESS_LAVA_MAZE, new WorldPoint(3069, 3861, 0), BLOW_KISS, item(BLACK_DHIDE_CHAPS), any("Spotted cape", item(SPOTTED_CAPE), item(SPOTTED_CAPE_10073)), item(ROLLING_PIN)),
		new EmoteClue("Blow a kiss outside K'ril Tsutsaroth's chamber. Beware of double agents! Equip a zamorak full helm and the shadow sword.", OUTSIDE_KRIL_TSUTSAROTHS_ROOM, new WorldPoint(2925, 5333, 0), BLOW_KISS, item(ZAMORAK_FULL_HELM), item(SHADOW_SWORD)),
		new EmoteClue("Cheer at the Druids' Circle. Equip a blue wizard hat, a bronze two-handed sword and HAM boots.", TAVERLEY_STONE_CIRCLE, new WorldPoint(2924, 3478, 0), CHEER, item(BLUE_WIZARD_HAT), item(BRONZE_2H_SWORD), item(HAM_BOOTS)),
		new EmoteClue("Cheer in the Edgeville general store. Dance before you talk to me. Equip a brown apron, leather boots and leather gloves.", NORTH_OF_EVIL_DAVES_HOUSE_IN_EDGEVILLE, new WorldPoint(3080, 3509, 0), CHEER, DANCE, item(BROWN_APRON), item(LEATHER_BOOTS), item(LEATHER_GLOVES)),
		new EmoteClue("Cheer in the Ogre Pen in the Training Camp. Show you are angry before you talk to me. Equip a green dragonhide body and chaps and a steel square shield.", OGRE_CAGE_IN_KING_LATHAS_TRAINING_CAMP, new WorldPoint(2527, 3375, 0), CHEER, ANGRY, item(GREEN_DHIDE_BODY), item(GREEN_DHIDE_CHAPS), item(STEEL_SQ_SHIELD)),
		new EmoteClue("Cheer in the Entrana church. Beware of double agents! Equip a full set of black dragonhide armour.", ENTRANA_CHAPEL, new WorldPoint(2852, 3349, 0), CHEER, item(BLACK_DHIDE_VAMB), item(BLACK_DHIDE_CHAPS), item(BLACK_DHIDE_BODY)),
		new EmoteClue("Cheer for the monks at Port Sarim. Equip a coif, steel plateskirt and a sapphire necklace.", NEAR_THE_ENTRANA_FERRY_IN_PORT_SARIM, new WorldPoint(3047, 3237, 0), CHEER, item(COIF), item(STEEL_PLATESKIRT), item(SAPPHIRE_NECKLACE)),
		new EmoteClue("Clap in the main exam room in the Exam Centre. Equip a white apron, green gnome boots and leather gloves.", INSIDE_THE_DIGSITE_EXAM_CENTRE, new WorldPoint(3361, 3339, 0), CLAP, item(WHITE_APRON), item(GREEN_BOOTS), item(LEATHER_GLOVES)),
		new EmoteClue("Clap on the causeway to the Wizards' Tower. Equip an iron medium helmet, emerald ring and a white apron.", ON_THE_BRIDGE_TO_THE_MISTHALIN_WIZARDS_TOWER, new WorldPoint(3113, 3196, 0), CLAP, item(IRON_MED_HELM), item(EMERALD_RING), item(WHITE_APRON)),
		new EmoteClue("Clap on the top level of the mill, north of East Ardougne. Equip a blue gnome robe top, HAM robe bottom and an unenchanted tiara.", UPSTAIRS_IN_THE_ARDOUGNE_WINDMILL, new WorldPoint(2635, 3385, 3), CLAP, item(BLUE_ROBE_TOP), item(HAM_ROBE), item(TIARA)),
		new EmoteClue("Clap in Seers court house. Spin before you talk to me. Equip an adamant halberd, blue mystic robe bottom and a diamond ring.", OUTSIDE_THE_SEERS_VILLAGE_COURTHOUSE, new WorldPoint(2735, 3469, 0), CLAP, SPIN, item(ADAMANT_HALBERD), item(MYSTIC_ROBE_BOTTOM), item(DIAMOND_RING)),
		new EmoteClue("Clap in the magic axe hut. Beware of double agents! Equip only some flared trousers.", OUTSIDE_THE_WILDERNESS_AXE_HUT, new WorldPoint(3191, 3960, 0), CLAP, item(FLARED_TROUSERS), item(LOCKPICK), emptySlot("Nothing else", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue("Clap your hands north of Mount Karuulm Spin before you talk to me. Equip an adamant warhammer, a ring of life and a pair of mithril boots.", NORTH_OF_MOUNT_KARUULM, new WorldPoint(1306, 3839, 0), CLAP, SPIN, item(ADAMANT_WARHAMMER), item(RING_OF_LIFE), item(MITHRIL_BOOTS)),
		new EmoteClue("Cry in the Catherby Ranging shop. Bow before you talk to me. Equip blue gnome boots, a hard leather body and an unblessed silver sickle.", HICKTONS_ARCHERY_EMPORIUM, new WorldPoint(2823, 3443, 0), CRY, BOW, item(BLUE_BOOTS), item(HARDLEATHER_BODY), item(SILVER_SICKLE)),
		new EmoteClue("Cry on the shore of Catherby beach. Laugh before you talk to me, equip an adamant sq shield, a bone dagger and mithril platebody.", OUTSIDE_HARRYS_FISHING_SHOP_IN_CATHERBY, new WorldPoint(2852, 3429, 0), CRY, LAUGH, item(ADAMANT_SQ_SHIELD), item(BONE_DAGGER), item(MITHRIL_PLATEBODY)),
		new EmoteClue("Cry on top of the western tree in the Gnome Agility Arena. Indicate 'no' before you talk to me. Equip a steel kiteshield, ring of forging and green dragonhide chaps.", GNOME_STRONGHOLD_BALANCING_ROPE, new WorldPoint(2473, 3420, 2), CRY, NO, item(STEEL_KITESHIELD), item(RING_OF_FORGING), item(GREEN_DHIDE_CHAPS)),
		new EmoteClue("Cry in the TzHaar gem store. Beware of double agents! Equip a fire cape and TokTz-Xil-Ul.", TZHAAR_GEM_STORE, new WorldPoint(2463, 5149, 0), CRY, any("Fire cape", item(FIRE_CAPE), item(FIRE_MAX_CAPE)), item(TOKTZXILUL)),
		new EmoteClue("Cry in the Draynor Village jail. Jump for joy before you talk to me. Equip an adamant sword, a sapphire amulet and an adamant plateskirt.", OUTSIDE_DRAYNOR_VILLAGE_JAIL, new WorldPoint(3128, 3245, 0), CRY, JUMP_FOR_JOY, item(ADAMANT_SWORD), item(SAPPHIRE_AMULET), item(ADAMANT_PLATESKIRT)),
		new EmoteClue("Dance at the crossroads north of Draynor. Equip an iron chain body, a sapphire ring and a longbow.", CROSSROADS_NORTH_OF_DRAYNOR_VILLAGE, new WorldPoint(3109, 3294, 0), DANCE, item(IRON_CHAINBODY), item(SAPPHIRE_RING), item(LONGBOW)),
		new EmoteClue("Dance in the Party Room. Equip a steel full helmet, steel platebody and an iron plateskirt.", OUTSIDE_THE_FALADOR_PARTY_ROOM, new WorldPoint(3045, 3376, 0), DANCE, item(STEEL_FULL_HELM), item(STEEL_PLATEBODY), item(IRON_PLATESKIRT)),
		new EmoteClue("Dance in the shack in Lumbridge Swamp. Equip a bronze dagger, iron full helmet and a gold ring.", NEAR_A_SHED_IN_LUMBRIDGE_SWAMP, new WorldPoint(3203, 3169, 0), DANCE, item(BRONZE_DAGGER), item(IRON_FULL_HELM), item(GOLD_RING)),
		new EmoteClue("Dance in the dark caves beneath Lumbridge Swamp. Blow a kiss before you talk to me. Equip an air staff, Bronze full helm and an amulet of power.", LUMBRIDGE_SWAMP_CAVES, new WorldPoint(3168, 9571, 0), DANCE, BLOW_KISS, item(STAFF_OF_AIR), item(BRONZE_FULL_HELM), item(AMULET_OF_POWER)),
		new EmoteClue("Dance at the cat-doored pyramid in Sophanem. Beware of double agents! Equip a ring of life, an uncharged amulet of glory and an adamant two-handed sword.", OUTSIDE_THE_GREAT_PYRAMID_OF_SOPHANEM, new WorldPoint(3294, 2781, 0), DANCE, item(RING_OF_LIFE), item(AMULET_OF_GLORY), item(ADAMANT_2H_SWORD)),
		new EmoteClue("Dance in the centre of Canifis. Bow before you talk to me. Equip a green gnome robe top, mithril plate legs and an iron two-handed sword.", CENTRE_OF_CANIFIS, new WorldPoint(3492, 3488, 0), DANCE, BOW, item(GREEN_ROBE_TOP), item(MITHRIL_PLATELEGS), item(IRON_2H_SWORD)),
		new EmoteClue("Dance in the King Black Dragon's lair. Beware of double agents! Equip a black dragonhide body, black dragonhide vambs and a black dragon mask.", KING_BLACK_DRAGONS_LAIR, new WorldPoint(2271, 4680, 0), DANCE, item(BLACK_DHIDE_BODY), item(BLACK_DHIDE_VAMB), item(BLACK_DRAGON_MASK)),
		new EmoteClue("Dance at the entrance to the Grand Exchange. Equip a pink skirt, pink robe top and a body tiara.", SOUTH_OF_THE_GRAND_EXCHANGE, new WorldPoint(3165, 3467, 0), DANCE, item(PINK_SKIRT), item(PINK_ROBE_TOP), item(BODY_TIARA)),
		new EmoteClue("Goblin Salute in the Goblin Village. Beware of double agents! Equip a bandos godsword, a bandos cloak and a bandos platebody.", OUTSIDE_MUDKNUCKLES_HUT, new WorldPoint(2956, 3505, 0), GOBLIN_SALUTE, item(BANDOS_PLATEBODY), item(BANDOS_CLOAK), item(BANDOS_GODSWORD)),
		new EmoteClue("Headbang in the mine north of Al Kharid. Equip a desert shirt, leather gloves and leather boots.", AL_KHARID_SCORPION_MINE, new WorldPoint(3299, 3289, 0), HEADBANG, item(DESERT_SHIRT), item(LEATHER_GLOVES), item(LEATHER_BOOTS)),
		new EmoteClue("Headbang at the exam center. Beware of double agents! Equip a mystic fire staff, a diamond bracelet and rune boots.", OUTSIDE_THE_DIGSITE_EXAM_CENTRE, new WorldPoint(3362, 3340, 0), HEADBANG, item(MYSTIC_FIRE_STAFF), item(DIAMOND_BRACELET), item(RUNE_BOOTS)),
		new EmoteClue("Headbang at the top of Slayer Tower. Equip a seercull, a combat bracelet and helm of Neitiznot.", OUTSIDE_THE_SLAYER_TOWER_GARGOYLE_ROOM, new WorldPoint(3421, 3537, 2), HEADBANG, item(SEERCULL), range("Combat bracelet", COMBAT_BRACELET4, COMBAT_BRACELET), item(HELM_OF_NEITIZNOT)),
		new EmoteClue("Dance a jig by the entrance to the Fishing Guild. Equip an emerald ring, a sapphire amulet, and a bronze chain body.", OUTSIDE_THE_FISHING_GUILD, new WorldPoint(2610, 3391, 0), JIG, item(EMERALD_RING), item(SAPPHIRE_AMULET), item(BRONZE_CHAINBODY)),
		new EmoteClue("Dance a jig under Shantay's Awning. Bow before you talk to me. Equip a pointed blue snail helmet, an air staff and a bronze square shield.", SHANTAY_PASS, new WorldPoint(3304, 3124, 0), JIG, BOW, any("Bruise blue snelm (pointed)", item(BRUISE_BLUE_SNELM_3343)), item(STAFF_OF_AIR), item(BRONZE_SQ_SHIELD)),
		new EmoteClue("Do a jig in Varrock's rune store. Equip an air tiara and a staff of water.", AUBURYS_SHOP_IN_VARROCK, new WorldPoint(3253, 3401, 0), JIG, item(AIR_TIARA), item(STAFF_OF_WATER)),
		new EmoteClue("Jump for joy at the beehives. Equip a desert shirt, green gnome robe bottoms and a steel axe.", CATHERBY_BEEHIVE_FIELD, new WorldPoint(2759, 3445, 0), JUMP_FOR_JOY, item(DESERT_SHIRT), item(GREEN_ROBE_BOTTOMS), item(STEEL_AXE)),
		new EmoteClue("Jump for joy in Yanille bank. Dance a jig before you talk to me. Equip a brown apron, adamantite medium helmet and snakeskin chaps.", OUTSIDE_YANILLE_BANK, new WorldPoint(2610, 3092, 0), JUMP_FOR_JOY, JIG, item(BROWN_APRON), item(ADAMANT_MED_HELM), item(SNAKESKIN_CHAPS)),
		new EmoteClue("Jump for joy in the TzHaar sword shop. Shrug before you talk to me. Equip a Steel longsword, Blue D'hide body and blue mystic gloves.", TZHAAR_WEAPONS_STORE, new WorldPoint(2477, 5146, 0), JUMP_FOR_JOY, SHRUG, item(STEEL_LONGSWORD), item(BLUE_DHIDE_BODY), item(MYSTIC_GLOVES)),
		new EmoteClue("Jump for joy in the Ancient Cavern. Equip a granite shield, splitbark body and any rune heraldic helm.", ENTRANCE_OF_THE_CAVERN_UNDER_THE_WHIRLPOOL, new WorldPoint(1768, 5366, 1), JUMP_FOR_JOY, item(GRANITE_SHIELD), item(SPLITBARK_BODY), range("Any rune heraldic helm", RUNE_HELM_H1, RUNE_HELM_H5)),
		new EmoteClue("Jump for joy at the Neitiznot rune rock. Equip Rune boots, a proselyte hauberk and a dragonstone ring.", NEAR_A_RUNITE_ROCK_IN_THE_FREMENNIK_ISLES, new WorldPoint(2375, 3850, 0), JUMP_FOR_JOY, item(RUNE_BOOTS), item(PROSELYTE_HAUBERK), item(DRAGONSTONE_RING)),
		new EmoteClue("Jump for joy in the centre of Zul-Andra. Beware of double agents! Equip a dragon 2h sword, bandos boots and an obsidian cape.", NEAR_THE_PIER_IN_ZULANDRA, new WorldPoint(2199, 3056, 0), JUMP_FOR_JOY, item(DRAGON_2H_SWORD), item(BANDOS_BOOTS), item(OBSIDIAN_CAPE)),
		new EmoteClue("Laugh by the fountain of heroes. Equip splitbark legs, dragon boots and a Rune longsword.", FOUNTAIN_OF_HEROES, new WorldPoint(2920, 9893, 0), LAUGH, item(SPLITBARK_LEGS), item(DRAGON_BOOTS), item(RUNE_LONGSWORD)),
		new EmoteClue("Laugh in Jokul's tent in the Mountain Camp. Beware of double agents! Equip a rune full helmet, blue dragonhide chaps and a fire battlestaff.", MOUNTAIN_CAMP_GOAT_ENCLOSURE, new WorldPoint(2812, 3681, 0), LAUGH, item(RUNE_FULL_HELM), item(BLUE_DHIDE_CHAPS), item(FIRE_BATTLESTAFF)),
		new EmoteClue("Laugh at the crossroads south of the Sinclair Mansion. Equip a cowl, a blue wizard robe top and an iron scimitar.", ROAD_JUNCTION_SOUTH_OF_SINCLAIR_MANSION, new WorldPoint(2741, 3536, 0), LAUGH, item(LEATHER_COWL), item(BLUE_WIZARD_ROBE), item(IRON_SCIMITAR)),
		new EmoteClue("Laugh in front of the gem store in Ardougne market. Equip a Castlewars bracelet, a dragonstone amulet and a ring of forging.", NEAR_THE_GEM_STALL_IN_ARDOUGNE_MARKET, new WorldPoint(2666, 3304, 0), LAUGH, any("Castle wars bracelet", range(CASTLE_WARS_BRACELET3, CASTLE_WARS_BRACELET1)), item(DRAGONSTONE_AMULET), item(RING_OF_FORGING)),
		new EmoteClue("Panic in the Limestone Mine. Equip bronze platelegs, a steel pickaxe and a steel medium helmet.", LIMESTONE_MINE, new WorldPoint(3372, 3498, 0), PANIC, item(BRONZE_PLATELEGS), item(STEEL_PICKAXE), item(STEEL_MED_HELM)),
		new EmoteClue("Panic by the mausoleum in Morytania. Wave before you speak to me. Equip a mithril plate skirt, a maple longbow and no boots.", MAUSOLEUM_OFF_THE_MORYTANIA_COAST, new WorldPoint(3504, 3576, 0), PANIC, WAVE, item(MITHRIL_PLATESKIRT), item(MAPLE_LONGBOW), emptySlot("No boots", BOOTS)),
		new EmoteClue("Panic on the Wilderness volcano bridge. Beware of double agents! Equip any headband and crozier.", VOLCANO_IN_THE_NORTHEASTERN_WILDERNESS, new WorldPoint(3368, 3935, 0), PANIC, any("Any headband", range(RED_HEADBAND, BROWN_HEADBAND), range(WHITE_HEADBAND, GREEN_HEADBAND)), any("Any crozier", item(ANCIENT_CROZIER), item(ARMADYL_CROZIER), item(BANDOS_CROZIER), range(SARADOMIN_CROZIER, ZAMORAK_CROZIER))),
		new EmoteClue("Panic by the pilot on White Wolf Mountain. Beware of double agents! Equip mithril platelegs, a ring of life and a rune axe.", GNOME_GLIDER_ON_WHITE_WOLF_MOUNTAIN, new WorldPoint(2847, 3499, 0), PANIC, item(MITHRIL_PLATELEGS), item(RING_OF_LIFE), item(RUNE_AXE)),
		new EmoteClue("Panic by the big egg where no one dare goes and the ground is burnt. Beware of double agents! Equip a dragon med helm, a TokTz-Ket-Xil, a brine sabre, rune platebody and an uncharged amulet of glory.", SOUTHEAST_CORNER_OF_LAVA_DRAGON_ISLE, new WorldPoint(3227, 3831, 0), PANIC, item(DRAGON_MED_HELM), item(TOKTZKETXIL), item(BRINE_SABRE), item(RUNE_PLATEBODY), item(AMULET_OF_GLORY)),
		new EmoteClue("Panic at the area flowers meet snow. Equip Blue D'hide vambs, a dragon spear and a rune plateskirt.", HALFWAY_DOWN_TROLLWEISS_MOUNTAIN, new WorldPoint(2776, 3781, 0), PANIC, item(BLUE_DHIDE_VAMB), item(DRAGON_SPEAR), item(RUNE_PLATESKIRT), item(SLED_4084)),
		new EmoteClue("Do a push up at the bank of the Warrior's guild. Beware of double agents! Equip a dragon battleaxe, a dragon defender and a slayer helm of any kind.", WARRIORS_GUILD_BANK_29047, new WorldPoint(2843, 3543, 0), PUSH_UP, item(DRAGON_BATTLEAXE), item(DRAGON_DEFENDER), any("Any slayer helmet", item(SLAYER_HELMET), item(BLACK_SLAYER_HELMET), item(GREEN_SLAYER_HELMET), item(PURPLE_SLAYER_HELMET), item(RED_SLAYER_HELMET), item(TURQUOISE_SLAYER_HELMET), item(SLAYER_HELMET_I), item(BLACK_SLAYER_HELMET_I), item(GREEN_SLAYER_HELMET_I), item(PURPLE_SLAYER_HELMET_I), item(RED_SLAYER_HELMET_I), item(TURQUOISE_SLAYER_HELMET_I), item(HYDRA_SLAYER_HELMET), item(HYDRA_SLAYER_HELMET_I))),
		new EmoteClue("Blow a raspberry at the bank of the Warrior's guild. Beware of double agents! Equip a dragon battleaxe, a dragon defender and a slayer helm of any kind.", WARRIORS_GUILD_BANK_29047, new WorldPoint(2843, 3543, 0), RASPBERRY, item(DRAGON_BATTLEAXE), item(DRAGON_DEFENDER), any("Any slayer helmet", item(SLAYER_HELMET), item(BLACK_SLAYER_HELMET), item(GREEN_SLAYER_HELMET), item(PURPLE_SLAYER_HELMET), item(RED_SLAYER_HELMET), item(TURQUOISE_SLAYER_HELMET), item(SLAYER_HELMET_I), item(BLACK_SLAYER_HELMET_I), item(GREEN_SLAYER_HELMET_I), item(PURPLE_SLAYER_HELMET_I), item(RED_SLAYER_HELMET_I), item(TURQUOISE_SLAYER_HELMET_I), item(HYDRA_SLAYER_HELMET), item(HYDRA_SLAYER_HELMET_I))),
		new EmoteClue("Blow a raspberry at the monkey cage in Ardougne Zoo. Equip a studded leather body, bronze platelegs and a normal staff with no orb.", NEAR_THE_PARROTS_IN_ARDOUGNE_ZOO, new WorldPoint(2607, 3282, 0), RASPBERRY, item(STUDDED_BODY), item(BRONZE_PLATELEGS), item(STAFF)),
		new EmoteClue("Blow raspberries outside the entrance to Keep Le Faye. Equip a coif, an iron platebody and leather gloves.", OUTSIDE_KEEP_LE_FAYE, new WorldPoint(2757, 3401, 0), RASPBERRY, item(COIF), item(IRON_PLATEBODY), item(LEATHER_GLOVES)),
		new EmoteClue("Blow a raspberry in the Fishing Guild bank. Beware of double agents! Equip an elemental shield, blue dragonhide chaps and a rune warhammer.", FISHING_GUILD_BANK, new WorldPoint(2588, 3419, 0), RASPBERRY, item(ELEMENTAL_SHIELD), item(BLUE_DHIDE_CHAPS), item(RUNE_WARHAMMER)),
		new EmoteClue("Salute in the banana plantation. Beware of double agents! Equip a diamond ring, amulet of power, and nothing on your chest and legs.", WEST_SIDE_OF_THE_KARAMJA_BANANA_PLANTATION, new WorldPoint(2914, 3168, 0), SALUTE, item(DIAMOND_RING), item(AMULET_OF_POWER), emptySlot("Nothing on chest & legs", BODY, LEGS)),
		new EmoteClue("Salute in the Warriors' guild bank. Equip only a black salamander.", WARRIORS_GUILD_BANK, new WorldPoint(2844, 3542, 0), SALUTE, item(BLACK_SALAMANDER), emptySlot("Nothing else", HEAD, CAPE, AMULET, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue("Salute in the centre of the mess hall. Beware of double agents! Equip a rune halberd rune platebody, and an amulet of strength.", HOSIDIUS_MESS, new WorldPoint(1646, 3632, 0), SALUTE, item(RUNE_HALBERD), item(RUNE_PLATEBODY), item(AMULET_OF_STRENGTH)),
		new EmoteClue("Shrug in the mine near Rimmington. Equip a gold necklace, a gold ring and a bronze spear.", RIMMINGTON_MINE, new WorldPoint(2976, 3238, 0), SHRUG, item(GOLD_NECKLACE), item(GOLD_RING), item(BRONZE_SPEAR)),
		new EmoteClue("Shrug in Catherby bank. Yawn before you talk to me. Equip a maple longbow, green d'hide chaps and an iron med helm.", OUTSIDE_CATHERBY_BANK, new WorldPoint(2808, 3440, 0), SHRUG, YAWN, item(MAPLE_LONGBOW), item(GREEN_DHIDE_CHAPS), item(IRON_MED_HELM)),
		new EmoteClue("Shrug in the Zamorak temple found in the Eastern Wilderness. Beware of double agents! Equip rune platelegs, an iron platebody and blue dragonhide vambraces.", CHAOS_TEMPLE_IN_THE_SOUTHEASTERN_WILDERNESS, new WorldPoint(3239, 3611, 0), SHRUG, item(RUNE_PLATELEGS), item(IRON_PLATEBODY), item(BLUE_DHIDE_VAMB)),
		new EmoteClue("Shrug in the Shayzien command tent. Equip a blue mystic robe bottom, a rune kiteshield and any bob shirt.", SHAYZIEN_WAR_TENT, new WorldPoint(1555, 3537, 0), SHRUG, item(MYSTIC_ROBE_BOTTOM), item(RUNE_KITESHIELD), range("Any bob shirt", BOBS_RED_SHIRT, BOBS_PURPLE_SHIRT)),
		new EmoteClue("Slap your head in the centre of the Kourend catacombs. Beware of double agents! Equip the arclight and the amulet of the damned.", CENTRE_OF_THE_CATACOMBS_OF_KOUREND, new WorldPoint(1663, 10045, 0), SLAP_HEAD, item(ARCLIGHT), any("Amulet of the damned", item(AMULET_OF_THE_DAMNED), item(AMULET_OF_THE_DAMNED_FULL))),
		new EmoteClue("Spin at the crossroads north of Rimmington. Equip a green gnome hat, cream gnome top and leather chaps.", ROAD_JUNCTION_NORTH_OF_RIMMINGTON, new WorldPoint(2981, 3276, 0), SPIN, item(GREEN_HAT), item(CREAM_ROBE_TOP), item(LEATHER_CHAPS)),
		new EmoteClue("Spin in Draynor Manor by the fountain. Equip an iron platebody, studded leather chaps and a bronze full helmet.", DRAYNOR_MANOR_BY_THE_FOUNTAIN, new WorldPoint(3088, 3336, 0), SPIN, item(IRON_PLATEBODY), item(STUDDED_CHAPS), item(BRONZE_FULL_HELM)),
		new EmoteClue("Spin in front of the Soul altar. Beware of double agents! Equip a dragon pickaxe, helm of neitiznot and a pair of rune boots.", SOUL_ALTAR, new WorldPoint(1815, 3856, 0), SPIN, any("Dragon pickaxe", item(DRAGON_PICKAXE), item(DRAGON_PICKAXE_12797), item(INFERNAL_PICKAXE), item(INFERNAL_PICKAXE_UNCHARGED)), item(HELM_OF_NEITIZNOT), item(RUNE_BOOTS)),
		new EmoteClue("Spin in the Varrock Castle courtyard. Equip a black axe, a coif and a ruby ring.", OUTSIDE_VARROCK_PALACE_COURTYARD, new WorldPoint(3213, 3463, 0), SPIN, item(BLACK_AXE), item(COIF), item(RUBY_RING)),
		new EmoteClue("Spin in West Ardougne Church. Equip a dragon spear and red dragonhide chaps.", CHAPEL_IN_WEST_ARDOUGNE, new WorldPoint(2530, 3290, 0), SPIN, item(DRAGON_SPEAR), item(RED_DHIDE_CHAPS)),
		new EmoteClue("Spin on the bridge by the Barbarian Village. Salute before you talk to me. Equip purple gloves, a steel kiteshield and a mithril full helmet.", EAST_OF_THE_BARBARIAN_VILLAGE_BRIDGE, new WorldPoint(3105, 3420, 0), SPIN, SALUTE, item(PURPLE_GLOVES), item(STEEL_KITESHIELD), item(MITHRIL_FULL_HELM)),
		new EmoteClue("Stamp in the Enchanted valley west of the waterfall. Beware of double agents! Equip a dragon axe.", NORTHWESTERN_CORNER_OF_THE_ENCHANTED_VALLEY, new WorldPoint(3030, 4522, 0), STOMP, item(DRAGON_AXE)),
		new EmoteClue("Think in middle of the wheat field by the Lumbridge mill. Equip a blue gnome robetop, a turquoise gnome robe bottom and an oak shortbow.", WHEAT_FIELD_NEAR_THE_LUMBRIDGE_WINDMILL, new WorldPoint(3159, 3298, 0), THINK, item(BLUE_ROBE_TOP), item(TURQUOISE_ROBE_BOTTOMS), item(OAK_SHORTBOW)),
		new EmoteClue("Think in the centre of the Observatory. Spin before you talk to me. Equip a mithril chain body, green dragonhide chaps and a ruby amulet.", OBSERVATORY, new WorldPoint(2439, 3161, 0), THINK, SPIN, item(MITHRIL_CHAINBODY), item(GREEN_DHIDE_CHAPS), item(RUBY_AMULET)),
		new EmoteClue("Wave along the south fence of the Lumber Yard. Equip a hard leather body, leather chaps and a bronze axe.", NEAR_THE_SAWMILL_OPERATORS_BOOTH, new WorldPoint(3307, 3491, 0), WAVE, item(HARDLEATHER_BODY), item(LEATHER_CHAPS), item(BRONZE_AXE)),
		new EmoteClue("Wave in the Falador gem store. Equip a Mithril pickaxe, Black platebody and an Iron Kiteshield.", NEAR_HERQUINS_SHOP_IN_FALADOR, new WorldPoint(2945, 3335, 0), WAVE, item(MITHRIL_PICKAXE), item(BLACK_PLATEBODY), item(IRON_KITESHIELD)),
		new EmoteClue("Wave on Mudskipper Point. Equip a black cape, leather chaps and a steel mace.", MUDSKIPPER_POINT, new WorldPoint(2989, 3110, 0), WAVE, item(BLACK_CAPE), item(LEATHER_CHAPS), item(STEEL_MACE)),
		new EmoteClue("Wave on the northern wall of Castle Drakan. Beware of double agents! Wear a dragon sq shield, splitbark body and any boater.", NORTHERN_WALL_OF_CASTLE_DRAKAN, new WorldPoint(3560, 3385, 0), WAVE, item(DRAGON_SQ_SHIELD), item(SPLITBARK_BODY), any("Any boater", item(RED_BOATER), item(ORANGE_BOATER), item(GREEN_BOATER), item(BLUE_BOATER), item(BLACK_BOATER), item(PINK_BOATER), item(PURPLE_BOATER), item(WHITE_BOATER))),
		new EmoteClue("Yawn in the 7th room of Pyramid Plunder. Beware of double agents! Equip a pharaoh sceptre and a full set of menaphite robes.", _7TH_CHAMBER_OF_JALSAVRAH, new WorldPoint(1944, 4427, 0), YAWN, any("Pharaoh's sceptre", item(PHARAOHS_SCEPTRE), item(PHARAOHS_SCEPTRE_1), item(PHARAOHS_SCEPTRE_2), item(PHARAOHS_SCEPTRE_3), item(PHARAOHS_SCEPTRE_4), item(PHARAOHS_SCEPTRE_5), item(PHARAOHS_SCEPTRE_6), item(PHARAOHS_SCEPTRE_7), item(PHARAOHS_SCEPTRE_8)), any("Full set of menaphite robes", all(item(MENAPHITE_PURPLE_HAT), item(MENAPHITE_PURPLE_TOP), range(MENAPHITE_PURPLE_ROBE, MENAPHITE_PURPLE_KILT)), all(item(MENAPHITE_RED_HAT), item(MENAPHITE_RED_TOP), range(MENAPHITE_RED_ROBE, MENAPHITE_RED_KILT)))),
		new EmoteClue("Yawn in the Varrock library. Equip a green gnome robe top, HAM robe bottom and an iron warhammer.", VARROCK_PALACE_LIBRARY, new WorldPoint(3209, 3492, 0), YAWN, item(GREEN_ROBE_TOP), item(HAM_ROBE), item(IRON_WARHAMMER)),
		new EmoteClue("Yawn in Draynor Marketplace. Equip studded leather chaps, an iron kiteshield and a steel longsword.", DRAYNOR_VILLAGE_MARKET, new WorldPoint(3083, 3253, 0), YAWN, item(STUDDED_CHAPS), item(IRON_KITESHIELD), item(STEEL_LONGSWORD)),
		new EmoteClue("Yawn in the Castle Wars lobby. Shrug before you talk to me. Equip a ruby amulet, a mithril scimitar and a Wilderness cape.", CASTLE_WARS_BANK, new WorldPoint(2440, 3092, 0), YAWN, SHRUG, item(RUBY_AMULET), item(MITHRIL_SCIMITAR), range("Any team cape", TEAM1_CAPE, TEAM50_CAPE)),
		new EmoteClue("Yawn in the rogues' general store. Beware of double agents! Equip an adamant square shield, blue dragon vambraces and a rune pickaxe.", NOTERAZZOS_SHOP_IN_THE_WILDERNESS, new WorldPoint(3026, 3701, 0), YAWN, item(ADAMANT_SQ_SHIELD), item(BLUE_DHIDE_VAMB), item(RUNE_PICKAXE)),
		new EmoteClue("Yawn at the top of Trollheim. Equip a lava battlestaff, black dragonhide vambraces and a mind shield.", ON_TOP_OF_TROLLHEIM_MOUNTAIN, new WorldPoint(2887, 3676, 0), YAWN, item(LAVA_BATTLESTAFF), item(BLACK_DHIDE_VAMB), item(MIND_SHIELD)),
		new EmoteClue("Yawn in the centre of Arceuus library. Nod your head before you talk to me. Equip blue dragonhide vambraces, adamant boots and an adamant dagger.", ENTRANCE_OF_THE_ARCEUUS_LIBRARY, new WorldPoint(1632, 3807, 0), YAWN, YES, item(BLUE_DHIDE_VAMB), item(ADAMANT_BOOTS), item(ADAMANT_DAGGER)),
		new EmoteClue("Swing a bullroarer at the top of the watchtower. Beware of double agents! Equip a dragon plateskirt, climbing boots and a dragon chainbody.", TOP_FLOOR_OF_THE_YANILLE_WATCHTOWER, new WorldPoint(2932, 4712, 0), BULL_ROARER, item(DRAGON_PLATESKIRT), item(CLIMBING_BOOTS), item(DRAGON_CHAINBODY_3140), item(ItemID.BULL_ROARER)),
		new EmoteClue("Blow a raspberry at Gypsy Aris in her tent. Equip a gold ring and a gold necklace.", GYPSY_TENT_ENTRANCE, new WorldPoint(3203, 3424, 0), RASPBERRY, item(GOLD_RING), item(GOLD_NECKLACE)),
		new EmoteClue("Bow to Brugsen Bursen at the Grand Exchange.", null, new WorldPoint(3164, 3477, 0), BOW),
		new EmoteClue("Cheer at Iffie Nitter. Equip a chef's hat and a red cape.", FINE_CLOTHES_ENTRANCE, new WorldPoint(3205, 3416, 0), CHEER, item(CHEFS_HAT), item(RED_CAPE)),
		new EmoteClue("Clap at Bob's Brilliant Axes. Equip a bronze axe and leather boots.", BOB_AXES_ENTRANCE, new WorldPoint(3231, 3203, 0), CLAP, item(BRONZE_AXE), item(LEATHER_BOOTS)),
		new EmoteClue("Panic at Al Kharid mine.", null, new WorldPoint(3300, 3314, 0), PANIC),
		new EmoteClue("Spin at Flynn's Mace Shop.", null, new WorldPoint(2950, 3387, 0), SPIN));

	private static SingleItemRequirement item(int itemId)
	{
		return new SingleItemRequirement(itemId);
	}

	private static RangeItemRequirement range(int startItemId, int endItemId)
	{
		return range(null, startItemId, endItemId);
	}

	private static RangeItemRequirement range(String name, int startItemId, int endItemId)
	{
		return new RangeItemRequirement(name, startItemId, endItemId);
	}

	private static AnyRequirementCollection any(String name, ItemRequirement... requirements)
	{
		return new AnyRequirementCollection(name, requirements);
	}

	private static AllRequirementsCollection all(ItemRequirement... requirements)
	{
		return new AllRequirementsCollection(requirements);
	}

	private static SlotLimitationRequirement emptySlot(String description, EquipmentInventorySlot... slots)
	{
		return new SlotLimitationRequirement(description, slots);
	}

	private final String text;
	private final Integer stashUnit;
	private final WorldPoint location;
	private final Emote firstEmote;
	private final Emote secondEmote;
	@Nonnull
	private final ItemRequirement[] itemRequirements;

	private EmoteClue(String text, Integer stashUnit, WorldPoint location, Emote firstEmote, @Nonnull ItemRequirement... itemRequirements)
	{
		this(text, stashUnit, location, firstEmote, null, itemRequirements);
	}

	private EmoteClue(String text, Integer stashUnit, WorldPoint location, Emote firstEmote, Emote secondEmote, @Nonnull ItemRequirement... itemRequirements)
	{
		this.text = text;
		this.stashUnit = stashUnit;
		this.location = location;
		this.firstEmote = firstEmote;
		this.secondEmote = secondEmote;
		this.itemRequirements = itemRequirements;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Emote Clue").build());
		panelComponent.getChildren().add(LineComponent.builder().left("Emotes:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getFirstEmote().getName())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		if (getSecondEmote() != null)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left(getSecondEmote().getName())
				.leftColor(TITLED_CONTENT_COLOR)
				.build());
		}

		if (itemRequirements.length > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("Equip:").build());

			Item[] equipment = plugin.getEquippedItems();
			Item[] inventory = plugin.getInventoryItems();

			// If equipment is null, the player is wearing nothing
			if (equipment == null)
			{
				equipment = new Item[0];
			}

			// If inventory is null, the player has nothing in their inventory
			if (inventory == null)
			{
				inventory = new Item[0];
			}

			Item[] combined = new Item[equipment.length + inventory.length];
			System.arraycopy(equipment, 0, combined, 0, equipment.length);
			System.arraycopy(inventory, 0, combined, equipment.length, inventory.length);

			for (ItemRequirement requirement : itemRequirements)
			{
				boolean equipmentFulfilled = requirement.fulfilledBy(equipment);
				boolean combinedFulfilled = requirement.fulfilledBy(combined);

				panelComponent.getChildren().add(LineComponent.builder()
					.left(requirement.getCollectiveName(plugin.getClient()))
					.leftColor(TITLED_CONTENT_COLOR)
					.right(combinedFulfilled ? "\u2713" : "\u2717")
					.rightColor(equipmentFulfilled ? Color.GREEN : (combinedFulfilled ? Color.ORANGE : Color.RED))
					.build());
			}
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation());

		if (localLocation == null)
		{
			return;
		}

		OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getEmoteImage(), Color.ORANGE);
	}

	public static EmoteClue forText(String text)
	{
		for (EmoteClue clue : CLUES)
		{
			if (clue.getText().equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return null;
	}
}
