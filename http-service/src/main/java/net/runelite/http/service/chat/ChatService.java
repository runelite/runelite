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

import com.google.common.collect.ImmutableMap;
import java.time.Duration;
import java.util.Map;
import net.runelite.http.api.chat.Task;
import net.runelite.http.service.util.redis.RedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class ChatService
{
	private static final Duration EXPIRE = Duration.ofMinutes(2);

	private final RedisPool jedisPool;

	@Autowired
	public ChatService(RedisPool jedisPool)
	{
		this.jedisPool = jedisPool;
	}

	public Integer getKc(String name, String boss)
	{
		String value;
		try (Jedis jedis = jedisPool.getResource())
		{
			value = jedis.get("kc." + name + "." + boss);
		}
		return value == null ? null : Integer.parseInt(value);
	}

	public void setKc(String name, String boss, int kc)
	{
		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.setex("kc." + name + "." + boss, (int) EXPIRE.getSeconds(), Integer.toString(kc));
		}
	}

	public Integer getQp(String name)
	{
		String value;
		try (Jedis jedis = jedisPool.getResource())
		{
			value = jedis.get("qp." + name);
		}
		return value == null ? null : Integer.parseInt(value);
	}

	public void setQp(String name, int qp)
	{
		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.setex("qp." + name, (int) EXPIRE.getSeconds(), Integer.toString(qp));
		}
	}

	public Task getTask(String name)
	{
		Map<String, String> map;

		try (Jedis jedis = jedisPool.getResource())
		{
			map = jedis.hgetAll("task." + name);
		}

		if (map.isEmpty())
		{
			return null;
		}

		Task task = new Task();
		task.setTask(map.get("task"));
		task.setAmount(Integer.parseInt(map.get("amount")));
		task.setInitialAmount(Integer.parseInt(map.get("initialAmount")));
		task.setLocation(map.get("location"));
		return task;
	}

	public void setTask(String name, Task task)
	{
		Map<String, String> taskMap = ImmutableMap.<String, String>builderWithExpectedSize(4)
			.put("task", task.getTask())
			.put("amount", Integer.toString(task.getAmount()))
			.put("initialAmount", Integer.toString(task.getInitialAmount()))
			.put("location", task.getLocation())
			.build();

		String key = "task." + name;

		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.hmset(key, taskMap);
			jedis.expire(key, (int) EXPIRE.getSeconds());
		}
	}

	public Integer getPb(String name, String boss)
	{
		String value;
		try (Jedis jedis = jedisPool.getResource())
		{
			value = jedis.get("pb." + boss + "." + name);
		}
		return value == null ? null : Integer.parseInt(value);
	}

	public void setPb(String name, String boss, int pb)
	{
		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.setex("pb." + boss + "." + name, (int) EXPIRE.getSeconds(), Integer.toString(pb));
		}
	}
}
