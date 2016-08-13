import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bp")
public class class66 {
   @ObfuscatedName("h")
   int[] field1306 = new int[2];
   @ObfuscatedName("r")
   int[][][] field1308 = new int[2][2][4];
   @ObfuscatedName("e")
   int[][][] field1309 = new int[2][2][4];
   @ObfuscatedName("u")
   static float field1310;
   @ObfuscatedName("s")
   static float[][] field1311 = new float[2][8];
   @ObfuscatedName("l")
   int[] field1313 = new int[2];
   @ObfuscatedName("n")
   static int field1314;
   @ObfuscatedName("k")
   static int[][] field1315 = new int[2][8];

   @ObfuscatedName("e")
   int method1411(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1306[0] + (float)(this.field1306[1] - this.field1306[0]) * var2;
         var3 *= 0.0030517578F;
         field1310 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1314 = (int)(field1310 * 65536.0F);
      }

      if(this.field1313[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1412(var1, 0, var2);
         field1311[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1414(var1, 0, var2));
         field1311[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1313[var1]; ++var4) {
            var3 = this.method1412(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1414(var1, var4, var2));
            float var6 = var3 * var3;
            field1311[var1][var4 * 2 + 1] = field1311[var1][var4 * 2 - 1] * var6;
            field1311[var1][var4 * 2] = field1311[var1][var4 * 2 - 1] * var5 + field1311[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1311[var1][var7] += field1311[var1][var7 - 1] * var5 + field1311[var1][var7 - 2] * var6;
            }

            field1311[var1][1] += field1311[var1][0] * var5 + var6;
            field1311[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1313[0] * 2; ++var4) {
               field1311[0][var4] *= field1310;
            }
         }

         for(var4 = 0; var4 < this.field1313[var1] * 2; ++var4) {
            field1315[var1][var4] = (int)(field1311[var1][var4] * 65536.0F);
         }

         return this.field1313[var1] * 2;
      }
   }

   @ObfuscatedName("l")
   float method1412(int var1, int var2, float var3) {
      float var4 = (float)this.field1309[var1][0][var2] + var3 * (float)(this.field1309[var1][1][var2] - this.field1309[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("r")
   float method1414(int var1, int var2, float var3) {
      float var4 = (float)this.field1308[var1][0][var2] + var3 * (float)(this.field1308[var1][1][var2] - this.field1308[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1422(var4);
   }

   @ObfuscatedName("h")
   final void method1416(Buffer var1, class60 var2) {
      int var3 = var1.method2633();
      this.field1313[0] = var3 >> 4;
      this.field1313[1] = var3 & 15;
      if(var3 != 0) {
         this.field1306[0] = var1.method2635();
         this.field1306[1] = var1.method2635();
         int var4 = var1.method2633();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1313[var5]; ++var6) {
               this.field1308[var5][0][var6] = var1.method2635();
               this.field1309[var5][0][var6] = var1.method2635();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1313[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1308[var5][1][var6] = var1.method2635();
                  this.field1309[var5][1][var6] = var1.method2635();
               } else {
                  this.field1308[var5][1][var6] = this.field1308[var5][0][var6];
                  this.field1309[var5][1][var6] = this.field1309[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1306[1] != this.field1306[0]) {
            var2.method1356(var1);
         }
      } else {
         int[] var7 = this.field1306;
         this.field1306[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("g")
   static float method1422(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
