import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class164 {
   @ObfuscatedName("dc")
   static IndexData field2329;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -769058425
   )
   static int field2331;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "77"
   )
   static int method2956(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class223.method3959(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class43.field582:class31.field457;
      }

      XItemContainer.method1020(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class83.intStack[--class83.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class20.localPlayer.composition.method3868();
            return 1;
         } else {
            return 2;
         }
      } else {
         class83.intStackSize -= 2;
         int var4 = class83.intStack[class83.intStackSize];
         int var5 = class83.intStack[class83.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class224.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2750 = var6.offsetX2d;
         var3.field2731 = var6.offsetY2d;
         var3.field2737 = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2712 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2712 = 1;
         } else {
            var3.field2712 = 2;
         }

         if(var3.field2709 > 0) {
            var3.field2737 = var3.field2737 * 32 / var3.field2709;
         } else if(var3.originalWidth > 0) {
            var3.field2737 = var3.field2737 * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1074358663"
   )
   static final int method2960(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class27.method228(var3, var5);
      int var8 = class27.method228(var3 + 1, var5);
      int var9 = class27.method228(var3, var5 + 1);
      int var10 = class27.method228(var3 + 1, var5 + 1);
      int var12 = 65536 - class136.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = (var12 * var8 >> 16) + (var7 * (65536 - var12) >> 16);
      int var14 = 65536 - class136.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = (var10 * var14 >> 16) + ((65536 - var14) * var9 >> 16);
      int var16 = 65536 - class136.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = (var16 * var13 >> 16) + ((65536 - var16) * var11 >> 16);
      return var15;
   }
}
