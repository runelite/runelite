package net.runelite.client.plugins.safespot;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "1 Way PVP Safe Spots",
	description = "Renders tile overlays for one way safe spots",
	tags = {"safe spot", "pvp", "safespots", "npc", "pklite"},
	enabledByDefault = false,
	type = PluginType.UTILITY
)
public class SafeSpotPlugin extends Plugin
{

	@Inject
	private Client client;
	@Inject
	OverlayManager overlayManager;
	@Inject
	private SafeSpotConfig config;

	@Getter
	private ArrayList<Tile> safeSpotList;
	@Getter
	private boolean safeSpotsRenderable = false;

	private SafeSpotOverlay safeSpotOverlay;
	private int tickCount = 0;

	@Provides
	SafeSpotConfig config(ConfigManager configManager)
	{
		return configManager.getConfig(SafeSpotConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		safeSpotOverlay = new SafeSpotOverlay(client, this, config);
		overlayManager.add(safeSpotOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(safeSpotOverlay);
	}

	@Subscribe
	private void onInteractingChanged(InteractingChanged event)
	{
		if (event.getSource() != client.getLocalPlayer())
		{
			return;
		}
		if (event.getTarget() == null && (config.npcSafeSpots() || config.playerSafeSpots()))
		{
			tickCount = 10;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getLocalPlayer().getInteracting() != null)
		{
			if (client.getLocalPlayer().getInteracting() instanceof Player && config.playerSafeSpots())
			{
				safeSpotsRenderable = true;
				updateSafeSpots();
			}
			if (client.getLocalPlayer().getInteracting() instanceof NPC && config.npcSafeSpots())
			{
				safeSpotsRenderable = true;
				updateSafeSpots();
			}
		}
		else
		{
			safeSpotsRenderable = false;
		}
		if (tickCount > 0)
		{
			tickCount--;
			safeSpotsRenderable = true;
		}
	}

	private void updateSafeSpots()
	{
		if (client.getLocalPlayer().getInteracting() != null)
		{
			Actor enemy = client.getLocalPlayer().getInteracting();
			WorldArea worldArea = new WorldArea(enemy.getWorldLocation().getX() - 12,
				enemy.getWorldLocation().getY() - 12, 24, 24, client.getPlane());
			List<WorldPoint> worldPoints = worldArea.toWorldPointList();
			safeSpotList = getSafeSpotList(enemy, worldPoints);
		}
	}


	private ArrayList<Tile> getSafeSpotList(Actor actor, List<WorldPoint> worldPoints)
	{
		ArrayList<Tile> safeSpotList = new ArrayList<>();
		Tile[][][] tiles = client.getScene().getTiles();
		for (WorldPoint w:worldPoints)
		{
			LocalPoint toPoint = LocalPoint.fromWorld(client, w);
			Tile fromTile = tiles[client.getPlane()][actor.getLocalLocation().getSceneX()]
				[actor.getLocalLocation().getSceneY()];
			Tile toTile = tiles[client.getPlane()][toPoint.getSceneX()]
				[toPoint.getSceneY()];
			if (toTile.hasLineOfSightTo(fromTile) && !fromTile.hasLineOfSightTo(toTile))
			{
				safeSpotList.add(toTile);
			}
		}
		return safeSpotList;
	}
}
