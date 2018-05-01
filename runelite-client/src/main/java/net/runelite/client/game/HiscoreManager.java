package net.runelite.client.game;

import com.google.common.base.Strings;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreEndpoint;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Singleton
@Slf4j
public class HiscoreManager
{

	static final HiscoreResult EMPTY = new HiscoreResult();
	static final HiscoreResult NONE = new HiscoreResult();

	private final Client client;
	private final ScheduledExecutorService scheduledExecutorService;
	private final ClientThread clientThread;

	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private final Map<HiscoreEndpoint, LoadingCache<String, HiscoreResult>> hiscores = new HashMap<>();

	@Inject
	public HiscoreManager(Client client, ScheduledExecutorService executor, ClientThread clientThread)
	{
		this.client = client;
		this.scheduledExecutorService = executor;
		this.clientThread = clientThread;

		for (HiscoreEndpoint endpoint : HiscoreEndpoint.values())
		{
			hiscores.put(endpoint, CacheBuilder.newBuilder()
					.maximumSize(128L)
					.expireAfterAccess(1, TimeUnit.HOURS)
					.build(new HiscoreLoader(executor, hiscoreClient, endpoint)));
		}
	}

	/**
	 * Synchronously look up a players hiscore from a specified endpoint
	 *
	 * @param username Players username
	 * @param endpoint Hiscore endpoint
	 * @throws IOException Upon error in fetching hiscore
	 * @return HiscoreResult or null
	 */
	public HiscoreResult lookupUsername(String username, HiscoreEndpoint endpoint) throws IOException
	{
		if (!Strings.isNullOrEmpty(username) && endpoint != null)
		{
			LoadingCache<String, HiscoreResult> cache = hiscores.get(endpoint);
			HiscoreResult result = cache.getIfPresent(username);

			if (result != null && result != EMPTY)
			{
				return result == NONE ? null : result;
			}
			result = hiscoreClient.lookup(username, endpoint);
			return result;
		}
		return null;
	}

	/**
	 * Asynchronously look up a players hiscore from a specified endpoint
	 *
	 * @param username Players username
	 * @param endpoint Hiscore endpoint
	 * @return HiscoreResult or null
	 */
	public HiscoreResult lookupUsernameAsync(String username, HiscoreEndpoint endpoint)
	{
		if (!Strings.isNullOrEmpty(username) && endpoint != null)
		{
			LoadingCache<String, HiscoreResult> cache = hiscores.get(endpoint);

			final HiscoreResult hiscore = cache.getIfPresent(username);

			if (hiscore != null && hiscore != EMPTY)
			{
				return hiscore == NONE ? null : hiscore;
			}

			cache.refresh(username);
		}

		return null;
	}
}
