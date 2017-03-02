import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("b")
   @Export("name")
   String name;
   @ObfuscatedName("if")
   static Widget field201;
   @ObfuscatedName("l")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZB)V",
      garbageValue = "19"
   )
   static void method206(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class41.field817 = (class2.field21 - Client.field500) / 2;
         class41.loginWindowX = class41.field817 + 202;
      }

      byte var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var11;
      Graphics var23;
      int var34;
      int var41;
      if(class41.worldSelectShown) {
         if(class25.field575 == null) {
            class25.field575 = class149.method2823(class114.field1790, "sl_back", "");
         }

         if(null == class16.field172) {
            class16.field172 = class164.method3217(class114.field1790, "sl_flags", "");
         }

         if(null == class116.field1817) {
            class116.field1817 = class164.method3217(class114.field1790, "sl_arrows", "");
         }

         if(null == class179.field2691) {
            class179.field2691 = class164.method3217(class114.field1790, "sl_stars", "");
         }

         Rasterizer2D.method4099(class41.field817, 23, 765, 480, 0);
         Rasterizer2D.method4103(class41.field817, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method4103(125 + class41.field817, 0, 640, 23, 5197647, 2697513);
         var0.method4006("Select a world", 62 + class41.field817, 15, 0, -1);
         if(class179.field2691 != null) {
            class179.field2691[1].method4191(140 + class41.field817, 1);
            var1.method3974("Members only world", 152 + class41.field817, 10, 16777215, -1);
            class179.field2691[0].method4191(140 + class41.field817, 12);
            var1.method3974("Free world", class41.field817 + 152, 21, 16777215, -1);
         }

         int var38;
         if(null != class116.field1817) {
            var34 = 280 + class41.field817;
            if(World.field677[0] == 0 && World.field678[0] == 0) {
               class116.field1817[2].method4191(var34, 4);
            } else {
               class116.field1817[0].method4191(var34, 4);
            }

            if(World.field677[0] == 0 && World.field678[0] == 1) {
               class116.field1817[3].method4191(15 + var34, 4);
            } else {
               class116.field1817[1].method4191(var34 + 15, 4);
            }

            var0.method3974("World", 32 + var34, 17, 16777215, -1);
            var5 = class41.field817 + 390;
            if(World.field677[0] == 1 && World.field678[0] == 0) {
               class116.field1817[2].method4191(var5, 4);
            } else {
               class116.field1817[0].method4191(var5, 4);
            }

            if(World.field677[0] == 1 && World.field678[0] == 1) {
               class116.field1817[3].method4191(var5 + 15, 4);
            } else {
               class116.field1817[1].method4191(var5 + 15, 4);
            }

            var0.method3974("Players", 32 + var5, 17, 16777215, -1);
            var38 = class41.field817 + 500;
            if(World.field677[0] == 2 && World.field678[0] == 0) {
               class116.field1817[2].method4191(var38, 4);
            } else {
               class116.field1817[0].method4191(var38, 4);
            }

            if(World.field677[0] == 2 && World.field678[0] == 1) {
               class116.field1817[3].method4191(var38 + 15, 4);
            } else {
               class116.field1817[1].method4191(var38 + 15, 4);
            }

            var0.method3974("Location", 32 + var38, 17, 16777215, -1);
            var7 = 610 + class41.field817;
            if(World.field677[0] == 3 && World.field678[0] == 0) {
               class116.field1817[2].method4191(var7, 4);
            } else {
               class116.field1817[0].method4191(var7, 4);
            }

            if(World.field677[0] == 3 && World.field678[0] == 1) {
               class116.field1817[3].method4191(var7 + 15, 4);
            } else {
               class116.field1817[1].method4191(15 + var7, 4);
            }

            var0.method3974("Type", 32 + var7, 17, 16777215, -1);
         }

         Rasterizer2D.method4099(708 + class41.field817, 4, 50, 16, 0);
         var1.method4006("Cancel", 25 + class41.field817 + 708, 16, 16777215, -1);
         class41.field849 = -1;
         if(class25.field575 != null) {
            var4 = 88;
            byte var40 = 19;
            var38 = 765 / (var4 + 1);
            var7 = 480 / (1 + var40);

            int var39;
            do {
               var39 = var7;
               var9 = var38;
               if((var38 - 1) * var7 >= World.field676) {
                  --var38;
               }

               if(var38 * (var7 - 1) >= World.field676) {
                  --var7;
               }

               if(var38 * (var7 - 1) >= World.field676) {
                  --var7;
               }
            } while(var7 != var39 || var38 != var9);

            var39 = (765 - var4 * var38) / (var38 + 1);
            if(var39 > 5) {
               var39 = 5;
            }

            var9 = (480 - var7 * var40) / (1 + var7);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var4 * var38 - (var38 - 1) * var39) / 2;
            var11 = (480 - var7 * var40 - var9 * (var7 - 1)) / 2;
            var41 = var11 + 23;
            int var42 = var10 + class41.field817;
            int var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.field676; ++var16) {
               World var17 = World.worldList[var16];
               boolean var18 = true;
               String var19 = Integer.toString(var17.playerCount);
               if(var17.playerCount == -1) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var17.playerCount > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var21 = 0;
               byte var20;
               if(var17.method654()) {
                  if(var17.method664()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method653()) {
                  var21 = 16711680;
                  if(var17.method664()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method648()) {
                  if(var17.method664()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method664()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class115.field1802 >= var42 && class115.field1801 >= var41 && class115.field1802 < var42 + var4 && class115.field1801 < var41 + var40 && var18) {
                  class41.field849 = var16;
                  class25.field575[var20].method4258(var42, var41, 128, 16777215);
                  var15 = true;
               } else {
                  class25.field575[var20].method4252(var42, var41);
               }

               if(class16.field172 != null) {
                  class16.field172[(var17.method664()?8:0) + var17.location].method4191(var42 + 29, var41);
               }

               var0.method4006(Integer.toString(var17.id), 15 + var42, 5 + var40 / 2 + var41, var21, -1);
               var1.method4006(var19, 60 + var42, var41 + var40 / 2 + 5, 268435455, -1);
               var41 += var9 + var40;
               ++var14;
               if(var14 >= var7) {
                  var41 = 23 + var11;
                  var42 += var39 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method3969(World.worldList[class41.field849].activity) + 6;
               int var22 = 8 + var1.field3104;
               Rasterizer2D.method4099(class115.field1802 - var16 / 2, 5 + 20 + class115.field1801, var16, var22, 16777120);
               Rasterizer2D.method4104(class115.field1802 - var16 / 2, 5 + 20 + class115.field1801, var16, var22, 0);
               var1.method4006(World.worldList[class41.field849].activity, class115.field1802, 4 + 5 + class115.field1801 + 20 + var1.field3104, 0, -1);
            }
         }

         try {
            var23 = class0.canvas.getGraphics();
            class22.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var31) {
            class0.canvas.repaint();
         }

      } else {
         if(var3) {
            class41.field820.method4252(class41.field817, 0);
            class41.field846.method4252(382 + class41.field817, 0);
            XGrandExchangeOffer.field43.method4191(class41.field817 + 382 - XGrandExchangeOffer.field43.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4006("RuneScape is loading - please wait...", class41.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method4104(180 + class41.loginWindowX - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method4104(class41.loginWindowX + 180 - 151, 1 + var5, 302, 32, 0);
            Rasterizer2D.method4099(180 + class41.loginWindowX - 150, var5 + 2, class41.field829 * 3, 30, 9179409);
            Rasterizer2D.method4099(180 + class41.loginWindowX - 150 + class41.field829 * 3, var5 + 2, 300 - class41.field829 * 3, 30, 0);
            var0.method4006(class41.field834, 180 + class41.loginWindowX, 276 - var4, 16777215, -1);
         }

         String var24;
         String var26;
         String var27;
         String var28;
         short var33;
         short var35;
         if(Client.gameState == 20) {
            class41.field818.method4191(180 + class41.loginWindowX - class41.field818.originalWidth / 2, 271 - class41.field818.height / 2);
            var33 = 211;
            var0.method4006(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16776960, 0);
            var34 = var33 + 15;
            var0.method4006(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16776960, 0);
            var34 += 15;
            var0.method4006(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16776960, 0);
            var34 += 15;
            var34 += 10;
            if(class41.loginIndex != 4) {
               var0.method3974("Login: ", 180 + class41.loginWindowX - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class41.username; var0.method3969(var24) > var35; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method3974(FontTypeFace.method3973(var24), 180 + class41.loginWindowX - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               var27 = class41.field841;
               var28 = class145.method2781('*', var27.length());
               var0.method3974(var26 + var28, 180 + class41.loginWindowX - 108, var34, 16777215, 0);
               var34 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field818.method4191(class41.loginWindowX, 171);
            short var6;
            if(class41.loginIndex == 0) {
               var33 = 251;
               var0.method4006("Welcome to RuneScape", class41.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var6 = 291;
               class41.field816.method4191(var5 - 73, var6 - 20);
               var0.method4042("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class41.field816.method4191(var5 - 73, var6 - 20);
               var0.method4042("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method4006(class41.field830, class41.loginWindowX + 180, 211, 16776960, 0);
               var33 = 236;
               var0.method4006(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method4006(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var0.method4006(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var5 = 180 + class41.loginWindowX - 80;
               var6 = 321;
               class41.field816.method4191(var5 - 73, var6 - 20);
               var0.method4006("Continue", var5, var6 + 5, 16777215, 0);
               var5 = 80 + 180 + class41.loginWindowX;
               class41.field816.method4191(var5 - 73, var6 - 20);
               var0.method4006("Cancel", var5, 5 + var6, 16777215, 0);
            } else if(class41.loginIndex == 2) {
               var33 = 211;
               var0.method4006(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method4006(class41.loginMessage2, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var0.method4006(class41.loginMessage3, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var34 += 10;
               var0.method3974("Login: ", 180 + class41.loginWindowX - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class41.username; var0.method3969(var24) > var35; var24 = var24.substring(1)) {
                  ;
               }

               var0.method3974(FontTypeFace.method3973(var24) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class187.method3515(16776960) + "|":""), 180 + class41.loginWindowX - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               var27 = class41.field841;
               var28 = class145.method2781('*', var27.length());
               var0.method3974(var26 + var28 + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class187.method3515(16776960) + "|":""), 180 + class41.loginWindowX - 108, var34, 16777215, 0);
               var34 += 15;
               var11 = class41.loginWindowX + 180 - 80;
               short var12 = 321;
               class41.field816.method4191(var11 - 73, var12 - 20);
               var0.method4006("Login", var11, 5 + var12, 16777215, 0);
               var11 = 80 + 180 + class41.loginWindowX;
               class41.field816.method4191(var11 - 73, var12 - 20);
               var0.method4006("Cancel", var11, var12 + 5, 16777215, 0);
               var33 = 357;
               var1.method4006("Forgotten your password? <col=ffffff>Click here.", 180 + class41.loginWindowX, var33, 16776960, 0);
            } else if(class41.loginIndex == 3) {
               var33 = 201;
               var0.method4006("Invalid username or password.", 180 + class41.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 20;
               var1.method4006("For accounts created after 24th November 2010, please use your", 180 + class41.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var1.method4006("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var5 = class41.loginWindowX + 180;
               var6 = 276;
               class41.field816.method4191(var5 - 73, var6 - 20);
               var2.method4006("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class41.loginWindowX + 180;
               var6 = 326;
               class41.field816.method4191(var5 - 73, var6 - 20);
               var2.method4006("Forgotten password?", var5, 5 + var6, 16777215, 0);
            } else if(class41.loginIndex == 4) {
               var0.method4006("Authenticator", 180 + class41.loginWindowX, 211, 16776960, 0);
               var33 = 236;
               var0.method4006(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method4006(class41.loginMessage2, class41.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               var0.method4006(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var24 = "PIN: ";
               var26 = class154.authCode;
               String var25 = class145.method2781('*', var26.length());
               var0.method3974(var24 + var25 + (Client.gameCycle % 40 < 20?class187.method3515(16776960) + "|":""), 180 + class41.loginWindowX - 108, var34, 16777215, 0);
               var34 -= 8;
               var0.method3974("Trust this computer", 180 + class41.loginWindowX - 9, var34, 16776960, 0);
               var34 += 15;
               var0.method3974("for 30 days: ", class41.loginWindowX + 180 - 9, var34, 16776960, 0);
               var9 = 180 + class41.loginWindowX - 9 + var0.method3969("for 30 days: ") + 15;
               var10 = var34 - var0.field3104;
               ModIcon var30;
               if(class41.field844) {
                  var30 = class41.field837;
               } else {
                  var30 = class41.field822;
               }

               var30.method4191(var9, var10);
               var34 += 15;
               var41 = class41.loginWindowX + 180 - 80;
               short var13 = 321;
               class41.field816.method4191(var41 - 73, var13 - 20);
               var0.method4006("Continue", var41, var13 + 5, 16777215, 0);
               var41 = 80 + 180 + class41.loginWindowX;
               class41.field816.method4191(var41 - 73, var13 - 20);
               var0.method4006("Cancel", var41, 5 + var13, 16777215, 0);
               var1.method4006("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, var13 + 36, 255, 0);
            } else if(class41.loginIndex == 5) {
               var0.method4006("Forgotten your password?", 180 + class41.loginWindowX, 201, 16776960, 0);
               var33 = 221;
               var2.method4006(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 15;
               var2.method4006(class41.loginMessage2, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var2.method4006(class41.loginMessage3, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var34 += 14;
               var0.method3974("Username/email: ", class41.loginWindowX + 180 - 145, var34, 16777215, 0);
               var35 = 174;

               for(var24 = class41.username; var0.method3969(var24) > var35; var24 = var24.substring(1)) {
                  ;
               }

               var0.method3974(FontTypeFace.method3973(var24) + (Client.gameCycle % 40 < 20?class187.method3515(16776960) + "|":""), class41.loginWindowX + 180 - 34, var34, 16777215, 0);
               var34 += 15;
               var7 = 180 + class41.loginWindowX - 80;
               short var8 = 321;
               class41.field816.method4191(var7 - 73, var8 - 20);
               var0.method4006("Recover", var7, 5 + var8, 16777215, 0);
               var7 = 80 + 180 + class41.loginWindowX;
               class41.field816.method4191(var7 - 73, var8 - 20);
               var0.method4006("Back", var7, var8 + 5, 16777215, 0);
            } else if(class41.loginIndex == 6) {
               var33 = 211;
               var0.method4006(class41.loginMessage1, class41.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method4006(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var0.method4006(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var5 = class41.loginWindowX + 180;
               var6 = 321;
               class41.field816.method4191(var5 - 73, var6 - 20);
               var0.method4006("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class41.field823 > 0) {
            NPCComposition.method3831(class41.field823);
            class41.field823 = 0;
         }

         WidgetNode.method201();
         class7.field64[WallObject.field1551.field692?1:0].method4191(class41.field817 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field289 == 0) {
            if(null != class38.field795) {
               var34 = class41.field817 + 5;
               var35 = 463;
               byte var36 = 100;
               byte var37 = 35;
               class38.field795.method4191(var34, var35);
               var0.method4006("World" + " " + Client.world, var34 + var36 / 2, var37 / 2 + var35 - 2, 16777215, 0);
               if(null != class60.worldServersDownload) {
                  var1.method4006("Loading...", var36 / 2 + var34, var35 + var37 / 2 + 12, 16777215, 0);
               } else {
                  var1.method4006("Click to switch", var34 + var36 / 2, 12 + var35 + var37 / 2, 16777215, 0);
               }
            } else {
               class38.field795 = class41.method854(class114.field1790, "sl_button", "");
            }
         }

         try {
            var23 = class0.canvas.getGraphics();
            class22.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var32) {
            class0.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "1826229238"
   )
   static final void method207(class159 var0) {
      var0.method3141();
      int var1 = Client.localInteractingIndex;
      Player var2 = class9.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field261 = var1;
      int var3 = var0.method3119(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - MessageNode.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method246() << 6);
      var2.pathY[0] = var6 - class2.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method246() << 6);
      class156.plane = var2.field260 = var4;
      if(class45.field899[var1] != null) {
         var2.method227(class45.field899[var1]);
      }

      class45.field907 = 0;
      class45.field900[++class45.field907 - 1] = var1;
      class45.field898[var1] = 0;
      class45.field901 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3119(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class45.field903[var7] = var11 + (var10 << 14) + (var9 << 28);
            class45.field904[var7] = 0;
            class45.field905[var7] = -1;
            class45.field902[++class45.field901 - 1] = var7;
            class45.field898[var7] = 0;
         }
      }

      var0.method3125();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-19"
   )
   static int method208(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class32.field729[--class101.field1648];
         var4 = class140.method2681(var3);
      } else {
         var4 = var2?class32.field719:class185.field2760;
      }

      if(var0 == 1000) {
         class101.field1648 -= 4;
         var4.originalX = class32.field729[class101.field1648];
         var4.originalY = class32.field729[1 + class101.field1648];
         var4.field2201 = class32.field729[class101.field1648 + 2];
         var4.field2202 = class32.field729[class101.field1648 + 3];
         Frames.method1960(var4);
         class39.method815(var4);
         if(var3 != -1 && var4.type == 0) {
            CombatInfo1.method646(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class101.field1648 -= 4;
         var4.originalWidth = class32.field729[class101.field1648];
         var4.field2208 = class32.field729[class101.field1648 + 1];
         var4.field2203 = class32.field729[2 + class101.field1648];
         var4.field2204 = class32.field729[3 + class101.field1648];
         Frames.method1960(var4);
         class39.method815(var4);
         if(var3 != -1 && var4.type == 0) {
            CombatInfo1.method646(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class32.field729[--class101.field1648] == 1;
         if(var4.isHidden != var5) {
            var4.isHidden = var5;
            Frames.method1960(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2280 = class32.field729[--class101.field1648] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2210 = class32.field729[--class101.field1648] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LFloorUnderlayDefinition;",
      garbageValue = "1716121058"
   )
   public static FloorUnderlayDefinition method209(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2812.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.field2815.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.method3559(new Buffer(var2), var0);
         }

         var1.method3551();
         FloorUnderlayDefinition.field2812.put(var1, (long)var0);
         return var1;
      }
   }
}
