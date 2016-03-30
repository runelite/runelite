import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class188 {
   @ObfuscatedName("gr")
   public static final int[] field3058 = new int[]{0, -2, 0, 0, 0, 0, 0, -2, 6, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, -2, 8, 0, -2, 0, -2, 0, 0, 0, 0, 0, 0, -2, 0, 8, 3, 0, 2, 0, 6, -1, 0, 0, -1, 0, 0, 0, 4, 0, 2, 0, 6, 0, 0, 0, 6, -1, 0, 0, 0, 5, 0, 0, 0, 0, 0, -2, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 6, 0, 1, 6, 0, 7, 0, 0, 0, 0, 6, 10, 0, 5, 2, 0, 0, 0, 0, 5, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, -1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0, 0, -2, 2, 0, 8, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 2, 4, 0, 0, 0, 0, 0, -2, 0, 6, 0, 0, 0, -1, 0, 0, 0, 0, 0, 8, -2, -2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, -2, 0, 0, 0, 0, 2, 4, 0, 15, 0, 0, 2, 0, 0, 0, 0, 4, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 14, 0, 0, 0, 6, 0, -2, 10, 1, 0, 0, 0, 0, 12, 0, 0, 6, 0, 0, 0, -2, 5, -2, 3, 0, 0, 28, 0, 0, 0, 0, -2};

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-69"
   )
   static void method3761() {
      if(client.field573) {
         class173 var0 = class157.method3195(client.field449, client.field442);
         if(null != var0 && null != var0.field2859) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field7 = var0.field2859;
            class3.method48(var1);
         }

         client.field573 = false;
         class134.method2877(var0);
      }
   }
}
