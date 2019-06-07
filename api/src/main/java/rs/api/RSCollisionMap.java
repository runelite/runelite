package rs.api;

import api.CollisionData;
import net.runelite.mapping.Import;

public interface RSCollisionMap extends CollisionData
{
	@Import("flags")
	int[][] getFlags();
}
