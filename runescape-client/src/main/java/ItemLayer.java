import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -831533189
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1561248703
   )
   @Export("x")
   int x;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 618321863
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("e")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("h")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -486552205
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1151246083
   )
   @Export("height")
   int height;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -1658846393
   )
   static int field1756;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -293633413
   )
   protected static int field1757;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -1139349345
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("s")
   @Export("top")
   Renderable top;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2034714713"
   )
   static final void method2289() {
      if(Client.field299 > 0) {
         class129.method2964();
      } else {
         class138.setGameState(40);
         class52.field1153 = class40.field904;
         class40.field904 = null;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-945687837"
   )
   public static boolean method2290(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "112"
   )
   static void method2291(int var0) {
      if(var0 != -1 && class14.method179(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3.field2888 != null) {
               class0 var4 = new class0();
               var4.field2 = var3;
               var4.field8 = var3.field2888;
               TextureProvider.method2282(var4, 2000000);
            }
         }
      }

   }
}
