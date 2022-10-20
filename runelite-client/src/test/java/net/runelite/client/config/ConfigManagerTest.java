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
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Named;
import net.runelite.api.Client;
import net.runelite.client.RuneLite;
import net.runelite.client.eventbus.EventBus;
import org.junit.Assert;
import static org.junit.Assert.assertNotNull;
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

	@Bind
	@Named("sessionfile")
	File sessionfile = RuneLite.DEFAULT_SESSION_FILE;

	@Bind
	@Named("config")
	File config = RuneLite.DEFAULT_CONFIG_FILE;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ConfigClient configClient;

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
		manager.setConfiguration("test", "key", "moo");

		TestConfig conf = manager.getConfig(TestConfig.class);
		Assert.assertEquals("moo", conf.key());
	}

	@Test
	public void testGetConfigDefault() throws IOException
	{
		TestConfig conf = manager.getConfig(TestConfig.class);
		Assert.assertEquals("default", conf.key());
	}

	@Test
	public void testSetConfig() throws IOException
	{
		TestConfig conf = manager.getConfig(TestConfig.class);
		conf.key("new value");

		Assert.assertEquals("new value", conf.key());
	}

	@Test
	public void testGetConfigDescriptor() throws IOException
	{
		TestConfig conf = manager.getConfig(TestConfig.class);
		ConfigDescriptor descriptor = manager.getConfigDescriptor(conf);
		Assert.assertEquals(2, descriptor.getItems().size());
	}

	@Test
	public void testResetNullDefaultConfig()
	{
		TestConfig conf = manager.getConfig(TestConfig.class);
		ConfigDescriptor descriptor = manager.getConfigDescriptor(conf);
		conf.nullDefaultKey("new value");

		manager.unsetConfiguration(descriptor.getGroup().value(), "nullDefaultKey");
		manager.setDefaultConfiguration(conf, false);
		Assert.assertNull(conf.nullDefaultKey());
	}

	@Test
	public void testKeySplitter()
	{
		for (String[] test : new String[][]
			{
				{"rsprofile", "rsprofile.123", "rsprofileThing"},
				{"rsprofile", null, "rsprofileThing"},
				{"foo", "rsprofile.123", "big.bad"},
				{"foo", null, "big.bad"},
				{"foo", "rsprofile.123", "456"},
				{"foo", null, "file.256"},
			})
		{
			String whole = ConfigManager.getWholeKey(test[0], test[1], test[2]);
			String[] split = ConfigManager.splitKey(whole);
			assertNotNull(split);
			Assert.assertEquals(split[0], test[0]);
			Assert.assertEquals(split[1], test[1]);
			Assert.assertEquals(split[2], test[2]);
		}
	}
}
