import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
final class class3 implements class0 {
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "78"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class46.field590.method858();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field947 = 0;
            Client.field1129 = 0;
         }

         if(var0 != 20 && var0 != 40 && Frames.field2149 != null) {
            Frames.field2149.method2989();
            Frames.field2149 = null;
         }

         if(Client.gameState == 25) {
            Client.field1180 = 0;
            Client.field1080 = 0;
            Client.field1151 = 1;
            Client.field971 = 0;
            Client.field972 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               Tile.method2507(class22.field353, Client.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               Tile.method2507(class22.field353, Client.indexSprites, false, 4);
            } else if(class92.field1430) {
               class92.field1418 = null;
               WidgetNode.field820 = null;
               class92.field1419 = null;
               class92.field1420 = null;
               class92.field1421 = null;
               class71.field845 = null;
               class177.field2426 = null;
               class33.field478 = null;
               class92.field1422 = null;
               class47.field599 = null;
               WorldMapType3.field394 = null;
               class4.field38 = null;
               class90.field1405 = null;
               class69.field836 = null;
               class51.field641 = null;
               class158.field2274 = null;
               class41.field563 = null;
               DecorativeObject.field2184 = null;
               class1.field12 = null;
               RSSocket.field2286 = null;
               class36.field509 = null;
               MessageNode.field860 = null;
               class203.field2515 = 1;
               class203.field2516 = null;
               class158.field2275 = -1;
               class275.field3730 = -1;
               FileOnDisk.field1774 = 0;
               class271.field3690 = false;
               class155.field2261 = 2;
               class222.method4092(true);
               class92.field1430 = false;
            }
         } else {
            Tile.method2507(class22.field353, Client.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZB)V",
      garbageValue = "43"
   )
   static void method9(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class92.field1417 = (class174.field2408 - 765) / 2;
         class92.loginWindowX = class92.field1417 + 202;
      }

      if(class92.worldSelectShown) {
         class61.method1047(var0, var1);
      } else {
         if(var3) {
            class92.field1420.method5164(class92.field1417, 0);
            class92.field1421.method5164(class92.field1417 + 382, 0);
            class71.field845.method5066(class92.field1417 + 382 - class71.field845.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4825("RuneScape is loading - please wait...", class92.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method4976(class92.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method4976(class92.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method5040(class92.loginWindowX + 180 - 150, var5 + 2, class92.field1416 * 3, 30, 9179409);
            Rasterizer2D.method5040(class92.field1416 * 3 + (class92.loginWindowX + 180 - 150), var5 + 2, 300 - class92.field1416 * 3, 30, 0);
            var0.method4825(class92.field1433, class92.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var17;
         int var18;
         short var19;
         if(Client.gameState == 20) {
            class92.field1418.method5066(class92.loginWindowX + 180 - class92.field1418.originalWidth / 2, 271 - class92.field1418.height / 2);
            var17 = 211;
            var0.method4825(class92.loginMessage1, class92.loginWindowX + 180, var17, 16776960, 0);
            var18 = var17 + 15;
            var0.method4825(class92.loginMessage2, class92.loginWindowX + 180, var18, 16776960, 0);
            var18 += 15;
            var0.method4825(class92.loginMessage3, class92.loginWindowX + 180, var18, 16776960, 0);
            var18 += 15;
            var18 += 10;
            if(class92.loginIndex != 4) {
               var0.method4785("Login: ", class92.loginWindowX + 180 - 110, var18, 16777215, 0);
               var19 = 200;

               for(var6 = class92.username; var0.method4780(var6) > var19; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4785(FontTypeFace.method4815(var6), class92.loginWindowX + 180 - 70, var18, 16777215, 0);
               var18 += 15;
               var0.method4785("Password: " + WorldMapType0.method698(class92.password), class92.loginWindowX + 180 - 108, var18, 16777215, 0);
               var18 += 15;
            }
         }

         int var7;
         int var20;
         int var23;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class92.field1418.method5066(class92.loginWindowX, 171);
            short var15;
            if(class92.loginIndex == 0) {
               var17 = 251;
               var0.method4825("Welcome to RuneScape", class92.loginWindowX + 180, var17, 16776960, 0);
               var18 = var17 + 30;
               var5 = class92.loginWindowX + 180 - 80;
               var15 = 291;
               WidgetNode.field820.method5066(var5 - 73, var15 - 20);
               var0.method4792("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class92.loginWindowX + 180 + 80;
               WidgetNode.field820.method5066(var5 - 73, var15 - 20);
               var0.method4792("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class92.loginIndex == 1) {
               var0.method4825(class92.field1435, class92.loginWindowX + 180, 211, 16776960, 0);
               var17 = 236;
               var0.method4825(class92.loginMessage1, class92.loginWindowX + 180, var17, 16777215, 0);
               var18 = var17 + 15;
               var0.method4825(class92.loginMessage2, class92.loginWindowX + 180, var18, 16777215, 0);
               var18 += 15;
               var0.method4825(class92.loginMessage3, class92.loginWindowX + 180, var18, 16777215, 0);
               var18 += 15;
               var5 = class92.loginWindowX + 180 - 80;
               var15 = 321;
               WidgetNode.field820.method5066(var5 - 73, var15 - 20);
               var0.method4825("Continue", var5, var15 + 5, 16777215, 0);
               var5 = class92.loginWindowX + 180 + 80;
               WidgetNode.field820.method5066(var5 - 73, var15 - 20);
               var0.method4825("Cancel", var5, var15 + 5, 16777215, 0);
            } else {
               short var8;
               if(class92.loginIndex == 2) {
                  var17 = 211;
                  var0.method4825(class92.loginMessage1, class92.loginWindowX + 180, var17, 16776960, 0);
                  var18 = var17 + 15;
                  var0.method4825(class92.loginMessage2, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var0.method4825(class92.loginMessage3, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var18 += 10;
                  var0.method4785("Login: ", class92.loginWindowX + 180 - 110, var18, 16777215, 0);
                  var19 = 200;

                  for(var6 = class92.username; var0.method4780(var6) > var19; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4785(FontTypeFace.method4815(var6) + (class92.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class60.method996(16776960) + "|":""), class92.loginWindowX + 180 - 70, var18, 16777215, 0);
                  var18 += 15;
                  var0.method4785("Password: " + WorldMapType0.method698(class92.password) + (class92.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class60.method996(16776960) + "|":""), class92.loginWindowX + 180 - 108, var18, 16777215, 0);
                  var18 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  WidgetNode.field820.method5066(var7 - 73, var8 - 20);
                  var0.method4825("Login", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  WidgetNode.field820.method5066(var7 - 73, var8 - 20);
                  var0.method4825("Cancel", var7, var8 + 5, 16777215, 0);
                  var17 = 357;
                  var1.method4825("Forgotten your password? <col=ffffff>Click here.", class92.loginWindowX + 180, var17, 16776960, 0);
               } else if(class92.loginIndex == 3) {
                  var17 = 201;
                  var0.method4825("Invalid username or password.", class92.loginWindowX + 180, var17, 16776960, 0);
                  var18 = var17 + 20;
                  var1.method4825("For accounts created after 24th November 2010, please use your", class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var1.method4825("email address to login. Otherwise please login with your username.", class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var5 = class92.loginWindowX + 180;
                  var15 = 276;
                  WidgetNode.field820.method5066(var5 - 73, var15 - 20);
                  var2.method4825("Try again", var5, var15 + 5, 16777215, 0);
                  var5 = class92.loginWindowX + 180;
                  var15 = 326;
                  WidgetNode.field820.method5066(var5 - 73, var15 - 20);
                  var2.method4825("Forgotten password?", var5, var15 + 5, 16777215, 0);
               } else if(class92.loginIndex == 4) {
                  var0.method4825("Authenticator", class92.loginWindowX + 180, 211, 16776960, 0);
                  var17 = 236;
                  var0.method4825(class92.loginMessage1, class92.loginWindowX + 180, var17, 16777215, 0);
                  var18 = var17 + 15;
                  var0.method4825(class92.loginMessage2, class92.loginWindowX + 180, var18, 16777215, 0);
                  var18 += 15;
                  var0.method4825(class92.loginMessage3, class92.loginWindowX + 180, var18, 16777215, 0);
                  var18 += 15;
                  var0.method4785("PIN: " + WorldMapType0.method698(XItemContainer.authCode) + (Client.gameCycle % 40 < 20?class60.method996(16776960) + "|":""), class92.loginWindowX + 180 - 108, var18, 16777215, 0);
                  var18 -= 8;
                  var0.method4785("Trust this computer", class92.loginWindowX + 180 - 9, var18, 16776960, 0);
                  var18 += 15;
                  var0.method4785("for 30 days: ", class92.loginWindowX + 180 - 9, var18, 16776960, 0);
                  var5 = class92.loginWindowX + 180 - 9 + var0.method4780("for 30 days: ") + 15;
                  var23 = var18 - var0.field3652;
                  ModIcon var16;
                  if(class92.field1442) {
                     var16 = class92.field1422;
                  } else {
                     var16 = class33.field478;
                  }

                  var16.method5066(var5, var23);
                  var18 += 15;
                  var20 = class92.loginWindowX + 180 - 80;
                  short var9 = 321;
                  WidgetNode.field820.method5066(var20 - 73, var9 - 20);
                  var0.method4825("Continue", var20, var9 + 5, 16777215, 0);
                  var20 = class92.loginWindowX + 180 + 80;
                  WidgetNode.field820.method5066(var20 - 73, var9 - 20);
                  var0.method4825("Cancel", var20, var9 + 5, 16777215, 0);
                  var1.method4825("<u=ff>Can\'t Log In?</u>", class92.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class92.loginIndex == 5) {
                  var0.method4825("Forgotten your password?", class92.loginWindowX + 180, 201, 16776960, 0);
                  var17 = 221;
                  var2.method4825(class92.loginMessage1, class92.loginWindowX + 180, var17, 16776960, 0);
                  var18 = var17 + 15;
                  var2.method4825(class92.loginMessage2, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var2.method4825(class92.loginMessage3, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var18 += 14;
                  var0.method4785("Username/email: ", class92.loginWindowX + 180 - 145, var18, 16777215, 0);
                  var19 = 174;

                  for(var6 = class92.username; var0.method4780(var6) > var19; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4785(FontTypeFace.method4815(var6) + (Client.gameCycle % 40 < 20?class60.method996(16776960) + "|":""), class92.loginWindowX + 180 - 34, var18, 16777215, 0);
                  var18 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  WidgetNode.field820.method5066(var7 - 73, var8 - 20);
                  var0.method4825("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  WidgetNode.field820.method5066(var7 - 73, var8 - 20);
                  var0.method4825("Back", var7, var8 + 5, 16777215, 0);
               } else if(class92.loginIndex == 6) {
                  var17 = 211;
                  var0.method4825(class92.loginMessage1, class92.loginWindowX + 180, var17, 16776960, 0);
                  var18 = var17 + 15;
                  var0.method4825(class92.loginMessage2, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var0.method4825(class92.loginMessage3, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var5 = class92.loginWindowX + 180;
                  var15 = 321;
                  WidgetNode.field820.method5066(var5 - 73, var15 - 20);
                  var0.method4825("Back", var5, var15 + 5, 16777215, 0);
               }
            }
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var21;
         if(class92.field1451 > 0) {
            var18 = class92.field1451;
            var19 = 256;
            class92.field1447 += var18 * 128;
            if(class92.field1447 > class1.field12.length) {
               class92.field1447 -= class1.field12.length;
               var23 = (int)(Math.random() * 12.0D);
               class47.method686(class92.field1419[var23]);
            }

            var23 = 0;
            var7 = var18 * 128;
            var20 = (var19 - var18) * 128;

            for(var21 = 0; var21 < var20; ++var21) {
               var10 = class36.field509[var23 + var7] - class1.field12[var23 + class92.field1447 & class1.field12.length - 1] * var18 / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class36.field509[var23++] = var10;
            }

            for(var21 = var19 - var18; var21 < var19; ++var21) {
               var10 = var21 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class36.field509[var10 + var11] = 255;
                  } else {
                     class36.field509[var11 + var10] = 0;
                  }
               }
            }

            if(class92.field1437 > 0) {
               class92.field1437 -= var18 * 4;
            }

            if(class92.field1427 > 0) {
               class92.field1427 -= var18 * 4;
            }

            if(class92.field1437 == 0 && class92.field1427 == 0) {
               var21 = (int)(Math.random() * (double)(2000 / var18));
               if(var21 == 0) {
                  class92.field1437 = 1024;
               }

               if(var21 == 1) {
                  class92.field1427 = 1024;
               }
            }

            for(var21 = 0; var21 < var19 - var18; ++var21) {
               class92.field1425[var21] = class92.field1425[var18 + var21];
            }

            for(var21 = var19 - var18; var21 < var19; ++var21) {
               class92.field1425[var21] = (int)(Math.sin((double)class92.field1444 / 14.0D) * 16.0D + Math.sin((double)class92.field1444 / 15.0D) * 14.0D + Math.sin((double)class92.field1444 / 16.0D) * 12.0D);
               ++class92.field1444;
            }

            class92.field1429 += var18;
            var21 = (var18 + (Client.gameCycle & 1)) / 2;
            if(var21 > 0) {
               for(var10 = 0; var10 < class92.field1429 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class36.field509[(var12 << 7) + var11] = 192;
               }

               class92.field1429 = 0;
               var10 = 0;

               label508:
               while(true) {
                  if(var10 >= var19) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label508;
                        }

                        var11 = 0;

                        for(var12 = -var21; var12 < var19; ++var12) {
                           var13 = var12 * 128;
                           if(var12 + var21 < var19) {
                              var11 += MessageNode.field860[var21 * 128 + var13 + var10];
                           }

                           if(var12 - (var21 + 1) >= 0) {
                              var11 -= MessageNode.field860[var13 + var10 - (var21 + 1) * 128];
                           }

                           if(var12 >= 0) {
                              class36.field509[var10 + var13] = var11 / (var21 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = var10 * 128;

                  for(var13 = -var21; var13 < 128; ++var13) {
                     if(var13 + var21 < 128) {
                        var11 += class36.field509[var13 + var12 + var21];
                     }

                     if(var13 - (var21 + 1) >= 0) {
                        var11 -= class36.field509[var13 + var12 - (var21 + 1)];
                     }

                     if(var13 >= 0) {
                        MessageNode.field860[var12 + var13] = var11 / (var21 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class92.field1451 = 0;
         }

         var17 = 256;
         if(class92.field1437 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class92.field1437 > 768) {
                  DecorativeObject.field2184[var5] = class83.method1651(class51.field641[var5], class158.field2274[var5], 1024 - class92.field1437);
               } else if(class92.field1437 > 256) {
                  DecorativeObject.field2184[var5] = class158.field2274[var5];
               } else {
                  DecorativeObject.field2184[var5] = class83.method1651(class158.field2274[var5], class51.field641[var5], 256 - class92.field1437);
               }
            }
         } else if(class92.field1427 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class92.field1427 > 768) {
                  DecorativeObject.field2184[var5] = class83.method1651(class51.field641[var5], class41.field563[var5], 1024 - class92.field1427);
               } else if(class92.field1427 > 256) {
                  DecorativeObject.field2184[var5] = class41.field563[var5];
               } else {
                  DecorativeObject.field2184[var5] = class83.method1651(class41.field563[var5], class51.field641[var5], 256 - class92.field1427);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               DecorativeObject.field2184[var5] = class51.field641[var5];
            }
         }

         Rasterizer2D.method4961(class92.field1417, 9, class92.field1417 + 128, var17 + 7);
         class92.field1420.method5164(class92.field1417, 0);
         Rasterizer2D.method4960();
         var5 = 0;
         var23 = class47.field601.width * 9 + class92.field1417;

         int var14;
         for(var7 = 1; var7 < var17 - 1; ++var7) {
            var20 = class92.field1425[var7] * (var17 - var7) / var17;
            var21 = var20 + 22;
            if(var21 < 0) {
               var21 = 0;
            }

            var5 += var21;

            for(var10 = var21; var10 < 128; ++var10) {
               var11 = class36.field509[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = DecorativeObject.field2184[var11];
                  var14 = class47.field601.pixels[var23];
                  class47.field601.pixels[var23++] = (var12 * (var11 & '\uff00') + var13 * (var14 & '\uff00') & 16711680) + ((var14 & 16711935) * var13 + (var11 & 16711935) * var12 & -16711936) >> 8;
               } else {
                  ++var23;
               }
            }

            var23 += class47.field601.width + var21 - 128;
         }

         Rasterizer2D.method4961(class92.field1417 + 765 - 128, 9, class92.field1417 + 765, var17 + 7);
         class92.field1421.method5164(class92.field1417 + 382, 0);
         Rasterizer2D.method4960();
         var5 = 0;
         var23 = class47.field601.width * 9 + 24 + 637 + class92.field1417;

         for(var7 = 1; var7 < var17 - 1; ++var7) {
            var20 = class92.field1425[var7] * (var17 - var7) / var17;
            var21 = 103 - var20;
            var23 += var20;

            for(var10 = 0; var10 < var21; ++var10) {
               var11 = class36.field509[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = DecorativeObject.field2184[var11];
                  var14 = class47.field601.pixels[var23];
                  class47.field601.pixels[var23++] = ((var11 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) + (var13 * (var14 & '\uff00') + (var11 & '\uff00') * var12 & 16711680) >> 8;
               } else {
                  ++var23;
               }
            }

            var5 += 128 - var21;
            var23 += class47.field601.width - var21 - var20;
         }

         class177.field2426[class66.field801.field1316?1:0].method5066(class92.field1417 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field919 == 0) {
            if(class69.field836 != null) {
               var18 = class92.field1417 + 5;
               var19 = 463;
               byte var24 = 100;
               byte var22 = 35;
               class69.field836.method5066(var18, var19);
               var0.method4825("World" + " " + Client.world, var18 + var24 / 2, var22 / 2 + var19 - 2, 16777215, 0);
               if(class64.worldServersDownload != null) {
                  var1.method4825("Loading...", var18 + var24 / 2, var22 / 2 + var19 + 12, 16777215, 0);
               } else {
                  var1.method4825("Click to switch", var24 / 2 + var18, var19 + var22 / 2 + 12, 16777215, 0);
               }
            } else {
               class69.field836 = class151.method2928(Client.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1333333283"
   )
   static char method10(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }
}
