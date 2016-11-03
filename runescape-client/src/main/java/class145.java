import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class145 {
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -946329725
   )
   static int field2220;
   @ObfuscatedName("k")
   public static class116 field2223;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 134376921
   )
   @Export("plane")
   static int plane;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "113"
   )
   static int method3018(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
