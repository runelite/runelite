import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class63 {
   @ObfuscatedName("b")
   static float field1241;
   @ObfuscatedName("s")
   int[] field1243 = new int[2];
   @ObfuscatedName("p")
   int[][][] field1244 = new int[2][2][4];
   @ObfuscatedName("d")
   int[] field1245 = new int[2];
   @ObfuscatedName("u")
   static float[][] field1246 = new float[2][8];
   @ObfuscatedName("o")
   static int[][] field1247 = new int[2][8];
   @ObfuscatedName("k")
   static int field1249;
   @ObfuscatedName("x")
   int[][][] field1251 = new int[2][2][4];

   @ObfuscatedName("s")
   float method1259(int var1, int var2, float var3) {
      float var4 = (float)this.field1251[var1][0][var2] + var3 * (float)(this.field1251[var1][1][var2] - this.field1251[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("p")
   float method1260(int var1, int var2, float var3) {
      float var4 = (float)this.field1244[var1][0][var2] + var3 * (float)(this.field1244[var1][1][var2] - this.field1244[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1270(var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IF)I",
      garbageValue = "0"
   )
   int method1261(int var1, float var2) {
      float var3 = (float)this.field1245[0] + (float)(this.field1245[1] - this.field1245[0]) * var2;
      var3 *= 0.0030517578F;
      field1241 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
      field1249 = (int)(field1241 * 65536.0F);
      if(this.field1243[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1259(var1, 0, var2);
         field1246[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1260(var1, 0, var2));
         field1246[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1243[var1]; ++var4) {
            var3 = this.method1259(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1260(var1, var4, var2));
            float var6 = var3 * var3;
            field1246[var1][var4 * 2 + 1] = field1246[var1][var4 * 2 - 1] * var6;
            field1246[var1][var4 * 2] = field1246[var1][var4 * 2 - 1] * var5 + field1246[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1246[var1][var7] += field1246[var1][var7 - 1] * var5 + field1246[var1][var7 - 2] * var6;
            }

            field1246[var1][1] += field1246[var1][0] * var5 + var6;
            field1246[var1][0] += var5;
         }

         for(var4 = 0; var4 < this.field1243[0] * 2; ++var4) {
            field1246[0][var4] *= field1241;
         }

         for(var4 = 0; var4 < this.field1243[var1] * 2; ++var4) {
            field1247[var1][var4] = (int)(field1246[var1][var4] * 65536.0F);
         }

         return this.field1243[var1] * 2;
      }
   }

   @ObfuscatedName("d")
   final void method1268(class119 var1, class57 var2) {
      int var3 = var1.method2492();
      this.field1243[0] = var3 >> 4;
      this.field1243[1] = var3 & 15;
      if(var3 != 0) {
         this.field1245[0] = var1.method2584();
         this.field1245[1] = var1.method2584();
         int var4 = var1.method2492();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1243[var5]; ++var6) {
               this.field1244[var5][0][var6] = var1.method2584();
               this.field1251[var5][0][var6] = var1.method2584();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1243[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1244[var5][1][var6] = var1.method2584();
                  this.field1251[var5][1][var6] = var1.method2584();
               } else {
                  this.field1244[var5][1][var6] = this.field1244[var5][0][var6];
                  this.field1251[var5][1][var6] = this.field1251[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1245[1] != this.field1245[0]) {
            var2.method1209(var1);
         }
      } else {
         int[] var7 = this.field1245;
         this.field1245[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("j")
   static float method1270(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
