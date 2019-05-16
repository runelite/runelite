package net.runelite.client.plugins.ping;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.ping.ping.Ping;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ExecutorServiceExceptionLogger;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.http.api.worlds.WorldResult;
import java.io.IOException;
import java.time.Duration;
import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@PluginDescriptor(
	name = "Ping",
	description = "Show current world ping",
	tags = {"Ping", "overlay"},
	enabledByDefault = false
)

@Slf4j
public class PingPlugin extends Plugin
{
	private static final int WORLD_FETCH_TIMER = 10;
	private static final int WORLD_PING_TIMER = 1;
	private static final int TICK_THROTTLE = (int) Duration.ofMinutes(10).toMillis();

	private ScheduledFuture<?> worldResultFuture, pingFuture;
	private WorldResult worldResult;

	private boolean firstRun;

	private int currentPing;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PingOverlay overlay;

	@Inject
	private ScheduledExecutorService executorService;

	private ScheduledExecutorService pingExecutorService;

	@Override
	protected void startUp() throws Exception
	{
		firstRun = true;

		overlayManager.add(overlay);

		worldResultFuture = executorService.scheduleAtFixedRate(this::fetchWorlds, 0, 10, TimeUnit.SECONDS);

		pingExecutorService = new ExecutorServiceExceptionLogger(Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors()));
		pingFuture = pingExecutorService.scheduleAtFixedRate(this::pingWorld, 5, 10, TimeUnit.SECONDS);

	}

	@Override
	protected void shutDown() throws Exception
	{
		pingFuture.cancel(true);
		pingFuture = null;

		overlayManager.remove(overlay);

		worldResultFuture.cancel(true);
		worldResultFuture = null;
		worldResult = null;

		pingExecutorService.shutdown();
		pingExecutorService = null;
	}

	public int getCurrentPing()
	{
		return currentPing;
	}

	private void fetchWorlds()
	{
		log.warn("fetchWorlds()");
		try
		{
			worldResult = new WorldClient().lookupWorlds();
			log.debug("world result {}", worldResult);

			if (worldResult != null)
			{
				worldResult.getWorlds().sort(Comparator.comparingInt(World::getId));
				//worldResult.getWorlds();
				this.worldResult = worldResult;
			}
		}
		catch (IOException ex)
		{
			log.warn("Error looking up worlds", ex);
		}
	}

	protected void pingWorld()
	{
		log.warn("pingWorld()");
		//log.warn("worldresult {}", worldResult);
		log.warn("getworld {}", client.getWorld());

		if (worldResult == null || client.getWorld() == 0 || client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		World currentWorld = worldResult.findWorld(client.getWorld());
		currentPing = Ping.ping(currentWorld);

		log.debug("ping {}", currentPing);
		//log.debug("Done pinging worlds in {}", stopwatch.elapsed());

		//return String.valueOf(currentPing);
	}
}
