package net.runelite.client.plugins.shootingstars;

import lombok.Value;
import net.runelite.api.coords.WorldPoint;

@Value
public class CrashedStar
{
	public static final int MIN_TIER = 1;

	int world;
	WorldPoint worldPoint;
	int tier;

	public boolean depleted()
	{
		return tier == 0;
	}

	public boolean isSame(CrashedStar star)
	{
		return this.world == star.world && this.worldPoint.equals(star.worldPoint);
	}

	public CrashedStar reduceTier()
	{
		if (depleted())
		{
			throw new IllegalStateException("Star has already depleted");
		}
		return new CrashedStar(world, worldPoint, tier - 1);
	}
}
