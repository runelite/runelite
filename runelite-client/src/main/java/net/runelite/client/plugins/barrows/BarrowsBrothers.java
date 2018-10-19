/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.barrows;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;

@RequiredArgsConstructor
public enum BarrowsBrothers
{
	AHRIM("Ahrim", new WorldPoint(3566, 3289, 0), Varbits.BARROWS_KILLED_AHRIM,
			new WorldPoint(3562, 3286, 0), new WorldPoint(3567, 3292, 0)),
	DHAROK("Dharok", new WorldPoint(3575, 3298, 0), Varbits.BARROWS_KILLED_DHAROK,
			new WorldPoint(3572, 3295, 0), new WorldPoint(3577, 3300, 0)),
	GUTHAN("Guthan", new WorldPoint(3576, 3282, 0), Varbits.BARROWS_KILLED_GUTHAN,
			new WorldPoint(3574, 3280, 0), new WorldPoint(3580, 3284, 0)),
	KARIL("Karil", new WorldPoint(3566, 3276, 0), Varbits.BARROWS_KILLED_KARIL,
			new WorldPoint(3563, 3273, 0), new WorldPoint(3569, 3279, 0)),
	TORAG("Torag", new WorldPoint(3554, 3283, 0), Varbits.BARROWS_KILLED_TORAG,
			new WorldPoint(3552, 3281, 0), new WorldPoint(3555, 3284, 0)),
	VERAC("Verac", new WorldPoint(3557, 3298, 0), Varbits.BARROWS_KILLED_VERAC,
			new WorldPoint(3555, 3295, 0), new WorldPoint(3559, 3300, 0));
	@Getter
	private final String name;
	@Getter
	private final WorldPoint location;
	@Getter
	private final Varbits killedVarbit;
	@Getter
	private final WorldPoint digLocationStart;
	@Getter
	private final WorldPoint digLocationEnd;
}
