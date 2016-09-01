import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class118 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -9123447155943715055L
   )
   static long field2032;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -1632452023942330573L
   )
   static long field2035;

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "2052513545"
   )
   static final boolean method2499(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field440 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field553.method3499(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field553.method3500(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field553.method3501(false);
         }

         if(var1 == 325) {
            Client.field553.method3501(true);
         }

         if(var1 == 326) {
            Client.field323.method2818(87);
            Client.field553.method3502(Client.field323);
            return true;
         } else {
            return false;
         }
      }
   }
}
