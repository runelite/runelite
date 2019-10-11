/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.playerindicators;

import com.google.inject.Provides;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.ClanMember;
import net.runelite.api.ClanMemberRank;
import static net.runelite.api.ClanMemberRank.UNRANKED;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import static net.runelite.api.MenuOpcode.*;
import net.runelite.api.Player;
import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ClanMemberLeft;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.util.Text;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ClanManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.PvPUtil;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreResult;

@PluginDescriptor(
	name = "Player Indicators",
	description = "Highlight players on-screen and/or on the minimap",
	tags = {"highlight", "minimap", "overlay", "players", "pklite"},
	type = PluginType.UTILITY
)
@Singleton
@Getter(AccessLevel.PACKAGE)
public class PlayerIndicatorsPlugin extends Plugin
{
	private static final HiscoreClient HISCORE_CLIENT = new HiscoreClient();
	private final List<String> callers = new ArrayList<>();
	private final Map<Player, PlayerRelation> colorizedMenus = new ConcurrentHashMap<>();
	private final Map<PlayerRelation, Color> relationColorHashMap = new ConcurrentHashMap<>();
	private final Map<PlayerRelation, Object[]> locationHashMap = new ConcurrentHashMap<>();
	private final Map<String, Actor> callerPiles = new ConcurrentHashMap<>();
	@Getter(AccessLevel.PACKAGE)
	private final Map<String, HiscoreResult> resultCache = new HashMap<>();
	private final ExecutorService executorService = Executors.newFixedThreadPool(100);
	@Inject
	@Getter(AccessLevel.NONE)
	private OverlayManager overlayManager;
	@Inject
	@Getter(AccessLevel.NONE)
	private PlayerIndicatorsConfig config;
	@Inject
	@Getter(AccessLevel.NONE)
	private PlayerIndicatorsOverlay playerIndicatorsOverlay;
	@Inject
	@Getter(AccessLevel.NONE)
	private PlayerIndicatorsMinimapOverlay playerIndicatorsMinimapOverlay;
	@Inject
	@Getter(AccessLevel.NONE)
	private Client client;
	@Inject
	@Getter(AccessLevel.NONE)
	private ClanManager clanManager;
	@Inject
	@Getter(AccessLevel.NONE)
	private EventBus eventBus;
	private ClanMemberRank callerRank;
	private PlayerIndicatorsPlugin.AgilityFormats agilityFormat;
	private PlayerIndicatorsPlugin.MinimapSkullLocations skullLocation;
	private String configCallers;
	private boolean highlightCallerTargets;
	private boolean highlightCallers;
	private boolean highlightClan;
	private boolean highlightFriends;
	private boolean highlightOther;
	private boolean highlightOwnPlayer;
	private boolean highlightTargets;
	private boolean highlightTeam;
	private boolean playerSkull;
	private boolean showAgilityLevel;
	private boolean showClanRanks;
	private boolean showCombatLevel;
	private boolean targetRisk;
	private boolean unchargedGlory;
	private boolean useClanchatRanks;
	private int agilityFirstThreshold;
	private int agilitySecondThreshold;

