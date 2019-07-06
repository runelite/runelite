import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("Instrument")
public class Instrument {
   @ObfuscatedName("s")
   @Export("Instrument_samples")
   static int[] Instrument_samples;
   @ObfuscatedName("t")
   @Export("Instrument_noise")
   static int[] Instrument_noise;
   @ObfuscatedName("y")
   @Export("Instrument_sine")
   static int[] Instrument_sine;
   @ObfuscatedName("b")
   @Export("Instrument_phases")
   static int[] Instrument_phases;
   @ObfuscatedName("c")
   @Export("Instrument_delays")
   static int[] Instrument_delays;
   @ObfuscatedName("r")
   @Export("Instrument_volumeSteps")
   static int[] Instrument_volumeSteps;
   @ObfuscatedName("p")
   @Export("Instrument_pitchSteps")
   static int[] Instrument_pitchSteps;
   @ObfuscatedName("v")
   @Export("Instrument_pitchBaseSteps")
   static int[] Instrument_pitchBaseSteps;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope field413;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope field414;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope field415;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope field416;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope field417;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope field418;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope field419;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope field420;
   @ObfuscatedName("e")
   @Export("oscillatorVolume")
   int[] oscillatorVolume;
   @ObfuscatedName("x")
   @Export("oscillatorPitch")
   int[] oscillatorPitch;
   @ObfuscatedName("d")
   @Export("oscillatorDelays")
   int[] oscillatorDelays;
   @ObfuscatedName("k")
   @Export("delayTime")
   int delayTime;
   @ObfuscatedName("n")
   @Export("delayDecay")
   int delayDecay;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ldi;"
   )
   @Export("filter")
   AudioFilter filter;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope field421;
   @ObfuscatedName("z")
   @Export("duration")
   int duration;
   @ObfuscatedName("j")
   @Export("offset")
   int offset;

   Instrument() {
      this.oscillatorVolume = new int[]{0, 0, 0, 0, 0};
      this.oscillatorPitch = new int[]{0, 0, 0, 0, 0};
      this.oscillatorDelays = new int[]{0, 0, 0, 0, 0};
      this.delayTime = 0;
      this.delayDecay = 100;
      this.duration = 500;
      this.offset = 0;
   }

   @ObfuscatedName("m")
   @Export("synthesize")
   final int[] synthesize(int var1, int var2) {
      class212.clearIntArray(Instrument_samples, 0, var1);
      if (var2 < 10) {
         return Instrument_samples;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field413.reset();
         this.field414.reset();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if (this.field415 != null) {
            this.field415.reset();
            this.field416.reset();
            var5 = (int)((double)(this.field415.end - this.field415.start) * 32.768D / var3);
            var6 = (int)((double)this.field415.start * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if (this.field417 != null) {
            this.field417.reset();
            this.field418.reset();
            var8 = (int)((double)(this.field417.end - this.field417.start) * 32.768D / var3);
            var9 = (int)((double)this.field417.start * 32.768D / var3);
         }

         int var11;
         for (var11 = 0; var11 < 5; ++var11) {
            if (this.oscillatorVolume[var11] != 0) {
               Instrument_phases[var11] = 0;
               Instrument_delays[var11] = (int)((double)this.oscillatorDelays[var11] * var3);
               Instrument_volumeSteps[var11] = (this.oscillatorVolume[var11] << 14) / 100;
               Instrument_pitchSteps[var11] = (int)((double)(this.field413.end - this.field413.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[var11]) / var3);
               Instrument_pitchBaseSteps[var11] = (int)((double)this.field413.start * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         int[] var10000;
         for (var11 = 0; var11 < var1; ++var11) {
            var12 = this.field413.doStep(var1);
            var13 = this.field414.doStep(var1);
            if (this.field415 != null) {
               var14 = this.field415.doStep(var1);
               var15 = this.field416.doStep(var1);
               var12 += this.evaluateWave(var7, var15, this.field415.form) >> 1;
               var7 = var7 + var6 + (var14 * var5 >> 16);
            }

            if (this.field417 != null) {
               var14 = this.field417.doStep(var1);
               var15 = this.field418.doStep(var1);
               var13 = var13 * ((this.evaluateWave(var10, var15, this.field417.form) >> 1) + 32768) >> 15;
               var10 = var10 + var9 + (var14 * var8 >> 16);
            }

            for (var14 = 0; var14 < 5; ++var14) {
               if (this.oscillatorVolume[var14] != 0) {
                  var15 = Instrument_delays[var14] + var11;
                  if (var15 < var1) {
                     var10000 = Instrument_samples;
                     var10000[var15] += this.evaluateWave(Instrument_phases[var14], var13 * Instrument_volumeSteps[var14] >> 15, this.field413.form);
                     var10000 = Instrument_phases;
                     var10000[var14] += (var12 * Instrument_pitchSteps[var14] >> 16) + Instrument_pitchBaseSteps[var14];
                  }
               }
            }
         }

         int var16;
         if (this.field419 != null) {
            this.field419.reset();
            this.field420.reset();
            var11 = 0;
            boolean var17 = false;
            boolean var18 = true;

            for (var14 = 0; var14 < var1; ++var14) {
               var15 = this.field419.doStep(var1);
               var16 = this.field420.doStep(var1);
               if (var18) {
                  var12 = (var15 * (this.field419.end - this.field419.start) >> 8) + this.field419.start;
               } else {
                  var12 = (var16 * (this.field419.end - this.field419.start) >> 8) + this.field419.start;
               }

               var11 += 256;
               if (var11 >= var12) {
                  var11 = 0;
                  var18 = !var18;
               }

               if (var18) {
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

         if (this.filter.field36[0] > 0 || this.filter.field36[1] > 0) {
            this.field421.reset();
            var11 = this.field421.doStep(var1 + 1);
            var12 = this.filter.method26(0, (float)var11 / 65536.0F);
            var13 = this.filter.method26(1, (float)var11 / 65536.0F);
            if (var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if (var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var19;
               while (var14 < var15) {
                  var16 = (int)((long)Instrument_samples[var14 + var12] * (long)AudioFilter.field35 >> 16);

                  for (var19 = 0; var19 < var12; ++var19) {
                     var16 += (int)((long)Instrument_samples[var14 + var12 - 1 - var19] * (long)AudioFilter.field33[0][var19] >> 16);
                  }

                  for (var19 = 0; var19 < var14; ++var19) {
                     var16 -= (int)((long)Instrument_samples[var14 - 1 - var19] * (long)AudioFilter.field33[1][var19] >> 16);
                  }

                  Instrument_samples[var14] = var16;
                  var11 = this.field421.doStep(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while (true) {
                  if (var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var20;
                  while (var14 < var15) {
                     var19 = (int)((long)Instrument_samples[var14 + var12] * (long)AudioFilter.field35 >> 16);

                     for (var20 = 0; var20 < var12; ++var20) {
                        var19 += (int)((long)Instrument_samples[var14 + var12 - 1 - var20] * (long)AudioFilter.field33[0][var20] >> 16);
                     }

                     for (var20 = 0; var20 < var13; ++var20) {
                        var19 -= (int)((long)Instrument_samples[var14 - 1 - var20] * (long)AudioFilter.field33[1][var20] >> 16);
                     }

                     Instrument_samples[var14] = var19;
                     var11 = this.field421.doStep(var1 + 1);
                     ++var14;
                  }

                  if (var14 >= var1 - var12) {
                     while (var14 < var1) {
                        var19 = 0;

                        for (var20 = var14 + var12 - var1; var20 < var12; ++var20) {
                           var19 += (int)((long)Instrument_samples[var14 + var12 - 1 - var20] * (long)AudioFilter.field33[0][var20] >> 16);
                        }

                        for (var20 = 0; var20 < var13; ++var20) {
                           var19 -= (int)((long)Instrument_samples[var14 - 1 - var20] * (long)AudioFilter.field33[1][var20] >> 16);
                        }

                        Instrument_samples[var14] = var19;
                        this.field421.doStep(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.filter.method26(0, (float)var11 / 65536.0F);
                  var13 = this.filter.method26(1, (float)var11 / 65536.0F);
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

   @ObfuscatedName("f")
   @Export("evaluateWave")
   final int evaluateWave(int var1, int var2, int var3) {
      return var3 == 1 ? ((var1 & 32767) < 16384 ? var2 : -var2) : (var3 == 2 ? Instrument_sine[var1 & 32767] * var2 >> 14 : (var3 == 3 ? (var2 * (var1 & 32767) >> 14) - var2 : (var3 == 4 ? var2 * Instrument_noise[var1 / 2607 & 32767] : 0)));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;)V"
   )
   @Export("decode")
   final void decode(Buffer var1) {
      this.field413 = new SoundEnvelope();
      this.field413.decode(var1);
      this.field414 = new SoundEnvelope();
      this.field414.decode(var1);
      int var2 = var1.readUnsignedByte();
      if (var2 != 0) {
         --var1.index;
         this.field415 = new SoundEnvelope();
         this.field415.decode(var1);
         this.field416 = new SoundEnvelope();
         this.field416.decode(var1);
      }

      var2 = var1.readUnsignedByte();
      if (var2 != 0) {
         --var1.index;
         this.field417 = new SoundEnvelope();
         this.field417.decode(var1);
         this.field418 = new SoundEnvelope();
         this.field418.decode(var1);
      }

      var2 = var1.readUnsignedByte();
      if (var2 != 0) {
         --var1.index;
         this.field419 = new SoundEnvelope();
         this.field419.decode(var1);
         this.field420 = new SoundEnvelope();
         this.field420.decode(var1);
      }

      for (int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method48();
         if (var4 == 0) {
            break;
         }

         this.oscillatorVolume[var3] = var4;
         this.oscillatorPitch[var3] = var1.method47();
         this.oscillatorDelays[var3] = var1.method48();
      }

      this.delayTime = var1.method48();
      this.delayDecay = var1.method48();
      this.duration = var1.readUnsignedShort();
      this.offset = var1.readUnsignedShort();
      this.filter = new AudioFilter();
      this.field421 = new SoundEnvelope();
      this.filter.method27(var1, this.field421);
   }

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
}
