import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bv")
public class class63 {
   @ObfuscatedName("a")
   static float field1207;
   @ObfuscatedName("p")
   int[] field1211 = new int[2];
   @ObfuscatedName("h")
   static float[][] field1212 = new float[2][8];
   @ObfuscatedName("g")
   static int[][] field1213 = new int[2][8];
   @ObfuscatedName("e")
   int[] field1214 = new int[2];
   @ObfuscatedName("r")
   static int field1215;
   @ObfuscatedName("s")
   int[][][] field1216 = new int[2][2][4];
   @ObfuscatedName("f")
   int[][][] field1218 = new int[2][2][4];

   @ObfuscatedName("w")
   static float method1282(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("f")
   float method1283(int var1, int var2, float var3) {
      float var4 = (float)this.field1218[var1][0][var2] + var3 * (float)(this.field1218[var1][1][var2] - this.field1218[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1282(var4);
   }

   @ObfuscatedName("s")
   int method1284(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1211[0] + (float)(this.field1211[1] - this.field1211[0]) * var2;
         var3 *= 0.0030517578F;
         field1207 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1215 = (int)(field1207 * 65536.0F);
      }

      if(this.field1214[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1288(var1, 0, var2);
         field1212[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1283(var1, 0, var2));
         field1212[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1214[var1]; ++var4) {
            var3 = this.method1288(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1283(var1, var4, var2));
            float var6 = var3 * var3;
            field1212[var1][var4 * 2 + 1] = field1212[var1][var4 * 2 - 1] * var6;
            field1212[var1][var4 * 2] = field1212[var1][var4 * 2 - 1] * var5 + field1212[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1212[var1][var7] += field1212[var1][var7 - 1] * var5 + field1212[var1][var7 - 2] * var6;
            }

            field1212[var1][1] += field1212[var1][0] * var5 + var6;
            field1212[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1214[0] * 2; ++var4) {
               field1212[0][var4] *= field1207;
            }
         }

         for(var4 = 0; var4 < this.field1214[var1] * 2; ++var4) {
            field1213[var1][var4] = (int)(field1212[var1][var4] * 65536.0F);
         }

         return this.field1214[var1] * 2;
      }
   }

   @ObfuscatedName("p")
   final void method1285(class119 var1, class57 var2) {
      int var3 = var1.method2523();
      this.field1214[0] = var3 >> 4;
      this.field1214[1] = var3 & 15;
      if(var3 != 0) {
         this.field1211[0] = var1.method2700();
         this.field1211[1] = var1.method2700();
         int var4 = var1.method2523();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1214[var5]; ++var6) {
               this.field1218[var5][0][var6] = var1.method2700();
               this.field1216[var5][0][var6] = var1.method2700();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1214[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1218[var5][1][var6] = var1.method2700();
                  this.field1216[var5][1][var6] = var1.method2700();
               } else {
                  this.field1218[var5][1][var6] = this.field1218[var5][0][var6];
                  this.field1216[var5][1][var6] = this.field1216[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1211[1] != this.field1211[0]) {
            var2.method1236(var1);
         }
      } else {
         int[] var7 = this.field1211;
         this.field1211[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("e")
   float method1288(int var1, int var2, float var3) {
      float var4 = (float)this.field1216[var1][0][var2] + var3 * (float)(this.field1216[var1][1][var2] - this.field1216[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }
}
