import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class158 {
   @ObfuscatedName("bd")
   static class80[] field2604;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "824130552"
   )
   public static int method3149(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return 0 == var2?var1:(var2 == 1?7 - var0 - (var3 - 1):(2 == var2?7 - var1 - (var4 - 1):var0));
   }
}
