/*
 * Copyright (c) 2025, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.gpu;

import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * The depth order of static faces depends only on camera direction. Share this
 * cache with temporary copies of a model rendered from a neighboring zone.
 */
final class AlphaFaceSorter
{
	final int radius;
	private final int[] packedFaces;
	private char[] sortedFaces;
	private boolean directionInitialized, cacheValid;
	private int lastYawSin, lastYawCos, lastPitchSin, lastPitchCos;

	AlphaFaceSorter(int radius, int[] packedFaces)
	{
		this.radius = radius;
		this.packedFaces = packedFaces;
	}

	int faceCount()
	{
		return packedFaces.length;
	}

	void writeIndices(int yawSin, int yawCos, int pitchSin, int pitchCos, char[] head, char[] tail, char[] next, IntBuffer output, int start)
	{
		boolean sameDirection = directionInitialized
			&& yawSin == lastYawSin && yawCos == lastYawCos
			&& pitchSin == lastPitchSin && pitchCos == lastPitchCos;
		if (sameDirection && cacheValid)
		{
			for (char face : sortedFaces)
			{
				putFace(output, face, start);
			}
			return;
		}

		int diameter = 1 + radius * 2;
		Arrays.fill(head, 0, diameter, (char) -1);

		for (char i = 0; i < packedFaces.length; ++i)
		{
			int pack = packedFaces[i];
			int x = pack >> 21;
			int y = (pack << 11) >> 22;
			int z = (pack << 21) >> 21;

			int t = z * yawCos - x * yawSin >> 16;
			int depth = (y * pitchSin + t * pitchCos >> 16) + radius;
			assert depth >= 0 && depth < diameter : depth;

			if (head[depth] == (char) -1)
			{
				head[depth] = i;
			}
			else
			{
				next[tail[depth]] = i;
			}
			tail[depth] = i;
			next[i] = (char) -1;
		}

		// Populate the cache only after the camera direction repeats. While the
		// camera is rotating, emit directly without the additional cache writes.
		if (sameDirection)
		{
			if (sortedFaces == null)
			{
				sortedFaces = new char[packedFaces.length];
			}
			int offset = 0;
			for (int depth = diameter - 1; depth >= 0; --depth)
			{
				for (char face = head[depth]; face != (char) -1; face = next[face])
				{
					sortedFaces[offset++] = face;
					putFace(output, face, start);
				}
			}
		}
		else
		{
			for (int depth = diameter - 1; depth >= 0; --depth)
			{
				for (char face = head[depth]; face != (char) -1; face = next[face])
				{
					putFace(output, face, start);
				}
			}
		}

		cacheValid = sameDirection;
		directionInitialized = true;
		lastYawSin = yawSin;
		lastYawCos = yawCos;
		lastPitchSin = pitchSin;
		lastPitchCos = pitchCos;
	}

	private static void putFace(IntBuffer output, int face, int start)
	{
		int faceIdx = face * 3 + start;
		output.put(faceIdx++);
		output.put(faceIdx++);
		output.put(faceIdx);
	}
}
