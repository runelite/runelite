/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.game;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.eventbus.Subscribe;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ClanMember;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Client;
import net.runelite.api.events.ClanChanged;
import net.runelite.client.util.Text;

@Singleton
@Slf4j
public class ClanManager
{
	@Inject
	private Provider<Client> clientProvider;

	private final LoadingCache<String, ClanMemberRank> clanRanksCache = CacheBuilder.newBuilder()
		.maximumSize(100)
		.expireAfterWrite(1, TimeUnit.MINUTES)
		.build(new CacheLoader<String, ClanMemberRank>()
		{
			@Override
			public ClanMemberRank load(String key) throws Exception
			{
				final Client client = clientProvider.get();
				final ClanMember[] clanMembersArr = client.getClanMembers();

				if (clanMembersArr == null || clanMembersArr.length == 0)
				{
					return ClanMemberRank.UNRANKED;
				}

				return Arrays.stream(clanMembersArr)
					.filter(Objects::nonNull)
					.filter(clanMember -> sanitize(clanMember.getUsername()).equals(sanitize(key)))
					.map(ClanMember::getRank)
					.findAny()
					.orElse(ClanMemberRank.UNRANKED);
			}
		});

	public ClanMemberRank getRank(String playerName)
	{
		return clanRanksCache.getUnchecked(playerName);
	}

	@Subscribe
	public void onClanChange(ClanChanged clanChanged)
	{
		clanRanksCache.invalidateAll();
	}

	private static String sanitize(String lookup)
	{
		final String cleaned = Text.removeTags(lookup);
		return cleaned.replace('\u00A0', ' ');
	}
}
