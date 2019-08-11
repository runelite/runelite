/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.discord;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.inject.Inject;
import lombok.Data;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.discord.DiscordPresence;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.ws.PartyService;
import static net.runelite.client.ws.PartyService.PARTY_MAX;

/**
 * This class contains data about currently active discord state.
 */
class DiscordState
{
	@Data
	private static class EventWithTime
	{
		private final DiscordGameEventType type;
		private final Instant start;
		private Instant updated;
	}

	private final UUID partyId = UUID.randomUUID();
	private final List<EventWithTime> events = new ArrayList<>();
	private final DiscordService discordService;
	private final DiscordPlugin plugin;
	private final PartyService party;
	private DiscordPresence lastPresence;

	@Inject
	private DiscordState(final DiscordService discordService, final DiscordPlugin plugin, final PartyService party)
	{
		this.discordService = discordService;
		this.plugin = plugin;
		this.party = party;
	}

	/**
	 * Reset state.
	 */
	void reset()
	{
		discordService.clearPresence();
		events.clear();
		lastPresence = null;
	}

	/**
	 * Force refresh discord presence
	 */
	void refresh()
	{
		if (lastPresence == null)
		{
			return;
		}

		final DiscordPresence.DiscordPresenceBuilder presenceBuilder = DiscordPresence.builder()
			.state(lastPresence.getState())
			.details(lastPresence.getDetails())
			.largeImageText(lastPresence.getLargeImageText())
			.startTimestamp(lastPresence.getStartTimestamp())
			.smallImageKey(lastPresence.getSmallImageKey())
			.partyMax(lastPresence.getPartyMax())
			.partySize(Math.max(plugin.isAlwaysShowParty() ? 1 : 0, party.getMembers().size()));

		if (party.isOwner())
		{
			presenceBuilder.partyId(partyId.toString());
			presenceBuilder.joinSecret(party.getPartyId().toString());
		}

		discordService.updatePresence(presenceBuilder.build());
	}

	/**
	 * Trigger new discord state update.
	 *
	 * @param eventType discord event type
	 */
	void triggerEvent(final DiscordGameEventType eventType)
	{
		final Optional<EventWithTime> foundEvent = events.stream().filter(e -> e.type == eventType).findFirst();
		EventWithTime event;

		if (foundEvent.isPresent())
		{
			event = foundEvent.get();
		}
		else
		{
			// If we aren't showing the elapsed time within Discord then
			// We null out the event start property
			event = new EventWithTime(eventType, plugin.isHideElapsedTime() ? null : Instant.now());

			events.add(event);
		}

		event.setUpdated(Instant.now());

		if (event.getType().isShouldClear())
		{
			events.removeIf(e -> e.getType() != eventType && e.getType().isShouldClear());
		}

		events.sort((a, b) -> ComparisonChain.start()
			.compare(b.getType().getPriority(), a.getType().getPriority())
			.compare(b.getUpdated(), a.getUpdated())
			.result());

		event = events.get(0);

		String imageKey = null;
		String state = null;
		String details = null;

		for (EventWithTime eventWithTime : events)
		{
			if (imageKey == null)
			{
				imageKey = eventWithTime.getType().getImageKey();
			}

			if (details == null)
			{
				details = eventWithTime.getType().getDetails();
			}

			if (state == null)
			{
				state = eventWithTime.getType().getState();
			}

			if (imageKey != null && details != null && state != null)
			{
				break;
			}
		}

		// Replace snapshot with + to make tooltip shorter (so it will span only 1 line)
		final String versionShortHand = RuneLiteProperties.getVersion().replace("-SNAPSHOT", "+");

		final DiscordPresence.DiscordPresenceBuilder presenceBuilder = DiscordPresence.builder()
			.state(MoreObjects.firstNonNull(state, ""))
			.details(MoreObjects.firstNonNull(details, ""))
			.largeImageText(RuneLiteProperties.getTitle() + " v" + versionShortHand)
			.startTimestamp(event.getStart())
			.smallImageKey(imageKey)
			.partyMax(PARTY_MAX)
			.partySize(party.getMembers().size());

		if (party.isOwner())
		{
			presenceBuilder.partyId(partyId.toString());
			presenceBuilder.joinSecret(party.getPartyId().toString());
		}

		final DiscordPresence presence = presenceBuilder.build();

		// This is to reduce amount of RPC calls
		if (!presence.equals(lastPresence))
		{
			lastPresence = presence;
			discordService.updatePresence(presence);
		}
	}

	/**
	 * Check for current state timeout and act upon it.
	 */
	void checkForTimeout()
	{
		final Duration actionTimeout = Duration.ofMinutes(plugin.getActionTimeout());
		final Instant now = Instant.now();
		events.removeIf(event -> event.getType().isShouldTimeout() && now.isAfter(event.getUpdated().plus(actionTimeout)));
	}
}
