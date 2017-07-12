import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class140 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZIB)V",
      garbageValue = "6"
   )
   static void method2857(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class17.field317) {
         if(var3 == 4) {
            class92.loginIndex = 4;
         }

      } else {
         class92.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4145("title.jpg", "");
         class92.field1451 = Coordinates.method3928(var4);
         class3.field19 = class92.field1451.method5040();
         if((Client.flags & 536870912) != 0) {
            class83.logoSprite = DState.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class83.logoSprite = DState.getSprite(var1, "logo", "");
         }

         class92.field1461 = DState.getSprite(var1, "titlebox", "");
         class92.field1475 = DState.getSprite(var1, "titlebutton", "");
         class266.field3669 = class64.method1117(var1, "runes", "");
         WorldMapType2.titlemuteSprite = class64.method1117(var1, "title_mute", "");
         class5.field40 = DState.getSprite(var1, "options_radio_buttons,0", "");
         class224.field2855 = DState.getSprite(var1, "options_radio_buttons,2", "");
         class41.field586 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            class41.field586[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class41.field586[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class41.field586[var5 + 128] = 4 * var5 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class41.field586[var5 + 192] = 16777215;
         }

         class244.field3326 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class244.field3326[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class244.field3326[var5 + 64] = var5 * 4 + '\uff00';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class244.field3326[var5 + 128] = var5 * 262144 + '\uffff';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class244.field3326[var5 + 192] = 16777215;
         }

         class83.field1370 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class83.field1370[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class83.field1370[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class83.field1370[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class83.field1370[var5 + 192] = 16777215;
         }

         WorldMapType3.field375 = new int[256];
         GraphicsObject.field1382 = new int['耀'];
         class14.field293 = new int['耀'];
         CacheFile.method2346((ModIcon)null);
         class12.field270 = new int['耀'];
         Ignore.field864 = new int['耀'];
         if(var2) {
            class92.username = "";
            class92.password = "";
         }

         Script.authCodeForLogin = 0;
         class36.authCode = "";
         class92.field1473 = true;
         class92.worldSelectShown = false;
         if(!class8.preferences.muted) {
            Timer.method2968(2, class44.indexTrack1, "scape main", "", 255, false);
         } else {
            class174.method3343(2);
         }

         class170.sendConInfo(false);
         class17.field317 = true;
         class92.field1470 = (class45.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1470 + 202;
         class92.field1451.method5074(class92.field1470, 0);
         class3.field19.method5074(class92.field1470 + 382, 0);
         class83.logoSprite.method5025(class92.field1470 + 382 - class83.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "805176549"
   )
   static final void method2856(Widget var0, int var1, int var2) {
      if(Client.field1100 == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var5 = var0;
            int var7 = WorldMapType3.getWidgetConfig(var0);
            int var6 = var7 >> 17 & 7;
            int var8 = var6;
            Widget var4;
            int var9;
            if(var6 == 0) {
               var4 = null;
            } else {
               var9 = 0;

               while(true) {
                  if(var9 >= var8) {
                     var4 = var5;
                     break;
                  }

                  var5 = PacketBuffer.method3403(var5.parentId);
                  if(var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var9;
               }
            }

            Widget var10 = var4;
            if(var4 == null) {
               var10 = var0.dragParent;
            }

            if(var10 != null) {
               Client.field1100 = var0;
               var5 = var0;
               var7 = WorldMapType3.getWidgetConfig(var0);
               var6 = var7 >> 17 & 7;
               var8 = var6;
               if(var6 == 0) {
                  var4 = null;
               } else {
                  var9 = 0;

                  while(true) {
                     if(var9 >= var8) {
                        var4 = var5;
                        break;
                     }

                     var5 = PacketBuffer.method3403(var5.parentId);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var9;
                  }
               }

               var10 = var4;
               if(var4 == null) {
                  var10 = var0.dragParent;
               }

               Client.field1101 = var10;
               Client.field1102 = var1;
               Client.field1103 = var2;
               class220.field2809 = 0;
               Client.field1111 = false;
               int var11 = class2.method7();
               if(var11 != -1) {
                  class13.field281 = new class89();
                  class13.field281.field1433 = Client.menuActionParams0[var11];
                  class13.field281.field1429 = Client.menuActionParams1[var11];
                  class13.field281.field1427 = Client.menuTypes[var11];
                  class13.field281.field1428 = Client.menuIdentifiers[var11];
                  class13.field281.field1425 = Client.menuOptions[var11];
               }

               return;
            }
         }

      }
   }
}
