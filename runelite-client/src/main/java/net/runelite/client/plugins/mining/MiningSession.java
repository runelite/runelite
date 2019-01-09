package net.runelite.client.plugins.mining;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Holds information about the players current mining session
 */
public class MiningSession
{

	private static final Duration HOUR = Duration.ofHours(1);

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Instant ignoreSpawn;

	@Getter(AccessLevel.PACKAGE)
	private Instant lastMined;

	@Getter(AccessLevel.PACKAGE)
	private Instant[] lastOreMined;

	private Instant[] recentOreMined;

	@Getter(AccessLevel.PACKAGE)
	private int totalMined[];

	@Getter(AccessLevel.PACKAGE)
	private int[] perHour;

	@Getter(AccessLevel.PACKAGE)
	private int recentMined[];

	public MiningSession()
	{
		setupSession();
	}

	/**
	 * Setups all variables for the players session
	 */
	public void setupSession()
	{
		ignoreSpawn = Instant.now();
		lastOreMined = new Instant[MiningRockType.values().length];
		recentOreMined =  new Instant[MiningRockType.values().length];
		totalMined = new int[MiningRockType.values().length];
		perHour = new int[MiningRockType.values().length];
		recentMined = new int[MiningRockType.values().length];
		resetSession();
	}

	/**
	 * Clears everything to do with this session, including totals
	 */
	public void resetSession()
	{
		Arrays.fill(lastOreMined, null);
		Arrays.fill(recentOreMined, null);
		Arrays.fill(totalMined, 0);
		Arrays.fill(perHour, 0);
		Arrays.fill(recentMined, 0);
	}

	/**
	 * Checks if the respawn times for a certain rock should be displayed
	 * This is achieved by checking if the player recently mined that ore
	 * @param rock		Rock to display
	 * @return 			If player should see respawn times for the rock
	 */
	public boolean showOreRespawns(MiningRockType rock)
	{
		return recentOreMined[rock.getIndex()] != null;
	}

	/**
	 * Clear the session values (excluding totals) for a certain rock
	 * @param rock 		Rock to clear session values for
	 */
	public void clearSessionFor(MiningRockType rock)
	{
		int index = rock.getIndex();
		recentOreMined[index] = null;
		perHour[index] = 0;
		recentMined[index] = 0;
	}

	/**
	 * Increases the amount of a rock mined during this session by 1
	 * @param rock		The rock type mined by the player
	 */
	public void increaseRockMine(MiningRockType rock)
	{
		Instant now = Instant.now();
		int index = rock.getIndex();

		lastMined = now;
		lastOreMined[index] = now;
		totalMined[index]++;

		if (recentOreMined[index] == null)
		{
			recentOreMined[index] = now;
		}
		recentMined[index]++;

		Duration timeSinceStart = Duration.between(recentOreMined[index], now);
		if (!timeSinceStart.isZero())
		{
			perHour[index] = (int) ((double) recentMined[index] * (double) HOUR.toMillis() / (double) timeSinceStart.toMillis());
		}
	}

}
