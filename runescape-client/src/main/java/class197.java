import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class197 {
   @ObfuscatedName("ot")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   static Resampler field2565;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1187304355
   )
   public static int field2566;

   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "(Lim;I)Z",
      garbageValue = "-1808991180"
   )
   static boolean method3823(Widget var0) {
      if(Client.field1000) {
         if(class230.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
