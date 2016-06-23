import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class191 {
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "5"
   )
   static void method3781(int var0, int var1) {
      if(client.field524 != 0 && var0 != -1) {
         class96.method2261(class152.field2257, var0, 0, client.field524, false);
         client.field526 = true;
      }

   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method3782() {
      for(int var0 = 0; var0 < client.field429; ++var0) {
         int var2 = client.field329[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < client.field429 - 1) {
               for(int var3 = var0; var3 < client.field429 - 1; ++var3) {
                  client.field459[var3] = client.field459[var3 + 1];
                  client.field435[var3] = client.field435[var3 + 1];
                  client.field329[var3] = client.field329[var3 + 1];
                  client.field433[var3] = client.field433[1 + var3];
                  client.field434[var3] = client.field434[var3 + 1];
                  client.field431[var3] = client.field431[var3 + 1];
               }
            }

            --client.field429;
         }
      }

   }
}
