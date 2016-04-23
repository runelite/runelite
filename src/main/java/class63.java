import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class63 {
   @ObfuscatedName("e")
   static float[][] field1218 = new float[2][8];
   @ObfuscatedName("j")
   int[] field1220 = new int[2];
   @ObfuscatedName("z")
   int[][][] field1221 = new int[2][2][4];
   @ObfuscatedName("x")
   int[] field1222 = new int[2];
   @ObfuscatedName("i")
   static int[][] field1224 = new int[2][8];
   @ObfuscatedName("c")
   static float field1225;
   @ObfuscatedName("m")
   int[][][] field1228 = new int[2][2][4];
   @ObfuscatedName("n")
   static int field1229;

   @ObfuscatedName("j")
   float method1280(int var1, int var2, float var3) {
      float var4 = (float)this.field1221[var1][0][var2] + var3 * (float)(this.field1221[var1][1][var2] - this.field1221[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("h")
   static float method1281(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("m")
   float method1282(int var1, int var2, float var3) {
      float var4 = (float)this.field1228[var1][0][var2] + var3 * (float)(this.field1228[var1][1][var2] - this.field1228[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1281(var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IF)I",
      garbageValue = "0"
   )
   int method1283(int var1, float var2) {
      float var3 = (float)this.field1222[0] + (float)(this.field1222[1] - this.field1222[0]) * var2;
      var3 *= 0.0030517578F;
      field1225 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
      field1229 = (int)(field1225 * 65536.0F);
      if(this.field1220[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1280(var1, 0, var2);
         field1218[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1282(var1, 0, var2));
         field1218[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1220[var1]; ++var4) {
            var3 = this.method1280(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1282(var1, var4, var2));
            float var6 = var3 * var3;
            field1218[var1][var4 * 2 + 1] = field1218[var1][var4 * 2 - 1] * var6;
            field1218[var1][var4 * 2] = field1218[var1][var4 * 2 - 1] * var5 + field1218[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1218[var1][var7] += field1218[var1][var7 - 1] * var5 + field1218[var1][var7 - 2] * var6;
            }

            field1218[var1][1] += field1218[var1][0] * var5 + var6;
            field1218[var1][0] += var5;
         }

         for(var4 = 0; var4 < this.field1220[0] * 2; ++var4) {
            field1218[0][var4] *= field1225;
         }

         for(var4 = 0; var4 < this.field1220[var1] * 2; ++var4) {
            field1224[var1][var4] = (int)(field1218[var1][var4] * 65536.0F);
         }

         return this.field1220[var1] * 2;
      }
   }

   @ObfuscatedName("x")
   final void method1284(class119 var1, class57 var2) {
      int var3 = var1.method2500();
      this.field1220[0] = var3 >> 4;
      this.field1220[1] = var3 & 15;
      if(var3 != 0) {
         this.field1222[0] = var1.method2502();
         this.field1222[1] = var1.method2502();
         int var4 = var1.method2500();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1220[var5]; ++var6) {
               this.field1228[var5][0][var6] = var1.method2502();
               this.field1221[var5][0][var6] = var1.method2502();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1220[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1228[var5][1][var6] = var1.method2502();
                  this.field1221[var5][1][var6] = var1.method2502();
               } else {
                  this.field1228[var5][1][var6] = this.field1228[var5][0][var6];
                  this.field1221[var5][1][var6] = this.field1221[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1222[1] != this.field1222[0]) {
            var2.method1225(var1);
         }
      } else {
         int[] var7 = this.field1222;
         this.field1222[1] = 0;
         var7[0] = 0;
      }

   }
}
