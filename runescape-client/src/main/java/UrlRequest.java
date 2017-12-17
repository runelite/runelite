import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ep")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("u")
   static byte[][][] field2083;
   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "Lbj;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("a")
   @Export("url")
   final URL url;
   @ObfuscatedName("w")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("e")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2084842518"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-2069544774"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-93248754"
   )
   public static boolean method2926(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "43"
   )
   static void method2922(String var0) {
      MilliTimer.sessionToken = var0;

      try {
         String var1 = TotalQuantityComparator.clientInstance.getParameter(Parameters.field3786.key);
         String var2 = TotalQuantityComparator.clientInstance.getParameter(Parameters.field3785.key);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + Client.method1457(Preferences.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         Client var4 = TotalQuantityComparator.clientInstance;
         String var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var4).eval(var5);
      } catch (Throwable var6) {
         ;
      }

   }
}
