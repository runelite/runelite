/*
 * Copyright (c) 2016-2017, Abel Briggs
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
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import static net.runelite.api.AnimationID.*;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.events.AnimationChanged;
import net.runelite.client.plugins.Plugin;

public class IdleNotifier extends Plugin
{
	private static final String OPERATING_SYSTEM = System.getProperty("os.name");
	private static final int CHECK_INTERVAL = 2;
	private static final Duration WAIT_DURATION = Duration.ofMillis(2500L);

	private final Client client = RuneLite.getClient();
	private final TrayIcon trayIcon = RuneLite.getTrayIcon();

	private ScheduledFuture<?> future;
	private Instant lastAnimating;
	private boolean notifyIdle = false;

	@Override
	protected void startUp() throws Exception
	{
		ScheduledExecutorService executor = RuneLite.getRunelite().getExecutor();
		future = executor.scheduleAtFixedRate(this::checkIdle, CHECK_INTERVAL, CHECK_INTERVAL, TimeUnit.SECONDS);
	}

	@Override
	protected void shutDown() throws Exception
	{
		future.cancel(true);
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		int animation = client.getLocalPlayer().getAnimation();

		switch (animation)
		{
			case WOODCUTTING_BRONZE:
			case WOODCUTTING_IRON:
			case WOODCUTTING_STEEL:
			case WOODCUTTING_BLACK:
			case WOODCUTTING_MITHRIL:
			case WOODCUTTING_ADAMANT:
			case WOODCUTTING_RUNE:
			case WOODCUTTING_DRAGON:
			case COOKING_FIRE:
			case COOKING_RANGE:
			case GEM_CUTTING_OPAL:
			case GEM_CUTTING_JADE:
			case GEM_CUTTING_REDTOPAZ:
			case GEM_CUTTING_SAPPHIRE:
			case GEM_CUTTING_EMERALD:
			case GEM_CUTTING_RUBY:
			case GEM_CUTTING_DIAMOND:
			case SMITHING_ANVIL:
			case SMITHING_SMELTING:
			case FISHING_NET:
			case FISHING_HARPOON:
			case FISHING_CAGE:
			case FISHING_POLE_CAST:
			case MINING_BRONZE_PICKAXE:
			case MINING_IRON_PICKAXE:
			case MINING_STEEL_PICKAXE:
			case MINING_BLACK_PICKAXE:
			case MINING_MITHRIL_PICKAXE:
			case MINING_ADAMANT_PICKAXE:
			case MINING_RUNE_PICKAXE:
			case MINING_DRAGON_PICKAXE:
			case MINING_MOTHERLODE_BRONZE:
			case MINING_MOTHERLODE_IRON:
			case MINING_MOTHERLODE_STEEL:
			case MINING_MOTHERLODE_BLACK:
			case MINING_MOTHERLODE_MITHRIL:
			case MINING_MOTHERLODE_ADAMANT:
			case MINING_MOTHERLODE_RUNE:
			case MINING_MOTHERLODE_DRAGON:
			case HERBLORE_POTIONMAKING:
			case MAGIC_CHARGING_ORBS:
				notifyIdle = true;
				lastAnimating = Instant.now();
				break;
		}
	}

	private void checkIdle()
	{
		if (notifyIdle && client.getLocalPlayer().getAnimation() == IDLE
			&& Instant.now().compareTo(lastAnimating.plus(WAIT_DURATION)) >= 0)
		{
			trayIcon.displayMessage("RuneLite", "You are now idle.", TrayIcon.MessageType.NONE);

			if (OPERATING_SYSTEM.startsWith("Windows"))
			{
				Toolkit.getDefaultToolkit().beep();
			}

			notifyIdle = false;
		}
	}

}