	@Provides
	PlayerIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PlayerIndicatorsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();
		resultCache.clear();
		overlayManager.add(playerIndicatorsOverlay);
		overlayManager.add(playerIndicatorsMinimapOverlay);
		getCallerList();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		overlayManager.remove(playerIndicatorsOverlay);
		overlayManager.remove(playerIndicatorsMinimapOverlay);
		resultCache.clear();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ClanMemberJoined.class, this, this::onClanMemberJoined);
		eventBus.subscribe(ClanMemberLeft.class, this, this::onClanMemberLeft);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(InteractingChanged.class, this, this::onInteractingChanged);
		eventBus.subscribe(PlayerSpawned.class, this, this::onPlayerSpawned);
	}

	private void onInteractingChanged(InteractingChanged event)
	{
		if (!this.highlightCallerTargets || event.getSource() == null || callers.isEmpty() || !isCaller(event.getSource()))
		{
			return;
		}

		final Actor caller = event.getSource();

		if (this.callerPiles.containsKey(caller.getName()))
		{
			if (event.getTarget() == null)
			{
				callerPiles.remove(caller.getName());
				return;
			}

			callerPiles.replace(caller.getName(), event.getTarget());
			return;
		}

		if (event.getTarget() == null)
		{
			return;
		}

		callerPiles.put(caller.getName(), event.getTarget());
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("playerindicators"))
		{
			return;
		}

		updateConfig();
	}

	private void onClanMemberJoined(ClanMemberJoined event)
	{
		getCallerList();
	}

	private void onClanMemberLeft(ClanMemberLeft event)
	{
		getCallerList();
	}

	private void onPlayerSpawned(PlayerSpawned event)
	{
		final Player player = event.getPlayer();

		if (!this.showAgilityLevel || resultCache.containsKey(player.getName()))
		{
			return;
		}

		executorService.submit(() ->
		{
			HiscoreResult result;
			do
			{
				try
				{
					result = HISCORE_CLIENT.lookup(player.getName());
				}
				catch (IOException ex)
				{
					result = null;
					try
					{
						Thread.sleep(250);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
			while (result == null);

			resultCache.put(player.getName(), result);
		});
	}

	private void onMenuEntryAdded(MenuEntryAdded menuEntryAdded)
	{
		int type = menuEntryAdded.getOpcode();

		if (type >= 2000)
		{
			type -= 2000;
		}

		int identifier = menuEntryAdded.getIdentifier();
		if (type == FOLLOW.getId() || type == TRADE.getId()
			|| type == SPELL_CAST_ON_PLAYER.getId() || type == ITEM_USE_ON_PLAYER.getId()
			|| type == PLAYER_FIRST_OPTION.getId()
			|| type == PLAYER_SECOND_OPTION.getId()
			|| type == PLAYER_THIRD_OPTION.getId()
			|| type == PLAYER_FOURTH_OPTION.getId()
			|| type == PLAYER_FIFTH_OPTION.getId()
			|| type == PLAYER_SIXTH_OPTION.getId()
			|| type == PLAYER_SEVENTH_OPTION.getId()
			|| type == PLAYER_EIGTH_OPTION.getId()
			|| type == RUNELITE.getId())
		{
			final Player localPlayer = client.getLocalPlayer();
			final Player[] players = client.getCachedPlayers();
			Player player = null;

			if (identifier >= 0 && identifier < players.length)
			{
				player = players[identifier];
			}

			if (player == null)
			{
				return;
			}

			int image = -1;
			int image2 = -1;
			Color color = null;

			if (this.highlightCallers && isCaller(player))
			{
				if (Arrays.asList(this.locationHashMap.get(PlayerRelation.CALLER)).contains(PlayerIndicationLocation.MENU))
				{
					color = relationColorHashMap.get(PlayerRelation.CALLER);
				}
			}
			else if (this.highlightCallerTargets && isPile(player))
			{
				if (Arrays.asList(this.locationHashMap.get(PlayerRelation.CALLER_TARGET)).contains(PlayerIndicationLocation.MENU))
				{
					color = relationColorHashMap.get(PlayerRelation.CALLER_TARGET);
				}
			}
			else if (this.highlightFriends && client.isFriended(player.getName(), false))
			{
				if (Arrays.asList(this.locationHashMap.get(PlayerRelation.FRIEND)).contains(PlayerIndicationLocation.MENU))
				{
					color = relationColorHashMap.get(PlayerRelation.FRIEND);
				}
			}
			else if (this.highlightClan && player.isClanMember())
			{
				if (Arrays.asList(this.locationHashMap.get(PlayerRelation.CLAN)).contains(PlayerIndicationLocation.MENU))
				{
					color = relationColorHashMap.get(PlayerRelation.CLAN);
				}

				ClanMemberRank rank = clanManager.getRank(player.getName());
				if (rank != UNRANKED)
				{
					image = clanManager.getIconNumber(rank);
				}
			}
			else if (this.highlightTeam && player.getTeam() > 0 && (localPlayer != null ? localPlayer.getTeam() : -1) == player.getTeam())
			{
				if (Arrays.asList(this.locationHashMap.get(PlayerRelation.TEAM)).contains(PlayerIndicationLocation.MENU))
				{
					color = relationColorHashMap.get(PlayerRelation.TEAM);
				}
			}
			else if (this.highlightOther && !player.isClanMember() && !player.isFriend() && !PvPUtil.isAttackable(client, player))
			{
				if (Arrays.asList(this.locationHashMap.get(PlayerRelation.OTHER)).contains(PlayerIndicationLocation.MENU))
				{
					color = relationColorHashMap.get(PlayerRelation.OTHER);
				}
			}
			else if (this.highlightTargets && !player.isClanMember() && !client.isFriended(player.getName(),
				false) && PvPUtil.isAttackable(client, player))
			{
				if (Arrays.asList(this.locationHashMap.get(PlayerRelation.TARGET)).contains(PlayerIndicationLocation.MENU))
				{
					color = relationColorHashMap.get(PlayerRelation.TARGET);
				}
			}


			if (this.playerSkull && !player.isClanMember() && player.getSkullIcon() != null)
			{
				image2 = 35;
			}

			if (image != -1 || color != null)
			{
				final MenuEntry[] menuEntries = client.getMenuEntries();
				final MenuEntry lastEntry = menuEntries[menuEntries.length - 1];


				if (color != null)
				{
					// strip out existing <col...
					String target = lastEntry.getTarget();
					final int idx = target.indexOf('>');
					if (idx != -1)
					{
						target = target.substring(idx + 1);
					}

					lastEntry.setTarget(ColorUtil.prependColorTag(target, color));
				}
				if (image != -1)
				{
					lastEntry.setTarget("<img=" + image + ">" + lastEntry.getTarget());
				}

				if (image2 != -1 && this.playerSkull)
				{
					lastEntry.setTarget("<img=" + image2 + ">" + lastEntry.getTarget());
				}

				client.setMenuEntries(menuEntries);
			}
		}
	}


	private void getCallerList()
	{
		if (!this.highlightCallers)
		{
			return;
		}

		callers.clear();

		if (this.useClanchatRanks && client.getClanMembers() != null)
		{
			for (ClanMember clanMember : client.getClanMembers())
			{
				if (clanMember.getRank().getValue() > this.callerRank.getValue())
				{
					callers.add(Text.standardize(clanMember.getUsername()));
				}
			}
		}

		if (this.configCallers.contains(","))
		{
			callers.addAll(Arrays.asList(this.configCallers.split(",")));
			return;
		}

		if (!this.configCallers.equals(""))
		{
			callers.add(this.configCallers);
		}
	}

	/**
	 * Checks if a player is a caller
	 *
	 * @param player The player to check
	 * @return true if they are, false otherwise
	 */
	boolean isCaller(Actor player)
	{
		if (player == null || player.getName() == null)
		{
			return false;
		}

		if (callers.size() > 0)
		{
			for (String name : callers)
			{
				String finalName = Text.standardize(name.trim());
				if (Text.standardize(player.getName()).equals(finalName))
				{
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Checks if a player is currently a target of any of the current callers
	 *
	 * @param actor The player to check
	 * @return true if they are a target, false otherwise
	 */
	public boolean isPile(Actor actor)
	{
		/**
		 if (!(actor instanceof Player))
		 {
		 return false;
		 }
		 **/
		if (actor == null)
		{
			return false;
		}

		return callerPiles.containsValue(actor);
	}


	private void updateConfig()
	{
		locationHashMap.clear();
		relationColorHashMap.clear();
		this.highlightOwnPlayer = config.highlightOwnPlayer();
		if (this.highlightOwnPlayer)
		{
			relationColorHashMap.put(PlayerRelation.SELF, config.getOwnPlayerColor());
			locationHashMap.put(PlayerRelation.SELF, EnumSet.copyOf(config.selfIndicatorModes()).toArray());
		}

		this.highlightFriends = config.highlightFriends();
		if (this.highlightFriends)
		{
			relationColorHashMap.put(PlayerRelation.FRIEND, config.getFriendColor());
			locationHashMap.put(PlayerRelation.FRIEND, config.friendIndicatorMode().toArray());
		}

		this.highlightClan = config.highlightClan();
		if (this.highlightClan)
		{
			relationColorHashMap.put(PlayerRelation.CLAN, config.getClanColor());
			locationHashMap.put(PlayerRelation.CLAN, config.clanIndicatorModes().toArray());
		}

		this.highlightTeam = config.highlightTeamMembers();
		if (this.highlightTeam)
		{
			relationColorHashMap.put(PlayerRelation.TEAM, config.getTeamcolor());
			locationHashMap.put(PlayerRelation.TEAM, config.teamIndicatorModes().toArray());
		}

		this.highlightOther = config.highlightOtherPlayers();
		if (this.highlightOther)
		{
			relationColorHashMap.put(PlayerRelation.OTHER, config.getOtherColor());
			locationHashMap.put(PlayerRelation.OTHER, EnumSet.copyOf(config.otherIndicatorModes()).toArray());
		}

		this.highlightTargets = config.highlightTargets();
		if (this.highlightTargets)
		{
			relationColorHashMap.put(PlayerRelation.TARGET, config.getTargetsColor());
			locationHashMap.put(PlayerRelation.TARGET, config.targetsIndicatorModes().toArray());
		}

		this.highlightCallers = config.highlightCallers();
		if (this.highlightCallers)
		{
			this.callerRank = config.callerRank();

			this.configCallers = config.callers();
			relationColorHashMap.put(PlayerRelation.CALLER, config.callerColor());
			locationHashMap.put(PlayerRelation.CALLER, config.callerHighlightOptions().toArray());
			getCallerList();
		}

		this.highlightCallerTargets = config.callersTargets();
		if (this.highlightCallerTargets)
		{
			relationColorHashMap.put(PlayerRelation.CALLER_TARGET, config.callerTargetColor());
			locationHashMap.put(PlayerRelation.CALLER_TARGET, config.callerTargetHighlightOptions().toArray());
		}

		this.showClanRanks = config.showClanRanks();
		this.showCombatLevel = config.showCombatLevel();
		this.showAgilityLevel = config.showAgilityLevel();
		this.agilityFirstThreshold = config.agilityFirstThreshold();
		this.agilitySecondThreshold = config.agilitySecondThreshold();
		this.agilityFormat = config.agilityFormat();
		this.playerSkull = config.playerSkull();
		this.skullLocation = config.skullLocation();
		this.targetRisk = config.targetRisk();
		this.useClanchatRanks = config.useClanchatRanks();
		this.unchargedGlory = config.unchargedGlory();
	}

	public enum MinimapSkullLocations
	{
		BEFORE_NAME,
		AFTER_NAME
	}

	public enum AgilityFormats
	{
		TEXT,
		ICONS
	}
}
