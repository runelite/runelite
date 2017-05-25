import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class233 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1024229019
   )
   int field3190;
   @ObfuscatedName("h")
   byte[] field3191;
   @ObfuscatedName("u")
   IndexFile field3192;
   @ObfuscatedName("q")
   IndexData field3193;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "460222811"
   )
   public static boolean method4170(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
