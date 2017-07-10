import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class164 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass254;",
      garbageValue = "1833322020"
   )
   public static class254 method3059(int var0) {
      class254 var1 = (class254)class254.field3421.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3441.getConfigData(32, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4481(new Buffer(var2));
         }

         class254.field3421.put(var1, (long)var0);
         return var1;
      }
   }
}
