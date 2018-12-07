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

import java.awt.Color;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Player;

@Singleton
public class PlayerIndicatorsService
{
	private final Client client;
	private final PlayerIndicatorsConfig config;

	private boolean highlightOwnPlayer;
	private boolean highlightFriends;
	private boolean drawClanMemberNames;
	private boolean highlightNonClanMembers;
	private boolean highlightTeamMembers;

	private Color ownPlayerColor;
	private Color friendColor;
	private Color clanMemberColor;
	private Color teamMemberColor;
	private Color nonClanMemberColor;

	@Inject
	private PlayerIndicatorsService(Client client, PlayerIndicatorsConfig config)
	{
		this.config = config;
		this.client = client;
	}

	public void updateConfig()
	{
		this.highlightOwnPlayer = config.highlightOwnPlayer();
		this.highlightFriends = config.highlightFriends();
		this.drawClanMemberNames = config.drawClanMemberNames();
		this.highlightNonClanMembers = config.highlightNonClanMembers();
		this.highlightTeamMembers = config.highlightTeamMembers();
		this.ownPlayerColor = config.getOwnPlayerColor();
		this.friendColor = config.getFriendColor();
		this.clanMemberColor = config.getClanMemberColor();
		this.teamMemberColor = config.getTeamMemberColor();
		this.nonClanMemberColor = config.getNonClanMemberColor();
	}

	public void forEachPlayer(final BiConsumer<Player, Color> consumer)
	{
		if (!highlightOwnPlayer && !drawClanMemberNames && !highlightFriends&& !highlightNonClanMembers)
		{
			return;
		}

		final Player localPlayer = client.getLocalPlayer();

		for (Player player : client.getPlayers())
		{
			if (player == null || player.getName() == null)
			{
				continue;
			}

			boolean isClanMember = player.isClanMember();

			if (player == localPlayer)
			{
				if (highlightOwnPlayer)
				{
					consumer.accept(player, ownPlayerColor);
				}
			}
			else if (highlightFriends && player.isFriend())
			{
				consumer.accept(player, friendColor);
			}
			else if (drawClanMemberNames && isClanMember)
			{
				consumer.accept(player, this.clanMemberColor);
			}
			else if (highlightTeamMembers && localPlayer.getTeam() > 0 && localPlayer.getTeam() == player.getTeam())
			{
				consumer.accept(player, teamMemberColor);
			}
			else if (highlightNonClanMembers && !isClanMember)
			{
				consumer.accept(player, nonClanMemberColor);
			}
		}
	}
}
