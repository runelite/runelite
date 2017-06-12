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

import net.runelite.http.service.account.beans.UserEntry;
import net.runelite.http.service.account.beans.SessionEntry;
import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import net.runelite.http.api.RuneliteAPI;
import net.runelite.http.api.account.OAuthResponse;
import net.runelite.http.api.ws.messages.LoginResponse;
import net.runelite.http.service.ws.SessionManager;
import net.runelite.http.service.ws.WSService;
import net.runelite.http.service.ws.WSSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import spark.Request;
import spark.Response;

public class AccountService
{
	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	private static final String CREATE_SESSIONS = "CREATE TABLE IF NOT EXISTS `sessions` (\n"
		+ "  `user` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n"
		+ "  `uuid` varchar(36) NOT NULL,\n"
		+ "  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
		+ "  `last_used` timestamp NOT NULL,\n"
		+ "  UNIQUE KEY `uuid` (`uuid`),\n"
		+ "  KEY `user` (`user`)\n"
		+ ") ENGINE=InnoDB";

	private static final String CREATE_USERS = "CREATE TABLE IF NOT EXISTS `users` (\n"
		+ "  `id` int(11) NOT NULL,\n"
		+ "  `username` tinytext NOT NULL,\n"
		+ "  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
		+ "  PRIMARY KEY (`id`),\n"
		+ "  UNIQUE KEY `username` (`username`(64))\n"
		+ ") ENGINE=InnoDB";

	private static final String SESSIONS_FK = "ALTER TABLE `sessions`\n"
		+ "  ADD CONSTRAINT `id` FOREIGN KEY (`user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;";

	private static final String SCOPE = "https://www.googleapis.com/auth/userinfo.email";
	private static final String USERINFO = "https://www.googleapis.com/oauth2/v2/userinfo";
	private static final String RL_OAUTH_URL = "https://api.runelite.net/oauth/";
	private static final String RL_REDIR = "http://runelite.net/logged-in";

	private final Gson gson = new Gson();

	private final Sql2o sql2o;
	private final String oauthClientId;
	private final String oauthClientSecret;

	@Inject
	public AccountService(
		@Named("Runelite SQL2O") Sql2o sql2o,
		@Named("OAuth Client ID") String oauthClientId,
		@Named("OAuth Client Secret") String oauthClientSecret
	)
	{
		this.sql2o = sql2o;
		this.oauthClientId = oauthClientId;
		this.oauthClientSecret = oauthClientSecret;
	}

	public void init()
	{
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

	public OAuthResponse login(Request request, Response response)
	{
		UUID uuid = UUID.randomUUID();

		State state = new State();
		state.setUuid(uuid);
		state.setApiVersion(RuneliteAPI.getVersion());

		OAuth20Service service = new ServiceBuilder()
			.apiKey(oauthClientId)
			.apiSecret(oauthClientSecret)
			.scope(SCOPE)
			.callback(RL_OAUTH_URL)
			.state(gson.toJson(state))
			.build(GoogleApi20.instance());

		String authorizationUrl = service.getAuthorizationUrl();

		OAuthResponse lr = new OAuthResponse();
		lr.setOauthUrl(authorizationUrl);
		lr.setUid(uuid);

		response.type("application/json");
		return lr;
	}

	public Object callback(Request request, Response response) throws IOException, InterruptedException, ExecutionException
	{
		String error = request.queryParams("error");

		if (error != null)
		{
			logger.info("Error in oauth callback: {}", error);
			return null;
		}

		String authorizationCode = request.queryParams("code");
		State state = gson.fromJson(request.queryParams("state"), State.class);

		logger.info("Got authorization code {} for uuid {}", authorizationCode, state.getUuid());

		OAuth20Service service = new ServiceBuilder()
			.apiKey(oauthClientId)
			.apiSecret(oauthClientSecret)
			.scope(SCOPE)
			.callback(RL_OAUTH_URL)
			.state(gson.toJson(state))
			.build(GoogleApi20.instance());

		OAuth2AccessToken accessToken = service.getAccessToken(authorizationCode);

		// Access user info
		OAuthRequest orequest = new OAuthRequest(Verb.GET, USERINFO);
		service.signRequest(accessToken, orequest);

		com.github.scribejava.core.model.Response oresponse = service.execute(orequest);

		if (oresponse.getCode() / 100 != 2)
		{
			// Could be a forged result
			return null;
		}

		UserInfo userInfo = gson.fromJson(oresponse.getBody(), UserInfo.class);

		logger.info("Got user info: {}", userInfo);

		try (Connection con = sql2o.open())
		{
			con.createQuery("insert ignore into users (username) values (:username)")
				.addParameter("username", userInfo.getEmail())
				.executeUpdate();

			UserEntry user = con.createQuery("select id from users where username = :username")
				.addParameter("username", userInfo.getEmail())
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

			logger.info("Created session for user {}", userInfo.getEmail());
		}

		response.redirect(RL_REDIR);

		notifySession(state.getUuid(), userInfo.getEmail());

		return "";
	}

	private void notifySession(UUID uuid, String username)
	{
		WSSession session = SessionManager.findSession(uuid);
		if (session == null)
		{
			logger.info("Session {} logged in - but no websocket session", uuid);
			return;
		}

		WSService service = session.getServlet();

		LoginResponse response = new LoginResponse();
		response.setUsername(username);

		service.send(response);
	}

	public Object logout(Request request, Response response)
	{
		SessionEntry session = request.session().attribute("session");

		try (Connection con = sql2o.open())
		{
			con.createQuery("delete from sessions where uuid = :uuid")
				.addParameter("uuid", session.getUuid().toString())
				.executeUpdate();
		}

		return "";
	}

	public Object sessionCheck(Request request, Response response)
	{
		// Auth filter would kick this out before here
		return "";
	}
}
