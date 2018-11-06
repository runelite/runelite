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
package net.runelite.client.plugins.twitch;

/**
 * @author JBerben
 */
public enum TwitchBadges
{
	// NAME_OF_BADGE(badgeTag, imgCode, badgeCode);
	NO_BADGE("null", 0, 0),
	ONE_MONTH_SUB("subscriber", 9, 1),
	THREE_MONTH_SUB("subscriber", 8, 2),
	SIX_MONTH_SUB("subscriber", 7, 3),
	ONE_YEAR_SUB("subscriber", 6, 4),
	TWO_YEAR_SUB("subscriber", 5, 5),
	THREE_YEAR_SUB("subscriber", 4, 6),
	MOD("moderator", 0, 1),
	BROADCASTER("broadcaster", 1, 1),
	TWITCH_PRIME("prime", 25, 1),
	TWITCH_TURBO("turbo", 12, 1)
	;

	private final String badgeType;
	private final int imgCode;
	private final int ircCode;

	private TwitchBadges(String badgeTag, int imageId, int ircId)
	{
		badgeType = badgeTag;
		imgCode = imageId;
		ircCode = ircId;
	}

	static TwitchBadges getCodeGivenRank(String badgeTag, int rank)
	{
		for (TwitchBadges badge : TwitchBadges.values())
		{
			if (badge.getBadgeType().equalsIgnoreCase(badgeTag) && badge.getIrcCode() == rank)
			{
				return badge;
			}
		}
		return NO_BADGE;
	}

	public String getBadgeType()
	{
		return badgeType;
	}

	public int getImgCode()
	{
		return imgCode;
	}

	public int getIrcCode()
	{
		return ircCode;
	}
}