import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class87 {
   @ObfuscatedName("z")
   @Export("osNameLC")
   public static String osNameLC;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "1644629182"
   )
   static int method1793(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class82.intStack[--class56.intStackSize];
         var4 = PendingSpawn.method1612(var3);
      } else {
         var4 = var2?class285.field3789:Friend.field768;
      }

      if(var0 == 1000) {
         class56.intStackSize -= 4;
         var4.originalX = class82.intStack[class56.intStackSize];
         var4.originalY = class82.intStack[class56.intStackSize + 1];
         var4.field2731 = class82.intStack[class56.intStackSize + 2];
         var4.field2732 = class82.intStack[class56.intStackSize + 3];
         WorldMapData.method394(var4);
         class9.clientInstance.method1252(var4);
         if(var3 != -1 && var4.type == 0) {
            class22.method179(class243.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class56.intStackSize -= 4;
         var4.originalWidth = class82.intStack[class56.intStackSize];
         var4.field2738 = class82.intStack[class56.intStackSize + 1];
         var4.field2834 = class82.intStack[class56.intStackSize + 2];
         var4.buttonType = class82.intStack[class56.intStackSize + 3];
         WorldMapData.method394(var4);
         class9.clientInstance.method1252(var4);
         if(var3 != -1 && var4.type == 0) {
            class22.method179(class243.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class82.intStack[--class56.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            WorldMapData.method394(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2859 = class82.intStack[--class56.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2733 = class82.intStack[--class56.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
