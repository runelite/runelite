/*
 * Copyright (c) 2018 Ben Dol <dolb90@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
import java.util.concurrent.ScheduledExecutorService;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import net.runelite.http.api.item.ItemInfo;
import net.runelite.http.api.osrsbox.ItemNotFoundException;
import net.runelite.http.api.osrsbox.OSRSBoxClient;

import static net.runelite.client.game.ItemInfoManager.EMPTY;
import static net.runelite.client.game.ItemInfoManager.NONE;

/**
 * @author Ben Dol
 */
@Slf4j
class ItemInfoLoader extends CacheLoader<Integer, ItemInfo>
{
	private final ListeningExecutorService executorService;

	@Getter
	private boolean loading;

	ItemInfoLoader(ScheduledExecutorService executor)
	{
		this.executorService = MoreExecutors.listeningDecorator(executor);
	}

	@Override
	public ItemInfo load(Integer key) throws Exception
	{
		return EMPTY;
	}

	@Override
	public ListenableFuture<ItemInfo> reload(Integer key, ItemInfo oldValue)
	{
		log.debug("Submitting item lookup for {}", key);

		return executorService.submit(() -> fetch(key));
	}

	private ItemInfo fetch(Integer key)
	{
		try
		{
			loading = true;
			return OSRSBoxClient.getItem(key);
		}
		catch (ItemNotFoundException ex)
		{
			log.debug("Unable to look up item!", ex);
			return NONE;
		}
		finally
		{
			loading = false;
		}
	}

}

