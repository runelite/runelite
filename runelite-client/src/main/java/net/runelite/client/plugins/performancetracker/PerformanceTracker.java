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

import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.plugins.performancetracker.data.ActivityInfo;
import net.runelite.client.plugins.performancetracker.data.NpcExpModifier;
import net.runelite.client.plugins.performancetracker.data.stats.CastleWars;
import net.runelite.client.plugins.performancetracker.data.stats.Performance;
import net.runelite.client.plugins.performancetracker.data.stats.TheatreOfBlood;

@Slf4j
@Singleton
public class PerformanceTracker
{
	// For every damage point dealt, 1.33 experience is given to the player's hitpoints (base rate)
	private static final double HITPOINT_RATIO = 1.33;
	private static final double DMM_MULTIPLIER_RATIO = 10;

	private ChatMessageManager chatMessageManager;
	private Client client;
	private PerformanceTrackerConfig config;

	private boolean tracking = false;
	private boolean paused = false;
	@Setter
	private boolean playingDeadManMode = false;
	@Getter
	private Performance current;

	private final List<Performance> performances = new ArrayList<>();
	private final List<String> messages = new ArrayList<>();

	// Theatre of Blood
	private int tobVarbit = 0;
	private boolean tobSpectator = false;
	// Castle Wars
	private boolean inCastleWarsGame = false;

	@Inject
	PerformanceTracker(Client client, ChatMessageManager chatMessageManager, PerformanceTrackerConfig config)
	{
		this.client = client;
		this.chatMessageManager = chatMessageManager;
		this.config = config;
	}

	public void shutDown()
	{
		disableTracking();
		messages.clear();
		performances.clear();

		tobVarbit = 0;
		tobSpectator = false;
		inCastleWarsGame = false;
	}

