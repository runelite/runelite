/*
 * Copyright (c) 2016-2017, Abel Briggs
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
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
import static net.runelite.api.AnimationID.*;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Idle Notifier"
)
public class IdleNotifierPlugin extends Plugin
{
	private static final int LOGOUT_WARNING_AFTER_TICKS = 14000; // 4 minutes and 40 seconds
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

	private Instant sixHourWarningTime;
	private boolean ready;

	@Provides
	IdleNotifierConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(IdleNotifierConfig.class);
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
		switch (animation)
		{
			/* Woodcutting */
			case WOODCUTTING_BRONZE:
			case WOODCUTTING_IRON:
			case WOODCUTTING_STEEL:
			case WOODCUTTING_BLACK:
			case WOODCUTTING_MITHRIL:
			case WOODCUTTING_ADAMANT:
			case WOODCUTTING_RUNE:
			case WOODCUTTING_DRAGON:
			case WOODCUTTING_INFERNAL:
			case WOODCUTTING_3A_AXE:
			/* Cooking(Fire, Range) */
			case COOKING_FIRE:
			case COOKING_RANGE:
			case COOKING_WINE:
			/* Crafting(Gem Cutting, Glassblowing, Spinning) */
			case GEM_CUTTING_OPAL:
			case GEM_CUTTING_JADE:
			case GEM_CUTTING_REDTOPAZ:
			case GEM_CUTTING_SAPPHIRE:
			case GEM_CUTTING_EMERALD:
			case GEM_CUTTING_RUBY:
			case GEM_CUTTING_DIAMOND:
			case CRAFTING_GLASSBLOWING:
			case CRAFTING_SPINNING:
			/* Fletching(Cutting, Stringing) */
			case FLETCHING_BOW_CUTTING:
			case FLETCHING_STRING_NORMAL_SHORTBOW:
			case FLETCHING_STRING_OAK_SHORTBOW:
			case FLETCHING_STRING_WILLOW_SHORTBOW:
			case FLETCHING_STRING_MAPLE_SHORTBOW:
			case FLETCHING_STRING_YEW_SHORTBOW:
			case FLETCHING_STRING_MAGIC_SHORTBOW:
			case FLETCHING_STRING_NORMAL_LONGBOW:
			case FLETCHING_STRING_OAK_LONGBOW:
			case FLETCHING_STRING_WILLOW_LONGBOW:
			case FLETCHING_STRING_MAPLE_LONGBOW:
			case FLETCHING_STRING_YEW_LONGBOW:
			case FLETCHING_STRING_MAGIC_LONGBOW:
			/* Smithing(Anvil, Furnace, Cannonballs */
			case SMITHING_ANVIL:
			case SMITHING_SMELTING:
			case SMITHING_CANNONBALL:
			/* Fishing */
			case FISHING_NET:
			case FISHING_BIG_NET:
			case FISHING_HARPOON:
			case FISHING_BARBTAIL_HARPOON:
			case FISHING_DRAGON_HARPOON:
			case FISHING_CAGE:
			case FISHING_POLE_CAST:
			case FISHING_INFERNAL_HARPOON:
			case FISHING_OILY_ROD:
			case FISHING_KARAMBWAN:
			case FISHING_CRUSHING_INFERNAL_EELS:
			case FISHING_BAREHAND:
			/* Mining(Normal) */
			case MINING_BRONZE_PICKAXE:
			case MINING_IRON_PICKAXE:
			case MINING_STEEL_PICKAXE:
			case MINING_BLACK_PICKAXE:
			case MINING_MITHRIL_PICKAXE:
			case MINING_ADAMANT_PICKAXE:
			case MINING_RUNE_PICKAXE:
			case MINING_DRAGON_PICKAXE:
			case MINING_DRAGON_PICKAXE_ORN:
			case MINING_INFERNAL_PICKAXE:
			case MINING_3A_PICKAXE:
			/* Mining(Motherlode) */
			case MINING_MOTHERLODE_BRONZE:
			case MINING_MOTHERLODE_IRON:
			case MINING_MOTHERLODE_STEEL:
			case MINING_MOTHERLODE_BLACK:
			case MINING_MOTHERLODE_MITHRIL:
			case MINING_MOTHERLODE_ADAMANT:
			case MINING_MOTHERLODE_RUNE:
			case MINING_MOTHERLODE_DRAGON:
			case MINING_MOTHERLODE_DRAGON_ORN:
			case MINING_MOTHERLODE_INFERNAL:
			case MINING_MOTHERLODE_3A:
			/* Herblore */
			case HERBLORE_POTIONMAKING:
			case HERBLORE_MAKE_TAR:
			/* Magic */
			case MAGIC_CHARGING_ORBS:
			case MAGIC_LUNAR_STRING_JEWELRY:
			case MAGIC_LUNAR_BAKE_PIE:
			/* Prayer */
			case USING_GILDED_ALTAR:
				resetTimers();
				notifyIdle = true;
				break;
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

		if (client.getGameState() != GameState.LOGGED_IN || local == null)
		{
			return;
		}

		if (checkIdleLogout())
		{
			notifier.notify("[" + local.getName() + "] is about to log out from idling too long!");
		}

		if (check6hrLogout())
		{
			notifier.notify("[" + local.getName() + "] is about to log out from being online for 6 hours!");
		}

		if (config.animationIdle() && checkAnimationIdle(waitDuration, local))
		{
			notifier.notify("[" + local.getName() + "] is now idle!");
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
			if (notifyIdleLogout)
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
