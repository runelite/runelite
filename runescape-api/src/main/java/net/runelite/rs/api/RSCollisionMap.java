package net.runelite.rs.api;

import net.runelite.api.CollisionData;
import net.runelite.mapping.Import;

public interface RSCollisionMap extends CollisionData
{
	@Import("flags")
	int[][] getFlags();
}
