/*
 * Copyright (c) 2022, Jacob Petersen <https://github.com/jpeter17>
 * Copyright (c) 2019, Sean Dewar <https://github.com/seandewar>
 * Copyright (c) 2018, Abex
 * Copyright (c) 2018, Zimaya <https://github.com/Zimaya>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.statusorbs;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.Getter;
import com.google.common.collect.ImmutableSet;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

import static net.runelite.api.ItemID.*;

@PluginDescriptor(
	name = "Status Orbs",
	description = "Adds various information related to status orbs",
	tags = {"combat", "health", "hitpoints", "special", "attack", "run", "energy", "overlay", "notifications",
			"overlay", "stamina", "status", "orbs", "regeneration", "meter"}
)
public class StatusOrbsPlugin extends Plugin
{
	private static final ImmutableSet<Integer> ALL_GRACEFUL_HOODS = ImmutableSet.of(
			GRACEFUL_HOOD_11851, GRACEFUL_HOOD_13579, GRACEFUL_HOOD_13580, GRACEFUL_HOOD_13591, GRACEFUL_HOOD_13592,
			GRACEFUL_HOOD_13603, GRACEFUL_HOOD_13604, GRACEFUL_HOOD_13615, GRACEFUL_HOOD_13616, GRACEFUL_HOOD_13627,
			GRACEFUL_HOOD_13628, GRACEFUL_HOOD_13667, GRACEFUL_HOOD_13668, GRACEFUL_HOOD_21061, GRACEFUL_HOOD_21063,
			GRACEFUL_HOOD_24743, GRACEFUL_HOOD_24745, GRACEFUL_HOOD_25069, GRACEFUL_HOOD_25071
	);

	private static final ImmutableSet<Integer> ALL_GRACEFUL_TOPS = ImmutableSet.of(
			GRACEFUL_TOP_11855, GRACEFUL_TOP_13583, GRACEFUL_TOP_13584, GRACEFUL_TOP_13595, GRACEFUL_TOP_13596,
			GRACEFUL_TOP_13607, GRACEFUL_TOP_13608, GRACEFUL_TOP_13619, GRACEFUL_TOP_13620, GRACEFUL_TOP_13631,
			GRACEFUL_TOP_13632, GRACEFUL_TOP_13671, GRACEFUL_TOP_13672, GRACEFUL_TOP_21067, GRACEFUL_TOP_21069,
			GRACEFUL_TOP_24749, GRACEFUL_TOP_24751, GRACEFUL_TOP_25075, GRACEFUL_TOP_25077
	);

	private static final ImmutableSet<Integer> ALL_GRACEFUL_LEGS = ImmutableSet.of(
			GRACEFUL_LEGS_11857, GRACEFUL_LEGS_13585, GRACEFUL_LEGS_13586, GRACEFUL_LEGS_13597, GRACEFUL_LEGS_13598,
			GRACEFUL_LEGS_13609, GRACEFUL_LEGS_13610, GRACEFUL_LEGS_13621, GRACEFUL_LEGS_13622, GRACEFUL_LEGS_13633,
			GRACEFUL_LEGS_13634, GRACEFUL_LEGS_13673, GRACEFUL_LEGS_13674, GRACEFUL_LEGS_21070, GRACEFUL_LEGS_21072,
			GRACEFUL_LEGS_24752, GRACEFUL_LEGS_24754, GRACEFUL_LEGS_25078, GRACEFUL_LEGS_25080
	);

	private static final ImmutableSet<Integer> ALL_GRACEFUL_GLOVES = ImmutableSet.of(
			GRACEFUL_GLOVES_11859, GRACEFUL_GLOVES_13587, GRACEFUL_GLOVES_13588, GRACEFUL_GLOVES_13599, GRACEFUL_GLOVES_13600,
			GRACEFUL_GLOVES_13611, GRACEFUL_GLOVES_13612, GRACEFUL_GLOVES_13623, GRACEFUL_GLOVES_13624, GRACEFUL_GLOVES_13635,
			GRACEFUL_GLOVES_13636, GRACEFUL_GLOVES_13675, GRACEFUL_GLOVES_13676, GRACEFUL_GLOVES_21073, GRACEFUL_GLOVES_21075,
			GRACEFUL_GLOVES_24755, GRACEFUL_GLOVES_24757, GRACEFUL_GLOVES_25081, GRACEFUL_GLOVES_25083
	);

	private static final ImmutableSet<Integer> ALL_GRACEFUL_BOOTS = ImmutableSet.of(
			GRACEFUL_BOOTS_11861, GRACEFUL_BOOTS_13589, GRACEFUL_BOOTS_13590, GRACEFUL_BOOTS_13601, GRACEFUL_BOOTS_13602,
			GRACEFUL_BOOTS_13613, GRACEFUL_BOOTS_13614, GRACEFUL_BOOTS_13625, GRACEFUL_BOOTS_13626, GRACEFUL_BOOTS_13637,
			GRACEFUL_BOOTS_13638, GRACEFUL_BOOTS_13677, GRACEFUL_BOOTS_13678, GRACEFUL_BOOTS_21076, GRACEFUL_BOOTS_21078,
			GRACEFUL_BOOTS_24758, GRACEFUL_BOOTS_24760, GRACEFUL_BOOTS_25084, GRACEFUL_BOOTS_25086
	);

	// Agility skill capes and the non-cosmetic Max capes also count for the Graceful set effect
	private static final ImmutableSet<Integer> ALL_GRACEFUL_CAPES = ImmutableSet.of(
			GRACEFUL_CAPE_11853, GRACEFUL_CAPE_13581, GRACEFUL_CAPE_13582, GRACEFUL_CAPE_13593, GRACEFUL_CAPE_13594,
			GRACEFUL_CAPE_13605, GRACEFUL_CAPE_13606, GRACEFUL_CAPE_13617, GRACEFUL_CAPE_13618, GRACEFUL_CAPE_13629,
			GRACEFUL_CAPE_13630, GRACEFUL_CAPE_13669, GRACEFUL_CAPE_13670, GRACEFUL_CAPE_21064, GRACEFUL_CAPE_21066,
			GRACEFUL_CAPE_24746, GRACEFUL_CAPE_24748, GRACEFUL_CAPE_25072, GRACEFUL_CAPE_25074,
			AGILITY_CAPE, AGILITY_CAPET, MAX_CAPE
	);

	@RequiredArgsConstructor
	@Getter
	private enum Graceful
	{
		HEAD(EquipmentInventorySlot.HEAD.getSlotIdx(), ALL_GRACEFUL_HOODS, 3),
		BODY(EquipmentInventorySlot.BODY.getSlotIdx(), ALL_GRACEFUL_TOPS, 4),
		LEGS(EquipmentInventorySlot.LEGS.getSlotIdx(), ALL_GRACEFUL_LEGS, 4),
		GLOVES(EquipmentInventorySlot.GLOVES.getSlotIdx(), ALL_GRACEFUL_GLOVES, 3),
		BOOTS(EquipmentInventorySlot.BOOTS.getSlotIdx(), ALL_GRACEFUL_BOOTS, 3),
		CAPE(EquipmentInventorySlot.CAPE.getSlotIdx(), ALL_GRACEFUL_CAPES, 3);

		private final int index;
		private final ImmutableSet<Integer> items;
		private final int boost;

		private static final int TOTAL_BOOSTS = Arrays.stream(values()).mapToInt(StatusOrbsPlugin.Graceful::getBoost).sum();

		public static boolean hasFullSet(final ItemContainer equipment)
		{
			if (equipment == null)
			{
				return false;
			}

			final Item[] items = equipment.getItems();

			if (items.length <= EquipmentInventorySlot.BOOTS.getSlotIdx())
			{
				return false;
			}

			return 	HEAD.getItems().contains(items[HEAD.getIndex()].getId())
					&& BODY.getItems().contains(items[BODY.getIndex()].getId())
					&& LEGS.getItems().contains(items[LEGS.getIndex()].getId())
					&& GLOVES.getItems().contains(items[GLOVES.getIndex()].getId())
					&& BOOTS.getItems().contains(items[BOOTS.getIndex()].getId())
					&& CAPE.getItems().contains(items[CAPE.getIndex()].getId());
		}
	}

	// Full set grants an extra 10% boost to recovery rate
	private static final int GRACEFUL_FULL_SET_BOOST_BONUS = 10;

	private static final int SPEC_REGEN_TICKS = 50;
	private static final int NORMAL_HP_REGEN_TICKS = 100;

	private static final int TRAILBLAZER_LEAGUE_FLUID_STRIKES_RELIC = 2;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Notifier notifier;

	@Inject
	private StatusOrbsOverlay overlay;

	@Inject
	private StatusOrbsConfig config;

	@Getter
	private double hitpointsPercentage;

	@Getter
	private double specialPercentage;

	@Getter
	private double runPercentage;

	private int ticksSinceSpecRegen;
	private int ticksSinceHPRegen;
	private double ticksSinceRunRegen;
	private boolean wasRapidHeal;

	private int lastEnergy = 0;

	private boolean localPlayerRunningToDestination;
	private WorldPoint prevLocalPlayerLocation;
	private String runTimeRemaining;

	@Provides
	StatusOrbsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StatusOrbsConfig.class);
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
		localPlayerRunningToDestination = false;
		prevLocalPlayerLocation = null;
		resetRunOrbText();
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged ev)
	{
		if (ev.getGameState() == GameState.HOPPING || ev.getGameState() == GameState.LOGIN_SCREEN)
		{
			ticksSinceHPRegen = -2; // For some reason this makes this accurate
			ticksSinceSpecRegen = 0;
			ticksSinceRunRegen = -1;
		}
	}

	@Subscribe
	private void onVarbitChanged(VarbitChanged ev)
	{
		boolean isRapidHeal = client.isPrayerActive(Prayer.RAPID_HEAL);
		if (wasRapidHeal != isRapidHeal)
		{
			ticksSinceHPRegen = 0;
		}
		wasRapidHeal = isRapidHeal;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT) == 1000)
		{
			// The recharge doesn't tick when at 100%
			ticksSinceSpecRegen = 0;
		}
		else
		{
			ticksSinceSpecRegen = (ticksSinceSpecRegen + 1) % SPEC_REGEN_TICKS;
		}
		specialPercentage = ticksSinceSpecRegen / (double) SPEC_REGEN_TICKS;


		int ticksPerHPRegen = NORMAL_HP_REGEN_TICKS;
		if (client.isPrayerActive(Prayer.RAPID_HEAL))
		{
			ticksPerHPRegen /= 2;
		}

		if (client.getVar(Varbits.LEAGUE_RELIC_3) == TRAILBLAZER_LEAGUE_FLUID_STRIKES_RELIC)
		{
			ticksPerHPRegen /= 4;
		}

		int currEnergy = client.getEnergy();

		WorldPoint currLocation = Objects.requireNonNull(client.getLocalPlayer()).getWorldLocation();

		if (currEnergy == 100 || prevLocalPlayerLocation.distanceTo(currLocation) > 1 || currEnergy < lastEnergy)
		{
			ticksSinceRunRegen = 0;
		}
		else if (currEnergy > lastEnergy)
		{
			if (runPercentage < 1)
			{
				ticksSinceRunRegen = (1 - runPercentage) / runRegenPerTick();
				ticksSinceRunRegen = ticksSinceRunRegen > 1 ? 1 : ticksSinceRunRegen;
			}
			else
			{
				ticksSinceRunRegen = (runPercentage - 1) / runRegenPerTick();
			}
		}
		else
		{
			ticksSinceRunRegen += 1;
		}

		runPercentage = ticksSinceRunRegen * runRegenPerTick();
		prevLocalPlayerLocation = currLocation;
		lastEnergy = currEnergy;

		runTimeRemaining = config.replaceOrbText() ? getEstimatedRunTimeRemaining(true) : null;

		ticksSinceHPRegen = (ticksSinceHPRegen + 1) % ticksPerHPRegen;
		hitpointsPercentage = ticksSinceHPRegen / (double) ticksPerHPRegen;

		int currentHP = client.getBoostedSkillLevel(Skill.HITPOINTS);
		int maxHP = client.getRealSkillLevel(Skill.HITPOINTS);
		if (currentHP == maxHP && !config.showWhenNoChange())
		{
			hitpointsPercentage = 0;
		}
		else if (currentHP > maxHP)
		{
			// Show it going down
			hitpointsPercentage = 1 - hitpointsPercentage;
		}

		if (config.getNotifyBeforeHpRegenSeconds() > 0 && currentHP < maxHP && shouldNotifyHpRegenThisTick(ticksPerHPRegen))
		{
			notifier.notify("Your next hitpoint will regenerate soon!");
		}
	}

	@Subscribe
	public void onBeforeRender(BeforeRender beforeRender)
	{
		if (runTimeRemaining != null)
		{
			setRunOrbText(runTimeRemaining);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("runenergy") && !config.replaceOrbText())
		{
			resetRunOrbText();
		}
	}

	private void setRunOrbText(String text)
	{
		Widget runOrbText = client.getWidget(WidgetInfo.MINIMAP_RUN_ORB_TEXT);

		if (runOrbText != null)
		{
			runOrbText.setText(text);
		}
	}

	private void resetRunOrbText()
	{
		setRunOrbText(Integer.toString(client.getEnergy()));
	}

	String getEstimatedRunTimeRemaining(boolean inSeconds)
	{
		// Calculate the amount of energy lost every tick.
		// Negative weight has the same depletion effect as 0 kg.
		final int effectiveWeight = Math.max(client.getWeight(), 0);
		double lossRate = (Math.min(effectiveWeight, 64) / 100.0) + 0.64;

		if (client.getVar(Varbits.RUN_SLOWED_DEPLETION_ACTIVE) != 0)
		{
			lossRate *= 0.3; // Stamina effect reduces energy depletion to 30%
		}

		// Calculate the number of seconds left
		final double secondsLeft = (client.getEnergy() * Constants.GAME_TICK_LENGTH) / (lossRate * 1000.0);

		// Return the text
		if (inSeconds)
		{
			return (int) Math.floor(secondsLeft) + "s";
		}
		else
		{
			final int minutes = (int) Math.floor(secondsLeft / 60.0);
			final int seconds = (int) Math.floor(secondsLeft - (minutes * 60.0));
			return minutes + ":" + StringUtils.leftPad(Integer.toString(seconds), 2, "0");
		}
	}

	private int getGracefulRecoveryBoost()
	{
		final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);

		if (equipment == null)
		{
			return 0;
		}

		final Item[] items = equipment.getItems();

		int boost = 0;

		for (final StatusOrbsPlugin.Graceful slot : StatusOrbsPlugin.Graceful.values())
		{
			if (items.length <= slot.getIndex())
			{
				continue;
			}

			final Item wornItem = items[slot.getIndex()];

			if (wornItem != null && slot.getItems().contains(wornItem.getId()))
			{
				boost += slot.getBoost();
			}
		}

		if (boost == StatusOrbsPlugin.Graceful.TOTAL_BOOSTS)
		{
			boost += GRACEFUL_FULL_SET_BOOST_BONUS;
		}

		return boost;
	}

	int getEstimatedRecoverTimeRemaining()
	{
		if (localPlayerRunningToDestination)
		{
			return -1;
		}

		// Calculate the amount of energy recovered every second
		double recoverRate = (48 + client.getBoostedSkillLevel(Skill.AGILITY)) / 360.0;
		recoverRate *= 1.0 + getGracefulRecoveryBoost() / 100.0;

		// Calculate the number of seconds left
		final double secondsLeft = (100 - client.getEnergy()) / recoverRate;
		return (int) secondsLeft;
	}

	private boolean shouldNotifyHpRegenThisTick(int ticksPerHPRegen)
	{
		// if the configured duration lies between two ticks, choose the earlier tick
		final int ticksBeforeHPRegen = ticksPerHPRegen - ticksSinceHPRegen;
		final int notifyTick = (int) Math.ceil(config.getNotifyBeforeHpRegenSeconds() * 1000d / Constants.GAME_TICK_LENGTH);
		return ticksBeforeHPRegen == notifyTick;
	}

	private double runRegenPerTick()
	{
		// Rates from https://oldschool.runescape.wiki/w/Energy
		double regenPerTick = (Math.floor(client.getBoostedSkillLevel(Skill.AGILITY) / 6d) + 8) / 100;
		if (Graceful.hasFullSet(client.getItemContainer(InventoryID.EQUIPMENT)))
		{
			regenPerTick = Math.floor(1.3 * regenPerTick);
		}

		return regenPerTick;
	}
}
