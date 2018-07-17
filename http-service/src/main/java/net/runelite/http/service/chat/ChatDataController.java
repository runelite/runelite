/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.http.service.chat;

import com.google.common.base.Strings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.service.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatDataController
{
	private final Cache<ChatDataKey, String> cache = CacheBuilder.newBuilder()
		.expireAfterWrite(2, TimeUnit.MINUTES)
		.maximumSize(128L)
		.build();

	private final ChatDataService chatDataService;

	@Autowired
	public ChatDataController(ChatDataService chatDataService)
	{
		this.chatDataService = chatDataService;
	}

	@PostMapping
	public void submit(@RequestParam String name, @RequestParam String type, @RequestParam(required = false) String subtype, @RequestParam String data)
	{
		if (Strings.isNullOrEmpty(type))
		{
			return;
		}

		final ChatDataKey key = new ChatDataKey(name, type, subtype);
		chatDataService.setData(name, type, subtype, data);
		cache.put(key, data);
	}

	@GetMapping
	public String get(@RequestParam String name, @RequestParam String type, @RequestParam(required = false) String subtype)
	{
		final ChatDataKey key = new ChatDataKey(name, type, subtype);
		String data = cache.getIfPresent(key);

		if (data == null)
		{
			data = chatDataService.getData(name, type, subtype);

			if (data != null)
			{
				cache.put(key, data);
			}
		}

		if (data == null)
		{
			throw new NotFoundException();
		}

		return data;
	}
}
