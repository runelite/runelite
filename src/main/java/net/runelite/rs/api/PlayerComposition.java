package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface PlayerComposition
{
	@Import("isFemale")
	boolean isFemale();

	@Import("equipment")
	int[] getEquipment();
}
