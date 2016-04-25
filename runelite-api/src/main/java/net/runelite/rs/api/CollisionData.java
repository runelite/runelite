package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface CollisionData
{
	@Import("flags")
	int[][] getFlags();
}
