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

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import static net.runelite.api.AnimationID.*;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.GraphicID;
import net.runelite.api.Hitsplat;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Idle Notifier",
	description = "Send a notification when going idle, or when HP/Prayer reaches a threshold",
	tags = {"health", "hitpoints", "notifications", "prayer"}
)
public class IdleNotifierPlugin extends Plugin
{
	// This must be more than 500 client ticks (10 seconds) before you get AFK kicked
	private static final int LOGOUT_WARNING_MILLIS = (4 * 60 + 40) * 1000; // 4 minutes and 40 seconds
	private static final int COMBAT_WARNING_MILLIS = 19 * 60 * 1000; // 19 minutes
	private static final int LOGOUT_WARNING_CLIENT_TICKS = LOGOUT_WARNING_MILLIS / Constants.CLIENT_TICK_LENGTH;
	private static final int COMBAT_WARNING_CLIENT_TICKS = COMBAT_WARNING_MILLIS / Constants.CLIENT_TICK_LENGTH;

	private static final int HIGHEST_MONSTER_ATTACK_SPEED = 8; // Except Scarab Mage, but they are with other monsters
	private static final Duration SIX_HOUR_LOGOUT_WARNING_AFTER_DURATION = Duration.ofMinutes(340);

	private static final String FISHING_SPOT = "Fishing spot";
	
	private static final Set<Integer> nominalAnimations = Collections.unmodifiableSet(
		new HashSet<>(
			Arrays.asList(
				/* Woodcutting */
				WOODCUTTING_BRONZE,
				WOODCUTTING_IRON,
				WOODCUTTING_STEEL,
				WOODCUTTING_BLACK,
				WOODCUTTING_MITHRIL,
				WOODCUTTING_ADAMANT,
				WOODCUTTING_RUNE,
				WOODCUTTING_DRAGON,
				WOODCUTTING_INFERNAL,
				WOODCUTTING_3A_AXE,
				/* Cooking(Fire, Range) */
				COOKING_FIRE,
				COOKING_RANGE,
				COOKING_WINE,
				/* Crafting(Gem Cutting, Glassblowing, Spinning, Battlestaves, Pottery) */
				GEM_CUTTING_OPAL,
				GEM_CUTTING_JADE,
				GEM_CUTTING_REDTOPAZ,
				GEM_CUTTING_SAPPHIRE,
				GEM_CUTTING_EMERALD,
				GEM_CUTTING_RUBY,
				GEM_CUTTING_DIAMOND,
				GEM_CUTTING_AMETHYST,
				CRAFTING_GLASSBLOWING,
				CRAFTING_SPINNING,
				CRAFTING_BATTLESTAVES,
				CRAFTING_LEATHER,
				CRAFTING_POTTERS_WHEEL,
				CRAFTING_POTTERY_OVEN,
				/* Fletching(Cutting, Stringing) */
				FLETCHING_BOW_CUTTING,
				FLETCHING_STRING_NORMAL_SHORTBOW,
				FLETCHING_STRING_OAK_SHORTBOW,
				FLETCHING_STRING_WILLOW_SHORTBOW,
				FLETCHING_STRING_MAPLE_SHORTBOW,
				FLETCHING_STRING_YEW_SHORTBOW,
				FLETCHING_STRING_MAGIC_SHORTBOW,
				FLETCHING_STRING_NORMAL_LONGBOW,
				FLETCHING_STRING_OAK_LONGBOW,
				FLETCHING_STRING_WILLOW_LONGBOW,
				FLETCHING_STRING_MAPLE_LONGBOW,
				FLETCHING_STRING_YEW_LONGBOW,
				FLETCHING_STRING_MAGIC_LONGBOW,
				/* Smithing(Anvil, Furnace, Cannonballs */
				SMITHING_ANVIL,
				SMITHING_SMELTING,
				SMITHING_CANNONBALL,
				/* Fishing */
				FISHING_CRUSHING_INFERNAL_EELS,
				FISHING_CUTTING_SACRED_EELS,
				/* Mining(Normal) */
				MINING_BRONZE_PICKAXE,
				MINING_IRON_PICKAXE,
				MINING_STEEL_PICKAXE,
				MINING_BLACK_PICKAXE,
				MINING_MITHRIL_PICKAXE,
				MINING_ADAMANT_PICKAXE,
				MINING_RUNE_PICKAXE,
				MINING_DRAGON_PICKAXE,
				MINING_DRAGON_PICKAXE_ORN,
				MINING_INFERNAL_PICKAXE,
				MINING_3A_PICKAXE,
				DENSE_ESSENCE_CHIPPING,
				DENSE_ESSENCE_CHISELING,
				/* Mining(Motherlode) */
				MINING_MOTHERLODE_BRONZE,
				MINING_MOTHERLODE_IRON,
				MINING_MOTHERLODE_STEEL,
				MINING_MOTHERLODE_BLACK,
				MINING_MOTHERLODE_MITHRIL,
				MINING_MOTHERLODE_ADAMANT,
				MINING_MOTHERLODE_RUNE,
				MINING_MOTHERLODE_DRAGON,
				MINING_MOTHERLODE_DRAGON_ORN,
				MINING_MOTHERLODE_INFERNAL,
				MINING_MOTHERLODE_3A,
				/* Herblore */
				HERBLORE_PESTLE_AND_MORTAR,
				HERBLORE_POTIONMAKING,
				HERBLORE_MAKE_TAR,
				/* Magic */
				MAGIC_CHARGING_ORBS,
				MAGIC_LUNAR_PLANK_MAKE,
				MAGIC_LUNAR_STRING_JEWELRY,
				MAGIC_MAKE_TABLET,
				MAGIC_ENCHANTING_JEWELRY,
				MAGIC_ENCHANTING_AMULET_1,
				MAGIC_ENCHANTING_AMULET_2,
				MAGIC_ENCHANTING_AMULET_3,
				/* Prayer */
				USING_GILDED_ALTAR,
				/* Farming */
				FARMING_MIX_ULTRACOMPOST,
				/* Misc */
				PISCARILIUS_CRANE_REPAIR,
				HOME_MAKE_TABLET,
				SAND_COLLECTION
			)
		)
	);

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private IdleNotifierConfig config;

