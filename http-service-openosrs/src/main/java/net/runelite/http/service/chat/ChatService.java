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

import java.time.Duration;
import java.util.List;
import net.runelite.http.api.chat.ChatClient;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.chat.House;
import net.runelite.http.service.util.redis.RedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class ChatService
{
	private static final Duration EXPIRE = Duration.ofMinutes(2);

	private final RedisPool jedisPool;
	private final ChatClient chatClient = new ChatClient();


	@Autowired
	public ChatService(RedisPool jedisPool)
	{
		this.jedisPool = jedisPool;
	}

	public String getLayout(String name)
	{
		String value;
		try (Jedis jedis = jedisPool.getResource())
		{
			value = jedis.get("layout." + name);
		}
		return value;
	}

	public void setLayout(String name, String layout)
	{
		if (!chatClient.testLayout(layout))
		{
			throw new IllegalArgumentException(layout);
		}

		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.setex("layout." + name, (int) EXPIRE.getSeconds(), layout);
		}
	}

	public void addHost(int world, String location, House house)
	{
		String houseJSON = house.toString();

		String key = "hosts.w" + Integer.toString(world) + "." + location;

		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.rpush(key, houseJSON);
		}
	}

	public House[] getHosts(int world, String location)
	{
		List<String> json;
		String key = "hosts.w" + Integer.toString(world) + "." + location;

		try (Jedis jedis = jedisPool.getResource())
		{
			json = jedis.lrange(key, 0, 25);
		}

		if (json.isEmpty())
		{
			return null;
		}

		House[] hosts = new House[json.size()];
		for (int i = 0; i < json.size(); i++)
		{
			hosts[i] = RuneLiteAPI.GSON.fromJson(json.get(i), House.class);
		}
		return hosts;
	}

	public void removeHost(int world, String location, House house)
	{
		String json = house.toString();
		String key = "hosts.w" + Integer.toString(world) + "." + location;

		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.lrem(key, 0, json);
		}
	}
}