import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static NodeCache field1214;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 1986819395
   )
   static int field1219;
   @ObfuscatedName("m")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("q")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("b")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -234324811
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -289334549
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 461672635
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1932646591
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lgx;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1214 = new NodeCache(128);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[Lgx;",
      garbageValue = "-717771929"
   )
   IterableHashTable[] method1989(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;I)V",
      garbageValue = "-968351460"
   )
   public static void method2002(IndexDataBase var0) {
      Varbit.varbit_ref = var0;
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(Lbs;I)V",
      garbageValue = "1256740677"
   )
   static final void method1994(Actor var0) {
      int var1 = var0.field896 - Client.gameCycle;
      int var2 = var0.field925 * 128 + var0.field885 * 64;
      int var3 = var0.field927 * 128 + var0.field885 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field936 = 0;
      var0.orientation = var0.field931;
   }
}
