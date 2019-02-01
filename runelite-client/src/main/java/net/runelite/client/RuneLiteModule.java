/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import java.applet.Applet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.hooks.Callbacks;
import net.runelite.client.account.SessionManager;
import net.runelite.client.callback.Hooks;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.rs.ClientLoader;
import net.runelite.client.rs.ClientUpdateCheckMode;
import net.runelite.client.task.Scheduler;
import net.runelite.client.util.DeferredEventBus;
import net.runelite.client.util.ExecutorServiceExceptionLogger;
import net.runelite.client.util.QueryRunner;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class RuneLiteModule extends AbstractModule
{
	private final ClientUpdateCheckMode updateCheckMode;
	private final boolean developerMode;

	public RuneLiteModule(final ClientUpdateCheckMode updateCheckMode, final boolean developerMode)
	{
		this.updateCheckMode = updateCheckMode;
		this.developerMode = developerMode;
	}

	@Override
	protected void configure()
	{
		bindConstant().annotatedWith(Names.named("updateCheckMode")).to(updateCheckMode);
		bindConstant().annotatedWith(Names.named("developerMode")).to(developerMode);
		bind(ScheduledExecutorService.class).toInstance(new ExecutorServiceExceptionLogger(Executors.newSingleThreadScheduledExecutor()));
		bind(OkHttpClient.class).toInstance(RuneLiteAPI.CLIENT);
		bind(QueryRunner.class);
		bind(MenuManager.class);
		bind(ChatMessageManager.class);
		bind(ItemManager.class);
		bind(Scheduler.class);
		bind(PluginManager.class);
		bind(RuneLiteProperties.class);
		bind(SessionManager.class);

		bind(Callbacks.class).to(Hooks.class);

		bind(EventBus.class)
			.toInstance(new EventBus());

		bind(EventBus.class)
			.annotatedWith(Names.named("Deferred EventBus"))
			.to(DeferredEventBus.class);

		bind(Logger.class)
			.annotatedWith(Names.named("Core Logger"))
			.toInstance(LoggerFactory.getLogger(RuneLite.class));
	}

	@Provides
	@Singleton
	Applet provideApplet(ClientLoader clientLoader)
	{
		return clientLoader.load();
	}

	@Provides
	@Singleton
	Client provideClient(@Nullable Applet applet)
	{
		return applet instanceof Client ? (Client) applet : null;
	}

	@Provides
	@Singleton
	RuneLiteConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RuneLiteConfig.class);
	}

	@Provides
	@Singleton
	ChatColorConfig provideChatColorConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatColorConfig.class);
	}
}
