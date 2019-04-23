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
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.Varbits;


import static net.runelite.client.plugins.playerindicators.PlayerIndicatorsPlugin.calculateWildernessLevel;

@Singleton
public class PlayerIndicatorsService {
	private final Client client;
	private final PlayerIndicatorsConfig config;

	@Inject
	private PlayerIndicatorsService(Client client, PlayerIndicatorsConfig config) {
		this.config = config;
		this.client = client;
	}

	public void forEachPlayer(final BiConsumer<Player, Color> consumer) {

		if (config.showInWildernessOnly() && client.getVar(Varbits.IN_THE_WILDERNESS) != 1)
		{
			return;
		}

		if (!config.highlightOwnPlayer() && !config.drawClanMemberNames()
				&& !config.highlightFriends() && !config.highlightNonClanMembers()
				&& !config.highlightAttackablePlayers() && !config.highlightAttackerPlayers()) {
			return;
		}

		final Player localPlayer = client.getLocalPlayer();

		for (Player player : client.getPlayers()) {
			if (player == null || player.getName() == null) {
				continue;
			}

			boolean isClanMember = player.isClanMember();

			if (player == localPlayer) {
				if (config.highlightOwnPlayer()) {
					consumer.accept(player, config.getOwnPlayerColor());
				}
			} else if (config.highlightFriends() && (player.isFriend() || client.isFriended(player.getName(), false))) {
				consumer.accept(player, config.getFriendColor());
			} else if (config.drawClanMemberNames() && isClanMember) {
				consumer.accept(player, config.getClanMemberColor());
			} else if (config.highlightTeamMembers() && localPlayer.getTeam() > 0 && localPlayer.getTeam() == player.getTeam()) {
				consumer.accept(player, config.getTeamMemberColor());
			} else if (config.highlightNonClanMembers() && !isClanMember) {
				consumer.accept(player, config.getNonClanMemberColor());
            } else if (config.highlightAttackerPlayers() && player.getInteracting() == localPlayer) {
                consumer.accept(player, config.getAttackerPlayerColor());
			} else if (config.highlightAttackablePlayers() && isWithinLevelRange(player.getCombatLevel())) {
                consumer.accept(player, config.getAttackablePlayerColor());
            }
		}
	}

	public boolean isWithinLevelRange(int playerCombatLevel)
	{
		Widget levelRangeWidget = client.getWidget(WidgetInfo.PVP_ATTACK_RANGE);
		Widget wildernessLevelWidget = client.getWidget(WidgetInfo.PVP_WILDERNESS_LEVEL);

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
}
