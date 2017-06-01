import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 473855799
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("c")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("m")
   public static String[] field1538;
   @ObfuscatedName("v")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1905553941
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -27966999
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("f")
   @Export("switches")
   class186[] switches;
   @ObfuscatedName("e")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 264016071
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("i")
   static NodeCache field1552;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[Lclass186;",
      garbageValue = "16748608"
   )
   class186[] method1841(int var1) {
      return new class186[var1];
   }

   static {
      field1552 = new NodeCache(128);
   }
}
