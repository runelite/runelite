import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class5 implements class0 {
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 1687533779
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljh;Ljh;Ljh;ZI)V",
      garbageValue = "-1879649297"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class90.field1413 = (Timer.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1413 + 202;
         class227.field3145 = class90.loginWindowX + 180;
      }

      if(class90.worldSelectShown) {
         class19.method144(var0, var1);
      } else {
         if(var3) {
            class90.field1427.method5172(class90.field1413, 0);
            class8.field250.method5172(class90.field1413 + 382, 0);
            class29.logoSprite.method5147(class90.field1413 + 382 - class29.logoSprite.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4845("RuneScape is loading - please wait...", class90.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method5045(class90.loginWindowX + 180 - 150, var5 + 2, class90.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method5045(class90.loginWindowX + 180 - 150 + class90.loadingBarPercentage * 3, var5 + 2, 300 - class90.loadingBarPercentage * 3, 30, 0);
            var0.method4845(class90.loadingText, class90.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var17;
         int var18;
         short var19;
         if(Client.gameState == 20) {
            class90.field1414.method5147(class90.loginWindowX + 180 - class90.field1414.originalWidth / 2, 271 - class90.field1414.height / 2);
            var17 = 201;
            var0.method4845(class90.loginMessage1, class90.loginWindowX + 180, var17, 16776960, 0);
            var18 = var17 + 15;
            var0.method4845(class90.loginMessage2, class90.loginWindowX + 180, var18, 16776960, 0);
            var18 += 15;
            var0.method4845(class90.loginMessage3, class90.loginWindowX + 180, var18, 16776960, 0);
            var18 += 15;
            var18 += 7;
            if(class90.loginIndex != 4) {
               var0.method4842("Login: ", class90.loginWindowX + 180 - 110, var18, 16777215, 0);
               var19 = 200;

               for(var6 = class157.method3022(); var0.method4848(var6) > var19; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4842(FontTypeFace.appendTags(var6), class90.loginWindowX + 180 - 70, var18, 16777215, 0);
               var18 += 15;
               var0.method4842("Password: " + class45.method653(class90.password), class90.loginWindowX + 180 - 108, var18, 16777215, 0);
               var18 += 15;
            }
         }

         int var7;
         int var8;
         int var9;
         int var24;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class90.field1414.method5147(class90.loginWindowX, 171);
            short var14;
            if(class90.loginIndex == 0) {
               var17 = 251;
               var0.method4845("Welcome to RuneScape", class90.loginWindowX + 180, var17, 16776960, 0);
               var18 = var17 + 30;
               var5 = class90.loginWindowX + 180 - 80;
               var14 = 291;
               World.field1293.method5147(var5 - 73, var14 - 20);
               var0.method4915("New User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class90.loginWindowX + 180 + 80;
               World.field1293.method5147(var5 - 73, var14 - 20);
               var0.method4915("Existing User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class90.loginIndex == 1) {
               var0.method4845(class90.field1442, class90.loginWindowX + 180, 201, 16776960, 0);
               var17 = 236;
               var0.method4845(class90.loginMessage1, class90.loginWindowX + 180, var17, 16777215, 0);
               var18 = var17 + 15;
               var0.method4845(class90.loginMessage2, class90.loginWindowX + 180, var18, 16777215, 0);
               var18 += 15;
               var0.method4845(class90.loginMessage3, class90.loginWindowX + 180, var18, 16777215, 0);
               var18 += 15;
               var5 = class90.loginWindowX + 180 - 80;
               var14 = 321;
               World.field1293.method5147(var5 - 73, var14 - 20);
               var0.method4845("Continue", var5, var14 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180 + 80;
               World.field1293.method5147(var5 - 73, var14 - 20);
               var0.method4845("Cancel", var5, var14 + 5, 16777215, 0);
            } else if(class90.loginIndex == 2) {
               var17 = 201;
               var0.method4845(class90.loginMessage1, class227.field3145, var17, 16776960, 0);
               var18 = var17 + 15;
               var0.method4845(class90.loginMessage2, class227.field3145, var18, 16776960, 0);
               var18 += 15;
               var0.method4845(class90.loginMessage3, class227.field3145, var18, 16776960, 0);
               var18 += 15;
               var18 += 7;
               var0.method4842("Login: ", class227.field3145 - 110, var18, 16777215, 0);
               var19 = 200;

               for(var6 = class157.method3022(); var0.method4848(var6) > var19; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4842(FontTypeFace.appendTags(var6) + (class90.field1422 == 0 & Client.gameCycle % 40 < 20?class24.getColTags(16776960) + "|":""), class227.field3145 - 70, var18, 16777215, 0);
               var18 += 15;
               var0.method4842("Password: " + class45.method653(class90.password) + (class90.field1422 == 1 & Client.gameCycle % 40 < 20?class24.getColTags(16776960) + "|":""), class227.field3145 - 108, var18, 16777215, 0);
               var18 += 15;
               var17 = 277;
               var7 = class227.field3145 + -117;
               IndexedSprite var15 = RSCanvas.method776(class90.field1439, class90.field1450);
               var15.method5147(var7, var17);
               var7 = var7 + var15.originalWidth + 5;
               var1.method4842("Remember username", var7, var17 + 13, 16776960, 0);
               var7 = class227.field3145 + 24;
               var15 = RSCanvas.method776(class70.preferences.field1305, class90.field1441);
               var15.method5147(var7, var17);
               var7 = var7 + var15.originalWidth + 5;
               var1.method4842("Hide username", var7, var17 + 13, 16776960, 0);
               var18 = var17 + 15;
               var9 = class227.field3145 - 80;
               short var10 = 321;
               World.field1293.method5147(var9 - 73, var10 - 20);
               var0.method4845("Login", var9, var10 + 5, 16777215, 0);
               var9 = class227.field3145 + 80;
               World.field1293.method5147(var9 - 73, var10 - 20);
               var0.method4845("Cancel", var9, var10 + 5, 16777215, 0);
               var17 = 357;
               var1.method4845("Forgotten your password? <col=ffffff>Click here.", class227.field3145, var17, 16776960, 0);
            } else if(class90.loginIndex == 3) {
               var17 = 201;
               var0.method4845("Invalid username or password.", class90.loginWindowX + 180, var17, 16776960, 0);
               var18 = var17 + 20;
               var1.method4845("For accounts created after 24th November 2010, please use your", class90.loginWindowX + 180, var18, 16776960, 0);
               var18 += 15;
               var1.method4845("email address to login. Otherwise please login with your username.", class90.loginWindowX + 180, var18, 16776960, 0);
               var18 += 15;
               var5 = class90.loginWindowX + 180;
               var14 = 276;
               World.field1293.method5147(var5 - 73, var14 - 20);
               var2.method4845("Try again", var5, var14 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180;
               var14 = 326;
               World.field1293.method5147(var5 - 73, var14 - 20);
               var2.method4845("Forgotten password?", var5, var14 + 5, 16777215, 0);
            } else if(class90.loginIndex == 4) {
               var0.method4845("Authenticator", class90.loginWindowX + 180, 201, 16776960, 0);
               var17 = 236;
               var0.method4845(class90.loginMessage1, class90.loginWindowX + 180, var17, 16777215, 0);
               var18 = var17 + 15;
               var0.method4845(class90.loginMessage2, class90.loginWindowX + 180, var18, 16777215, 0);
               var18 += 15;
               var0.method4845(class90.loginMessage3, class90.loginWindowX + 180, var18, 16777215, 0);
               var18 += 15;
               var0.method4842("PIN: " + class45.method653(DState.field2346) + (Client.gameCycle % 40 < 20?class24.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 108, var18, 16777215, 0);
               var18 -= 8;
               var0.method4842("Trust this computer", class90.loginWindowX + 180 - 9, var18, 16776960, 0);
               var18 += 15;
               var0.method4842("for 30 days: ", class90.loginWindowX + 180 - 9, var18, 16776960, 0);
               var5 = 180 + class90.loginWindowX - 9 + var0.method4848("for 30 days: ") + 15;
               var24 = var18 - var0.verticalSpace;
               IndexedSprite var16;
               if(class90.field1438) {
                  var16 = class29.field430;
               } else {
                  var16 = class90.field1417;
               }

               var16.method5147(var5, var24);
               var18 += 15;
               var8 = class90.loginWindowX + 180 - 80;
               short var22 = 321;
               World.field1293.method5147(var8 - 73, var22 - 20);
               var0.method4845("Continue", var8, var22 + 5, 16777215, 0);
               var8 = class90.loginWindowX + 180 + 80;
               World.field1293.method5147(var8 - 73, var22 - 20);
               var0.method4845("Cancel", var8, var22 + 5, 16777215, 0);
               var1.method4845("<u=ff>Can\'t Log In?</u>", class90.loginWindowX + 180, var22 + 36, 255, 0);
            } else if(class90.loginIndex == 5) {
               var0.method4845("Forgotten your password?", class90.loginWindowX + 180, 201, 16776960, 0);
               var17 = 221;
               var2.method4845(class90.loginMessage1, class90.loginWindowX + 180, var17, 16776960, 0);
               var18 = var17 + 15;
               var2.method4845(class90.loginMessage2, class90.loginWindowX + 180, var18, 16776960, 0);
               var18 += 15;
               var2.method4845(class90.loginMessage3, class90.loginWindowX + 180, var18, 16776960, 0);
               var18 += 15;
               var18 += 14;
               var0.method4842("Username/email: ", class90.loginWindowX + 180 - 145, var18, 16777215, 0);
               var19 = 174;

               for(var6 = class157.method3022(); var0.method4848(var6) > var19; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4842(FontTypeFace.appendTags(var6) + (Client.gameCycle % 40 < 20?class24.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 34, var18, 16777215, 0);
               var18 += 15;
               var7 = class90.loginWindowX + 180 - 80;
               short var20 = 321;
               World.field1293.method5147(var7 - 73, var20 - 20);
               var0.method4845("Recover", var7, var20 + 5, 16777215, 0);
               var7 = class90.loginWindowX + 180 + 80;
               World.field1293.method5147(var7 - 73, var20 - 20);
               var0.method4845("Back", var7, var20 + 5, 16777215, 0);
            } else if(class90.loginIndex == 6) {
               var17 = 201;
               var0.method4845(class90.loginMessage1, class90.loginWindowX + 180, var17, 16776960, 0);
               var18 = var17 + 15;
               var0.method4845(class90.loginMessage2, class90.loginWindowX + 180, var18, 16776960, 0);
               var18 += 15;
               var0.method4845(class90.loginMessage3, class90.loginWindowX + 180, var18, 16776960, 0);
               var18 += 15;
               var5 = class90.loginWindowX + 180;
               var14 = 321;
               World.field1293.method5147(var5 - 73, var14 - 20);
               var0.method4845("Back", var5, var14 + 5, 16777215, 0);
            }
         }

         if(class90.field1412 > 0) {
            var18 = class90.field1412;
            var19 = 256;
            class90.field1426 += var18 * 128;
            if(class90.field1426 > Frames.field2125.length) {
               class90.field1426 -= Frames.field2125.length;
               var24 = (int)(Math.random() * 12.0D);
               class182.method3534(class90.field1415[var24]);
            }

            var24 = 0;
            var7 = var18 * 128;
            var8 = (var19 - var18) * 128;

            int var23;
            for(var9 = 0; var9 < var8; ++var9) {
               var23 = class90.field1425[var7 + var24] - Frames.field2125[var24 + class90.field1426 & Frames.field2125.length - 1] * var18 / 6;
               if(var23 < 0) {
                  var23 = 0;
               }

               class90.field1425[var24++] = var23;
            }

            int var11;
            int var12;
            for(var9 = var19 - var18; var9 < var19; ++var9) {
               var23 = var9 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class90.field1425[var11 + var23] = 255;
                  } else {
                     class90.field1425[var11 + var23] = 0;
                  }
               }
            }

            if(class90.field1423 > 0) {
               class90.field1423 -= var18 * 4;
            }

            if(class90.field1424 > 0) {
               class90.field1424 -= var18 * 4;
            }

            if(class90.field1423 == 0 && class90.field1424 == 0) {
               var9 = (int)(Math.random() * (double)(2000 / var18));
               if(var9 == 0) {
                  class90.field1423 = 1024;
               }

               if(var9 == 1) {
                  class90.field1424 = 1024;
               }
            }

            for(var9 = 0; var9 < var19 - var18; ++var9) {
               class90.field1443[var9] = class90.field1443[var9 + var18];
            }

            for(var9 = var19 - var18; var9 < var19; ++var9) {
               class90.field1443[var9] = (int)(Math.sin((double)class90.field1429 / 14.0D) * 16.0D + Math.sin((double)class90.field1429 / 15.0D) * 14.0D + Math.sin((double)class90.field1429 / 16.0D) * 12.0D);
               ++class90.field1429;
            }

            class90.field1430 += var18;
            var9 = (var18 + (Client.gameCycle & 1)) / 2;
            if(var9 > 0) {
               for(var23 = 0; var23 < class90.field1430 * 100; ++var23) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class90.field1425[var11 + (var12 << 7)] = 192;
               }

               class90.field1430 = 0;
               var23 = 0;

               label286:
               while(true) {
                  int var13;
                  if(var23 >= var19) {
                     var23 = 0;

                     while(true) {
                        if(var23 >= 128) {
                           break label286;
                        }

                        var11 = 0;

                        for(var12 = -var9; var12 < var19; ++var12) {
                           var13 = var12 * 128;
                           if(var12 + var9 < var19) {
                              var11 += World.field1285[var9 * 128 + var23 + var13];
                           }

                           if(var12 - (var9 + 1) >= 0) {
                              var11 -= World.field1285[var23 + var13 - (var9 + 1) * 128];
                           }

                           if(var12 >= 0) {
                              class90.field1425[var13 + var23] = var11 / (var9 * 2 + 1);
                           }
                        }

                        ++var23;
                     }
                  }

                  var11 = 0;
                  var12 = var23 * 128;

                  for(var13 = -var9; var13 < 128; ++var13) {
                     if(var13 + var9 < 128) {
                        var11 += class90.field1425[var12 + var13 + var9];
                     }

                     if(var13 - (var9 + 1) >= 0) {
                        var11 -= class90.field1425[var13 + var12 - (var9 + 1)];
                     }

                     if(var13 >= 0) {
                        World.field1285[var12 + var13] = var11 / (var9 * 2 + 1);
                     }
                  }

                  ++var23;
               }
            }

            class90.field1412 = 0;
         }

         BaseVarType.method9();
         class252.titlemuteSprite[class70.preferences.muted?1:0].method5147(class90.field1413 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(Buffer.field2391 != null) {
               var18 = class90.field1413 + 5;
               var19 = 463;
               byte var25 = 100;
               byte var21 = 35;
               Buffer.field2391.method5147(var18, var19);
               var0.method4845("World" + " " + Client.world, var25 / 2 + var18, var21 / 2 + var19 - 2, 16777215, 0);
               if(Ignore.listFetcher != null) {
                  var1.method4845("Loading...", var25 / 2 + var18, var21 / 2 + var19 + 12, 16777215, 0);
               } else {
                  var1.method4845("Click to switch", var25 / 2 + var18, var21 / 2 + var19 + 12, 16777215, 0);
               }
            } else {
               Buffer.field2391 = InvType.getSprite(class3.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(Lhj;IIII)V",
      garbageValue = "-1250821773"
   )
   static final void method14(Widget var0, int var1, int var2, int var3) {
      KeyFocusListener.method756();
      class210 var4 = var0.method4076(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2589 + var1, var2 + var4.field2592);
         if(Client.field1148 != 2 && Client.field1148 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = class66.localPlayer.x / 32 + 48;
            int var7 = 464 - class66.localPlayer.y / 32;
            ScriptVarType.field85.method5184(var1, var2, var4.field2589, var4.field2592, var6, var7, var5, 256, var4.field2594, var4.field2591);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1164; ++var8) {
               var9 = Client.field1143[var8] * 4 + 2 - class66.localPlayer.x / 32;
               var10 = Client.field1179[var8] * 4 + 2 - class66.localPlayer.y / 32;
               class9.drawDot(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[class46.plane][var8][var9];
                  if(var17 != null) {
                     var11 = var8 * 4 + 2 - class66.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - class66.localPlayer.y / 32;
                     class9.drawDot(var1, var2, var11, var12, class34.mapDots[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.npcIndexesCount; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.npcIndices[var8]];
               if(var18 != null && var18.hasConfig()) {
                  NPCComposition var21 = var18.composition;
                  if(var21 != null && var21.configs != null) {
                     var21 = var21.transform();
                  }

                  if(var21 != null && var21.isMinimapVisible && var21.field3582) {
                     var11 = var18.x / 32 - class66.localPlayer.x / 32;
                     var12 = var18.y / 32 - class66.localPlayer.y / 32;
                     class9.drawDot(var1, var2, var11, var12, class34.mapDots[1], var4);
                  }
               }
            }

            var8 = class94.playerIndexesCount;
            int[] var22 = class94.playerIndices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var22[var10]];
               if(var19 != null && var19.hasConfig() && !var19.hidden && var19 != class66.localPlayer) {
                  var12 = var19.x / 32 - class66.localPlayer.x / 32;
                  int var13 = var19.y / 32 - class66.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class90.isFriended(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class2.clanChatCount; ++var16) {
                     if(var19.name.equals(GraphicsObject.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(class66.localPlayer.team != 0 && var19.team != 0 && var19.team == class66.localPlayer.team) {
                     var20 = true;
                  }

                  if(var14) {
                     class9.drawDot(var1, var2, var12, var13, class34.mapDots[3], var4);
                  } else if(var20) {
                     class9.drawDot(var1, var2, var12, var13, class34.mapDots[4], var4);
                  } else if(var15) {
                     class9.drawDot(var1, var2, var12, var13, class34.mapDots[5], var4);
                  } else {
                     class9.drawDot(var1, var2, var12, var13, class34.mapDots[2], var4);
                  }
               }
            }

            if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
               if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                  if(var23 != null) {
                     var11 = var23.x / 32 - class66.localPlayer.x / 32;
                     var12 = var23.y / 32 - class66.localPlayer.y / 32;
                     class18.method138(var1, var2, var11, var12, class202.mapMarkers[1], var4);
                  }
               }

               if(Client.hintArrowTargetType == 2) {
                  var10 = Client.hintArrowX * 4 - class22.baseX * 1645060 + 2 - class66.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - class273.baseY * 4 + 2 - class66.localPlayer.y / 32;
                  class18.method138(var1, var2, var10, var11, class202.mapMarkers[1], var4);
               }

               if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                  if(var24 != null) {
                     var11 = var24.x / 32 - class66.localPlayer.x / 32;
                     var12 = var24.y / 32 - class66.localPlayer.y / 32;
                     class18.method138(var1, var2, var11, var12, class202.mapMarkers[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - class66.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - class66.localPlayer.y / 32;
               class9.drawDot(var1, var2, var10, var11, class202.mapMarkers[0], var4);
            }

            if(!class66.localPlayer.hidden) {
               Rasterizer2D.method5045(var4.field2589 / 2 + var1 - 1, var4.field2592 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5059(var1, var2, 0, var4.field2594, var4.field2591);
         }

         Client.field1120[var3] = true;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;I)V",
      garbageValue = "-1175049252"
   )
   public static void method17(IndexDataBase var0) {
      Varbit.varbit_ref = var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "83319532"
   )
   static void method15(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class266.worldList[var6];
         class266.worldList[var6] = class266.worldList[var1];
         class266.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = class266.worldList[var9];
            int var12 = FileOnDisk.method2410(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = FileOnDisk.method2410(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = class266.worldList[var9];
               class266.worldList[var9] = class266.worldList[var7];
               class266.worldList[var7++] = var14;
            }
         }

         class266.worldList[var1] = class266.worldList[var7];
         class266.worldList[var7] = var8;
         method15(var0, var7 - 1, var2, var3, var4, var5);
         method15(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
