import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
public class class260 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcf;ZB)I",
      garbageValue = "53"
   )
   static int method4817(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class216.getWidget(class80.intStack[--class80.intStackSize]);
      } else {
         var3 = var2?class94.field1418:ItemLayer.field1668;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class80.intStack[--class80.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class80.scriptStringStack[--class294.scriptStringStackSize]);
            return 1;
         } else {
            --class294.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class80.intStackSize -= 2;
         var4 = class80.intStack[class80.intStackSize];
         int var5 = class80.intStack[class80.intStackSize + 1];
         var3.dragParent = class44.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2819 = class80.intStack[--class80.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2830 = class80.intStack[--class80.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2822 = class80.intStack[--class80.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class80.scriptStringStack[--class294.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class80.scriptStringStack[--class294.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
