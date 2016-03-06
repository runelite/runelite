import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ed")
public abstract class class132 {
   @ObfuscatedName("bf")
   protected static FontMetrics field2070;
   @ObfuscatedName("gd")
   static class172 field2073;

   @ObfuscatedName("l")
   abstract void vmethod3066();

   @ObfuscatedName("a")
   abstract int vmethod3067(int var1, int var2);

   @ObfuscatedName("dh")
   static boolean method2791(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class134.method2803(var0, client.field473);

         for(int var3 = 0; var3 < client.field421; ++var3) {
            if(var2.equalsIgnoreCase(class134.method2803(client.field557[var3].field253, client.field473)) && (!var1 || client.field557[var3].field248 != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class134.method2803(class148.field2249.field48, client.field473))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
