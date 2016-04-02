import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ed")
public class class148 extends RuntimeException {
   @ObfuscatedName("p")
   Throwable field2218;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1632640873
   )
   public static int field2219;
   @ObfuscatedName("e")
   static Applet field2220;
   @ObfuscatedName("s")
   String field2223;

   @ObfuscatedName("e")
   public static String method3125(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class162.field2648[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("w")
   public static class173 method3129(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == class173.field2837[var1] || class173.field2837[var1][var2] == null) {
         boolean var3 = class113.method2462(var1);
         if(!var3) {
            return null;
         }
      }

      return class173.field2837[var1][var2];
   }
}
