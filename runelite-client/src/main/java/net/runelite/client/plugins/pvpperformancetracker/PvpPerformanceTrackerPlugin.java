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

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

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
	// stand under for a while to eat. Fights will automatically end when either player dies.
	private static final Duration NEW_FIGHT_DELAY = Duration.ofSeconds(21);

	// Last man standing map regions (thanks to loottracker plugin)
	private static final Set<Integer> LAST_MAN_STANDING_REGIONS = ImmutableSet.of(13658, 13659, 13914, 13915, 13916);

	@Inject
	private PvpPerformanceTrackerConfig config;
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PvpPerformanceTrackerOverlay overlay;

	// the last time someone in the fight attacked, or when the fight was initiated.
	private Instant lastFightTime;
	private Player currentOpponent;
	private boolean playerAttacking;
	private boolean opponentAttacking;

	@Getter
	private FightPerformance currentFight;
	@Getter
	private List<FightPerformance> fightHistory;

	@Provides
	PvpPerformanceTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PvpPerformanceTrackerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		lastFightTime = Instant.MIN;
		playerAttacking = false;
		opponentAttacking = false;
		fightHistory = new ArrayList<>();
		currentFight = FightPerformance.getTestInstance(true);
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	// Keep track of a player's new target using this event.
	// It's worth noting that if you aren't in a fight, all player interactions including
	// trading & following will trigger a new fight and a new opponent. Due to this, set the
	// lastFightTime in the past to only be 3 seconds after the time NEW_FIGHT_DELAY would trigger
	// and unset the opponent, in case the player follows a different player before actually starting
	// a fight or getting attacked. In other words, remain skeptical of the validity of this event.
	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		// if the event source is null, the client player already has an opponent, or the event
		// source & target aren't players, skip any processing.
		if (event.getSource() == null || hasOpponent() || !(event.getSource() instanceof Player) ||
			!(event.getTarget() instanceof Player))
		{
			return;
		}

		Actor opponent;

		// If the event source is the player, then it is the player interacting with their potential opponent.
		if (event.getSource() == client.getLocalPlayer())
		{
			opponent = event.getTarget();
		}
		else if (event.getTarget() == client.getLocalPlayer())
		{
			opponent = event.getSource();
		}
		else
		{
			return;
		}

		if (currentFight != null)
		{
			fightHistory.add(currentFight);
		}
		currentOpponent = (Player) opponent;
		currentFight = new FightPerformance(client.getLocalPlayer().getName(), currentOpponent.getName());
		lastFightTime = Instant.now().minusSeconds(NEW_FIGHT_DELAY.getSeconds() - 3);
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (config.restrictToLms() && !isAtLMS())
		{
			return;
		}

		// check if local player has a Player target, or did recently.
		if (hasOpponent())
		{
			// if there is an opponent, check the player's animation for an attack,
			// and also check the opponent's animation for an attack. If they attacked,
			// the function will also add the attack to the current fight stats, taking
			// into account the opponent's overhead prayer.
			checkAnimation(true);
			checkAnimation(false);
		}
	}

	// Returns true if the player has an opponent. Will also set the currentOpponent to null if the player
	// should no longer have a target (hasn't fought in NEW_FIGHT_DELAY, or either player died)
	private boolean hasOpponent()
	{
		if (currentOpponent != null && currentOpponent.getAnimation() == AnimationID.DEATH)
		{
			currentFight.opponentDied();
			fightHistory.add(currentFight);
			currentFight = null;
			currentOpponent = null;
		}
		if (client.getLocalPlayer().getAnimation() == AnimationID.DEATH)
		{
			currentFight.playerDied();
			fightHistory.add(currentFight);
			currentFight = null;
			currentOpponent = null;
		}
		// If there was no fight actions in the last 20s (NEW_FIGHT_DELAY), set opponent to
		// null, which will get set next time the player targets a Player.
		if (Duration.between(lastFightTime, Instant.now()).compareTo(NEW_FIGHT_DELAY) > 0)
		{
			fightHistory.add(currentFight);
			currentFight = null;
			currentOpponent = null;
		}
		return currentOpponent != null;
	}

	// check player's animation, and if they are doing an attack animation, add an attack
	// to the current fight stats. Check opponent's overhead to see if the attack was "successful".
	// forPlayer bool: when true, checking animations for the local player. False will check the opponent.
	private void checkAnimation(boolean forPlayer)
	{
		Player player = forPlayer ? client.getLocalPlayer() : currentOpponent;
		Player opponent = forPlayer ? currentOpponent : client.getLocalPlayer();
		AnimationAttackStyle animationStyle = AnimationAttackStyle.styleForAnimation(player.getAnimation());
		if (animationStyle == None || animationStyle == null)
		{
			// shorthand for: if (forPlayer) { pAttacking = false } else { oAttacking = false }
			playerAttacking = !forPlayer && playerAttacking;
			opponentAttacking = forPlayer && opponentAttacking;
			return;
		}

		// Only apply new attack if not currently attacking (to avoid duplicate attacks with 1 long animation)
		if (forPlayer ? !playerAttacking : !opponentAttacking)
		{
			lastFightTime = Instant.now();
			currentFight.addAttack(player.getName(), opponent.getOverheadIcon() != animationStyle.getProtection());

			// similar shorthand as above, but = true.
			playerAttacking = forPlayer || playerAttacking;
			opponentAttacking = !forPlayer || opponentAttacking;
		}
	}

	/**
	 * Is player at the Last Man Standing minigame
	 * (Thanks to loottracker plugin)
	 */
	protected boolean isAtLMS()
	{
		final int[] mapRegions = client.getMapRegions();

		for (int region : LAST_MAN_STANDING_REGIONS)
		{
			if (ArrayUtils.contains(mapRegions, region))
			{
				return true;
			}
		}

		return false;
	}

}
