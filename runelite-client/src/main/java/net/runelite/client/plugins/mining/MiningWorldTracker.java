package net.runelite.client.plugins.mining;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.TileObject;

import java.util.HashMap;

/**
 * Holds each world currently being tracked for respawn timers
 */
public class MiningWorldTracker
{

	@Getter(AccessLevel.PUBLIC)
	private MiningRockType.WorldRock trackingRock;

	@Getter(AccessLevel.PUBLIC)
	private HashMap<Integer, MiningWorld> trackedWorlds = new HashMap<>();

	public MiningWorldTracker(MiningRockType.WorldRock trackingRock)
	{
		this.trackingRock = trackingRock;
	}

	/**
	 * Adds a tracked rock to a world.
	 * @param world			World ID
	 * @param object		The TileObject of the rock to track
	 * @param mined			The MinedRock of the rock, containing the Type & respawn time
	 */
	public void addTracked(int world, TileObject object, MinedRock mined)
	{
		if (!trackedWorlds.containsKey(world))
		{ // Create the world if it does not exist yet
			trackedWorlds.put(world, new MiningWorld(world));
		}
		trackedWorlds.get(world).clearNegatives(); // Clear any negative rocks as a new rock is being added
		trackedWorlds.get(world).getRocks().put(object, mined); // Add this rock
	}

}
