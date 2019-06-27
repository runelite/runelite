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
import com.google.common.primitives.Longs;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.feed.FeedClient;
import net.runelite.http.api.feed.FeedItemType;
import net.runelite.http.api.feed.FeedResult;

@PluginDescriptor(
	name = "News Feed",
	description = "Show the latest RuneLite blog posts, OSRS news, and JMod Twitter posts",
	tags = {"external", "integration", "panel", "twitter"},
	loadWhenOutdated = true
)
@Slf4j
public class FeedPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private FeedConfig config;

	@Inject
	private ScheduledExecutorService executorService;

	@Inject
	private FeedClient feedClient;

	private FeedPanel feedPanel;
	private NavigationButton navButton;

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
		feedPanel = new FeedPanel(config);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "icon.png");

		navButton = NavigationButton.builder()
			.tooltip("News Feed")
			.icon(icon)
			.priority(8)
			.panel(feedPanel)
			.build();

		clientToolbar.addNavigation(navButton);

		// This gets queued after the NavigationButtonAdded
		// listener procedure that initializes the button.
		SwingUtilities.invokeLater(() ->
		{
			// The button will have been fully added to the
			// frame here so the panel can be safely opened.
			executorService.submit(() -> updateFeed(true));
		});
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientToolbar.removeNavigation(navButton);
	}

	private void updateFeed(boolean openPanelOnChange)
	{
		FeedResult feed = feedSupplier.get();

		if (feed == null)
		{
			return;
		}

		feedPanel.rebuildFeed(feed);

		if (config.includeBlogPosts() && openPanelOnChange)
		{
			feed.getItems()
				.stream()
				.filter(i -> i.getType() == FeedItemType.BLOG_POST)
				// Find the latest blog post
				.max((o1, o2) -> Longs.compare(o1.getTimestamp(), o2.getTimestamp()))
				// Select the blog post only if we haven't seen it before
				.filter(i -> config.lastSeenBlogPostTimestamp().toEpochMilli() < i.getTimestamp())
				.ifPresent(i ->
				{
					if (!navButton.isSelected())
					{
						// If we haven't seen the latest feed item,
						// open the feed panel.
						navButton.getOnSelect().run();
					}

					// Update last seen timestamp
					config.lastSeenBlogPostTimestamp(Instant.ofEpochMilli(i.getTimestamp()));
				});
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("feed"))
		{
			executorService.submit(() -> updateFeed(false));
		}
	}

	@Schedule(
		period = 10,
		unit = ChronoUnit.MINUTES,
		asynchronous = true
	)
	public void updateFeedTask()
	{
		updateFeed(false);
	}

	@Provides
	FeedConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FeedConfig.class);
	}
}
