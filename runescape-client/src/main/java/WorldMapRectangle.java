import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -987673901
   )
   @Export("worldMapRegionWidth")
   int worldMapRegionWidth;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 41622299
   )
   @Export("worldMapRegionHeight")
   int worldMapRegionHeight;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 924219265
   )
   @Export("worldMapRegionX")
   int worldMapRegionX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2003119817
   )
   @Export("worldMapRegionY")
   int worldMapRegionY;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      signature = "(Lay;)V"
   )
   WorldMapRectangle(WorldMapManager var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1965753337"
   )
   public static void method190(int var0) {
      if(var0 != -1) {
         if(Item.validInterfaces[var0]) {
            Frames.widgetIndex.method4659(var0);
            if(Widget.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               Item.validInterfaces[var0] = false;
            }
         }
      }
   }
}
