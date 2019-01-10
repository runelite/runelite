/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.crystalmathlabs;

import java.io.IOException;
import java.util.Objects;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@PluginDescriptor(
	name = "Crystal Math Labs",
	description = "Automatically updates your stats on Crystal Math Labs when you log out",
	tags = {"cml", "external", "integration"},
	enabledByDefault = false
)
@Slf4j
public class CrystalMathLabs extends Plugin
{
	/**
	 * Amount of EXP that must be gained for an update to be submitted.
	 */
	private static final int XP_THRESHOLD = 1000;

	@Inject
	private Client client;

	private String lastUsername;
	private long lastXp;

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		GameState state = gameStateChanged.getGameState();
		if (state == GameState.LOGGED_IN)
		{
			if (!Objects.equals(client.getUsername(), lastUsername))
			{
				lastUsername = client.getUsername();
				lastXp = getTotalXp();
			}
		}
		else if (state == GameState.LOGIN_SCREEN)
		{
			Player local = client.getLocalPlayer();
			if (local == null)
			{
				return;
			}

			long totalXp = getTotalXp();
			// Don't submit update unless xp threshold is reached
			if (Math.abs(totalXp - lastXp) > XP_THRESHOLD)
			{
				log.debug("Submitting update for {}", local.getName());
				sendUpdateRequest(local.getName());
			}
		}
	}

	private long getTotalXp()
	{
		long total = 0;
		for (Skill skill : Skill.values())
		{
			total += client.getSkillExperience(skill);
		}
		return total;
	}

	private void sendUpdateRequest(String username)
	{
		String reformedUsername = username.replace(" ", "_");
		OkHttpClient httpClient = RuneLiteAPI.CLIENT;

		HttpUrl httpUrl = new HttpUrl.Builder()
			.scheme("https")
			.host("crystalmathlabs.com")
			.addPathSegment("tracker")
			.addPathSegment("api.php")
			.addQueryParameter("type", "update")
			.addQueryParameter("player", reformedUsername)
			.build();

		Request request = new Request.Builder()
			.header("User-Agent", "RuneLite")
			.url(httpUrl)
			.build();

		httpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("error submitting CML update", e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				response.close();
			}
		});
	}
}
