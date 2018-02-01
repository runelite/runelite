import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("Resampler")
public class Resampler {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 929715937
   )
   @Export("storedSampleRateRatio")
   int storedSampleRateRatio;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1959640571
   )
   @Export("playbackSampleRateRatio")
   int playbackSampleRateRatio;
   @ObfuscatedName("a")
   @Export("resampleTable")
   int[][] resampleTable;

   public Resampler(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class27.method230(var1, var2);
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

            int var9 = (int)Math.ceil(var6 + 7.0D);
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
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-30"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1473772959"
   )
   int method2272(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)var1 * (long)this.playbackSampleRateRatio / (long)this.storedSampleRateRatio);
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "22"
   )
   int method2273(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)var1 * (long)this.playbackSampleRateRatio / (long)this.storedSampleRateRatio) + 6;
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILfd;Lfg;I)Z",
      garbageValue = "321597523"
   )
   public static final boolean method2278(int var0, int var1, class168 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class167.field2191[var6][var7] = 99;
      class167.field2188[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class167.field2186[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class167.field2192[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class167.field2186[var11];
         var5 = class167.field2192[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3287(1, var4, var5, var3)) {
            GameCanvas.field600 = var4;
            class167.field2190 = var5;
            return true;
         }

         int var15 = class167.field2188[var16][var17] + 1;
         if(var16 > 0 && class167.field2191[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class167.field2186[var18] = var4 - 1;
            class167.field2192[var18] = var5;
            var18 = var18 + 1 & 4095;
            class167.field2191[var16 - 1][var17] = 2;
            class167.field2188[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class167.field2191[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class167.field2186[var18] = var4 + 1;
            class167.field2192[var18] = var5;
            var18 = var18 + 1 & 4095;
            class167.field2191[var16 + 1][var17] = 8;
            class167.field2188[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class167.field2191[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class167.field2186[var18] = var4;
            class167.field2192[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2191[var16][var17 - 1] = 1;
            class167.field2188[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class167.field2191[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class167.field2186[var18] = var4;
            class167.field2192[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2191[var16][var17 + 1] = 4;
            class167.field2188[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class167.field2191[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class167.field2186[var18] = var4 - 1;
            class167.field2192[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2191[var16 - 1][var17 - 1] = 3;
            class167.field2188[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class167.field2191[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class167.field2186[var18] = var4 + 1;
            class167.field2192[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2191[var16 + 1][var17 - 1] = 9;
            class167.field2188[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class167.field2191[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class167.field2186[var18] = var4 - 1;
            class167.field2192[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2191[var16 - 1][var17 + 1] = 6;
            class167.field2188[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class167.field2191[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class167.field2186[var18] = var4 + 1;
            class167.field2192[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2191[var16 + 1][var17 + 1] = 12;
            class167.field2188[var16 + 1][var17 + 1] = var15;
         }
      }

      GameCanvas.field600 = var4;
      class167.field2190 = var5;
      return false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;B)V",
      garbageValue = "11"
   )
   public static void method2281(IndexDataBase var0) {
      class254.field3376 = var0;
   }
}
