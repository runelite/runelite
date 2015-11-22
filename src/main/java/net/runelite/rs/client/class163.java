package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fr")
public class class163 {
   @ObfuscatedName("f")
   static final char[] field2638 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("l")
   static final char[] field2639 = new char[]{'[', ']', '#'};
   @ObfuscatedName("lv")
   static class129 field2640;

   @ObfuscatedName("s")
   static int method3281(int var0, int var1, int var2) {
      return (class5.field86[var0][var1][var2] & 8) != 0?0:(var0 > 0 && 0 != (class5.field86[1][var1][var2] & 2)?var0 - 1:var0);
   }

   @ObfuscatedName("g")
   static final int method3282(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
