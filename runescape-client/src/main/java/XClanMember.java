import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("w")
   @Export("titlemuteSprite")
   static ModIcon[] titlemuteSprite;
   @ObfuscatedName("re")
   static class13 field904;
   @ObfuscatedName("j")
   String field898;
   @ObfuscatedName("a")
   @Export("username")
   String username;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 299237351
   )
   @Export("world")
   int world;
   @ObfuscatedName("r")
   @Export("rank")
   byte rank;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "452325253"
   )
   public static boolean method1140(int var0) {
      return var0 >= class221.field2824.field2816 && var0 <= class221.field2815.field2816 || var0 == class221.field2830.field2816;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZI)V",
      garbageValue = "-1518546957"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class92.field1436 = (class77.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1436 + 202;
      }

      byte var4;
      int var5;
      int var7;
      int var10;
      int var11;
      int var12;
      int var13;
      int var26;
      int var28;
      int var29;
      int var32;
      if(class92.worldSelectShown) {
         if(class92.field1437 == null) {
            class92.field1437 = WorldMapType1.method274(class17.indexSprites, "sl_back", "");
         }

         if(class92.field1418 == null) {
            class92.field1418 = class266.method4774(class17.indexSprites, "sl_flags", "");
         }

         if(class175.field2409 == null) {
            class175.field2409 = class266.method4774(class17.indexSprites, "sl_arrows", "");
         }

         if(class10.field263 == null) {
            class10.field263 = class266.method4774(class17.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.method4921(class92.field1436, 23, 765, 480, 0);
         Rasterizer2D.method4859(class92.field1436, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method4859(class92.field1436 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4734("Select a world", class92.field1436 + 62, 15, 0, -1);
         if(class10.field263 != null) {
            class10.field263[1].method4952(class92.field1436 + 140, 1);
            var1.method4725("Members only world", class92.field1436 + 152, 10, 16777215, -1);
            class10.field263[0].method4952(class92.field1436 + 140, 12);
            var1.method4725("Free world", class92.field1436 + 152, 21, 16777215, -1);
         }

         if(class175.field2409 != null) {
            var26 = class92.field1436 + 280;
            if(World.field1303[0] == 0 && World.field1288[0] == 0) {
               class175.field2409[2].method4952(var26, 4);
            } else {
               class175.field2409[0].method4952(var26, 4);
            }

            if(World.field1303[0] == 0 && World.field1288[0] == 1) {
               class175.field2409[3].method4952(var26 + 15, 4);
            } else {
               class175.field2409[1].method4952(var26 + 15, 4);
            }

            var0.method4725("World", var26 + 32, 17, 16777215, -1);
            var5 = class92.field1436 + 390;
            if(World.field1303[0] == 1 && World.field1288[0] == 0) {
               class175.field2409[2].method4952(var5, 4);
            } else {
               class175.field2409[0].method4952(var5, 4);
            }

            if(World.field1303[0] == 1 && World.field1288[0] == 1) {
               class175.field2409[3].method4952(var5 + 15, 4);
            } else {
               class175.field2409[1].method4952(var5 + 15, 4);
            }

            var0.method4725("Players", var5 + 32, 17, 16777215, -1);
            var28 = class92.field1436 + 500;
            if(World.field1303[0] == 2 && World.field1288[0] == 0) {
               class175.field2409[2].method4952(var28, 4);
            } else {
               class175.field2409[0].method4952(var28, 4);
            }

            if(World.field1303[0] == 2 && World.field1288[0] == 1) {
               class175.field2409[3].method4952(var28 + 15, 4);
            } else {
               class175.field2409[1].method4952(var28 + 15, 4);
            }

            var0.method4725("Location", var28 + 32, 17, 16777215, -1);
            var7 = class92.field1436 + 610;
            if(World.field1303[0] == 3 && World.field1288[0] == 0) {
               class175.field2409[2].method4952(var7, 4);
            } else {
               class175.field2409[0].method4952(var7, 4);
            }

            if(World.field1303[0] == 3 && World.field1288[0] == 1) {
               class175.field2409[3].method4952(var7 + 15, 4);
            } else {
               class175.field2409[1].method4952(var7 + 15, 4);
            }

            var0.method4725("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4921(class92.field1436 + 708, 4, 50, 16, 0);
         var1.method4734("Cancel", class92.field1436 + 708 + 25, 16, 16777215, -1);
         class92.field1448 = -1;
         if(class92.field1437 != null) {
            var4 = 88;
            byte var33 = 19;
            var28 = 765 / (var4 + 1);
            var7 = 480 / (var33 + 1);

            do {
               var29 = var7;
               var32 = var28;
               if((var28 - 1) * var7 >= World.worldCount) {
                  --var28;
               }

               if((var7 - 1) * var28 >= World.worldCount) {
                  --var7;
               }

               if((var7 - 1) * var28 >= World.worldCount) {
                  --var7;
               }
            } while(var29 != var7 || var28 != var32);

            var29 = (765 - var4 * var28) / (var28 + 1);
            if(var29 > 5) {
               var29 = 5;
            }

            var32 = (480 - var33 * var7) / (var7 + 1);
            if(var32 > 5) {
               var32 = 5;
            }

            var10 = (765 - var28 * var4 - (var28 - 1) * var29) / 2;
            var11 = (480 - var7 * var33 - (var7 - 1) * var32) / 2;
            var12 = var11 + 23;
            var13 = var10 + class92.field1436;
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
               if(var17.method1524()) {
                  if(var17.method1561()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method1527()) {
                  var21 = 16711680;
                  if(var17.method1561()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method1521()) {
                  if(var17.method1561()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method1561()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(MouseInput.field722 >= var13 && MouseInput.field723 >= var12 && MouseInput.field722 < var4 + var13 && MouseInput.field723 < var33 + var12 && var18) {
                  class92.field1448 = var16;
                  class92.field1437[var20].method4987(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class92.field1437[var20].method4981(var13, var12);
               }

               if(class92.field1418 != null) {
                  class92.field1418[(var17.method1561()?8:0) + var17.location].method4952(var13 + 29, var12);
               }

               var0.method4734(Integer.toString(var17.id), var13 + 15, var12 + var33 / 2 + 5, var21, -1);
               var1.method4734(var19, var13 + 60, var33 / 2 + var12 + 5, 268435455, -1);
               var12 += var33 + var32;
               ++var14;
               if(var14 >= var7) {
                  var12 = var11 + 23;
                  var13 += var4 + var29;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4721(World.worldList[class92.field1448].activity) + 6;
               int var23 = var1.verticalSpace + 8;
               Rasterizer2D.method4921(MouseInput.field722 - var16 / 2, MouseInput.field723 + 20 + 5, var16, var23, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.field722 - var16 / 2, MouseInput.field723 + 20 + 5, var16, var23, 0);
               var1.method4734(World.worldList[class92.field1448].activity, MouseInput.field722, 20 + MouseInput.field723 + 5 + var1.verticalSpace + 4, 0, -1);
            }
         }

         GZipDecompressor.field2327.vmethod4942(0, 0);
      } else {
         if(var3) {
            XItemContainer.field781.method4981(class92.field1436, 0);
            class8.field245.method4981(class92.field1436 + 382, 0);
            class157.logoSprite.method4952(class92.field1436 + 382 - class157.logoSprite.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4734("RuneScape is loading - please wait...", class92.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class92.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class92.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4921(class92.loginWindowX + 180 - 150, var5 + 2, class92.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method4921(class92.loginWindowX + 180 - 150 + class92.loadingBarPercentage * 3, var5 + 2, 300 - class92.loadingBarPercentage * 3, 30, 0);
            var0.method4734(class92.loadingText, class92.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var22;
         short var25;
         short var27;
         if(Client.gameState == 20) {
            class92.field1419.method4952(class92.loginWindowX + 180 - class92.field1419.originalWidth / 2, 271 - class92.field1419.height / 2);
            var25 = 211;
            var0.method4734(class92.loginMessage1, class92.loginWindowX + 180, var25, 16776960, 0);
            var26 = var25 + 15;
            var0.method4734(class92.loginMessage2, class92.loginWindowX + 180, var26, 16776960, 0);
            var26 += 15;
            var0.method4734(class92.loginMessage3, class92.loginWindowX + 180, var26, 16776960, 0);
            var26 += 15;
            var26 += 10;
            if(class92.loginIndex != 4) {
               var0.method4725("Login: ", class92.loginWindowX + 180 - 110, var26, 16777215, 0);
               var27 = 200;

               for(var22 = class92.username; var0.method4721(var22) > var27; var22 = var22.substring(0, var22.length() - 1)) {
                  ;
               }

               var0.method4725(FontTypeFace.appendTags(var22), class92.loginWindowX + 180 - 70, var26, 16777215, 0);
               var26 += 15;
               var0.method4725("Password: " + class223.method4058(class92.password), class92.loginWindowX + 180 - 108, var26, 16777215, 0);
               var26 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class92.field1419.method4952(class92.loginWindowX, 171);
            short var6;
            if(class92.loginIndex == 0) {
               var25 = 251;
               var0.method4734("Welcome to RuneScape", class92.loginWindowX + 180, var25, 16776960, 0);
               var26 = var25 + 30;
               var5 = class92.loginWindowX + 180 - 80;
               var6 = 291;
               class208.field2595.method4952(var5 - 73, var6 - 20);
               var0.method4681("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class208.field2595.method4952(var5 - 73, var6 - 20);
               var0.method4681("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class92.loginIndex == 1) {
               var0.method4734(class92.field1434, class92.loginWindowX + 180, 211, 16776960, 0);
               var25 = 236;
               var0.method4734(class92.loginMessage1, class92.loginWindowX + 180, var25, 16777215, 0);
               var26 = var25 + 15;
               var0.method4734(class92.loginMessage2, class92.loginWindowX + 180, var26, 16777215, 0);
               var26 += 15;
               var0.method4734(class92.loginMessage3, class92.loginWindowX + 180, var26, 16777215, 0);
               var26 += 15;
               var5 = class92.loginWindowX + 180 - 80;
               var6 = 321;
               class208.field2595.method4952(var5 - 73, var6 - 20);
               var0.method4734("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class208.field2595.method4952(var5 - 73, var6 - 20);
               var0.method4734("Cancel", var5, var6 + 5, 16777215, 0);
            } else {
               short var8;
               if(class92.loginIndex == 2) {
                  var25 = 211;
                  var0.method4734(class92.loginMessage1, class92.loginWindowX + 180, var25, 16776960, 0);
                  var26 = var25 + 15;
                  var0.method4734(class92.loginMessage2, class92.loginWindowX + 180, var26, 16776960, 0);
                  var26 += 15;
                  var0.method4734(class92.loginMessage3, class92.loginWindowX + 180, var26, 16776960, 0);
                  var26 += 15;
                  var26 += 10;
                  var0.method4725("Login: ", class92.loginWindowX + 180 - 110, var26, 16777215, 0);
                  var27 = 200;

                  for(var22 = class92.username; var0.method4721(var22) > var27; var22 = var22.substring(1)) {
                     ;
                  }

                  var0.method4725(FontTypeFace.appendTags(var22) + (class92.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class46.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 70, var26, 16777215, 0);
                  var26 += 15;
                  var0.method4725("Password: " + class223.method4058(class92.password) + (class92.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class46.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 108, var26, 16777215, 0);
                  var26 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  class208.field2595.method4952(var7 - 73, var8 - 20);
                  var0.method4734("Login", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  class208.field2595.method4952(var7 - 73, var8 - 20);
                  var0.method4734("Cancel", var7, var8 + 5, 16777215, 0);
                  var25 = 357;
                  var1.method4734("Forgotten your password? <col=ffffff>Click here.", class92.loginWindowX + 180, var25, 16776960, 0);
               } else if(class92.loginIndex == 3) {
                  var25 = 201;
                  var0.method4734("Invalid username or password.", class92.loginWindowX + 180, var25, 16776960, 0);
                  var26 = var25 + 20;
                  var1.method4734("For accounts created after 24th November 2010, please use your", class92.loginWindowX + 180, var26, 16776960, 0);
                  var26 += 15;
                  var1.method4734("email address to login. Otherwise please login with your username.", class92.loginWindowX + 180, var26, 16776960, 0);
                  var26 += 15;
                  var5 = class92.loginWindowX + 180;
                  var6 = 276;
                  class208.field2595.method4952(var5 - 73, var6 - 20);
                  var2.method4734("Try again", var5, var6 + 5, 16777215, 0);
                  var5 = class92.loginWindowX + 180;
                  var6 = 326;
                  class208.field2595.method4952(var5 - 73, var6 - 20);
                  var2.method4734("Forgotten password?", var5, var6 + 5, 16777215, 0);
               } else if(class92.loginIndex == 4) {
                  var0.method4734("Authenticator", class92.loginWindowX + 180, 211, 16776960, 0);
                  var25 = 236;
                  var0.method4734(class92.loginMessage1, class92.loginWindowX + 180, var25, 16777215, 0);
                  var26 = var25 + 15;
                  var0.method4734(class92.loginMessage2, class92.loginWindowX + 180, var26, 16777215, 0);
                  var26 += 15;
                  var0.method4734(class92.loginMessage3, class92.loginWindowX + 180, var26, 16777215, 0);
                  var26 += 15;
                  var0.method4725("PIN: " + class223.method4058(WallObject.authCode) + (Client.gameCycle % 40 < 20?class46.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 108, var26, 16777215, 0);
                  var26 -= 8;
                  var0.method4725("Trust this computer", class92.loginWindowX + 180 - 9, var26, 16776960, 0);
                  var26 += 15;
                  var0.method4725("for 30 days: ", class92.loginWindowX + 180 - 9, var26, 16776960, 0);
                  var5 = class92.loginWindowX + 180 - 9 + var0.method4721("for 30 days: ") + 15;
                  var28 = var26 - var0.verticalSpace;
                  ModIcon var24;
                  if(class92.field1446) {
                     var24 = class228.field3151;
                  } else {
                     var24 = ISAACCipher.field2431;
                  }

                  var24.method4952(var5, var28);
                  var26 += 15;
                  var29 = class92.loginWindowX + 180 - 80;
                  short var9 = 321;
                  class208.field2595.method4952(var29 - 73, var9 - 20);
                  var0.method4734("Continue", var29, var9 + 5, 16777215, 0);
                  var29 = class92.loginWindowX + 180 + 80;
                  class208.field2595.method4952(var29 - 73, var9 - 20);
                  var0.method4734("Cancel", var29, var9 + 5, 16777215, 0);
                  var1.method4734("<u=ff>Can\'t Log In?</u>", class92.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class92.loginIndex == 5) {
                  var0.method4734("Forgotten your password?", class92.loginWindowX + 180, 201, 16776960, 0);
                  var25 = 221;
                  var2.method4734(class92.loginMessage1, class92.loginWindowX + 180, var25, 16776960, 0);
                  var26 = var25 + 15;
                  var2.method4734(class92.loginMessage2, class92.loginWindowX + 180, var26, 16776960, 0);
                  var26 += 15;
                  var2.method4734(class92.loginMessage3, class92.loginWindowX + 180, var26, 16776960, 0);
                  var26 += 15;
                  var26 += 14;
                  var0.method4725("Username/email: ", class92.loginWindowX + 180 - 145, var26, 16777215, 0);
                  var27 = 174;

                  for(var22 = class92.username; var0.method4721(var22) > var27; var22 = var22.substring(1)) {
                     ;
                  }

                  var0.method4725(FontTypeFace.appendTags(var22) + (Client.gameCycle % 40 < 20?class46.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 34, var26, 16777215, 0);
                  var26 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  class208.field2595.method4952(var7 - 73, var8 - 20);
                  var0.method4734("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  class208.field2595.method4952(var7 - 73, var8 - 20);
                  var0.method4734("Back", var7, var8 + 5, 16777215, 0);
               } else if(class92.loginIndex == 6) {
                  var25 = 211;
                  var0.method4734(class92.loginMessage1, class92.loginWindowX + 180, var25, 16776960, 0);
                  var26 = var25 + 15;
                  var0.method4734(class92.loginMessage2, class92.loginWindowX + 180, var26, 16776960, 0);
                  var26 += 15;
                  var0.method4734(class92.loginMessage3, class92.loginWindowX + 180, var26, 16776960, 0);
                  var26 += 15;
                  var5 = class92.loginWindowX + 180;
                  var6 = 321;
                  class208.field2595.method4952(var5 - 73, var6 - 20);
                  var0.method4734("Back", var5, var6 + 5, 16777215, 0);
               }
            }
         }

         if(class92.field1429 > 0) {
            var26 = class92.field1429;
            var27 = 256;
            class92.field1427 += var26 * 128;
            if(class92.field1427 > Spotanim.field3339.length) {
               class92.field1427 -= Spotanim.field3339.length;
               var28 = (int)(Math.random() * 12.0D);
               class66.method1084(Frames.field2137[var28]);
            }

            var28 = 0;
            var7 = var26 * 128;
            var29 = (var27 - var26) * 128;

            for(var32 = 0; var32 < var29; ++var32) {
               var10 = class168.field2340[var7 + var28] - var26 * Spotanim.field3339[var28 + class92.field1427 & Spotanim.field3339.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class168.field2340[var28++] = var10;
            }

            for(var32 = var27 - var26; var32 < var27; ++var32) {
               var10 = var32 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class168.field2340[var10 + var11] = 255;
                  } else {
                     class168.field2340[var10 + var11] = 0;
                  }
               }
            }

            if(class92.field1447 > 0) {
               class92.field1447 -= var26 * 4;
            }

            if(class92.field1422 > 0) {
               class92.field1422 -= var26 * 4;
            }

            if(class92.field1447 == 0 && class92.field1422 == 0) {
               var32 = (int)(Math.random() * (double)(2000 / var26));
               if(var32 == 0) {
                  class92.field1447 = 1024;
               }

               if(var32 == 1) {
                  class92.field1422 = 1024;
               }
            }

            for(var32 = 0; var32 < var27 - var26; ++var32) {
               class92.field1444[var32] = class92.field1444[var26 + var32];
            }

            for(var32 = var27 - var26; var32 < var27; ++var32) {
               class92.field1444[var32] = (int)(Math.sin((double)class92.field1425 / 14.0D) * 16.0D + Math.sin((double)class92.field1425 / 15.0D) * 14.0D + Math.sin((double)class92.field1425 / 16.0D) * 12.0D);
               ++class92.field1425;
            }

            class92.field1428 += var26;
            var32 = ((Client.gameCycle & 1) + var26) / 2;
            if(var32 > 0) {
               for(var10 = 0; var10 < class92.field1428 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class168.field2340[var11 + (var12 << 7)] = 192;
               }

               class92.field1428 = 0;
               var10 = 0;

               label565:
               while(true) {
                  if(var10 >= var27) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label565;
                        }

                        var11 = 0;

                        for(var12 = -var32; var12 < var27; ++var12) {
                           var13 = var12 * 128;
                           if(var32 + var12 < var27) {
                              var11 += class17.field312[var32 * 128 + var13 + var10];
                           }

                           if(var12 - (var32 + 1) >= 0) {
                              var11 -= class17.field312[var13 + var10 - (var32 + 1) * 128];
                           }

                           if(var12 >= 0) {
                              class168.field2340[var13 + var10] = var11 / (var32 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = var10 * 128;

                  for(var13 = -var32; var13 < 128; ++var13) {
                     if(var32 + var13 < 128) {
                        var11 += class168.field2340[var32 + var13 + var12];
                     }

                     if(var13 - (var32 + 1) >= 0) {
                        var11 -= class168.field2340[var12 + var13 - (var32 + 1)];
                     }

                     if(var13 >= 0) {
                        class17.field312[var12 + var13] = var11 / (var32 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class92.field1429 = 0;
         }

         class40.method552();
         titlemuteSprite[class23.preferences.muted?1:0].method4952(class92.field1436 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(Huffman.field2322 != null) {
               var26 = class92.field1436 + 5;
               var27 = 463;
               byte var31 = 100;
               byte var30 = 35;
               Huffman.field2322.method4952(var26, var27);
               var0.method4734("World" + " " + Client.world, var26 + var31 / 2, var27 + var30 / 2 - 2, 16777215, 0);
               if(class112.worldServersDownload != null) {
                  var1.method4734("Loading...", var26 + var31 / 2, var27 + var30 / 2 + 12, 16777215, 0);
               } else {
                  var1.method4734("Click to switch", var26 + var31 / 2, var27 + var30 / 2 + 12, 16777215, 0);
               }
            } else {
               Huffman.field2322 = ISAACCipher.getSprite(class17.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-280896287"
   )
   static int method1141(int var0, Script var1, boolean var2) {
      Widget var3 = class61.method1038(class83.intStack[--WorldMapType2.intStackSize]);
      if(var0 == 2500) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
