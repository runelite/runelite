import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class138 {
   @ObfuscatedName("u")
   static String field2133 = null;
   @ObfuscatedName("f")
   static Applet field2136 = null;
   @ObfuscatedName("ey")
   static class78[] field2139;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass212;I)Ljava/lang/String;",
      garbageValue = "184255459"
   )
   public static String method2969(CharSequence var0, class212 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1 && var14 <= class25.method649(var1)) {
            StringBuilder var13 = new StringBuilder(var14);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else {
                  boolean var9 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                  if(var9) {
                     var8 = true;
                  } else {
                     char[] var10 = class164.field2654;
                     int var11 = 0;

                     label125:
                     while(true) {
                        char var12;
                        if(var11 >= var10.length) {
                           var10 = class164.field2658;

                           for(var11 = 0; var11 < var10.length; ++var11) {
                              var12 = var10[var11];
                              if(var7 == var12) {
                                 var8 = true;
                                 break label125;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var12 = var10[var11];
                        if(var7 == var12) {
                           var8 = true;
                           break;
                        }

                        ++var11;
                     }
                  }
               }

               if(var8) {
                  char var15 = class106.method2426(var7);
                  if(var15 != 0) {
                     var13.append(var15);
                  }
               }
            }

            if(var13.length() == 0) {
               return null;
            } else {
               return var13.toString();
            }
         } else {
            return null;
         }
      }
   }
}
