/*
 * Copyright (c) 2020 ThatGamerBlue
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
package net.runelite.client.plugins.freezetimersv2;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Slf4j
@Singleton
public class TimerManager
{
	@Inject
	private FreezeTimersV2Plugin plugin;
	private HashMap<Actor, HashMap<TimerType, Timer>> timerMap = new HashMap<>();

	private HashMap<TimerType, Timer> getTimersFor(Actor actor)
	{
		if (!timerMap.containsKey(actor) || timerMap.get(actor) == null)
		{
			timerMap.put(actor, new HashMap<>());
		}
		return timerMap.get(actor);
	}

	public boolean isTimerValid(Actor actor, TimerType type)
	{
		return getTimerFor(actor, type).isValid();
	}

	public boolean hasTimerActive(Actor actor, TimerType type)
	{
		return getTimerFor(actor, type).getTimerState() != Timer.TimerState.INACTIVE;
	}

	public Timer getTimerFor(Actor actor, TimerType type)
	{
		if (getTimersFor(actor).get(type) == null)
		{
			getTimersFor(actor).put(type, new Timer(plugin, null));
		}
		return getTimersFor(actor).get(type);
	}

	public void setTimerFor(Actor actor, TimerType type, Timer timer)
	{
		timer.setTimerTypeIfNull(type);
		getTimersFor(actor).put(type, timer);
	}

	// TODO: test me
	public void jumpToCooldown(Actor actor, TimerType type)
	{
		Timer timer = getTimerFor(actor, type);
		timer.setStartMillis(System.currentTimeMillis());
		timer.setTicksStart(plugin.getClient().getTickCount());
		timer.setTicksLength(0);
	}

}
