package net.runelite.client.plugins.freezetimers;

import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;

@Slf4j
@Singleton
public class Timers
{

	@Inject
	private Client client;

	private HashMap<Actor, HashMap<TimerType, Long>> timerMap = new HashMap<>();

	public void gameTick()
	{

	}

	public void setTimerEnd(Actor actor, TimerType type, long n)
	{
		if (!timerMap.containsKey(actor))
		{
			timerMap.put(actor, new HashMap<>());
		}
		timerMap.get(actor).put(type, n);
	}

	public long getTimerEnd(Actor actor, TimerType type)
	{
		if (!timerMap.containsKey(actor))
		{
			timerMap.put(actor, new HashMap<>());
		}
		return timerMap.get(actor).getOrDefault(type, (long) 0);
	}

	public boolean areAllTimersZero(Actor actor)
	{
		for (TimerType type : TimerType.values())
		{
			if (getTimerEnd(actor, type) != 0)
			{
				return false;
			}
		}
		return true;
	}

}
