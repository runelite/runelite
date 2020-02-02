package net.runelite.api.geometry;

import net.runelite.api.coords.WorldPoint;

public class Cuboid
{
	private WorldPoint southWest;
	private WorldPoint northEast;

	public Cuboid(int x1, int y1, int z1, int x2, int y2, int z2)
	{
		this(new WorldPoint(x1, y1, z1), new WorldPoint(x2, y2, z2));
	}

	public Cuboid(WorldPoint southWest, WorldPoint northEast)
	{
		this.southWest = southWest;
		this.northEast = northEast;
	}

	public boolean contains(WorldPoint worldPoint)
	{
		if (worldPoint.getPlane() < southWest.getPlane() || worldPoint.getPlane() > northEast.getPlane())
		{
			return false;
		}
		if (worldPoint.getY() < southWest.getY() || worldPoint.getY() > northEast.getY())
		{
			return false;
		}
		return worldPoint.getX() >= southWest.getX() && worldPoint.getX() <= northEast.getX();
	}
}
