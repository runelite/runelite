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
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@Singleton
public class PlayerIndicatorsService
{
	private final Client client;
	private final PlayerIndicatorsConfig config;

	@Inject
	private PlayerIndicatorsService(Client client, PlayerIndicatorsConfig config)
	{
		this.config = config;
		this.client = client;
	}

	public void forEachPlayer(final BiConsumer<Player, Color> consumer)
	{
		if (!config.drawOwnName() && !config.drawClanMemberNames()
			&& !config.drawFriendNames() && !config.drawNonClanMemberNames() && !config.drawAttackableNames())
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
				if (config.drawOwnName())
				{
					consumer.accept(player, config.getOwnNameColor());
				}
			}
			else if (config.drawFriendNames() && player.isFriend())
			{
				consumer.accept(player, config.getFriendNameColor());
			}
			else if (config.drawClanMemberNames() && isClanMember)
			{
				consumer.accept(player, config.getClanMemberColor());
			}
			else if (config.drawTeamMemberNames() && localPlayer.getTeam() > 0 && localPlayer.getTeam() == player.getTeam())
			{
				consumer.accept(player, config.getTeamMemberColor());
			}
			else if (config.drawNonClanMemberNames() && !isClanMember)
			{
				consumer.accept(player, config.getNonClanMemberColor());
			}
			else if (config.drawAttackableNames() && isWithinLevelRange(player.getCombatLevel()))
			{
				consumer.accept(player, config.getAttackableNameColor());
			}
		}
	}

	public boolean isWithinLevelRange(int playerCombatLevel)
	{
		Widget levelRangeWidget = client.getWidget(WidgetInfo.COMBAT_AREA_LEVEL_RANGE);
		Widget wildernessLevelWidget = client.getWidget(WidgetInfo.COMBAT_AREA_WILDERNESS_LEVEL);

		int localPlayerLevel = client.getLocalPlayer().getCombatLevel();
		int lowerLevelBound = localPlayerLevel - 15;
		int upperLevelBound = localPlayerLevel + 15;

		if (levelRangeWidget == null && wildernessLevelWidget == null)
		{
			return false;
		}
		if (!levelRangeWidget.isHidden() && !wildernessLevelWidget.isHidden())
		{
			lowerLevelBound = Integer.parseInt(levelRangeWidget.getText().split("-")[0]);
			upperLevelBound = Integer.parseInt(levelRangeWidget.getText().split("-")[1]);
			return (playerCombatLevel >= lowerLevelBound && playerCombatLevel <= upperLevelBound);
		}
		else if (levelRangeWidget.isHidden() && !wildernessLevelWidget.isHidden())
		{
			int wildernessLevel = calculateWildernessLevel(client.getLocalPlayer().getWorldLocation());
			lowerLevelBound = localPlayerLevel - wildernessLevel;
			upperLevelBound = localPlayerLevel + wildernessLevel;
			return (playerCombatLevel >= lowerLevelBound && playerCombatLevel <= upperLevelBound);
		}
		else
		{
			return (playerCombatLevel >= lowerLevelBound && playerCombatLevel <= upperLevelBound);
		}
	}

	public int calculateWildernessLevel(WorldPoint userLocation)
	{
		int wildernessLevel = 0;
		if (isInsideWilderness(new WorldPoint(2944, 3520, 0), new WorldPoint(3391, 4351, 3), userLocation))
		{
			wildernessLevel = ((userLocation.getY() - (55 * 64)) / 8) + 1;
		}
		else if (isInsideWilderness(new WorldPoint(3008, 10112, 0), new WorldPoint(3071, 10175, 3), userLocation))
		{
			wildernessLevel = ((userLocation.getY() - (155 * 64)) / 8) - 1;
		}
		else if (isInsideWilderness(new WorldPoint(2944, 9920, 0), new WorldPoint(3391, 10879, 3), userLocation))
		{
			wildernessLevel = ((userLocation.getY() - (155 * 64)) / 8) + 1;
		}
		return wildernessLevel;
	}

	public boolean isInsideWilderness(WorldPoint lowerBound, WorldPoint upperBound, WorldPoint userLocation)
	{
		if (userLocation.getX() < lowerBound.getX() || userLocation.getX() > upperBound.getX())
		{
			return false;
		}
		if (userLocation.getY() < lowerBound.getY() || userLocation.getY() > upperBound.getY())
		{
			return false;
		}
		if (userLocation.getPlane() < lowerBound.getPlane() || userLocation.getPlane() > upperBound.getPlane())
		{
			return false;
		}
		return true;
	}

}
