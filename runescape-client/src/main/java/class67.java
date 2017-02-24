import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
public class class67 {
   @ObfuscatedName("n")
   static float[][] field1144 = new float[2][8];
   @ObfuscatedName("r")
   static int[][] field1145 = new int[2][8];
   @ObfuscatedName("h")
   int[][][] field1146 = new int[2][2][4];
   @ObfuscatedName("p")
   int[][][] field1147 = new int[2][2][4];
   @ObfuscatedName("i")
   static int field1148;
   @ObfuscatedName("j")
   int[] field1150 = new int[2];
   @ObfuscatedName("c")
   static float field1151;
   @ObfuscatedName("q")
   int[] field1153 = new int[2];

   @ObfuscatedName("j")
   final void method1380(Buffer var1, class58 var2) {
      int var3 = var1.readUnsignedByte();
      this.field1153[0] = var3 >> 4;
      this.field1153[1] = var3 & 15;
      if(var3 != 0) {
         this.field1150[0] = var1.readUnsignedShort();
         this.field1150[1] = var1.readUnsignedShort();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1153[var5]; ++var6) {
               this.field1146[var5][0][var6] = var1.readUnsignedShort();
               this.field1147[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1153[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1146[var5][1][var6] = var1.readUnsignedShort();
                  this.field1147[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1146[var5][1][var6] = this.field1146[var5][0][var6];
                  this.field1147[var5][1][var6] = this.field1147[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1150[1] != this.field1150[0]) {
            var2.method1172(var1);
         }
      } else {
         int[] var7 = this.field1150;
         this.field1150[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("q")
   float method1381(int var1, int var2, float var3) {
      float var4 = (float)this.field1147[var1][0][var2] + var3 * (float)(this.field1147[var1][1][var2] - this.field1147[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("d")
   static float method1382(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("p")
   int method1384(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1150[0] + (float)(this.field1150[1] - this.field1150[0]) * var2;
         var3 *= 0.0030517578F;
         field1151 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1148 = (int)(field1151 * 65536.0F);
      }

      if(this.field1153[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1381(var1, 0, var2);
         field1144[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1390(var1, 0, var2));
         field1144[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1153[var1]; ++var4) {
            var3 = this.method1381(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1390(var1, var4, var2));
            float var6 = var3 * var3;
            field1144[var1][var4 * 2 + 1] = field1144[var1][var4 * 2 - 1] * var6;
            field1144[var1][var4 * 2] = field1144[var1][var4 * 2 - 1] * var5 + field1144[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1144[var1][var7] += field1144[var1][var7 - 1] * var5 + field1144[var1][var7 - 2] * var6;
            }

            field1144[var1][1] += field1144[var1][0] * var5 + var6;
            field1144[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1153[0] * 2; ++var4) {
               field1144[0][var4] *= field1151;
            }
         }

         for(var4 = 0; var4 < this.field1153[var1] * 2; ++var4) {
            field1145[var1][var4] = (int)(field1144[var1][var4] * 65536.0F);
         }

         return this.field1153[var1] * 2;
      }
   }

   @ObfuscatedName("h")
   float method1390(int var1, int var2, float var3) {
      float var4 = (float)this.field1146[var1][0][var2] + var3 * (float)(this.field1146[var1][1][var2] - this.field1146[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1382(var4);
   }
}
