import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class160 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass42;",
      garbageValue = "578547655"
   )
   @Export("getObjectDefinition")
   public static class42 method3312(int var0) {
      class42 var1 = (class42)class42.field947.method3905((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class42.field945.method3411(6, var0);
         var1 = new class42();
         var1.field952 = var0;
         if(var2 != null) {
            var1.method880(new class122(var2));
         }

         var1.method845();
         if(var1.field984) {
            var1.field998 = 0;
            var1.field961 = false;
         }

         class42.field947.method3907(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   static final void method3313(boolean var0) {
      class47.method1009();
      ++client.field343;
      if(client.field343 >= 50 || var0) {
         client.field343 = 0;
         if(!client.field348 && null != class40.field904) {
            client.field337.method2903(177);

            try {
               class40.field904.method3135(client.field337.field2051, 0, client.field337.field2050);
               client.field337.field2050 = 0;
            } catch (IOException var2) {
               client.field348 = true;
            }
         }

      }
   }
}
