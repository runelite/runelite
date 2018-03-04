import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class21 {
   @ObfuscatedName("ql")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   @Export("platformInfo")
   static MachineInfo platformInfo;
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   @Export("loginType")
   static JagexLoginType loginType;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-576117370"
   )
   static void method159() {
      UrlRequest.field2107 = null;
      class62.field744 = null;
      class62.field734 = null;
      class62.field739 = null;
      class62.field738 = null;
      class62.field740 = null;
      class62.field741 = null;
      class19.field327 = null;
      class318.field3919 = null;
      UnitPriceComparator.field321 = null;
      class29.field430 = null;
      UnitPriceComparator.field316 = null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-96986940"
   )
   static int method157(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class81.intStack[--class81.intStackSize];
         var4 = class5.getWidget(var3);
      } else {
         var4 = var2?class20.field338:class81.field1267;
      }

      if(var0 == 1000) {
         class81.intStackSize -= 4;
         var4.originalX = class81.intStack[class81.intStackSize];
         var4.originalY = class81.intStack[class81.intStackSize + 1];
         var4.dynamicX = class81.intStack[class81.intStackSize + 2];
         var4.dynamicY = class81.intStack[class81.intStackSize + 3];
         class171.method3363(var4);
         class23.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class183.method3484(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class81.intStackSize -= 4;
         var4.originalWidth = class81.intStack[class81.intStackSize];
         var4.originalHeight = class81.intStack[class81.intStackSize + 1];
         var4.dynamicWidth = class81.intStack[class81.intStackSize + 2];
         var4.buttonType = class81.intStack[class81.intStackSize + 3];
         class171.method3363(var4);
         class23.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class183.method3484(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class81.intStack[--class81.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class171.method3363(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class81.intStack[--class81.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2959 = class81.intStack[--class81.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
