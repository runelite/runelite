import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -336129561
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 209873097
   )
   @Export("y")
   int y;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1872037373
   )
   @Export("z")
   int z;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "104649099"
   )
   static int method3003(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class35.getWidget(class80.intStack[--class80.intStackSize]);
      } else {
         var3 = var2?class23.field331:GrandExchangeOffer.field297;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class80.intStack[--class80.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class80.scriptStringStack[--WorldComparator.scriptStringStackSize]);
            return 1;
         } else {
            --WorldComparator.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class80.intStackSize -= 2;
         var4 = class80.intStack[class80.intStackSize];
         int var5 = class80.intStack[class80.intStackSize + 1];
         var3.dragParent = class31.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2816 = class80.intStack[--class80.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2814 = class80.intStack[--class80.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2802 = class80.intStack[--class80.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
