/*
 * Copyright (c) 2018, Daniel Teo <https://github.com/takuyakanbr>
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
package net.runelite.client.plugins.timetracking.hunter;

import java.awt.Color;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;

@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
enum BirdHouseState
{
	SEEDED(ColorScheme.PROGRESS_COMPLETE_COLOR),
	BUILT(ColorScheme.PROGRESS_INPROGRESS_COLOR),
	EMPTY(ColorScheme.MEDIUM_GRAY_COLOR),
	UNKNOWN(ColorScheme.MEDIUM_GRAY_COLOR);

	private final Color color;

	/**
	 * Gets the {@code BirdHouseState} corresponding to the given {@code VarPlayer} value.
	 */
	static BirdHouseState fromVarpValue(int varp)
	{
		if (varp < 0 || varp > BirdHouse.values().length * 3)
		{
			return UNKNOWN;
		}
		else if (varp == 0)
		{
			return EMPTY;
		}
		else if (varp % 3 == 0)
		{
			return SEEDED;
		}
		else
		{
			return BUILT;
		}
	}
}
