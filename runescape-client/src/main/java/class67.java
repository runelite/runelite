import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public class class67 {
   @ObfuscatedName("c")
   static float field1131;
   @ObfuscatedName("b")
   int[][][] field1133 = new int[2][2][4];
   @ObfuscatedName("g")
   int[][][] field1134 = new int[2][2][4];
   @ObfuscatedName("v")
   static float[][] field1136 = new float[2][8];
   @ObfuscatedName("l")
   static int[][] field1137 = new int[2][8];
   @ObfuscatedName("h")
   int[] field1138 = new int[2];
   @ObfuscatedName("u")
   static int field1140;
   @ObfuscatedName("o")
   int[] field1141 = new int[2];

   @ObfuscatedName("o")
   float method1306(int var1, int var2, float var3) {
      float var4 = (float)this.field1134[var1][0][var2] + var3 * (float)(this.field1134[var1][1][var2] - this.field1134[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("g")
   int method1307(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1138[0] + (float)(this.field1138[1] - this.field1138[0]) * var2;
         var3 *= 0.0030517578F;
         field1131 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1140 = (int)(field1131 * 65536.0F);
      }

      if(this.field1141[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1306(var1, 0, var2);
         field1136[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1308(var1, 0, var2));
         field1136[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1141[var1]; ++var4) {
            var3 = this.method1306(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1308(var1, var4, var2));
            float var6 = var3 * var3;
            field1136[var1][var4 * 2 + 1] = field1136[var1][var4 * 2 - 1] * var6;
            field1136[var1][var4 * 2] = field1136[var1][var4 * 2 - 1] * var5 + field1136[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1136[var1][var7] += field1136[var1][var7 - 1] * var5 + field1136[var1][var7 - 2] * var6;
            }

            field1136[var1][1] += field1136[var1][0] * var5 + var6;
            field1136[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1141[0] * 2; ++var4) {
               field1136[0][var4] *= field1131;
            }
         }

         for(var4 = 0; var4 < this.field1141[var1] * 2; ++var4) {
            field1137[var1][var4] = (int)(field1136[var1][var4] * 65536.0F);
         }

         return this.field1141[var1] * 2;
      }
   }

   @ObfuscatedName("b")
   float method1308(int var1, int var2, float var3) {
      float var4 = (float)this.field1133[var1][0][var2] + var3 * (float)(this.field1133[var1][1][var2] - this.field1133[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1319(var4);
   }

   @ObfuscatedName("l")
   final void method1310(Buffer var1, class58 var2) {
      int var3 = var1.readUnsignedByte();
      this.field1141[0] = var3 >> 4;
      this.field1141[1] = var3 & 15;
      if(var3 != 0) {
         this.field1138[0] = var1.readUnsignedShort();
         this.field1138[1] = var1.readUnsignedShort();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1141[var5]; ++var6) {
               this.field1133[var5][0][var6] = var1.readUnsignedShort();
               this.field1134[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1141[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1133[var5][1][var6] = var1.readUnsignedShort();
                  this.field1134[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1133[var5][1][var6] = this.field1133[var5][0][var6];
                  this.field1134[var5][1][var6] = this.field1134[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1138[1] != this.field1138[0]) {
            var2.method1079(var1);
         }
      } else {
         int[] var7 = this.field1138;
         this.field1138[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("m")
   static float method1319(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
