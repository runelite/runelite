package net.runelite.client.game;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.plugins.xptracker.XpWorldType;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
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
	 * has no hiscore
	 */
	static final HiscoreResult NONE = new HiscoreResult();

	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private final LoadingCache<String, HiscoreResult> hiscoreLookupCache;
	private final XpTrackerPlugin xpTrackerPlugin = new XpTrackerPlugin();

	@Inject
	public HiscoreManager(Client client, ScheduledExecutorService executor, ClientThread clientThread)
	{
		this.client = client;
		this.scheduledExecutorService = executor;
		this.clientThread = clientThread;

		try
		{
			xpTrackerPlugin.startUp_backend();
		}
		catch (Exception ex)
		{
			log.debug("could not start up plugin");
		}


		hiscoreLookupCache = CacheBuilder.newBuilder()
				.maximumSize(128L)
				.expireAfterAccess(1, TimeUnit.HOURS)
				.build(new CacheLoader<String, HiscoreResult>()
				{
					@Override
					public HiscoreResult load(String username) throws Exception
					{
						try
						{
							int worldNum = client.getWorld();
							XpWorldType worldType = xpTrackerPlugin.getWorldType(worldNum);

							HiscoreEndpoint endpoint;
							switch (worldType)
							{
								case NORMAL:  endpoint = HiscoreEndpoint.NORMAL;
									break;
								case DMM:  endpoint = HiscoreEndpoint.DEADMAN;
									break;
								case SDMM:  endpoint = HiscoreEndpoint.SEASONAL_DEADMAN;
									break;
								default: endpoint = HiscoreEndpoint.NORMAL;
									break;
							}

							log.debug("Hiscore endpoint " + endpoint.name() + " selected");
							HiscoreResult result = hiscoreClient.lookup(username, endpoint);
							return result;
						}
						catch (IOException ex)
						{
							log.warn("Error fetching Hiscore data " + ex.getMessage());
							return NONE;
						}
					}
				});
	}

	public HiscoreResult lookupUsername(String username) throws ExecutionException
	{
		return hiscoreLookupCache.get(username);
	}

	public HiscoreResult lookupUsernameAsync(String username)
	{
		HiscoreResult hiscore = hiscoreLookupCache.getIfPresent(username);

		if (hiscore != null && hiscore != NONE)
		{
			return hiscore;
		}
		hiscoreLookupCache.refresh(username);
		return null;
	}
}
