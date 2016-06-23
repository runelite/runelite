import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public class class63 {
   @ObfuscatedName("m")
   static float field1251;
   @ObfuscatedName("x")
   int[][][] field1253 = new int[2][2][4];
   @ObfuscatedName("n")
   static int[][] field1254 = new int[2][8];
   @ObfuscatedName("l")
   int[] field1255 = new int[2];
   @ObfuscatedName("d")
   static float[][] field1256 = new float[2][8];
   @ObfuscatedName("f")
   int[] field1257 = new int[2];
   @ObfuscatedName("g")
   static int field1259;
   @ObfuscatedName("b")
   int[][][] field1262 = new int[2][2][4];

   @ObfuscatedName("f")
   float method1341(int var1, int var2, float var3) {
      float var4 = (float)this.field1262[var1][0][var2] + var3 * (float)(this.field1262[var1][1][var2] - this.field1262[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("u")
   static float method1342(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("x")
   float method1343(int var1, int var2, float var3) {
      float var4 = (float)this.field1253[var1][0][var2] + var3 * (float)(this.field1253[var1][1][var2] - this.field1253[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1342(var4);
   }

   @ObfuscatedName("b")
   int method1345(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1255[0] + (float)(this.field1255[1] - this.field1255[0]) * var2;
         var3 *= 0.0030517578F;
         field1251 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1259 = (int)(field1251 * 65536.0F);
      }

      if(this.field1257[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1341(var1, 0, var2);
         field1256[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1343(var1, 0, var2));
         field1256[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1257[var1]; ++var4) {
            var3 = this.method1341(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1343(var1, var4, var2));
            float var6 = var3 * var3;
            field1256[var1][var4 * 2 + 1] = field1256[var1][var4 * 2 - 1] * var6;
            field1256[var1][var4 * 2] = field1256[var1][var4 * 2 - 1] * var5 + field1256[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1256[var1][var7] += field1256[var1][var7 - 1] * var5 + field1256[var1][var7 - 2] * var6;
            }

            field1256[var1][1] += field1256[var1][0] * var5 + var6;
            field1256[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1257[0] * 2; ++var4) {
               field1256[0][var4] *= field1251;
            }
         }

         for(var4 = 0; var4 < this.field1257[var1] * 2; ++var4) {
            field1254[var1][var4] = (int)(field1256[var1][var4] * 65536.0F);
         }

         return this.field1257[var1] * 2;
      }
   }

   @ObfuscatedName("l")
   final void method1350(class119 var1, class57 var2) {
      int var3 = var1.method2554();
      this.field1257[0] = var3 >> 4;
      this.field1257[1] = var3 & 15;
      if(var3 != 0) {
         this.field1255[0] = var1.method2556();
         this.field1255[1] = var1.method2556();
         int var7 = var1.method2554();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1257[var5]; ++var6) {
               this.field1253[var5][0][var6] = var1.method2556();
               this.field1262[var5][0][var6] = var1.method2556();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1257[var5]; ++var6) {
               if((var7 & 1 << var5 * 4 << var6) != 0) {
                  this.field1253[var5][1][var6] = var1.method2556();
                  this.field1262[var5][1][var6] = var1.method2556();
               } else {
                  this.field1253[var5][1][var6] = this.field1253[var5][0][var6];
                  this.field1262[var5][1][var6] = this.field1262[var5][0][var6];
               }
            }
         }

         if(var7 != 0 || this.field1255[1] != this.field1255[0]) {
            var2.method1299(var1);
         }
      } else {
         int[] var4 = this.field1255;
         this.field1255[1] = 0;
         var4[0] = 0;
      }

   }
}
