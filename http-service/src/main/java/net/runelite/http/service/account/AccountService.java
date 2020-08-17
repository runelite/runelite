/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.account;

import com.github.scribejava.apis.DiscordApi;
import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.account.OAuthResponse;
import net.runelite.http.api.account.OAuthProvider;
import net.runelite.http.api.ws.WebsocketGsonFactory;
import net.runelite.http.api.ws.WebsocketMessage;
import net.runelite.http.api.ws.messages.LoginResponse;
import net.runelite.http.service.account.beans.SessionEntry;
import net.runelite.http.service.account.beans.UserEntry;
import net.runelite.http.service.util.redis.RedisPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/account")
public class AccountService
{
	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	private static final String CREATE_SESSIONS = "CREATE TABLE IF NOT EXISTS `sessions` (\n"
		+ "  `user` int(11) NOT NULL PRIMARY KEY,\n"
		+ "  `uuid` varchar(36) NOT NULL,\n"
		+ "  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
		+ "  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
		+ "  UNIQUE KEY `uuid` (`uuid`),\n"
		+ "  KEY `user` (`user`)\n"
		+ ") ENGINE=InnoDB";

	private static final String CREATE_USERS = "CREATE TABLE IF NOT EXISTS `users` (\n"
		+ "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
		+ "  `username` tinytext NOT NULL,\n"
		+ "  `oauth_provider` ENUM('GOOGLE', 'DISCORD') NOT NULL,\n"
		+ "  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
		+ "  PRIMARY KEY (`id`),\n"
		+ "  UNIQUE KEY `username` (`username`, `oauth_provider`)\n"
		+ ") ENGINE=InnoDB";

	private static final String SESSIONS_FK = "ALTER TABLE `sessions`\n"
		+ "  ADD CONSTRAINT `id` FOREIGN KEY (`user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;";

	private final Gson gson = RuneLiteAPI.GSON;
	private final Gson websocketGson = WebsocketGsonFactory.build();

	private final Sql2o sql2o;
	private final String googleOauthClientId;
	private final String googleOauthClientSecret;
	private final String discordOauthClientId;
	private final String discordOauthClientSecret;
	private final String oauthCallback;
	private final String rlRedirect;
	private final AuthFilter auth;
	private final RedisPool jedisPool;

	@Autowired
	public AccountService(
		@Qualifier("Runelite SQL2O") Sql2o sql2o,
		@Value("${oauth.google-client-id}") String googleOauthClientId,
		@Value("${oauth.google-client-secret}") String googleOauthClientSecret,
		@Value("${oauth.discord-client-id}") String discordOauthClientId,
		@Value("${oauth.discord-client-secret}") String discordOauthClientSecret,
		@Value("${oauth.callback}") String oauthCallback,
		@Value("${oauth.redirect}") String rlRedirect,
		AuthFilter auth,
		RedisPool jedisPool
	)
	{
		this.sql2o = sql2o;
		this.googleOauthClientId = googleOauthClientId;
		this.googleOauthClientSecret = googleOauthClientSecret;
		this.discordOauthClientId = discordOauthClientId;
		this.discordOauthClientSecret = discordOauthClientSecret;
		this.oauthCallback = oauthCallback;
		this.rlRedirect = rlRedirect;
		this.auth = auth;
		this.jedisPool = jedisPool;

		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_SESSIONS)
				.executeUpdate();

			con.createQuery(CREATE_USERS)
				.executeUpdate();

