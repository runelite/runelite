package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
public class class74 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1360964049
   )
   int field1367;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1523157071
   )
   int field1369;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -1538835479
   )
   @Export("cameraYaw")
   static int field1371;
   @ObfuscatedName("m")
   int[][] field1372;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -1187496983
   )
   static int field1373;
   @ObfuscatedName("if")
   static class172 field1376;
   @ObfuscatedName("ez")
   static class78[] field1378;

   @ObfuscatedName("j")
   byte[] method1583(byte[] var1) {
      if(this.field1372 != null) {
         int var2 = 14 + (int)((long)this.field1367 * (long)var1.length / (long)this.field1369);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1372[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
            }

            var5 += this.field1367;
            var9 = var5 / this.field1369;
            var4 += var9;
            var5 -= this.field1369 * var9;
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

   @ObfuscatedName("l")
   int method1586(int var1) {
      if(this.field1372 != null) {
         var1 = (int)((long)var1 * (long)this.field1367 / (long)this.field1369);
      }

      return var1;
   }

   @ObfuscatedName("a")
   int method1589(int var1) {
      if(this.field1372 != null) {
         var1 = (int)((long)var1 * (long)this.field1367 / (long)this.field1369) + 6;
      }

      return var1;
   }

   public class74(int var1, int var2) {
      if(var1 != var2) {
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
         this.field1369 = var1;
         this.field1367 = var2;
         this.field1372 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1372[var7];
            double var9 = 6.0D + (double)var7 / (double)var1;
            int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(var9 + 7.0D);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = 3.141592653589793D * ((double)var11 - var9);
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var11 - var9));
               var8[var11] = (int)Math.floor(65536.0D * var17 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("dz")
   static final void method1596(int var0, int var1, int var2, int var3, class78 var4, class174 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field374 + client.field522 & 2047;
         int var8 = class90.field1587[var7];
         int var9 = class90.field1590[var7];
         var8 = 256 * var8 / (256 + client.field359);
         var9 = var9 * 256 / (256 + client.field359);
         int var10 = var2 * var9 + var8 * var3 >> 16;
         int var11 = var3 * var9 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         client.field494.method1687(var14 + 94 + var0 + 4 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class38.method763(var0, var1, var2, var3, var4, var5);
      }

   }
}
