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

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.runelite.http.api.chat.Duels;
import net.runelite.http.api.chat.LayoutRoom;
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

	public Double getPb(String name, String boss)
	{
		String value;
		try (Jedis jedis = jedisPool.getResource())
		{
			value = jedis.get("pb." + boss + "." + name);
		}
		return value == null ? null : Double.parseDouble(value);
	}

	public void setPb(String name, String boss, double pb)
	{
		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.setex("pb." + boss + "." + name, (int) EXPIRE.getSeconds(), Double.toString(pb));
		}
	}

	public Integer getGc(String name)
	{
		String value;
		try (Jedis jedis = jedisPool.getResource())
		{
			value = jedis.get("gc." + name);
		}
		return value == null ? null : Integer.parseInt(value);
	}

	public void setGc(String name, int gc)
	{
		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.setex("gc." + name, (int) EXPIRE.getSeconds(), Integer.toString(gc));
		}
	}

	public Duels getDuels(String name)
	{
		Map<String, String> map;

		try (Jedis jedis = jedisPool.getResource())
		{
			map = jedis.hgetAll("duels." + name);
		}

		if (map.isEmpty())
		{
			return null;
		}

		Duels duels = new Duels();
		duels.setWins(Integer.parseInt(map.get("wins")));
		duels.setLosses(Integer.parseInt(map.get("losses")));
		duels.setWinningStreak(Integer.parseInt(map.get("winningStreak")));
		duels.setLosingStreak(Integer.parseInt(map.get("losingStreak")));
		return duels;
	}

	public void setDuels(String name, Duels duels)
	{
		Map<String, String> duelsMap = ImmutableMap.<String, String>builderWithExpectedSize(4)
			.put("wins", Integer.toString(duels.getWins()))
			.put("losses", Integer.toString(duels.getLosses()))
			.put("winningStreak", Integer.toString(duels.getWinningStreak()))
			.put("losingStreak", Integer.toString(duels.getLosingStreak()))
			.build();

		String key = "duels." + name;

		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.hmset(key, duelsMap);
			jedis.expire(key, (int) EXPIRE.getSeconds());
		}
	}

	public LayoutRoom[] getLayout(String name)
	{
		String layout;
		try (Jedis jedis = jedisPool.getResource())
		{
			layout = jedis.get("layout." + name);
		}

		if (layout == null)
		{
			return null;
		}

		List<String> roomList = Splitter.on(' ').splitToList(layout);
		return roomList.stream()
			.map(LayoutRoom::valueOf)
			.toArray(LayoutRoom[]::new);
	}

	public void setLayout(String name, LayoutRoom[] rooms)
	{
		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.setex("layout." + name, (int) EXPIRE.getSeconds(), Joiner.on(' ').join(rooms));
		}
	}

	public int[] getPetList(String name)
	{
		Set<String> pets;
		try (Jedis jedis = jedisPool.getResource())
		{
			pets = jedis.smembers("pets." + name);
		}

		if (pets.isEmpty())
		{
			return null;
		}

		return pets.stream()
			.mapToInt(Integer::parseInt)
			.toArray();
	}

	public void setPetList(String name, int[] petList)
	{
		String[] pets = Arrays.stream(petList).mapToObj(Integer::toString).toArray(String[]::new);
		String key = "pets." + name;
		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.sadd(key, pets);
			jedis.expire(key, (int) EXPIRE.getSeconds());
		}
	}
}
