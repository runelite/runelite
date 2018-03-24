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

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;
import net.runelite.http.service.util.InstantConverter;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.sql2o.Sql2o;
import org.sql2o.converters.Converter;
import org.sql2o.quirks.NoQuirks;

@SpringBootApplication
@EnableScheduling
public class SpringBootWebApplicationTest
{
	@Bean("Runelite SQL2O")
	Sql2o sql2o()
	{
		Map<Class, Converter> converters = new HashMap<>();
		converters.put(Instant.class, new InstantConverter());
		return new Sql2o("jdbc:mysql://192.168.1.2/runelite", "runelite", "runelite", new NoQuirks(converters));
	}

	@Bean("Runelite Cache SQL2O")
	Sql2o cacheSql2o() throws NamingException
	{
		Map<Class, Converter> converters = new HashMap<>();
		converters.put(Instant.class, new InstantConverter());
		return new Sql2o("jdbc:mysql://192.168.1.2/cache", "runelite", "runelite", new NoQuirks(converters));
	}

	@Bean("Runelite XP Tracker SQL2O")
	Sql2o xpSql2o() throws NamingException
	{
		Map<Class, Converter> converters = new HashMap<>();
		converters.put(Instant.class, new InstantConverter());
		return new Sql2o("jdbc:mysql://192.168.1.2/xptracker", "runelite", "runelite", new NoQuirks(converters));
	}

	@Test
	@Ignore
	public void test() throws InterruptedException
	{
		SpringApplication.run(SpringBootWebApplicationTest.class, new String[0]);
		for (;;)
		{
			Thread.sleep(100L);
		}
	}
}
