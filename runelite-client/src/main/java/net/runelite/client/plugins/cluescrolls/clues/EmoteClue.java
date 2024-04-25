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

import com.google.common.collect.ImmutableList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.List;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import static net.runelite.api.EquipmentInventorySlot.AMMO;
import static net.runelite.api.EquipmentInventorySlot.AMULET;
import static net.runelite.api.EquipmentInventorySlot.BODY;
import static net.runelite.api.EquipmentInventorySlot.BOOTS;
import static net.runelite.api.EquipmentInventorySlot.CAPE;
import static net.runelite.api.EquipmentInventorySlot.GLOVES;
import static net.runelite.api.EquipmentInventorySlot.HEAD;
import static net.runelite.api.EquipmentInventorySlot.LEGS;
import static net.runelite.api.EquipmentInventorySlot.RING;
import static net.runelite.api.EquipmentInventorySlot.SHIELD;
import static net.runelite.api.EquipmentInventorySlot.WEAPON;
import net.runelite.api.Item;
import static net.runelite.api.ItemID.*;
import net.runelite.api.Perspective;
import net.runelite.api.ScriptID;
import net.runelite.api.Varbits;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemVariationMapping;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.clues.Enemy.DOUBLE_AGENT_108;
import static net.runelite.client.plugins.cluescrolls.clues.Enemy.DOUBLE_AGENT_141;
import static net.runelite.client.plugins.cluescrolls.clues.Enemy.DOUBLE_AGENT_65;
import net.runelite.client.plugins.cluescrolls.clues.emote.Emote;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.*;
import net.runelite.client.plugins.cluescrolls.clues.emote.STASHUnit;
import static net.runelite.client.plugins.cluescrolls.clues.emote.STASHUnit.SHANTAY_PASS;
import static net.runelite.client.plugins.cluescrolls.clues.emote.STASHUnit.*;
import net.runelite.client.plugins.cluescrolls.clues.item.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.all;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.any;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.emptySlot;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.item;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.range;
import net.runelite.client.plugins.cluescrolls.clues.item.SingleItemRequirement;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class EmoteClue extends ClueScroll implements LocationClueScroll
{
	private static final AnyRequirementCollection ANY_SLAYER_HELMET = any("Any slayer helmet",
		ItemVariationMapping.getVariations(SLAYER_HELMET).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	private static final AnyRequirementCollection ANY_RING_OF_WEALTH = any("Any ring of wealth",
		ItemVariationMapping.getVariations(RING_OF_WEALTH).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	private static final AnyRequirementCollection ANY_PHARAOHS_SCEPTRE = any("Pharaoh's sceptre",
		ItemVariationMapping.getVariations(PHARAOHS_SCEPTRE).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	private static final AnyRequirementCollection ANY_TEAM_CAPE = any("Any team cape",
		Stream.of(
			ItemVariationMapping.getVariations(TEAM1_CAPE).stream(),
			Stream.of(TEAM_CAPE_I, TEAM_CAPE_X, TEAM_CAPE_ZERO))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ACTIVE_CRYSTAL_BOW_OR_BOW_OF_FAERDHINEN = any("Crystal Bow or Bow of Faerdhinen",
		Stream.of(
			ItemVariationMapping.getVariations(BOW_OF_FAERDHINEN_INACTIVE).stream(),
			Stream.of(CRYSTAL_BOW, CRYSTAL_BOW_24123))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.filter(itemId -> itemId != BOW_OF_FAERDHINEN_INACTIVE)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));

	static final List<EmoteClue> CLUES = ImmutableList.of(
		new EmoteClue("Beckon on the east coast of the Kharazi Jungle. Beware of double agents! Equip any vestment stole and a heraldic rune shield.", "Kharazi Jungle", NORTHEAST_CORNER_OF_THE_KHARAZI_JUNGLE, new WorldPoint(2954, 2933, 0), DOUBLE_AGENT_108, BECKON, any("Any stole", item(GUTHIX_STOLE), item(SARADOMIN_STOLE), item(ZAMORAK_STOLE), item(ARMADYL_STOLE), item(BANDOS_STOLE), item(ANCIENT_STOLE)), any("Any heraldic rune shield", item(RUNE_SHIELD_H1), item(RUNE_SHIELD_H2), item(RUNE_SHIELD_H3), item(RUNE_SHIELD_H4), item(RUNE_SHIELD_H5))),
		new EmoteClue("Cheer in the Barbarian Agility Arena. Headbang before you talk to me. Equip a steel platebody, maple shortbow and a Wilderness cape.", "Barbarian Outpost", BARBARIAN_OUTPOST_OBSTACLE_COURSE, new WorldPoint(2552, 3556, 0), CHEER, HEADBANG, item(STEEL_PLATEBODY), item(MAPLE_SHORTBOW), ANY_TEAM_CAPE),
		new EmoteClue("Bow upstairs in the Edgeville Monastery. Equip a completed prayer book.", "Edgeville Monastery", SOUTHEAST_CORNER_OF_THE_MONASTERY, new WorldPoint(3056, 3484, 1), BOW, any("Any god book", item(HOLY_BOOK), item(BOOK_OF_BALANCE), item(UNHOLY_BOOK), item(BOOK_OF_LAW), item(BOOK_OF_WAR), item(BOOK_OF_DARKNESS), item(HOLY_BOOK_OR), item(BOOK_OF_BALANCE_OR), item(UNHOLY_BOOK_OR), item(BOOK_OF_LAW_OR), item(BOOK_OF_WAR_OR), item(BOOK_OF_DARKNESS_OR))),
		new EmoteClue("Cheer in the Shadow dungeon. Equip a rune crossbow, climbing boots and any mitre.", "Shadow dungeon", ENTRANCE_OF_THE_CAVE_OF_DAMIS, new WorldPoint(2629, 5071, 0), CHEER, any("Any mitre", item(GUTHIX_MITRE), item(SARADOMIN_MITRE), item(ZAMORAK_MITRE), item(ANCIENT_MITRE), item(BANDOS_MITRE), item(ARMADYL_MITRE)), any("Rune crossbow", item(RUNE_CROSSBOW), item(RUNE_CROSSBOW_OR)), any("Climbing boots", item(CLIMBING_BOOTS), item(CLIMBING_BOOTS_G)), any("Ring of visibility or ring of shadows", item(RING_OF_VISIBILITY), item(RING_OF_SHADOWS), item(RING_OF_SHADOWS_UNCHARGED))),
		new EmoteClue("Cheer at the top of the agility pyramid. Beware of double agents! Equip a blue mystic robe top, and any rune heraldic shield.", "Agility Pyramid", AGILITY_PYRAMID, new WorldPoint(3043, 4697, 3), DOUBLE_AGENT_108, CHEER, item(MYSTIC_ROBE_TOP), any("Any rune heraldic shield", item(RUNE_SHIELD_H1), item(RUNE_SHIELD_H2), item(RUNE_SHIELD_H3), item(RUNE_SHIELD_H4), item(RUNE_SHIELD_H5))),
		new EmoteClue("Dance in Iban's temple. Beware of double agents! Equip Iban's staff, a black mystic top and a black mystic bottom.", "Iban's temple", WELL_OF_VOYAGE, new WorldPoint(2011, 4712, 0), DOUBLE_AGENT_141, DANCE, any("Any iban's staff", item(IBANS_STAFF), item(IBANS_STAFF_U)), item(MYSTIC_ROBE_TOP_DARK), item(MYSTIC_ROBE_BOTTOM_DARK)),
		new EmoteClue("Dance on the Fishing Platform. Equip barrows gloves, an amulet of glory and a dragon med helm.", "Fishing Platform", SOUTHEAST_CORNER_OF_THE_FISHING_PLATFORM, new WorldPoint(2782, 3273, 0), DANCE, any("Any amulet of glory", item(AMULET_OF_GLORY), item(AMULET_OF_GLORY1), item(AMULET_OF_GLORY2), item(AMULET_OF_GLORY3), item(AMULET_OF_GLORY4), item(AMULET_OF_GLORY5), item(AMULET_OF_GLORY6)), item(BARROWS_GLOVES), item(DRAGON_MED_HELM)),
		new EmoteClue("Flap at the death altar. Beware of double agents! Equip a death tiara, a legend's cape and any ring of wealth.", "Death altar", DEATH_ALTAR, new WorldPoint(2205, 4838, 0), DOUBLE_AGENT_141, FLAP, ANY_RING_OF_WEALTH, item(DEATH_TIARA), item(CAPE_OF_LEGENDS)),
		new EmoteClue("Headbang in the Fight Arena pub. Equip a pirate bandana, a dragonstone necklace and and a magic longbow.", "Fight Arena pub", OUTSIDE_THE_BAR_BY_THE_FIGHT_ARENA, new WorldPoint(2568, 3149, 0), HEADBANG, any("Any pirate bandana", item(PIRATE_BANDANA), item(PIRATE_BANDANA_7124), item(PIRATE_BANDANA_7130), item(PIRATE_BANDANA_7136)), item(DRAGON_NECKLACE), item(MAGIC_LONGBOW)),
		new EmoteClue("Do a jig at the barrows chest. Beware of double agents! Equip any full barrows set.", "Barrows chest", BARROWS_CHEST, new WorldPoint(3551, 9694, 0), DOUBLE_AGENT_141, JIG, any("Any full barrows set", all(any("Ahrim's hood", item(AHRIMS_HOOD), range(AHRIMS_HOOD_100, AHRIMS_HOOD_0)), any("Ahrim's staff", item(AHRIMS_STAFF), range(AHRIMS_STAFF_100, AHRIMS_STAFF_0)), any("Ahrim's robetop", item(AHRIMS_ROBETOP), range(AHRIMS_ROBETOP_100, AHRIMS_ROBETOP_0)), any("Ahrim's robeskirt", item(AHRIMS_ROBESKIRT), range(AHRIMS_ROBESKIRT_100, AHRIMS_ROBESKIRT_0))), all(any("Dharok's helm", item(DHAROKS_HELM), range(DHAROKS_HELM_100, DHAROKS_HELM_0)), any("Dharok's greataxe", item(DHAROKS_GREATAXE), range(DHAROKS_GREATAXE_100, DHAROKS_GREATAXE_0)), any("Dharok's platebody", item(DHAROKS_PLATEBODY), range(DHAROKS_PLATEBODY_100, DHAROKS_PLATEBODY_0)), any("Dharok's platelegs", item(DHAROKS_PLATELEGS), range(DHAROKS_PLATELEGS_100, DHAROKS_PLATELEGS_0))), all(any("Guthan's helm", item(GUTHANS_HELM), range(GUTHANS_HELM_100, GUTHANS_HELM_0)), any("Guthan's warspear", item(GUTHANS_WARSPEAR), range(GUTHANS_WARSPEAR_100, GUTHANS_WARSPEAR_0)), any("Guthan's platebody", item(GUTHANS_PLATEBODY), range(GUTHANS_PLATEBODY_100, GUTHANS_PLATEBODY_0)), any("Guthan's chainskirt", item(GUTHANS_CHAINSKIRT), range(GUTHANS_CHAINSKIRT_100, GUTHANS_CHAINSKIRT_0))), all(any("Karil's coif", item(KARILS_COIF), range(KARILS_COIF_100, KARILS_COIF_0)), any("Karil's crossbow", item(KARILS_CROSSBOW), range(KARILS_CROSSBOW_100, KARILS_CROSSBOW_0)), any("Karil's leathertop", item(KARILS_LEATHERTOP), range(KARILS_LEATHERTOP_100, KARILS_LEATHERTOP_0)), any("Karil's leatherskirt", item(KARILS_LEATHERSKIRT), range(KARILS_LEATHERSKIRT_100, KARILS_LEATHERSKIRT_0))), all(any("Torag's helm", item(TORAGS_HELM), range(TORAGS_HELM_100, TORAGS_HELM_0)), any("Torag's hammers", item(TORAGS_HAMMERS), range(TORAGS_HAMMERS_100, TORAGS_HAMMERS_0)), any("Torag's platebody", item(TORAGS_PLATEBODY), range(TORAGS_PLATEBODY_100, TORAGS_PLATEBODY_0)), any("Torag's platelegs", item(TORAGS_PLATELEGS), range(TORAGS_PLATELEGS_100, TORAGS_PLATELEGS_0))), all(any("Verac's helm", item(VERACS_HELM), range(VERACS_HELM_100, VERACS_HELM_0)), any("Verac's flail", item(VERACS_FLAIL), range(VERACS_FLAIL_100, VERACS_FLAIL_0)), any("Verac's brassard", item(VERACS_BRASSARD), range(VERACS_BRASSARD_100, VERACS_BRASSARD_0)), any("Verac's plateskirt", item(VERACS_PLATESKIRT), range(VERACS_PLATESKIRT_100, VERACS_PLATESKIRT_0))))),
		new EmoteClue("Jig at Jiggig. Beware of double agents! Equip a Rune spear, rune platelegs and any rune heraldic helm.", "Jiggig", IN_THE_MIDDLE_OF_JIGGIG, new WorldPoint(2477, 3047, 0), DOUBLE_AGENT_108, JIG, range("Any rune heraldic helm", RUNE_HELM_H1, RUNE_HELM_H5), item(RUNE_SPEAR), item(RUNE_PLATELEGS)),
		new EmoteClue("Cheer at the games room. Have nothing equipped at all when you do.", "Burthorpe Games Room", null, new WorldPoint(2207, 4952, 0), CHEER, emptySlot("Nothing at all", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue("Panic on the pier where you catch the Fishing trawler. Have nothing equipped at all when you do.", "Fishing trawler", null, new WorldPoint(2676, 3169, 0), PANIC, emptySlot("Nothing at all", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue("Panic in the heart of the Haunted Woods. Beware of double agents! Have no items equipped when you do.", "Haunted Woods (ALQ)", null, new WorldPoint(3611, 3492, 0), DOUBLE_AGENT_108, PANIC, emptySlot("Nothing at all", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue("Show your anger towards the Statue of Saradomin in Ellamaria's garden. Beware of double agents! Equip a zamorak godsword.", "Varrock Castle", BY_THE_BEAR_CAGE_IN_VARROCK_PALACE_GARDENS, new WorldPoint(3230, 3478, 0), DOUBLE_AGENT_141, ANGRY, any("Zamorak godsword", item(ZAMORAK_GODSWORD), item(ZAMORAK_GODSWORD_OR))),
		new EmoteClue("Show your anger at the Wise old man. Beware of double agents! Equip an abyssal whip, a legend's cape and some spined chaps.", "Draynor Village", BEHIND_MISS_SCHISM_IN_DRAYNOR_VILLAGE, new WorldPoint(3088, 3254, 0), DOUBLE_AGENT_141, ANGRY, any("Abyssal whip", item(ABYSSAL_WHIP), item(VOLCANIC_ABYSSAL_WHIP), item(FROZEN_ABYSSAL_WHIP), item(ABYSSAL_WHIP_OR), item(ABYSSAL_TENTACLE), item(ABYSSAL_TENTACLE_OR)), item(CAPE_OF_LEGENDS), item(SPINED_CHAPS)),
		new EmoteClue("Beckon by a collection of crystalline maple trees. Beware of double agents! Equip Bryophyta's staff and a nature tiara.", "North of Prifddinas", CRYSTALLINE_MAPLE_TREES, new WorldPoint(2211, 3427, 0), DOUBLE_AGENT_141, BECKON, range("Bryophyta's staff", BRYOPHYTAS_STAFF_UNCHARGED, BRYOPHYTAS_STAFF), item(NATURE_TIARA)),
		new EmoteClue("Beckon in the Digsite, near the eastern winch. Bow before you talk to me. Equip a green gnome hat, snakeskin boots and an iron pickaxe.", "Digsite", DIGSITE, new WorldPoint(3370, 3425, 0), BECKON, BOW, item(GREEN_HAT), item(SNAKESKIN_BOOTS), item(IRON_PICKAXE)),
		new EmoteClue("Beckon in Tai Bwo Wannai. Clap before you talk to me. Equip green dragonhide chaps, a ring of dueling and a mithril medium helmet.", "Tai Bwo Wannai", SOUTH_OF_THE_SHRINE_IN_TAI_BWO_WANNAI_VILLAGE, new WorldPoint(2803, 3073, 0), BECKON, CLAP, item(GREEN_DHIDE_CHAPS), any("Ring of dueling", item(RING_OF_DUELING1), item(RING_OF_DUELING2), item(RING_OF_DUELING3), item(RING_OF_DUELING4), item(RING_OF_DUELING5), item(RING_OF_DUELING6), item(RING_OF_DUELING7), item(RING_OF_DUELING8)), item(MITHRIL_MED_HELM)),
		new EmoteClue("Beckon in the Shayzien Combat Ring. Show your anger before you talk to me. Equip an adamant platebody, adamant full helm and adamant platelegs.", "Shayzien Combat Ring", WEST_OF_THE_SHAYZIEN_COMBAT_RING, new WorldPoint(1543, 3623, 0), BECKON, ANGRY, item(ADAMANT_PLATELEGS), item(ADAMANT_PLATEBODY), item(ADAMANT_FULL_HELM)),
		new EmoteClue("Bow near Lord Iorwerth. Beware of double agents! Equip a charged crystal bow.", "Lord Iorwerth's camp", TENT_IN_LORD_IORWERTHS_ENCAMPMENT, new WorldPoint(2205, 3252, 0), DOUBLE_AGENT_141, BOW, ACTIVE_CRYSTAL_BOW_OR_BOW_OF_FAERDHINEN),
		new EmoteClue("Bow in the Iorwerth Camp. Beware of double agents! Equip a charged crystal bow.", "Lord Iorwerth's camp", TENT_IN_LORD_IORWERTHS_ENCAMPMENT, new WorldPoint(2205, 3252, 0), DOUBLE_AGENT_141, BOW, ACTIVE_CRYSTAL_BOW_OR_BOW_OF_FAERDHINEN),
		new EmoteClue("Bow outside the entrance to the Legends' Guild. Equip iron platelegs, an emerald amulet and an oak longbow.", "Legend's Guild", OUTSIDE_THE_LEGENDS_GUILD_GATES, new WorldPoint(2729, 3349, 0), BOW, item(IRON_PLATELEGS), item(OAK_LONGBOW), item(EMERALD_AMULET)),
		new EmoteClue("Bow on the ground floor of the Legends' Guild. Equip a Cape of Legends, a dragon battleaxe and an amulet of glory.", "Legend's Guild", OUTSIDE_THE_LEGENDS_GUILD_DOOR, new WorldPoint(2728, 3377, 0), BOW, item(CAPE_OF_LEGENDS), item(DRAGON_BATTLEAXE), any("Any amulet of glory", item(AMULET_OF_GLORY), item(AMULET_OF_GLORY1), item(AMULET_OF_GLORY2), item(AMULET_OF_GLORY3), item(AMULET_OF_GLORY4), item(AMULET_OF_GLORY5), item(AMULET_OF_GLORY6))),
		new EmoteClue("Bow in the office of the Emir's Arena. Equip an iron chain body, leather chaps and coif.", "PvP Arena", PVP_ARENA_TICKET_OFFICE, new WorldPoint(3314, 3241, 0), BOW, item(IRON_CHAINBODY), item(LEATHER_CHAPS), item(COIF)),
		new EmoteClue("Bow at the top of the lighthouse. Beware of double agents! Equip a blue dragonhide body, blue dragonhide vambraces and no jewelry.", "Lighthouse", TOP_FLOOR_OF_THE_LIGHTHOUSE, new WorldPoint(2511, 3641, 2), DOUBLE_AGENT_108, BOW, item(BLUE_DHIDE_BODY), item(BLUE_DHIDE_VAMBRACES), emptySlot("No jewellery", AMULET, RING)),
		new EmoteClue("Bow within the temple in Civitas illa Fortis. Equip any piece of sunfire fanatic armour.", "Civitas illa Fortis", TEMPLE_SOUTHEAST_OF_THE_BAZAAR, new WorldPoint(1699, 3087, 0), BOW, any("Any piece of Sunfire Fanatic armour", item(SUNFIRE_FANATIC_HELM), item(SUNFIRE_FANATIC_CUIRASS), item(SUNFIRE_FANATIC_CHAUSSES))),
		new EmoteClue("Blow a kiss between the tables in Shilo Village bank. Beware of double agents! Equip a blue mystic hat, bone spear and rune platebody.", "Shilo Village", SHILO_VILLAGE_BANK, new WorldPoint(2851, 2954, 0), DOUBLE_AGENT_108, BLOW_KISS, item(MYSTIC_HAT), item(BONE_SPEAR), item(RUNE_PLATEBODY)),
		new EmoteClue("Blow a kiss in the heart of the lava maze. Equip black dragonhide chaps, a spotted cape and a rolling pin.", "Lava maze", NEAR_A_LADDER_IN_THE_WILDERNESS_LAVA_MAZE, new WorldPoint(3069, 3861, 0), BLOW_KISS, item(BLACK_DHIDE_CHAPS), any("Spotted cape", item(SPOTTED_CAPE), item(SPOTTED_CAPE_10073)), item(ROLLING_PIN)),
		new EmoteClue("Blow a kiss outside K'ril Tsutsaroth's chamber. Beware of double agents! Equip a zamorak full helm and the shadow sword.", "K'ril's chamber", OUTSIDE_KRIL_TSUTSAROTHS_ROOM, new WorldPoint(2925, 5333, 2), DOUBLE_AGENT_141, BLOW_KISS, item(ZAMORAK_FULL_HELM), item(SHADOW_SWORD)),
		new EmoteClue("Cheer at the Druids' Circle. Equip a blue wizard hat, a bronze two-handed sword and HAM boots.", "Taverley stone circle", TAVERLEY_STONE_CIRCLE, new WorldPoint(2924, 3478, 0), CHEER, item(BLUE_WIZARD_HAT), item(BRONZE_2H_SWORD), item(HAM_BOOTS)),
		new EmoteClue("Cheer in the Edgeville general store. Dance before you talk to me. Equip a brown apron, leather boots and leather gloves.", "Edgeville", NORTH_OF_EVIL_DAVES_HOUSE_IN_EDGEVILLE, new WorldPoint(3080, 3509, 0), CHEER, DANCE, item(BROWN_APRON), item(LEATHER_BOOTS), item(LEATHER_GLOVES)),
		new EmoteClue("Cheer in the Ogre Pen in the Training Camp. Show you are angry before you talk to me. Equip a green dragonhide body and chaps and a steel square shield.", "King Lathas' camp", OGRE_CAGE_IN_KING_LATHAS_TRAINING_CAMP, new WorldPoint(2527, 3375, 0), CHEER, ANGRY, item(GREEN_DHIDE_BODY), item(GREEN_DHIDE_CHAPS), item(STEEL_SQ_SHIELD)),
		new EmoteClue("Cheer in the Entrana church. Beware of double agents! Equip a full set of black dragonhide armour.", "Entrana church", ENTRANA_CHAPEL, new WorldPoint(2852, 3349, 0), DOUBLE_AGENT_141, CHEER, item(BLACK_DHIDE_VAMBRACES), item(BLACK_DHIDE_CHAPS), item(BLACK_DHIDE_BODY)),
		new EmoteClue("Cheer for the monks at Port Sarim. Equip a coif, steel plateskirt and a sapphire necklace.", "Port Sarim", NEAR_THE_ENTRANA_FERRY_IN_PORT_SARIM, new WorldPoint(3047, 3237, 0), CHEER, item(COIF), item(STEEL_PLATESKIRT), item(SAPPHIRE_NECKLACE)),
		new EmoteClue("Clap in the main exam room in the Exam Centre. Equip a white apron, green gnome boots and leather gloves.", "Exam Centre", OUTSIDE_THE_DIGSITE_EXAM_CENTRE, new WorldPoint(3361, 3339, 0), CLAP, item(WHITE_APRON), item(GREEN_BOOTS), item(LEATHER_GLOVES)),
		new EmoteClue("Clap on the causeway to the Wizards' Tower. Equip an iron medium helmet, emerald ring and a white apron.", "Wizards' Tower", ON_THE_BRIDGE_TO_THE_MISTHALIN_WIZARDS_TOWER, new WorldPoint(3113, 3196, 0), CLAP, item(IRON_MED_HELM), item(EMERALD_RING), item(WHITE_APRON)),
		new EmoteClue("Clap on the top level of the mill, north of East Ardougne. Equip a blue gnome robe top, HAM robe bottom and an unenchanted tiara.", "East Ardougne", UPSTAIRS_IN_THE_ARDOUGNE_WINDMILL, new WorldPoint(2635, 3385, 3), CLAP, item(BLUE_ROBE_TOP), item(HAM_ROBE), item(TIARA)),
		new EmoteClue("Clap in Seers court house. Spin before you talk to me. Equip an adamant halberd, blue mystic robe bottom and a diamond ring.", "Seers Village", OUTSIDE_THE_SEERS_VILLAGE_COURTHOUSE, new WorldPoint(2735, 3469, 0), CLAP, SPIN, item(ADAMANT_HALBERD), item(MYSTIC_ROBE_BOTTOM), item(DIAMOND_RING)),
		new EmoteClue("Clap in the magic axe hut. Beware of double agents! Equip only some flared trousers.", "Magic axe hut", OUTSIDE_THE_WILDERNESS_AXE_HUT, new WorldPoint(3191, 3960, 0), DOUBLE_AGENT_141, CLAP, item(FLARED_TROUSERS), item(LOCKPICK), emptySlot("Nothing else", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue("Clap your hands north of Mount Karuulm Spin before you talk to me. Equip an adamant warhammer, a ring of life and a pair of mithril boots.", "Mount Karuulm", NORTH_OF_MOUNT_KARUULM, new WorldPoint(1306, 3839, 0), CLAP, SPIN, item(ADAMANT_WARHAMMER), item(RING_OF_LIFE), item(MITHRIL_BOOTS)),
		new EmoteClue("Cry in the Catherby Ranging shop. Bow before you talk to me. Equip blue gnome boots, a hard leather body and an unblessed silver sickle.", "Catherby", HICKTONS_ARCHERY_EMPORIUM, new WorldPoint(2823, 3443, 0), CRY, BOW, item(BLUE_BOOTS), item(HARDLEATHER_BODY), item(SILVER_SICKLE)),
		new EmoteClue("Cry on the shore of Catherby beach. Laugh before you talk to me, equip an adamant sq shield, a bone dagger and mithril platebody.", "Catherby", OUTSIDE_HARRYS_FISHING_SHOP_IN_CATHERBY, new WorldPoint(2852, 3429, 0), CRY, LAUGH, item(ADAMANT_SQ_SHIELD), item(BONE_DAGGER), item(MITHRIL_PLATEBODY)),
		new EmoteClue("Cry on top of the western tree in the Gnome Agility Arena. Indicate 'no' before you talk to me. Equip a steel kiteshield, ring of forging and green dragonhide chaps.", "Gnome Stronghold", GNOME_STRONGHOLD_BALANCING_ROPE, new WorldPoint(2473, 3420, 2), CRY, NO, item(STEEL_KITESHIELD), item(RING_OF_FORGING), item(GREEN_DHIDE_CHAPS)),
		new EmoteClue("Cry in the TzHaar gem store. Beware of double agents! Equip a fire cape and TokTz-Xil-Ul.", "Tzhaar gem store", TZHAAR_GEM_STORE, new WorldPoint(2463, 5149, 0), DOUBLE_AGENT_141, CRY, any("Fire cape", item(FIRE_CAPE), item(FIRE_CAPE_L), item(FIRE_MAX_CAPE), item(FIRE_MAX_CAPE_L), item(INFERNAL_CAPE), item(INFERNAL_CAPE_L), item(INFERNAL_MAX_CAPE_21285), item(INFERNAL_MAX_CAPE_L)), item(TOKTZXILUL)),
		new EmoteClue("Cry in the Draynor Village jail. Jump for joy before you talk to me. Equip an adamant sword, a sapphire amulet and an adamant plateskirt.", "Draynor Village jail", OUTSIDE_DRAYNOR_VILLAGE_JAIL, new WorldPoint(3128, 3245, 0), CRY, JUMP_FOR_JOY, item(ADAMANT_SWORD), item(SAPPHIRE_AMULET), item(ADAMANT_PLATESKIRT)),
		new EmoteClue("Dance at the crossroads north of Draynor. Equip an iron chain body, a sapphire ring and a longbow.", "Draynor Village", CROSSROADS_NORTH_OF_DRAYNOR_VILLAGE, new WorldPoint(3109, 3294, 0), DANCE, item(IRON_CHAINBODY), item(SAPPHIRE_RING), item(LONGBOW)),
		new EmoteClue("Dance in the Party Room. Equip a steel full helmet, steel platebody and an iron plateskirt.", "Falador Party Room", OUTSIDE_THE_FALADOR_PARTY_ROOM, new WorldPoint(3045, 3376, 0), DANCE, item(STEEL_FULL_HELM), item(STEEL_PLATEBODY), item(IRON_PLATESKIRT)),
		new EmoteClue("Dance in the shack in Lumbridge Swamp. Equip a bronze dagger, iron full helmet and a gold ring.", "Lumbridge swamp", NEAR_A_SHED_IN_LUMBRIDGE_SWAMP, new WorldPoint(3203, 3169, 0), DANCE, item(BRONZE_DAGGER), item(IRON_FULL_HELM), item(GOLD_RING)),
		new EmoteClue("Dance in the dark caves beneath Lumbridge Swamp. Blow a kiss before you talk to me. Equip an air staff, Bronze full helm and an amulet of power.", "Lumbridge swamp caves", LUMBRIDGE_SWAMP_CAVES, new WorldPoint(3168, 9571, 0), DANCE, BLOW_KISS, Varbits.FIRE_PIT_LUMBRIDGE_SWAMP, item(STAFF_OF_AIR), item(BRONZE_FULL_HELM), item(AMULET_OF_POWER)),
		new EmoteClue("Dance at the cat-doored pyramid in Sophanem. Beware of double agents! Equip a ring of life, an uncharged amulet of glory and an adamant two-handed sword.", "Pyramid Of Sophanem", OUTSIDE_THE_GREAT_PYRAMID_OF_SOPHANEM, new WorldPoint(3294, 2781, 0), DOUBLE_AGENT_108, DANCE, item(RING_OF_LIFE), item(AMULET_OF_GLORY), item(ADAMANT_2H_SWORD)),
		new EmoteClue("Dance in the centre of Canifis. Bow before you talk to me. Equip a green gnome robe top, mithril plate legs and an iron two-handed sword.", "Canifis", CENTRE_OF_CANIFIS, new WorldPoint(3492, 3488, 0), DANCE, BOW, item(GREEN_ROBE_TOP), item(MITHRIL_PLATELEGS), item(IRON_2H_SWORD)),
		new EmoteClue("Dance in the King Black Dragon's lair. Beware of double agents! Equip a black dragonhide body, black dragonhide vambraces and a black dragon mask.", "King black dragon's lair", KING_BLACK_DRAGONS_LAIR, new WorldPoint(2271, 4680, 0), DOUBLE_AGENT_141, DANCE, item(BLACK_DHIDE_BODY), item(BLACK_DHIDE_VAMBRACES), item(BLACK_DRAGON_MASK)),
		new EmoteClue("Dance at the entrance to the Grand Exchange. Equip a pink skirt, pink robe top and a body tiara.", "Grand Exchange", SOUTH_OF_THE_GRAND_EXCHANGE, new WorldPoint(3165, 3467, 0), DANCE, item(PINK_SKIRT), item(PINK_ROBE_TOP), item(BODY_TIARA)),
		new EmoteClue("Goblin Salute in the Goblin Village. Beware of double agents! Equip a bandos godsword, a bandos cloak and a bandos platebody.", "Goblin Village", OUTSIDE_MUDKNUCKLES_HUT, new WorldPoint(2956, 3505, 0), DOUBLE_AGENT_141, GOBLIN_SALUTE, item(BANDOS_PLATEBODY), item(BANDOS_CLOAK), any("Bandos godsword", item(BANDOS_GODSWORD), item(BANDOS_GODSWORD_OR))),
		new EmoteClue("Headbang in the mine north of Al Kharid. Equip a desert shirt, leather gloves and leather boots.", "Al Kharid mine", AL_KHARID_SCORPION_MINE, new WorldPoint(3299, 3289, 0), HEADBANG, item(DESERT_SHIRT), item(LEATHER_GLOVES), item(LEATHER_BOOTS)),
		new EmoteClue("Headbang at the exam centre. Beware of double agents! Equip a mystic fire staff, a diamond bracelet and rune boots.", "Exam Centre", INSIDE_THE_DIGSITE_EXAM_CENTRE, new WorldPoint(3362, 3340, 0), DOUBLE_AGENT_108, HEADBANG, item(MYSTIC_FIRE_STAFF), item(DIAMOND_BRACELET), item(RUNE_BOOTS)),
		new EmoteClue("Headbang at the top of Slayer Tower. Equip a seercull, a combat bracelet and helm of Neitiznot.", "Slayer Tower", OUTSIDE_THE_SLAYER_TOWER_GARGOYLE_ROOM, new WorldPoint(3421, 3537, 2), HEADBANG, item(SEERCULL), any("Combat bracelet", range(COMBAT_BRACELET4, COMBAT_BRACELET), item(COMBAT_BRACELET5), item(COMBAT_BRACELET6)), item(HELM_OF_NEITIZNOT)),
		new EmoteClue("Dance a jig by the entrance to the Fishing Guild. Equip an emerald ring, a sapphire amulet, and a bronze chain body.", "Fishing Guild", OUTSIDE_THE_FISHING_GUILD, new WorldPoint(2610, 3391, 0), JIG, item(EMERALD_RING), item(SAPPHIRE_AMULET), item(BRONZE_CHAINBODY)),
		new EmoteClue("Dance a jig under Shantay's Awning. Bow before you talk to me. Equip a pointed blue snail helmet, an air staff and a bronze square shield.", "Shantay Pass", SHANTAY_PASS, new WorldPoint(3304, 3124, 0), JIG, BOW, any("Bruise blue snelm (pointed)", item(BRUISE_BLUE_SNELM_3343)), item(STAFF_OF_AIR), item(BRONZE_SQ_SHIELD)),
		new EmoteClue("Do a jig in Varrock's rune store. Equip an air tiara and a staff of water.", "Varrock rune store", AUBURYS_SHOP_IN_VARROCK, new WorldPoint(3253, 3401, 0), JIG, item(AIR_TIARA), item(STAFF_OF_WATER)),
		new EmoteClue("Jump for joy at the beehives. Equip a desert shirt, green gnome robe bottoms and a steel axe.", "Catherby", CATHERBY_BEEHIVE_FIELD, new WorldPoint(2759, 3445, 0), JUMP_FOR_JOY, item(DESERT_SHIRT), item(GREEN_ROBE_BOTTOMS), item(STEEL_AXE)),
		new EmoteClue("Jump for joy in Yanille bank. Dance a jig before you talk to me. Equip a brown apron, adamantite medium helmet and snakeskin chaps.", "Yanille", OUTSIDE_YANILLE_BANK, new WorldPoint(2610, 3092, 0), JUMP_FOR_JOY, JIG, item(BROWN_APRON), item(ADAMANT_MED_HELM), item(SNAKESKIN_CHAPS)),
		new EmoteClue("Jump for joy in the TzHaar sword shop. Shrug before you talk to me. Equip a Steel longsword, Blue D'hide body and blue mystic gloves.", "Tzhaar weapon store", TZHAAR_WEAPONS_STORE, new WorldPoint(2477, 5146, 0), JUMP_FOR_JOY, SHRUG, item(STEEL_LONGSWORD), item(BLUE_DHIDE_BODY), item(MYSTIC_GLOVES)),
		new EmoteClue("Jump for joy in the Ancient Cavern. Equip a granite shield, splitbark body and any rune heraldic helm.", "Ancient cavern", ENTRANCE_OF_THE_CAVERN_UNDER_THE_WHIRLPOOL, new WorldPoint(1768, 5366, 1), JUMP_FOR_JOY, item(GRANITE_SHIELD), item(SPLITBARK_BODY), range("Any rune heraldic helm", RUNE_HELM_H1, RUNE_HELM_H5)),
		new EmoteClue("Jump for joy at the Neitiznot rune rock. Equip Rune boots, a proselyte hauberk and a dragonstone ring.", "Fremennik Isles", NEAR_A_RUNITE_ROCK_IN_THE_FREMENNIK_ISLES, new WorldPoint(2375, 3850, 0), JUMP_FOR_JOY, item(RUNE_BOOTS), item(PROSELYTE_HAUBERK), item(DRAGONSTONE_RING)),
		new EmoteClue("Jump for joy in the centre of Zul-Andra. Beware of double agents! Equip a dragon 2h sword, bandos boots and an obsidian cape.", "Zul-Andra", NEAR_THE_PIER_IN_ZULANDRA, new WorldPoint(2199, 3056, 0), DOUBLE_AGENT_141, JUMP_FOR_JOY, item(DRAGON_2H_SWORD), any("Bandos boots", item(BANDOS_BOOTS), item(GUARDIAN_BOOTS)), item(OBSIDIAN_CAPE)),
		new EmoteClue("Laugh by the fountain of heroes. Equip splitbark legs, dragon boots and a Rune longsword.", "Fountain of heroes", FOUNTAIN_OF_HEROES, new WorldPoint(2920, 9893, 0), LAUGH, item(SPLITBARK_LEGS), any("Dragon boots", item(DRAGON_BOOTS), item(DRAGON_BOOTS_G), item(PRIMORDIAL_BOOTS)), item(RUNE_LONGSWORD)),
		new EmoteClue("Laugh in Jokul's tent in the Mountain Camp. Beware of double agents! Equip a rune full helmet, blue dragonhide chaps and a fire battlestaff.", "Mountain Camp", MOUNTAIN_CAMP_GOAT_ENCLOSURE, new WorldPoint(2812, 3681, 0), DOUBLE_AGENT_108, LAUGH, item(RUNE_FULL_HELM), item(BLUE_DHIDE_CHAPS), item(FIRE_BATTLESTAFF)),
		new EmoteClue("Laugh at the crossroads south of the Sinclair Mansion. Equip a cowl, a blue wizard robe top and an iron scimitar.", "Sinclair Mansion", ROAD_JUNCTION_SOUTH_OF_SINCLAIR_MANSION, new WorldPoint(2741, 3536, 0), LAUGH, item(LEATHER_COWL), item(BLUE_WIZARD_ROBE), item(IRON_SCIMITAR)),
		new EmoteClue("Laugh in front of the gem store in Ardougne market. Equip a Castlewars bracelet, a dragonstone amulet and a ring of forging.", "Ardougne", NEAR_THE_GEM_STALL_IN_ARDOUGNE_MARKET, new WorldPoint(2666, 3304, 0), LAUGH, any("Castle wars bracelet", range(CASTLE_WARS_BRACELET3, CASTLE_WARS_BRACELET1)), item(DRAGONSTONE_AMULET), item(RING_OF_FORGING)),
		new EmoteClue("Panic in the Limestone Mine. Equip bronze platelegs, a steel pickaxe and a steel medium helmet.", "Limestone Mine", LIMESTONE_MINE, new WorldPoint(3372, 3498, 0), PANIC, item(BRONZE_PLATELEGS), item(STEEL_PICKAXE), item(STEEL_MED_HELM)),
		new EmoteClue("Panic by the mausoleum in Morytania. Wave before you speak to me. Equip a mithril plate skirt, a maple longbow and no boots.", "Morytania mausoleum, access via the experiments cave", MAUSOLEUM_OFF_THE_MORYTANIA_COAST, new WorldPoint(3504, 3576, 0), PANIC, WAVE, item(MITHRIL_PLATESKIRT), item(MAPLE_LONGBOW), emptySlot("No boots", BOOTS)),
		new EmoteClue("Panic on the Wilderness volcano bridge. Beware of double agents! Equip any headband and crozier.", "Wilderness volcano", VOLCANO_IN_THE_NORTHEASTERN_WILDERNESS, new WorldPoint(3368, 3935, 0), DOUBLE_AGENT_65, PANIC, any("Any headband", range(RED_HEADBAND, BROWN_HEADBAND), range(WHITE_HEADBAND, GREEN_HEADBAND)), any("Any crozier", item(ANCIENT_CROZIER), item(ARMADYL_CROZIER), item(BANDOS_CROZIER), range(SARADOMIN_CROZIER, ZAMORAK_CROZIER))),
		new EmoteClue("Panic by the pilot on White Wolf Mountain. Beware of double agents! Equip mithril platelegs, a ring of life and a rune axe.", "White Wolf Mountain", GNOME_GLIDER_ON_WHITE_WOLF_MOUNTAIN, new WorldPoint(2847, 3499, 0), DOUBLE_AGENT_108, PANIC, item(MITHRIL_PLATELEGS), item(RING_OF_LIFE), item(RUNE_AXE)),
		new EmoteClue("Panic by the big egg where no one dare goes and the ground is burnt. Beware of double agents! Equip a dragon med helm, a TokTz-Ket-Xil, a brine sabre, rune platebody and an uncharged amulet of glory.", "Lava dragon isle", SOUTHEAST_CORNER_OF_LAVA_DRAGON_ISLE, new WorldPoint(3227, 3831, 0), DOUBLE_AGENT_141, PANIC, item(DRAGON_MED_HELM), item(TOKTZKETXIL), item(BRINE_SABRE), item(RUNE_PLATEBODY), any("Uncharged Amulet of glory", item(AMULET_OF_GLORY))),
		new EmoteClue("Panic at the area flowers meet snow. Equip Blue D'hide vambraces, a dragon spear and a rune plateskirt.", "Trollweiss mountain", HALFWAY_DOWN_TROLLWEISS_MOUNTAIN, new WorldPoint(2776, 3781, 0), PANIC, item(BLUE_DHIDE_VAMBRACES), item(DRAGON_SPEAR), item(RUNE_PLATESKIRT), item(SLED_4084)),
		new EmoteClue("Do a push up at the bank of the Warrior's guild. Beware of double agents! Equip a dragon battleaxe, a dragon defender and a slayer helm of any kind.", "Warriors' guild", WARRIORS_GUILD_BANK_29047, new WorldPoint(2843, 3543, 0), DOUBLE_AGENT_141, PUSH_UP, item(DRAGON_BATTLEAXE), any("Dragon defender", item(DRAGON_DEFENDER), item(DRAGON_DEFENDER_T), item(DRAGON_DEFENDER_L)), ANY_SLAYER_HELMET),
		new EmoteClue("Blow a raspberry in the bank of the Warriors' Guild. Beware of double agents! Equip a dragon battleaxe, a slayer helm of any kind and a dragon defender or avernic defender.", "Warriors' guild", WARRIORS_GUILD_BANK_29047, new WorldPoint(2843, 3543, 0), DOUBLE_AGENT_141, RASPBERRY, item(DRAGON_BATTLEAXE), any("Dragon defender or Avernic defender", item(DRAGON_DEFENDER), item(DRAGON_DEFENDER_T), item(DRAGON_DEFENDER_L), item(AVERNIC_DEFENDER), item(AVERNIC_DEFENDER_L)), ANY_SLAYER_HELMET),
		new EmoteClue("Blow a raspberry at the monkey cage in Ardougne Zoo. Equip a studded leather body, bronze platelegs and a normal staff with no orb.", "Ardougne Zoo", NEAR_THE_PARROTS_IN_ARDOUGNE_ZOO, new WorldPoint(2607, 3282, 0), RASPBERRY, item(STUDDED_BODY), item(BRONZE_PLATELEGS), item(STAFF)),
		new EmoteClue("Blow raspberries outside the entrance to Keep Le Faye. Equip a coif, an iron platebody and leather gloves.", "Keep Le Faye", OUTSIDE_KEEP_LE_FAYE, new WorldPoint(2757, 3401, 0), RASPBERRY, item(COIF), item(IRON_PLATEBODY), item(LEATHER_GLOVES)),
		new EmoteClue("Blow a raspberry in the Fishing Guild bank. Beware of double agents! Equip an elemental shield, blue dragonhide chaps and a rune warhammer.", "Fishing Guild", FISHING_GUILD_BANK, new WorldPoint(2588, 3419, 0), DOUBLE_AGENT_108, RASPBERRY, item(ELEMENTAL_SHIELD), item(BLUE_DHIDE_CHAPS), item(RUNE_WARHAMMER)),
		new EmoteClue("Salute in the banana plantation. Beware of double agents! Equip a diamond ring, amulet of power, and nothing on your chest and legs.", "Karamja", WEST_SIDE_OF_THE_KARAMJA_BANANA_PLANTATION, new WorldPoint(2914, 3168, 0), DOUBLE_AGENT_108, SALUTE, item(DIAMOND_RING), item(AMULET_OF_POWER), emptySlot("Nothing on chest & legs", BODY, LEGS)),
		new EmoteClue("Salute in the Warriors' Guild bank. Equip only a black salamander.", "Warriors' guild", WARRIORS_GUILD_BANK, new WorldPoint(2844, 3542, 0), SALUTE, item(BLACK_SALAMANDER), emptySlot("Nothing else", HEAD, CAPE, AMULET, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue("Salute in the centre of the mess hall. Beware of double agents! Equip a rune halberd rune platebody, and an amulet of strength.", "Hosidius mess hall", HOSIDIUS_MESS, new WorldPoint(1646, 3631, 0), DOUBLE_AGENT_108, SALUTE, item(RUNE_HALBERD), item(RUNE_PLATEBODY), item(AMULET_OF_STRENGTH)),
		new EmoteClue("Salute outside the gates of Cam Torum. Beware of double agents! Equip a full set of blue moon equipment.", "Cam Torum", CAM_TORUM_ENTRANCE, new WorldPoint(1436, 3115, 0), DOUBLE_AGENT_141, SALUTE, any("Blue moon helm", item(BLUE_MOON_HELM), item(BLUE_MOON_HELM_29041)), any("Blue moon chestplate", item(BLUE_MOON_CHESTPLATE), item(BLUE_MOON_CHESTPLATE_29037)), any("Blue moon tassets", item(BLUE_MOON_TASSETS), item(BLUE_MOON_TASSETS_29039)), item(BLUE_MOON_SPEAR)),
		new EmoteClue("Shrug in the mine near Rimmington. Equip a gold necklace, a gold ring and a bronze spear.", "Rimmington mine", RIMMINGTON_MINE, new WorldPoint(2976, 3238, 0), SHRUG, item(GOLD_NECKLACE), item(GOLD_RING), item(BRONZE_SPEAR)),
		new EmoteClue("Shrug in Catherby bank. Yawn before you talk to me. Equip a maple longbow, green d'hide chaps and an iron med helm.", "Catherby", OUTSIDE_CATHERBY_BANK, new WorldPoint(2808, 3440, 0), SHRUG, YAWN, item(MAPLE_LONGBOW), item(GREEN_DHIDE_CHAPS), item(IRON_MED_HELM)),
		new EmoteClue("Shrug in the woods east of the Level 19 Wilderness Obelisk. Beware of double agents! Equip rune platelegs, an iron platebody and blue dragonhide vambraces.", "East of the Level 19 Wilderness Obelisk", EAST_OF_THE_LEVEL_19_WILDERNESS_OBELISK, new WorldPoint(3241, 3672, 0), DOUBLE_AGENT_65, SHRUG, item(RUNE_PLATELEGS), item(IRON_PLATEBODY), item(BLUE_DHIDE_VAMBRACES)),
		new EmoteClue("Shrug in the Shayzien war tent. Equip a blue mystic robe bottom, a rune kiteshield and any bob shirt.", "Shayzien war tent", SHAYZIEN_WAR_TENT, new WorldPoint(1487, 3635, 0), SHRUG, item(MYSTIC_ROBE_BOTTOM), item(RUNE_KITESHIELD), range("Any bob shirt", BOBS_RED_SHIRT, BOBS_PURPLE_SHIRT)),
		new EmoteClue("Slap your head in the centre of the Kourend catacombs. Beware of double agents! Equip the arclight and the amulet of the damned.", "Kourend catacombs", CENTRE_OF_THE_CATACOMBS_OF_KOUREND, new WorldPoint(1663, 10045, 0), DOUBLE_AGENT_141, SLAP_HEAD, item(ARCLIGHT), any("Amulet of the damned", item(AMULET_OF_THE_DAMNED), item(AMULET_OF_THE_DAMNED_FULL))),
		new EmoteClue("Spin at the crossroads north of Rimmington. Equip a green gnome hat, cream gnome top and leather chaps.", "Rimmington", ROAD_JUNCTION_NORTH_OF_RIMMINGTON, new WorldPoint(2981, 3276, 0), SPIN, item(GREEN_HAT), item(CREAM_ROBE_TOP), item(LEATHER_CHAPS)),
		new EmoteClue("Spin in Draynor Manor by the fountain. Equip an iron platebody, studded leather chaps and a bronze full helmet.", "Draynor Manor", DRAYNOR_MANOR_BY_THE_FOUNTAIN, new WorldPoint(3088, 3336, 0), SPIN, item(IRON_PLATEBODY), item(STUDDED_CHAPS), item(BRONZE_FULL_HELM)),
		new EmoteClue("Spin in front of the Soul altar. Beware of double agents! Equip a dragon pickaxe, helm of neitiznot and a pair of rune boots.", "Soul altar", SOUL_ALTAR, new WorldPoint(1815, 3856, 0), DOUBLE_AGENT_141, SPIN, any("Dragon or Crystal pickaxe", item(DRAGON_PICKAXE), item(DRAGON_PICKAXE_12797), item(INFERNAL_PICKAXE), item(INFERNAL_PICKAXE_UNCHARGED), item(DRAGON_PICKAXE_OR), item(DRAGON_PICKAXE_OR_25376), item(CRYSTAL_PICKAXE), item(CRYSTAL_PICKAXE_INACTIVE), item(INFERNAL_PICKAXE_OR), item(INFERNAL_PICKAXE_UNCHARGED_25369)), item(HELM_OF_NEITIZNOT), item(RUNE_BOOTS)),
		new EmoteClue("Spin in the Varrock Castle courtyard. Equip a black axe, a coif and a ruby ring.", "Varrock Castle", OUTSIDE_VARROCK_PALACE_COURTYARD, new WorldPoint(3213, 3463, 0), SPIN, item(BLACK_AXE), item(COIF), item(RUBY_RING)),
		new EmoteClue("Spin in West Ardougne Church. Equip a dragon spear and red dragonhide chaps.", "West Ardougne Church", CHAPEL_IN_WEST_ARDOUGNE, new WorldPoint(2530, 3290, 0), SPIN, item(DRAGON_SPEAR), item(RED_DHIDE_CHAPS)),
		new EmoteClue("Spin on the bridge by the Barbarian Village. Salute before you talk to me. Equip purple gloves, a steel kiteshield and a mithril full helmet.", "Barbarian Village", EAST_OF_THE_BARBARIAN_VILLAGE_BRIDGE, new WorldPoint(3105, 3420, 0), SPIN, SALUTE, item(PURPLE_GLOVES), item(STEEL_KITESHIELD), item(MITHRIL_FULL_HELM)),
		new EmoteClue("Stamp in the Enchanted valley west of the waterfall. Beware of double agents! Equip a dragon axe.", "Enchanted Valley (BKQ)", NORTHWESTERN_CORNER_OF_THE_ENCHANTED_VALLEY, new WorldPoint(3030, 4522, 0), DOUBLE_AGENT_141, STAMP, any("Dragon or Crystal axe", item(DRAGON_AXE), item(DRAGON_AXE_OR), item(CRYSTAL_AXE), item(CRYSTAL_AXE_INACTIVE), item(INFERNAL_AXE), item(INFERNAL_AXE_UNCHARGED), item(INFERNAL_AXE_OR), item(INFERNAL_AXE_UNCHARGED_25371))),
		new EmoteClue("Think in middle of the wheat field by the Lumbridge mill. Equip a blue gnome robetop, a turquoise gnome robe bottom and an oak shortbow.", "Lumbridge mill", WHEAT_FIELD_NEAR_THE_LUMBRIDGE_WINDMILL, new WorldPoint(3159, 3298, 0), THINK, item(BLUE_ROBE_TOP), item(TURQUOISE_ROBE_BOTTOMS), item(OAK_SHORTBOW)),
		new EmoteClue("Think in the centre of the Observatory. Spin before you talk to me. Equip a mithril chain body, green dragonhide chaps and a ruby amulet.", "Observatory", OBSERVATORY, new WorldPoint(2439, 3161, 0), THINK, SPIN, item(MITHRIL_CHAINBODY), item(GREEN_DHIDE_CHAPS), item(RUBY_AMULET)),
		new EmoteClue("Wave along the south fence of the Lumber Yard. Equip a hard leather body, leather chaps and a bronze axe.", "Lumber Yard", NEAR_THE_SAWMILL_OPERATORS_BOOTH, new WorldPoint(3307, 3491, 0), WAVE, item(HARDLEATHER_BODY), item(LEATHER_CHAPS), item(BRONZE_AXE)),
		new EmoteClue("Wave in the Falador gem store. Equip a Mithril pickaxe, Black platebody and an Iron Kiteshield.", "Falador", NEAR_HERQUINS_SHOP_IN_FALADOR, new WorldPoint(2945, 3335, 0), WAVE, item(MITHRIL_PICKAXE), item(BLACK_PLATEBODY), item(IRON_KITESHIELD)),
		new EmoteClue("Wave on Mudskipper Point. Equip a black cape, leather chaps and a steel mace.", "Mudskipper Point (AIQ)", MUDSKIPPER_POINT, new WorldPoint(2989, 3110, 0), WAVE, item(BLACK_CAPE), item(LEATHER_CHAPS), item(STEEL_MACE)),
		new EmoteClue("Wave on the northern wall of Castle Drakan. Beware of double agents! Wear a dragon sq shield, splitbark body and any boater.", "Castle Drakan", NORTHERN_WALL_OF_CASTLE_DRAKAN, new WorldPoint(3562, 3379, 0), DOUBLE_AGENT_141, WAVE, any("Dragon sq shield", item(DRAGON_SQ_SHIELD), item(DRAGON_SQ_SHIELD_G)), item(SPLITBARK_BODY), any("Any boater", item(RED_BOATER), item(ORANGE_BOATER), item(GREEN_BOATER), item(BLUE_BOATER), item(BLACK_BOATER), item(PINK_BOATER), item(PURPLE_BOATER), item(WHITE_BOATER))),
		new EmoteClue("Yawn in the 7th room of Pyramid Plunder. Beware of double agents! Equip a pharaoh sceptre and a full set of menaphite robes.", "Pyramid Plunder", _7TH_CHAMBER_OF_JALSAVRAH, new WorldPoint(1944, 4427, 0), DOUBLE_AGENT_141, YAWN, ANY_PHARAOHS_SCEPTRE, any("Full set of menaphite robes", all(item(MENAPHITE_PURPLE_HAT), item(MENAPHITE_PURPLE_TOP), range(MENAPHITE_PURPLE_ROBE, MENAPHITE_PURPLE_KILT)), all(item(MENAPHITE_RED_HAT), item(MENAPHITE_RED_TOP), range(MENAPHITE_RED_ROBE, MENAPHITE_RED_KILT)))),
		new EmoteClue("Yawn in the Varrock library. Equip a green gnome robe top, HAM robe bottom and an iron warhammer.", "Varrock Castle", VARROCK_PALACE_LIBRARY, new WorldPoint(3209, 3492, 0), YAWN, item(GREEN_ROBE_TOP), item(HAM_ROBE), item(IRON_WARHAMMER)),
		new EmoteClue("Yawn in Draynor marketplace. Equip studded leather chaps, an iron kiteshield and a steel longsword.", "Draynor", DRAYNOR_VILLAGE_MARKET, new WorldPoint(3083, 3253, 0), YAWN, item(STUDDED_CHAPS), item(IRON_KITESHIELD), item(STEEL_LONGSWORD)),
		new EmoteClue("Yawn in the Castle Wars lobby. Shrug before you talk to me. Equip a ruby amulet, a mithril scimitar and a Wilderness cape.", "Castle Wars", CASTLE_WARS_BANK, new WorldPoint(2440, 3092, 0), YAWN, SHRUG, item(RUBY_AMULET), item(MITHRIL_SCIMITAR), ANY_TEAM_CAPE),
		new EmoteClue("Yawn in the rogues' general store. Beware of double agents! Equip an adamant square shield, blue dragon vambraces and a rune pickaxe.", "Rogues general store", NOTERAZZOS_SHOP_IN_THE_WILDERNESS, new WorldPoint(3026, 3701, 0), DOUBLE_AGENT_65, YAWN, item(ADAMANT_SQ_SHIELD), item(BLUE_DHIDE_VAMBRACES), item(RUNE_PICKAXE)),
		new EmoteClue("Yawn at the top of Trollheim. Equip a lava battlestaff, black dragonhide vambraces and a mind shield.", "Trollheim Mountain", ON_TOP_OF_TROLLHEIM_MOUNTAIN, new WorldPoint(2887, 3676, 0), YAWN, any("Lava battlestaff", item(LAVA_BATTLESTAFF), item(LAVA_BATTLESTAFF_21198)), item(BLACK_DHIDE_VAMBRACES), item(MIND_SHIELD)),
		new EmoteClue("Yawn in the centre of the Arceuus Library. Nod your head before you talk to me. Equip blue dragonhide vambraces, adamant boots and an adamant dagger.", "Arceuus library", ENTRANCE_OF_THE_ARCEUUS_LIBRARY, new WorldPoint(1632, 3807, 0), YAWN, YES, item(BLUE_DHIDE_VAMBRACES), item(ADAMANT_BOOTS), item(ADAMANT_DAGGER)),
		new EmoteClue("Yawn in the Fortis Grand Museum. Equip an emerald necklace, blue skirt, and turqoise gnome robe top.", "Fortis Grand Museum", FORTIS_GRAND_MUSEUM, new WorldPoint(1712, 3163, 0), YAWN, item(EMERALD_NECKLACE), item(BLUE_SKIRT), item(TURQUOISE_ROBE_TOP)),
		new EmoteClue("Swing a bullroarer at the top of the Watchtower. Beware of double agents! Equip a dragon plateskirt, climbing boots and a dragon chainbody.", "Yanille Watchtower", TOP_FLOOR_OF_THE_YANILLE_WATCHTOWER, new WorldPoint(2930, 4717, 2), DOUBLE_AGENT_141, BULL_ROARER, any("Dragon plateskirt", item(DRAGON_PLATESKIRT), item(DRAGON_PLATESKIRT_G)), any("Climbing boots", item(CLIMBING_BOOTS), item(CLIMBING_BOOTS_G)), any("Dragon chainbody", item(DRAGON_CHAINBODY_3140), item(DRAGON_CHAINBODY_G)), item(BULLROARER)),
		new EmoteClue("Blow a raspberry at Aris in her tent. Equip a gold ring and a gold necklace.", "Varrock", GYPSY_TENT_ENTRANCE, new WorldPoint(3203, 3424, 0), RASPBERRY, item(GOLD_RING), item(GOLD_NECKLACE)),
		new EmoteClue("Bow to Brugsen Bursen at the Grand Exchange.", "Grand Exchange", null, new WorldPoint(3164, 3477, 0), BOW),
		new EmoteClue("Cheer at Iffie Nitter. Equip a chef hat and a red cape.", "Varrock", FINE_CLOTHES_ENTRANCE, new WorldPoint(3205, 3416, 0), CHEER, item(CHEFS_HAT), item(RED_CAPE)),
		new EmoteClue("Clap at Bob's Brilliant Axes. Equip a bronze axe and leather boots.", "Lumbridge", BOB_AXES_ENTRANCE, new WorldPoint(3231, 3203, 0), CLAP, item(BRONZE_AXE), item(LEATHER_BOOTS)),
		new EmoteClue("Panic at Al Kharid mine.", "Al Kharid mine", null, new WorldPoint(3303, 3271, 0), PANIC),
		new EmoteClue("Spin at Flynn's Mace Shop.", "Falador", null, new WorldPoint(2950, 3387, 0), SPIN),
		new EmoteClue("Salute by the Charcoal Burners. Equip a Farmer's strawhat, Shayzien platebody (5) and Pyromancer robes.", "Charcoal Burners", CHARCOAL_BURNERS, new WorldPoint(1714, 3467, 0), SALUTE, any("Farmer's strawhat", item(FARMERS_STRAWHAT), item(FARMERS_STRAWHAT_13647)), item(SHAYZIEN_BODY_5), item(PYROMANCER_ROBE)));

	private static final String UNICODE_CHECK_MARK = "\u2713";
	private static final String UNICODE_BALLOT_X = "\u2717";

	private final String text;
	private final String locationName;
	@Nullable
	private final STASHUnit stashUnit;
	@Getter(AccessLevel.PRIVATE)
	private final WorldPoint location;
	private final Emote firstEmote;
	private final Emote secondEmote;
	private final ItemRequirement[] itemRequirements;

	private EmoteClue(String text, String locationName, STASHUnit stashUnit, WorldPoint location, Emote firstEmote, @Nonnull ItemRequirement... itemRequirements)
	{
		this(text, locationName, stashUnit, location, firstEmote, null, itemRequirements);
	}

	private EmoteClue(String text, String locationName, STASHUnit stashUnit, WorldPoint location, Enemy enemy, Emote firstEmote, @Nonnull ItemRequirement... itemRequirements)
	{
		this(text, locationName, stashUnit, location, firstEmote, null, itemRequirements);
		setEnemy(enemy);
	}

	private EmoteClue(String text, String locationName, STASHUnit stashUnit, WorldPoint location, Emote firstEmote, Emote secondEmote, @Nonnull ItemRequirement... itemRequirements)
	{
		this.text = text;
		this.locationName = locationName;
		this.stashUnit = stashUnit;
		this.location = location;
		this.firstEmote = firstEmote;
		this.secondEmote = secondEmote;
		this.itemRequirements = itemRequirements;
	}

	private EmoteClue(String text, String locationName, @Nullable STASHUnit stashUnit, WorldPoint location, Emote firstEmote, Emote secondEmote, @Varbit int firePitVarbitId, @Nonnull ItemRequirement... itemRequirements)
	{
		this(text, locationName, stashUnit, location, firstEmote, secondEmote, itemRequirements);
		setRequiresLight(true);
		setFirePitVarbitId(firePitVarbitId);
	}

	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return location;
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

		panelComponent.getChildren().add(LineComponent.builder().left("Location:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getLocationName())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		if (itemRequirements.length > 0)
		{
			Client client = plugin.getClient();

			if (stashUnit != null)
			{
				client.runScript(ScriptID.WATSON_STASH_UNIT_CHECK, stashUnit.getObjectId(), 0, 0, 0);
				int[] intStack = client.getIntStack();
				boolean stashUnitBuilt = intStack[0] == 1;

				panelComponent.getChildren().add(LineComponent.builder()
					.left("STASH Unit:")
					.right(stashUnitBuilt ? UNICODE_CHECK_MARK : UNICODE_BALLOT_X)
					.rightFont(FontManager.getDefaultFont())
					.rightColor(stashUnitBuilt ? Color.GREEN : Color.RED)
					.build());
			}

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
					.left(requirement.getCollectiveName(client))
					.leftColor(TITLED_CONTENT_COLOR)
					.right(combinedFulfilled ? UNICODE_CHECK_MARK : UNICODE_BALLOT_X)
					.rightFont(FontManager.getDefaultFont())
					.rightColor(equipmentFulfilled ? Color.GREEN : (combinedFulfilled ? Color.ORANGE : Color.RED))
					.build());
			}
		}

		renderOverlayNote(panelComponent, plugin);
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		LocalPoint localPoint = LocalPoint.fromWorld(plugin.getClient(), getLocation());

		if (localPoint != null)
		{
			OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localPoint, plugin.getEmoteImage(), Color.ORANGE);
		}

		makeSTASHOverlay(graphics, plugin);
	}

	@Override
	public int[] getConfigKeys()
	{
		return new int[]{text.hashCode()};
	}

	public void makeSTASHOverlay(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		if (stashUnit != null)
		{
			final WorldPoint[] worldPoints = stashUnit.getWorldPoints();

			for (final WorldPoint worldPoint : worldPoints)
			{
				final LocalPoint stashUnitLocalPoint = LocalPoint.fromWorld(plugin.getClient(), worldPoint);

				if (stashUnitLocalPoint != null)
				{
					final Polygon poly = Perspective.getCanvasTilePoly(plugin.getClient(), stashUnitLocalPoint);
					if (poly != null)
					{
						OverlayUtil.renderPolygon(graphics, poly, Color.RED);
					}
				}
			}
		}
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
