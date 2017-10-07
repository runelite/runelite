import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class223 {
   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "(Lhj;S)Lhj;",
      garbageValue = "2027"
   )
   static Widget method4190(Widget var0) {
      int var1 = class168.method3205(class244.getWidgetConfig(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = PacketBuffer.method3528(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
