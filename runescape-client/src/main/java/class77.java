import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class77 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -501770835
   )
   int field1435;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1725046201
   )
   int field1439;
   @ObfuscatedName("s")
   int[][] field1440;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1657076819
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = -1104710225
   )
   static int field1443;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1893369728"
   )
   byte[] method1699(byte[] var1) {
      if(this.field1440 != null) {
         int var2 = (int)((long)var1.length * (long)this.field1439 / (long)this.field1435) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1440[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1439;
            var9 = var5 / this.field1435;
            var4 += var9;
            var5 -= this.field1435 * var9;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = '耀' + var3[var6] >> 16;
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1974673549"
   )
   int method1700(int var1) {
      if(null != this.field1440) {
         var1 = (int)((long)this.field1439 * (long)var1 / (long)this.field1435);
      }

      return var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1332393538"
   )
   int method1701(int var1) {
      if(null != this.field1440) {
         var1 = (int)((long)this.field1439 * (long)var1 / (long)this.field1435) + 6;
      }

      return var1;
   }

   public class77(int var1, int var2) {
      if(var1 != var2) {
         int var3 = class117.method2559(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1435 = var1;
         this.field1439 = var2;
         this.field1440 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1440[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var8 - var6));
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2102002582"
   )
   static int method1708() {
      return 9;
   }
}
