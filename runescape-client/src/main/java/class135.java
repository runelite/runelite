import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class135 {
   @ObfuscatedName("s")
   static class80 field2101;
   @ObfuscatedName("i")
   static File field2103;
   @ObfuscatedName("d")
   public static short[] field2106;
   @ObfuscatedName("t")
   static boolean field2107 = false;
   @ObfuscatedName("g")
   static Hashtable field2109 = new Hashtable(16);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "500"
   )
   static final void method2845() {
      if(null != client.field331) {
         client.field331.method1186();
      }

      if(class17.field247 != null) {
         class17.field247.method1186();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "0"
   )
   public static void method2850(String var0, boolean var1, boolean var2) {
      class158.method3142(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "50"
   )
   public static String method2851(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class13.method143(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
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
