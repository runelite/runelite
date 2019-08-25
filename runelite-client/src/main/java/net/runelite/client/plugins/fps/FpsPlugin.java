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
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.overlay.OverlayManager;

/**
 * FPS Control has two primary areas, this plugin class just keeps those areas up to date and handles setup / teardown.
 *
 * <p>Overlay paints the current FPS, the color depends on whether or not FPS is being enforced.
 * The overlay is lightweight and is merely and indicator.
 *
 * <p>Draw Listener, sleeps a calculated amount after each canvas paint operation.
 * This is the heart of the plugin, the amount of sleep taken is regularly adjusted to account varying
 * game and system load, it usually finds the sweet spot in about two seconds.
 */
@PluginDescriptor(
	name = "Performance",
	description = "Show current FPS or set an FPS limit",
	tags = {"frames", "framerate", "limit", "overlay"},
	enabledByDefault = false
)
@Singleton
public class FpsPlugin extends Plugin
{
	static final String CONFIG_GROUP_KEY = "fpscontrol";

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private FpsOverlay overlay;

	@Inject
	private FpsDrawListener drawListener;

	@Inject
	private DrawManager drawManager;

	@Inject
	private FpsConfig fpsConfig;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private FpsLimitMode limitMode;

	@Getter(AccessLevel.PACKAGE)
	private boolean drawFps;

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
		}
	}

	private void onFocusChanged(FocusChanged event)
	{
		drawListener.onFocusChanged(event);
		overlay.onFocusChanged(event);
	}

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		limitMode = fpsConfig.limitMode();
		drawFps = fpsConfig.drawFps();
		overlayManager.add(overlay);
		drawManager.registerEveryFrameListener(drawListener);
		drawListener.reloadConfig();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		drawManager.unregisterEveryFrameListener(drawListener);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(FocusChanged.class, this, this::onFocusChanged);
	}
}
