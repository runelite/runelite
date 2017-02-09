import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 733131611
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -568153711
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 751488249
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("w")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("j")
   @Export("top")
   Renderable top;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -789564289
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -433876719
   )
   @Export("height")
   int height;
   @ObfuscatedName("dy")
   static byte[][] field1220;

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "422115324"
   )
   static final String method1467(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)LWidget;",
      garbageValue = "71"
   )
   public static Widget method1468(int var0, int var1) {
      Widget var2 = class37.method759(var0);
      return var1 == -1?var2:(null != var2 && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
