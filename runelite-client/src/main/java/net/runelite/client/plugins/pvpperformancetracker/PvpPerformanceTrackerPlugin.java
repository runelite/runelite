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
import net.runelite.client.ui.overlay.OverlayManager;

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
    private abstract class PvpPlayer implements Player
    {
        public boolean isAttacking;
    }
	// Delay to assume a fight is over. May seem long, but sometimes people barrage &
	// stand under for a while to eat.
	private static final Duration NEW_FIGHT_DELAY = Duration.ofSeconds(21);

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PvpPerformanceTrackerOverlay overlay;

	private PvpPerformanceTrackerPanel panel;

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

	// Keep track of a new player's target using this event.
	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		if (event.getSource() != client.getLocalPlayer())
		{
			return;
		}

		Actor opponent = event.getTarget();
		if (opponent != null && opponent instanceof Player && !hasOpponent())
		{
			if (currentFight != null)
			{
				fightHistory.add(currentFight);
			}
			currentOpponent = (Player)opponent;
			currentFight = new FightPerformance(client.getLocalPlayer().getName(), currentOpponent.getName());
			lastFightTime = Instant.now();
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		// check if local player has a Player target, or did recently.
		if (hasOpponent())
		{
			// if there is an opponent, check the player's animation for an attack,
			// and also check the opponent's animation for an attack. If they attacked,
			// the function will also add the attack to the current fight stats, taking
			// into account the opponent's overhead prayer.
            checkPlayerAnimation();
            checkOpponentAnimation();
		}
	}

	private boolean hasOpponent()
	{
		// If there was no fight actions in the last 20s (NEW_FIGHT_DELAY), set opponent to
		// null, which will get set next time the player targets a Player.
		if (Duration.between(lastFightTime, Instant.now()).compareTo(NEW_FIGHT_DELAY) > 0 ||
            (currentOpponent != null && currentOpponent.getAnimation() != AnimationID.DEATH))
		{
			currentOpponent = null;
		}
		return currentOpponent != null;
	}


//	private void checkAnimation(boolean forPlayer)
//	{
//		Player player = forPlayer ? client.getLocalPlayer() : currentOpponent;
//		Player opponent = forPlayer ? currentOpponent : client.getLocalPlayer();
//		AnimationAttackStyle animationStyle = AnimationAttackStyle.styleForAnimation(player.getAnimation());
//		if (animationStyle == None || animationStyle == null)
//		{
//			// shorthand for: if (forPlayer) { pAttacking = false } else { oAttacking = false }
//			playerAttacking = !forPlayer && playerAttacking;
//			opponentAttacking = forPlayer && opponentAttacking;
//			return;
//		}
//
//		// Only apply new attack if not currently attacking (to avoid duplicate attacks with 1 long animation)
//		if (forPlayer ? !playerAttacking : !opponentAttacking)
//		{
//			lastFightTime = Instant.now();
//			currentFight.addAttack(player.getName(), opponent.getOverheadIcon() != animationStyle.getProtection());
//
//			// similar shorthand as above, but = true.
//			playerAttacking = forPlayer || playerAttacking;
//			opponentAttacking = !forPlayer || opponentAttacking;
//		}
//	}

    // check player's animation, and if they are doing an attack animation, add an attack
    // to the current fight stats. Check opponent's overhead to see if the attack was"successful".
    // forPlayer bool: when true, checking animations for the local player. False will check the opponent.
	private void checkPlayerAnimation()
	{
		Player player = client.getLocalPlayer();
		Player opponent = currentOpponent;
		AnimationAttackStyle animationStyle = AnimationAttackStyle.styleForAnimation(player.getAnimation());
		if (animationStyle == None || animationStyle == null)
		{
			playerAttacking = false;
			return;
		}

		// Only apply new attack if not currently attacking (to avoid duplicate attacks with 1 long animation)
		if (playerAttacking)
		{
			lastFightTime = Instant.now();
			currentFight.addAttack(player.getName(), opponent.getOverheadIcon() != animationStyle.getProtection());
			playerAttacking = true;
		}
	}

	// same as above but for opponent.
    private void checkOpponentAnimation()
    {
        Player player = client.getLocalPlayer();
        Player opponent = currentOpponent;
        AnimationAttackStyle animationStyle = AnimationAttackStyle.styleForAnimation(opponent.getAnimation());
        if (animationStyle == None || animationStyle == null)
        {
            opponentAttacking = false;
            return;
        }

        // Only apply new attack if not currently attacking (to avoid duplicate attacks with 1 long animation)
        if (opponentAttacking)
        {
            lastFightTime = Instant.now();
            currentFight.addAttack(opponent.getName(), player.getOverheadIcon() != animationStyle.getProtection());
            opponentAttacking = true;
        }
    }

}
