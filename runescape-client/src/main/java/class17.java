import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class17 implements Comparator {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("seq_ref")
   static IndexDataBase seq_ref;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -8788198670194285635L
   )
   static long field289;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lj;Lj;I)I",
      garbageValue = "1103405489"
   )
   int method123(class14 var1, class14 var2) {
      return var1.field276.price < var2.field276.price?-1:(var2.field276.price == var1.field276.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method123((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "54114026"
   )
   static void method121() {
      ItemContainer.itemContainers = new HashTable(32);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljn;Ljn;Ljn;ZI)V",
      garbageValue = "-1021970400"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class91.field1361 = (class66.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1361 + 202;
         class256.field3426 = class91.loginWindowX + 180;
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
      if(class91.worldSelectShown) {
         if(class217.field2676 == null) {
            class217.field2676 = class43.method589(Signlink.indexSprites, "sl_back", "");
         }

         if(Tile.field1829 == null) {
            Tile.field1829 = class36.method477(Signlink.indexSprites, "sl_flags", "");
         }

         if(Frames.field2040 == null) {
            Frames.field2040 = class36.method477(Signlink.indexSprites, "sl_arrows", "");
         }

         if(class43.field527 == null) {
            class43.field527 = class36.method477(Signlink.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.method4981(class91.field1361, 23, 765, 480, 0);
         Rasterizer2D.method5001(class91.field1361, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method5001(class91.field1361 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4773("Select a world", class91.field1361 + 62, 15, 0, -1);
         if(class43.field527 != null) {
            class43.field527[1].method5097(class91.field1361 + 140, 1);
            var1.method4770("Members only world", class91.field1361 + 152, 10, 16777215, -1);
            class43.field527[0].method5097(class91.field1361 + 140, 12);
            var1.method4770("Free world", class91.field1361 + 152, 21, 16777215, -1);
         }

         int var37;
         if(Frames.field2040 != null) {
            var33 = class91.field1361 + 280;
            if(World.field1211[0] == 0 && World.field1217[0] == 0) {
               Frames.field2040[2].method5097(var33, 4);
            } else {
               Frames.field2040[0].method5097(var33, 4);
            }

            if(World.field1211[0] == 0 && World.field1217[0] == 1) {
               Frames.field2040[3].method5097(var33 + 15, 4);
            } else {
               Frames.field2040[1].method5097(var33 + 15, 4);
            }

            var0.method4770("World", var33 + 32, 17, 16777215, -1);
            var5 = class91.field1361 + 390;
            if(World.field1211[0] == 1 && World.field1217[0] == 0) {
               Frames.field2040[2].method5097(var5, 4);
            } else {
               Frames.field2040[0].method5097(var5, 4);
            }

            if(World.field1211[0] == 1 && World.field1217[0] == 1) {
               Frames.field2040[3].method5097(var5 + 15, 4);
            } else {
               Frames.field2040[1].method5097(var5 + 15, 4);
            }

            var0.method4770("Players", var5 + 32, 17, 16777215, -1);
            var37 = class91.field1361 + 500;
            if(World.field1211[0] == 2 && World.field1217[0] == 0) {
               Frames.field2040[2].method5097(var37, 4);
            } else {
               Frames.field2040[0].method5097(var37, 4);
            }

            if(World.field1211[0] == 2 && World.field1217[0] == 1) {
               Frames.field2040[3].method5097(var37 + 15, 4);
            } else {
               Frames.field2040[1].method5097(var37 + 15, 4);
            }

            var0.method4770("Location", var37 + 32, 17, 16777215, -1);
            var7 = class91.field1361 + 610;
            if(World.field1211[0] == 3 && World.field1217[0] == 0) {
               Frames.field2040[2].method5097(var7, 4);
            } else {
               Frames.field2040[0].method5097(var7, 4);
            }

            if(World.field1211[0] == 3 && World.field1217[0] == 1) {
               Frames.field2040[3].method5097(var7 + 15, 4);
            } else {
               Frames.field2040[1].method5097(var7 + 15, 4);
            }

            var0.method4770("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4981(class91.field1361 + 708, 4, 50, 16, 0);
         var1.method4773("Cancel", class91.field1361 + 708 + 25, 16, 16777215, -1);
         class91.field1360 = -1;
         if(class217.field2676 != null) {
            var4 = 88;
            byte var39 = 19;
            var37 = 765 / (var4 + 1);
            var7 = 480 / (var39 + 1);

            int var38;
            do {
               var38 = var7;
               var9 = var37;
               if(var7 * (var37 - 1) >= World.worldCount) {
                  --var37;
               }

               if(var37 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }

               if(var37 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }
            } while(var38 != var7 || var9 != var37);

            var38 = (765 - var4 * var37) / (var37 + 1);
            if(var38 > 5) {
               var38 = 5;
            }

            var9 = (480 - var39 * var7) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var37 * var4 - var38 * (var37 - 1)) / 2;
            var11 = (480 - var7 * var39 - var9 * (var7 - 1)) / 2;
            var12 = var11 + 23;
            var13 = var10 + class91.field1361;
            var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.worldCount; ++var16) {
               World var17 = class54.worldList[var16];
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
               if(var17.method1521()) {
                  if(var17.method1516()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method1520()) {
                  var21 = 16711680;
                  if(var17.method1516()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method1519()) {
                  if(var17.method1516()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method1516()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(MouseInput.field681 >= var13 && MouseInput.field676 >= var12 && MouseInput.field681 < var4 + var13 && MouseInput.field676 < var39 + var12 && var18) {
                  class91.field1360 = var16;
                  class217.field2676[var20].method5136(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class217.field2676[var20].method5138(var13, var12);
               }

               if(Tile.field1829 != null) {
                  Tile.field1829[(var17.method1516()?8:0) + var17.location].method5097(var13 + 29, var12);
               }

               var0.method4773(Integer.toString(var17.id), var13 + 15, var39 / 2 + var12 + 5, var21, -1);
               var1.method4773(var19, var13 + 60, var39 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var39 + var9;
               ++var14;
               if(var14 >= var7) {
                  var12 = var11 + 23;
                  var13 = var13 + var4 + var38;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4790(class54.worldList[class91.field1360].activity) + 6;
               int var22 = var1.verticalSpace + 8;
               Rasterizer2D.method4981(MouseInput.field681 - var16 / 2, MouseInput.field676 + 20 + 5, var16, var22, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.field681 - var16 / 2, MouseInput.field676 + 20 + 5, var16, var22, 0);
               var1.method4773(class54.worldList[class91.field1360].activity, MouseInput.field681, MouseInput.field676 + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
         }

         class236.field3227.vmethod5065(0, 0);
      } else {
         if(var3) {
            class243.field3292.method5138(class91.field1361, 0);
            class230.field2910.method5138(class91.field1361 + 382, 0);
            class66.logoSprite.method5097(class91.field1361 + 382 - class66.logoSprite.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4773("RuneScape is loading - please wait...", class91.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4981(class91.loginWindowX + 180 - 150, var5 + 2, class91.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method4981(class91.loadingBarPercentage * 3 + (class91.loginWindowX + 180 - 150), var5 + 2, 300 - class91.loadingBarPercentage * 3, 30, 0);
            var0.method4773(class91.loadingText, class91.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var23;
         String var25;
         String var26;
         char[] var27;
         String var28;
         short var32;
         short var34;
         if(Client.gameState == 20) {
            class91.field1331.method5097(class91.loginWindowX + 180 - class91.field1331.originalWidth / 2, 271 - class91.field1331.height / 2);
            var32 = 201;
            var0.method4773(class91.loginMessage1, class91.loginWindowX + 180, var32, 16776960, 0);
            var33 = var32 + 15;
            var0.method4773(class91.loginMessage2, class91.loginWindowX + 180, var33, 16776960, 0);
            var33 += 15;
            var0.method4773(class91.loginMessage3, class91.loginWindowX + 180, var33, 16776960, 0);
            var33 += 15;
            var33 += 7;
            if(class91.loginIndex != 4) {
               var0.method4770("Login: ", class91.loginWindowX + 180 - 110, var33, 16777215, 0);
               var34 = 200;

               for(var23 = class34.method422(); var0.method4790(var23) > var34; var23 = var23.substring(0, var23.length() - 1)) {
                  ;
               }

               var0.method4770(FontTypeFace.appendTags(var23), class91.loginWindowX + 180 - 70, var33, 16777215, 0);
               var33 += 15;
               var25 = "Password: ";
               var26 = class91.password;
               var12 = var26.length();
               var27 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var27[var14] = '*';
               }

               var28 = new String(var27);
               var0.method4770(var25 + var28, class91.loginWindowX + 180 - 108, var33, 16777215, 0);
               var33 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class91.field1331.method5097(class91.loginWindowX, 171);
            short var6;
            if(class91.loginIndex == 0) {
               var32 = 251;
               var0.method4773("Welcome to RuneScape", class91.loginWindowX + 180, var32, 16776960, 0);
               var33 = var32 + 30;
               var5 = class91.loginWindowX + 180 - 80;
               var6 = 291;
               class273.field3711.method5097(var5 - 73, var6 - 20);
               var0.method4774("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class273.field3711.method5097(var5 - 73, var6 - 20);
               var0.method4774("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class91.loginIndex == 1) {
               var0.method4773(class91.field1334, class91.loginWindowX + 180, 201, 16776960, 0);
               var32 = 236;
               var0.method4773(class91.loginMessage1, class91.loginWindowX + 180, var32, 16777215, 0);
               var33 = var32 + 15;
               var0.method4773(class91.loginMessage2, class91.loginWindowX + 180, var33, 16777215, 0);
               var33 += 15;
               var0.method4773(class91.loginMessage3, class91.loginWindowX + 180, var33, 16777215, 0);
               var33 += 15;
               var5 = class91.loginWindowX + 180 - 80;
               var6 = 321;
               class273.field3711.method5097(var5 - 73, var6 - 20);
               var0.method4773("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class273.field3711.method5097(var5 - 73, var6 - 20);
               var0.method4773("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class91.loginIndex == 2) {
               var32 = 201;
               var0.method4773(class91.loginMessage1, class256.field3426, var32, 16776960, 0);
               var33 = var32 + 15;
               var0.method4773(class91.loginMessage2, class256.field3426, var33, 16776960, 0);
               var33 += 15;
               var0.method4773(class91.loginMessage3, class256.field3426, var33, 16776960, 0);
               var33 += 15;
               var33 += 7;
               var0.method4770("Login: ", class256.field3426 - 110, var33, 16777215, 0);
               var34 = 200;

               for(var23 = class34.method422(); var0.method4790(var23) > var34; var23 = var23.substring(1)) {
                  ;
               }

               var0.method4770(FontTypeFace.appendTags(var23) + (class91.field1356 == 0 & Client.gameCycle % 40 < 20?class222.getColTags(16776960) + "|":""), class256.field3426 - 70, var33, 16777215, 0);
               var33 += 15;
               var25 = "Password: ";
               var26 = class91.password;
               var12 = var26.length();
               var27 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var27[var14] = '*';
               }

               var28 = new String(var27);
               var0.method4770(var25 + var28 + (class91.field1356 == 1 & Client.gameCycle % 40 < 20?class222.getColTags(16776960) + "|":""), class256.field3426 - 108, var33, 16777215, 0);
               var33 += 15;
               var32 = 277;
               var11 = class256.field3426 + -117;
               IndexedSprite var31 = ScriptEvent.method1042(class91.field1352, class91.field1346);
               var31.method5097(var11, var32);
               var11 = var11 + var31.originalWidth + 5;
               var1.method4770("Remember username", var11, var32 + 13, 16776960, 0);
               var11 = class256.field3426 + 24;
               var31 = ScriptEvent.method1042(class70.preferences.field1235, class91.field1354);
               var31.method5097(var11, var32);
               var11 = var11 + var31.originalWidth + 5;
               var1.method4770("Hide username", var11, var32 + 13, 16776960, 0);
               var33 = var32 + 15;
               var13 = class256.field3426 - 80;
               short var41 = 321;
               class273.field3711.method5097(var13 - 73, var41 - 20);
               var0.method4773("Login", var13, var41 + 5, 16777215, 0);
               var13 = class256.field3426 + 80;
               class273.field3711.method5097(var13 - 73, var41 - 20);
               var0.method4773("Cancel", var13, var41 + 5, 16777215, 0);
               var32 = 357;
               var1.method4773("Forgotten your password? <col=ffffff>Click here.", class256.field3426, var32, 16776960, 0);
            } else if(class91.loginIndex == 3) {
               var32 = 201;
               var0.method4773("Invalid username or password.", class91.loginWindowX + 180, var32, 16776960, 0);
               var33 = var32 + 20;
               var1.method4773("For accounts created after 24th November 2010, please use your", class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var1.method4773("email address to login. Otherwise please login with your username.", class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var5 = class91.loginWindowX + 180;
               var6 = 276;
               class273.field3711.method5097(var5 - 73, var6 - 20);
               var2.method4773("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180;
               var6 = 326;
               class273.field3711.method5097(var5 - 73, var6 - 20);
               var2.method4773("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class91.loginIndex == 4) {
               var0.method4773("Authenticator", class91.loginWindowX + 180, 201, 16776960, 0);
               var32 = 236;
               var0.method4773(class91.loginMessage1, class91.loginWindowX + 180, var32, 16777215, 0);
               var33 = var32 + 15;
               var0.method4773(class91.loginMessage2, class91.loginWindowX + 180, var33, 16777215, 0);
               var33 += 15;
               var0.method4773(class91.loginMessage3, class91.loginWindowX + 180, var33, 16777215, 0);
               var33 += 15;
               var23 = "PIN: ";
               var25 = class44.field538;
               var10 = var25.length();
               char[] var42 = new char[var10];

               for(var12 = 0; var12 < var10; ++var12) {
                  var42[var12] = '*';
               }

               String var29 = new String(var42);
               var0.method4770(var23 + var29 + (Client.gameCycle % 40 < 20?class222.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 108, var33, 16777215, 0);
               var33 -= 8;
               var0.method4770("Trust this computer", class91.loginWindowX + 180 - 9, var33, 16776960, 0);
               var33 += 15;
               var0.method4770("for 30 days: ", class91.loginWindowX + 180 - 9, var33, 16776960, 0);
               var9 = 180 + class91.loginWindowX - 9 + var0.method4790("for 30 days: ") + 15;
               var10 = var33 - var0.verticalSpace;
               IndexedSprite var43;
               if(class91.field1355) {
                  var43 = RSCanvas.field617;
               } else {
                  var43 = class91.field1351;
               }

               var43.method5097(var9, var10);
               var33 += 15;
               var12 = class91.loginWindowX + 180 - 80;
               short var40 = 321;
               class273.field3711.method5097(var12 - 73, var40 - 20);
               var0.method4773("Continue", var12, var40 + 5, 16777215, 0);
               var12 = class91.loginWindowX + 180 + 80;
               class273.field3711.method5097(var12 - 73, var40 - 20);
               var0.method4773("Cancel", var12, var40 + 5, 16777215, 0);
               var1.method4773("<u=ff>Can\'t Log In?</u>", class91.loginWindowX + 180, var40 + 36, 255, 0);
            } else if(class91.loginIndex == 5) {
               var0.method4773("Forgotten your password?", class91.loginWindowX + 180, 201, 16776960, 0);
               var32 = 221;
               var2.method4773(class91.loginMessage1, class91.loginWindowX + 180, var32, 16776960, 0);
               var33 = var32 + 15;
               var2.method4773(class91.loginMessage2, class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var2.method4773(class91.loginMessage3, class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var33 += 14;
               var0.method4770("Username/email: ", class91.loginWindowX + 180 - 145, var33, 16777215, 0);
               var34 = 174;

               for(var23 = class34.method422(); var0.method4790(var23) > var34; var23 = var23.substring(1)) {
                  ;
               }

               var0.method4770(FontTypeFace.appendTags(var23) + (Client.gameCycle % 40 < 20?class222.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 34, var33, 16777215, 0);
               var33 += 15;
               var7 = class91.loginWindowX + 180 - 80;
               short var8 = 321;
               class273.field3711.method5097(var7 - 73, var8 - 20);
               var0.method4773("Recover", var7, var8 + 5, 16777215, 0);
               var7 = class91.loginWindowX + 180 + 80;
               class273.field3711.method5097(var7 - 73, var8 - 20);
               var0.method4773("Back", var7, var8 + 5, 16777215, 0);
            } else if(class91.loginIndex == 6) {
               var32 = 201;
               var0.method4773(class91.loginMessage1, class91.loginWindowX + 180, var32, 16776960, 0);
               var33 = var32 + 15;
               var0.method4773(class91.loginMessage2, class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var0.method4773(class91.loginMessage3, class91.loginWindowX + 180, var33, 16776960, 0);
               var33 += 15;
               var5 = class91.loginWindowX + 180;
               var6 = 321;
               class273.field3711.method5097(var5 - 73, var6 - 20);
               var0.method4773("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class91.field1341 > 0) {
            class214.method3918(class91.field1341);
            class91.field1341 = 0;
         }

         class163.method3079();
         class268.titlemuteSprite[class70.preferences.muted?1:0].method5097(class91.field1361 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class20.field307 != null) {
               var33 = class91.field1361 + 5;
               var34 = 463;
               byte var35 = 100;
               byte var36 = 35;
               class20.field307.method5097(var33, var34);
               var0.method4773("World" + " " + Client.world, var35 / 2 + var33, var36 / 2 + var34 - 2, 16777215, 0);
               if(SoundTask.listFetcher != null) {
                  var1.method4773("Loading...", var35 / 2 + var33, var36 / 2 + var34 + 12, 16777215, 0);
               } else {
                  var1.method4773("Click to switch", var35 / 2 + var33, var36 / 2 + var34 + 12, 16777215, 0);
               }
            } else {
               class20.field307 = class72.getSprite(Signlink.indexSprites, "sl_button", "");
            }
         }

      }
   }
}
