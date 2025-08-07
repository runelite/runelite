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
import net.runelite.api.EquipmentInventorySlot;
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
import net.runelite.api.Perspective;
import net.runelite.api.ScriptID;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarbitID;
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
		ItemVariationMapping.getVariations(ItemID.SLAYER_HELM).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	private static final AnyRequirementCollection ANY_RING_OF_WEALTH = any("Any ring of wealth",
		ItemVariationMapping.getVariations(ItemID.RING_OF_WEALTH).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	private static final AnyRequirementCollection ANY_PHARAOHS_SCEPTRE = any("Pharaoh's sceptre",
		ItemVariationMapping.getVariations(ItemID.NTK_JEWELLED_SCEPTRE_3).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	private static final AnyRequirementCollection ANY_TEAM_CAPE = any("Any team cape",
		Stream.of(
			ItemVariationMapping.getVariations(ItemID.WILDERNESS_CAPE_1).stream(),
			Stream.of(ItemID.WILDERNESS_CAPE_I, ItemID.WILDERNESS_CAPE_X, ItemID.WILDERNESS_CAPE_ZERO))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ACTIVE_CRYSTAL_BOW_OR_BOW_OF_FAERDHINEN = any("Crystal Bow or Bow of Faerdhinen",
		Stream.of(
			ItemVariationMapping.getVariations(ItemID.BOW_OF_FAERDHINEN_INACTIVE).stream(),
			Stream.of(ItemID.CRYSTAL_BOW, ItemID.CRYSTAL_BOW_2500))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.filter(itemId -> itemId != ItemID.BOW_OF_FAERDHINEN_INACTIVE)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));

	static final List<EmoteClue> CLUES = ImmutableList.of(
		new EmoteClue(ItemID.TRAIL_HARD_EMOTE_EXP2, "Beckon on the east coast of the Kharazi Jungle. Beware of double agents! Equip any vestment stole and a heraldic rune shield.", "Kharazi Jungle", NORTHEAST_CORNER_OF_THE_KHARAZI_JUNGLE, new WorldPoint(2954, 2933, 0), DOUBLE_AGENT_108, BECKON, any("Any stole", item(ItemID.TRAIL_GUTHIX_SCARF), item(ItemID.TRAIL_SARADOMIN_SCARF), item(ItemID.TRAIL_ZAMORAK_SCARF), item(ItemID.TRAIL_ARMADYL_SCARF), item(ItemID.TRAIL_BANDOS_SCARF), item(ItemID.TRAIL_ANCIENT_SCARF)), any("Any heraldic rune shield", item(ItemID.RUNE_HERALDIC_KITESHIELD1), item(ItemID.RUNE_HERALDIC_KITESHIELD2), item(ItemID.RUNE_HERALDIC_KITESHIELD3), item(ItemID.RUNE_HERALDIC_KITESHIELD4), item(ItemID.RUNE_HERALDIC_KITESHIELD5))),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE006, "Cheer in the Barbarian Agility Arena. Headbang before you talk to me. Equip a steel platebody, maple shortbow and a Wilderness cape.", "Barbarian Outpost", BARBARIAN_OUTPOST_OBSTACLE_COURSE, new WorldPoint(2552, 3556, 0), CHEER, HEADBANG, item(ItemID.STEEL_PLATEBODY), item(ItemID.MAPLE_SHORTBOW), ANY_TEAM_CAPE),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP6, "Bow upstairs in the Edgeville Monastery. Equip a completed prayer book.", "Edgeville Monastery", SOUTHEAST_CORNER_OF_THE_MONASTERY, new WorldPoint(3056, 3484, 1), BOW, any("Any god book", item(ItemID.SARADOMINBOOK_COMPLETE), item(ItemID.GUTHIXBOOK_COMPLETE), item(ItemID.ZAMORAKBOOK_COMPLETE), item(ItemID.ARMADYLBOOK_COMPLETE), item(ItemID.BANDOSBOOK_COMPLETE), item(ItemID.ZAROSBOOK_COMPLETE), item(ItemID.LEAGUE_3_BOOK_SARADOMIN), item(ItemID.LEAGUE_3_BOOK_GUTHIX), item(ItemID.LEAGUE_3_BOOK_ZAMORAK), item(ItemID.LEAGUE_3_BOOK_ARMADYL), item(ItemID.LEAGUE_3_BOOK_BANDOS), item(ItemID.LEAGUE_3_BOOK_ZAROS))),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP4, "Cheer in the Shadow dungeon. Equip a rune crossbow, climbing boots and any mitre.", "Shadow dungeon", ENTRANCE_OF_THE_CAVE_OF_DAMIS, new WorldPoint(2629, 5071, 0), CHEER, any("Any mitre", item(ItemID.TRAIL_GUTHIX_MITRE), item(ItemID.TRAIL_SARADOMIN_MITRE), item(ItemID.TRAIL_ZAMORAK_MITRE), item(ItemID.TRAIL_ANCIENT_MITRE), item(ItemID.TRAIL_BANDOS_MITRE), item(ItemID.TRAIL_ARMADYL_MITRE)), any("Rune crossbow", item(ItemID.XBOWS_CROSSBOW_RUNITE), item(ItemID.LEAGUE_3_RUNE_XBOW)), any("Climbing boots", item(ItemID.DEATH_CLIMBINGBOOTS), item(ItemID.CLIMBING_BOOTS_G)), any("Ring of visibility or ring of shadows", item(ItemID.FD_RING_VISIBILITY), item(ItemID.RING_OF_SHADOWS), item(ItemID.RING_OF_SHADOWS_UNCHARGED))),
		new EmoteClue(ItemID.TRAIL_HARD_EMOTE_EXP5, "Cheer at the top of the agility pyramid. Beware of double agents! Equip a blue mystic robe top and any rune heraldic shield.", "Agility Pyramid", AGILITY_PYRAMID, new WorldPoint(3043, 4697, 3), DOUBLE_AGENT_108, CHEER, item(ItemID.MYSTIC_ROBE_TOP), any("Any rune heraldic shield", item(ItemID.RUNE_HERALDIC_KITESHIELD1), item(ItemID.RUNE_HERALDIC_KITESHIELD2), item(ItemID.RUNE_HERALDIC_KITESHIELD3), item(ItemID.RUNE_HERALDIC_KITESHIELD4), item(ItemID.RUNE_HERALDIC_KITESHIELD5))),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Dance in Iban's temple. Beware of double agents! Equip Iban's staff, a black mystic top and a black mystic bottom.", "Iban's temple", WELL_OF_VOYAGE, new WorldPoint(2011, 4712, 0), DOUBLE_AGENT_141, DANCE, any("Any iban's staff", item(ItemID.IBANSTAFF), item(ItemID.IBANSTAFF_UPGRADED)), item(ItemID.MYSTIC_ROBE_TOP_DARK), item(ItemID.MYSTIC_ROBE_BOTTOM_DARK)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP7, "Dance on the Fishing Platform. Equip barrows gloves, an amulet of glory and a dragon med helm.", "Fishing Platform", SOUTHEAST_CORNER_OF_THE_FISHING_PLATFORM, new WorldPoint(2782, 3273, 0), DANCE, any("Any amulet of glory", item(ItemID.AMULET_OF_GLORY), item(ItemID.AMULET_OF_GLORY_1), item(ItemID.AMULET_OF_GLORY_2), item(ItemID.AMULET_OF_GLORY_3), item(ItemID.AMULET_OF_GLORY_4), item(ItemID.AMULET_OF_GLORY_5), item(ItemID.AMULET_OF_GLORY_6)), item(ItemID.HUNDRED_GAUNTLETS_LEVEL_10), item(ItemID.DRAGON_MED_HELM)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Flap at the death altar. Beware of double agents! Equip a death tiara, a legend's cape and any ring of wealth.", "Death altar", DEATH_ALTAR, new WorldPoint(2205, 4838, 0), DOUBLE_AGENT_141, FLAP, ANY_RING_OF_WEALTH, item(ItemID.TIARA_DEATH), item(ItemID.CAPE_OF_LEGENDS)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP16, "Headbang in the Fight Arena pub. Equip a pirate bandana, a dragonstone necklace and and a magic longbow.", "Fight Arena pub", OUTSIDE_THE_BAR_BY_THE_FIGHT_ARENA, new WorldPoint(2568, 3149, 0), HEADBANG, any("Any pirate bandana", item(ItemID.PIRATE_BANDANNA), item(ItemID.PIRATE_BANDANA_RED), item(ItemID.PIRATE_BANDANA_BLUE), item(ItemID.PIRATE_BANDANA_BROWN)), item(ItemID.DRAGONSTONE_NECKLACE), item(ItemID.MAGIC_LONGBOW)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Do a jig at the barrows chest. Beware of double agents! Equip any full barrows set.", "Barrows chest", BARROWS_CHEST, new WorldPoint(3551, 9694, 0), DOUBLE_AGENT_141, JIG, any("Any full barrows set",
			all(any("Ahrim's hood", item(ItemID.BARROWS_AHRIM_HEAD), range(ItemID.BARROWS_AHRIM_HEAD_100, ItemID.BARROWS_AHRIM_HEAD_BROKEN), item(ItemID.BARROWS_AHRIM_HEAD_ORNAMENT), item(ItemID.BARROWS_AHRIM_HEAD_ORNAMENT_100), item(ItemID.BARROWS_AHRIM_HEAD_ORNAMENT_75), item(ItemID.BARROWS_AHRIM_HEAD_ORNAMENT_50), item(ItemID.BARROWS_AHRIM_HEAD_ORNAMENT_25), item(ItemID.BARROWS_AHRIM_HEAD_ORNAMENT_BROKEN)), any("Ahrim's staff", item(ItemID.BARROWS_AHRIM_WEAPON), range(ItemID.BARROWS_AHRIM_WEAPON_100, ItemID.BARROWS_AHRIM_WEAPON_BROKEN), item(ItemID.BARROWS_AHRIM_WEAPON_ORNAMENT), range(ItemID.BARROWS_AHRIM_WEAPON_ORNAMENT_100, ItemID.BARROWS_AHRIM_WEAPON_ORNAMENT_BROKEN)), any("Ahrim's robetop", item(ItemID.BARROWS_AHRIM_BODY), range(ItemID.BARROWS_AHRIM_BODY_100, ItemID.BARROWS_AHRIM_BODY_BROKEN), item(ItemID.BARROWS_AHRIM_BODY_ORNAMENT), item(ItemID.BARROWS_AHRIM_BODY_ORNAMENT_100), item(ItemID.BARROWS_AHRIM_BODY_ORNAMENT_75), item(ItemID.BARROWS_AHRIM_BODY_ORNAMENT_50), item(ItemID.BARROWS_AHRIM_BODY_ORNAMENT_25), item(ItemID.BARROWS_AHRIM_BODY_ORNAMENT_BROKEN)), any("Ahrim's robeskirt", item(ItemID.BARROWS_AHRIM_LEGS), range(ItemID.BARROWS_AHRIM_LEGS_100, ItemID.BARROWS_AHRIM_LEGS_BROKEN), item(ItemID.BARROWS_AHRIM_LEGS_ORNAMENT), item(ItemID.BARROWS_AHRIM_LEGS_ORNAMENT_100), item(ItemID.BARROWS_AHRIM_LEGS_ORNAMENT_75), item(ItemID.BARROWS_AHRIM_LEGS_ORNAMENT_50), item(ItemID.BARROWS_AHRIM_LEGS_ORNAMENT_25), item(ItemID.BARROWS_AHRIM_LEGS_ORNAMENT_BROKEN))),
			all(any("Dharok's helm", item(ItemID.BARROWS_DHAROK_HEAD), range(ItemID.BARROWS_DHAROK_HEAD_100, ItemID.BARROWS_DHAROK_HEAD_BROKEN)), any("Dharok's greataxe", item(ItemID.BARROWS_DHAROK_WEAPON), range(ItemID.BARROWS_DHAROK_WEAPON_100, ItemID.BARROWS_DHAROK_WEAPON_BROKEN)), any("Dharok's platebody", item(ItemID.BARROWS_DHAROK_BODY), range(ItemID.BARROWS_DHAROK_BODY_100, ItemID.BARROWS_DHAROK_BODY_BROKEN)), any("Dharok's platelegs", item(ItemID.BARROWS_DHAROK_LEGS), range(ItemID.BARROWS_DHAROK_LEGS_100, ItemID.BARROWS_DHAROK_LEGS_BROKEN))),
			all(any("Guthan's helm", item(ItemID.BARROWS_GUTHAN_HEAD), range(ItemID.BARROWS_GUTHAN_HEAD_100, ItemID.BARROWS_GUTHAN_HEAD_BROKEN)), any("Guthan's warspear", item(ItemID.BARROWS_GUTHAN_WEAPON), range(ItemID.BARROWS_GUTHAN_WEAPON_100, ItemID.BARROWS_GUTHAN_WEAPON_BROKEN)), any("Guthan's platebody", item(ItemID.BARROWS_GUTHAN_BODY), range(ItemID.BARROWS_GUTHAN_BODY_100, ItemID.BARROWS_GUTHAN_BODY_BROKEN)), any("Guthan's chainskirt", item(ItemID.BARROWS_GUTHAN_LEGS), range(ItemID.BARROWS_GUTHAN_LEGS_100, ItemID.BARROWS_GUTHAN_LEGS_BROKEN))),
			all(any("Karil's coif", item(ItemID.BARROWS_KARIL_HEAD), range(ItemID.BARROWS_KARIL_HEAD_100, ItemID.BARROWS_KARIL_HEAD_BROKEN)), any("Karil's crossbow", item(ItemID.BARROWS_KARIL_WEAPON), range(ItemID.BARROWS_KARIL_WEAPON_100, ItemID.BARROWS_KARIL_WEAPON_BROKEN)), any("Karil's leathertop", item(ItemID.BARROWS_KARIL_BODY), range(ItemID.BARROWS_KARIL_BODY_100, ItemID.BARROWS_KARIL_BODY_BROKEN)), any("Karil's leatherskirt", item(ItemID.BARROWS_KARIL_LEGS), range(ItemID.BARROWS_KARIL_LEGS_100, ItemID.BARROWS_KARIL_LEGS_BROKEN))),
			all(any("Torag's helm", item(ItemID.BARROWS_TORAG_HEAD), range(ItemID.BARROWS_TORAG_HEAD_100, ItemID.BARROWS_TORAG_HEAD_BROKEN)), any("Torag's hammers", item(ItemID.BARROWS_TORAG_WEAPON), range(ItemID.BARROWS_TORAG_WEAPON_100, ItemID.BARROWS_TORAG_WEAPON_BROKEN)), any("Torag's platebody", item(ItemID.BARROWS_TORAG_BODY), range(ItemID.BARROWS_TORAG_BODY_100, ItemID.BARROWS_TORAG_BODY_BROKEN)), any("Torag's platelegs", item(ItemID.BARROWS_TORAG_LEGS), range(ItemID.BARROWS_TORAG_LEGS_100, ItemID.BARROWS_TORAG_LEGS_BROKEN))),
			all(any("Verac's helm", item(ItemID.BARROWS_VERAC_HEAD), range(ItemID.BARROWS_VERAC_HEAD_100, ItemID.BARROWS_VERAC_HEAD_BROKEN)), any("Verac's flail", item(ItemID.BARROWS_VERAC_WEAPON), range(ItemID.BARROWS_VERAC_WEAPON_100, ItemID.BARROWS_VERAC_WEAPON_BROKEN)), any("Verac's brassard", item(ItemID.BARROWS_VERAC_BODY), range(ItemID.BARROWS_VERAC_BODY_100, ItemID.BARROWS_VERAC_BODY_BROKEN)), any("Verac's plateskirt", item(ItemID.BARROWS_VERAC_LEGS), range(ItemID.BARROWS_VERAC_LEGS_100, ItemID.BARROWS_VERAC_LEGS_BROKEN))))),
		new EmoteClue(ItemID.TRAIL_HARD_EMOTE_EXP4, "Jig at Jiggig. Beware of double agents! Equip a Rune spear, rune platelegs and any rune heraldic helm.", "Jiggig", IN_THE_MIDDLE_OF_JIGGIG, new WorldPoint(2477, 3047, 0), DOUBLE_AGENT_108, JIG, range("Any rune heraldic helm", ItemID.TRAIL_HERALDIC_HELM_1_RUNE, ItemID.TRAIL_HERALDIC_HELM_5_RUNE), item(ItemID.RUNE_SPEAR), item(ItemID.RUNE_PLATELEGS)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE017, "Cheer at the games room. Have nothing equipped at all when you do.", "Burthorpe Games Room", null, new WorldPoint(2207, 4952, 0), CHEER, emptySlot("Nothing at all", EquipmentInventorySlot.values())),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE023, "Panic on the pier where you catch the Fishing trawler. Have nothing equipped at all when you do.", "Fishing trawler", null, new WorldPoint(2676, 3169, 0), PANIC, emptySlot("Nothing at all", EquipmentInventorySlot.values())),
		new EmoteClue(ItemID.TRAIL_CLUE_HARD_EMOTE004, "Panic in the heart of the Haunted Woods. Beware of double agents! Have no items equipped when you do.", "Haunted Woods (ALQ)", null, new WorldPoint(3611, 3492, 0), DOUBLE_AGENT_108, PANIC, emptySlot("Nothing at all", EquipmentInventorySlot.values())),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Show your anger towards the Statue of Saradomin in Ellamaria's garden. Beware of double agents! Equip a zamorak godsword.", "Varrock Castle", BY_THE_BEAR_CAGE_IN_VARROCK_PALACE_GARDENS, new WorldPoint(3230, 3478, 0), DOUBLE_AGENT_141, ANGRY, any("Zamorak godsword", item(ItemID.ZGS), item(ItemID.ZGSG))),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Show your anger at the Wise old man. Beware of double agents! Equip an abyssal whip, a legend's cape and some spined chaps.", "Draynor Village", BEHIND_MISS_SCHISM_IN_DRAYNOR_VILLAGE, new WorldPoint(3088, 3254, 0), DOUBLE_AGENT_141, ANGRY, any("Abyssal whip", item(ItemID.ABYSSAL_WHIP), item(ItemID.ABYSSAL_WHIP_LAVA), item(ItemID.ABYSSAL_WHIP_ICE), item(ItemID.LEAGUE_3_WHIP), item(ItemID.ABYSSAL_TENTACLE), item(ItemID.LEAGUE_3_WHIP_TENTACLE)), item(ItemID.CAPE_OF_LEGENDS), item(ItemID.DAGGANOTH_RANGED_LEGS)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Beckon by a collection of crystalline maple trees. Beware of double agents! Equip Bryophyta's staff and a nature tiara.", "North of Prifddinas", CRYSTALLINE_MAPLE_TREES, new WorldPoint(2211, 3427, 0), DOUBLE_AGENT_141, BECKON, range("Bryophyta's staff", ItemID.NATURE_STAFF_UNCHARGED, ItemID.NATURE_STAFF_CHARGED), item(ItemID.TIARA_NATURE)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE011, "Beckon in the Digsite, near the eastern winch. Bow before you talk to me. Equip a green gnome hat, snakeskin boots and an iron pickaxe.", "Digsite", DIGSITE, new WorldPoint(3370, 3425, 0), BECKON, BOW, item(ItemID.GNOME_HAT_GREEN), item(ItemID.SNAKESKIN_BOOTS), item(ItemID.IRON_PICKAXE)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE004, "Beckon in Tai Bwo Wannai. Clap before you talk to me. Equip green dragonhide chaps, a ring of dueling and a mithril medium helmet.", "Tai Bwo Wannai", SOUTH_OF_THE_SHRINE_IN_TAI_BWO_WANNAI_VILLAGE, new WorldPoint(2803, 3073, 0), BECKON, CLAP, item(ItemID.DRAGONHIDE_CHAPS), any("Ring of dueling", item(ItemID.RING_OF_DUELING_1), item(ItemID.RING_OF_DUELING_2), item(ItemID.RING_OF_DUELING_3), item(ItemID.RING_OF_DUELING_4), item(ItemID.RING_OF_DUELING_5), item(ItemID.RING_OF_DUELING_6), item(ItemID.RING_OF_DUELING_7), item(ItemID.RING_OF_DUELING_8)), item(ItemID.MITHRIL_MED_HELM)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_EXP7, "Beckon in the Shayzien Combat Ring. Show your anger before you talk to me. Equip an adamant platebody, adamant full helm and adamant platelegs.", "Shayzien Combat Ring", WEST_OF_THE_SHAYZIEN_COMBAT_RING, new WorldPoint(1543, 3623, 0), BECKON, ANGRY, item(ItemID.ADAMANT_PLATELEGS), item(ItemID.ADAMANT_PLATEBODY), item(ItemID.ADAMANT_FULL_HELM)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Bow near Lord Iorwerth. Beware of double agents! Equip a charged crystal bow.", "Lord Iorwerth's camp", TENT_IN_LORD_IORWERTHS_ENCAMPMENT, new WorldPoint(2205, 3252, 0), DOUBLE_AGENT_141, BOW, ACTIVE_CRYSTAL_BOW_OR_BOW_OF_FAERDHINEN),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Bow in the Iorwerth Camp. Beware of double agents! Equip a charged crystal bow.", "Lord Iorwerth's camp", TENT_IN_LORD_IORWERTHS_ENCAMPMENT, new WorldPoint(2205, 3252, 0), DOUBLE_AGENT_141, BOW, ACTIVE_CRYSTAL_BOW_OR_BOW_OF_FAERDHINEN),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE005, "Bow outside the entrance to the Legends' Guild. Equip iron platelegs, an emerald amulet and an oak longbow.", "Legend's Guild", OUTSIDE_THE_LEGENDS_GUILD_GATES, new WorldPoint(2729, 3349, 0), BOW, item(ItemID.IRON_PLATELEGS), item(ItemID.OAK_LONGBOW), item(ItemID.STRUNG_EMERALD_AMULET)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP14, "Bow on the ground floor of the Legends' Guild. Equip a Cape of Legends, a dragon battleaxe and an amulet of glory.", "Legend's Guild", OUTSIDE_THE_LEGENDS_GUILD_DOOR, new WorldPoint(2728, 3377, 0), BOW, item(ItemID.CAPE_OF_LEGENDS), any("Dragon battleaxe", item(ItemID.DRAGON_BATTLEAXE), item(ItemID.BH_DRAGON_BATTLEAXE_CORRUPTED)), any("Any amulet of glory", item(ItemID.AMULET_OF_GLORY), item(ItemID.AMULET_OF_GLORY_1), item(ItemID.AMULET_OF_GLORY_2), item(ItemID.AMULET_OF_GLORY_3), item(ItemID.AMULET_OF_GLORY_4), item(ItemID.AMULET_OF_GLORY_5), item(ItemID.AMULET_OF_GLORY_6))),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE027, "Bow in the office of the Emir's Arena. Equip an iron chain body, leather chaps and coif.", "Emir's Arena", EMIRS_ARENA_TICKET_OFFICE, new WorldPoint(3314, 3241, 0), BOW, item(ItemID.IRON_CHAINBODY), item(ItemID.LEATHER_CHAPS), item(ItemID.COIF)),
		new EmoteClue(ItemID.TRAIL_CLUE_HARD_EMOTE003, "Bow at the top of the lighthouse. Beware of double agents! Equip a blue dragonhide body, blue dragonhide vambraces and no jewelry.", "Lighthouse", TOP_FLOOR_OF_THE_LIGHTHOUSE, new WorldPoint(2511, 3641, 2), DOUBLE_AGENT_108, BOW, item(ItemID.BLUE_DRAGONHIDE_BODY), item(ItemID.BLUE_DRAGON_VAMBRACES), emptySlot("No jewellery", AMULET, RING)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_VM01, "Bow within the temple in Civitas illa Fortis. Equip any piece of sunfire fanatic armour.", "Civitas illa Fortis", TEMPLE_SOUTHEAST_OF_THE_BAZAAR, new WorldPoint(1699, 3087, 0), BOW, any("Any piece of Sunfire Fanatic armour", item(ItemID.SUNFIRE_HELM), item(ItemID.SUNFIRE_BODY), item(ItemID.SUNFIRE_LEGS))),
		new EmoteClue(ItemID.TRAIL_CLUE_HARD_EMOTE010, "Blow a kiss between the tables in Shilo Village bank. Beware of double agents! Equip a blue mystic hat, bone spear and rune platebody.", "Shilo Village", SHILO_VILLAGE_BANK, new WorldPoint(2851, 2954, 0), DOUBLE_AGENT_108, BLOW_KISS, item(ItemID.MYSTIC_HAT), item(ItemID.CAVE_GOBLIN_BONE_SPEAR), item(ItemID.RUNE_PLATEBODY)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP3, "Blow a kiss in the heart of the lava maze. Equip black dragonhide chaps, a spotted cape and a rolling pin.", "Lava maze", NEAR_A_LADDER_IN_THE_WILDERNESS_LAVA_MAZE, new WorldPoint(3069, 3861, 0), BLOW_KISS, item(ItemID.BLACK_DRAGONHIDE_CHAPS), any("Spotted cape", item(ItemID.HUNTING_LIGHT_CAPE), item(ItemID.HUNTING_LIGHT_CAPE_WORN)), item(ItemID.HUNDRED_ROLLINGPIN)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Blow a kiss outside K'ril Tsutsaroth's chamber. Beware of double agents! Equip a zamorak full helm and the shadow sword.", "K'ril's chamber", OUTSIDE_KRIL_TSUTSAROTHS_ROOM, new WorldPoint(2925, 5333, 2), DOUBLE_AGENT_141, BLOW_KISS, item(ItemID.RUNE_FULL_HELM_ZAMORAK), item(ItemID.SHADOW_MAJ_SHADOW_SWORD)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE016, "Cheer at the Druids' Circle. Equip a blue wizard hat, a bronze two-handed sword and HAM boots.", "Taverley stone circle", TAVERLEY_STONE_CIRCLE, new WorldPoint(2924, 3478, 0), CHEER, item(ItemID.BLUEWIZHAT), item(ItemID.BRONZE_2H_SWORD), item(ItemID.HAM_BOOTS)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_EXP6, "Cheer in the Edgeville general store. Dance before you talk to me. Equip a brown apron, leather boots and leather gloves.", "Edgeville", NORTH_OF_EVIL_DAVES_HOUSE_IN_EDGEVILLE, new WorldPoint(3080, 3509, 0), CHEER, DANCE, item(ItemID.BROWN_APRON), item(ItemID.LEATHER_BOOTS), item(ItemID.LEATHER_GLOVES)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE010, "Cheer in the Ogre Pen in the Training Camp. Show you are angry before you talk to me. Equip a green dragonhide body and chaps and a steel square shield.", "King Lathas' camp", OGRE_CAGE_IN_KING_LATHAS_TRAINING_CAMP, new WorldPoint(2527, 3375, 0), CHEER, ANGRY, item(ItemID.DRAGONHIDE_BODY), item(ItemID.DRAGONHIDE_CHAPS), item(ItemID.STEEL_SQ_SHIELD)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Cheer in the Entrana church. Beware of double agents! Equip a full set of black dragonhide armour.", "Entrana church", ENTRANA_CHAPEL, new WorldPoint(2852, 3349, 0), DOUBLE_AGENT_141, CHEER, item(ItemID.BLACK_DRAGON_VAMBRACES), item(ItemID.BLACK_DRAGONHIDE_CHAPS), item(ItemID.BLACK_DRAGONHIDE_BODY)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE007, "Cheer for the monks at Port Sarim. Equip a coif, steel plateskirt and a sapphire necklace.", "Port Sarim", NEAR_THE_ENTRANA_FERRY_IN_PORT_SARIM, new WorldPoint(3047, 3237, 0), CHEER, item(ItemID.COIF), item(ItemID.STEEL_PLATESKIRT), item(ItemID.SAPPHIRE_NECKLACE)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE025, "Clap in the main exam room in the Exam Centre. Equip a white apron, green gnome boots and leather gloves.", "Exam Centre", OUTSIDE_THE_DIGSITE_EXAM_CENTRE, new WorldPoint(3361, 3339, 0), CLAP, item(ItemID.WHITE_APRON), item(ItemID.GNOME_BOOTS_GREEN), item(ItemID.LEATHER_GLOVES)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE002, "Clap on the causeway to the Wizards' Tower. Equip an iron medium helmet, emerald ring and a white apron.", "Wizards' Tower", ON_THE_BRIDGE_TO_THE_MISTHALIN_WIZARDS_TOWER, new WorldPoint(3113, 3196, 0), CLAP, item(ItemID.IRON_MED_HELM), item(ItemID.EMERALD_RING), item(ItemID.WHITE_APRON)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE014, "Clap on the top level of the mill, north of East Ardougne. Equip a blue gnome robe top, HAM robe bottom and an unenchanted tiara.", "East Ardougne", UPSTAIRS_IN_THE_ARDOUGNE_WINDMILL, new WorldPoint(2635, 3385, 3), CLAP, item(ItemID.GNOME_ROBETOP_BLUE), item(ItemID.HAM_ROBE), item(ItemID.TIARA)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_EXP3, "Clap in Seers court house. Spin before you talk to me. Equip an adamant halberd, blue mystic robe bottom and a diamond ring.", "Seers Village", OUTSIDE_THE_SEERS_VILLAGE_COURTHOUSE, new WorldPoint(2735, 3469, 0), CLAP, SPIN, item(ItemID.ADAMANT_HALBERD), item(ItemID.MYSTIC_ROBE_BOTTOM), item(ItemID.DIAMOND_RING)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Clap in the magic axe hut. Beware of double agents! Equip only some flared trousers.", "Magic axe hut", OUTSIDE_THE_WILDERNESS_AXE_HUT, new WorldPoint(3191, 3960, 0), DOUBLE_AGENT_141, CLAP, item(ItemID.TRAIL_FLARED_PANTS), item(ItemID.LOCKPICK), emptySlot("Nothing else", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_EXP10, "Clap your hands north of Mount Karuulm Spin before you talk to me. Equip an adamant warhammer, a ring of life and a pair of mithril boots.", "Mount Karuulm", NORTH_OF_MOUNT_KARUULM, new WorldPoint(1306, 3839, 0), CLAP, SPIN, item(ItemID.ADAMNT_WARHAMMER), item(ItemID.RING_OF_LIFE), item(ItemID.MITHRIL_ARMOURED_BOOTS)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE012, "Cry in the Catherby Ranging shop. Bow before you talk to me. Equip blue gnome boots, a hard leather body and an unblessed silver sickle.", "Catherby", HICKTONS_ARCHERY_EMPORIUM, new WorldPoint(2823, 3443, 0), CRY, BOW, item(ItemID.GNOME_BOOTS_BLUE), item(ItemID.HARDLEATHER_BODY), item(ItemID.SILVER_SICKLE)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_EXP4, "Cry on the shore of Catherby beach. Laugh before you talk to me, equip an adamant sq shield, a bone dagger and mithril platebody.", "Catherby", OUTSIDE_HARRYS_FISHING_SHOP_IN_CATHERBY, new WorldPoint(2852, 3429, 0), CRY, LAUGH, item(ItemID.ADAMANT_SQ_SHIELD), item(ItemID.DTTD_BONE_DAGGER), item(ItemID.MITHRIL_PLATEBODY)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE007, "Cry on top of the western tree in the Gnome Agility Arena. Indicate 'no' before you talk to me. Equip a steel kiteshield, ring of forging and green dragonhide chaps.", "Gnome Stronghold", GNOME_STRONGHOLD_BALANCING_ROPE, new WorldPoint(2473, 3420, 2), CRY, NO, item(ItemID.STEEL_KITESHIELD), item(ItemID.RING_OF_FORGING), item(ItemID.DRAGONHIDE_CHAPS)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Cry in the TzHaar gem store. Beware of double agents! Equip a fire cape and TokTz-Xil-Ul.", "Tzhaar gem store", TZHAAR_GEM_STORE, new WorldPoint(2463, 5149, 0), DOUBLE_AGENT_141, CRY, any("Fire cape", item(ItemID.TZHAAR_CAPE_FIRE), item(ItemID.TZHAAR_CAPE_FIRE_TROUVER), item(ItemID.SKILLCAPE_MAX_FIRECAPE), item(ItemID.SKILLCAPE_MAX_FIRECAPE_TROUVER), item(ItemID.INFERNAL_CAPE), item(ItemID.INFERNAL_CAPE_TROUVER), item(ItemID.SKILLCAPE_MAX_INFERNALCAPE), item(ItemID.SKILLCAPE_MAX_INFERNALCAPE_TROUVER)), item(ItemID.TZHAAR_THROWINGRING)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_EXP9, "Cry in the Draynor Village jail. Jump for joy before you talk to me. Equip an adamant sword, a sapphire amulet and an adamant plateskirt.", "Draynor Village jail", OUTSIDE_DRAYNOR_VILLAGE_JAIL, new WorldPoint(3128, 3245, 0), CRY, JUMP_FOR_JOY, item(ItemID.ADAMANT_SWORD), item(ItemID.STRUNG_SAPPHIRE_AMULET), item(ItemID.ADAMANT_PLATESKIRT)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE011, "Dance at the crossroads north of Draynor. Equip an iron chain body, a sapphire ring and a longbow.", "Draynor Village", CROSSROADS_NORTH_OF_DRAYNOR_VILLAGE, new WorldPoint(3109, 3294, 0), DANCE, item(ItemID.IRON_CHAINBODY), item(ItemID.SAPPHIRE_RING), item(ItemID.LONGBOW)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE015, "Dance in the Party Room. Equip a steel full helmet, steel platebody and an iron plateskirt.", "Falador Party Room", OUTSIDE_THE_FALADOR_PARTY_ROOM, new WorldPoint(3045, 3376, 0), DANCE, item(ItemID.STEEL_FULL_HELM), item(ItemID.STEEL_PLATEBODY), item(ItemID.IRON_PLATESKIRT)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE001, "Dance in the shack in Lumbridge Swamp. Equip a bronze dagger, iron full helmet and a gold ring.", "Lumbridge swamp", NEAR_A_SHED_IN_LUMBRIDGE_SWAMP, new WorldPoint(3203, 3169, 0), DANCE, item(ItemID.BRONZE_DAGGER), item(ItemID.IRON_FULL_HELM), item(ItemID.GOLD_RING)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_EXP1, "Dance in the dark caves beneath Lumbridge Swamp. Blow a kiss before you talk to me. Equip an air staff, Bronze full helm and an amulet of power.", "Lumbridge swamp caves", LUMBRIDGE_SWAMP_CAVES, new WorldPoint(3168, 9571, 0), DANCE, BLOW_KISS, VarbitID.MY2ARM_FIRE_LUMB, item(ItemID.STAFF_OF_AIR), item(ItemID.BRONZE_FULL_HELM), item(ItemID.AMULET_OF_POWER)),
		new EmoteClue(ItemID.TRAIL_CLUE_HARD_EMOTE005, "Dance at the cat-doored pyramid in Sophanem. Beware of double agents! Equip a ring of life, an uncharged amulet of glory and an adamant two-handed sword.", "Pyramid Of Sophanem", OUTSIDE_THE_GREAT_PYRAMID_OF_SOPHANEM, new WorldPoint(3294, 2781, 0), DOUBLE_AGENT_108, DANCE, item(ItemID.RING_OF_LIFE), item(ItemID.AMULET_OF_GLORY), item(ItemID.ADAMANT_2H_SWORD)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE001, "Dance in the centre of Canifis. Bow before you talk to me. Equip a green gnome robe top, mithril plate legs and an iron two-handed sword.", "Canifis", CENTRE_OF_CANIFIS, new WorldPoint(3492, 3488, 0), DANCE, BOW, item(ItemID.GNOME_ROBETOP_GREEN), item(ItemID.MITHRIL_PLATELEGS), item(ItemID.IRON_2H_SWORD)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Dance in the King Black Dragon's lair. Beware of double agents! Equip a black dragonhide body, black dragonhide vambraces and a black dragon mask.", "King black dragon's lair", KING_BLACK_DRAGONS_LAIR, new WorldPoint(2271, 4680, 0), DOUBLE_AGENT_141, DANCE, item(ItemID.BLACK_DRAGONHIDE_BODY), item(ItemID.BLACK_DRAGON_VAMBRACES), item(ItemID.DRAGONMASK_BLACK)),
		new EmoteClue(ItemID.TRAIL_EASY_EMOTE_EXP3, "Dance at the entrance to the Grand Exchange. Equip a pink skirt, pink robe top and a body tiara.", "Grand Exchange", SOUTH_OF_THE_GRAND_EXCHANGE, new WorldPoint(3165, 3467, 0), DANCE, item(ItemID.PINK_SKIRT), item(ItemID.GNOME_ROBETOP_PINK), item(ItemID.TIARA_BODY)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Goblin Salute in the Goblin Village. Beware of double agents! Equip a bandos godsword, a bandos cloak and a bandos platebody.", "Goblin Village", OUTSIDE_MUDKNUCKLES_HUT, new WorldPoint(2956, 3505, 0), DOUBLE_AGENT_141, GOBLIN_SALUTE, item(ItemID.RUNE_PLATEBODY_BANDOS), item(ItemID.TRAIL_BANDOS_CLOAK), any("Bandos godsword", item(ItemID.BGS), item(ItemID.BGSG))),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE008, "Headbang in the mine north of Al Kharid. Equip a desert shirt, leather gloves and leather boots.", "Al Kharid mine", AL_KHARID_SCORPION_MINE, new WorldPoint(3299, 3289, 0), HEADBANG, item(ItemID.DESERT_SHIRT), item(ItemID.LEATHER_GLOVES), item(ItemID.LEATHER_BOOTS)),
		new EmoteClue(ItemID.TRAIL_HARD_EMOTE_EXP1, "Headbang at the exam centre. Beware of double agents! Equip a mystic fire staff, a diamond bracelet and rune boots.", "Exam Centre", INSIDE_THE_DIGSITE_EXAM_CENTRE, new WorldPoint(3362, 3340, 0), DOUBLE_AGENT_108, HEADBANG, item(ItemID.MYSTIC_FIRE_STAFF), item(ItemID.JEWL_DIAMOND_BRACELET), item(ItemID.RUNE_ARMOURED_BOOTS)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP8, "Headbang at the top of Slayer Tower. Equip a seercull, a combat bracelet and helm of Neitiznot.", "Slayer Tower", OUTSIDE_THE_SLAYER_TOWER_GARGOYLE_ROOM, new WorldPoint(3421, 3537, 2), HEADBANG, item(ItemID.DAGANOTH_CAVE_MAGIC_SHORTBOW), any("Combat bracelet", range(ItemID.JEWL_BRACELET_OF_COMBAT_4, ItemID.JEWL_BRACELET_OF_COMBAT), item(ItemID.JEWL_BRACELET_OF_COMBAT_5), item(ItemID.JEWL_BRACELET_OF_COMBAT_6)), item(ItemID.FRIS_KINGLY_HELM)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE021, "Dance a jig by the entrance to the Fishing Guild. Equip an emerald ring, a sapphire amulet, and a bronze chain body.", "Fishing Guild", OUTSIDE_THE_FISHING_GUILD, new WorldPoint(2610, 3391, 0), JIG, item(ItemID.EMERALD_RING), item(ItemID.STRUNG_SAPPHIRE_AMULET), item(ItemID.BRONZE_CHAINBODY)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE013, "Dance a jig under Shantay's Awning. Bow before you talk to me. Equip a pointed blue snail helmet, an air staff and a bronze square shield.", "Shantay Pass", SHANTAY_PASS, new WorldPoint(3304, 3124, 0), JIG, BOW, item(ItemID.SNELM_POINT_BLUE), item(ItemID.STAFF_OF_AIR), item(ItemID.BRONZE_SQ_SHIELD)),
		new EmoteClue(ItemID.TRAIL_EASY_EMOTE_EXP4, "Do a jig in Varrock's rune store. Equip an air tiara and a staff of water.", "Varrock rune store", AUBURYS_SHOP_IN_VARROCK, new WorldPoint(3253, 3401, 0), JIG, item(ItemID.TIARA_AIR), item(ItemID.STAFF_OF_WATER)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE018, "Jump for joy at the beehives. Equip a desert shirt, green gnome robe bottoms and a steel axe.", "Catherby", CATHERBY_BEEHIVE_FIELD, new WorldPoint(2759, 3445, 0), JUMP_FOR_JOY, item(ItemID.DESERT_SHIRT), item(ItemID.GNOME_ROBEBOTTOMS_GREEN), item(ItemID.STEEL_AXE)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE008, "Jump for joy in Yanille bank. Dance a jig before you talk to me. Equip a brown apron, adamantite medium helmet and snakeskin chaps.", "Yanille", OUTSIDE_YANILLE_BANK, new WorldPoint(2610, 3092, 0), JUMP_FOR_JOY, JIG, item(ItemID.BROWN_APRON), item(ItemID.ADAMANT_MED_HELM), item(ItemID.SNAKESKIN_CHAPS)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_EXP5, "Jump for joy in the TzHaar sword shop. Shrug before you talk to me. Equip a Steel longsword, Blue D'hide body and blue mystic gloves.", "Tzhaar weapon store", TZHAAR_WEAPONS_STORE, new WorldPoint(2477, 5146, 0), JUMP_FOR_JOY, SHRUG, item(ItemID.STEEL_LONGSWORD), item(ItemID.BLUE_DRAGONHIDE_BODY), item(ItemID.MYSTIC_GLOVES)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP11, "Jump for joy in the Ancient Cavern. Equip a granite shield, splitbark body and any rune heraldic helm.", "Ancient cavern", ENTRANCE_OF_THE_CAVERN_UNDER_THE_WHIRLPOOL, new WorldPoint(1768, 5366, 1), JUMP_FOR_JOY, item(ItemID.GRANITE_SHIELD), item(ItemID.SPLITBARK_BODY), range("Any rune heraldic helm", ItemID.TRAIL_HERALDIC_HELM_1_RUNE, ItemID.TRAIL_HERALDIC_HELM_5_RUNE)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP2, "Jump for joy at the Neitiznot rune rock. Equip Rune boots, a proselyte hauberk and a dragonstone ring.", "Fremennik Isles", NEAR_A_RUNITE_ROCK_IN_THE_FREMENNIK_ISLES, new WorldPoint(2375, 3850, 0), JUMP_FOR_JOY, item(ItemID.RUNE_ARMOURED_BOOTS), item(ItemID.BASIC_TK_RANK2_BODY), item(ItemID.DRAGONSTONE_RING)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Jump for joy in the centre of Zul-Andra. Beware of double agents! Equip a dragon 2h sword, bandos boots and an obsidian cape.", "Zul-Andra", NEAR_THE_PIER_IN_ZULANDRA, new WorldPoint(2199, 3056, 0), DOUBLE_AGENT_141, JUMP_FOR_JOY, item(ItemID.DRAGON_2H_SWORD), any("Bandos boots", item(ItemID.BANDOS_BOOTS), item(ItemID.GUARDIAN_BOOTS), item(ItemID.ECHO_BOOTS)), item(ItemID.TZHAAR_CAPE_OBSIDIAN)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_23, "Jump for Joy in the mine near the Twilight Temple. Bow before you talk to me. Equip a maple longbow, a ruby amulet and some steel platelegs.", "Twilight Temple", TWILIGHT_TEMPLE_MINE, new WorldPoint (1672, 3284, 0), JUMP_FOR_JOY, BOW, item(ItemID.MAPLE_LONGBOW), item(ItemID.STRUNG_RUBY_AMULET), item(ItemID.STEEL_PLATELEGS)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP10, "Laugh by the fountain of heroes. Equip splitbark legs, dragon boots and a Rune longsword.", "Fountain of heroes", FOUNTAIN_OF_HEROES, new WorldPoint(2920, 9893, 0), LAUGH, item(ItemID.SPLITBARK_LEGS), any("Dragon boots", item(ItemID.DRAGON_BOOTS), item(ItemID.DRAGON_BOOTS_GOLD), item(ItemID.PRIMORDIAL_BOOTS)), item(ItemID.RUNE_LONGSWORD)),
		new EmoteClue(ItemID.TRAIL_CLUE_HARD_EMOTE008, "Laugh in Jokul's tent in the Mountain Camp. Beware of double agents! Equip a rune full helmet, blue dragonhide chaps and a fire battlestaff.", "Mountain Camp", MOUNTAIN_CAMP_GOAT_ENCLOSURE, new WorldPoint(2812, 3681, 0), DOUBLE_AGENT_108, LAUGH, item(ItemID.RUNE_FULL_HELM), item(ItemID.BLUE_DRAGONHIDE_CHAPS), item(ItemID.FIRE_BATTLESTAFF)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE024, "Laugh at the crossroads south of the Sinclair Mansion. Equip a cowl, a blue wizard robe top and an iron scimitar.", "Sinclair Mansion", ROAD_JUNCTION_SOUTH_OF_SINCLAIR_MANSION, new WorldPoint(2741, 3536, 0), LAUGH, item(ItemID.LEATHER_COWL), item(ItemID.WIZARDS_ROBE), item(ItemID.IRON_SCIMITAR)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP15, "Laugh in front of the gem store in Ardougne market. Equip a Castlewars bracelet, a dragonstone amulet and a ring of forging.", "Ardougne", NEAR_THE_GEM_STALL_IN_ARDOUGNE_MARKET, new WorldPoint(2666, 3304, 0), LAUGH, any("Castle wars bracelet", range(ItemID.JEWL_CASTLEWARS_BRACELET3, ItemID.JEWL_CASTLEWARS_BRACELET)), item(ItemID.STRUNG_DRAGONSTONE_AMULET), item(ItemID.RING_OF_FORGING)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_24, "Nod your head where the River Ortus meets the Proudspire. Indicate 'no' before you talk to me. Equip a blue wizard hat, a blue wizard robe and wear nothing on your legs.", "East of The Proudspire", ORTUS_MEETS_PROUDSPIRE, new WorldPoint(1626, 3241, 0), YES, NO, item(ItemID.BLUEWIZHAT), item(ItemID.WIZARDS_ROBE), emptySlot("Nothing on legs", LEGS)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE004, "Panic in the Limestone Mine. Equip bronze platelegs, a steel pickaxe and a steel medium helmet.", "Limestone Mine", LIMESTONE_MINE, new WorldPoint(3372, 3498, 0), PANIC, item(ItemID.BRONZE_PLATELEGS), item(ItemID.STEEL_PICKAXE), item(ItemID.STEEL_MED_HELM)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE002, "Panic by the mausoleum in Morytania. Wave before you speak to me. Equip a mithril plate skirt, a maple longbow and no boots.", "Morytania mausoleum, access via the experiments cave", MAUSOLEUM_OFF_THE_MORYTANIA_COAST, new WorldPoint(3504, 3576, 0), PANIC, WAVE, item(ItemID.MITHRIL_PLATESKIRT), item(ItemID.MAPLE_LONGBOW), emptySlot("No boots", BOOTS)),
		new EmoteClue(ItemID.TRAIL_HARD_EMOTE_EXP3, "Panic on the Wilderness volcano bridge. Beware of double agents! Equip any headband and crozier.", "Wilderness volcano", VOLCANO_IN_THE_NORTHEASTERN_WILDERNESS, new WorldPoint(3368, 3935, 0), DOUBLE_AGENT_65, PANIC, any("Any headband", range(ItemID.HEADBAND_RED, ItemID.HEADBAND_BROWN), range(ItemID.HEADBAND_WHITE, ItemID.HEADBAND_GREEN)), any("Any crozier", item(ItemID.TRAIL_ANCIENT_STAFF), item(ItemID.TRAIL_ARMADYL_STAFF), item(ItemID.TRAIL_BANDOS_STAFF), range(ItemID.TRAIL_SARADOMIN_STAFF, ItemID.TRAIL_ZAMORAK_STAFF))),
		new EmoteClue(ItemID.TRAIL_CLUE_HARD_EMOTE009, "Panic by the pilot on White Wolf Mountain. Beware of double agents! Equip mithril platelegs, a ring of life and a rune axe.", "White Wolf Mountain", GNOME_GLIDER_ON_WHITE_WOLF_MOUNTAIN, new WorldPoint(2847, 3499, 0), DOUBLE_AGENT_108, PANIC, item(ItemID.MITHRIL_PLATELEGS), item(ItemID.RING_OF_LIFE), item(ItemID.RUNE_AXE)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Panic by the big egg where no one dare goes and the ground is burnt. Beware of double agents! Equip a dragon med helm, a TokTz-Ket-Xil, a brine sabre, rune platebody and an uncharged amulet of glory.", "Lava dragon isle", SOUTHEAST_CORNER_OF_LAVA_DRAGON_ISLE, new WorldPoint(3227, 3831, 0), DOUBLE_AGENT_141, PANIC, item(ItemID.DRAGON_MED_HELM), item(ItemID.TZHAAR_SPIKESHIELD), item(ItemID.OLAF2_BRINE_SABRE), item(ItemID.RUNE_PLATEBODY), any("Uncharged Amulet of glory", item(ItemID.AMULET_OF_GLORY))),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP12, "Panic at the area flowers meet snow. Equip Blue D'hide vambraces, a dragon spear and a rune plateskirt.", "Trollweiss mountain", HALFWAY_DOWN_TROLLWEISS_MOUNTAIN, new WorldPoint(2776, 3781, 0), PANIC, item(ItemID.BLUE_DRAGON_VAMBRACES), item(ItemID.DRAGON_SPEAR), item(ItemID.RUNE_PLATESKIRT), item(ItemID.TROLLROMANCE_TOBOGGON_WAXED)),
		new EmoteClue(ItemID.TRAIL_HARD_EMOTE_VM2, "Panic outside the Twilight Temple. Beware of double agents! Equip a rune longsword, rune platebody and a rune plateskirt.", "Twilight Temple", OUTSIDE_TWILIGHT_TEMPLE, new WorldPoint(1694, 3247, 0), DOUBLE_AGENT_108, PANIC, item(ItemID.RUNE_LONGSWORD), item(ItemID.RUNE_PLATEBODY), item(ItemID.RUNE_PLATESKIRT)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Blow a raspberry in the bank of the Warriors' Guild. Beware of double agents! Equip a dragon battleaxe, a slayer helm of any kind and a dragon defender or avernic defender.", "Warriors' guild", WARRIORS_GUILD_BANK_29047, new WorldPoint(2843, 3543, 0), DOUBLE_AGENT_141, RASPBERRY, any("Dragon battleaxe", item(ItemID.DRAGON_BATTLEAXE), item(ItemID.BH_DRAGON_BATTLEAXE_CORRUPTED)), any("Dragon defender or Avernic defender", item(ItemID.DRAGON_PARRYINGDAGGER), item(ItemID.DRAGON_PARRYINGDAGGER_T), item(ItemID.DRAGON_PARRYINGDAGGER_TROUVER), item(ItemID.INFERNAL_DEFENDER), item(ItemID.INFERNAL_DEFENDER_TROUVER), item(ItemID.INFERNAL_DEFENDER_GHOMMAL_5), item(ItemID.INFERNAL_DEFENDER_GHOMMAL_5_TROUVER), item(ItemID.INFERNAL_DEFENDER_GHOMMAL_6), item(ItemID.INFERNAL_DEFENDER_GHOMMAL_6_TROUVER)), ANY_SLAYER_HELMET),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE019, "Blow a raspberry at the monkey cage in Ardougne Zoo. Equip a studded leather body, bronze platelegs and a normal staff with no orb.", "Ardougne Zoo", NEAR_THE_PARROTS_IN_ARDOUGNE_ZOO, new WorldPoint(2607, 3282, 0), RASPBERRY, item(ItemID.STUDDED_BODY), item(ItemID.BRONZE_PLATELEGS), item(ItemID.PLAINSTAFF)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE022, "Blow raspberries outside the entrance to Keep Le Faye. Equip a coif, an iron platebody and leather gloves.", "Keep Le Faye", OUTSIDE_KEEP_LE_FAYE, new WorldPoint(2757, 3401, 0), RASPBERRY, item(ItemID.COIF), item(ItemID.IRON_PLATEBODY), item(ItemID.LEATHER_GLOVES)),
		new EmoteClue(ItemID.TRAIL_CLUE_HARD_EMOTE002, "Blow a raspberry in the Fishing Guild bank. Beware of double agents! Equip an elemental shield, blue dragonhide chaps and a rune warhammer.", "Fishing Guild", FISHING_GUILD_BANK, new WorldPoint(2588, 3419, 0), DOUBLE_AGENT_108, RASPBERRY, item(ItemID.ELEMENTAL_SHIELD), item(ItemID.BLUE_DRAGONHIDE_CHAPS), item(ItemID.RUNE_WARHAMMER)),
		new EmoteClue(ItemID.TRAIL_CLUE_HARD_EMOTE007, "Salute in the banana plantation. Beware of double agents! Equip a diamond ring, amulet of power, and nothing on your chest and legs.", "Karamja", WEST_SIDE_OF_THE_KARAMJA_BANANA_PLANTATION, new WorldPoint(2914, 3168, 0), DOUBLE_AGENT_108, SALUTE, item(ItemID.DIAMOND_RING), item(ItemID.AMULET_OF_POWER), emptySlot("Nothing on chest & legs", BODY, LEGS)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP5, "Salute in the Warriors' Guild bank. Equip only a black salamander.", "Warriors' guild", WARRIORS_GUILD_BANK, new WorldPoint(2844, 3542, 0), SALUTE, item(ItemID.BLACK_SALAMANDER), emptySlot("Nothing else", HEAD, CAPE, AMULET, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO)),
		new EmoteClue(ItemID.TRAIL_HARD_EMOTE_EXP6, "Salute in the centre of the mess hall. Beware of double agents! Equip a rune halberd rune platebody and an amulet of strength.", "Hosidius mess hall", HOSIDIUS_MESS, new WorldPoint(1646, 3631, 0), DOUBLE_AGENT_108, SALUTE, item(ItemID.RUNE_HALBERD), item(ItemID.RUNE_PLATEBODY), item(ItemID.AMULET_OF_STRENGTH)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Salute outside the gates of Cam Torum. Beware of double agents! Equip a full set of blue moon equipment.", "Cam Torum", CAM_TORUM_ENTRANCE, new WorldPoint(1436, 3115, 0), DOUBLE_AGENT_141, SALUTE, any("Blue moon helm", item(ItemID.FROST_MOON_HELM), item(ItemID.FROST_MOON_HELM_DEGRADED)), any("Blue moon chestplate", item(ItemID.FROST_MOON_CHESTPLATE), item(ItemID.FROST_MOON_CHESTPLATE_DEGRADED)), any("Blue moon tassets", item(ItemID.FROST_MOON_TASSETS), item(ItemID.FROST_MOON_TASSETS_DEGRADED)), item(ItemID.FROSTMOON_SPEAR)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE012, "Shrug in the mine near Rimmington. Equip a gold necklace, a gold ring and a bronze spear.", "Rimmington mine", RIMMINGTON_MINE, new WorldPoint(2976, 3238, 0), SHRUG, item(ItemID.GOLD_NECKLACE), item(ItemID.GOLD_RING), item(ItemID.BRONZE_SPEAR)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_EXP2, "Shrug in Catherby bank. Yawn before you talk to me. Equip a maple longbow, green d'hide chaps and an iron med helm.", "Catherby", OUTSIDE_CATHERBY_BANK, new WorldPoint(2808, 3440, 0), SHRUG, YAWN, item(ItemID.MAPLE_LONGBOW), item(ItemID.DRAGONHIDE_CHAPS), item(ItemID.IRON_MED_HELM)),
		new EmoteClue(ItemID.TRAIL_CLUE_HARD_EMOTE001, "Shrug in the woods east of the Level 19 Wilderness Obelisk. Beware of double agents! Equip rune platelegs, an iron platebody and blue dragonhide vambraces.", "East of the Level 19 Wilderness Obelisk", EAST_OF_THE_LEVEL_19_WILDERNESS_OBELISK, new WorldPoint(3241, 3672, 0), DOUBLE_AGENT_65, SHRUG, item(ItemID.RUNE_PLATELEGS), item(ItemID.IRON_PLATEBODY), item(ItemID.BLUE_DRAGON_VAMBRACES)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP13, "Shrug in the Shayzien war tent. Equip a blue mystic robe bottom, a rune kiteshield and any bob shirt.", "Shayzien war tent", SHAYZIEN_WAR_TENT, new WorldPoint(1487, 3635, 0), SHRUG, item(ItemID.MYSTIC_ROBE_BOTTOM), item(ItemID.RUNE_KITESHIELD), range("Any bob shirt", ItemID.TRAIL_BOB_SHIRT_RED, ItemID.TRAIL_BOB_SHIRT_PURPLE)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Slap your head in the centre of the Kourend catacombs. Beware of double agents! Equip arclight or emberlight along with the amulet of the damned.", "Kourend catacombs", CENTRE_OF_THE_CATACOMBS_OF_KOUREND, new WorldPoint(1663, 10045, 0), DOUBLE_AGENT_141, SLAP_HEAD, any("Arclight or Emberlight", item(ItemID.ARCLIGHT), item(ItemID.EMBERLIGHT)), any("Amulet of the damned", item(ItemID.DAMNED_AMULET_DEGRADED), item(ItemID.DAMNED_AMULET))),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE020, "Spin at the crossroads north of Rimmington. Equip a green gnome hat, cream gnome top and leather chaps.", "Rimmington", ROAD_JUNCTION_NORTH_OF_RIMMINGTON, new WorldPoint(2981, 3276, 0), SPIN, item(ItemID.GNOME_HAT_GREEN), item(ItemID.GNOME_ROBETOP_CREAM), item(ItemID.LEATHER_CHAPS)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE009, "Spin in Draynor Manor by the fountain. Equip an iron platebody, studded leather chaps and a bronze full helmet.", "Draynor Manor", DRAYNOR_MANOR_BY_THE_FOUNTAIN, new WorldPoint(3088, 3336, 0), SPIN, item(ItemID.IRON_PLATEBODY), item(ItemID.STUDDED_CHAPS), item(ItemID.BRONZE_FULL_HELM)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Spin in front of the Soul altar. Beware of double agents! Equip a dragon pickaxe, helm of neitiznot and a pair of rune boots.", "Soul altar", SOUL_ALTAR, new WorldPoint(1815, 3856, 0), DOUBLE_AGENT_141, SPIN, any("Dragon or Crystal pickaxe", item(ItemID.DRAGON_PICKAXE), item(ItemID.DRAGON_PICKAXE_PRETTY), item(ItemID.INFERNAL_PICKAXE), item(ItemID.INFERNAL_PICKAXE_EMPTY), item(ItemID.ZALCANO_PICKAXE), item(ItemID.TRAILBLAZER_PICKAXE_NO_INFERNAL), item(ItemID.TRAILBLAZER_RELOADED_PICKAXE_NO_INFERNAL), item(ItemID.CRYSTAL_PICKAXE), item(ItemID.CRYSTAL_PICKAXE_INACTIVE), item(ItemID.TRAILBLAZER_PICKAXE), item(ItemID.TRAILBLAZER_RELOADED_PICKAXE), item(ItemID.TRAILBLAZER_PICKAXE_EMPTY), item(ItemID.TRAILBLAZER_RELOADED_PICKAXE_EMPTY)), item(ItemID.FRIS_KINGLY_HELM), item(ItemID.RUNE_ARMOURED_BOOTS)),
		new EmoteClue(ItemID.TRAIL_EASY_EMOTE_EXP1, "Spin in the Varrock Castle courtyard. Equip a black axe, a coif and a ruby ring.", "Varrock Castle", OUTSIDE_VARROCK_PALACE_COURTYARD, new WorldPoint(3213, 3463, 0), SPIN, item(ItemID.BLACK_AXE), item(ItemID.COIF), item(ItemID.RUBY_RING)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP1, "Spin in West Ardougne Church. Equip a dragon spear and red dragonhide chaps.", "West Ardougne Church", CHAPEL_IN_WEST_ARDOUGNE, new WorldPoint(2530, 3290, 0), SPIN, item(ItemID.DRAGON_SPEAR), item(ItemID.RED_DRAGONHIDE_CHAPS)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE003, "Spin on the bridge by the Barbarian Village. Salute before you talk to me. Equip purple gloves, a steel kiteshield and a mithril full helmet.", "Barbarian Village", EAST_OF_THE_BARBARIAN_VILLAGE_BRIDGE, new WorldPoint(3105, 3420, 0), SPIN, SALUTE, item(ItemID.WOLFENGLOVES_PURPLE), item(ItemID.STEEL_KITESHIELD), item(ItemID.MITHRIL_FULL_HELM)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Stamp in the Enchanted valley west of the waterfall. Beware of double agents! Equip a dragon axe.", "Enchanted Valley (BKQ)", NORTHWESTERN_CORNER_OF_THE_ENCHANTED_VALLEY, new WorldPoint(3030, 4522, 0), DOUBLE_AGENT_141, STAMP, any("Dragon or Crystal axe", item(ItemID.DRAGON_AXE), item(ItemID.TRAILBLAZER_AXE_NO_INFERNAL), item(ItemID.DRAGON_AXE_2H), item(ItemID.CRYSTAL_AXE), item(ItemID.CRYSTAL_AXE_INACTIVE), item(ItemID.CRYSTAL_AXE_2H), item(ItemID.CRYSTAL_AXE_2H_INACTIVE), item(ItemID.INFERNAL_AXE), item(ItemID.INFERNAL_AXE_EMPTY), item(ItemID.TRAILBLAZER_AXE), item(ItemID.TRAILBLAZER_AXE_EMPTY), item(ItemID.TRAILBLAZER_RELOADED_AXE), item(ItemID.TRAILBLAZER_RELOADED_AXE_EMPTY))),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE010, "Think in middle of the wheat field by the Lumbridge mill. Equip a blue gnome robetop, a turquoise gnome robe bottom and an oak shortbow.", "Lumbridge mill", WHEAT_FIELD_NEAR_THE_LUMBRIDGE_WINDMILL, new WorldPoint(3159, 3298, 0), THINK, item(ItemID.GNOME_ROBETOP_BLUE), item(ItemID.GNOME_ROBEBOTTOMS_TURQUOISE), item(ItemID.OAK_SHORTBOW)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE009, "Think in the centre of the Observatory. Spin before you talk to me. Equip a mithril chain body, green dragonhide chaps and a ruby amulet.", "Observatory", OBSERVATORY, new WorldPoint(2439, 3161, 0), THINK, SPIN, item(ItemID.MITHRIL_CHAINBODY), item(ItemID.DRAGONHIDE_CHAPS), item(ItemID.STRUNG_RUBY_AMULET)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Think on the western coast of Salvager Overlook. Beware of double agents! Equip a Hueycoatl hide coif and some Hueycoatl hide vambraces.", "Salvager Overlook", WESTERN_SALVAGER_OVERLOOK, new WorldPoint(1610, 3302, 0), DOUBLE_AGENT_141, THINK, item(ItemID.HUEY_COIF), item(ItemID.HUEY_VAMBRACES)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE026, "Wave along the south fence of the Lumber Yard. Equip a hard leather body, leather chaps and a bronze axe.", "Lumber Yard", NEAR_THE_SAWMILL_OPERATORS_BOOTH, new WorldPoint(3307, 3491, 0), WAVE, item(ItemID.HARDLEATHER_BODY), item(ItemID.LEATHER_CHAPS), item(ItemID.BRONZE_AXE)),
		new EmoteClue(ItemID.TRAIL_EASY_EMOTE_EXP2, "Wave in the Falador gem store. Equip a Mithril pickaxe, Black platebody and an Iron Kiteshield.", "Falador", NEAR_HERQUINS_SHOP_IN_FALADOR, new WorldPoint(2945, 3335, 0), WAVE, item(ItemID.MITHRIL_PICKAXE), item(ItemID.BLACK_PLATEBODY), item(ItemID.IRON_KITESHIELD)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE006, "Wave on Mudskipper Point. Equip a black cape, leather chaps and a steel mace.", "Mudskipper Point (AIQ)", MUDSKIPPER_POINT, new WorldPoint(2989, 3110, 0), WAVE, item(ItemID.BLACK_CAPE), item(ItemID.LEATHER_CHAPS), item(ItemID.STEEL_MACE)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Wave on the northern wall of Castle Drakan. Beware of double agents! Wear a dragon sq shield, splitbark body and any boater.", "Castle Drakan", NORTHERN_WALL_OF_CASTLE_DRAKAN, new WorldPoint(3562, 3379, 0), DOUBLE_AGENT_141, WAVE, any("Dragon sq shield", item(ItemID.DRAGON_SQ_SHIELD), item(ItemID.DRAGON_SQ_SHIELD_GOLD)), item(ItemID.SPLITBARK_BODY), any("Any boater", item(ItemID.STRAWBOATER_RED), item(ItemID.STRAWBOATER_ORANGE), item(ItemID.STRAWBOATER_GREEN), item(ItemID.STRAWBOATER_BLUE), item(ItemID.STRAWBOATER_BLACK), item(ItemID.STRAWBOATER_PINK), item(ItemID.STRAWBOATER_PURPLE), item(ItemID.STRAWBOATER_WHITE))),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Yawn in the 7th room of Pyramid Plunder. Beware of double agents! Equip a pharaoh sceptre and a full set of menaphite robes.", "Pyramid Plunder", _7TH_CHAMBER_OF_JALSAVRAH, new WorldPoint(1944, 4427, 0), DOUBLE_AGENT_141, YAWN, ANY_PHARAOHS_SCEPTRE, any("Full set of menaphite robes", all(item(ItemID.ROGUETRADER_MENAPHITE_HAT), item(ItemID.ROGUETRADER_MENAPHITE_TOP), range(ItemID.ROGUETRADER_MENAPHITE_LEGS, ItemID.ROGUETRADER_MENAPHITE_LEGS2)), all(item(ItemID.ROGUETRADER_MENAPHITE_HAT_RED), item(ItemID.ROGUETRADER_MENAPHITE_TOP_RED), range(ItemID.ROGUETRADER_MENAPHITE_LEGS_RED, ItemID.ROGUETRADER_MENAPHITE_LEGS_RED2)))),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE013, "Yawn in the Varrock library. Equip a green gnome robe top, HAM robe bottom and an iron warhammer.", "Varrock Castle", VARROCK_PALACE_LIBRARY, new WorldPoint(3209, 3492, 0), YAWN, item(ItemID.GNOME_ROBETOP_GREEN), item(ItemID.HAM_ROBE), item(ItemID.IRON_WARHAMMER)),
		new EmoteClue(ItemID.TRAIL_CLUE_EASY_EMOTE003, "Yawn in Draynor marketplace. Equip studded leather chaps, an iron kiteshield and a steel longsword.", "Draynor", DRAYNOR_VILLAGE_MARKET, new WorldPoint(3083, 3253, 0), YAWN, item(ItemID.STUDDED_CHAPS), item(ItemID.IRON_KITESHIELD), item(ItemID.STEEL_LONGSWORD)),
		new EmoteClue(ItemID.TRAIL_CLUE_MEDIUM_EMOTE005, "Yawn in the Castle Wars lobby. Shrug before you talk to me. Equip a ruby amulet, a mithril scimitar and a Wilderness cape.", "Castle Wars", CASTLE_WARS_BANK, new WorldPoint(2440, 3092, 0), YAWN, SHRUG, item(ItemID.STRUNG_RUBY_AMULET), item(ItemID.MITHRIL_SCIMITAR), ANY_TEAM_CAPE),
		new EmoteClue(ItemID.TRAIL_CLUE_HARD_EMOTE006, "Yawn in the rogues' general store. Beware of double agents! Equip an adamant square shield, blue dragon vambraces and a rune pickaxe.", "Rogues general store", NOTERAZZOS_SHOP_IN_THE_WILDERNESS, new WorldPoint(3026, 3701, 0), DOUBLE_AGENT_65, YAWN, item(ItemID.ADAMANT_SQ_SHIELD), item(ItemID.BLUE_DRAGON_VAMBRACES), item(ItemID.RUNE_PICKAXE)),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP9, "Yawn at the top of Trollheim. Equip a lava battlestaff, black dragonhide vambraces and a mind shield.", "Trollheim Mountain", ON_TOP_OF_TROLLHEIM_MOUNTAIN, new WorldPoint(2887, 3676, 0), YAWN, any("Lava battlestaff", item(ItemID.LAVA_BATTLESTAFF), item(ItemID.LAVA_BATTLESTAFF_PRETTY)), item(ItemID.BLACK_DRAGON_VAMBRACES), item(ItemID.ELEMENTAL_MIND_SHIELD)),
		new EmoteClue(ItemID.TRAIL_MEDIUM_EMOTE_EXP8, "Yawn in the centre of the Arceuus Library. Nod your head before you talk to me. Equip blue dragonhide vambraces, adamant boots and an adamant dagger.", "Arceuus library", ENTRANCE_OF_THE_ARCEUUS_LIBRARY, new WorldPoint(1632, 3807, 0), YAWN, YES, item(ItemID.BLUE_DRAGON_VAMBRACES), item(ItemID.ADAMANT_ARMOURED_BOOTS), item(ItemID.ADAMANT_DAGGER)),
		new EmoteClue(ItemID.TRAIL_EASY_EMOTE_VM01, "Yawn in the Fortis Grand Museum. Equip an emerald necklace, blue skirt, and turqoise gnome robe top.", "Fortis Grand Museum", FORTIS_GRAND_MUSEUM, new WorldPoint(1712, 3163, 0), YAWN, item(ItemID.EMERALD_NECKLACE), item(ItemID.BLUE_SKIRT), item(ItemID.GNOME_ROBETOP_TURQUOISE)),
		new EmoteClue(ItemID.TRAIL_CLUE_MASTER, "Swing a bullroarer at the top of the Watchtower. Beware of double agents! Equip a dragon plateskirt, climbing boots and a dragon chainbody.", "Yanille Watchtower", TOP_FLOOR_OF_THE_YANILLE_WATCHTOWER, new WorldPoint(2930, 4717, 2), DOUBLE_AGENT_141, BULL_ROARER, any("Dragon plateskirt", item(ItemID.DRAGON_PLATESKIRT), item(ItemID.DRAGON_PLATESKIRT_GOLD)), any("Climbing boots", item(ItemID.DEATH_CLIMBINGBOOTS), item(ItemID.CLIMBING_BOOTS_G)), any("Dragon chainbody", item(ItemID.DRAGON_CHAINBODY), item(ItemID.DRAGON_CHAINBODY_GOLD)), item(ItemID.BULLROARER)),
		new EmoteClue(ItemID.TRAIL_CLUE_BEGINNER, "Blow a raspberry at Aris in her tent. Equip a gold ring and a gold necklace.", "Varrock", GYPSY_TENT_ENTRANCE, new WorldPoint(3203, 3424, 0), RASPBERRY, item(ItemID.GOLD_RING), item(ItemID.GOLD_NECKLACE)),
		new EmoteClue(ItemID.TRAIL_CLUE_BEGINNER, "Bow to Brugsen Bursen at the Grand Exchange.", "Grand Exchange", null, new WorldPoint(3164, 3477, 0), BOW),
		new EmoteClue(ItemID.TRAIL_CLUE_BEGINNER, "Cheer at Iffie Nitter. Equip a chef hat and a red cape.", "Varrock", FINE_CLOTHES_ENTRANCE, new WorldPoint(3205, 3416, 0), CHEER, item(ItemID.CHEFS_HAT), item(ItemID.RED_CAPE)),
		new EmoteClue(ItemID.TRAIL_CLUE_BEGINNER, "Clap at Bob's Brilliant Axes. Equip a bronze axe and leather boots.", "Lumbridge", BOB_AXES_ENTRANCE, new WorldPoint(3231, 3203, 0), CLAP, item(ItemID.BRONZE_AXE), item(ItemID.LEATHER_BOOTS)),
		new EmoteClue(ItemID.TRAIL_CLUE_BEGINNER, "Panic at Al Kharid mine.", "Al Kharid mine", null, new WorldPoint(3303, 3271, 0), PANIC),
		new EmoteClue(ItemID.TRAIL_CLUE_BEGINNER, "Spin at Flynn's Mace Shop.", "Falador", null, new WorldPoint(2950, 3387, 0), SPIN),
		new EmoteClue(ItemID.TRAIL_ELITE_EMOTE_EXP17, "Salute by the Charcoal Burners. Equip a Farmer's strawhat, Shayzien platebody (5) and Pyromancer robes.", "Charcoal Burners", CHARCOAL_BURNERS, new WorldPoint(1714, 3467, 0), SALUTE, any("Farmer's strawhat", item(ItemID.TITHE_REWARD_HAT_MALE), item(ItemID.TITHE_REWARD_HAT_FEMALE)), item(ItemID.SHAYZIEN_BODY_5), item(ItemID.PYROMANCER_BOTTOM)));

	private static final String UNICODE_CHECK_MARK = "\u2713";
	private static final String UNICODE_BALLOT_X = "\u2717";

	private final int itemId;
	private final String text;
	private final String locationName;
	@Nullable
	private final STASHUnit stashUnit;
	@Getter(AccessLevel.PRIVATE)
	private final WorldPoint location;
	private final Emote firstEmote;
	private final Emote secondEmote;
	private final ItemRequirement[] itemRequirements;

	private EmoteClue(int itemId, String text, String locationName, STASHUnit stashUnit, WorldPoint location, Emote firstEmote, @Nonnull ItemRequirement... itemRequirements)
	{
		this(itemId, text, locationName, stashUnit, location, firstEmote, null, itemRequirements);
	}

	private EmoteClue(int itemId, String text, String locationName, STASHUnit stashUnit, WorldPoint location, Enemy enemy, Emote firstEmote, @Nonnull ItemRequirement... itemRequirements)
	{
		this(itemId, text, locationName, stashUnit, location, firstEmote, null, itemRequirements);
		setEnemy(enemy);
	}

	private EmoteClue(int itemId, String text, String locationName, STASHUnit stashUnit, WorldPoint location, Emote firstEmote, Emote secondEmote, @Nonnull ItemRequirement... itemRequirements)
	{
		this.itemId = itemId;
		this.text = text;
		this.locationName = locationName;
		this.stashUnit = stashUnit;
		this.location = location;
		this.firstEmote = firstEmote;
		this.secondEmote = secondEmote;
		this.itemRequirements = itemRequirements;
	}

	private EmoteClue(int itemId, String text, String locationName, @Nullable STASHUnit stashUnit, WorldPoint location, Emote firstEmote, Emote secondEmote, @Varbit int firePitVarbitId, @Nonnull ItemRequirement... itemRequirements)
	{
		this(itemId, text, locationName, stashUnit, location, firstEmote, secondEmote, itemRequirements);
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

	public static EmoteClue forItemId(int itemId)
	{
		for (EmoteClue clue : CLUES)
		{
			if (clue.itemId == itemId)
			{
				return clue;
			}
		}

		return null;
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
