/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.client.game.ItemVariationMapping;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_BORDER_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_FILL_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_HOVER_BORDER_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.plugins.cluescrolls.clues.item.AllRequirementsCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.*;
import net.runelite.client.plugins.cluescrolls.clues.item.SingleItemRequirement;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class SkillChallengeClue extends ClueScroll implements NpcClueScroll, NamedObjectClueScroll
{
	@AllArgsConstructor
	@Getter
	enum ChallengeType
	{
		CHARLIE("Charlie the Tramp", "Southern Entrance to Varrock"),
		SHERLOCK("Sherlock", "East of the Sorcerer's Tower in Seers' Village");

		private final String name;
		private final String location;
	}

	private static final AnyRequirementCollection ANY_PICKAXE = any("Any Pickaxe",
		item(ItemID.BRONZE_PICKAXE),
		item(ItemID.IRON_PICKAXE),
		item(ItemID.STEEL_PICKAXE),
		item(ItemID.BLACK_PICKAXE),
		item(ItemID.MITHRIL_PICKAXE),
		item(ItemID.ADAMANT_PICKAXE),
		item(ItemID.RUNE_PICKAXE),
		item(ItemID.DRAGON_PICKAXE),
		item(ItemID.DRAGON_PICKAXE_12797),
		item(ItemID.DRAGON_PICKAXE_OR),
		item(ItemID.DRAGON_PICKAXE_OR_25376),
		item(ItemID.INFERNAL_PICKAXE),
		item(ItemID.INFERNAL_PICKAXE_OR),
		item(ItemID.INFERNAL_PICKAXE_UNCHARGED),
		item(ItemID.INFERNAL_PICKAXE_UNCHARGED_25369),
		item(ItemID.GILDED_PICKAXE),
		item(ItemID._3RD_AGE_PICKAXE),
		item(ItemID.CRYSTAL_PICKAXE),
		item(ItemID.CRYSTAL_PICKAXE_INACTIVE),
		item(ItemID.ECHO_PICKAXE)
	);

	private static final AnyRequirementCollection ANY_AXE = any("Any Axe",
		item(ItemID.BRONZE_AXE),
		item(ItemID.BRONZE_FELLING_AXE),
		item(ItemID.IRON_AXE),
		item(ItemID.IRON_FELLING_AXE),
		item(ItemID.STEEL_AXE),
		item(ItemID.STEEL_FELLING_AXE),
		item(ItemID.BLACK_AXE),
		item(ItemID.BLACK_FELLING_AXE),
		item(ItemID.MITHRIL_AXE),
		item(ItemID.MITHRIL_FELLING_AXE),
		item(ItemID.ADAMANT_AXE),
		item(ItemID.ADAMANT_FELLING_AXE),
		item(ItemID.RUNE_AXE),
		item(ItemID.RUNE_FELLING_AXE),
		item(ItemID.DRAGON_AXE),
		item(ItemID.DRAGON_AXE_OR),
		item(ItemID.DRAGON_FELLING_AXE),
		item(ItemID.INFERNAL_AXE),
		item(ItemID.INFERNAL_AXE_OR),
		item(ItemID.INFERNAL_AXE_UNCHARGED),
		item(ItemID.INFERNAL_AXE_UNCHARGED_25371),
		item(ItemID.GILDED_AXE),
		item(ItemID._3RD_AGE_AXE),
		item(ItemID._3RD_AGE_FELLING_AXE),
		item(ItemID.CRYSTAL_AXE),
		item(ItemID.CRYSTAL_AXE_INACTIVE),
		item(ItemID.CRYSTAL_FELLING_AXE),
		item(ItemID.CRYSTAL_FELLING_AXE_INACTIVE),
		item(ItemID.ECHO_AXE)
	);

	private static final AnyRequirementCollection ANY_HARPOON = any("Harpoon",
		item(ItemID.HARPOON),
		item(ItemID.BARBTAIL_HARPOON),
		item(ItemID.DRAGON_HARPOON),
		item(ItemID.DRAGON_HARPOON_OR),
		item(ItemID.INFERNAL_HARPOON),
		item(ItemID.INFERNAL_HARPOON_OR),
		item(ItemID.INFERNAL_HARPOON_UNCHARGED),
		item(ItemID.INFERNAL_HARPOON_UNCHARGED_25367),
		item(ItemID.CRYSTAL_HARPOON),
		item(ItemID.CRYSTAL_HARPOON_INACTIVE),
		item(ItemID.ECHO_HARPOON)
	);

	private static final AnyRequirementCollection ANY_HAMMER = any("Hammer",
		item(ItemID.HAMMER),
		item(ItemID.IMCANDO_HAMMER)
	);

	private static final AllRequirementsCollection A_FULL_GRACEFUL_SET = all("A full Graceful set",
		any("" /* graceful hood   */, ItemVariationMapping.getVariations(ItemID.GRACEFUL_HOOD).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful top    */, ItemVariationMapping.getVariations(ItemID.GRACEFUL_TOP).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful legs   */, ItemVariationMapping.getVariations(ItemID.GRACEFUL_LEGS).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful gloves */, ItemVariationMapping.getVariations(ItemID.GRACEFUL_GLOVES).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful boots  */, ItemVariationMapping.getVariations(ItemID.GRACEFUL_BOOTS).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful cape   */, Stream.of(
			ItemVariationMapping.getVariations(ItemID.GRACEFUL_CAPE).stream(),
			ItemVariationMapping.getVariations(ItemID.AGILITY_CAPE).stream(),
			ItemVariationMapping.getVariations(ItemID.MAX_CAPE).stream())
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item).toArray(SingleItemRequirement[]::new))
	);

	static final List<SkillChallengeClue> CLUES = ImmutableList.of(
		// Charlie Tasks
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a cooked pike.", item(ItemID.PIKE)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a cooked trout.", item(ItemID.TROUT)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a leather body.", item(ItemID.LEATHER_BODY)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie some leather chaps.", item(ItemID.LEATHER_CHAPS)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a raw herring.", item(ItemID.RAW_HERRING)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a raw trout.", item(ItemID.RAW_TROUT)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a piece of iron ore.", item(ItemID.IRON_ORE)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie one iron dagger.", item(ItemID.IRON_DAGGER)),
		// Elite Sherlock Tasks
		new SkillChallengeClue("Equip a Dragon Scimitar.", true, any("Any Dragon Scimitar", item(ItemID.DRAGON_SCIMITAR), item(ItemID.DRAGON_SCIMITAR_OR))),
		new SkillChallengeClue("Enchant some Dragonstone Jewellery.", "enchant a piece of dragonstone jewellery.",
			xOfItem(ItemID.COSMIC_RUNE, 1),
			any("Water Rune x15", xOfItem(ItemID.WATER_RUNE, 15), xOfItem(ItemID.MIST_RUNE, 15), xOfItem(ItemID.MUD_RUNE, 15), xOfItem(ItemID.STEAM_RUNE, 15), item(ItemID.STAFF_OF_WATER), item(ItemID.WATER_BATTLESTAFF), item(ItemID.MYSTIC_WATER_STAFF), item(ItemID.MUD_BATTLESTAFF), item(ItemID.MYSTIC_MUD_STAFF), item(ItemID.MIST_BATTLESTAFF), item(ItemID.MYSTIC_MIST_STAFF), item(ItemID.STEAM_BATTLESTAFF), item(ItemID.MYSTIC_STEAM_STAFF), item(ItemID.STEAM_BATTLESTAFF_12795), item(ItemID.MYSTIC_STEAM_STAFF_12796), item(ItemID.KODAI_WAND), item(ItemID.TOME_OF_WATER)),
			any("Earth Rune x15", xOfItem(ItemID.EARTH_RUNE, 15), xOfItem(ItemID.DUST_RUNE, 15), xOfItem(ItemID.MUD_RUNE, 15), xOfItem(ItemID.LAVA_RUNE, 15), item(ItemID.STAFF_OF_EARTH), item(ItemID.EARTH_BATTLESTAFF), item(ItemID.MYSTIC_EARTH_STAFF), item(ItemID.MUD_BATTLESTAFF), item(ItemID.MYSTIC_MUD_STAFF), item(ItemID.DUST_BATTLESTAFF), item(ItemID.MYSTIC_DUST_STAFF), item(ItemID.LAVA_BATTLESTAFF), item(ItemID.MYSTIC_LAVA_STAFF), item(ItemID.LAVA_BATTLESTAFF_21198), item(ItemID.MYSTIC_LAVA_STAFF_21200)),
			any("Unenchanted Dragonstone Jewellery", item(ItemID.DRAGONSTONE_RING), item(ItemID.DRAGON_NECKLACE), item(ItemID.DRAGONSTONE_BRACELET), item(ItemID.DRAGONSTONE_AMULET))),
		new SkillChallengeClue("Craft a nature rune.", any("Pure essence or Daeyalt essence", item(ItemID.PURE_ESSENCE), item(ItemID.DAEYALT_ESSENCE))),
		new SkillChallengeClue("Catch a mottled eel with aerial fishing in Lake Molch.", any("Fish chunks or King worms", item(ItemID.FISH_CHUNKS), item(ItemID.KING_WORM)), emptySlot("No Gloves", EquipmentInventorySlot.GLOVES), any("No Weapon", emptySlot("",  EquipmentInventorySlot.WEAPON), item(ItemID.CORMORANTS_GLOVE), item(ItemID.CORMORANTS_GLOVE_22817)), emptySlot("No Shield", EquipmentInventorySlot.SHIELD)),
		new SkillChallengeClue("Score a goal in skullball.", true, any("Ring of Charos", item(ItemID.RING_OF_CHAROS), item(ItemID.RING_OF_CHAROSA))),
		new SkillChallengeClue("Complete a lap of Ape atoll agility course.", true, any("Ninja Monkey Greegree", item(ItemID.NINJA_MONKEY_GREEGREE), item(ItemID.NINJA_MONKEY_GREEGREE_4025), item(ItemID.KRUK_MONKEY_GREEGREE))),
		new SkillChallengeClue("Create a super defence potion.", item(ItemID.CADANTINE_POTION_UNF), item(ItemID.WHITE_BERRIES)),
		new SkillChallengeClue("Steal from a chest in Ardougne Castle."),
		new SkillChallengeClue("Craft a green dragonhide body.", xOfItem(ItemID.GREEN_DRAGON_LEATHER, 3), any("Needle", item(ItemID.NEEDLE), item(ItemID.COSTUME_NEEDLE)), any("Thread", item(ItemID.THREAD), item(ItemID.COSTUME_NEEDLE))),
		new SkillChallengeClue("String a yew longbow.", item(ItemID.YEW_LONGBOW_U), item(ItemID.BOW_STRING)),
		new SkillChallengeClue("Kill a Dust Devil.", "slay a dust devil.", true,
			any("Facemask or Slayer Helmet",
				Stream.of(
					ItemVariationMapping.getVariations(ItemID.SLAYER_HELMET).stream(),
					Stream.of(ItemID.FACEMASK))
					.reduce(Stream::concat)
					.orElseGet(Stream::empty)
					.map(ItemRequirements::item)
					.toArray(SingleItemRequirement[]::new))),
		new SkillChallengeClue("Catch a black warlock.", any("Butterfly Net", item(ItemID.BUTTERFLY_NET), item(ItemID.MAGIC_BUTTERFLY_NET))),
		new SkillChallengeClue("Catch a red chinchompa.", item(ItemID.BOX_TRAP)),
		new SkillChallengeClue("Mine a mithril ore.", ANY_PICKAXE),
		new SkillChallengeClue("Smith a mithril 2h sword.", ANY_HAMMER, xOfItem(ItemID.MITHRIL_BAR, 3)),
		new SkillChallengeClue("Catch a raw shark.", ANY_HARPOON),
		new SkillChallengeClue("Cut a yew log.", ANY_AXE),
		new SkillChallengeClue("Fix a magical lamp in Dorgesh-Kaan.", new String[] { "Broken lamp" }, new int[] { 10834, 10835 }, item(ItemID.LIGHT_ORB)),
		new SkillChallengeClue("Burn a yew log.", item(ItemID.YEW_LOGS), item(ItemID.TINDERBOX)),
		new SkillChallengeClue("Cook a swordfish", "cook a swordfish", item(ItemID.RAW_SWORDFISH)),
		new SkillChallengeClue("Craft multiple cosmic runes from a single essence.", any("Pure essence or Daeyalt essence", item(ItemID.PURE_ESSENCE), item(ItemID.DAEYALT_ESSENCE))),
		new SkillChallengeClue("Plant a watermelon seed.", item(ItemID.RAKE), item(ItemID.SEED_DIBBER), xOfItem(ItemID.WATERMELON_SEED, 3)),
		new SkillChallengeClue("Activate the Chivalry prayer."),
		new SkillChallengeClue("Smith a tier 2 or above Shayzien platebody.", "smith a tier 2 or above shayzien platebody.", ANY_HAMMER, xOfItem(ItemID.LOVAKITE_BAR, 4)),
		// Master Sherlock Tasks
		new SkillChallengeClue("Equip an abyssal whip in front of the abyssal demons of the Slayer Tower.", true, any("Abyssal Whip", item(ItemID.ABYSSAL_WHIP), item(ItemID.FROZEN_ABYSSAL_WHIP), item(ItemID.VOLCANIC_ABYSSAL_WHIP), item(ItemID.ABYSSAL_WHIP_OR), item(ItemID.ABYSSAL_TENTACLE), item(ItemID.ABYSSAL_TENTACLE_OR))),
		new SkillChallengeClue("Smith a runite med helm.", ANY_HAMMER, item(ItemID.RUNITE_BAR)),
		new SkillChallengeClue("Teleport to a spirit tree you planted yourself."),
		new SkillChallengeClue("Create a Barrows teleport tablet.", item(ItemID.DARK_ESSENCE_BLOCK), xOfItem(ItemID.BLOOD_RUNE, 1), xOfItem(ItemID.LAW_RUNE, 2), xOfItem(ItemID.SOUL_RUNE, 2)),
		new SkillChallengeClue("Kill a Nechryael in the Slayer Tower.", "slay a nechryael in the slayer tower."),
		new SkillChallengeClue("Kill a Spiritual Mage while wearing something from their god.", "kill the spiritual, magic and godly whilst representing their own god."),
		new SkillChallengeClue("Create an unstrung dragonstone amulet at a furnace.", item(ItemID.GOLD_BAR), item(ItemID.DRAGONSTONE), item(ItemID.AMULET_MOULD)),
		new SkillChallengeClue("Burn a magic log.", item(ItemID.MAGIC_LOGS), item(ItemID.TINDERBOX)),
		new SkillChallengeClue("Burn a redwood log.", item(ItemID.REDWOOD_LOGS), item(ItemID.TINDERBOX)),
		new SkillChallengeClue("Complete a lap of Rellekka's Rooftop Agility Course", "complete a lap of the rellekka rooftop agility course whilst sporting the finest amount of grace.", true, A_FULL_GRACEFUL_SET),
		new SkillChallengeClue("Mix an anti-venom potion.", item(ItemID.ANTIDOTE4_5952), xOfItem(ItemID.ZULRAHS_SCALES, 20)),
		new SkillChallengeClue("Mine a piece of Runite ore", "mine a piece of runite ore whilst sporting the finest mining gear.", true, ANY_PICKAXE,
			all("Prospector kit",
				any("", item(ItemID.PROSPECTOR_HELMET), item(ItemID.GOLDEN_PROSPECTOR_HELMET)),
				any("", item(ItemID.PROSPECTOR_JACKET), item(ItemID.VARROCK_ARMOUR_4), item(ItemID.GOLDEN_PROSPECTOR_JACKET)),
				any("", item(ItemID.PROSPECTOR_LEGS), item(ItemID.GOLDEN_PROSPECTOR_LEGS)),
				any("", item(ItemID.PROSPECTOR_BOOTS), item(ItemID.GOLDEN_PROSPECTOR_BOOTS)))),
		new SkillChallengeClue("Steal a gem from the Ardougne market."),
		new SkillChallengeClue("Pickpocket an elf."),
		new SkillChallengeClue("Bind a blood rune at the blood altar.", item(ItemID.DARK_ESSENCE_FRAGMENTS)),
		new SkillChallengeClue("Create a ranging mix potion.", "mix a ranging mix potion.", item(ItemID.RANGING_POTION2), item(ItemID.CAVIAR)),
		new SkillChallengeClue("Fletch a rune dart.", item(ItemID.RUNE_DART_TIP), item(ItemID.FEATHER)),
		new SkillChallengeClue("Cremate a set of fiyr remains.", any("Magic or Redwood Pyre Logs", item(ItemID.MAGIC_PYRE_LOGS), item(ItemID.REDWOOD_PYRE_LOGS)), item(ItemID.TINDERBOX), item(ItemID.FIYR_REMAINS)),
		new SkillChallengeClue("Dissect a sacred eel.", item(ItemID.KNIFE), any("Fishing rod", item(ItemID.FISHING_ROD), item(ItemID.PEARL_FISHING_ROD)), item(ItemID.FISHING_BAIT)),
		new SkillChallengeClue("Kill a lizardman shaman."),
		new SkillChallengeClue("Catch an Anglerfish.", "angle for an anglerfish whilst sporting the finest fishing gear.", true, any("Fishing rod", item(ItemID.FISHING_ROD), item(ItemID.PEARL_FISHING_ROD)), item(ItemID.SANDWORMS),
			all("Angler's outfit",
				any("", item(ItemID.ANGLER_HAT), item(ItemID.SPIRIT_ANGLER_HEADBAND)),
				any("", item(ItemID.ANGLER_TOP), item(ItemID.SPIRIT_ANGLER_TOP)),
				any("", item(ItemID.ANGLER_WADERS), item(ItemID.SPIRIT_ANGLER_WADERS)),
				any("", item(ItemID.ANGLER_BOOTS), item(ItemID.SPIRIT_ANGLER_BOOTS)))),
		new SkillChallengeClue("Chop a redwood log.", "chop a redwood log whilst sporting the finest lumberjack gear.", true, ANY_AXE,
			all("Lumberjack outfit",
				any("", item(ItemID.LUMBERJACK_HAT), item(ItemID.FORESTRY_HAT)),
				any("", item(ItemID.LUMBERJACK_TOP), item(ItemID.FORESTRY_TOP)),
				any("", item(ItemID.LUMBERJACK_LEGS), item(ItemID.FORESTRY_LEGS)),
				any("", item(ItemID.LUMBERJACK_BOOTS), item(ItemID.FORESTRY_BOOTS)))),
		new SkillChallengeClue("Craft a light orb in the Dorgesh-Kaan bank.", item(ItemID.CAVE_GOBLIN_WIRE), item(ItemID.EMPTY_LIGHT_ORB)),
		new SkillChallengeClue("Kill a reanimated Abyssal Demon.", "kill a reanimated abyssal.", xOfItem(ItemID.SOUL_RUNE, 4), xOfItem(ItemID.BLOOD_RUNE, 2), any("Nature Rune x4", xOfItem(ItemID.NATURE_RUNE, 4), item(ItemID.BRYOPHYTAS_STAFF)), range("Ensouled abyssal head", ItemID.ENSOULED_ABYSSAL_HEAD, ItemID.ENSOULED_ABYSSAL_HEAD_13508)),
		new SkillChallengeClue("Kill a Fiyr shade inside Mort'tons shade catacombs.",
			any("Any Gold or Silver Shade Key",
				item(ItemID.GOLD_KEY_RED), item(ItemID.GOLD_KEY_BROWN), item(ItemID.GOLD_KEY_CRIMSON), item(ItemID.GOLD_KEY_BLACK), item(ItemID.GOLD_KEY_PURPLE),
				item(ItemID.SILVER_KEY_RED), item(ItemID.SILVER_KEY_BROWN), item(ItemID.SILVER_KEY_CRIMSON), item(ItemID.SILVER_KEY_BLACK), item(ItemID.SILVER_KEY_PURPLE))),
		new SkillChallengeClue("Catch a tecu salamander.", item(ItemID.ROPE), item(ItemID.SMALL_FISHING_NET))
	);

	private final ChallengeType type;
	private final String challenge;
	private final String rawChallenge;
	private final String returnText;
	private final ItemRequirement[] itemRequirements;
	private final SingleItemRequirement returnItem;
	private final boolean requireEquip;
	private final String[] objectNames;
	private final int[] objectRegions;
	@Setter
	private boolean challengeCompleted;

	// Charlie Tasks
	private SkillChallengeClue(ChallengeType challengeType, String clueText, SingleItemRequirement returnItem)
	{
		Preconditions.checkArgument(challengeType == ChallengeType.CHARLIE);
		this.type = challengeType;
		this.challenge = "";
		this.rawChallenge = clueText;
		this.returnText = clueText;
		this.itemRequirements = new ItemRequirement[0];
		this.returnItem = returnItem;
		this.challengeCompleted = true;
		this.requireEquip = false;
		this.objectNames = new String[0];
		this.objectRegions = null;
	}

	// Non-cryptic Sherlock Tasks
	private SkillChallengeClue(String challenge, ItemRequirement ... itemRequirements)
	{
		this(challenge, challenge.toLowerCase(), itemRequirements);
	}

	// Non-cryptic Sherlock Tasks
	private SkillChallengeClue(String challenge, String[] objectNames, int[] objectRegions, ItemRequirement ... itemRequirements)
	{
		this(challenge, challenge.toLowerCase(), false, objectNames, objectRegions, itemRequirements);
	}

	// Non-cryptic Sherlock Tasks
	private SkillChallengeClue(String challenge, boolean requireEquip, ItemRequirement ... itemRequirements)
	{
		this(challenge, challenge.toLowerCase(), requireEquip, new String[0], null, itemRequirements);
	}

	// Sherlock Tasks
	private SkillChallengeClue(String challenge, String rawChallenge, ItemRequirement ... itemRequirements)
	{
		this(challenge, rawChallenge, false, new String[0], null, itemRequirements);
	}

	// Sherlock Tasks
	private SkillChallengeClue(String challenge, String rawChallenge, boolean requireEquip, ItemRequirement ... itemRequirements)
	{
		this(challenge, rawChallenge, requireEquip, new String[0], null, itemRequirements);
	}

	// Sherlock Tasks
	private SkillChallengeClue(String challenge, String rawChallenge, boolean requireEquip, String[] objectNames, int[] objectRegions, ItemRequirement ... itemRequirements)
	{
		this.type = ChallengeType.SHERLOCK;
		this.challenge = challenge;
		this.rawChallenge = rawChallenge;
		this.itemRequirements = itemRequirements;
		this.challengeCompleted = false;
		this.requireEquip = requireEquip;
		this.objectNames = objectNames;
		this.objectRegions = objectRegions;
		this.returnText = "<str>" + rawChallenge + "</str>";

		this.returnItem = null;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Skill Challenge Clue").build());

		if (!challengeCompleted)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("Challenge:").build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(challenge)
				.leftColor(TITLED_CONTENT_COLOR)
				.build());

			if (itemRequirements.length > 0)
			{
				panelComponent.getChildren().add(LineComponent.builder().left(requireEquip ? "Equipment:" : "Items Required:").build());

				for (LineComponent line : getRequirements(plugin, requireEquip, itemRequirements))
				{
					panelComponent.getChildren().add(line);
				}
			}
		}
		else
		{
			panelComponent.getChildren().add(LineComponent.builder().left("NPC:").build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(type.getName())
				.leftColor(TITLED_CONTENT_COLOR)
				.build());

			panelComponent.getChildren().add(LineComponent.builder().left("Location:").build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(type.getLocation())
				.leftColor(TITLED_CONTENT_COLOR)
				.build());

			if (returnItem != null)
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Item:").build());
				for (LineComponent line : getRequirements(plugin, false, returnItem))
				{
					panelComponent.getChildren().add(line);
				}
			}
		}

		renderOverlayNote(panelComponent, plugin);
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		// Mark NPC
		if (plugin.getNpcsToMark() != null)
		{
			for (NPC npc : plugin.getNpcsToMark())
			{
				OverlayUtil.renderActorOverlayImage(graphics, npc, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
			}
		}

		// Mark objects
		if (!challengeCompleted && objectNames.length > 0 && plugin.getNamedObjectsToMark() != null)
		{
			final Point mousePosition = plugin.getClient().getMouseCanvasPosition();

			for (final TileObject object : plugin.getNamedObjectsToMark())
			{
				if (plugin.getClient().getPlane() != object.getPlane())
				{
					continue;
				}

				OverlayUtil.renderHoverableArea(graphics, object.getClickbox(), mousePosition,
					CLICKBOX_FILL_COLOR, CLICKBOX_BORDER_COLOR, CLICKBOX_HOVER_BORDER_COLOR);

				OverlayUtil.renderImageLocation(plugin.getClient(), graphics, object.getLocalLocation(), plugin.getClueScrollImage(), IMAGE_Z_OFFSET);
			}
		}
	}

	private static List<LineComponent> getRequirements(ClueScrollPlugin plugin, boolean requireEquipped, ItemRequirement ... requirements)
	{
		List<LineComponent> components = new ArrayList<>();

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

		for (ItemRequirement requirement : requirements)
		{
			boolean equipmentFulfilled = requirement.fulfilledBy(equipment);
			boolean combinedFulfilled = requirement.fulfilledBy(combined);

			components.add(LineComponent.builder()
				.left(requirement.getCollectiveName(plugin.getClient()))
				.leftColor(TITLED_CONTENT_COLOR)
				.right(combinedFulfilled ? "\u2713" : "\u2717")
				.rightFont(FontManager.getDefaultFont())
				.rightColor(equipmentFulfilled || (combinedFulfilled && !requireEquipped) ? Color.GREEN : (combinedFulfilled ? Color.ORANGE : Color.RED))
				.build());
		}

		return components;
	}

	public static SkillChallengeClue forText(String text, String rawText)
	{
		for (SkillChallengeClue clue : CLUES)
		{
			if (rawText.equalsIgnoreCase(clue.returnText))
			{
				clue.setChallengeCompleted(true);
				return clue;
			}
			else if (text.equals(clue.rawChallenge))
			{
				clue.setChallengeCompleted(false);
				return clue;
			}
		}
		return null;
	}

	@Override
	public String[] getNpcs(ClueScrollPlugin plugin)
	{
		return new String[] {type.getName()};
	}

	@Override
	public int[] getConfigKeys()
	{
		return new int[]{rawChallenge.hashCode()};
	}
}
