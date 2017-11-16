import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class64 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Lhx;",
      garbageValue = "-75"
   )
   public static Widget method1017(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-874781494"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(class56.validInterfaces[var0]) {
         return true;
      } else if(!TextureProvider.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = TextureProvider.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            class56.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = TextureProvider.widgetIndex.getConfigData(var0, var2);
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

            class56.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(I)Lkw;",
      garbageValue = "225085181"
   )
   static RenderOverview method1018() {
      return ScriptState.renderOverview;
   }
}
