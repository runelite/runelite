/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.dps;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ws.PartyMember;
import net.runelite.client.ws.PartyService;
import net.runelite.client.ws.WSClient;

@PluginDescriptor(
	name = "DPS Counter",
	description = "Counts damage (per second) dealt",
	tags = {"DPS", "damage", "tracker", "Party"},
	enabledByDefault = false
)
@Slf4j
public class DpsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PartyService partyService;

	@Inject
	private WSClient wsClient;

	@Inject
	private DpsOverlay dpsOverlay;

	@Inject
	private DpsConfig dpsConfig;

	@Getter(AccessLevel.PACKAGE)
	private final Map<String, DpsTracker> members = new ConcurrentHashMap<>();
	@Getter(AccessLevel.PACKAGE)
	private DpsTracker totalTracker = new DpsTracker("Total");
	@Getter
	private DpsTracker tracker;
	private Instant idleStartTime;

	@Provides
	DpsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DpsConfig.class);
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(DpsService.class).to(DpsServiceImpl.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(dpsOverlay);
		wsClient.registerMessage(DpsUpdate.class);
	}

	@Override
	protected void shutDown()
	{
		wsClient.unregisterMessage(DpsUpdate.class);
		overlayManager.remove(dpsOverlay);
		members.clear();
		tracker = null;
		idleStartTime = null;
	}

	@Subscribe
	public void onPartyChanged(PartyChanged partyChanged)
	{
		members.clear();
		totalTracker.reset();
	}

	@Subscribe
	protected void onHitsplatApplied(final HitsplatApplied e)
	{
		if (client.getLocalPlayer() == null || e.getActor().equals(client.getLocalPlayer()))
		{
			return;
		}

		switch (e.getHitsplat().getHitsplatType())
		{
			case DAMAGE_ME:
				if (tracker == null || tracker.getName() == null)
				{
					tracker = new DpsTracker(client.getLocalPlayer().getName());
				}
				tracker.addDamage(e.getHitsplat().getAmount());

				final PartyMember localMember = partyService.getLocalMember();
				if (localMember != null)
				{
					totalTracker.addDamage(e.getHitsplat().getAmount());

					final DpsUpdate update = new DpsUpdate(e.getHitsplat().getAmount());
					update.setMemberId(localMember.getMemberId());
					wsClient.send(update);
				}
				break;
		}
	}

	@Subscribe
	protected void onInteractingChanged(InteractingChanged event)
	{
		if (tracker == null || tracker.isPaused()
			|| event.getSource() != client.getLocalPlayer()
			|| dpsConfig.idleTimeout() == 0)
		{
			return;
		}

		final boolean idleFlag = event.getTarget() == null || event.getTarget().getCombatLevel() < 1;
		if (!idleFlag)
		{
			idleStartTime = null;
		}
		else if (idleStartTime == null)
		{
			idleStartTime = Instant.now();
		}
	}

	@Subscribe
	protected void onGameTick(final GameTick tick)
	{
		if (tracker == null || idleStartTime == null || dpsConfig.idleTimeout() == 0)
		{
			idleStartTime = null; // Reset here in case of config/tracker change while idle
			return;
		}

		if (tracker.isPaused())
		{
			// Adjust end point to account for idle time
			if (tracker.getEnd().compareTo(idleStartTime) > 0)
			{
				tracker.getEnd().plus(Duration.between(idleStartTime, tracker.getEnd()));
			}
			idleStartTime = null;
			return;
		}

		final Duration idleTime = Duration.between(idleStartTime, Instant.now());
		if (idleTime.compareTo(Duration.ofSeconds(dpsConfig.idleTimeout())) > 0)
		{
			tracker.setEnd(Instant.now().minus(idleTime));
			idleStartTime = null;
		}
	}

	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked event)
	{
		if (event.getEntry().getMenuAction() != MenuAction.RUNELITE_OVERLAY ||
			!event.getEntry().getTarget().equals("DPS counter"))
		{
			return;
		}

		switch (event.getEntry().getOption())
		{
			case "Reset":
				tracker.reset();
				break;
			case "Pause":
				if (tracker.isPaused())
				{
					tracker.unpause();
				}
				else
				{
					tracker.pause();
				}
				break;
		}
	}

	@Subscribe
	public void onDpsUpdate(DpsUpdate dpsUpdate)
	{
		if (partyService.getLocalMember().getMemberId().equals(dpsUpdate.getMemberId()))
		{
			return;
		}

		String name = partyService.getMemberById(dpsUpdate.getMemberId()).getName();
		if (name == null)
		{
			return;
		}

		DpsTracker dpsTracker = members.computeIfAbsent(name, DpsTracker::new);
		dpsTracker.addDamage(dpsUpdate.getHit());
		totalTracker.addDamage(dpsUpdate.getHit());
	}

	private void pause()
	{
		tracker.pause();

		if (partyService.getLocalMember() != null)
		{
			for (DpsTracker dpsTracker : members.values())
			{
				dpsTracker.pause();
			}
			totalTracker.pause();
		}
	}
}
