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
package net.runelite.client;

import net.runelite.http.api.RuneliteAPI;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WSClient extends WebSocketListener implements AutoCloseable
{
	private static final Logger logger = LoggerFactory.getLogger(WSClient.class);

	private final OkHttpClient client = new OkHttpClient();

	private WebSocket webSocket;

	public WSClient()
	{
		connect();
	}

	private void connect()
	{
		Request request = new Request.Builder()
			.url(RuneliteAPI.getWsEndpoint())
			.build();

		webSocket = client.newWebSocket(request, this);
	}

	@Override
	public void close()
	{
		webSocket.close(0, null);
	}

	@Override
	public void onOpen(WebSocket webSocket, Response response)
	{
		logger.info("Websocket {} opened", webSocket);

		webSocket.send("Hello");
	}

	@Override
	public void onMessage(WebSocket webSocket, String text)
	{
		logger.debug("Got message: {}", text);
	}

	@Override
	public void onClosed(WebSocket webSocket, int code, String reason)
	{
		logger.info("Websocket {} closed: {}/{}", webSocket, code, reason);
		this.webSocket = null;
	}

	@Override
	public void onFailure(WebSocket webSocket, Throwable t, Response response)
	{
		logger.warn("Error in websocket", t);
		this.webSocket = null;
	}
}
