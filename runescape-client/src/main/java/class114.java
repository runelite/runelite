import java.applet.Applet;
import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class114 {
   @ObfuscatedName("j")
   static String field1794 = null;
   @ObfuscatedName("x")
   static Applet field1798 = null;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZI)V",
      garbageValue = "258662119"
   )
   static void method2245(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class41.field846 = (class108.field1748 - Client.field528) / 2;
         class41.loginWindowX = 202 + class41.field846;
      }

      byte var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var11;
      Graphics var23;
      int var34;
      int var36;
      int var38;
      int var41;
      int var42;
      if(class41.worldSelectShown) {
         if(null == class8.field79) {
            class8.field79 = class142.method2715(class0.field2, "sl_back", "");
         }

         if(null == class118.field1857) {
            class118.field1857 = class0.method15(class0.field2, "sl_flags", "");
         }

         if(null == class99.field1660) {
            class99.field1660 = class0.method15(class0.field2, "sl_arrows", "");
         }

         if(null == class33.field771) {
            class33.field771 = class0.method15(class0.field2, "sl_stars", "");
         }

         Rasterizer2D.method4028(class41.field846, 23, 765, 480, 0);
         Rasterizer2D.method4009(class41.field846, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method4009(class41.field846 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method3964("Select a world", 62 + class41.field846, 15, 0, -1);
         if(null != class33.field771) {
            class33.field771[1].method4090(class41.field846 + 140, 1);
            var1.method3881("Members only world", class41.field846 + 152, 10, 16777215, -1);
            class33.field771[0].method4090(140 + class41.field846, 12);
            var1.method3881("Free world", 152 + class41.field846, 21, 16777215, -1);
         }

         if(class99.field1660 != null) {
            var34 = 280 + class41.field846;
            if(World.field694[0] == 0 && World.field708[0] == 0) {
               class99.field1660[2].method4090(var34, 4);
            } else {
               class99.field1660[0].method4090(var34, 4);
            }

            if(World.field694[0] == 0 && World.field708[0] == 1) {
               class99.field1660[3].method4090(15 + var34, 4);
            } else {
               class99.field1660[1].method4090(var34 + 15, 4);
            }

            var0.method3881("World", 32 + var34, 17, 16777215, -1);
            var5 = 390 + class41.field846;
            if(World.field694[0] == 1 && World.field708[0] == 0) {
               class99.field1660[2].method4090(var5, 4);
            } else {
               class99.field1660[0].method4090(var5, 4);
            }

            if(World.field694[0] == 1 && World.field708[0] == 1) {
               class99.field1660[3].method4090(var5 + 15, 4);
            } else {
               class99.field1660[1].method4090(var5 + 15, 4);
            }

            var0.method3881("Players", var5 + 32, 17, 16777215, -1);
            var36 = class41.field846 + 500;
            if(World.field694[0] == 2 && World.field708[0] == 0) {
               class99.field1660[2].method4090(var36, 4);
            } else {
               class99.field1660[0].method4090(var36, 4);
            }

            if(World.field694[0] == 2 && World.field708[0] == 1) {
               class99.field1660[3].method4090(var36 + 15, 4);
            } else {
               class99.field1660[1].method4090(var36 + 15, 4);
            }

            var0.method3881("Location", var36 + 32, 17, 16777215, -1);
            var7 = class41.field846 + 610;
            if(World.field694[0] == 3 && World.field708[0] == 0) {
               class99.field1660[2].method4090(var7, 4);
            } else {
               class99.field1660[0].method4090(var7, 4);
            }

            if(World.field694[0] == 3 && World.field708[0] == 1) {
               class99.field1660[3].method4090(15 + var7, 4);
            } else {
               class99.field1660[1].method4090(15 + var7, 4);
            }

            var0.method3881("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4028(class41.field846 + 708, 4, 50, 16, 0);
         var1.method3964("Cancel", 25 + class41.field846 + 708, 16, 16777215, -1);
         class41.field848 = -1;
         if(class8.field79 != null) {
            var4 = 88;
            byte var40 = 19;
            var36 = 765 / (1 + var4);
            var7 = 480 / (1 + var40);

            do {
               var38 = var7;
               var9 = var36;
               if((var36 - 1) * var7 >= World.field697) {
                  --var36;
               }

               if((var7 - 1) * var36 >= World.field697) {
                  --var7;
               }

               if(var36 * (var7 - 1) >= World.field697) {
                  --var7;
               }
            } while(var38 != var7 || var36 != var9);

            var38 = (765 - var4 * var36) / (1 + var36);
            if(var38 > 5) {
               var38 = 5;
            }

            var9 = (480 - var40 * var7) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var4 * var36 - (var36 - 1) * var38) / 2;
            var11 = (480 - var40 * var7 - var9 * (var7 - 1)) / 2;
            var41 = 23 + var11;
            var42 = class41.field846 + var10;
            int var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.field697; ++var16) {
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
               if(var17.method631()) {
                  if(var17.method673()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method663()) {
                  var21 = 16711680;
                  if(var17.method673()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method632()) {
                  if(var17.method673()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method673()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class115.field1807 >= var42 && class115.field1801 >= var41 && class115.field1807 < var4 + var42 && class115.field1801 < var40 + var41 && var18) {
                  class41.field848 = var16;
                  class8.field79[var20].method4153(var42, var41, 128, 16777215);
                  var15 = true;
               } else {
                  class8.field79[var20].method4147(var42, var41);
               }

               if(null != class118.field1857) {
                  class118.field1857[(var17.method673()?8:0) + var17.location].method4090(var42 + 29, var41);
               }

               var0.method3964(Integer.toString(var17.id), 15 + var42, 5 + var40 / 2 + var41, var21, -1);
               var1.method3964(var19, 60 + var42, 5 + var40 / 2 + var41, 268435455, -1);
               var41 += var40 + var9;
               ++var14;
               if(var14 >= var7) {
                  var41 = var11 + 23;
                  var42 += var4 + var38;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method3876(World.worldList[class41.field848].activity) + 6;
               int var22 = 8 + var1.field3120;
               Rasterizer2D.method4028(class115.field1807 - var16 / 2, 20 + class115.field1801 + 5, var16, var22, 16777120);
               Rasterizer2D.method4010(class115.field1807 - var16 / 2, 5 + class115.field1801 + 20, var16, var22, 0);
               var1.method3964(World.worldList[class41.field848].activity, class115.field1807, 4 + 5 + class115.field1801 + 20 + var1.field3120, 0, -1);
            }
         }

         try {
            var23 = CollisionData.canvas.getGraphics();
            Frames.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var31) {
            CollisionData.canvas.repaint();
         }

      } else {
         if(var3) {
            class41.field880.method4147(class41.field846, 0);
            class41.field850.method4147(382 + class41.field846, 0);
            class186.field2763.method4090(class41.field846 + 382 - class186.field2763.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method3964("RuneScape is loading - please wait...", class41.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method4010(class41.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method4010(class41.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4028(180 + class41.loginWindowX - 150, var5 + 2, class41.field872 * 3, 30, 9179409);
            Rasterizer2D.method4028(180 + class41.loginWindowX - 150 + class41.field872 * 3, 2 + var5, 300 - class41.field872 * 3, 30, 0);
            var0.method3964(class41.field866, class41.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var24;
         String var26;
         String var27;
         String var28;
         short var33;
         short var35;
         if(Client.gameState == 20) {
            class41.field882.method4090(class41.loginWindowX + 180 - class41.field882.originalWidth / 2, 271 - class41.field882.height / 2);
            var33 = 211;
            var0.method3964(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16776960, 0);
            var34 = var33 + 15;
            var0.method3964(class41.loginMessage2, class41.loginWindowX + 180, var34, 16776960, 0);
            var34 += 15;
            var0.method3964(class41.loginMessage3, class41.loginWindowX + 180, var34, 16776960, 0);
            var34 += 15;
            var34 += 10;
            if(class41.loginIndex != 4) {
               var0.method3881("Login: ", class41.loginWindowX + 180 - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class41.username; var0.method3876(var24) > var35; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method3881(FontTypeFace.method3880(var24), class41.loginWindowX + 180 - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               var27 = class41.field873;
               var28 = ScriptState.method172('*', var27.length());
               var0.method3881(var26 + var28, class41.loginWindowX + 180 - 108, var34, 16777215, 0);
               var34 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field882.method4090(class41.loginWindowX, 171);
            short var6;
            if(class41.loginIndex == 0) {
               var33 = 251;
               var0.method3964("Welcome to RuneScape", 180 + class41.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var6 = 291;
               class41.field847.method4090(var5 - 73, var6 - 20);
               var0.method3916("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 180 + class41.loginWindowX + 80;
               class41.field847.method4090(var5 - 73, var6 - 20);
               var0.method3916("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3964(class41.field870, class41.loginWindowX + 180, 211, 16776960, 0);
               var33 = 236;
               var0.method3964(class41.loginMessage1, class41.loginWindowX + 180, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method3964(class41.loginMessage2, class41.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               var0.method3964(class41.loginMessage3, class41.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var6 = 321;
               class41.field847.method4090(var5 - 73, var6 - 20);
               var0.method3964("Continue", var5, 5 + var6, 16777215, 0);
               var5 = 80 + class41.loginWindowX + 180;
               class41.field847.method4090(var5 - 73, var6 - 20);
               var0.method3964("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class41.loginIndex == 2) {
               var33 = 211;
               var0.method3964(class41.loginMessage1, class41.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method3964(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var0.method3964(class41.loginMessage3, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var34 += 10;
               var0.method3881("Login: ", 180 + class41.loginWindowX - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class41.username; var0.method3876(var24) > var35; var24 = var24.substring(1)) {
                  ;
               }

               var0.method3881(FontTypeFace.method3880(var24) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class116.method2288(16776960) + "|":""), 180 + class41.loginWindowX - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               var27 = class41.field873;
               var28 = ScriptState.method172('*', var27.length());
               var0.method3881(var26 + var28 + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class116.method2288(16776960) + "|":""), class41.loginWindowX + 180 - 108, var34, 16777215, 0);
               var34 += 15;
               var11 = class41.loginWindowX + 180 - 80;
               short var12 = 321;
               class41.field847.method4090(var11 - 73, var12 - 20);
               var0.method3964("Login", var11, 5 + var12, 16777215, 0);
               var11 = 80 + 180 + class41.loginWindowX;
               class41.field847.method4090(var11 - 73, var12 - 20);
               var0.method3964("Cancel", var11, 5 + var12, 16777215, 0);
               var33 = 357;
               var1.method3964("Forgotten your password? <col=ffffff>Click here.", 180 + class41.loginWindowX, var33, 16776960, 0);
            } else if(class41.loginIndex == 3) {
               var33 = 201;
               var0.method3964("Invalid username or password.", class41.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 20;
               var1.method3964("For accounts created after 24th November 2010, please use your", class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var1.method3964("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var5 = class41.loginWindowX + 180;
               var6 = 276;
               class41.field847.method4090(var5 - 73, var6 - 20);
               var2.method3964("Try again", var5, 5 + var6, 16777215, 0);
               var5 = 180 + class41.loginWindowX;
               var6 = 326;
               class41.field847.method4090(var5 - 73, var6 - 20);
               var2.method3964("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class41.loginIndex == 4) {
               var0.method3964("Authenticator", class41.loginWindowX + 180, 211, 16776960, 0);
               var33 = 236;
               var0.method3964(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method3964(class41.loginMessage2, class41.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               var0.method3964(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var24 = "PIN: ";
               var26 = class146.authCode;
               String var25 = ScriptState.method172('*', var26.length());
               var0.method3881(var24 + var25 + (Client.gameCycle % 40 < 20?class116.method2288(16776960) + "|":""), class41.loginWindowX + 180 - 108, var34, 16777215, 0);
               var34 -= 8;
               var0.method3881("Trust this computer", 180 + class41.loginWindowX - 9, var34, 16776960, 0);
               var34 += 15;
               var0.method3881("for 30 days: ", 180 + class41.loginWindowX - 9, var34, 16776960, 0);
               var9 = class41.loginWindowX + 180 - 9 + var0.method3876("for 30 days: ") + 15;
               var10 = var34 - var0.field3120;
               ModIcon var30;
               if(class41.field875) {
                  var30 = class41.field852;
               } else {
                  var30 = class41.field851;
               }

               var30.method4090(var9, var10);
               var34 += 15;
               var41 = 180 + class41.loginWindowX - 80;
               short var13 = 321;
               class41.field847.method4090(var41 - 73, var13 - 20);
               var0.method3964("Continue", var41, var13 + 5, 16777215, 0);
               var41 = class41.loginWindowX + 180 + 80;
               class41.field847.method4090(var41 - 73, var13 - 20);
               var0.method3964("Cancel", var41, 5 + var13, 16777215, 0);
               var1.method3964("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, 36 + var13, 255, 0);
            } else if(class41.loginIndex == 5) {
               var0.method3964("Forgotten your password?", 180 + class41.loginWindowX, 201, 16776960, 0);
               var33 = 221;
               var2.method3964(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 15;
               var2.method3964(class41.loginMessage2, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var2.method3964(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var34 += 14;
               var0.method3881("Username/email: ", 180 + class41.loginWindowX - 145, var34, 16777215, 0);
               var35 = 174;

               for(var24 = class41.username; var0.method3876(var24) > var35; var24 = var24.substring(1)) {
                  ;
               }

               var0.method3881(FontTypeFace.method3880(var24) + (Client.gameCycle % 40 < 20?class116.method2288(16776960) + "|":""), 180 + class41.loginWindowX - 34, var34, 16777215, 0);
               var34 += 15;
               var7 = class41.loginWindowX + 180 - 80;
               short var8 = 321;
               class41.field847.method4090(var7 - 73, var8 - 20);
               var0.method3964("Recover", var7, var8 + 5, 16777215, 0);
               var7 = class41.loginWindowX + 180 + 80;
               class41.field847.method4090(var7 - 73, var8 - 20);
               var0.method3964("Back", var7, 5 + var8, 16777215, 0);
            } else if(class41.loginIndex == 6) {
               var33 = 211;
               var0.method3964(class41.loginMessage1, class41.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method3964(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var0.method3964(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var5 = class41.loginWindowX + 180;
               var6 = 321;
               class41.field847.method4090(var5 - 73, var6 - 20);
               var0.method3964("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class41.field863 > 0) {
            var34 = class41.field863;
            var35 = 256;
            class41.field861 += 128 * var34;
            if(class41.field861 > class36.field807.length) {
               class41.field861 -= class36.field807.length;
               var36 = (int)(Math.random() * 12.0D);
               class30.method688(class205.field3095[var36]);
            }

            var36 = 0;
            var7 = var34 * 128;
            var38 = 128 * (var35 - var34);

            for(var9 = 0; var9 < var38; ++var9) {
               var10 = XGrandExchangeOffer.field48[var36 + var7] - var34 * class36.field807[class41.field861 + var36 & class36.field807.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               XGrandExchangeOffer.field48[var36++] = var10;
            }

            for(var9 = var35 - var34; var9 < var35; ++var9) {
               var10 = 128 * var9;

               for(var11 = 0; var11 < 128; ++var11) {
                  var41 = (int)(Math.random() * 100.0D);
                  if(var41 < 50 && var11 > 10 && var11 < 118) {
                     XGrandExchangeOffer.field48[var11 + var10] = 255;
                  } else {
                     XGrandExchangeOffer.field48[var10 + var11] = 0;
                  }
               }
            }

            if(class41.field858 > 0) {
               class41.field858 -= 4 * var34;
            }

            if(class41.field845 > 0) {
               class41.field845 -= 4 * var34;
            }

            if(class41.field858 == 0 && class41.field845 == 0) {
               var9 = (int)(Math.random() * (double)(2000 / var34));
               if(var9 == 0) {
                  class41.field858 = 1024;
               }

               if(var9 == 1) {
                  class41.field845 = 1024;
               }
            }

            for(var9 = 0; var9 < var35 - var34; ++var9) {
               class41.field859[var9] = class41.field859[var34 + var9];
            }

            for(var9 = var35 - var34; var9 < var35; ++var9) {
               class41.field859[var9] = (int)(Math.sin((double)class41.field862 / 14.0D) * 16.0D + Math.sin((double)class41.field862 / 15.0D) * 14.0D + Math.sin((double)class41.field862 / 16.0D) * 12.0D);
               ++class41.field862;
            }

            class41.field879 += var34;
            var9 = (var34 + (Client.gameCycle & 1)) / 2;
            if(var9 > 0) {
               for(var10 = 0; var10 < class41.field879 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var41 = (int)(Math.random() * 128.0D) + 128;
                  XGrandExchangeOffer.field48[var11 + (var41 << 7)] = 192;
               }

               class41.field879 = 0;
               var10 = 0;

               label520:
               while(true) {
                  if(var10 >= var35) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label520;
                        }

                        var11 = 0;

                        for(var41 = -var9; var41 < var35; ++var41) {
                           var42 = 128 * var41;
                           if(var9 + var41 < var35) {
                              var11 += class161.field2130[var10 + var42 + 128 * var9];
                           }

                           if(var41 - (1 + var9) >= 0) {
                              var11 -= class161.field2130[var42 + var10 - (var9 + 1) * 128];
                           }

                           if(var41 >= 0) {
                              XGrandExchangeOffer.field48[var10 + var42] = var11 / (2 * var9 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var41 = var10 * 128;

                  for(var42 = -var9; var42 < 128; ++var42) {
                     if(var42 + var9 < 128) {
                        var11 += XGrandExchangeOffer.field48[var42 + var41 + var9];
                     }

                     if(var42 - (var9 + 1) >= 0) {
                        var11 -= XGrandExchangeOffer.field48[var42 + var41 - (1 + var9)];
                     }

                     if(var42 >= 0) {
                        class161.field2130[var41 + var42] = var11 / (1 + 2 * var9);
                     }
                  }

                  ++var10;
               }
            }

            class41.field863 = 0;
         }

         class171.method3265();
         GroundObject.field1310[class8.field84.field712?1:0].method4090(class41.field846 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field409 == 0) {
            if(Client.field595 != null) {
               var34 = 5 + class41.field846;
               var35 = 463;
               byte var39 = 100;
               byte var37 = 35;
               Client.field595.method4090(var34, var35);
               var0.method3964("World" + " " + Client.world, var34 + var39 / 2, var37 / 2 + var35 - 2, 16777215, 0);
               if(World.worldServersDownload != null) {
                  var1.method3964("Loading...", var34 + var39 / 2, var37 / 2 + var35 + 12, 16777215, 0);
               } else {
                  var1.method3964("Click to switch", var34 + var39 / 2, var35 + var37 / 2 + 12, 16777215, 0);
               }
            } else {
               Client.field595 = class26.method600(class0.field2, "sl_button", "");
            }
         }

         try {
            var23 = CollisionData.canvas.getGraphics();
            Frames.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var32) {
            CollisionData.canvas.repaint();
         }

      }
   }

   class114() throws Throwable {
      throw new Error();
   }
}
