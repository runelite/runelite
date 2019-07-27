/*
 * Copyright (c) 2019, Matsyir <https://github.com/matsyir>
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
package net.runelite.client.plugins.pvpperformancetracker;

import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static net.runelite.client.plugins.pvpperformancetracker.AnimationAttackStyle.None;

@PluginDescriptor(
	name = "LMS Performance Tracker",
	description = "Tracks your PvP performance by counting how many attacks you & your opponent hit off-pray (ex. used range or melee vs pray mage).",
	tags = {"pvp", "last man standing", "hybrid", "tribrid", "nh", "no honour", "pking"},
	enabledByDefault = true
)
public class PvpPerformanceTrackerPlugin extends Plugin
{
	// Delay to assume a fight is over. May seem long, but sometimes people barrage &
	// stand under for a while to eat.
	private static final Duration NEW_FIGHT_DELAY = Duration.ofSeconds(20);

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PvpPerformanceTrackerOverlay overlay;



	//public final int MAX_FIGHT_DELAY = 20000; // when no attacks happen in 20s, assume fight's over.

	private Instant lastFightTime;
	private Player currentOpponent;

	@Getter
	private PvpPerformanceStats currentFight;
	@Getter
	private List<PvpPerformanceStats> fightHistory;

	@Provides
	PvpPerformanceTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PvpPerformanceTrackerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		if (event.getSource() != client.getLocalPlayer())
		{
			return;
		}

		Actor opponent = event.getTarget();
		if (opponent != null && opponent instanceof Player &&
			Duration.between(lastFightTime, Instant.now()).compareTo(NEW_FIGHT_DELAY) > 0)
		{
			if (currentFight != null)
			{
				fightHistory.add(currentFight);
			}
			currentOpponent = (Player)opponent;
			currentFight = new PvpPerformanceStats(client.getLocalPlayer().getName(), currentOpponent.getName());
			lastFightTime = Instant.now();
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		// check if player has player opponent (or did not long ago)
		if (hasOpponent())
		{
			// if he does, check if either are attacking
			compareAnimation(client.getLocalPlayer(), currentOpponent);
			compareAnimation(currentOpponent, client.getLocalPlayer());
			  // if either is attacking, check the other player's pray, and increment the counter accordingly
		}


	}

	private boolean hasOpponent()
	{
		return currentOpponent != null;
	}

	private void compareAnimation(Player player, Player opponent)
	{
		AnimationAttackStyle animationStyle = AnimationAttackStyle.styleForAnimation(player.getAnimation());
		if (animationStyle == None)
		{
			return;
		}

		currentFight.addAttack(player.getName(), opponent.getOverheadIcon() != animationStyle.getProtection());
	}

}
