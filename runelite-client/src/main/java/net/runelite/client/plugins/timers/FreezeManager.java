package net.runelite.client.plugins.timers;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.client.plugins.timers.FreezeInfo;

@Singleton
public class FreezeManager
{
	private final Cache<String, FreezeInfo> freezes = CacheBuilder.newBuilder()
		.maximumSize(200)
		.expireAfterWrite(1, TimeUnit.HOURS)
		.build();


	public void put(Actor actor, GameTimer gameTimer)
	{
		FreezeInfo previousFreezeInfo = freezes.getIfPresent(actor.getName());

		// conditions to skip putting
		// 1. already entry inside
		// AND... Either of the following
		// 2. worldPoint hasnt changed
		// 3. timer hasnt run out
		if (previousFreezeInfo != null)// && (actor.getWorldLocation().equals(previousFreezeInfo.getWorldPoint()) || ))
		{
			return;
		}
		else
		{
			FreezeInfo freezeInfo = new FreezeInfo(gameTimer, actor);
			freezes.put(actor.getName(), freezeInfo);
		}

	}

	public ConcurrentMap<String, FreezeInfo> getFreezeInfo()
	{
		return freezes.asMap();
	}

}

