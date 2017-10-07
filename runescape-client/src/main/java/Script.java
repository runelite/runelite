import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static NodeCache field1518;
   @ObfuscatedName("k")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("e")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1723494033
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1163104061
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("p")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1531329989
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lgc;"
   )
   @Export("switches")
   IterableHashTable[] switches;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -98022837
   )
   @Export("stringStackCount")
   int stringStackCount;

   static {
      field1518 = new NodeCache(128);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)[Lgc;",
      garbageValue = "-22826"
   )
   IterableHashTable[] method1919(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "(Lhj;I)Z",
      garbageValue = "2044719853"
   )
   static boolean method1926(Widget var0) {
      if(Client.field961) {
         if(class244.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
