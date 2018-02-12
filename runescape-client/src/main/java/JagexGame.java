import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("JagexGame")
public enum JagexGame implements Enumerated {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3288("runescape", "RuneScape", 0),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3283("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3284("game3", "Game 3", 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3289("game4", "Game 4", 3),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3287("game5", "Game 5", 4),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3282("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("t")
   @Export("name")
   public final String name;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2095693251
   )
   @Export("id")
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "744101166"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;Lkp;ZI)V",
      garbageValue = "-1623306231"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class89.field1356 = (GameEngine.canvasWidth - 765) / 2;
         class89.loginWindowX = class89.field1356 + 202;
         class89.field1323 = class89.loginWindowX + 180;
      }

      if(class89.worldSelectShown) {
         class46.method675(var0, var1);
      } else {
         if(var3) {
            UnitPriceComparator.field307.method5682(class89.field1356, 0);
            class37.field483.method5682(class89.field1356 + 382, 0);
            class137.logoSprite.method5653(class89.field1356 + 382 - class137.logoSprite.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.drawTextCentered("RuneScape is loading - please wait...", class89.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class89.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class89.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(class89.loginWindowX + 180 - 150, var5 + 2, class89.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(class89.loginWindowX + 180 - 150 + class89.loadingBarPercentage * 3, var5 + 2, 300 - class89.loadingBarPercentage * 3, 30, 0);
            var0.drawTextCentered(class89.loadingText, class89.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         String var7;
         short var18;
         int var19;
         short var20;
         if(Client.gameState == 20) {
            AbstractByteBuffer.field2531.method5653(class89.loginWindowX + 180 - AbstractByteBuffer.field2531.originalWidth / 2, 271 - AbstractByteBuffer.field2531.height / 2);
            var18 = 201;
            var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var18, 16776960, 0);
            var19 = var18 + 15;
            var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var19, 16776960, 0);
            var19 += 15;
            var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var19, 16776960, 0);
            var19 += 15;
            var19 += 7;
            if(class89.loginIndex != 4) {
               var0.method5384("Login: ", class89.loginWindowX + 180 - 110, var19, 16777215, 0);
               var20 = 200;
               var6 = WorldComparator.preferences.hideUsername?class167.method3394(class89.username):class89.username;

               for(var7 = var6; var0.getTextWidth(var7) > var20; var7 = var7.substring(0, var7.length() - 1)) {
                  ;
               }

               var0.method5384(FontTypeFace.appendTags(var7), class89.loginWindowX + 180 - 70, var19, 16777215, 0);
               var19 += 15;
               var0.method5384("Password: " + class167.method3394(class89.password), class89.loginWindowX + 180 - 108, var19, 16777215, 0);
               var19 += 15;
            }
         }

         int var8;
         int var10;
         int var24;
         if(Client.gameState == 10 || Client.gameState == 11) {
            AbstractByteBuffer.field2531.method5653(class89.loginWindowX, 171);
            short var15;
            if(class89.loginIndex == 0) {
               var18 = 251;
               var0.drawTextCentered("Welcome to RuneScape", class89.loginWindowX + 180, var18, 16776960, 0);
               var19 = var18 + 30;
               var5 = class89.loginWindowX + 180 - 80;
               var15 = 291;
               class89.field1319.method5653(var5 - 73, var15 - 20);
               var0.method5376("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class89.loginWindowX + 180 + 80;
               class89.field1319.method5653(var5 - 73, var15 - 20);
               var0.method5376("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class89.loginIndex == 1) {
               var0.drawTextCentered(class89.Login_response0, class89.loginWindowX + 180, 201, 16776960, 0);
               var18 = 236;
               var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var18, 16777215, 0);
               var19 = var18 + 15;
               var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var19, 16777215, 0);
               var19 += 15;
               var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var19, 16777215, 0);
               var19 += 15;
               var5 = class89.loginWindowX + 180 - 80;
               var15 = 321;
               class89.field1319.method5653(var5 - 73, var15 - 20);
               var0.drawTextCentered("Continue", var5, var15 + 5, 16777215, 0);
               var5 = class89.loginWindowX + 180 + 80;
               class89.field1319.method5653(var5 - 73, var15 - 20);
               var0.drawTextCentered("Cancel", var5, var15 + 5, 16777215, 0);
            } else if(class89.loginIndex == 2) {
               var18 = 201;
               var0.drawTextCentered(class89.loginMessage1, class89.field1323, var18, 16776960, 0);
               var19 = var18 + 15;
               var0.drawTextCentered(class89.loginMessage2, class89.field1323, var19, 16776960, 0);
               var19 += 15;
               var0.drawTextCentered(class89.loginMessage3, class89.field1323, var19, 16776960, 0);
               var19 += 15;
               var19 += 7;
               var0.method5384("Login: ", class89.field1323 - 110, var19, 16777215, 0);
               var20 = 200;
               var6 = WorldComparator.preferences.hideUsername?class167.method3394(class89.username):class89.username;

               for(var7 = var6; var0.getTextWidth(var7) > var20; var7 = var7.substring(1)) {
                  ;
               }

               var0.method5384(FontTypeFace.appendTags(var7) + (class89.field1317 == 0 & Client.gameCycle % 40 < 20?class70.getColTags(16776960) + "|":""), class89.field1323 - 70, var19, 16777215, 0);
               var19 += 15;
               var0.method5384("Password: " + class167.method3394(class89.password) + (class89.field1317 == 1 & Client.gameCycle % 40 < 20?class70.getColTags(16776960) + "|":""), class89.field1323 - 108, var19, 16777215, 0);
               var19 += 15;
               var18 = 277;
               var8 = class89.field1323 + -117;
               IndexedSprite var17 = WidgetNode.method1062(class89.Login_isUsernameRemembered, class89.field1344);
               var17.method5653(var8, var18);
               var8 = var8 + var17.originalWidth + 5;
               var1.method5384("Remember username", var8, var18 + 13, 16776960, 0);
               var8 = class89.field1323 + 24;
               var17 = WidgetNode.method1062(WorldComparator.preferences.hideUsername, class89.field1345);
               var17.method5653(var8, var18);
               var8 = var8 + var17.originalWidth + 5;
               var1.method5384("Hide username", var8, var18 + 13, 16776960, 0);
               var19 = var18 + 15;
               var10 = class89.field1323 - 80;
               short var11 = 321;
               class89.field1319.method5653(var10 - 73, var11 - 20);
               var0.drawTextCentered("Login", var10, var11 + 5, 16777215, 0);
               var10 = class89.field1323 + 80;
               class89.field1319.method5653(var10 - 73, var11 - 20);
               var0.drawTextCentered("Cancel", var10, var11 + 5, 16777215, 0);
               var18 = 357;
               var1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", class89.field1323, var18, 16776960, 0);
            } else if(class89.loginIndex == 3) {
               var18 = 201;
               var0.drawTextCentered("Invalid username or password.", class89.loginWindowX + 180, var18, 16776960, 0);
               var19 = var18 + 20;
               var1.drawTextCentered("For accounts created after 24th November 2010, please use your", class89.loginWindowX + 180, var19, 16776960, 0);
               var19 += 15;
               var1.drawTextCentered("email address to login. Otherwise please login with your username.", class89.loginWindowX + 180, var19, 16776960, 0);
               var19 += 15;
               var5 = class89.loginWindowX + 180;
               var15 = 276;
               class89.field1319.method5653(var5 - 73, var15 - 20);
               var2.drawTextCentered("Try again", var5, var15 + 5, 16777215, 0);
               var5 = class89.loginWindowX + 180;
               var15 = 326;
               class89.field1319.method5653(var5 - 73, var15 - 20);
               var2.drawTextCentered("Forgotten password?", var5, var15 + 5, 16777215, 0);
            } else {
               short var9;
               if(class89.loginIndex == 4) {
                  var0.drawTextCentered("Authenticator", class89.loginWindowX + 180, 201, 16776960, 0);
                  var18 = 236;
                  var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var18, 16777215, 0);
                  var19 = var18 + 15;
                  var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var19, 16777215, 0);
                  var19 += 15;
                  var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var19, 16777215, 0);
                  var19 += 15;
                  var0.method5384("PIN: " + class167.method3394(class27.field376) + (Client.gameCycle % 40 < 20?class70.getColTags(16776960) + "|":""), class89.loginWindowX + 180 - 108, var19, 16777215, 0);
                  var19 -= 8;
                  var0.method5384("Trust this computer", class89.loginWindowX + 180 - 9, var19, 16776960, 0);
                  var19 += 15;
                  var0.method5384("for 30 days: ", class89.loginWindowX + 180 - 9, var19, 16776960, 0);
                  var5 = class89.loginWindowX + 180 - 9 + var0.getTextWidth("for 30 days: ") + 15;
                  var24 = var19 - var0.verticalSpace;
                  IndexedSprite var21;
                  if(class89.field1346) {
                     var21 = class89.field1321;
                  } else {
                     var21 = Size.field350;
                  }

                  var21.method5653(var5, var24);
                  var19 += 15;
                  var8 = class89.loginWindowX + 180 - 80;
                  var9 = 321;
                  class89.field1319.method5653(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Continue", var8, var9 + 5, 16777215, 0);
                  var8 = class89.loginWindowX + 180 + 80;
                  class89.field1319.method5653(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Cancel", var8, var9 + 5, 16777215, 0);
                  var1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class89.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class89.loginIndex == 5) {
                  var0.drawTextCentered("Forgotten your password?", class89.loginWindowX + 180, 201, 16776960, 0);
                  var18 = 221;
                  var2.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var18, 16776960, 0);
                  var19 = var18 + 15;
                  var2.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var19, 16776960, 0);
                  var19 += 15;
                  var2.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var19, 16776960, 0);
                  var19 += 15;
                  var19 += 14;
                  var0.method5384("Username/email: ", class89.loginWindowX + 180 - 145, var19, 16777215, 0);
                  var20 = 174;
                  var6 = WorldComparator.preferences.hideUsername?class167.method3394(class89.username):class89.username;

                  for(var7 = var6; var0.getTextWidth(var7) > var20; var7 = var7.substring(1)) {
                     ;
                  }

                  var0.method5384(FontTypeFace.appendTags(var7) + (Client.gameCycle % 40 < 20?class70.getColTags(16776960) + "|":""), class89.loginWindowX + 180 - 34, var19, 16777215, 0);
                  var19 += 15;
                  var8 = class89.loginWindowX + 180 - 80;
                  var9 = 321;
                  class89.field1319.method5653(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Recover", var8, var9 + 5, 16777215, 0);
                  var8 = class89.loginWindowX + 180 + 80;
                  class89.field1319.method5653(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Back", var8, var9 + 5, 16777215, 0);
               } else if(class89.loginIndex == 6) {
                  var18 = 201;
                  var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var18, 16776960, 0);
                  var19 = var18 + 15;
                  var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var19, 16776960, 0);
                  var19 += 15;
                  var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var19, 16776960, 0);
                  var19 += 15;
                  var5 = class89.loginWindowX + 180;
                  var15 = 321;
                  class89.field1319.method5653(var5 - 73, var15 - 20);
                  var0.drawTextCentered("Back", var5, var15 + 5, 16777215, 0);
               }
            }
         }

         if(class89.field1331 > 0) {
            class89.method1941(class89.field1331);
            class89.field1331 = 0;
         }

         var18 = 256;
         if(class89.field1327 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class89.field1327 > 768) {
                  class5.field29[var5] = method4494(KeyFocusListener.field623[var5], class89.field1326[var5], 1024 - class89.field1327);
               } else if(class89.field1327 > 256) {
                  class5.field29[var5] = class89.field1326[var5];
               } else {
                  class5.field29[var5] = method4494(class89.field1326[var5], KeyFocusListener.field623[var5], 256 - class89.field1327);
               }
            }
         } else if(class89.field1355 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class89.field1355 > 768) {
                  class5.field29[var5] = method4494(KeyFocusListener.field623[var5], class80.field1251[var5], 1024 - class89.field1355);
               } else if(class89.field1355 > 256) {
                  class5.field29[var5] = class80.field1251[var5];
               } else {
                  class5.field29[var5] = method4494(class80.field1251[var5], KeyFocusListener.field623[var5], 256 - class89.field1355);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class5.field29[var5] = KeyFocusListener.field623[var5];
            }
         }

         Rasterizer2D.setDrawRegion(class89.field1356, 9, class89.field1356 + 128, var18 + 7);
         UnitPriceComparator.field307.method5682(class89.field1356, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var24 = class22.rasterProvider.width * 9 + class89.field1356;

         int var12;
         int var13;
         int var14;
         int var16;
         int var22;
         int var23;
         for(var16 = 1; var16 < var18 - 1; ++var16) {
            var8 = class89.field1325[var16] * (var18 - var16) / var18;
            var22 = var8 + 22;
            if(var22 < 0) {
               var22 = 0;
            }

            var5 += var22;

            for(var10 = var22; var10 < 128; ++var10) {
               var23 = OwnWorldComparator.field838[var5++];
               if(var23 != 0) {
                  var12 = var23;
                  var13 = 256 - var23;
                  var23 = class5.field29[var23];
                  var14 = class22.rasterProvider.pixels[var24];
                  class22.rasterProvider.pixels[var24++] = (var13 * (var14 & 65280) + var12 * (var23 & 65280) & 16711680) + ((var23 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) >> 8;
               } else {
                  ++var24;
               }
            }

            var24 += var22 + class22.rasterProvider.width - 128;
         }

         Rasterizer2D.setDrawRegion(class89.field1356 + 765 - 128, 9, class89.field1356 + 765, var18 + 7);
         class37.field483.method5682(class89.field1356 + 382, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var24 = class22.rasterProvider.width * 9 + class89.field1356 + 637 + 24;

         for(var16 = 1; var16 < var18 - 1; ++var16) {
            var8 = class89.field1325[var16] * (var18 - var16) / var18;
            var22 = 103 - var8;
            var24 += var8;

            for(var10 = 0; var10 < var22; ++var10) {
               var23 = OwnWorldComparator.field838[var5++];
               if(var23 != 0) {
                  var12 = var23;
                  var13 = 256 - var23;
                  var23 = class5.field29[var23];
                  var14 = class22.rasterProvider.pixels[var24];
                  class22.rasterProvider.pixels[var24++] = ((var14 & 16711935) * var13 + (var23 & 16711935) * var12 & -16711936) + (var13 * (var14 & 65280) + var12 * (var23 & 65280) & 16711680) >> 8;
               } else {
                  ++var24;
               }
            }

            var5 += 128 - var22;
            var24 += class22.rasterProvider.width - var22 - var8;
         }

         class35.titlemuteSprite[WorldComparator.preferences.muted?1:0].method5653(class89.field1356 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(VertexNormal.field1889 != null) {
               var19 = class89.field1356 + 5;
               var20 = 463;
               byte var26 = 100;
               byte var25 = 35;
               VertexNormal.field1889.method5653(var19, var20);
               var0.drawTextCentered("World" + " " + Client.world, var26 / 2 + var19, var25 / 2 + var20 - 2, 16777215, 0);
               if(class161.listFetcher != null) {
                  var1.drawTextCentered("Loading...", var26 / 2 + var19, var25 / 2 + var20 + 12, 16777215, 0);
               } else {
                  var1.drawTextCentered("Click to switch", var26 / 2 + var19, var25 / 2 + var20 + 12, 16777215, 0);
               }
            } else {
               VertexNormal.field1889 = class163.getSprite(class37.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "122"
   )
   static final int method4494(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) + ((var1 & 65280) * var2 + (var0 & 65280) * var3 & 16711680) >> 8;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1765744935"
   )
   public static void method4492() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(Lby;IIB)V",
      garbageValue = "-39"
   )
   static void method4497(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = FileRequest.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1140 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1150 = 0;
         }

         if(var3 == 2) {
            var0.field1150 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || FileRequest.getAnimation(var1).forcedPriority >= FileRequest.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1140 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1150 = 0;
         var0.field1161 = var0.queueSize;
      }

   }
}
