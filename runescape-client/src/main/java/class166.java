import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public final class class166 {
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 1498745013
   )
   static int field2710;

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "-55"
   )
   static boolean method3234(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class23.method579(var0, class134.field2117);

         for(int var3 = 0; var3 < client.field537; ++var3) {
            if(var2.equalsIgnoreCase(class23.method579(client.field273[var3].field229, class134.field2117)) && (!var1 || client.field273[var3].field223 != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class23.method579(class114.field2010.field43, class134.field2117))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1562011683"
   )
   public static void method3268(int var0, int var1) {
      class50 var2 = class7.method103(var0);
      int var3 = var2.field1112;
      int var4 = var2.field1107;
      int var5 = var2.field1106;
      int var6 = class179.field2952[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class179.field2949[var3] = class179.field2949[var3] & ~var6 | var1 << var4 & var6;
   }
}
