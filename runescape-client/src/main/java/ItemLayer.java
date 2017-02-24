import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("n")
   @Export("top")
   Renderable top;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1001357227
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -713957811
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("j")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -707337707
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1172187263
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 34931389
   )
   @Export("height")
   int height;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "22781"
   )
   static int method1510() {
      return 9;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)Ljava/lang/String;",
      garbageValue = "1473557078"
   )
   public static String method1511(Buffer var0) {
      String var1;
      try {
         int var2 = var0.method2846();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class210.field3126.method2752(var0.payload, var0.offset, var3, 0, var2);
         String var4 = Client.method343(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }
}
