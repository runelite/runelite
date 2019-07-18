/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, PandahRS <https://github.com/PandahRS>
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

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.time.temporal.ChronoUnit;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.imageio.ImageIO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.discord.events.DiscordJoinGame;
import net.runelite.client.discord.events.DiscordJoinRequest;
import net.runelite.client.discord.events.DiscordReady;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.ws.PartyMember;
import net.runelite.client.ws.PartyService;
import net.runelite.client.ws.WSClient;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.ws.messages.party.UserJoin;
import net.runelite.http.api.ws.messages.party.UserPart;
import net.runelite.http.api.ws.messages.party.UserSync;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

@PluginDescriptor(
	name = "Discord",
	description = "Show your status and activity in the Discord user panel",
	tags = {"action", "activity", "external", "integration", "status"}
)
@Slf4j
@Singleton
public class DiscordPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private DiscordConfig config;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private RuneLiteProperties properties;

	@Inject
	private DiscordState discordState;

	@Inject
	private PartyService partyService;

	@Inject
	private DiscordService discordService;

	@Inject
	private WSClient wsClient;

	@Inject
	private EventBus eventBus;

	private final Map<Skill, Integer> skillExp = new HashMap<>();
	private NavigationButton discordButton;
	private boolean loginFlag;

	@Getter(AccessLevel.PACKAGE)
	private int actionTimeout;
	@Getter(AccessLevel.PACKAGE)
	private boolean hideElapsedTime;
	@Getter(AccessLevel.PACKAGE)
	private boolean alwaysShowParty;
	private boolean showSkillingActivity;
	private boolean showBossActivity;
	private boolean showCityActivity;
	private boolean showDungeonActivity;
	private boolean showMinigameActivity;
	private boolean showRaidingActivity;

	@Provides
	private DiscordConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DiscordConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "discord.png");

		discordButton = NavigationButton.builder()
			.tab(false)
			.tooltip("Join Discord")
			.icon(icon)
			.onClick(() -> LinkBrowser.browse(properties.getDiscordInvite()))
			.build();

		clientToolbar.addNavigation(discordButton);
		checkForGameStateUpdate();
		checkForAreaUpdate();

		if (discordService.getCurrentUser() != null)
		{
			partyService.setUsername(discordService.getCurrentUser().username + "#" + discordService.getCurrentUser().discriminator);
		}

		wsClient.registerMessage(DiscordUserInfo.class);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		clientToolbar.removeNavigation(discordButton);
		discordState.reset();
		partyService.changeParty(null);
		wsClient.unregisterMessage(DiscordUserInfo.class);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ExperienceChanged.class, this, this::onExperienceChanged);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(DiscordReady.class, this, this::onDiscordReady);
		eventBus.subscribe(DiscordJoinRequest.class, this, this::onDiscordJoinRequest);
		eventBus.subscribe(DiscordJoinGame.class, this, this::onDiscordJoinGame);
		eventBus.subscribe(DiscordUserInfo.class, this, this::onDiscordUserInfo);
		eventBus.subscribe(UserJoin.class, this, this::onUserJoin);
		eventBus.subscribe(UserSync.class, this, this::onUserSync);
		eventBus.subscribe(UserPart.class, this, this::onUserPart);
		eventBus.subscribe(PartyChanged.class, this, this::onPartyChanged);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
				checkForGameStateUpdate();
				return;
			case LOGGING_IN:
				loginFlag = true;
				break;
			case LOGGED_IN:
				if (loginFlag)
				{
					loginFlag = false;
					checkForGameStateUpdate();
				}

				break;
		}

		checkForAreaUpdate();
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equalsIgnoreCase("discord"))
		{
			updateConfig();

			checkForGameStateUpdate();
			checkForAreaUpdate();
			updatePresence();
		}
	}

	private void onExperienceChanged(ExperienceChanged event)
	{
		final int exp = client.getSkillExperience(event.getSkill());
		final Integer previous = skillExp.put(event.getSkill(), exp);

		if (previous == null || previous >= exp)
		{
			return;
		}

		final DiscordGameEventType discordGameEventType = DiscordGameEventType.fromSkill(event.getSkill());

		if (discordGameEventType != null && this.showSkillingActivity)
		{
			discordState.triggerEvent(discordGameEventType);
		}
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		if (!this.showRaidingActivity)
		{
			return;
		}

		final DiscordGameEventType discordGameEventType = DiscordGameEventType.fromVarbit(client);

		if (discordGameEventType != null)
		{
			discordState.triggerEvent(discordGameEventType);
		}
	}

	private void onDiscordReady(DiscordReady event)
	{
		partyService.setUsername(event.getUsername() + "#" + event.getDiscriminator());
	}

	private void onDiscordJoinRequest(DiscordJoinRequest request)
	{
		log.debug("Got discord join request {}", request);
		if (partyService.isOwner() && partyService.getMembers().isEmpty())
		{
			// First join, join also yourself
			partyService.changeParty(partyService.getLocalPartyId());
			updatePresence();
		}
	}

	private void onDiscordJoinGame(DiscordJoinGame joinGame)
	{
		log.debug("Got discord join game {}", joinGame);
		UUID partyId = UUID.fromString(joinGame.getJoinSecret());
		partyService.changeParty(partyId);
		updatePresence();
	}

	private void onDiscordUserInfo(final DiscordUserInfo event)
	{
		final PartyMember memberById = partyService.getMemberById(event.getMemberId());

		if (memberById == null || memberById.getAvatar() != null)
		{
			return;
		}

		String url = "https://cdn.discordapp.com/avatars/" + event.getUserId() + "/" + event.getAvatarId() + ".png";

		if (Strings.isNullOrEmpty(event.getAvatarId()))
		{
			final String[] split = memberById.getName().split("#", 2);

			if (split.length == 2)
			{
				int disc = Integer.valueOf(split[1]);
				int avatarId = disc % 5;
				url = "https://cdn.discordapp.com/embed/avatars/" + avatarId + ".png";
			}
		}

		log.debug("Got user avatar {}", url);

		final Request request = new Request.Builder()
			.url(url)
			.build();

		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{

			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				try
				{
					if (!response.isSuccessful())
					{
						throw new IOException("Unexpected code " + response);
					}

					final InputStream inputStream = response.body().byteStream();
					final BufferedImage image = ImageIO.read(inputStream);
					memberById.setAvatar(image);
				}
				finally
				{
					response.close();
				}
			}
		});
	}

	private void onUserJoin(final UserJoin event)
	{
		updatePresence();
	}

	private void onUserSync(final UserSync event)
	{
		final PartyMember localMember = partyService.getLocalMember();

		if (localMember != null && discordService.getCurrentUser() != null)
		{
			final DiscordUserInfo userInfo = new DiscordUserInfo(
				discordService.getCurrentUser().userId,
				discordService.getCurrentUser().avatar);

			userInfo.setMemberId(localMember.getMemberId());
			wsClient.send(userInfo);
		}
	}

	private void onUserPart(final UserPart event)
	{
		updatePresence();
	}

	private void onPartyChanged(final PartyChanged event)
	{
		updatePresence();
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.MINUTES
	)
	public void checkForValidStatus()
	{
		discordState.checkForTimeout();
	}

	private void updatePresence()
	{
		discordState.refresh();
	}

	private void checkForGameStateUpdate()
	{
		// Game state update does also full reset of discord state
		discordState.reset();
		discordState.triggerEvent(client.getGameState() == GameState.LOGGED_IN
			? DiscordGameEventType.IN_GAME
			: DiscordGameEventType.IN_MENU);
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

		final DiscordGameEventType discordGameEventType = DiscordGameEventType.fromRegion(playerRegionID);

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

		final EnumSet<WorldType> worldType = client.getWorldType();

		// Do not show location in PVP activities
		if (WorldType.isPvpWorld(worldType))
		{
			return false;
		}

		switch (event.getDiscordAreaType())
		{
			case BOSSES:
				return this.showBossActivity;
			case CITIES:
				return this.showCityActivity;
			case DUNGEONS:
				return this.showDungeonActivity;
			case MINIGAMES:
				return this.showMinigameActivity;
		}

		return false;
	}

	private void updateConfig()
	{
		this.actionTimeout = config.actionTimeout();
		this.hideElapsedTime = config.hideElapsedTime();
		this.alwaysShowParty = config.alwaysShowParty();
		this.showSkillingActivity = config.showSkillingActivity();
		this.showBossActivity = config.showBossActivity();
		this.showCityActivity = config.showCityActivity();
		this.showDungeonActivity = config.showDungeonActivity();
		this.showMinigameActivity = config.showMinigameActivity();
		this.showRaidingActivity = config.showRaidingActivity();
	}
}
