import java.awt.Image;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("cy")
   static class227 field1850;
   @ObfuscatedName("qa")
   static Image field1852;
   @ObfuscatedName("eo")
   static SpritePixels field1853;
   @ObfuscatedName("a")
   Frame[] field1858;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public boolean method2306(int var1) {
      return this.field1858[var1].field1633;
   }

   Frames(class170 var1, class170 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3319(var3);
      this.field1858 = new Frame[var6];
      int[] var7 = var1.method3330(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3309(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3854(); var12 != null; var12 = (FrameMap)var5.method3869()) {
            if(var12.field1843 == var11) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3315(0, var11);
            } else {
               var13 = var2.method3315(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method3849(var10);
         }

         this.field1858[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass215;I)Ljava/lang/String;",
      garbageValue = "-1437162180"
   )
   public static String method2312(CharSequence var0, class215 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && FrameMap.method2304(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && FrameMap.method2304(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3197) {
               case 5:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var4 <= var6) {
               StringBuilder var10 = new StringBuilder(var4);

               for(int var11 = var2; var11 < var3; ++var11) {
                  char var7 = var0.charAt(var11);
                  if(NPC.method758(var7)) {
                     char var8;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var8 = 95;
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var8 = var7;
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
                        var8 = 97;
                        break;
                     case 'Ç':
                     case 'ç':
                        var8 = 99;
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var8 = 101;
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var8 = 105;
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var8 = 110;
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
                        var8 = 111;
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var8 = 117;
                        break;
                     case 'ß':
                        var8 = 98;
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var8 = 121;
                        break;
                     default:
                        var8 = Character.toLowerCase(var7);
                     }

                     if(var8 != 0) {
                        var10.append(var8);
                     }
                  }
               }

               if(var10.length() == 0) {
                  return null;
               }

               return var10.toString();
            }
         }

         return null;
      }
   }
}
