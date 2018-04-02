import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
public class class292 {
   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Lib;IIB)V",
      garbageValue = "95"
   )
   static void method5207(Widget var0, int var1, int var2) {
      if(var0.dynamicX == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.dynamicX == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.dynamicX == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.dynamicX == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.dynamicX == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.originalX * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.dynamicY == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.dynamicY == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.dynamicY == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.dynamicY == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.dynamicY == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

   }
}
