import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class191 {
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIZI)V",
      garbageValue = "427077988"
   )
   static void method3708(class173 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2791;
      int var5 = var0.field2792;
      if(var0.field2783 == 0) {
         var0.field2791 = var0.field2787;
      } else if(var0.field2783 == 1) {
         var0.field2791 = var1 - var0.field2787;
      } else if(var0.field2783 == 2) {
         var0.field2791 = var0.field2787 * var1 >> 14;
      }

      if(var0.field2784 == 0) {
         var0.field2792 = var0.field2788;
      } else if(var0.field2784 == 1) {
         var0.field2792 = var2 - var0.field2788;
      } else if(var0.field2784 == 2) {
         var0.field2792 = var2 * var0.field2788 >> 14;
      }

      if(var0.field2783 == 4) {
         var0.field2791 = var0.field2793 * var0.field2792 / var0.field2794;
      }

      if(var0.field2784 == 4) {
         var0.field2792 = var0.field2794 * var0.field2791 / var0.field2793;
      }

      if(client.field452 && var0.field2778 == 0) {
         if(var0.field2792 < 5 && var0.field2791 < 5) {
            var0.field2792 = 5;
            var0.field2791 = 5;
         } else {
            if(var0.field2792 <= 0) {
               var0.field2792 = 5;
            }

            if(var0.field2791 <= 0) {
               var0.field2791 = 5;
            }
         }
      }

      if(var0.field2780 == 1337) {
         client.field454 = var0;
      }

      if(var3 && var0.field2885 != null && (var0.field2791 != var4 || var0.field2792 != var5)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field5 = var0.field2885;
         client.field395.method3771(var6);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)Ljava/lang/String;",
      garbageValue = "917751295"
   )
   public static String method3709(class119 var0) {
      return class115.method2410(var0, 32767);
   }
}
