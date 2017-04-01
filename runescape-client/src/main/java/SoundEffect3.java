import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
@Implements("SoundEffect3")
public class SoundEffect3 {
   @ObfuscatedName("u")
   int[][][] field1154 = new int[2][2][4];
   @ObfuscatedName("f")
   int[] field1155 = new int[2];
   @ObfuscatedName("r")
   int[] field1156 = new int[2];
   @ObfuscatedName("o")
   static float[][] field1157 = new float[2][8];
   @ObfuscatedName("l")
   static int[][] field1158 = new int[2][8];
   @ObfuscatedName("h")
   int[][][] field1159 = new int[2][2][4];
   @ObfuscatedName("m")
   static int field1160;
   @ObfuscatedName("n")
   static float field1162;

   @ObfuscatedName("o")
   final void method1362(Buffer var1, SoundEffect2 var2) {
      int var3 = var1.readUnsignedByte();
      this.field1155[0] = var3 >> 4;
      this.field1155[1] = var3 & 15;
      if(var3 != 0) {
         this.field1156[0] = var1.readUnsignedShort();
         this.field1156[1] = var1.readUnsignedShort();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1155[var5]; ++var6) {
               this.field1154[var5][0][var6] = var1.readUnsignedShort();
               this.field1159[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1155[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1154[var5][1][var6] = var1.readUnsignedShort();
                  this.field1159[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1154[var5][1][var6] = this.field1154[var5][0][var6];
                  this.field1159[var5][1][var6] = this.field1159[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1156[1] != this.field1156[0]) {
            var2.method1144(var1);
         }
      } else {
         int[] var7 = this.field1156;
         this.field1156[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("f")
   float method1363(int var1, int var2, float var3) {
      float var4 = (float)this.field1159[var1][0][var2] + var3 * (float)(this.field1159[var1][1][var2] - this.field1159[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("i")
   static float method1364(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("u")
   float method1365(int var1, int var2, float var3) {
      float var4 = (float)this.field1154[var1][0][var2] + var3 * (float)(this.field1154[var1][1][var2] - this.field1154[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1364(var4);
   }

   @ObfuscatedName("r")
   int method1370(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1156[0] + (float)(this.field1156[1] - this.field1156[0]) * var2;
         var3 *= 0.0030517578F;
         field1162 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1160 = (int)(field1162 * 65536.0F);
      }

      if(this.field1155[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1363(var1, 0, var2);
         field1157[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1365(var1, 0, var2));
         field1157[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1155[var1]; ++var4) {
            var3 = this.method1363(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1365(var1, var4, var2));
            float var6 = var3 * var3;
            field1157[var1][var4 * 2 + 1] = field1157[var1][var4 * 2 - 1] * var6;
            field1157[var1][var4 * 2] = field1157[var1][var4 * 2 - 1] * var5 + field1157[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1157[var1][var7] += field1157[var1][var7 - 1] * var5 + field1157[var1][var7 - 2] * var6;
            }

            field1157[var1][1] += field1157[var1][0] * var5 + var6;
            field1157[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1155[0] * 2; ++var4) {
               field1157[0][var4] *= field1162;
            }
         }

         for(var4 = 0; var4 < this.field1155[var1] * 2; ++var4) {
            field1158[var1][var4] = (int)(field1157[var1][var4] * 65536.0F);
         }

         return this.field1155[var1] * 2;
      }
   }
}
