package net.runelite.client.plugins.spawntimer;

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import java.util.*;

@PluginDescriptor(
		name = "Spawn Timer",
		description = "Shows NPC'S time since spawned",
		tags = {"highlight", "minimap", "npcs", "overlay", "spawn", "tags", "lyzrd"},
		type = PluginType.PVM,
		enabledByDefault = false
)

public class SpawnTimerPlugin extends Plugin 
{
	@Inject
	private OverlayManager overlayManager;



	@Getter(AccessLevel.PACKAGE)
	private final Set<NPC> highlightedNpcs = new HashSet<>();

	@Getter(AccessLevel.PACKAGE)
	Set<thing> ticks = new HashSet<>();

	@Inject
	private SpawnTimerOverlay SpawnTimerOverlay;

	@Inject
	private Client client;

	@Inject
	private SpawnTimerConfig config;

	@Provides
	SpawnTimerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SpawnTimerConfig.class);
	}

	@Getter(AccessLevel.PACKAGE)
	public int currentTick;
	@Override
	protected void startUp() throws Exception
	{
		currentTick = 0;
		overlayManager.add(SpawnTimerOverlay);
	}


	@Override
	protected void shutDown() throws Exception
	{
		ticks.clear();
		highlightedNpcs.clear();
		overlayManager.remove(SpawnTimerOverlay);
	}

	@Subscribe
	public void onGameTick(GameTick g)
	{
		currentTick++;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN ||
				event.getGameState() == GameState.HOPPING)
		{
			highlightedNpcs.clear();
			ticks.clear();
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned n)
	{
		if (n.getNpc() != null)
		{
			final NPC npc = n.getNpc();
			highlightedNpcs.add(npc);
			thing temp = new thing();
			temp.setNpc(npc);
			temp.setTick(currentTick);
			ticks.add(temp);
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned n)
	{
		final NPC npc = n.getNpc();
		if (highlightedNpcs.contains(npc))
		{
			highlightedNpcs.remove(npc);
			for (Iterator<thing> iterator = ticks.iterator(); iterator.hasNext();)
			{
				thing t =  iterator.next();
				if (t.getNpc() == npc) 
				{
					iterator.remove();
				}
				//currentTick = 0;
			}
		}
	}
	@VisibleForTesting
	public List<String> getHighlights()
	{
		final String configNpcs = config.getNpcToHighlight().toLowerCase();

		if (configNpcs.isEmpty())
		{
			return Collections.emptyList();
		}

		return Text.fromCSV(configNpcs);
	}
}