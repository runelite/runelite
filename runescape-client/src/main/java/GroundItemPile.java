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
   @Export("optionButtonSpriteSubHeight")
   static int optionButtonSpriteSubHeight;
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
   @Export("loadInterface")
   public static boolean loadInterface(int itf) {
      if (Widget.loadedInterfaces[itf]) {
         return true;
      } else if (!Widget.Widget_archive.tryLoadGroup(itf)) {
         return false;
      } else {
         int var1 = Widget.Widget_archive.getGroupFileCount(itf);
         if (var1 == 0) {
            Widget.loadedInterfaces[itf] = true;
            return true;
         } else {
            if (Widget.interfaceComponents[itf] == null) {
               Widget.interfaceComponents[itf] = new Widget[var1];
            }

            for (int var2 = 0; var2 < var1; ++var2) {
               if (Widget.interfaceComponents[itf][var2] == null) {
                  byte[] var3 = Widget.Widget_archive.takeFile(itf, var2);
                  if (var3 != null) {
                     Widget.interfaceComponents[itf][var2] = new Widget();
                     Widget.interfaceComponents[itf][var2].id = var2 + (itf << 16);
                     if (var3[0] == -1) {
                        Widget.interfaceComponents[itf][var2].decode(new Buffer(var3));
                     } else {
                        Widget.interfaceComponents[itf][var2].decodeLegacy(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.loadedInterfaces[itf] = true;
            return true;
         }
      }
   }
}
