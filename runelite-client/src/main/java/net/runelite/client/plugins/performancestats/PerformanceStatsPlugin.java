/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.performancestats;

import com.google.inject.Provides;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.game.NPCManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.api.util.Text;
import net.runelite.client.ws.PartyMember;
import net.runelite.client.ws.PartyService;
import net.runelite.client.ws.WSClient;
import net.runelite.http.api.ws.messages.party.UserPart;
import net.runelite.http.api.ws.messages.party.UserSync;

@PluginDescriptor(
	name = "Performance Stats",
	description = "Displays your current performance stats",
	tags = {"performance", "stats", "dps", "damage", "combat"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Slf4j
@Singleton
public class PerformanceStatsPlugin extends Plugin
{
	// For every damage point dealt 1.33 experience is given to the player's hitpoints (base rate)
	private static final double HITPOINT_RATIO = 1.33;
	private static final double DMM_MULTIPLIER_RATIO = 10;

	private static final double GAME_TICK_SECONDS = 0.6;
	private static final DecimalFormat numberFormat = new DecimalFormat("#,###");

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private PerformanceStatsConfig config;

	@Inject
	private PerformanceStatsOverlay performanceTrackerOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private NPCManager npcManager;

	@Inject
	private PartyService partyService;

	@Inject
	private WSClient wsClient;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private boolean enabled = false;
	@Getter(AccessLevel.PACKAGE)
	private boolean paused = false;
	@Getter(AccessLevel.PACKAGE)
	private final Performance performance = new Performance();

	// Keep track of actor last tick as sometimes getInteracting can return null when hp xp event is triggered
	// as the player clicked away at the perfect time
	private Actor oldTarget;
	private double hpExp;
	private boolean hopping;
	private int pausedTicks = 0;

	private int submitTimeout;

	// Party System
	@Getter(AccessLevel.PACKAGE)
	private final Map<UUID, Performance> partyDataMap = Collections.synchronizedMap(new HashMap<>());

	@Provides
	PerformanceStatsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PerformanceStatsConfig.class);
	}

	@Override
	protected void startUp()
	{
		addSubscriptions();

		this.submitTimeout = config.submitTimeout();

		overlayManager.add(performanceTrackerOverlay);
		wsClient.registerMessage(Performance.class);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(performanceTrackerOverlay);
		wsClient.unregisterMessage(Performance.class);
		disable();
		reset();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(HitsplatApplied.class, this, this::onHitsplatApplied);
		eventBus.subscribe(ExperienceChanged.class, this, this::onExperienceChanged);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(OverlayMenuClicked.class, this, this::onOverlayMenuClicked);
		eventBus.subscribe(Performance.class, this, this::onPerformance);
		eventBus.subscribe(UserSync.class, this, this::onUserSync);
		eventBus.subscribe(UserPart.class, this, this::onUserPart);
		eventBus.subscribe(PartyChanged.class, this, this::onPartyChanged);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
				disable();
				break;
			case HOPPING:
				hopping = true;
				break;
		}
	}

	private void onHitsplatApplied(HitsplatApplied e)
	{
		if (isPaused())
		{
			return;
		}

		if (e.getActor().equals(client.getLocalPlayer()))
		{
			// Auto enables when hitsplat is applied to player
			if (!isEnabled())
			{
				enable();
			}

			performance.addDamageTaken(e.getHitsplat().getAmount(), client.getTickCount());
		}
	}

	private void onExperienceChanged(ExperienceChanged c)
	{
		if (isPaused() || hopping)
		{
			return;
		}

		if (c.getSkill().equals(Skill.HITPOINTS))
		{
			final double oldExp = hpExp;
			hpExp = client.getSkillExperience(Skill.HITPOINTS);

			// Ignore initial login
			if (client.getTickCount() < 2)
			{
				return;
			}

			final double diff = hpExp - oldExp;
			if (diff < 1)
			{
				return;
			}

			// Auto enables when player receives hp exp
			if (!isEnabled())
			{
				enable();
			}

			final double damageDealt = calculateDamageDealt(diff);
			performance.addDamageDealt(damageDealt, client.getTickCount());
		}
	}

	private void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		// Handles Fake XP drops (Ironman in PvP, DMM Cap, 200m xp, etc)
		if (isPaused())
		{
			return;
		}

		if (!"fakeXpDrop".equals(e.getEventName()))
		{
			return;
		}

		final int[] intStack = client.getIntStack();
		final int intStackSize = client.getIntStackSize();

		final int skillId = intStack[intStackSize - 2];
		final Skill skill = Skill.values()[skillId];
		if (skill.equals(Skill.HITPOINTS))
		{
			// Auto enables when player would have received hp exp
			if (!isEnabled())
			{
				enable();
			}

			final int exp = intStack[intStackSize - 1];
			performance.addDamageDealt(calculateDamageDealt(exp), client.getTickCount());
		}
	}

	private void onGameTick(GameTick t)
	{
		oldTarget = client.getLocalPlayer().getInteracting();

		if (!isEnabled())
		{
			return;
		}

		if (isPaused())
		{
			pausedTicks++;
			return;
		}

		performance.incrementTicksSpent();
		hopping = false;

		final int timeout = this.submitTimeout;
		if (timeout > 0)
		{
			final double tickTimeout = timeout / GAME_TICK_SECONDS;
			final int activityDiff = (client.getTickCount() - pausedTicks) - performance.getLastActivityTick();
			if (activityDiff > tickTimeout)
			{
				// offset the tracker time to account for idle timeout
				// Leave an additional tick to pad elapsed time
				final double offset = tickTimeout - GAME_TICK_SECONDS;
				performance.setTicksSpent(performance.getTicksSpent() - offset);

				submit();
			}
		}

		final String name = client.getLocalPlayer().getName();
		performance.setUsername(Text.removeTags(name));
		sendPerformance();
	}

	private void onOverlayMenuClicked(OverlayMenuClicked c)
	{
		if (!c.getOverlay().equals(performanceTrackerOverlay))
		{
			return;
		}

		switch (c.getEntry().getOption())
		{
			case "Pause":
				togglePaused();
				break;
			case "Reset":
				reset();
				break;
			case "Submit":
				submit();
				break;
		}
	}

	private void enable()
	{
		this.enabled = true;
		hpExp = client.getSkillExperience(Skill.HITPOINTS);
	}

	private void disable()
	{
		this.enabled = false;
	}

	private void togglePaused()
	{
		this.paused = !this.paused;
	}

	private void reset()
	{
		this.enabled = false;
		this.paused = false;

		this.performance.reset();
		pausedTicks = 0;
	}

	private void submit()
	{
		final String message = createPerformanceMessage(performance);

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.GAMEMESSAGE)
			.runeLiteFormattedMessage(message)
			.build());

		reset();
	}

	/**
	 * Calculates damage dealt based on HP xp gained accounting for multipliers such as DMM mode
	 * @param diff HP xp gained
	 * @return damage dealt
	 */
	private double calculateDamageDealt(double diff)
	{
		double damageDealt = diff / HITPOINT_RATIO;
		// DeadMan mode has an XP modifier
		if (client.getWorldType().contains(WorldType.DEADMAN))
		{
			damageDealt = damageDealt / DMM_MULTIPLIER_RATIO;
		}

		// Some NPCs have an XP modifier, account for it here.
		Actor a = client.getLocalPlayer().getInteracting();
		if (!(a instanceof NPC))
		{
			// If we are interacting with nothing we may have clicked away at the perfect time fall back to last tick
			if (!(oldTarget instanceof NPC))
			{
				log.warn("Couldn't find current or past target for experienced gain...");
				return damageDealt;
			}

			a = oldTarget;
		}

		final int npcId = ((NPC) a).getId();
		return damageDealt / npcManager.getXpModifier(npcId);
	}

	private String createPerformanceMessage(final Performance p)
	{
		// Expected result: Damage Dealt: ## (Max: ##), Damage Taken: ## (Max: ##), Time Spent: ##:## (DPS: ##.##)
		return new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Damage dealt: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(numberFormat.format(p.getDamageDealt()))
			.append(ChatColorType.NORMAL)
			.append(" (Max: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(numberFormat.format(p.getHighestHitDealt()))
			.append(ChatColorType.NORMAL)
			.append("), Damage Taken: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(numberFormat.format(p.getDamageTaken()))
			.append(ChatColorType.NORMAL)
			.append(" (Max: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(numberFormat.format(p.getHighestHitTaken()))
			.append(ChatColorType.NORMAL)
			.append("), Time Spent: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(p.getHumanReadableSecondsSpent())
			.append(ChatColorType.NORMAL)
			.append(" (DPS: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.valueOf(p.getDPS()))
			.append(ChatColorType.NORMAL)
			.append(")")
			.build();
	}

	private void sendPerformance()
	{
		final PartyMember me = partyService.getLocalMember();
		if (me != null && me.getMemberId() != null)
		{
			performance.setMemberId(me.getMemberId());
			wsClient.send(performance);
		}
	}

	private void onPerformance(final Performance performance)
	{
		partyDataMap.put(performance.getMemberId(), performance);
	}

	private void onUserSync(final UserSync event)
	{
		if (isEnabled())
		{
			sendPerformance();
		}
	}

	private void onUserPart(final UserPart event)
	{
		partyDataMap.remove(event.getMemberId());
	}

	private void onPartyChanged(final PartyChanged event)
	{
		// Reset party
		partyDataMap.clear();
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("performancestats"))
		{
			return;
		}

		this.submitTimeout = config.submitTimeout();
	}
}
