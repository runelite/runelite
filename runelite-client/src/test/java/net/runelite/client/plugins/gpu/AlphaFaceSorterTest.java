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
import java.util.Random;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AlphaFaceSorterTest
{
	private final char[] head = new char[6000];
	private final char[] tail = new char[6000];
	private final char[] next = new char[8192];

	@Test
	public void matchesStableDepthSort()
	{
		Random random = new Random(0xA1FA);
		for (int count : new int[]{0, 1, 2, 32, 256, 8192})
		{
			int[][] positions = new int[count][3];
			for (int[] position : positions)
			{
				position[0] = random.nextInt(2048) - 1024;
				position[1] = random.nextInt(1024) - 512;
				position[2] = random.nextInt(2048) - 1024;
			}
			AlphaFaceSorter sorter = sorter(1600, positions);
			assertEquals(count, sorter.faceCount());

			for (int i = 0; i < 64; ++i)
			{
				int[] direction = direction(random.nextInt(16384), random.nextInt(16384));
				assertArrayEquals(expected(positions, direction), sort(sorter, direction));
			}
		}
	}

	@Test
	public void retainsInputOrderAtEqualDepthAndSignedPackingBoundaries()
	{
		int[][] positions = {
			{-1024, -512, -1024}, {1023, 511, 1023},
			{1023, -512, -1024}, {-1024, 511, 1023},
			{0, 0, 0}, {0, 0, 0}
		};
		AlphaFaceSorter sorter = sorter(1600, positions);
		for (int yaw : new int[]{0, 4096, 8192, 12288, 16383})
		{
			for (int pitch : new int[]{0, 4096, 8192, 12288, 16383})
			{
				int[] direction = direction(yaw, pitch);
				assertArrayEquals(expected(positions, direction), sort(sorter, direction));
			}
		}
	}

	@Test
	public void reusesOrderWithoutDependingOnSharedScratchBuffers()
	{
		int[][] positions = {{0, 0, -20}, {0, 0, 20}, {10, 5, 0}};
		AlphaFaceSorter sorter = sorter(24, positions);
		int[] direction = direction(0, 0);
		sort(sorter, direction);
		char[] order = sort(sorter, direction);

		// Another model uses the same render thread's scratch buffers.
		AlphaFaceSorter other = sorter(2, new int[][]{{0, 0, 0}});
		sort(other, direction(8192, 2048));
		char[] savedHead = head.clone();
		char[] savedTail = tail.clone();
		char[] savedNext = next.clone();

		assertArrayEquals(order, sort(sorter, direction));
		assertArrayEquals(expected(positions, direction), order);
		assertArrayEquals(savedHead, head);
		assertArrayEquals(savedTail, tail);
		assertArrayEquals(savedNext, next);
	}

	@Test
	public void invalidatesOnEitherCameraAngleAndWhenCameraReturns()
	{
		int[][] positions = {{-10, -10, -10}, {10, 10, 10}, {10, -10, 10}, {-10, 10, -10}};
		AlphaFaceSorter sorter = sorter(20, positions);
		for (int[] direction : new int[][]{
			direction(0, 0), direction(8192, 0), direction(8192, 4096),
			direction(8192, 12288), direction(0, 0)})
		{
			for (int i = 0; i < 3; ++i)
			{
				// Miss, cache population, and cache hit, with changing buffer offsets.
				assertArrayEquals(expected(positions, direction), sort(sorter, direction, 123 + i * 30));
			}
		}
	}

	@Test
	public void includesBothDepthRangeBoundaries()
	{
		int[][] positions = {{0, 0, -2}, {0, 0, 2}, {0, 0, -2}};
		assertArrayEquals(new char[]{1, 0, 2}, sort(sorter(2, positions), direction(0, 0)));
	}

	private char[] sort(AlphaFaceSorter sorter, int[] direction)
	{
		return sort(sorter, direction, 123);
	}

	private char[] sort(AlphaFaceSorter sorter, int[] direction, int start)
	{
		IntBuffer output = IntBuffer.allocate(sorter.faceCount() * 3);
		sorter.writeIndices(direction[0], direction[1], direction[2], direction[3], head, tail, next, output, start);
		assertEquals(sorter.faceCount() * 3, output.position());
		char[] faces = new char[sorter.faceCount()];
		for (int i = 0; i < faces.length; ++i)
		{
			int first = output.get(i * 3);
			assertEquals(first + 1, output.get(i * 3 + 1));
			assertEquals(first + 2, output.get(i * 3 + 2));
			assertEquals(0, (first - start) % 3);
			faces[i] = (char) ((first - start) / 3);
		}
		return faces;
	}

	private static AlphaFaceSorter sorter(int radius, int[][] positions)
	{
		int[] packed = new int[positions.length];
		for (int i = 0; i < positions.length; ++i)
		{
			int[] p = positions[i];
			packed[i] = ((p[0] & 2047) << 21) | ((p[1] & 1023) << 11) | (p[2] & 2047);
		}
		return new AlphaFaceSorter(radius, packed);
	}

	private static int[] direction(int yaw, int pitch)
	{
		double unit = 3.834951969714103E-4D;
		return new int[]{
			(int) (65536.0 * Math.sin(yaw * unit)), (int) (65536.0 * Math.cos(yaw * unit)),
			(int) (65536.0 * Math.sin(pitch * unit)), (int) (65536.0 * Math.cos(pitch * unit))
		};
	}

	private static char[] expected(int[][] positions, int[] direction)
	{
		int[] depth = new int[positions.length];
		Integer[] faces = new Integer[positions.length];
		for (int i = 0; i < positions.length; ++i)
		{
			int[] p = positions[i];
			int t = (p[2] * direction[1] - p[0] * direction[0]) >> 16;
			depth[i] = (p[1] * direction[2] + t * direction[3]) >> 16;
			faces[i] = i;
		}
		// Object sorting is stable, preserving the original face order on ties.
		Arrays.sort(faces, (a, b) -> Integer.compare(depth[b], depth[a]));
		char[] result = new char[faces.length];
		for (int i = 0; i < faces.length; ++i)
		{
			result[i] = (char) (int) faces[i];
		}
		return result;
	}
}
