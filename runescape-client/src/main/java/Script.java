import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field1506;
   @ObfuscatedName("o")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("i")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1274028583
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -823888683
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("u")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1484383199
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lgk;"
   )
   @Export("switches")
   class186[] switches;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -75435077
   )
   @Export("stringStackCount")
   int stringStackCount;

   static {
      field1506 = new NodeCache(128);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[Lgk;",
      garbageValue = "-1652382305"
   )
   class186[] method1781(int var1) {
      return new class186[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "405912795"
   )
   public static void method1786() {
      if(class238.field3226 != null) {
         class238.field3226.close();
      }

   }
}
