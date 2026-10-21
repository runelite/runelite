/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import java.util.EnumSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter(onMethod_ = @Override)
public enum FishingBonus implements SkillBonus
{
	ANGLERS_OUTFIT("Angler's Outfit", 1.025f),
	DIABOLIC_WORMS("Diabolic Worms", 0.66f),
	SHARK_LURE_1("Shark Lure x1", 0.25f),
	SHARK_LURE_3("Shark Lure x3", 0.2f),
	SHARK_LURE_5("Shark Lure x5", 0.16f)
	;

	private final String name;
	private final float value;

	@Override
	public Set<FishingBonus> getCanBeStackedWith()
	{
		switch (this)
		{
			case SHARK_LURE_1:
			case SHARK_LURE_3:
			case SHARK_LURE_5:
				return EnumSet.complementOf(EnumSet.of(
					SHARK_LURE_1,
					SHARK_LURE_3,
					SHARK_LURE_5
				));
			default:
				return EnumSet.complementOf(EnumSet.of(this));
		}
	}
}
