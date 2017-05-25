import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class66 {
   @ObfuscatedName("h")
   static final class66 field799;
   @ObfuscatedName("dg")
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("q")
   static final class66 field801;
   @ObfuscatedName("i")
   static final class66 field802;
   @ObfuscatedName("u")
   static final class66 field803;

   static {
      field802 = new class66();
      field799 = new class66();
      field803 = new class66();
      field801 = new class66();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "-1189681637"
   )
   public static Widget method1099(int var0, int var1) {
      Widget var2 = class261.method4792(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method1100() {
      FloorUnderlayDefinition.field3336.reset();
   }
}
