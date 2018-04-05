import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   static NodeCache field1459;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 42620915
   )
   static int field1455;
   @ObfuscatedName("k")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("t")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("d")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -728926159
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 730295907
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 438661745
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 779372035
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lha;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1459 = new NodeCache(128);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)[Lha;",
      garbageValue = "69"
   )
   IterableHashTable[] method2016(int var1) {
      return new IterableHashTable[var1];
   }
}
