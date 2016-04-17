import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class63 {
   @ObfuscatedName("d")
   int[][][] field1245 = new int[2][2][4];
   @ObfuscatedName("k")
   static float[][] field1246 = new float[2][8];
   @ObfuscatedName("y")
   int[] field1247 = new int[2];
   @ObfuscatedName("c")
   int[][][] field1248 = new int[2][2][4];
   @ObfuscatedName("r")
   static int[][] field1249 = new int[2][8];
   @ObfuscatedName("p")
   static float field1250;
   @ObfuscatedName("q")
   static int field1251;
   @ObfuscatedName("a")
   int[] field1252 = new int[2];

   @ObfuscatedName("a")
   float method1374(int var1, int var2, float var3) {
      float var4 = (float)this.field1248[var1][0][var2] + var3 * (float)(this.field1248[var1][1][var2] - this.field1248[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IF)I",
      garbageValue = "0"
   )
   int method1375(int var1, float var2) {
      float var3 = (float)this.field1247[0] + (float)(this.field1247[1] - this.field1247[0]) * var2;
      var3 *= 0.0030517578F;
      field1250 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
      field1251 = (int)(field1250 * 65536.0F);
      if(this.field1252[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1374(var1, 0, var2);
         field1246[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1376(var1, 0, var2));
         field1246[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1252[var1]; ++var4) {
            var3 = this.method1374(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1376(var1, var4, var2));
            float var6 = var3 * var3;
            field1246[var1][var4 * 2 + 1] = field1246[var1][var4 * 2 - 1] * var6;
            field1246[var1][var4 * 2] = field1246[var1][var4 * 2 - 1] * var5 + field1246[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1246[var1][var7] += field1246[var1][var7 - 1] * var5 + field1246[var1][var7 - 2] * var6;
            }

            field1246[var1][1] += field1246[var1][0] * var5 + var6;
            field1246[var1][0] += var5;
         }

         for(var4 = 0; var4 < this.field1252[0] * 2; ++var4) {
            field1246[0][var4] *= field1250;
         }

         for(var4 = 0; var4 < this.field1252[var1] * 2; ++var4) {
            field1249[var1][var4] = (int)(field1246[var1][var4] * 65536.0F);
         }

         return this.field1252[var1] * 2;
      }
   }

   @ObfuscatedName("d")
   float method1376(int var1, int var2, float var3) {
      float var4 = (float)this.field1245[var1][0][var2] + var3 * (float)(this.field1245[var1][1][var2] - this.field1245[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1389(var4);
   }

   @ObfuscatedName("y")
   final void method1377(class119 var1, class57 var2) {
      int var3 = var1.method2613();
      this.field1252[0] = var3 >> 4;
      this.field1252[1] = var3 & 15;
      if(var3 != 0) {
         this.field1247[0] = var1.method2615();
         this.field1247[1] = var1.method2615();
         int var4 = var1.method2613();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1252[var5]; ++var6) {
               this.field1245[var5][0][var6] = var1.method2615();
               this.field1248[var5][0][var6] = var1.method2615();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1252[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1245[var5][1][var6] = var1.method2615();
                  this.field1248[var5][1][var6] = var1.method2615();
               } else {
                  this.field1245[var5][1][var6] = this.field1245[var5][0][var6];
                  this.field1248[var5][1][var6] = this.field1248[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1247[1] != this.field1247[0]) {
            var2.method1326(var1);
         }
      } else {
         int[] var7 = this.field1247;
         this.field1247[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("w")
   static float method1389(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
