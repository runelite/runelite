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
package net.runelite.http.api.ws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.runelite.http.api.ws.messages.Handshake;
import net.runelite.http.api.ws.messages.LoginResponse;
import net.runelite.http.api.ws.messages.party.Join;
import net.runelite.http.api.ws.messages.party.Part;
import net.runelite.http.api.ws.messages.party.PartyChatMessage;
import net.runelite.http.api.ws.messages.party.UserJoin;
import net.runelite.http.api.ws.messages.party.UserPart;
import net.runelite.http.api.ws.messages.party.UserSync;

public class WebsocketGsonFactory
{
	private static final Collection<Class<? extends WebsocketMessage>> MESSAGES;

	static
	{
		final List<Class<? extends WebsocketMessage>> messages = new ArrayList<>();
		messages.add(Handshake.class);
		messages.add(LoginResponse.class);
		messages.add(Join.class);
		messages.add(Part.class);
		messages.add(UserJoin.class);
		messages.add(UserPart.class);
		messages.add(UserSync.class);
		messages.add(PartyChatMessage.class);
		MESSAGES = messages;
	}

	public static RuntimeTypeAdapterFactory<WebsocketMessage> factory(final Collection<Class<? extends WebsocketMessage>> messages)
	{
		final RuntimeTypeAdapterFactory<WebsocketMessage> factory = RuntimeTypeAdapterFactory.of(WebsocketMessage.class);

		for (Class<? extends WebsocketMessage> message : MESSAGES)
		{
			factory.registerSubtype(message);
		}

		for (Class<? extends WebsocketMessage> message : messages)
		{
			factory.registerSubtype(message);
		}

		return factory;
	}

	public static Gson build(final RuntimeTypeAdapterFactory<WebsocketMessage> factory)
	{
		return new GsonBuilder()
			.registerTypeAdapterFactory(factory)
			.create();
	}

	public static Gson build()
	{
		return build(factory(Collections.emptyList()));
	}
}
