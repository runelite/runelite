/*
 * Copyright (c) 2018, cw-dev
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
package net.runelite.client.plugins.castlewars.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@AllArgsConstructor
@Getter
public enum CWBase
{
	ZAM_BASE(CWArea.ZAM_4TH, CWArea.ZAM_3RD, CWArea.ZAM_SPAWN, CWArea.ZAM_GROUND),
	SARA_BASE(CWArea.SARA_4TH, CWArea.SARA_3RD, CWArea.SARA_SPAWN, CWArea.SARA_GROUND);

	private final CWArea fourth;
	private final CWArea third;
	private final CWArea spawn;
	private final CWArea ground;

	public static CWBase match(WorldPoint point)
	{
		CWArea area = CWArea.match(point);

		if (ZAM_BASE.getFourth().equals(area) ||
			ZAM_BASE.getThird().equals(area) ||
			ZAM_BASE.getSpawn().equals(area) ||
			ZAM_BASE.getGround().equals(area))
		{
			return ZAM_BASE;
		}

		if (SARA_BASE.getFourth().equals(area) ||
			SARA_BASE.getThird().equals(area) ||
			SARA_BASE.getSpawn().equals(area) ||
			SARA_BASE.getGround().equals(area))
		{
			return SARA_BASE;
		}

		return null;
	}


}
