import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dm")
@Implements("SoundEffect3")
public class SoundEffect3 {
   @ObfuscatedName("e")
   int[][][] field1722;
   @ObfuscatedName("v")
   int[][][] field1723;
   @ObfuscatedName("y")
   static float[][] field1725;
   @ObfuscatedName("b")
   int[] field1726;
   @ObfuscatedName("i")
   int[] field1727;
   @ObfuscatedName("h")
   static int[][] field1728;
   @ObfuscatedName("f")
   static int field1729;
   @ObfuscatedName("x")
   static float field1731;

   @ObfuscatedName("i")
   float method2259(int var1, int var2, float var3) {
      float var4 = (float)this.field1723[var1][0][var2] + var3 * (float)(this.field1723[var1][1][var2] - this.field1723[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("c")
   static float method2261(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("b")
   final void method2262(Buffer var1, SoundEffect2 var2) {
      int var3 = var1.readUnsignedByte();
      this.field1727[0] = var3 >> 4;
      this.field1727[1] = var3 & 15;
      if(var3 != 0) {
         this.field1726[0] = var1.readUnsignedShort();
         this.field1726[1] = var1.readUnsignedShort();
         int var7 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1727[var5]; ++var6) {
               this.field1722[var5][0][var6] = var1.readUnsignedShort();
               this.field1723[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1727[var5]; ++var6) {
               if((var7 & 1 << var5 * 4 << var6) != 0) {
                  this.field1722[var5][1][var6] = var1.readUnsignedShort();
                  this.field1723[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1722[var5][1][var6] = this.field1722[var5][0][var6];
                  this.field1723[var5][1][var6] = this.field1723[var5][0][var6];
               }
            }
         }

         if(var7 != 0 || this.field1726[1] != this.field1726[0]) {
            var2.method2061(var1);
         }
      } else {
         int[] var4 = this.field1726;
         this.field1726[1] = 0;
         var4[0] = 0;
      }

   }

   @ObfuscatedName("v")
   int method2263(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1726[0] + (float)(this.field1726[1] - this.field1726[0]) * var2;
         var3 *= 0.0030517578F;
         field1731 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1729 = (int)(field1731 * 65536.0F);
      }

      if(this.field1727[var1] == 0) {
         return 0;
      } else {
         var3 = this.method2259(var1, 0, var2);
         field1725[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method2271(var1, 0, var2));
         field1725[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1727[var1]; ++var4) {
            var3 = this.method2259(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method2271(var1, var4, var2));
            float var6 = var3 * var3;
            field1725[var1][var4 * 2 + 1] = field1725[var1][var4 * 2 - 1] * var6;
            field1725[var1][var4 * 2] = field1725[var1][var4 * 2 - 1] * var5 + field1725[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1725[var1][var7] += field1725[var1][var7 - 1] * var5 + field1725[var1][var7 - 2] * var6;
            }

            field1725[var1][1] += field1725[var1][0] * var5 + var6;
            field1725[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1727[0] * 2; ++var4) {
               field1725[0][var4] *= field1731;
            }
         }

         for(var4 = 0; var4 < this.field1727[var1] * 2; ++var4) {
            field1728[var1][var4] = (int)(field1725[var1][var4] * 65536.0F);
         }

         return this.field1727[var1] * 2;
      }
   }

   static {
      field1725 = new float[2][8];
      field1728 = new int[2][8];
   }

   SoundEffect3() {
      this.field1727 = new int[2];
      this.field1722 = new int[2][2][4];
      this.field1723 = new int[2][2][4];
      this.field1726 = new int[2];
   }

   @ObfuscatedName("e")
   float method2271(int var1, int var2, float var3) {
      float var4 = (float)this.field1722[var1][0][var2] + var3 * (float)(this.field1722[var1][1][var2] - this.field1722[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method2261(var4);
   }
}
