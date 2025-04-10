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
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.api.gameval.ItemID;
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
		item(ItemID.DRAGON_PICKAXE_PRETTY),
		item(ItemID.ZALCANO_PICKAXE),
		item(ItemID.TRAILBLAZER_PICKAXE_NO_INFERNAL),
		item(ItemID.INFERNAL_PICKAXE),
		item(ItemID.TRAILBLAZER_PICKAXE),
		item(ItemID.INFERNAL_PICKAXE_EMPTY),
		item(ItemID.TRAILBLAZER_PICKAXE_EMPTY),
		item(ItemID.TRAIL_GILDED_PICKAXE),
		item(ItemID._3A_PICKAXE),
		item(ItemID.CRYSTAL_PICKAXE),
		item(ItemID.CRYSTAL_PICKAXE_INACTIVE),
		item(ItemID.LEAGUE_TRAILBLAZER_PICKAXE)
	);

	private static final AnyRequirementCollection ANY_AXE = any("Any Axe",
		item(ItemID.BRONZE_AXE),
		item(ItemID.BRONZE_AXE_2H),
		item(ItemID.IRON_AXE),
		item(ItemID.IRON_AXE_2H),
		item(ItemID.STEEL_AXE),
		item(ItemID.STEEL_AXE_2H),
		item(ItemID.BLACK_AXE),
		item(ItemID.BLACK_AXE_2H),
		item(ItemID.MITHRIL_AXE),
		item(ItemID.MITHRIL_AXE_2H),
		item(ItemID.ADAMANT_AXE),
		item(ItemID.ADAMANT_AXE_2H),
		item(ItemID.RUNE_AXE),
		item(ItemID.RUNE_AXE_2H),
		item(ItemID.DRAGON_AXE),
		item(ItemID.TRAILBLAZER_AXE_NO_INFERNAL),
		item(ItemID.DRAGON_AXE_2H),
		item(ItemID.INFERNAL_AXE),
		item(ItemID.TRAILBLAZER_AXE),
		item(ItemID.INFERNAL_AXE_EMPTY),
		item(ItemID.TRAILBLAZER_AXE_EMPTY),
		item(ItemID.TRAIL_GILDED_AXE),
		item(ItemID._3A_AXE),
		item(ItemID._3A_AXE_2H),
		item(ItemID.CRYSTAL_AXE),
		item(ItemID.CRYSTAL_AXE_INACTIVE),
		item(ItemID.CRYSTAL_AXE_2H),
		item(ItemID.CRYSTAL_AXE_2H_INACTIVE),
		item(ItemID.LEAGUE_TRAILBLAZER_AXE)
	);

	private static final AnyRequirementCollection ANY_HARPOON = any("Harpoon",
		item(ItemID.HARPOON),
		item(ItemID.HUNTING_BARBED_HARPOON),
		item(ItemID.DRAGON_HARPOON),
		item(ItemID.TRAILBLAZER_HARPOON_NO_INFERNAL),
		item(ItemID.INFERNAL_HARPOON),
		item(ItemID.TRAILBLAZER_HARPOON),
		item(ItemID.INFERNAL_HARPOON_EMPTY),
		item(ItemID.TRAILBLAZER_HARPOON_EMPTY),
		item(ItemID.CRYSTAL_HARPOON),
		item(ItemID.CRYSTAL_HARPOON_INACTIVE),
		item(ItemID.LEAGUE_TRAILBLAZER_HARPOON)
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
			ItemVariationMapping.getVariations(ItemID.SKILLCAPE_AGILITY).stream(),
			ItemVariationMapping.getVariations(ItemID.SKILLCAPE_MAX).stream())
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item).toArray(SingleItemRequirement[]::new))
	);

	static final List<SkillChallengeClue> CLUES = ImmutableList.of(
		// Charlie Tasks
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a cooked pike.", item(ItemID.PIKE)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a cooked trout.", item(ItemID.TROUT)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a leather body.", item(ItemID.LEATHER_ARMOUR)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie some leather chaps.", item(ItemID.LEATHER_CHAPS)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a raw herring.", item(ItemID.RAW_HERRING)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a raw trout.", item(ItemID.RAW_TROUT)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie a piece of iron ore.", item(ItemID.IRON_ORE)),
		new SkillChallengeClue(ChallengeType.CHARLIE, "i need to give charlie one iron dagger.", item(ItemID.IRON_DAGGER)),
		// Elite Sherlock Tasks
		new SkillChallengeClue("Equip a Dragon Scimitar.", true, any("Any Dragon Scimitar", item(ItemID.DRAGON_SCIMITAR), item(ItemID.DRAGON_SCIMITAR_ORNAMENT))),
		new SkillChallengeClue("Enchant some Dragonstone Jewellery.", "enchant a piece of dragonstone jewellery.",
			xOfItem(ItemID.COSMICRUNE, 1),
			any("Water Rune x15", xOfItem(ItemID.WATERRUNE, 15), xOfItem(ItemID.MISTRUNE, 15), xOfItem(ItemID.MUDRUNE, 15), xOfItem(ItemID.STEAMRUNE, 15), item(ItemID.STAFF_OF_WATER), item(ItemID.WATER_BATTLESTAFF), item(ItemID.MYSTIC_WATER_STAFF), item(ItemID.MUD_BATTLESTAFF), item(ItemID.MYSTIC_MUD_STAFF), item(ItemID.MIST_BATTLESTAFF), item(ItemID.MYSTIC_MIST_BATTLESTAFF), item(ItemID.STEAM_BATTLESTAFF), item(ItemID.MYSTIC_STEAM_BATTLESTAFF), item(ItemID.STEAM_BATTLESTAFF_PRETTY), item(ItemID.MYSTIC_STEAM_BATTLESTAFF_PRETTY), item(ItemID.KODAI_WAND), item(ItemID.TOME_OF_WATER)),
			any("Earth Rune x15", xOfItem(ItemID.EARTHRUNE, 15), xOfItem(ItemID.DUSTRUNE, 15), xOfItem(ItemID.MUDRUNE, 15), xOfItem(ItemID.LAVARUNE, 15), item(ItemID.STAFF_OF_EARTH), item(ItemID.EARTH_BATTLESTAFF), item(ItemID.MYSTIC_EARTH_STAFF), item(ItemID.MUD_BATTLESTAFF), item(ItemID.MYSTIC_MUD_STAFF), item(ItemID.DUST_BATTLESTAFF), item(ItemID.MYSTIC_DUST_BATTLESTAFF), item(ItemID.LAVA_BATTLESTAFF), item(ItemID.MYSTIC_LAVA_STAFF), item(ItemID.LAVA_BATTLESTAFF_PRETTY), item(ItemID.MYSTIC_LAVA_STAFF_PRETTY)),
			any("Unenchanted Dragonstone Jewellery", item(ItemID.DRAGONSTONE_RING), item(ItemID.DRAGONSTONE_NECKLACE), item(ItemID.JEWL_DRAGONSTONE_BRACELET), item(ItemID.STRUNG_DRAGONSTONE_AMULET))),
		new SkillChallengeClue("Craft a nature rune.", any("Pure essence or Daeyalt essence", item(ItemID.BLANKRUNE_HIGH), item(ItemID.BLANKRUNE_DAEYALT))),
		new SkillChallengeClue("Catch a mottled eel with aerial fishing in Lake Molch.", any("Fish chunks or King worms", item(ItemID.FISH_CHUNKS), item(ItemID.KING_WORM)), emptySlot("No Gloves", EquipmentInventorySlot.GLOVES), any("No Weapon", emptySlot("",  EquipmentInventorySlot.WEAPON), item(ItemID.AERIAL_FISHING_GLOVES_NO_BIRD), item(ItemID.AERIAL_FISHING_GLOVES_BIRD)), emptySlot("No Shield", EquipmentInventorySlot.SHIELD)),
		new SkillChallengeClue("Score a goal in skullball.", true, any("Ring of Charos", item(ItemID.RING_OF_CHAROS), item(ItemID.RING_OF_CHAROS_UNLOCKED))),
		new SkillChallengeClue("Complete a lap of Ape atoll agility course.", true, any("Ninja Monkey Greegree", item(ItemID.MM_MONKEY_GREEGREE_FOR_SMALL_NINJA_MONKEY), item(ItemID.MM_MONKEY_GREEGREE_FOR_MEDIUM_NINJA_MONKEY), item(ItemID.MM2_KRUK_GREEGREE))),
		new SkillChallengeClue("Create a super defence potion.", item(ItemID.CADANTINEVIAL), item(ItemID.WHITE_BERRIES)),
		new SkillChallengeClue("Steal from a chest in Ardougne Castle."),
		new SkillChallengeClue("Craft a green dragonhide body.", xOfItem(ItemID.DRAGON_LEATHER, 3), any("Needle", item(ItemID.NEEDLE), item(ItemID.COSTUMENEEDLE)), any("Thread", item(ItemID.THREAD), item(ItemID.COSTUMENEEDLE))),
		new SkillChallengeClue("String a yew longbow.", item(ItemID.UNSTRUNG_YEW_LONGBOW), item(ItemID.BOW_STRING)),
		new SkillChallengeClue("Kill a Dust Devil.", "slay a dust devil.", true,
			any("Facemask or Slayer Helmet",
				Stream.of(
					ItemVariationMapping.getVariations(ItemID.SLAYER_HELM).stream(),
					Stream.of(ItemID.SLAYER_FACEMASK))
					.reduce(Stream::concat)
					.orElseGet(Stream::empty)
					.map(ItemRequirements::item)
					.toArray(SingleItemRequirement[]::new))),
		new SkillChallengeClue("Catch a black warlock.", any("Butterfly Net", item(ItemID.HUNTING_BUTTERFLY_NET), item(ItemID.II_MAGIC_BUTTERFLY_NET))),
		new SkillChallengeClue("Catch a red chinchompa.", item(ItemID.HUNTING_BOX_TRAP)),
		new SkillChallengeClue("Mine a mithril ore.", ANY_PICKAXE),
		new SkillChallengeClue("Smith a mithril 2h sword.", ANY_HAMMER, xOfItem(ItemID.MITHRIL_BAR, 3)),
		new SkillChallengeClue("Catch a raw shark.", ANY_HARPOON),
		new SkillChallengeClue("Cut a yew log.", ANY_AXE),
		new SkillChallengeClue("Fix a magical lamp in Dorgesh-Kaan.", new String[] { "Broken lamp" }, new int[] { 10834, 10835 }, item(ItemID.DORGESH_LIGHT_BULB)),
		new SkillChallengeClue("Burn a yew log.", item(ItemID.YEW_LOGS), item(ItemID.TINDERBOX)),
		new SkillChallengeClue("Cook a swordfish", "cook a swordfish", item(ItemID.RAW_SWORDFISH)),
		new SkillChallengeClue("Craft multiple cosmic runes from a single essence.", any("Pure essence or Daeyalt essence", item(ItemID.BLANKRUNE_HIGH), item(ItemID.BLANKRUNE_DAEYALT))),
		new SkillChallengeClue("Plant a watermelon seed.", item(ItemID.RAKE), item(ItemID.DIBBER), xOfItem(ItemID.WATERMELON_SEED, 3)),
		new SkillChallengeClue("Activate the Chivalry prayer."),
		new SkillChallengeClue("Smith a tier 2 or above Shayzien platebody.", "smith a tier 2 or above shayzien platebody.", ANY_HAMMER, xOfItem(ItemID.LOVAKITE_BAR, 4)),
		// Master Sherlock Tasks
		new SkillChallengeClue("Equip an abyssal whip in front of the abyssal demons of the Slayer Tower.", true, any("Abyssal Whip", item(ItemID.ABYSSAL_WHIP), item(ItemID.ABYSSAL_WHIP_ICE), item(ItemID.ABYSSAL_WHIP_LAVA), item(ItemID.LEAGUE_3_WHIP), item(ItemID.ABYSSAL_TENTACLE), item(ItemID.LEAGUE_3_WHIP_TENTACLE))),
		new SkillChallengeClue("Smith a runite med helm.", ANY_HAMMER, item(ItemID.RUNITE_BAR)),
		new SkillChallengeClue("Teleport to a spirit tree you planted yourself."),
		new SkillChallengeClue("Create a Barrows teleport tablet.", item(ItemID.ARCEUUS_ESSENCE_BLOCK_DARK), xOfItem(ItemID.BLOODRUNE, 1), xOfItem(ItemID.LAWRUNE, 2), xOfItem(ItemID.SOULRUNE, 2)),
		new SkillChallengeClue("Kill a Nechryael in the Slayer Tower.", "slay a nechryael in the slayer tower."),
		new SkillChallengeClue("Kill a Spiritual Mage while wearing something from their god.", "kill the spiritual, magic and godly whilst representing their own god."),
		new SkillChallengeClue("Create an unstrung dragonstone amulet at a furnace.", item(ItemID.GOLD_BAR), item(ItemID.DRAGONSTONE), item(ItemID.AMULET_MOULD)),
		new SkillChallengeClue("Burn a magic log.", item(ItemID.MAGIC_LOGS), item(ItemID.TINDERBOX)),
		new SkillChallengeClue("Burn a redwood log.", item(ItemID.REDWOOD_LOGS), item(ItemID.TINDERBOX)),
		new SkillChallengeClue("Complete a lap of Rellekka's Rooftop Agility Course", "complete a lap of the rellekka rooftop agility course whilst sporting the finest amount of grace.", true, A_FULL_GRACEFUL_SET),
		new SkillChallengeClue("Mix an anti-venom potion.", item(ItemID.ANTIDOTE__4), xOfItem(ItemID.SNAKEBOSS_SCALE, 20)),
		new SkillChallengeClue("Mine a piece of Runite ore", "mine a piece of runite ore whilst sporting the finest mining gear.", true, ANY_PICKAXE,
			all("Prospector kit",
				any("", item(ItemID.MOTHERLODE_REWARD_HAT), item(ItemID.MOTHERLODE_REWARD_HAT_GOLD)),
				any("", item(ItemID.MOTHERLODE_REWARD_TOP), item(ItemID.VARROCK_ARMOUR_ELITE), item(ItemID.MOTHERLODE_REWARD_TOP_GOLD)),
				any("", item(ItemID.MOTHERLODE_REWARD_LEGS), item(ItemID.MOTHERLODE_REWARD_LEGS_GOLD)),
				any("", item(ItemID.MOTHERLODE_REWARD_BOOTS), item(ItemID.MOTHERLODE_REWARD_BOOTS_GOLD)))),
		new SkillChallengeClue("Steal a gem from the Ardougne market."),
		new SkillChallengeClue("Pickpocket an elf."),
		new SkillChallengeClue("Bind a blood rune at the blood altar.", item(ItemID.BIGBLANKRUNE)),
		new SkillChallengeClue("Create a ranging mix potion.", "mix a ranging mix potion.", item(ItemID._2DOSERANGERSPOTION), item(ItemID.BRUT_CAVIAR)),
		new SkillChallengeClue("Fletch a rune dart.", item(ItemID.RUNE_DART_TIP), item(ItemID.FEATHER)),
		new SkillChallengeClue("Cremate a set of fiyr remains.", any("Magic or Redwood Pyre Logs", item(ItemID.MAGIC_LOGS_PYRE), item(ItemID.REDWOOD_LOGS_PYRE)), item(ItemID.TINDERBOX), item(ItemID.SHADE_BONES5)),
		new SkillChallengeClue("Dissect a sacred eel.", item(ItemID.KNIFE), any("Fishing rod", item(ItemID.FISHING_ROD), item(ItemID.FISHINGROD_PEARL)), item(ItemID.FISHING_BAIT)),
		new SkillChallengeClue("Kill a lizardman shaman."),
		new SkillChallengeClue("Catch an Anglerfish.", "angle for an anglerfish whilst sporting the finest fishing gear.", true, any("Fishing rod", item(ItemID.FISHING_ROD), item(ItemID.FISHINGROD_PEARL)), item(ItemID.PISCARILIUS_SANDWORMS),
			all("Angler's outfit",
				any("", item(ItemID.TRAWLER_REWARD_HAT), item(ItemID.SPIRIT_ANGLER_HAT)),
				any("", item(ItemID.TRAWLER_REWARD_TOP), item(ItemID.SPIRIT_ANGLER_TOP)),
				any("", item(ItemID.TRAWLER_REWARD_LEGS), item(ItemID.SPIRIT_ANGLER_LEGS)),
				any("", item(ItemID.TRAWLER_REWARD_BOOTS), item(ItemID.SPIRIT_ANGLER_BOOTS)))),
		new SkillChallengeClue("Chop a redwood log.", "chop a redwood log whilst sporting the finest lumberjack gear.", true, ANY_AXE,
			all("Lumberjack outfit",
				any("", item(ItemID.RAMBLE_LUMBERJACK_HAT), item(ItemID.FORESTRY_LUMBERJACK_HAT)),
				any("", item(ItemID.RAMBLE_LUMBERJACK_TOP), item(ItemID.FORESTRY_LUMBERJACK_TOP)),
				any("", item(ItemID.RAMBLE_LUMBERJACK_LEGS), item(ItemID.FORESTRY_LUMBERJACK_LEGS)),
				any("", item(ItemID.RAMBLE_LUMBERJACK_BOOTS), item(ItemID.FORESTRY_LUMBERJACK_BOOTS)))),
		new SkillChallengeClue("Craft a light orb in the Dorgesh-Kaan bank.", item(ItemID.DORGESH_WIRE), item(ItemID.DORGESH_LIGHTBULB_NOFILAMENT)),
		new SkillChallengeClue("Kill a reanimated Abyssal Demon.", "kill a reanimated abyssal.", xOfItem(ItemID.SOULRUNE, 4), xOfItem(ItemID.BLOODRUNE, 2), any("Nature Rune x4", xOfItem(ItemID.NATURERUNE, 4), item(ItemID.NATURE_STAFF_CHARGED)), range("Ensouled abyssal head", ItemID.ARCEUUS_CORPSE_ABYSSAL_INITIAL, ItemID.ARCEUUS_CORPSE_ABYSSAL)),
		new SkillChallengeClue("Kill a Fiyr shade inside Mort'tons shade catacombs.",
			any("Any Gold or Silver Shade Key",
				item(ItemID.SHADEKEY_GOLD_BLOODRED), item(ItemID.SHADEKEY_GOLD_BROWN), item(ItemID.SHADEKEY_GOLD_CRIMSON), item(ItemID.SHADEKEY_GOLD_BLACK), item(ItemID.SHADEKEY_GOLD_PURPLE),
				item(ItemID.SHADEKEY_SILVER_BLOODRED), item(ItemID.SHADEKEY_SILVER_BROWN), item(ItemID.SHADEKEY_SILVER_CRIMSON), item(ItemID.SHADEKEY_SILVER_BLACK), item(ItemID.SHADEKEY_SILVER_PURPLE))),
		new SkillChallengeClue("Catch a tecu salamander.", item(ItemID.ROPE), item(ItemID.NET))
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
