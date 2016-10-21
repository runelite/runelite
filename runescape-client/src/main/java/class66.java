import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bp")
public class class66 {
   @ObfuscatedName("m")
   static int[][] field1284 = new int[2][8];
   @ObfuscatedName("k")
   static float field1286;
   @ObfuscatedName("b")
   static float[][] field1287 = new float[2][8];
   @ObfuscatedName("f")
   int[] field1288 = new int[2];
   @ObfuscatedName("t")
   int[][][] field1289 = new int[2][2][4];
   @ObfuscatedName("c")
   static int field1290;
   @ObfuscatedName("v")
   int[] field1292 = new int[2];
   @ObfuscatedName("n")
   int[][][] field1293 = new int[2][2][4];

   @ObfuscatedName("n")
   float method1337(int var1, int var2, float var3) {
      float var4 = (float)this.field1293[var1][0][var2] + var3 * (float)(this.field1293[var1][1][var2] - this.field1293[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1340(var4);
   }

   @ObfuscatedName("t")
   int method1338(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1292[0] + (float)(this.field1292[1] - this.field1292[0]) * var2;
         var3 *= 0.0030517578F;
         field1286 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1290 = (int)(field1286 * 65536.0F);
      }

      if(this.field1288[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1343(var1, 0, var2);
         field1287[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1337(var1, 0, var2));
         field1287[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1288[var1]; ++var4) {
            var3 = this.method1343(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1337(var1, var4, var2));
            float var6 = var3 * var3;
            field1287[var1][var4 * 2 + 1] = field1287[var1][var4 * 2 - 1] * var6;
            field1287[var1][var4 * 2] = field1287[var1][var4 * 2 - 1] * var5 + field1287[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1287[var1][var7] += field1287[var1][var7 - 1] * var5 + field1287[var1][var7 - 2] * var6;
            }

            field1287[var1][1] += field1287[var1][0] * var5 + var6;
            field1287[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1288[0] * 2; ++var4) {
               field1287[0][var4] *= field1286;
            }
         }

         for(var4 = 0; var4 < this.field1288[var1] * 2; ++var4) {
            field1284[var1][var4] = (int)(field1287[var1][var4] * 65536.0F);
         }

         return this.field1288[var1] * 2;
      }
   }

   @ObfuscatedName("v")
   final void method1339(Buffer var1, class60 var2) {
      int var3 = var1.method2656();
      this.field1288[0] = var3 >> 4;
      this.field1288[1] = var3 & 15;
      if(var3 != 0) {
         this.field1292[0] = var1.method2535();
         this.field1292[1] = var1.method2535();
         int var4 = var1.method2656();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1288[var5]; ++var6) {
               this.field1293[var5][0][var6] = var1.method2535();
               this.field1289[var5][0][var6] = var1.method2535();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1288[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1293[var5][1][var6] = var1.method2535();
                  this.field1289[var5][1][var6] = var1.method2535();
               } else {
                  this.field1293[var5][1][var6] = this.field1293[var5][0][var6];
                  this.field1289[var5][1][var6] = this.field1289[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1292[1] != this.field1292[0]) {
            var2.method1277(var1);
         }
      } else {
         int[] var7 = this.field1292;
         this.field1292[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("e")
   static float method1340(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("f")
   float method1343(int var1, int var2, float var3) {
      float var4 = (float)this.field1289[var1][0][var2] + var3 * (float)(this.field1289[var1][1][var2] - this.field1289[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }
}
