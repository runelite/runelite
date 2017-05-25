import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class23 {
   @ObfuscatedName("gg")
   static SpritePixels[] field347;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 181864093
   )
   static int field352;
   @ObfuscatedName("ry")
   static GarbageCollectorMXBean field355;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1573886725"
   )
   static void method160(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method3615((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method3617(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1661283939"
   )
   static void method161(Widget var0, int var1, int var2) {
      if(var0.field2647 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2647 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2647 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2647 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2647 == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2648 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2648 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2648 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2648 == 3) {
         var0.relativeY = var0.originalY * var2 >> 14;
      } else if(var0.field2648 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var0.originalY * var2 >> 14);
      }

      if(Client.field1060 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "165"
   )
   static final void method162(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class61.tileHeights[var0][var1 + var3][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var1][var3 + var2] = class61.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var1 + var3][var2] = class61.tileHeights[var0][var1 + var3][var2 - 1];
         }
      }

      if(var1 > 0 && class61.tileHeights[var0][var1 - 1][var2] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class61.tileHeights[var0][var1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class61.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "2141903860"
   )
   static int method163(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = class261.method4792(class83.intStack[--class83.intStackSize]);
         class83.intStack[++class83.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = class261.method4792(class83.intStack[--class83.intStackSize]);
         if(var3.itemId != -1) {
            class83.intStack[++class83.intStackSize - 1] = var3.itemQuantity;
         } else {
            class83.intStack[++class83.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class83.intStack[--class83.intStackSize];
         WidgetNode var4 = (WidgetNode)Client.componentTable.method3615((long)var5);
         if(var4 != null) {
            class83.intStack[++class83.intStackSize - 1] = 1;
         } else {
            class83.intStack[++class83.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class83.intStack[++class83.intStackSize - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)LCombatInfo2;",
      garbageValue = "-22177"
   )
   public static CombatInfo2 method164(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3352.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field3353.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method4465(new Buffer(var2));
         }

         CombatInfo2.field3352.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-132365226"
   )
   public static void method165(IndexDataBase var0) {
      class253.field3400 = var0;
   }
}
