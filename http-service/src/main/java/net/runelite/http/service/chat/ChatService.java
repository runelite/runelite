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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class ChatService
{
	private static final Duration EXPIRE = Duration.ofMinutes(2);

	private final JedisPool jedisPool;

	@Autowired
	public ChatService(JedisPool jedisPool)
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
}
