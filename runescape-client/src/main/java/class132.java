import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("eu")
public final class class132 {
   @ObfuscatedName("i")
   public static int[] field2126;
   @ObfuscatedName("ai")
   static class149 field2127;

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1678925401"
   )
   static void method2867(String var0) {
      Client.field287 = var0;

      try {
         String var1 = Client.field277.getParameter(class193.field3122.field3121);
         String var2 = Client.field277.getParameter(class193.field3119.field3121);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + Sequence.method932(class5.method63() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         Client var4 = Client.field277;
         String var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var4).eval(var5);
      } catch (Throwable var6) {
         ;
      }

   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-637524674"
   )
   static boolean method2871(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = Frames.method2312(var0, Client.field283);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(Frames.method2312(Client.friends[var3].name, Client.field283)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(Frames.method2312(WidgetNode.localPlayer.name, Client.field283))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
