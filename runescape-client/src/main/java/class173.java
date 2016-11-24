import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class173 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lclass194;",
      garbageValue = "87"
   )
   public static class194 method3303(int var0) {
      class194 var1 = (class194)class194.field2849.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class194.field2851.method3329(14, var0);
         var1 = new class194();
         if(null != var2) {
            var1.method3589(new Buffer(var2));
         }

         class194.field2849.put(var1, (long)var0);
         return var1;
      }
   }
}
