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
public class TwitterService
{
	private static final HttpUrl AUTH_URL = HttpUrl.parse("https://api.twitter.com/oauth2/token");
	private static final HttpUrl LIST_STATUSES_URL = HttpUrl.parse("https://api.twitter.com/1.1/lists/statuses.json");

	private final String credentials;
	private final String listId;

	private String token;

	@Autowired
	public TwitterService(
		@Value("${runelite.twitter.consumerkey}") String consumerKey,
		@Value("${runelite.twitter.secretkey}") String consumerSecret,
		@Value("${runelite.twitter.listid}") String listId
	)
	{
		this.credentials = consumerKey + ":" + consumerSecret;
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
			.addQueryParameter("list_id", listId)
			.addQueryParameter("count", "15")
			.addQueryParameter("include_entities", "false")
			.build();

		Request request = new Request.Builder()
			.url(url)
			.header("Authorization", "Bearer " + token)
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
						throw new InternalServerErrorException("Could not auth to Twitter after trying once: " + response.message());
					default:
						throw new IOException("Error getting Twitter list: " + response.message());
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
					i.getText().replace("\n\n", " ").replaceAll("\n", " "),
					"https://twitter.com/" + i.getUser().getScreenName() + "/status/" + i.getId(),
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
			.header("Authorization", "Basic " + encodedCredentials)
			.post(new FormBody.Builder().add("grant_type", "client_credentials").build())
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Error authing to Twitter: " + response.message());
			}

			InputStream in = response.body().byteStream();
			TwitterOAuth2TokenResponse tokenResponse = RuneLiteAPI.GSON
				.fromJson(new InputStreamReader(in), TwitterOAuth2TokenResponse.class);

			if (!tokenResponse.getTokenType().equals("bearer"))
			{
				throw new InternalServerErrorException("Returned token was not a bearer token");
			}

			if (tokenResponse.getToken() == null)
			{
				throw new InternalServerErrorException("Returned token was null");
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
