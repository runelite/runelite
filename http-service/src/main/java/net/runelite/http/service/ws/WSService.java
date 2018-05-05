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
package net.runelite.http.service.ws;

import com.google.gson.Gson;
import java.util.UUID;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.http.api.ws.WebsocketGsonFactory;
import net.runelite.http.api.ws.WebsocketMessage;
import net.runelite.http.api.ws.messages.Handshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint("/ws")
public class WSService
{
	private static final Logger logger = LoggerFactory.getLogger(WSService.class);

	private static final Gson gson = WebsocketGsonFactory.build();

	private Session session;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private UUID uuid;

	public void send(WebsocketMessage message)
	{
		String json = gson.toJson(message, WebsocketMessage.class);

		logger.debug("Sending {}", json);

		session.getAsyncRemote().sendText(json);
	}

	@OnOpen
	public void onOpen(Session session, EndpointConfig config)
	{
		this.session = session;
		logger.debug("New session {}", session);
	}

	@OnClose
	public void onClose(Session session, CloseReason resaon)
	{
		SessionManager.remove(this);
		logger.debug("Close session {}", session);
	}

	@OnError
	public void onError(Session session, Throwable ex)
	{
		SessionManager.remove(this);
		logger.debug("Error in session {}", session, ex);
	}

	@OnMessage
	public void onMessage(Session session, String text)
	{
		WebsocketMessage message = gson.fromJson(text, WebsocketMessage.class);
		logger.debug("Got message: {}", message);

		if (message instanceof Handshake)
		{
			Handshake hs = (Handshake) message;
			SessionManager.changeSessionUID(this, hs.getSession());
		}
	}
}
