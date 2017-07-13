import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class181 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 408324859
   )
   static int field2435;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 1591219957
   )
   static int field2434;

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZB)V",
      garbageValue = "34"
   )
   static void method3424(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2640 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2640 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2640 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2736;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2736;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2736 >> 14;
      }

      if(var0.field2640 == 4) {
         var0.width = var0.height * var0.field2715 / var0.field2671;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.field2671 * var0.width / var0.field2715;
      }

      if(Client.field1076 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1078 = var0;
      }

      if(var3 && var0.field2732 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field839 = var0.field2732;
         Client.field1105.addFront(var6);
      }

   }
}
