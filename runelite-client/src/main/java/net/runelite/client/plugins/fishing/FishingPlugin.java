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

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.FishingSpot;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;

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
	private static final int TRAWLER_TIME_LIMIT_IN_SECONDS = 314;

	private static final Pattern FISHING_CATCH_REGEX = Pattern.compile(
		"You catch (?:a|an|some) |Your cormorant returns with its catch.|You catch .* Karambwanji");

	private Instant trawlerStartTime;

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
		fishingSpots.clear();
		minnowSpots.clear();
		currentSpot = null;
		trawlerStartTime = null;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		GameState gameState = gameStateChanged.getGameState();
		if (gameState == GameState.CONNECTION_LOST || gameState == GameState.LOGIN_SCREEN || gameState == GameState.HOPPING)
		{
			fishingSpots.clear();
			minnowSpots.clear();
		}
	}

	void reset()
	{
		session.setLastFishCaught(null);
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.INV)
			&& event.getItemContainer() != client.getItemContainer(InventoryID.WORN))
		{
			return;
		}

		final boolean showOverlays = session.getLastFishCaught() != null
			|| canPlayerFish(client.getItemContainer(InventoryID.INV))
			|| canPlayerFish(client.getItemContainer(InventoryID.WORN));

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
		if (event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		var message = event.getMessage();
		if (FISHING_CATCH_REGEX.matcher(message).find())
		{
			session.setLastFishCaught(Instant.now());
			spotOverlay.setHidden(false);
			fishingSpotMinimapOverlay.setHidden(false);
		}

		if (message.equals("A flying fish jumps up and eats some of your minnows!"))
		{
			notifier.notify(config.flyingFishNotification(), "A flying fish is eating your minnows!");
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
		FishingSpot spot = FishingSpot.findSpot(npc.getId());

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
			switch (item.getId())
			{
				case ItemID.DRAGON_HARPOON:
				case ItemID.TRAILBLAZER_HARPOON_NO_INFERNAL:
				case ItemID.INFERNAL_HARPOON:
				case ItemID.INFERNAL_HARPOON_EMPTY:
				case ItemID.TRAILBLAZER_HARPOON_EMPTY:
				case ItemID.HARPOON:
				case ItemID.HUNTING_BARBED_HARPOON:
				case ItemID.BIG_NET:
				case ItemID.NET:
				case ItemID.EVIL_BOB_NET:
				case ItemID.FISHING_ROD:
				case ItemID.FLY_FISHING_ROD:
				case ItemID.FISHINGROD_PEARL_BRUT:
				case ItemID.FISHINGROD_PEARL:
				case ItemID.FISHINGROD_PEARL_FLY:
				case ItemID.BRUT_FISHING_ROD:
				case ItemID.OILY_FISHING_ROD:
				case ItemID.LOBSTER_POT:
				case ItemID.TBWT_KARAMBWAN_VESSEL:
				case ItemID.TBWT_KARAMBWAN_VESSEL_LOADED_WITH_KARAMBWANJI:
				case ItemID.AERIAL_FISHING_GLOVES_NO_BIRD:
				case ItemID.AERIAL_FISHING_GLOVES_BIRD:
				case ItemID.TRAILBLAZER_HARPOON:
				case ItemID.LEAGUE_TRAILBLAZER_HARPOON:
				case ItemID.CRYSTAL_HARPOON:
				case ItemID.GAUNTLET_HARPOON:
				case ItemID.CRYSTAL_HARPOON_INACTIVE:
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

		inverseSortSpotDistanceFromPlayer();

		for (NPC npc : fishingSpots)
		{
			if (FishingSpot.findSpot(npc.getId()) == FishingSpot.MINNOW && config.showMinnowOverlay())
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

		updateTrawlerTimer();
		updateTrawlerContribution();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		final NPC npc = event.getNpc();

		if (FishingSpot.findSpot(npc.getId()) == null)
		{
			return;
		}

		fishingSpots.add(npc);
		inverseSortSpotDistanceFromPlayer();
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		final NPC npc = npcDespawned.getNpc();

		fishingSpots.remove(npc);

		MinnowSpot minnowSpot = minnowSpots.remove(npc.getIndex());
		if (minnowSpot != null)
		{
			log.debug("Minnow spot {} despawned", npc);
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == InterfaceID.TRAWLER_OVERLAY)
		{
			trawlerStartTime = Instant.now();
			log.debug("Trawler session started");
		}
	}

	/**
	 * Updates the trawler contribution value
	 */
	private void updateTrawlerContribution()
	{
		int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();
		if (regionID != TRAWLER_SHIP_REGION_NORMAL && regionID != TRAWLER_SHIP_REGION_SINKING)
		{
			return;
		}

		if (!config.trawlerContribution())
		{
			return;
		}

		Widget trawlerContributionWidget = client.getWidget(InterfaceID.TrawlerOverlay.CATCH);
		if (trawlerContributionWidget == null)
		{
			return;
		}

		int trawlerContribution = client.getVarbitValue(VarbitID.TRAWLER_ACTIVITY);
		trawlerContributionWidget.setText("Contribution: " + trawlerContribution);
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
			trawlerStartTime = null;
			return;
		}

		if (!config.trawlerTimer())
		{
			return;
		}

		Widget trawlerTimerWidget = client.getWidget(InterfaceID.TrawlerOverlay.TIME);
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
			trawlerText.append('0');
		}

		trawlerText.append(':');

		if (seconds < 10)
		{
			trawlerText.append('0');
		}

		trawlerText.append(seconds);

		trawlerTimerWidget.setText(trawlerText.toString());
	}

	private void inverseSortSpotDistanceFromPlayer()
	{
		if (fishingSpots.isEmpty())
		{
			return;
		}

		final LocalPoint cameraPoint = new LocalPoint(client.getCameraX(), client.getCameraY());
		fishingSpots.sort(
			Comparator.comparingInt(
				// Negate to have the furthest first
				(NPC npc) -> -npc.getLocalLocation().distanceTo(cameraPoint))
				// Order by position
				.thenComparing(NPC::getLocalLocation, Comparator.comparingInt(LocalPoint::getX)
					.thenComparingInt(LocalPoint::getY))
				// And then by id
				.thenComparingInt(NPC::getId)
		);
	}
}
