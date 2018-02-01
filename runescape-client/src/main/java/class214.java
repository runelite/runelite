import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class214 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field2598;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field2593;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field2592;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   public static class215 field2595;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2086115957
   )
   public static int field2596;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1954560121
   )
   public static int field2597;
   @ObfuscatedName("o")
   public static boolean field2594;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   public static Track1 field2599;

   static {
      field2596 = 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "53233045"
   )
   static final void method3948() {
      short var0 = 256;
      int var1;
      if(class89.field1311 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class89.field1311 > 768) {
               TotalQuantityComparator.field284[var1] = WorldComparator.method84(UnitPriceComparator.field300[var1], class238.field3223[var1], 1024 - class89.field1311);
            } else if(class89.field1311 > 256) {
               TotalQuantityComparator.field284[var1] = class238.field3223[var1];
            } else {
               TotalQuantityComparator.field284[var1] = WorldComparator.method84(class238.field3223[var1], UnitPriceComparator.field300[var1], 256 - class89.field1311);
            }
         }
      } else if(class89.field1312 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class89.field1312 > 768) {
               TotalQuantityComparator.field284[var1] = WorldComparator.method84(UnitPriceComparator.field300[var1], class239.field3236[var1], 1024 - class89.field1312);
            } else if(class89.field1312 > 256) {
               TotalQuantityComparator.field284[var1] = class239.field3236[var1];
            } else {
               TotalQuantityComparator.field284[var1] = WorldComparator.method84(class239.field3236[var1], UnitPriceComparator.field300[var1], 256 - class89.field1312);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            TotalQuantityComparator.field284[var1] = UnitPriceComparator.field300[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class89.field1301, 9, class89.field1301 + 128, var0 + 7);
      class89.field1316.method5534(class89.field1301, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = CombatInfo2.rasterProvider.width * 9 + class89.field1301;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class89.field1340[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = NetWriter.field1440[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = TotalQuantityComparator.field284[var7];
               var10 = CombatInfo2.rasterProvider.pixels[var2];
               CombatInfo2.rasterProvider.pixels[var2++] = ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) + (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + CombatInfo2.rasterProvider.width - 128;
      }

      Rasterizer2D.setDrawRegion(class89.field1301 + 765 - 128, 9, class89.field1301 + 765, var0 + 7);
      class295.field3780.method5534(class89.field1301 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = CombatInfo2.rasterProvider.width * 9 + class89.field1301 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class89.field1340[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = NetWriter.field1440[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = TotalQuantityComparator.field284[var7];
               var10 = CombatInfo2.rasterProvider.pixels[var2];
               CombatInfo2.rasterProvider.pixels[var2++] = (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += CombatInfo2.rasterProvider.width - var5 - var4;
      }

   }
}
