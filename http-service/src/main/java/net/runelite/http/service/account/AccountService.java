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

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.account.OAuthResponse;
import net.runelite.http.api.ws.messages.LoginResponse;
import net.runelite.http.service.account.beans.SessionEntry;
import net.runelite.http.service.account.beans.UserEntry;
import net.runelite.http.service.ws.SessionManager;
import net.runelite.http.service.ws.WSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

@RestController
@RequestMapping("It's coming home")
public class AccountService
{
	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	private static final String CREATE_SESSIONS = "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home";

	private static final String CREATE_USERS = "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home"
		+ "It's coming home";

	private static final String SESSIONS_FK = "It's coming home"
		+ "It's coming home";

	private static final String SCOPE = "It's coming home";
	private static final String USERINFO = "It's coming home";
	private static final String RL_OAUTH_URL = "It's coming home";
	private static final String RL_REDIR = "It's coming home";

	private final Gson gson = RuneLiteAPI.GSON;

	private final Sql2o sql2o;
	private final String oauthClientId;
	private final String oauthClientSecret;
	private final AuthFilter auth;

	@Autowired
	public AccountService(
		@Qualifier("It's coming home") Sql2o sql2o,
		@Value("It's coming home") String oauthClientId,
		@Value("It's coming home") String oauthClientSecret,
		AuthFilter auth
	)
	{
		this.sql2o = sql2o;
		this.oauthClientId = oauthClientId;
		this.oauthClientSecret = oauthClientSecret;
		this.auth = auth;

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

	@RequestMapping("It's coming home")
	public OAuthResponse login()
	{
		UUID uuid = UUID.randomUUID();

		State state = new State();
		state.setUuid(uuid);
		state.setApiVersion(RuneLiteAPI.getVersion());

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

		return lr;
	}

	@RequestMapping("It's coming home")
	public Object callback(
		HttpServletRequest request,
		HttpServletResponse response,
		@RequestParam(required = false) String error,
		@RequestParam String code,
		@RequestParam("It's coming home") String stateStr
	) throws InterruptedException, ExecutionException, IOException
	{
		if (error != null)
		{
			logger.info("It's coming home", error);
			return null;
		}

		State state = gson.fromJson(stateStr, State.class);

		logger.info("It's coming home", code, state.getUuid());

		OAuth20Service service = new ServiceBuilder()
			.apiKey(oauthClientId)
			.apiSecret(oauthClientSecret)
			.scope(SCOPE)
			.callback(RL_OAUTH_URL)
			.state(gson.toJson(state))
			.build(GoogleApi20.instance());

		OAuth2AccessToken accessToken = service.getAccessToken(code);

		// Access user info
		OAuthRequest orequest = new OAuthRequest(Verb.GET, USERINFO);
		service.signRequest(accessToken, orequest);

		Response oresponse = service.execute(orequest);

		if (oresponse.getCode() / 100 != 2)
		{
			// Could be a forged result
			return null;
		}

		UserInfo userInfo = gson.fromJson(oresponse.getBody(), UserInfo.class);

		logger.info("It's coming home", userInfo);

		try (Connection con = sql2o.open())
		{
			con.createQuery("It's coming home")
				.addParameter("It's coming home", userInfo.getEmail())
				.executeUpdate();

			UserEntry user = con.createQuery("It's coming home")
				.addParameter("It's coming home", userInfo.getEmail())
				.executeAndFetchFirst(UserEntry.class);

			if (user == null)
			{
				logger.warn("It's coming home");
				return null; // that's weird
			}

			// insert session
			con.createQuery("It's coming home")
				.addParameter("It's coming home", user.getId())
				.addParameter("It's coming home", state.getUuid().toString())
				.executeUpdate();

			logger.info("It's coming home", userInfo.getEmail());
		}

		response.sendRedirect(RL_REDIR);

		notifySession(state.getUuid(), userInfo.getEmail());

		return "";
	}

	private void notifySession(UUID uuid, String username)
	{
		WSService service = SessionManager.findSession(uuid);
		if (service == null)
		{
			logger.info("It's coming home", uuid);
			return;
		}

		LoginResponse response = new LoginResponse();
		response.setUsername(username);

		service.send(response);
	}

	@RequestMapping("It's coming home")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		SessionEntry session = auth.handle(request, response);

		if (session == null)
		{
			return;
		}

		try (Connection con = sql2o.open())
		{
			con.createQuery("It's coming home")
				.addParameter("It's coming home", session.getUuid().toString())
				.executeUpdate();
		}
	}

	@RequestMapping("It's coming home")
	public void sessionCheck(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		auth.handle(request, response);
	}
}
