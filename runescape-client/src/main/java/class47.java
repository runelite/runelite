import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class47 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -373175293
   )
   public int field573;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   public Coordinates field574;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   public Coordinates field575;

   @ObfuscatedSignature(
      signature = "(ILht;Lht;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field573 = var1;
      this.field574 = var2;
      this.field575 = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "16"
   )
   static int method692(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class82.intStack[--class82.intStackSize];
         var4 = UrlRequester.getWidget(var3);
      } else {
         var4 = var2?class82.field1267:CombatInfo1.field1216;
      }

      if(var0 == 1000) {
         class82.intStackSize -= 4;
         var4.originalX = class82.intStack[class82.intStackSize];
         var4.originalY = class82.intStack[class82.intStackSize + 1];
         var4.dynamicX = class82.intStack[class82.intStackSize + 2];
         var4.dynamicY = class82.intStack[class82.intStackSize + 3];
         class28.method220(var4);
         class160.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class160.method3094(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class82.intStackSize -= 4;
         var4.originalWidth = class82.intStack[class82.intStackSize];
         var4.originalHeight = class82.intStack[class82.intStackSize + 1];
         var4.dynamicWidth = class82.intStack[class82.intStackSize + 2];
         var4.buttonType = class82.intStack[class82.intStackSize + 3];
         class28.method220(var4);
         class160.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class160.method3094(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class82.intStack[--class82.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class28.method220(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class82.intStack[--class82.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2803 = class82.intStack[--class82.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(B)Lkl;",
      garbageValue = "-76"
   )
   static RenderOverview method693() {
      return TextureProvider.renderOverview;
   }
}
