/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.performancestats;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.http.api.ws.messages.party.PartyMemberMessage;

@Getter(AccessLevel.PACKAGE)
class Performance extends PartyMemberMessage
{
	private static final double TICK_LENGTH = 0.6;

	@Setter(AccessLevel.PACKAGE)
	String username;

	double damageDealt = 0;
	double highestHitDealt = 0;

	double damageTaken = 0;
	double highestHitTaken = 0;

	int lastActivityTick = -1;
	@Setter(AccessLevel.PACKAGE)
	double ticksSpent = 0;

	void addDamageDealt(double a, int currentTick)
	{
		damageDealt += a;
		if (a > highestHitDealt)
		{
			highestHitDealt = a;
		}

		this.lastActivityTick = currentTick;
	}

	void addDamageTaken(double a, int currentTick)
	{
		damageTaken += a;
		if (a > highestHitTaken)
		{
			highestHitTaken = a;
		}

		this.lastActivityTick = currentTick;
	}

	void incrementTicksSpent()
	{
		ticksSpent++;
	}

	void reset()
	{
		damageDealt = 0;
		highestHitDealt = 0;
		damageTaken = 0;
		highestHitTaken = 0;
		lastActivityTick = -1;
		ticksSpent = 0;
	}

	private double getSecondsSpent()
	{
		return Math.round(this.ticksSpent * TICK_LENGTH);
	}

	double getDPS()
	{
		return Math.round((this.damageDealt / this.getSecondsSpent()) * 100) / 100.00;
	}

	String getHumanReadableSecondsSpent()
	{
		final double secondsSpent = getSecondsSpent();
		if (secondsSpent <= 60)
		{
			return String.format("%2.0f", secondsSpent) + "s";
		}

		final double s = secondsSpent % 3600 % 60;
		final double m = Math.floor(secondsSpent % 3600 / 60);
		final double h = Math.floor(secondsSpent / 3600);

		return h < 1 ? String.format("%2.0f:%02.0f", m, s) : String.format("%2.0f:%02.0f:%02.0f", h, m, s);
	}
}
