package net.runelite.client.plugins.masterfarmer;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import static net.runelite.api.ObjectID.ORE_VEIN_26661;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import static net.runelite.api.ObjectID.ROCKFALL;
import static net.runelite.api.ObjectID.ROCKFALL_26680;
import net.runelite.api.Perspective;
import net.runelite.api.Varbits;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.WildcardMatcher;

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
	private final Map<Integer, MasterFarmerNPC> masterfarmers = new HashMap<>();

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

		if (npc.getId() == 3257)
		{
			//System.out.println("Master Farmer Spawned");
			//System.out.println("ID: " + npc.getId() + "X: " + npc.getWorldLocation().getX() + "Y: " + npc.getWorldLocation().getY());
			MasterFarmer(npc);
			return;
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

			if (npc.getId() == 3257 || npc.getId() == 3258)
			{
				final MasterFarmerNPC mf = masterfarmers.get(npc.getIndex());

				if (mf == null)
				{
					return;
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

	private void MasterFarmer(NPC npc)
	{
		final int npcIndex = npc.getIndex();
		masterfarmers.putIfAbsent(npcIndex, new MasterFarmerNPC(npc));
	}
}
