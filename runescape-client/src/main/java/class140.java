import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class140 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2068510053"
   )
   public static void method2855() {
      try {
         if(class203.field2501 == 1) {
            int var0 = class203.field2500.method3698();
            if(var0 > 0 && class203.field2500.method3704()) {
               var0 -= class73.field861;
               if(var0 < 0) {
                  var0 = 0;
               }

               class203.field2500.method3697(var0);
               return;
            }

            class203.field2500.method3703();
            class203.field2500.method3701();
            if(class203.field2502 != null) {
               class203.field2501 = 2;
            } else {
               class203.field2501 = 0;
            }

            class149.field2196 = null;
            class203.field2506 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class203.field2500.method3703();
         class203.field2501 = 0;
         class149.field2196 = null;
         class203.field2506 = null;
         class203.field2502 = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-427027648"
   )
   static final int method2854(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var2 * (var1 & 16711935) + var3 * (var0 & 16711935) & -16711936) + ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) >> 8;
   }
}
