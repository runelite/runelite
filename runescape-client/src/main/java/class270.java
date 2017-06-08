import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
public final class class270 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-4"
   )
   static void method4919(int var0) {
      if(var0 != -1) {
         if(class73.method1095(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2733 != null) {
                  class69 var4 = new class69();
                  var4.field824 = var3;
                  var4.field833 = var3.field2733;
                  class207.method3902(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lclass254;",
      garbageValue = "1173901102"
   )
   public static class254 method4936(int var0) {
      class254 var1 = (class254)class254.field3419.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3430.getConfigData(32, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4503(new Buffer(var2));
         }

         class254.field3419.put(var1, (long)var0);
         return var1;
      }
   }
}
