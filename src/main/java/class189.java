import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class189 {
   @ObfuscatedName("y")
   static class167 field3058;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "-782428467"
   )
   public static class45 method3830(int var0) {
      class45 var1 = (class45)class45.field1054.method3840((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class45.field1056.method3403(19, var0);
         var1 = new class45();
         if(var2 != null) {
            var1.method1046(new class119(var2));
         }

         class45.field1054.method3842(var1, (long)var0);
         return var1;
      }
   }
}
