import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
final class class5 implements class0 {
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -854648669
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static class290 field42;
   @ObfuscatedName("w")
   static int[] field41;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)Lhj;",
      garbageValue = "-1177937336"
   )
   public static Widget method18(int var0, int var1) {
      Widget var2 = PacketBuffer.method3528(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
