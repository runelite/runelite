import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("is")
public class class252 {
   @ObfuscatedName("k")
   public static String decodeBase37(long encoded) {
      if(encoded > 0L && encoded < 6582952005840035281L) {
         if(0L == encoded % 37L) {
            return null; //invalid name
         } else {
            int var2 = 0;

            for(long var3 = encoded; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != encoded; var5.append(var8)) {
               long name = encoded;
               encoded /= 37L;
               var8 = class316.BASE_37_CHARACTERS[(int)(name - 37L * encoded)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
