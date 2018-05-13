package net.runelite.client.plugins.worldswitcherfilter;

import lombok.Getter;

public enum WorldRegions
{
	USA(0),
	UK(1),
	AUSTRALIA(3),
	GERMANY(7);

	@Getter
	private int regionId;

	WorldRegions(int regionId)
	{
		this.regionId = regionId;
	}
}
