/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.feed;

import com.google.common.base.Suppliers;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.http.api.feed.FeedClient;
import net.runelite.http.api.feed.FeedResult;

@PluginDescriptor(
	name = "News Feed",
	loadWhenOutdated = true
)
@Slf4j
public class FeedPlugin extends Plugin
{
	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private FeedConfig config;

	@Inject
	private ScheduledExecutorService executorService;

	private FeedPanel feedPanel;
	private NavigationButton navButton;

	private FeedClient feedClient = new FeedClient();
	private Supplier<FeedResult> feedSupplier = Suppliers.memoizeWithExpiration(() ->
	{
		try
		{
			return feedClient.lookupFeed();
		}
		catch (IOException e)
		{
			log.warn(null, e);
		}
		return null;
	}, 10, TimeUnit.MINUTES);

	@Override
	protected void startUp() throws Exception
	{
		feedPanel = new FeedPanel(config, feedSupplier);

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("icon.png"));
		}

		navButton = NavigationButton.builder()
			.name("News Feed")
			.icon(icon)
			.panel(feedPanel)
			.build();

		pluginToolbar.addNavigation(navButton);
		executorService.submit(this::updateFeed);
	}

	@Override
	protected void shutDown() throws Exception
	{
		pluginToolbar.removeNavigation(navButton);
	}

	private void updateFeed()
	{
		feedPanel.rebuildFeed();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("feed"))
		{
			executorService.submit(this::updateFeed);
		}
	}

	@Schedule(
		period = 10,
		unit = ChronoUnit.MINUTES,
		asynchronous = true
	)
	public void updateFeedTask()
	{
		updateFeed();
	}

	@Provides
	FeedConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FeedConfig.class);
	}
}
