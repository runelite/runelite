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

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;

@AllArgsConstructor
@Getter
public enum CWArea
{
	ZAM_4TH(WorldArea.fromCoords(2369, 3134, 2373, 3130, 3)),
	ZAM_3RD(WorldArea.fromCoords(2368, 3135, 2376, 3127, 2)),
	ZAM_SPAWN(WorldArea.fromCoords(2368, 3135, 2379, 3124, 1)),
	ZAM_GROUND(WorldArea.fromCoords(2368, 3135, 2384, 3120, 0)),
	ZAM_UND_LADDER(new WorldArea(2369, 9526, 1, 1, 0)),

	SARA_4TH(WorldArea.fromCoords(2426, 3077, 2430, 3073, 3)),
	SARA_3RD(WorldArea.fromCoords(2423, 3081, 2431, 3072, 2)),
	SARA_SPAWN(WorldArea.fromCoords(2420, 3083, 2431, 3072, 1)),
	SARA_GROUND(WorldArea.fromCoords(2415, 3087, 2431, 3072, 0)),
	SARA_UND_LADDER(new WorldArea(2430, 9481, 1, 1, 0)),

	NORTH_ROCKS(WorldArea.fromCoords(2418, 3125, 2420, 3123, 0)),
	SOUTH_ROCKS(WorldArea.fromCoords(2377, 3088, 2378, 3084, 0));

	private final WorldArea area;

	public static CWArea match(WorldPoint point)
	{
		return Arrays.stream(CWArea.values())
			.filter(cwArea -> cwArea.getArea().intersectsWith(new WorldArea(point, 1, 1)))
			.findFirst()
			.orElse(null);
	}

}
