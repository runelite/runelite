import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class225 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2084467383
   )
   static int field3214;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 159667517
   )
   static int field3215;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 901669625
   )
   static int field3216;
   @ObfuscatedName("k")
   public static int[] field3217;
   @ObfuscatedName("n")
   public static int[] field3218;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1325459135"
   )
   public static String method4146(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class162.method3009(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
