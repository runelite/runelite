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
import net.runelite.client.util.PvPUtil;

@Singleton
public class PlayerIndicatorsService
{
	private final Client client;
	private final PlayerIndicatorsConfig config;
	private final PlayerIndicatorsPlugin playerIndicatorsPlugin;

	@Inject
	private PlayerIndicatorsService(Client client, PlayerIndicatorsConfig config, PlayerIndicatorsPlugin plugin)
	{
		this.config = config;
		this.client = client;
		this.playerIndicatorsPlugin = plugin;
	}

	public void forEachPlayer(final BiConsumer<Player, Color> consumer)
	{
		if (!config.highlightOwnPlayer() && !config.drawClanMemberNames()
			&& !config.highlightFriends() && !config.highlightNonClanMembers() && !config.highlightTargets()
		&& !config.highlightPile() && !config.highlightCallers() && !config.highlightTeamMembers())
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
				if (config.highlightOwnPlayer())
				{
					consumer.accept(player, config.getOwnPlayerColor());
				}
			}
			else if (config.highlightFriends() && client.isFriended(player.getName(), false))
			{
				consumer.accept(player, config.getFriendColor());
			}
			else if (config.drawClanMemberNames() && isClanMember)
			{
				consumer.accept(player, config.getClanMemberColor());
			}
			else if (config.highlightTeamMembers() && localPlayer.getTeam() > 0 &&
				localPlayer.getTeam() == player.getTeam())
			{
				consumer.accept(player, config.getTeamMemberColor());
			}
			else if (config.highlightNonClanMembers() && !isClanMember)
			{
				consumer.accept(player, config.getNonClanMemberColor());
			}
			else if (config.highlightTargets() && PvPUtil.isAttackable(client, player) &&
				!client.isFriended(player.getName(), false) && !player.isClanMember())
			{
			    if (config.skulledTargetsOnly() && player.getSkullIcon() != null)
                {
                    consumer.accept(player, config.getTargetColor());
                }
			    else if (!config.skulledTargetsOnly())
                {
                    consumer.accept(player, config.getTargetColor());
                }
			}
			if (config.highlightCallers() && config.callers() != null && playerIndicatorsPlugin.isCaller(player))
			{
				consumer.accept(player, config.callerColor());
			}
			if (config.highlightPile() && playerIndicatorsPlugin.isPile(player)
				&& !player.isClanMember())
			{
				consumer.accept(player, config.pileColor());
			}
		}
	}
}
