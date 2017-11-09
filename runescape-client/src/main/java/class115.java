import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public class class115 {
   @ObfuscatedName("d")
   @Export("userHome")
   public static String userHome;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -909791305
   )
   int field1600;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1980010065
   )
   int field1605;
   @ObfuscatedName("x")
   int[][] field1602;

   public class115(int var1, int var2) {
      if(var2 != var1) {
         int var3 = MilliTimer.method3043(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1600 = var1;
         this.field1605 = var2;
         this.field1602 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1602[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(var6 - 7.0D + 1.0D);
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
               var5[var8] = (int)Math.floor(var14 * 65536.0D + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-654291072"
   )
   byte[] method2203(byte[] var1) {
      if(this.field1602 != null) {
         int var2 = (int)((long)this.field1605 * (long)var1.length / (long)this.field1600) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1602[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.field1605;
            var9 = var5 / this.field1600;
            var4 += var9;
            var5 -= var9 * this.field1600;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + 32768 >> 16;
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1015163325"
   )
   int method2202(int var1) {
      if(this.field1602 != null) {
         var1 = (int)((long)this.field1605 * (long)var1 / (long)this.field1600);
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-12"
   )
   int method2208(int var1) {
      if(this.field1602 != null) {
         var1 = (int)((long)this.field1605 * (long)var1 / (long)this.field1600) + 6;
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-76"
   )
   public static boolean method2210(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIS)I",
      garbageValue = "-8905"
   )
   static final int method2211(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) + ((var0 & 65280) * var3 + (var1 & 65280) * var2 & 16711680) >> 8;
   }
}
