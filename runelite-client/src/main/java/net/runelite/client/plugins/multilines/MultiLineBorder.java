package net.runelite.client.plugins.multilines;

import lombok.Value;
import net.runelite.api.coords.WorldPoint;

@Value
public class MultiLineBorder
{

	public static final int NORTH = 0;
	public static final int SOUTH = 1;
	public static final int EAST = 2;
	public static final int WEST = 3;

	private final String id;
	private final WorldPoint single;
	private final WorldPoint multi;

	public int getEdge()
	{
		if (single.getX() > multi.getX())
		{
			return EAST;
		}
		else if (single.getX() < multi.getX())
		{
			return WEST;
		}
		else if (single.getY() > multi.getY())
		{
			return NORTH;
		}
		else if (single.getY() < multi.getY())
		{
			return SOUTH;
		}
		throw new IllegalStateException("Entry is not representing a border.");
	}

}
