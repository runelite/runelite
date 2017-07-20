import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class215 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1214744253
   )
   public static int field2605;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lkb;I)Ljava/lang/String;",
      garbageValue = "1554646860"
   )
   public static String method3908(CharSequence var0, class289 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && GameObject.method2835(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && GameObject.method2835(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3849) {
               case 0:
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
                  if(WorldMapType3.method204(var7)) {
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "585685475"
   )
   static int method3909(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
      } else {
         var3 = var2?class48.field614:FaceNormal.field2099;
      }

      class21.method156(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class83.intStack[--BufferProvider.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class226.localPlayer.composition.method3891();
            return 1;
         } else {
            return 2;
         }
      } else {
         BufferProvider.intStackSize -= 2;
         int var4 = class83.intStack[BufferProvider.intStackSize];
         int var5 = class83.intStack[BufferProvider.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class10.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2661 = var6.offsetX2d;
         var3.field2667 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2675 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2675 = 1;
         } else {
            var3.field2675 = 2;
         }

         if(var3.field2744 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2744;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }
}
