/*
 * Copyright (c) 2018, AeonLucid <https://github.com/AeonLucid>
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
package net.runelite.http.service.osb.grandexchange;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import net.runelite.http.service.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/osb/ge")
public class GrandExchangeController
{
	private static final int CACHE_MAX_SIZE = 2048;

	private static final int CACHE_EXPIRY_MINUTES = 2;

	private final GrandExchangeService grandExchangeService;

	private final Cache<Integer, GrandExchangeEntry> cache;

	@Autowired
	public GrandExchangeController(GrandExchangeService grandExchangeService)
	{
		this.grandExchangeService = grandExchangeService;
		this.cache = CacheBuilder.newBuilder()
			.maximumSize(CACHE_MAX_SIZE)
			.expireAfterWrite(CACHE_EXPIRY_MINUTES, TimeUnit.MINUTES)
			.build();
	}

	@RequestMapping
	public GrandExchangeEntry get(@RequestParam("itemId") int itemId) throws ExecutionException
	{
		return this.cache.get(itemId, () ->
		{
			GrandExchangeEntry entry = grandExchangeService.get(itemId);

			if (entry == null)
			{
				throw new NotFoundException();
			}

			return entry;
		});
	}
}
