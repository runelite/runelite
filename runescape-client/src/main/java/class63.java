import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class63 {
   @ObfuscatedName("j")
   int[][][] field1203 = new int[2][2][4];
   @ObfuscatedName("b")
   int[] field1204 = new int[2];
   @ObfuscatedName("c")
   static float field1205;
   @ObfuscatedName("d")
   int[][][] field1206 = new int[2][2][4];
   @ObfuscatedName("x")
   int[] field1207 = new int[2];
   @ObfuscatedName("y")
   static float[][] field1208 = new float[2][8];
   @ObfuscatedName("r")
   static int[][] field1209 = new int[2][8];
   @ObfuscatedName("l")
   static int field1211;

   @ObfuscatedName("b")
   float method1290(int var1, int var2, float var3) {
      float var4 = (float)this.field1206[var1][0][var2] + var3 * (float)(this.field1206[var1][1][var2] - this.field1206[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("j")
   float method1292(int var1, int var2, float var3) {
      float var4 = (float)this.field1203[var1][0][var2] + var3 * (float)(this.field1203[var1][1][var2] - this.field1203[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1306(var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IF)I",
      garbageValue = "0"
   )
   int method1293(int var1, float var2) {
      float var3 = (float)this.field1207[0] + (float)(this.field1207[1] - this.field1207[0]) * var2;
      var3 *= 0.0030517578F;
      field1205 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
      field1211 = (int)(field1205 * 65536.0F);
      if(this.field1204[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1290(var1, 0, var2);
         field1208[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1292(var1, 0, var2));
         field1208[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1204[var1]; ++var4) {
            var3 = this.method1290(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1292(var1, var4, var2));
            float var6 = var3 * var3;
            field1208[var1][var4 * 2 + 1] = field1208[var1][var4 * 2 - 1] * var6;
            field1208[var1][var4 * 2] = field1208[var1][var4 * 2 - 1] * var5 + field1208[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1208[var1][var7] += field1208[var1][var7 - 1] * var5 + field1208[var1][var7 - 2] * var6;
            }

            field1208[var1][1] += field1208[var1][0] * var5 + var6;
            field1208[var1][0] += var5;
         }

         for(var4 = 0; var4 < this.field1204[0] * 2; ++var4) {
            field1208[0][var4] *= field1205;
         }

         for(var4 = 0; var4 < this.field1204[var1] * 2; ++var4) {
            field1209[var1][var4] = (int)(field1208[var1][var4] * 65536.0F);
         }

         return this.field1204[var1] * 2;
      }
   }

   @ObfuscatedName("x")
   final void method1294(class119 var1, class57 var2) {
      int var3 = var1.method2514();
      this.field1204[0] = var3 >> 4;
      this.field1204[1] = var3 & 15;
      if(var3 != 0) {
         this.field1207[0] = var1.method2516();
         this.field1207[1] = var1.method2516();
         int var7 = var1.method2514();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1204[var5]; ++var6) {
               this.field1203[var5][0][var6] = var1.method2516();
               this.field1206[var5][0][var6] = var1.method2516();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1204[var5]; ++var6) {
               if((var7 & 1 << var5 * 4 << var6) != 0) {
                  this.field1203[var5][1][var6] = var1.method2516();
                  this.field1206[var5][1][var6] = var1.method2516();
               } else {
                  this.field1203[var5][1][var6] = this.field1203[var5][0][var6];
                  this.field1206[var5][1][var6] = this.field1206[var5][0][var6];
               }
            }
         }

         if(var7 != 0 || this.field1207[1] != this.field1207[0]) {
            var2.method1246(var1);
         }
      } else {
         int[] var4 = this.field1207;
         this.field1207[1] = 0;
         var4[0] = 0;
      }

   }

   @ObfuscatedName("g")
   static float method1306(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
