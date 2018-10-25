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
package net.runelite.client.plugins.theatreofblood.data;

import java.util.List;
import lombok.Getter;

@Getter
public class AttemptTotal
{
	private int attempts;
	private int completions;
	private int deathCount;
	private int damageTaken;
	private double damageDealt;

	public AttemptTotal(List<Attempt> attemptList)
	{
		this.attempts = attemptList.size();
		for (Attempt a : attemptList)
		{
			if (a.isCompleted())
			{
				this.completions++;
			}
			this.deathCount += a.getDeathCount();
			this.damageTaken += a.getDamageTaken();
			this.damageDealt += a.getDamageDealt();
		}
	}

	@Override
	public String toString()
	{
		return "AttemptTotal(attempts=" + attempts
			+ ",completions=" + completions
			+ ",deathCount=" + deathCount
			+ ",damageTaken=" + damageTaken
			+ ",damageDealt=" + damageDealt
			+ ")";
	}

	public void addAttempt(Attempt a)
	{
		if (a == null)
		{
			return;
		}

		this.attempts++;
		this.completions += (a.isCompleted() ? 1 : 0);
		this.deathCount += a.getDeathCount();
		this.damageTaken += a.getDamageTaken();
		this.damageDealt += a.getDamageDealt();
	}
}
