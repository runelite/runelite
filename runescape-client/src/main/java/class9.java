import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public abstract class class9 extends Node {
   @ObfuscatedName("pf")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   static class116 field237;
   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   public abstract void vmethod49();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "10381"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(class163.validInterfaces[var0]) {
         return true;
      } else if(!class35.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = class35.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            class163.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = class35.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            class163.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-942671943"
   )
   public static boolean method46(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
