/*
 * Copyright (c) 2020, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.pluginhub;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import javax.servlet.http.HttpServletRequest;
import net.runelite.http.service.util.redis.RedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/pluginhub")
public class PluginHubController
{
	@Value("${pluginhub.stats.days:7}")
	private int days;

	@Value("${pluginhub.stats.expire:90}")
	private int expireDays;

	@Autowired
	private RedisPool redisPool;

	private final Cache<String, String> pluginCache = CacheBuilder.newBuilder()
		.maximumSize(512L)
		.build();

	private Map<String, Long> pluginCounts = Collections.emptyMap();

	@GetMapping
	public ResponseEntity<Map<String, Long>> get()
	{
		if (pluginCounts.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.cacheControl(CacheControl.noCache())
				.build();
		}

		return ResponseEntity.ok()
			.cacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES).cachePublic())
			.body(pluginCounts);
	}

	@PostMapping
	public void submit(HttpServletRequest request, @RequestBody String[] plugins)
	{
		final String date = Instant.now().atZone(ZoneOffset.UTC).format(DateTimeFormatter.ISO_LOCAL_DATE);
		final String ip = request.getHeader("X-Forwarded-For");
		try (Jedis jedis = redisPool.getResource())
		{
			for (String plugin : plugins)
			{
				if (!plugin.matches("[a-z0-9-]+"))
				{
					continue;
				}

				jedis.pfadd("pluginhub." + plugin + "." + date, ip);

				if (pluginCache.getIfPresent(plugin) == null)
				{
					jedis.sadd("pluginhub.plugins", plugin);
					// additionally set the ttl on the hyperloglog since it might be a new key
					jedis.expire("pluginhub." + plugin + "." + date, (int) (Duration.ofDays(expireDays).toMillis() / 1000L));

					pluginCache.put(plugin, plugin);
				}
			}
		}
	}

	@Scheduled(fixedDelay = 1_800_000, initialDelay = 30_000) // 30 minutes with 30 second initial delay
	public void rebuildCounts()
	{
		Map<String, Long> counts = new HashMap<>();
		try (Jedis jedis = redisPool.getResource())
		{
			Set<String> plugins = jedis.smembers("pluginhub.plugins");
			ZonedDateTime time = Instant.now().atZone(ZoneOffset.UTC);

			for (String plugin : plugins)
			{
				// When called with multiple keys, pfcount returns the approximated
				// cardinality of the union of the HyperLogLogs. We use this to determine
				// the number of users in the last N days.
				String[] keys = IntStream.range(0, days - 1)
					.mapToObj(time::minusDays)
					.map(zdt -> "pluginhub." + plugin + "." + zdt.format(DateTimeFormatter.ISO_LOCAL_DATE))
					.toArray(String[]::new);
				long cnt = jedis.pfcount(keys);
				if (cnt > 0)
				{
					counts.put(plugin, cnt);
				}
			}
		}
		pluginCounts = counts;
	}
}
