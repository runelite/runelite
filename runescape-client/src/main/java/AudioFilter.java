import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("AudioFilter")
public class AudioFilter {
   @ObfuscatedName("u")
   static float[][] field32;
   @ObfuscatedName("g")
   static int[][] field33;
   @ObfuscatedName("l")
   static float field34;
   @ObfuscatedName("e")
   static int field35;
   @ObfuscatedName("m")
   int[] field36;
   @ObfuscatedName("q")
   int[][][] field37;
   @ObfuscatedName("w")
   int[][][] field38;
   @ObfuscatedName("o")
   int[] field39;

   AudioFilter() {
      this.field36 = new int[2];
      this.field37 = new int[2][2][4];
      this.field38 = new int[2][2][4];
      this.field39 = new int[2];
   }

   @ObfuscatedName("m")
   float method24(int var1, int var2, float var3) {
      float var4 = (float)this.field38[var1][0][var2] + var3 * (float)(this.field38[var1][1][var2] - this.field38[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("q")
   float method25(int var1, int var2, float var3) {
      float var4 = (float)this.field37[var1][0][var2] + var3 * (float)(this.field37[var1][1][var2] - this.field37[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method2646(var4);
   }

   @ObfuscatedName("w")
   int method26(int var1, float var2) {
      float var3;
      if (var1 == 0) {
         var3 = (float)this.field39[0] + (float)(this.field39[1] - this.field39[0]) * var2;
         var3 *= 0.0030517578F;
         field34 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field35 = (int)(field34 * 65536.0F);
      }

      if (this.field36[var1] == 0) {
         return 0;
      } else {
         var3 = this.method24(var1, 0, var2);
         field32[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method25(var1, 0, var2));
         field32[var1][1] = var3 * var3;

         float[] var10000;
         int var4;
         for (var4 = 1; var4 < this.field36[var1]; ++var4) {
            var3 = this.method24(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method25(var1, var4, var2));
            float var6 = var3 * var3;
            field32[var1][var4 * 2 + 1] = field32[var1][var4 * 2 - 1] * var6;
            field32[var1][var4 * 2] = field32[var1][var4 * 2 - 1] * var5 + field32[var1][var4 * 2 - 2] * var6;

            for (int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               var10000 = field32[var1];
               var10000[var7] += field32[var1][var7 - 1] * var5 + field32[var1][var7 - 2] * var6;
            }

            var10000 = field32[var1];
            var10000[1] += field32[var1][0] * var5 + var6;
            var10000 = field32[var1];
            var10000[0] += var5;
         }

         if (var1 == 0) {
            for (var4 = 0; var4 < this.field36[0] * 2; ++var4) {
               var10000 = field32[0];
               var10000[var4] *= field34;
            }
         }

         for (var4 = 0; var4 < this.field36[var1] * 2; ++var4) {
            field33[var1][var4] = (int)(field32[var1][var4] * 65536.0F);
         }

         return this.field36[var1] * 2;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgr;Lde;)V"
   )
   final void method27(Buffer var1, SoundEnvelope var2) {
      int var3 = var1.readUnsignedByte();
      this.field36[0] = var3 >> 4;
      this.field36[1] = var3 & 15;
      if (var3 != 0) {
         this.field39[0] = var1.method43();
         this.field39[1] = var1.method43();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for (var5 = 0; var5 < 2; ++var5) {
            for (var6 = 0; var6 < this.field36[var5]; ++var6) {
               this.field37[var5][0][var6] = var1.method43();
               this.field38[var5][0][var6] = var1.method43();
            }
         }

         for (var5 = 0; var5 < 2; ++var5) {
            for (var6 = 0; var6 < this.field36[var5]; ++var6) {
               if ((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field37[var5][1][var6] = var1.method43();
                  this.field38[var5][1][var6] = var1.method43();
               } else {
                  this.field37[var5][1][var6] = this.field37[var5][0][var6];
                  this.field38[var5][1][var6] = this.field38[var5][0][var6];
               }
            }
         }

         if (var4 != 0 || this.field39[1] != this.field39[0]) {
            var2.decodeSegments(var1);
         }
      } else {
         int[] var7 = this.field39;
         this.field39[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("f")
   static float method2646(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   static {
      field32 = new float[2][8];
      field33 = new int[2][8];
   }
}
