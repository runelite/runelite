/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import java.util.HashMap;
import java.util.Map;

public enum ClanMemberRank
{
	UNRANKED((byte) -1),
	FRIEND((byte) 0),
	RECRUIT((byte) 1),
	CORPORAL((byte) 2),
	SERGEANT((byte) 3),
	LIEUTENANT((byte) 4),
	CAPTAIN((byte) 5),
	GENERAL((byte) 6),
	OWNER((byte) 7);

	private static final Map<Byte, ClanMemberRank> BYTE_TO_RANK = new HashMap<>();

	static
	{
		for (final ClanMemberRank clanMemberRank : ClanMemberRank.values())
		{
			BYTE_TO_RANK.put(clanMemberRank.value, clanMemberRank);
		}
	}

	public static ClanMemberRank valueOf(byte rank)
	{
		return BYTE_TO_RANK.get(rank);
	}

	private final byte value;

	ClanMemberRank(final byte value)
	{
		this.value = value;
	}

	public byte getValue()
	{
		return value;
	}
}
