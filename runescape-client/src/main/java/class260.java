import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
public class class260 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Ljq;",
      garbageValue = "2"
   )
   public static class263 method4605(int var0) {
      class263 var1 = (class263)class263.field3485.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class60.field723.getConfigData(34, var0);
         var1 = new class263();
         if(var2 != null) {
            var1.method4653(new Buffer(var2));
         }

         var1.method4634();
         class263.field3485.put(var1, (long)var0);
         return var1;
      }
   }
}
