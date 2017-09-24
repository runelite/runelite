import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class218 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-1964362704"
   )
   static int method4079(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
      } else {
         var3 = var2?class31.field452:class23.field366;
      }

      class7.method34(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class82.intStack[--Ignore.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = Player.localPlayer.composition.method4002();
            return 1;
         } else {
            return 2;
         }
      } else {
         Ignore.intStackSize -= 2;
         int var4 = class82.intStack[Ignore.intStackSize];
         int var5 = class82.intStack[Ignore.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class169.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2707 = var6.offsetX2d;
         var3.field2647 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2716 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2716 = 1;
         } else {
            var3.field2716 = 2;
         }

         if(var3.field2713 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2713;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }
}
