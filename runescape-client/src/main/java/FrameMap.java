import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("dh")
   @Export("host")
   static String host;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 659725133
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 619979225
   )
   @Export("count")
   int count;
   @ObfuscatedName("w")
   @Export("types")
   int[] types;
   @ObfuscatedName("s")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;Lkz;ZI)V",
      garbageValue = "-1743793367"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class89.field1301 = (WorldMapType1.canvasWidth - 765) / 2;
         class89.loginWindowX = class89.field1301 + 202;
         class89.field1307 = class89.loginWindowX + 180;
      }

      byte var4;
      int var5;
      int var8;
      boolean var15;
      int var16;
      int var29;
      int var31;
      if(class89.worldSelectShown) {
         if(class56.field618 == null) {
            class56.field618 = BoundingBox2D.getSprites(Tile.indexSprites, "sl_back", "");
         }

         if(class157.slFlagSprites == null) {
            class157.slFlagSprites = class228.getIndexedSprites(Tile.indexSprites, "sl_flags", "");
         }

         if(class46.slArrowSprites == null) {
            class46.slArrowSprites = class228.getIndexedSprites(Tile.indexSprites, "sl_arrows", "");
         }

         if(class263.slStarSprites == null) {
            class263.slStarSprites = class228.getIndexedSprites(Tile.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class89.field1301, 23, 765, 480, 0);
         Rasterizer2D.method5481(class89.field1301, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method5481(class89.field1301 + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawTextCentered("Select a world", class89.field1301 + 62, 15, 0, -1);
         if(class263.slStarSprites != null) {
            class263.slStarSprites[1].method5504(class89.field1301 + 140, 1);
            var1.method5225("Members only world", class89.field1301 + 152, 10, 16777215, -1);
            class263.slStarSprites[0].method5504(class89.field1301 + 140, 12);
            var1.method5225("Free world", class89.field1301 + 152, 21, 16777215, -1);
         }

         int var32;
         if(class46.slArrowSprites != null) {
            var29 = class89.field1301 + 280;
            if(World.field1173[0] == 0 && World.field1171[0] == 0) {
               class46.slArrowSprites[2].method5504(var29, 4);
            } else {
               class46.slArrowSprites[0].method5504(var29, 4);
            }

            if(World.field1173[0] == 0 && World.field1171[0] == 1) {
               class46.slArrowSprites[3].method5504(var29 + 15, 4);
            } else {
               class46.slArrowSprites[1].method5504(var29 + 15, 4);
            }

            var0.method5225("World", var29 + 32, 17, 16777215, -1);
            var5 = class89.field1301 + 390;
            if(World.field1173[0] == 1 && World.field1171[0] == 0) {
               class46.slArrowSprites[2].method5504(var5, 4);
            } else {
               class46.slArrowSprites[0].method5504(var5, 4);
            }

            if(World.field1173[0] == 1 && World.field1171[0] == 1) {
               class46.slArrowSprites[3].method5504(var5 + 15, 4);
            } else {
               class46.slArrowSprites[1].method5504(var5 + 15, 4);
            }

            var0.method5225("Players", var5 + 32, 17, 16777215, -1);
            var31 = class89.field1301 + 500;
            if(World.field1173[0] == 2 && World.field1171[0] == 0) {
               class46.slArrowSprites[2].method5504(var31, 4);
            } else {
               class46.slArrowSprites[0].method5504(var31, 4);
            }

            if(World.field1173[0] == 2 && World.field1171[0] == 1) {
               class46.slArrowSprites[3].method5504(var31 + 15, 4);
            } else {
               class46.slArrowSprites[1].method5504(var31 + 15, 4);
            }

            var0.method5225("Location", var31 + 32, 17, 16777215, -1);
            var32 = class89.field1301 + 610;
            if(World.field1173[0] == 3 && World.field1171[0] == 0) {
               class46.slArrowSprites[2].method5504(var32, 4);
            } else {
               class46.slArrowSprites[0].method5504(var32, 4);
            }

            if(World.field1173[0] == 3 && World.field1171[0] == 1) {
               class46.slArrowSprites[3].method5504(var32 + 15, 4);
            } else {
               class46.slArrowSprites[1].method5504(var32 + 15, 4);
            }

            var0.method5225("Type", var32 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class89.field1301 + 708, 4, 50, 16, 0);
         var1.drawTextCentered("Cancel", class89.field1301 + 708 + 25, 16, 16777215, -1);
         class89.field1335 = -1;
         if(class56.field618 != null) {
            var4 = 88;
            byte var34 = 19;
            var31 = 765 / (var4 + 1);
            var32 = 480 / (var34 + 1);

            int var35;
            do {
               var8 = var32;
               var35 = var31;
               if(var32 * (var31 - 1) >= World.worldCount) {
                  --var31;
               }

               if(var31 * (var32 - 1) >= World.worldCount) {
                  --var32;
               }

               if(var31 * (var32 - 1) >= World.worldCount) {
                  --var32;
               }
            } while(var32 != var8 || var31 != var35);

            var8 = (765 - var4 * var31) / (var31 + 1);
            if(var8 > 5) {
               var8 = 5;
            }

            var35 = (480 - var34 * var32) / (var32 + 1);
            if(var35 > 5) {
               var35 = 5;
            }

            int var36 = (765 - var4 * var31 - var8 * (var31 - 1)) / 2;
            int var37 = (480 - var32 * var34 - var35 * (var32 - 1)) / 2;
            int var12 = var37 + 23;
            int var13 = var36 + class89.field1301;
            int var38 = 0;
            var15 = false;

            for(var16 = 0; var16 < World.worldCount; ++var16) {
               World var17 = class89.worldList[var16];
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
               if(var17.method1621()) {
                  if(var17.method1608()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method1645()) {
                  var21 = 16711680;
                  if(var17.method1608()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method1610()) {
                  if(var17.method1608()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method1608()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(MouseInput.mouseLastX >= var13 && MouseInput.mouseLastY >= var12 && MouseInput.mouseLastX < var4 + var13 && MouseInput.mouseLastY < var12 + var34 && var18) {
                  class89.field1335 = var16;
                  class56.field618[var20].method5540(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class56.field618[var20].method5534(var13, var12);
               }

               if(class157.slFlagSprites != null) {
                  class157.slFlagSprites[(var17.method1608()?8:0) + var17.location].method5504(var13 + 29, var12);
               }

               var0.drawTextCentered(Integer.toString(var17.id), var13 + 15, var34 / 2 + var12 + 5, var21, -1);
               var1.drawTextCentered(var19, var13 + 60, var34 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var35 + var34;
               ++var38;
               if(var38 >= var32) {
                  var12 = var37 + 23;
                  var13 = var13 + var4 + var8;
                  var38 = 0;
               }
            }

            if(var15) {
               var16 = var1.getTextWidth(class89.worldList[class89.field1335].activity) + 6;
               int var39 = var1.verticalSpace + 8;
               Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY + 20 + 5, var16, var39, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY + 20 + 5, var16, var39, 0);
               var1.drawTextCentered(class89.worldList[class89.field1335].activity, MouseInput.mouseLastX, MouseInput.mouseLastY + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
         }

         CombatInfo2.rasterProvider.drawFull(0, 0);
      } else {
         if(var3) {
            class89.field1316.method5534(class89.field1301, 0);
            class295.field3780.method5534(class89.field1301 + 382, 0);
            class7.logoSprite.method5504(class89.field1301 + 382 - class7.logoSprite.originalWidth / 2, 18);
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
         short var28;
         short var30;
         if(Client.gameState == 20) {
            class89.field1302.method5504(class89.loginWindowX + 180 - class89.field1302.originalWidth / 2, 271 - class89.field1302.height / 2);
            var28 = 201;
            var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var28, 16776960, 0);
            var29 = var28 + 15;
            var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var29 += 7;
            if(class89.loginIndex != 4) {
               var0.method5225("Login: ", class89.loginWindowX + 180 - 110, var29, 16777215, 0);
               var30 = 200;
               var23 = class221.preferences.hideUsername?class80.method1781(class89.username):class89.username;

               for(var24 = var23; var0.getTextWidth(var24) > var30; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method5225(FontTypeFace.appendTags(var24), class89.loginWindowX + 180 - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method5225("Password: " + class80.method1781(class89.password), class89.loginWindowX + 180 - 108, var29, 16777215, 0);
               var29 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class89.field1302.method5504(class89.loginWindowX, 171);
            short var6;
            if(class89.loginIndex == 0) {
               var28 = 251;
               var0.drawTextCentered("Welcome to RuneScape", class89.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 30;
               var5 = class89.loginWindowX + 180 - 80;
               var6 = 291;
               class89.field1303.method5504(var5 - 73, var6 - 20);
               var0.method5217("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class89.loginWindowX + 180 + 80;
               class89.field1303.method5504(var5 - 73, var6 - 20);
               var0.method5217("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class89.loginIndex == 1) {
               var0.drawTextCentered(class89.Login_response0, class89.loginWindowX + 180, 201, 16776960, 0);
               var28 = 236;
               var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var28, 16777215, 0);
               var29 = var28 + 15;
               var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var5 = class89.loginWindowX + 180 - 80;
               var6 = 321;
               class89.field1303.method5504(var5 - 73, var6 - 20);
               var0.drawTextCentered("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class89.loginWindowX + 180 + 80;
               class89.field1303.method5504(var5 - 73, var6 - 20);
               var0.drawTextCentered("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class89.loginIndex == 2) {
               var28 = 201;
               var0.drawTextCentered(class89.loginMessage1, class89.field1307, var28, 16776960, 0);
               var29 = var28 + 15;
               var0.drawTextCentered(class89.loginMessage2, class89.field1307, var29, 16776960, 0);
               var29 += 15;
               var0.drawTextCentered(class89.loginMessage3, class89.field1307, var29, 16776960, 0);
               var29 += 15;
               var29 += 7;
               var0.method5225("Login: ", class89.field1307 - 110, var29, 16777215, 0);
               var30 = 200;
               var23 = class221.preferences.hideUsername?class80.method1781(class89.username):class89.username;

               for(var24 = var23; var0.getTextWidth(var24) > var30; var24 = var24.substring(1)) {
                  ;
               }

               var0.method5225(FontTypeFace.appendTags(var24) + (class89.field1300 == 0 & Client.gameCycle % 40 < 20?class1.getColTags(16776960) + "|":""), class89.field1307 - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method5225("Password: " + class80.method1781(class89.password) + (class89.field1300 == 1 & Client.gameCycle % 40 < 20?class1.getColTags(16776960) + "|":""), class89.field1307 - 108, var29, 16777215, 0);
               var29 += 15;
               var28 = 277;
               var8 = class89.field1307 + -117;
               boolean var10 = class89.Login_isUsernameRemembered;
               boolean var11 = class89.field1327;
               IndexedSprite var25 = var10?(var11?MouseRecorder.field761:TextureProvider.field1658):(var11?class89.field1309:class89.field1305);
               var25.method5504(var8, var28);
               var8 = var8 + var25.originalWidth + 5;
               var1.method5225("Remember username", var8, var28 + 13, 16776960, 0);
               var8 = class89.field1307 + 24;
               boolean var14 = class221.preferences.hideUsername;
               var15 = class89.field1328;
               IndexedSprite var27 = var14?(var15?MouseRecorder.field761:TextureProvider.field1658):(var15?class89.field1309:class89.field1305);
               var27.method5504(var8, var28);
               var8 = var8 + var27.originalWidth + 5;
               var1.method5225("Hide username", var8, var28 + 13, 16776960, 0);
               var29 = var28 + 15;
               var16 = class89.field1307 - 80;
               short var22 = 321;
               class89.field1303.method5504(var16 - 73, var22 - 20);
               var0.drawTextCentered("Login", var16, var22 + 5, 16777215, 0);
               var16 = class89.field1307 + 80;
               class89.field1303.method5504(var16 - 73, var22 - 20);
               var0.drawTextCentered("Cancel", var16, var22 + 5, 16777215, 0);
               var28 = 357;
               var1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", class89.field1307, var28, 16776960, 0);
            } else if(class89.loginIndex == 3) {
               var28 = 201;
               var0.drawTextCentered("Invalid username or password.", class89.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 20;
               var1.drawTextCentered("For accounts created after 24th November 2010, please use your", class89.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var1.drawTextCentered("email address to login. Otherwise please login with your username.", class89.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var5 = class89.loginWindowX + 180;
               var6 = 276;
               class89.field1303.method5504(var5 - 73, var6 - 20);
               var2.drawTextCentered("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class89.loginWindowX + 180;
               var6 = 326;
               class89.field1303.method5504(var5 - 73, var6 - 20);
               var2.drawTextCentered("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else {
               short var9;
               if(class89.loginIndex == 4) {
                  var0.drawTextCentered("Authenticator", class89.loginWindowX + 180, 201, 16776960, 0);
                  var28 = 236;
                  var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var28, 16777215, 0);
                  var29 = var28 + 15;
                  var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var29, 16777215, 0);
                  var29 += 15;
                  var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var29, 16777215, 0);
                  var29 += 15;
                  var0.method5225("PIN: " + class80.method1781(Client.field1032) + (Client.gameCycle % 40 < 20?class1.getColTags(16776960) + "|":""), class89.loginWindowX + 180 - 108, var29, 16777215, 0);
                  var29 -= 8;
                  var0.method5225("Trust this computer", class89.loginWindowX + 180 - 9, var29, 16776960, 0);
                  var29 += 15;
                  var0.method5225("for 30 days: ", class89.loginWindowX + 180 - 9, var29, 16776960, 0);
                  var5 = 180 + class89.loginWindowX - 9 + var0.getTextWidth("for 30 days: ") + 15;
                  var31 = var29 - var0.verticalSpace;
                  IndexedSprite var40;
                  if(class89.field1329) {
                     var40 = TextureProvider.field1658;
                  } else {
                     var40 = class89.field1305;
                  }

                  var40.method5504(var5, var31);
                  var29 += 15;
                  var8 = class89.loginWindowX + 180 - 80;
                  var9 = 321;
                  class89.field1303.method5504(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Continue", var8, var9 + 5, 16777215, 0);
                  var8 = class89.loginWindowX + 180 + 80;
                  class89.field1303.method5504(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Cancel", var8, var9 + 5, 16777215, 0);
                  var1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class89.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class89.loginIndex == 5) {
                  var0.drawTextCentered("Forgotten your password?", class89.loginWindowX + 180, 201, 16776960, 0);
                  var28 = 221;
                  var2.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var2.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var2.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 14;
                  var0.method5225("Username/email: ", class89.loginWindowX + 180 - 145, var29, 16777215, 0);
                  var30 = 174;
                  var23 = class221.preferences.hideUsername?class80.method1781(class89.username):class89.username;

                  for(var24 = var23; var0.getTextWidth(var24) > var30; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method5225(FontTypeFace.appendTags(var24) + (Client.gameCycle % 40 < 20?class1.getColTags(16776960) + "|":""), class89.loginWindowX + 180 - 34, var29, 16777215, 0);
                  var29 += 15;
                  var8 = class89.loginWindowX + 180 - 80;
                  var9 = 321;
                  class89.field1303.method5504(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Recover", var8, var9 + 5, 16777215, 0);
                  var8 = class89.loginWindowX + 180 + 80;
                  class89.field1303.method5504(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Back", var8, var9 + 5, 16777215, 0);
               } else if(class89.loginIndex == 6) {
                  var28 = 201;
                  var0.drawTextCentered(class89.loginMessage1, class89.loginWindowX + 180, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.drawTextCentered(class89.loginMessage2, class89.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var0.drawTextCentered(class89.loginMessage3, class89.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var5 = class89.loginWindowX + 180;
                  var6 = 321;
                  class89.field1303.method5504(var5 - 73, var6 - 20);
                  var0.drawTextCentered("Back", var5, var6 + 5, 16777215, 0);
               }
            }
         }

         if(class89.field1334 > 0) {
            Item.method1922(class89.field1334);
            class89.field1334 = 0;
         }

         class214.method3948();
         class18.titlemuteSprite[class221.preferences.muted?1:0].method5504(class89.field1301 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(CombatInfo2.field3434 != null) {
               var29 = class89.field1301 + 5;
               var30 = 463;
               byte var33 = 100;
               byte var7 = 35;
               CombatInfo2.field3434.method5504(var29, var30);
               var0.drawTextCentered("World" + " " + Client.world, var33 / 2 + var29, var7 / 2 + var30 - 2, 16777215, 0);
               if(class238.listFetcher != null) {
                  var1.drawTextCentered("Loading...", var33 / 2 + var29, var7 / 2 + var30 + 12, 16777215, 0);
               } else {
                  var1.drawTextCentered("Click to switch", var33 / 2 + var29, var7 / 2 + var30 + 12, 16777215, 0);
               }
            } else {
               CombatInfo2.field3434 = class221.getSprite(Tile.indexSprites, "sl_button", "");
            }
         }

      }
   }
}
