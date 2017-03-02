import java.awt.Canvas;
import java.awt.Color;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public final class class9 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1794886851
   )
   static int field78;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 979132237
   )
   static int field80;
   @ObfuscatedName("y")
   public static Buffer field83;
   @ObfuscatedName("hy")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("kl")
   @Export("chatMessages")
   static ChatMessages chatMessages;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "695891332"
   )
   static final void method117(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var14 = class10.tileHeights[0][var2];
                  int var11 = var4 + 932731 + var2;
                  int var12 = var3 + 556238 + var5;
                  int var13 = class178.method3336('넵' + var11, 91923 + var12, 4) - 128 + (class178.method3336(10294 + var11, '鎽' + var12, 2) - 128 >> 1) + (class178.method3336(var11, var12, 1) - 128 >> 2);
                  var13 = 35 + (int)(0.3D * (double)var13);
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var14[var3] = -var13 * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class10.overlayIds[var1][var2][var3] = var0.readByte();
               class10.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class10.overlayRotations[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class10.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   class9() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1788332777"
   )
   static void method121() {
      Canvas var0 = class0.canvas;
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1703 = -1;
      XClanMember.method259(class0.canvas);
      if(null != class8.field73) {
         class8.field73.vmethod2152(class0.canvas);
      }

      Client.field279.method2221();
      class0.canvas.setBackground(Color.black);
      class162.method3172(class0.canvas);
      Actor.method638(class0.canvas);
      if(class8.field73 != null) {
         class8.field73.vmethod2162(class0.canvas);
      }

      if(Client.widgetRoot != -1) {
         class39.method814(false);
      }

      GameEngine.field1775 = true;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;I)Ljava/lang/String;",
      garbageValue = "1928072245"
   )
   public static String method122(CharSequence var0, class228 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var12;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var12 = var0.charAt(var2);
            var4 = var12 == 160 || var12 == 32 || var12 == 95 || var12 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var12 = var0.charAt(var3 - 1);
            var4 = var12 == 160 || var12 == 32 || var12 == 95 || var12 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1 && var14 <= class185.method3487(var1)) {
            StringBuilder var5 = new StringBuilder(var14);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else if(class41.method852(var7)) {
                  var8 = true;
               } else {
                  char[] var13 = class204.field3082;
                  int var10 = 0;

                  label107:
                  while(true) {
                     char var11;
                     if(var10 >= var13.length) {
                        var13 = class204.field3084;

                        for(var10 = 0; var10 < var13.length; ++var10) {
                           var11 = var13[var10];
                           if(var11 == var7) {
                              var8 = true;
                              break label107;
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
                  char var9 = class33.method760(var7);
                  if(var9 != 0) {
                     var5.append(var9);
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
