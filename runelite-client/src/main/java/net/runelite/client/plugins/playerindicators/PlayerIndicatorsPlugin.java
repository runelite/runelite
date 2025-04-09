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

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.FriendsChatRank;
import static net.runelite.api.FriendsChatRank.UNRANKED;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.ITEM_USE_ON_PLAYER;
import static net.runelite.api.MenuAction.PLAYER_EIGHTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIFTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIRST_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FOURTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SECOND_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SEVENTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SIXTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_THIRD_OPTION;
import static net.runelite.api.MenuAction.RUNELITE_PLAYER;
import static net.runelite.api.MenuAction.WALK;
import static net.runelite.api.MenuAction.WIDGET_TARGET_ON_PLAYER;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.ScriptID;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.game.ChatIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;

@PluginDescriptor(
	name = "Player Indicators",
	description = "Highlight players on-screen and/or on the minimap",
	tags = {"highlight", "minimap", "overlay", "players"}
)
@Slf4j
public class PlayerIndicatorsPlugin extends Plugin
{
	private static final String TRADING_WITH_TEXT = "Trading with: ";

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
	private PlayerIndicatorsService playerIndicatorsService;

	@Inject
	private Client client;

	@Inject
	private ChatIconManager chatIconManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

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
		migrate();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(playerIndicatorsOverlay);
		overlayManager.remove(playerIndicatorsTileOverlay);
		overlayManager.remove(playerIndicatorsMinimapOverlay);
	}

	@Subscribe
	public void onProfileChanged(ProfileChanged profileChanged)
	{
		migrate();
	}

	private void migrate()
	{
		String[] keys = {
			"drawOwnName", "highlightSelf",
			"drawPartyMembers", "highlightPartyMembers",
			"drawFriendNames", "highlightFriends",
			"drawClanMemberNames", "highlightFriendsChat",
			"drawTeamMemberNames", "highlightTeamMembers",
			"drawClanChatMemberNames", "highlightClanMembers",
			"drawNonClanMemberNames", "highlightOthers"
		};

		Boolean disableOutsidePvP = configManager.getConfiguration(PlayerIndicatorsConfig.GROUP, "disableOutsidePvP", Boolean.class);
		if (disableOutsidePvP != null)
		{
			configManager.unsetConfiguration(PlayerIndicatorsConfig.GROUP, "disableOutsidePvP");

			for (int i = 0; i < keys.length; i += 2)
			{
				String old = keys[i];
				String new_ = keys[i + 1];

				Boolean value = configManager.getConfiguration(PlayerIndicatorsConfig.GROUP, old, Boolean.class);
				if (value != null)
				{
					PlayerIndicatorsConfig.HighlightSetting newSetting;
					if (disableOutsidePvP && value)
					{
						newSetting = PlayerIndicatorsConfig.HighlightSetting.PVP;
					}
					else if (value)
					{
						newSetting = PlayerIndicatorsConfig.HighlightSetting.ENABLED;
					}
					else
					{
						newSetting = PlayerIndicatorsConfig.HighlightSetting.DISABLED;
					}

					configManager.setConfiguration(PlayerIndicatorsConfig.GROUP, new_, newSetting);
					configManager.unsetConfiguration(PlayerIndicatorsConfig.GROUP, old);
				}
			}

			log.debug("Migrated player indicators config");
		}
	}

	@Subscribe
	public void onClientTick(ClientTick clientTick)
	{
		if (client.isMenuOpen())
		{
			return;
		}

		MenuEntry[] menuEntries = client.getMenuEntries();

		for (MenuEntry entry : menuEntries)
		{
			MenuAction type = entry.getType();

			if (type == WALK
				|| type == WIDGET_TARGET_ON_PLAYER
				|| type == ITEM_USE_ON_PLAYER
				|| type == PLAYER_FIRST_OPTION
				|| type == PLAYER_SECOND_OPTION
				|| type == PLAYER_THIRD_OPTION
				|| type == PLAYER_FOURTH_OPTION
				|| type == PLAYER_FIFTH_OPTION
				|| type == PLAYER_SIXTH_OPTION
				|| type == PLAYER_SEVENTH_OPTION
				|| type == PLAYER_EIGHTH_OPTION
				|| type == RUNELITE_PLAYER)
			{
				Player player = entry.getPlayer();
				if (player == null)
				{
					continue;
				}

				PlayerIndicatorsService.Decorations decorations = playerIndicatorsService.getDecorations(player);
				if (decorations == null)
				{
					continue;
				}

				String oldTarget = entry.getTarget();
				String newTarget = decorateTarget(oldTarget, decorations);

				entry.setTarget(newTarget);
			}
		}
	}

	@VisibleForTesting
	String decorateTarget(String oldTarget, PlayerIndicatorsService.Decorations decorations)
	{
		String newTarget = oldTarget;

		if (decorations.getColor() != null && config.colorPlayerMenu())
		{
			String prefix = "";
			int idx = oldTarget.indexOf("->");
			if (idx != -1)
			{
				prefix = oldTarget.substring(0, idx + 3); // <col=ff9040>Earth rune</col><col=ff> ->
				oldTarget = oldTarget.substring(idx + 3);
			}

			// <col=ff0000>title0RuneLitetitle1<col=ff>  (level-126)title2
			idx = oldTarget.indexOf('>');
			// remove leading <col>
			oldTarget = oldTarget.substring(idx + 1);

			newTarget = prefix + ColorUtil.prependColorTag(oldTarget, decorations.getColor());
		}

		FriendsChatRank rank = decorations.getFriendsChatRank();
		int image = -1;
		if (rank != null && rank != UNRANKED && config.showFriendsChatRanks())
		{
			image = chatIconManager.getIconNumber(rank);
		}
		else if (decorations.getClanTitle() != null && config.showClanChatRanks())
		{
			image = chatIconManager.getIconNumber(decorations.getClanTitle());
		}

		if (image != -1)
		{
			newTarget = "<img=" + image + ">" + newTarget;
		}

		return newTarget;
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.TRADE_MAIN_INIT)
		{
			clientThread.invokeLater(() ->
			{
				Widget tradeTitle = client.getWidget(InterfaceID.Trademain.TITLE);
				String header = tradeTitle.getText();
				String playerName = header.substring(TRADING_WITH_TEXT.length());

				Player targetPlayer = findPlayer(playerName);
				if (targetPlayer == null)
				{
					return;
				}

				PlayerIndicatorsService.Decorations decorations = playerIndicatorsService.getDecorations(targetPlayer);
				if (decorations != null && decorations.getColor() != null)
				{
					tradeTitle.setText(TRADING_WITH_TEXT + ColorUtil.wrapWithColorTag(playerName, decorations.getColor()));
				}
			});
		}
	}

	private Player findPlayer(String name)
	{
		for (Player player : client.getPlayers())
		{
			if (player.getName().equals(name))
			{
				return player;
			}
		}
		return null;
	}
}
