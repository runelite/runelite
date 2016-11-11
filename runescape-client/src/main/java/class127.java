import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class127 {
   @ObfuscatedName("na")
   static class77 field2079;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   static void method2819() {
      FileOnDisk var0 = null;

      try {
         var0 = GameEngine.method3132("", class114.field2004.field2341, true);
         Buffer var1 = Player.field42.method107();
         var0.method4153(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4156();
         }
      } catch (Exception var2) {
         ;
      }

   }
}
