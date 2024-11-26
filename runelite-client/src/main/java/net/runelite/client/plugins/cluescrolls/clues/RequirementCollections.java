/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2024, Felanbird <https://github.com/Felanbird>
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

import java.util.stream.Stream;
import static net.runelite.api.ItemID.*;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.plugins.cluescrolls.clues.item.AllRequirementsCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.all;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.any;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.item;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.range;
import net.runelite.client.plugins.cluescrolls.clues.item.SingleItemRequirement;

class RequirementCollections
{
	static final AnyRequirementCollection ANY_SLAYER_HELMET = any("Any slayer helmet",
		ItemVariationMapping.getVariations(SLAYER_HELMET).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_RING_OF_WEALTH = any("Any ring of wealth",
		ItemVariationMapping.getVariations(RING_OF_WEALTH).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_PHARAOHS_SCEPTRE = any("Pharaoh's sceptre",
		ItemVariationMapping.getVariations(PHARAOHS_SCEPTRE).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_RUNE_HERALDIC_SHIELD = any("Any Rune shield (h)",
		ItemVariationMapping.getVariations(RUNE_SHIELD_H1).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_RUNE_HERALDIC_HELM = any("Any Rune helm (h)",
		ItemVariationMapping.getVariations(RUNE_HELM_H1).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_TEAM_CAPE = any("Any team cape",
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
	static final AnyRequirementCollection DRAGON_OR_AVERNIC_DEFENDER = any("Dragon or Avernic Defender",
		Stream.of(
			ItemVariationMapping.getVariations(DRAGON_DEFENDER).stream(),
			ItemVariationMapping.getVariations(AVERNIC_DEFENDER).stream(),
			ItemVariationMapping.getVariations(GHOMMALS_AVERNIC_DEFENDER_5).stream())
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.filter(itemId -> itemId != DRAGON_DEFENDER_BROKEN && itemId != AVERNIC_DEFENDER_BROKEN)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_HAMMER = any("Hammer",
		item(HAMMER),
		item(IMCANDO_HAMMER)
	);
	static final AnyRequirementCollection ANY_HARPOON = any("Harpoon",
		item(HARPOON),
		item(BARBTAIL_HARPOON),
		item(DRAGON_HARPOON),
		item(DRAGON_HARPOON_OR),
		item(INFERNAL_HARPOON),
		item(INFERNAL_HARPOON_OR),
		item(INFERNAL_HARPOON_UNCHARGED),
		item(INFERNAL_HARPOON_UNCHARGED_25367),
		item(CRYSTAL_HARPOON),
		item(CRYSTAL_HARPOON_INACTIVE),
		item(TRAILBLAZER_HARPOON)
	);
	static final AnyRequirementCollection ANY_PICKAXE = any("Any Pickaxe",
		item(BRONZE_PICKAXE),
		item(IRON_PICKAXE),
		item(STEEL_PICKAXE),
		item(BLACK_PICKAXE),
		item(MITHRIL_PICKAXE),
		item(ADAMANT_PICKAXE),
		item(RUNE_PICKAXE),
		item(DRAGON_PICKAXE),
		item(DRAGON_PICKAXE_12797),
		item(DRAGON_PICKAXE_OR),
		item(DRAGON_PICKAXE_OR_25376),
		item(INFERNAL_PICKAXE),
		item(INFERNAL_PICKAXE_OR),
		item(INFERNAL_PICKAXE_UNCHARGED),
		item(INFERNAL_PICKAXE_UNCHARGED_25369),
		item(GILDED_PICKAXE),
		item(_3RD_AGE_PICKAXE),
		item(CRYSTAL_PICKAXE),
		item(CRYSTAL_PICKAXE_INACTIVE),
		item(TRAILBLAZER_PICKAXE)
	);
	static final AnyRequirementCollection ANY_AXE = any("Any Axe",
		item(BRONZE_AXE),
		item(BRONZE_FELLING_AXE),
		item(IRON_AXE),
		item(IRON_FELLING_AXE),
		item(STEEL_AXE),
		item(STEEL_FELLING_AXE),
		item(BLACK_AXE),
		item(BLACK_FELLING_AXE),
		item(MITHRIL_AXE),
		item(MITHRIL_FELLING_AXE),
		item(ADAMANT_AXE),
		item(ADAMANT_FELLING_AXE),
		item(RUNE_AXE),
		item(RUNE_FELLING_AXE),
		item(DRAGON_AXE),
		item(DRAGON_AXE_OR),
		item(DRAGON_FELLING_AXE),
		item(INFERNAL_AXE),
		item(INFERNAL_AXE_OR),
		item(INFERNAL_AXE_UNCHARGED),
		item(INFERNAL_AXE_UNCHARGED_25371),
		item(GILDED_AXE),
		item(_3RD_AGE_AXE),
		item(_3RD_AGE_FELLING_AXE),
		item(CRYSTAL_AXE),
		item(CRYSTAL_AXE_INACTIVE),
		item(CRYSTAL_FELLING_AXE),
		item(CRYSTAL_FELLING_AXE_INACTIVE),
		item(TRAILBLAZER_AXE)
	);
	static final AllRequirementsCollection A_FULL_GRACEFUL_SET = all("A full Graceful set",
		any("" /* graceful hood   */, ItemVariationMapping.getVariations(GRACEFUL_HOOD).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful top    */, ItemVariationMapping.getVariations(GRACEFUL_TOP).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful legs   */, ItemVariationMapping.getVariations(GRACEFUL_LEGS).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful gloves */, ItemVariationMapping.getVariations(GRACEFUL_GLOVES).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful boots  */, ItemVariationMapping.getVariations(GRACEFUL_BOOTS).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful cape   */, Stream.of(
			ItemVariationMapping.getVariations(GRACEFUL_CAPE).stream(),
			ItemVariationMapping.getVariations(AGILITY_CAPE).stream(),
			ItemVariationMapping.getVariations(MAX_CAPE).stream())
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item).toArray(SingleItemRequirement[]::new))
	);
	static final AnyRequirementCollection ANY_FULL_BARROWS_SET = any("Any full Barrows set",
		all(any("Ahrim's hood", item(AHRIMS_HOOD), range(AHRIMS_HOOD_100, AHRIMS_HOOD_0)),
			any("Ahrim's staff", item(AHRIMS_STAFF), range(AHRIMS_STAFF_100, AHRIMS_STAFF_0)),
			any("Ahrim's robetop", item(AHRIMS_ROBETOP), range(AHRIMS_ROBETOP_100, AHRIMS_ROBETOP_0)),
			any("Ahrim's robeskirt", item(AHRIMS_ROBESKIRT), range(AHRIMS_ROBESKIRT_100, AHRIMS_ROBESKIRT_0))),
		all(any("Dharok's helm", item(DHAROKS_HELM), range(DHAROKS_HELM_100, DHAROKS_HELM_0)),
			any("Dharok's greataxe", item(DHAROKS_GREATAXE), range(DHAROKS_GREATAXE_100, DHAROKS_GREATAXE_0)),
			any("Dharok's platebody", item(DHAROKS_PLATEBODY), range(DHAROKS_PLATEBODY_100, DHAROKS_PLATEBODY_0)),
			any("Dharok's platelegs", item(DHAROKS_PLATELEGS), range(DHAROKS_PLATELEGS_100, DHAROKS_PLATELEGS_0))),
		all(any("Guthan's helm", item(GUTHANS_HELM), range(GUTHANS_HELM_100, GUTHANS_HELM_0)),
			any("Guthan's warspear", item(GUTHANS_WARSPEAR), range(GUTHANS_WARSPEAR_100, GUTHANS_WARSPEAR_0)),
			any("Guthan's platebody", item(GUTHANS_PLATEBODY), range(GUTHANS_PLATEBODY_100, GUTHANS_PLATEBODY_0)),
			any("Guthan's chainskirt", item(GUTHANS_CHAINSKIRT), range(GUTHANS_CHAINSKIRT_100, GUTHANS_CHAINSKIRT_0))),
		all(any("Karil's coif", item(KARILS_COIF), range(KARILS_COIF_100, KARILS_COIF_0)),
			any("Karil's crossbow", item(KARILS_CROSSBOW), range(KARILS_CROSSBOW_100, KARILS_CROSSBOW_0)),
			any("Karil's leathertop", item(KARILS_LEATHERTOP), range(KARILS_LEATHERTOP_100, KARILS_LEATHERTOP_0)),
			any("Karil's leatherskirt", item(KARILS_LEATHERSKIRT), range(KARILS_LEATHERSKIRT_100, KARILS_LEATHERSKIRT_0))),
		all(any("Torag's helm", item(TORAGS_HELM), range(TORAGS_HELM_100, TORAGS_HELM_0)),
			any("Torag's hammers", item(TORAGS_HAMMERS), range(TORAGS_HAMMERS_100, TORAGS_HAMMERS_0)),
			any("Torag's platebody", item(TORAGS_PLATEBODY), range(TORAGS_PLATEBODY_100, TORAGS_PLATEBODY_0)),
			any("Torag's platelegs", item(TORAGS_PLATELEGS), range(TORAGS_PLATELEGS_100, TORAGS_PLATELEGS_0))),
		all(any("Verac's helm", item(VERACS_HELM), range(VERACS_HELM_100, VERACS_HELM_0)),
			any("Verac's flail", item(VERACS_FLAIL), range(VERACS_FLAIL_100, VERACS_FLAIL_0)),
			any("Verac's brassard", item(VERACS_BRASSARD), range(VERACS_BRASSARD_100, VERACS_BRASSARD_0)),
			any("Verac's plateskirt", item(VERACS_PLATESKIRT), range(VERACS_PLATESKIRT_100, VERACS_PLATESKIRT_0)))
	);
}
