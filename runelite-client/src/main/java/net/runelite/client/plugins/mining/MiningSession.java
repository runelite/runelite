/*
 * Copyright (c) 2018, Craftiii4 <Craftiii4@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
	 *
	 * @param rock		Rock to display
	 * @return 			If player should see respawn times for the rock
	 */
	public boolean showOreRespawns(MiningRockType rock)
	{
		return recentOreMined[rock.getIndex()] != null;
	}

	/**
	 * Clear the session values (excluding totals) for a certain rock
	 *
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
	 *
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
