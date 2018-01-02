import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class43 {
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 240894555
   )
   int field532;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2132278471
   )
   int field540;
   @ObfuscatedName("e")
   int[][] field534;
   @ObfuscatedName("k")
   int[][] field535;
   @ObfuscatedName("u")
   int[][] field536;
   @ObfuscatedName("z")
   int[][] field537;

   class43(int var1, int var2) {
      this.field532 = var1;
      this.field540 = var2;
      this.field534 = new int[var1][var2];
      this.field535 = new int[var1][var2];
      this.field536 = new int[var1][var2];
      this.field537 = new int[var1][var2];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILih;I)V",
      garbageValue = "413316008"
   )
   void method610(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field532 && var2 - var3 <= this.field540) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field532, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field540, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field534[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field535[var9][var10] += var4.saturation;
                     this.field536[var9][var10] += var4.lightness;
                     ++this.field537[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1196036533"
   )
   int method612(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field532 && var2 < this.field540) {
         if(this.field536[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field534[var1][var2] / this.field537[var1][var2];
            int var4 = this.field535[var1][var2] / this.field537[var1][var2];
            int var5 = this.field536[var1][var2] / this.field537[var1][var2];
            return Script.method1842((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;Ljm;ZS)V",
      garbageValue = "-12288"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class91.field1351 = (Huffman.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1351 + 202;
         Preferences.field1217 = class91.loginWindowX + 180;
      }

      if(class91.worldSelectShown) {
         class160.method3048(var0, var1);
      } else {
         if(var3) {
            class91.field1315.method5203(class91.field1351, 0);
            class91.field1319.method5203(class91.field1351 + 382, 0);
            class91.logoSprite.method5176(class91.field1351 + 382 - class91.logoSprite.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4884("RuneScape is loading - please wait...", class91.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(class91.loginWindowX + 180 - 150, var5 + 2, class91.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(class91.loginWindowX + 180 - 150 + class91.loadingBarPercentage * 3, var5 + 2, 300 - class91.loadingBarPercentage * 3, 30, 0);
            var0.method4884(class91.loadingText, class91.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var14;
         int var15;
         short var16;
         if(Client.gameState == 20) {
            class91.field1316.method5176(class91.loginWindowX + 180 - class91.field1316.originalWidth / 2, 271 - class91.field1316.height / 2);
            var14 = 201;
            var0.method4884(class91.loginMessage1, class91.loginWindowX + 180, var14, 16776960, 0);
            var15 = var14 + 15;
            var0.method4884(class91.loginMessage2, class91.loginWindowX + 180, var15, 16776960, 0);
            var15 += 15;
            var0.method4884(class91.loginMessage3, class91.loginWindowX + 180, var15, 16776960, 0);
            var15 += 15;
            var15 += 7;
            if(class91.loginIndex != 4) {
               var0.method4891("Login: ", class91.loginWindowX + 180 - 110, var15, 16777215, 0);
               var16 = 200;

               for(var6 = class21.method151(); var0.method4886(var6) > var16; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4891(FontTypeFace.appendTags(var6), class91.loginWindowX + 180 - 70, var15, 16777215, 0);
               var15 += 15;
               var0.method4891("Password: " + UnitPriceComparator.method127(class91.password), class91.loginWindowX + 180 - 108, var15, 16777215, 0);
               var15 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class91.field1316.method5176(class91.loginWindowX, 171);
            short var11;
            if(class91.loginIndex == 0) {
               var14 = 251;
               var0.method4884("Welcome to RuneScape", class91.loginWindowX + 180, var14, 16776960, 0);
               var15 = var14 + 30;
               var5 = class91.loginWindowX + 180 - 80;
               var11 = 291;
               class91.field1317.method5176(var5 - 73, var11 - 20);
               var0.method4895("New User", var5 - 73, var11 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class91.field1317.method5176(var5 - 73, var11 - 20);
               var0.method4895("Existing User", var5 - 73, var11 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class91.loginIndex == 1) {
               var0.method4884(class91.Login_response0, class91.loginWindowX + 180, 201, 16776960, 0);
               var14 = 236;
               var0.method4884(class91.loginMessage1, class91.loginWindowX + 180, var14, 16777215, 0);
               var15 = var14 + 15;
               var0.method4884(class91.loginMessage2, class91.loginWindowX + 180, var15, 16777215, 0);
               var15 += 15;
               var0.method4884(class91.loginMessage3, class91.loginWindowX + 180, var15, 16777215, 0);
               var15 += 15;
               var5 = class91.loginWindowX + 180 - 80;
               var11 = 321;
               class91.field1317.method5176(var5 - 73, var11 - 20);
               var0.method4884("Continue", var5, var11 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class91.field1317.method5176(var5 - 73, var11 - 20);
               var0.method4884("Cancel", var5, var11 + 5, 16777215, 0);
            } else {
               int var7;
               if(class91.loginIndex == 2) {
                  var14 = 201;
                  var0.method4884(class91.loginMessage1, Preferences.field1217, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var0.method4884(class91.loginMessage2, Preferences.field1217, var15, 16776960, 0);
                  var15 += 15;
                  var0.method4884(class91.loginMessage3, Preferences.field1217, var15, 16776960, 0);
                  var15 += 15;
                  var15 += 7;
                  var0.method4891("Login: ", Preferences.field1217 - 110, var15, 16777215, 0);
                  var16 = 200;

                  for(var6 = class21.method151(); var0.method4886(var6) > var16; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4891(FontTypeFace.appendTags(var6) + (class91.field1345 == 0 & Client.gameCycle % 40 < 20?Buffer.getColTags(16776960) + "|":""), Preferences.field1217 - 70, var15, 16777215, 0);
                  var15 += 15;
                  var0.method4891("Password: " + UnitPriceComparator.method127(class91.password) + (class91.field1345 == 1 & Client.gameCycle % 40 < 20?Buffer.getColTags(16776960) + "|":""), Preferences.field1217 - 108, var15, 16777215, 0);
                  var15 += 15;
                  var14 = 277;
                  var7 = Preferences.field1217 + -117;
                  IndexedSprite var8 = MouseInput.method974(class91.Login_isUsernameRemembered, class91.field1331);
                  var8.method5176(var7, var14);
                  var7 = var7 + var8.originalWidth + 5;
                  var1.method4891("Remember username", var7, var14 + 13, 16776960, 0);
                  var7 = Preferences.field1217 + 24;
                  var8 = MouseInput.method974(class2.preferences.hideUsername, class91.field1318);
                  var8.method5176(var7, var14);
                  var7 = var7 + var8.originalWidth + 5;
                  var1.method4891("Hide username", var7, var14 + 13, 16776960, 0);
                  var15 = var14 + 15;
                  int var9 = Preferences.field1217 - 80;
                  short var10 = 321;
                  class91.field1317.method5176(var9 - 73, var10 - 20);
                  var0.method4884("Login", var9, var10 + 5, 16777215, 0);
                  var9 = Preferences.field1217 + 80;
                  class91.field1317.method5176(var9 - 73, var10 - 20);
                  var0.method4884("Cancel", var9, var10 + 5, 16777215, 0);
                  var14 = 357;
                  var1.method4884("Forgotten your password? <col=ffffff>Click here.", Preferences.field1217, var14, 16776960, 0);
               } else if(class91.loginIndex == 3) {
                  var14 = 201;
                  var0.method4884("Invalid username or password.", class91.loginWindowX + 180, var14, 16776960, 0);
                  var15 = var14 + 20;
                  var1.method4884("For accounts created after 24th November 2010, please use your", class91.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var1.method4884("email address to login. Otherwise please login with your username.", class91.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var5 = class91.loginWindowX + 180;
                  var11 = 276;
                  class91.field1317.method5176(var5 - 73, var11 - 20);
                  var2.method4884("Try again", var5, var11 + 5, 16777215, 0);
                  var5 = class91.loginWindowX + 180;
                  var11 = 326;
                  class91.field1317.method5176(var5 - 73, var11 - 20);
                  var2.method4884("Forgotten password?", var5, var11 + 5, 16777215, 0);
               } else if(class91.loginIndex == 4) {
                  var0.method4884("Authenticator", class91.loginWindowX + 180, 201, 16776960, 0);
                  var14 = 236;
                  var0.method4884(class91.loginMessage1, class91.loginWindowX + 180, var14, 16777215, 0);
                  var15 = var14 + 15;
                  var0.method4884(class91.loginMessage2, class91.loginWindowX + 180, var15, 16777215, 0);
                  var15 += 15;
                  var0.method4884(class91.loginMessage3, class91.loginWindowX + 180, var15, 16777215, 0);
                  var15 += 15;
                  var0.method4891("PIN: " + UnitPriceComparator.method127(class237.field3245) + (Client.gameCycle % 40 < 20?Buffer.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 108, var15, 16777215, 0);
                  var15 -= 8;
                  var0.method4891("Trust this computer", class91.loginWindowX + 180 - 9, var15, 16776960, 0);
                  var15 += 15;
                  var0.method4891("for 30 days: ", class91.loginWindowX + 180 - 9, var15, 16776960, 0);
                  var5 = 180 + class91.loginWindowX - 9 + var0.method4886("for 30 days: ") + 15;
                  int var19 = var15 - var0.verticalSpace;
                  IndexedSprite var12;
                  if(class91.field1346) {
                     var12 = class91.field1333;
                  } else {
                     var12 = CombatInfoListHolder.field1267;
                  }

                  var12.method5176(var5, var19);
                  var15 += 15;
                  int var13 = class91.loginWindowX + 180 - 80;
                  short var18 = 321;
                  class91.field1317.method5176(var13 - 73, var18 - 20);
                  var0.method4884("Continue", var13, var18 + 5, 16777215, 0);
                  var13 = class91.loginWindowX + 180 + 80;
                  class91.field1317.method5176(var13 - 73, var18 - 20);
                  var0.method4884("Cancel", var13, var18 + 5, 16777215, 0);
                  var1.method4884("<u=ff>Can\'t Log In?</u>", class91.loginWindowX + 180, var18 + 36, 255, 0);
               } else if(class91.loginIndex == 5) {
                  var0.method4884("Forgotten your password?", class91.loginWindowX + 180, 201, 16776960, 0);
                  var14 = 221;
                  var2.method4884(class91.loginMessage1, class91.loginWindowX + 180, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var2.method4884(class91.loginMessage2, class91.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var2.method4884(class91.loginMessage3, class91.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var15 += 14;
                  var0.method4891("Username/email: ", class91.loginWindowX + 180 - 145, var15, 16777215, 0);
                  var16 = 174;

                  for(var6 = class21.method151(); var0.method4886(var6) > var16; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4891(FontTypeFace.appendTags(var6) + (Client.gameCycle % 40 < 20?Buffer.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 34, var15, 16777215, 0);
                  var15 += 15;
                  var7 = class91.loginWindowX + 180 - 80;
                  short var21 = 321;
                  class91.field1317.method5176(var7 - 73, var21 - 20);
                  var0.method4884("Recover", var7, var21 + 5, 16777215, 0);
                  var7 = class91.loginWindowX + 180 + 80;
                  class91.field1317.method5176(var7 - 73, var21 - 20);
                  var0.method4884("Back", var7, var21 + 5, 16777215, 0);
               } else if(class91.loginIndex == 6) {
                  var14 = 201;
                  var0.method4884(class91.loginMessage1, class91.loginWindowX + 180, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var0.method4884(class91.loginMessage2, class91.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var0.method4884(class91.loginMessage3, class91.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var5 = class91.loginWindowX + 180;
                  var11 = 321;
                  class91.field1317.method5176(var5 - 73, var11 - 20);
                  var0.method4884("Back", var5, var11 + 5, 16777215, 0);
               }
            }
         }

         if(class91.field1330 > 0) {
            GameObject.method2909(class91.field1330);
            class91.field1330 = 0;
         }

         AbstractScene.method239();
         class278.titlemuteSprite[class2.preferences.muted?1:0].method5176(class91.field1351 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class160.field2151 != null) {
               var15 = class91.field1351 + 5;
               var16 = 463;
               byte var20 = 100;
               byte var17 = 35;
               class160.field2151.method5176(var15, var16);
               var0.method4884("World" + " " + Client.world, var20 / 2 + var15, var17 / 2 + var16 - 2, 16777215, 0);
               if(class192.listFetcher != null) {
                  var1.method4884("Loading...", var20 / 2 + var15, var17 / 2 + var16 + 12, 16777215, 0);
               } else {
                  var1.method4884("Click to switch", var20 / 2 + var15, var17 / 2 + var16 + 12, 16777215, 0);
               }
            } else {
               class160.field2151 = class279.getSprite(indexSprites, "sl_button", "");
            }
         }

      }
   }
}
