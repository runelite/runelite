import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class188 {
   @ObfuscatedName("e")
   @Export("spritePixels")
   public static byte[][] spritePixels;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-1"
   )
   public static int method3599(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljz;Ljz;Ljz;ZB)V",
      garbageValue = "0"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class91.field1336 = (class87.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1336 + 202;
         class91.field1344 = class91.loginWindowX + 180;
      }

      byte var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var33;
      int var35;
      int var37;
      if(class91.worldSelectShown) {
         if(class219.field2709 == null) {
            class219.field2709 = class5.getSprites(Renderable.indexSprites, "sl_back", "");
         }

         if(ItemLayer.slFlagSprites == null) {
            ItemLayer.slFlagSprites = BufferProvider.getIndexedSprites(Renderable.indexSprites, "sl_flags", "");
         }

         if(WorldMapData.slArrowSprites == null) {
            WorldMapData.slArrowSprites = BufferProvider.getIndexedSprites(Renderable.indexSprites, "sl_arrows", "");
         }

         if(class41.slStarSprites == null) {
            class41.slStarSprites = BufferProvider.getIndexedSprites(Renderable.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class91.field1336, 23, 765, 480, 0);
         Rasterizer2D.method5162(class91.field1336, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method5162(class91.field1336 + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawTextCentered("Select a world", class91.field1336 + 62, 15, 0, -1);
         if(class41.slStarSprites != null) {
            class41.slStarSprites[1].method5253(class91.field1336 + 140, 1);
            var1.method4950("Members only world", class91.field1336 + 152, 10, 16777215, -1);
            class41.slStarSprites[0].method5253(class91.field1336 + 140, 12);
            var1.method4950("Free world", class91.field1336 + 152, 21, 16777215, -1);
         }

         if(WorldMapData.slArrowSprites != null) {
            var33 = class91.field1336 + 280;
            if(World.field1224[0] == 0 && World.field1223[0] == 0) {
               WorldMapData.slArrowSprites[2].method5253(var33, 4);
            } else {
               WorldMapData.slArrowSprites[0].method5253(var33, 4);
            }

            if(World.field1224[0] == 0 && World.field1223[0] == 1) {
               WorldMapData.slArrowSprites[3].method5253(var33 + 15, 4);
            } else {
               WorldMapData.slArrowSprites[1].method5253(var33 + 15, 4);
            }

            var0.method4950("World", var33 + 32, 17, 16777215, -1);
            var5 = class91.field1336 + 390;
            if(World.field1224[0] == 1 && World.field1223[0] == 0) {
               WorldMapData.slArrowSprites[2].method5253(var5, 4);
            } else {
               WorldMapData.slArrowSprites[0].method5253(var5, 4);
            }

            if(World.field1224[0] == 1 && World.field1223[0] == 1) {
               WorldMapData.slArrowSprites[3].method5253(var5 + 15, 4);
            } else {
               WorldMapData.slArrowSprites[1].method5253(var5 + 15, 4);
            }

            var0.method4950("Players", var5 + 32, 17, 16777215, -1);
            var35 = class91.field1336 + 500;
            if(World.field1224[0] == 2 && World.field1223[0] == 0) {
               WorldMapData.slArrowSprites[2].method5253(var35, 4);
            } else {
               WorldMapData.slArrowSprites[0].method5253(var35, 4);
            }

            if(World.field1224[0] == 2 && World.field1223[0] == 1) {
               WorldMapData.slArrowSprites[3].method5253(var35 + 15, 4);
            } else {
               WorldMapData.slArrowSprites[1].method5253(var35 + 15, 4);
            }

            var0.method4950("Location", var35 + 32, 17, 16777215, -1);
            var7 = class91.field1336 + 610;
            if(World.field1224[0] == 3 && World.field1223[0] == 0) {
               WorldMapData.slArrowSprites[2].method5253(var7, 4);
            } else {
               WorldMapData.slArrowSprites[0].method5253(var7, 4);
            }

            if(World.field1224[0] == 3 && World.field1223[0] == 1) {
               WorldMapData.slArrowSprites[3].method5253(var7 + 15, 4);
            } else {
               WorldMapData.slArrowSprites[1].method5253(var7 + 15, 4);
            }

            var0.method4950("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class91.field1336 + 708, 4, 50, 16, 0);
         var1.drawTextCentered("Cancel", class91.field1336 + 708 + 25, 16, 16777215, -1);
         class91.field1349 = -1;
         if(class219.field2709 != null) {
            var4 = 88;
            byte var39 = 19;
            var35 = 765 / (var4 + 1);
            var7 = 480 / (var39 + 1);

            do {
               var37 = var7;
               var9 = var35;
               if(var7 * (var35 - 1) >= World.worldCount) {
                  --var35;
               }

               if(var35 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }

               if(var35 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }
            } while(var37 != var7 || var35 != var9);

            var37 = (765 - var35 * var4) / (var35 + 1);
            if(var37 > 5) {
               var37 = 5;
            }

            var9 = (480 - var39 * var7) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var35 * var4 - var37 * (var35 - 1)) / 2;
            var11 = (480 - var39 * var7 - var9 * (var7 - 1)) / 2;
            var12 = var11 + 23;
            var13 = var10 + class91.field1336;
            var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.worldCount; ++var16) {
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
               if(var17.method1583()) {
                  if(var17.method1592()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method1589()) {
                  var21 = 16711680;
                  if(var17.method1592()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method1580()) {
                  if(var17.method1592()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method1592()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(MouseInput.mouseLastX >= var13 && MouseInput.mouseLastY >= var12 && MouseInput.mouseLastX < var4 + var13 && MouseInput.mouseLastY < var39 + var12 && var18) {
                  class91.field1349 = var16;
                  class219.field2709[var20].method5286(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class219.field2709[var20].method5287(var13, var12);
               }

               if(ItemLayer.slFlagSprites != null) {
                  ItemLayer.slFlagSprites[(var17.method1592()?8:0) + var17.location].method5253(var13 + 29, var12);
               }

               var0.drawTextCentered(Integer.toString(var17.id), var13 + 15, var39 / 2 + var12 + 5, var21, -1);
               var1.drawTextCentered(var19, var13 + 60, var39 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var9 + var39;
               ++var14;
               if(var14 >= var7) {
                  var12 = var11 + 23;
                  var13 = var13 + var37 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.getTextWidth(World.worldList[class91.field1349].activity) + 6;
               int var31 = var1.verticalSpace + 8;
               Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY + 20 + 5, var16, var31, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY + 20 + 5, var16, var31, 0);
               var1.drawTextCentered(World.worldList[class91.field1349].activity, MouseInput.mouseLastX, MouseInput.mouseLastY + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
         }

         class35.rasterProvider.drawFull(0, 0);
      } else {
         if(var3) {
            class91.field1339.method5287(class91.field1336, 0);
            GrandExchangeEvents.field269.method5287(class91.field1336 + 382, 0);
            class91.logoSprite.method5253(class91.field1336 + 382 - class91.logoSprite.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.drawTextCentered("RuneScape is loading - please wait...", class91.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(class91.loginWindowX + 180 - 150, var5 + 2, class91.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(class91.loadingBarPercentage * 3 + (class91.loginWindowX + 180 - 150), var5 + 2, 300 - class91.loadingBarPercentage * 3, 30, 0);
            var0.drawTextCentered(class91.loadingText, class91.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var22;
         String var24;
         String var25;
         char[] var26;
         String var27;
         short var32;
         short var34;
         if(Client.gameState == 20) {
            class91.field1337.method5253(class91.loginWindowX + 180 - class91.field1337.originalWidth / 2, 271 - class91.field1337.height / 2);
            var32 = 201;
            var0.drawTextCentered(class91.loginMessage1, class91.loginWindowX + 180, var32, 16776960, 0);
            var33 = var32 + 15;
            var0.drawTextCentered(class91.loginMessage2, class91.loginWindowX + 180, var33, 16776960, 0);
            var33 += 15;
            var0.drawTextCentered(class91.loginMessage3, class91.loginWindowX + 180, var33, 16776960, 0);
            var33 += 15;
            var33 += 7;
            if(class91.loginIndex != 4) {
               var0.method4950("Login: ", class91.loginWindowX + 180 - 110, var33, 16777215, 0);
               var34 = 200;

               for(var22 = class44.method619(); var0.getTextWidth(var22) > var34; var22 = var22.substring(0, var22.length() - 1)) {
                  ;
               }

               var0.method4950(FontTypeFace.appendTags(var22), class91.loginWindowX + 180 - 70, var33, 16777215, 0);
               var33 += 15;
               var24 = "Password: ";
               var25 = class91.password;
               var12 = var25.length();
               var26 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var26[var14] = '*';
               }

               var27 = new String(var26);
               var0.method4950(var24 + var27, class91.loginWindowX + 180 - 108, var33, 16777215, 0);
               var33 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class91.field1337.method5253(class91.loginWindowX, 171);
            short var6;
            if(class91.loginIndex == 0) {
               var32 = 251;
               var0.drawTextCentered("Welcome to RuneScape", class91.loginWindowX + 180, var32, 16776960, 0);
               var33 = var32 + 30;
               var5 = class91.loginWindowX + 180 - 80;
               var6 = 291;
               class277.field3744.method5253(var5 - 73, var6 - 20);
               var0.method4954("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class277.field3744.method5253(var5 - 73, var6 - 20);
               var0.method4954("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class91.loginIndex == 1) {
               var0.drawTextCentered(class91.Login_response0, class91.loginWindowX + 180, 201, 16776960, 0);
               var32 = 236;
               var0.drawTextCentered(class91.loginMessage1, class91.loginWindowX + 180, var32, 16777215, 0);
               var33 = var32 + 15;
               var0.drawTextCentered(class91.loginMessage2, class91.loginWindowX + 180, var33, 16777215, 0);
               var33 += 15;
               var0.drawTextCentered(class91.loginMessage3, class91.loginWindowX + 180, var33, 16777215, 0);
               var33 += 15;
               var5 = class91.loginWindowX + 180 - 80;
               var6 = 321;
               class277.field3744.method5253(var5 - 73, var6 - 20);
               var0.drawTextCentered("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class277.field3744.method5253(var5 - 73, var6 - 20);
               var0.drawTextCentered("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class91.loginIndex == 2) {
               var32 = 201;
               var0.drawTextCentered(class91.loginMessage1, class91.field1344, var32, 16776960, 0);
               var33 = var32 + 15;
               var0.drawTextCentered(class91.loginMessage2, class91.field1344, var33, 16776960, 0);
               var33 += 15;
               var0.drawTextCentered(class91.loginMessage3, class91.field1344, var33, 16776960, 0);
               var33 += 15;
               var33 += 7;
               var0.method4950("Login: ", class91.field1344 - 110, var33, 16777215, 0);
               var34 = 200;

               for(var22 = class44.method619(); var0.getTextWidth(var22) > var34; var22 = var22.substring(1)) {
                  ;
               }

               var0.method4950(FontTypeFace.appendTags(var22) + (class91.field1347 == 0 & Client.gameCycle % 40 < 20?class54.getColTags(16776960) + "|":""), class91.field1344 - 70, var33, 16777215, 0);
               var33 += 15;
               var24 = "Password: ";
               var25 = class91.password;
               var12 = var25.length();
               var26 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var26[var14] = '*';
               }

               var27 = new String(var26);
               var0.method4950(var24 + var27 + (class91.field1347 == 1 & Client.gameCycle % 40 < 20?class54.getColTags(16776960) + "|":""), class91.field1344 - 108, var33, 16777215, 0);
               var33 += 15;
               var32 = 277;
               var11 = class91.field1344 + -117;
               IndexedSprite var30 = class219.method4129(class91.Login_isUsernameRemembered, class91.field1335);
               var30.method5253(var11, var32);
               var11 = var11 + var30.originalWidth + 5;
               var1.method4950("Remember username", var11, var32 + 13, 16776960, 0);
               var11 = class91.field1344 + 24;
               var30 = class219.method4129(class222.preferences.hideUsername, class91.field1363);
               var30.method5253(var11, var32);
               var11 = var11 + var30.originalWidth + 5;
               var1.method4950("Hide username", var11, var32 + 13, 16776960, 0);
               var33 = var32 + 15;
               var13 = class91.field1344 - 80;
               short var41 = 321;
               class277.field3744.method5253(var13 - 73, var41 - 20);
               var0.drawTextCentered("Login", var13, var41 + 5, 16777215, 0);
               var13 = class91.field1344 + 80;
               class277.field3744.method5253(var13 - 73, var41 - 20);
               var0.drawTextCentered("Cancel", var13, var41 + 5, 16777215, 0);
               var32 = 357;
               var1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", class91.field1344, var32, 16776960, 0);
            } else if(class91.loginIndex == 3) {
               var32 = 201;
               var0.drawTextCentered("Invalid username or password.", class91.loginWindowX + 180, var32, 16776960, 0);
               var33 = var32 + 20;
               var1.drawTextCentered("For accounts created after 24th November 2010, please use your", class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var1.drawTextCentered("email address to login. Otherwise please login with your username.", class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var5 = class91.loginWindowX + 180;
               var6 = 276;
               class277.field3744.method5253(var5 - 73, var6 - 20);
               var2.drawTextCentered("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180;
               var6 = 326;
               class277.field3744.method5253(var5 - 73, var6 - 20);
               var2.drawTextCentered("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class91.loginIndex == 4) {
               var0.drawTextCentered("Authenticator", class91.loginWindowX + 180, 201, 16776960, 0);
               var32 = 236;
               var0.drawTextCentered(class91.loginMessage1, class91.loginWindowX + 180, var32, 16777215, 0);
               var33 = var32 + 15;
               var0.drawTextCentered(class91.loginMessage2, class91.loginWindowX + 180, var33, 16777215, 0);
               var33 += 15;
               var0.drawTextCentered(class91.loginMessage3, class91.loginWindowX + 180, var33, 16777215, 0);
               var33 += 15;
               var22 = "PIN: ";
               var24 = IndexStoreActionHandler.field3327;
               var10 = var24.length();
               char[] var42 = new char[var10];

               for(var12 = 0; var12 < var10; ++var12) {
                  var42[var12] = '*';
               }

               String var28 = new String(var42);
               var0.method4950(var22 + var28 + (Client.gameCycle % 40 < 20?class54.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 108, var33, 16777215, 0);
               var33 -= 8;
               var0.method4950("Trust this computer", class91.loginWindowX + 180 - 9, var33, 16776960, 0);
               var33 += 15;
               var0.method4950("for 30 days: ", class91.loginWindowX + 180 - 9, var33, 16776960, 0);
               var9 = 180 + class91.loginWindowX - 9 + var0.getTextWidth("for 30 days: ") + 15;
               var10 = var33 - var0.verticalSpace;
               IndexedSprite var43;
               if(class91.field1367) {
                  var43 = class2.field11;
               } else {
                  var43 = MouseRecorder.field812;
               }

               var43.method5253(var9, var10);
               var33 += 15;
               var12 = class91.loginWindowX + 180 - 80;
               short var40 = 321;
               class277.field3744.method5253(var12 - 73, var40 - 20);
               var0.drawTextCentered("Continue", var12, var40 + 5, 16777215, 0);
               var12 = class91.loginWindowX + 180 + 80;
               class277.field3744.method5253(var12 - 73, var40 - 20);
               var0.drawTextCentered("Cancel", var12, var40 + 5, 16777215, 0);
               var1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class91.loginWindowX + 180, var40 + 36, 255, 0);
            } else if(class91.loginIndex == 5) {
               var0.drawTextCentered("Forgotten your password?", class91.loginWindowX + 180, 201, 16776960, 0);
               var32 = 221;
               var2.drawTextCentered(class91.loginMessage1, class91.loginWindowX + 180, var32, 16776960, 0);
               var33 = var32 + 15;
               var2.drawTextCentered(class91.loginMessage2, class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var2.drawTextCentered(class91.loginMessage3, class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var33 += 14;
               var0.method4950("Username/email: ", class91.loginWindowX + 180 - 145, var33, 16777215, 0);
               var34 = 174;

               for(var22 = class44.method619(); var0.getTextWidth(var22) > var34; var22 = var22.substring(1)) {
                  ;
               }

               var0.method4950(FontTypeFace.appendTags(var22) + (Client.gameCycle % 40 < 20?class54.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 34, var33, 16777215, 0);
               var33 += 15;
               var7 = class91.loginWindowX + 180 - 80;
               short var8 = 321;
               class277.field3744.method5253(var7 - 73, var8 - 20);
               var0.drawTextCentered("Recover", var7, var8 + 5, 16777215, 0);
               var7 = class91.loginWindowX + 180 + 80;
               class277.field3744.method5253(var7 - 73, var8 - 20);
               var0.drawTextCentered("Back", var7, var8 + 5, 16777215, 0);
            } else if(class91.loginIndex == 6) {
               var32 = 201;
               var0.drawTextCentered(class91.loginMessage1, class91.loginWindowX + 180, var32, 16776960, 0);
               var33 = var32 + 15;
               var0.drawTextCentered(class91.loginMessage2, class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var0.drawTextCentered(class91.loginMessage3, class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var5 = class91.loginWindowX + 180;
               var6 = 321;
               class277.field3744.method5253(var5 - 73, var6 - 20);
               var0.drawTextCentered("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class91.field1366 > 0) {
            var33 = class91.field1366;
            var34 = 256;
            class91.field1348 += var33 * 128;
            if(class91.field1348 > FrameMap.field1958.length) {
               class91.field1348 -= FrameMap.field1958.length;
               var35 = (int)(Math.random() * 12.0D);
               class37.method495(class91.runeSprites[var35]);
            }

            var35 = 0;
            var7 = var33 * 128;
            var37 = (var34 - var33) * 128;

            for(var9 = 0; var9 < var37; ++var9) {
               var10 = GrandExchangeEvent.field282[var7 + var35] - FrameMap.field1958[var35 + class91.field1348 & FrameMap.field1958.length - 1] * var33 / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               GrandExchangeEvent.field282[var35++] = var10;
            }

            for(var9 = var34 - var33; var9 < var34; ++var9) {
               var10 = var9 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     GrandExchangeEvent.field282[var11 + var10] = 255;
                  } else {
                     GrandExchangeEvent.field282[var10 + var11] = 0;
                  }
               }
            }

            if(class91.field1346 > 0) {
               class91.field1346 -= var33 * 4;
            }

            if(class91.field1350 > 0) {
               class91.field1350 -= var33 * 4;
            }

            if(class91.field1346 == 0 && class91.field1350 == 0) {
               var9 = (int)(Math.random() * (double)(2000 / var33));
               if(var9 == 0) {
                  class91.field1346 = 1024;
               }

               if(var9 == 1) {
                  class91.field1350 = 1024;
               }
            }

            for(var9 = 0; var9 < var34 - var33; ++var9) {
               class91.field1352[var9] = class91.field1352[var9 + var33];
            }

            for(var9 = var34 - var33; var9 < var34; ++var9) {
               class91.field1352[var9] = (int)(Math.sin((double)class91.field1351 / 14.0D) * 16.0D + Math.sin((double)class91.field1351 / 15.0D) * 14.0D + Math.sin((double)class91.field1351 / 16.0D) * 12.0D);
               ++class91.field1351;
            }

            class91.field1353 += var33;
            var9 = (var33 + (Client.gameCycle & 1)) / 2;
            if(var9 > 0) {
               for(var10 = 0; var10 < class91.field1353 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  GrandExchangeEvent.field282[var11 + (var12 << 7)] = 192;
               }

               class91.field1353 = 0;
               var10 = 0;

               label662:
               while(true) {
                  if(var10 >= var34) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label662;
                        }

                        var11 = 0;

                        for(var12 = -var9; var12 < var34; ++var12) {
                           var13 = var12 * 128;
                           if(var9 + var12 < var34) {
                              var11 += SoundTask.field1571[var13 + var10 + var9 * 128];
                           }

                           if(var12 - (var9 + 1) >= 0) {
                              var11 -= SoundTask.field1571[var10 + var13 - (var9 + 1) * 128];
                           }

                           if(var12 >= 0) {
                              GrandExchangeEvent.field282[var13 + var10] = var11 / (var9 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = var10 * 128;

                  for(var13 = -var9; var13 < 128; ++var13) {
                     if(var13 + var9 < 128) {
                        var11 += GrandExchangeEvent.field282[var12 + var13 + var9];
                     }

                     if(var13 - (var9 + 1) >= 0) {
                        var11 -= GrandExchangeEvent.field282[var13 + var12 - (var9 + 1)];
                     }

                     if(var13 >= 0) {
                        SoundTask.field1571[var13 + var12] = var11 / (var9 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class91.field1366 = 0;
         }

         ScriptEvent.method1110();
         ItemContainer.titlemuteSprite[class222.preferences.muted?1:0].method5253(class91.field1336 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class43.field550 != null) {
               var33 = class91.field1336 + 5;
               var34 = 463;
               byte var38 = 100;
               byte var36 = 35;
               class43.field550.method5253(var33, var34);
               var0.drawTextCentered("World" + " " + Client.world, var38 / 2 + var33, var36 / 2 + var34 - 2, 16777215, 0);
               if(class37.listFetcher != null) {
                  var1.drawTextCentered("Loading...", var38 / 2 + var33, var36 / 2 + var34 + 12, 16777215, 0);
               } else {
                  var1.drawTextCentered("Click to switch", var38 / 2 + var33, var36 / 2 + var34 + 12, 16777215, 0);
               }
            } else {
               class43.field550 = class222.getSprite(Renderable.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2077590541"
   )
   static final int method3600(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
