import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("m")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("e")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("t")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -928316301
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1729926335
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1120356871
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("p")
   static NodeCache field1533;
   @ObfuscatedName("f")
   @Export("switches")
   class186[] switches;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 154474411
   )
   static int field1535;
   @ObfuscatedName("u")
   static int[] field1536;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1403273459
   )
   @Export("intStackCount")
   int intStackCount;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[Lclass186;",
      garbageValue = "50681606"
   )
   class186[] method1757(int var1) {
      return new class186[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass186;III)I",
      garbageValue = "-1248114035"
   )
   static int method1758(class186 var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         class198 var3 = (class198)var0.method3389((long)var1);
         return var3 == null?var2:var3.field2496;
      }
   }

   static {
      field1533 = new NodeCache(128);
   }
}
