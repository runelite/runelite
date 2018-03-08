import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "Lbf;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 582082035
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 617373503
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("i")
   boolean field773;

   WidgetNode() {
      this.field773 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1873556420"
   )
   static int method1151(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class81.intStack[--class5.intStackSize];
         var4 = GZipDecompressor.getWidget(var3);
      } else {
         var4 = var2?class233.field2755:class81.field1260;
      }

      if(var0 == 1000) {
         class5.intStackSize -= 4;
         var4.originalX = class81.intStack[class5.intStackSize];
         var4.originalY = class81.intStack[class5.intStackSize + 1];
         var4.dynamicX = class81.intStack[class5.intStackSize + 2];
         var4.dynamicY = class81.intStack[class5.intStackSize + 3];
         GameEngine.method1053(var4);
         class249.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            GameEngine.method1051(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class5.intStackSize -= 4;
         var4.originalWidth = class81.intStack[class5.intStackSize];
         var4.originalHeight = class81.intStack[class5.intStackSize + 1];
         var4.dynamicWidth = class81.intStack[class5.intStackSize + 2];
         var4.buttonType = class81.intStack[class5.intStackSize + 3];
         GameEngine.method1053(var4);
         class249.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            GameEngine.method1051(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class81.intStack[--class5.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            GameEngine.method1053(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class81.intStack[--class5.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2951 = class81.intStack[--class5.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
