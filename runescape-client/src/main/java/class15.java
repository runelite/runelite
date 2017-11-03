import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class15 implements Comparator {
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   @Export("rssocket2")
   static RSSocket rssocket2;
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static IndexData field310;
   @ObfuscatedName("fn")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(La;La;I)I",
      garbageValue = "1495680373"
   )
   int method89(class14 var1, class14 var2) {
      return var1.field294.totalQuantity < var2.field294.totalQuantity?-1:(var2.field294.totalQuantity == var1.field294.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method89((class14)var1, (class14)var2);
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1404435572"
   )
   static final void method96() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var0.level == class46.plane && !var0.finished) {
            if(Client.gameCycle >= var0.startCycle) {
               var0.method1675(Client.field1004);
               if(var0.finished) {
                  var0.unlink();
               } else {
                  class3.region.method2718(var0.level, var0.x, var0.y, var0.height, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILct;ZS)I",
      garbageValue = "-15027"
   )
   static int method95(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = ItemLayer.method2454(class81.intStack[--class278.intStackSize]);
      } else {
         var3 = var2?class251.field3392:class164.field2314;
      }

      class45.method647(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class81.intStack[--class278.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class66.localPlayer.composition.method4034();
            return 1;
         } else {
            return 2;
         }
      } else {
         class278.intStackSize -= 2;
         int var4 = class81.intStack[class278.intStackSize];
         int var5 = class81.intStack[class278.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = FaceNormal.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2737 = var6.offsetX2d;
         var3.field2692 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2759 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2759 = 1;
         } else {
            var3.field2759 = 2;
         }

         if(var3.field2758 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2758;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }
}
