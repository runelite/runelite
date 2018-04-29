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
	public HiscoreResult load(String s)
	{
		return EMPTY;
	}

	@Override
	public ListenableFuture<HiscoreResult> reload(String key, HiscoreResult oldValue)
	{
		log.debug("Submitting hiscore lookup for player {}", key);
		return executorService.submit(() ->
		{
			HiscoreResult result = null;
			try
			{
				result = hiscoreClient.lookup(key, endpoint);
			}
			catch (IOException e)
			{
				log.warn("Unable to look up hiscore!", e);
			}
			return result == null ? NONE : result;
		});
	}


}
