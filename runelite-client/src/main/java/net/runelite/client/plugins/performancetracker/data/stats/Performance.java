/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.performancetracker.data.stats;

import lombok.Getter;

@Getter
public class Performance
{
	private double damageTaken = 0;
	private double damageDealt = 0;
	private double secondsSpent = 0;
	private int deathCount = 0;

	private double highestHitDealt;
	private double highestHitTaken;

	public void addDeath()
	{
		this.deathCount++;
	}

	public void addDamageTaken(double a)
	{
		this.damageTaken += a;
		if (a > highestHitTaken)
		{
			highestHitTaken = a;
		}
	}

	public void addDamageDealt(double a)
	{
		this.damageDealt += a;
		if (a > highestHitDealt)
		{
			highestHitDealt = a;
		}
	}

	public void incrementSeconds()
	{
		this.secondsSpent++;
	}

	@Override
	public String toString()
	{
		return "Performance(damageTaken=" + damageTaken
			+ ",damageDealt=" + damageDealt
			+ ",secondsSpent=" + secondsSpent
			+ ",deathCount=" + deathCount
			+ ",highestHitDealt=" + highestHitDealt
			+ ",highestHitTaken=" + highestHitTaken
			+ ")";
	}
}
