/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.driftnet;

import java.util.Set;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.runelite.api.GameObject;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;

@Data
@RequiredArgsConstructor
class DriftNet
{
	private final int objectId;
	private final Varbits statusVarbit;
	private final Varbits countVarbit;
	private final Set<WorldPoint> adjacentTiles;

	private GameObject net;
	private DriftNetStatus status;
	private int count;
	@Setter
	private DriftNetStatus prevTickStatus;

	// Nets that are not accepting fish are those currently not accepting, or those which were not
	// accepting in the previous tick. (When a fish shoal is 2 tiles adjacent to a drift net and is
	// moving to a net that is just being setup it will be denied even though the net is currently
	// in the CATCHING status)
	boolean isNotAcceptingFish()
	{
		return (status != DriftNetStatus.CATCH && status != DriftNetStatus.SET) ||
			(prevTickStatus != DriftNetStatus.CATCH && prevTickStatus != DriftNetStatus.SET);
	}

	String getFormattedCountText()
	{
		return status != DriftNetStatus.UNSET ? count + "/10" : "";
	}
}
