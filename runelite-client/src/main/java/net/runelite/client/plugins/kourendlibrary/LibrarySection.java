/*
 * Copyright (c) 2019 Koekkruimels
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
package net.runelite.client.plugins.kourendlibrary;

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

import javax.annotation.Nonnull;

public enum LibrarySection
{
	NORTH_WEST("Northwest"),
	NORTH_EAST("Northeast"),
	SOUTH_WEST("Southwest"),
	CENTER("center");

	@Getter
	private String name;

	LibrarySection(String name)
	{
		this.name = name;
	}

	@Nonnull
	public static LibrarySection getSection(@Nonnull WorldPoint location)
	{
		boolean north;
		boolean west;

		if (location.getPlane() == 0)
		{
			north = location.getY() > 3813;
			west = location.getX() < 1627;
		}
		else
		{
			north = location.getY() > 3815;
			west = location.getX() < 1625;
		}

		if (north && west)
		{
			return NORTH_WEST;
		}
		else if (north)
		{
			return NORTH_EAST;
		}
		else if (west)
		{
			return SOUTH_WEST;
		}
		else
		{
			return CENTER;
		}
	}
}
