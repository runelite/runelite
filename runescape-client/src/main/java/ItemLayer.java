import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2062965013
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -935648273
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1943466103
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -590833893
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1808492959
   )
   @Export("height")
   int height;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;Ljr;Lhe;I)Z",
      garbageValue = "1998951335"
   )
   public static boolean method2689(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class230 var3) {
      class229.field2697 = var0;
      class229.field2700 = var1;
      class229.field2696 = var2;
      class38.field507 = var3;
      return true;
   }
}
