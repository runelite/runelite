import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class33 {
   @ObfuscatedName("p")
   String field473;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2009838801
   )
   int field474;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1042841621
   )
   int field475;
   @ObfuscatedName("du")
   static IndexData field476;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -521577791
   )
   static int field478;
   @ObfuscatedName("t")
   class24 field479;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 2145057121
   )
   static int field480;
   @ObfuscatedName("gm")
   static ModIcon[] field481;
   @ObfuscatedName("bi")
   static class289 field482;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZB)V",
      garbageValue = "65"
   )
   static void method352(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class92.field1414 = (class10.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1414 + 202;
      }

      byte var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      if(class92.worldSelectShown) {
         if(class230.field3188 == null) {
            class230.field3188 = class152.method2812(WorldMapType3.indexSprites, "sl_back", "");
         }

         if(class92.field1418 == null) {
            class92.field1418 = WidgetNode.method1033(WorldMapType3.indexSprites, "sl_flags", "");
         }

         if(class47.field613 == null) {
            class47.field613 = WidgetNode.method1033(WorldMapType3.indexSprites, "sl_arrows", "");
         }

         if(WorldMapData.field471 == null) {
            WorldMapData.field471 = WidgetNode.method1033(WorldMapType3.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.method4826(class92.field1414, 23, 765, 480, 0);
         Rasterizer2D.method4830(class92.field1414, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method4830(class92.field1414 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4635("Select a world", class92.field1414 + 62, 15, 0, -1);
         if(WorldMapData.field471 != null) {
            WorldMapData.field471[1].method4923(class92.field1414 + 140, 1);
            var1.method4647("Members only world", class92.field1414 + 152, 10, 16777215, -1);
            WorldMapData.field471[0].method4923(class92.field1414 + 140, 12);
            var1.method4647("Free world", class92.field1414 + 152, 21, 16777215, -1);
         }

         if(class47.field613 != null) {
            var12 = class92.field1414 + 280;
            if(World.field1284[0] == 0 && World.field1283[0] == 0) {
               class47.field613[2].method4923(var12, 4);
            } else {
               class47.field613[0].method4923(var12, 4);
            }

            if(World.field1284[0] == 0 && World.field1283[0] == 1) {
               class47.field613[3].method4923(var12 + 15, 4);
            } else {
               class47.field613[1].method4923(var12 + 15, 4);
            }

            var0.method4647("World", var12 + 32, 17, 16777215, -1);
            var5 = class92.field1414 + 390;
            if(World.field1284[0] == 1 && World.field1283[0] == 0) {
               class47.field613[2].method4923(var5, 4);
            } else {
               class47.field613[0].method4923(var5, 4);
            }

            if(World.field1284[0] == 1 && World.field1283[0] == 1) {
               class47.field613[3].method4923(var5 + 15, 4);
            } else {
               class47.field613[1].method4923(var5 + 15, 4);
            }

            var0.method4647("Players", var5 + 32, 17, 16777215, -1);
            var13 = class92.field1414 + 500;
            if(World.field1284[0] == 2 && World.field1283[0] == 0) {
               class47.field613[2].method4923(var13, 4);
            } else {
               class47.field613[0].method4923(var13, 4);
            }

            if(World.field1284[0] == 2 && World.field1283[0] == 1) {
               class47.field613[3].method4923(var13 + 15, 4);
            } else {
               class47.field613[1].method4923(var13 + 15, 4);
            }

            var0.method4647("Location", var13 + 32, 17, 16777215, -1);
            var6 = class92.field1414 + 610;
            if(World.field1284[0] == 3 && World.field1283[0] == 0) {
               class47.field613[2].method4923(var6, 4);
            } else {
               class47.field613[0].method4923(var6, 4);
            }

            if(World.field1284[0] == 3 && World.field1283[0] == 1) {
               class47.field613[3].method4923(var6 + 15, 4);
            } else {
               class47.field613[1].method4923(var6 + 15, 4);
            }

            var0.method4647("Type", var6 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4826(class92.field1414 + 708, 4, 50, 16, 0);
         var1.method4635("Cancel", class92.field1414 + 708 + 25, 16, 16777215, -1);
         class92.field1445 = -1;
         if(class230.field3188 != null) {
            var4 = 88;
            byte var16 = 19;
            var13 = 765 / (var4 + 1);
            var6 = 480 / (var16 + 1);

            while(true) {
               var14 = var6;
               var15 = var13;
               if(var6 * (var13 - 1) >= World.field1281) {
                  --var13;
               }

               if(var13 * (var6 - 1) >= World.field1281) {
                  --var6;
               }

               if(var13 * (var6 - 1) >= World.field1281) {
                  --var6;
               }

               if(var6 == var14 && var15 == var13) {
                  var14 = (765 - var13 * var4) / (var13 + 1);
                  if(var14 > 5) {
                     var14 = 5;
                  }

                  var15 = (480 - var6 * var16) / (var6 + 1);
                  if(var15 > 5) {
                     var15 = 5;
                  }

                  var7 = (765 - var13 * var4 - (var13 - 1) * var14) / 2;
                  var8 = (480 - var16 * var6 - (var6 - 1) * var15) / 2;
                  var9 = var8 + 23;
                  var10 = var7 + class92.field1414;
                  var11 = 0;
                  boolean var17 = false;

                  int var18;
                  for(var18 = 0; var18 < World.field1281; ++var18) {
                     World var19 = World.worldList[var18];
                     boolean var20 = true;
                     String var21 = Integer.toString(var19.playerCount);
                     if(var19.playerCount == -1) {
                        var21 = "OFF";
                        var20 = false;
                     } else if(var19.playerCount > 1980) {
                        var21 = "FULL";
                        var20 = false;
                     }

                     int var22 = 0;
                     byte var23;
                     if(var19.method1466()) {
                        if(var19.method1461()) {
                           var23 = 7;
                        } else {
                           var23 = 6;
                        }
                     } else if(var19.method1465()) {
                        var22 = 16711680;
                        if(var19.method1461()) {
                           var23 = 5;
                        } else {
                           var23 = 4;
                        }
                     } else if(var19.method1469()) {
                        if(var19.method1461()) {
                           var23 = 3;
                        } else {
                           var23 = 2;
                        }
                     } else if(var19.method1461()) {
                        var23 = 1;
                     } else {
                        var23 = 0;
                     }

                     if(class59.field730 >= var10 && class59.field731 >= var9 && class59.field730 < var4 + var10 && class59.field731 < var9 + var16 && var20) {
                        class92.field1445 = var18;
                        class230.field3188[var23].method4944(var10, var9, 128, 16777215);
                        var17 = true;
                     } else {
                        class230.field3188[var23].method4949(var10, var9);
                     }

                     if(class92.field1418 != null) {
                        class92.field1418[(var19.method1461()?8:0) + var19.location].method4923(var10 + 29, var9);
                     }

                     var0.method4635(Integer.toString(var19.id), var10 + 15, var16 / 2 + var9 + 5, var22, -1);
                     var1.method4635(var21, var10 + 60, var9 + var16 / 2 + 5, 268435455, -1);
                     var9 += var15 + var16;
                     ++var11;
                     if(var11 >= var6) {
                        var9 = var8 + 23;
                        var10 += var14 + var4;
                        var11 = 0;
                     }
                  }

                  if(var17) {
                     var18 = var1.method4696(World.worldList[class92.field1445].activity) + 6;
                     int var27 = var1.field3643 + 8;
                     Rasterizer2D.method4826(class59.field730 - var18 / 2, class59.field731 + 20 + 5, var18, var27, 16777120);
                     Rasterizer2D.method4888(class59.field730 - var18 / 2, class59.field731 + 20 + 5, var18, var27, 0);
                     var1.method4635(World.worldList[class92.field1445].activity, class59.field730, class59.field731 + 20 + 5 + var1.field3643 + 4, 0, -1);
                  }
                  break;
               }
            }
         }

         World.field1296.vmethod4897(0, 0);
      } else {
         if(var3) {
            class37.field519.method4949(class92.field1414, 0);
            class92.field1419.method4949(class92.field1414 + 382, 0);
            class92.field1416.method4923(class92.field1414 + 382 - class92.field1416.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4635("RuneScape is loading - please wait...", class92.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method4888(class92.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method4888(class92.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4826(class92.loginWindowX + 180 - 150, var5 + 2, class92.field1429 * 3, 30, 9179409);
            Rasterizer2D.method4826(class92.loginWindowX + 180 - 150 + class92.field1429 * 3, var5 + 2, 300 - class92.field1429 * 3, 30, 0);
            var0.method4635(class92.field1446, class92.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var24;
         short var25;
         short var26;
         if(Client.gameState == 20) {
            class92.field1415.method4923(class92.loginWindowX + 180 - class92.field1415.originalWidth / 2, 271 - class92.field1415.height / 2);
            var25 = 211;
            var0.method4635(class92.loginMessage1, class92.loginWindowX + 180, var25, 16776960, 0);
            var12 = var25 + 15;
            var0.method4635(class92.loginMessage2, class92.loginWindowX + 180, var12, 16776960, 0);
            var12 += 15;
            var0.method4635(class92.loginMessage3, class92.loginWindowX + 180, var12, 16776960, 0);
            var12 += 15;
            var12 += 10;
            if(class92.loginIndex != 4) {
               var0.method4647("Login: ", class92.loginWindowX + 180 - 110, var12, 16777215, 0);
               var26 = 200;

               for(var24 = class92.username; var0.method4696(var24) > var26; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method4647(FontTypeFace.method4631(var24), class92.loginWindowX + 180 - 70, var12, 16777215, 0);
               var12 += 15;
               var0.method4647("Password: " + class69.method1042(class92.password), class92.loginWindowX + 180 - 108, var12, 16777215, 0);
               var12 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class92.field1415.method4923(class92.loginWindowX, 171);
            short var28;
            if(class92.loginIndex == 0) {
               var25 = 251;
               var0.method4635("Welcome to RuneScape", class92.loginWindowX + 180, var25, 16776960, 0);
               var12 = var25 + 30;
               var5 = class92.loginWindowX + 180 - 80;
               var28 = 291;
               class92.field1447.method4923(var5 - 73, var28 - 20);
               var0.method4636("New User", var5 - 73, var28 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1447.method4923(var5 - 73, var28 - 20);
               var0.method4636("Existing User", var5 - 73, var28 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class92.loginIndex == 1) {
               var0.method4635(class92.field1444, class92.loginWindowX + 180, 211, 16776960, 0);
               var25 = 236;
               var0.method4635(class92.loginMessage1, class92.loginWindowX + 180, var25, 16777215, 0);
               var12 = var25 + 15;
               var0.method4635(class92.loginMessage2, class92.loginWindowX + 180, var12, 16777215, 0);
               var12 += 15;
               var0.method4635(class92.loginMessage3, class92.loginWindowX + 180, var12, 16777215, 0);
               var12 += 15;
               var5 = class92.loginWindowX + 180 - 80;
               var28 = 321;
               class92.field1447.method4923(var5 - 73, var28 - 20);
               var0.method4635("Continue", var5, var28 + 5, 16777215, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1447.method4923(var5 - 73, var28 - 20);
               var0.method4635("Cancel", var5, var28 + 5, 16777215, 0);
            } else {
               short var29;
               if(class92.loginIndex == 2) {
                  var25 = 211;
                  var0.method4635(class92.loginMessage1, class92.loginWindowX + 180, var25, 16776960, 0);
                  var12 = var25 + 15;
                  var0.method4635(class92.loginMessage2, class92.loginWindowX + 180, var12, 16776960, 0);
                  var12 += 15;
                  var0.method4635(class92.loginMessage3, class92.loginWindowX + 180, var12, 16776960, 0);
                  var12 += 15;
                  var12 += 10;
                  var0.method4647("Login: ", class92.loginWindowX + 180 - 110, var12, 16777215, 0);
                  var26 = 200;

                  for(var24 = class92.username; var0.method4696(var24) > var26; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method4647(FontTypeFace.method4631(var24) + (class92.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class15.method105(16776960) + "|":""), class92.loginWindowX + 180 - 70, var12, 16777215, 0);
                  var12 += 15;
                  var0.method4647("Password: " + class69.method1042(class92.password) + (class92.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class15.method105(16776960) + "|":""), class92.loginWindowX + 180 - 108, var12, 16777215, 0);
                  var12 += 15;
                  var6 = class92.loginWindowX + 180 - 80;
                  var29 = 321;
                  class92.field1447.method4923(var6 - 73, var29 - 20);
                  var0.method4635("Login", var6, var29 + 5, 16777215, 0);
                  var6 = class92.loginWindowX + 180 + 80;
                  class92.field1447.method4923(var6 - 73, var29 - 20);
                  var0.method4635("Cancel", var6, var29 + 5, 16777215, 0);
                  var25 = 357;
                  var1.method4635("Forgotten your password? <col=ffffff>Click here.", class92.loginWindowX + 180, var25, 16776960, 0);
               } else if(class92.loginIndex == 3) {
                  var25 = 201;
                  var0.method4635("Invalid username or password.", class92.loginWindowX + 180, var25, 16776960, 0);
                  var12 = var25 + 20;
                  var1.method4635("For accounts created after 24th November 2010, please use your", class92.loginWindowX + 180, var12, 16776960, 0);
                  var12 += 15;
                  var1.method4635("email address to login. Otherwise please login with your username.", class92.loginWindowX + 180, var12, 16776960, 0);
                  var12 += 15;
                  var5 = class92.loginWindowX + 180;
                  var28 = 276;
                  class92.field1447.method4923(var5 - 73, var28 - 20);
                  var2.method4635("Try again", var5, var28 + 5, 16777215, 0);
                  var5 = class92.loginWindowX + 180;
                  var28 = 326;
                  class92.field1447.method4923(var5 - 73, var28 - 20);
                  var2.method4635("Forgotten password?", var5, var28 + 5, 16777215, 0);
               } else if(class92.loginIndex == 4) {
                  var0.method4635("Authenticator", class92.loginWindowX + 180, 211, 16776960, 0);
                  var25 = 236;
                  var0.method4635(class92.loginMessage1, class92.loginWindowX + 180, var25, 16777215, 0);
                  var12 = var25 + 15;
                  var0.method4635(class92.loginMessage2, class92.loginWindowX + 180, var12, 16777215, 0);
                  var12 += 15;
                  var0.method4635(class92.loginMessage3, class92.loginWindowX + 180, var12, 16777215, 0);
                  var12 += 15;
                  var0.method4647("PIN: " + class69.method1042(class82.authCode) + (Client.gameCycle % 40 < 20?class15.method105(16776960) + "|":""), class92.loginWindowX + 180 - 108, var12, 16777215, 0);
                  var12 -= 8;
                  var0.method4647("Trust this computer", class92.loginWindowX + 180 - 9, var12, 16776960, 0);
                  var12 += 15;
                  var0.method4647("for 30 days: ", class92.loginWindowX + 180 - 9, var12, 16776960, 0);
                  var5 = class92.loginWindowX + 180 - 9 + var0.method4696("for 30 days: ") + 15;
                  var13 = var12 - var0.field3643;
                  ModIcon var32;
                  if(class92.field1430) {
                     var32 = FrameMap.field2055;
                  } else {
                     var32 = class21.field351;
                  }

                  var32.method4923(var5, var13);
                  var12 += 15;
                  var14 = class92.loginWindowX + 180 - 80;
                  short var33 = 321;
                  class92.field1447.method4923(var14 - 73, var33 - 20);
                  var0.method4635("Continue", var14, var33 + 5, 16777215, 0);
                  var14 = class92.loginWindowX + 180 + 80;
                  class92.field1447.method4923(var14 - 73, var33 - 20);
                  var0.method4635("Cancel", var14, var33 + 5, 16777215, 0);
                  var1.method4635("<u=ff>Can\'t Log In?</u>", class92.loginWindowX + 180, var33 + 36, 255, 0);
               } else if(class92.loginIndex != 5) {
                  if(class92.loginIndex == 6) {
                     var25 = 211;
                     var0.method4635(class92.loginMessage1, class92.loginWindowX + 180, var25, 16776960, 0);
                     var12 = var25 + 15;
                     var0.method4635(class92.loginMessage2, class92.loginWindowX + 180, var12, 16776960, 0);
                     var12 += 15;
                     var0.method4635(class92.loginMessage3, class92.loginWindowX + 180, var12, 16776960, 0);
                     var12 += 15;
                     var5 = class92.loginWindowX + 180;
                     var28 = 321;
                     class92.field1447.method4923(var5 - 73, var28 - 20);
                     var0.method4635("Back", var5, var28 + 5, 16777215, 0);
                  }
               } else {
                  var0.method4635("Forgotten your password?", class92.loginWindowX + 180, 201, 16776960, 0);
                  var25 = 221;
                  var2.method4635(class92.loginMessage1, class92.loginWindowX + 180, var25, 16776960, 0);
                  var12 = var25 + 15;
                  var2.method4635(class92.loginMessage2, class92.loginWindowX + 180, var12, 16776960, 0);
                  var12 += 15;
                  var2.method4635(class92.loginMessage3, class92.loginWindowX + 180, var12, 16776960, 0);
                  var12 += 15;
                  var12 += 14;
                  var0.method4647("Username/email: ", class92.loginWindowX + 180 - 145, var12, 16777215, 0);
                  var26 = 174;

                  for(var24 = class92.username; var0.method4696(var24) > var26; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method4647(FontTypeFace.method4631(var24) + (Client.gameCycle % 40 < 20?class15.method105(16776960) + "|":""), class92.loginWindowX + 180 - 34, var12, 16777215, 0);
                  var12 += 15;
                  var6 = class92.loginWindowX + 180 - 80;
                  var29 = 321;
                  class92.field1447.method4923(var6 - 73, var29 - 20);
                  var0.method4635("Recover", var6, var29 + 5, 16777215, 0);
                  var6 = class92.loginWindowX + 180 + 80;
                  class92.field1447.method4923(var6 - 73, var29 - 20);
                  var0.method4635("Back", var6, var29 + 5, 16777215, 0);
               }
            }
         }

         if(class92.field1427 > 0) {
            GameEngine.method930(class92.field1427);
            class92.field1427 = 0;
         }

         var25 = 256;
         if(class92.field1442 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class92.field1442 > 768) {
                  class277.field3736[var5] = class289.method5224(class48.field629[var5], class43.field583[var5], 1024 - class92.field1442);
               } else if(class92.field1442 > 256) {
                  class277.field3736[var5] = class43.field583[var5];
               } else {
                  class277.field3736[var5] = class289.method5224(class43.field583[var5], class48.field629[var5], 256 - class92.field1442);
               }
            }
         } else if(class92.field1424 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class92.field1424 > 768) {
                  class277.field3736[var5] = class289.method5224(class48.field629[var5], XClanMember.field897[var5], 1024 - class92.field1424);
               } else if(class92.field1424 > 256) {
                  class277.field3736[var5] = XClanMember.field897[var5];
               } else {
                  class277.field3736[var5] = class289.method5224(XClanMember.field897[var5], class48.field629[var5], 256 - class92.field1424);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class277.field3736[var5] = class48.field629[var5];
            }
         }

         Rasterizer2D.method4833(class92.field1414, 9, class92.field1414 + 128, var25 + 7);
         class37.field519.method4949(class92.field1414, 0);
         Rasterizer2D.method4880();
         var5 = 0;
         var13 = World.field1296.width * 9 + class92.field1414;

         for(var6 = 1; var6 < var25 - 1; ++var6) {
            var14 = (var25 - var6) * class92.field1441[var6] / var25;
            var15 = var14 + 22;
            if(var15 < 0) {
               var15 = 0;
            }

            var5 += var15;

            for(var7 = var15; var7 < 128; ++var7) {
               var8 = class10.field268[var5++];
               if(var8 != 0) {
                  var9 = var8;
                  var10 = 256 - var8;
                  var8 = class277.field3736[var8];
                  var11 = World.field1296.pixels[var13];
                  World.field1296.pixels[var13++] = ((var8 & 16711935) * var9 + (var11 & 16711935) * var10 & -16711936) + (var9 * (var8 & '\uff00') + var10 * (var11 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var13;
               }
            }

            var13 += var15 + World.field1296.width - 128;
         }

         Rasterizer2D.method4833(class92.field1414 + 765 - 128, 9, class92.field1414 + 765, var25 + 7);
         class92.field1419.method4949(class92.field1414 + 382, 0);
         Rasterizer2D.method4880();
         var5 = 0;
         var13 = class92.field1414 + World.field1296.width * 9 + 24 + 637;

         for(var6 = 1; var6 < var25 - 1; ++var6) {
            var14 = class92.field1441[var6] * (var25 - var6) / var25;
            var15 = 103 - var14;
            var13 += var14;

            for(var7 = 0; var7 < var15; ++var7) {
               var8 = class10.field268[var5++];
               if(var8 != 0) {
                  var9 = var8;
                  var10 = 256 - var8;
                  var8 = class277.field3736[var8];
                  var11 = World.field1296.pixels[var13];
                  World.field1296.pixels[var13++] = ((var11 & 16711935) * var10 + var9 * (var8 & 16711935) & -16711936) + ((var11 & '\uff00') * var10 + var9 * (var8 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var13;
               }
            }

            var5 += 128 - var15;
            var13 += World.field1296.width - var15 - var14;
         }

         class92.field1423[Item.field1481.field1300?1:0].method4923(class92.field1414 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field1120 == 0) {
            if(Signlink.field2253 != null) {
               var12 = class92.field1414 + 5;
               var26 = 463;
               byte var30 = 100;
               byte var31 = 35;
               Signlink.field2253.method4923(var12, var26);
               var0.method4635("World " + Client.world, var30 / 2 + var12, var31 / 2 + var26 - 2, 16777215, 0);
               if(World.worldServersDownload != null) {
                  var1.method4635("Loading...", var30 / 2 + var12, var31 / 2 + var26 + 12, 16777215, 0);
               } else {
                  var1.method4635("Click to switch", var12 + var30 / 2, var26 + var31 / 2 + 12, 16777215, 0);
               }
            } else {
               Signlink.field2253 = class273.method4789(WorldMapType3.indexSprites, "sl_button", "");
            }
         }
      }

   }

   class33(String var1, int var2, int var3, class24 var4) {
      this.field473 = var1;
      this.field474 = var2;
      this.field475 = var3;
      this.field479 = var4;
   }
}
