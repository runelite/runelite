/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * An enumeration of possible instance templates and the area they occupy.
 */
@AllArgsConstructor
public enum InstanceTemplates
{
	RAIDS_LOBBY(3264, 5184, 0, 96, 32),
	RAIDS_START(3264, 5696, 0, 96, 32),
	RAIDS_END(3264, 5152, 0, 64, 32),
	RAIDS_SCAVENGERS(3264, 5216, 0, 96, 32),
	RAIDS_SHAMANS(3264, 5248, 0, 96, 32),
	RAIDS_VASA(3264, 5280, 0, 96, 32),
	RAIDS_VANGUARDS(3264, 5312, 0, 96, 32),
	RAIDS_ICE_DEMON(3264, 5344, 0, 96, 32),
	RAIDS_THIEVING(3264, 5376, 0, 96, 32),
	RAIDS_FARMING(3264, 5440, 0, 96, 32),
	RAIDS_SCAVENGERS2(3264, 5216, 1, 96, 32),
	RAIDS_MUTTADILES(3264, 5312, 1, 96, 32),
	RAIDS_MYSTICS(3264, 5248, 1, 96, 32),
	RAIDS_TEKTON(3264, 5280, 1, 96, 32),
	RAIDS_TIGHTROPE(3264, 5344, 1, 96, 32),
	RAIDS_FARMING2(3264, 5440, 1, 96, 32),
	RAIDS_GUARDIANS(3264, 5248, 2, 96, 32),
	RAIDS_VESPULA(3264, 5280, 2, 96, 32),
	RAIDS_CRABS(3264, 5344, 2, 96, 32);

	/**
	 * The base x-axis coordinate of the instance area.
	 */
	@Getter
	private final int baseX;

	/**
	 * The base y-axis coordinate of the instance area.
	 */
	@Getter
	private final int baseY;

	/**
	 * The plane the instance is on.
	 */
	@Getter
	private final int plane;

	/**
	 * The width of the instance area.
	 */
	@Getter
	private final int width;

	/**
	 * The height of the instance area.
	 */
	@Getter
	private final int height;

	/**
	 * Matches chunk data of an instance to the instance it belongs.
	 *
	 * @param chunkData the chunk data
	 * @return the instance the chunk is in
	 */
	public static InstanceTemplates findMatch(int chunkData)
	{
		int rotation = chunkData >> 1 & 0x3; //unused, but shows us the rotation of the chunk
		int y = (chunkData >> 3 & 0x7FF) * 8;
		int x = (chunkData >> 14 & 0x3FF) * 8;
		int plane = chunkData >> 24 & 0x3;

		for (InstanceTemplates template : InstanceTemplates.values())
		{
			if (plane == template.getPlane()
					&& x >= template.getBaseX() && x < template.getBaseX() + template.getWidth()
					&& y >= template.getBaseY() && y < template.getBaseY() + template.getHeight())
			{
				return template;
			}
		}

		return null;
	}
}