	private Instant lastAnimating;
	private int lastAnimation = AnimationID.IDLE;
	private Instant lastInteracting;
	private Actor lastInteract;
	private boolean notifyHitpoints = true;
	private boolean notifyPrayer = true;
	private boolean notifyOxygen = true;
	private boolean notifyIdleLogout = true;
	private boolean notify6HourLogout = true;
	private int lastSpecEnergy = 1000;
	private int lastCombatCountdown = 0;
	private Instant sixHourWarningTime;
	private boolean ready;
	private boolean lastInteractWasCombat;

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

		int graphic = localPlayer.getGraphic();
		int animation = localPlayer.getAnimation();
		
		if (nominalAnimations.contains(animation) || (animation == MAGIC_LUNAR_SHARED && graphic == GraphicID.BAKE_PIE))
		{
			resetTimers();
			lastAnimation = animation;
			lastAnimating = Instant.now();
		}
		
		else if (animation == IDLE)
		{
			lastAnimating = Instant.now();
		}
		
		// On unknown animation simply assume the animation is invalid and dont throw notification
		else
		{
			lastAnimation = IDLE;
			lastAnimating = null;
		}
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		final Actor source = event.getSource();
		if (source != client.getLocalPlayer())
		{
			return;
		}

		final Actor target = event.getTarget();

		// Reset last interact
		if (target != null)
		{
			lastInteract = null;
		}
		else
		{
			lastInteracting = Instant.now();
		}

		final boolean isNpc = target instanceof NPC;

		// If this is not NPC, do not process as we are not interested in other entities
		if (!isNpc)
		{
			return;
		}

		final NPC npc = (NPC) target;
		final NPCComposition npcComposition = npc.getComposition();
		final List<String> npcMenuActions = Arrays.asList(npcComposition.getActions());

