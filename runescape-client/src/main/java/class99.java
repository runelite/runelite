import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("ItemLayer")
public final class class99 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 616244989
   )
   @Export("y")
   int field1652;
   @ObfuscatedName("d")
   @Export("bottom")
   class85 field1654;
   @ObfuscatedName("y")
   @Export("top")
   class85 field1655;
   @ObfuscatedName("x")
   @Export("middle")
   class85 field1656;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1725272561
   )
   @Export("height")
   int field1657;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -107474319
   )
   @Export("flags")
   int field1658;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2002987333
   )
   @Export("hash")
   int field1659;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 1607836731
   )
   static int field1660;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 388277691
   )
   @Export("x")
   int field1664;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1282886034"
   )
   static void method2201() {
      for(class23 var0 = (class23)class23.field606.method3844(); var0 != null; var0 = (class23)class23.field606.method3834()) {
         if(var0.field607 != null) {
            class52.field1134.method1132(var0.field607);
            var0.field607 = null;
         }

         if(var0.field610 != null) {
            class52.field1134.method1132(var0.field610);
            var0.field610 = null;
         }
      }

      class23.field606.method3823();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass25;",
      garbageValue = "1412817634"
   )
   static class25 method2202() {
      return class25.field633 < class25.field627?class25.field635[++class25.field633 - 1]:null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "57"
   )
   @Export("widgetReset")
   static final void method2203() {
      class46.field1028.method3755();
      class74.method1626();
      class44.field1008.method3755();
      class109.method2430();
      class39.field861.method3755();
      class39.field862.method3755();
      class37.method764();
      class42.field972.method3755();
      class42.field961.method3755();
      class43.field984.method3755();
      class43.field993.method3755();
      class136.method2941();
      class52.field1130.method3755();
      class111.method2438();
      class173.field2742.method3755();
      class173.field2743.method3755();
      class173.field2744.method3755();
      class173.field2801.method3755();
      ((class95)class91.field1560).method2179();
      class22.field594.method3755();
      client.field317.method3279();
      class8.field137.method3279();
      class50.field1071.method3279();
      client.field466.method3279();
      class35.field771.method3279();
      client.field358.method3279();
      class21.field583.method3279();
      class129.field2038.method3279();
      class168.field2692.method3279();
      class12.field186.method3279();
      class84.field1422.method3279();
      class172.field2735.method3279();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1782169375"
   )
   static final void method2204() {
      int var0 = class11.field167 * 128 + 64;
      int var1 = 64 + class130.field2047 * 128;
      int var2 = class108.method2413(var0, var1, class144.field2193) - field1660;
      if(class28.field670 < var0) {
         class28.field670 += class75.field1343 + class17.field244 * (var0 - class28.field670) / 1000;
         if(class28.field670 > var0) {
            class28.field670 = var0;
         }
      }

      if(class28.field670 > var0) {
         class28.field670 -= class75.field1343 + (class28.field670 - var0) * class17.field244 / 1000;
         if(class28.field670 < var0) {
            class28.field670 = var0;
         }
      }

      if(class59.field1188 < var2) {
         class59.field1188 += class17.field244 * (var2 - class59.field1188) / 1000 + class75.field1343;
         if(class59.field1188 > var2) {
            class59.field1188 = var2;
         }
      }

      if(class59.field1188 > var2) {
         class59.field1188 -= class17.field244 * (class59.field1188 - var2) / 1000 + class75.field1343;
         if(class59.field1188 < var2) {
            class59.field1188 = var2;
         }
      }

      if(client.field478 < var1) {
         client.field478 += class17.field244 * (var1 - client.field478) / 1000 + class75.field1343;
         if(client.field478 > var1) {
            client.field478 = var1;
         }
      }

      if(client.field478 > var1) {
         client.field478 -= class75.field1343 + class17.field244 * (client.field478 - var1) / 1000;
         if(client.field478 < var1) {
            client.field478 = var1;
         }
      }

      var0 = class8.field134 * 128 + 64;
      var1 = 64 + class181.field2934 * 128;
      var2 = class108.method2413(var0, var1, class144.field2193) - class10.field159;
      int var3 = var0 - class28.field670;
      int var4 = var2 - class59.field1188;
      int var5 = var1 - client.field478;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class156.field2286 < var7) {
         class156.field2286 += class41.field951 + class114.field1950 * (var7 - class156.field2286) / 1000;
         if(class156.field2286 > var7) {
            class156.field2286 = var7;
         }
      }

      if(class156.field2286 > var7) {
         class156.field2286 -= class41.field951 + (class156.field2286 - var7) * class114.field1950 / 1000;
         if(class156.field2286 < var7) {
            class156.field2286 = var7;
         }
      }

      int var9 = var8 - class149.field2224;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class149.field2224 += class41.field951 + var9 * class114.field1950 / 1000;
         class149.field2224 &= 2047;
      }

      if(var9 < 0) {
         class149.field2224 -= class41.field951 + -var9 * class114.field1950 / 1000;
         class149.field2224 &= 2047;
      }

      int var10 = var8 - class149.field2224;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class149.field2224 = var8;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "14"
   )
   public static int method2205(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1945538247"
   )
   static void method2206(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != class25.field639[var5]) {
            var2[var4] = class25.field639[var5];
            var3[var4] = class25.field647[var5];
            ++var4;
         }
      }

      class25.field639 = var2;
      class25.field647 = var3;
      class16.method177(class25.field635, 0, class25.field635.length - 1, class25.field639, class25.field647);
   }
}
