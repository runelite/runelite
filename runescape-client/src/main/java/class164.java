import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class164 {
   @ObfuscatedName("ba")
   static class289 field2317;

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "524878373"
   )
   static void method3055(Widget var0, int var1, int var2) {
      if(var0.field2658 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2658 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2658 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2658 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2658 == 4) {
         var0.relativeX = (var1 * var0.originalX >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2659 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2659 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2659 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2659 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2659 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1076 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}
