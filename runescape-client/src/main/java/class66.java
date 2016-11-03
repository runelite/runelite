import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class66 {
   @ObfuscatedName("f")
   int[][][] field1296 = new int[2][2][4];
   @ObfuscatedName("c")
   int[][][] field1297 = new int[2][2][4];
   @ObfuscatedName("v")
   int[] field1298 = new int[2];
   @ObfuscatedName("y")
   static float field1299;
   @ObfuscatedName("m")
   static int[][] field1300 = new int[2][8];
   @ObfuscatedName("j")
   static float[][] field1301 = new float[2][8];
   @ObfuscatedName("u")
   static int field1302;
   @ObfuscatedName("k")
   int[] field1303 = new int[2];

   @ObfuscatedName("v")
   final void method1325(Buffer var1, class60 var2) {
      int var3 = var1.method2571();
      this.field1303[0] = var3 >> 4;
      this.field1303[1] = var3 & 15;
      if(var3 != 0) {
         this.field1298[0] = var1.method2691();
         this.field1298[1] = var1.method2691();
         int var4 = var1.method2571();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1303[var5]; ++var6) {
               this.field1296[var5][0][var6] = var1.method2691();
               this.field1297[var5][0][var6] = var1.method2691();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1303[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1296[var5][1][var6] = var1.method2691();
                  this.field1297[var5][1][var6] = var1.method2691();
               } else {
                  this.field1296[var5][1][var6] = this.field1296[var5][0][var6];
                  this.field1297[var5][1][var6] = this.field1297[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1298[1] != this.field1298[0]) {
            var2.method1273(var1);
         }
      } else {
         int[] var7 = this.field1298;
         this.field1298[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("q")
   static float method1326(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("f")
   float method1327(int var1, int var2, float var3) {
      float var4 = (float)this.field1296[var1][0][var2] + var3 * (float)(this.field1296[var1][1][var2] - this.field1296[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1326(var4);
   }

   @ObfuscatedName("k")
   float method1328(int var1, int var2, float var3) {
      float var4 = (float)this.field1297[var1][0][var2] + var3 * (float)(this.field1297[var1][1][var2] - this.field1297[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("c")
   int method1329(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1298[0] + (float)(this.field1298[1] - this.field1298[0]) * var2;
         var3 *= 0.0030517578F;
         field1299 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1302 = (int)(field1299 * 65536.0F);
      }

      if(this.field1303[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1328(var1, 0, var2);
         field1301[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1327(var1, 0, var2));
         field1301[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1303[var1]; ++var4) {
            var3 = this.method1328(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1327(var1, var4, var2));
            float var6 = var3 * var3;
            field1301[var1][var4 * 2 + 1] = field1301[var1][var4 * 2 - 1] * var6;
            field1301[var1][var4 * 2] = field1301[var1][var4 * 2 - 1] * var5 + field1301[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1301[var1][var7] += field1301[var1][var7 - 1] * var5 + field1301[var1][var7 - 2] * var6;
            }

            field1301[var1][1] += field1301[var1][0] * var5 + var6;
            field1301[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1303[0] * 2; ++var4) {
               field1301[0][var4] *= field1299;
            }
         }

         for(var4 = 0; var4 < this.field1303[var1] * 2; ++var4) {
            field1300[var1][var4] = (int)(field1301[var1][var4] * 65536.0F);
         }

         return this.field1303[var1] * 2;
      }
   }
}
