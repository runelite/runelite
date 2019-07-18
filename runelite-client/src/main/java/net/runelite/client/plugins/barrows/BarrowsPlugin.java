/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.barrows;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.inject.Provides;
import java.awt.Color;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NullObjectID;
import net.runelite.api.ObjectID;
import net.runelite.api.SpriteID;
import net.runelite.api.WallObject;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;
import net.runelite.client.ui.overlay.infobox.LoopTimer;
import net.runelite.client.util.StackFormatter;

@PluginDescriptor(
	name = "Barrows Brothers",
	description = "Show helpful information for the Barrows minigame",
	tags = {"combat", "minigame", "minimap", "bosses", "pve", "pvm"}
)
@Singleton
public class BarrowsPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> BARROWS_WALLS = Sets.newHashSet
		(
			ObjectID.DOOR_20678, NullObjectID.NULL_20681, NullObjectID.NULL_20682, NullObjectID.NULL_20683, NullObjectID.NULL_20684, NullObjectID.NULL_20685, NullObjectID.NULL_20686, NullObjectID.NULL_20687,
			NullObjectID.NULL_20688, NullObjectID.NULL_20689, NullObjectID.NULL_20690, NullObjectID.NULL_20691, NullObjectID.NULL_20692, NullObjectID.NULL_20693, NullObjectID.NULL_20694, NullObjectID.NULL_20695,
			NullObjectID.NULL_20696, ObjectID.DOOR_20697, NullObjectID.NULL_20700, NullObjectID.NULL_20701, NullObjectID.NULL_20702, NullObjectID.NULL_20703, NullObjectID.NULL_20704, NullObjectID.NULL_20705,
			NullObjectID.NULL_20706, NullObjectID.NULL_20707, NullObjectID.NULL_20708, NullObjectID.NULL_20709, NullObjectID.NULL_20710, NullObjectID.NULL_20711, NullObjectID.NULL_20712, NullObjectID.NULL_20713,
			NullObjectID.NULL_20714, NullObjectID.NULL_20715, NullObjectID.NULL_20728, NullObjectID.NULL_20730
		);

	private static final Set<Integer> BARROWS_LADDERS = Sets.newHashSet(NullObjectID.NULL_20675, NullObjectID.NULL_20676, NullObjectID.NULL_20677);
	private static final ImmutableList<WidgetInfo> POSSIBLE_SOLUTIONS = ImmutableList.of(
		WidgetInfo.BARROWS_PUZZLE_ANSWER1,
		WidgetInfo.BARROWS_PUZZLE_ANSWER2,
		WidgetInfo.BARROWS_PUZZLE_ANSWER3
	);

	private static final long PRAYER_DRAIN_INTERVAL_MS = 18200;
	private static final int CRYPT_REGION_ID = 14231;

	@Getter(AccessLevel.PACKAGE)
	private final Set<WallObject> walls = new HashSet<>();

	@Getter(AccessLevel.PACKAGE)
	private final Set<GameObject> ladders = new HashSet<>();

	private LoopTimer barrowsPrayerDrainTimer;
	private boolean wasInCrypt = false;

	@Getter
	private Widget puzzleAnswer;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BarrowsOverlay barrowsOverlay;

	@Inject
	private BarrowsBrotherSlainOverlay brotherOverlay;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private BarrowsConfig config;

	@Inject
	private EventBus eventBus;

	@Provides
	BarrowsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BarrowsConfig.class);
	}

	@Getter(AccessLevel.PACKAGE)
	private boolean showMinimap;
	@Getter(AccessLevel.PACKAGE)
	private boolean showBrotherLoc;
	private boolean showChestValue;
	@Getter(AccessLevel.PACKAGE)
	private Color brotherLocColor;
	@Getter(AccessLevel.PACKAGE)
	private Color deadBrotherLocColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean showPuzzleAnswer;
	private boolean showPrayerDrainTimer;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(barrowsOverlay);
		overlayManager.add(brotherOverlay);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(barrowsOverlay);
		overlayManager.remove(brotherOverlay);
		walls.clear();
		ladders.clear();
		puzzleAnswer = null;
		wasInCrypt = false;
		stopPrayerDrainTimer();

		// Restore widgets
		final Widget potential = client.getWidget(WidgetInfo.BARROWS_POTENTIAL);
		if (potential != null)
		{
			potential.setHidden(false);
		}

		final Widget barrowsBrothers = client.getWidget(WidgetInfo.BARROWS_BROTHERS);
		if (barrowsBrothers != null)
		{
			barrowsBrothers.setHidden(false);
		}
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(WallObjectSpawned.class, this, this::onWallObjectSpawned);
		eventBus.subscribe(WallObjectChanged.class, this, this::onWallObjectChanged);
		eventBus.subscribe(WallObjectDespawned.class, this, this::onWallObjectDespawned);
		eventBus.subscribe(GameObjectSpawned.class, this, this::onGameObjectSpawned);
		eventBus.subscribe(GameObjectChanged.class, this, this::onGameObjectChanged);
		eventBus.subscribe(GameObjectDespawned.class, this, this::onGameObjectDespawned);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("barrows"))
		{
			updateConfig();

			if (!this.showPrayerDrainTimer)
			{
				stopPrayerDrainTimer();
			}
		}
	}

	private void updateConfig()
	{
		this.showMinimap = config.showMinimap();
		this.showBrotherLoc = config.showBrotherLoc();
		this.showChestValue = config.showChestValue();
		this.brotherLocColor = config.brotherLocColor();
		this.deadBrotherLocColor = config.deadBrotherLocColor();
		this.showPuzzleAnswer = config.showPuzzleAnswer();
		this.showPrayerDrainTimer = config.showPrayerDrainTimer();
	}

	private void onWallObjectSpawned(WallObjectSpawned event)
	{
		WallObject wallObject = event.getWallObject();
		if (BARROWS_WALLS.contains(wallObject.getId()))
		{
			walls.add(wallObject);
		}
	}

	private void onWallObjectChanged(WallObjectChanged event)
	{
		WallObject previous = event.getPrevious();
		WallObject wallObject = event.getWallObject();

		walls.remove(previous);
		if (BARROWS_WALLS.contains(wallObject.getId()))
		{
			walls.add(wallObject);
		}
	}

	private void onWallObjectDespawned(WallObjectDespawned event)
	{
		WallObject wallObject = event.getWallObject();
		walls.remove(wallObject);
	}

	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();
		if (BARROWS_LADDERS.contains(gameObject.getId()))
		{
			ladders.add(gameObject);
		}
	}

	private void onGameObjectChanged(GameObjectChanged event)
	{
		GameObject previous = event.getPrevious();
		GameObject gameObject = event.getGameObject();

		ladders.remove(previous);
		if (BARROWS_LADDERS.contains(gameObject.getId()))
		{
			ladders.add(gameObject);
		}
	}

	private void onGameObjectDespawned(GameObjectDespawned event)
	{
		GameObject gameObject = event.getGameObject();
		ladders.remove(gameObject);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			wasInCrypt = isInCrypt();
			// on region changes the tiles get set to null
			walls.clear();
			ladders.clear();
			puzzleAnswer = null;
		}
		else if (event.getGameState() == GameState.LOGGED_IN && client.getLocalPlayer() != null)
		{
			boolean isInCrypt = isInCrypt();
			if (wasInCrypt && !isInCrypt)
			{
				stopPrayerDrainTimer();
			}
			else if (!wasInCrypt && isInCrypt)
			{
				startPrayerDrainTimer();
			}
		}
	}

	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.BARROWS_REWARD_GROUP_ID && this.showChestValue)
		{
			ItemContainer barrowsRewardContainer = client.getItemContainer(InventoryID.BARROWS_REWARD);
			Item[] items = new Item[0];
			if (barrowsRewardContainer != null)
			{
				items = barrowsRewardContainer.getItems();
			}
			long chestPrice = 0;

			for (Item item : items)
			{
				long itemStack = (long) itemManager.getItemPrice(item.getId()) * (long) item.getQuantity();
				chestPrice += itemStack;
			}

			final ChatMessageBuilder message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("Your chest is worth around ")
				.append(StackFormatter.formatNumber(chestPrice))
				.append(" coins.")
				.append(ChatColorType.NORMAL);

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.ITEM_EXAMINE)
				.runeLiteFormattedMessage(message.build())
				.build());
		}
		else if (event.getGroupId() == WidgetID.BARROWS_PUZZLE_GROUP_ID)
		{
			final int answer = client.getWidget(WidgetInfo.BARROWS_FIRST_PUZZLE).getModelId() - 3;
			puzzleAnswer = null;

			for (WidgetInfo puzzleNode : POSSIBLE_SOLUTIONS)
			{
				final Widget widgetToCheck = client.getWidget(puzzleNode);

				if (widgetToCheck != null && widgetToCheck.getModelId() == answer)
				{
					puzzleAnswer = client.getWidget(puzzleNode);
					break;
				}
			}
		}
	}

	private void startPrayerDrainTimer()
	{
		if (this.showPrayerDrainTimer)
		{
			final LoopTimer loopTimer = new LoopTimer(
				PRAYER_DRAIN_INTERVAL_MS,
				ChronoUnit.MILLIS,
				null,
				this,
				true);

			spriteManager.getSpriteAsync(SpriteID.TAB_PRAYER, 0, loopTimer);

			loopTimer.setPriority(InfoBoxPriority.MED);
			loopTimer.setTooltip("Prayer Drain");

			infoBoxManager.addInfoBox(loopTimer);
			barrowsPrayerDrainTimer = loopTimer;
		}
	}

	private void stopPrayerDrainTimer()
	{
		infoBoxManager.removeInfoBox(barrowsPrayerDrainTimer);
		barrowsPrayerDrainTimer = null;
	}

	private boolean isInCrypt()
	{
		return client.getLocalPlayer().getWorldLocation().getRegionID() == CRYPT_REGION_ID;
	}
}
