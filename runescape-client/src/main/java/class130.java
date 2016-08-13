import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class130 {
   @ObfuscatedName("f")
   public static String[] field2100;
   @ObfuscatedName("es")
   static SpritePixels[] field2101;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[Lclass85;",
      garbageValue = "-1975964480"
   )
   public static class85[] method2968() {
      return new class85[]{class85.field1505, class85.field1516, class85.field1507, class85.field1509, class85.field1513};
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-102199171"
   )
   public static String method2971(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class33.method735(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
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
