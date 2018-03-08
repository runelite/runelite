import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("Resampler")
public class Resampler {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   public static Font field1590;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 2036146259
   )
   static int field1597;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1951843609
   )
   @Export("storedSampleRateRatio")
   int storedSampleRateRatio;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1124074761
   )
   @Export("playbackSampleRateRatio")
   int playbackSampleRateRatio;
   @ObfuscatedName("b")
   @Export("resampleTable")
   int[][] resampleTable;

   public Resampler(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class169.method3290(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.storedSampleRateRatio = var1;
         this.playbackSampleRateRatio = var2;
         this.resampleTable = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.resampleTable[var4];
            double var6 = (double)var4 / (double)var1 + 6.0D;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "120"
   )
   @Export("resampleIfNecessary")
   byte[] resampleIfNecessary(byte[] var1) {
      if(this.resampleTable != null) {
         int var2 = (int)((long)var1.length * (long)this.playbackSampleRateRatio / (long)this.storedSampleRateRatio) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.resampleTable[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.playbackSampleRateRatio;
            var9 = var5 / this.storedSampleRateRatio;
            var4 += var9;
            var5 -= var9 * this.storedSampleRateRatio;
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1143007816"
   )
   int method2312(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)this.playbackSampleRateRatio * (long)var1 / (long)this.storedSampleRateRatio);
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1457910263"
   )
   int method2309(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)this.playbackSampleRateRatio * (long)var1 / (long)this.storedSampleRateRatio) + 6;
      }

      return var1;
   }

   @ObfuscatedName("t")
   static double method2307(double var0, double var2, double var4) {
      double var8 = (var0 - var2) / var4;
      double var6 = Math.exp(var8 * -var8 / 2.0D) / Math.sqrt(6.283185307179586D);
      return var6 / var4;
   }
}
