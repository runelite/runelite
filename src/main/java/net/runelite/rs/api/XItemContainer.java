package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface XItemContainer extends Node
{
	@Import("itemIds")
	int[] getItemIds();

	@Import("stackSizes")
	int[] getStackSizes();
}
