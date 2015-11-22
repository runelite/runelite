package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class63 {
   @ObfuscatedName("f")
   int[][][] field1223 = new int[2][2][4];
   @ObfuscatedName("j")
   int[] field1226 = new int[2];
   @ObfuscatedName("u")
   int[] field1227 = new int[2];
   @ObfuscatedName("a")
   static float[][] field1228 = new float[2][8];
   @ObfuscatedName("l")
   int[][][] field1229 = new int[2][2][4];
   @ObfuscatedName("i")
   static float field1230;
   @ObfuscatedName("t")
   static int field1231;
   @ObfuscatedName("h")
   static int[][] field1233 = new int[2][8];

   @ObfuscatedName("j")
   float method1324(int var1, int var2, float var3) {
      float var4 = (float)this.field1229[var1][0][var2] + var3 * (float)(this.field1229[var1][1][var2] - this.field1229[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("m")
   static float method1325(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("u")
   final void method1326(class118 var1, class57 var2) {
      int var3 = var1.method2536();
      this.field1226[0] = var3 >> 4;
      this.field1226[1] = var3 & 15;
      if(var3 != 0) {
         this.field1227[0] = var1.method2538();
         this.field1227[1] = var1.method2538();
         int var4 = var1.method2536();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1226[var5]; ++var6) {
               this.field1223[var5][0][var6] = var1.method2538();
               this.field1229[var5][0][var6] = var1.method2538();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1226[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1223[var5][1][var6] = var1.method2538();
                  this.field1229[var5][1][var6] = var1.method2538();
               } else {
                  this.field1223[var5][1][var6] = this.field1223[var5][0][var6];
                  this.field1229[var5][1][var6] = this.field1229[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1227[1] != this.field1227[0]) {
            var2.method1270(var1);
         }
      } else {
         int[] var7 = this.field1227;
         this.field1227[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("f")
   float method1328(int var1, int var2, float var3) {
      float var4 = (float)this.field1223[var1][0][var2] + var3 * (float)(this.field1223[var1][1][var2] - this.field1223[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1325(var4);
   }

   @ObfuscatedName("l")
   int method1335(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1227[0] + (float)(this.field1227[1] - this.field1227[0]) * var2;
         var3 *= 0.0030517578F;
         field1230 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1231 = (int)(field1230 * 65536.0F);
      }

      if(this.field1226[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1324(var1, 0, var2);
         field1228[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1328(var1, 0, var2));
         field1228[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1226[var1]; ++var4) {
            var3 = this.method1324(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1328(var1, var4, var2));
            float var6 = var3 * var3;
            field1228[var1][var4 * 2 + 1] = field1228[var1][var4 * 2 - 1] * var6;
            field1228[var1][var4 * 2] = field1228[var1][var4 * 2 - 1] * var5 + field1228[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1228[var1][var7] += field1228[var1][var7 - 1] * var5 + field1228[var1][var7 - 2] * var6;
            }

            field1228[var1][1] += field1228[var1][0] * var5 + var6;
            field1228[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1226[0] * 2; ++var4) {
               field1228[0][var4] *= field1230;
            }
         }

         for(var4 = 0; var4 < this.field1226[var1] * 2; ++var4) {
            field1233[var1][var4] = (int)(field1228[var1][var4] * 65536.0F);
         }

         return this.field1226[var1] * 2;
      }
   }
}
