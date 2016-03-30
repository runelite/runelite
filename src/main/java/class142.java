import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("et")
public class class142 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -6691539213482381539L
   )
   public static long field2198;

   @ObfuscatedName("e")
   public static void method2994(int var0) {
      class140.field2169 = var0;
   }

   @ObfuscatedName("v")
   public static byte[] method2995(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class125) {
         class125 var2 = (class125)var0;
         return var2.vmethod2794();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("dj")
   static void method2996(String var0) {
      class93.field1604 = var0;

      try {
         String var1 = client.field294.getParameter(class190.field3076.field3079);
         String var2 = client.field294.getParameter(class190.field3077.field3079);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class39.method815(class14.method165() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class132.method2848(client.field294, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }

   @ObfuscatedName("t")
   public static String method2997(CharSequence var0, class212 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class129.method2831(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class129.method2831(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= class13.method164(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else if(class104.method2294(var7)) {
                  var8 = true;
               } else {
                  char[] var9 = class164.field2677;
                  int var10 = 0;

                  label108:
                  while(true) {
                     char var11;
                     if(var10 >= var9.length) {
                        var9 = class164.field2675;

                        for(var10 = 0; var10 < var9.length; ++var10) {
                           var11 = var9[var10];
                           if(var11 == var7) {
                              var8 = true;
                              break label108;
                           }
                        }

                        var8 = false;
                        break;
                     }

                     var11 = var9[var10];
                     if(var11 == var7) {
                        var8 = true;
                        break;
                     }

                     ++var10;
                  }
               }

               if(var8) {
                  char var12;
                  switch(var7) {
                  case ' ':
                  case '-':
                  case '_':
                  case ' ':
                     var12 = 95;
                     break;
                  case '#':
                  case '[':
                  case ']':
                     var12 = var7;
                     break;
                  case 'À':
                  case 'Á':
                  case 'Â':
                  case 'Ã':
                  case 'Ä':
                  case 'à':
                  case 'á':
                  case 'â':
                  case 'ã':
                  case 'ä':
                     var12 = 97;
                     break;
                  case 'Ç':
                  case 'ç':
                     var12 = 99;
                     break;
                  case 'È':
                  case 'É':
                  case 'Ê':
                  case 'Ë':
                  case 'è':
                  case 'é':
                  case 'ê':
                  case 'ë':
                     var12 = 101;
                     break;
                  case 'Í':
                  case 'Î':
                  case 'Ï':
                  case 'í':
                  case 'î':
                  case 'ï':
                     var12 = 105;
                     break;
                  case 'Ñ':
                  case 'ñ':
                     var12 = 110;
                     break;
                  case 'Ò':
                  case 'Ó':
                  case 'Ô':
                  case 'Õ':
                  case 'Ö':
                  case 'ò':
                  case 'ó':
                  case 'ô':
                  case 'õ':
                  case 'ö':
                     var12 = 111;
                     break;
                  case 'Ù':
                  case 'Ú':
                  case 'Û':
                  case 'Ü':
                  case 'ù':
                  case 'ú':
                  case 'û':
                  case 'ü':
                     var12 = 117;
                     break;
                  case 'ß':
                     var12 = 98;
                     break;
                  case 'ÿ':
                  case 'Ÿ':
                     var12 = 121;
                     break;
                  default:
                     var12 = Character.toLowerCase(var7);
                  }

                  if(0 != var12) {
                     var5.append(var12);
                  }
               }
            }

            if(var5.length() == 0) {
               return null;
            } else {
               return var5.toString();
            }
         } else {
            return null;
         }
      }
   }
}
