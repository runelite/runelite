import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("Resampler")
public class Resampler {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -554086911
   )
   @Export("storedSampleRateRatio")
   int storedSampleRateRatio;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -144966917
   )
   @Export("playbackSampleRateRatio")
   int playbackSampleRateRatio;
   @ObfuscatedName("x")
   @Export("resampleTable")
   int[][] resampleTable;

   public Resampler(int var1, int var2) {
      if(var2 != var1) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.storedSampleRateRatio = var1;
         this.playbackSampleRateRatio = var2;
         this.resampleTable = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.resampleTable[var7];
            double var9 = 6.0D + (double)var7 / (double)var1;
            int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(7.0D + var9);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = 3.141592653589793D * ((double)var11 - var9);
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(65536.0D * var17 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1285236461"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "4117"
   )
   int method2286(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)var1 * (long)this.playbackSampleRateRatio / (long)this.storedSampleRateRatio);
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "201385874"
   )
   int method2290(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)var1 * (long)this.playbackSampleRateRatio / (long)this.storedSampleRateRatio) + 6;
      }

      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1281656114"
   )
   static int method2295(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
