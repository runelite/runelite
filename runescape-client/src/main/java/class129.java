import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public final class class129 {
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "2092063837"
   )
   static final void method2810(class173 var0, int var1, int var2) {
      if(client.field450 == null && !client.field418 && var0 != null) {
         class173 var3 = class111.method2420(var0);
         if(null == var3) {
            var3 = var0.field2871;
         }

         if(null != var3) {
            client.field450 = var0;
            var3 = class111.method2420(var0);
            if(null == var3) {
               var3 = var0.field2871;
            }

            client.field288 = var3;
            client.field452 = var1;
            client.field453 = var2;
            class56.field1188 = 0;
            client.field461 = false;
            if(client.field496 > 0) {
               class48.method973(client.field496 - 1);
            }

            return;
         }
      }

   }
}
