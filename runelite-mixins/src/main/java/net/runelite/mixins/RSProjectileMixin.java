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

import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSProjectile;

@Mixin(RSProjectile.class)
public abstract class RSProjectileMixin implements RSProjectile
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	@Override
	public int getRemainingCycles()
	{
		int currentGameCycle = client.getGameCycle();

		return getEndCycle() - currentGameCycle;
	}

	/**
	 * Called when a projectile is set to move towards a point. For
	 * projectiles that target the ground, like AoE projectiles from
	 * Lizardman Shamans, this is only called once
	 *
	 * @param targetX X position of where the projectile is being moved to
	 * @param targetY Y position of where the projectile is being moved to
	 * @param targetZ Z position of where the projectile is being moved to
	 * @param cycle
	 */
	@Inject
	@MethodHook("moveProjectile")
	public void projectileMoved(int targetX, int targetY, int targetZ, int cycle)
	{
		final LocalPoint position = new LocalPoint(targetX, targetY);
		final ProjectileMoved projectileMoved = new ProjectileMoved();
		projectileMoved.setProjectile(this);
		projectileMoved.setPosition(position);
		projectileMoved.setZ(targetZ);
		client.getCallbacks().post(projectileMoved);
	}
}
