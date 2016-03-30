import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cx")
public final class class93 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2131204619
   )
   int field1596;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1580000801
   )
   int field1597;
   @ObfuscatedName("p")
   public class85 field1599;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -593151139
   )
   public int field1600;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -724666071
   )
   int field1601;
   @ObfuscatedName("u")
   static String field1604;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -297379225
   )
   static int field1607;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1554255059
   )
   int field1608;
   @ObfuscatedName("em")
   static class80[] field1610;

   @ObfuscatedName("w")
   public static byte method2158(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(8364 == var0) {
            var1 = -128;
         } else if(var0 == 8218) {
            var1 = -126;
         } else if(402 == var0) {
            var1 = -125;
         } else if(8222 == var0) {
            var1 = -124;
         } else if(var0 == 8230) {
            var1 = -123;
         } else if(8224 == var0) {
            var1 = -122;
         } else if(var0 == 8225) {
            var1 = -121;
         } else if(710 == var0) {
            var1 = -120;
         } else if(var0 == 8240) {
            var1 = -119;
         } else if(352 == var0) {
            var1 = -118;
         } else if(var0 == 8249) {
            var1 = -117;
         } else if(338 == var0) {
            var1 = -116;
         } else if(var0 == 381) {
            var1 = -114;
         } else if(8216 == var0) {
            var1 = -111;
         } else if(var0 == 8217) {
            var1 = -110;
         } else if(8220 == var0) {
            var1 = -109;
         } else if(8221 == var0) {
            var1 = -108;
         } else if(8226 == var0) {
            var1 = -107;
         } else if(8211 == var0) {
            var1 = -106;
         } else if(8212 == var0) {
            var1 = -105;
         } else if(732 == var0) {
            var1 = -104;
         } else if(var0 == 8482) {
            var1 = -103;
         } else if(var0 == 353) {
            var1 = -102;
         } else if(var0 == 8250) {
            var1 = -101;
         } else if(339 == var0) {
            var1 = -100;
         } else if(382 == var0) {
            var1 = -98;
         } else if(376 == var0) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }

   @ObfuscatedName("z")
   static final String method2159(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}
