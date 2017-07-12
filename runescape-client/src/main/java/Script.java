import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("i")
   static NodeCache field1551;
   @ObfuscatedName("a")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("t")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 346249157
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2098797789
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1393628567
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1155965441
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("j")
   @Export("switches")
   class186[] switches;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1343832047
   )
   @Export("authCodeForLogin")
   static int authCodeForLogin;
   @ObfuscatedName("w")
   @Export("instructions")
   int[] instructions;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)[Lclass186;",
      garbageValue = "-1370797715"
   )
   class186[] method1861(int var1) {
      return new class186[var1];
   }

   static {
      field1551 = new NodeCache(128);
   }
}
