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

import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.client.game.HiscoreManager.EMPTY;
import static net.runelite.client.game.HiscoreManager.NONE;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;

@Slf4j
class HiscoreLoader extends CacheLoader<HiscoreManager.HiscoreKey, HiscoreResult>
{
	private final ListeningExecutorService executorService;
	private final HiscoreClient hiscoreClient;

	HiscoreLoader(ScheduledExecutorService executor, HiscoreClient client)
	{
		this.executorService = MoreExecutors.listeningDecorator(executor);
		this.hiscoreClient = client;
	}

	@Override
	public HiscoreResult load(HiscoreManager.HiscoreKey hiscoreKey) throws Exception
	{
		return EMPTY;
	}

	@Override
	public ListenableFuture<HiscoreResult> reload(HiscoreManager.HiscoreKey hiscoreKey, HiscoreResult oldValue)
	{
		log.debug("Submitting hiscore lookup for {} type {}", hiscoreKey.getUsername(), hiscoreKey.getType());

		return executorService.submit(() -> fetch(hiscoreKey));
	}

	private HiscoreResult fetch(HiscoreManager.HiscoreKey hiscoreKey)
	{
		String username = hiscoreKey.getUsername();
		HiscoreEndpoint endpoint = hiscoreKey.getType();

		try
		{
			HiscoreResult result = hiscoreClient.lookup(username, endpoint);
			if (result == null)
			{
				return NONE;
			}
			return result;
		}
		catch (IOException ex)
		{
			log.warn("Unable to look up hiscore!", ex);
			return NONE;
		}
	}

}

