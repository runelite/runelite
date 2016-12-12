import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public class class67 {
   @ObfuscatedName("w")
   static int field1134;
   @ObfuscatedName("f")
   int[][][] field1135 = new int[2][2][4];
   @ObfuscatedName("k")
   int[][][] field1136 = new int[2][2][4];
   @ObfuscatedName("g")
   int[] field1137 = new int[2];
   @ObfuscatedName("n")
   static float[][] field1138 = new float[2][8];
   @ObfuscatedName("a")
   static int[][] field1139 = new int[2][8];
   @ObfuscatedName("q")
   static float field1140;
   @ObfuscatedName("i")
   int[] field1141 = new int[2];

   @ObfuscatedName("f")
   float method1305(int var1, int var2, float var3) {
      float var4 = (float)this.field1135[var1][0][var2] + var3 * (float)(this.field1135[var1][1][var2] - this.field1135[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1310(var4);
   }

   @ObfuscatedName("k")
   int method1306(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1137[0] + (float)(this.field1137[1] - this.field1137[0]) * var2;
         var3 *= 0.0030517578F;
         field1140 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1134 = (int)(field1140 * 65536.0F);
      }

      if(this.field1141[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1312(var1, 0, var2);
         field1138[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1305(var1, 0, var2));
         field1138[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1141[var1]; ++var4) {
            var3 = this.method1312(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1305(var1, var4, var2));
            float var6 = var3 * var3;
            field1138[var1][var4 * 2 + 1] = field1138[var1][var4 * 2 - 1] * var6;
            field1138[var1][var4 * 2] = field1138[var1][var4 * 2 - 1] * var5 + field1138[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1138[var1][var7] += field1138[var1][var7 - 1] * var5 + field1138[var1][var7 - 2] * var6;
            }

            field1138[var1][1] += field1138[var1][0] * var5 + var6;
            field1138[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1141[0] * 2; ++var4) {
               field1138[0][var4] *= field1140;
            }
         }

         for(var4 = 0; var4 < this.field1141[var1] * 2; ++var4) {
            field1139[var1][var4] = (int)(field1138[var1][var4] * 65536.0F);
         }

         return this.field1141[var1] * 2;
      }
   }

   @ObfuscatedName("a")
   final void method1307(Buffer var1, class58 var2) {
      int var3 = var1.readUnsignedByte();
      this.field1141[0] = var3 >> 4;
      this.field1141[1] = var3 & 15;
      if(var3 != 0) {
         this.field1137[0] = var1.readUnsignedShort();
         this.field1137[1] = var1.readUnsignedShort();
         int var7 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1141[var5]; ++var6) {
               this.field1135[var5][0][var6] = var1.readUnsignedShort();
               this.field1136[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1141[var5]; ++var6) {
               if((var7 & 1 << var5 * 4 << var6) != 0) {
                  this.field1135[var5][1][var6] = var1.readUnsignedShort();
                  this.field1136[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1135[var5][1][var6] = this.field1135[var5][0][var6];
                  this.field1136[var5][1][var6] = this.field1136[var5][0][var6];
               }
            }
         }

         if(var7 != 0 || this.field1137[1] != this.field1137[0]) {
            var2.method1071(var1);
         }
      } else {
         int[] var4 = this.field1137;
         this.field1137[1] = 0;
         var4[0] = 0;
      }

   }

   @ObfuscatedName("e")
   static float method1310(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("i")
   float method1312(int var1, int var2, float var3) {
      float var4 = (float)this.field1136[var1][0][var2] + var3 * (float)(this.field1136[var1][1][var2] - this.field1136[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }
}
