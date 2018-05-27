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
package net.runelite.client.plugins.performance;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import static net.runelite.client.callback.Hooks.log;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.overlay.Overlay;

/**
 * Performance has a few areas, this plugin class just keeps those areas up to date and handles setup / teardown.
 *
 * <p>Overlay paints the current FPS and ping, both are toggled for display.
 * For FPS, the color depends on whether or not FPS is being enforced.
 * For Ping, the color depends on the value, &lt;50 green, &lt;100 yellow, &gt;=100 red.
 * The overlay is lightweight and is merely and indicator, it does not
 *
 * <p>Draw Listener, sleeps a calculated amount after each canvas paint operation.
 * This is the heart of the FPS control, the amount of sleep taken is regularly adjusted to account varying
 * game and system load, it usually finds the sweet spot in about two seconds.
 *
 * <p>Pinging the world, when logged in and ping display is enabled, every 5 seconds the remote server
 * for the current world is pinged. A scheduled method in this class is responsible for that. When ping fails
 * or those conditions are not met, ping will have the value of -1.
 */
@PluginDescriptor(
	name = "Performance",
	enabledByDefault = false
)
public class PerformancePlugin extends Plugin
{
	static final String CONFIG_GROUP_KEY = "performance";

	ScheduledExecutorService scheduledExecutorService;

	@Getter
	private int ping;

	@Inject
	private Client client;

	@Inject
	private PerformanceOverlay overlay;

	@Inject
	private FpsDrawListener drawListener;

	@Inject
	private DrawManager drawManager;

	@Inject
	private PerformanceConfig performanceConfig;

	@Provides
	PerformanceConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PerformanceConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_GROUP_KEY))
		{
			drawListener.reloadConfig();
		}
	}

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		drawListener.onFocusChanged(event);
		overlay.onFocusChanged(event);
	}

	@Override
	protected void startUp() throws Exception
	{
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(this::getPingToCurrentWorld, 5, 5, TimeUnit.SECONDS);
		drawManager.registerEveryFrameListener(drawListener);
		drawListener.reloadConfig();
	}

	@Override
	protected void shutDown() throws Exception
	{
		scheduledExecutorService.shutdown();
		drawManager.unregisterEveryFrameListener(drawListener);
	}

	public void getPingToCurrentWorld()
	{
		if (client.getGameState().equals(GameState.LOGGED_IN) && performanceConfig.drawPing())
		{
			ping = pingWorld(client.getWorld());
		}
		else
		{
			ping = -1;
		}
	}

	int pingWorld(int world)
	{
		InetAddress host;

		try
		{
			// Will update to the below code once hook for host name has been added
			// Host hook will fix issues where the world host name sometimes ends in a or b (oldschool[0-9]{1,3}[ab]?.runescape.com)
			// host = InetAddress.getByName(client.getWorldHostname());
			final String hostDomain = String.format("oldschool%d.runescape.com",  world - 300);
			host = InetAddress.getByName(hostDomain);
		}
		catch (UnknownHostException he)
		{
			log.warn("Cannot ping host", he);
			return -1;
		}

		Instant start = Instant.now();

		// Java cannot use ping (via ICMP), use sockets instead
		try (Socket sock = new Socket(host, 443))
		{
			sock.setSoTimeout(5000);

			if (sock.isConnected())
			{
				return Math.toIntExact(ChronoUnit.MILLIS.between(start, Instant.now()));
			}

			log.warn("Host {} is not reachable", host);
		}
		catch (SocketTimeoutException e)
		{
			log.warn("Host {} timed out", host, e);
			return 5000;
		}
		catch (Exception e)
		{
			log.warn("Could not create new socket", e);
		}

		return -1;
	}
}
