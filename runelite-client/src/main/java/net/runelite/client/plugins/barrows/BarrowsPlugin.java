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
import java.awt.Color;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.WorldView;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.WidgetClosed;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.SpriteID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.callback.ClientThread;
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
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Barrows Brothers",
	description = "Show helpful information for the Barrows minigame",
	tags = {"combat", "minigame", "bosses", "pve", "pvm"}
)
public class BarrowsPlugin extends Plugin
{
	private static final ImmutableList<Integer> POSSIBLE_SOLUTIONS = ImmutableList.of(
		InterfaceID.BarrowsPuzzle.PIC_A,
		InterfaceID.BarrowsPuzzle.PIC_B,
		InterfaceID.BarrowsPuzzle.PIC_C
	);

	private static final long PRAYER_DRAIN_INTERVAL_MS = 18200;
	private static final int CRYPT_REGION_ID = 14231;
	private static final int BARROWS_REGION_ID = 14131;
	private static final int MAX_BASE_POTENTIAL = 1000;
	static final int MAX_REWARD_POTENTIAL = 1012;
	private static final Map<String, Integer> BROTHER_VARBITS;
	private static final Set<String> CRYPT_MONSTERS;

	static
	{
		Map<String, Integer> brothers = new HashMap<>();
		brothers.put("Ahrim the Blighted", VarbitID.BARROWS_KILLED_AHRIM);
		brothers.put("Dharok the Wretched", VarbitID.BARROWS_KILLED_DHAROK);
		brothers.put("Guthan the Infested", VarbitID.BARROWS_KILLED_GUTHAN);
		brothers.put("Karil the Tainted", VarbitID.BARROWS_KILLED_KARIL);
		brothers.put("Torag the Corrupted", VarbitID.BARROWS_KILLED_TORAG);
		brothers.put("Verac the Defiled", VarbitID.BARROWS_KILLED_VERAC);
		BROTHER_VARBITS = Collections.unmodifiableMap(brothers);

		Set<String> monsters = new HashSet<>();
		monsters.add("crypt rat");
		monsters.add("bloodworm");
		monsters.add("crypt spider");
		monsters.add("giant crypt rat");
		monsters.add("skeleton");
		monsters.add("giant crypt spider");
		CRYPT_MONSTERS = Collections.unmodifiableSet(monsters);
	}

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
	private BarrowsPotentialNpcOverlay potentialNpcOverlay;

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
	private ClientThread clientThread;

	private final Set<NPC> trackedPotentialNpcs = Collections.newSetFromMap(new IdentityHashMap<>());

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
		overlayManager.add(potentialNpcOverlay);
		clientThread.invokeLater(this::rebuildTrackedPotentialNpcs);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(barrowsOverlay);
		overlayManager.remove(brotherOverlay);
		overlayManager.remove(potentialNpcOverlay);
		trackedPotentialNpcs.clear();
		puzzleAnswer = null;
		stopPrayerDrainTimer();

		// Restore widgets
		final Widget potential = client.getWidget(InterfaceID.BarrowsOverlay.KILLCOUNT);
		if (potential != null)
		{
			potential.setHidden(false);
		}

		final Widget barrowsBrothers = client.getWidget(InterfaceID.BarrowsOverlay.BROTHERS);
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
			rebuildTrackedPotentialNpcs();
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
		else
		{
			trackedPotentialNpcs.clear();
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		trackPotentialNpc(event.getNpc());
	}

	@Subscribe
	public void onNpcChanged(NpcChanged event)
	{
		trackPotentialNpc(event.getNpc());
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		trackedPotentialNpcs.remove(event.getNpc());
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!config.preventExceedingGoal() || !isInCrypt())
		{
			return;
		}

		MenuEntry menuEntry = event.getMenuEntry();
		NPC npc = menuEntry.getNpc();
		if (npc == null || !isNpcAttackOption(menuEntry.getType())
			|| !"Attack".equalsIgnoreCase(menuEntry.getOption())
			|| isPotentialBrother(npc.getName()) || !isPotentialNpc(npc.getName()))
		{
			return;
		}

