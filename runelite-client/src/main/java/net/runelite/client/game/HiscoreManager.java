package net.runelite.client.game;

import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreResult;

import javax.inject.Inject;
import javax.inject.Singleton;
//import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Singleton
@Slf4j
public class HiscoreManager
{

	private final Client client;
	private final ScheduledExecutorService scheduledExecutorService;
	private final ClientThread clientThread;

	/**
	 * not yet looked up
	 */
	static final HiscoreResult EMPTY = new HiscoreResult();

	/**
	 * has no hiscore
	 */
	static final HiscoreResult NONE = new HiscoreResult();

	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private final LoadingCache<String, HiscoreResult> hiscoreLookupCache;

	@Inject
	public HiscoreManager(Client client, ScheduledExecutorService executor, ClientThread clientThread)
	{
		this.client = client;
		this.scheduledExecutorService = executor;
		this.clientThread = clientThread;




		hiscoreLookupCache = CacheBuilder.newBuilder()
				.maximumSize(128L)
				.expireAfterAccess(1, TimeUnit.HOURS)
				.build(new HiscoreLoader(client, executor, hiscoreClient));
	}

	public HiscoreResult lookupUsername(String username) throws ExecutionException
	{
		return hiscoreLookupCache.get(username);
	}

	public HiscoreResult lookupUsernameAsync(String username)
	{
		HiscoreResult hiscore = hiscoreLookupCache.getIfPresent(username);

		if (hiscore != null && hiscore != EMPTY)
		{
			return hiscore == NONE ? null : hiscore;
		}
		hiscoreLookupCache.refresh(username);
		return null;
	}
}
