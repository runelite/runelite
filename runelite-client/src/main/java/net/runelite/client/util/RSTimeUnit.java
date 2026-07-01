/*
 * Copyright (c) 2020, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.util;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import lombok.Getter;
import net.runelite.api.Constants;

@Getter
public enum RSTimeUnit implements TemporalUnit
{
	CLIENT_TICKS("Client tick", Duration.ofMillis(Constants.CLIENT_TICK_LENGTH)),
	GAME_TICKS("Game tick", Duration.ofMillis(Constants.GAME_TICK_LENGTH)),
	;

	private final String name;
	private final Duration duration;

	RSTimeUnit(String name, Duration estimatedDuration)
	{
		this.name = name;
		duration = estimatedDuration;
	}

	@Override
	public boolean isDurationEstimated()
	{
		return false;
	}

	@Override
	public boolean isDateBased()
	{
		return false;
	}

	@Override
	public boolean isTimeBased()
	{
		return true;
	}

	@Override
	public boolean isSupportedBy(Temporal temporal)
	{
		return temporal.isSupported(this);
	}

	@Override
	public <R extends Temporal> R addTo(R temporal, long amount)
	{
		return (R) temporal.plus(amount, this);
	}

	@Override
	public long between(Temporal temporal1Inclusive, Temporal temporal2Exclusive)
	{
		return temporal1Inclusive.until(temporal2Exclusive, this);
	}

	@Override
	public String toString()
	{
		return name + " (" + duration.toMillis() + "ms)";
	}
}
