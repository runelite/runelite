/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, PandahRS <https://github.com/PandahRS>
 * Copyright (c) 2021, Jonathan Rousseau <https://github.com/JoRouss>
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
package net.runelite.client.plugins.discord;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.time.temporal.ChronoUnit;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.StatChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.party.PartyService;
import net.runelite.client.party.WSClient;
import net.runelite.client.party.messages.UserSync;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.discord.DiscordUser;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@PluginDescriptor(
	name = "Discord",
	description = "Show your status and activity in the Discord user panel",
	tags = {"action", "activity", "external", "integration", "status"}
)
@Slf4j
public class DiscordPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private DiscordConfig config;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private DiscordState discordState;

	@Inject
	private PartyService partyService;

	@Inject
	private DiscordService discordService;

	@Inject
	private WSClient wsClient;

	@Inject
	private OkHttpClient okHttpClient;

	@Inject
	@Named("runelite.discord.invite")
	private String discordInvite;

	private final Map<Skill, Integer> skillExp = new HashMap<>();
	private NavigationButton discordButton;
	private boolean loginFlag;

	@Provides
	private DiscordConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DiscordConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "discord.png");

		discordButton = NavigationButton.builder()
			.tooltip("Join Discord")
			.icon(icon)
			.onClick(() -> LinkBrowser.browse(discordInvite))
			.build();

		clientToolbar.addNavigation(discordButton);
		resetState();
		checkForGameStateUpdate();
		checkForAreaUpdate();

		wsClient.registerMessage(DiscordUserInfo.class);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientToolbar.removeNavigation(discordButton);
		resetState();
		wsClient.unregisterMessage(DiscordUserInfo.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
				resetState();
				checkForGameStateUpdate();
				return;
			case LOGGING_IN:
				loginFlag = true;
				break;
			case LOGGED_IN:
				if (loginFlag)
				{
					loginFlag = false;
					resetState();
					checkForGameStateUpdate();
				}
				checkForAreaUpdate();
				break;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equalsIgnoreCase("discord"))
		{
			resetState();
			checkForGameStateUpdate();
			checkForAreaUpdate();
		}
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		final Skill skill = statChanged.getSkill();
		final int exp = statChanged.getXp();
		final Integer previous = skillExp.put(skill, exp);

		if (previous == null || previous >= exp)
		{
			return;
		}

		final DiscordGameEventType discordGameEventType = DiscordGameEventType.fromSkill(skill);

		if (discordGameEventType != null && config.showSkillingActivity())
		{
			discordState.triggerEvent(discordGameEventType);
		}
	}

	@Subscribe
	public void onDiscordUserInfo(final DiscordUserInfo event)
	{
		final CharMatcher matcher = CharMatcher.anyOf("abcdef0123456789");

		// animated avatars contain a_ as prefix so we need to get rid of that first to check against matcher
		if (!matcher.matchesAllOf(event.getUserId()) || !matcher.matchesAllOf(event.getAvatarId().replace("a_", "")))
		{
			// userid is actually a snowflake, but the matcher is sufficient
			return;
		}

		final String url;

		if (Strings.isNullOrEmpty(event.getAvatarId()))
		{
			int disc = Integer.parseInt(event.getDiscriminator());
			int avatarId = disc % 5;
			url = "https://cdn.discordapp.com/embed/avatars/" + avatarId + ".png";
		}
		else
		{
			url = "https://cdn.discordapp.com/avatars/" + event.getUserId() + "/" + event.getAvatarId() + ".png";
		}

		log.debug("Got user avatar {}", url);

		final Request request = new Request.Builder()
			.url(url)
			.build();

		okHttpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{

			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				try (response)
				{
					if (!response.isSuccessful())
					{
						throw new IOException("Unexpected code " + response);
					}

					final InputStream inputStream = response.body().byteStream();
					final BufferedImage image;
					synchronized (ImageIO.class)
					{
						image = ImageIO.read(inputStream);
					}

					partyService.setPartyMemberAvatar(event.getMemberId(), image);
				}
			}
		});
	}

	@Subscribe
	public void onUserSync(final UserSync event)
	{
		final DiscordUser discordUser = discordService.getCurrentUser();
		if (discordUser != null)
		{
			final DiscordUserInfo userInfo = new DiscordUserInfo(
				discordUser.userId,
				discordUser.username,
				discordUser.discriminator,
				discordUser.avatar
			);
			partyService.send(userInfo);
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.MINUTES
	)
	public void checkForValidStatus()
	{
		discordState.checkForTimeout();
	}

	private void resetState()
	{
		discordState.reset();
	}

	private void checkForGameStateUpdate()
	{
		final boolean isLoggedIn = client.getGameState() == GameState.LOGGED_IN;

		if (config.showMainMenu() || isLoggedIn)
		{
			discordState.triggerEvent(isLoggedIn
					? DiscordGameEventType.IN_GAME
					: DiscordGameEventType.IN_MENU);
		}
	}

	private void checkForAreaUpdate()
	{
		if (client.getLocalPlayer() == null)
		{
			return;
		}

		final int playerRegionID = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();

		if (playerRegionID == 0)
		{
			return;
		}

		final EnumSet<WorldType> worldType = client.getWorldType();

		if (worldType.contains(WorldType.DEADMAN))
		{
			discordState.triggerEvent(DiscordGameEventType.PLAYING_DEADMAN);
			return;
		}
		else if (WorldType.isPvpWorld(worldType))
		{
			discordState.triggerEvent(DiscordGameEventType.PLAYING_PVP);
			return;
		}

		DiscordGameEventType discordGameEventType = DiscordGameEventType.fromRegion(playerRegionID);

		// NMZ uses the same region ID as KBD. KBD is always on plane 0 and NMZ is always above plane 0
		// Since KBD requires going through the wilderness there is no EventType for it
		if (DiscordGameEventType.MG_NIGHTMARE_ZONE == discordGameEventType
			&& client.getLocalPlayer().getWorldLocation().getPlane() == 0)
		{
			discordGameEventType = null;
		}

		if (discordGameEventType == null)
		{
			// Unknown region, reset to default in-game
			discordState.triggerEvent(DiscordGameEventType.IN_GAME);
			return;
		}

		if (!showArea(discordGameEventType))
		{
			return;
		}

		discordState.triggerEvent(discordGameEventType);
	}

	private boolean showArea(final DiscordGameEventType event)
	{
		if (event == null)
		{
			return false;
		}

		switch (event.getDiscordAreaType())
		{
			case BOSSES: return config.showBossActivity();
			case CITIES: return config.showCityActivity();
			case DUNGEONS: return config.showDungeonActivity();
			case MINIGAMES: return config.showMinigameActivity();
			case REGIONS: return config.showRegionsActivity();
			case RAIDS: return config.showRaidingActivity();
		}

		return false;
	}
}
