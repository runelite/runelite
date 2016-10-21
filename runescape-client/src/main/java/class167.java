import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class167 {
   @ObfuscatedName("n")
   static final char[] field2691 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("bh")
   static class171 field2694;
   @ObfuscatedName("t")
   static final char[] field2695 = new char[]{'[', ']', '#'};
   @ObfuscatedName("v")
   static class170 field2697;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-1304051273"
   )
   static void method3258(Sequence var0, int var1, int var2, int var3) {
      if(Client.field363 < 50 && Client.field520 != 0) {
         if(var0.field995 != null && var1 < var0.field995.length) {
            int var4 = var0.field995[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field522[Client.field363] = var5;
               Client.field523[Client.field363] = var6;
               Client.field524[Client.field363] = 0;
               Client.field313[Client.field363] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field525[Client.field363] = (var9 << 8) + (var8 << 16) + var7;
               ++Client.field363;
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-39"
   )
   public static boolean method3259(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
