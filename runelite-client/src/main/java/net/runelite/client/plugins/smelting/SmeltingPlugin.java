/*
 * Copyright (c) 2019, Stephen <stepzhu@umich.edu>
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
package net.runelite.client.plugins.smelting;

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.MenuAction;
import net.runelite.api.Skill;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.events.XpTrackerSkillReset;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayMenuEntry;

@PluginDescriptor(
	name = "Smelting",
	description = "Show Smelting stats",
	tags = {"overlay", "skilling"}
)
@PluginDependency(XpTrackerPlugin.class)
public class SmeltingPlugin extends Plugin
{
	@Inject
	private SmeltingConfig config;

	@Inject
	private SmeltingOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Getter(AccessLevel.PACKAGE)
	private final SmeltingSession session = new SmeltingSession();

	@Provides
	SmeltingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SmeltingConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked overlayMenuClicked)
	{
		OverlayMenuEntry overlayMenuEntry = overlayMenuClicked.getEntry();
		if (overlayMenuEntry.getMenuAction() == MenuAction.RUNELITE_OVERLAY
			&& overlayMenuClicked.getEntry().getOption().equals(SmeltingOverlay.SMELTING_RESET)
			&& overlayMenuClicked.getOverlay() == overlay)
		{
			session.setLastItemSmelted(null);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		if (event.getMessage().startsWith("You retrieve a bar of"))
		{
			session.increaseBarsSmelted(1);
			session.increaseBarsSmeltedSinceHrReset(1);
		}
		else if (event.getMessage().startsWith("You remove the cannonballs from the mould"))
		{
			session.increaseCannonBallsSmelted(4);
		}
		else if (event.getMessage().equals("The Varrock platebody enabled you to smelt your next ore simultaneously."))
		{
			session.increaseExtraBarsSmelted(1);
			session.increaseExtraBarsSmeltedSinceHrReset(1);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (session.getLastItemSmelted() != null)
		{
			final Duration statTimeout = Duration.ofMinutes(config.statTimeout());
			final Duration sinceCaught = Duration.between(session.getLastItemSmelted(), Instant.now());

			if (sinceCaught.compareTo(statTimeout) >= 0)
			{
				session.setLastItemSmelted(null);
			}
		}
	}

	@Subscribe
	public void onXpTrackerSkillReset(XpTrackerSkillReset event)
	{
		if (event.getSkill() == Skill.SMITHING)
		{
			// Both types reset actions per hour.
			session.setBarsSmeltedSinceHrReset(0);
			session.setExtraBarsSmeltedSinceHrReset(0);
			if (event.getResetType() == XpTrackerSkillReset.ResetType.ACTIONS)
			{
				session.setBarsSmelted(0);
				session.setExtraBarsSmelted(0);
				session.setCannonBallsSmelted(0);
			}
		}
	}
}

