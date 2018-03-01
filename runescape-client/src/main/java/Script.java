import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("my")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   static NodeCache field1439;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 671650711
   )
   static int field1438;
   @ObfuscatedName("z")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("n")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("r")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1153368683
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -85676671
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 139586357
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -225273817
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lhd;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1439 = new NodeCache(128);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)[Lhd;",
      garbageValue = "148894488"
   )
   IterableHashTable[] method2045(int var1) {
      return new IterableHashTable[var1];
   }
}
