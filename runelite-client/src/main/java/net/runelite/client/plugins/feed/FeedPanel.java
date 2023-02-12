/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.SwingUtil;
import net.runelite.http.api.feed.FeedItem;
import net.runelite.http.api.feed.FeedItemType;
import net.runelite.http.api.feed.FeedResult;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Slf4j
@Singleton
class FeedPanel extends PluginPanel
{
	private static final ImageIcon RUNELITE_ICON;
	private static final ImageIcon OSRS_ICON;

	private static final Color TWEET_BACKGROUND = new Color(15, 15, 15);
	private static final Color OSRS_NEWS_BACKGROUND = new Color(36, 30, 19);
	private static final Color BLOG_POST_BACKGROUND = new Color(11, 30, 41);

	private static final int MAX_CONTENT_LINES = 3;
	private static final int CONTENT_WIDTH = 148;
	private static final int TIME_WIDTH = 20;

	private static final Duration UPDATE_INTERVAL = Duration.ofMinutes(10);

	private static final Comparator<FeedItem> FEED_ITEM_COMPARATOR = (o1, o2) ->
	{
		if (o1.getType() != o2.getType())
		{
			if (o1.getType() == FeedItemType.BLOG_POST)
			{
				return -1;
			}
			else if (o2.getType() == FeedItemType.BLOG_POST)
			{
				return 1;
			}
		}

		return -Long.compare(o1.getTimestamp(), o2.getTimestamp());
	};

	static
	{
		RUNELITE_ICON = new ImageIcon(ImageUtil.loadImageResource(FeedPanel.class, "runelite.png"));
		OSRS_ICON = new ImageIcon(ImageUtil.loadImageResource(FeedPanel.class, "osrs.png"));
	}

	private final FeedConfig config;
	private final FeedClient feedClient;
	private final OkHttpClient okHttpClient;
	private final ScheduledExecutorService executor;

	private boolean isActive;
	private ScheduledFuture<?> feedResultFuture;
	private FeedResult feedResult;
	private Instant nextUpdate = Instant.EPOCH;