	/**
	 * Send all queued messages via in-game chat
	 */
	private void sendChatMessages()
	{
		for (String message : messages)
		{
			log.debug("Sending Message: {}", message);
			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.GAME)
				.runeLiteFormattedMessage(message)
				.build());
		}

		messages.clear();
	}


	/* Tracking statuses */

	public void enableTracking()
	{
		tracking = true;
		paused = false;

		if (current == null)
		{
			current = new Performance();
		}
	}

	public void disableTracking()
	{
		tracking = false;
		paused = false;
		current = null;
	}

	public void pauseTracking()
	{
		paused = true;
	}

	public void unpauseTracking()
	{
		paused = false;
	}

	public boolean isEnabled()
	{
		return tracking && !paused;
	}


	/* Tracking Data */

	// Used to determine Damage per Second & Time Elapsed
	public void secondTick()
	{
		if (isEnabled())
		{
			current.incrementSeconds();
		}
	}

	public void handleDamageTaken(double damage)
	{
		if (!isEnabled())
		{
			return;
		}

		current.addDamageTaken(damage);
	}

	public void handleDamageDealtDiff(double diff, Actor oldTarget)
	{
		if (!isEnabled())
		{
			return;
		}

		double damageDealt = calculateDamageDealt(diff, oldTarget);
		handleDamageDealt(damageDealt);
	}

	private void handleDamageDealt(double damage)
	{
		current.addDamageDealt(damage);
	}

	public void handleLocalPlayerDeath()
	{
		if (!isEnabled())
		{
			return;
		}

		// Deaths inside Theatre of Blood are handled separately
		if (tobVarbit > 1)
		{
			return;
		}

		current.addDeath();
	}

	private void submitPerformance()
	{
		performances.add(current);
		current = null;
	}

	public void reset()
	{
		if (!isEnabled() || current == null)
		{
			return;
		}

		Performance newP = new Performance();
		if (current instanceof TheatreOfBlood)
		{
			newP = new TheatreOfBlood();
		}
		else if (current instanceof CastleWars)
		{
			newP = new CastleWars();
		}

		enableTracking();
		current = newP;
	}


	/* Tracker Events */

	/**
	 * Handles region changes and triggers region-specific functionality
	 */
	public void handleRegionChange(int newRegion)
	{
		switch (newRegion)
		{
			case ActivityInfo.TOB.REGION.MAIDEN:
				// Maiden means starting a new raid
				if (config.trackTheatreOfBlood())
				{
					enableTracking();
					current = new TheatreOfBlood();
					handleTobAct(ActivityInfo.TOB.ACT.MAIDEN);
				}
				return;
			case ActivityInfo.TOB.REGION.BLOAT:
				handleTobAct(ActivityInfo.TOB.ACT.BLOAT);
				break;
			case ActivityInfo.TOB.REGION.NYLOCAS:
				handleTobAct(ActivityInfo.TOB.ACT.NYLOCAS);
				break;
			case ActivityInfo.TOB.REGION.SOTETSEG:
				handleTobAct(ActivityInfo.TOB.ACT.SOTETSEG);
				break;
			case ActivityInfo.TOB.REGION.XARPUS:
				handleTobAct(ActivityInfo.TOB.ACT.XARPUS);
				break;
			case ActivityInfo.TOB.REGION.VERZIK:
				handleTobAct(ActivityInfo.TOB.ACT.VERZIK);
				break;
			case ActivityInfo.TOB.REGION.REWARD:
				handleTobAct(ActivityInfo.TOB.ACT.REWARD);
				break;
			case ActivityInfo.TOB.REGION.LOBBY:
				if (tobVarbit != 0)
				{
					// Only handle lobby if we are in a party
					handleTobAct(ActivityInfo.TOB.ACT.LOBBY);
				}
				disableTracking(); // Disable tracking while in lobby, going to maiden will re-enable it.
				break;
			default:
				return;
		}

		sendChatMessages();
	}

	public void handleVarbitChanged()
	{
		// Theatre of Blood Varbit
		int oldTobVarbit = tobVarbit;
		tobVarbit = client.getVar(Varbits.THEATRE_OF_BLOOD);
		if (oldTobVarbit != tobVarbit)
		{
			tobVarbitChanged(oldTobVarbit);
		}
	}

	public void handleGameTick()
	{
		// Activities are checked via game tick or region change
		checkCwGame();
	}


	/* Tracker Calculations **/

	/**
	 * Return the NPC name accounting for special use cases
	 * @param target target NPC
	 * @return NPC name adjusted for special internal use cases
	 */
	private String getRealNpcName(NPC target)
	{
		String name = target.getName();

		switch (name.toUpperCase())
		{
			case "VERZIK":
				return NpcExpModifier.getNameByNpcId(target.getId());
			default:
				return name;
		}
	}

	/**
	 * Calculates damage dealt based on HP xp gained
	 * @param diff HP xp gained
	 * @return damage dealt
	 */
	private double calculateDamageDealt(double diff, Actor oldTarget)
	{
		double damageDealt = diff / HITPOINT_RATIO;

		// Determine which NPC we attacked.
		Actor a = client.getLocalPlayer().getInteracting();
		if (a == null)
		{
			// If we are interacting with nothing we may have clicked away at the perfect time
			// Fall back to the actor we were interacting with last game tick
			if (oldTarget == null)
			{
				log.warn("Couldn't find current or past target...");
				return damageDealt;
			}
			a = oldTarget;
		}
		if (!(a instanceof NPC))
		{
			return damageDealt;
		}
		NPC target = (NPC) a;

		// Account for NPCs phases by NPC id
		String targetName = getRealNpcName(target);
		log.debug("Attacking NPC named: {}", targetName);

		// Some NPCs have an XP modifier
		NpcExpModifier m = NpcExpModifier.getByName(targetName);
		if (m != null)
		{
			damageDealt = damageDealt / NpcExpModifier.calculateBonus(m);
		}

		// DeadMan mode has an XP modifier
		if (playingDeadManMode)
		{
			damageDealt = damageDealt / DMM_MULTIPLIER_RATIO;
		}
		return damageDealt;
	}


	/* Theatre of Blood Section */

	// ToB deaths are handled via chat message instead of LocalPlayerDeath as it is inaccurate.
	public void handleTheatreOfBloodDeath()
	{
		if (!isEnabled())
		{
			return;
		}

		current.addDeath();
	}

	/**
	 * Handles changes to the Theatre of Blood Varbit
	 * @param old previous Theatre of Blood varbit value
	 */
	private void tobVarbitChanged(int old)
	{
		// TODO: Figure out a way to determine if they are logging back into a raid
		switch (tobVarbit)
		{
			case ActivityInfo.TOB.STATE.DEFAULT:
				if (old == ActivityInfo.TOB.STATE.INSIDE)
				{
					tobSpectator = false;
					return;
				}
				disableTracking();
				break;
			case ActivityInfo.TOB.STATE.PARTY:
				// Joined party, nothing we need to do?
				break;
			case ActivityInfo.TOB.STATE.INSIDE:
				// Inside the Theatre, are they a spectator?
				if (old == ActivityInfo.TOB.STATE.DEFAULT)
				{
					tobSpectator = true;
					return;
				}
				break;
			case ActivityInfo.TOB.STATE.SPECTATING_MEMBER:
				if (old == ActivityInfo.TOB.STATE.DEFAULT)
				{
					log.debug("Logged out and returned to non-existing raid");
					return;
				}
				break;
		}
	}

	private void handleTobAct(int act)
	{
		if (!config.trackTheatreOfBlood() || tobSpectator)
		{
			return;
		}

		if (!(current instanceof TheatreOfBlood))
		{
			log.warn("Tried handling ToB Act on non-TheatreOfBlood performance: {} | {}", act, current);
			return;
		}

		TheatreOfBlood tob = (TheatreOfBlood) current;

		List<String> ms = new ArrayList<>();

		// Went to new room which means last room was completed.
		switch (act)
		{
			// Reward Region
			case ActivityInfo.TOB.ACT.REWARD:
				tob.setCompleted(true);
				// Show verzik room stats upon entering reward room
				ms.add(PerformanceTrackerMessages.tobRoomMessage(tob));
				ms.add(PerformanceTrackerMessages.tobCurrentMessage(tob));
				break;
			// Starting Maiden
			case ActivityInfo.TOB.ACT.MAIDEN:
				break;
			// Back to lobby, show total stats
			case ActivityInfo.TOB.ACT.LOBBY:
				// If we didn't complete the raid show the last rooms stats as well
				if (!tob.isCompleted())
				{
					ms.add(PerformanceTrackerMessages.tobRoomMessage(tob));
					ms.add(PerformanceTrackerMessages.tobCurrentMessage(tob));
				}
				submitPerformance();
				ms.addAll(PerformanceTrackerMessages.tobTotalMessage(performances));
				break;
			default:
				// Between each room display previous stats
				ms.add(PerformanceTrackerMessages.tobRoomMessage(tob));
				ms.add(PerformanceTrackerMessages.tobCurrentMessage(tob));
				tob.nextRoom(act);
		}

		messages.addAll(ms);
		log.debug("Starting act {}", act);
	}


	/* Castle Wars Section */

	// Check for Time Remaining in-game widget.
	private void checkCwGame()
	{
		if (!config.trackCastleWars())
		{
			if (inCastleWarsGame)
			{
				// Turned off config while inside a game
				finishCwGame();
			}
			return;
		}

		WidgetInfo info;
		switch (client.getLocalPlayer().getTeam())
		{
			case ActivityInfo.CW.TEAM.SARA:
				info = WidgetInfo.CW_TIME_REMAINING_SARA;
				break;
			case ActivityInfo.CW.TEAM.ZAM:
				info = WidgetInfo.CW_TIME_REMAINING_ZAM;
				break;
			default:
				return;
		}

		Widget gameTimeRemaining = client.getWidget(info);
		boolean old = inCastleWarsGame;
		inCastleWarsGame = gameTimeRemaining != null && !gameTimeRemaining.isHidden();
		if (old != inCastleWarsGame)
		{
			toggleCastleWarsGame();
		}
	}

	private void toggleCastleWarsGame()
	{
		if (inCastleWarsGame)
		{
			enableTracking();

			CastleWars game = new CastleWars();
			game.setTeam(client.getLocalPlayer().getTeam());
			current = game;
		}
		else
		{
			finishCwGame();
		}
	}

	private void finishCwGame()
	{
		CastleWars game = (CastleWars) current;

		game.setSaraScore(client.getVar(Varbits.CW_SARA_SCORE));
		game.setZamScore(client.getVar(Varbits.CW_ZAM_SCORE));

		messages.addAll(PerformanceTrackerMessages.castleWarsMessage(game));
		submitPerformance();
		sendChatMessages();
		disableTracking();
	}
}
