import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class90 {
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-437836171"
   )
   static boolean method2140(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class138.method2969(var0, client.field294);

         for(int var3 = 0; var3 < client.field555; ++var3) {
            if(var2.equalsIgnoreCase(class138.method2969(client.field557[var3].field254, client.field294)) && (!var1 || client.field557[var3].field249 != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class138.method2969(class15.field225.field60, client.field294))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
