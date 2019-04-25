/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.http.service.worlds;

import net.runelite.http.api.worlds.WorldType;

enum ServiceWorldType
{
	MEMBERS(WorldType.MEMBERS, 1),
	PVP(WorldType.PVP, 1 << 2),
	BOUNTY(WorldType.BOUNTY, 1 << 5),
	SKILL_TOTAL(WorldType.SKILL_TOTAL, 1 << 7),
	HIGH_RISK(WorldType.HIGH_RISK, 1 << 10),
	LAST_MAN_STANDING(WorldType.LAST_MAN_STANDING, 1 << 14),
	TOURNAMENT(WorldType.TOURNAMENT, 1 << 25),
	DEADMAN_TOURNAMENT(WorldType.DEADMAN_TOURNAMENT, 1 << 26),
	DEADMAN(WorldType.DEADMAN, 1 << 29),
	SEASONAL_DEADMAN(WorldType.SEASONAL_DEADMAN, 1 << 30);

	private final WorldType apiType;
	private final int mask;

	ServiceWorldType(WorldType apiType, int mask)
	{
		this.apiType = apiType;
		this.mask = mask;
	}

	public WorldType getApiType()
	{
		return apiType;
	}

	public int getMask()
	{
		return mask;
	}
}
