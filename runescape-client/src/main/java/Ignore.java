import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("f")
   @Export("name")
   String name;
   @ObfuscatedName("e")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("n")
   static class170 field131;

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "14"
   )
   static void method92(Widget var0, int var1, int var2) {
      if(var0.field2793 == 0) {
         var0.relativeX = var0.field2797;
      } else if(var0.field2793 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.field2797;
      } else if(var0.field2793 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2797;
      } else if(var0.field2793 == 3) {
         var0.relativeX = var0.field2797 * var1 >> 14;
      } else if(var0.field2793 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.field2797 * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.field2797 >> 14);
      }

      if(var0.field2794 == 0) {
         var0.relativeY = var0.field2798;
      } else if(var0.field2794 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.field2798;
      } else if(var0.field2794 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2798;
      } else if(var0.field2794 == 3) {
         var0.relativeY = var0.field2798 * var2 >> 14;
      } else if(var0.field2794 == 4) {
         var0.relativeY = (var0.field2798 * var2 >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.field2798 >> 14);
      }

      if(Client.field449 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "862769837"
   )
   static void method93(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3849((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-98"
   )
   static void method94() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3852(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3857()) {
         int var1 = var0.id;
         if(class171.method3404(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2787;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class153.method3170(var4);
               if(var5 != null) {
                  MessageNode.method750(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "920690630"
   )
   public static class51 method95(int var0) {
      class51 var1 = (class51)class51.field1100.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class51.field1102.method3304(32, var0);
         var1 = new class51();
         if(var2 != null) {
            var1.method1032(new Buffer(var2));
         }

         class51.field1100.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "73"
   )
   static void method96(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method3849((long)var0);
      if(null == var4) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method3850(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[1 + var1];

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
}
