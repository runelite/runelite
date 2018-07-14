package net.runelite.client.plugins.cluescrolls.clues;

import net.runelite.api.Item;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.plugins.cluescrolls.clues.emote.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.emote.SingleItemRequirement;
import net.runelite.client.ui.overlay.components.LineComponent;

import java.awt.*;

import static net.runelite.api.ItemID.SPADE;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;

public abstract class SpadeClueScroll extends ClueScroll
{
	private static final ItemRequirement SPADE_REQUIRED = new SingleItemRequirement(SPADE);
	private boolean playerHasSpade(ClueScrollPlugin plugin)
	{
		Item[] inventory = plugin.getInventoryItems();
		if (inventory != null)
		{
			return SPADE_REQUIRED.fulfilledBy(inventory);
		}
		return false;
	}
	LineComponent hasSpadeOverlayLine(ClueScrollPlugin plugin)
	{
		boolean hasSpade = playerHasSpade(plugin);
		return LineComponent.builder()
				.left(SPADE_REQUIRED.getCollectiveName(plugin.getClient()))
				.leftColor(TITLED_CONTENT_COLOR)
				.right(hasSpade ? "\u2713" : "\u2717")
				.rightColor(hasSpade ? Color.GREEN : Color.RED)
				.build();
	}
}
