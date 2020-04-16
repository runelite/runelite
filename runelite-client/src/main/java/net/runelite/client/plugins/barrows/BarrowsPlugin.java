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
import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Player;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameTick;
import net.runelite.client.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;
import net.runelite.client.ui.overlay.infobox.LoopTimer;
import net.runelite.client.util.QuantityFormatter;

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
	private static final int BARROWS_TP_ID = 19629;
	private static final String totalKillField = "TOTAL";

	private LoopTimer barrowsPrayerDrainTimer;
	private boolean wasInCrypt = false;

	private int barrowsStartingPotential = 0;
	private static Map<String, Integer> monstersKilled = new HashMap<>();

	@Getter
	private Widget puzzleAnswer;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BarrowsOverlay barrowsOverlay;

	@Inject
	private BarrowsBrotherSlainOverlay brotherOverlay;

	private BarrowsCryptKCInfobox kcInfobox;

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
		//Declare new infobox
		this.kcInfobox = new BarrowsCryptKCInfobox(itemManager.getImage(BARROWS_TP_ID), this, client, config);
		infoBoxManager.addInfoBox(this.kcInfobox);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(barrowsOverlay);
		overlayManager.remove(brotherOverlay);
		infoBoxManager.removeIf(t -> t instanceof BarrowsCryptKCInfobox);
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
		if (event.getGameState() == GameState.LOADING)
		{
			wasInCrypt = isInCrypt();
			//When entering crypt, initialize reward potential
			if (isInCrypt())
			{
				initializeRewardPotential();
			}
			// on region changes the tiles get set to null
			puzzleAnswer = null;
		}
		else if (event.getGameState() == GameState.LOGGED_IN)
		{
			//initialize kill count on login
			initializeKC();
			boolean isInCrypt = isInCrypt();
			if (wasInCrypt && !isInCrypt)
			{
				stopPrayerDrainTimer();
			}
			else if (!wasInCrypt && isInCrypt)
			{
				//On login into crypt, initialize reward potential
				initializeRewardPotential();
				startPrayerDrainTimer();
			}
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
	public void onGameTick(GameTick tick)
	{
		if (isInCrypt())
		{
			// Get new potential after a kill
			int newPotential = client.getVar(Varbits.BARROWS_REWARD_POTENTIAL);
			// Calculate the difference between the original potential and new potential (how much potential gained
			// from the kill)
			int potentialDifference = newPotential - this.barrowsStartingPotential;
			// If the amount of potential goes down, a barrows trip has been completed and we want to reset the counters
			// Note - this only occurs when re-entering a crypt/maze after having completed, so if a player finishes a
			// barrows run, the kill count will still be present until they leave the crypt.  But on re-entry of a new
			// crypt, it will have reset.
			if (potentialDifference < 0)
			{
				initializeKC();
			}
			// Set the "original" potential to the new potential so future calculations are based on the correct value.
			this.barrowsStartingPotential = newPotential;

			for (CryptMonsters monster : CryptMonsters.values())
			{
				// To figure out which monster was killed, just check the difference in reward potential and compare it
				// to the combat level of the monster.  This does mean, however, that if multiple unregistered kills occur
				// (such as if the tracker is toggled off mid-run, then back on after a few kills), they will not appear.
				if (monster.getCombatLevel() == potentialDifference)
				{
					String monsterSlain = monster.getName();
					int numKilled = monstersKilled.get(monsterSlain);
					monstersKilled.put(monsterSlain, numKilled + 1);
					//Increment total kills
					int totalKills = monstersKilled.get(totalKillField);
					monstersKilled.put(totalKillField, totalKills + 1);
					//Update the tooltip
					this.kcInfobox.updateTooltip();
				}
			}
		}
	}

	private void initializeRewardPotential()
	{
		this.barrowsStartingPotential = client.getVar(Varbits.BARROWS_REWARD_POTENTIAL);

	}

	private void initializeKC()
	{
		//Initialize monstersKilled dictionary to have 0 kills for each monster
		for (CryptMonsters monster : CryptMonsters.values())
		{
			monstersKilled.put(monster.getName(), 0);
		}
		monstersKilled.put(totalKillField, 0);
	}

	protected String getTooltip()
	{
		StringBuilder tooltipBuilder = new StringBuilder();
		for (CryptMonsters monster : CryptMonsters.values())
		{
			String monsterName = monster.getName();
			tooltipBuilder.append(monsterName).append(": ").append(monstersKilled.get(monsterName))
					.append("\n");
		}
		return tooltipBuilder.toString();
	}

	private void startPrayerDrainTimer()
	{
		if (config.showPrayerDrainTimer())
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
		Player localPlayer = client.getLocalPlayer();
		return localPlayer != null && localPlayer.getWorldLocation().getRegionID() == CRYPT_REGION_ID;
	}

	protected Map<String, Integer> getMonstersKilled()
	{
		return monstersKilled;
	}
}
