import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("GroundItemPile")
public final class GroundItemPile {
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -704675849
   )
   @Export("__dr_ao")
   static int __dr_ao;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("second")
   Entity second;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -325682933
   )
   @Export("tileHeight")
   int tileHeight;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1363136655
   )
   @Export("x")
   int x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 968072997
   )
   @Export("y")
   int y;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("first")
   Entity first;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("third")
   Entity third;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -3696674445500472687L
   )
   @Export("tag")
   long tag;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1659262853
   )
   @Export("height")
   int height;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-60"
   )
   @Export("loadWidgetGroup")
   public static boolean loadWidgetGroup(int var0) {
      if(Widget.loadedWidgetGroups[var0]) {
         return true;
      } else if(!Widget.Widget_indexCache.tryLoadArchive(var0)) {
         return false;
      } else {
         int var1 = Widget.Widget_indexCache.__s_396(var0);
         if(var1 == 0) {
            Widget.loadedWidgetGroups[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.Widget_indexCache.takeRecord(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].decode(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].decodeLegacy(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.loadedWidgetGroups[var0] = true;
            return true;
         }
      }
   }
}
