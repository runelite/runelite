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

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ItemUtil;

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
	private static final int TRAWLER_TIME_LIMIT_IN_SECONDS = 614;
	private static final int TRAWLER_ACTIVITY_THRESHOLD = Math.round(0.15f * 255);

	private Instant trawlerStartTime;

	private static final ImmutableSet<Integer> FISHING_TOOLS = ImmutableSet.of(
		ItemID.DRAGON_HARPOON, ItemID.INFERNAL_HARPOON, ItemID.INFERNAL_HARPOON_UNCHARGED, ItemID.HARPOON,
		ItemID.BARBTAIL_HARPOON, ItemID.BIG_FISHING_NET, ItemID.SMALL_FISHING_NET, ItemID.SMALL_FISHING_NET_6209,
		ItemID.FISHING_ROD, ItemID.FLY_FISHING_ROD, ItemID.BARBARIAN_ROD, ItemID.OILY_FISHING_ROD,
		ItemID.LOBSTER_POT, ItemID.KARAMBWAN_VESSEL, ItemID.KARAMBWAN_VESSEL_3159,
		ItemID.CORMORANTS_GLOVE, ItemID.CORMORANTS_GLOVE_22817,
		ItemID.PEARL_FISHING_ROD, ItemID.PEARL_FLY_FISHING_ROD, ItemID.PEARL_BARBARIAN_ROD
	);

	@Getter(AccessLevel.PACKAGE)
	private final FishingSession session = new FishingSession();

	@Getter(AccessLevel.PACKAGE)
	private final Map<Integer, MinnowSpot> minnowSpots = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final List<NPC> fishingSpots = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private FishingSpot currentSpot;

	@Inject
	private Client client;

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

	@Inject
	private EventBus eventBus;

	private boolean trawlerNotificationSent;

	@Provides
	FishingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FishingConfig.class);
	}

	@Getter(AccessLevel.PACKAGE)
	private boolean onlyCurrentSpot;
	@Getter(AccessLevel.PACKAGE)
	private boolean showSpotTiles;
	@Getter(AccessLevel.PACKAGE)
	private boolean showSpotIcons;
	@Getter(AccessLevel.PACKAGE)
	private boolean showSpotNames;
	private int statTimeout;
	@Getter(AccessLevel.PACKAGE)
	private boolean showFishingStats;
	@Getter(AccessLevel.PACKAGE)
	private boolean showMinnowOverlay;
	private boolean trawlerNotification;
	private boolean trawlerTimer;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
		overlayManager.add(spotOverlay);
		overlayManager.add(fishingSpotMinimapOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		spotOverlay.setHidden(true);
		fishingSpotMinimapOverlay.setHidden(true);
		overlayManager.remove(overlay);
		overlayManager.remove(spotOverlay);
		overlayManager.remove(fishingSpotMinimapOverlay);
		fishingSpots.clear();
		minnowSpots.clear();
		trawlerNotificationSent = false;
		currentSpot = null;
		trawlerStartTime = null;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(InteractingChanged.class, this, this::onInteractingChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("fishing"))
		{
			return;
		}

		updateConfig();
	}

	private void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		GameState gameState = gameStateChanged.getGameState();
		if (gameState == GameState.CONNECTION_LOST || gameState == GameState.LOGIN_SCREEN || gameState == GameState.HOPPING)
		{
			fishingSpots.clear();
			minnowSpots.clear();
		}
	}

	private void onItemContainerChanged(ItemContainerChanged event)
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

	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM)
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

	private void onInteractingChanged(InteractingChanged event)
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

		return ItemUtil.containsAnyItemId(itemContainer.getItems(), FISHING_TOOLS);
	}

	private void onGameTick(GameTick event)
	{
		// Reset fishing session
		if (session.getLastFishCaught() != null)
		{
			final Duration statTimeout = Duration.ofMinutes(this.statTimeout);
			final Duration sinceCaught = Duration.between(session.getLastFishCaught(), Instant.now());

			if (sinceCaught.compareTo(statTimeout) >= 0)
			{
				currentSpot = null;
				session.setLastFishCaught(null);
			}
		}

		inverseSortSpotDistanceFromPlayer();

		for (NPC npc : fishingSpots)
		{
			if (FishingSpot.getSPOTS().get(npc.getId()) == FishingSpot.MINNOW && this.showMinnowOverlay)
			{
				final int id = npc.getIndex();
				final MinnowSpot minnowSpot = minnowSpots.get(id);

				// create the minnow spot if it doesn't already exist
				// or if it was moved, reset it
				if (minnowSpot == null
					|| !minnowSpot.getLoc().equals(npc.getWorldLocation()))
				{
					minnowSpots.put(id, new MinnowSpot(npc.getWorldLocation(), Instant.now()));
				}
			}
		}

		if (this.trawlerTimer)
		{
			updateTrawlerTimer();
		}
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		final NPC npc = event.getNpc();

		if (!FishingSpot.getSPOTS().containsKey(npc.getId()))
		{
			return;
		}

		fishingSpots.add(npc);
		inverseSortSpotDistanceFromPlayer();
	}

	private void onNpcDespawned(NpcDespawned npcDespawned)
	{
		final NPC npc = npcDespawned.getNpc();

		fishingSpots.remove(npc);

		MinnowSpot minnowSpot = minnowSpots.remove(npc.getIndex());
		if (minnowSpot != null)
		{
			log.debug("Minnow spot {} despawned", npc);
		}
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		if (!this.trawlerNotification || client.getGameState() != GameState.LOGGED_IN)
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

	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.FISHING_TRAWLER_GROUP_ID)
		{
			trawlerStartTime = Instant.now();
		}
	}

	/**
	 * Changes the Fishing Trawler timer widget from minutes to minutes and seconds
	 */
	private void updateTrawlerTimer()
	{
		if (trawlerStartTime == null)
		{
			return;
		}

		int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();
		if (regionID != TRAWLER_SHIP_REGION_NORMAL && regionID != TRAWLER_SHIP_REGION_SINKING)
		{
			log.debug("Trawler session ended");
			return;
		}

		Widget trawlerTimerWidget = client.getWidget(WidgetInfo.FISHING_TRAWLER_TIMER);
		if (trawlerTimerWidget == null)
		{
			return;
		}

		long timeLeft = TRAWLER_TIME_LIMIT_IN_SECONDS - Duration.between(trawlerStartTime, Instant.now()).getSeconds();
		if (timeLeft < 0)
		{
			timeLeft = 0;
		}

		int minutes = (int) timeLeft / 60;
		int seconds = (int) timeLeft % 60;

		final StringBuilder trawlerText = new StringBuilder();
		trawlerText.append("Time Left: ");

		if (minutes > 0)
		{
			trawlerText.append(minutes);
		}
		else
		{
			trawlerText.append("00");
		}

		trawlerText.append(':');

		if (seconds < 10)
		{
			trawlerText.append("0");
		}

		trawlerText.append(seconds);

		trawlerTimerWidget.setText(trawlerText.toString());
	}

	private void inverseSortSpotDistanceFromPlayer()
	{
		final LocalPoint cameraPoint = new LocalPoint(client.getCameraX(), client.getCameraY());
		fishingSpots.sort(Comparator.comparing(npc -> -1 * npc.getLocalLocation().distanceTo(cameraPoint)));
	}

	private void updateConfig()
	{
		this.onlyCurrentSpot = config.onlyCurrentSpot();
		this.showSpotTiles = config.showSpotTiles();
		this.showSpotIcons = config.showSpotIcons();
		this.showSpotNames = config.showSpotNames();
		this.statTimeout = config.statTimeout();
		this.showFishingStats = config.showFishingStats();
		this.showMinnowOverlay = config.showMinnowOverlay();
		this.trawlerNotification = config.trawlerNotification();
		this.trawlerTimer = config.trawlerTimer();
	}
}
