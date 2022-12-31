/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, Alexsuperfly <alexsuperfly@users.noreply.github.com>
 * Copyright (c) 2020, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.xpupdater;

import com.google.inject.Provides;
import java.io.IOException;
import java.util.EnumSet;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.WorldType;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.FormBody;
import okhttp3.Response;

@PluginDescriptor(
	name = "XP Updater",
	description = "Automatically updates your stats on external xptrackers when you log out",
	tags = {"cml", "crystalmathlabs", "templeosrs", "temple", "wom", "wiseoldman", "wise old man", "external", "integration"},
	enabledByDefault = false
)
@Slf4j
public class XpUpdaterPlugin extends Plugin
{
	/**
	 * Amount of EXP that must be gained for an update to be submitted.
	 */
	private static final int XP_THRESHOLD = 10000;

	@Inject
	private Client client;

	@Inject
	private XpUpdaterConfig config;

	@Inject
	private OkHttpClient okHttpClient;

	private long lastAccount;
	private boolean fetchXp;
	private long lastXp;

	@Provides
	XpUpdaterConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XpUpdaterConfig.class);
	}

	@Override
	protected void startUp()
	{
		fetchXp = true;
		lastAccount = -1L;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		GameState state = gameStateChanged.getGameState();
		if (state == GameState.LOGGED_IN)
		{
			if (lastAccount != client.getAccountHash())
			{
				lastAccount = client.getAccountHash();
				fetchXp = true;
			}
		}
		else if (state == GameState.LOGIN_SCREEN)
		{
			Player local = client.getLocalPlayer();
			if (local == null)
			{
				return;
			}

			long totalXp = client.getOverallExperience();
			// Don't submit update unless xp threshold is reached
			if (Math.abs(totalXp - lastXp) > XP_THRESHOLD)
			{
				log.debug("Submitting update for {} accountHash {}", local.getName(), lastAccount);
				update(lastAccount, local.getName());
				lastXp = totalXp;
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (fetchXp)
		{
			lastXp = client.getOverallExperience();
			fetchXp = false;
		}
	}

	private void update(long accountHash, String username)
	{
		EnumSet<WorldType> worldTypes = client.getWorldType();
		username = username.replace(" ", "_");
		updateCml(username, worldTypes);
		updateTempleosrs(accountHash, username, worldTypes);
		updateWom(accountHash, username, worldTypes);
	}

	private void updateCml(String username, EnumSet<WorldType> worldTypes)
	{
		if (config.cml()
			&& !worldTypes.contains(WorldType.SEASONAL)
			&& !worldTypes.contains(WorldType.DEADMAN)
			&& !worldTypes.contains(WorldType.NOSAVE_MODE)
			&& !worldTypes.contains(WorldType.FRESH_START_WORLD))
		{
			HttpUrl url = new HttpUrl.Builder()
				.scheme("https")
				.host("crystalmathlabs.com")
				.addPathSegment("tracker")
				.addPathSegment("api.php")
				.addQueryParameter("type", "update")
				.addQueryParameter("player", username)
				.build();

			Request request = new Request.Builder()
				.header("User-Agent", "RuneLite")
				.url(url)
				.build();

			sendRequest("CrystalMathLabs", request);
		}
	}

	private void updateTempleosrs(long accountHash, String username, EnumSet<WorldType> worldTypes)
	{
		if (config.templeosrs()
			&& !worldTypes.contains(WorldType.SEASONAL)
			&& !worldTypes.contains(WorldType.DEADMAN)
			&& !worldTypes.contains(WorldType.NOSAVE_MODE))
		{
			HttpUrl.Builder url = new HttpUrl.Builder()
				.scheme("https")
				.host("templeosrs.com")
				.addPathSegment("php")
				.addPathSegment("add_datapoint.php")
				.addQueryParameter("player", username)
				.addQueryParameter("accountHash", Long.toString(accountHash));

			if (worldTypes.contains(WorldType.FRESH_START_WORLD))
			{
				url.addQueryParameter("worldType", "fsw");
			}

			Request request = new Request.Builder()
				.header("User-Agent", "RuneLite")
				.url(url.build())
				.build();

			sendRequest("TempleOSRS", request);
		}
	}

	private void updateWom(long accountHash, String username, EnumSet<WorldType> worldTypes)
	{
		if (config.wiseoldman()
			&& !worldTypes.contains(WorldType.DEADMAN)
			&& !worldTypes.contains(WorldType.NOSAVE_MODE))
		{
			HttpUrl url = new HttpUrl.Builder()
				.scheme("https")
				.host(
					worldTypes.contains(WorldType.SEASONAL) ? "seasonal.api.wiseoldman.net" :
						"api.wiseoldman.net")
				.addPathSegment("v2")
				.addPathSegment("players")
				.addPathSegment(username)
				.build();

			RequestBody formBody = new FormBody.Builder()
				.add("accountHash", Long.toString(accountHash))
				.build();

			Request request = new Request.Builder()
				.header("User-Agent", "RuneLite")
				.url(url)
				.post(formBody)
				.build();

			sendRequest("Wise Old Man", request);
		}
	}

	private void sendRequest(String platform, Request request)
	{
		okHttpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("Error submitting {} update, caused by {}.", platform, e.getMessage());
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				response.close();
			}
		});
	}
}
