import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("as")
public class class33 {
   @ObfuscatedName("at")
   static int[] field775;
   @ObfuscatedName("a")
   static final class33 field776 = new class33();
   @ObfuscatedName("f")
   static final class33 field777 = new class33();
   @ObfuscatedName("s")
   static final class33 field778 = new class33();
   @ObfuscatedName("r")
   static final class33 field783 = new class33();

   @ObfuscatedName("y")
   public static final boolean method715() {
      class136 var0 = class136.field2108;
      synchronized(class136.field2108) {
         if(class136.field2116 == class136.field2101) {
            return false;
         } else {
            class13.field201 = class136.field2103[class136.field2101];
            class110.field1948 = class136.field2093[class136.field2101];
            class136.field2101 = class136.field2101 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("r")
   public static String method716(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class161.field2630[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
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
