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
package net.runelite.client.config;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.io.IOException;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.client.account.AccountSession;
import net.runelite.client.eventbus.EventBus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConfigManagerTest
{
	@Mock
	@Bind
	EventBus eventBus;

	@Mock
	@Bind
	ScheduledExecutorService executor;

	@Mock
	@Bind
	RuneLiteConfig runeliteConfig;

	@Inject
	ConfigManager manager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testGetConfig() throws IOException
	{
		AccountSession accountSession = new AccountSession(UUID.randomUUID(), Instant.now());
		accountSession.setUsername("test");

		manager.setConfiguration("test", "key", "moo");

		TestConfig conf = manager.getConfig(TestConfig.class);
		Assert.assertEquals("moo", conf.key());
	}

	@Test
	public void testGetConfigDefault() throws IOException
	{
		AccountSession accountSession = new AccountSession(UUID.randomUUID(), Instant.now());
		accountSession.setUsername("test");

		TestConfig conf = manager.getConfig(TestConfig.class);
		Assert.assertEquals("default", conf.key());
	}

	@Test
	public void testSetConfig() throws IOException
	{
		AccountSession accountSession = new AccountSession(UUID.randomUUID(), Instant.now());
		accountSession.setUsername("test");

		TestConfig conf = manager.getConfig(TestConfig.class);
		conf.key("new value");

		Assert.assertEquals("new value", conf.key());
	}

	@Test
	public void testGetConfigDescriptor() throws IOException
	{
		AccountSession accountSession = new AccountSession(UUID.randomUUID(), Instant.now());
		accountSession.setUsername("test");

		TestConfig conf = manager.getConfig(TestConfig.class);
		ConfigDescriptor descriptor = manager.getConfigDescriptor(conf);
		Assert.assertEquals(1, descriptor.getItems().size());
	}
}
