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
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.item.ItemClient;
import net.runelite.http.api.item.SearchResult;

import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author Ben Dol
 */
@Slf4j
class ItemSearchLoader extends CacheLoader<String, SearchResult>
{
	static final SearchResult EMPTY = new SearchResult();
	static final SearchResult NONE = new SearchResult();

	private final ItemClient itemClient;
	private final ListeningExecutorService executorService;

	@Getter
	private boolean loading;

	public ItemSearchLoader(ItemClient itemClient, ScheduledExecutorService executor)
	{
		this.itemClient = itemClient;
		this.executorService = MoreExecutors.listeningDecorator(executor);
	}

	@Override
	public SearchResult load(String key) throws Exception
	{
		return EMPTY;
	}

	@Override
	public ListenableFuture<SearchResult> reload(String key, SearchResult oldValue) throws Exception
	{
		log.debug("Submitting item lookup for search term {}", key);

		return executorService.submit(() -> fetch(key));
	}

	private SearchResult fetch(String search)
	{
		try
		{
			loading = true;
			SearchResult result = itemClient.search(search);
			return result != null ? result : NONE;
		}
		catch (IOException ex)
		{
			log.warn("Unable to look up item!", ex);
			return NONE;
		}
		finally
		{
			loading = false;
		}
	}
}
