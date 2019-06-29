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
package net.runelite.client.game;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;

@Singleton
public class HiscoreManager
{
	@AllArgsConstructor
	@Data
	static class HiscoreKey
	{
		String username;
		HiscoreEndpoint type;
	}

	static final HiscoreResult EMPTY = new HiscoreResult();
	static final HiscoreResult NONE = new HiscoreResult();

	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private final LoadingCache<HiscoreKey, HiscoreResult> hiscoreCache;

	@Inject
	public HiscoreManager(Client client, ScheduledExecutorService executor, ClientThread clientThread)
	{
		hiscoreCache = CacheBuilder.newBuilder()
			.maximumSize(128L)
			.expireAfterWrite(1, TimeUnit.HOURS)
			.build(new HiscoreLoader(executor, hiscoreClient));
	}

	/**
	 * Synchronously look up a players hiscore from a specified endpoint
	 *
	 * @param username Players username
	 * @param endpoint Hiscore endpoint
	 * @return HiscoreResult or null
	 * @throws IOException Upon error in fetching hiscore
	 */
	public HiscoreResult lookup(String username, HiscoreEndpoint endpoint) throws IOException
	{
		HiscoreKey hiscoreKey = new HiscoreKey(username, endpoint);
		HiscoreResult hiscoreResult = hiscoreCache.getIfPresent(hiscoreKey);
		if (hiscoreResult != null && hiscoreResult != EMPTY)
		{
			return hiscoreResult == NONE ? null : hiscoreResult;
		}

		hiscoreResult = hiscoreClient.lookup(username, endpoint);
		if (hiscoreResult == null)
		{
			hiscoreCache.put(hiscoreKey, NONE);
			return null;
		}

		hiscoreCache.put(hiscoreKey, hiscoreResult);
		return hiscoreResult;
	}

	/**
	 * Asynchronously look up a players hiscore from a specified endpoint
	 *
	 * @param username Players username
	 * @param endpoint Hiscore endpoint
	 * @return HiscoreResult or null
	 */
	public HiscoreResult lookupAsync(String username, HiscoreEndpoint endpoint)
	{
		HiscoreKey hiscoreKey = new HiscoreKey(username, endpoint);
		HiscoreResult hiscoreResult = hiscoreCache.getIfPresent(hiscoreKey);
		if (hiscoreResult != null && hiscoreResult != EMPTY)
		{
			return hiscoreResult == NONE ? null : hiscoreResult;
		}

		hiscoreCache.refresh(hiscoreKey);
		return null;
	}
}
