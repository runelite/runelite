import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class63 {
   @ObfuscatedName("y")
   int[] field1235 = new int[2];
   @ObfuscatedName("e")
   static float[][] field1237 = new float[2][8];
   @ObfuscatedName("a")
   int[] field1238 = new int[2];
   @ObfuscatedName("s")
   int[][][] field1239 = new int[2][2][4];
   @ObfuscatedName("f")
   int[][][] field1240 = new int[2][2][4];
   @ObfuscatedName("g")
   static int[][] field1241 = new int[2][8];
   @ObfuscatedName("m")
   static float field1242;
   @ObfuscatedName("j")
   static int field1243;

   @ObfuscatedName("a")
   float method1307(int var1, int var2, float var3) {
      float var4 = (float)this.field1239[var1][0][var2] + var3 * (float)(this.field1239[var1][1][var2] - this.field1239[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("f")
   float method1309(int var1, int var2, float var3) {
      float var4 = (float)this.field1240[var1][0][var2] + var3 * (float)(this.field1240[var1][1][var2] - this.field1240[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1311(var4);
   }

   @ObfuscatedName("s")
   int method1310(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1235[0] + (float)(this.field1235[1] - this.field1235[0]) * var2;
         var3 *= 0.0030517578F;
         field1242 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1243 = (int)(field1242 * 65536.0F);
      }

      if(this.field1238[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1307(var1, 0, var2);
         field1237[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1309(var1, 0, var2));
         field1237[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1238[var1]; ++var4) {
            var3 = this.method1307(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1309(var1, var4, var2));
            float var6 = var3 * var3;
            field1237[var1][var4 * 2 + 1] = field1237[var1][var4 * 2 - 1] * var6;
            field1237[var1][var4 * 2] = field1237[var1][var4 * 2 - 1] * var5 + field1237[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1237[var1][var7] += field1237[var1][var7 - 1] * var5 + field1237[var1][var7 - 2] * var6;
            }

            field1237[var1][1] += field1237[var1][0] * var5 + var6;
            field1237[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1238[0] * 2; ++var4) {
               field1237[0][var4] *= field1242;
            }
         }

         for(var4 = 0; var4 < this.field1238[var1] * 2; ++var4) {
            field1241[var1][var4] = (int)(field1237[var1][var4] * 65536.0F);
         }

         return this.field1238[var1] * 2;
      }
   }

   @ObfuscatedName("r")
   static float method1311(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("y")
   final void method1319(class118 var1, class57 var2) {
      int var3 = var1.method2579();
      this.field1238[0] = var3 >> 4;
      this.field1238[1] = var3 & 15;
      if(var3 != 0) {
         this.field1235[0] = var1.method2514();
         this.field1235[1] = var1.method2514();
         int var4 = var1.method2579();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1238[var5]; ++var6) {
               this.field1240[var5][0][var6] = var1.method2514();
               this.field1239[var5][0][var6] = var1.method2514();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1238[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1240[var5][1][var6] = var1.method2514();
                  this.field1239[var5][1][var6] = var1.method2514();
               } else {
                  this.field1240[var5][1][var6] = this.field1240[var5][0][var6];
                  this.field1239[var5][1][var6] = this.field1239[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1235[1] != this.field1235[0]) {
            var2.method1245(var1);
         }
      } else {
         int[] var7 = this.field1235;
         this.field1235[1] = 0;
         var7[0] = 0;
      }

   }
}
