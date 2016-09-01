import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public final class class166 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)LWidget;",
      garbageValue = "-102"
   )
   public static Widget method3265(int var0, int var1) {
      Widget var2 = World.method628(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