		if (npcMenuActions.contains("Attack"))
		{
			// Player is most likely in combat with attack-able NPC
			resetTimers();
			lastInteract = target;
			lastInteracting = Instant.now();
			lastInteractWasCombat = true;
		}
		else if (target.getName() != null && target.getName().contains(FISHING_SPOT))
		{
			// Player is fishing
			resetTimers();
			lastInteract = target;
			lastInteracting = Instant.now();
			lastInteractWasCombat = false;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		lastInteracting = null;

		GameState state = gameStateChanged.getGameState();

		switch (state)
		{
			case LOGIN_SCREEN:
				resetTimers();
				break;
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
					resetTimers();
				}

				break;
		}
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied event)
	{
		if (event.getActor() != client.getLocalPlayer())
		{
			return;
		}

		final Hitsplat hitsplat = event.getHitsplat();

		if (hitsplat.getHitsplatType() == Hitsplat.HitsplatType.DAMAGE
			|| hitsplat.getHitsplatType() == Hitsplat.HitsplatType.BLOCK)
		{
			lastCombatCountdown = HIGHEST_MONSTER_ATTACK_SPEED;
		}
	}

	@Subscribe
	public void onGraphicChanged(GraphicChanged event)
	{
		Actor actor = event.getActor();

		if (actor != client.getLocalPlayer())
		{
			return;
		}

		if (actor.getGraphic() == GraphicID.SPLASH)
		{
			lastCombatCountdown = HIGHEST_MONSTER_ATTACK_SPEED;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		final Player local = client.getLocalPlayer();
		final Duration waitDuration = Duration.ofMillis(config.getIdleNotificationDelay());
		lastCombatCountdown = Math.max(lastCombatCountdown - 1, 0);

		if (client.getGameState() != GameState.LOGGED_IN
			|| local == null
			// If user has clicked in the last second then they're not idle so don't send idle notification
			|| System.currentTimeMillis() - client.getMouseLastPressedMillis() < 1000
			|| client.getKeyboardIdleTicks() < 10)
		{
			resetTimers();
			return;
		}

		if (config.logoutIdle() && checkIdleLogout())
		{
			notifyWith(local, "is about to log out from idling too long!");
		}

		if (check6hrLogout())
		{
			notifyWith(local, "is about to log out from being online for 6 hours!");
		}

		if (config.animationIdle() && checkAnimationIdle(waitDuration, local))
		{
			notifyWith(local, "is now idle!");
		}

		if (config.interactionIdle() && checkInteractionIdle(waitDuration, local))
		{
			if (lastInteractWasCombat)
			{
				notifyWith(local, "is now out of combat!");
			}
			else
			{
				notifyWith(local, "is now idle!");
			}
		}

		if (checkLowHitpoints())
		{
			notifyWith(local, "has low hitpoints!");
		}

		if (checkLowPrayer())
		{
			notifyWith(local, "has low prayer!");
		}

		if (checkLowOxygen())
		{
			notifyWith(local, "has low oxygen!");
		}

		if (checkFullSpecEnergy())
		{
			notifyWith(local, "has restored spec energy!");
		}
	}
	
	private void notifyWith(Player local, String message) {
		notifier.notify("[" + local.getName() + "] " + message);
	}

	private boolean checkFullSpecEnergy()
	{
		int currentSpecEnergy = client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT);

		int threshold = config.getSpecEnergyThreshold() * 10;
		if (threshold == 0)
		{
			lastSpecEnergy = currentSpecEnergy;
			return false;
		}

		// Check if we have regenerated over the threshold, and that the
		// regen was small enough.
		boolean notify = lastSpecEnergy < threshold && currentSpecEnergy >= threshold
			&& currentSpecEnergy - lastSpecEnergy <= 100;
		lastSpecEnergy = currentSpecEnergy;
		return notify;
	}

	private boolean checkLowOxygen()
	{
		if (config.getOxygenThreshold() == 0)
		{
			return false;
		}
		if (config.getOxygenThreshold() >= client.getVar(Varbits.OXYGEN_LEVEL) * 0.1)
		{
			if (!notifyOxygen)
			{
				notifyOxygen = true;
				return true;
			}
		}
		else
		{
			notifyOxygen = false;
		}
		return false;
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

	private boolean checkInteractionIdle(Duration waitDuration, Player local)
	{
		if (lastInteract == null)
		{
			return false;
		}

		final Actor interact = local.getInteracting();

		if (interact == null)
		{
			if (lastInteracting != null
				&& Instant.now().compareTo(lastInteracting.plus(waitDuration)) >= 0
				&& lastCombatCountdown == 0)
			{
				lastInteract = null;
				lastInteracting = null;
				return true;
			}
		}
		else
		{
			lastInteracting = Instant.now();
		}

		return false;
	}

	private boolean checkIdleLogout()
	{
		// Check clientside AFK first, because this is required for the server to disconnect you for being first
		int idleClientTicks = client.getKeyboardIdleTicks();
		if (client.getMouseIdleTicks() < idleClientTicks)
		{
			idleClientTicks = client.getMouseIdleTicks();
		}

		if (idleClientTicks < LOGOUT_WARNING_CLIENT_TICKS)
		{
			notifyIdleLogout = true;
			return false;
		}

		// If we are not receiving hitsplats then we can be afk kicked
		if (lastCombatCountdown <= 0)
		{
			boolean warn = notifyIdleLogout;
			notifyIdleLogout = false;
			return warn;
		}

		// We are in combat, so now we have to check for the timer that knocks you out of combat
		// I think there are other conditions that I don't know about, because during testing I just didn't
		// get removed from combat sometimes.
		final long lastInteractionAgo = System.currentTimeMillis() - client.getMouseLastPressedMillis();
		if (lastInteractionAgo < COMBAT_WARNING_MILLIS || client.getKeyboardIdleTicks() < COMBAT_WARNING_CLIENT_TICKS)
		{
			notifyIdleLogout = true;
			return false;
		}

		boolean warn = notifyIdleLogout;
		notifyIdleLogout = false;
		return warn;
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
		if (lastAnimation == IDLE)
		{
			return false;
		}

		final int animation = local.getAnimation();

		if (animation == IDLE)
		{
			if (lastAnimating != null && Instant.now().compareTo(lastAnimating.plus(waitDuration)) >= 0)
			{
				lastAnimation = IDLE;
				lastAnimating = null;
				return true;
			}
		}
		else
		{
			lastAnimating = Instant.now();
		}

		return false;
	}

	private void resetTimers()
	{
		final Player local = client.getLocalPlayer();

		// Reset animation idle timer
		lastAnimating = null;
		if (client.getGameState() == GameState.LOGIN_SCREEN || local == null || local.getAnimation() != lastAnimation)
		{
			lastAnimation = IDLE;
		}

		// Reset interaction idle timer
		lastInteracting = null;
		if (client.getGameState() == GameState.LOGIN_SCREEN || local == null || local.getInteracting() != lastInteract)
		{
			lastInteract = null;
		}
	}
}