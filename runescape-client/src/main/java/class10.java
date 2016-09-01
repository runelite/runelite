import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class10 extends class110 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass215;I)Ljava/lang/String;",
      garbageValue = "1813266747"
   )
   public static String method123(CharSequence var0, class215 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && Sequence.method896(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && Sequence.method896(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3199) {
               case 0:
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
                  } else if(class139.method2942(var7)) {
                     var8 = true;
                  } else {
                     char[] var13 = class167.field2717;
                     int var10 = 0;

                     label124:
                     while(true) {
                        char var11;
                        if(var10 >= var13.length) {
                           var13 = class167.field2720;

                           for(var10 = 0; var10 < var13.length; ++var10) {
                              var11 = var13[var10];
                              if(var7 == var11) {
                                 var8 = true;
                                 break label124;
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)V",
      garbageValue = "1580551610"
   )
   static void method124(class125 var0, int var1) {
      boolean var2 = var0.method2827(1) == 1;
      if(var2) {
         class34.field771[++class34.field762 - 1] = var1;
      }

      int var3 = var0.method2827(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field49 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class34.field761[var1] = (var4.field47 << 28) + (var4.pathX[0] + class28.baseX >> 6 << 14) + (class159.baseY + var4.pathY[0] >> 6);
            if(var4.field845 != -1) {
               class34.field765[var1] = var4.field845;
            } else {
               class34.field765[var1] = var4.field835;
            }

            class34.field766[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method2827(1) != 0) {
               ChatLineBuffer.method645(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2827(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method36(var6, var7);
               var4.field49 = false;
            } else if(var2) {
               var4.field49 = true;
               var4.field50 = var6;
               var4.field26 = var7;
            } else {
               var4.field49 = false;
               var4.method17(var6, var7, class34.field758[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2827(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method36(var6, var7);
               var4.field49 = false;
            } else if(var2) {
               var4.field49 = true;
               var4.field50 = var6;
               var4.field26 = var7;
            } else {
               var4.field49 = false;
               var4.method17(var6, var7, class34.field758[var1]);
            }

         } else {
            var5 = var0.method2827(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2827(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.pathX[0] + var8;
               var11 = var4.pathY[0] + var9;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field49 = true;
                     var4.field50 = var10;
                     var4.field26 = var11;
                  } else {
                     var4.field49 = false;
                     var4.method17(var10, var11, class34.field758[var1]);
                  }
               } else {
                  var4.method36(var10, var11);
                  var4.field49 = false;
               }

               var4.field47 = (byte)(var7 + var4.field47 & 3);
               if(Client.localInteractingIndex == var1) {
                  FrameMap.plane = var4.field47;
               }

            } else {
               var6 = var0.method2827(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.pathX[0] + class28.baseX & 16383) - class28.baseX;
               var11 = (class159.baseY + var4.pathY[0] + var9 & 16383) - class159.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method36(var10, var11);
                  var4.field49 = false;
               } else if(var2) {
                  var4.field49 = true;
                  var4.field50 = var10;
                  var4.field26 = var11;
               } else {
                  var4.field49 = false;
                  var4.method17(var10, var11, class34.field758[var1]);
               }

               var4.field47 = (byte)(var7 + var4.field47 & 3);
               if(Client.localInteractingIndex == var1) {
                  FrameMap.plane = var4.field47;
               }

            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1661057489"
   )
   static void method126(int var0, int var1, int var2) {
      if(Client.field519 != 0 && var1 != 0 && Client.field521 < 50) {
         Client.field325[Client.field521] = var0;
         Client.field523[Client.field521] = var1;
         Client.field286[Client.field521] = var2;
         Client.field526[Client.field521] = null;
         Client.field434[Client.field521] = 0;
         ++Client.field521;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "31"
   )
   protected boolean vmethod2439(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field1943 && var3 == super.field1940;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "2117751851"
   )
   public static SpritePixels[] method128(class170 var0, String var1, String var2) {
      int var3 = var0.method3359(var1);
      int var4 = var0.method3305(var3, var2);
      SpritePixels[] var5;
      if(!NPCComposition.method775(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = Buffer.method2773();
      }

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1423931638"
   )
   public static final boolean method129() {
      class140 var0 = class140.keyboard;
      synchronized(class140.keyboard) {
         if(class140.field2150 == class140.field2164) {
            return false;
         } else {
            class132.field2102 = class140.field2172[class140.field2150];
            class113.field2009 = class140.field2160[class140.field2150];
            class140.field2150 = 1 + class140.field2150 & 127;
            return true;
         }
      }
   }
}
