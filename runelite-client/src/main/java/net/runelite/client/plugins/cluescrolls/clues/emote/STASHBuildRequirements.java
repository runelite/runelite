package net.runelite.client.plugins.cluescrolls.clues.emote;

import lombok.Getter;
import net.runelite.client.plugins.cluescrolls.clues.item.*;


import static net.runelite.api.ItemID.*;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.*;

@Getter
public enum STASHBuildRequirements
{
	BEGINNER("12 Construction", any("Hammer", xOfItem(HAMMER, 1), xOfItem(IMCANDO_HAMMER, 1)), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1)), any("Plank x2", xOfItem(PLANK, 2)), any("Nails x10", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10))),
	EASY("27 Construction", any("Hammer", xOfItem(HAMMER, 1), xOfItem(IMCANDO_HAMMER, 1)), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1)), any("Plank x2", xOfItem(PLANK, 2)), any("Nails", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10))),
	MEDIUM("42 Construction", any("Hammer", xOfItem(HAMMER, 1), xOfItem(IMCANDO_HAMMER, 1)), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1)), any("Oak plank x2", xOfItem(OAK_PLANK, 2)), any("Nails x10", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10))),
	HARD("55 Construction", any("Hammer", xOfItem(HAMMER, 1), xOfItem(IMCANDO_HAMMER, 1)), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1)), any("Teak plank x2", xOfItem(PLANK, 2)), any("Nails x10", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10))),
	ELITE("77 Construction", any("Hammer", xOfItem(HAMMER, 1), xOfItem(IMCANDO_HAMMER, 1)), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1)), any("Mahogany plank x2", xOfItem(PLANK, 2)), any("Nails x10", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10))),
	MASTER("88 Construction", any("Hammer", xOfItem(HAMMER, 1), xOfItem(IMCANDO_HAMMER, 1)), any("Saw", xOfItem(SAW, 1), xOfItem(CRYSTAL_SAW, 1)), any("Mahogany plank x2", xOfItem(PLANK, 2)), any("Nails x10", xOfItem(BRONZE_NAILS, 10), xOfItem(STEEL_NAILS, 10), xOfItem(BLACK_NAILS, 10), xOfItem(MITHRIL_NAILS, 10), xOfItem(ADAMANTITE_NAILS, 10), xOfItem(RUNE_NAILS, 10)), any("Gold Leaf", xOfItem(GOLD_LEAF, 1)));

	private final String constructionLevelRequired;
	private final ItemRequirement[] itemRequirements;

	STASHBuildRequirements(String constructionLevelRequired, ItemRequirement ... itemRequirements)
	{
		this.constructionLevelRequired = constructionLevelRequired;
		this.itemRequirements = itemRequirements;
		System.out.println(itemRequirements.length);
	}
}
