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
package net.runelite.client.ws;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.EventBus;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.ws.WebsocketGsonFactory;
import net.runelite.http.api.ws.WebsocketMessage;
import net.runelite.http.api.ws.messages.Handshake;
import net.runelite.http.api.ws.messages.party.PartyMessage;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

@Slf4j
@Singleton
public class WSClient extends WebSocketListener implements AutoCloseable
{
	private final EventBus eventBus;
	private final Collection<Class<? extends WebsocketMessage>> messages = new HashSet<>();

	private volatile Gson gson;
	@Getter
	private UUID sessionId;
	private WebSocket webSocket;

	@Inject
	private WSClient(EventBus eventBus)
	{
		this.eventBus = eventBus;
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

	private void connect()
	{
		if (sessionId == null)
		{
			throw new IllegalStateException("Cannot connect with no session id");
		}

		Request request = new Request.Builder()
			.url(RuneLiteAPI.getWsEndpoint())
			.build();

		webSocket = RuneLiteAPI.CLIENT.newWebSocket(request, this);

		Handshake handshake = new Handshake();
		handshake.setSession(sessionId);
		send(handshake);
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

	public void send(WebsocketMessage message)
	{
		if (webSocket == null)
		{
			log.debug("Reconnecting to server");
			connect();
		}

		final String json = gson.toJson(message, WebsocketMessage.class);
		webSocket.send(json);
		log.debug("Sent: {}", json);
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
	public void onMessage(WebSocket webSocket, String text)
	{
		final WebsocketMessage message;

		try
		{
			message = gson.fromJson(text, WebsocketMessage.class);
		}
		catch (JsonParseException e)
		{
			log.debug("Failed to deserialize message", e);
			return;
		}

		if (message.isParty() && !(message instanceof PartyMessage))
		{
			// spoofed message?
			return;
		}

		log.debug("Got: {}", text);
		eventBus.post(PartyMessage.class, message);
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
		log.warn("Error in websocket {}:{}", response, t);
		this.webSocket = null;
	}
}
