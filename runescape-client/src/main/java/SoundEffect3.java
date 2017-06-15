import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dz")
@Implements("SoundEffect3")
public class SoundEffect3 {
   @ObfuscatedName("t")
   int[][][] field1703;
   @ObfuscatedName("f")
   static int field1704;
   @ObfuscatedName("e")
   int[][][] field1705;
   @ObfuscatedName("j")
   static int[][] field1706;
   @ObfuscatedName("w")
   int[] field1707;
   @ObfuscatedName("z")
   static float[][] field1708;
   @ObfuscatedName("i")
   static float field1710;
   @ObfuscatedName("p")
   int[] field1711;

   @ObfuscatedName("m")
   static float method2180(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("e")
   float method2181(int var1, int var2, float var3) {
      float var4 = (float)this.field1705[var1][0][var2] + var3 * (float)(this.field1705[var1][1][var2] - this.field1705[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method2180(var4);
   }

   @ObfuscatedName("t")
   int method2182(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1707[0] + (float)(this.field1707[1] - this.field1707[0]) * var2;
         var3 *= 0.0030517578F;
         field1710 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1704 = (int)(field1710 * 65536.0F);
      }

      if(this.field1711[var1] == 0) {
         return 0;
      } else {
         var3 = this.method2194(var1, 0, var2);
         field1708[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method2181(var1, 0, var2));
         field1708[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1711[var1]; ++var4) {
            var3 = this.method2194(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method2181(var1, var4, var2));
            float var6 = var3 * var3;
            field1708[var1][var4 * 2 + 1] = field1708[var1][var4 * 2 - 1] * var6;
            field1708[var1][var4 * 2] = field1708[var1][var4 * 2 - 1] * var5 + field1708[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1708[var1][var7] += field1708[var1][var7 - 1] * var5 + field1708[var1][var7 - 2] * var6;
            }

            field1708[var1][1] += field1708[var1][0] * var5 + var6;
            field1708[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1711[0] * 2; ++var4) {
               field1708[0][var4] *= field1710;
            }
         }

         for(var4 = 0; var4 < this.field1711[var1] * 2; ++var4) {
            field1706[var1][var4] = (int)(field1708[var1][var4] * 65536.0F);
         }

         return this.field1711[var1] * 2;
      }
   }

   SoundEffect3() {
      this.field1711 = new int[2];
      this.field1705 = new int[2][2][4];
      this.field1703 = new int[2][2][4];
      this.field1707 = new int[2];
   }

   static {
      field1708 = new float[2][8];
      field1706 = new int[2][8];
   }

   @ObfuscatedName("p")
   float method2194(int var1, int var2, float var3) {
      float var4 = (float)this.field1703[var1][0][var2] + var3 * (float)(this.field1703[var1][1][var2] - this.field1703[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("w")
   final void method2196(Buffer var1, AudioEnvelope var2) {
      int var3 = var1.readUnsignedByte();
      this.field1711[0] = var3 >> 4;
      this.field1711[1] = var3 & 15;
      if(var3 != 0) {
         this.field1707[0] = var1.readUnsignedShort();
         this.field1707[1] = var1.readUnsignedShort();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1711[var5]; ++var6) {
               this.field1705[var5][0][var6] = var1.readUnsignedShort();
               this.field1703[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1711[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1705[var5][1][var6] = var1.readUnsignedShort();
                  this.field1703[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1705[var5][1][var6] = this.field1705[var5][0][var6];
                  this.field1703[var5][1][var6] = this.field1703[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1707[1] != this.field1707[0]) {
            var2.method1981(var1);
         }
      } else {
         int[] var7 = this.field1707;
         this.field1707[1] = 0;
         var7[0] = 0;
      }

   }
}
