import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class66 {
   @ObfuscatedName("e")
   int[][][] field1289 = new int[2][2][4];
   @ObfuscatedName("n")
   int[] field1292 = new int[2];
   @ObfuscatedName("g")
   int[][][] field1293 = new int[2][2][4];
   @ObfuscatedName("u")
   static float[][] field1294 = new float[2][8];
   @ObfuscatedName("d")
   static int[][] field1295 = new int[2][8];
   @ObfuscatedName("l")
   static float field1296;
   @ObfuscatedName("m")
   static int field1297;
   @ObfuscatedName("i")
   int[] field1300 = new int[2];

   @ObfuscatedName("n")
   final void method1326(Buffer var1, class60 var2) {
      int var3 = var1.method2544();
      this.field1300[0] = var3 >> 4;
      this.field1300[1] = var3 & 15;
      if(var3 != 0) {
         this.field1292[0] = var1.method2546();
         this.field1292[1] = var1.method2546();
         int var4 = var1.method2544();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1300[var5]; ++var6) {
               this.field1289[var5][0][var6] = var1.method2546();
               this.field1293[var5][0][var6] = var1.method2546();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1300[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1289[var5][1][var6] = var1.method2546();
                  this.field1293[var5][1][var6] = var1.method2546();
               } else {
                  this.field1289[var5][1][var6] = this.field1289[var5][0][var6];
                  this.field1293[var5][1][var6] = this.field1293[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1292[1] != this.field1292[0]) {
            var2.method1274(var1);
         }
      } else {
         int[] var7 = this.field1292;
         this.field1292[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("i")
   float method1327(int var1, int var2, float var3) {
      float var4 = (float)this.field1293[var1][0][var2] + var3 * (float)(this.field1293[var1][1][var2] - this.field1293[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("e")
   float method1328(int var1, int var2, float var3) {
      float var4 = (float)this.field1289[var1][0][var2] + var3 * (float)(this.field1289[var1][1][var2] - this.field1289[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1339(var4);
   }

   @ObfuscatedName("h")
   static float method1339(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("g")
   int method1340(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1292[0] + (float)(this.field1292[1] - this.field1292[0]) * var2;
         var3 *= 0.0030517578F;
         field1296 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1297 = (int)(field1296 * 65536.0F);
      }

      if(this.field1300[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1327(var1, 0, var2);
         field1294[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1328(var1, 0, var2));
         field1294[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1300[var1]; ++var4) {
            var3 = this.method1327(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1328(var1, var4, var2));
            float var6 = var3 * var3;
            field1294[var1][var4 * 2 + 1] = field1294[var1][var4 * 2 - 1] * var6;
            field1294[var1][var4 * 2] = field1294[var1][var4 * 2 - 1] * var5 + field1294[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1294[var1][var7] += field1294[var1][var7 - 1] * var5 + field1294[var1][var7 - 2] * var6;
            }

            field1294[var1][1] += field1294[var1][0] * var5 + var6;
            field1294[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1300[0] * 2; ++var4) {
               field1294[0][var4] *= field1296;
            }
         }

         for(var4 = 0; var4 < this.field1300[var1] * 2; ++var4) {
            field1295[var1][var4] = (int)(field1294[var1][var4] * 65536.0F);
         }

         return this.field1300[var1] * 2;
      }
   }
}
