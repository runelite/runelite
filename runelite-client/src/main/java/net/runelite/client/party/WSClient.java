/*
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
package net.runelite.client.party;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.party.events.UserJoin;
import net.runelite.client.party.events.UserPart;
import net.runelite.client.party.messages.PartyMemberMessage;
import net.runelite.client.party.messages.WebsocketMessage;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

@Slf4j
@Singleton
public class WSClient extends WebSocketListener implements AutoCloseable
{
	private final EventBus eventBus;
	private final OkHttpClient okHttpClient;
	private final HttpUrl runeliteWs;
	private final Collection<Class<? extends WebsocketMessage>> messages = new HashSet<>();

	private volatile Gson gson;
	@Getter
	private UUID sessionId;
	private WebSocket webSocket;

	@Inject
	private WSClient(EventBus eventBus, OkHttpClient okHttpClient, @Named("runelite.ws") HttpUrl runeliteWs)
	{
		this.eventBus = eventBus;
		this.okHttpClient = okHttpClient;
		this.runeliteWs = runeliteWs;
		this.gson = WebsocketGsonFactory.build(WebsocketGsonFactory.factory(messages));
	}

	public boolean sessionExists()
	{
		return sessionId != null;
	}

	public void changeSession(UUID sessionId)
	{
		if (Objects.equals(sessionId, this.sessionId))
		{
			return;
		}

		if (webSocket != null)
		{
			close();
			webSocket = null;
		}

		this.sessionId = sessionId;

		if (sessionId != null)
		{
			connect();
		}
	}

	void connect()
	{
		if (sessionId == null)
		{
			throw new IllegalStateException("Cannot connect with no session id");
		}

		Request request = new Request.Builder()
			.url(runeliteWs.newBuilder()
				.addQueryParameter("sessionId", sessionId.toString())
				.build())
			.header("User-Agent", RuneLite.USER_AGENT)
			.build();

		webSocket = okHttpClient.newWebSocket(request, this);
	}

	boolean isOpen()
	{
		return webSocket != null;
	}

	public void registerMessage(final Class<? extends WebsocketMessage> message)
	{
		if (messages.add(message))
		{
			gson = WebsocketGsonFactory.build(WebsocketGsonFactory.factory(messages));
		}
	}

	public void unregisterMessage(final Class<? extends WebsocketMessage> message)
	{
		if (messages.remove(message))
		{
			gson = WebsocketGsonFactory.build(WebsocketGsonFactory.factory(messages));
		}
	}

	void join(long partyId, long memberId)
	{
		final Party.Join join = Party.Join.newBuilder()
			.setPartyId(partyId)
			.setMemberId(memberId)
			.build();
		final Party.C2S c2s = Party.C2S.newBuilder()
			.setJoin(join)
			.build();
		send(c2s);
	}

	void part()
	{
		final Party.Part part = Party.Part.newBuilder()
			.build();
		final Party.C2S c2s = Party.C2S.newBuilder()
			.setPart(part)
			.build();
		send(c2s);
	}

	void send(WebsocketMessage message)
	{
		log.debug("Sending: {}", message);
		final String json = gson.toJson(message, WebsocketMessage.class);
		final Party.Data data = Party.Data.newBuilder()
			.setType(message.getClass().getSimpleName())
			.setData(com.google.protobuf.ByteString.copyFromUtf8(json))
			.build();
		final Party.C2S c2s = Party.C2S.newBuilder()
			.setData(data)
			.build();
		send(c2s);
	}

	private void send(Party.C2S message)
	{
		if (webSocket == null)
		{
			log.debug("Reconnecting to server");
			connect();
		}

		webSocket.send(ByteString.of(message.toByteArray()));
	}

	@Override
	public void close()
	{
		if (webSocket != null)
		{
			webSocket.close(1000, null);
		}
	}

	@Override
	public void onOpen(WebSocket webSocket, Response response)
	{
		log.info("Websocket {} opened", webSocket);
	}

	@Override
	public void onMessage(WebSocket webSocket, ByteString bytes)
	{
		Party.S2C s2c;
		try
		{
			s2c = Party.S2C.parseFrom(bytes.toByteArray());
		}
		catch (InvalidProtocolBufferException e)
		{
			log.debug("Failed to deserialize message", e);
			return;
		}

		switch (s2c.getMsgCase())
		{
			case JOIN:
				Party.UserJoin join = s2c.getJoin();
				UserJoin userJoin = new UserJoin(join.getPartyId(), join.getMemberId());
				log.debug("Got: {}", userJoin);
				eventBus.post(userJoin);
				break;
			case PART:
				Party.UserPart part = s2c.getPart();
				UserPart userPart = new UserPart(part.getMemberId());
				log.debug("Got: {}", userPart);
				eventBus.post(userPart);
				break;
			case DATA:
				Party.PartyData data = s2c.getData();
				final WebsocketMessage message;

				try
				{
					message = gson.fromJson(data.getData().toStringUtf8(), WebsocketMessage.class);
				}
				catch (JsonParseException e)
				{
					log.debug("Failed to deserialize message", e);
					return;
				}

				if (message instanceof PartyMemberMessage)
				{
					((PartyMemberMessage) message).setMemberId(data.getMemberId());
				}

				log.debug("Got: {}", message);
				eventBus.post(message);
		}
	}

	@Override
	public void onClosed(WebSocket webSocket, int code, String reason)
	{
		log.info("Websocket {} closed: {}/{}", webSocket, code, reason);
		this.webSocket = null;
	}

	@Override
	public void onFailure(WebSocket webSocket, Throwable t, Response response)
	{
		log.warn("Error in websocket: {}", response, t);
		this.webSocket = null;
	}
}
