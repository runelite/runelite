package net.runelite.client.plugins.raids.bats;

import java.util.Comparator;
import net.runelite.api.coords.WorldPoint;

public class WorldPointComparator implements Comparator<WorldPoint>
{
	private int rotation;

	public WorldPointComparator(int rotation)
	{
		this.rotation = rotation;
	}

	@Override
	public int compare(WorldPoint worldPointA, WorldPoint worldPointB)
	{
		switch (rotation)
		{
			case 0:
				if (worldPointA.getY() < worldPointB.getY())
				{
					return -1;
				}
				else if (worldPointA.getY() > worldPointB.getY())
				{
					return 1;
				}
				else
				{
					if (worldPointA.getX() < worldPointB.getX())
					{
						return -1;
					}
					if (worldPointA.getX() > worldPointB.getX())
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
			case 1:
				if (worldPointA.getX() < worldPointB.getX())
				{
					return -1;
				}
				else if (worldPointA.getX() > worldPointB.getX())
				{
					return 1;
				}
				else
				{
					if (worldPointA.getY() > worldPointB.getY())
					{
						return -1;
					}
					if (worldPointA.getY() < worldPointB.getY())
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
			case 2:
				if (worldPointA.getY() > worldPointB.getY())
				{
					return -1;
				}
				else if (worldPointA.getY() < worldPointB.getY())
				{
					return 1;
				}
				else
				{
					if (worldPointA.getX() > worldPointB.getX())
					{
						return -1;
					}
					if (worldPointA.getX() < worldPointB.getX())
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
			case 3:
				if (worldPointA.getX() > worldPointB.getX())
				{
					return -1;
				}
				else if (worldPointA.getX() < worldPointB.getX())
				{
					return 1;
				}
				else
				{
					if (worldPointA.getY() < worldPointB.getY())
					{
						return -1;
					}
					if (worldPointA.getY() > worldPointB.getY())
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
		}
		//This should never be reached.
		return 0;
	}
}
