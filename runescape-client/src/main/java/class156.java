import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class156 {
   @ObfuscatedName("g")
   static final class156 field2333 = new class156("BUILDLIVE", 3);
   @ObfuscatedName("r")
   static final class156 field2334 = new class156("RC", 1);
   @ObfuscatedName("l")
   static final class156 field2335 = new class156("LIVE", 0);
   @ObfuscatedName("h")
   public final String field2336;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1624633119
   )
   final int field2337;
   @ObfuscatedName("v")
   static class122 field2338;
   @ObfuscatedName("e")
   static final class156 field2339 = new class156("WIP", 2);

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class156(String var1, int var2) {
      this.field2336 = var1;
      this.field2337 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass215;I)Ljava/lang/String;",
      garbageValue = "-1443945512"
   )
   public static String method3300(CharSequence var0, class215 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class27.method655(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class27.method655(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3199) {
               case 2:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var4 <= var6) {
               StringBuilder var12 = new StringBuilder(var4);

               for(int var14 = var2; var14 < var3; ++var14) {
                  char var7 = var0.charAt(var14);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else if(class102.method2290(var7)) {
                     var8 = true;
                  } else {
                     char[] var13 = class167.field2713;
                     int var10 = 0;

                     label119:
                     while(true) {
                        char var11;
                        if(var10 >= var13.length) {
                           var13 = class167.field2712;

                           for(var10 = 0; var10 < var13.length; ++var10) {
                              var11 = var13[var10];
                              if(var7 == var11) {
                                 var8 = true;
                                 break label119;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var11 = var13[var10];
                        if(var11 == var7) {
                           var8 = true;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(var8) {
                     char var9;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var9 = 95;
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var9 = var7;
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
                        var9 = 97;
                        break;
                     case 'Ç':
                     case 'ç':
                        var9 = 99;
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var9 = 101;
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var9 = 105;
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var9 = 110;
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
                        var9 = 111;
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var9 = 117;
                        break;
                     case 'ß':
                        var9 = 98;
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var9 = 121;
                        break;
                     default:
                        var9 = Character.toLowerCase(var7);
                     }

                     if(var9 != 0) {
                        var12.append(var9);
                     }
                  }
               }

               if(var12.length() == 0) {
                  return null;
               }

               return var12.toString();
            }
         }

         return null;
      }
   }
}
