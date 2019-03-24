package net.runelite.client.plugins.masterfarmer;

import com.google.inject.Provides;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Master Farmer",
	description = "Displays helpful information while pickpocketing master farmers",
	tags = {"farm", "master", "farmer"},
	enabledByDefault = false
)
public class MasterFarmerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MasterFarmerOverlay masterfarmeroverlay;

	@Getter(AccessLevel.PACKAGE)
	private Instant lastTickUpdate;

	@Getter(AccessLevel.PACKAGE)
	private final Map<Integer, MasterFarmerNPC> masterFarmers = new HashMap<>();

	@Provides
	MasterFarmerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MasterFarmerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(masterfarmeroverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(masterfarmeroverlay);
		masterFarmers.clear();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		final NPC npc = npcSpawned.getNpc();
		final String npcName = npc.getName();

		if (npcName == null)
		{
			return;
		}

		if (npc.getId() == NpcID.MASTER_FARMER || npc.getId() == NpcID.MASTER_FARMER_3258)
		{
			masterFarmers.putIfAbsent(npc.getIndex(), new MasterFarmerNPC(npc));
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		final NPC npc = npcDespawned.getNpc();
		final String npcName = npc.getName();

		if (npcName == null)
		{
			return;
		}

		if (npc.getId() == NpcID.MASTER_FARMER || npc.getId() == NpcID.MASTER_FARMER_3258)
		{
			masterFarmers.remove(npc.getIndex());
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN ||
			event.getGameState() == GameState.HOPPING)
		{
			masterFarmers.clear();
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		lastTickUpdate = Instant.now();

		for (NPC npc : client.getNpcs())
		{
			final String npcName = npc.getName();

			if (npcName == null)
			{
				continue;
			}

			if (npc.getId() == NpcID.MASTER_FARMER || npc.getId() == NpcID.MASTER_FARMER_3258)
			{
				final MasterFarmerNPC mf = masterFarmers.get(npc.getIndex());

				if (mf == null)
				{
					continue;
				}

				if (mf.getCurrentLocation().getX() != npc.getWorldLocation().getX() || mf.getCurrentLocation().getY() != npc.getWorldLocation().getY())
				{
					mf.setCurrentLocation(npc.getWorldLocation());
					mf.setTimeWithoutMoving(0);
					mf.setStoppedMovingTick(Instant.now());
					mf.setNpc(npc);
				}
				else
				{
					mf.setTimeWithoutMoving(lastTickUpdate.getEpochSecond() - mf.getStoppedMovingTick().getEpochSecond());
				}
				continue;
			}
		}
	}
}
