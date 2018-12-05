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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.feed.FeedItem;
import net.runelite.http.api.feed.FeedResult;
import net.runelite.http.service.feed.blog.BlogService;
import net.runelite.http.service.feed.osrsnews.OSRSNewsService;
import net.runelite.http.service.feed.twitter.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed")
@Slf4j
public class FeedController
{
	private final BlogService blogService;
	private final TwitterService twitterService;
	private final OSRSNewsService osrsNewsService;

	private FeedResult feedResult;

	@Autowired
	public FeedController(BlogService blogService, TwitterService twitterService, OSRSNewsService osrsNewsService)
	{
		this.blogService = blogService;
		this.twitterService = twitterService;
		this.osrsNewsService = osrsNewsService;
	}

	@Scheduled(fixedDelay = 10 * 60 * 1000)
	public void updateFeed()
	{
		List<FeedItem> items = new ArrayList<>();

		try
		{
			items.addAll(blogService.getBlogPosts());
		}
		catch (IOException e)
		{
			log.warn(null, e);
		}

		try
		{
			items.addAll(twitterService.getTweets());
		}
		catch (IOException e)
		{
			log.warn(null, e);
		}

		try
		{
			items.addAll(osrsNewsService.getNews());
		}
		catch (IOException e)
		{
			log.warn(null, e);
		}

		feedResult = new FeedResult(items);
	}

	@RequestMapping
	public ResponseEntity<FeedResult> getFeed()
	{
		if (feedResult == null)
		{
			return ResponseEntity.notFound()
				.build();
		}

		return ResponseEntity.ok()
			.cacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES).cachePublic())
			.body(feedResult);
	}
}
