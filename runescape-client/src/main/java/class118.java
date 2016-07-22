import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class118 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 7153725490281601031L
   )
   static long field2028;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lclass133;",
      garbageValue = "-1960950966"
   )
   static class133[] method2511() {
      return new class133[]{class133.field2114, class133.field2115, class133.field2110};
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1673438386"
   )
   static void method2512() {
      if(client.field444) {
         class176 var0 = class158.method3212(class96.field1669, client.field426);
         if(null != var0 && var0.field2887 != null) {
            class0 var1 = new class0();
            var1.field3 = var0;
            var1.field1 = var0.field2887;
            class43.method884(var1, 200000);
         }

         client.field444 = false;
         class92.method2164(var0);
      }
   }
}
