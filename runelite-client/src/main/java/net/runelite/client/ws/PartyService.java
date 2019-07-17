/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.ws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.PartyChanged;
import net.runelite.http.api.ws.messages.party.Join;
import net.runelite.http.api.ws.messages.party.Part;
import net.runelite.http.api.ws.messages.party.UserJoin;
import net.runelite.http.api.ws.messages.party.UserPart;
import net.runelite.http.api.ws.messages.party.UserSync;

@Slf4j
@Singleton
public class PartyService
{
	public static final int PARTY_MAX = 15;

	private final WSClient wsClient;
	private final SessionManager sessionManager;
	private final EventBus eventBus;
	private final List<PartyMember> members = new ArrayList<>();

	@Getter
	private UUID localPartyId = UUID.randomUUID();

	@Getter
	private UUID partyId = localPartyId;

	@Setter
	private String username;

	@Inject
	private PartyService(final WSClient wsClient, final SessionManager sessionManager, final EventBus eventBus)
	{
		this.wsClient = wsClient;
		this.sessionManager = sessionManager;
		this.eventBus = eventBus;

		eventBus.subscribe(UserJoin.class, this, this::onUserJoin);
		eventBus.subscribe(UserPart.class, this, this::onUserPart);
	}

	public void changeParty(UUID newParty)
	{
		if (wsClient.sessionExists())
		{
			wsClient.send(new Part());
		}

		log.debug("Party change to {}", newParty);
		members.clear();
		partyId = newParty;

		if (partyId == null)
		{
			localPartyId = UUID.randomUUID(); // cycle local party id so that a new party is created now
			partyId = localPartyId;

			// close the websocket if the session id isn't for an account
			if (sessionManager.getAccountSession() == null)
			{
				wsClient.changeSession(null);
			}

			eventBus.post(PartyChanged.class, new PartyChanged(partyId));
			return;
		}

		// If there isn't already a session open, open one
		if (!wsClient.sessionExists())
		{
			AccountSession accountSession = sessionManager.getAccountSession();
			// Use the existing account session, if it exists, otherwise generate a new session id
			UUID uuid = accountSession != null ? accountSession.getUuid() : UUID.randomUUID();
			wsClient.changeSession(uuid);
		}

		eventBus.post(PartyChanged.class, new PartyChanged(partyId));
		wsClient.send(new Join(partyId, username));
	}

	private void onUserJoin(final UserJoin message)
	{
		if (!partyId.equals(message.getPartyId()))
		{
			// This can happen when a session is resumed server side after the client party
			// changes when disconnected.
			return;
		}

		final PartyMember partyMember = new PartyMember(message.getMemberId(), message.getName());
		members.add(partyMember);

		final PartyMember localMember = getLocalMember();

		// Send info to other clients that this user successfully finished joining party
		if (localMember != null && message.getMemberId().equals(localMember.getMemberId()))
		{
			final UserSync userSync = new UserSync();
			userSync.setMemberId(message.getMemberId());
			wsClient.send(userSync);
		}
	}

	private void onUserPart(final UserPart message)
	{
		members.removeIf(member -> member.getMemberId().equals(message.getMemberId()));
	}

	public PartyMember getLocalMember()
	{
		return getMemberByName(username);
	}

	public PartyMember getMemberById(final UUID id)
	{
		for (PartyMember member : members)
		{
			if (id.equals(member.getMemberId()))
			{
				return member;
			}
		}

		return null;
	}

	public PartyMember getMemberByName(final String name)
	{
		for (PartyMember member : members)
		{
			if (name.equals(member.getName()))
			{
				return member;
			}
		}

		return null;
	}

	public List<PartyMember> getMembers()
	{
		return Collections.unmodifiableList(members);
	}

	public boolean isOwner()
	{
		return partyId == null || localPartyId.equals(partyId);
	}
}
