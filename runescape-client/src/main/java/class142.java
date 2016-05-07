import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class142 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Lclass153;",
      garbageValue = "-1675212104"
   )
   public static class153[] method2957() {
      return new class153[]{class153.field2288, class153.field2289, class153.field2287, class153.field2286};
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1433836915"
   )
   static boolean method2958(String var0) {
      if(null == var0) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }
}
