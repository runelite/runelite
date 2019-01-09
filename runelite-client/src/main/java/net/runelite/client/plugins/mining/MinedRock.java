package net.runelite.client.plugins.mining;

import lombok.AccessLevel;
import lombok.Getter;

public class MinedRock
{

	@Getter(AccessLevel.PACKAGE)
	private final MiningRockType type;

	private final long respawnTime;

	private final long maxRespawnTime;

	public MinedRock(MiningRockType type)
	{
		this.type = type;
		this.respawnTime = System.currentTimeMillis() + (int)(type.getRespawnTime() * 1000);
		this.maxRespawnTime = type.getMaxRespawnTime() == -1 ? -1 : System.currentTimeMillis() + (int)(type.getMaxRespawnTime() * 1000);
	}

	/**
	 * Gets the time until a rock respawns in seconds
	 * @return 		Seconds until the rock respawns. Minimum return value is 1, unless the rock has a respawn range, in which case can return 0
	 */
	public int asSeconds()
	{
		long remaining = respawnTime - System.currentTimeMillis();
		if (remaining > 0)
		{
			return (int) (remaining / 1000) + (remaining % 1000 > 0 ? 1 : 0);
		}
		else
		{
			return hasMax() ? 0 : 1;
		}
	}

	/**
	 * Gets the maximum time a ore can take to respawn
	 * @return 		-1 if the ore does not have a respawn range, else the max of the respawn range
	 */
	public int asSecondsMax()
	{
		if (maxRespawnTime == -1)
		{
			return -1;
		}
		long remaining = maxRespawnTime - System.currentTimeMillis();
		if (remaining > 0)
		{
			return (int) (remaining / 1000) + (remaining % 1000 > 0 ? 1 : 0);
		}
		else
		{
			return 1;
		}
	}

	/**
	 * @return 		If the rock has a respawn range
	 */
	public boolean hasMax()
	{
		return maxRespawnTime != -1;
	}

	/**
	 * Gets the seconds left until a respawn based on the minumum respawn time. Can return negative if rock should have respawned by now
	 * @return 		Time in seconds until a rock respawns.
	 */
	public int asSecondsNegative()
	{
		long remaining = respawnTime - System.currentTimeMillis();
		return (int) (remaining / 1000) + (remaining % 1000 > 0 ? 1 : 0);
	}

}
