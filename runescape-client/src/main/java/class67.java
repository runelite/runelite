import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
public class class67 {
   @ObfuscatedName("j")
   static int[][] field1129 = new int[2][8];
   @ObfuscatedName("k")
   static float[][] field1131 = new float[2][8];
   @ObfuscatedName("q")
   int[][][] field1132 = new int[2][2][4];
   @ObfuscatedName("d")
   int[] field1133 = new int[2];
   @ObfuscatedName("s")
   static float field1134;
   @ObfuscatedName("p")
   int[] field1136 = new int[2];
   @ObfuscatedName("o")
   static int field1137;
   @ObfuscatedName("x")
   int[][][] field1138 = new int[2][2][4];

   @ObfuscatedName("x")
   float method1316(int var1, int var2, float var3) {
      float var4 = (float)this.field1138[var1][0][var2] + var3 * (float)(this.field1138[var1][1][var2] - this.field1138[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1318(var4);
   }

   @ObfuscatedName("p")
   float method1317(int var1, int var2, float var3) {
      float var4 = (float)this.field1132[var1][0][var2] + var3 * (float)(this.field1132[var1][1][var2] - this.field1132[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("g")
   static float method1318(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("q")
   int method1321(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1133[0] + (float)(this.field1133[1] - this.field1133[0]) * var2;
         var3 *= 0.0030517578F;
         field1134 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1137 = (int)(field1134 * 65536.0F);
      }

      if(this.field1136[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1317(var1, 0, var2);
         field1131[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1316(var1, 0, var2));
         field1131[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1136[var1]; ++var4) {
            var3 = this.method1317(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1316(var1, var4, var2));
            float var6 = var3 * var3;
            field1131[var1][var4 * 2 + 1] = field1131[var1][var4 * 2 - 1] * var6;
            field1131[var1][var4 * 2] = field1131[var1][var4 * 2 - 1] * var5 + field1131[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1131[var1][var7] += field1131[var1][var7 - 1] * var5 + field1131[var1][var7 - 2] * var6;
            }

            field1131[var1][1] += field1131[var1][0] * var5 + var6;
            field1131[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1136[0] * 2; ++var4) {
               field1131[0][var4] *= field1134;
            }
         }

         for(var4 = 0; var4 < this.field1136[var1] * 2; ++var4) {
            field1129[var1][var4] = (int)(field1131[var1][var4] * 65536.0F);
         }

         return this.field1136[var1] * 2;
      }
   }

   @ObfuscatedName("d")
   final void method1329(Buffer var1, class58 var2) {
      int var3 = var1.readUnsignedByte();
      this.field1136[0] = var3 >> 4;
      this.field1136[1] = var3 & 15;
      if(var3 != 0) {
         this.field1133[0] = var1.readUnsignedShort();
         this.field1133[1] = var1.readUnsignedShort();
         int var7 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1136[var5]; ++var6) {
               this.field1138[var5][0][var6] = var1.readUnsignedShort();
               this.field1132[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1136[var5]; ++var6) {
               if((var7 & 1 << var5 * 4 << var6) != 0) {
                  this.field1138[var5][1][var6] = var1.readUnsignedShort();
                  this.field1132[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1138[var5][1][var6] = this.field1138[var5][0][var6];
                  this.field1132[var5][1][var6] = this.field1132[var5][0][var6];
               }
            }
         }

         if(var7 != 0 || this.field1133[1] != this.field1133[0]) {
            var2.method1075(var1);
         }
      } else {
         int[] var4 = this.field1133;
         this.field1133[1] = 0;
         var4[0] = 0;
      }

   }
}
