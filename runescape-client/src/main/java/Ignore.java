import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("h")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("i")
   @Export("name")
   String name;

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1189933123"
   )
   static final void method1118() {
      if(WidgetNode.field812 != null) {
         WidgetNode.field812.method2046();
      }

      if(class48.field611 != null) {
         class48.field611.method2046();
      }

   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-65"
   )
   static final int method1119(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class61.tileHeights[var5][var3 + 1][var4] + class61.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = (128 - var6) * class61.tileHeights[var5][var3][var4 + 1] + var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1930665505"
   )
   static final void method1120(Widget var0, int var1, int var2) {
      if(Client.field961 == null && !Client.isMenuOpen) {
         if(var0 != null && Buffer.method3411(var0) != null) {
            Client.field961 = var0;
            Client.field1084 = Buffer.method3411(var0);
            Client.field1065 = var1;
            Client.field1039 = var2;
            FaceNormal.field2120 = 0;
            Client.field1008 = false;
            int var3 = class84.method1694();
            if(var3 != -1) {
               class7.field235 = new class89();
               class7.field235.field1381 = Client.menuActionParams0[var3];
               class7.field235.field1394 = Client.menuActionParams1[var3];
               class7.field235.field1382 = Client.menuTypes[var3];
               class7.field235.field1391 = Client.menuIdentifiers[var3];
               class7.field235.field1384 = Client.menuOptions[var3];
            }

         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZI)V",
      garbageValue = "650492539"
   )
   static void method1121(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class92.field1416 = (class261.field3626 - 765) / 2;
         class92.loginWindowX = class92.field1416 + 202;
      }

      if(class92.worldSelectShown) {
         class90.method1747(var0, var1);
      } else {
         if(var3) {
            class92.field1429.method5130(class92.field1416, 0);
            class269.field3672.method5130(class92.field1416 + 382, 0);
            class268.field3670.method5101(class92.field1416 + 382 - class268.field3670.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4817("RuneScape is loading - please wait...", class92.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method5012(class92.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method5012(class92.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method5042(class92.loginWindowX + 180 - 150, var5 + 2, class92.field1430 * 3, 30, 9179409);
            Rasterizer2D.method5042(class92.loginWindowX + 180 - 150 + class92.field1430 * 3, var5 + 2, 300 - class92.field1430 * 3, 30, 0);
            var0.method4817(class92.field1431, class92.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var14;
         short var16;
         int var17;
         short var18;
         if(Client.gameState == 20) {
            class92.field1417.method5101(class92.loginWindowX + 180 - class92.field1417.originalWidth / 2, 271 - class92.field1417.height / 2);
            var16 = 211;
            var0.method4817(class92.loginMessage1, class92.loginWindowX + 180, var16, 16776960, 0);
            var17 = var16 + 15;
            var0.method4817(class92.loginMessage2, class92.loginWindowX + 180, var17, 16776960, 0);
            var17 += 15;
            var0.method4817(class92.loginMessage3, class92.loginWindowX + 180, var17, 16776960, 0);
            var17 += 15;
            var17 += 10;
            if(class92.loginIndex != 4) {
               var0.method4889("Login: ", class92.loginWindowX + 180 - 110, var17, 16777215, 0);
               var18 = 200;

               for(var14 = class92.username; var0.method4809(var14) > var18; var14 = var14.substring(0, var14.length() - 1)) {
                  ;
               }

               var0.method4889(FontTypeFace.method4813(var14), class92.loginWindowX + 180 - 70, var17, 16777215, 0);
               var17 += 15;
               var0.method4889("Password: " + class134.method2619(class92.password), class92.loginWindowX + 180 - 108, var17, 16777215, 0);
               var17 += 15;
            }
         }

         int var7;
         int var19;
         int var20;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class92.field1417.method5101(class92.loginWindowX, 171);
            short var6;
            if(class92.loginIndex == 0) {
               var16 = 251;
               var0.method4817("Welcome to RuneScape", class92.loginWindowX + 180, var16, 16776960, 0);
               var17 = var16 + 30;
               var5 = class92.loginWindowX + 180 - 80;
               var6 = 291;
               class92.field1425.method5101(var5 - 73, var6 - 20);
               var0.method4818("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1425.method5101(var5 - 73, var6 - 20);
               var0.method4818("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class92.loginIndex == 1) {
               var0.method4817(class92.field1428, class92.loginWindowX + 180, 211, 16776960, 0);
               var16 = 236;
               var0.method4817(class92.loginMessage1, class92.loginWindowX + 180, var16, 16777215, 0);
               var17 = var16 + 15;
               var0.method4817(class92.loginMessage2, class92.loginWindowX + 180, var17, 16777215, 0);
               var17 += 15;
               var0.method4817(class92.loginMessage3, class92.loginWindowX + 180, var17, 16777215, 0);
               var17 += 15;
               var5 = class92.loginWindowX + 180 - 80;
               var6 = 321;
               class92.field1425.method5101(var5 - 73, var6 - 20);
               var0.method4817("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1425.method5101(var5 - 73, var6 - 20);
               var0.method4817("Cancel", var5, var6 + 5, 16777215, 0);
            } else {
               short var8;
               if(class92.loginIndex == 2) {
                  var16 = 211;
                  var0.method4817(class92.loginMessage1, class92.loginWindowX + 180, var16, 16776960, 0);
                  var17 = var16 + 15;
                  var0.method4817(class92.loginMessage2, class92.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var0.method4817(class92.loginMessage3, class92.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var17 += 10;
                  var0.method4889("Login: ", class92.loginWindowX + 180 - 110, var17, 16777215, 0);
                  var18 = 200;

                  for(var14 = class92.username; var0.method4809(var14) > var18; var14 = var14.substring(1)) {
                     ;
                  }

                  var0.method4889(FontTypeFace.method4813(var14) + (class92.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class82.method1610(16776960) + "|":""), class92.loginWindowX + 180 - 70, var17, 16777215, 0);
                  var17 += 15;
                  var0.method4889("Password: " + class134.method2619(class92.password) + (class92.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class82.method1610(16776960) + "|":""), class92.loginWindowX + 180 - 108, var17, 16777215, 0);
                  var17 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  class92.field1425.method5101(var7 - 73, var8 - 20);
                  var0.method4817("Login", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  class92.field1425.method5101(var7 - 73, var8 - 20);
                  var0.method4817("Cancel", var7, var8 + 5, 16777215, 0);
                  var16 = 357;
                  var1.method4817("Forgotten your password? <col=ffffff>Click here.", class92.loginWindowX + 180, var16, 16776960, 0);
               } else if(class92.loginIndex == 3) {
                  var16 = 201;
                  var0.method4817("Invalid username or password.", class92.loginWindowX + 180, var16, 16776960, 0);
                  var17 = var16 + 20;
                  var1.method4817("For accounts created after 24th November 2010, please use your", class92.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var1.method4817("email address to login. Otherwise please login with your username.", class92.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var5 = class92.loginWindowX + 180;
                  var6 = 276;
                  class92.field1425.method5101(var5 - 73, var6 - 20);
                  var2.method4817("Try again", var5, var6 + 5, 16777215, 0);
                  var5 = class92.loginWindowX + 180;
                  var6 = 326;
                  class92.field1425.method5101(var5 - 73, var6 - 20);
                  var2.method4817("Forgotten password?", var5, var6 + 5, 16777215, 0);
               } else if(class92.loginIndex == 4) {
                  var0.method4817("Authenticator", class92.loginWindowX + 180, 211, 16776960, 0);
                  var16 = 236;
                  var0.method4817(class92.loginMessage1, class92.loginWindowX + 180, var16, 16777215, 0);
                  var17 = var16 + 15;
                  var0.method4817(class92.loginMessage2, class92.loginWindowX + 180, var17, 16777215, 0);
                  var17 += 15;
                  var0.method4817(class92.loginMessage3, class92.loginWindowX + 180, var17, 16777215, 0);
                  var17 += 15;
                  var0.method4889("PIN: " + class134.method2619(ItemLayer.authCode) + (Client.gameCycle % 40 < 20?class82.method1610(16776960) + "|":""), class92.loginWindowX + 180 - 108, var17, 16777215, 0);
                  var17 -= 8;
                  var0.method4889("Trust this computer", class92.loginWindowX + 180 - 9, var17, 16776960, 0);
                  var17 += 15;
                  var0.method4889("for 30 days: ", class92.loginWindowX + 180 - 9, var17, 16776960, 0);
                  var5 = class92.loginWindowX + 180 - 9 + var0.method4809("for 30 days: ") + 15;
                  var19 = var17 - var0.field3638;
                  ModIcon var15;
                  if(class92.field1440) {
                     var15 = class56.field676;
                  } else {
                     var15 = class92.field1420;
                  }

                  var15.method5101(var5, var19);
                  var17 += 15;
                  var20 = class92.loginWindowX + 180 - 80;
                  short var9 = 321;
                  class92.field1425.method5101(var20 - 73, var9 - 20);
                  var0.method4817("Continue", var20, var9 + 5, 16777215, 0);
                  var20 = class92.loginWindowX + 180 + 80;
                  class92.field1425.method5101(var20 - 73, var9 - 20);
                  var0.method4817("Cancel", var20, var9 + 5, 16777215, 0);
                  var1.method4817("<u=ff>Can\'t Log In?</u>", class92.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class92.loginIndex == 5) {
                  var0.method4817("Forgotten your password?", class92.loginWindowX + 180, 201, 16776960, 0);
                  var16 = 221;
                  var2.method4817(class92.loginMessage1, class92.loginWindowX + 180, var16, 16776960, 0);
                  var17 = var16 + 15;
                  var2.method4817(class92.loginMessage2, class92.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var2.method4817(class92.loginMessage3, class92.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var17 += 14;
                  var0.method4889("Username/email: ", class92.loginWindowX + 180 - 145, var17, 16777215, 0);
                  var18 = 174;

                  for(var14 = class92.username; var0.method4809(var14) > var18; var14 = var14.substring(1)) {
                     ;
                  }

                  var0.method4889(FontTypeFace.method4813(var14) + (Client.gameCycle % 40 < 20?class82.method1610(16776960) + "|":""), class92.loginWindowX + 180 - 34, var17, 16777215, 0);
                  var17 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  class92.field1425.method5101(var7 - 73, var8 - 20);
                  var0.method4817("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  class92.field1425.method5101(var7 - 73, var8 - 20);
                  var0.method4817("Back", var7, var8 + 5, 16777215, 0);
               } else if(class92.loginIndex == 6) {
                  var16 = 211;
                  var0.method4817(class92.loginMessage1, class92.loginWindowX + 180, var16, 16776960, 0);
                  var17 = var16 + 15;
                  var0.method4817(class92.loginMessage2, class92.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var0.method4817(class92.loginMessage3, class92.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var5 = class92.loginWindowX + 180;
                  var6 = 321;
                  class92.field1425.method5101(var5 - 73, var6 - 20);
                  var0.method4817("Back", var5, var6 + 5, 16777215, 0);
               }
            }
         }

         if(class92.field1445 > 0) {
            var17 = class92.field1445;
            var18 = 256;
            class92.field1426 += var17 * 128;
            if(class92.field1426 > class30.field437.length) {
               class92.field1426 -= class30.field437.length;
               var19 = (int)(Math.random() * 12.0D);
               class64.method1094(class29.field419[var19]);
            }

            var19 = 0;
            var7 = var17 * 128;
            var20 = (var18 - var17) * 128;

            int var10;
            int var23;
            for(var23 = 0; var23 < var20; ++var23) {
               var10 = class5.field33[var7 + var19] - class30.field437[var19 + class92.field1426 & class30.field437.length - 1] * var17 / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class5.field33[var19++] = var10;
            }

            int var11;
            int var12;
            for(var23 = var18 - var17; var23 < var18; ++var23) {
               var10 = var23 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class5.field33[var11 + var10] = 255;
                  } else {
                     class5.field33[var10 + var11] = 0;
                  }
               }
            }

            if(class92.field1424 > 0) {
               class92.field1424 -= var17 * 4;
            }

            if(class92.field1419 > 0) {
               class92.field1419 -= var17 * 4;
            }

            if(class92.field1424 == 0 && class92.field1419 == 0) {
               var23 = (int)(Math.random() * (double)(2000 / var17));
               if(var23 == 0) {
                  class92.field1424 = 1024;
               }

               if(var23 == 1) {
                  class92.field1419 = 1024;
               }
            }

            for(var23 = 0; var23 < var18 - var17; ++var23) {
               class92.field1423[var23] = class92.field1423[var23 + var17];
            }

            for(var23 = var18 - var17; var23 < var18; ++var23) {
               class92.field1423[var23] = (int)(Math.sin((double)class92.field1415 / 14.0D) * 16.0D + Math.sin((double)class92.field1415 / 15.0D) * 14.0D + Math.sin((double)class92.field1415 / 16.0D) * 12.0D);
               ++class92.field1415;
            }

            class92.field1418 += var17;
            var23 = ((Client.gameCycle & 1) + var17) / 2;
            if(var23 > 0) {
               for(var10 = 0; var10 < class92.field1418 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class5.field33[var11 + (var12 << 7)] = 192;
               }

               class92.field1418 = 0;
               var10 = 0;

               label392:
               while(true) {
                  int var13;
                  if(var10 >= var18) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label392;
                        }

                        var11 = 0;

                        for(var12 = -var23; var12 < var18; ++var12) {
                           var13 = var12 * 128;
                           if(var23 + var12 < var18) {
                              var11 += GroundObject.field1847[var23 * 128 + var10 + var13];
                           }

                           if(var12 - (var23 + 1) >= 0) {
                              var11 -= GroundObject.field1847[var13 + var10 - (var23 + 1) * 128];
                           }

                           if(var12 >= 0) {
                              class5.field33[var10 + var13] = var11 / (var23 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = var10 * 128;

                  for(var13 = -var23; var13 < 128; ++var13) {
                     if(var23 + var13 < 128) {
                        var11 += class5.field33[var23 + var13 + var12];
                     }

                     if(var13 - (var23 + 1) >= 0) {
                        var11 -= class5.field33[var13 + var12 - (var23 + 1)];
                     }

                     if(var13 >= 0) {
                        GroundObject.field1847[var12 + var13] = var11 / (var23 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class92.field1445 = 0;
         }

         IndexFile.method3065();
         class89.field1392[class134.field1989.field1285?1:0].method5101(class92.field1416 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field896 == 0) {
            if(class38.field518 != null) {
               var17 = class92.field1416 + 5;
               var18 = 463;
               byte var22 = 100;
               byte var21 = 35;
               class38.field518.method5101(var17, var18);
               var0.method4817("World" + " " + Client.world, var22 / 2 + var17, var18 + var21 / 2 - 2, 16777215, 0);
               if(World.worldServersDownload != null) {
                  var1.method4817("Loading...", var22 / 2 + var17, var21 / 2 + var18 + 12, 16777215, 0);
               } else {
                  var1.method4817("Click to switch", var22 / 2 + var17, var21 / 2 + var18 + 12, 16777215, 0);
               }
            } else {
               class38.field518 = class238.method4337(class77.indexSprites, "sl_button", "");
            }
         }

         class40.field541.vmethod5083(0, 0);
      }
   }
}
