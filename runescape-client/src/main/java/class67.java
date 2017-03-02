import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class67 {
   @ObfuscatedName("i")
   int[][][] field1112 = new int[2][2][4];
   @ObfuscatedName("k")
   int[] field1114 = new int[2];
   @ObfuscatedName("t")
   int[][][] field1115 = new int[2][2][4];
   @ObfuscatedName("h")
   static float[][] field1117 = new float[2][8];
   @ObfuscatedName("n")
   static int[][] field1118 = new int[2][8];
   @ObfuscatedName("f")
   static float field1119;
   @ObfuscatedName("a")
   static int field1120;
   @ObfuscatedName("b")
   int[] field1123 = new int[2];

   @ObfuscatedName("l")
   static float method1381(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("i")
   float method1383(int var1, int var2, float var3) {
      float var4 = (float)this.field1112[var1][0][var2] + var3 * (float)(this.field1112[var1][1][var2] - this.field1112[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1381(var4);
   }

   @ObfuscatedName("t")
   int method1384(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1114[0] + (float)(this.field1114[1] - this.field1114[0]) * var2;
         var3 *= 0.0030517578F;
         field1119 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1120 = (int)(field1119 * 65536.0F);
      }

      if(this.field1123[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1388(var1, 0, var2);
         field1117[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1383(var1, 0, var2));
         field1117[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1123[var1]; ++var4) {
            var3 = this.method1388(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1383(var1, var4, var2));
            float var6 = var3 * var3;
            field1117[var1][var4 * 2 + 1] = field1117[var1][var4 * 2 - 1] * var6;
            field1117[var1][var4 * 2] = field1117[var1][var4 * 2 - 1] * var5 + field1117[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1117[var1][var7] += field1117[var1][var7 - 1] * var5 + field1117[var1][var7 - 2] * var6;
            }

            field1117[var1][1] += field1117[var1][0] * var5 + var6;
            field1117[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1123[0] * 2; ++var4) {
               field1117[0][var4] *= field1119;
            }
         }

         for(var4 = 0; var4 < this.field1123[var1] * 2; ++var4) {
            field1118[var1][var4] = (int)(field1117[var1][var4] * 65536.0F);
         }

         return this.field1123[var1] * 2;
      }
   }

   @ObfuscatedName("k")
   final void method1385(Buffer var1, class58 var2) {
      int var3 = var1.readUnsignedByte();
      this.field1123[0] = var3 >> 4;
      this.field1123[1] = var3 & 15;
      if(var3 != 0) {
         this.field1114[0] = var1.readUnsignedShort();
         this.field1114[1] = var1.readUnsignedShort();
         int var7 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1123[var5]; ++var6) {
               this.field1112[var5][0][var6] = var1.readUnsignedShort();
               this.field1115[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1123[var5]; ++var6) {
               if((var7 & 1 << var5 * 4 << var6) != 0) {
                  this.field1112[var5][1][var6] = var1.readUnsignedShort();
                  this.field1115[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1112[var5][1][var6] = this.field1112[var5][0][var6];
                  this.field1115[var5][1][var6] = this.field1115[var5][0][var6];
               }
            }
         }

         if(var7 != 0 || this.field1114[1] != this.field1114[0]) {
            var2.method1165(var1);
         }
      } else {
         int[] var4 = this.field1114;
         this.field1114[1] = 0;
         var4[0] = 0;
      }

   }

   @ObfuscatedName("b")
   float method1388(int var1, int var2, float var3) {
      float var4 = (float)this.field1115[var1][0][var2] + var3 * (float)(this.field1115[var1][1][var2] - this.field1115[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }
}
