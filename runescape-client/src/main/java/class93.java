import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class93 {
   @ObfuscatedName("x")
   static boolean field1615;

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "2139609184"
   )
   static void method2128(Widget var0, int var1, int var2) {
      if(var0.field2909 == 0) {
         var0.relativeX = var0.field2819;
      } else if(var0.field2909 == 1) {
         var0.relativeX = var0.field2819 + (var1 - var0.width) / 2;
      } else if(var0.field2909 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2819;
      } else if(var0.field2909 == 3) {
         var0.relativeX = var0.field2819 * var1 >> 14;
      } else if(var0.field2909 == 4) {
         var0.relativeX = (var1 * var0.field2819 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.field2819 * var1 >> 14);
      }

      if(var0.field2920 == 0) {
         var0.relativeY = var0.field2820;
      } else if(var0.field2920 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.field2820;
      } else if(var0.field2920 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2820;
      } else if(var0.field2920 == 3) {
         var0.relativeY = var0.field2820 * var2 >> 14;
      } else if(var0.field2920 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.field2820 >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var0.field2820 * var2 >> 14);
      }

      if(Client.field449 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1312271665"
   )
   static int method2129(int var0) {
      MessageNode var1 = (MessageNode)class11.field164.method3839((long)var0);
      return var1 == null?-1:(class11.field165.field3157 == var1.previous?-1:((MessageNode)var1.previous).id);
   }
}
