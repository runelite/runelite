import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("p")
   @Export("top")
   Renderable top;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 128792277
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2101326953
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1117902831
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("l")
   static int[][] field1199;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2075021049
   )
   @Export("height")
   int height;
   @ObfuscatedName("ef")
   static SpritePixels field1204;
   @ObfuscatedName("t")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2084235863
   )
   @Export("flags")
   int flags;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)[Lclass179;",
      garbageValue = "74329661"
   )
   public static class179[] method1475() {
      return new class179[]{class179.field2665, class179.field2664, class179.field2666, class179.field2667, class179.field2662, class179.field2663};
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZB)V",
      garbageValue = "0"
   )
   static void method1476(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var1 == var6.parentId) {
            class5.method63(var6, var2, var3, var4);
            class161.method3028(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class164.method3116(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-81"
   )
   public static void method1477() {
      class231.field3265 = new CombatInfoList();
   }
}
