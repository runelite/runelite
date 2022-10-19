/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2021, Jonathan Rousseau <https://github.com/JoRouss>
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
package net.runelite.client.party;

import com.google.common.base.CharMatcher;
import com.google.common.hash.Hashing;
import java.awt.image.BufferedImage;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.events.PartyMemberAvatar;
import net.runelite.client.party.events.UserJoin;
import net.runelite.client.party.events.UserPart;
import net.runelite.client.party.messages.PartyChatMessage;
import net.runelite.client.party.messages.PartyMessage;
import net.runelite.client.party.messages.UserSync;
import net.runelite.client.util.Text;
import static net.runelite.client.util.Text.JAGEX_PRINTABLE_CHAR_MATCHER;

@Slf4j
@Singleton
public class PartyService
{
	private static final int MAX_MESSAGE_LEN = 150;
	private static final String ALPHABET = "bcdfghjklmnpqrstvwxyz";

	private final Client client;
	private final WSClient wsClient;
	private final EventBus eventBus;
	private final ChatMessageManager chat;
	private final List<PartyMember> members = new ArrayList<>();

	@Getter
	private long partyId; // secret party id
	private long memberId = randomMemberId();
	@Getter
	private String partyPassphrase;

	@Inject
	private PartyService(final Client client, final WSClient wsClient, final EventBus eventBus, final ChatMessageManager chat)
	{
		this.client = client;
		this.wsClient = wsClient;
		this.eventBus = eventBus;
		this.chat = chat;
		eventBus.register(this);
	}

	public String generatePassphrase()
	{
		assert client.isClientThread();

		Random r = new Random();
		StringBuilder sb = new StringBuilder();

		if (client.getGameState().getState() >= GameState.LOGIN_SCREEN.getState())
		{
			int len = 0;
			final CharMatcher matcher = CharMatcher.javaLetter();
			do
			{
				final int itemId = r.nextInt(client.getItemCount());
				final ItemComposition def = client.getItemDefinition(itemId);
				final String name = def.getMembersName();
				if (name == null || name.isEmpty() || name.equalsIgnoreCase("null"))
				{
					continue;
				}

				final String[] split = name.split(" ");
				final String token = split[r.nextInt(split.length)];
				if (!matcher.matchesAllOf(token) || token.length() <= 2)
				{
					continue;
				}

				if (sb.length() > 0)
				{
					sb.append('-');
				}
				sb.append(token.toLowerCase(Locale.US));
				++len;
			}
			while (len < 4);
		}
		else
		{
			int len = 0;
			do
			{
				if (sb.length() > 0)
				{
					sb.append('-');
				}
				for (int i = 0; i < 5; ++i)
				{
					sb.append(ALPHABET.charAt(r.nextInt(ALPHABET.length())));
				}
				++len;
			}
			while (len < 4);
		}

		String partyPassphrase = sb.toString();
		log.debug("Generated party passphrase {}", partyPassphrase);
		return partyPassphrase;
	}

	public void changeParty(@Nullable String passphrase)
	{
		if (wsClient.sessionExists())
		{
			wsClient.part();
			memberId = randomMemberId(); // use a different member id between parties
		}

		long id = passphrase != null ? passphraseToId(passphrase) : 0;

		log.debug("Party change to {} (id {})", passphrase, id);
		members.clear();
		partyId = id;
		partyPassphrase = passphrase;

		if (passphrase == null)
		{
			wsClient.changeSession(null);
			eventBus.post(new PartyChanged(partyPassphrase, null));
			return;
		}

		// If there isn't already a session open, open one
		if (!wsClient.sessionExists())
		{
			wsClient.changeSession(UUID.randomUUID());
		}

		eventBus.post(new PartyChanged(partyPassphrase, partyId));
		wsClient.join(partyId, memberId);
	}

	public <T extends PartyMessage> void send(T message)
	{
		if (!wsClient.isOpen())
		{
			log.debug("Reconnecting to server");

			members.clear();

			wsClient.connect();
			wsClient.join(partyId, memberId);
		}

		wsClient.send(message);
	}

	@Subscribe(priority = 1) // run prior to plugins so that the member is joined by the time the plugins see it.
	public void onUserJoin(final UserJoin message)
	{
		if (partyId != message.getPartyId())
		{
			// This can happen when a session is resumed server side after the client party
			// changes when disconnected.
			return;
		}

		PartyMember partyMember = getMemberById(message.getMemberId());
		if (partyMember == null)
		{
			partyMember = new PartyMember(message.getMemberId());
			members.add(partyMember);
			log.debug("User {} joins party, {} members", partyMember, members.size());
		}

		final PartyMember localMember = getLocalMember();
		// Send info to other clients that this user successfully finished joining party
		if (localMember != null && localMember == partyMember)
		{
			log.debug("Requesting sync");
			final UserSync userSync = new UserSync();
			wsClient.send(userSync);
		}
	}

	@Subscribe(priority = 1) // run prior to plugins so that the member is removed by the time the plugins see it.
	public void onUserPart(final UserPart message)
	{
		if (members.removeIf(member -> member.getMemberId() == message.getMemberId()))
		{
			log.debug("User {} leaves party, {} members", message.getMemberId(), members.size());
		}
	}

	@Subscribe
	public void onPartyChatMessage(final PartyChatMessage message)
	{
		final PartyMember member = getMemberById(message.getMemberId());
		if (member == null || !member.isLoggedIn())
		{
			log.debug("Dropping party chat from non logged-in member");
			return;
		}

		// Remove non-printable characters, and <img> tags from message
		String sentMesage = JAGEX_PRINTABLE_CHAR_MATCHER.retainFrom(message.getValue())
			.replaceAll("<img=.+>", "");

		// Cap the message length
		if (sentMesage.length() > MAX_MESSAGE_LEN)
		{
			sentMesage = sentMesage.substring(0, MAX_MESSAGE_LEN);
		}

		chat.queue(QueuedMessage.builder()
			.type(ChatMessageType.FRIENDSCHAT)
			.sender("Party")
			.name(member.getDisplayName())
			.runeLiteFormattedMessage(sentMesage)
			.build());
	}

	public PartyMember getLocalMember()
	{
		return getMemberById(memberId);
	}

	public PartyMember getMemberById(final long id)
	{
		for (PartyMember member : members)
		{
			if (id == member.getMemberId())
			{
				return member;
			}
		}

		return null;
	}

	public PartyMember getMemberByDisplayName(final String name)
	{
		String sanitized = Text.removeTags(Text.toJagexName(name));
		for (PartyMember member : members)
		{
			if (member.isLoggedIn() && sanitized.equals(member.getDisplayName()))
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

	public boolean isInParty()
	{
		return partyId != 0;
	}

	public void setPartyMemberAvatar(long memberID, BufferedImage image)
	{
		final PartyMember memberById = getMemberById(memberID);

		if (memberById != null)
		{
			memberById.setAvatar(image);
			eventBus.post(new PartyMemberAvatar(memberID, image));
		}
	}

	private static long passphraseToId(String passphrase)
	{
		return Hashing.sha256().hashBytes(
			passphrase.getBytes(StandardCharsets.UTF_8)
		).asLong() & Long.MAX_VALUE;
	}

	private static long randomMemberId()
	{
		return new Random().nextLong() & Long.MAX_VALUE;
	}
}
