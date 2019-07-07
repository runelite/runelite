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
   public static boolean loadInterface(int var0) {
      if (Widget.loadedInterfaces[var0]) {
         return true;
      } else if (!Widget.Widget_archive.tryLoadGroup(var0)) {
         return false;
      } else {
         int var1 = Widget.Widget_archive.method4(var0);
         if (var1 == 0) {
            Widget.loadedInterfaces[var0] = true;
            return true;
         } else {
            if (Widget.interfaceComponents[var0] == null) {
               Widget.interfaceComponents[var0] = new Widget[var1];
            }

            for (int var2 = 0; var2 < var1; ++var2) {
               if (Widget.interfaceComponents[var0][var2] == null) {
                  byte[] var3 = Widget.Widget_archive.takeFile(var0, var2);
                  if (var3 != null) {
                     Widget.interfaceComponents[var0][var2] = new Widget();
                     Widget.interfaceComponents[var0][var2].id = var2 + (var0 << 16);
                     if (var3[0] == -1) {
                        Widget.interfaceComponents[var0][var2].decode(new Buffer(var3));
                     } else {
                        Widget.interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.loadedInterfaces[var0] = true;
            return true;
         }
      }
   }
}
