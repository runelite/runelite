/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
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
package net.runelite.client.plugins.objectindicators;

import java.awt.Color;
import javax.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.runelite.api.ObjectComposition;
import net.runelite.api.TileObject;

/**
 * Used to denote marked objects and their colors.
 * Note: This is not used for serialization of object indicators; see {@link ObjectPoint}
 */
@Value
@RequiredArgsConstructor
class ColorTileObject
{
	static final int HF_HULL = 0x1;
	static final int HF_OUTLINE = 0x2;
	static final int HF_CLICKBOX = 0x4;
	static final int HF_TILE = 0x8;

	private final TileObject tileObject;
	/**
	 * Non-transformed object composition for the object
	 */
	private final ObjectComposition composition;
	/**
	 * Name to highlight for multilocs
	 */
	private final String name;
	@Nullable
	private final Color borderColor;
	@Nullable
	private final Color fillColor;
	byte highlightFlags;
}
