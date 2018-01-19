import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   static NodeCache field1435;
   @ObfuscatedName("v")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("y")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("r")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -285464221
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 179342557
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1986593681
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1606864021
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Lgb;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1435 = new NodeCache(128);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)[Lgb;",
      garbageValue = "29958537"
   )
   IterableHashTable[] method1866(int var1) {
      return new IterableHashTable[var1];
   }
}
