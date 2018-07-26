/*
 * Copyright (c) 2018, Sir Girion <https://github.com/sirgirion>
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
package net.runelite.client.plugins.blowpipetracker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@AllArgsConstructor
@Getter
enum AttractorDefinition
{
	ATTRACTOR(ItemID.AVAS_ATTRACTOR, 0.2f, 0.16f, 0.64f),
	ACCUMULATOR(ItemID.AVAS_ACCUMULATOR, 0.2f, 0.08f, 0.72f),
	ACCUMULATOR_MAX_CAPE(ItemID.AVAS_ACCUMULATOR, 0.2f, 0.08f, 0.72f),
	ACCUMULATOR_RANGE_CAPE(ItemID.RANGING_CAPE, 0.2f, 0.08f, 0.72f),
	ASSEMBLER(ItemID.AVAS_ASSEMBLER, 0.2f, 0.0f, 0.8f),
	ASSEMBLER_MAX_CAPE(ItemID.AVAS_ACCUMULATOR, 0.2f, 0.08f, 0.72f);

	private int itemId;
	private float breakOnImpactChance;
	private float dropToFloorChance;
	private float savedChance;

	static AttractorDefinition getAttractorById(int itemId)
	{
		for (AttractorDefinition attractorDefinition : values())
		{
			if (attractorDefinition.getItemId() == itemId)
			{
				return attractorDefinition;
			}
		}

		return null;
	}
}
