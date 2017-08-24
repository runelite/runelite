import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("o")
   static Thread field1668;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Ldz;"
   )
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2055();
            }
         }
      } catch (Exception var4) {
         class150.method2975((String)null, var4);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;Ljm;ZI)V",
      garbageValue = "-501203843"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class91.field1435 = (class91.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1435 + 202;
         Ignore.field874 = class91.loginWindowX + 180;
      }

      byte var4;
      int var5;
      int var7;
      int var8;
      int var11;
      int var12;
      int var29;
      int var31;
      int var36;
      int var38;
      int var39;
      if(class91.worldSelectShown) {
         if(class41.field572 == null) {
            class41.field572 = class10.method62(GrandExchangeOffer.indexSprites, "sl_back", "");
         }

         if(Script.field1549 == null) {
            Script.field1549 = class139.method2909(GrandExchangeOffer.indexSprites, "sl_flags", "");
         }

         if(class25.field383 == null) {
            class25.field383 = class139.method2909(GrandExchangeOffer.indexSprites, "sl_arrows", "");
         }

         if(class73.field895 == null) {
            class73.field895 = class139.method2909(GrandExchangeOffer.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.method4890(class91.field1435, 23, 765, 480, 0);
         Rasterizer2D.method4885(class91.field1435, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method4885(class91.field1435 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4755("Select a world", class91.field1435 + 62, 15, 0, -1);
         if(class73.field895 != null) {
            class73.field895[1].method4983(class91.field1435 + 140, 1);
            var1.method4773("Members only world", class91.field1435 + 152, 10, 16777215, -1);
            class73.field895[0].method4983(class91.field1435 + 140, 12);
            var1.method4773("Free world", class91.field1435 + 152, 21, 16777215, -1);
         }

         if(class25.field383 != null) {
            var29 = class91.field1435 + 280;
            if(World.field1303[0] == 0 && World.field1302[0] == 0) {
               class25.field383[2].method4983(var29, 4);
            } else {
               class25.field383[0].method4983(var29, 4);
            }

            if(World.field1303[0] == 0 && World.field1302[0] == 1) {
               class25.field383[3].method4983(var29 + 15, 4);
            } else {
               class25.field383[1].method4983(var29 + 15, 4);
            }

            var0.method4773("World", var29 + 32, 17, 16777215, -1);
            var5 = class91.field1435 + 390;
            if(World.field1303[0] == 1 && World.field1302[0] == 0) {
               class25.field383[2].method4983(var5, 4);
            } else {
               class25.field383[0].method4983(var5, 4);
            }

            if(World.field1303[0] == 1 && World.field1302[0] == 1) {
               class25.field383[3].method4983(var5 + 15, 4);
            } else {
               class25.field383[1].method4983(var5 + 15, 4);
            }

            var0.method4773("Players", var5 + 32, 17, 16777215, -1);
            var31 = class91.field1435 + 500;
            if(World.field1303[0] == 2 && World.field1302[0] == 0) {
               class25.field383[2].method4983(var31, 4);
            } else {
               class25.field383[0].method4983(var31, 4);
            }

            if(World.field1303[0] == 2 && World.field1302[0] == 1) {
               class25.field383[3].method4983(var31 + 15, 4);
            } else {
               class25.field383[1].method4983(var31 + 15, 4);
            }

            var0.method4773("Location", var31 + 32, 17, 16777215, -1);
            var7 = class91.field1435 + 610;
            if(World.field1303[0] == 3 && World.field1302[0] == 0) {
               class25.field383[2].method4983(var7, 4);
            } else {
               class25.field383[0].method4983(var7, 4);
            }

            if(World.field1303[0] == 3 && World.field1302[0] == 1) {
               class25.field383[3].method4983(var7 + 15, 4);
            } else {
               class25.field383[1].method4983(var7 + 15, 4);
            }

            var0.method4773("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4890(class91.field1435 + 708, 4, 50, 16, 0);
         var1.method4755("Cancel", class91.field1435 + 708 + 25, 16, 16777215, -1);
         class91.field1465 = -1;
         if(class41.field572 != null) {
            var4 = 88;
            byte var37 = 19;
            var31 = 765 / (var4 + 1);
            var7 = 480 / (var37 + 1);

            do {
               var8 = var7;
               var36 = var31;
               if(var7 * (var31 - 1) >= World.worldCount) {
                  --var31;
               }

               if(var31 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }

               if(var31 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }
            } while(var7 != var8 || var31 != var36);

            var8 = (765 - var31 * var4) / (var31 + 1);
            if(var8 > 5) {
               var8 = 5;
            }

            var36 = (480 - var7 * var37) / (var7 + 1);
            if(var36 > 5) {
               var36 = 5;
            }

            var38 = (765 - var4 * var31 - var8 * (var31 - 1)) / 2;
            var11 = (480 - var7 * var37 - var36 * (var7 - 1)) / 2;
            var12 = var11 + 23;
            var39 = var38 + class91.field1435;
            int var40 = 0;
            boolean var41 = false;

            int var42;
            for(var42 = 0; var42 < World.worldCount; ++var42) {
               World var17 = World.worldList[var42];
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
               if(var17.method1551()) {
                  if(var17.method1550()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method1554()) {
                  var21 = 16711680;
                  if(var17.method1550()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method1552()) {
                  if(var17.method1550()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method1550()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(MouseInput.field752 >= var39 && MouseInput.field747 >= var12 && MouseInput.field752 < var4 + var39 && MouseInput.field747 < var37 + var12 && var18) {
                  class91.field1465 = var42;
                  class41.field572[var20].method5023(var39, var12, 128, 16777215);
                  var41 = true;
               } else {
                  class41.field572[var20].method5017(var39, var12);
               }

               if(Script.field1549 != null) {
                  Script.field1549[(var17.method1550()?8:0) + var17.location].method4983(var39 + 29, var12);
               }

               var0.method4755(Integer.toString(var17.id), var39 + 15, var37 / 2 + var12 + 5, var21, -1);
               var1.method4755(var19, var39 + 60, var37 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var36 + var37;
               ++var40;
               if(var40 >= var7) {
                  var12 = var11 + 23;
                  var39 = var39 + var4 + var8;
                  var40 = 0;
               }
            }

            if(var41) {
               var42 = var1.method4775(World.worldList[class91.field1465].activity) + 6;
               int var26 = var1.verticalSpace + 8;
               Rasterizer2D.method4890(MouseInput.field752 - var42 / 2, MouseInput.field747 + 20 + 5, var42, var26, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.field752 - var42 / 2, MouseInput.field747 + 20 + 5, var42, var26, 0);
               var1.method4755(World.worldList[class91.field1465].activity, MouseInput.field752, MouseInput.field747 + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
         }

         class20.field342.vmethod4967(0, 0);
      } else {
         if(var3) {
            class19.field336.method5017(class91.field1435, 0);
            class88.field1405.method5017(class91.field1435 + 382, 0);
            class43.logoSprite.method4983(class91.field1435 + 382 - class43.logoSprite.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4755("RuneScape is loading - please wait...", class91.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4890(class91.loginWindowX + 180 - 150, var5 + 2, class91.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method4890(class91.loginWindowX + 180 - 150 + class91.loadingBarPercentage * 3, var5 + 2, 300 - class91.loadingBarPercentage * 3, 30, 0);
            var0.method4755(class91.loadingText, class91.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var22;
         short var28;
         short var30;
         if(Client.gameState == 20) {
            class91.field1464.method4983(class91.loginWindowX + 180 - class91.field1464.originalWidth / 2, 271 - class91.field1464.height / 2);
            var28 = 201;
            var0.method4755(class91.loginMessage1, class91.loginWindowX + 180, var28, 16776960, 0);
            var29 = var28 + 15;
            var0.method4755(class91.loginMessage2, class91.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var0.method4755(class91.loginMessage3, class91.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var29 += 7;
            if(class91.loginIndex != 4) {
               var0.method4773("Login: ", class91.loginWindowX + 180 - 110, var29, 16777215, 0);
               var30 = 200;

               for(var22 = class44.method659(); var0.method4775(var22) > var30; var22 = var22.substring(0, var22.length() - 1)) {
                  ;
               }

               var0.method4773(FontTypeFace.appendTags(var22), class91.loginWindowX + 180 - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method4773("Password: " + class263.method4703(class91.password), class91.loginWindowX + 180 - 108, var29, 16777215, 0);
               var29 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class91.field1464.method4983(class91.loginWindowX, 171);
            short var6;
            if(class91.loginIndex == 0) {
               var28 = 251;
               var0.method4755("Welcome to RuneScape", class91.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 30;
               var5 = class91.loginWindowX + 180 - 80;
               var6 = 291;
               class17.field317.method4983(var5 - 73, var6 - 20);
               var0.method4789("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class17.field317.method4983(var5 - 73, var6 - 20);
               var0.method4789("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class91.loginIndex == 1) {
               var0.method4755(class91.field1451, class91.loginWindowX + 180, 201, 16776960, 0);
               var28 = 236;
               var0.method4755(class91.loginMessage1, class91.loginWindowX + 180, var28, 16777215, 0);
               var29 = var28 + 15;
               var0.method4755(class91.loginMessage2, class91.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var0.method4755(class91.loginMessage3, class91.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var5 = class91.loginWindowX + 180 - 80;
               var6 = 321;
               class17.field317.method4983(var5 - 73, var6 - 20);
               var0.method4755("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class17.field317.method4983(var5 - 73, var6 - 20);
               var0.method4755("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class91.loginIndex == 2) {
               var28 = 201;
               var0.method4755(class91.loginMessage1, Ignore.field874, var28, 16776960, 0);
               var29 = var28 + 15;
               var0.method4755(class91.loginMessage2, Ignore.field874, var29, 16776960, 0);
               var29 += 15;
               var0.method4755(class91.loginMessage3, Ignore.field874, var29, 16776960, 0);
               var29 += 15;
               var29 += 7;
               var0.method4773("Login: ", Ignore.field874 - 110, var29, 16777215, 0);
               var30 = 200;

               for(var22 = class44.method659(); var0.method4775(var22) > var30; var22 = var22.substring(1)) {
                  ;
               }

               var0.method4773(FontTypeFace.appendTags(var22) + (class91.field1461 == 0 & Client.gameCycle % 40 < 20?Friend.getColTags(16776960) + "|":""), Ignore.field874 - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method4773("Password: " + class263.method4703(class91.password) + (class91.field1461 == 1 & Client.gameCycle % 40 < 20?Friend.getColTags(16776960) + "|":""), Ignore.field874 - 108, var29, 16777215, 0);
               var29 += 15;
               var28 = 277;
               var7 = Ignore.field874 + -117;
               boolean var9 = class91.field1457;
               boolean var10 = class91.field1438;
               IndexedSprite var23 = var9?(var10?class91.field1439:TextureProvider.field1790):(var10?class27.field409:class262.field3624);
               var23.method4983(var7, 277);
               var7 = var7 + var23.originalWidth + 5;
               var1.method4773("Remember username", var7, var28 + 13, 16776960, 0);
               var7 = Ignore.field874 + 24;
               boolean var13 = Buffer.preferences.field1320;
               boolean var14 = class91.field1459;
               IndexedSprite var25 = var13?(var14?class91.field1439:TextureProvider.field1790):(var14?class27.field409:class262.field3624);
               var25.method4983(var7, 277);
               var7 = var7 + var25.originalWidth + 5;
               var1.method4773("Hide username", var7, var28 + 13, 16776960, 0);
               var29 = var28 + 15;
               int var15 = Ignore.field874 - 80;
               short var16 = 321;
               class17.field317.method4983(var15 - 73, var16 - 20);
               var0.method4755("Login", var15, var16 + 5, 16777215, 0);
               var15 = Ignore.field874 + 80;
               class17.field317.method4983(var15 - 73, var16 - 20);
               var0.method4755("Cancel", var15, var16 + 5, 16777215, 0);
               var28 = 357;
               var1.method4755("Forgotten your password? <col=ffffff>Click here.", Ignore.field874, var28, 16776960, 0);
            } else if(class91.loginIndex == 3) {
               var28 = 201;
               var0.method4755("Invalid username or password.", class91.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 20;
               var1.method4755("For accounts created after 24th November 2010, please use your", class91.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var1.method4755("email address to login. Otherwise please login with your username.", class91.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var5 = class91.loginWindowX + 180;
               var6 = 276;
               class17.field317.method4983(var5 - 73, var6 - 20);
               var2.method4755("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180;
               var6 = 326;
               class17.field317.method4983(var5 - 73, var6 - 20);
               var2.method4755("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class91.loginIndex == 4) {
               var0.method4755("Authenticator", class91.loginWindowX + 180, 201, 16776960, 0);
               var28 = 236;
               var0.method4755(class91.loginMessage1, class91.loginWindowX + 180, var28, 16777215, 0);
               var29 = var28 + 15;
               var0.method4755(class91.loginMessage2, class91.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var0.method4755(class91.loginMessage3, class91.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var0.method4773("PIN: " + class263.method4703(class13.field282) + (Client.gameCycle % 40 < 20?Friend.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 108, var29, 16777215, 0);
               var29 -= 8;
               var0.method4773("Trust this computer", class91.loginWindowX + 180 - 9, var29, 16776960, 0);
               var29 += 15;
               var0.method4773("for 30 days: ", class91.loginWindowX + 180 - 9, var29, 16776960, 0);
               var5 = class91.loginWindowX + 180 - 9 + var0.method4775("for 30 days: ") + 15;
               var31 = var29 - var0.verticalSpace;
               IndexedSprite var27;
               if(class91.field1447) {
                  var27 = TextureProvider.field1790;
               } else {
                  var27 = class262.field3624;
               }

               var27.method4983(var5, var31);
               var29 += 15;
               var8 = class91.loginWindowX + 180 - 80;
               short var35 = 321;
               class17.field317.method4983(var8 - 73, var35 - 20);
               var0.method4755("Continue", var8, var35 + 5, 16777215, 0);
               var8 = class91.loginWindowX + 180 + 80;
               class17.field317.method4983(var8 - 73, var35 - 20);
               var0.method4755("Cancel", var8, var35 + 5, 16777215, 0);
               var1.method4755("<u=ff>Can\'t Log In?</u>", class91.loginWindowX + 180, var35 + 36, 255, 0);
            } else if(class91.loginIndex == 5) {
               var0.method4755("Forgotten your password?", class91.loginWindowX + 180, 201, 16776960, 0);
               var28 = 221;
               var2.method4755(class91.loginMessage1, class91.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 15;
               var2.method4755(class91.loginMessage2, class91.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var2.method4755(class91.loginMessage3, class91.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var29 += 14;
               var0.method4773("Username/email: ", class91.loginWindowX + 180 - 145, var29, 16777215, 0);
               var30 = 174;

               for(var22 = class44.method659(); var0.method4775(var22) > var30; var22 = var22.substring(1)) {
                  ;
               }

               var0.method4773(FontTypeFace.appendTags(var22) + (Client.gameCycle % 40 < 20?Friend.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 34, var29, 16777215, 0);
               var29 += 15;
               var7 = class91.loginWindowX + 180 - 80;
               short var32 = 321;
               class17.field317.method4983(var7 - 73, var32 - 20);
               var0.method4755("Recover", var7, var32 + 5, 16777215, 0);
               var7 = class91.loginWindowX + 180 + 80;
               class17.field317.method4983(var7 - 73, var32 - 20);
               var0.method4755("Back", var7, var32 + 5, 16777215, 0);
            } else if(class91.loginIndex == 6) {
               var28 = 201;
               var0.method4755(class91.loginMessage1, class91.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 15;
               var0.method4755(class91.loginMessage2, class91.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var0.method4755(class91.loginMessage3, class91.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var5 = class91.loginWindowX + 180;
               var6 = 321;
               class17.field317.method4983(var5 - 73, var6 - 20);
               var0.method4755("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class91.field1446 > 0) {
            var29 = class91.field1446;
            var30 = 256;
            class91.field1441 += var29 * 128;
            if(class91.field1441 > class81.field1341.length) {
               class91.field1441 -= class81.field1341.length;
               var31 = (int)(Math.random() * 12.0D);
               method2080(class91.field1437[var31]);
            }

            var31 = 0;
            var7 = var29 * 128;
            var8 = (var30 - var29) * 128;

            for(var36 = 0; var36 < var8; ++var36) {
               var38 = Coordinates.field2615[var7 + var31] - var29 * class81.field1341[var31 + class91.field1441 & class81.field1341.length - 1] / 6;
               if(var38 < 0) {
                  var38 = 0;
               }

               Coordinates.field2615[var31++] = var38;
            }

            for(var36 = var30 - var29; var36 < var30; ++var36) {
               var38 = var36 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     Coordinates.field2615[var11 + var38] = 255;
                  } else {
                     Coordinates.field2615[var11 + var38] = 0;
                  }
               }
            }

            if(class91.field1442 > 0) {
               class91.field1442 -= var29 * 4;
            }

            if(class91.field1448 > 0) {
               class91.field1448 -= var29 * 4;
            }

            if(class91.field1442 == 0 && class91.field1448 == 0) {
               var36 = (int)(Math.random() * (double)(2000 / var29));
               if(var36 == 0) {
                  class91.field1442 = 1024;
               }

               if(var36 == 1) {
                  class91.field1448 = 1024;
               }
            }

            for(var36 = 0; var36 < var30 - var29; ++var36) {
               class91.field1434[var36] = class91.field1434[var36 + var29];
            }

            for(var36 = var30 - var29; var36 < var30; ++var36) {
               class91.field1434[var36] = (int)(Math.sin((double)class91.field1450 / 14.0D) * 16.0D + Math.sin((double)class91.field1450 / 15.0D) * 14.0D + Math.sin((double)class91.field1450 / 16.0D) * 12.0D);
               ++class91.field1450;
            }

            class91.field1458 += var29;
            var36 = (var29 + (Client.gameCycle & 1)) / 2;
            if(var36 > 0) {
               for(var38 = 0; var38 < class91.field1458 * 100; ++var38) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  Coordinates.field2615[var11 + (var12 << 7)] = 192;
               }

               class91.field1458 = 0;
               var38 = 0;

               label537:
               while(true) {
                  if(var38 >= var30) {
                     var38 = 0;

                     while(true) {
                        if(var38 >= 128) {
                           break label537;
                        }

                        var11 = 0;

                        for(var12 = -var36; var12 < var30; ++var12) {
                           var39 = var12 * 128;
                           if(var36 + var12 < var30) {
                              var11 += class5.field37[var39 + var38 + var36 * 128];
                           }

                           if(var12 - (var36 + 1) >= 0) {
                              var11 -= class5.field37[var38 + var39 - 128 * (var36 + 1)];
                           }

                           if(var12 >= 0) {
                              Coordinates.field2615[var38 + var39] = var11 / (var36 * 2 + 1);
                           }
                        }

                        ++var38;
                     }
                  }

                  var11 = 0;
                  var12 = var38 * 128;

                  for(var39 = -var36; var39 < 128; ++var39) {
                     if(var39 + var36 < 128) {
                        var11 += Coordinates.field2615[var36 + var39 + var12];
                     }

                     if(var39 - (var36 + 1) >= 0) {
                        var11 -= Coordinates.field2615[var39 + var12 - (var36 + 1)];
                     }

                     if(var39 >= 0) {
                        class5.field37[var12 + var39] = var11 / (var36 * 2 + 1);
                     }
                  }

                  ++var38;
               }
            }

            class91.field1446 = 0;
         }

         FaceNormal.method2917();
         class91.titlemuteSprite[Buffer.preferences.muted?1:0].method4983(class91.field1435 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(WorldMapType1.field446 != null) {
               var29 = class91.field1435 + 5;
               var30 = 463;
               byte var33 = 100;
               byte var34 = 35;
               WorldMapType1.field446.method4983(var29, var30);
               var0.method4755("World" + " " + Client.world, var33 / 2 + var29, var34 / 2 + var30 - 2, 16777215, 0);
               if(class73.listFetcher != null) {
                  var1.method4755("Loading...", var33 / 2 + var29, var34 / 2 + var30 + 12, 16777215, 0);
               } else {
                  var1.method4755("Click to switch", var33 / 2 + var29, var34 / 2 + var30 + 12, 16777215, 0);
               }
            } else {
               WorldMapType1.field446 = Client.getSprite(GrandExchangeOffer.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljx;I)V",
      garbageValue = "1254061542"
   )
   static final void method2080(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class81.field1341.length; ++var2) {
         class81.field1341[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class81.field1341[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class19.field335[var5] = (class81.field1341[var5 - 128] + class81.field1341[var5 - 1] + class81.field1341[var5 + 1] + class81.field1341[var5 + 128]) / 4;
            }
         }

         int[] var8 = class81.field1341;
         class81.field1341 = class19.field335;
         class19.field335 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  class81.field1341[var7] = 0;
               }
            }
         }
      }

   }
}