	@Inject
	FeedPanel(FeedConfig config, FeedClient feedClient, OkHttpClient okHttpClient, ScheduledExecutorService executor)
	{
		super(true);
		this.config = config;
		this.feedClient = feedClient;
		this.okHttpClient = okHttpClient;
		this.executor = executor;

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new GridLayout(0, 1, 0, 4));
	}

	@Override
	public void onActivate()
	{
		isActive = true;
		refresh();
		rebuild();
	}

	@Override
	public void onDeactivate()
	{
		isActive = false;
		stop();

		SwingUtil.fastRemoveAll(this);
	}

	synchronized void stop()
	{
		feedResultFuture.cancel(false);
		feedResultFuture = null;
	}

	private synchronized void refresh()
	{
		if (feedResultFuture != null)
		{
			return;
		}

		long msUntilUpdate = 0;
		if (feedResult != null)
		{
			msUntilUpdate = Math.max(0, Instant.now().until(nextUpdate, ChronoUnit.MILLIS));
		}

		feedResultFuture = executor.scheduleAtFixedRate(() ->
		{
			nextUpdate = Instant.now().plus(UPDATE_INTERVAL);

			try
			{
				feedResult = feedClient.lookupFeed();
			}
			catch (IOException e)
			{
				log.warn("fetching feed", e);
				return;
			}

			rebuild();
		}, msUntilUpdate, UPDATE_INTERVAL.toMillis(), TimeUnit.MILLISECONDS);
	}

	void rebuild()
	{
		if (!isActive)
		{
			return;
		}

		SwingUtilities.invokeLater(() ->
		{
			if (!isActive)
			{
				return;
			}

			SwingUtil.fastRemoveAll(this);

			FeedResult feed = feedResult;
			if (feed == null)
			{
				JLabel loading = new JLabel("Loading ...");
				loading.setHorizontalAlignment(JLabel.CENTER);
				add(loading);
				return;
			}

			feed.getItems()
				.stream()
				.filter(f -> f.getType() != FeedItemType.BLOG_POST || config.includeBlogPosts())
				.filter(f -> f.getType() != FeedItemType.TWEET || config.includeTweets())
				.filter(f -> f.getType() != FeedItemType.OSRS_NEWS || config.includeOsrsNews())
				.sorted(FEED_ITEM_COMPARATOR)
				.forEach(this::addItemToPanel);
		});
	}

	private void addItemToPanel(FeedItem item)
	{
		JPanel avatarAndRight = new JPanel(new BorderLayout());
		avatarAndRight.setPreferredSize(new Dimension(0, 56));

		JLabel avatar = new JLabel();
		// width = 48+4 to compensate for the border
		avatar.setPreferredSize(new Dimension(52, 48));
		avatar.setBorder(new EmptyBorder(0, 4, 0, 0));

		switch (item.getType())
		{
			case TWEET:
				try
				{
					Request request = new Request.Builder()
						.url(item.getAvatar())
						.build();

					okHttpClient.newCall(request).enqueue(new Callback()
					{
						@Override
						public void onFailure(Call call, IOException e)
						{
							log.warn(null, e);
						}

						@Override
						public void onResponse(Call call, Response response) throws IOException
						{
							try (ResponseBody responseBody = response.body())
							{
								if (!response.isSuccessful())
								{
									log.warn("Failed to download image " + item.getAvatar());
									return;
								}

								BufferedImage icon;
								synchronized (ImageIO.class)
								{
									icon = ImageIO.read(responseBody.byteStream());
								}
								avatar.setIcon(new ImageIcon(icon));
							}
						}
					});
				}
				catch (IllegalArgumentException | NullPointerException e)
				{
					log.warn(null, e);
				}
				avatarAndRight.setBackground(TWEET_BACKGROUND);
				break;
			case OSRS_NEWS:
				if (OSRS_ICON != null)
				{
					avatar.setIcon(OSRS_ICON);
				}
				avatarAndRight.setBackground(OSRS_NEWS_BACKGROUND);
				break;
			default:
				if (RUNELITE_ICON != null)
				{
					avatar.setIcon(RUNELITE_ICON);
				}
				avatarAndRight.setBackground(BLOG_POST_BACKGROUND);
				break;
		}

		JPanel upAndContent = new JPanel();
		upAndContent.setLayout(new BoxLayout(upAndContent, BoxLayout.Y_AXIS));
		upAndContent.setBorder(new EmptyBorder(4, 8, 4, 4));
		upAndContent.setBackground(null);

		JPanel titleAndTime = new JPanel();
		titleAndTime.setLayout(new BorderLayout());
		titleAndTime.setBackground(null);

		Color darkerForeground = UIManager.getColor("Label.foreground").darker();

		JLabel titleLabel = new JLabel(item.getTitle());
		titleLabel.setFont(FontManager.getRunescapeSmallFont());
		titleLabel.setBackground(null);
		titleLabel.setForeground(darkerForeground);
		titleLabel.setPreferredSize(new Dimension(CONTENT_WIDTH - TIME_WIDTH, 0));

		Duration duration = Duration.between(Instant.ofEpochMilli(item.getTimestamp()), Instant.now());
		JLabel timeLabel = new JLabel(durationToString(duration));
		timeLabel.setFont(FontManager.getRunescapeSmallFont());
		timeLabel.setForeground(darkerForeground);

		titleAndTime.add(titleLabel, BorderLayout.WEST);
		titleAndTime.add(timeLabel, BorderLayout.EAST);

		JPanel content = new JPanel(new BorderLayout());
		content.setBackground(null);

		JLabel contentLabel = new JLabel();
		contentLabel.setBorder(new EmptyBorder(2, 0, 0, 0));
		contentLabel.setFont(FontManager.getRunescapeSmallFont());
		contentLabel.setForeground(darkerForeground);

		content.add(contentLabel, BorderLayout.CENTER);

		upAndContent.add(titleAndTime);
		upAndContent.add(content);
		upAndContent.add(new Box.Filler(new Dimension(0, 0),
			new Dimension(0, Short.MAX_VALUE),
			new Dimension(0, Short.MAX_VALUE)));

		avatarAndRight.add(avatar, BorderLayout.WEST);
		avatarAndRight.add(upAndContent, BorderLayout.CENTER);

		Color backgroundColor = avatarAndRight.getBackground();
		Color hoverColor = backgroundColor.brighter().brighter();
		Color pressedColor = hoverColor.brighter();

		avatarAndRight.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				avatarAndRight.setBackground(hoverColor);
				avatarAndRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				avatarAndRight.setBackground(backgroundColor);
				avatarAndRight.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				avatarAndRight.setBackground(pressedColor);
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				avatarAndRight.setBackground(hoverColor);
				LinkBrowser.browse(item.getUrl());
			}
		});

		add(avatarAndRight);

		// set the text last, as some text is very expensive to layout, and it will
		// re-layout for every relevant property change
		contentLabel.setText(lineBreakText(item.getContent(), contentLabel.getFont()));
	}

	private String durationToString(Duration duration)
	{
		if (duration.getSeconds() >= 60 * 60 * 24)
		{
			return (int) (duration.getSeconds() / (60 * 60 * 24)) + "d";
		}
		else if (duration.getSeconds() >= 60 * 60)
		{
			return (int) (duration.getSeconds() / (60 * 60)) + "h";
		}
		return (int) (duration.getSeconds() / 60) + "m";
	}

	private String lineBreakText(String text, Font font)
	{
		StringBuilder newText = new StringBuilder("<html>");

		FontRenderContext fontRenderContext = new FontRenderContext(font.getTransform(),
			true, true);

		int lines = 0;
		int pos = 0;
		String[] words = text.split(" ");
		String line = "";

		while (lines < MAX_CONTENT_LINES && pos < words.length)
		{
			String newLine = pos > 0 ? line + " " + words[pos] : words[pos];
			double width = font.getStringBounds(newLine, fontRenderContext).getWidth();

			if (width >= CONTENT_WIDTH)
			{
				newText.append(line);
				newText.append("<br>");
				line = "";
				lines++;
			}
			else
			{
				line = newLine;
				pos++;
			}
		}

		newText.append(line);
		newText.append("</html>");

		return newText.toString();
	}
}
