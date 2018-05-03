import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
   @ObfuscatedName("f")
   @Export("cacheLocations")
   public static String[] cacheLocations;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2022874967
   )
   @Export("objectDefinitionId")
   final int objectDefinitionId;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 276948237
   )
   @Export("decoration")
   final int decoration;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 534624009
   )
   @Export("rotation")
   final int rotation;

   WorldMapDecoration(int var1, int var2, int var3) {
      this.objectDefinitionId = var1;
      this.decoration = var2;
      this.rotation = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)[Ljt;",
      garbageValue = "118"
   )
   static HorizontalAlignment[] method277() {
      return new HorizontalAlignment[]{HorizontalAlignment.field3706, HorizontalAlignment.field3704, HorizontalAlignment.field3702};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lkh;Lkh;Lkh;ZB)V",
      garbageValue = "64"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class90.field1336 = (FaceNormal.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1336 + 202;
         GrandExchangeEvent.field293 = class90.loginWindowX + 180;
      }

      byte var4;
      int var5;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      boolean var18;
      int var36;
      int var38;
      int var43;
      boolean var45;
      if(class90.worldSelectShown) {
         if(ScriptState.field744 == null) {
            ScriptState.field744 = WorldMapType1.getSprites(UnitPriceComparator.indexSprites, "sl_back", "");
         }

         if(class90.slFlagSprites == null) {
            class90.slFlagSprites = class243.getIndexedSprites(UnitPriceComparator.indexSprites, "sl_flags", "");
         }

         if(class3.slArrowSprites == null) {
            class3.slArrowSprites = class243.getIndexedSprites(UnitPriceComparator.indexSprites, "sl_arrows", "");
         }

         if(WorldMapData.slStarSprites == null) {
            WorldMapData.slStarSprites = class243.getIndexedSprites(UnitPriceComparator.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class90.field1336, 23, 765, 480, 0);
         Rasterizer2D.method5840(class90.field1336, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method5840(class90.field1336 + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawTextCentered("Select a world", class90.field1336 + 62, 15, 0, -1);
         if(WorldMapData.slStarSprites != null) {
            WorldMapData.slStarSprites[1].method5898(class90.field1336 + 140, 1);
            var1.method5630("Members only world", class90.field1336 + 152, 10, 16777215, -1);
            WorldMapData.slStarSprites[0].method5898(class90.field1336 + 140, 12);
            var1.method5630("Free world", class90.field1336 + 152, 21, 16777215, -1);
         }

         if(class3.slArrowSprites != null) {
            var36 = class90.field1336 + 280;
            if(World.field1213[0] == 0 && World.field1210[0] == 0) {
               class3.slArrowSprites[2].method5898(var36, 4);
            } else {
               class3.slArrowSprites[0].method5898(var36, 4);
            }

            if(World.field1213[0] == 0 && World.field1210[0] == 1) {
               class3.slArrowSprites[3].method5898(var36 + 15, 4);
            } else {
               class3.slArrowSprites[1].method5898(var36 + 15, 4);
            }

            var0.method5630("World", var36 + 32, 17, 16777215, -1);
            var5 = class90.field1336 + 390;
            if(World.field1213[0] == 1 && World.field1210[0] == 0) {
               class3.slArrowSprites[2].method5898(var5, 4);
            } else {
               class3.slArrowSprites[0].method5898(var5, 4);
            }

            if(World.field1213[0] == 1 && World.field1210[0] == 1) {
               class3.slArrowSprites[3].method5898(var5 + 15, 4);
            } else {
               class3.slArrowSprites[1].method5898(var5 + 15, 4);
            }

            var0.method5630("Players", var5 + 32, 17, 16777215, -1);
            var38 = class90.field1336 + 500;
            if(World.field1213[0] == 2 && World.field1210[0] == 0) {
               class3.slArrowSprites[2].method5898(var38, 4);
            } else {
               class3.slArrowSprites[0].method5898(var38, 4);
            }

            if(World.field1213[0] == 2 && World.field1210[0] == 1) {
               class3.slArrowSprites[3].method5898(var38 + 15, 4);
            } else {
               class3.slArrowSprites[1].method5898(var38 + 15, 4);
            }

            var0.method5630("Location", var38 + 32, 17, 16777215, -1);
            var7 = class90.field1336 + 610;
            if(World.field1213[0] == 3 && World.field1210[0] == 0) {
               class3.slArrowSprites[2].method5898(var7, 4);
            } else {
               class3.slArrowSprites[0].method5898(var7, 4);
            }

            if(World.field1213[0] == 3 && World.field1210[0] == 1) {
               class3.slArrowSprites[3].method5898(var7 + 15, 4);
            } else {
               class3.slArrowSprites[1].method5898(var7 + 15, 4);
            }

            var0.method5630("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class90.field1336 + 708, 4, 50, 16, 0);
         var1.drawTextCentered("Cancel", class90.field1336 + 708 + 25, 16, 16777215, -1);
         class90.field1368 = -1;
         if(ScriptState.field744 != null) {
            var4 = 88;
            byte var42 = 19;
            var38 = 765 / (var4 + 1);
            var7 = 480 / (var42 + 1);

            do {
               var8 = var7;
               var9 = var38;
               if(var7 * (var38 - 1) >= World.worldCount) {
                  --var38;
               }

               if(var38 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }

               if(var38 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }
            } while(var7 != var8 || var38 != var9);

            var8 = (765 - var38 * var4) / (var38 + 1);
            if(var8 > 5) {
               var8 = 5;
            }

            var9 = (480 - var7 * var42) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var4 * var38 - var8 * (var38 - 1)) / 2;
            var11 = (480 - var42 * var7 - var9 * (var7 - 1)) / 2;
            var12 = var11 + 23;
            var13 = var10 + class90.field1336;
            var43 = 0;
            var45 = false;

            int var16;
            for(var16 = 0; var16 < World.worldCount; ++var16) {
               World var46 = class171.worldList[var16];
               var18 = true;
               String var19 = Integer.toString(var46.playerCount);
               if(var46.playerCount == -1) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var46.playerCount > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var48 = 0;
               byte var47;
               if(var46.method1726()) {
                  if(var46.method1727()) {
                     var47 = 7;
                  } else {
                     var47 = 6;
                  }
               } else if(var46.method1746()) {
                  var48 = 16711680;
                  if(var46.method1727()) {
                     var47 = 5;
                  } else {
                     var47 = 4;
                  }
               } else if(var46.method1729()) {
                  if(var46.method1727()) {
                     var47 = 3;
                  } else {
                     var47 = 2;
                  }
               } else if(var46.method1727()) {
                  var47 = 1;
               } else {
                  var47 = 0;
               }

               if(MouseInput.mouseLastX >= var13 && MouseInput.mouseLastY >= var12 && MouseInput.mouseLastX < var13 + var4 && MouseInput.mouseLastY < var12 + var42 && var18) {
                  class90.field1368 = var16;
                  ScriptState.field744[var47].method5919(var13, var12, 128, 16777215);
                  var45 = true;
               } else {
                  ScriptState.field744[var47].method5915(var13, var12);
               }

               if(class90.slFlagSprites != null) {
                  class90.slFlagSprites[(var46.method1727()?8:0) + var46.location].method5898(var13 + 29, var12);
               }

               var0.drawTextCentered(Integer.toString(var46.id), var13 + 15, var42 / 2 + var12 + 5, var48, -1);
               var1.drawTextCentered(var19, var13 + 60, var42 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var42 + var9;
               ++var43;
               if(var43 >= var7) {
                  var12 = var11 + 23;
                  var13 = var13 + var4 + var8;
                  var43 = 0;
               }
            }

            if(var45) {
               var16 = var1.getTextWidth(class171.worldList[class90.field1368].activity) + 6;
               int var22 = var1.verticalSpace + 8;
               Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY + 20 + 5, var16, var22, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY + 20 + 5, var16, var22, 0);
               var1.drawTextCentered(class171.worldList[class90.field1368].activity, MouseInput.mouseLastX, MouseInput.mouseLastY + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
         }

         GrandExchangeOffer.rasterProvider.drawFull(0, 0);
      } else {
         if(var3) {
            class90.field1359.method5915(class90.field1336, 0);
            class90.field1340.method5915(class90.field1336 + 382, 0);
            GrandExchangeOffer.logoSprite.method5898(class90.field1336 + 382 - GrandExchangeOffer.logoSprite.width / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.drawTextCentered("RuneScape is loading - please wait...", class90.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(class90.loginWindowX + 180 - 150, var5 + 2, class90.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(class90.loginWindowX + 180 - 150 + class90.loadingBarPercentage * 3, var5 + 2, 300 - class90.loadingBarPercentage * 3, 30, 0);
            var0.drawTextCentered(class90.loadingText, class90.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         int var15;
         String var23;
         char[] var24;
         String var25;
         String var27;
         String var29;
         char[] var30;
         short var35;
         short var37;
         String var49;
         if(Client.gameState == 20) {
            class90.field1337.method5898(class90.loginWindowX + 180 - class90.field1337.width / 2, 271 - class90.field1337.height / 2);
            var35 = 201;
            var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var35, 16776960, 0);
            var36 = var35 + 15;
            var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var36, 16776960, 0);
            var36 += 15;
            var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var36, 16776960, 0);
            var36 += 15;
            var36 += 7;
            if(class90.loginIndex != 4) {
               var0.method5630("Login: ", class90.loginWindowX + 180 - 110, var36, 16777215, 0);
               var37 = 200;
               if(!Client.preferences.hideUsername) {
                  var27 = class90.username;
               } else {
                  var23 = class90.username;
                  var11 = var23.length();
                  var24 = new char[var11];

                  for(var13 = 0; var13 < var11; ++var13) {
                     var24[var13] = '*';
                  }

                  var25 = new String(var24);
                  var27 = var25;
               }

               for(var27 = var27; var0.getTextWidth(var27) > var37; var27 = var27.substring(0, var27.length() - 1)) {
                  ;
               }

               var0.method5630(FontTypeFace.appendTags(var27), class90.loginWindowX + 180 - 70, var36, 16777215, 0);
               var36 += 15;
               var23 = "Password: ";
               var29 = class90.password;
               var13 = var29.length();
               var30 = new char[var13];

               for(var15 = 0; var15 < var13; ++var15) {
                  var30[var15] = '*';
               }

               var49 = new String(var30);
               var0.method5630(var23 + var49, class90.loginWindowX + 180 - 108, var36, 16777215, 0);
               var36 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class90.field1337.method5898(class90.loginWindowX, 171);
            short var6;
            if(class90.loginIndex == 0) {
               var35 = 251;
               var0.drawTextCentered("Welcome to RuneScape", class90.loginWindowX + 180, var35, 16776960, 0);
               var36 = var35 + 30;
               var5 = class90.loginWindowX + 180 - 80;
               var6 = 291;
               class149.field2106.method5898(var5 - 73, var6 - 20);
               var0.method5574("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class149.field2106.method5898(var5 - 73, var6 - 20);
               var0.method5574("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class90.loginIndex == 1) {
               var0.drawTextCentered(class90.Login_response0, class90.loginWindowX + 180, 201, 16776960, 0);
               var35 = 236;
               var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var35, 16777215, 0);
               var36 = var35 + 15;
               var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var36, 16777215, 0);
               var36 += 15;
               var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var36, 16777215, 0);
               var36 += 15;
               var5 = class90.loginWindowX + 180 - 80;
               var6 = 321;
               class149.field2106.method5898(var5 - 73, var6 - 20);
               var0.drawTextCentered("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class149.field2106.method5898(var5 - 73, var6 - 20);
               var0.drawTextCentered("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class90.loginIndex == 2) {
               var35 = 201;
               var0.drawTextCentered(class90.loginMessage1, GrandExchangeEvent.field293, var35, 16776960, 0);
               var36 = var35 + 15;
               var0.drawTextCentered(class90.loginMessage2, GrandExchangeEvent.field293, var36, 16776960, 0);
               var36 += 15;
               var0.drawTextCentered(class90.loginMessage3, GrandExchangeEvent.field293, var36, 16776960, 0);
               var36 += 15;
               var36 += 7;
               var0.method5630("Login: ", GrandExchangeEvent.field293 - 110, var36, 16777215, 0);
               var37 = 200;
               if(!Client.preferences.hideUsername) {
                  var27 = class90.username;
               } else {
                  var23 = class90.username;
                  var11 = var23.length();
                  var24 = new char[var11];

                  for(var13 = 0; var13 < var11; ++var13) {
                     var24[var13] = '*';
                  }

                  var25 = new String(var24);
                  var27 = var25;
               }

               for(var27 = var27; var0.getTextWidth(var27) > var37; var27 = var27.substring(1)) {
                  ;
               }

               var0.method5630(FontTypeFace.appendTags(var27) + (class90.currentLoginField == 0 & Client.gameCycle % 40 < 20?DynamicObject.getColTags(16776960) + "|":""), GrandExchangeEvent.field293 - 70, var36, 16777215, 0);
               var36 += 15;
               var23 = "Password: ";
               var29 = class90.password;
               var13 = var29.length();
               var30 = new char[var13];

               for(var15 = 0; var15 < var13; ++var15) {
                  var30[var15] = '*';
               }

               var49 = new String(var30);
               var0.method5630(var23 + var49 + (class90.currentLoginField == 1 & Client.gameCycle % 40 < 20?DynamicObject.getColTags(16776960) + "|":""), GrandExchangeEvent.field293 - 108, var36, 16777215, 0);
               var36 += 15;
               var35 = 277;
               var12 = GrandExchangeEvent.field293 + -117;
               boolean var14 = class90.Login_isUsernameRemembered;
               var45 = class90.field1354;
               IndexedSprite var32 = var14?(var45?MessageNode.field811:class21.field339):(var45?BoundingBox3D.field262:BaseVarType.field33);
               var32.method5898(var12, var35);
               var12 = var12 + var32.width + 5;
               var1.method5630("Remember username", var12, var35 + 13, 16776960, 0);
               var12 = GrandExchangeEvent.field293 + 24;
               var18 = Client.preferences.hideUsername;
               boolean var34 = class90.field1353;
               IndexedSprite var17 = var18?(var34?MessageNode.field811:class21.field339):(var34?BoundingBox3D.field262:BaseVarType.field33);
               var17.method5898(var12, var35);
               var12 = var12 + var17.width + 5;
               var1.method5630("Hide username", var12, var35 + 13, 16776960, 0);
               var36 = var35 + 15;
               int var20 = GrandExchangeEvent.field293 - 80;
               short var21 = 321;
               class149.field2106.method5898(var20 - 73, var21 - 20);
               var0.drawTextCentered("Login", var20, var21 + 5, 16777215, 0);
               var20 = GrandExchangeEvent.field293 + 80;
               class149.field2106.method5898(var20 - 73, var21 - 20);
               var0.drawTextCentered("Cancel", var20, var21 + 5, 16777215, 0);
               var35 = 357;
               var1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", GrandExchangeEvent.field293, var35, 16776960, 0);
            } else if(class90.loginIndex == 3) {
               var35 = 201;
               var0.drawTextCentered("Invalid username or password.", class90.loginWindowX + 180, var35, 16776960, 0);
               var36 = var35 + 20;
               var1.drawTextCentered("For accounts created after 24th November 2010, please use your", class90.loginWindowX + 180, var36, 16776960, 0);
               var36 += 15;
               var1.drawTextCentered("email address to login. Otherwise please login with your username.", class90.loginWindowX + 180, var36, 16776960, 0);
               var36 += 15;
               var5 = class90.loginWindowX + 180;
               var6 = 276;
               class149.field2106.method5898(var5 - 73, var6 - 20);
               var2.drawTextCentered("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180;
               var6 = 326;
               class149.field2106.method5898(var5 - 73, var6 - 20);
               var2.drawTextCentered("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else {
               String var28;
               if(class90.loginIndex == 4) {
                  var0.drawTextCentered("Authenticator", class90.loginWindowX + 180, 201, 16776960, 0);
                  var35 = 236;
                  var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var35, 16777215, 0);
                  var36 = var35 + 15;
                  var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var36, 16777215, 0);
                  var36 += 15;
                  var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var36, 16777215, 0);
                  var36 += 15;
                  var28 = "PIN: ";
                  String var26 = WidgetNode.field767;
                  var10 = var26.length();
                  char[] var50 = new char[var10];

                  for(var12 = 0; var12 < var10; ++var12) {
                     var50[var12] = '*';
                  }

                  var23 = new String(var50);
                  var0.method5630(var28 + var23 + (Client.gameCycle % 40 < 20?DynamicObject.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 108, var36, 16777215, 0);
                  var36 -= 8;
                  var0.method5630("Trust this computer", class90.loginWindowX + 180 - 9, var36, 16776960, 0);
                  var36 += 15;
                  var0.method5630("for 30 days: ", class90.loginWindowX + 180 - 9, var36, 16776960, 0);
                  var9 = class90.loginWindowX + 180 - 9 + var0.getTextWidth("for 30 days: ") + 15;
                  var10 = var36 - var0.verticalSpace;
                  IndexedSprite var51;
                  if(class90.field1362) {
                     var51 = class21.field339;
                  } else {
                     var51 = BaseVarType.field33;
                  }

                  var51.method5898(var9, var10);
                  var36 += 15;
                  var12 = class90.loginWindowX + 180 - 80;
                  short var44 = 321;
                  class149.field2106.method5898(var12 - 73, var44 - 20);
                  var0.drawTextCentered("Continue", var12, var44 + 5, 16777215, 0);
                  var12 = class90.loginWindowX + 180 + 80;
                  class149.field2106.method5898(var12 - 73, var44 - 20);
                  var0.drawTextCentered("Cancel", var12, var44 + 5, 16777215, 0);
                  var1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class90.loginWindowX + 180, var44 + 36, 255, 0);
               } else if(class90.loginIndex == 5) {
                  var0.drawTextCentered("Forgotten your password?", class90.loginWindowX + 180, 201, 16776960, 0);
                  var35 = 221;
                  var2.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var35, 16776960, 0);
                  var36 = var35 + 15;
                  var2.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var36, 16776960, 0);
                  var36 += 15;
                  var2.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var36, 16776960, 0);
                  var36 += 15;
                  var36 += 14;
                  var0.method5630("Username/email: ", class90.loginWindowX + 180 - 145, var36, 16777215, 0);
                  var37 = 174;
                  var28 = Client.preferences.hideUsername?class45.method682(class90.username):class90.username;

                  for(var27 = var28; var0.getTextWidth(var27) > var37; var27 = var27.substring(1)) {
                     ;
                  }

                  var0.method5630(FontTypeFace.appendTags(var27) + (Client.gameCycle % 40 < 20?DynamicObject.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 34, var36, 16777215, 0);
                  var36 += 15;
                  var8 = class90.loginWindowX + 180 - 80;
                  short var40 = 321;
                  class149.field2106.method5898(var8 - 73, var40 - 20);
                  var0.drawTextCentered("Recover", var8, var40 + 5, 16777215, 0);
                  var8 = class90.loginWindowX + 180 + 80;
                  class149.field2106.method5898(var8 - 73, var40 - 20);
                  var0.drawTextCentered("Back", var8, var40 + 5, 16777215, 0);
               } else if(class90.loginIndex == 6) {
                  var35 = 201;
                  var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var35, 16776960, 0);
                  var36 = var35 + 15;
                  var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var36, 16776960, 0);
                  var36 += 15;
                  var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var36, 16776960, 0);
                  var36 += 15;
                  var5 = class90.loginWindowX + 180;
                  var6 = 321;
                  class149.field2106.method5898(var5 - 73, var6 - 20);
                  var0.drawTextCentered("Back", var5, var6 + 5, 16777215, 0);
               }
            }
         }

         if(class90.field1370 > 0) {
            ItemContainer.method1147(class90.field1370);
            class90.field1370 = 0;
         }

         var35 = 256;
         if(class90.field1344 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class90.field1344 > 768) {
                  class90.field1338[var5] = class153.method3219(class37.field501[var5], class317.field3926[var5], 1024 - class90.field1344);
               } else if(class90.field1344 > 256) {
                  class90.field1338[var5] = class317.field3926[var5];
               } else {
                  class90.field1338[var5] = class153.method3219(class317.field3926[var5], class37.field501[var5], 256 - class90.field1344);
               }
            }
         } else if(class90.field1371 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class90.field1371 > 768) {
                  class90.field1338[var5] = class153.method3219(class37.field501[var5], class3.field18[var5], 1024 - class90.field1371);
               } else if(class90.field1371 > 256) {
                  class90.field1338[var5] = class3.field18[var5];
               } else {
                  class90.field1338[var5] = class153.method3219(class3.field18[var5], class37.field501[var5], 256 - class90.field1371);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class90.field1338[var5] = class37.field501[var5];
            }
         }

         Rasterizer2D.setDrawRegion(class90.field1336, 9, class90.field1336 + 128, var35 + 7);
         class90.field1359.method5915(class90.field1336, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var38 = GrandExchangeOffer.rasterProvider.width * 9 + class90.field1336;

         for(var7 = 1; var7 < var35 - 1; ++var7) {
            var8 = class90.field1365[var7] * (var35 - var7) / var35;
            var9 = var8 + 22;
            if(var9 < 0) {
               var9 = 0;
            }

            var5 += var9;

            for(var10 = var9; var10 < 128; ++var10) {
               var11 = MouseRecorder.field789[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class90.field1338[var11];
                  var43 = GrandExchangeOffer.rasterProvider.pixels[var38];
                  GrandExchangeOffer.rasterProvider.pixels[var38++] = (var13 * (var43 & 65280) + var12 * (var11 & 65280) & 16711680) + ((var43 & 16711935) * var13 + (var11 & 16711935) * var12 & -16711936) >> 8;
               } else {
                  ++var38;
               }
            }

            var38 += var9 + GrandExchangeOffer.rasterProvider.width - 128;
         }

         Rasterizer2D.setDrawRegion(class90.field1336 + 765 - 128, 9, class90.field1336 + 765, var35 + 7);
         class90.field1340.method5915(class90.field1336 + 382, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var38 = GrandExchangeOffer.rasterProvider.width * 9 + class90.field1336 + 637 + 24;

         for(var7 = 1; var7 < var35 - 1; ++var7) {
            var8 = class90.field1365[var7] * (var35 - var7) / var35;
            var9 = 103 - var8;
            var38 += var8;

            for(var10 = 0; var10 < var9; ++var10) {
               var11 = MouseRecorder.field789[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class90.field1338[var11];
                  var43 = GrandExchangeOffer.rasterProvider.pixels[var38];
                  GrandExchangeOffer.rasterProvider.pixels[var38++] = (var13 * (var43 & 65280) + var12 * (var11 & 65280) & 16711680) + ((var11 & 16711935) * var12 + (var43 & 16711935) * var13 & -16711936) >> 8;
               } else {
                  ++var38;
               }
            }

            var5 += 128 - var9;
            var38 += GrandExchangeOffer.rasterProvider.width - var9 - var8;
         }

         class85.titlemuteSprite[Client.preferences.muted?1:0].method5898(class90.field1336 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class149.field2107 != null) {
               var36 = class90.field1336 + 5;
               var37 = 463;
               byte var41 = 100;
               byte var39 = 35;
               class149.field2107.method5898(var36, var37);
               var0.drawTextCentered("World" + " " + Client.world, var41 / 2 + var36, var39 / 2 + var37 - 2, 16777215, 0);
               if(Size.listFetcher != null) {
                  var1.drawTextCentered("Loading...", var41 / 2 + var36, var39 / 2 + var37 + 12, 16777215, 0);
               } else {
                  var1.drawTextCentered("Click to switch", var41 / 2 + var36, var39 / 2 + var37 + 12, 16777215, 0);
               }
            } else {
               class149.field2107 = class62.getSprite(UnitPriceComparator.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1759973293"
   )
   static void method278() {
      if(Client.field978 >= 0 && Client.cachedPlayers[Client.field978] != null) {
         class36.method541(Client.cachedPlayers[Client.field978], false);
      }

   }
}
