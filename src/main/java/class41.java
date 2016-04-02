import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class41 extends class204 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 514432139
   )
   int field949 = 0;
   @ObfuscatedName("w")
   public static class193 field950 = new class193(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1048554483
   )
   public int field951;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1911822321
   )
   public int field953;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1559779509
   )
   public int field954;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 708643525
   )
   public int field955;
   @ObfuscatedName("e")
   public static class167 field959;

   @ObfuscatedName("e")
   public void method839() {
      this.method853(this.field949);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1994080787"
   )
   static final void method840() {
      short var0 = 256;
      int var1;
      if(class31.field701 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field701 > 768) {
               class48.field1061[var1] = class188.method3743(class27.field655[var1], class14.field212[var1], 1024 - class31.field701);
            } else if(class31.field701 > 256) {
               class48.field1061[var1] = class14.field212[var1];
            } else {
               class48.field1061[var1] = class188.method3743(class14.field212[var1], class27.field655[var1], 256 - class31.field701);
            }
         }
      } else if(class31.field693 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field693 > 768) {
               class48.field1061[var1] = class188.method3743(class27.field655[var1], class143.field2187[var1], 1024 - class31.field693);
            } else if(class31.field693 > 256) {
               class48.field1061[var1] = class143.field2187[var1];
            } else {
               class48.field1061[var1] = class188.method3743(class143.field2187[var1], class27.field655[var1], 256 - class31.field693);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class48.field1061[var1] = class27.field655[var1];
         }
      }

      class79.method1803(class31.field696, 9, class31.field696 + 128, 7 + var0);
      class31.field720.method1741(class31.field696, 0);
      class79.method1802();
      var1 = 0;
      int var2 = class134.field2070.field1366 * 9 + class31.field696;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class31.field708[var3] / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class77.field1369[var1++];
            if(0 != var7) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class48.field1061[var7];
               var10 = class134.field2070.field1361[var2];
               class134.field2070.field1361[var2++] = ((var7 & '\uff00') * var8 + var9 * (var10 & '\uff00') & 16711680) + ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += class134.field2070.field1366 + var5 - 128;
      }

      class79.method1803(class31.field696 + 765 - 128, 9, 765 + class31.field696, var0 + 7);
      class13.field199.method1741(class31.field696 + 382, 0);
      class79.method1802();
      var1 = 0;
      var2 = class31.field696 + 637 + 24 + class134.field2070.field1366 * 9;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class31.field708[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class77.field1369[var1++];
            if(0 != var7) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class48.field1061[var7];
               var10 = class134.field2070.field1361[var2];
               class134.field2070.field1361[var2++] = (var9 * (var10 & 16711935) + (var7 & 16711935) * var8 & -16711936) + ((var7 & '\uff00') * var8 + var9 * (var10 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class134.field2070.field1366 - var5 - var4;
      }

   }

   @ObfuscatedName("w")
   public void method841(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(0 == var2) {
            return;
         }

         this.method842(var1, var2);
      }
   }

   @ObfuscatedName("f")
   void method842(class119 var1, int var2) {
      if(var2 == 1) {
         this.field949 = var1.method2527();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1203407483"
   )
   void method853(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field953 = (int)(256.0D * var14);
      this.field954 = (int)(256.0D * var16);
      if(this.field953 < 0) {
         this.field953 = 0;
      } else if(this.field953 > 255) {
         this.field953 = 255;
      }

      if(this.field954 < 0) {
         this.field954 = 0;
      } else if(this.field954 > 255) {
         this.field954 = 255;
      }

      if(var16 > 0.5D) {
         this.field951 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field951 = (int)(512.0D * var14 * var16);
      }

      if(this.field951 < 1) {
         this.field951 = 1;
      }

      this.field955 = (int)((double)this.field951 * var12);
   }

   @ObfuscatedName("n")
   static class78 method854() {
      class78 var0 = new class78();
      var0.field1372 = class76.field1356;
      var0.field1376 = class76.field1354;
      var0.field1373 = class76.field1357[0];
      var0.field1374 = class84.field1437[0];
      var0.field1371 = class5.field86[0];
      var0.field1378 = class76.field1355[0];
      int var1 = var0.field1371 * var0.field1378;
      byte[] var2 = class76.field1352[0];
      var0.field1379 = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.field1379[var3] = class215.field3152[var2[var3] & 255];
      }

      class30.method670();
      return var0;
   }

   @ObfuscatedName("m")
   static class103 method855(int var0) {
      class103 var1 = (class103)class42.field963.method3754((long)var0);
      if(null != var1) {
         return var1;
      } else {
         var1 = class77.method1696(class42.field962, class42.field961, var0, false);
         if(null != var1) {
            class42.field963.method3756(var1, (long)var0);
         }

         return var1;
      }
   }
}
