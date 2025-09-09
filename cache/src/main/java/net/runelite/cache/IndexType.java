/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

package net.runelite.cache;

public enum IndexType
{
	ANIMATIONS(0),
	SKELETONS(1),
	CONFIGS(2),
	INTERFACES(3),
	SOUNDEFFECTS(4),
	MAPS(5),
	MUSIC_TRACKS(6),
	MODELS(7),
	SPRITES(8),
	TEXTURES(9),
	BINARY(10),
	MUSIC_JINGLES(11),
	CLIENTSCRIPT(12),
	FONTS(13),
	MUSIC_SAMPLES(14),
	MUSIC_PATCHES(15),
	WORLDMAP_GEOGRAPHY(18),
	WORLDMAP(19),
	WORLDMAP_GROUND(20),
	DBTABLEINDEX(21),
	ANIMAYAS(22),
	GAMEVALS(24);

	private int id;

	IndexType(int id)
	{
		this.id = id;
	}

	public int getNumber()
	{
		return id;
	}
}