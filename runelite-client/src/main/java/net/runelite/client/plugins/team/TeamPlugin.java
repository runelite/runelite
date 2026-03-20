/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.team;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.FriendsChatMember;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.clan.ClanChannel;
import net.runelite.api.clan.ClanChannelMember;
import net.runelite.api.clan.ClanID;
import net.runelite.api.events.ClanChannelChanged;
import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ClanMemberLeft;
import net.runelite.api.events.FriendsChatChanged;
import net.runelite.api.events.FriendsChatMemberJoined;
import net.runelite.api.events.FriendsChatMemberLeft;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.PlayerChanged;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.gameval.SpriteID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Team",
	description = "Shows how many team and clan mates are nearby",
	tags = {"overlay", "players", "cape", "clan", "friend"},
	configName = "TeamCapesPlugin", // the old plugin's name
	enabledByDefault = false
)
@Slf4j
public class TeamPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TeamConfig config;

	@Inject
	private TeamCapesOverlay overlay;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	// Team number -> Number of players
	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, Integer> teams = new LinkedHashMap<>();
	// Player -> Team number
	private final Map<Player, Integer> playerTeam = new HashMap<>();

	private final BiMap<String, Player> players = HashBiMap.create();
	private int friendsChatCount;
	private int clanChatCount;
	private MembersIndicator friendsChatIndicator;
	private MembersIndicator clanChatIndicator;

	@Provides
	TeamConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TeamConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);

		clientThread.invokeLater(() -> client.getPlayers().forEach(this::updateTeam));
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		teams.clear();
		playerTeam.clear();
		players.clear();
		removeFriendsChatCounter();
		removeClanChatCounter();
		friendsChatCount = 0;
		clanChatCount = 0;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals(TeamConfig.GROUP))
		{
			if (config.friendsChatMemberCounter())
			{
				clientThread.invoke(this::addFriendsChatCounter);
			}
			else
			{
				removeFriendsChatCounter();
			}

			if (config.clanChatMemberCounter())
			{
				clientThread.invoke(this::addClanChatCounter);
			}
			else
			{
				removeClanChatCounter();
			}
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged state)
	{
		GameState gameState = state.getGameState();

		if (gameState == GameState.LOGIN_SCREEN || gameState == GameState.CONNECTION_LOST || gameState == GameState.HOPPING)
		{
			players.clear();
			removeFriendsChatCounter();
			removeClanChatCounter();
		}
	}

	@Subscribe
	public void onPlayerSpawned(PlayerSpawned event)
	{
		final Player local = client.getLocalPlayer();
		final Player player = event.getPlayer();

		if (player != local)
		{
			players.put(Text.removeTags(player.getName()), player);

			if (player.isFriendsChatMember())
			{
				++friendsChatCount;
				addFriendsChatCounter();
			}

			if (player.isClanMember())
			{
				++clanChatCount;
				addClanChatCounter();
			}
		}
	}

	@Subscribe
	public void onPlayerDespawned(PlayerDespawned playerDespawned)
	{
		Player player = playerDespawned.getPlayer();
		Integer team = playerTeam.remove(player);
		if (team != null)
		{
			teams.computeIfPresent(team, (key, value) -> value > 1 ? value - 1 : null);
			sortTeams();
		}

		players.inverse().remove(player);

		if (player.isFriendsChatMember())
		{
			if (friendsChatCount > 0)
			{
				if (--friendsChatCount == 0)
				{
					removeFriendsChatCounter();
				}
			}
		}

		if (player.isClanMember())
		{
			if (clanChatCount > 0)
			{
				if (--clanChatCount == 0)
				{
					removeClanChatCounter();
				}
			}
		}
	}

	@Subscribe
	public void onPlayerChanged(PlayerChanged playerChanged)
	{
		Player player = playerChanged.getPlayer();
		updateTeam(player);
	}

	private void updateTeam(Player player)
	{
		int oldTeam = playerTeam.getOrDefault(player, 0);
		if (oldTeam == player.getTeam())
		{
			return;
		}

		log.debug("{} has changed teams: {} -> {}", player.getName(), oldTeam, player.getTeam());

		if (oldTeam > 0)
		{
			teams.computeIfPresent(oldTeam, (key, value) -> value > 1 ? value - 1 : null);
			playerTeam.remove(player);
		}

		if (player.getTeam() > 0)
		{
			teams.merge(player.getTeam(), 1, Integer::sum);
			playerTeam.put(player, player.getTeam());
		}

		sortTeams();
	}

	private void sortTeams()
	{
		// Sort teams by value in descending order and then by key in ascending order, limited to 5 entries
		teams = teams.entrySet().stream()
			.sorted(
				Comparator.comparing(Map.Entry<Integer, Integer>::getValue, Comparator.reverseOrder())
					.thenComparingInt(Map.Entry::getKey)
			)
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	@Subscribe
	public void onFriendsChatChanged(FriendsChatChanged event)
	{
		if (!event.isJoined())
		{
			removeFriendsChatCounter();
			friendsChatCount = 0;
		}
	}

	@Subscribe
	public void onClanChannelChanged(ClanChannelChanged event)
	{
		if (event.getClanId() == ClanID.CLAN)
		{
			removeClanChatCounter();
			clanChatCount = 0;

			ClanChannel clanChannel = event.getClanChannel();
			if (clanChannel != null)
			{
				for (ClanChannelMember member : clanChannel.getMembers())
				{
					final String memberName = Text.toJagexName(member.getName());

					final Player player = players.get(memberName);
					if (player != null)
					{
						++clanChatCount;
					}
				}

				addClanChatCounter();
			}
		}
	}

	@Subscribe
	public void onFriendsChatMemberJoined(FriendsChatMemberJoined event)
	{
		final FriendsChatMember member = event.getMember();

		if (member.getWorld() == client.getWorld())
		{
			final String memberName = Text.toJagexName(member.getName());

			final Player player = players.get(memberName);
			if (player != null)
			{
				++friendsChatCount;
				addFriendsChatCounter();
			}
		}
	}

	@Subscribe
	public void onFriendsChatMemberLeft(FriendsChatMemberLeft event)
	{
		final FriendsChatMember member = event.getMember();

		if (member.getWorld() == client.getWorld())
		{
			final String memberName = Text.toJagexName(member.getName());
			final Player player = players.get(memberName);
			if (player != null)
			{
				if (friendsChatCount > 0)
				{
					if (--friendsChatCount == 0)
					{
						removeFriendsChatCounter();
					}
				}
			}
		}
	}

	@Subscribe
	public void onClanMemberJoined(ClanMemberJoined clanMemberJoined)
	{
		final ClanChannelMember member = clanMemberJoined.getClanMember();

		if (member.getWorld() == client.getWorld())
		{
			final String memberName = Text.toJagexName(member.getName());

			final Player player = players.get(memberName);
			if (player != null)
			{
				++clanChatCount;
				addClanChatCounter();
			}
		}
	}

	@Subscribe
	public void onClanMemberLeft(ClanMemberLeft clanMemberLeft)
	{
		final ClanChannelMember member = clanMemberLeft.getClanMember();

		if (member.getWorld() == client.getWorld())
		{
			final String memberName = Text.toJagexName(member.getName());
			final Player player = players.get(memberName);
			if (player != null)
			{
				if (clanChatCount > 0)
				{
					if (--clanChatCount == 0)
					{
						removeClanChatCounter();
					}
				}
			}
		}
	}

	private void addFriendsChatCounter()
	{
		if (!config.friendsChatMemberCounter() || friendsChatIndicator != null || friendsChatCount == 0)
		{
			return;
		}

		final BufferedImage image = spriteManager.getSprite(SpriteID.SideIcons.FRIENDS_CHAT, 0);
		friendsChatIndicator = new MembersIndicator(image, this)
		{
			@Override
			public String getText()
			{
				return Integer.toString(friendsChatCount);
			}

			@Override
			public String getTooltip()
			{
				return friendsChatCount + " friends chat member(s) near you";
			}
		};
		infoBoxManager.addInfoBox(friendsChatIndicator);
	}

	private void removeFriendsChatCounter()
	{
		infoBoxManager.removeInfoBox(friendsChatIndicator);
		friendsChatIndicator = null;
	}

	private void addClanChatCounter()
	{
		if (!config.clanChatMemberCounter() || clanChatIndicator != null || clanChatCount == 0)
		{
			return;
		}

		final BufferedImage image = spriteManager.getSprite(SpriteID.SideiconsInterface.CLAN, 0);
		clanChatIndicator = new MembersIndicator(image, this)
		{
			@Override
			public String getText()
			{
				return Integer.toString(clanChatCount);
			}

			@Override
			public String getTooltip()
			{
				return clanChatCount + " clan chat member(s) near you";
			}
		};
		infoBoxManager.addInfoBox(clanChatIndicator);
	}

	private void removeClanChatCounter()
	{
		infoBoxManager.removeInfoBox(clanChatIndicator);
		clanChatIndicator = null;
	}
}
