import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dc")
@Implements("SoundEffect3")
public class SoundEffect3 {
   @ObfuscatedName("j")
   static int field1715;
   @ObfuscatedName("t")
   int[][][] field1716;
   @ObfuscatedName("s")
   int[] field1717;
   @ObfuscatedName("r")
   static float[][] field1718;
   @ObfuscatedName("v")
   static int[][] field1719;
   @ObfuscatedName("y")
   static float field1720;
   @ObfuscatedName("i")
   int[] field1721;
   @ObfuscatedName("a")
   int[][][] field1724;

   SoundEffect3() {
      this.field1721 = new int[2];
      this.field1724 = new int[2][2][4];
      this.field1716 = new int[2][2][4];
      this.field1717 = new int[2];
   }

   @ObfuscatedName("w")
   static float method2273(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("a")
   float method2274(int var1, int var2, float var3) {
      float var4 = (float)this.field1724[var1][0][var2] + var3 * (float)(this.field1724[var1][1][var2] - this.field1724[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method2273(var4);
   }

   @ObfuscatedName("t")
   int method2275(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1717[0] + (float)(this.field1717[1] - this.field1717[0]) * var2;
         var3 *= 0.0030517578F;
         field1720 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1715 = (int)(field1720 * 65536.0F);
      }

      if(this.field1721[var1] == 0) {
         return 0;
      } else {
         var3 = this.method2287(var1, 0, var2);
         field1718[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method2274(var1, 0, var2));
         field1718[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1721[var1]; ++var4) {
            var3 = this.method2287(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method2274(var1, var4, var2));
            float var6 = var3 * var3;
            field1718[var1][var4 * 2 + 1] = field1718[var1][var4 * 2 - 1] * var6;
            field1718[var1][var4 * 2] = field1718[var1][var4 * 2 - 1] * var5 + field1718[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1718[var1][var7] += field1718[var1][var7 - 1] * var5 + field1718[var1][var7 - 2] * var6;
            }

            field1718[var1][1] += field1718[var1][0] * var5 + var6;
            field1718[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1721[0] * 2; ++var4) {
               field1718[0][var4] *= field1720;
            }
         }

         for(var4 = 0; var4 < this.field1721[var1] * 2; ++var4) {
            field1719[var1][var4] = (int)(field1718[var1][var4] * 65536.0F);
         }

         return this.field1721[var1] * 2;
      }
   }

   @ObfuscatedName("s")
   final void method2277(Buffer var1, AudioEnvelope var2) {
      int var3 = var1.readUnsignedByte();
      this.field1721[0] = var3 >> 4;
      this.field1721[1] = var3 & 15;
      if(var3 != 0) {
         this.field1717[0] = var1.readUnsignedShort();
         this.field1717[1] = var1.readUnsignedShort();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1721[var5]; ++var6) {
               this.field1724[var5][0][var6] = var1.readUnsignedShort();
               this.field1716[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1721[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1724[var5][1][var6] = var1.readUnsignedShort();
                  this.field1716[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1724[var5][1][var6] = this.field1724[var5][0][var6];
                  this.field1716[var5][1][var6] = this.field1716[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1717[1] != this.field1717[0]) {
            var2.method2067(var1);
         }
      } else {
         int[] var7 = this.field1717;
         this.field1717[1] = 0;
         var7[0] = 0;
      }

   }

   static {
      field1718 = new float[2][8];
      field1719 = new int[2][8];
   }

   @ObfuscatedName("i")
   float method2287(int var1, int var2, float var3) {
      float var4 = (float)this.field1716[var1][0][var2] + var3 * (float)(this.field1716[var1][1][var2] - this.field1716[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }
}
