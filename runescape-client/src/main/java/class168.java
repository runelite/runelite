import java.util.Date;
import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("fv")
public class class168 {
   @ObfuscatedName("i")
   static IndexDataBase field2355;

   static {
      new HashMap();
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "832205489"
   )
   static void method3111(String var0) {
      class67.field833 = var0;

      try {
         String var1 = Client.field1214.getParameter(class274.field3728.field3731);
         String var2 = Client.field1214.getParameter(class274.field3729.field3731);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = XGrandExchangeOffer.method96() + 94608000000L;
            class182.field2455.setTime(new Date(var6));
            int var8 = class182.field2455.get(7);
            int var9 = class182.field2455.get(5);
            int var10 = class182.field2455.get(2);
            int var11 = class182.field2455.get(1);
            int var12 = class182.field2455.get(11);
            int var13 = class182.field2455.get(12);
            int var14 = class182.field2455.get(13);
            var5 = class182.field2451[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class182.field2452[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         Client var16 = Client.field1214;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }
}
