import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class212 {
   @ObfuscatedName("gh")
   public static final int[] field3117 = new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, -2, 0, 0, 7, 0, 7, -1, -1, 10, 6, 0, 0, 0, 0, 0, 6, 0, 0, 0, 8, 0, 0, 0, 0, 0, 5, 2, 8, 2, 0, 0, 0, -2, 0, 0, 0, -2, 4, 0, 4, 0, -2, 0, 0, 0, 10, 0, 0, 0, 0, 6, 6, 0, 0, -2, 0, 2, 20, 0, 0, 0, 0, 0, -2, 0, -2, 0, 6, 0, 0, 0, 0, 0, 0, 1, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, -2, 2, 6, -1, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 4, 0, -2, 5, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, -2, 0, 4, 0, 12, 2, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 5, 0, 0, -1, 2, 0, 0, -2, 0, 0, 3, 0, 3, 0, 2, 8, 0, -2, 0, 0, 0, 5, 6, -2, 0, 0, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 0, 0, -2, 14, 15, 0, 0, 0, 6, -1, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 4, 0, 0, -1, 2, 0, -2, 0, 0, 6, -2, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0};

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "58"
   )
   public static String method4022(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class196.method3649(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
