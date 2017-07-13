import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class19 implements Comparator {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-1569021939"
   )
   int method146(class14 var1, class14 var2) {
      return var1.field296 < var2.field296?-1:(var1.field296 == var2.field296?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method146((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILScript;ZS)I",
      garbageValue = "511"
   )
   static int method148(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class61.method1038(class83.intStack[--WorldMapType2.intStackSize]);
      } else {
         var3 = var2?class83.field1336:class1.field9;
      }

      class48.method749(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class83.intStack[--WorldMapType2.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = Script.localPlayer.composition.method3941();
            return 1;
         } else {
            return 2;
         }
      } else {
         WorldMapType2.intStackSize -= 2;
         int var4 = class83.intStack[WorldMapType2.intStackSize];
         int var5 = class83.intStack[WorldMapType2.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class83.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2702 = var6.offsetX2d;
         var3.field2670 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2711 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2711 = 1;
         } else {
            var3.field2711 = 2;
         }

         if(var3.field2648 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2648;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1096906176"
   )
   static int method149(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class61.method1038(class83.intStack[--WorldMapType2.intStackSize]);
      } else {
         var3 = var2?class83.field1336:class1.field9;
      }

      if(var0 == 1927) {
         if(class83.field1334 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2732 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.field839 = var3.field2732;
            var4.field835 = class83.field1334 + 1;
            Client.field1105.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
