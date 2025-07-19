/*
 * Copyright (c) 2024, YvesW <https://github.com/YvesW>
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
package net.runelite.client.plugins.timersandbuffs;

import java.awt.Color;
import java.util.function.BiPredicate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.SpriteID;

@Getter(AccessLevel.PACKAGE)
@AllArgsConstructor
enum GameCounter
{
	BURN_DAMAGE_ACCUMULATED(SpriteID.Hitmark.BURN_DAMAGE, GameTimerImageType.SPRITE, "Burn damage accumulated"),
	BURN_DAMAGE_NEXT_HIT(ItemID.BONE_CLAW, GameTimerImageType.ITEM, "Burn damage next hit"),
	COLOSSEUM_DOOM(SpriteID.Hitmark.COLOSSEUM_DOOM, GameTimerImageType.SPRITE, "Doom"),
	CURSE_OF_THE_MOONS_BLUE(ItemID.FROST_MOON_HELM, GameTimerImageType.ITEM, "Curse of the Moons (Blue Moon)", ColorBoundaryType.GREATER_THAN_EQUAL_TO, 18, Color.RED),
	CURSE_OF_THE_MOONS_ECLIPSE(ItemID.ECLIPSE_MOON_HELM, GameTimerImageType.ITEM, "Curse of the Moons (Eclipse Moon)"),
	STONE_OF_JAS_EMPOWERMENT(ItemID.WGS_STONE_OF_JAS_DUMMY_ITEM, GameTimerImageType.ITEM, "Stone of Jas empowerment", false),
	VENGEANCE_ACTIVE(SpriteID.LunarMagicOn.VENGEANCE_OTHER, GameTimerImageType.SPRITE, "Vengeance active", false),
	;

	private final int imageId;
	private final GameTimerImageType imageType;
	private final String description;
	private final ColorBoundaryType colorBoundaryType;
	private final int boundary;
	private final Color color;
	private final boolean shouldDisplayCount;

	GameCounter(int imageId, GameTimerImageType idType, String description, ColorBoundaryType colorBoundaryType, int boundary, Color color)
	{
		this(imageId, idType, description, colorBoundaryType, boundary, color, true);
	}

	GameCounter(int imageId, GameTimerImageType idType, String description, boolean shouldDisplayCount)
	{
		this(imageId, idType, description, ColorBoundaryType.NO_BOUNDARY, 0, Color.WHITE, shouldDisplayCount);
	}

	GameCounter(int imageId, GameTimerImageType idType, String description)
	{
		this(imageId, idType, description, ColorBoundaryType.NO_BOUNDARY, 0, Color.WHITE, true);
	}

	@AllArgsConstructor
	enum ColorBoundaryType
	{
		GREATER_THAN_EQUAL_TO((count, boundary) -> count >= boundary),
		LESS_THAN_EQUAL_TO((count, boundary) -> count <= boundary),
		NO_BOUNDARY((count, boundary) -> false);

		final BiPredicate<Integer, Integer> shouldRecolorPredicate;

		boolean shouldRecolor(int count, int boundary)
		{
			return shouldRecolorPredicate.test(count, boundary);
		}
	}
}
