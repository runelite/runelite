import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("v")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 527419605
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1384470371
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("c")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1326789549
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @Export("top")
   Renderable top;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1183021269
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("cm")
   public static char field1744;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2049120395
   )
   @Export("height")
   int height;

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "211761050"
   )
   static final void method2271(int var0) {
      if(class85.method1938(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3) {
               var3.field2920 = 0;
               var3.field2873 = 0;
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "148"
   )
   public static boolean method2272(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
