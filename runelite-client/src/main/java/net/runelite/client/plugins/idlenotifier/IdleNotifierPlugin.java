/*
 * Copyright (c) 2016-2017, Abel Briggs
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
import javax.inject.Inject;
import net.runelite.api.Actor;
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
import static net.runelite.api.AnimationID.COOKING_FIRE;
import static net.runelite.api.AnimationID.COOKING_RANGE;
import static net.runelite.api.AnimationID.CRAFTING_GLASSBLOWING;
import static net.runelite.api.AnimationID.CRAFTING_SPINNING;
import static net.runelite.api.AnimationID.FISHING_BARBTAIL_HARPOON;
import static net.runelite.api.AnimationID.FISHING_CAGE;
import static net.runelite.api.AnimationID.FISHING_DRAGON_HARPOON;
import static net.runelite.api.AnimationID.FISHING_HARPOON;
import static net.runelite.api.AnimationID.FISHING_KARAMBWAN;
import static net.runelite.api.AnimationID.FISHING_NET;
import static net.runelite.api.AnimationID.FISHING_OILY_ROD;
import static net.runelite.api.AnimationID.FISHING_POLE_CAST;
import static net.runelite.api.AnimationID.FLETCHING_BOW_CUTTING;
import static net.runelite.api.AnimationID.FLETCHING_STRING_MAGIC_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_MAGIC_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_MAPLE_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_MAPLE_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_NORMAL_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_NORMAL_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_OAK_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_OAK_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_WILLOW_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_WILLOW_SHORTBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_YEW_LONGBOW;
import static net.runelite.api.AnimationID.FLETCHING_STRING_YEW_SHORTBOW;
import static net.runelite.api.AnimationID.GEM_CUTTING_DIAMOND;
import static net.runelite.api.AnimationID.GEM_CUTTING_EMERALD;
import static net.runelite.api.AnimationID.GEM_CUTTING_JADE;
import static net.runelite.api.AnimationID.GEM_CUTTING_OPAL;
import static net.runelite.api.AnimationID.GEM_CUTTING_REDTOPAZ;
import static net.runelite.api.AnimationID.GEM_CUTTING_RUBY;
import static net.runelite.api.AnimationID.GEM_CUTTING_SAPPHIRE;
import static net.runelite.api.AnimationID.HERBLORE_MAKE_TAR;
import static net.runelite.api.AnimationID.HERBLORE_POTIONMAKING;
import static net.runelite.api.AnimationID.IDLE;
import static net.runelite.api.AnimationID.MAGIC_CHARGING_ORBS;
import static net.runelite.api.AnimationID.MINING_ADAMANT_PICKAXE;
import static net.runelite.api.AnimationID.MINING_BLACK_PICKAXE;
import static net.runelite.api.AnimationID.MINING_BRONZE_PICKAXE;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE_ORN;
import static net.runelite.api.AnimationID.MINING_INFERNAL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_IRON_PICKAXE;
import static net.runelite.api.AnimationID.MINING_MITHRIL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_ADAMANT;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_BLACK;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_BRONZE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_DRAGON;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_DRAGON_ORN;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_INFERNAL;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_IRON;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_MITHRIL;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_RUNE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_STEEL;
import static net.runelite.api.AnimationID.MINING_RUNE_PICKAXE;
import static net.runelite.api.AnimationID.MINING_STEEL_PICKAXE;
import static net.runelite.api.AnimationID.SMITHING_ANVIL;
import static net.runelite.api.AnimationID.SMITHING_CANNONBALL;
import static net.runelite.api.AnimationID.SMITHING_SMELTING;
import static net.runelite.api.AnimationID.WOODCUTTING_ADAMANT;
import static net.runelite.api.AnimationID.WOODCUTTING_BLACK;
import static net.runelite.api.AnimationID.WOODCUTTING_BRONZE;
import static net.runelite.api.AnimationID.WOODCUTTING_DRAGON;
import static net.runelite.api.AnimationID.WOODCUTTING_INFERNAL;
import static net.runelite.api.AnimationID.WOODCUTTING_IRON;
import static net.runelite.api.AnimationID.WOODCUTTING_MITHRIL;
import static net.runelite.api.AnimationID.WOODCUTTING_RUNE;
import static net.runelite.api.AnimationID.WOODCUTTING_STEEL;

@PluginDescriptor(
	name = "Idle Notifier"
)
public class IdleNotifierPlugin extends Plugin
{
	private static final int LOGOUT_WARNING_AFTER_TICKS = 14000; // 4 minutes and 40 seconds
	private static final long COMBAT_WARNING_AFTER_TIME = 1180000000000L; // 19 minutes and 40 seconds
	private static final long SIX_HOUR_LOGOUT_WARNING_AFTER_TIME = 21300000000000L; // 5 hours and 55 minutes

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private IdleNotifierConfig config;

	private long sixHourWarningTime;
	private long opponentWarningTime;
	private long lastAnimation;

	private boolean triggeredIdleLogout = false;
	private boolean triggered6hrLogout = false;
	private boolean triggeredIdleAnimation = false;
	private boolean triggeredOutOfCombatIdle = false;
	private boolean triggeredLowHealth = false;
	private boolean triggeredLowPrayer = false;

	private Actor trackedOpponent;

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
			/* Cooking(Fire, Range) */
			case COOKING_FIRE:
			case COOKING_RANGE:
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
			case FISHING_HARPOON:
			case FISHING_BARBTAIL_HARPOON:
			case FISHING_DRAGON_HARPOON:
			case FISHING_CAGE:
			case FISHING_POLE_CAST:
			case FISHING_OILY_ROD:
			case FISHING_KARAMBWAN:
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
			/* Herblore */
			case HERBLORE_POTIONMAKING:
			case HERBLORE_MAKE_TAR:
			/* Magic */
			case MAGIC_CHARGING_ORBS:
				triggeredIdleAnimation = true;
				lastAnimation = 0L;
				break;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		GameState state = gameStateChanged.getGameState();

		switch (state)
		{
			case LOGGING_IN:
			case HOPPING:
			case CONNECTION_LOST:
			case LOGIN_SCREEN:
				sixHourWarningTime = 0L;
				lastAnimation = 0L;
				opponentWarningTime = 0L;
				trackedOpponent = null;
				break;
			case LOGGED_IN:
				sixHourWarningTime = System.nanoTime() + SIX_HOUR_LOGOUT_WARNING_AFTER_TIME;
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		final Player local = client.getLocalPlayer();

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

		if (config.animationIdle() && checkAnimationIdle(local))
		{
			notifier.notify("[" + local.getName() + "] is now idle!");
		}

		if (config.combatIdle() && checkOutOfCombat(local))
		{
			notifier.notify("[" + local.getName() + "] is now out of combat!");
		}

		if (config.getHitpointsThreshold() != 0 && checkLowHitpoints())
		{
			notifier.notify("[" + local.getName() + "] has reached the hitpoint threshold!");
		}

		if (config.getPrayerThreshold() != 0 && checkLowPrayer())
		{
			notifier.notify("[" + local.getName() + "] has reached the prayer threshold!");
		}
	}

	private boolean checkIdleLogout()
	{
		if (client.getMouseIdleTicks() > LOGOUT_WARNING_AFTER_TICKS
			&& client.getKeyboardIdleTicks() > LOGOUT_WARNING_AFTER_TICKS
			&& trackedOpponent == null)
		{
			if (!triggeredIdleLogout)
			{
				triggeredIdleLogout = true;
				return true;
			}
		}
		else
		{
			triggeredIdleLogout = false;
		}

		return false;
	}

	private boolean check6hrLogout()
	{
		if (sixHourWarningTime == 0L)
		{
			return false;
		}

		if (System.nanoTime() >= sixHourWarningTime)
		{
			if (!triggered6hrLogout)
			{
				triggered6hrLogout = true;
				return true;
			}
		}
		else
		{
			triggered6hrLogout = false;
		}

		return false;
	}

	private boolean checkAnimationIdle(Player local)
	{
		if (triggeredIdleAnimation)
		{
			if (lastAnimation != 0L
				&& System.nanoTime() >= lastAnimation)
			{
				triggeredIdleAnimation = false;
				lastAnimation = 0L;
				return true;
			}
			else if (local.getAnimation() == IDLE)
			{
				lastAnimation = System.nanoTime() + (long) (config.getAnimationIdleNotificationDelay() * 1000000000L);
			}
		}

		return false;
	}

	private boolean checkOutOfCombat(Player local)
	{
		Actor opponent = local.getInteracting();
		boolean isOpponentPlayer = opponent instanceof Player;

		if (opponentWarningTime != 0L
			&& System.nanoTime() >= opponentWarningTime)
		{
			if (!triggeredOutOfCombatIdle)
			{
				triggeredOutOfCombatIdle = true;
				trackedOpponent = null;
				opponentWarningTime = 0L;
				return true;
			}
		}
		else
		{
			triggeredOutOfCombatIdle = false;
		}

		if (trackedOpponent == null)
		{
			if (opponent != null
				&& opponent.getCombatLevel() > 0
				&& !isOpponentPlayer
				&& (client.getSetting(Varbits.MULTICOMBAT_AREA) == 1
					|| (client.getSetting(Varbits.MULTICOMBAT_AREA) != 1 && opponent.getInteracting() == local)))
			{
					trackedOpponent = opponent;
					opponentWarningTime = System.nanoTime() + COMBAT_WARNING_AFTER_TIME;
			}
		}
		else if (trackedOpponent.getHealthRatio() == 0
				|| (opponent == null && trackedOpponent.getInteracting() != local))
		{
				trackedOpponent = null;
				opponentWarningTime = System.nanoTime() + (long) (config.getCombatIdleNotificationDelay() * 1000000000L);
		}

		return false;
	}

	private boolean checkLowHitpoints()
	{
		if (client.getRealSkillLevel(Skill.HITPOINTS) > config.getHitpointsThreshold())
		{
			if (client.getBoostedSkillLevel(Skill.HITPOINTS) <= config.getHitpointsThreshold())
			{
				if (!triggeredLowHealth)
				{
					triggeredLowHealth = true;
					return true;
				}
			}
			else
			{
				triggeredLowHealth = false;
			}
		}

		return false;
	}

	private boolean checkLowPrayer()
	{
		if (client.getRealSkillLevel(Skill.PRAYER) > config.getPrayerThreshold())
		{
			if (client.getBoostedSkillLevel(Skill.PRAYER) <= config.getPrayerThreshold())
			{
				if (!triggeredLowPrayer)
				{
					triggeredLowPrayer = true;
					return true;
				}
			}
			else
			{
				triggeredLowPrayer = false;
			}
		}

		return false;
	}
}