import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public abstract class class159 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1280125978"
   )
   public abstract boolean vmethod3220(int var1) throws IOException;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-120"
   )
   public abstract int vmethod3188() throws IOException;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-693383529"
   )
   public abstract int vmethod3215() throws IOException;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-719042495"
   )
   public abstract int vmethod3190(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "44"
   )
   public abstract void vmethod3192(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-953149698"
   )
   public abstract void vmethod3186();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lld;I)Ljava/lang/String;",
      garbageValue = "-2134727145"
   )
   @Export("cleanUsername")
   public static String cleanUsername(CharSequence var0, JagexLoginType var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class39.method535(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class39.method535(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3964) {
               case 3:
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
                  } else if(MilliTimer.method3053(var7)) {
                     var8 = true;
                  } else {
                     char[] var13 = class290.field3763;
                     int var10 = 0;

                     label98:
                     while(true) {
                        char var11;
                        if(var10 >= var13.length) {
                           var13 = class290.field3766;

                           for(var10 = 0; var10 < var13.length; ++var10) {
                              var11 = var13[var10];
                              if(var11 == var7) {
                                 var8 = true;
                                 break label98;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var11 = var13[var10];
                        if(var7 == var11) {
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
                        var9 = '_';
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
                        var9 = 'a';
                        break;
                     case 'Ç':
                     case 'ç':
                        var9 = 'c';
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var9 = 'e';
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var9 = 'i';
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var9 = 'n';
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
                        var9 = 'o';
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var9 = 'u';
                        break;
                     case 'ß':
                        var9 = 'b';
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var9 = 'y';
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
