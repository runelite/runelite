package net.runelite.client.game;

import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.client.game.HiscoreManager.EMPTY;
import static net.runelite.client.game.HiscoreManager.NONE;

import net.runelite.api.Client;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.plugins.xptracker.XpWorldType;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreEndpoint;

@Slf4j
public class HiscoreLoader extends CacheLoader<String, HiscoreResult>
{
	private final Client client;
	private final ListeningExecutorService executorService;
	private final HiscoreClient hiscoreClient;
	private final XpTrackerPlugin xpTrackerPlugin = new XpTrackerPlugin();

	HiscoreLoader(Client client, ScheduledExecutorService executor, HiscoreClient hiscoreClient)
	{
		this.executorService = MoreExecutors.listeningDecorator(executor);
		this.client = client;
		this.hiscoreClient = hiscoreClient;

		try
		{
			xpTrackerPlugin.startUp_backend();
		}
		catch (Exception ex)
		{
			log.debug("could not start up plugin");
		}
	}

	@Override
	public HiscoreResult load(String username) throws Exception
	{
		// guava's Cache doesn't support null values
		return EMPTY;
	}

	@Override
	public ListenableFuture<HiscoreResult> reload(String username, HiscoreResult oldValue)
	{
		log.debug("Submitting lookup for item {}", username);

		return executorService.submit(() -> fetch(username));
	}

	private HiscoreResult fetch(String username)
	{
		HiscoreEndpoint hiscoreEndpoint;
		try
		{
			int worldNum = client.getWorld();
			XpWorldType worldType = xpTrackerPlugin.getWorldType(worldNum);

			switch (worldType)
			{
				case NORMAL:  hiscoreEndpoint = HiscoreEndpoint.NORMAL;
					break;
				case DMM:  hiscoreEndpoint = HiscoreEndpoint.DEADMAN;
					break;
				case SDMM:  hiscoreEndpoint = HiscoreEndpoint.SEASONAL_DEADMAN;
					break;
				default: hiscoreEndpoint = HiscoreEndpoint.NORMAL;
					break;
			}

			log.debug("Hiscore endpoint " + hiscoreEndpoint.name() + " selected");
		}
		catch (Exception ex)
		{
			hiscoreEndpoint = HiscoreEndpoint.NORMAL;
			log.debug("could not start up plugin");
		}

		try
		{
			HiscoreResult hiscoreResult = hiscoreClient.lookup(username, hiscoreEndpoint);
			if (hiscoreResult == null)
			{
				return NONE;
			}
			return hiscoreResult;
		}
		catch (IOException ex)
		{
			log.warn("unable to look up item!", ex);
			return NONE;
		}
	}
};
