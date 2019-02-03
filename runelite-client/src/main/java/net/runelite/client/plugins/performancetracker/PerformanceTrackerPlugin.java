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
package net.runelite.client.plugins.performancetracker;

import java.text.DecimalFormat;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ws.PartyService;
import net.runelite.client.ws.WSClient;

@PluginDescriptor(
	name = "Performance Tracker",
	description = "Tracks & displays your current PvM performance stats",
	tags = {"performance", "tracker", "stats", "dps", "damage"}
)
@Slf4j
public class PerformanceTrackerPlugin extends Plugin
{
	private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#,###");
	// For every damage point dealt 1.33 experience is given to the player's hitpoints (base rate)
	private static final double HITPOINT_RATIO = 1.33;
	private static final double DMM_MULTIPLIER_RATIO = 10;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private PerformanceTrackerOverlay performanceTrackerOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PartyService party;

	@Inject
	private WSClient wsClient;

	private double hpExp = 0;
	private int region = -1;
	private boolean loginTick = false;
	private Actor oldTarget;

	@Getter
	private Performance current;
	private PTRegion currentPTRegion;
	@Getter
	private boolean paused = false;
	@Getter
	private boolean tracking = false;

	@Getter
	private Map<String, Performance> partyPerformances = new HashMap<>();

	@Override
	protected void startUp()
	{
		overlayManager.add(performanceTrackerOverlay);
		wsClient.registerMessage(Performance.class);
		if (client.getGameState().equals(GameState.LOGGED_IN))
		{
			region = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
			handleRegionChange();
		}
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(performanceTrackerOverlay);
		wsClient.unregisterMessage(Performance.class);
		disableTracking();
		currentPTRegion = null;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGGED_IN:
				break;
			case LOGIN_SCREEN:
				loginTick = true;
				disableTracking();
			default:
				return;
		}

		// Region Change
		final int oldRegion = region;
		region = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
		if (oldRegion != region || loginTick)
		{
			// Performance Tracker is Enabled/Disabled by Region Changes.
			handleRegionChange();
		}
	}

	// Calculate Damage Taken
	@Subscribe
	protected void onHitsplatApplied(HitsplatApplied e)
	{
		if (!isEnabled())
		{
			return;
		}

		if (e.getActor().equals(client.getLocalPlayer()))
		{
			current.addDamageTaken(e.getHitsplat().getAmount());
		}
	}

	// Calculate Damage Dealt
	@Subscribe
	protected void onExperienceChanged(ExperienceChanged c)
	{
		if (!isEnabled())
		{
			return;
		}

		if (loginTick)
		{
			return;
		}

		if (c.getSkill().equals(Skill.HITPOINTS))
		{
			final double oldExp = hpExp;
			hpExp = client.getSkillExperience(Skill.HITPOINTS);

			final double diff = hpExp - oldExp;
			if (diff < 1)
			{
				return;
			}


			final double damageDealt = calculateDamageDealt(diff);
			current.addDamageDealt(damageDealt);
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		loginTick = false;
		oldTarget = client.getLocalPlayer().getInteracting();
		if (tracking && !current.isStarted() && (client.getLocalPlayer().getInteracting() instanceof NPC))
		{
			paused = false;
			current.setStarted(true);
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		if (!isEnabled())
		{
			return;
		}

		final String eventName = e.getEventName();

		// Handles Fake XP drops (Ironman, DMM Cap, 200m xp, etc)
		if (eventName.equals("fakeXpDrop"))
		{
			final int[] intStack = client.getIntStack();
			final int intStackSize = client.getIntStackSize();

			final int skillId = intStack[intStackSize - 2];
			final Skill skill = Skill.values()[skillId];
			if (skill.equals(Skill.HITPOINTS))
			{
				final int exp = intStack[intStackSize - 1];
				current.addDamageDealt(calculateDamageDealt(exp));
			}

			client.setIntStackSize(intStackSize - 2);
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void secondTick()
	{
		if (!isEnabled())
		{
			return;
		}

		current.incrementSeconds();
		if (!party.getMembers().isEmpty())
		{
			current.setMemberId(party.getLocalMember().getMemberId());
			wsClient.send(current);
		}
	}

	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked c)
	{
		if (!c.getOverlay().equals(performanceTrackerOverlay))
		{
			return;
		}

		switch (c.getEntry().getOption())
		{
			case "Pause":
				togglePaused();
			case "Reset":
				resetTracker();
		}
	}

	@Subscribe
	public void onPartyChanged(final PartyChanged event)
	{
		// Reset party
		partyPerformances.clear();
	}

	@Subscribe
	public void onPerformance(Performance p)
	{
		log.info("Received performance: {}", p);
		partyPerformances.put(party.getMemberById(p.getMemberId()).getName(), p);
	}

	/**
	 * Calculates damage dealt based on HP xp gained
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
				log.warn("Couldn't find current or past target...");
				return damageDealt;
			}

			a = oldTarget;
		}

		NPC target = (NPC) a;
		return damageDealt / NpcExpModifier.getByNpcId(target.getId());
	}

	/**
	 * Tracking is enabled/disabled based on region change
	 */
	private void handleRegionChange()
	{
		final PTRegion oldRegion = currentPTRegion;
		currentPTRegion = PTRegion.map.get(region);

		// Either entered, left, or changed tracked region
		if (oldRegion != currentPTRegion)
		{
			if (oldRegion != null)
			{
				submitPerformance();
			}

			if (currentPTRegion != null)
			{
				enableTracking();
			}
			else
			{
				disableTracking();
			}
		}
	}

	public boolean isEnabled()
	{
		return tracking && !paused;
	}

	private void submitPerformance()
	{
		if (current != null)
		{
			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.GAME)
				.runeLiteFormattedMessage(createPerformanceMessage(current))
				.build());
			current = null;
		}
	}

	private void enableTracking()
	{
		tracking = true;
		// Start paused?
		paused = true;

		if (current == null)
		{
			current = new Performance();
			hpExp = client.getSkillExperience(Skill.HITPOINTS);
		}
	}

	private void disableTracking()
	{
		tracking = false;
		paused = false;
		current = null;
	}

	void togglePaused()
	{
		if (!tracking)
		{
			return;
		}

		paused = !paused;
		current.setStarted(true);
	}

	void resetTracker()
	{
		if (!tracking || current == null)
		{
			return;
		}

		current = null;
		enableTracking();
	}

	// Generic chat message for all performances
	private static String createPerformanceMessage(Performance a)
	{
		return new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Damage dealt: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(a.getDamageDealt()))
			.append(ChatColorType.NORMAL)
			.append(" (Max: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(a.getHighestHitDealt()))
			.append(ChatColorType.NORMAL)
			.append("), Damage Taken: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(a.getDamageTaken()))
			.append(ChatColorType.NORMAL)
			.append(" (Max: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(a.getHighestHitTaken()))
			.append(ChatColorType.NORMAL)
			.append("), Time Spent: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(a.getReadableSecondsSpent())
			.append(ChatColorType.NORMAL)
			.append(" (DPS: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.valueOf(a.getDPS()))
			.append(ChatColorType.NORMAL)
			.append(")")
			.build();
	}
}
