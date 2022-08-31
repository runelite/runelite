package net.runelite.client.plugins.zulrah.constants;

import net.runelite.api.coords.LocalPoint;

public enum StandLocation
{
	SOUTHWEST(6208, 6848),
	WEST(5952, 7616),
	CENTER(6848, 6976),
	NORTHEAST_TOP(7488, 7872),
	NORTHEAST_BOTTOM(7360, 7872),
	NORTHWEST_TOP(5952, 7744),
	NORTHWEST_BOTTOM(6208, 7872),
	EAST_PILLAR_S(7232, 6976),
	EAST_PILLAR(7232, 7104),
	EAST_PILLAR_N(7232, 7232),
	EAST_PILLAR_N2(7232, 7360),
	WEST_PILLAR_S(6208, 6976),
	WEST_PILLAR(6208, 7104),
	WEST_PILLAR_N(6208, 7232),
	WEST_PILLAR_N2(6208, 7360);

	private final int localX;
	private final int localY;

	private StandLocation(int localX, int localY)
	{
		this.localX = localX;
		this.localY = localY;
	}

	public LocalPoint toLocalPoint()
	{
		return new LocalPoint(this.localX, this.localY);
	}
}
