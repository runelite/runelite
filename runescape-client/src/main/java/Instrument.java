import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("Instrument")
public class Instrument {
	@ObfuscatedName("a")
	@Export("Instrument_samples")
	static int[] Instrument_samples;
	@ObfuscatedName("j")
	@Export("Instrument_noise")
	static int[] Instrument_noise;
	@ObfuscatedName("t")
	@Export("Instrument_sine")
	static int[] Instrument_sine;
	@ObfuscatedName("o")
	@Export("Instrument_phases")
	static int[] Instrument_phases;
	@ObfuscatedName("n")
	@Export("Instrument_delays")
	static int[] Instrument_delays;
	@ObfuscatedName("d")
	@Export("Instrument_volumeSteps")
	static int[] Instrument_volumeSteps;
	@ObfuscatedName("s")
	@Export("Instrument_pitchSteps")
	static int[] Instrument_pitchSteps;
	@ObfuscatedName("z")
	@Export("Instrument_pitchBaseSteps")
	static int[] Instrument_pitchBaseSteps;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("pitch")
	SoundEnvelope pitch;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("volume")
	SoundEnvelope volume;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("pitchModifier")
	SoundEnvelope pitchModifier;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("pitchModifierAmplitude")
	SoundEnvelope pitchModifierAmplitude;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("volumeMultiplier")
	SoundEnvelope volumeMultiplier;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("volumeMultiplierAmplitude")
	SoundEnvelope volumeMultiplierAmplitude;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("release")
	SoundEnvelope release;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("attack")
	SoundEnvelope attack;
	@ObfuscatedName("c")
	@Export("oscillatorVolume")
	int[] oscillatorVolume;
	@ObfuscatedName("f")
	@Export("oscillatorPitch")
	int[] oscillatorPitch;
	@ObfuscatedName("m")
	@Export("oscillatorDelays")
	int[] oscillatorDelays;
	@ObfuscatedName("u")
	@Export("delayTime")
	int delayTime;
	@ObfuscatedName("x")
	@Export("delayDecay")
	int delayDecay;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Ldy;"
	)
	@Export("filter")
	AudioFilter filter;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("filterEnvelope")
	SoundEnvelope filterEnvelope;
	@ObfuscatedName("y")
	@Export("duration")
	int duration;
	@ObfuscatedName("g")
	@Export("offset")
	int offset;

	static {
		Instrument_noise = new int[32768];
		Random var0 = new Random(0L);

		int var1;
		for (var1 = 0; var1 < 32768; ++var1) {
			Instrument_noise[var1] = (var0.nextInt() & 2) - 1;
		}

		Instrument_sine = new int[32768];

		for (var1 = 0; var1 < 32768; ++var1) {
			Instrument_sine[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
		}

		Instrument_samples = new int[220500];
		Instrument_phases = new int[5];
		Instrument_delays = new int[5];
		Instrument_volumeSteps = new int[5];
		Instrument_pitchSteps = new int[5];
		Instrument_pitchBaseSteps = new int[5];
	}

	Instrument() {
		this.oscillatorVolume = new int[]{0, 0, 0, 0, 0};
		this.oscillatorPitch = new int[]{0, 0, 0, 0, 0};
		this.oscillatorDelays = new int[]{0, 0, 0, 0, 0};
		this.delayTime = 0;
		this.delayDecay = 100;
		this.duration = 500;
		this.offset = 0;
	}

	@ObfuscatedName("q")
	@Export("synthesize")
	final int[] synthesize(int var1, int var2) {
		class301.clearIntArray(Instrument_samples, 0, var1);
		if (var2 < 10) {
			return Instrument_samples;
		} else {
			double var3 = (double)var1 / ((double)var2 + 0.0D);
			this.pitch.reset();
			this.volume.reset();
			int var5 = 0;
			int var6 = 0;
			int var7 = 0;
			if (this.pitchModifier != null) {
				this.pitchModifier.reset();
				this.pitchModifierAmplitude.reset();
				var5 = (int)((double)(this.pitchModifier.end - this.pitchModifier.start) * 32.768D / var3);
				var6 = (int)((double)this.pitchModifier.start * 32.768D / var3);
			}

			int var8 = 0;
			int var9 = 0;
			int var10 = 0;
			if (this.volumeMultiplier != null) {
				this.volumeMultiplier.reset();
				this.volumeMultiplierAmplitude.reset();
				var8 = (int)((double)(this.volumeMultiplier.end - this.volumeMultiplier.start) * 32.768D / var3);
				var9 = (int)((double)this.volumeMultiplier.start * 32.768D / var3);
			}

			int var11;
			for (var11 = 0; var11 < 5; ++var11) {
				if (this.oscillatorVolume[var11] != 0) {
					Instrument_phases[var11] = 0;
					Instrument_delays[var11] = (int)((double)this.oscillatorDelays[var11] * var3);
					Instrument_volumeSteps[var11] = (this.oscillatorVolume[var11] << 14) / 100;
					Instrument_pitchSteps[var11] = (int)((double)(this.pitch.end - this.pitch.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[var11]) / var3);
					Instrument_pitchBaseSteps[var11] = (int)((double)this.pitch.start * 32.768D / var3);
				}
			}

			int var12;
			int var13;
			int var14;
			int var15;
			int[] var10000;
			for (var11 = 0; var11 < var1; ++var11) {
				var12 = this.pitch.doStep(var1);
				var13 = this.volume.doStep(var1);
				if (this.pitchModifier != null) {
					var14 = this.pitchModifier.doStep(var1);
					var15 = this.pitchModifierAmplitude.doStep(var1);
					var12 += this.evaluateWave(var7, var15, this.pitchModifier.form) >> 1;
					var7 = var7 + var6 + (var14 * var5 >> 16);
				}

				if (this.volumeMultiplier != null) {
					var14 = this.volumeMultiplier.doStep(var1);
					var15 = this.volumeMultiplierAmplitude.doStep(var1);
					var13 = var13 * ((this.evaluateWave(var10, var15, this.volumeMultiplier.form) >> 1) + 32768) >> 15;
					var10 = var10 + var9 + (var14 * var8 >> 16);
				}

				for (var14 = 0; var14 < 5; ++var14) {
					if (this.oscillatorVolume[var14] != 0) {
						var15 = Instrument_delays[var14] + var11;
						if (var15 < var1) {
							var10000 = Instrument_samples;
							var10000[var15] += this.evaluateWave(Instrument_phases[var14], var13 * Instrument_volumeSteps[var14] >> 15, this.pitch.form);
							var10000 = Instrument_phases;
							var10000[var14] += (var12 * Instrument_pitchSteps[var14] >> 16) + Instrument_pitchBaseSteps[var14];
						}
					}
				}
			}

			int var16;
			if (this.release != null) {
				this.release.reset();
				this.attack.reset();
				var11 = 0;
				boolean var19 = false;
				boolean var20 = true;

				for (var14 = 0; var14 < var1; ++var14) {
					var15 = this.release.doStep(var1);
					var16 = this.attack.doStep(var1);
					if (var20) {
						var12 = (var15 * (this.release.end - this.release.start) >> 8) + this.release.start;
					} else {
						var12 = (var16 * (this.release.end - this.release.start) >> 8) + this.release.start;
					}

					var11 += 256;
					if (var11 >= var12) {
						var11 = 0;
						var20 = !var20;
					}

					if (var20) {
						Instrument_samples[var14] = 0;
					}
				}
			}

			if (this.delayTime > 0 && this.delayDecay > 0) {
				var11 = (int)((double)this.delayTime * var3);

				for (var12 = var11; var12 < var1; ++var12) {
					var10000 = Instrument_samples;
					var10000[var12] += Instrument_samples[var12 - var11] * this.delayDecay / 100;
				}
			}

			if (this.filter.pairs[0] > 0 || this.filter.pairs[1] > 0) {
				this.filterEnvelope.reset();
				var11 = this.filterEnvelope.doStep(var1 + 1);
				var12 = this.filter.compute(0, (float)var11 / 65536.0F);
				var13 = this.filter.compute(1, (float)var11 / 65536.0F);
				if (var1 >= var12 + var13) {
					var14 = 0;
					var15 = var13;
					if (var13 > var1 - var12) {
						var15 = var1 - var12;
					}

					int var17;
					while (var14 < var15) {
						var16 = (int)((long)Instrument_samples[var14 + var12] * (long)AudioFilter.forwardMultiplier >> 16);

						for (var17 = 0; var17 < var12; ++var17) {
							var16 += (int)((long)Instrument_samples[var14 + var12 - 1 - var17] * (long)AudioFilter.coefficients[0][var17] >> 16);
						}

						for (var17 = 0; var17 < var14; ++var17) {
							var16 -= (int)((long)Instrument_samples[var14 - 1 - var17] * (long)AudioFilter.coefficients[1][var17] >> 16);
						}

						Instrument_samples[var14] = var16;
						var11 = this.filterEnvelope.doStep(var1 + 1);
						++var14;
					}

					var15 = 128;

					while (true) {
						if (var15 > var1 - var12) {
							var15 = var1 - var12;
						}

						int var18;
						while (var14 < var15) {
							var17 = (int)((long)Instrument_samples[var14 + var12] * (long)AudioFilter.forwardMultiplier >> 16);

							for (var18 = 0; var18 < var12; ++var18) {
								var17 += (int)((long)Instrument_samples[var14 + var12 - 1 - var18] * (long)AudioFilter.coefficients[0][var18] >> 16);
							}

							for (var18 = 0; var18 < var13; ++var18) {
								var17 -= (int)((long)Instrument_samples[var14 - 1 - var18] * (long)AudioFilter.coefficients[1][var18] >> 16);
							}

							Instrument_samples[var14] = var17;
							var11 = this.filterEnvelope.doStep(var1 + 1);
							++var14;
						}

						if (var14 >= var1 - var12) {
							while (var14 < var1) {
								var17 = 0;

								for (var18 = var14 + var12 - var1; var18 < var12; ++var18) {
									var17 += (int)((long)Instrument_samples[var14 + var12 - 1 - var18] * (long)AudioFilter.coefficients[0][var18] >> 16);
								}

								for (var18 = 0; var18 < var13; ++var18) {
									var17 -= (int)((long)Instrument_samples[var14 - 1 - var18] * (long)AudioFilter.coefficients[1][var18] >> 16);
								}

								Instrument_samples[var14] = var17;
								this.filterEnvelope.doStep(var1 + 1);
								++var14;
							}
							break;
						}

						var12 = this.filter.compute(0, (float)var11 / 65536.0F);
						var13 = this.filter.compute(1, (float)var11 / 65536.0F);
						var15 += 128;
					}
				}
			}

			for (var11 = 0; var11 < var1; ++var11) {
				if (Instrument_samples[var11] < -32768) {
					Instrument_samples[var11] = -32768;
				}

				if (Instrument_samples[var11] > 32767) {
					Instrument_samples[var11] = 32767;
				}
			}

			return Instrument_samples;
		}
	}

	@ObfuscatedName("w")
	@Export("evaluateWave")
	final int evaluateWave(int var1, int var2, int var3) {
		if (var3 == 1) {
			return (var1 & 32767) < 16384 ? var2 : -var2;
		} else if (var3 == 2) {
			return Instrument_sine[var1 & 32767] * var2 >> 14;
		} else if (var3 == 3) {
			return (var2 * (var1 & 32767) >> 14) - var2;
		} else {
			return var3 == 4 ? var2 * Instrument_noise[var1 / 2607 & 32767] : 0;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkf;)V"
	)
	@Export("decode")
	final void decode(Buffer var1) {
		this.pitch = new SoundEnvelope();
		this.pitch.decode(var1);
		this.volume = new SoundEnvelope();
		this.volume.decode(var1);
		int var2 = var1.readUnsignedByte();
		if (var2 != 0) {
			--var1.offset;
			this.pitchModifier = new SoundEnvelope();
			this.pitchModifier.decode(var1);
			this.pitchModifierAmplitude = new SoundEnvelope();
			this.pitchModifierAmplitude.decode(var1);
		}

		var2 = var1.readUnsignedByte();
		if (var2 != 0) {
			--var1.offset;
			this.volumeMultiplier = new SoundEnvelope();
			this.volumeMultiplier.decode(var1);
			this.volumeMultiplierAmplitude = new SoundEnvelope();
			this.volumeMultiplierAmplitude.decode(var1);
		}

		var2 = var1.readUnsignedByte();
		if (var2 != 0) {
			--var1.offset;
			this.release = new SoundEnvelope();
			this.release.decode(var1);
			this.attack = new SoundEnvelope();
			this.attack.decode(var1);
		}

		for (int var3 = 0; var3 < 10; ++var3) {
			int var4 = var1.readUShortSmart();
			if (var4 == 0) {
				break;
			}

			this.oscillatorVolume[var3] = var4;
			this.oscillatorPitch[var3] = var1.readShortSmart();
			this.oscillatorDelays[var3] = var1.readUShortSmart();
		}

		this.delayTime = var1.readUShortSmart();
		this.delayDecay = var1.readUShortSmart();
		this.duration = var1.readUnsignedShort();
		this.offset = var1.readUnsignedShort();
		this.filter = new AudioFilter();
		this.filterEnvelope = new SoundEnvelope();
		this.filter.method2680(var1, this.filterEnvelope);
	}
}
