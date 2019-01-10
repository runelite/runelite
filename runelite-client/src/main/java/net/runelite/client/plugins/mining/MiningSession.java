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
import java.time.Instant;
import java.util.HashMap;

/**
 * Holds information about the players current mining session
 */
public class MiningSession
{

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Instant ignoreSpawn;

	@Getter(AccessLevel.PACKAGE)
	private Instant lastMined;

	@Getter(AccessLevel.PACKAGE)
	private HashMap<MiningRockType, MiningSessionRockStats> sessionStats = new HashMap<>();

	public MiningSession()
	{
		setupSession();
	}

	public void setupSession()
	{
		ignoreSpawn = Instant.now();
		for (MiningRockType rock : MiningRockType.values())
		{
			sessionStats.put(rock, new MiningSessionRockStats());
		}
	}

	public boolean showRockRespawnTimes(MiningRockType rock)
	{
		return sessionStats.get(rock).getRecentOreMined() != null;
	}

	public void clearSessionFor(MiningRockType rock)
	{
		sessionStats.get(rock).clearSession();
	}

	public void increaseRockMine(MiningRockType rock)
	{
		Instant now = Instant.now();
		lastMined = now;
		sessionStats.get(rock).increaseMined();
	}

}
