package net.runelite.client.plugins.ping;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.ping.ping.Ping;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.http.api.worlds.WorldResult;
import java.io.IOException;
import java.util.Comparator;
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
	private static final int WORLD_FETCH_TIMER = 600;
	private static final int WORLD_PING_TIMER = 60;

	private ScheduledFuture<?> worldResultFuture, pingFuture;
	private WorldResult worldResult;

	private int currentPing;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PingOverlay overlay;

	@Inject
	private ScheduledExecutorService executorService;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);

		worldResultFuture = executorService.scheduleAtFixedRate(this::fetchWorlds, 0, WORLD_FETCH_TIMER, TimeUnit.SECONDS);
		pingFuture = executorService.scheduleAtFixedRate(this::pingWorld, 0, WORLD_PING_TIMER, TimeUnit.SECONDS);
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
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			pingFuture.cancel(true);
			worldResultFuture.cancel(true);
			return;
		}

		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			worldResultFuture = executorService.scheduleAtFixedRate(this::fetchWorlds, 0, WORLD_FETCH_TIMER, TimeUnit.SECONDS);
			pingFuture = executorService.scheduleAtFixedRate(this::pingWorld, 0, WORLD_PING_TIMER, TimeUnit.SECONDS);
		}
	}

	public int getCurrentPing()
	{
		return currentPing;
	}

	private void fetchWorlds()
	{
		try
		{
			worldResult = new WorldClient().lookupWorlds();

			if (worldResult != null)
			{
				worldResult.getWorlds().sort(Comparator.comparingInt(World::getId));
			}
		}
		catch (IOException ex)
		{
			log.warn("Error looking up worlds", ex);
		}
	}

	private void pingWorld()
	{
		if (worldResult == null)
		{
			return;
		}

		World currentWorld = worldResult.findWorld(client.getWorld());
		currentPing = Ping.ping(currentWorld);
	}
}
