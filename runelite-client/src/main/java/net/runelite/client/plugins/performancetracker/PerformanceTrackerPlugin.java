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

import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.performancetracker.overlays.GenericOverlay;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Performance Tracker",
	description = "Shows your current performance stats",
	tags = {"performance", "stats", "activity", "tracker"}
)
@Slf4j
public class PerformanceTrackerPlugin extends Plugin
{
	private static final Pattern DEATH_TEXT = Pattern.compile("You have died. Death count: \\d.");

	@Inject
	private Client client;

	@Inject
	private GenericOverlay genericOverlay;

	@Provides
	PerformanceTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PerformanceTrackerConfig.class);
	}

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PerformanceTracker performanceTracker;

	private boolean loginTick = false;
	private double hpExp = 0;
	private int region = -1;

	private Actor oldTarget;

	@Override
	protected void startUp()
	{
		overlayManager.add(genericOverlay);
	}

	@Override
	protected void shutDown()
	{
		// Not sure if clearing the tracker data is necessary on shutdown.
		performanceTracker.shutDown();
		overlayManager.remove(genericOverlay);
	}

	// Help us calculate damage per second.
	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void secondTick()
	{
		performanceTracker.secondTick();
	}

	@Subscribe
	protected void onConfigChanged(ConfigChanged c)
	{
		if (c.getGroup().equals("PerformanceTracker"))
		{
			if (c.getKey().equals("resetButton"))
			{
				performanceTracker.reset();
			}
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGGED_IN:
				break;
			case LOGIN_SCREEN:
				performanceTracker.disableTracking();
			case HOPPING:
				loginTick = true;
			default:
				return;
		}

		performanceTracker.setPlayingDeadManMode(client.getWorldType().contains(WorldType.DEADMAN));

		// Region Change
		int oldRegion = region;
		region = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
		if (oldRegion != region)
		{
			performanceTracker.handleRegionChange(region);
		}
	}

	// Calculate Damage Taken
	@Subscribe
	protected void onHitsplatApplied(HitsplatApplied e)
	{
		if (!performanceTracker.isEnabled())
		{
			return;
		}

		if (e.getActor().equals(client.getLocalPlayer()))
		{
			performanceTracker.handleDamageTaken(e.getHitsplat().getAmount());
		}
	}

	// Calculate Damage Dealt
	@Subscribe
	protected void onExperienceChanged(ExperienceChanged c)
	{
		if (!performanceTracker.isEnabled())
		{
			return;
		}

		if (c.getSkill().equals(Skill.HITPOINTS))
		{
			double oldExp = hpExp;
			hpExp = client.getSkillExperience(Skill.HITPOINTS);
			if (loginTick)
			{
				// We've updated the stored HP but we need to ignore this XP drop.
				return;
			}

			double diff = hpExp - oldExp;
			if (diff < 1)
			{
				return;
			}

			performanceTracker.handleDamageDealtDiff(diff, oldTarget);
		}
	}

	// Ensure we know who we were last interacting with.
	@Subscribe
	public void onGameTick(GameTick tick)
	{
		oldTarget = client.getLocalPlayer().getInteracting();
		if (loginTick)
		{
			loginTick = false;
		}

		performanceTracker.handleGameTick();
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		if (!performanceTracker.isEnabled())
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
				performanceTracker.handleDamageDealtDiff(exp, oldTarget);
			}

			client.setIntStackSize(intStackSize - 2);
		}
	}

	@Subscribe
	protected void onChatMessage(ChatMessage m)
	{
		if (m.getType() != ChatMessageType.SERVER)
		{
			return;
		}
		
		// Theatre of Blood death check
		String message = Text.removeTags(m.getMessage());
		Matcher match = DEATH_TEXT.matcher(message);
		if (match.matches())
		{
			performanceTracker.handleTheatreOfBloodDeath();
		}
	}

	@Subscribe
	protected void onLocalPlayerDeath(LocalPlayerDeath e)
	{
		if (performanceTracker.isEnabled())
		{
			performanceTracker.handleLocalPlayerDeath();
		}
	}

	@Subscribe
	protected void onVarbitChanged(VarbitChanged e)
	{
		performanceTracker.handleVarbitChanged();
	}

	private void enableTracking()
	{
		if (performanceTracker.isEnabled())
		{
			return;
		}

		// Grab Starting EXP
		hpExp = client.getSkillExperience(Skill.HITPOINTS);

		performanceTracker.enableTracking();
	}

	private void disableTracking()
	{
		performanceTracker.disableTracking();
	}


}
