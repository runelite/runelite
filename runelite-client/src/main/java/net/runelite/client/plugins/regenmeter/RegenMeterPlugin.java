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
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
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
	private static int specRegenTicks = 50;
	private static final int NORMAL_HP_REGEN_TICKS = 100;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

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
	private int specialAttack;

	private int ticksSinceSpecRegen;
	private int ticksSinceHPRegen;

	@Provides
	RegenMeterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RegenMeterConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(() ->
			{
				specialAttack = client.getVarpValue(VarPlayer.SPECIAL_ATTACK_PERCENT);
			});
		}
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
	private void onVarbitChanged(VarbitChanged ev)
	{
		if (ev.getVarbitId() == Varbits.PRAYER_RAPID_HEAL)
		{
			ticksSinceHPRegen = 0;
		}
		else if (ev.getVarpId() == VarPlayer.SPECIAL_ATTACK_PERCENT)
		{
			int spec = client.getVarpValue(VarPlayer.SPECIAL_ATTACK_PERCENT);
			ticksSinceSpecRegen = specialAttack > spec ? ticksSinceSpecRegen : 0;
			specialAttack = spec;
		}
	}

	@Subscribe
	private void onVarClientIntChanged(VarClientIntChanged event)
	{
		if (event.getIndex() == VarClientInt.SPEC_REGEN_INTERVAL)
		{
			int var = client.getVarcIntValue(VarClientInt.SPEC_REGEN_INTERVAL);
			specRegenTicks = (var & ((1 << 22) - 1)) >> 11;

			// Equipping a lightbearer after 25 ticks since last spec regen
			// will carry over (ticksSinceSpecRegen - 25) ticks to the new cycle
			ticksSinceSpecRegen = Math.max(0, ticksSinceSpecRegen - 25);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getVarpValue(VarPlayer.SPECIAL_ATTACK_PERCENT) == 1000)
		{
			// The recharge doesn't tick when at 100%
			ticksSinceSpecRegen = 0;
		}
		else
		{
			ticksSinceSpecRegen = (ticksSinceSpecRegen + 1) % specRegenTicks;
		}
		specialPercentage = ticksSinceSpecRegen / (double) specRegenTicks;


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
