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

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.*;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ClanManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import java.awt.Color;
import static net.runelite.api.ClanMemberRank.UNRANKED;
import static net.runelite.api.MenuAction.*;



@PluginDescriptor(
	name = "Player Indicators",
	description = "Highlight players on-screen and/or on the minimap",
	tags = {"highlight", "minimap", "overlay", "players"}
)
public class PlayerIndicatorsPlugin extends Plugin
{

	// Option added to Player menu
	private static final String TAG = "Tag";
	private static final String KICK_OPTION = "Kick";
	private static final ImmutableList<String> AFTER_OPTIONS = ImmutableList.of("Message", "Add ignore", "Remove friend", KICK_OPTION);

	@Inject
	private Provider<MenuManager> menuManager;

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

	@Inject
	private PlayerIndicatorsInput inputListener;

	@Inject
	private KeyManager keyManager;

	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed = false;

	static final Set<String> highlightedPlayersNames = new HashSet<>();

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
		keyManager.registerKeyListener(inputListener);
		highlightedPlayersNames.clear();

	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(playerIndicatorsOverlay);
		overlayManager.remove(playerIndicatorsTileOverlay);
		overlayManager.remove(playerIndicatorsMinimapOverlay);
		keyManager.unregisterKeyListener(inputListener);
		highlightedPlayersNames.clear();

	}

	@Subscribe
	public void onPlayerMenuOptionClicked(PlayerMenuOptionClicked playerMenuOptionClicked)
	{
		if(playerMenuOptionClicked.getMenuOption().equals(TAG))
		{
			if(highlightedPlayersNames.contains(Text.sanitize(playerMenuOptionClicked.getMenuTarget())))
			{
				highlightedPlayersNames.remove(Text.sanitize(playerMenuOptionClicked.getMenuTarget()));
			}
			else
			{
				highlightedPlayersNames.add(Text.sanitize(playerMenuOptionClicked.getMenuTarget()));

			}

		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded) {

		int type = menuEntryAdded.getType();

		if (type == MenuAction.TRADE.getId() && hotKeyPressed && config.highlightSpecificNames())
		{
			// Add tag option
			MenuEntry[] menuEntries = client.getMenuEntries();
			menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);
			final MenuEntry tagEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();
			tagEntry.setOption(TAG);
			tagEntry.setTarget(menuEntryAdded.getTarget());
			tagEntry.setIdentifier(menuEntryAdded.getIdentifier());
			tagEntry.setType(MenuAction.RUNELITE.getId());
			client.setMenuEntries(menuEntries);
		}

		if (type >= 2000) {
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
				|| type == RUNELITE.getId()) {
			final Player localPlayer = client.getLocalPlayer();
			Player[] players = client.getCachedPlayers();
			Player player = null;

			if (identifier >= 0 && identifier < players.length) {
				player = players[identifier];
			}

			if (player == null) {
				return;
			}

			int image = -1;
			Color color = null;

			if (config.highlightFriends() && player.isFriend()) {
				color = config.getFriendColor();
			} else if (config.drawClanMemberNames() && player.isClanMember()) {
				color = config.getClanMemberColor();

				ClanMemberRank rank = clanManager.getRank(player.getName());
				if (rank != UNRANKED) {
					image = clanManager.getIconNumber(rank);
				}
			} else if (config.highlightTeamMembers() && player.getTeam() > 0 && localPlayer.getTeam() == player.getTeam()) {
				color = config.getTeamMemberColor();
			} else if (config.highlightNonClanMembers() && !player.isClanMember()) {
				color = config.getNonClanMemberColor();
			}

			if (image != -1 || color != null) {
				MenuEntry[] menuEntries = client.getMenuEntries();
				MenuEntry lastEntry = menuEntries[menuEntries.length - 1];

				if (color != null && config.colorPlayerMenu()) {
					// strip out existing <col...
					String target = lastEntry.getTarget();
					int idx = target.indexOf('>');
					if (idx != -1) {
						target = target.substring(idx + 1);
					}

					lastEntry.setTarget(ColorUtil.prependColorTag(target, color));
				}

				if (image != -1 && config.showClanRanks()) {
					lastEntry.setTarget("<img=" + image + ">" + lastEntry.getTarget());
				}

				client.setMenuEntries(menuEntries);
			}
		}
	}
}
