import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class56 {
   @ObfuscatedName("i")
   public static Applet field699;
   @ObfuscatedName("w")
   public static String field705;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "125"
   )
   public static int method849(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("a")
   public static String method850(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            char var4;
            StringBuilder var8;
            for(var8 = new StringBuilder(var2); 0L != var0; var8.append(var4)) {
               long var5 = var0;
               var0 /= 37L;
               var4 = class268.field3681[(int)(var5 - var0 * 37L)];
               if(var4 == 95) {
                  int var7 = var8.length() - 1;
                  var8.setCharAt(var7, Character.toUpperCase(var8.charAt(var7)));
                  var4 = 160;
               }
            }

            var8.reverse();
            var8.setCharAt(0, Character.toUpperCase(var8.charAt(0)));
            return var8.toString();
         }
      } else {
         return null;
      }
   }

   static {
      field699 = null;
      field705 = null;
   }
}
