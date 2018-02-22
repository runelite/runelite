import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class31 {
   @ObfuscatedName("bk")
   static String field407;
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "Lbz;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1243120225
   )
   final int field412;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1071233993
   )
   final int field409;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 963374767
   )
   final int field408;

   class31(int var1, int var2, int var3) {
      this.field412 = var1;
      this.field409 = var2;
      this.field408 = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;Lie;Lie;Lie;I)V",
      garbageValue = "-2079676165"
   )
   public static void method301(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      class154.widgetIndex = var0;
      Widget.field2770 = var1;
      class170.field2192 = var2;
      class35.field457 = var3;
      Widget.widgets = new Widget[class154.widgetIndex.size()][];
      class89.validInterfaces = new boolean[class154.widgetIndex.size()];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1296495203"
   )
   public static int method303() {
      return KeyFocusListener.keyboardIdleTicks;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lkt;Lkt;Lkt;ZB)V",
      garbageValue = "54"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class89.field1324 = (class1.canvasWidth - 765) / 2;
         class89.loginWindowX = class89.field1324 + 202;
         class222.field2641 = class89.loginWindowX + 180;
      }

      byte var4;
      int var5;
      int var8;
      int var10;
      int var27;
      int var29;
      if(class89.worldSelectShown) {
         if(class54.field605 == null) {
            class54.field605 = ObjectComposition.getSprites(MessageNode.indexSprites, "sl_back", "");
         }

         if(IndexStoreActionHandler.slFlagSprites == null) {
            IndexStoreActionHandler.slFlagSprites = DState.getIndexedSprites(MessageNode.indexSprites, "sl_flags", "");
         }

         if(class33.slArrowSprites == null) {
            class33.slArrowSprites = DState.getIndexedSprites(MessageNode.indexSprites, "sl_arrows", "");
         }

         if(BoundingBox3D.slStarSprites == null) {
            BoundingBox3D.slStarSprites = DState.getIndexedSprites(MessageNode.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class89.field1324, 23, 765, 480, 0);
         Rasterizer2D.method5710(class89.field1324, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method5710(class89.field1324 + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawTextCentered("Select a world", class89.field1324 + 62, 15, 0, -1);
         if(BoundingBox3D.slStarSprites != null) {
            BoundingBox3D.slStarSprites[1].method5783(class89.field1324 + 140, 1);
            var1.method5451("Members only world", class89.field1324 + 152, 10, 16777215, -1);
            BoundingBox3D.slStarSprites[0].method5783(class89.field1324 + 140, 12);
            var1.method5451("Free world", class89.field1324 + 152, 21, 16777215, -1);
         }

         int var30;
         if(class33.slArrowSprites != null) {
            var27 = class89.field1324 + 280;
            if(World.field1166[0] == 0 && World.field1168[0] == 0) {
               class33.slArrowSprites[2].method5783(var27, 4);
            } else {
               class33.slArrowSprites[0].method5783(var27, 4);
            }

            if(World.field1166[0] == 0 && World.field1168[0] == 1) {
               class33.slArrowSprites[3].method5783(var27 + 15, 4);
            } else {
               class33.slArrowSprites[1].method5783(var27 + 15, 4);
            }

            var0.method5451("World", var27 + 32, 17, 16777215, -1);
            var5 = class89.field1324 + 390;
            if(World.field1166[0] == 1 && World.field1168[0] == 0) {
               class33.slArrowSprites[2].method5783(var5, 4);
            } else {
               class33.slArrowSprites[0].method5783(var5, 4);
            }

            if(World.field1166[0] == 1 && World.field1168[0] == 1) {
               class33.slArrowSprites[3].method5783(var5 + 15, 4);
            } else {
               class33.slArrowSprites[1].method5783(var5 + 15, 4);
            }

            var0.method5451("Players", var5 + 32, 17, 16777215, -1);
            var29 = class89.field1324 + 500;
            if(World.field1166[0] == 2 && World.field1168[0] == 0) {
               class33.slArrowSprites[2].method5783(var29, 4);
            } else {
               class33.slArrowSprites[0].method5783(var29, 4);
            }

            if(World.field1166[0] == 2 && World.field1168[0] == 1) {
               class33.slArrowSprites[3].method5783(var29 + 15, 4);
            } else {
               class33.slArrowSprites[1].method5783(var29 + 15, 4);
            }

            var0.method5451("Location", var29 + 32, 17, 16777215, -1);
            var30 = class89.field1324 + 610;
            if(World.field1166[0] == 3 && World.field1168[0] == 0) {
               class33.slArrowSprites[2].method5783(var30, 4);
            } else {
               class33.slArrowSprites[0].method5783(var30, 4);
            }

            if(World.field1166[0] == 3 && World.field1168[0] == 1) {
               class33.slArrowSprites[3].method5783(var30 + 15, 4);
            } else {
               class33.slArrowSprites[1].method5783(var30 + 15, 4);
            }

            var0.method5451("Type", var30 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class89.field1324 + 708, 4, 50, 16, 0);
         var1.drawTextCentered("Cancel", class89.field1324 + 708 + 25, 16, 16777215, -1);
         class89.field1315 = -1;
         if(class54.field605 != null) {
            var4 = 88;
            byte var32 = 19;
            var29 = 765 / (var4 + 1);
            var30 = 480 / (var32 + 1);

            int var33;
            do {
               var8 = var30;
               var33 = var29;
               if(var30 * (var29 - 1) >= World.worldCount) {
                  --var29;
               }

               if(var29 * (var30 - 1) >= World.worldCount) {
                  --var30;
               }

               if(var29 * (var30 - 1) >= World.worldCount) {
                  --var30;
               }
            } while(var30 != var8 || var33 != var29);

            var8 = (765 - var29 * var4) / (var29 + 1);
            if(var8 > 5) {
               var8 = 5;
            }

            var33 = (480 - var32 * var30) / (var30 + 1);
            if(var33 > 5) {
               var33 = 5;
            }

            var10 = (765 - var4 * var29 - var8 * (var29 - 1)) / 2;
            int var34 = (480 - var32 * var30 - var33 * (var30 - 1)) / 2;
            int var12 = var34 + 23;
            int var13 = var10 + class89.field1324;
            int var14 = 0;
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
               if(var17.method1664()) {
                  if(var17.method1643()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method1654()) {
                  var21 = 16711680;
                  if(var17.method1643()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method1645()) {
                  if(var17.method1643()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method1643()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(MouseInput.mouseLastX >= var13 && MouseInput.mouseLastY >= var12 && MouseInput.mouseLastX < var4 + var13 && MouseInput.mouseLastY < var32 + var12 && var18) {
                  class89.field1315 = var16;
                  class54.field605[var20].method5814(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class54.field605[var20].method5809(var13, var12);
               }

               if(IndexStoreActionHandler.slFlagSprites != null) {
                  IndexStoreActionHandler.slFlagSprites[(var17.method1643()?8:0) + var17.location].method5783(var13 + 29, var12);
               }

               var0.drawTextCentered(Integer.toString(var17.id), var13 + 15, var32 / 2 + var12 + 5, var21, -1);
               var1.drawTextCentered(var19, var13 + 60, var32 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var32 + var33;
               ++var14;
               if(var14 >= var30) {
                  var12 = var34 + 23;
                  var13 = var13 + var8 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.getTextWidth(World.worldList[class89.field1315].activity) + 6;
               int var22 = var1.verticalSpace + 8;
               Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY + 20 + 5, var16, var22, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY + 20 + 5, var16, var22, 0);
               var1.drawTextCentered(World.worldList[class89.field1315].activity, MouseInput.mouseLastX, MouseInput.mouseLastY + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
         }

         class324.rasterProvider.drawFull(0, 0);
      } else {
         if(var3) {
            class234.field2759.method5809(class89.field1324, 0);
            class305.field3806.method5809(class89.field1324 + 382, 0);
            class89.logoSprite.method5783(class89.field1324 + 382 - class89.logoSprite.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.drawTextCentered("RuneScape is loading - please wait...", class89.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class89.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class89.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(class89.loginWindowX + 180 - 150, var5 + 2, class89.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(class89.loginWindowX + 180 - 150 + class89.loadingBarPercentage * 3, var5 + 2, 300 - class89.loadingBarPercentage * 3, 30, 0);
            var0.drawTextCentered(class89.loadingText, class89.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var23;
         String var24;
         short var26;
         short var28;
         if(Client.gameState == 20) {
            class89.field1299.method5783(class89.loginWindowX + 180 - class89.field1299.originalWidth / 2, 271 - class89.field1299.height / 2);
            var26 = 201;
            var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var26, 16776960, 0);
            var27 = var26 + 15;
            var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var27, 16776960, 0);
            var27 += 15;
            var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var27, 16776960, 0);
            var27 += 15;
            var27 += 7;
            if(class89.loginIndex != 4) {
               var0.method5451("Login: ", class89.loginWindowX + 180 - 110, var27, 16777215, 0);
               var28 = 200;
               var23 = Client.preferences.hideUsername?NetWriter.method2061(class89.username):class89.username;

               for(var24 = var23; var0.getTextWidth(var24) > var28; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method5451(FontTypeFace.appendTags(var24), class89.loginWindowX + 180 - 70, var27, 16777215, 0);
               var27 += 15;
               var0.method5451("Password: " + NetWriter.method2061(class89.password), class89.loginWindowX + 180 - 108, var27, 16777215, 0);
               var27 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class89.field1299.method5783(class89.loginWindowX, 171);
            short var6;
            if(class89.loginIndex == 0) {
               var26 = 251;
               var0.drawTextCentered("Welcome to RuneScape", class89.loginWindowX + 180, var26, 16776960, 0);
               var27 = var26 + 30;
               var5 = class89.loginWindowX + 180 - 80;
               var6 = 291;
               class84.field1264.method5783(var5 - 73, var6 - 20);
               var0.method5455("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class89.loginWindowX + 180 + 80;
               class84.field1264.method5783(var5 - 73, var6 - 20);
               var0.method5455("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class89.loginIndex == 1) {
               var0.drawTextCentered(class89.Login_response0, class89.loginWindowX + 180, 201, 16776960, 0);
               var26 = 236;
               var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var26, 16777215, 0);
               var27 = var26 + 15;
               var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var27, 16777215, 0);
               var27 += 15;
               var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var27, 16777215, 0);
               var27 += 15;
               var5 = class89.loginWindowX + 180 - 80;
               var6 = 321;
               class84.field1264.method5783(var5 - 73, var6 - 20);
               var0.drawTextCentered("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class89.loginWindowX + 180 + 80;
               class84.field1264.method5783(var5 - 73, var6 - 20);
               var0.drawTextCentered("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class89.loginIndex == 2) {
               var26 = 201;
               var0.drawTextCentered(class89.loginMessage1, class222.field2641, var26, 16776960, 0);
               var27 = var26 + 15;
               var0.drawTextCentered(class89.loginMessage2, class222.field2641, var27, 16776960, 0);
               var27 += 15;
               var0.drawTextCentered(class89.loginMessage3, class222.field2641, var27, 16776960, 0);
               var27 += 15;
               var27 += 7;
               var0.method5451("Login: ", class222.field2641 - 110, var27, 16777215, 0);
               var28 = 200;
               var23 = Client.preferences.hideUsername?NetWriter.method2061(class89.username):class89.username;

               for(var24 = var23; var0.getTextWidth(var24) > var28; var24 = var24.substring(1)) {
                  ;
               }

               var0.method5451(FontTypeFace.appendTags(var24) + (class89.field1331 == 0 & Client.gameCycle % 40 < 20?BoundingBox3D.getColTags(16776960) + "|":""), class222.field2641 - 70, var27, 16777215, 0);
               var27 += 15;
               var0.method5451("Password: " + NetWriter.method2061(class89.password) + (class89.field1331 == 1 & Client.gameCycle % 40 < 20?BoundingBox3D.getColTags(16776960) + "|":""), class222.field2641 - 108, var27, 16777215, 0);
               var27 += 15;
               var26 = 277;
               var8 = class222.field2641 + -117;
               IndexedSprite var25 = Varbit.method4859(class89.Login_isUsernameRemembered, class89.field1320);
               var25.method5783(var8, var26);
               var8 = var8 + var25.originalWidth + 5;
               var1.method5451("Remember username", var8, var26 + 13, 16776960, 0);
               var8 = class222.field2641 + 24;
               var25 = Varbit.method4859(Client.preferences.hideUsername, class89.field1325);
               var25.method5783(var8, var26);
               var8 = var8 + var25.originalWidth + 5;
               var1.method5451("Hide username", var8, var26 + 13, 16776960, 0);
               var27 = var26 + 15;
               var10 = class222.field2641 - 80;
               short var11 = 321;
               class84.field1264.method5783(var10 - 73, var11 - 20);
               var0.drawTextCentered("Login", var10, var11 + 5, 16777215, 0);
               var10 = class222.field2641 + 80;
               class84.field1264.method5783(var10 - 73, var11 - 20);
               var0.drawTextCentered("Cancel", var10, var11 + 5, 16777215, 0);
               var26 = 357;
               var1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", class222.field2641, var26, 16776960, 0);
            } else if(class89.loginIndex == 3) {
               var26 = 201;
               var0.drawTextCentered("Invalid username or password.", class89.loginWindowX + 180, var26, 16776960, 0);
               var27 = var26 + 20;
               var1.drawTextCentered("For accounts created after 24th November 2010, please use your", class89.loginWindowX + 180, var27, 16776960, 0);
               var27 += 15;
               var1.drawTextCentered("email address to login. Otherwise please login with your username.", class89.loginWindowX + 180, var27, 16776960, 0);
               var27 += 15;
               var5 = class89.loginWindowX + 180;
               var6 = 276;
               class84.field1264.method5783(var5 - 73, var6 - 20);
               var2.drawTextCentered("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class89.loginWindowX + 180;
               var6 = 326;
               class84.field1264.method5783(var5 - 73, var6 - 20);
               var2.drawTextCentered("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else {
               short var9;
               if(class89.loginIndex == 4) {
                  var0.drawTextCentered("Authenticator", class89.loginWindowX + 180, 201, 16776960, 0);
                  var26 = 236;
                  var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var26, 16777215, 0);
                  var27 = var26 + 15;
                  var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var27, 16777215, 0);
                  var27 += 15;
                  var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var27, 16777215, 0);
                  var27 += 15;
                  var0.method5451("PIN: " + NetWriter.method2061(WidgetNode.field740) + (Client.gameCycle % 40 < 20?BoundingBox3D.getColTags(16776960) + "|":""), class89.loginWindowX + 180 - 108, var27, 16777215, 0);
                  var27 -= 8;
                  var0.method5451("Trust this computer", class89.loginWindowX + 180 - 9, var27, 16776960, 0);
                  var27 += 15;
                  var0.method5451("for 30 days: ", class89.loginWindowX + 180 - 9, var27, 16776960, 0);
                  var5 = class89.loginWindowX + 180 - 9 + var0.getTextWidth("for 30 days: ") + 15;
                  var29 = var27 - var0.verticalSpace;
                  IndexedSprite var35;
                  if(class89.field1312) {
                     var35 = class89.field1302;
                  } else {
                     var35 = WorldComparator.field259;
                  }

                  var35.method5783(var5, var29);
                  var27 += 15;
                  var8 = class89.loginWindowX + 180 - 80;
                  var9 = 321;
                  class84.field1264.method5783(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Continue", var8, var9 + 5, 16777215, 0);
                  var8 = class89.loginWindowX + 180 + 80;
                  class84.field1264.method5783(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Cancel", var8, var9 + 5, 16777215, 0);
                  var1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class89.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class89.loginIndex == 5) {
                  var0.drawTextCentered("Forgotten your password?", class89.loginWindowX + 180, 201, 16776960, 0);
                  var26 = 221;
                  var2.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var26, 16776960, 0);
                  var27 = var26 + 15;
                  var2.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var27, 16776960, 0);
                  var27 += 15;
                  var2.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var27, 16776960, 0);
                  var27 += 15;
                  var27 += 14;
                  var0.method5451("Username/email: ", class89.loginWindowX + 180 - 145, var27, 16777215, 0);
                  var28 = 174;
                  var23 = Client.preferences.hideUsername?NetWriter.method2061(class89.username):class89.username;

                  for(var24 = var23; var0.getTextWidth(var24) > var28; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method5451(FontTypeFace.appendTags(var24) + (Client.gameCycle % 40 < 20?BoundingBox3D.getColTags(16776960) + "|":""), class89.loginWindowX + 180 - 34, var27, 16777215, 0);
                  var27 += 15;
                  var8 = class89.loginWindowX + 180 - 80;
                  var9 = 321;
                  class84.field1264.method5783(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Recover", var8, var9 + 5, 16777215, 0);
                  var8 = class89.loginWindowX + 180 + 80;
                  class84.field1264.method5783(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Back", var8, var9 + 5, 16777215, 0);
               } else if(class89.loginIndex == 6) {
                  var26 = 201;
                  var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var26, 16776960, 0);
                  var27 = var26 + 15;
                  var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var27, 16776960, 0);
                  var27 += 15;
                  var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var27, 16776960, 0);
                  var27 += 15;
                  var5 = class89.loginWindowX + 180;
                  var6 = 321;
                  class84.field1264.method5783(var5 - 73, var6 - 20);
                  var0.drawTextCentered("Back", var5, var6 + 5, 16777215, 0);
               }
            }
         }

         if(class89.field1310 > 0) {
            class18.method143(class89.field1310);
            class89.field1310 = 0;
         }

         class56.method834();
         SoundTask.titlemuteSprite[Client.preferences.muted?1:0].method5783(class89.field1324 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(WorldMapType1.field406 != null) {
               var27 = class89.field1324 + 5;
               var28 = 463;
               byte var31 = 100;
               byte var7 = 35;
               WorldMapType1.field406.method5783(var27, var28);
               var0.drawTextCentered("World" + " " + Client.world, var31 / 2 + var27, var7 / 2 + var28 - 2, 16777215, 0);
               if(World.listFetcher != null) {
                  var1.drawTextCentered("Loading...", var31 / 2 + var27, var7 / 2 + var28 + 12, 16777215, 0);
               } else {
                  var1.drawTextCentered("Click to switch", var31 / 2 + var27, var7 / 2 + var28 + 12, 16777215, 0);
               }
            } else {
               WorldMapType1.field406 = class137.getSprite(MessageNode.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1266871588"
   )
   static final void method304(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         class21.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class131.Viewport_entityCountAtMouse; ++var6) {
         var7 = class131.Viewport_entityIdsAtMouse[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && GameObject.region.getObjectFlags(class230.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = Preferences.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  class21.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + BoundingBox3D.getColTags(65535) + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((Size.field340 & 4) == 4) {
                     class21.addMenuEntry(Client.field961, Client.field962 + " " + "->" + " " + BoundingBox3D.getColTags(65535) + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var19 = var12.actions;
                  if(Client.numberMenuOptions) {
                     var19 = Item.prependIndices(var19);
                  }

                  if(var19 != null) {
                     for(int var20 = 4; var20 >= 0; --var20) {
                        if(var19[var20] != null) {
                           short var15 = 0;
                           if(var20 == 0) {
                              var15 = 3;
                           }

                           if(var20 == 1) {
                              var15 = 4;
                           }

                           if(var20 == 2) {
                              var15 = 5;
                           }

                           if(var20 == 3) {
                              var15 = 6;
                           }

                           if(var20 == 4) {
                              var15 = 1001;
                           }

                           class21.addMenuEntry(var19[var20], BoundingBox3D.getColTags(65535) + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class21.addMenuEntry("Examine", BoundingBox3D.getColTags(65535) + var12.name, 1002, var12.id << 14, var8, var9);
               }
            }

            int var13;
            NPC var14;
            Player var16;
            int[] var26;
            int var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3661 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var14 != var23 && var14.composition.field3661 == 1 && var23.x == var14.x && var14.y == var23.y) {
                        LoginPacket.method3435(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class92.playerIndexesCount;
                  var26 = class92.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16.x == var23.x && var23.y == var16.y) {
                        class28.method268(var16, var26[var28], var8, var9);
                     }
                  }
               }

               LoginPacket.method3435(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var14.composition.field3661 == 1 && var14.x == var24.x && var24.y == var14.y) {
                        LoginPacket.method3435(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class92.playerIndexesCount;
                  var26 = class92.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var24 != var16 && var16.x == var24.x && var16.y == var24.y) {
                        class28.method268(var16, var26[var28], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field972) {
                  class28.method268(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class230.plane][var8][var9];
               if(var25 != null) {
                  for(Item var29 = (Item)var25.getTail(); var29 != null; var29 = (Item)var25.getPrevious()) {
                     ItemComposition var27 = ContextMenuRow.getItemDefinition(var29.id);
                     if(Client.itemSelectionState == 1) {
                        class21.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + BoundingBox3D.getColTags(16748608) + var27.name, 16, var29.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((Size.field340 & 1) == 1) {
                           class21.addMenuEntry(Client.field961, Client.field962 + " " + "->" + " " + BoundingBox3D.getColTags(16748608) + var27.name, 17, var29.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var27.groundActions;
                        if(Client.numberMenuOptions) {
                           var21 = Item.prependIndices(var21);
                        }

                        for(int var22 = 4; var22 >= 0; --var22) {
                           if(var21 != null && var21[var22] != null) {
                              byte var17 = 0;
                              if(var22 == 0) {
                                 var17 = 18;
                              }

                              if(var22 == 1) {
                                 var17 = 19;
                              }

                              if(var22 == 2) {
                                 var17 = 20;
                              }

                              if(var22 == 3) {
                                 var17 = 21;
                              }

                              if(var22 == 4) {
                                 var17 = 22;
                              }

                              class21.addMenuEntry(var21[var22], BoundingBox3D.getColTags(16748608) + var27.name, var17, var29.id, var8, var9);
                           } else if(var22 == 2) {
                              class21.addMenuEntry("Take", BoundingBox3D.getColTags(16748608) + var27.name, 20, var29.id, var8, var9);
                           }
                        }

                        class21.addMenuEntry("Examine", BoundingBox3D.getColTags(16748608) + var27.name, 1004, var29.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field972];
         class28.method268(var18, Client.field972, var6, var7);
      }

   }
}
