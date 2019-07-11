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

import java.util.Random;

public class InstrumentDefinition
{
	public AudioEnvelopeDefinition volume;
	public AudioEnvelopeDefinition pitchModifier;
	public AudioEnvelopeDefinition field1175;
	public AudioEnvelopeDefinition release;
	public AudioEnvelopeDefinition volumeMultiplier;
	public AudioEnvelopeDefinition volumeMultiplierAmplitude;
	public AudioEnvelopeDefinition pitchModifierAmplitude;
	public AudioEnvelopeDefinition pitch;

	public int[] oscillatorDelays = new int[]
			{
					0, 0, 0, 0, 0
			};
	public int[] oscillatorPitch = new int[]
			{
					0, 0, 0, 0, 0
			};
	public int[] oscillatorVolume = new int[]
			{
					0, 0, 0, 0, 0
			};

	public SoundEffectDefinition filter;
	public AudioEnvelopeDefinition filterEnvelope;

	static int[] samples = new int[220500];

	static int[] NOISE = new int[32768];
	static int[] AUDIO_SINE = new int[32768];

	static int[] phases = new int[5];
	static int[] delays = new int[5];

	static int[] volumeSteps = new int[5];
	static int[] pitchSteps = new int[5];
	static int[] pitchBaseSteps = new int[5];

	public int duration = 500;
	public int delayDecay = 100;
	public int delayTime = 0;
	public int offset = 0;

	static
	{
		Random random = new Random(0);

		for (int i = 0; i < 32768; ++i)
		{
			InstrumentDefinition.NOISE[i] = (random.nextInt() & 2) - 1;
			InstrumentDefinition.AUDIO_SINE[i] = (int) (Math.sin((double) i / 5215.1903) * 16384.0);
		}
	}

