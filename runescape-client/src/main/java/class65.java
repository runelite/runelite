import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class65 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1680470545
   )
   int field1090;
   @ObfuscatedName("h")
   int[][] field1092;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -697074577
   )
   int field1094;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-52"
   )
   byte[] method1222(byte[] var1) {
      if(null != this.field1092) {
         int var2 = 14 + (int)((long)this.field1094 * (long)var1.length / (long)this.field1090);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1092[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
            }

            var5 += this.field1094;
            var9 = var5 / this.field1090;
            var4 += var9;
            var5 -= this.field1090 * var9;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1840274985"
   )
   int method1223(int var1) {
      if(this.field1092 != null) {
         var1 = (int)((long)this.field1094 * (long)var1 / (long)this.field1090);
      }

      return var1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-2072506396"
   )
   static final int method1224(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class10.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class10.tileHeights[var5][var3 + 1][var4] * var6 + (128 - var6) * class10.tileHeights[var5][var3][var4] >> 7;
         int var9 = class10.tileHeights[var5][var3 + 1][var4 + 1] * var6 + (128 - var6) * class10.tileHeights[var5][var3][1 + var4] >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }

   public class65(int var1, int var2) {
      if(var1 != var2) {
         int var3 = class108.method2100(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1090 = var1;
         this.field1094 = var2;
         this.field1092 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1092[var4];
            double var6 = (double)var4 / (double)var1 + 6.0D;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = ((double)var8 - var6) * 3.141592653589793D;
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(0.5D + var14 * 65536.0D);
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1422660233"
   )
   int method1229(int var1) {
      if(this.field1092 != null) {
         var1 = 6 + (int)((long)var1 * (long)this.field1094 / (long)this.field1090);
      }

      return var1;
   }
}
