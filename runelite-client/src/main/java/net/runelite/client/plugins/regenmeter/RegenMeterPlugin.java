/*
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
package net.runelite.client.plugins.regenmeter;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.ItemContainer;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Regeneration Meter",
	description = "Track and show the hitpoints and special attack regeneration timers",
	tags = {"combat", "health", "hitpoints", "special", "attack", "overlay", "notifications"}
)
public class RegenMeterPlugin extends Plugin
{
	private static final int SPEC_REGEN_TICKS = 50;
	private static final int NORMAL_HP_REGEN_TICKS = 100;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Notifier notifier;

	@Inject
	private RegenMeterOverlay overlay;

	@Inject
	private RegenMeterConfig config;

	@Getter
	private double hitpointsPercentage;

	@Getter
	private double specialPercentage;

	private int ticksSinceSpecRegen;
	private int ticksSinceHPRegen;

	private boolean wearingLightbearer;

	@Provides
	RegenMeterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RegenMeterConfig.class);
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
	private void onGameStateChanged(GameStateChanged ev)
	{
		if (ev.getGameState() == GameState.HOPPING || ev.getGameState() == GameState.LOGIN_SCREEN)
		{
			ticksSinceHPRegen = -2; // For some reason this makes this accurate
			ticksSinceSpecRegen = 0;
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getContainerId() != InventoryID.WORN)
		{
			return;
		}

		ItemContainer equipment = event.getItemContainer();
		final boolean hasLightbearer = equipment.contains(ItemID.LIGHTBEARER);
		if (hasLightbearer == wearingLightbearer)
		{
			return;
		}

		// Lightbearer switch preserves time until next spec regen if <25 ticks remain
		// If unequipping Lightbearer, this will always evaluate to 0
		ticksSinceSpecRegen = Math.max(0, ticksSinceSpecRegen - 25);
		wearingLightbearer = hasLightbearer;
	}

	@Subscribe
	private void onVarbitChanged(VarbitChanged ev)
	{
		if (ev.getVarbitId() == VarbitID.PRAYER_RAPIDHEAL)
		{
			ticksSinceHPRegen = 0;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		final int ticksPerSpecRegen = wearingLightbearer ? SPEC_REGEN_TICKS / 2 : SPEC_REGEN_TICKS;

		if (client.getVarpValue(VarPlayerID.SA_ENERGY) == 1000)
		{
			// The recharge doesn't tick when at 100%
			ticksSinceSpecRegen = 0;
		}
		else
		{
			ticksSinceSpecRegen = (ticksSinceSpecRegen + 1) % ticksPerSpecRegen;
		}
		specialPercentage = ticksSinceSpecRegen / (double) ticksPerSpecRegen;


		int ticksPerHPRegen = NORMAL_HP_REGEN_TICKS;
		if (client.isPrayerActive(Prayer.RAPID_HEAL))
		{
			ticksPerHPRegen /= 2;
		}

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

	private boolean shouldNotifyHpRegenThisTick(int ticksPerHPRegen)
	{
		// if the configured duration lies between two ticks, choose the earlier tick
		final int ticksBeforeHPRegen = ticksPerHPRegen - ticksSinceHPRegen;
		final int notifyTick = (int) Math.ceil(config.getNotifyBeforeHpRegenSeconds() * 1000d / Constants.GAME_TICK_LENGTH);
		return ticksBeforeHPRegen == notifyTick;
	}
}
