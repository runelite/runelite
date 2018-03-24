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
package net.runelite.http.service.feed;

import com.google.common.base.Suppliers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import net.runelite.http.api.feed.FeedResult;
import net.runelite.http.api.feed.FeedItem;
import net.runelite.http.service.feed.blog.BlogService;
import net.runelite.http.service.feed.osrsnews.OSRSNewsService;
import net.runelite.http.service.feed.twitter.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed")
public class FeedController
{
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

	private BlogService blogService;
	private TwitterService twitterService;
	private OSRSNewsService osrsNewsService;

	private final Supplier<FeedResult> feed = Suppliers.memoizeWithExpiration(() ->
	{
		List<FeedItem> items = new ArrayList<>();

		try
		{
			items.addAll(blogService.getBlogPosts());
		}
		catch (IOException e)
		{
			logger.warn(null, e);
		}

		try
		{
			items.addAll(twitterService.getTweets());
		}
		catch (IOException e)
		{
			logger.warn(null, e);
		}

		try
		{
			items.addAll(osrsNewsService.getNews());
		}
		catch (IOException e)
		{
			logger.warn(null, e);
		}

		return new FeedResult(items);
	}, 10, TimeUnit.MINUTES);

	@Autowired
	public FeedController(BlogService blogService, TwitterService twitterService, OSRSNewsService osrsNewsService)
	{
		this.blogService = blogService;
		this.twitterService = twitterService;
		this.osrsNewsService = osrsNewsService;
	}

	@RequestMapping
	public FeedResult getFeed() throws IOException
	{
		return feed.get();
	}
}
