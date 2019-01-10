/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.service;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.service.util.InstantConverter;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.sql2o.Sql2o;
import org.sql2o.converters.Converter;
import org.sql2o.quirks.NoQuirks;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class SpringBootWebApplication extends SpringBootServletInitializer
{
	@Value("${redis.host:localhost}")
	private String redisHost;

	@Bean
	protected ServletContextListener listener()
	{
		return new ServletContextListener()
		{
			@Override
			public void contextInitialized(ServletContextEvent sce)
			{
				log.info("RuneLite API started");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce)
			{
				// Destroy okhttp client
				OkHttpClient client = RuneLiteAPI.CLIENT;
				client.dispatcher().executorService().shutdown();
				client.connectionPool().evictAll();
				try
				{
					Cache cache = client.cache();
					if (cache != null)
					{
						cache.close();
					}
				}
				catch (IOException ex)
				{
					log.warn(null, ex);
				}

				log.info("RuneLite API stopped");
			}

		};
	}

	private Context getContext() throws NamingException
	{
		Context initCtx = new InitialContext();
		return (Context) initCtx.lookup("java:comp/env");
	}

	@Bean("Runelite SQL2O")
	Sql2o sql2o() throws NamingException
	{
		DataSource dataSource = (DataSource) getContext().lookup("jdbc/runelite");
		Map<Class, Converter> converters = new HashMap<>();
		converters.put(Instant.class, new InstantConverter());
		return new Sql2o(dataSource, new NoQuirks(converters));
	}

	@Bean("Runelite Cache SQL2O")
	Sql2o cacheSql2o() throws NamingException
	{
		DataSource dataSource = (DataSource) getContext().lookup("jdbc/runelite-cache2");
		Map<Class, Converter> converters = new HashMap<>();
		converters.put(Instant.class, new InstantConverter());
		return new Sql2o(dataSource, new NoQuirks(converters));
	}

	@Bean("Runelite XP Tracker SQL2O")
	Sql2o trackerSql2o() throws NamingException
	{
		DataSource dataSource = (DataSource) getContext().lookup("jdbc/runelite-tracker");
		Map<Class, Converter> converters = new HashMap<>();
		converters.put(Instant.class, new InstantConverter());
		return new Sql2o(dataSource, new NoQuirks(converters));
	}

	@Bean
	JedisPool jedis()
	{
		return new JedisPool(new JedisPoolConfig(), redisHost);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
