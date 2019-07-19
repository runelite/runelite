/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import java.util.Arrays;

/**
 * Based off of the implementation from
 * https://rosettacode.org/wiki/The_ISAAC_Cipher#Java Modified to not extend
 * java.util.Random, and return results in reverse order
 *
 * @author Adam
 */
public class RLISAACCipher
{
	private final int[] randResult = new int[256];    // output of last generation
	private int valuesLeft;                           // the number of values already left in randResult

	// internal generator state
	private final int[] mm = new int[256];
	private int aa, bb, cc;

	public RLISAACCipher(int[] key)
	{
		init(key);
	}

	private void generateMoreResults()
	{
		cc++;
		bb += cc;

		for (int i = 0; i < 256; i++)
		{
			int x = mm[i];
			switch (i & 3)
			{
				case 0:
					aa = aa ^ (aa << 13);
					break;
				case 1:
					aa = aa ^ (aa >>> 6);
					break;
				case 2:
					aa = aa ^ (aa << 2);
					break;
				case 3:
					aa = aa ^ (aa >>> 16);
					break;
			}
			aa = mm[i ^ 128] + aa;
			int y = mm[i] = mm[(x >>> 2) & 0xFF] + aa + bb;
			randResult[i] = bb = mm[(y >>> 10) & 0xFF] + x;
		}

		valuesLeft = 256;
	}

	private static void mix(int[] s)
	{
		s[0] ^= s[1] << 11;
		s[3] += s[0];
		s[1] += s[2];
		s[1] ^= s[2] >>> 2;
		s[4] += s[1];
		s[2] += s[3];
		s[2] ^= s[3] << 8;
		s[5] += s[2];
		s[3] += s[4];
		s[3] ^= s[4] >>> 16;
		s[6] += s[3];
		s[4] += s[5];
		s[4] ^= s[5] << 10;
		s[7] += s[4];
		s[5] += s[6];
		s[5] ^= s[6] >>> 4;
		s[0] += s[5];
		s[6] += s[7];
		s[6] ^= s[7] << 8;
		s[1] += s[6];
		s[7] += s[0];
		s[7] ^= s[0] >>> 9;
		s[2] += s[7];
		s[0] += s[1];
	}

	private void init(int[] seed)
	{
		if (seed != null && seed.length != 256)
		{
			seed = Arrays.copyOf(seed, 256);
		}
		aa = bb = cc = 0;
		int[] initState = new int[8];
		Arrays.fill(initState, 0x9e3779b9);	// the golden ratio

		for (int i = 0; i < 4; i++)
		{
			mix(initState);
		}

		for (int i = 0; i < 256; i += 8)
		{
			if (seed != null)
			{
				for (int j = 0; j < 8; j++)
				{
					initState[j] += seed[i + j];
				}
			}

			mix(initState);
			for (int j = 0; j < 8; j++)
			{
				mm[i + j] = initState[j];
			}
		}

		if (seed != null)
		{
			for (int i = 0; i < 256; i += 8)
			{
				for (int j = 0; j < 8; j++)
				{
					initState[j] += mm[i + j];
				}

				mix(initState);

				for (int j = 0; j < 8; j++)
				{
					mm[i + j] = initState[j];
				}
			}
		}

		valuesLeft = 0;	// Make sure generateMoreResults() will be called by the next nextInt() call.
	}

	public int nextInt()
	{
		if (valuesLeft == 0)
		{
			generateMoreResults();
			assert valuesLeft == 256;
		}

		int value = randResult[--valuesLeft];

		return value;
	}
}
