package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface ItemComposition
{
	@Import("name")
	String getName();

	@Import("isMembers")
	boolean isMembers();

	@Import("maleModel")
	int getMaleModel();
}
