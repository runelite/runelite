import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class63 {
   @ObfuscatedName("r")
   static float[][] field1239 = new float[2][8];
   @ObfuscatedName("t")
   int[] field1240 = new int[2];
   @ObfuscatedName("g")
   int[][][] field1241 = new int[2][2][4];
   @ObfuscatedName("h")
   int[][][] field1242 = new int[2][2][4];
   @ObfuscatedName("z")
   int[] field1243 = new int[2];
   @ObfuscatedName("f")
   static int[][] field1245 = new int[2][8];
   @ObfuscatedName("s")
   static float field1246;
   @ObfuscatedName("d")
   static int field1248;

   @ObfuscatedName("i")
   static float method1244(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IF)I",
      garbageValue = "0"
   )
   int method1246(int var1, float var2) {
      float var3 = (float)this.field1243[0] + (float)(this.field1243[1] - this.field1243[0]) * var2;
      var3 *= 0.0030517578F;
      field1246 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
      field1248 = (int)(field1246 * 65536.0F);
      if(this.field1240[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1248(var1, 0, var2);
         field1239[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1254(var1, 0, var2));
         field1239[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1240[var1]; ++var4) {
            var3 = this.method1248(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1254(var1, var4, var2));
            float var6 = var3 * var3;
            field1239[var1][var4 * 2 + 1] = field1239[var1][var4 * 2 - 1] * var6;
            field1239[var1][var4 * 2] = field1239[var1][var4 * 2 - 1] * var5 + field1239[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1239[var1][var7] += field1239[var1][var7 - 1] * var5 + field1239[var1][var7 - 2] * var6;
            }

            field1239[var1][1] += field1239[var1][0] * var5 + var6;
            field1239[var1][0] += var5;
         }

         for(var4 = 0; var4 < this.field1240[0] * 2; ++var4) {
            field1239[0][var4] *= field1246;
         }

         for(var4 = 0; var4 < this.field1240[var1] * 2; ++var4) {
            field1245[var1][var4] = (int)(field1239[var1][var4] * 65536.0F);
         }

         return this.field1240[var1] * 2;
      }
   }

   @ObfuscatedName("z")
   final void method1247(class119 var1, class57 var2) {
      int var3 = var1.method2494();
      this.field1240[0] = var3 >> 4;
      this.field1240[1] = var3 & 15;
      if(var3 != 0) {
         this.field1243[0] = var1.method2470();
         this.field1243[1] = var1.method2470();
         int var7 = var1.method2494();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1240[var5]; ++var6) {
               this.field1241[var5][0][var6] = var1.method2470();
               this.field1242[var5][0][var6] = var1.method2470();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1240[var5]; ++var6) {
               if((var7 & 1 << var5 * 4 << var6) != 0) {
                  this.field1241[var5][1][var6] = var1.method2470();
                  this.field1242[var5][1][var6] = var1.method2470();
               } else {
                  this.field1241[var5][1][var6] = this.field1241[var5][0][var6];
                  this.field1242[var5][1][var6] = this.field1242[var5][0][var6];
               }
            }
         }

         if(var7 != 0 || this.field1243[1] != this.field1243[0]) {
            var2.method1191(var1);
         }
      } else {
         int[] var4 = this.field1243;
         this.field1243[1] = 0;
         var4[0] = 0;
      }

   }

   @ObfuscatedName("t")
   float method1248(int var1, int var2, float var3) {
      float var4 = (float)this.field1242[var1][0][var2] + var3 * (float)(this.field1242[var1][1][var2] - this.field1242[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("g")
   float method1254(int var1, int var2, float var3) {
      float var4 = (float)this.field1241[var1][0][var2] + var3 * (float)(this.field1241[var1][1][var2] - this.field1241[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1244(var4);
   }
}
