import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("AudioInstrument")
public class AudioInstrument {
   @ObfuscatedName("e")
   @Export("samples")
   static int[] samples;
   @ObfuscatedName("t")
   @Export("NOISE")
   static int[] NOISE;
   @ObfuscatedName("u")
   @Export("AUDIO_SINE")
   static int[] AUDIO_SINE;
   @ObfuscatedName("z")
   @Export("phases")
   static int[] phases;
   @ObfuscatedName("k")
   @Export("delays")
   static int[] delays;
   @ObfuscatedName("r")
   @Export("volumeSteps")
   static int[] volumeSteps;
   @ObfuscatedName("v")
   @Export("pitchSteps")
   static int[] pitchSteps;
   @ObfuscatedName("o")
   @Export("pitchBaseSteps")
   static int[] pitchBaseSteps;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("pitch")
   AudioEnvelope pitch;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("volume")
   AudioEnvelope volume;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("pitchModifier")
   AudioEnvelope pitchModifier;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("pitchModifierAmplitude")
   AudioEnvelope pitchModifierAmplitude;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("volumeMultiplier")
   AudioEnvelope volumeMultiplier;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("volumeMultiplierAmplitude")
   AudioEnvelope volumeMultiplierAmplitude;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("release")
   AudioEnvelope release;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   AudioEnvelope field1421;
   @ObfuscatedName("j")
   @Export("oscillatorVolume")
   int[] oscillatorVolume;
   @ObfuscatedName("a")
   @Export("oscillatorPitch")
   int[] oscillatorPitch;
   @ObfuscatedName("l")
   @Export("oscillatorDelays")
   int[] oscillatorDelays;
   @ObfuscatedName("d")
   @Export("delayTime")
   int delayTime;
   @ObfuscatedName("s")
   @Export("delayDecay")
   int delayDecay;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   @Export("filter")
   SoundEffect3 filter;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("filterEnvelope")
   AudioEnvelope filterEnvelope;
   @ObfuscatedName("y")
   @Export("duration")
   int duration;
   @ObfuscatedName("c")
   @Export("offset")
   int offset;

   static {
      NOISE = new int['耀'];
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < 32768; ++var1) {
         NOISE[var1] = (var0.nextInt() & 2) - 1;
      }

      AUDIO_SINE = new int['耀'];

