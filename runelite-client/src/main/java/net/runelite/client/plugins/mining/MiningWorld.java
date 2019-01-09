package net.runelite.client.plugins.mining;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.TileObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Holds rocks mined in a certain world
 */
public class MiningWorld
{

	@Getter(AccessLevel.PACKAGE)
	private int world; // World ID

	@Getter(AccessLevel.PACKAGE)
	private final HashMap<TileObject, MinedRock> rocks = new HashMap<>();

	/**
	 * @param world		Worlds ID
	 */
	public MiningWorld(int world)
	{
		this.world = world;
	}

	/**
	 * Clears any negative respawn times on rocks stored in this world
	 */
	public void clearNegatives()
	{
		for (TileObject o : new ArrayList<>(rocks.keySet()))
		{
			MinedRock rock = rocks.get(o);
			if (rock.asSecondsNegative() < 0)
				rocks.remove(o);
		}
	}

	/**
	 * Gets the lowest time left on a rock respawn for this world
	 * @return		Seconds left on the rock that respawns first
	 */
	public int asSeconds()
	{
		int least = Integer.MAX_VALUE;
		for (MinedRock rock : new ArrayList<>(rocks.values()))
		{
			int seconds = rock.asSecondsNegative();
			if (seconds < least)
				least = seconds;
		}
		return least;
	}

}
