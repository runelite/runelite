import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public class class89 {
   @ObfuscatedName("t")
   String field1425;
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
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1964086173
   )
   int field1429;
   @ObfuscatedName("cm")
   @Export("socket")
   static Task socket;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1160966763
   )
   int field1433;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "12"
   )
   public static boolean method1718() {
      return class203.field2508 != 0?true:class203.field2509.method3674();
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
         if(XItemContainer.isMembersWorld != var1) {
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
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
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
            var10 = class92.field1470 + 280;
            if(World.field1312[0] == 0 && World.field1318[0] == 0) {
               AbstractByteBuffer.field2422[2].method5025(var10, 4);
            } else {
               AbstractByteBuffer.field2422[0].method5025(var10, 4);
            }

            if(World.field1312[0] == 0 && World.field1318[0] == 1) {
               AbstractByteBuffer.field2422[3].method5025(var10 + 15, 4);
            } else {
               AbstractByteBuffer.field2422[1].method5025(var10 + 15, 4);
            }

            var0.method4790("World", var10 + 32, 17, 16777215, -1);
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
            var11 = class92.field1470 + 500;
            if(World.field1312[0] == 2 && World.field1318[0] == 0) {
               AbstractByteBuffer.field2422[2].method5025(var11, 4);
            } else {
               AbstractByteBuffer.field2422[0].method5025(var11, 4);
            }

            if(World.field1312[0] == 2 && World.field1318[0] == 1) {
               AbstractByteBuffer.field2422[3].method5025(var11 + 15, 4);
            } else {
               AbstractByteBuffer.field2422[1].method5025(var11 + 15, 4);
            }

            var0.method4790("Location", var11 + 32, 17, 16777215, -1);
            var6 = class92.field1470 + 610;
            if(World.field1312[0] == 3 && World.field1318[0] == 0) {
               AbstractByteBuffer.field2422[2].method5025(var6, 4);
            } else {
               AbstractByteBuffer.field2422[0].method5025(var6, 4);
            }

            if(World.field1312[0] == 3 && World.field1318[0] == 1) {
               AbstractByteBuffer.field2422[3].method5025(var6 + 15, 4);
            } else {
               AbstractByteBuffer.field2422[1].method5025(var6 + 15, 4);
            }

            var0.method4790("Type", var6 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4983(class92.field1470 + 708, 4, 50, 16, 0);
         var1.method4757("Cancel", class92.field1470 + 708 + 25, 16, 16777215, -1);
         class92.field1479 = -1;
         if(KitDefinition.field3367 != null) {
            var4 = 88;
            byte var15 = 19;
            var11 = 765 / (var4 + 1);
            var6 = 480 / (var15 + 1);

            while(true) {
               var12 = var6;
               var7 = var11;
               if((var11 - 1) * var6 >= World.worldCount) {
                  --var11;
               }

               if((var6 - 1) * var11 >= World.worldCount) {
                  --var6;
               }

               if((var6 - 1) * var11 >= World.worldCount) {
                  --var6;
               }

               if(var12 == var6 && var7 == var11) {
                  var12 = (765 - var4 * var11) / (var11 + 1);
                  if(var12 > 5) {
                     var12 = 5;
                  }

                  var7 = (480 - var15 * var6) / (var6 + 1);
                  if(var7 > 5) {
                     var7 = 5;
                  }

                  var8 = (765 - var4 * var11 - (var11 - 1) * var12) / 2;
                  var9 = (480 - var15 * var6 - (var6 - 1) * var7) / 2;
                  var13 = var9 + 23;
                  var14 = var8 + class92.field1470;
                  int var16 = 0;
                  boolean var17 = false;

                  int var18;
                  for(var18 = 0; var18 < World.worldCount; ++var18) {
                     World var19 = World.worldList[var18];
                     boolean var20 = true;
                     String var21 = Integer.toString(var19.playerCount);
                     if(var19.playerCount == -1) {
                        var21 = "OFF";
                        var20 = false;
                     } else if(var19.playerCount > 1980) {
                        var21 = "FULL";
                        var20 = false;
                     }

                     int var22 = 0;
                     byte var23;
                     if(var19.method1571()) {
                        if(var19.method1566()) {
                           var23 = 7;
                        } else {
                           var23 = 6;
                        }
                     } else if(var19.method1577()) {
                        var22 = 16711680;
                        if(var19.method1566()) {
                           var23 = 5;
                        } else {
                           var23 = 4;
                        }
                     } else if(var19.method1565()) {
                        if(var19.method1566()) {
                           var23 = 3;
                        } else {
                           var23 = 2;
                        }
                     } else if(var19.method1566()) {
                        var23 = 1;
                     } else {
                        var23 = 0;
                     }

                     if(MouseInput.field748 >= var14 && MouseInput.field749 >= var13 && MouseInput.field748 < var14 + var4 && MouseInput.field749 < var15 + var13 && var20) {
                        class92.field1479 = var18;
                        KitDefinition.field3367[var23].method5049(var14, var13, 128, 16777215);
                        var17 = true;
                     } else {
                        KitDefinition.field3367[var23].method5074(var14, var13);
                     }

                     if(class48.field651 != null) {
                        class48.field651[(var19.method1566()?8:0) + var19.location].method5025(var14 + 29, var13);
                     }

                     var0.method4757(Integer.toString(var19.id), var14 + 15, var13 + var15 / 2 + 5, var22, -1);
                     var1.method4757(var21, var14 + 60, var15 / 2 + var13 + 5, 268435455, -1);
                     var13 += var15 + var7;
                     ++var16;
                     if(var16 >= var6) {
                        var13 = var9 + 23;
                        var14 += var12 + var4;
                        var16 = 0;
                     }
                  }

                  if(var17) {
                     var18 = var1.method4773(World.worldList[class92.field1479].activity) + 6;
                     int var29 = var1.verticalSpace + 8;
                     Rasterizer2D.method4983(MouseInput.field748 - var18 / 2, MouseInput.field749 + 20 + 5, var18, var29, 16777120);
                     Rasterizer2D.drawRectangle(MouseInput.field748 - var18 / 2, MouseInput.field749 + 20 + 5, var18, var29, 0);
                     var1.method4757(World.worldList[class92.field1479].activity, MouseInput.field748, var1.verticalSpace + MouseInput.field749 + 20 + 5 + 4, 0, -1);
                  }
                  break;
               }
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

         String var25;
         String var26;
         String var27;
         String var28;
         short var30;
         short var31;
         if(Client.gameState == 20) {
            class92.field1461.method5025(class92.loginWindowX + 180 - class92.field1461.originalWidth / 2, 271 - class92.field1461.height / 2);
            var30 = 211;
            var0.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16776960, 0);
            var10 = var30 + 15;
            var0.method4757(class92.loginMessage2, class92.loginWindowX + 180, var10, 16776960, 0);
            var10 += 15;
            var0.method4757(class92.loginMessage3, class92.loginWindowX + 180, var10, 16776960, 0);
            var10 += 15;
            var10 += 10;
            if(class92.loginIndex != 4) {
               var0.method4790("Login: ", class92.loginWindowX + 180 - 110, var10, 16777215, 0);
               var31 = 200;

               for(var25 = class92.username; var0.method4773(var25) > var31; var25 = var25.substring(0, var25.length() - 1)) {
                  ;
               }

               var0.method4790(FontTypeFace.appendTags(var25), class92.loginWindowX + 180 - 70, var10, 16777215, 0);
               var10 += 15;
               var26 = "Password: ";
               var27 = class92.password;
               var28 = class265.method4836('*', var27.length());
               var0.method4790(var26 + var28, class92.loginWindowX + 180 - 108, var10, 16777215, 0);
               var10 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class92.field1461.method5025(class92.loginWindowX, 171);
            short var32;
            if(class92.loginIndex == 0) {
               var30 = 251;
               var0.method4757("Welcome to RuneScape", class92.loginWindowX + 180, var30, 16776960, 0);
               var10 = var30 + 30;
               var5 = class92.loginWindowX + 180 - 80;
               var32 = 291;
               class92.field1475.method5025(var5 - 73, var32 - 20);
               var0.method4788("New User", var5 - 73, var32 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1475.method5025(var5 - 73, var32 - 20);
               var0.method4788("Existing User", var5 - 73, var32 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class92.loginIndex == 1) {
               var0.method4757(class92.field1466, class92.loginWindowX + 180, 211, 16776960, 0);
               var30 = 236;
               var0.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16777215, 0);
               var10 = var30 + 15;
               var0.method4757(class92.loginMessage2, class92.loginWindowX + 180, var10, 16777215, 0);
               var10 += 15;
               var0.method4757(class92.loginMessage3, class92.loginWindowX + 180, var10, 16777215, 0);
               var10 += 15;
               var5 = class92.loginWindowX + 180 - 80;
               var32 = 321;
               class92.field1475.method5025(var5 - 73, var32 - 20);
               var0.method4757("Continue", var5, var32 + 5, 16777215, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1475.method5025(var5 - 73, var32 - 20);
               var0.method4757("Cancel", var5, var32 + 5, 16777215, 0);
            } else {
               short var33;
               if(class92.loginIndex == 2) {
                  var30 = 211;
                  var0.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16776960, 0);
                  var10 = var30 + 15;
                  var0.method4757(class92.loginMessage2, class92.loginWindowX + 180, var10, 16776960, 0);
                  var10 += 15;
                  var0.method4757(class92.loginMessage3, class92.loginWindowX + 180, var10, 16776960, 0);
                  var10 += 15;
                  var10 += 10;
                  var0.method4790("Login: ", class92.loginWindowX + 180 - 110, var10, 16777215, 0);
                  var31 = 200;

                  for(var25 = class92.username; var0.method4773(var25) > var31; var25 = var25.substring(1)) {
                     ;
                  }

                  var0.method4790(FontTypeFace.appendTags(var25) + (class92.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class220.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 70, var10, 16777215, 0);
                  var10 += 15;
                  var26 = "Password: ";
                  var27 = class92.password;
                  var28 = class265.method4836('*', var27.length());
                  var0.method4790(var26 + var28 + (class92.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class220.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 108, var10, 16777215, 0);
                  var10 += 15;
                  var9 = class92.loginWindowX + 180 - 80;
                  var33 = 321;
                  class92.field1475.method5025(var9 - 73, var33 - 20);
                  var0.method4757("Login", var9, var33 + 5, 16777215, 0);
                  var9 = 180 + class92.loginWindowX + 80;
                  class92.field1475.method5025(var9 - 73, var33 - 20);
                  var0.method4757("Cancel", var9, var33 + 5, 16777215, 0);
                  var30 = 357;
                  var1.method4757("Forgotten your password? <col=ffffff>Click here.", class92.loginWindowX + 180, var30, 16776960, 0);
               } else if(class92.loginIndex == 3) {
                  var30 = 201;
                  var0.method4757("Invalid username or password.", class92.loginWindowX + 180, var30, 16776960, 0);
                  var10 = var30 + 20;
                  var1.method4757("For accounts created after 24th November 2010, please use your", class92.loginWindowX + 180, var10, 16776960, 0);
                  var10 += 15;
                  var1.method4757("email address to login. Otherwise please login with your username.", class92.loginWindowX + 180, var10, 16776960, 0);
                  var10 += 15;
                  var5 = class92.loginWindowX + 180;
                  var32 = 276;
                  class92.field1475.method5025(var5 - 73, var32 - 20);
                  var2.method4757("Try again", var5, var32 + 5, 16777215, 0);
                  var5 = class92.loginWindowX + 180;
                  var32 = 326;
                  class92.field1475.method5025(var5 - 73, var32 - 20);
                  var2.method4757("Forgotten password?", var5, var32 + 5, 16777215, 0);
               } else if(class92.loginIndex == 4) {
                  var0.method4757("Authenticator", class92.loginWindowX + 180, 211, 16776960, 0);
                  var30 = 236;
                  var0.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16777215, 0);
                  var10 = var30 + 15;
                  var0.method4757(class92.loginMessage2, class92.loginWindowX + 180, var10, 16777215, 0);
                  var10 += 15;
                  var0.method4757(class92.loginMessage3, class92.loginWindowX + 180, var10, 16777215, 0);
                  var10 += 15;
                  var25 = "PIN: ";
                  var26 = class36.authCode;
                  String var34 = class265.method4836('*', var26.length());
                  var0.method4790(var25 + var34 + (Client.gameCycle % 40 < 20?class220.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 108, var10, 16777215, 0);
                  var10 -= 8;
                  var0.method4790("Trust this computer", class92.loginWindowX + 180 - 9, var10, 16776960, 0);
                  var10 += 15;
                  var0.method4790("for 30 days: ", class92.loginWindowX + 180 - 9, var10, 16776960, 0);
                  var7 = class92.loginWindowX + 180 - 9 + var0.method4773("for 30 days: ") + 15;
                  var8 = var10 - var0.verticalSpace;
                  ModIcon var37;
                  if(class92.field1473) {
                     var37 = class224.field2855;
                  } else {
                     var37 = class5.field40;
                  }

                  var37.method5025(var7, var8);
                  var10 += 15;
                  var13 = class92.loginWindowX + 180 - 80;
                  short var24 = 321;
                  class92.field1475.method5025(var13 - 73, var24 - 20);
                  var0.method4757("Continue", var13, var24 + 5, 16777215, 0);
                  var13 = class92.loginWindowX + 180 + 80;
                  class92.field1475.method5025(var13 - 73, var24 - 20);
                  var0.method4757("Cancel", var13, var24 + 5, 16777215, 0);
                  var1.method4757("<u=ff>Can\'t Log In?</u>", class92.loginWindowX + 180, var24 + 36, 255, 0);
               } else if(class92.loginIndex != 5) {
                  if(class92.loginIndex == 6) {
                     var30 = 211;
                     var0.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16776960, 0);
                     var10 = var30 + 15;
                     var0.method4757(class92.loginMessage2, class92.loginWindowX + 180, var10, 16776960, 0);
                     var10 += 15;
                     var0.method4757(class92.loginMessage3, class92.loginWindowX + 180, var10, 16776960, 0);
                     var10 += 15;
                     var5 = class92.loginWindowX + 180;
                     var32 = 321;
                     class92.field1475.method5025(var5 - 73, var32 - 20);
                     var0.method4757("Back", var5, var32 + 5, 16777215, 0);
                  }
               } else {
                  var0.method4757("Forgotten your password?", class92.loginWindowX + 180, 201, 16776960, 0);
                  var30 = 221;
                  var2.method4757(class92.loginMessage1, class92.loginWindowX + 180, var30, 16776960, 0);
                  var10 = var30 + 15;
                  var2.method4757(class92.loginMessage2, class92.loginWindowX + 180, var10, 16776960, 0);
                  var10 += 15;
                  var2.method4757(class92.loginMessage3, class92.loginWindowX + 180, var10, 16776960, 0);
                  var10 += 15;
                  var10 += 14;
                  var0.method4790("Username/email: ", class92.loginWindowX + 180 - 145, var10, 16777215, 0);
                  var31 = 174;

                  for(var25 = class92.username; var0.method4773(var25) > var31; var25 = var25.substring(1)) {
                     ;
                  }

                  var0.method4790(FontTypeFace.appendTags(var25) + (Client.gameCycle % 40 < 20?class220.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 34, var10, 16777215, 0);
                  var10 += 15;
                  var6 = class92.loginWindowX + 180 - 80;
                  var33 = 321;
                  class92.field1475.method5025(var6 - 73, var33 - 20);
                  var0.method4757("Recover", var6, var33 + 5, 16777215, 0);
                  var6 = class92.loginWindowX + 180 + 80;
                  class92.field1475.method5025(var6 - 73, var33 - 20);
                  var0.method4757("Back", var6, var33 + 5, 16777215, 0);
               }
            }
         }

         if(class92.field1456 > 0) {
            var10 = class92.field1456;
            var31 = 256;
            class92.field1452 += var10 * 128;
            if(class92.field1452 > GraphicsObject.field1382.length) {
               class92.field1452 -= GraphicsObject.field1382.length;
               var11 = (int)(Math.random() * 12.0D);
               CacheFile.method2346(class266.field3669[var11]);
            }

            var11 = 0;
            var6 = var10 * 128;
            var12 = (var31 - var10) * 128;

            for(var7 = 0; var7 < var12; ++var7) {
               var8 = class12.field270[var6 + var11] - GraphicsObject.field1382[class92.field1452 + var11 & GraphicsObject.field1382.length - 1] * var10 / 6;
               if(var8 < 0) {
                  var8 = 0;
               }

               class12.field270[var11++] = var8;
            }

            var7 = var31 - var10;

            while(true) {
               if(var7 >= var31) {
                  if(class92.field1457 > 0) {
                     class92.field1457 -= var10 * 4;
                  }

                  if(class92.field1458 > 0) {
                     class92.field1458 -= var10 * 4;
                  }

                  if(class92.field1457 == 0 && class92.field1458 == 0) {
                     var7 = (int)(Math.random() * (double)(2000 / var10));
                     if(var7 == 0) {
                        class92.field1457 = 1024;
                     }

                     if(var7 == 1) {
                        class92.field1458 = 1024;
                     }
                  }

                  for(var7 = 0; var7 < var31 - var10; ++var7) {
                     class92.field1459[var7] = class92.field1459[var10 + var7];
                  }

                  for(var7 = var31 - var10; var7 < var31; ++var7) {
                     class92.field1459[var7] = (int)(Math.sin((double)class92.field1462 / 14.0D) * 16.0D + Math.sin((double)class92.field1462 / 15.0D) * 14.0D + Math.sin((double)class92.field1462 / 16.0D) * 12.0D);
                     ++class92.field1462;
                  }

                  class92.field1465 += var10;
                  var7 = ((Client.gameCycle & 1) + var10) / 2;
                  if(var7 > 0) {
                     for(var8 = 0; var8 < class92.field1465 * 100; ++var8) {
                        var9 = (int)(Math.random() * 124.0D) + 2;
                        var13 = (int)(Math.random() * 128.0D) + 128;
                        class12.field270[var9 + (var13 << 7)] = 192;
                     }

                     class92.field1465 = 0;

                     for(var8 = 0; var8 < var31; ++var8) {
                        var9 = 0;
                        var13 = var8 * 128;

                        for(var14 = -var7; var14 < 128; ++var14) {
                           if(var14 + var7 < 128) {
                              var9 += class12.field270[var14 + var13 + var7];
                           }

                           if(var14 - (var7 + 1) >= 0) {
                              var9 -= class12.field270[var14 + var13 - (var7 + 1)];
                           }

                           if(var14 >= 0) {
                              Ignore.field864[var14 + var13] = var9 / (var7 * 2 + 1);
                           }
                        }
                     }

                     for(var8 = 0; var8 < 128; ++var8) {
                        var9 = 0;

                        for(var13 = -var7; var13 < var31; ++var13) {
                           var14 = var13 * 128;
                           if(var7 + var13 < var31) {
                              var9 += Ignore.field864[var7 * 128 + var14 + var8];
                           }

                           if(var13 - (var7 + 1) >= 0) {
                              var9 -= Ignore.field864[var14 + var8 - (var7 + 1) * 128];
                           }

                           if(var13 >= 0) {
                              class12.field270[var14 + var8] = var9 / (var7 * 2 + 1);
                           }
                        }
                     }
                  }

                  class92.field1456 = 0;
                  break;
               }

               var8 = var7 * 128;

               for(var9 = 0; var9 < 128; ++var9) {
                  var13 = (int)(Math.random() * 100.0D);
                  if(var13 < 50 && var9 > 10 && var9 < 118) {
                     class12.field270[var9 + var8] = 255;
                  } else {
                     class12.field270[var9 + var8] = 0;
                  }
               }

               ++var7;
            }
         }

         class239.method4269();
         WorldMapType2.titlemuteSprite[class8.settings.muted?1:0].method5025(class92.field1470 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class91.field1445 != null) {
               var10 = class92.field1470 + 5;
               var31 = 463;
               byte var35 = 100;
               byte var36 = 35;
               class91.field1445.method5025(var10, var31);
               var0.method4757("World " + Client.world, var35 / 2 + var10, var31 + var36 / 2 - 2, 16777215, 0);
               if(World.worldServersDownload != null) {
                  var1.method4757("Loading...", var35 / 2 + var10, var31 + var36 / 2 + 12, 16777215, 0);
               } else {
                  var1.method4757("Click to switch", var35 / 2 + var10, var31 + var36 / 2 + 12, 16777215, 0);
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
}
