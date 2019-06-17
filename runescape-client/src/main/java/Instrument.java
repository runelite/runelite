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
   @Export("__m")
   SoundEnvelope __m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("__f")
   SoundEnvelope __f;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("__q")
   SoundEnvelope __q;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("__w")
   SoundEnvelope __w;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("__o")
   SoundEnvelope __o;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("__u")
   SoundEnvelope __u;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("__g")
   SoundEnvelope __g;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("__l")
   SoundEnvelope __l;
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
   @Export("__a")
   SoundEnvelope __a;
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
      if(var2 < 10) {
         return Instrument_samples;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.__m.reset();
         this.__f.reset();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.__q != null) {
            this.__q.reset();
            this.__w.reset();
            var5 = (int)((double)(this.__q.end - this.__q.start) * 32.768D / var3);
            var6 = (int)((double)this.__q.start * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.__o != null) {
            this.__o.reset();
            this.__u.reset();
            var8 = (int)((double)(this.__o.end - this.__o.start) * 32.768D / var3);
            var9 = (int)((double)this.__o.start * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.oscillatorVolume[var11] != 0) {
               Instrument_phases[var11] = 0;
               Instrument_delays[var11] = (int)((double)this.oscillatorDelays[var11] * var3);
               Instrument_volumeSteps[var11] = (this.oscillatorVolume[var11] << 14) / 100;
               Instrument_pitchSteps[var11] = (int)((double)(this.__m.end - this.__m.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[var11]) / var3);
               Instrument_pitchBaseSteps[var11] = (int)((double)this.__m.start * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.__m.doStep(var1);
            var13 = this.__f.doStep(var1);
            if(this.__q != null) {
               var14 = this.__q.doStep(var1);
               var15 = this.__w.doStep(var1);
               var12 += this.evaluateWave(var7, var15, this.__q.form) >> 1;
               var7 = var7 + var6 + (var14 * var5 >> 16);
            }

            if(this.__o != null) {
               var14 = this.__o.doStep(var1);
               var15 = this.__u.doStep(var1);
               var13 = var13 * ((this.evaluateWave(var10, var15, this.__o.form) >> 1) + 32768) >> 15;
               var10 = var10 + var9 + (var14 * var8 >> 16);
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.oscillatorVolume[var14] != 0) {
                  var15 = Instrument_delays[var14] + var11;
                  if(var15 < var1) {
                     Instrument_samples[var15] += this.evaluateWave(Instrument_phases[var14], var13 * Instrument_volumeSteps[var14] >> 15, this.__m.form);
                     Instrument_phases[var14] += (var12 * Instrument_pitchSteps[var14] >> 16) + Instrument_pitchBaseSteps[var14];
                  }
               }
            }
         }

         int var16;
         if(this.__g != null) {
            this.__g.reset();
            this.__l.reset();
            var11 = 0;
            boolean var17 = false;
            boolean var18 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.__g.doStep(var1);
               var16 = this.__l.doStep(var1);
               if(var18) {
                  var12 = (var15 * (this.__g.end - this.__g.start) >> 8) + this.__g.start;
               } else {
                  var12 = (var16 * (this.__g.end - this.__g.start) >> 8) + this.__g.start;
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var18 = !var18;
               }

               if(var18) {
                  Instrument_samples[var14] = 0;
               }
            }
         }

         if(this.delayTime > 0 && this.delayDecay > 0) {
            var11 = (int)((double)this.delayTime * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               Instrument_samples[var12] += Instrument_samples[var12 - var11] * this.delayDecay / 100;
            }
         }

         if(this.filter.__m[0] > 0 || this.filter.__m[1] > 0) {
            this.__a.reset();
            var11 = this.__a.doStep(var1 + 1);
            var12 = this.filter.__w_207(0, (float)var11 / 65536.0F);
            var13 = this.filter.__w_207(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var19;
               while(var14 < var15) {
                  var16 = (int)((long)Instrument_samples[var14 + var12] * (long)AudioFilter.__di_e >> 16);

                  for(var19 = 0; var19 < var12; ++var19) {
                     var16 += (int)((long)Instrument_samples[var14 + var12 - 1 - var19] * (long)AudioFilter.__di_g[0][var19] >> 16);
                  }

                  for(var19 = 0; var19 < var14; ++var19) {
                     var16 -= (int)((long)Instrument_samples[var14 - 1 - var19] * (long)AudioFilter.__di_g[1][var19] >> 16);
                  }

                  Instrument_samples[var14] = var16;
                  var11 = this.__a.doStep(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var20;
                  while(var14 < var15) {
                     var19 = (int)((long)Instrument_samples[var14 + var12] * (long)AudioFilter.__di_e >> 16);

                     for(var20 = 0; var20 < var12; ++var20) {
                        var19 += (int)((long)Instrument_samples[var14 + var12 - 1 - var20] * (long)AudioFilter.__di_g[0][var20] >> 16);
                     }

                     for(var20 = 0; var20 < var13; ++var20) {
                        var19 -= (int)((long)Instrument_samples[var14 - 1 - var20] * (long)AudioFilter.__di_g[1][var20] >> 16);
                     }

                     Instrument_samples[var14] = var19;
                     var11 = this.__a.doStep(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var19 = 0;

                        for(var20 = var14 + var12 - var1; var20 < var12; ++var20) {
                           var19 += (int)((long)Instrument_samples[var14 + var12 - 1 - var20] * (long)AudioFilter.__di_g[0][var20] >> 16);
                        }

                        for(var20 = 0; var20 < var13; ++var20) {
                           var19 -= (int)((long)Instrument_samples[var14 - 1 - var20] * (long)AudioFilter.__di_g[1][var20] >> 16);
                        }

                        Instrument_samples[var14] = var19;
                        this.__a.doStep(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.filter.__w_207(0, (float)var11 / 65536.0F);
                  var13 = this.filter.__w_207(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(Instrument_samples[var11] < -32768) {
               Instrument_samples[var11] = -32768;
            }

            if(Instrument_samples[var11] > 32767) {
               Instrument_samples[var11] = 32767;
            }
         }

         return Instrument_samples;
      }
   }

   @ObfuscatedName("f")
   @Export("evaluateWave")
   final int evaluateWave(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?Instrument_sine[var1 & 32767] * var2 >> 14:(var3 == 3?(var2 * (var1 & 32767) >> 14) - var2:(var3 == 4?var2 * Instrument_noise[var1 / 2607 & 32767]:0)));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;)V"
   )
   @Export("decode")
   final void decode(Buffer var1) {
      this.__m = new SoundEnvelope();
      this.__m.decode(var1);
      this.__f = new SoundEnvelope();
      this.__f.decode(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.index;
         this.__q = new SoundEnvelope();
         this.__q.decode(var1);
         this.__w = new SoundEnvelope();
         this.__w.decode(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.index;
         this.__o = new SoundEnvelope();
         this.__o.decode(var1);
         this.__u = new SoundEnvelope();
         this.__u.decode(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.index;
         this.__g = new SoundEnvelope();
         this.__g.decode(var1);
         this.__l = new SoundEnvelope();
         this.__l.decode(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.__ae_307();
         if(var4 == 0) {
            break;
         }

         this.oscillatorVolume[var3] = var4;
         this.oscillatorPitch[var3] = var1.__ab_306();
         this.oscillatorDelays[var3] = var1.__ae_307();
      }

      this.delayTime = var1.__ae_307();
      this.delayDecay = var1.__ae_307();
      this.duration = var1.__ag_302();
      this.offset = var1.__ag_302();
      this.filter = new AudioFilter();
      this.__a = new SoundEnvelope();
      this.filter.__o_208(var1, this.__a);
   }

   static {
      Instrument_noise = new int[32768];
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < 32768; ++var1) {
         Instrument_noise[var1] = (var0.nextInt() & 2) - 1;
      }

      Instrument_sine = new int[32768];

      for(var1 = 0; var1 < 32768; ++var1) {
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
