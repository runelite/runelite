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
package net.runelite.cache.definitions.sound;

public class SoundEffectDefinition
{
	public int[][][] phases = new int[2][2][4];
	public int[] pairs = new int[2];
	public int[] unity = new int[2];
	public int[][][] magnitudes = new int[2][2][4];

	public static float[][] minCoefficients = new float[2][8];
	public static int[][] coefficients = new int[2][8];
	public static float fowardMinCoefficientMultiplier;
	public static int fowardMultiplier;

	public int compute(int var1, float var2)
	{
		float var3;
		int var4;

		if (var1 == 0)
		{
			var3 = (float) this.unity[0] + (float) (this.unity[1] - this.unity[0]) * var2;

			fowardMinCoefficientMultiplier = (float) Math.pow(0.1, (var3 *= 0.0030517578f) / 20.0f);
			fowardMultiplier = (int) (fowardMinCoefficientMultiplier * 65536.0f);
		}

		if (this.pairs[var1] == 0)
		{
			return 0;
		}

		var3 = this.interpolateMagniture(var1, 0, var2);

		minCoefficients[var1][0] = -2.0f * var3 * (float) Math.cos(this.interpolatePhase(var1, 0, var2));
		minCoefficients[var1][1] = var3 * var3;

		for (var4 = 1; var4 < this.pairs[var1]; ++var4)
		{
			var3 = this.interpolateMagniture(var1, var4, var2);

			float var5 = -2.0f * var3 * (float) Math.cos(this.interpolatePhase(var1, var4, var2));
			float var6 = var3 * var3;

			minCoefficients[var1][var4 * 2 + 1] = minCoefficients[var1][var4 * 2 - 1] * var6;
			minCoefficients[var1][var4 * 2] = minCoefficients[var1][var4 * 2 - 1] * var5 + minCoefficients[var1][var4 * 2 - 2] * var6;

			for (int var7 = var4 * 2 - 1; var7 >= 2; --var7)
			{
				float[] arrf = minCoefficients[var1];
				int n = var7;

				arrf[n] = arrf[n] + (minCoefficients[var1][var7 - 1] * var5 + minCoefficients[var1][var7 - 2] * var6);
			}

			float[] arrf = minCoefficients[var1];
			arrf[1] = arrf[1] + (minCoefficients[var1][0] * var5 + var6);

			float[] arrf2 = minCoefficients[var1];
			arrf2[0] = arrf2[0] + var5;
		}

		if (var1 == 0)
		{
			var4 = 0;
			while (var4 < this.pairs[0] * 2)
			{
				float[] arrf = minCoefficients[0];
				int n = var4++;

				arrf[n] = arrf[n] * fowardMinCoefficientMultiplier;
			}
		}

		for (var4 = 0; var4 < this.pairs[var1] * 2; ++var4)
		{
			coefficients[var1][var4] = (int) (minCoefficients[var1][var4] * 65536.0f);
		}

		return this.pairs[var1] * 2;
	}

	public float interpolateMagniture(int var1, int var2, float var3)
	{
		float var4 = (float) this.magnitudes[var1][0][var2] + var3 * (float) (this.magnitudes[var1][1][var2] - this.magnitudes[var1][0][var2]);

		return 1.0f - (float) Math.pow(10.0, (-(var4 *= 0.0015258789f)) / 20.0f);
	}

	public float interpolatePhase(int var1, int var2, float var3)
	{
		float var4 = (float) this.phases[var1][0][var2] + var3 * (float) (this.phases[var1][1][var2] - this.phases[var1][0][var2]);

		return normalise(var4 *= 1.2207031E-4f);
	}

	public static float normalise(float var1)
	{
		float var2 = 32.703197f * (float) Math.pow(2.0, var1);

		return var2 * 3.1415927f / 11025.0f;
	}
}