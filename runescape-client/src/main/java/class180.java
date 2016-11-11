import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class180 {
   @ObfuscatedName("e")
   static ModIcon field2958;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "-2044386030"
   )
   public static class51 method3491(int var0) {
      class51 var1 = (class51)class51.field1108.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class51.field1127.method3292(32, var0);
         var1 = new class51();
         if(var2 != null) {
            var1.method1035(new Buffer(var2));
         }

         class51.field1108.put(var1, (long)var0);
         return var1;
      }
   }
}
