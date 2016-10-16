import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class66 {
   @ObfuscatedName("f")
   static float field1277;
   @ObfuscatedName("t")
   int[][][] field1278 = new int[2][2][4];
   @ObfuscatedName("g")
   static float[][] field1279 = new float[2][8];
   @ObfuscatedName("p")
   int[] field1281 = new int[2];
   @ObfuscatedName("s")
   int[] field1282 = new int[2];
   @ObfuscatedName("m")
   static int[][] field1283 = new int[2][8];
   @ObfuscatedName("k")
   static int field1285;
   @ObfuscatedName("y")
   int[][][] field1286 = new int[2][2][4];

   @ObfuscatedName("s")
   float method1292(int var1, int var2, float var3) {
      float var4 = (float)this.field1286[var1][0][var2] + var3 * (float)(this.field1286[var1][1][var2] - this.field1286[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("z")
   static float method1293(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("t")
   float method1294(int var1, int var2, float var3) {
      float var4 = (float)this.field1278[var1][0][var2] + var3 * (float)(this.field1278[var1][1][var2] - this.field1278[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1293(var4);
   }

   @ObfuscatedName("y")
   int method1295(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1281[0] + (float)(this.field1281[1] - this.field1281[0]) * var2;
         var3 *= 0.0030517578F;
         field1277 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1285 = (int)(field1277 * 65536.0F);
      }

      if(this.field1282[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1292(var1, 0, var2);
         field1279[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1294(var1, 0, var2));
         field1279[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1282[var1]; ++var4) {
            var3 = this.method1292(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1294(var1, var4, var2));
            float var6 = var3 * var3;
            field1279[var1][var4 * 2 + 1] = field1279[var1][var4 * 2 - 1] * var6;
            field1279[var1][var4 * 2] = field1279[var1][var4 * 2 - 1] * var5 + field1279[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1279[var1][var7] += field1279[var1][var7 - 1] * var5 + field1279[var1][var7 - 2] * var6;
            }

            field1279[var1][1] += field1279[var1][0] * var5 + var6;
            field1279[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1282[0] * 2; ++var4) {
               field1279[0][var4] *= field1277;
            }
         }

         for(var4 = 0; var4 < this.field1282[var1] * 2; ++var4) {
            field1283[var1][var4] = (int)(field1279[var1][var4] * 65536.0F);
         }

         return this.field1282[var1] * 2;
      }
   }

   @ObfuscatedName("p")
   final void method1298(Buffer var1, class60 var2) {
      int var3 = var1.method2481();
      this.field1282[0] = var3 >> 4;
      this.field1282[1] = var3 & 15;
      if(var3 != 0) {
         this.field1281[0] = var1.method2668();
         this.field1281[1] = var1.method2668();
         int var4 = var1.method2481();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1282[var5]; ++var6) {
               this.field1278[var5][0][var6] = var1.method2668();
               this.field1286[var5][0][var6] = var1.method2668();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1282[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1278[var5][1][var6] = var1.method2668();
                  this.field1286[var5][1][var6] = var1.method2668();
               } else {
                  this.field1278[var5][1][var6] = this.field1278[var5][0][var6];
                  this.field1286[var5][1][var6] = this.field1286[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1281[1] != this.field1281[0]) {
            var2.method1232(var1);
         }
      } else {
         int[] var7 = this.field1281;
         this.field1281[1] = 0;
         var7[0] = 0;
      }

   }
}
