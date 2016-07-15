import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bv")
public class class66 {
   @ObfuscatedName("r")
   int[] field1307 = new int[2];
   @ObfuscatedName("h")
   int[][][] field1308 = new int[2][2][4];
   @ObfuscatedName("a")
   static float[][] field1310 = new float[2][8];
   @ObfuscatedName("b")
   static int[][] field1311 = new int[2][8];
   @ObfuscatedName("u")
   static float field1312;
   @ObfuscatedName("o")
   static int field1313;
   @ObfuscatedName("c")
   int[][][] field1314 = new int[2][2][4];
   @ObfuscatedName("e")
   int[] field1316 = new int[2];

   @ObfuscatedName("l")
   static float method1386(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("c")
   float method1387(int var1, int var2, float var3) {
      float var4 = (float)this.field1314[var1][0][var2] + var3 * (float)(this.field1314[var1][1][var2] - this.field1314[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1386(var4);
   }

   @ObfuscatedName("h")
   int method1388(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1307[0] + (float)(this.field1307[1] - this.field1307[0]) * var2;
         var3 *= 0.0030517578F;
         field1312 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1313 = (int)(field1312 * 65536.0F);
      }

      if(this.field1316[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1403(var1, 0, var2);
         field1310[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1387(var1, 0, var2));
         field1310[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1316[var1]; ++var4) {
            var3 = this.method1403(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1387(var1, var4, var2));
            float var6 = var3 * var3;
            field1310[var1][var4 * 2 + 1] = field1310[var1][var4 * 2 - 1] * var6;
            field1310[var1][var4 * 2] = field1310[var1][var4 * 2 - 1] * var5 + field1310[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1310[var1][var7] += field1310[var1][var7 - 1] * var5 + field1310[var1][var7 - 2] * var6;
            }

            field1310[var1][1] += field1310[var1][0] * var5 + var6;
            field1310[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1316[0] * 2; ++var4) {
               field1310[0][var4] *= field1312;
            }
         }

         for(var4 = 0; var4 < this.field1316[var1] * 2; ++var4) {
            field1311[var1][var4] = (int)(field1310[var1][var4] * 65536.0F);
         }

         return this.field1316[var1] * 2;
      }
   }

   @ObfuscatedName("r")
   final void method1389(class122 var1, class60 var2) {
      int var3 = var1.method2610();
      this.field1316[0] = var3 >> 4;
      this.field1316[1] = var3 & 15;
      if(var3 != 0) {
         this.field1307[0] = var1.method2612();
         this.field1307[1] = var1.method2612();
         int var7 = var1.method2610();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1316[var5]; ++var6) {
               this.field1314[var5][0][var6] = var1.method2612();
               this.field1308[var5][0][var6] = var1.method2612();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1316[var5]; ++var6) {
               if((var7 & 1 << var5 * 4 << var6) != 0) {
                  this.field1314[var5][1][var6] = var1.method2612();
                  this.field1308[var5][1][var6] = var1.method2612();
               } else {
                  this.field1314[var5][1][var6] = this.field1314[var5][0][var6];
                  this.field1308[var5][1][var6] = this.field1308[var5][0][var6];
               }
            }
         }

         if(var7 != 0 || this.field1307[1] != this.field1307[0]) {
            var2.method1329(var1);
         }
      } else {
         int[] var4 = this.field1307;
         this.field1307[1] = 0;
         var4[0] = 0;
      }

   }

   @ObfuscatedName("e")
   float method1403(int var1, int var2, float var3) {
      float var4 = (float)this.field1308[var1][0][var2] + var3 * (float)(this.field1308[var1][1][var2] - this.field1308[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }
}