			try
			{
				con.createQuery(SESSIONS_FK)
					.executeUpdate();
			}
			catch (Sql2oException ex)
			{
				// Ignore, happens when index already exists
			}
		}
	}

	@GetMapping("/login")
	public OAuthResponse login(
		@RequestParam UUID uuid,
		@RequestParam OAuthProvider provider
	)
	{
		State state = new State();
		state.setUuid(uuid);
		state.setApiVersion(RuneLiteAPI.getVersion());
		state.setProvider(provider);

		OAuth20Service service = generateService(state.getProvider());

		if (service == null)
		{
			logger.info("Unknown oauth provider: {}", state.getProvider());
			return null;
		}

		final Map<String, String> additionalParams = new HashMap<>();
		additionalParams.put("prompt", "select_account");
		additionalParams.put("state", gson.toJson(state));

		String authorizationUrl = service.getAuthorizationUrl(additionalParams);

		OAuthResponse lr = new OAuthResponse();
		lr.setOauthUrl(authorizationUrl);
		lr.setUid(uuid);

		return lr;
	}

	@GetMapping("/callback")
	public Object callback(
		HttpServletRequest request,
		HttpServletResponse response,
		@RequestParam(required = false) String error,
		@RequestParam String code,
		@RequestParam("state") String stateStr
	) throws InterruptedException, ExecutionException, IOException
	{
		if (error != null)
		{
			logger.info("Error in oauth callback: {}", error);
			return null;
		}

		State state = gson.fromJson(stateStr, State.class);

		logger.info("Got authorization code {} for uuid {}", code, state.getUuid());

		OAuth20Service service = generateService(state.getProvider());

		if (service == null)
		{
			logger.info("Unknown oauth provider: {}", state.getProvider());
			return null;
		}

		OAuth2AccessToken accessToken = service.getAccessToken(code);

		// Access user info
		OAuthRequest orequest = new OAuthRequest(Verb.GET, state.getProvider().getUserinfo());
		service.signRequest(accessToken, orequest);

		Response oresponse = service.execute(orequest);

		if (oresponse.getCode() / 100 != 2)
		{
			// Could be a forged result
			return null;
		}

		Map userInfo = gson.fromJson(oresponse.getBody(), Map.class);

		String username = (String) userInfo.get(state.getProvider().getUsernameKey());

		StringBuilder displayBuilder = new StringBuilder();

		for (String s : state.getProvider().getDisplayKey())
		{
			if (s.startsWith("\\"))
			{
				displayBuilder.append(s.substring(1));
			}
			else
			{
				displayBuilder.append((String) userInfo.get(s));
			}
		}

		String display = displayBuilder.toString();

		logger.info("Got user info: {}", oresponse.getBody());

		try (Connection con = sql2o.open())
		{
			con.createQuery("insert ignore into users (username, oauth_provider) values (:username, :oauth_provider)")
				.addParameter("username", username)
				.addParameter("oauth_provider", state.getProvider())
				.executeUpdate();


			UserEntry user = con.createQuery("select id from users where username = :username and oauth_provider = :oauth_provider")
				.addParameter("username", username)
				.addParameter("oauth_provider", state.getProvider())
				.executeAndFetchFirst(UserEntry.class);

			if (user == null)
			{
				logger.warn("Unable to find newly created user session");
				return null; // that's weird
			}

			// insert session
			con.createQuery("insert ignore into sessions (user, uuid) values (:user, :uuid)")
				.addParameter("user", user.getId())
				.addParameter("uuid", state.getUuid().toString())
				.executeUpdate();

			logger.info("Created session for user {}", username);
		}

		response.sendRedirect(rlRedirect);

		notifySession(state.getUuid(), username, display, state.getProvider());

		return "";
	}

	private void notifySession(UUID uuid, String username, String display, OAuthProvider provider)
	{
		LoginResponse response = new LoginResponse();
		response.setUsername(username);
		response.setProvider(provider);
		response.setDisplay(display);

		try (Jedis jedis = jedisPool.getResource())
		{
			jedis.publish("session." + uuid, websocketGson.toJson(response, WebsocketMessage.class));
		}
	}

	@GetMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		SessionEntry session = auth.handle(request, response);

		if (session == null)
		{
			return;
		}

		auth.invalidate(session.getUuid());

		try (Connection con = sql2o.open())
		{
			con.createQuery("delete from sessions where uuid = :uuid")
				.addParameter("uuid", session.getUuid().toString())
				.executeUpdate();
		}
	}

	@GetMapping("/session-check")
	public void sessionCheck(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		auth.handle(request, response);
	}

	private OAuth20Service generateService(OAuthProvider provider)
	{
		String clientId;
		String clientSecret;
		DefaultApi20 api20;

		switch (provider)
		{
			case GOOGLE:
				clientId = googleOauthClientId;
				clientSecret = googleOauthClientSecret;
				api20 = GoogleApi20.instance();
				break;
			case DISCORD:
				clientId = discordOauthClientId;
				clientSecret = discordOauthClientSecret;
				api20 = DiscordApi.instance();
				break;
			default:
				return null;
		}

		return new ServiceBuilder(clientId)
			.apiSecret(clientSecret)
			.defaultScope(provider.getScope())
			.callback(oauthCallback)
			.userAgent(RuneLiteAPI.userAgent)
			.build(api20);
	}
}
