package net.runelite.client.plugins.raids.shortcuts;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Raid Shortcuts",
	description = "Highlights Raid Shortcuts",
	tags = {"boulder", "cox", "raids", "highlight"}
)
@Slf4j
public class ShortcutPlugin extends Plugin
{
	private final List<TileObject> shortcut = new ArrayList<>();
	@Inject
	private Client client;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private ShortcutOverlay overlay;

	List<TileObject> getShortcut()
	{
		return shortcut;
	}

	@Provides
	ShortcutConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ShortcutConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, event.getGameObject().getLocalLocation());
		if (worldPoint == null)
		{
			return;
		}
		if ((event.getGameObject().getId() == 29740) || (event.getGameObject().getId() == 29736) || (event.getGameObject().getId() == 29738))
		{
			shortcut.add(event.getGameObject());
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		shortcut.remove(event.getGameObject());
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (shortcut == null)
		{
			return;
		}
		Iterator<TileObject> it = shortcut.iterator();
		while (it.hasNext())
		{
			TileObject object = it.next();
			if (object.getCanvasLocation() == null)
			{
				it.remove();
			}
		}
	}
}
