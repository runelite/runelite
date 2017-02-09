import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class67 {
   @ObfuscatedName("w")
   int[] field1130 = new int[2];
   @ObfuscatedName("o")
   int[][][] field1132 = new int[2][2][4];
   @ObfuscatedName("r")
   int[][][] field1133 = new int[2][2][4];
   @ObfuscatedName("d")
   static float field1134;
   @ObfuscatedName("j")
   static float[][] field1135 = new float[2][8];
   @ObfuscatedName("q")
   static int[][] field1136 = new int[2][8];
   @ObfuscatedName("k")
   int[] field1137 = new int[2];
   @ObfuscatedName("n")
   static int field1138;

   @ObfuscatedName("k")
   float method1341(int var1, int var2, float var3) {
      float var4 = (float)this.field1133[var1][0][var2] + var3 * (float)(this.field1133[var1][1][var2] - this.field1133[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("y")
   static float method1342(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("o")
   float method1343(int var1, int var2, float var3) {
      float var4 = (float)this.field1132[var1][0][var2] + var3 * (float)(this.field1132[var1][1][var2] - this.field1132[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1342(var4);
   }

   @ObfuscatedName("r")
   int method1344(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1130[0] + (float)(this.field1130[1] - this.field1130[0]) * var2;
         var3 *= 0.0030517578F;
         field1134 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1138 = (int)(field1134 * 65536.0F);
      }

      if(this.field1137[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1341(var1, 0, var2);
         field1135[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1343(var1, 0, var2));
         field1135[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1137[var1]; ++var4) {
            var3 = this.method1341(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1343(var1, var4, var2));
            float var6 = var3 * var3;
            field1135[var1][var4 * 2 + 1] = field1135[var1][var4 * 2 - 1] * var6;
            field1135[var1][var4 * 2] = field1135[var1][var4 * 2 - 1] * var5 + field1135[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1135[var1][var7] += field1135[var1][var7 - 1] * var5 + field1135[var1][var7 - 2] * var6;
            }

            field1135[var1][1] += field1135[var1][0] * var5 + var6;
            field1135[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1137[0] * 2; ++var4) {
               field1135[0][var4] *= field1134;
            }
         }

         for(var4 = 0; var4 < this.field1137[var1] * 2; ++var4) {
            field1136[var1][var4] = (int)(field1135[var1][var4] * 65536.0F);
         }

         return this.field1137[var1] * 2;
      }
   }

   @ObfuscatedName("w")
   final void method1345(Buffer var1, class58 var2) {
      int var3 = var1.readUnsignedByte();
      this.field1137[0] = var3 >> 4;
      this.field1137[1] = var3 & 15;
      if(var3 != 0) {
         this.field1130[0] = var1.readUnsignedShort();
         this.field1130[1] = var1.readUnsignedShort();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1137[var5]; ++var6) {
               this.field1132[var5][0][var6] = var1.readUnsignedShort();
               this.field1133[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1137[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1132[var5][1][var6] = var1.readUnsignedShort();
                  this.field1133[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1132[var5][1][var6] = this.field1132[var5][0][var6];
                  this.field1133[var5][1][var6] = this.field1133[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1130[1] != this.field1130[0]) {
            var2.method1108(var1);
         }
      } else {
         int[] var7 = this.field1130;
         this.field1130[1] = 0;
         var7[0] = 0;
      }

   }
}