		int goalPoints = BarrowsPotentialPlan.getPotentialGoalPoints(config.potentialGoal());
		if (getPotentialAfterRequiredBrothersAndNpc(npc) <= goalPoints)
		{
			return;
		}

		event.consume();
		String warning = new ChatMessageBuilder()
			.append(Color.RED, "Killing this NPC would take you over your barrows reward potential goal.")
			.build();
		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.GAMEMESSAGE)
			.runeLiteFormattedMessage(warning)
			.build());
	}

	private boolean isNpcAttackOption(MenuAction action)
	{
		return action == MenuAction.NPC_FIRST_OPTION
			|| action == MenuAction.NPC_SECOND_OPTION
			|| action == MenuAction.NPC_THIRD_OPTION
			|| action == MenuAction.NPC_FOURTH_OPTION
			|| action == MenuAction.NPC_FIFTH_OPTION;
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == InterfaceID.BARROWS_REWARD && config.showChestValue())
		{
			ItemContainer barrowsRewardContainer = client.getItemContainer(InventoryID.TRAIL_REWARDINV);
			if (barrowsRewardContainer == null)
			{
				return;
			}

			Item[] items = barrowsRewardContainer.getItems();
			long chestPrice = 0;

			for (Item item : items)
			{
				long itemStack = itemManager.getItemPrice(item.getId()) * item.getQuantity();
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
		else if (event.getGroupId() == InterfaceID.BARROWS_PUZZLE)
		{
			final int answer = client.getWidget(InterfaceID.BarrowsPuzzle._1).getModelId() - 3;
			puzzleAnswer = null;

			for (int puzzleComponent : POSSIBLE_SOLUTIONS)
			{
				final Widget widgetToCheck = client.getWidget(puzzleComponent);

				if (widgetToCheck != null && widgetToCheck.getModelId() == answer)
				{
					puzzleAnswer = widgetToCheck;
					break;
				}
			}
		}
	}

	@Subscribe
	public void onBeforeRender(BeforeRender beforeRender)
	{
		// The barrows brothers and potential overlays have timers to unhide them each tick. Set them
		// hidden here instead of in the overlay, because if the overlay renders on the ABOVE_WIDGETS
		// layer due to being moved outside of the snap corner, it will be running after the overlays
		// had already been rendered.
		final Widget barrowsBrothers = client.getWidget(InterfaceID.BarrowsOverlay.BROTHERS);
		if (barrowsBrothers != null)
		{
			barrowsBrothers.setHidden(true);
		}

		final Widget potential = client.getWidget(InterfaceID.BarrowsOverlay.KILLCOUNT);
		if (potential != null)
		{
			potential.setHidden(true);
		}
	}

	@Subscribe
	public void onWidgetClosed(WidgetClosed widgetClosed)
	{
		if (widgetClosed.getGroupId() == InterfaceID.BARROWS_PUZZLE)
		{
			puzzleAnswer = null;
		}
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

			spriteManager.getSpriteAsync(SpriteID.SideiconsInterface.PRAYER, 0, loopTimer);

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

	boolean isInCrypt()
	{
		Player localPlayer = client.getLocalPlayer();
		return localPlayer != null && localPlayer.getWorldLocation().getRegionID() == CRYPT_REGION_ID;
	}

	boolean shouldShowPotentialKillRecommendations()
	{
		return isInCrypt() && getKilledBrotherCount() >= 5;
	}

	int getBasePotential()
	{
		return client.getVarbitValue(VarbitID.BARROWS_KILLED_MONSTER);
	}

	int getRewardPotential()
	{
		int slainBrothers = 0;
		for (BarrowsBrothers brother : BarrowsBrothers.values())
		{
			slainBrothers += client.getVarbitValue(brother.getKilledVarbit());
		}
		return getBasePotential() + slainBrothers * 2;
	}

	int getKilledBrotherCount()
	{
		int count = 0;
		for (int varbit : BROTHER_VARBITS.values())
		{
			count += client.getVarbitValue(varbit);
		}
		return count;
	}

	boolean isBrotherKilled(String brotherName)
	{
		Integer varbit = BROTHER_VARBITS.get(brotherName);
		return varbit != null && client.getVarbitValue(varbit) > 0;
	}

	static boolean isPotentialNpc(String name)
	{
		return name != null && (BROTHER_VARBITS.containsKey(name)
			|| CRYPT_MONSTERS.contains(name.trim().toLowerCase(Locale.ROOT)));
	}

	static boolean isPotentialBrother(String name)
	{
		return BROTHER_VARBITS.containsKey(name);
	}

	/**
	 * Calculates the reward potential after the target NPC is killed.
	 *
	 * @param target the NPC to calculate potential for
	 * @return reward potential points, from 0 to 1012
	 */
	int getPotentialAfterKilling(NPC target)
	{
		int potential = Math.min(MAX_BASE_POTENTIAL, getBasePotential() + Math.max(0, target.getCombatLevel()));
		int brothersSlain = getKilledBrotherCount();
		if (isPotentialBrother(target.getName()) && !isBrotherKilled(target.getName()))
		{
			brothersSlain++;
		}
		return Math.min(MAX_REWARD_POTENTIAL, potential + brothersSlain * 2);
	}

	boolean shouldPotentialBeRed(NPC target)
	{
		return !isPotentialBrother(target.getName())
			&& getPotentialAfterRequiredBrothersAndNpc(target)
				> BarrowsPotentialPlan.getPotentialGoalPoints(config.potentialGoal());
	}

	private int getPotentialAfterRequiredBrothersAndNpc(NPC target)
	{
		int basePotential = getBasePotential() + Math.max(0, target.getCombatLevel());
		int brothersSlain = getKilledBrotherCount();
		for (BarrowsBrothers brother : BarrowsBrothers.values())
		{
			if (client.getVarbitValue(brother.getKilledVarbit()) == 0)
			{
				basePotential += BarrowsPotentialPlan.getBrotherCombatLevel(brother);
				brothersSlain++;
			}
		}

		int potential = Math.min(MAX_BASE_POTENTIAL, basePotential) + brothersSlain * 2;
		return Math.min(MAX_REWARD_POTENTIAL, potential);
	}

	Set<NPC> getTrackedPotentialNpcs()
	{
		return trackedPotentialNpcs;
	}

	private void rebuildTrackedPotentialNpcs()
	{
		trackedPotentialNpcs.clear();
		if (client.getGameState() != GameState.LOGGED_IN || !isInCrypt())
		{
			return;
		}

		Set<WorldView> visitedWorldViews = Collections.newSetFromMap(new IdentityHashMap<>());
		collectPotentialNpcs(client.getTopLevelWorldView(), visitedWorldViews);
	}

	private void collectPotentialNpcs(WorldView worldView, Set<WorldView> visitedWorldViews)
	{
		if (worldView == null || !visitedWorldViews.add(worldView))
		{
			return;
		}

		for (NPC npc : worldView.npcs())
		{
			trackPotentialNpc(npc);
		}

		for (WorldView childWorldView : worldView.worldViews())
		{
			collectPotentialNpcs(childWorldView, visitedWorldViews);
		}
	}

	private void trackPotentialNpc(NPC npc)
	{
		if (isInCrypt() && isPotentialNpc(npc.getName()))
		{
			trackedPotentialNpcs.add(npc);
		}
		else
		{
			trackedPotentialNpcs.remove(npc);
		}
	}

	boolean isBarrowsLoaded()
	{
		return ArrayUtils.contains(client.getMapRegions(), BARROWS_REGION_ID);
	}
}
