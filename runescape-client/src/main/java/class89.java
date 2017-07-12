import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public class class89 {
   @ObfuscatedName("cm")
   @Export("socket")
   static Task socket;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1160966763
   )
   int field1433;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1964086173
   )
   int field1429;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1173578823
   )
   int field1427;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1036721047
   )
   int field1428;
   @ObfuscatedName("t")
   String field1425;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZI)V",
      garbageValue = "53127622"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class92.field1470 = (class45.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1470 + 202;
      }

      byte var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var11;
      int var31;
      int var33;
      int var35;
      int var38;
      int var39;
      if(class92.worldSelectShown) {
         if(KitDefinition.field3367 == null) {
            KitDefinition.field3367 = class2.method8(class18.indexSprites, "sl_back", "");
         }

         if(class48.field651 == null) {
            class48.field651 = class64.method1117(class18.indexSprites, "sl_flags", "");
         }

         if(AbstractByteBuffer.field2422 == null) {
            AbstractByteBuffer.field2422 = class64.method1117(class18.indexSprites, "sl_arrows", "");
         }

         if(class61.field768 == null) {
            class61.field768 = class64.method1117(class18.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.method4983(class92.field1470, 23, 765, 480, 0);
         Rasterizer2D.method4937(class92.field1470, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method4937(class92.field1470 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4757("Select a world", class92.field1470 + 62, 15, 0, -1);
         if(class61.field768 != null) {
            class61.field768[1].method5025(class92.field1470 + 140, 1);
            var1.method4790("Members only world", class92.field1470 + 152, 10, 16777215, -1);
            class61.field768[0].method5025(class92.field1470 + 140, 12);
            var1.method4790("Free world", class92.field1470 + 152, 21, 16777215, -1);
         }

         if(AbstractByteBuffer.field2422 != null) {
            var31 = class92.field1470 + 280;
            if(World.field1312[0] == 0 && World.field1318[0] == 0) {
               AbstractByteBuffer.field2422[2].method5025(var31, 4);
            } else {
               AbstractByteBuffer.field2422[0].method5025(var31, 4);
            }

            if(World.field1312[0] == 0 && World.field1318[0] == 1) {
               AbstractByteBuffer.field2422[3].method5025(var31 + 15, 4);
            } else {
               AbstractByteBuffer.field2422[1].method5025(var31 + 15, 4);
            }

            var0.method4790("World", var31 + 32, 17, 16777215, -1);
            var5 = class92.field1470 + 390;
            if(World.field1312[0] == 1 && World.field1318[0] == 0) {
               AbstractByteBuffer.field2422[2].method5025(var5, 4);
            } else {
               AbstractByteBuffer.field2422[0].method5025(var5, 4);
            }

            if(World.field1312[0] == 1 && World.field1318[0] == 1) {
               AbstractByteBuffer.field2422[3].method5025(var5 + 15, 4);
            } else {
               AbstractByteBuffer.field2422[1].method5025(var5 + 15, 4);
            }

            var0.method4790("Players", var5 + 32, 17, 16777215, -1);
            var33 = class92.field1470 + 500;
            if(World.field1312[0] == 2 && World.field1318[0] == 0) {
               AbstractByteBuffer.field2422[2].method5025(var33, 4);
            } else {
               AbstractByteBuffer.field2422[0].method5025(var33, 4);
            }

            if(World.field1312[0] == 2 && World.field1318[0] == 1) {
               AbstractByteBuffer.field2422[3].method5025(var33 + 15, 4);
            } else {
               AbstractByteBuffer.field2422[1].method5025(var33 + 15, 4);
            }

            var0.method4790("Location", var33 + 32, 17, 16777215, -1);
            var7 = class92.field1470 + 610;
            if(World.field1312[0] == 3 && World.field1318[0] == 0) {
               AbstractByteBuffer.field2422[2].method5025(var7, 4);
            } else {
               AbstractByteBuffer.field2422[0].method5025(var7, 4);
            }

            if(World.field1312[0] == 3 && World.field1318[0] == 1) {
               AbstractByteBuffer.field2422[3].method5025(var7 + 15, 4);
            } else {
               AbstractByteBuffer.field2422[1].method5025(var7 + 15, 4);
            }

            var0.method4790("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4983(class92.field1470 + 708, 4, 50, 16, 0);
         var1.method4757("Cancel", class92.field1470 + 708 + 25, 16, 16777215, -1);
         class92.field1479 = -1;
         if(KitDefinition.field3367 != null) {
            var4 = 88;
            byte var37 = 19;
            var33 = 765 / (var4 + 1);
            var7 = 480 / (var37 + 1);

            do {
               var35 = var7;
               var9 = var33;
               if((var33 - 1) * var7 >= World.worldCount) {
                  --var33;
               }

               if((var7 - 1) * var33 >= World.worldCount) {
                  --var7;
               }

               if((var7 - 1) * var33 >= World.worldCount) {
                  --var7;
               }
            } while(var7 != var35 || var33 != var9);

            var35 = (765 - var33 * var4) / (var33 + 1);
            if(var35 > 5) {
               var35 = 5;
            }

            var9 = (480 - var37 * var7) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var33 * var4 - (var33 - 1) * var35) / 2;
            var11 = (480 - var37 * var7 - (var7 - 1) * var9) / 2;
            var38 = var11 + 23;
            var39 = var10 + class92.field1470;
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
               if(var17.method1571()) {
                  if(var17.method1566()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method1577()) {
                  var21 = 16711680;
                  if(var17.method1566()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method1565()) {
                  if(var17.method1566()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method1566()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(MouseInput.field748 >= var39 && MouseInput.field749 >= var38 && MouseInput.field748 < var39 + var4 && MouseInput.field749 < var37 + var38 && var18) {
                  class92.field1479 = var16;
                  KitDefinition.field3367[var20].method5049(var39, var38, 128, 16777215);
                  var15 = true;
               } else {
                  KitDefinition.field3367[var20].method5074(var39, var38);
               }

               if(class48.field651 != null) {
                  class48.field651[(var17.method1566()?8:0) + var17.location].method5025(var39 + 29, var38);
               }

               var0.method4757(Integer.toString(var17.id), var39 + 15, var38 + var37 / 2 + 5, var21, -1);
               var1.method4757(var19, var39 + 60, var38 + var37 / 2 + 5, 268435455, -1);
               var38 += var37 + var9;
               ++var14;
               if(var14 >= var7) {
                  var38 = var11 + 23;
                  var39 += var4 + var35;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4773(World.worldList[class92.field1479].activity) + 6;
               int var27 = var1.verticalSpace + 8;
               Rasterizer2D.method4983(MouseInput.field748 - var16 / 2, 20 + MouseInput.field749 + 5, var16, var27, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.field748 - var16 / 2, MouseInput.field749 + 20 + 5, var16, var27, 0);
               var1.method4757(World.worldList[class92.field1479].activity, MouseInput.field748, var1.verticalSpace + MouseInput.field749 + 20 + 5 + 4, 0, -1);
            }
         }

         class43.field602.vmethod5007(0, 0);
      } else {
         if(var3) {
            class92.field1451.method5074(class92.field1470, 0);
            class3.field19.method5074(class92.field1470 + 382, 0);
            class83.logoSprite.method5025(class92.field1470 + 382 - class83.logoSprite.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4757("RuneScape is loading - please wait...", class92.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class92.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class92.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4983(class92.loginWindowX + 180 - 150, var5 + 2, class92.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method4983(class92.loadingBarPercentage * 3 + (class92.loginWindowX + 180 - 150), var5 + 2, 300 - class92.loadingBarPercentage * 3, 30, 0);
            var0.method4757(class92.loadingText, class92.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var22;
         String var24;
         String var25;
         String var26;
         short var30;
         short var32;
         if(Client.gameState == 20) {
            class92.field1461.method5025(class92.loginWindowX + 180 - class92.field1461.originalWidth / 2, 271 - class92.field1461.height / 2);
            var30 = 211;
            var0.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16776960, 0);
            var31 = var30 + 15;
            var0.method4757(class92.loginMessage2, class92.loginWindowX + 180, var31, 16776960, 0);
            var31 += 15;
            var0.method4757(class92.loginMessage3, class92.loginWindowX + 180, var31, 16776960, 0);
            var31 += 15;
            var31 += 10;
            if(class92.loginIndex != 4) {
               var0.method4790("Login: ", class92.loginWindowX + 180 - 110, var31, 16777215, 0);
               var32 = 200;

               for(var22 = class92.username; var0.method4773(var22) > var32; var22 = var22.substring(0, var22.length() - 1)) {
                  ;
               }

               var0.method4790(FontTypeFace.appendTags(var22), class92.loginWindowX + 180 - 70, var31, 16777215, 0);
               var31 += 15;
               var24 = "Password: ";
               var25 = class92.password;
               var26 = class265.method4836('*', var25.length());
               var0.method4790(var24 + var26, class92.loginWindowX + 180 - 108, var31, 16777215, 0);
               var31 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class92.field1461.method5025(class92.loginWindowX, 171);
            short var6;
            if(class92.loginIndex == 0) {
               var30 = 251;
               var0.method4757("Welcome to RuneScape", class92.loginWindowX + 180, var30, 16776960, 0);
               var31 = var30 + 30;
               var5 = class92.loginWindowX + 180 - 80;
               var6 = 291;
               class92.field1475.method5025(var5 - 73, var6 - 20);
               var0.method4788("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1475.method5025(var5 - 73, var6 - 20);
               var0.method4788("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class92.loginIndex == 1) {
               var0.method4757(class92.field1466, class92.loginWindowX + 180, 211, 16776960, 0);
               var30 = 236;
               var0.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16777215, 0);
               var31 = var30 + 15;
               var0.method4757(class92.loginMessage2, class92.loginWindowX + 180, var31, 16777215, 0);
               var31 += 15;
               var0.method4757(class92.loginMessage3, class92.loginWindowX + 180, var31, 16777215, 0);
               var31 += 15;
               var5 = class92.loginWindowX + 180 - 80;
               var6 = 321;
               class92.field1475.method5025(var5 - 73, var6 - 20);
               var0.method4757("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1475.method5025(var5 - 73, var6 - 20);
               var0.method4757("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class92.loginIndex == 2) {
               var30 = 211;
               var0.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16776960, 0);
               var31 = var30 + 15;
               var0.method4757(class92.loginMessage2, class92.loginWindowX + 180, var31, 16776960, 0);
               var31 += 15;
               var0.method4757(class92.loginMessage3, class92.loginWindowX + 180, var31, 16776960, 0);
               var31 += 15;
               var31 += 10;
               var0.method4790("Login: ", class92.loginWindowX + 180 - 110, var31, 16777215, 0);
               var32 = 200;

               for(var22 = class92.username; var0.method4773(var22) > var32; var22 = var22.substring(1)) {
                  ;
               }

               var0.method4790(FontTypeFace.appendTags(var22) + (class92.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class220.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 70, var31, 16777215, 0);
               var31 += 15;
               var24 = "Password: ";
               var25 = class92.password;
               var26 = class265.method4836('*', var25.length());
               var0.method4790(var24 + var26 + (class92.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class220.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 108, var31, 16777215, 0);
               var31 += 15;
               var11 = class92.loginWindowX + 180 - 80;
               short var12 = 321;
               class92.field1475.method5025(var11 - 73, var12 - 20);
               var0.method4757("Login", var11, var12 + 5, 16777215, 0);
               var11 = 180 + class92.loginWindowX + 80;
               class92.field1475.method5025(var11 - 73, var12 - 20);
               var0.method4757("Cancel", var11, var12 + 5, 16777215, 0);
               var30 = 357;
               var1.method4757("Forgotten your password? <col=ffffff>Click here.", class92.loginWindowX + 180, var30, 16776960, 0);
            } else if(class92.loginIndex == 3) {
               var30 = 201;
               var0.method4757("Invalid username or password.", class92.loginWindowX + 180, var30, 16776960, 0);
               var31 = var30 + 20;
               var1.method4757("For accounts created after 24th November 2010, please use your", class92.loginWindowX + 180, var31, 16776960, 0);
               var31 += 15;
               var1.method4757("email address to login. Otherwise please login with your username.", class92.loginWindowX + 180, var31, 16776960, 0);
               var31 += 15;
               var5 = class92.loginWindowX + 180;
               var6 = 276;
               class92.field1475.method5025(var5 - 73, var6 - 20);
               var2.method4757("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class92.loginWindowX + 180;
               var6 = 326;
               class92.field1475.method5025(var5 - 73, var6 - 20);
               var2.method4757("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class92.loginIndex == 4) {
               var0.method4757("Authenticator", class92.loginWindowX + 180, 211, 16776960, 0);
               var30 = 236;
               var0.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16777215, 0);
               var31 = var30 + 15;
               var0.method4757(class92.loginMessage2, class92.loginWindowX + 180, var31, 16777215, 0);
               var31 += 15;
               var0.method4757(class92.loginMessage3, class92.loginWindowX + 180, var31, 16777215, 0);
               var31 += 15;
               var22 = "PIN: ";
               var24 = class36.authCode;
               String var23 = class265.method4836('*', var24.length());
               var0.method4790(var22 + var23 + (Client.gameCycle % 40 < 20?class220.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 108, var31, 16777215, 0);
               var31 -= 8;
               var0.method4790("Trust this computer", class92.loginWindowX + 180 - 9, var31, 16776960, 0);
               var31 += 15;
               var0.method4790("for 30 days: ", class92.loginWindowX + 180 - 9, var31, 16776960, 0);
               var9 = class92.loginWindowX + 180 - 9 + var0.method4773("for 30 days: ") + 15;
               var10 = var31 - var0.verticalSpace;
               ModIcon var29;
               if(class92.field1473) {
                  var29 = class224.field2855;
               } else {
                  var29 = class5.field40;
               }

               var29.method5025(var9, var10);
               var31 += 15;
               var38 = class92.loginWindowX + 180 - 80;
               short var13 = 321;
               class92.field1475.method5025(var38 - 73, var13 - 20);
               var0.method4757("Continue", var38, var13 + 5, 16777215, 0);
               var38 = class92.loginWindowX + 180 + 80;
               class92.field1475.method5025(var38 - 73, var13 - 20);
               var0.method4757("Cancel", var38, var13 + 5, 16777215, 0);
               var1.method4757("<u=ff>Can\'t Log In?</u>", class92.loginWindowX + 180, var13 + 36, 255, 0);
            } else if(class92.loginIndex == 5) {
               var0.method4757("Forgotten your password?", class92.loginWindowX + 180, 201, 16776960, 0);
               var30 = 221;
               var2.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16776960, 0);
               var31 = var30 + 15;
               var2.method4757(class92.loginMessage2, class92.loginWindowX + 180, var31, 16776960, 0);
               var31 += 15;
               var2.method4757(class92.loginMessage3, class92.loginWindowX + 180, var31, 16776960, 0);
               var31 += 15;
               var31 += 14;
               var0.method4790("Username/email: ", class92.loginWindowX + 180 - 145, var31, 16777215, 0);
               var32 = 174;

               for(var22 = class92.username; var0.method4773(var22) > var32; var22 = var22.substring(1)) {
                  ;
               }

               var0.method4790(FontTypeFace.appendTags(var22) + (Client.gameCycle % 40 < 20?class220.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 34, var31, 16777215, 0);
               var31 += 15;
               var7 = class92.loginWindowX + 180 - 80;
               short var8 = 321;
               class92.field1475.method5025(var7 - 73, var8 - 20);
               var0.method4757("Recover", var7, var8 + 5, 16777215, 0);
               var7 = class92.loginWindowX + 180 + 80;
               class92.field1475.method5025(var7 - 73, var8 - 20);
               var0.method4757("Back", var7, var8 + 5, 16777215, 0);
            } else if(class92.loginIndex == 6) {
               var30 = 211;
               var0.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16776960, 0);
               var31 = var30 + 15;
               var0.method4757(class92.loginMessage2, class92.loginWindowX + 180, var31, 16776960, 0);
               var31 += 15;
               var0.method4757(class92.loginMessage3, class92.loginWindowX + 180, var31, 16776960, 0);
               var31 += 15;
               var5 = class92.loginWindowX + 180;
               var6 = 321;
               class92.field1475.method5025(var5 - 73, var6 - 20);
               var0.method4757("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class92.field1456 > 0) {
            var31 = class92.field1456;
            var32 = 256;
            class92.field1452 += var31 * 128;
            if(class92.field1452 > GraphicsObject.field1382.length) {
               class92.field1452 -= GraphicsObject.field1382.length;
               var33 = (int)(Math.random() * 12.0D);
               CacheFile.method2346(class266.field3669[var33]);
            }

            var33 = 0;
            var7 = var31 * 128;
            var35 = (var32 - var31) * 128;

            for(var9 = 0; var9 < var35; ++var9) {
               var10 = class12.field270[var33 + var7] - var31 * GraphicsObject.field1382[var33 + class92.field1452 & GraphicsObject.field1382.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class12.field270[var33++] = var10;
            }

            for(var9 = var32 - var31; var9 < var32; ++var9) {
               var10 = var9 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var38 = (int)(Math.random() * 100.0D);
                  if(var38 < 50 && var11 > 10 && var11 < 118) {
                     class12.field270[var11 + var10] = 255;
                  } else {
                     class12.field270[var11 + var10] = 0;
                  }
               }
            }

            if(class92.field1457 > 0) {
               class92.field1457 -= var31 * 4;
            }

            if(class92.field1458 > 0) {
               class92.field1458 -= var31 * 4;
            }

            if(class92.field1457 == 0 && class92.field1458 == 0) {
               var9 = (int)(Math.random() * (double)(2000 / var31));
               if(var9 == 0) {
                  class92.field1457 = 1024;
               }

               if(var9 == 1) {
                  class92.field1458 = 1024;
               }
            }

            for(var9 = 0; var9 < var32 - var31; ++var9) {
               class92.field1459[var9] = class92.field1459[var31 + var9];
            }

            for(var9 = var32 - var31; var9 < var32; ++var9) {
               class92.field1459[var9] = (int)(Math.sin((double)class92.field1462 / 14.0D) * 16.0D + Math.sin((double)class92.field1462 / 15.0D) * 14.0D + Math.sin((double)class92.field1462 / 16.0D) * 12.0D);
               ++class92.field1462;
            }

            class92.field1465 += var31;
            var9 = ((Client.gameCycle & 1) + var31) / 2;
            if(var9 > 0) {
               for(var10 = 0; var10 < class92.field1465 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var38 = (int)(Math.random() * 128.0D) + 128;
                  class12.field270[var11 + (var38 << 7)] = 192;
               }

               class92.field1465 = 0;
               var10 = 0;

               label606:
               while(true) {
                  if(var10 >= var32) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label606;
                        }

                        var11 = 0;

                        for(var38 = -var9; var38 < var32; ++var38) {
                           var39 = var38 * 128;
                           if(var38 + var9 < var32) {
                              var11 += Ignore.field864[var9 * 128 + var39 + var10];
                           }

                           if(var38 - (var9 + 1) >= 0) {
                              var11 -= Ignore.field864[var39 + var10 - (var9 + 1) * 128];
                           }

                           if(var38 >= 0) {
                              class12.field270[var39 + var10] = var11 / (var9 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var38 = var10 * 128;

                  for(var39 = -var9; var39 < 128; ++var39) {
                     if(var39 + var9 < 128) {
                        var11 += class12.field270[var9 + var38 + var39];
                     }

                     if(var39 - (var9 + 1) >= 0) {
                        var11 -= class12.field270[var39 + var38 - (var9 + 1)];
                     }

                     if(var39 >= 0) {
                        Ignore.field864[var39 + var38] = var11 / (var9 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class92.field1456 = 0;
         }

         class239.method4269();
         WorldMapType2.titlemuteSprite[class8.preferences.muted?1:0].method5025(class92.field1470 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class91.field1445 != null) {
               var31 = class92.field1470 + 5;
               var32 = 463;
               byte var36 = 100;
               byte var34 = 35;
               class91.field1445.method5025(var31, var32);
               var0.method4757("World" + " " + Client.world, var31 + var36 / 2, var32 + var34 / 2 - 2, 16777215, 0);
               if(World.worldServersDownload != null) {
                  var1.method4757("Loading...", var31 + var36 / 2, var32 + var34 / 2 + 12, 16777215, 0);
               } else {
                  var1.method4757("Click to switch", var31 + var36 / 2, var32 + var34 / 2 + 12, 16777215, 0);
               }
            } else {
               class91.field1445 = DState.getSprite(class18.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "16711935"
   )
   public static void method1721(IndexDataBase var0) {
      Overlay.overlay_ref = var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "-1399848615"
   )
   static void method1719(World var0) {
      if(var0.method1566() != Client.isMembers) {
         Client.isMembers = var0.method1566();
         boolean var1 = var0.method1566();
         if(var1 != XItemContainer.isMembersWorld) {
            ItemComposition.items.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            XItemContainer.isMembersWorld = var1;
         }
      }

      DState.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class33.field481 = Client.socketType == 0?'ꩊ':var0.id + '鱀';
      class37.field529 = Client.socketType == 0?443:var0.id + '썐';
      class96.myWorldPort = class33.field481;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "12"
   )
   public static boolean method1718() {
      return class203.field2508 != 0?true:class203.field2509.method3674();
   }
}
