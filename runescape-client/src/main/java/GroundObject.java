import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1683399343
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -11860079
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1426760087
   )
   @Export("x")
   int x;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 610343311
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 158025097
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfr;II)Ljava/lang/String;",
      garbageValue = "1581456833"
   )
   static String method2599(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class272.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class163.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-1744279850"
   )
   static int method2601(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         GrandExchangeEvents.intStackSize -= 3;
         var3 = class82.intStack[GrandExchangeEvents.intStackSize];
         var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
         int var5 = class82.intStack[GrandExchangeEvents.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = class87.getWidget(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class54.field636 = var12;
               } else {
                  class82.field1265 = var12;
               }

               class40.method556(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class54.field636:class82.field1265;
            Widget var10 = class87.getWidget(var9.id);
            var10.children[var9.index] = null;
            class40.method556(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = class87.getWidget(class82.intStack[--GrandExchangeEvents.intStackSize]);
            var9.children = null;
            class40.method556(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = class87.getWidget(class82.intStack[--GrandExchangeEvents.intStackSize]);
               if(var9 != null) {
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 1;
                  if(var2) {
                     class54.field636 = var9;
                  } else {
                     class82.field1265 = var9;
                  }
               } else {
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            GrandExchangeEvents.intStackSize -= 2;
            var3 = class82.intStack[GrandExchangeEvents.intStackSize];
            var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
            Widget var11 = MilliTimer.getWidgetChild(var3, var4);
            if(var11 != null && var4 != -1) {
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 1;
               if(var2) {
                  class54.field636 = var11;
               } else {
                  class82.field1265 = var11;
               }
            } else {
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljp;Ljp;Ljp;ZB)V",
      garbageValue = "5"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class91.field1354 = (class86.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1354 + 202;
         class91.field1348 = class91.loginWindowX + 180;
      }

      byte var4;
      int var5;
      int var10;
      int var12;
      boolean var15;
      boolean var18;
      int var24;
      int var25;
      int var34;
      if(class91.worldSelectShown) {
         if(class46.field570 == null) {
            class46.field570 = class46.getSprites(ContextMenuRow.indexSprites, "sl_back", "");
         }

         if(class31.slFlagSprites == null) {
            class31.slFlagSprites = class210.getIndexedSprites(ContextMenuRow.indexSprites, "sl_flags", "");
         }

         if(BoundingBox3D.slArrowSprites == null) {
            BoundingBox3D.slArrowSprites = class210.getIndexedSprites(ContextMenuRow.indexSprites, "sl_arrows", "");
         }

         if(class37.slStarSprites == null) {
            class37.slStarSprites = class210.getIndexedSprites(ContextMenuRow.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class91.field1354, 23, 765, 480, 0);
         Rasterizer2D.method5149(class91.field1354, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method5149(class91.field1354 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4962("Select a world", class91.field1354 + 62, 15, 0, -1);
         if(class37.slStarSprites != null) {
            class37.slStarSprites[1].method5245(class91.field1354 + 140, 1);
            var1.method4931("Members only world", class91.field1354 + 152, 10, 16777215, -1);
            class37.slStarSprites[0].method5245(class91.field1354 + 140, 12);
            var1.method4931("Free world", class91.field1354 + 152, 21, 16777215, -1);
         }

         int var37;
         int var44;
         if(BoundingBox3D.slArrowSprites != null) {
            var34 = class91.field1354 + 280;
            if(World.field1220[0] == 0 && World.field1219[0] == 0) {
               BoundingBox3D.slArrowSprites[2].method5245(var34, 4);
            } else {
               BoundingBox3D.slArrowSprites[0].method5245(var34, 4);
            }

            if(World.field1220[0] == 0 && World.field1219[0] == 1) {
               BoundingBox3D.slArrowSprites[3].method5245(var34 + 15, 4);
            } else {
               BoundingBox3D.slArrowSprites[1].method5245(var34 + 15, 4);
            }

            var0.method4931("World", var34 + 32, 17, 16777215, -1);
            var5 = class91.field1354 + 390;
            if(World.field1220[0] == 1 && World.field1219[0] == 0) {
               BoundingBox3D.slArrowSprites[2].method5245(var5, 4);
            } else {
               BoundingBox3D.slArrowSprites[0].method5245(var5, 4);
            }

            if(World.field1220[0] == 1 && World.field1219[0] == 1) {
               BoundingBox3D.slArrowSprites[3].method5245(var5 + 15, 4);
            } else {
               BoundingBox3D.slArrowSprites[1].method5245(var5 + 15, 4);
            }

            var0.method4931("Players", var5 + 32, 17, 16777215, -1);
            var37 = class91.field1354 + 500;
            if(World.field1220[0] == 2 && World.field1219[0] == 0) {
               BoundingBox3D.slArrowSprites[2].method5245(var37, 4);
            } else {
               BoundingBox3D.slArrowSprites[0].method5245(var37, 4);
            }

            if(World.field1220[0] == 2 && World.field1219[0] == 1) {
               BoundingBox3D.slArrowSprites[3].method5245(var37 + 15, 4);
            } else {
               BoundingBox3D.slArrowSprites[1].method5245(var37 + 15, 4);
            }

            var0.method4931("Location", var37 + 32, 17, 16777215, -1);
            var44 = class91.field1354 + 610;
            if(World.field1220[0] == 3 && World.field1219[0] == 0) {
               BoundingBox3D.slArrowSprites[2].method5245(var44, 4);
            } else {
               BoundingBox3D.slArrowSprites[0].method5245(var44, 4);
            }

            if(World.field1220[0] == 3 && World.field1219[0] == 1) {
               BoundingBox3D.slArrowSprites[3].method5245(var44 + 15, 4);
            } else {
               BoundingBox3D.slArrowSprites[1].method5245(var44 + 15, 4);
            }

            var0.method4931("Type", var44 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class91.field1354 + 708, 4, 50, 16, 0);
         var1.method4962("Cancel", class91.field1354 + 708 + 25, 16, 16777215, -1);
         class91.field1374 = -1;
         if(class46.field570 != null) {
            var4 = 88;
            byte var38 = 19;
            var37 = 765 / (var4 + 1);
            var44 = 480 / (var38 + 1);

            do {
               var24 = var44;
               var25 = var37;
               if(var44 * (var37 - 1) >= World.worldCount) {
                  --var37;
               }

               if(var37 * (var44 - 1) >= World.worldCount) {
                  --var44;
               }

               if(var37 * (var44 - 1) >= World.worldCount) {
                  --var44;
               }
            } while(var44 != var24 || var25 != var37);

            var24 = (765 - var37 * var4) / (var37 + 1);
            if(var24 > 5) {
               var24 = 5;
            }

            var25 = (480 - var44 * var38) / (var44 + 1);
            if(var25 > 5) {
               var25 = 5;
            }

            var10 = (765 - var4 * var37 - var24 * (var37 - 1)) / 2;
            int var11 = (480 - var44 * var38 - var25 * (var44 - 1)) / 2;
            var12 = var11 + 23;
            int var39 = var10 + class91.field1354;
            int var40 = 0;
            var15 = false;

            int var16;
            for(var16 = 0; var16 < World.worldCount; ++var16) {
               World var41 = World.worldList[var16];
               var18 = true;
               String var19 = Integer.toString(var41.playerCount);
               if(var41.playerCount == -1) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var41.playerCount > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var43 = 0;
               byte var42;
               if(var41.method1599()) {
                  if(var41.method1624()) {
                     var42 = 7;
                  } else {
                     var42 = 6;
                  }
               } else if(var41.method1598()) {
                  var43 = 16711680;
                  if(var41.method1624()) {
                     var42 = 5;
                  } else {
                     var42 = 4;
                  }
               } else if(var41.method1627()) {
                  if(var41.method1624()) {
                     var42 = 3;
                  } else {
                     var42 = 2;
                  }
               } else if(var41.method1624()) {
                  var42 = 1;
               } else {
                  var42 = 0;
               }

               if(MouseInput.field703 >= var39 && MouseInput.field715 * 10625923 >= var12 && MouseInput.field703 < var4 + var39 && MouseInput.field715 * 10625923 < var12 + var38 && var18) {
                  class91.field1374 = var16;
                  class46.field570[var42].method5265(var39, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class46.field570[var42].method5266(var39, var12);
               }

               if(class31.slFlagSprites != null) {
                  class31.slFlagSprites[(var41.method1624()?8:0) + var41.location].method5245(var39 + 29, var12);
               }

               var0.method4962(Integer.toString(var41.id), var39 + 15, var38 / 2 + var12 + 5, var43, -1);
               var1.method4962(var19, var39 + 60, var38 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var38 + var25;
               ++var40;
               if(var40 >= var44) {
                  var12 = var11 + 23;
                  var39 = var39 + var4 + var24;
                  var40 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4925(World.worldList[class91.field1374].activity) + 6;
               int var26 = var1.verticalSpace + 8;
               Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.field703 - var16 / 2, MouseInput.field715 * 10625923 + 20 + 5, var16, var26, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.field703 - var16 / 2, MouseInput.field715 * 10625923 + 20 + 5, var16, var26, 0);
               var1.method4962(World.worldList[class91.field1374].activity, MouseInput.field703, MouseInput.field715 * 10625923 + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
         }

         class86.rasterProvider.drawFull(0, 0);
      } else {
         if(var3) {
            class182.field2511.method5266(class91.field1354, 0);
            class91.field1347.method5266(class91.field1354 + 382, 0);
            class91.logoSprite.method5245(class91.field1354 + 382 - class91.logoSprite.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4962("RuneScape is loading - please wait...", class91.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(class91.loginWindowX + 180 - 150, var5 + 2, class91.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(class91.loadingBarPercentage * 3 + (class91.loginWindowX + 180 - 150), var5 + 2, 300 - class91.loadingBarPercentage * 3, 30, 0);
            var0.method4962(class91.loadingText, class91.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var7;
         String var8;
         String var9;
         String var27;
         String var28;
         short var33;
         short var35;
         if(Client.gameState == 20) {
            class91.field1341.method5245(class91.loginWindowX + 180 - class91.field1341.originalWidth / 2, 271 - class91.field1341.height / 2);
            var33 = 201;
            var0.method4962(class91.loginMessage1, class91.loginWindowX + 180, var33, 16776960, 0);
            var34 = var33 + 15;
            var0.method4962(class91.loginMessage2, class91.loginWindowX + 180, var34, 16776960, 0);
            var34 += 15;
            var0.method4962(class91.loginMessage3, class91.loginWindowX + 180, var34, 16776960, 0);
            var34 += 15;
            var34 += 7;
            if(class91.loginIndex != 4) {
               var0.method4931("Login: ", class91.loginWindowX + 180 - 110, var34, 16777215, 0);
               var35 = 200;
               if(RSCanvas.preferences.hideUsername) {
                  var9 = class91.username;
                  var8 = class277.method5083('*', var9.length());
                  var7 = var8;
               } else {
                  var7 = class91.username;
               }

               for(var7 = var7; var0.method4925(var7) > var35; var7 = var7.substring(0, var7.length() - 1)) {
                  ;
               }

               var0.method4931(FontTypeFace.appendTags(var7), class91.loginWindowX + 180 - 70, var34, 16777215, 0);
               var34 += 15;
               var9 = "Password: ";
               var27 = class91.password;
               var28 = class277.method5083('*', var27.length());
               var0.method4931(var9 + var28, class91.loginWindowX + 180 - 108, var34, 16777215, 0);
               var34 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class91.field1341.method5245(class91.loginWindowX, 171);
            short var6;
            if(class91.loginIndex == 0) {
               var33 = 251;
               var0.method4962("Welcome to RuneScape", class91.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 30;
               var5 = class91.loginWindowX + 180 - 80;
               var6 = 291;
               class91.field1340.method5245(var5 - 73, var6 - 20);
               var0.method4935("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class91.field1340.method5245(var5 - 73, var6 - 20);
               var0.method4935("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class91.loginIndex == 1) {
               var0.method4962(class91.Login_response0, class91.loginWindowX + 180, 201, 16776960, 0);
               var33 = 236;
               var0.method4962(class91.loginMessage1, class91.loginWindowX + 180, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method4962(class91.loginMessage2, class91.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               var0.method4962(class91.loginMessage3, class91.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               var5 = class91.loginWindowX + 180 - 80;
               var6 = 321;
               class91.field1340.method5245(var5 - 73, var6 - 20);
               var0.method4962("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class91.field1340.method5245(var5 - 73, var6 - 20);
               var0.method4962("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class91.loginIndex == 2) {
               var33 = 201;
               var0.method4962(class91.loginMessage1, class91.field1348, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method4962(class91.loginMessage2, class91.field1348, var34, 16776960, 0);
               var34 += 15;
               var0.method4962(class91.loginMessage3, class91.field1348, var34, 16776960, 0);
               var34 += 15;
               var34 += 7;
               var0.method4931("Login: ", class91.field1348 - 110, var34, 16777215, 0);
               var35 = 200;
               if(RSCanvas.preferences.hideUsername) {
                  var9 = class91.username;
                  var8 = class277.method5083('*', var9.length());
                  var7 = var8;
               } else {
                  var7 = class91.username;
               }

               for(var7 = var7; var0.method4925(var7) > var35; var7 = var7.substring(1)) {
                  ;
               }

               var0.method4931(FontTypeFace.appendTags(var7) + (class91.field1339 == 0 & Client.gameCycle % 40 < 20?ISAACCipher.getColTags(16776960) + "|":""), class91.field1348 - 70, var34, 16777215, 0);
               var34 += 15;
               var9 = "Password: ";
               var27 = class91.password;
               var28 = class277.method5083('*', var27.length());
               var0.method4931(var9 + var28 + (class91.field1339 == 1 & Client.gameCycle % 40 < 20?ISAACCipher.getColTags(16776960) + "|":""), class91.field1348 - 108, var34, 16777215, 0);
               var34 += 15;
               var33 = 277;
               var12 = class91.field1348 + -117;
               boolean var14 = class91.Login_isUsernameRemembered;
               var15 = class91.field1364;
               IndexedSprite var29 = var14?(var15?class33.field446:UrlRequester.field2098):(var15?GrandExchangeEvents.field269:Fonts.field3694);
               var29.method5245(var12, var33);
               var12 = var12 + var29.originalWidth + 5;
               var1.method4931("Remember username", var12, var33 + 13, 16776960, 0);
               var12 = class91.field1348 + 24;
               var18 = RSCanvas.preferences.hideUsername;
               boolean var31 = class91.field1360;
               IndexedSprite var17 = var18?(var31?class33.field446:UrlRequester.field2098):(var31?GrandExchangeEvents.field269:Fonts.field3694);
               var17.method5245(var12, var33);
               var12 = var12 + var17.originalWidth + 5;
               var1.method4931("Hide username", var12, var33 + 13, 16776960, 0);
               var34 = var33 + 15;
               int var20 = class91.field1348 - 80;
               short var21 = 321;
               class91.field1340.method5245(var20 - 73, var21 - 20);
               var0.method4962("Login", var20, var21 + 5, 16777215, 0);
               var20 = class91.field1348 + 80;
               class91.field1340.method5245(var20 - 73, var21 - 20);
               var0.method4962("Cancel", var20, var21 + 5, 16777215, 0);
               var33 = 357;
               var1.method4962("Forgotten your password? <col=ffffff>Click here.", class91.field1348, var33, 16776960, 0);
            } else if(class91.loginIndex == 3) {
               var33 = 201;
               var0.method4962("Invalid username or password.", class91.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 20;
               var1.method4962("For accounts created after 24th November 2010, please use your", class91.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var1.method4962("email address to login. Otherwise please login with your username.", class91.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var5 = class91.loginWindowX + 180;
               var6 = 276;
               class91.field1340.method5245(var5 - 73, var6 - 20);
               var2.method4962("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180;
               var6 = 326;
               class91.field1340.method5245(var5 - 73, var6 - 20);
               var2.method4962("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class91.loginIndex == 4) {
               var0.method4962("Authenticator", class91.loginWindowX + 180, 201, 16776960, 0);
               var33 = 236;
               var0.method4962(class91.loginMessage1, class91.loginWindowX + 180, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method4962(class91.loginMessage2, class91.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               var0.method4962(class91.loginMessage3, class91.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               String var22 = "PIN: ";
               var8 = class28.field393;
               var7 = class277.method5083('*', var8.length());
               var0.method4931(var22 + var7 + (Client.gameCycle % 40 < 20?ISAACCipher.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 108, var34, 16777215, 0);
               var34 -= 8;
               var0.method4931("Trust this computer", class91.loginWindowX + 180 - 9, var34, 16776960, 0);
               var34 += 15;
               var0.method4931("for 30 days: ", class91.loginWindowX + 180 - 9, var34, 16776960, 0);
               var25 = 180 + class91.loginWindowX - 9 + var0.method4925("for 30 days: ") + 15;
               var10 = var34 - var0.verticalSpace;
               IndexedSprite var46;
               if(class91.field1369) {
                  var46 = UrlRequester.field2098;
               } else {
                  var46 = Fonts.field3694;
               }

               var46.method5245(var25, var10);
               var34 += 15;
               var12 = class91.loginWindowX + 180 - 80;
               short var13 = 321;
               class91.field1340.method5245(var12 - 73, var13 - 20);
               var0.method4962("Continue", var12, var13 + 5, 16777215, 0);
               var12 = class91.loginWindowX + 180 + 80;
               class91.field1340.method5245(var12 - 73, var13 - 20);
               var0.method4962("Cancel", var12, var13 + 5, 16777215, 0);
               var1.method4962("<u=ff>Can\'t Log In?</u>", class91.loginWindowX + 180, var13 + 36, 255, 0);
            } else if(class91.loginIndex == 5) {
               var0.method4962("Forgotten your password?", class91.loginWindowX + 180, 201, 16776960, 0);
               var33 = 221;
               var2.method4962(class91.loginMessage1, class91.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 15;
               var2.method4962(class91.loginMessage2, class91.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var2.method4962(class91.loginMessage3, class91.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var34 += 14;
               var0.method4931("Username/email: ", class91.loginWindowX + 180 - 145, var34, 16777215, 0);
               var35 = 174;
               if(RSCanvas.preferences.hideUsername) {
                  var9 = class91.username;
                  var8 = class277.method5083('*', var9.length());
                  var7 = var8;
               } else {
                  var7 = class91.username;
               }

               for(var7 = var7; var0.method4925(var7) > var35; var7 = var7.substring(1)) {
                  ;
               }

               var0.method4931(FontTypeFace.appendTags(var7) + (Client.gameCycle % 40 < 20?ISAACCipher.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 34, var34, 16777215, 0);
               var34 += 15;
               var24 = class91.loginWindowX + 180 - 80;
               short var45 = 321;
               class91.field1340.method5245(var24 - 73, var45 - 20);
               var0.method4962("Recover", var24, var45 + 5, 16777215, 0);
               var24 = class91.loginWindowX + 180 + 80;
               class91.field1340.method5245(var24 - 73, var45 - 20);
               var0.method4962("Back", var24, var45 + 5, 16777215, 0);
            } else if(class91.loginIndex == 6) {
               var33 = 201;
               var0.method4962(class91.loginMessage1, class91.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method4962(class91.loginMessage2, class91.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var0.method4962(class91.loginMessage3, class91.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var5 = class91.loginWindowX + 180;
               var6 = 321;
               class91.field1340.method5245(var5 - 73, var6 - 20);
               var0.method4962("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class91.field1368 > 0) {
            Script.method1903(class91.field1368);
            class91.field1368 = 0;
         }

         BoundingBox3D.method62();
         class91.titlemuteSprite[RSCanvas.preferences.muted?1:0].method5245(class91.field1354 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(IntegerToken.field13 != null) {
               var34 = class91.field1354 + 5;
               var35 = 463;
               byte var36 = 100;
               byte var23 = 35;
               IntegerToken.field13.method5245(var34, var35);
               var0.method4962("World" + " " + Client.world, var36 / 2 + var34, var23 / 2 + var35 - 2, 16777215, 0);
               if(ScriptState.listFetcher != null) {
                  var1.method4962("Loading...", var36 / 2 + var34, var23 / 2 + var35 + 12, 16777215, 0);
               } else {
                  var1.method4962("Click to switch", var36 / 2 + var34, var23 / 2 + var35 + 12, 16777215, 0);
               }
            } else {
               IntegerToken.field13 = ClanMember.getSprite(ContextMenuRow.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lid;III)Z",
      garbageValue = "-2048925484"
   )
   public static boolean method2603(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class115.decodeSprite(var3);
         return true;
      }
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-697242736"
   )
   @Export("prependIndices")
   static final String[] prependIndices(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
