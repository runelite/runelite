/*
 * Copyright (c) 2019, pklite <https://github.com/pklite/pklite>
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
package net.runelite.client.plugins.freezetimers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;

@Slf4j
@Singleton
public class Timers
{
	private final Map<Actor, HashMap<TimerType, Long>> timerMap = new HashMap<>();

	void setTimerEnd(Actor actor, TimerType type, long n)
	{
		if (!timerMap.containsKey(actor))
		{
			timerMap.put(actor, new HashMap<>());
		}

		timerMap.get(actor).put(type, n + type.getImmunityTime());
	}

	void setTimerReApply(Actor actor, TimerType type, long n)
	{
		if (!timerMap.containsKey(actor))
		{
			timerMap.put(actor, new HashMap<>());
		}

		timerMap.get(actor).put(type, n);
	}

	long getTimerEnd(Actor actor, TimerType type)
	{
		if (!timerMap.containsKey(actor))
		{
			return 0;
		}

		return timerMap.get(actor).getOrDefault(type, (long) type.getImmunityTime()) - type.getImmunityTime();
	}

	long getTimerReApply(Actor actor, TimerType type)
	{
		if (!timerMap.containsKey(actor))
		{
			return 0;
		}

		return timerMap.get(actor).getOrDefault(type, (long) 0);
	}

	List<Actor> getAllActorsOnTimer(TimerType type)
	{
		final List<Actor> actors = new ArrayList<>();
		final Iterator<Actor> it = timerMap.keySet().iterator();

		while (it.hasNext())
		{
			final Actor actor = it.next();

			for (TimerType timerType : TimerType.values())
			{
				if (getTimerReApply(actor, timerType) > System.currentTimeMillis())
				{
					break;
				}
				it.remove();
				break;
			}

			final long end = getTimerReApply(actor, type);

			if (end > System.currentTimeMillis())
			{
				actors.add(actor);
			}
		}

		return actors;
	}

	boolean areAllTimersZero(Actor actor)
	{
		for (TimerType type : TimerType.values())
		{
			if (getTimerReApply(actor, type) > System.currentTimeMillis())
			{
				return false;
			}
		}
		return true;
	}
}
