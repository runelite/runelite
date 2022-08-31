package net.runelite.client.plugins.cluescrolls.clues.emote;

import lombok.Getter;
import net.runelite.client.plugins.cluescrolls.clues.item.*;

import javax.annotation.Nonnull;

import static net.runelite.api.ItemID.*;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.*;

@Getter
public enum STASHBuildRequirements
{
	BEGINNER("12 Construction", xOfItem(HAMMER, 1), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1), xOfItem(PLANK, 2), any("nails", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10)))),
	EASY("27 Construction", xOfItem(HAMMER, 1), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1), xOfItem(PLANK, 2), any("nails", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10)))),
	MEDIUM("42 Construction", xOfItem(HAMMER, 1), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1), xOfItem(OAK_PLANK, 2), any("nails", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10)))),
	HARD("55 Construction", xOfItem(HAMMER, 1), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1), xOfItem(TEAK_PLANK, 2), any("nails", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10)))),
	ELITE("77 Construction", xOfItem(HAMMER, 1), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1), xOfItem(MAHOGANY_PLANK, 2), any("nails", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10)))),
	MASTER("88 Construction", xOfItem(HAMMER, 1), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1), xOfItem(MAHOGANY_PLANK, 2), any("nails", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10)), xOfItem(GOLD_LEAF, 1)));

	private final String constructionLevelRequired;
	private final MultipleOfItemRequirement multipleOfItemRequirements;
	private final AnyRequirementCollection[] anyItemRequirementsCollection;

	STASHBuildRequirements(String constructionLevelRequired,MultipleOfItemRequirement multipleOfItemRequirements, @Nonnull AnyRequirementCollection... anyItemRequirementsCollection)
	{
		this.constructionLevelRequired = constructionLevelRequired;
		this.multipleOfItemRequirements = multipleOfItemRequirements;
		this.anyItemRequirementsCollection = anyItemRequirementsCollection;
	}
}
