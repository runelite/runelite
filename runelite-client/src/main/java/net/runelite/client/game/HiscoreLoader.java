package net.runelite.client.game;

import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;

import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;

import static net.runelite.client.game.HiscoreManager.EMPTY;
import static net.runelite.client.game.HiscoreManager.NONE;

@Slf4j
class HiscoreLoader extends CacheLoader<String, HiscoreResult>
{
	private final ListeningExecutorService executorService;
	private final HiscoreClient hiscoreClient;
	private final HiscoreEndpoint endpoint;

	HiscoreLoader(ScheduledExecutorService executor, HiscoreClient client, HiscoreEndpoint endpoint)
	{
		this.executorService = MoreExecutors.listeningDecorator(executor);
		this.hiscoreClient = client;
		this.endpoint = endpoint;
	}

	@Override
	public HiscoreResult load(String s) throws Exception
	{
		return EMPTY;
	}

	@Override
	public ListenableFuture<HiscoreResult> reload(String key, HiscoreResult oldValue)
	{
		log.debug("Submitting lookup for item {}", key);

		return executorService.submit(() -> fetch(key));
	}

	private HiscoreResult fetch(String key)
	{
		try
		{
			HiscoreResult result = hiscoreClient.lookup(key, endpoint);
			if (result == null)
			{
				return NONE;
			}
			return result;
		}
		catch (IOException ex)
		{
			log.warn("Unable to look up hiscore!", ex);
			return NONE;
		}
	}

}