      for(var1 = 0; var1 < 32768; ++var1) {
         AUDIO_SINE[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      samples = new int[220500];
      phases = new int[5];
      delays = new int[5];
      volumeSteps = new int[5];
      pitchSteps = new int[5];
      pitchBaseSteps = new int[5];
   }

   AudioInstrument() {
      this.oscillatorVolume = new int[]{0, 0, 0, 0, 0};
      this.oscillatorPitch = new int[]{0, 0, 0, 0, 0};
      this.oscillatorDelays = new int[]{0, 0, 0, 0, 0};
      this.delayTime = 0;
      this.delayDecay = 100;
      this.duration = 500;
      this.offset = 0;
   }

   @ObfuscatedName("w")
   @Export("synthesize")
   final int[] synthesize(int var1, int var2) {
      class193.method3935(samples, 0, var1);
      if(var2 < 10) {
         return samples;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.pitch.reset();
         this.volume.reset();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.pitchModifier != null) {
            this.pitchModifier.reset();
            this.pitchModifierAmplitude.reset();
            var5 = (int)((double)(this.pitchModifier.end - this.pitchModifier.start) * 32.768D / var3);
            var6 = (int)((double)this.pitchModifier.start * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.volumeMultiplier != null) {
            this.volumeMultiplier.reset();
            this.volumeMultiplierAmplitude.reset();
            var8 = (int)((double)(this.volumeMultiplier.end - this.volumeMultiplier.start) * 32.768D / var3);
            var9 = (int)((double)this.volumeMultiplier.start * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.oscillatorVolume[var11] != 0) {
               phases[var11] = 0;
               delays[var11] = (int)((double)this.oscillatorDelays[var11] * var3);
               volumeSteps[var11] = (this.oscillatorVolume[var11] << 14) / 100;
               pitchSteps[var11] = (int)((double)(this.pitch.end - this.pitch.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[var11]) / var3);
               pitchBaseSteps[var11] = (int)((double)this.pitch.start * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.pitch.step(var1);
            var13 = this.volume.step(var1);
            if(this.pitchModifier != null) {
               var14 = this.pitchModifier.step(var1);
               var15 = this.pitchModifierAmplitude.step(var1);
               var12 += this.evaluateWave(var7, var15, this.pitchModifier.form) >> 1;
               var7 = var7 + var6 + (var14 * var5 >> 16);
            }

            if(this.volumeMultiplier != null) {
               var14 = this.volumeMultiplier.step(var1);
               var15 = this.volumeMultiplierAmplitude.step(var1);
               var13 = var13 * ((this.evaluateWave(var10, var15, this.volumeMultiplier.form) >> 1) + 32768) >> 15;
               var10 = var10 + var9 + (var14 * var8 >> 16);
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.oscillatorVolume[var14] != 0) {
                  var15 = delays[var14] + var11;
                  if(var15 < var1) {
                     samples[var15] += this.evaluateWave(phases[var14], var13 * volumeSteps[var14] >> 15, this.pitch.form);
                     phases[var14] += (var12 * pitchSteps[var14] >> 16) + pitchBaseSteps[var14];
                  }
               }
            }
         }

         int var16;
         if(this.release != null) {
            this.release.reset();
            this.field1421.reset();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.release.step(var1);
               var16 = this.field1421.step(var1);
               if(var20) {
                  var12 = (var15 * (this.release.end - this.release.start) >> 8) + this.release.start;
               } else {
                  var12 = (var16 * (this.release.end - this.release.start) >> 8) + this.release.start;
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  samples[var14] = 0;
               }
            }
         }

         if(this.delayTime > 0 && this.delayDecay > 0) {
            var11 = (int)((double)this.delayTime * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               samples[var12] += samples[var12 - var11] * this.delayDecay / 100;
            }
         }

         if(this.filter.pairs[0] > 0 || this.filter.pairs[1] > 0) {
            this.filterEnvelope.reset();
            var11 = this.filterEnvelope.step(var1 + 1);
            var12 = this.filter.compute(0, (float)var11 / 65536.0F);
            var13 = this.filter.compute(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)samples[var14 + var12] * (long)SoundEffect3.fowardMultiplier >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)samples[var14 + var12 - 1 - var17] * (long)SoundEffect3.coefficients[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)samples[var14 - 1 - var17] * (long)SoundEffect3.coefficients[1][var17] >> 16);
                  }

                  samples[var14] = var16;
                  var11 = this.filterEnvelope.step(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)samples[var14 + var12] * (long)SoundEffect3.fowardMultiplier >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)samples[var14 + var12 - 1 - var18] * (long)SoundEffect3.coefficients[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)samples[var14 - 1 - var18] * (long)SoundEffect3.coefficients[1][var18] >> 16);
                     }

                     samples[var14] = var17;
                     var11 = this.filterEnvelope.step(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)samples[var14 + var12 - 1 - var18] * (long)SoundEffect3.coefficients[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)samples[var14 - 1 - var18] * (long)SoundEffect3.coefficients[1][var18] >> 16);
                        }

                        samples[var14] = var17;
                        this.filterEnvelope.step(var1 + 1);
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

         for(var11 = 0; var11 < var1; ++var11) {
            if(samples[var11] < -32768) {
               samples[var11] = -32768;
            }

            if(samples[var11] > 32767) {
               samples[var11] = 32767;
            }
         }

         return samples;
      }
   }

   @ObfuscatedName("m")
   @Export("evaluateWave")
   final int evaluateWave(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?AUDIO_SINE[var1 & 32767] * var2 >> 14:(var3 == 3?(var2 * (var1 & 32767) >> 14) - var2:(var3 == 4?var2 * NOISE[var1 / 2607 & 32767]:0)));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;)V"
   )
   @Export("decode")
   final void decode(Buffer var1) {
      this.pitch = new AudioEnvelope();
      this.pitch.decode(var1);
      this.volume = new AudioEnvelope();
      this.volume.decode(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.pitchModifier = new AudioEnvelope();
         this.pitchModifier.decode(var1);
         this.pitchModifierAmplitude = new AudioEnvelope();
         this.pitchModifierAmplitude.decode(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.volumeMultiplier = new AudioEnvelope();
         this.volumeMultiplier.decode(var1);
         this.volumeMultiplierAmplitude = new AudioEnvelope();
         this.volumeMultiplierAmplitude.decode(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.release = new AudioEnvelope();
         this.release.decode(var1);
         this.field1421 = new AudioEnvelope();
         this.field1421.decode(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.getUSmart();
         if(var4 == 0) {
            break;
         }

         this.oscillatorVolume[var3] = var4;
         this.oscillatorPitch[var3] = var1.readShortSmart();
         this.oscillatorDelays[var3] = var1.getUSmart();
      }

      this.delayTime = var1.getUSmart();
      this.delayDecay = var1.getUSmart();
      this.duration = var1.readUnsignedShort();
      this.offset = var1.readUnsignedShort();
      this.filter = new SoundEffect3();
      this.filterEnvelope = new AudioEnvelope();
      this.filter.decode(var1, this.filterEnvelope);
   }
}
