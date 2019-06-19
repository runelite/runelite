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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.ClanMember;
import net.runelite.api.ClanMemberRank;
import static net.runelite.api.ClanMemberRank.UNRANKED;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.FOLLOW;
import static net.runelite.api.MenuAction.ITEM_USE_ON_PLAYER;
import static net.runelite.api.MenuAction.PLAYER_EIGTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIFTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIRST_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FOURTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SECOND_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SEVENTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SIXTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_THIRD_OPTION;
import static net.runelite.api.MenuAction.RUNELITE;
import static net.runelite.api.MenuAction.SPELL_CAST_ON_PLAYER;
import static net.runelite.api.MenuAction.TRADE;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ClanMemberLeft;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ClanManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.PvPUtil;

@PluginDescriptor(
	name = "Player Indicators",
	description = "Highlight players on-screen and/or on the minimap",
	tags = {"highlight", "minimap", "overlay", "players", "pklite"}
)
public class PlayerIndicatorsPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PlayerIndicatorsConfig config;

	@Inject
	private PlayerIndicatorsOverlay playerIndicatorsOverlay;

	@Inject
	private PlayerIndicatorsTileOverlay playerIndicatorsTileOverlay;

	@Inject
	private PlayerIndicatorsMinimapOverlay playerIndicatorsMinimapOverlay;

	@Inject
	private Client client;

	@Inject
	private ClanManager clanManager;

	@Provides
	PlayerIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PlayerIndicatorsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(playerIndicatorsOverlay);
		overlayManager.add(playerIndicatorsTileOverlay);
		overlayManager.add(playerIndicatorsMinimapOverlay);
		getCallerList();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(playerIndicatorsOverlay);
		overlayManager.remove(playerIndicatorsTileOverlay);
		overlayManager.remove(playerIndicatorsMinimapOverlay);
	}

	private ArrayList<String> callers = new ArrayList<>();
	private List<String> pileList;

	@Subscribe
	public void onConfigChanged(ConfigChanged e)
	{
		if (config.callers() != null && !config.callers().trim().equals(""))
		{
			getCallerList();
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (config.highlightPile() && callers != null)
		{
			for (Player p : client.getPlayers())
			{
				for (String name : callers)
				{
					Actor pile;
					String finalName = name.toLowerCase().replace("_", " ");
					if (p.getName().toLowerCase().replace("_", " ").equals(finalName))
					{
						pile = p.getInteracting();
						if (pile != null)
						{
							pileList.set(callers.indexOf(name), pile.getName());
							//pileList.add(pile.getName());
						}
						else
						{
							pileList.set(callers.indexOf(name), "");
						}
					}
				}
			}
		}
	}

	@Subscribe
	public void onClanMemberJoined(ClanMemberJoined event)
	{
		getCallerList();
	}

	@Subscribe
	public void onClanMemberLeft(ClanMemberLeft event)
	{
		getCallerList();
	}

	private void getCallerList()
	{
		callers.clear();
		if (config.useClanchatRanks() && client.getClanMembers() != null)
		{
			for (ClanMember clanMember : client.getClanMembers())
			{
				if (clanMember.getRank().getValue() > config.callerRank().getValue())
				{
					callers.add(clanMember.getUsername());
				}
			}
		}
		if (config.callers().contains(","))
		{
			callers.addAll(Arrays.asList(config.callers().split(",")));
		}
		else
		{
			if (!config.callers().equals("") || config.callers().length() > 1)
			{
				callers.add(config.callers());
			}
		}
		pileList = Arrays.asList(new String[callers.size()]);
	}

	boolean isCaller(Player player)
	{
		if (callers != null)
		{
			for (String name : callers)
			{
				String finalName = name.toLowerCase().replace("_", " ");
				if (player.getName().toLowerCase().replace("_", " ").equals(finalName))
				{
					return true;
				}
			}
		}

		return false;
	}

	boolean isPile(Player player)
	{
		if (Objects.nonNull(pileList) && pileList.size() > 0)
		{
			return pileList.contains(player.getName());
		}
		return false;
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded)
	{
		int type = menuEntryAdded.getType();

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
			Player[] players = client.getCachedPlayers();
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

			if (config.colorPlayerMenu() && client.isFriended(player.getName(), false))
			{
				color = config.getFriendColor();
			}
			else if (config.colorPlayerMenu() && player.isClanMember())
			{
				color = config.getClanMemberColor();

				ClanMemberRank rank = clanManager.getRank(player.getName());
				if (rank != UNRANKED)
				{
					image = clanManager.getIconNumber(rank);
				}
			}
			else if (config.colorPlayerMenu() && player.getTeam() > 0 && localPlayer.getTeam() == player.getTeam())
			{
				color = config.getTeamMemberColor();
			}
			else if (config.highlightNonClanMembers() && !player.isClanMember() && !player.isFriend() && !PvPUtil.isAttackable(client, player))
			{
				color = config.getNonClanMemberColor();
			}
			else if (config.colorPlayerMenu() && !player.isClanMember() && client.isFriended(player.getName(), false) && PvPUtil.isAttackable(client, player))
			{
				color = config.getTargetColor();
			}
			else if (config.colorPlayerMenu() && PvPUtil.isAttackable(client, player) && !player.isClanMember() && !player.isFriend())
			{
				color = config.getTargetColor();
			}
/*			if (config.rightClickOverhead() && !player.isClanMember() && player.getOverheadIcon() != null)
			{
				if (player.getOverheadIcon().equals(HeadIcon.MAGIC))
				{
					image = 29;
				}
				else if (player.getOverheadIcon().equals(HeadIcon.RANGED))
				{
					image = 30;
				}
				else if (player.getOverheadIcon().equals(HeadIcon.MELEE))
				{
					image = 31;
				}
				else if (player.getOverheadIcon().equals(HeadIcon.REDEMPTION))
				{
					image = 32;
				}
				else if (player.getOverheadIcon().equals(HeadIcon.RETRIBUTION))
				{
					image = 33;
				}
				else if (player.getOverheadIcon().equals(HeadIcon.SMITE))
				{
					image = 34;
				}
			}*/
			if (config.playerSkull() && !player.isClanMember() && player.getSkullIcon() != null)
			{
				image2 = 35;
			}
			if (config.colorPlayerMenu() && config.highlightCallers() && this.isCaller(player))
			{
				color = config.callerColor();
			}
			if (config.colorPlayerMenu() && config.highlightPile() && this.isPile(player))
			{
				color = config.pileColor();
			}
			if (image != -1 || color != null)
			{
				MenuEntry[] menuEntries = client.getMenuEntries();
				MenuEntry lastEntry = menuEntries[menuEntries.length - 1];


				if (color != null && config.colorPlayerMenu())
				{
					// strip out existing <col...
					String target = lastEntry.getTarget();
					int idx = target.indexOf('>');
					if (idx != -1)
					{
						target = target.substring(idx + 1);
					}

					lastEntry.setTarget(ColorUtil.prependColorTag(target, color));
				}
				
/*				if (image != -1 && config.showClanRanks() || image != -1 && config.rightClickOverhead())
				{
					lastEntry.setTarget(lastEntry.getTarget() + "<img=" + image + ">");
				}*/
				if (image2 != -1 && config.playerSkull())
				{
					lastEntry.setTarget("<img=" + image2 + ">" + lastEntry.getTarget());
				}

				client.setMenuEntries(menuEntries);
			}
		}
	}

	public enum MinimapSkullLocations
	{
		BEFORE_NAME,
		AFTER_NAME
	}
}