	public final int[] synthesize(int var1, int var2)
	{
		int var16;
		int var15;
		int var14;
		int var11;
		int var12;
		int var13;

		InstrumentDefinition.method3854(samples, 0, var1);

		if (var2 < 10)
		{
			return samples;
		}

		double var3 = (double) var1 / ((double) var2 + 0.0);

		this.pitch.reset();
		this.volume.reset();

		int var5 = 0;
		int var6 = 0;
		int var7 = 0;

		if (this.pitchModifier != null)
		{
			this.pitchModifier.reset();
			this.pitchModifierAmplitude.reset();

			var5 = (int) ((double) (this.pitchModifier.end - this.pitchModifier.start) * 32.768 / var3);
			var6 = (int) ((double) this.pitchModifier.start * 32.768 / var3);
		}

		int var8 = 0;
		int var9 = 0;
		int var10 = 0;

		if (this.volumeMultiplier != null)
		{
			this.volumeMultiplier.reset();
			this.volumeMultiplierAmplitude.reset();

			var8 = (int) ((double) (this.volumeMultiplier.end - this.volumeMultiplier.start) * 32.768 / var3);
			var9 = (int) ((double) this.volumeMultiplier.start * 32.768 / var3);
		}

		for (var11 = 0; var11 < 5; ++var11)
		{
			if (this.oscillatorVolume[var11] == 0)
			{
				continue;
			}

			InstrumentDefinition.phases[var11] = 0;
			InstrumentDefinition.delays[var11] = (int) ((double) this.oscillatorDelays[var11] * var3);
			InstrumentDefinition.volumeSteps[var11] = (this.oscillatorVolume[var11] << 14) / 100;
			InstrumentDefinition.pitchSteps[var11] = (int) ((double) (this.pitch.end - this.pitch.start) * 32.768 * Math.pow(1.0057929410678534, this.oscillatorPitch[var11]) / var3);
			InstrumentDefinition.pitchBaseSteps[var11] = (int) ((double) this.pitch.start * 32.768 / var3);
		}

		for (var11 = 0; var11 < var1; ++var11)
		{
			var12 = this.pitch.step(var1);
			var13 = this.volume.step(var1);

			if (this.pitchModifier != null)
			{
				var14 = this.pitchModifier.step(var1);
				var15 = this.pitchModifierAmplitude.step(var1);
				var12 += this.evaluateWave(var7, var15, this.pitchModifier.form) >> 1;
				var7 = var7 + var6 + (var14 * var5 >> 16);
			}

			if (this.volumeMultiplier != null)
			{
				var14 = this.volumeMultiplier.step(var1);
				var15 = this.volumeMultiplierAmplitude.step(var1);
				var13 = var13 * ((this.evaluateWave(var10, var15, this.volumeMultiplier.form) >> 1) + 32768) >> 15;
				var10 = var10 + var9 + (var14 * var8 >> 16);
			}

			for (var14 = 0; var14 < 5; ++var14)
			{
				if (this.oscillatorVolume[var14] == 0 || (var15 = delays[var14] + var11) >= var1)
				{
					continue;
				}

				int[] arrn = samples;
				int n = var15;
				arrn[n] = arrn[n] + this.evaluateWave(phases[var14], var13 * volumeSteps[var14] >> 15, this.pitch.form);
				int[] arrn2 = phases;
				int n2 = var14;
				arrn2[n2] = arrn2[n2] + ((var12 * pitchSteps[var14] >> 16) + pitchBaseSteps[var14]);
			}
		}

		if (this.release != null)
		{
			this.release.reset();
			this.field1175.reset();

			var11 = 0;
			boolean var20 = true;

			for (var14 = 0; var14 < var1; ++var14)
			{
				var15 = this.release.step(var1);
				var16 = this.field1175.step(var1);
				var12 = var20 ? (var15 * (this.release.end - this.release.start) >> 8) + this.release.start : (var16 * (this.release.end - this.release.start) >> 8) + this.release.start;
				if ((var11 += 256) >= var12)
				{
					var11 = 0;
				}
				if (!var20)
				{
					continue;
				}
				InstrumentDefinition.samples[var14] = 0;
			}
		}
		if (this.delayTime > 0 && this.delayDecay > 0)
		{
			for (var12 = var11 = (int) ((double) this.delayTime * var3); var12 < var1; ++var12)
			{
				int[] arrn = samples;
				int n = var12;

				arrn[n] = arrn[n] + samples[var12 - var11] * this.delayDecay / 100;
			}
		}
		if (this.filter.pairs[0] > 0 || this.filter.pairs[1] > 0)
		{
			this.filterEnvelope.reset();

			var11 = this.filterEnvelope.step(var1 + 1);
			var12 = this.filter.compute(0, (float) var11 / 65536.0f);
			var13 = this.filter.compute(1, (float) var11 / 65536.0f);

			if (var1 >= var12 + var13)
			{
				int var17;

				var14 = 0;
				var15 = var13;

				if (var13 > var1 - var12)
				{
					var15 = var1 - var12;
				}

				while (var14 < var15)
				{
					var16 = (int) ((long) samples[var14 + var12] * (long) SoundEffectDefinition.fowardMultiplier >> 16);

					for (var17 = 0; var17 < var12; ++var17)
					{
						var16 += (int) ((long) samples[var14 + var12 - 1 - var17] * (long) SoundEffectDefinition.coefficients[0][var17] >> 16);
					}

					for (var17 = 0; var17 < var14; ++var17)
					{
						var16 -= (int) ((long) samples[var14 - 1 - var17] * (long) SoundEffectDefinition.coefficients[1][var17] >> 16);
					}

					InstrumentDefinition.samples[var14] = var16;
					var11 = this.filterEnvelope.step(var1 + 1);
					++var14;
				}
				var15 = 128;

				do
				{
					int var18;

					if (var15 > var1 - var12)
					{
						var15 = var1 - var12;
					}

					while (var14 < var15)
					{
						var17 = (int) ((long) samples[var14 + var12] * (long) SoundEffectDefinition.fowardMultiplier >> 16);

						for (var18 = 0; var18 < var12; ++var18)
						{
							var17 += (int) ((long) samples[var14 + var12 - 1 - var18] * (long) SoundEffectDefinition.coefficients[0][var18] >> 16);
						}

						for (var18 = 0; var18 < var13; ++var18)
						{
							var17 -= (int) ((long) samples[var14 - 1 - var18] * (long) SoundEffectDefinition.coefficients[1][var18] >> 16);
						}

						InstrumentDefinition.samples[var14] = var17;
						var11 = this.filterEnvelope.step(var1 + 1);
						++var14;
					}
					if (var14 >= var1 - var12)
					{
						while (var14 < var1)
						{
							var17 = 0;
							for (var18 = var14 + var12 - var1; var18 < var12; ++var18)
							{
								var17 += (int) ((long) samples[var14 + var12 - 1 - var18]
										* (long) SoundEffectDefinition.coefficients[0][var18] >> 16);
							}
							for (var18 = 0; var18 < var13; ++var18)
							{
								var17 -= (int) ((long) samples[var14 - 1 - var18]
										* (long) SoundEffectDefinition.coefficients[1][var18] >> 16);
							}
							InstrumentDefinition.samples[var14] = var17;
							this.filterEnvelope.step(var1 + 1);
							++var14;
						}
						break;
					}
					var12 = this.filter.compute(0, (float) var11 / 65536.0f);
					var13 = this.filter.compute(1, (float) var11 / 65536.0f);
					var15 += 128;
				}
				while (true);
			}
		}
		for (var11 = 0; var11 < var1; ++var11)
		{
			if (samples[var11] < -32768)
			{
				InstrumentDefinition.samples[var11] = -32768;
			}

			if (samples[var11] <= 32767)
			{
				continue;
			}

			InstrumentDefinition.samples[var11] = 32767;
		}

		return samples;
	}

	private static void method3854(int[] var1, int var2, int var3)
	{
		var3 = var3 + var2 - 7;

		while (var2 < var3)
		{
			var1[var2++] = 0;
			var1[var2++] = 0;
			var1[var2++] = 0;
			var1[var2++] = 0;
			var1[var2++] = 0;
			var1[var2++] = 0;
			var1[var2++] = 0;
			var1[var2++] = 0;
		}

		while (var2 < (var3 += 7))
		{
			var1[var2++] = 0;
		}
	}

	public final int evaluateWave(int var1, int var2, int var3)
	{
		return var3 == 1 ? ((var1 & 32767) < 16384 ? var2 : -var2) : (var3 == 2 ? AUDIO_SINE[var1 & 32767] * var2 >> 14 : (var3 == 3 ? (var2 * (var1 & 32767) >> 14) - var2 : (var3 == 4 ? var2 * NOISE[var1 / 2607 & 32767] : 0)));
	}
}

