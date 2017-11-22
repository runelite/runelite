/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.events;

import net.runelite.api.Projectile;

public class ProjectileMoved
{
	private Projectile projectile;
	private int targetX;
	private int targetY;
	private int targetZ;
	private int cycle;

	public ProjectileMoved(Projectile projectile, int targetX, int targetY, int targetZ, int cycle)
	{
		this.projectile = projectile;
		this.targetX = targetX;
		this.targetY = targetY;
		this.targetZ = targetZ;
		this.cycle = cycle;
	}

	public Projectile getProjectile()
	{
		return projectile;
	}

	public void setProjectile(Projectile projectile)
	{
		this.projectile = projectile;
	}

	public int getTargetX()
	{
		return targetX;
	}

	public void setTargetX(int targetX)
	{
		this.targetX = targetX;
	}

	public int getTargetY()
	{
		return targetY;
	}

	public void setTargetY(int targetY)
	{
		this.targetY = targetY;
	}

	public int getTargetZ()
	{
		return targetZ;
	}

	public void setTargetZ(int targetZ)
	{
		this.targetZ = targetZ;
	}

	public int getCycle()
	{
		return cycle;
	}

	public void setCycle(int cycle)
	{
		this.cycle = cycle;
	}
}
