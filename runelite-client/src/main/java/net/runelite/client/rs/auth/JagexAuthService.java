/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
 * Copyright (c) 2026, LlemonDuck <napkinorton@gmail.com>
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
package net.runelite.client.rs.auth;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.util.OSType;

@Slf4j
@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class JagexAuthService
{
	private final Client client;
	private final ClientThread clientThread;
	private final JagexAuthClient authClient;
	private final SessionStore sessionStore;
	private final Gson gson;
	private final ScheduledExecutorService executor;

	private final List<Session> sessions = new ArrayList<>();
	private final Map<String, Account[]> accounts = new HashMap<>();

	public CompletableFuture<Void> loadFromStore()
	{
		return CompletableFuture.runAsync(
			() ->
			{
				try
				{
					List<Session> sessions = sessionStore.load();
					synchronized (this)
					{
						this.sessions.clear();
						this.accounts.clear();
						for (Session session : sessions)
						{
							loadSession(session);
						}
					}
				}
				catch (Exception e)
				{
					log.error("Unable to load saved Jagex accounts", e);
				}
			},
			executor
		);
	}

	public synchronized List<Session> getSessions()
	{
		return new ArrayList<>(sessions);
	}

	public synchronized Account[] getAccounts(String sessionId)
	{
		return accounts.get(sessionId);
	}

	public synchronized void removeSession(Session session)
	{
		List<Session> updatedAccounts = new ArrayList<>(sessions);
		if (!updatedAccounts.remove(session))
		{
			return;
		}

		try
		{
			sessionStore.save(updatedAccounts);
		}
		catch (IOException e)
		{
			log.error("Unable to remove Jagex account session for {}", session.getNickname(), e);
			return;
		}

		sessions.clear();
		sessions.addAll(updatedAccounts);
		accounts.remove(session.getSessionId());
	}

	public void performJagexAuthFlow() throws IOException, InterruptedException
	{
		String idToken = launchJagexAuth();
		handleJagexAuthCompletion(idToken);
	}

	private String launchJagexAuth() throws IOException, InterruptedException
	{
		var url = getJagexAuthURL();
		if (url == null)
		{
			throw new RuntimeException("jagexauth not found");
		}

		Path temp;
		try (var in = url.openStream())
		{
			temp = Files.createTempFile("runelite_jagexauth", "");
			Files.copy(in, temp, StandardCopyOption.REPLACE_EXISTING);
		}

		temp.toFile().setExecutable(true);

		Process process = new ProcessBuilder(
			temp.toAbsolutePath().toString(),
			"--prompt=login"
		)
			.redirectErrorStream(true)
			.start();

		String idToken = "";
		try (var in = new BufferedReader(new InputStreamReader(process.getInputStream())))
		{
			for (String s; (s = in.readLine()) != null;)
			{
				s = s.trim();
				String[] split = s.split(" ");
				if (split.length > 1 && split[0].equals("id_token:"))
				{
					idToken = split[1];
				}
			}
		}

		if (idToken.isBlank())
		{
			throw new RuntimeException("Login did not return an id token");
		}

		process.waitFor();
		Files.delete(temp);
		return idToken;
	}

	private void handleJagexAuthCompletion(String idToken) throws IOException
	{
		JagexAuthJwt jwt = JagexAuthJwt.decode(idToken, gson);
		String subject = jwt.getSub();
		String nickname = jwt.getNickname();

		String sessionId = authClient.getSessionId(idToken);
		Session session = new Session(sessionId, subject, nickname);

		synchronized (this)
		{
			if (sessions.stream().anyMatch(a -> subject.equals(a.getSub())))
			{
				log.info("Jagex account {} ({}) already exists", subject, nickname);
				return;
			}

			loadSession(session);
			sessionStore.save(sessions);
		}
	}

	private void loadSession(Session session)
	{
		try
		{
			Account[] characters = authClient.getAccounts(session.getSessionId());
			sessions.add(session);
			accounts.put(session.getSessionId(), characters);
		}
		catch (IOException e)
		{
			log.error("Unable to load characters for Jagex account {}", session.getNickname(), e);
		}
	}

	public void switchJagexAccount(String sessionId, String sub, String displayName)
	{
		clientThread.invoke(() -> client.switchJagexAccount(sessionId, sub, displayName));
	}

	private static URL getJagexAuthURL()
	{
		String propOverride = System.getProperty("runelite.jagexauth");
		if (propOverride != null)
		{
			var path = Path.of(propOverride);
			try
			{
				return path.toUri().toURL();
			}
			catch (MalformedURLException e)
			{
				throw new RuntimeException(e);
			}
		}

		String os, ext = "";
		switch (OSType.getOSType())
		{
			case Windows:
				os = "Win";
				ext = ".exe";
				break;
			case MacOS:
				os = "macOS";
				break;
			case Linux:
				os = "Linux";
				break;
			default:
				return null;
		}
		String arch = System.getProperty("os.arch");
		return JagexAuthService.class.getResource("/net/runelite/jagexauth/JagexAuth-" + os + "-" + arch + ext);
	}
}
