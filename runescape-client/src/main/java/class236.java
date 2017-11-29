import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public final class class236 {
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   @Export("jagexLoginType")
   static JagexLoginType jagexLoginType;

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-357531925"
   )
   static void method4243(int var0) {
      for(IntegerNode var1 = (IntegerNode)Client.widgetFlags.first(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.next()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }
}
