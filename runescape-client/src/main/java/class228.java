import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class228 {
   @ObfuscatedName("pf")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   static class117 field3114;

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Lhg;IIB)V",
      garbageValue = "-83"
   )
   static void method4086(Widget var0, int var1, int var2) {
      if(var0.field2715 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2715 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2715 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2715 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2715 == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2629 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2629 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2629 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2629 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2629 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1072 && var0.type == 0) {
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1478277317"
   )
   public static void method4087() {
      try {
         class156.field2231.method2357();

         for(int var0 = 0; var0 < class156.field2229; ++var0) {
            class156.field2227[var0].method2357();
         }

         class156.field2232.method2357();
         class156.field2230.method2357();
      } catch (Exception var2) {
         ;
      }

   }
}
