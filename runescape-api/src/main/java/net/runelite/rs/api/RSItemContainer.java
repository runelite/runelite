package net.runelite.rs.api;

import net.runelite.api.ItemContainer;
import net.runelite.mapping.Import;

public interface RSItemContainer extends RSNode, ItemContainer
{
	@Import("ids")
	int[] getItemIds();

	@Import("quantities")
	int[] getStackSizes();
}
