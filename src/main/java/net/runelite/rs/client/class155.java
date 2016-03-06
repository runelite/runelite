package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("es")
public class class155 {
   @ObfuscatedName("i")
   public static int method3117(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var4 + var6] = -128;
         } else if(var7 == 8218) {
            var3[var4 + var6] = -126;
         } else if(var7 == 402) {
            var3[var4 + var6] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(8230 == var7) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var4 + var6] = -122;
         } else if(var7 == 8225) {
            var3[var4 + var6] = -121;
         } else if(710 == var7) {
            var3[var6 + var4] = -120;
         } else if(8240 == var7) {
            var3[var4 + var6] = -119;
         } else if(352 == var7) {
            var3[var4 + var6] = -118;
         } else if(8249 == var7) {
            var3[var6 + var4] = -117;
         } else if(338 == var7) {
            var3[var4 + var6] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(8217 == var7) {
            var3[var4 + var6] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(8221 == var7) {
            var3[var4 + var6] = -108;
         } else if(8226 == var7) {
            var3[var4 + var6] = -107;
         } else if(8211 == var7) {
            var3[var4 + var6] = -106;
         } else if(8212 == var7) {
            var3[var6 + var4] = -105;
         } else if(732 == var7) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var4 + var6] = -103;
         } else if(353 == var7) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var4 + var6] = -101;
         } else if(var7 == 339) {
            var3[var4 + var6] = -100;
         } else if(var7 == 382) {
            var3[var4 + var6] = -98;
         } else if(376 == var7) {
            var3[var4 + var6] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }
}
