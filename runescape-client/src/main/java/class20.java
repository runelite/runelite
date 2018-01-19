import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class20 {
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = 1039169479
   )
   static int field327;

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      signature = "(Lhq;I)Z",
      garbageValue = "793162376"
   )
   static boolean method150(Widget var0) {
      if(Client.field911) {
         if(GraphicsObject.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
