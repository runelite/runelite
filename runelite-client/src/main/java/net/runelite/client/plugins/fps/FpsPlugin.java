/*
 * Copyright (c) 2017, Levi <me@levischuck.com>
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
package net.runelite.client.plugins.fps;

import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ExecutorServiceExceptionLogger;
import net.runelite.client.util.ping.Ping;

/**
 * Performance has two primary areas, this plugin class just keeps those areas up to date and handles setup / teardown.
 *
 * <p>Overlay paints the current FPS, the color depends on whether or not FPS is being enforced.
 * The overlay is lightweight and is merely and indicator.
 *
 * <p>Draw Listener, sleeps a calculated amount after each canvas paint operation.
 * This is the heart of the plugin, the amount of sleep taken is regularly adjusted to account varying
 * game and system load, it usually finds the sweet spot in about two seconds.
 *
 * <p>Pinging the world, when logged in and ping display is enabled, every 5 seconds the remote server
 * for the current world is pinged. A scheduled method in this class is responsible for that. When ping fails
 * or those conditions are not met, ping will have the value of -1.
 */
@PluginDescriptor(
	name = "Performance",
	description = "Show current Ping and FPS or set an FPS limit",
	tags = {"frames", "framerate", "limit", "overlay", "ping"},
	enabledByDefault = false
)
@Singleton
public class FpsPlugin extends Plugin
{
	static final String CONFIG_GROUP_KEY = "fpscontrol";

	@Getter
	private int ping;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private FpsOverlay overlay;

	@Inject
	private FpsDrawListener drawListener;

	@Inject
	private DrawManager drawManager;

	@Inject
	private Client client;

	@Inject
	private FpsConfig fpsConfig;

	@Inject
	private EventBus eventBus;

	private final ScheduledExecutorService pingExecutorService = new ExecutorServiceExceptionLogger(Executors.newSingleThreadScheduledExecutor());

	private boolean loaded = false;

	private boolean shutdown;

	@Getter(AccessLevel.PACKAGE)
	private FpsLimitMode limitMode;

	@Getter(AccessLevel.PACKAGE)
	private boolean drawFps;

	@Getter(AccessLevel.PACKAGE)
	private boolean drawPing;

	@Provides
	FpsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FpsConfig.class);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_GROUP_KEY))
		{
			drawListener.reloadConfig();

			limitMode = fpsConfig.limitMode();
			drawFps = fpsConfig.drawFps();
			drawPing = fpsConfig.drawPing();
		}
	}

	private void onFocusChanged(FocusChanged event)
	{
		drawListener.onFocusChanged(event);
		overlay.onFocusChanged(event);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		shutdown = event.getGameState() != GameState.LOGGED_IN;
	}

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		limitMode = fpsConfig.limitMode();
		drawFps = fpsConfig.drawFps();
		drawPing = fpsConfig.drawPing();
		overlayManager.add(overlay);
		drawManager.registerEveryFrameListener(drawListener);
		drawListener.reloadConfig();
		shutdown = client.getGameState() != GameState.LOGGED_IN;

		if (!loaded)
		{
			pingExecutorService.scheduleAtFixedRate(this::getPingToCurrentWorld, 5, 5, TimeUnit.SECONDS);
			loaded = true;
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		drawManager.unregisterEveryFrameListener(drawListener);
		shutdown = true;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(FocusChanged.class, this, this::onFocusChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
	}

	private void getPingToCurrentWorld()
	{
		if (!shutdown && drawPing)
		{
			ping = Ping.ping(String.format("oldschool%d.runescape.com", client.getWorld() - 300));
		}
		else
		{
			ping = -1;
		}
	}
}
