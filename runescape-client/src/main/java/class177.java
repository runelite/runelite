import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class177 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-708769340"
   )
   public static void method3485() {
      try {
         if(class183.field2953 == 1) {
            int var0 = class183.field2955.method3651();
            if(var0 > 0 && class183.field2955.method3644()) {
               var0 -= class183.field2957;
               if(var0 < 0) {
                  var0 = 0;
               }

               class183.field2955.method3636(var0);
               return;
            }

            class183.field2955.method3642();
            class183.field2955.method3640();
            if(class20.field582 != null) {
               class183.field2953 = 2;
            } else {
               class183.field2953 = 0;
            }

            class133.field2072 = null;
            class7.field133 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class183.field2955.method3642();
         class183.field2953 = 0;
         class133.field2072 = null;
         class7.field133 = null;
         class20.field582 = null;
      }

   }
}
