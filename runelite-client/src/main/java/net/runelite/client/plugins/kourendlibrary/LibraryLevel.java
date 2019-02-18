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
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;

public enum LibraryLevel
{
	GROUND_FLOOR("ground floor"),
	MIDDLE_FLOOR("middle floor"),
	TOP_FLOOR("top floor");

	@Getter
	private String name;

	LibraryLevel(String name)
	{
		this.name = name;
	}

	public boolean canReachOtherSections()
	{
		switch (this)
		{
			case GROUND_FLOOR:
				return true;
			case MIDDLE_FLOOR:
				return false;
			case TOP_FLOOR:
				return true;
		}

		return false;
	}

	public int getPlane()
	{
		switch (this)
		{
			case GROUND_FLOOR:
				return 0;
			case MIDDLE_FLOOR:
				return 1;
			case TOP_FLOOR:
				return 2;
		}

		return -1;
	}

	@Nullable
	public static LibraryLevel getLevel(@Nonnull WorldPoint location)
	{
		switch (location.getPlane())
		{
			case 0:
				return GROUND_FLOOR;
			case 1:
				return MIDDLE_FLOOR;
			case 2:
				return TOP_FLOOR;
			default:
				return null;
		}
	}

	@Nullable
	public static LibraryLevel maxLevel()
	{
		return Arrays.stream(values())
			.max(Comparator.comparingInt(LibraryLevel::getPlane))
			.orElse(null);
	}

	@Nullable
	public static LibraryLevel minLevel()
	{
		return Arrays.stream(values())
			.min(Comparator.comparingInt(LibraryLevel::getPlane))
			.orElse(null);
	}
}
