import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class159 {
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -1703770483
   )
   static int field2372;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 1981613059
   )
   public static int field2374;

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1783033939"
   )
   static final boolean method3209(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field333 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field554.method3519(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field554.method3528(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field554.method3530(false);
         }

         if(var1 == 325) {
            Client.field554.method3530(true);
         }

         if(var1 == 326) {
            Client.field323.method2801(143);
            Client.field554.method3522(Client.field323);
            return true;
         } else {
            return false;
         }
      }
   }
}
