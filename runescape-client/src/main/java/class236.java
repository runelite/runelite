import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public final class class236 {
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static class298 field3239;

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-357531925"
   )
   static void method4243(int var0) {
      for(IntegerNode var1 = (IntegerNode)Client.widgetFlags.method3707(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.method3703()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }
}
