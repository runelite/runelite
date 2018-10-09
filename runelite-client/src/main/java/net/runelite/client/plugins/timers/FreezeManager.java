package net.runelite.client.plugins.timers;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import net.runelite.api.Actor;
import net.runelite.client.plugins.timers.FreezeInfo;

public class FreezeManager
{
	private final Cache<String, FreezeInfo> freezes = CacheBuilder.newBuilder()
		.maximumSize(100)
		.expireAfterWrite(1, TimeUnit.HOURS)
		.build();

	public void put(Actor actor, GameTimer gameTimer)
	{
		// TODO: create FreezeInfo from GameTimer
		FreezeInfo freezeInfo = new FreezeInfo(gameTimer, actor.getWorldLocation());
		freezes.put(actor.getName(), freezeInfo);
	}

}

