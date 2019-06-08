import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("AudioFilter")
public class AudioFilter {
   @ObfuscatedName("u")
   @Export("__di_u")
   static float[][] __di_u;
   @ObfuscatedName("g")
   @Export("__di_g")
   static int[][] __di_g;
   @ObfuscatedName("l")
   @Export("__di_l")
   static float __di_l;
   @ObfuscatedName("e")
   @Export("__di_e")
   static int __di_e;
   @ObfuscatedName("m")
   @Export("__m")
   int[] __m;
   @ObfuscatedName("q")
   @Export("__q")
   int[][][] __q;
   @ObfuscatedName("w")
   @Export("__w")
   int[][][] __w;
   @ObfuscatedName("o")
   @Export("__o")
   int[] __o;

   static {
      __di_u = new float[2][8];
      __di_g = new int[2][8];
   }

   AudioFilter() {
      this.__m = new int[2];
      this.__q = new int[2][2][4];
      this.__w = new int[2][2][4];
      this.__o = new int[2];
   }

   @ObfuscatedName("m")
   @Export("__m_205")
   float __m_205(int var1, int var2, float var3) {
      float var4 = (float)this.__w[var1][0][var2] + var3 * (float)(this.__w[var1][1][var2] - this.__w[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("q")
   @Export("__q_206")
   float __q_206(int var1, int var2, float var3) {
      float var4 = (float)this.__q[var1][0][var2] + var3 * (float)(this.__q[var1][1][var2] - this.__q[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method2646(var4);
   }

   @ObfuscatedName("w")
   @Export("__w_207")
   int __w_207(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.__o[0] + (float)(this.__o[1] - this.__o[0]) * var2;
         var3 *= 0.0030517578F;
         __di_l = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         __di_e = (int)(__di_l * 65536.0F);
      }

      if(this.__m[var1] == 0) {
         return 0;
      } else {
         var3 = this.__m_205(var1, 0, var2);
         __di_u[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.__q_206(var1, 0, var2));
         __di_u[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.__m[var1]; ++var4) {
            var3 = this.__m_205(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.__q_206(var1, var4, var2));
            float var6 = var3 * var3;
            __di_u[var1][var4 * 2 + 1] = __di_u[var1][var4 * 2 - 1] * var6;
            __di_u[var1][var4 * 2] = __di_u[var1][var4 * 2 - 1] * var5 + __di_u[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               __di_u[var1][var7] += __di_u[var1][var7 - 1] * var5 + __di_u[var1][var7 - 2] * var6;
            }

            __di_u[var1][1] += __di_u[var1][0] * var5 + var6;
            __di_u[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.__m[0] * 2; ++var4) {
               __di_u[0][var4] *= __di_l;
            }
         }

         for(var4 = 0; var4 < this.__m[var1] * 2; ++var4) {
            __di_g[var1][var4] = (int)(__di_u[var1][var4] * 65536.0F);
         }

         return this.__m[var1] * 2;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgr;Lde;)V"
   )
   @Export("__o_208")
   final void __o_208(Buffer var1, SoundEnvelope var2) {
      int var3 = var1.readUnsignedByte();
      this.__m[0] = var3 >> 4;
      this.__m[1] = var3 & 15;
      if(var3 != 0) {
         this.__o[0] = var1.__ag_302();
         this.__o[1] = var1.__ag_302();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.__m[var5]; ++var6) {
               this.__q[var5][0][var6] = var1.__ag_302();
               this.__w[var5][0][var6] = var1.__ag_302();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.__m[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.__q[var5][1][var6] = var1.__ag_302();
                  this.__w[var5][1][var6] = var1.__ag_302();
               } else {
                  this.__q[var5][1][var6] = this.__q[var5][0][var6];
                  this.__w[var5][1][var6] = this.__w[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.__o[1] != this.__o[0]) {
            var2.decodeSegments(var1);
         }
      } else {
         int[] var7 = this.__o;
         this.__o[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("f")
   static float method2646(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
