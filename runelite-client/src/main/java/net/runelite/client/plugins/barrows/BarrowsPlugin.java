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
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;
import net.runelite.client.ui.overlay.infobox.LoopTimer;
import net.runelite.client.util.QuantityFormatter;

import static net.runelite.api.NullObjectID.*;

@PluginDescriptor(
	name = "Barrows Brothers",
	description = "Show helpful information for the Barrows minigame",
	tags = {"combat", "minigame", "bosses", "pve", "pvm"}
)
public class BarrowsPlugin extends Plugin
{
	private static final ImmutableList<WidgetInfo> POSSIBLE_SOLUTIONS = ImmutableList.of(
		WidgetInfo.BARROWS_PUZZLE_ANSWER1,
		WidgetInfo.BARROWS_PUZZLE_ANSWER2,
		WidgetInfo.BARROWS_PUZZLE_ANSWER3
	);

	private static final long PRAYER_DRAIN_INTERVAL_MS = 18200;
	private static final int CRYPT_REGION_ID = 14231;

	static final ImmutableSet<Integer> DOOR_IDS = ImmutableSet.of(
		NULL_20681, NULL_20682, NULL_20683, NULL_20684, NULL_20685, NULL_20686, NULL_20687, NULL_20688,
		NULL_20689, NULL_20690, NULL_20691, NULL_20692, NULL_20693, NULL_20694, NULL_20695, NULL_20696,
		NULL_20700, NULL_20701, NULL_20702, NULL_20703, NULL_20704, NULL_20705, NULL_20706, NULL_20707,
		NULL_20708, NULL_20709, NULL_20710, NULL_20711, NULL_20712, NULL_20713, NULL_20714, NULL_20715
	);

	private LoopTimer barrowsPrayerDrainTimer;

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

	@Getter
	private final Set<WallObject> doors = new HashSet<>();

	@Provides
	BarrowsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BarrowsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(barrowsOverlay);
		overlayManager.add(brotherOverlay);
	}

	@Override
	protected void shutDown()
	{
		doors.clear();
		overlayManager.remove(barrowsOverlay);
		overlayManager.remove(brotherOverlay);
		puzzleAnswer = null;
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

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("barrows") && !config.showPrayerDrainTimer())
		{
			stopPrayerDrainTimer();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			boolean isInCrypt = isInCrypt();
			if (!isInCrypt && barrowsPrayerDrainTimer != null)
			{
				stopPrayerDrainTimer();
			}
			else if (isInCrypt && barrowsPrayerDrainTimer == null)
			{
				startPrayerDrainTimer();
			}
		}
		else if (event.getGameState() == GameState.LOADING)
		{
			doors.clear();
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.BARROWS_REWARD_GROUP_ID && config.showChestValue())
		{
			ItemContainer barrowsRewardContainer = client.getItemContainer(InventoryID.BARROWS_REWARD);
			Item[] items = barrowsRewardContainer.getItems();
			long chestPrice = 0;

			for (Item item : items)
			{
				long itemStack = (long) itemManager.getItemPrice(item.getId()) * (long) item.getQuantity();
				chestPrice += itemStack;
			}

			final ChatMessageBuilder message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("Your chest is worth around ")
				.append(QuantityFormatter.formatNumber(chestPrice))
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

	@Subscribe
	public void onWidgetClosed(WidgetClosed widgetClosed)
	{
		if (widgetClosed.getGroupId() == WidgetID.BARROWS_PUZZLE_GROUP_ID)
		{
			puzzleAnswer = null;
		}
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		WallObject wallObject = event.getWallObject();
		if (DOOR_IDS.contains(wallObject.getId()))
		{
			doors.add(wallObject);
		}
	}

	@Subscribe
	public void onWallObjectChanged(WallObjectChanged event)
	{
		WallObject previous = event.getPrevious();
		WallObject wallObject = event.getWallObject();

		doors.remove(previous);
		if (DOOR_IDS.contains(wallObject.getId()))
		{
			doors.add(wallObject);
		}
	}

	@Subscribe
	public void onWallObjectDespawned(WallObjectDespawned event)
	{
		WallObject wallObject = event.getWallObject();
		doors.remove(wallObject);
	}

	private void startPrayerDrainTimer()
	{
		if (config.showPrayerDrainTimer())
		{
			assert barrowsPrayerDrainTimer == null;
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
		Player localPlayer = client.getLocalPlayer();
		return localPlayer != null && localPlayer.getWorldLocation().getRegionID() == CRYPT_REGION_ID;
	}
}
