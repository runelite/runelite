import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class25 {
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = 192118161
   )
   static int field340;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   static class47 field342;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -619180239
   )
   static int field339;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1338055
   )
   int field338;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   Coordinates field337;

   @ObfuscatedSignature(
      signature = "(ILhk;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field338 = var1;
      this.field337 = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "799744740"
   )
   public static boolean method178(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
