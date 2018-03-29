import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class21 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   @Export("soundTaskDataProvider")
   public static class101 soundTaskDataProvider;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkw;Lkw;Lkw;ZI)V",
      garbageValue = "-1272858986"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class90.field1338 = (Sequence.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1338 + 202;
         GameCanvas.field630 = class90.loginWindowX + 180;
      }

      if(class90.worldSelectShown) {
         class88.method1852(var0, var1);
      } else {
         if(var3) {
            class317.field3926.method5868(class90.field1338, 0);
            class61.field715.method5868(class90.field1338 + 382, 0);
            class90.logoSprite.method5842(class90.field1338 + 382 - class90.logoSprite.width / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.drawTextCentered("RuneScape is loading - please wait...", class90.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(class90.loginWindowX + 180 - 150, var5 + 2, class90.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(class90.loginWindowX + 180 - 150 + class90.loadingBarPercentage * 3, var5 + 2, 300 - class90.loadingBarPercentage * 3, 30, 0);
            var0.drawTextCentered(class90.loadingText, class90.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         String var7;
         String var9;
         String var10;
         String var11;
         short var20;
         int var21;
         short var22;
         if(Client.gameState == 20) {
            class90.field1339.method5842(class90.loginWindowX + 180 - class90.field1339.width / 2, 271 - class90.field1339.height / 2);
            var20 = 201;
            var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var20, 16776960, 0);
            var21 = var20 + 15;
            var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var21, 16776960, 0);
            var21 += 15;
            var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var21, 16776960, 0);
            var21 += 15;
            var21 += 7;
            if(class90.loginIndex != 4) {
               var0.method5521("Login: ", class90.loginWindowX + 180 - 110, var21, 16777215, 0);
               var22 = 200;
               var6 = class46.preferences.hideUsername?Client.method1580(class90.username):class90.username;

               for(var7 = var6; var0.getTextWidth(var7) > var22; var7 = var7.substring(0, var7.length() - 1)) {
                  ;
               }

               var0.method5521(FontTypeFace.appendTags(var7), class90.loginWindowX + 180 - 70, var21, 16777215, 0);
               var21 += 15;
               var9 = "Password: ";
               var11 = class90.password;
               var10 = class294.method5232('*', var11.length());
               var0.method5521(var9 + var10, class90.loginWindowX + 180 - 108, var21, 16777215, 0);
               var21 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class90.field1339.method5842(class90.loginWindowX, 171);
            short var16;
            if(class90.loginIndex == 0) {
               var20 = 251;
               var0.drawTextCentered("Welcome to RuneScape", class90.loginWindowX + 180, var20, 16776960, 0);
               var21 = var20 + 30;
               var5 = class90.loginWindowX + 180 - 80;
               var16 = 291;
               class203.field2605.method5842(var5 - 73, var16 - 20);
               var0.method5525("New User", var5 - 73, var16 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class203.field2605.method5842(var5 - 73, var16 - 20);
               var0.method5525("Existing User", var5 - 73, var16 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class90.loginIndex == 1) {
               var0.drawTextCentered(class90.Login_response0, class90.loginWindowX + 180, 201, 16776960, 0);
               var20 = 236;
               var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var20, 16777215, 0);
               var21 = var20 + 15;
               var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var21, 16777215, 0);
               var21 += 15;
               var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var21, 16777215, 0);
               var21 += 15;
               var5 = class90.loginWindowX + 180 - 80;
               var16 = 321;
               class203.field2605.method5842(var5 - 73, var16 - 20);
               var0.drawTextCentered("Continue", var5, var16 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class203.field2605.method5842(var5 - 73, var16 - 20);
               var0.drawTextCentered("Cancel", var5, var16 + 5, 16777215, 0);
            } else if(class90.loginIndex == 2) {
               var20 = 201;
               var0.drawTextCentered(class90.loginMessage1, GameCanvas.field630, var20, 16776960, 0);
               var21 = var20 + 15;
               var0.drawTextCentered(class90.loginMessage2, GameCanvas.field630, var21, 16776960, 0);
               var21 += 15;
               var0.drawTextCentered(class90.loginMessage3, GameCanvas.field630, var21, 16776960, 0);
               var21 += 15;
               var21 += 7;
               var0.method5521("Login: ", GameCanvas.field630 - 110, var21, 16777215, 0);
               var22 = 200;
               var6 = class46.preferences.hideUsername?Client.method1580(class90.username):class90.username;

               for(var7 = var6; var0.getTextWidth(var7) > var22; var7 = var7.substring(1)) {
                  ;
               }

               var0.method5521(FontTypeFace.appendTags(var7) + (class90.field1367 == 0 & Client.gameCycle % 40 < 20?class173.getColTags(16776960) + "|":""), GameCanvas.field630 - 70, var21, 16777215, 0);
               var21 += 15;
               var9 = "Password: ";
               var11 = class90.password;
               var10 = class294.method5232('*', var11.length());
               var0.method5521(var9 + var10 + (class90.field1367 == 1 & Client.gameCycle % 40 < 20?class173.getColTags(16776960) + "|":""), GameCanvas.field630 - 108, var21, 16777215, 0);
               var21 += 15;
               var20 = 277;
               int var12 = GameCanvas.field630 + -117;
               IndexedSprite var13 = FontName.method5499(class90.Login_isUsernameRemembered, class90.field1364);
               var13.method5842(var12, var20);
               var12 = var12 + var13.width + 5;
               var1.method5521("Remember username", var12, var20 + 13, 16776960, 0);
               var12 = GameCanvas.field630 + 24;
               var13 = FontName.method5499(class46.preferences.hideUsername, class90.field1340);
               var13.method5842(var12, var20);
               var12 = var12 + var13.width + 5;
               var1.method5521("Hide username", var12, var20 + 13, 16776960, 0);
               var21 = var20 + 15;
               int var14 = GameCanvas.field630 - 80;
               short var15 = 321;
               class203.field2605.method5842(var14 - 73, var15 - 20);
               var0.drawTextCentered("Login", var14, var15 + 5, 16777215, 0);
               var14 = GameCanvas.field630 + 80;
               class203.field2605.method5842(var14 - 73, var15 - 20);
               var0.drawTextCentered("Cancel", var14, var15 + 5, 16777215, 0);
               var20 = 357;
               var1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", GameCanvas.field630, var20, 16776960, 0);
            } else if(class90.loginIndex == 3) {
               var20 = 201;
               var0.drawTextCentered("Invalid username or password.", class90.loginWindowX + 180, var20, 16776960, 0);
               var21 = var20 + 20;
               var1.drawTextCentered("For accounts created after 24th November 2010, please use your", class90.loginWindowX + 180, var21, 16776960, 0);
               var21 += 15;
               var1.drawTextCentered("email address to login. Otherwise please login with your username.", class90.loginWindowX + 180, var21, 16776960, 0);
               var21 += 15;
               var5 = class90.loginWindowX + 180;
               var16 = 276;
               class203.field2605.method5842(var5 - 73, var16 - 20);
               var2.drawTextCentered("Try again", var5, var16 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180;
               var16 = 326;
               class203.field2605.method5842(var5 - 73, var16 - 20);
               var2.drawTextCentered("Forgotten password?", var5, var16 + 5, 16777215, 0);
            } else {
               int var18;
               short var19;
               if(class90.loginIndex == 4) {
                  var0.drawTextCentered("Authenticator", class90.loginWindowX + 180, 201, 16776960, 0);
                  var20 = 236;
                  var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var20, 16777215, 0);
                  var21 = var20 + 15;
                  var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var21, 16777215, 0);
                  var21 += 15;
                  var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var21, 16777215, 0);
                  var21 += 15;
                  var0.method5521("PIN: " + Client.method1580(MapCacheArchiveNames.field520) + (Client.gameCycle % 40 < 20?class173.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 108, var21, 16777215, 0);
                  var21 -= 8;
                  var0.method5521("Trust this computer", class90.loginWindowX + 180 - 9, var21, 16776960, 0);
                  var21 += 15;
                  var0.method5521("for 30 days: ", class90.loginWindowX + 180 - 9, var21, 16776960, 0);
                  var5 = class90.loginWindowX + 180 - 9 + var0.getTextWidth("for 30 days: ") + 15;
                  int var24 = var21 - var0.verticalSpace;
                  IndexedSprite var23;
                  if(class90.field1344) {
                     var23 = class151.field2127;
                  } else {
                     var23 = TextureProvider.field1691;
                  }

                  var23.method5842(var5, var24);
                  var21 += 15;
                  var18 = class90.loginWindowX + 180 - 80;
                  var19 = 321;
                  class203.field2605.method5842(var18 - 73, var19 - 20);
                  var0.drawTextCentered("Continue", var18, var19 + 5, 16777215, 0);
                  var18 = class90.loginWindowX + 180 + 80;
                  class203.field2605.method5842(var18 - 73, var19 - 20);
                  var0.drawTextCentered("Cancel", var18, var19 + 5, 16777215, 0);
                  var1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class90.loginWindowX + 180, var19 + 36, 255, 0);
               } else if(class90.loginIndex == 5) {
                  var0.drawTextCentered("Forgotten your password?", class90.loginWindowX + 180, 201, 16776960, 0);
                  var20 = 221;
                  var2.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var20, 16776960, 0);
                  var21 = var20 + 15;
                  var2.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var21, 16776960, 0);
                  var21 += 15;
                  var2.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var21, 16776960, 0);
                  var21 += 15;
                  var21 += 14;
                  var0.method5521("Username/email: ", class90.loginWindowX + 180 - 145, var21, 16777215, 0);
                  var22 = 174;
                  if(class46.preferences.hideUsername) {
                     var9 = class90.username;
                     String var8 = class294.method5232('*', var9.length());
                     var7 = var8;
                  } else {
                     var7 = class90.username;
                  }

                  for(var7 = var7; var0.getTextWidth(var7) > var22; var7 = var7.substring(1)) {
                     ;
                  }

                  var0.method5521(FontTypeFace.appendTags(var7) + (Client.gameCycle % 40 < 20?class173.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 34, var21, 16777215, 0);
                  var21 += 15;
                  var18 = class90.loginWindowX + 180 - 80;
                  var19 = 321;
                  class203.field2605.method5842(var18 - 73, var19 - 20);
                  var0.drawTextCentered("Recover", var18, var19 + 5, 16777215, 0);
                  var18 = class90.loginWindowX + 180 + 80;
                  class203.field2605.method5842(var18 - 73, var19 - 20);
                  var0.drawTextCentered("Back", var18, var19 + 5, 16777215, 0);
               } else if(class90.loginIndex == 6) {
                  var20 = 201;
                  var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var20, 16776960, 0);
                  var21 = var20 + 15;
                  var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var21, 16776960, 0);
                  var21 += 15;
                  var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var21, 16776960, 0);
                  var21 += 15;
                  var5 = class90.loginWindowX + 180;
                  var16 = 321;
                  class203.field2605.method5842(var5 - 73, var16 - 20);
                  var0.drawTextCentered("Back", var5, var16 + 5, 16777215, 0);
               }
            }
         }

         if(class90.field1351 > 0) {
            class197.method3754(class90.field1351);
            class90.field1351 = 0;
         }

         class151.method3140();
         class38.titlemuteSprite[class46.preferences.muted?1:0].method5842(class90.field1338 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(Sequence.field3764 != null) {
               var21 = class90.field1338 + 5;
               var22 = 463;
               byte var25 = 100;
               byte var17 = 35;
               Sequence.field3764.method5842(var21, var22);
               var0.drawTextCentered("World" + " " + Client.world, var25 / 2 + var21, var17 / 2 + var22 - 2, 16777215, 0);
               if(listFetcher != null) {
                  var1.drawTextCentered("Loading...", var25 / 2 + var21, var17 / 2 + var22 + 12, 16777215, 0);
               } else {
                  var1.drawTextCentered("Click to switch", var25 / 2 + var21, var17 / 2 + var22 + 12, 16777215, 0);
               }
            } else {
               Sequence.field3764 = class44.getSprite(class44.indexSprites, "sl_button", "");
            }
         }

      }
   }
}
