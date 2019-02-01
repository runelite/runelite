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

import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
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
	private static final int TRAWLER_SHIP_REGION_NORMAL = 7499;
	private static final int TRAWLER_SHIP_REGION_SINKING = 8011;

	private static final int TRAWLER_ACTIVITY_THRESHOLD = Math.round(0.15f * 255);

	@Getter(AccessLevel.PACKAGE)
	private final FishingSession session = new FishingSession();

	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, MinnowSpot> minnowSpots = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private NPC[] fishingSpots;

	@Getter(AccessLevel.PACKAGE)
	private FishingSpot currentSpot;

	@Inject
	private Client client;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private Notifier notifier;

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

	private boolean trawlerNotificationSent;

	@Provides
	FishingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FishingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(spotOverlay);
		overlayManager.add(fishingSpotMinimapOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		spotOverlay.setHidden(true);
		fishingSpotMinimapOverlay.setHidden(true);
		overlayManager.remove(overlay);
		overlayManager.remove(spotOverlay);
		overlayManager.remove(fishingSpotMinimapOverlay);
		minnowSpots.clear();
		trawlerNotificationSent = false;
		currentSpot = null;
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY)
			&& event.getItemContainer() != client.getItemContainer(InventoryID.EQUIPMENT))
		{
			return;
		}

		final boolean showOverlays = session.getLastFishCaught() != null
			|| canPlayerFish(client.getItemContainer(InventoryID.INVENTORY))
			|| canPlayerFish(client.getItemContainer(InventoryID.EQUIPMENT));

		if (!showOverlays)
		{
			currentSpot = null;
		}

		spotOverlay.setHidden(!showOverlays);
		fishingSpotMinimapOverlay.setHidden(!showOverlays);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		if (event.getMessage().contains("You catch a") || event.getMessage().contains("You catch some") ||
			event.getMessage().equals("Your cormorant returns with its catch."))
		{
			session.setLastFishCaught(Instant.now());
			spotOverlay.setHidden(false);
			fishingSpotMinimapOverlay.setHidden(false);
		}
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		if (event.getSource() != client.getLocalPlayer())
		{
			return;
		}

		final Actor target = event.getTarget();

		if (!(target instanceof NPC))
		{
			return;
		}

		final NPC npc = (NPC) target;
		FishingSpot spot = FishingSpot.getSPOTS().get(npc.getId());

		if (spot == null)
		{
			return;
		}

		currentSpot = spot;
	}

	private boolean canPlayerFish(final ItemContainer itemContainer)
	{
		if (itemContainer == null)
		{
			return false;
		}

		for (Item item : itemContainer.getItems())
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
				case ItemID.CORMORANTS_GLOVE:
				case ItemID.CORMORANTS_GLOVE_22817:
					return true;
			}
		}

		return false;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		// Reset fishing session
		if (session.getLastFishCaught() != null)
		{
			final Duration statTimeout = Duration.ofMinutes(config.statTimeout());
			final Duration sinceCaught = Duration.between(session.getLastFishCaught(), Instant.now());

			if (sinceCaught.compareTo(statTimeout) >= 0)
			{
				currentSpot = null;
				session.setLastFishCaught(null);
			}
		}

		final LocalPoint cameraPoint = new LocalPoint(client.getCameraX(), client.getCameraY());

		final NPCQuery query = new NPCQuery()
			.idEquals(Ints.toArray(FishingSpot.getSPOTS().keySet()));
		NPC[] spots = queryRunner.runQuery(query);
		// -1 to make closer things draw last (on top of farther things)
		Arrays.sort(spots, Comparator.comparing(npc -> -1 * npc.getLocalLocation().distanceTo(cameraPoint)));
		fishingSpots = spots;

		// process minnows
		for (NPC npc : spots)
		{
			FishingSpot spot = FishingSpot.getSPOTS().get(npc.getId());

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

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (!config.trawlerNotification() || client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();

		if ((regionID == TRAWLER_SHIP_REGION_NORMAL || regionID == TRAWLER_SHIP_REGION_SINKING)
			&& client.getVar(Varbits.FISHING_TRAWLER_ACTIVITY) <= TRAWLER_ACTIVITY_THRESHOLD)
		{
			if (!trawlerNotificationSent)
			{
				notifier.notify("[" + client.getLocalPlayer().getName() + "] has low Fishing Trawler activity!");
				trawlerNotificationSent = true;
			}
		}
		else
		{
			trawlerNotificationSent = false;
		}
	}
}
