package net.runelite.client.plugins.thieving;

import com.google.inject.Provides;
import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Thieving",
	description = "Show the state of your plundered chests",
	tags = {"overlay", "skilling", "timers"}
)
public class ThievingPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ChestOverlay overlay;

	private static final HashMap<WorldPoint, ThievableChest> timedChests = new HashMap<>();

	@Getter
	private static final HashMap<WorldPoint, ThievableChest.ActiveChest> activeChests = new HashMap<>();

	@Override
	protected void startUp() throws Exception
	{
		initMaps();
		overlayManager.add(overlay);
		overlay.updateConfig();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		final GameObject gameObject = event.getGameObject();

		ThievableChest chest = timedChests.get(gameObject.getWorldLocation());
		if (chest != null)
		{
			switch (gameObject.getId())
			{
				case 11740:
				case 11741:
					ThievableChest.ActiveChest oldChestInfo = activeChests.put(gameObject.getWorldLocation(), new ThievableChest.ActiveChest(Instant.now(), chest.getResetTime(), gameObject, gameObject.getWorldLocation().getRegionID(), chest.getChestIcon(), ThievableChest.ActiveChest.State.PLUNDERED));
					log.debug("Added chest to active chest collection, {} total", activeChests.size());
					// If we are adding a new plundered chest, but there already exists a timer, it is most likely we have added the same chest
					if (oldChestInfo != null && oldChestInfo.getState() == ThievableChest.ActiveChest.State.PLUNDERED)
					{
						activeChests.put(gameObject.getWorldLocation(), oldChestInfo);
						log.info("Re-added old chest to active chest collection, {} total", activeChests.size());
					}
					break;
				case 11743:
					activeChests.put(gameObject.getWorldLocation(), new ThievableChest.ActiveChest(Instant.now(), chest.getResetTime(), gameObject, gameObject.getWorldLocation().getRegionID(), chest.getChestIcon(), ThievableChest.ActiveChest.State.TRANS));
					log.debug("Added chest to active chest collection, {} total", activeChests.size());
					break;
				default:
					activeChests.put(gameObject.getWorldLocation(), new ThievableChest.ActiveChest(Instant.now(), chest.getResetTime(), gameObject, gameObject.getWorldLocation().getRegionID(), chest.getChestIcon(), ThievableChest.ActiveChest.State.READY));
					log.debug("Added chest to active chest collection, {} total", activeChests.size());
					break;

			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		// Check if all chests are still there, and remove the ones that are not.
		Iterator<Map.Entry<WorldPoint, ThievableChest.ActiveChest>> it = activeChests.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry<WorldPoint, ThievableChest.ActiveChest> entry = it.next();
			ThievableChest.ActiveChest chest = entry.getValue();
			WorldPoint world = entry.getKey();
			LocalPoint local = LocalPoint.fromWorld(client, world);

			Instant expire = Instant.now();
			if (chest.getTimerDuration() != null)
			{
				expire = Instant.now().minus(chest.getTimerDuration().multipliedBy(2));
			}

			// Not within the client's viewport
			if (local == null)
			{
				// Cull very old chests
				if (chest.getStartTime().isBefore(expire))
				{
					log.debug("Chest removed from active chest collection due to timeout, {} left", activeChests.size());
					it.remove();
				}
			}
		}
	}

	/**
	 * initMaps pulls the array of tracked chests and adds them to the relevant HashMap
	 */
	public void initMaps()
	{
		for (ThievableChest chest : ThievableChest.trackedChests)
		{
			timedChests.put(chest.getLocation(), chest);
		}
	}

	@Provides
	ThievingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ThievingConfig.class);
	}


}
