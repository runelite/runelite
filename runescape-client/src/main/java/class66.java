import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
public class class66 {
   @ObfuscatedName("m")
   static float field1279;
   @ObfuscatedName("j")
   int[][][] field1281 = new int[2][2][4];
   @ObfuscatedName("z")
   int[][][] field1282 = new int[2][2][4];
   @ObfuscatedName("b")
   static float[][] field1283 = new float[2][8];
   @ObfuscatedName("l")
   static int[][] field1284 = new int[2][8];
   @ObfuscatedName("i")
   int[] field1285 = new int[2];
   @ObfuscatedName("x")
   int[] field1286 = new int[2];
   @ObfuscatedName("p")
   static int field1287;

   @ObfuscatedName("x")
   float method1326(int var1, int var2, float var3) {
      float var4 = (float)this.field1282[var1][0][var2] + var3 * (float)(this.field1282[var1][1][var2] - this.field1282[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("r")
   static float method1327(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("j")
   float method1328(int var1, int var2, float var3) {
      float var4 = (float)this.field1281[var1][0][var2] + var3 * (float)(this.field1281[var1][1][var2] - this.field1281[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1327(var4);
   }

   @ObfuscatedName("i")
   final void method1329(Buffer var1, class60 var2) {
      int var3 = var1.method2556();
      this.field1286[0] = var3 >> 4;
      this.field1286[1] = var3 & 15;
      if(var3 != 0) {
         this.field1285[0] = var1.method2551();
         this.field1285[1] = var1.method2551();
         int var4 = var1.method2556();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1286[var5]; ++var6) {
               this.field1281[var5][0][var6] = var1.method2551();
               this.field1282[var5][0][var6] = var1.method2551();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1286[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1281[var5][1][var6] = var1.method2551();
                  this.field1282[var5][1][var6] = var1.method2551();
               } else {
                  this.field1281[var5][1][var6] = this.field1281[var5][0][var6];
                  this.field1282[var5][1][var6] = this.field1282[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1285[1] != this.field1285[0]) {
            var2.method1281(var1);
         }
      } else {
         int[] var7 = this.field1285;
         this.field1285[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("z")
   int method1334(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1285[0] + (float)(this.field1285[1] - this.field1285[0]) * var2;
         var3 *= 0.0030517578F;
         field1279 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1287 = (int)(field1279 * 65536.0F);
      }

      if(this.field1286[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1326(var1, 0, var2);
         field1283[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1328(var1, 0, var2));
         field1283[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1286[var1]; ++var4) {
            var3 = this.method1326(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1328(var1, var4, var2));
            float var6 = var3 * var3;
            field1283[var1][var4 * 2 + 1] = field1283[var1][var4 * 2 - 1] * var6;
            field1283[var1][var4 * 2] = field1283[var1][var4 * 2 - 1] * var5 + field1283[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1283[var1][var7] += field1283[var1][var7 - 1] * var5 + field1283[var1][var7 - 2] * var6;
            }

            field1283[var1][1] += field1283[var1][0] * var5 + var6;
            field1283[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1286[0] * 2; ++var4) {
               field1283[0][var4] *= field1279;
            }
         }

         for(var4 = 0; var4 < this.field1286[var1] * 2; ++var4) {
            field1284[var1][var4] = (int)(field1283[var1][var4] * 65536.0F);
         }

         return this.field1286[var1] * 2;
      }
   }
}
