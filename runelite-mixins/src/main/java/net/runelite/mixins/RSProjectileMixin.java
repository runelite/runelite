/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.mixins;

import java.time.Duration;
import net.runelite.api.Actor;
import net.runelite.api.Point;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSProjectile;

@Mixin(RSProjectile.class)
public abstract class RSProjectileMixin implements RSProjectile
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	private int targetX;

	@Inject
	private int targetY;

	@Inject
	private int targetZ;

	@Inject
	Integer spawnCycle;

	@Inject
	@Override
	public Point getTarget()
	{
		if (targetX == -1 || targetY == -1)
		{
			return null;
		}

		return new Point(targetX, targetY);
	}

	@Inject
	@Override
	public int getTargetZ()
	{
		return targetZ;
	}

	@Inject
	@Override
	public int getSpawnCycle()
	{
		return spawnCycle == null ? -1 : spawnCycle;
	}

	/**
	 * the cycles returned are for the amount of time moving this works
	 * better with the projectile movement event as it only gets called
	 * after the projectile starts moving
	 *
	 * @return total time projectile will move for in gamecycles
	 */
	@Inject
	@Override
	public int getCycleLength()
	{
		return getEndCycle() - getSpawnCycle();
	}

	@Inject
	@Override
	public Duration getLength()
	{
		return Duration.ofMillis(getCycleLength() * 20);
	}

	@Inject
	@Override
	public int getRemainingCycles()
	{
		int currentGameCycle = client.getGameCycle();

		return getEndCycle() - currentGameCycle;
	}

	@Inject
	@Override
	public Actor getInteracting()
	{
		int interactingIndex = getRsInteracting();
		if (interactingIndex == 0)
		{
			return null;
		}

		if (interactingIndex > 0)
		{
			int idx = interactingIndex - 1;
			RSNPC[] npcs = client.getCachedNPCs();
			return npcs[idx];
		}
		else
		{
			int idx = -interactingIndex - 1;

			if (idx == client.getLocalInteractingIndex())
			{
				return client.getLocalPlayer();
			}

			RSPlayer[] players = client.getCachedPlayers();
			return players[idx];
		}
	}

	@Copy("moveProjectile")
	abstract void moveProjectile(int targetX, int targetY, int targetZ, int gameCycle);

	@Replace("moveProjectile")
	public void rl$moveProjectile(int targetX, int targetY, int targetZ, int gameCycle)
	{
		this.targetX = targetX;
		this.targetY = targetY;
		this.targetZ = targetZ;

		if (spawnCycle == null)
		{
			spawnCycle = client.getGameCycle();
		}

		moveProjectile(targetX, targetY, targetZ, gameCycle);
	}
}
