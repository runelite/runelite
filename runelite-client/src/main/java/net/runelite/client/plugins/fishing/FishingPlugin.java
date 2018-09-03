/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Levi <me@levischuck.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.fishing;

import com.google.common.eventbus.Subscribe;
import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.QueryRunner;

@PluginDescriptor(
	name = "Fishing",
	description = "Show fishing stats and mark fishing spots",
	tags = {"overlay", "skilling"}
)
@PluginDependency(XpTrackerPlugin.class)
@Singleton
@Slf4j
public class FishingPlugin extends Plugin
{
	private final List<Integer> spotIds = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private final FishingSession session = new FishingSession();

	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, MinnowSpot> minnowSpots = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private NPC[] fishingSpots;

	@Inject
	private Client client;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private FishingConfig config;

	@Inject
	private FishingOverlay overlay;

	@Inject
	private FishingSpotOverlay spotOverlay;

	@Inject
	private FishingSpotMinimapOverlay fishingSpotMinimapOverlay;

	@Provides
	FishingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FishingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		updateConfig();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(spotOverlay);
		overlayManager.remove(fishingSpotMinimapOverlay);
		minnowSpots.clear();
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		boolean showOverlays = false;

		if (session.getLastFishCaught() != null)
		{
			showOverlays = true;
		}
		else if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			for (Item item : event.getItemContainer().getItems())
			{
				if (item == null)
				{
					continue;
				}

				switch (item.getId())
				{
					case ItemID.DRAGON_HARPOON:
					case ItemID.INFERNAL_HARPOON:
					case ItemID.INFERNAL_HARPOON_UNCHARGED:
					case ItemID.HARPOON:
					case ItemID.BARBTAIL_HARPOON:
					case ItemID.BIG_FISHING_NET:
					case ItemID.SMALL_FISHING_NET:
					case ItemID.SMALL_FISHING_NET_6209:
					case ItemID.FISHING_ROD:
					case ItemID.FLY_FISHING_ROD:
					case ItemID.BARBARIAN_ROD:
					case ItemID.OILY_FISHING_ROD:
					case ItemID.LOBSTER_POT:
					case ItemID.KARAMBWAN_VESSEL:
					case ItemID.KARAMBWAN_VESSEL_3159:
						showOverlays = true;
						break;
				}
			}
		}
		else if (event.getItemContainer() == client.getItemContainer(InventoryID.EQUIPMENT))
		{
			for (Item item : event.getItemContainer().getItems())
			{
				if (item == null)
				{
					continue;
				}

				switch (item.getId())
				{
					case ItemID.DRAGON_HARPOON:
					case ItemID.INFERNAL_HARPOON:
					case ItemID.INFERNAL_HARPOON_UNCHARGED:
						showOverlays = true;
						break;
				}
			}
		}

		if (showOverlays)
		{
			overlayManager.add(spotOverlay);
			overlayManager.add(fishingSpotMinimapOverlay);
		}
		else
		{
			overlayManager.remove(spotOverlay);
			overlayManager.remove(fishingSpotMinimapOverlay);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		if (event.getMessage().contains("You catch a") || event.getMessage().contains("You catch some"))
		{
			session.setLastFishCaught(Instant.now());
			overlayManager.add(spotOverlay);
			overlayManager.add(fishingSpotMinimapOverlay);
		}
	}

	@Subscribe
	public void updateConfig(ConfigChanged event)
	{
		updateConfig();
	}

	private void updateConfig()
	{
		spotIds.clear();
		if (config.showShrimp())
		{
			spotIds.addAll(Ints.asList(FishingSpot.SHRIMP.getIds()));
		}
		if (config.showLobster())
		{
			spotIds.addAll(Ints.asList(FishingSpot.LOBSTER.getIds()));
		}
		if (config.showShark())
		{
			spotIds.addAll(Ints.asList(FishingSpot.SHARK.getIds()));
		}
		if (config.showMonkfish())
		{
			spotIds.addAll(Ints.asList(FishingSpot.MONKFISH.getIds()));
		}
		if (config.showSalmon())
		{
			spotIds.addAll(Ints.asList(FishingSpot.SALMON.getIds()));
		}
		if (config.showBarb())
		{
			spotIds.addAll(Ints.asList(FishingSpot.BARB_FISH.getIds()));
		}
		if (config.showAngler())
		{
			spotIds.addAll(Ints.asList(FishingSpot.ANGLERFISH.getIds()));
		}
		if (config.showMinnow())
		{
			spotIds.addAll(Ints.asList(FishingSpot.MINNOW.getIds()));
		}
		if (config.showInfernalEel())
		{
			spotIds.addAll(Ints.asList(FishingSpot.INFERNAL_EEL.getIds()));
		}
		if (config.showSacredEel())
		{
			spotIds.addAll(Ints.asList(FishingSpot.SACRED_EEL.getIds()));
		}
		if (config.showCaveEel())
		{
			spotIds.addAll(Ints.asList(FishingSpot.CAVE_EEL.getIds()));
		}
		if (config.showSlimyEel())
		{
			spotIds.addAll(Ints.asList(FishingSpot.SLIMY_EEL.getIds()));
		}
		if (config.showKarambwanji())
		{
			spotIds.addAll(Ints.asList(FishingSpot.KARAMBWANJI.getIds()));
		}
		if (config.showKarambwan())
		{
			spotIds.addAll(Ints.asList(FishingSpot.KARAMBWAN.getIds()));
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		final LocalPoint cameraPoint = new LocalPoint(client.getCameraX(), client.getCameraY());

		final NPCQuery query = new NPCQuery()
			.idEquals(Ints.toArray(spotIds));
		NPC[] spots = queryRunner.runQuery(query);
		// -1 to make closer things draw last (on top of farther things)
		Arrays.sort(spots, Comparator.comparing(npc -> -1 * npc.getLocalLocation().distanceTo(cameraPoint)));
		fishingSpots = spots;

		// process minnows
		for (NPC npc : spots)
		{
			FishingSpot spot = FishingSpot.getSpot(npc.getId());

			if (spot == null)
			{
				continue;
			}

			if (spot == FishingSpot.MINNOW && config.showMinnowOverlay())
			{
				int id = npc.getIndex();
				MinnowSpot minnowSpot = minnowSpots.get(id);
				// create the minnow spot if it doesn't already exist
				if (minnowSpot == null)
				{
					minnowSpots.put(id, new MinnowSpot(npc.getWorldLocation(), Instant.now()));
				}
				// if moved, reset
				else if (!minnowSpot.getLoc().equals(npc.getWorldLocation()))
				{
					minnowSpots.put(id, new MinnowSpot(npc.getWorldLocation(), Instant.now()));
				}
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();
		MinnowSpot minnowSpot = minnowSpots.remove(npc.getIndex());
		if (minnowSpot != null)
		{
			log.debug("Minnow spot {} despawned", npc);
		}
	}
}
