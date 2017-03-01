import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bk")
public class class67 {
   @ObfuscatedName("g")
   int[][][] field1146 = new int[2][2][4];
   @ObfuscatedName("a")
   static int field1147;
   @ObfuscatedName("y")
   int[] field1148 = new int[2];
   @ObfuscatedName("p")
   static float[][] field1149 = new float[2][8];
   @ObfuscatedName("j")
   static int[][] field1150 = new int[2][8];
   @ObfuscatedName("m")
   static float field1151;
   @ObfuscatedName("x")
   int[] field1152 = new int[2];
   @ObfuscatedName("v")
   int[][][] field1155 = new int[2][2][4];

   @ObfuscatedName("y")
   final void method1410(Buffer var1, class58 var2) {
      int var3 = var1.readUnsignedByte();
      this.field1152[0] = var3 >> 4;
      this.field1152[1] = var3 & 15;
      if(var3 != 0) {
         this.field1148[0] = var1.readUnsignedShort();
         this.field1148[1] = var1.readUnsignedShort();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1152[var5]; ++var6) {
               this.field1146[var5][0][var6] = var1.readUnsignedShort();
               this.field1155[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1152[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1146[var5][1][var6] = var1.readUnsignedShort();
                  this.field1155[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1146[var5][1][var6] = this.field1146[var5][0][var6];
                  this.field1155[var5][1][var6] = this.field1155[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1148[1] != this.field1148[0]) {
            var2.method1183(var1);
         }
      } else {
         int[] var7 = this.field1148;
         this.field1148[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("x")
   float method1411(int var1, int var2, float var3) {
      float var4 = (float)this.field1155[var1][0][var2] + var3 * (float)(this.field1155[var1][1][var2] - this.field1155[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("g")
   float method1413(int var1, int var2, float var3) {
      float var4 = (float)this.field1146[var1][0][var2] + var3 * (float)(this.field1146[var1][1][var2] - this.field1146[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1423(var4);
   }

   @ObfuscatedName("v")
   int method1414(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1148[0] + (float)(this.field1148[1] - this.field1148[0]) * var2;
         var3 *= 0.0030517578F;
         field1151 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1147 = (int)(field1151 * 65536.0F);
      }

      if(this.field1152[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1411(var1, 0, var2);
         field1149[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1413(var1, 0, var2));
         field1149[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1152[var1]; ++var4) {
            var3 = this.method1411(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1413(var1, var4, var2));
            float var6 = var3 * var3;
            field1149[var1][var4 * 2 + 1] = field1149[var1][var4 * 2 - 1] * var6;
            field1149[var1][var4 * 2] = field1149[var1][var4 * 2 - 1] * var5 + field1149[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1149[var1][var7] += field1149[var1][var7 - 1] * var5 + field1149[var1][var7 - 2] * var6;
            }

            field1149[var1][1] += field1149[var1][0] * var5 + var6;
            field1149[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1152[0] * 2; ++var4) {
               field1149[0][var4] *= field1151;
            }
         }

         for(var4 = 0; var4 < this.field1152[var1] * 2; ++var4) {
            field1150[var1][var4] = (int)(field1149[var1][var4] * 65536.0F);
         }

         return this.field1152[var1] * 2;
      }
   }

   @ObfuscatedName("n")
   static float method1423(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
