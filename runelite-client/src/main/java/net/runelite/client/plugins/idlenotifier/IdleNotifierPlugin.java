/*
 * Copyright (c) 2016-2017, Abel Briggs
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * Copyright (c) 2018, Magic fTail
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
package net.runelite.client.plugins.idlenotifier;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Actor;
import static net.runelite.api.AnimationID.IDLE;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Hitsplat;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Idle Notifier",
	description = "Send a notification when going idle, or when HP/Prayer reaches a threshold",
	tags = {"health", "hitpoints", "notifications", "prayer"}
)
public class IdleNotifierPlugin extends Plugin
{
	private static final int LOGOUT_WARNING_AFTER_TICKS = 280 * 50; // 4 minutes and 40 seconds
	private static final int LOGOUT_WARNING_AFTER_TICKS_IN_COMBAT = 1140 * 50; //19 minutes
	private static final int HIGHEST_MONSTER_ATTACK_SPEED = 8; //Except Scarab Mage, but they are with other monsters
	private static final Duration SIX_HOUR_LOGOUT_WARNING_AFTER_DURATION = Duration.ofMinutes(340);

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private IdleNotifierConfig config;

	private Actor lastOpponent;
	private Instant lastAnimating;
	private Instant lastInteracting;
	private boolean notifyIdle = false;
	private boolean notifyHitpoints = true;
	private boolean notifyPrayer = true;
	private boolean notifyIdleLogout = true;
	private boolean notify6HourLogout = true;
	private boolean inCombat = false;

	private Instant sixHourWarningTime;
	private boolean ready;
	private SkillingAnimations currentActivity;
	private int countdown = 0;

	@Provides
	IdleNotifierConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(IdleNotifierConfig.class);
	}

	private boolean getSkillEnabled()
	{
		if (currentActivity == null)
		{
			return false;
		}

		switch (currentActivity)
		{
			case WOODCUTTING:
				return config.woodcuttingIdle();
			case COOKING:
				return config.cookingIdle();
			case CRAFTING:
				return config.craftingIdle();
			case FLETCHING:
				return config.fletchingIdle();
			case SMITHING:
				return config.smithingIdle();
			case FISHING:
				return config.fishingIdle();
			case MINING:
				return config.miningIdle();
			case HERBLORE:
				return config.herbloreIdle();
			case PRAYER:
				return config.prayerIdle();
			case MAGIC:
				return config.magicIdle();
			default:
				return false;
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Player localPlayer = client.getLocalPlayer();
		if (localPlayer != event.getActor())
		{
			return;
		}

		int animation = localPlayer.getAnimation();

		final SkillingAnimations currentSkillAnimation = SkillingAnimations.getSkillingAnimations(animation);

		if (currentSkillAnimation == null)
		{
			return;
		}

		resetTimers();
		currentActivity = currentSkillAnimation;
		notifyIdle = true;
	}

	@Subscribe
	public void onHitsplat(HitsplatApplied event)
	{
		final Hitsplat hitsplat = event.getHitsplat();

		if (event.getActor() != client.getLocalPlayer())
		{
			return;
		}

		if (hitsplat.getHitsplatType() == Hitsplat.HitsplatType.DAMAGE
			|| hitsplat.getHitsplatType() == Hitsplat.HitsplatType.BLOCK)
		{
			inCombat = true;
			countdown = HIGHEST_MONSTER_ATTACK_SPEED;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		lastInteracting = null;

		GameState state = gameStateChanged.getGameState();

		switch (state)
		{
			case LOGGING_IN:
			case HOPPING:
			case CONNECTION_LOST:
				ready = true;
				break;
			case LOGGED_IN:
				if (ready)
				{
					sixHourWarningTime = Instant.now().plus(SIX_HOUR_LOGOUT_WARNING_AFTER_DURATION);
					ready = false;
				}
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		final Player local = client.getLocalPlayer();
		final Duration waitDuration = Duration.ofMillis(config.getIdleNotificationDelay());

		if (countdown > 0)
		{
			countdown = countdown - 1;
		}
		else
		{
			inCombat = false;
		}

		if (client.getGameState() != GameState.LOGGED_IN || local == null)
		{
			return;
		}

		if (config.idleLogout() && checkIdleLogout())
		{
			notifier.notify("[" + local.getName() + "] is about to log out from idling too long!");
		}

		if (check6hrLogout())
		{
			notifier.notify("[" + local.getName() + "] is about to log out from being online for 6 hours!");
		}

		if (checkAnimationIdle(waitDuration, local) && getSkillEnabled())
		{
			notifier.notify("[" + local.getName() + "] is no longer " + currentActivity.getActivity());
		}

		if (config.combatIdle() && checkOutOfCombat(waitDuration, local))
		{
			notifier.notify("[" + local.getName() + "] is now out of combat!");
		}

		if (checkLowHitpoints())
		{
			notifier.notify("[" + local.getName() + "] has low hitpoints!");
		}

		if (checkLowPrayer())
		{
			notifier.notify("[" + local.getName() + "] has low prayer!");
		}
	}

	private boolean checkLowHitpoints()
	{
		if (config.getHitpointsThreshold() == 0)
		{
			return false;
		}
		if (client.getRealSkillLevel(Skill.HITPOINTS) > config.getHitpointsThreshold())
		{
			if (client.getBoostedSkillLevel(Skill.HITPOINTS) + client.getVar(Varbits.NMZ_ABSORPTION) <= config.getHitpointsThreshold())
			{
				if (!notifyHitpoints)
				{
					notifyHitpoints = true;
					return true;
				}
			}
			else
			{
				notifyHitpoints = false;
			}
		}

		return false;
	}

	private boolean checkLowPrayer()
	{
		if (config.getPrayerThreshold() == 0)
		{
			return false;
		}
		if (client.getRealSkillLevel(Skill.PRAYER) > config.getPrayerThreshold())
		{
			if (client.getBoostedSkillLevel(Skill.PRAYER) <= config.getPrayerThreshold())
			{
				if (!notifyPrayer)
				{
					notifyPrayer = true;
					return true;
				}
			}
			else
			{
				notifyPrayer = false;
			}
		}

		return false;
	}

	private boolean checkOutOfCombat(Duration waitDuration, Player local)
	{
		Actor opponent = local.getInteracting();
		boolean isPlayer = opponent instanceof Player;

		if (opponent != null
			&& !isPlayer
			&& opponent.getCombatLevel() > 0)
		{
			resetTimers();
			lastOpponent = opponent;
		}
		else if (opponent == null)
		{
			lastOpponent = null;
		}

		if (lastOpponent != null && opponent == lastOpponent)
		{
			lastInteracting = Instant.now();
		}

		if (lastInteracting != null && Instant.now().compareTo(lastInteracting.plus(waitDuration)) >= 0)
		{
			lastInteracting = null;
			return true;
		}

		return false;
	}

	private boolean checkIdleLogout()
	{
		if (client.getMouseIdleTicks() > LOGOUT_WARNING_AFTER_TICKS
			&& client.getKeyboardIdleTicks() > LOGOUT_WARNING_AFTER_TICKS)
		{
			if (inCombat)
			{
				if (client.getMouseIdleTicks() > LOGOUT_WARNING_AFTER_TICKS_IN_COMBAT
					&& client.getKeyboardIdleTicks() > LOGOUT_WARNING_AFTER_TICKS_IN_COMBAT && notifyIdleLogout)
				{
					notifyIdleLogout = false;
					return true;
				}
			}
			else if (notifyIdleLogout)
			{
				notifyIdleLogout = false;
				return true;
			}
		}
		else
		{
			notifyIdleLogout = true;
		}

		return false;
	}

	private boolean check6hrLogout()
	{
		if (sixHourWarningTime == null)
		{
			return false;
		}

		if (Instant.now().compareTo(sixHourWarningTime) >= 0)
		{
			if (notify6HourLogout)
			{
				notify6HourLogout = false;
				return true;
			}
		}
		else
		{
			notify6HourLogout = true;
		}

		return false;
	}

	private boolean checkAnimationIdle(Duration waitDuration, Player local)
	{
		if (notifyIdle)
		{
			if (lastAnimating != null)
			{
				if (Instant.now().compareTo(lastAnimating.plus(waitDuration)) >= 0)
				{
					notifyIdle = false;
					lastAnimating = null;
					return true;
				}
			}
			else if (local.getAnimation() == IDLE)
			{
				lastAnimating = Instant.now();
			}
		}

		return false;
	}

	private void resetTimers()
	{
		// Reset animation idle timer
		notifyIdle = false;
		lastAnimating = null;

		// Reset combat idle timer
		lastOpponent = null;
		lastInteracting = null;
	}
}
