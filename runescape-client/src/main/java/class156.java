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
   static Buffer field2338;
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
         for(var3 = var0.length(); var2 < var3 && World.method655(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && World.method655(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var5;
            if(null == var1) {
               var5 = 12;
            } else {
               switch(var1.field3199) {
               case 2:
                  var5 = 20;
                  break;
               default:
                  var5 = 12;
               }
            }

            if(var4 <= var5) {
               StringBuilder var6 = new StringBuilder(var4);

               for(int var7 = var2; var7 < var3; ++var7) {
                  char var8 = var0.charAt(var7);
                  boolean var9;
                  if(Character.isISOControl(var8)) {
                     var9 = false;
                  } else if(ItemLayer.method2290(var8)) {
                     var9 = true;
                  } else {
                     label121: {
                        char[] var10 = class167.field2713;

                        int var11;
                        char var12;
                        for(var11 = 0; var11 < var10.length; ++var11) {
                           var12 = var10[var11];
                           if(var12 == var8) {
                              var9 = true;
                              break label121;
                           }
                        }

                        var10 = class167.field2712;
                        var11 = 0;

                        while(true) {
                           if(var11 >= var10.length) {
                              var9 = false;
                              break;
                           }

                           var12 = var10[var11];
                           if(var8 == var12) {
                              var9 = true;
                              break;
                           }

                           ++var11;
                        }
                     }
                  }

                  if(var9) {
                     char var13;
                     switch(var8) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var13 = 95;
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var13 = var8;
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
                        var13 = 97;
                        break;
                     case 'Ç':
                     case 'ç':
                        var13 = 99;
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var13 = 101;
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var13 = 105;
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var13 = 110;
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
                        var13 = 111;
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var13 = 117;
                        break;
                     case 'ß':
                        var13 = 98;
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var13 = 121;
                        break;
                     default:
                        var13 = Character.toLowerCase(var8);
                     }

                     if(var13 != 0) {
                        var6.append(var13);
                     }
                  }
               }

               if(var6.length() == 0) {
                  return null;
               }

               return var6.toString();
            }
         }

         return null;
      }
   }
}
