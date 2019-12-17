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
package net.runelite.http.service.hiscore;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import okhttp3.HttpUrl;
import org.springframework.stereotype.Service;

@Service
public class HiscoreService
{
	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private final LoadingCache<HiscoreKey, HiscoreResult> hiscoreCache = CacheBuilder.newBuilder()
		.maximumSize(128)
		.expireAfterWrite(1, TimeUnit.MINUTES)
		.build(
			new CacheLoader<HiscoreKey, HiscoreResult>()
			{
				@Override
				public HiscoreResult load(HiscoreKey key) throws IOException
				{
					return hiscoreClient.lookup(key.getUsername(), key.getEndpoint());
				}
			});

	@VisibleForTesting
	HiscoreResult lookupUsername(String username, HttpUrl httpUrl) throws IOException
	{
		return hiscoreClient.lookup(username, httpUrl);
	}

	public HiscoreResult lookupUsername(String username, HiscoreEndpoint endpoint) throws ExecutionException
	{
		return hiscoreCache.get(new HiscoreKey(username, endpoint));
	}
}
