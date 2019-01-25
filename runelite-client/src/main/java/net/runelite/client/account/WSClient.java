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
package net.runelite.client.account;

import com.google.gson.Gson;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.EventBus;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.ws.WebsocketGsonFactory;
import net.runelite.http.api.ws.WebsocketMessage;
import net.runelite.http.api.ws.messages.Handshake;
import net.runelite.http.api.ws.messages.Ping;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

@Slf4j
public class WSClient extends WebSocketListener implements AutoCloseable
{
	private static final Duration PING_TIME = Duration.ofSeconds(30);
	private static final Gson GSON = WebsocketGsonFactory.build();

	private final OkHttpClient client = new OkHttpClient();
	private final EventBus eventBus;
	private final ScheduledFuture pingFuture;
	private final AccountSession session;
	private WebSocket webSocket;

	WSClient(EventBus eventBus, ScheduledExecutorService executor, AccountSession session)
	{
		this.eventBus = eventBus;
		this.session = session;
		this.pingFuture = executor.scheduleWithFixedDelay(this::ping, PING_TIME.getSeconds(), PING_TIME.getSeconds(), TimeUnit.SECONDS);
	}

	boolean checkSession(AccountSession session)
	{
		return session.equals(this.session);
	}

	void connect()
	{
		Request request = new Request.Builder()
			.url(RuneLiteAPI.getWsEndpoint())
			.build();

		webSocket = client.newWebSocket(request, this);

		Handshake handshake = new Handshake();
		handshake.setSession(session.getUuid());
		send(handshake);
	}

	private void ping()
	{
		if (webSocket == null)
		{
			// Don't open a socket just for ping.
			return;
		}

		Ping ping = new Ping();
		ping.setTime(Instant.now());
		send(ping);
	}

	private void send(WebsocketMessage message)
	{
		if (webSocket == null)
		{
			log.debug("Reconnecting to server");

			connect();
		}

		String json = GSON.toJson(message, WebsocketMessage.class);
		webSocket.send(json);

		log.debug("Sent: {}", json);
	}

	@Override
	public void close()
	{
		if (pingFuture != null)
		{
			pingFuture.cancel(true);
		}

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
		WebsocketMessage message = GSON.fromJson(text, WebsocketMessage.class);
		log.debug("Got message: {}", message);

		eventBus.post(message);
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
		log.warn("Error in websocket", t);
		this.webSocket = null;
	}
}
