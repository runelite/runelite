import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class7 {
   @ObfuscatedName("a")
   public static boolean field232;
   @ObfuscatedName("t")
   public static class11 field233;
   @ObfuscatedName("s")
   public static CombatInfoList field234;
   @ObfuscatedName("i")
   public static boolean field236;
   @ObfuscatedName("l")
   public static class234 field237;
   @ObfuscatedName("w")
   public static boolean field238;
   @ObfuscatedName("r")
   public static int[] field239;

   static {
      field236 = false;
      field238 = false;
      field232 = false;
      field233 = class11.field268;
      field234 = new CombatInfoList();
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-710339884"
   )
   static final boolean method39(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field978 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1198.method3958(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1198.method3932(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1198.method3931(false);
         }

         if(var1 == 325) {
            Client.field1198.method3931(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(189);
            Client.field1198.method3934(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }
}
