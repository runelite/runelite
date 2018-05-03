import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("Resampler")
public class Resampler {
   @ObfuscatedName("po")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -4286262569391723657L
   )
   static long field1592;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1585228139
   )
   @Export("storedSampleRateRatio")
   int storedSampleRateRatio;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -97144149
   )
   @Export("playbackSampleRateRatio")
   int playbackSampleRateRatio;
   @ObfuscatedName("l")
   @Export("resampleTable")
   int[][] resampleTable;

   public Resampler(int var1, int var2) {
      if(var2 != var1) {
         int var3 = OwnWorldComparator.method1266(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.storedSampleRateRatio = var1;
         this.playbackSampleRateRatio = var2;
         this.resampleTable = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.resampleTable[var4];
            double var6 = (double)var4 / (double)var1 + 6.0D;
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

               var14 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var8 - var6));
               var5[var8] = (int)Math.floor(0.5D + 65536.0D * var14);
            }
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1690535032"
   )
   @Export("resampleIfNecessary")
   byte[] resampleIfNecessary(byte[] var1) {
      if(this.resampleTable != null) {
         int var2 = (int)((long)this.playbackSampleRateRatio * (long)var1.length / (long)this.storedSampleRateRatio) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.resampleTable[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-126"
   )
   int method2392(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)var1 * (long)this.playbackSampleRateRatio / (long)this.storedSampleRateRatio);
      }

      return var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1392261444"
   )
   int method2388(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)var1 * (long)this.playbackSampleRateRatio / (long)this.storedSampleRateRatio) + 6;
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIB)Llv;",
      garbageValue = "0"
   )
   static SpritePixels method2387(int var0, int var1, int var2) {
      return (SpritePixels)WorldMapRegion.field472.method4019(class167.method3334(var0, var1, var2));
   }

   @ObfuscatedName("b")
   public static String method2393(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class316.field3925[(int)(var6 - 37L * var0)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
