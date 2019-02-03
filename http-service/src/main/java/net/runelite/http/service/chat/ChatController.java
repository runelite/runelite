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
package net.runelite.http.service.chat;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.runelite.http.api.chat.Task;
import net.runelite.http.service.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController
{
	private static final Pattern STRING_VALIDATION = Pattern.compile("[^a-zA-Z0-9' -]");
	private static final int STRING_MAX_LENGTH = 50;

	private final Cache<KillCountKey, Integer> killCountCache = CacheBuilder.newBuilder()
		.expireAfterWrite(2, TimeUnit.MINUTES)
		.maximumSize(128L)
		.build();

	@Autowired
	private ChatService chatService;

	@PostMapping("/kc")
	public void submitKc(@RequestParam String name, @RequestParam String boss, @RequestParam int kc)
	{
		if (kc <= 0)
		{
			return;
		}

		chatService.setKc(name, boss, kc);
		killCountCache.put(new KillCountKey(name, boss), kc);
	}

	@GetMapping("/kc")
	public int getKc(@RequestParam String name, @RequestParam String boss)
	{
		Integer kc = killCountCache.getIfPresent(new KillCountKey(name, boss));
		if (kc == null)
		{
			kc = chatService.getKc(name, boss);
			if (kc != null)
			{
				killCountCache.put(new KillCountKey(name, boss), kc);
			}
		}

		if (kc == null)
		{
			throw new NotFoundException();
		}
		return kc;
	}

	@PostMapping("/qp")
	public void submitQp(@RequestParam String name, @RequestParam int qp)
	{
		if (qp < 0)
		{
			return;
		}

		chatService.setQp(name, qp);
	}

	@GetMapping("/qp")
	public int getQp(@RequestParam String name)
	{
		Integer kc = chatService.getQp(name);
		if (kc == null)
		{
			throw new NotFoundException();
		}
		return kc;
	}

	@PostMapping("/task")
	public void submitTask(@RequestParam String name, @RequestParam("task") String taskName, @RequestParam int amount,
		@RequestParam int initialAmount, @RequestParam String location)
	{
		Matcher mTask = STRING_VALIDATION.matcher(taskName);
		Matcher mLocation = STRING_VALIDATION.matcher(location);
		if (mTask.find() || taskName.length() > STRING_MAX_LENGTH ||
			mLocation.find() || location.length() > STRING_MAX_LENGTH)
		{
			return;
		}

		Task task = new Task();
		task.setTask(taskName);
		task.setAmount(amount);
		task.setInitialAmount(initialAmount);
		task.setLocation(location);

		chatService.setTask(name, task);
	}

	@GetMapping("/task")
	public Task getTask(@RequestParam String name)
	{
		return chatService.getTask(name);
	}

	@PostMapping("/pb")
	public void submitPb(@RequestParam String name, @RequestParam String boss, @RequestParam int pb)
	{
		if (pb < 0)
		{
			return;
		}

		chatService.setPb(name, boss, pb);
	}

	@GetMapping("/pb")
	public int getPb(@RequestParam String name, @RequestParam String boss)
	{
		Integer pb = chatService.getPb(name, boss);
		if (pb == null)
		{
			throw new NotFoundException();
		}
		return pb;
	}
}
