import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ff")
public class class157 {
   @ObfuscatedName("cy")
   static final void method3168(class173 var0, int var1, int var2) {
      if(client.field451 == null && !client.field331) {
         if(null != var0 && class154.method3162(var0) != null) {
            client.field451 = var0;
            client.field452 = class154.method3162(var0);
            client.field453 = var1;
            client.field517 = var2;
            class7.field139 = 0;
            client.field462 = false;
            if(client.field420 > 0) {
               class15.method177(client.field420 - 1);
            }

         }
      }
   }

   @ObfuscatedName("e")
   public static class50 method3169(int var0) {
      class50 var1 = (class50)class50.field1075.method3754((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class213.field3144.method3280(5, var0);
         var1 = new class50();
         if(null != var2) {
            var1.method1004(new class119(var2));
         }

         class50.field1075.method3756(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cb")
   static void method3170(int var0, int var1) {
      client.field321.method2762(198);
      client.field321.method2548(var1);
      client.field321.method2617(var0);
   }
}
