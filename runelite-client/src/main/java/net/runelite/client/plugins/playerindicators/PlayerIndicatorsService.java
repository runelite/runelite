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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.util.PvPUtil;

@Singleton
public class PlayerIndicatorsService
{
	private final Client client;
	private final PlayerIndicatorsPlugin plugin;

	private final Predicate<Player> self;
	private final Predicate<Player> friend;
	private final Predicate<Player> clan;
	private final Predicate<Player> team;
	private final Predicate<Player> target;
	private final Predicate<Player> other;
	private final Predicate<Player> caller;
	private final Predicate<Player> callerTarget;
	private final List<Actor> piles = new ArrayList<>();

	@Inject
	private PlayerIndicatorsService(final Client client, final PlayerIndicatorsPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;

		self = (player) -> client.getLocalPlayer().equals(player);
		friend = (player) -> (!player.equals(client.getLocalPlayer()) && client.isFriended(player.getName(), false));
		clan = (player) -> (player.isClanMember() && !client.isFriended(player.getName(), false));
		team = (player) -> (Objects.requireNonNull(client.getLocalPlayer()).getTeam() != 0 && !player.isClanMember()
			&& !client.isFriended(player.getName(), false) &&
			client.getLocalPlayer().getTeam() == player.getTeam());
		target = (player) -> (!team.test(player) && !clan.test(player)
			&& !friend.test(player) && PvPUtil.isAttackable(client, player) && !self.test(player));
		caller = plugin::isCaller;
		callerTarget = piles::contains;
		other = (player) ->
			(!PvPUtil.isAttackable(client, player) && !team.test(player) && !clan.test(player) && !friend.test(player));

	}

	public void forEachPlayer(final BiConsumer<Player, PlayerRelation> consumer)
	{
		if (!highlight())
		{
			return;
		}

		piles.clear();

		final List<Player> players = client.getPlayers();
		for (Player p : players)
		{
			if (self.test(p) && plugin.getLocationHashMap().containsKey(PlayerRelation.SELF))
			{
				consumer.accept(p, PlayerRelation.SELF);
				continue;
			}
			if (friend.test(p) && plugin.getLocationHashMap().containsKey(PlayerRelation.FRIEND))
			{
				consumer.accept(p, PlayerRelation.FRIEND);
				continue;
			}
			if (clan.test(p) && plugin.getLocationHashMap().containsKey(PlayerRelation.CLAN))
			{
				consumer.accept(p, PlayerRelation.CLAN);
				continue;
			}
			if (team.test(p) && plugin.getLocationHashMap().containsKey(PlayerRelation.TEAM))
			{
				consumer.accept(p, PlayerRelation.TEAM);
				continue;
			}
			if (target.test(p) && plugin.getLocationHashMap().containsKey(PlayerRelation.TARGET))
			{
				consumer.accept(p, PlayerRelation.TARGET);
				continue;
			}
			if (caller.test(p) && plugin.getLocationHashMap().containsKey(PlayerRelation.CALLER))
			{
				consumer.accept(p, PlayerRelation.CALLER);
				continue;
			}
			if (callerTarget.test(p) && plugin.getLocationHashMap().containsKey(PlayerRelation.CALLER_TARGET))
			{
				consumer.accept(p, PlayerRelation.CALLER_TARGET);
				continue;
			}
			if (other.test(p) && plugin.getLocationHashMap().containsKey(PlayerRelation.OTHER))
			{
				consumer.accept(p, PlayerRelation.OTHER);
			}
		}
}

	private boolean highlight()
	{
		return plugin.isHighlightOwnPlayer() || plugin.isHighlightClan()
			|| plugin.isHighlightFriends() || plugin.isHighlightOther() || plugin.isHighlightTargets()
			|| plugin.isHighlightCallers() || plugin.isHighlightTeam() || plugin.isHighlightCallerTargets();
	}
}