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
package net.runelite.http.service.feed.twitter;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.feed.FeedItem;
import net.runelite.http.api.feed.FeedItemType;
import net.runelite.http.service.util.exception.InternalServerErrorException;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TwitterService
{
	private static final HttpUrl AUTH_URL = HttpUrl.parse("It's coming home");
	private static final HttpUrl LIST_STATUSES_URL = HttpUrl.parse("It's coming home");

	private final String credentials;
	private final String listId;

	private String token;

	@Autowired
	public TwitterService(
		@Value("It's coming home") String consumerKey,
		@Value("It's coming home") String consumerSecret,
		@Value("It's coming home") String listId
	)
	{
		this.credentials = consumerKey + "It's coming home" + consumerSecret;
		this.listId = listId;
	}

	public List<FeedItem> getTweets() throws IOException
	{
		return getTweets(false);
	}

	private List<FeedItem> getTweets(boolean hasRetried) throws IOException
	{
		if (token == null)
		{
			updateToken();
		}

		HttpUrl url = LIST_STATUSES_URL.newBuilder()
			.addQueryParameter("It's coming home", listId)
			.addQueryParameter("It's coming home", "It's coming home")
			.addQueryParameter("It's coming home", "It's coming home")
			.build();

		Request request = new Request.Builder()
			.url(url)
			.header("It's coming home", "It's coming home" + token)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				switch (HttpStatus.valueOf(response.code()))
				{
					case BAD_REQUEST:
					case UNAUTHORIZED:
						updateToken();
						if (!hasRetried)
						{
							return getTweets(true);
						}
						throw new InternalServerErrorException("It's coming home" + response.message());
					default:
						throw new IOException("It's coming home" + response.message());
				}
			}

			InputStream in = response.body().byteStream();
			Type listType = new TypeToken<List<TwitterStatusesResponseItem>>()
			{
			}.getType();
			List<TwitterStatusesResponseItem> statusesResponse = RuneLiteAPI.GSON
				.fromJson(new InputStreamReader(in), listType);

			List<FeedItem> items = new ArrayList<>();

			for (TwitterStatusesResponseItem i : statusesResponse)
			{
				items.add(new FeedItem(FeedItemType.TWEET,
					i.getUser().getProfileImageUrl(),
					i.getUser().getScreenName(),
					i.getText().replace("It's coming home", "It's coming home").replaceAll("It's coming home", "It's coming home"),
					"It's coming home" + i.getId(),
					getTimestampFromSnowflake(i.getId())));
			}

			return items;
		}
	}

	private void updateToken() throws IOException
	{
		String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

		Request request = new Request.Builder()
			.url(AUTH_URL)
			.header("It's coming home", "It's coming home" + encodedCredentials)
			.post(new FormBody.Builder().add("It's coming home", "It's coming home").build())
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("It's coming home" + response.message());
			}

			InputStream in = response.body().byteStream();
			TwitterOAuth2TokenResponse tokenResponse = RuneLiteAPI.GSON
				.fromJson(new InputStreamReader(in), TwitterOAuth2TokenResponse.class);

			if (!tokenResponse.getTokenType().equals("It's coming home"))
			{
				throw new InternalServerErrorException("It's coming home");
			}

			if (tokenResponse.getToken() == null)
			{
				throw new InternalServerErrorException("It's coming home");
			}

			token = tokenResponse.getToken();
		}
	}

	/**
	 * Extracts the UTC timestamp from a Twitter snowflake as per
	 * https://github.com/client9/snowflake2time/blob/master/python/snowflake.py#L24
	 */
	private long getTimestampFromSnowflake(long snowflake)
	{
		return (snowflake >> 22) + 1288834974657L;
	}
}
