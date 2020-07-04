/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2018, Ugnius <https://github.com/UgiR>
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
package net.runelite.http.api.worlds;

import java.io.IOException;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.RuneLiteClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Slf4j
public class WorldClient extends RuneLiteClient
{

	private static final String ENDPOINT = "/worlds";

	private WorldClient(HttpClient client)
	{
		super(client, ENDPOINT);
	}

	/**
	 * Asynchronously lookup a list of worlds.
	 * Sends an {@link IOException} error signal if lookup fails with a non-200 response.
	 * The result can be handled as a {@link Future} if desired:
	 *
	 * <pre> {@code lookupWorldsAsync().toFuture;} </pre>
	 *
	 * Similarly, the {@link Future} will throw a {@link java.util.concurrent.ExecutionException}, wrapping
	 * the {@link IOException} on error.
	 *
	 * @return A {@link Mono<WorldResult>} containing the worlds.
	 */
	public Mono<WorldResult> lookupWorldsAsync()
	{
		return get(WorldResult.class)
			.retrieve()
			.defaultIfEmpty(WorldResult.builder().build());
	}

	/**
	 * Synchronously lookup a list of worlds.
	 *
	 * @return A {@link WorldResult} containing the worlds.
	 * @throws IOException if lookup fails with a non-200 response.
	 */
	public WorldResult lookupWorlds() throws IOException
	{
		try
		{
			return lookupWorldsAsync()
				.block();
		}
		catch (RuntimeException e)
		{
			throw new IOException(e);
		}
	}

	public static WorldClient create()
	{
		return create(RuneLiteAPI.getBaseClient());
	}

	public static WorldClient create(HttpClient client)
	{
		return new WorldClient(client);
	}
}
