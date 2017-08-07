import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class3 implements class0 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljk;Ljk;ZI)V",
      garbageValue = "-1527623590"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class93.field1424 = (NPC.canvasWidth - 765) / 2;
         class93.loginWindowX = class93.field1424 + 202;
      }

      if(class93.worldSelectShown) {
         Player.method1169(var0, var1);
      } else {
         if(var3) {
            class93.field1419.method5098(class93.field1424, 0);
            class83.field1322.method5098(class93.field1424 + 382, 0);
            Ignore.logoSprite.method5068(class93.field1424 + 382 - Ignore.logoSprite.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4779("RuneScape is loading - please wait...", class93.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class93.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class93.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4973(class93.loginWindowX + 180 - 150, var5 + 2, class93.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method4973(class93.loginWindowX + 180 - 150 + class93.loadingBarPercentage * 3, var5 + 2, 300 - class93.loadingBarPercentage * 3, 30, 0);
            var0.method4779(class93.loadingText, class93.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var16;
         int var17;
         short var18;
         if(Client.gameState == 20) {
            class93.field1420.method5068(class93.loginWindowX + 180 - class93.field1420.originalWidth / 2, 271 - class93.field1420.height / 2);
            var16 = 211;
            var0.method4779(class93.loginMessage1, class93.loginWindowX + 180, var16, 16776960, 0);
            var17 = var16 + 15;
            var0.method4779(class93.loginMessage2, class93.loginWindowX + 180, var17, 16776960, 0);
            var17 += 15;
            var0.method4779(class93.loginMessage3, class93.loginWindowX + 180, var17, 16776960, 0);
            var17 += 15;
            var17 += 10;
            if(class93.loginIndex != 4) {
               var0.method4776("Login: ", class93.loginWindowX + 180 - 110, var17, 16777215, 0);
               var18 = 200;

               for(var6 = class93.username; var0.method4771(var6) > var18; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4776(FontTypeFace.appendTags(var6), class93.loginWindowX + 180 - 70, var17, 16777215, 0);
               var17 += 15;
               var0.method4776("Password: " + Huffman.method3110(class93.password), class93.loginWindowX + 180 - 108, var17, 16777215, 0);
               var17 += 15;
            }
         }

         int var7;
         int var19;
         int var22;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class93.field1420.method5068(class93.loginWindowX, 171);
            short var14;
            if(class93.loginIndex == 0) {
               var16 = 251;
               var0.method4779("Welcome to RuneScape", class93.loginWindowX + 180, var16, 16776960, 0);
               var17 = var16 + 30;
               var5 = class93.loginWindowX + 180 - 80;
               var14 = 291;
               class93.field1421.method5068(var5 - 73, var14 - 20);
               var0.method4780("New User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class93.loginWindowX + 180 + 80;
               class93.field1421.method5068(var5 - 73, var14 - 20);
               var0.method4780("Existing User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class93.loginIndex == 1) {
               var0.method4779(class93.field1448, class93.loginWindowX + 180, 211, 16776960, 0);
               var16 = 236;
               var0.method4779(class93.loginMessage1, class93.loginWindowX + 180, var16, 16777215, 0);
               var17 = var16 + 15;
               var0.method4779(class93.loginMessage2, class93.loginWindowX + 180, var17, 16777215, 0);
               var17 += 15;
               var0.method4779(class93.loginMessage3, class93.loginWindowX + 180, var17, 16777215, 0);
               var17 += 15;
               var5 = class93.loginWindowX + 180 - 80;
               var14 = 321;
               class93.field1421.method5068(var5 - 73, var14 - 20);
               var0.method4779("Continue", var5, var14 + 5, 16777215, 0);
               var5 = class93.loginWindowX + 180 + 80;
               class93.field1421.method5068(var5 - 73, var14 - 20);
               var0.method4779("Cancel", var5, var14 + 5, 16777215, 0);
            } else {
               short var8;
               if(class93.loginIndex == 2) {
                  var16 = 211;
                  var0.method4779(class93.loginMessage1, class93.loginWindowX + 180, var16, 16776960, 0);
                  var17 = var16 + 15;
                  var0.method4779(class93.loginMessage2, class93.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var0.method4779(class93.loginMessage3, class93.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var17 += 10;
                  var0.method4776("Login: ", class93.loginWindowX + 180 - 110, var17, 16777215, 0);
                  var18 = 200;

                  for(var6 = class93.username; var0.method4771(var6) > var18; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4776(FontTypeFace.appendTags(var6) + (class93.loginIndex2 == 0 & Client.gameCycle % 40 < 20?RSSocket.getColTags(16776960) + "|":""), class93.loginWindowX + 180 - 70, var17, 16777215, 0);
                  var17 += 15;
                  var0.method4776("Password: " + Huffman.method3110(class93.password) + (class93.loginIndex2 == 1 & Client.gameCycle % 40 < 20?RSSocket.getColTags(16776960) + "|":""), class93.loginWindowX + 180 - 108, var17, 16777215, 0);
                  var17 += 15;
                  var7 = class93.loginWindowX + 180 - 80;
                  var8 = 321;
                  class93.field1421.method5068(var7 - 73, var8 - 20);
                  var0.method4779("Login", var7, var8 + 5, 16777215, 0);
                  var7 = class93.loginWindowX + 180 + 80;
                  class93.field1421.method5068(var7 - 73, var8 - 20);
                  var0.method4779("Cancel", var7, var8 + 5, 16777215, 0);
                  var16 = 357;
                  var1.method4779("Forgotten your password? <col=ffffff>Click here.", class93.loginWindowX + 180, var16, 16776960, 0);
               } else if(class93.loginIndex == 3) {
                  var16 = 201;
                  var0.method4779("Invalid username or password.", class93.loginWindowX + 180, var16, 16776960, 0);
                  var17 = var16 + 20;
                  var1.method4779("For accounts created after 24th November 2010, please use your", class93.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var1.method4779("email address to login. Otherwise please login with your username.", class93.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var5 = class93.loginWindowX + 180;
                  var14 = 276;
                  class93.field1421.method5068(var5 - 73, var14 - 20);
                  var2.method4779("Try again", var5, var14 + 5, 16777215, 0);
                  var5 = class93.loginWindowX + 180;
                  var14 = 326;
                  class93.field1421.method5068(var5 - 73, var14 - 20);
                  var2.method4779("Forgotten password?", var5, var14 + 5, 16777215, 0);
               } else if(class93.loginIndex == 4) {
                  var0.method4779("Authenticator", class93.loginWindowX + 180, 211, 16776960, 0);
                  var16 = 236;
                  var0.method4779(class93.loginMessage1, class93.loginWindowX + 180, var16, 16777215, 0);
                  var17 = var16 + 15;
                  var0.method4779(class93.loginMessage2, class93.loginWindowX + 180, var17, 16777215, 0);
                  var17 += 15;
                  var0.method4779(class93.loginMessage3, class93.loginWindowX + 180, var17, 16777215, 0);
                  var17 += 15;
                  var0.method4776("PIN: " + Huffman.method3110(class47.authCode) + (Client.gameCycle % 40 < 20?RSSocket.getColTags(16776960) + "|":""), class93.loginWindowX + 180 - 108, var17, 16777215, 0);
                  var17 -= 8;
                  var0.method4776("Trust this computer", class93.loginWindowX + 180 - 9, var17, 16776960, 0);
                  var17 += 15;
                  var0.method4776("for 30 days: ", class93.loginWindowX + 180 - 9, var17, 16776960, 0);
                  var5 = class93.loginWindowX + 180 - 9 + var0.method4771("for 30 days: ") + 15;
                  var22 = var17 - var0.verticalSpace;
                  IndexedSprite var15;
                  if(class93.field1443) {
                     var15 = class83.field1324;
                  } else {
                     var15 = class203.field2476;
                  }

                  var15.method5068(var5, var22);
                  var17 += 15;
                  var19 = class93.loginWindowX + 180 - 80;
                  short var9 = 321;
                  class93.field1421.method5068(var19 - 73, var9 - 20);
                  var0.method4779("Continue", var19, var9 + 5, 16777215, 0);
                  var19 = class93.loginWindowX + 180 + 80;
                  class93.field1421.method5068(var19 - 73, var9 - 20);
                  var0.method4779("Cancel", var19, var9 + 5, 16777215, 0);
                  var1.method4779("<u=ff>Can\'t Log In?</u>", class93.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class93.loginIndex == 5) {
                  var0.method4779("Forgotten your password?", class93.loginWindowX + 180, 201, 16776960, 0);
                  var16 = 221;
                  var2.method4779(class93.loginMessage1, class93.loginWindowX + 180, var16, 16776960, 0);
                  var17 = var16 + 15;
                  var2.method4779(class93.loginMessage2, class93.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var2.method4779(class93.loginMessage3, class93.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var17 += 14;
                  var0.method4776("Username/email: ", class93.loginWindowX + 180 - 145, var17, 16777215, 0);
                  var18 = 174;

                  for(var6 = class93.username; var0.method4771(var6) > var18; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4776(FontTypeFace.appendTags(var6) + (Client.gameCycle % 40 < 20?RSSocket.getColTags(16776960) + "|":""), class93.loginWindowX + 180 - 34, var17, 16777215, 0);
                  var17 += 15;
                  var7 = class93.loginWindowX + 180 - 80;
                  var8 = 321;
                  class93.field1421.method5068(var7 - 73, var8 - 20);
                  var0.method4779("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = class93.loginWindowX + 180 + 80;
                  class93.field1421.method5068(var7 - 73, var8 - 20);
                  var0.method4779("Back", var7, var8 + 5, 16777215, 0);
               } else if(class93.loginIndex == 6) {
                  var16 = 211;
                  var0.method4779(class93.loginMessage1, class93.loginWindowX + 180, var16, 16776960, 0);
                  var17 = var16 + 15;
                  var0.method4779(class93.loginMessage2, class93.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var0.method4779(class93.loginMessage3, class93.loginWindowX + 180, var17, 16776960, 0);
                  var17 += 15;
                  var5 = class93.loginWindowX + 180;
                  var14 = 321;
                  class93.field1421.method5068(var5 - 73, var14 - 20);
                  var0.method4779("Back", var5, var14 + 5, 16777215, 0);
               }
            }
         }

         if(class93.field1426 > 0) {
            var17 = class93.field1426;
            var18 = 256;
            class93.field1429 += var17 * 128;
            if(class93.field1429 > class18.field316.length) {
               class93.field1429 -= class18.field316.length;
               var22 = (int)(Math.random() * 12.0D);
               Script.method1891(class46.field589[var22]);
            }

            var22 = 0;
            var7 = var17 * 128;
            var19 = (var18 - var17) * 128;

            int var10;
            int var21;
            for(var21 = 0; var21 < var19; ++var21) {
               var10 = ScriptEvent.field847[var22 + var7] - class18.field316[var22 + class93.field1429 & class18.field316.length - 1] * var17 / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               ScriptEvent.field847[var22++] = var10;
            }

            int var11;
            int var12;
            for(var21 = var18 - var17; var21 < var18; ++var21) {
               var10 = var21 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     ScriptEvent.field847[var11 + var10] = 255;
                  } else {
                     ScriptEvent.field847[var11 + var10] = 0;
                  }
               }
            }

            if(class93.field1427 > 0) {
               class93.field1427 -= var17 * 4;
            }

            if(class93.field1431 > 0) {
               class93.field1431 -= var17 * 4;
            }

            if(class93.field1427 == 0 && class93.field1431 == 0) {
               var21 = (int)(Math.random() * (double)(2000 / var17));
               if(var21 == 0) {
                  class93.field1427 = 1024;
               }

               if(var21 == 1) {
                  class93.field1431 = 1024;
               }
            }

            for(var21 = 0; var21 < var18 - var17; ++var21) {
               class93.field1425[var21] = class93.field1425[var21 + var17];
            }

            for(var21 = var18 - var17; var21 < var18; ++var21) {
               class93.field1425[var21] = (int)(Math.sin((double)class93.field1432 / 14.0D) * 16.0D + Math.sin((double)class93.field1432 / 15.0D) * 14.0D + Math.sin((double)class93.field1432 / 16.0D) * 12.0D);
               ++class93.field1432;
            }

            class93.field1430 += var17;
            var21 = (var17 + (Client.gameCycle & 1)) / 2;
            if(var21 > 0) {
               for(var10 = 0; var10 < class93.field1430 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  ScriptEvent.field847[var11 + (var12 << 7)] = 192;
               }

               class93.field1430 = 0;
               var10 = 0;

               label265:
               while(true) {
                  int var13;
                  if(var10 >= var18) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label265;
                        }

                        var11 = 0;

                        for(var12 = -var21; var12 < var18; ++var12) {
                           var13 = var12 * 128;
                           if(var21 + var12 < var18) {
                              var11 += class88.field1368[var10 + var13 + var21 * 128];
                           }

                           if(var12 - (var21 + 1) >= 0) {
                              var11 -= class88.field1368[var13 + var10 - 128 * (var21 + 1)];
                           }

                           if(var12 >= 0) {
                              ScriptEvent.field847[var13 + var10] = var11 / (var21 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = var10 * 128;

                  for(var13 = -var21; var13 < 128; ++var13) {
                     if(var13 + var21 < 128) {
                        var11 += ScriptEvent.field847[var21 + var12 + var13];
                     }

                     if(var13 - (var21 + 1) >= 0) {
                        var11 -= ScriptEvent.field847[var13 + var12 - (var21 + 1)];
                     }

                     if(var13 >= 0) {
                        class88.field1368[var13 + var12] = var11 / (var21 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class93.field1426 = 0;
         }

         CombatInfoListHolder.method1702();
         class93.titlemuteSprite[MilliTimer.preferences.muted?1:0].method5068(class93.field1424 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class19.field319 != null) {
               var17 = class93.field1424 + 5;
               var18 = 463;
               byte var23 = 100;
               byte var20 = 35;
               class19.field319.method5068(var17, var18);
               var0.method4779("World" + " " + Client.world, var23 / 2 + var17, var20 / 2 + var18 - 2, 16777215, 0);
               if(World.listFetcher != null) {
                  var1.method4779("Loading...", var23 / 2 + var17, var20 / 2 + var18 + 12, 16777215, 0);
               } else {
                  var1.method4779("Click to switch", var23 / 2 + var17, var20 / 2 + var18 + 12, 16777215, 0);
               }
            } else {
               class19.field319 = class117.getSprite(WorldMapType1.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "392043445"
   )
   static void method4() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3549(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3556()) {
         int var1 = var0.id;
         if(class10.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = Item.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class266.method4862(var4);
               if(var5 != null) {
                  class255.method4531(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-476909513"
   )
   static void method2(int var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(80);
      Client.secretPacketBuffer1.putLEInt(var1);
      Client.secretPacketBuffer1.putLEShortA(var0);
   }
}
