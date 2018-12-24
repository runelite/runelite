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
package net.runelite.client.plugins.discord.party;

import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.EventBus;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

@Slf4j
@Singleton
public class DiscordParty extends WebSocketListener
{
	private static final String WSS_PARTY = "https://discord-rooms.herokuapp.com/";
	private final OkHttpClient client;
	private EventBus eventBus;
	private final String uuid = UUID.randomUUID().toString();
	private WebSocket socket;
	private String secret;

	@Inject
	private DiscordParty(final OkHttpClient client, final EventBus eventBus)
	{
		this.client = client;
		this.eventBus = eventBus;
	}

	public void join(final String secret)
	{
		if (socket != null)
		{
			socket.close(1000, null);
		}

		final Request request = new Request.Builder()
			.url(WSS_PARTY)
			.build();

		this.secret = secret;
		socket = client.newWebSocket(request, this);
	}

	public void send(final DiscordPartyMessageType type, final String message)
	{
		if (socket == null || secret == null)
		{
			return;
		}

		socket.send(RuneLiteAPI.GSON.toJson(new DiscordPartyMessage(uuid, secret, type, message)));
	}

	@Override
	public void onMessage(WebSocket webSocket, String text)
	{
		final DiscordPartyMessage message = RuneLiteAPI.GSON.fromJson(text, DiscordPartyMessage.class);
		log.info("Got message {}", message);
		eventBus.post(message);
	}

	@Override
	public void onClosed(WebSocket webSocket, int code, String reason)
	{
		log.info("Websocket {} closed: {}/{}", webSocket, code, reason);
		secret = null;
		socket = null;
	}

	@Override
	public void onFailure(WebSocket webSocket, Throwable t, Response response)
	{
		log.warn("Error in websocket", t);
		join(secret);
	}
}
