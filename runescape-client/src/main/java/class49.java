import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class49 implements WorldMapSectionBase {
   @ObfuscatedName("rj")
   static short[] field576;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 376602409
   )
   static int field581;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1089731071
   )
   int field579;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 896756771
   )
   int field586;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 569624617
   )
   int field578;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -686014889
   )
   int field585;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2085387129
   )
   int field588;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -850814069
   )
   int field577;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1629150641
   )
   int field582;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2050551769
   )
   int field583;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1720080435
   )
   int field584;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2011421983
   )
   int field580;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1173479592"
   )
   public void vmethod762(WorldMapData var1) {
      if(var1.minX > this.field588) {
         var1.minX = this.field588;
      }

      if(var1.field428 < this.field588) {
         var1.field428 = this.field588;
      }

      if(var1.minY > this.field577) {
         var1.minY = this.field577;
      }

      if(var1.field430 < this.field577) {
         var1.field430 = this.field577;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-52"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field579 && var1 < this.field579 + this.field586?var2 >= (this.field578 << 6) + (this.field582 << 3) && var2 <= (this.field578 << 6) + (this.field582 << 3) + 7 && var3 >= (this.field585 << 6) + (this.field583 << 3) && var3 <= (this.field585 << 6) + (this.field583 << 3) + 7:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "53"
   )
   public boolean vmethod764(int var1, int var2) {
      return var1 >= (this.field588 << 6) + (this.field584 << 3) && var1 <= (this.field588 << 6) + (this.field584 << 3) + 7 && var2 >= (this.field577 << 6) + (this.field580 << 3) && var2 <= (this.field577 << 6) + (this.field580 << 3) + 7;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-653420606"
   )
   public int[] vmethod765(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field588 * 64 - this.field578 * 64 + var2 + (this.field584 * 8 - this.field582 * 8), var3 + (this.field577 * 64 - this.field585 * 64) + (this.field580 * 8 - this.field583 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)Lik;",
      garbageValue = "-2033075237"
   )
   public Coordinates vmethod770(int var1, int var2) {
      if(!this.vmethod764(var1, var2)) {
         return null;
      } else {
         int var3 = this.field578 * 64 - this.field588 * 64 + (this.field582 * 8 - this.field584 * 8) + var1;
         int var4 = this.field585 * 64 - this.field577 * 64 + var2 + (this.field583 * 8 - this.field580 * 8);
         return new Coordinates(this.field579, var3, var4);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "1382348566"
   )
   public void vmethod761(Buffer var1) {
      this.field579 = var1.readUnsignedByte();
      this.field586 = var1.readUnsignedByte();
      this.field578 = var1.readUnsignedShort();
      this.field582 = var1.readUnsignedByte();
      this.field585 = var1.readUnsignedShort();
      this.field583 = var1.readUnsignedByte();
      this.field588 = var1.readUnsignedShort();
      this.field584 = var1.readUnsignedByte();
      this.field577 = var1.readUnsignedShort();
      this.field580 = var1.readUnsignedByte();
      this.method768();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2097808321"
   )
   void method768() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkm;Lkm;Lkm;ZI)V",
      garbageValue = "1104401106"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class90.field1323 = (WallObject.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1323 + 202;
         Coordinates.field2778 = class90.loginWindowX + 180;
      }

      byte var4;
      int var5;
      int var7;
      int var8;
      int var11;
      int var12;
      int var29;
      int var31;
      int var34;
      int var35;
      int var38;
      int var40;
      if(class90.worldSelectShown) {
         if(class264.field3430 == null) {
            class264.field3430 = CombatInfo2.getSprites(WorldMapRegion.indexSprites, "sl_back", "");
         }

         if(Timer.slFlagSprites == null) {
            Timer.slFlagSprites = WorldMapData.getIndexedSprites(WorldMapRegion.indexSprites, "sl_flags", "");
         }

         if(class28.slArrowSprites == null) {
            class28.slArrowSprites = WorldMapData.getIndexedSprites(WorldMapRegion.indexSprites, "sl_arrows", "");
         }

         if(WorldMapType2.slStarSprites == null) {
            WorldMapType2.slStarSprites = WorldMapData.getIndexedSprites(WorldMapRegion.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class90.field1323, 23, 765, 480, 0);
         Rasterizer2D.method5727(class90.field1323, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method5727(class90.field1323 + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawTextCentered("Select a world", class90.field1323 + 62, 15, 0, -1);
         if(WorldMapType2.slStarSprites != null) {
            WorldMapType2.slStarSprites[1].method5806(class90.field1323 + 140, 1);
            var1.method5500("Members only world", class90.field1323 + 152, 10, 16777215, -1);
            WorldMapType2.slStarSprites[0].method5806(class90.field1323 + 140, 12);
            var1.method5500("Free world", class90.field1323 + 152, 21, 16777215, -1);
         }

         if(class28.slArrowSprites != null) {
            var29 = class90.field1323 + 280;
            if(World.field1210[0] == 0 && World.field1204[0] == 0) {
               class28.slArrowSprites[2].method5806(var29, 4);
            } else {
               class28.slArrowSprites[0].method5806(var29, 4);
            }

            if(World.field1210[0] == 0 && World.field1204[0] == 1) {
               class28.slArrowSprites[3].method5806(var29 + 15, 4);
            } else {
               class28.slArrowSprites[1].method5806(var29 + 15, 4);
            }

            var0.method5500("World", var29 + 32, 17, 16777215, -1);
            var5 = class90.field1323 + 390;
            if(World.field1210[0] == 1 && World.field1204[0] == 0) {
               class28.slArrowSprites[2].method5806(var5, 4);
            } else {
               class28.slArrowSprites[0].method5806(var5, 4);
            }

            if(World.field1210[0] == 1 && World.field1204[0] == 1) {
               class28.slArrowSprites[3].method5806(var5 + 15, 4);
            } else {
               class28.slArrowSprites[1].method5806(var5 + 15, 4);
            }

            var0.method5500("Players", var5 + 32, 17, 16777215, -1);
            var31 = class90.field1323 + 500;
            if(World.field1210[0] == 2 && World.field1204[0] == 0) {
               class28.slArrowSprites[2].method5806(var31, 4);
            } else {
               class28.slArrowSprites[0].method5806(var31, 4);
            }

            if(World.field1210[0] == 2 && World.field1204[0] == 1) {
               class28.slArrowSprites[3].method5806(var31 + 15, 4);
            } else {
               class28.slArrowSprites[1].method5806(var31 + 15, 4);
            }

            var0.method5500("Location", var31 + 32, 17, 16777215, -1);
            var7 = class90.field1323 + 610;
            if(World.field1210[0] == 3 && World.field1204[0] == 0) {
               class28.slArrowSprites[2].method5806(var7, 4);
            } else {
               class28.slArrowSprites[0].method5806(var7, 4);
            }

            if(World.field1210[0] == 3 && World.field1204[0] == 1) {
               class28.slArrowSprites[3].method5806(var7 + 15, 4);
            } else {
               class28.slArrowSprites[1].method5806(var7 + 15, 4);
            }

            var0.method5500("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class90.field1323 + 708, 4, 50, 16, 0);
         var1.drawTextCentered("Cancel", class90.field1323 + 708 + 25, 16, 16777215, -1);
         class90.field1322 = -1;
         if(class264.field3430 != null) {
            var4 = 88;
            byte var39 = 19;
            var31 = 765 / (var4 + 1);
            var7 = 480 / (var39 + 1);

            do {
               var8 = var7;
               var34 = var31;
               if(var7 * (var31 - 1) >= World.worldCount) {
                  --var31;
               }

               if(var31 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }

               if(var31 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }
            } while(var8 != var7 || var34 != var31);

            var8 = (765 - var31 * var4) / (var31 + 1);
            if(var8 > 5) {
               var8 = 5;
            }

            var34 = (480 - var7 * var39) / (var7 + 1);
            if(var34 > 5) {
               var34 = 5;
            }

            var35 = (765 - var31 * var4 - var8 * (var31 - 1)) / 2;
            var11 = (480 - var39 * var7 - var34 * (var7 - 1)) / 2;
            var12 = var11 + 23;
            var38 = var35 + class90.field1323;
            var40 = 0;
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
               if(var17.method1676()) {
                  if(var17.method1690()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method1672()) {
                  var21 = 16711680;
                  if(var17.method1690()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method1673()) {
                  if(var17.method1690()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method1690()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(MouseInput.mouseLastX >= var38 && MouseInput.mouseLastY >= var12 && MouseInput.mouseLastX < var38 + var4 && MouseInput.mouseLastY < var39 + var12 && var18) {
                  class90.field1322 = var42;
                  class264.field3430[var20].method5849(var38, var12, 128, 16777215);
                  var41 = true;
               } else {
                  class264.field3430[var20].method5830(var38, var12);
               }

               if(Timer.slFlagSprites != null) {
                  Timer.slFlagSprites[(var17.method1690()?8:0) + var17.location].method5806(var38 + 29, var12);
               }

               var0.drawTextCentered(Integer.toString(var17.id), var38 + 15, var39 / 2 + var12 + 5, var21, -1);
               var1.drawTextCentered(var19, var38 + 60, var39 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var34 + var39;
               ++var40;
               if(var40 >= var7) {
                  var12 = var11 + 23;
                  var38 = var38 + var8 + var4;
                  var40 = 0;
               }
            }

            if(var41) {
               var42 = var1.getTextWidth(World.worldList[class90.field1322].activity) + 6;
               int var27 = var1.verticalSpace + 8;
               Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.mouseLastX - var42 / 2, MouseInput.mouseLastY + 20 + 5, var42, var27, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.mouseLastX - var42 / 2, MouseInput.mouseLastY + 20 + 5, var42, var27, 0);
               var1.drawTextCentered(World.worldList[class90.field1322].activity, MouseInput.mouseLastX, MouseInput.mouseLastY + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
         }

         KeyFocusListener.rasterProvider.drawFull(0, 0);
      } else {
         if(var3) {
            Item.field1387.method5830(class90.field1323, 0);
            class237.field2773.method5830(class90.field1323 + 382, 0);
            class252.logoSprite.method5806(class90.field1323 + 382 - class252.logoSprite.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.drawTextCentered("RuneScape is loading - please wait...", class90.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(class90.loginWindowX + 180 - 150, var5 + 2, class90.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(class90.loadingBarPercentage * 3 + (class90.loginWindowX + 180 - 150), var5 + 2, 300 - class90.loadingBarPercentage * 3, 30, 0);
            var0.drawTextCentered(class90.loadingText, class90.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var22;
         short var28;
         short var30;
         if(Client.gameState == 20) {
            class90.field1324.method5806(class90.loginWindowX + 180 - class90.field1324.originalWidth / 2, 271 - class90.field1324.height / 2);
            var28 = 201;
            var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var28, 16776960, 0);
            var29 = var28 + 15;
            var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var29 += 7;
            if(class90.loginIndex != 4) {
               var0.method5500("Login: ", class90.loginWindowX + 180 - 110, var29, 16777215, 0);
               var30 = 200;

               for(var22 = FileSystem.method4559(); var0.getTextWidth(var22) > var30; var22 = var22.substring(0, var22.length() - 1)) {
                  ;
               }

               var0.method5500(FontTypeFace.appendTags(var22), class90.loginWindowX + 180 - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method5500("Password: " + Fonts.method5483(class90.password), class90.loginWindowX + 180 - 108, var29, 16777215, 0);
               var29 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class90.field1324.method5806(class90.loginWindowX, 171);
            short var6;
            if(class90.loginIndex == 0) {
               var28 = 251;
               var0.drawTextCentered("Welcome to RuneScape", class90.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 30;
               var5 = class90.loginWindowX + 180 - 80;
               var6 = 291;
               class250.field3014.method5806(var5 - 73, var6 - 20);
               var0.method5504("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class250.field3014.method5806(var5 - 73, var6 - 20);
               var0.method5504("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class90.loginIndex == 1) {
               var0.drawTextCentered(class90.Login_response0, class90.loginWindowX + 180, 201, 16776960, 0);
               var28 = 236;
               var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var28, 16777215, 0);
               var29 = var28 + 15;
               var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var5 = class90.loginWindowX + 180 - 80;
               var6 = 321;
               class250.field3014.method5806(var5 - 73, var6 - 20);
               var0.drawTextCentered("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class250.field3014.method5806(var5 - 73, var6 - 20);
               var0.drawTextCentered("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class90.loginIndex == 2) {
               var28 = 201;
               var0.drawTextCentered(class90.loginMessage1, Coordinates.field2778, var28, 16776960, 0);
               var29 = var28 + 15;
               var0.drawTextCentered(class90.loginMessage2, Coordinates.field2778, var29, 16776960, 0);
               var29 += 15;
               var0.drawTextCentered(class90.loginMessage3, Coordinates.field2778, var29, 16776960, 0);
               var29 += 15;
               var29 += 7;
               var0.method5500("Login: ", Coordinates.field2778 - 110, var29, 16777215, 0);
               var30 = 200;

               for(var22 = FileSystem.method4559(); var0.getTextWidth(var22) > var30; var22 = var22.substring(1)) {
                  ;
               }

               var0.method5500(FontTypeFace.appendTags(var22) + (class90.field1351 == 0 & Client.gameCycle % 40 < 20?class37.getColTags(16776960) + "|":""), Coordinates.field2778 - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method5500("Password: " + Fonts.method5483(class90.password) + (class90.field1351 == 1 & Client.gameCycle % 40 < 20?class37.getColTags(16776960) + "|":""), Coordinates.field2778 - 108, var29, 16777215, 0);
               var29 += 15;
               var28 = 277;
               var7 = Coordinates.field2778 + -117;
               boolean var9 = class90.Login_isUsernameRemembered;
               boolean var10 = class90.field1348;
               IndexedSprite var23 = var9?(var10?class90.field1331:class90.field1326):(var10?class160.field2132:FaceNormal.field2035);
               var23.method5806(var7, var28);
               var7 = var7 + var23.originalWidth + 5;
               var1.method5500("Remember username", var7, var28 + 13, 16776960, 0);
               var7 = Coordinates.field2778 + 24;
               boolean var13 = MapIcon.preferences.hideUsername;
               boolean var14 = class90.field1327;
               IndexedSprite var25 = var13?(var14?class90.field1331:class90.field1326):(var14?class160.field2132:FaceNormal.field2035);
               var25.method5806(var7, var28);
               var7 = var7 + var25.originalWidth + 5;
               var1.method5500("Hide username", var7, var28 + 13, 16776960, 0);
               var29 = var28 + 15;
               int var15 = Coordinates.field2778 - 80;
               short var16 = 321;
               class250.field3014.method5806(var15 - 73, var16 - 20);
               var0.drawTextCentered("Login", var15, var16 + 5, 16777215, 0);
               var15 = Coordinates.field2778 + 80;
               class250.field3014.method5806(var15 - 73, var16 - 20);
               var0.drawTextCentered("Cancel", var15, var16 + 5, 16777215, 0);
               var28 = 357;
               var1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", Coordinates.field2778, var28, 16776960, 0);
            } else if(class90.loginIndex == 3) {
               var28 = 201;
               var0.drawTextCentered("Invalid username or password.", class90.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 20;
               var1.drawTextCentered("For accounts created after 24th November 2010, please use your", class90.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var1.drawTextCentered("email address to login. Otherwise please login with your username.", class90.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var5 = class90.loginWindowX + 180;
               var6 = 276;
               class250.field3014.method5806(var5 - 73, var6 - 20);
               var2.drawTextCentered("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180;
               var6 = 326;
               class250.field3014.method5806(var5 - 73, var6 - 20);
               var2.drawTextCentered("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class90.loginIndex == 4) {
               var0.drawTextCentered("Authenticator", class90.loginWindowX + 180, 201, 16776960, 0);
               var28 = 236;
               var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var28, 16777215, 0);
               var29 = var28 + 15;
               var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var0.method5500("PIN: " + Fonts.method5483(Coordinates.field2779) + (Client.gameCycle % 40 < 20?class37.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 108, var29, 16777215, 0);
               var29 -= 8;
               var0.method5500("Trust this computer", class90.loginWindowX + 180 - 9, var29, 16776960, 0);
               var29 += 15;
               var0.method5500("for 30 days: ", class90.loginWindowX + 180 - 9, var29, 16776960, 0);
               var5 = 180 + class90.loginWindowX - 9 + var0.getTextWidth("for 30 days: ") + 15;
               var31 = var29 - var0.verticalSpace;
               IndexedSprite var26;
               if(class90.field1350) {
                  var26 = class90.field1326;
               } else {
                  var26 = FaceNormal.field2035;
               }

               var26.method5806(var5, var31);
               var29 += 15;
               var8 = class90.loginWindowX + 180 - 80;
               short var33 = 321;
               class250.field3014.method5806(var8 - 73, var33 - 20);
               var0.drawTextCentered("Continue", var8, var33 + 5, 16777215, 0);
               var8 = class90.loginWindowX + 180 + 80;
               class250.field3014.method5806(var8 - 73, var33 - 20);
               var0.drawTextCentered("Cancel", var8, var33 + 5, 16777215, 0);
               var1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class90.loginWindowX + 180, var33 + 36, 255, 0);
            } else if(class90.loginIndex == 5) {
               var0.drawTextCentered("Forgotten your password?", class90.loginWindowX + 180, 201, 16776960, 0);
               var28 = 221;
               var2.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 15;
               var2.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var2.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var29 += 14;
               var0.method5500("Username/email: ", class90.loginWindowX + 180 - 145, var29, 16777215, 0);
               var30 = 174;

               for(var22 = FileSystem.method4559(); var0.getTextWidth(var22) > var30; var22 = var22.substring(1)) {
                  ;
               }

               var0.method5500(FontTypeFace.appendTags(var22) + (Client.gameCycle % 40 < 20?class37.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 34, var29, 16777215, 0);
               var29 += 15;
               var7 = class90.loginWindowX + 180 - 80;
               short var32 = 321;
               class250.field3014.method5806(var7 - 73, var32 - 20);
               var0.drawTextCentered("Recover", var7, var32 + 5, 16777215, 0);
               var7 = class90.loginWindowX + 180 + 80;
               class250.field3014.method5806(var7 - 73, var32 - 20);
               var0.drawTextCentered("Back", var7, var32 + 5, 16777215, 0);
            } else if(class90.loginIndex == 6) {
               var28 = 201;
               var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 15;
               var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var29, 16776960, 0);
               var29 += 15;
               var5 = class90.loginWindowX + 180;
               var6 = 321;
               class250.field3014.method5806(var5 - 73, var6 - 20);
               var0.drawTextCentered("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class90.field1336 > 0) {
            MouseInput.method1091(class90.field1336);
            class90.field1336 = 0;
         }

         var28 = 256;
         if(class90.field1332 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class90.field1332 > 768) {
                  ItemContainer.field750[var5] = GameEngine.method1050(MapLabel.field448[var5], class233.field2754[var5], 1024 - class90.field1332);
               } else if(class90.field1332 > 256) {
                  ItemContainer.field750[var5] = class233.field2754[var5];
               } else {
                  ItemContainer.field750[var5] = GameEngine.method1050(class233.field2754[var5], MapLabel.field448[var5], 256 - class90.field1332);
               }
            }
         } else if(class90.field1333 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class90.field1333 > 768) {
                  ItemContainer.field750[var5] = GameEngine.method1050(MapLabel.field448[var5], MilliTimer.field2140[var5], 1024 - class90.field1333);
               } else if(class90.field1333 > 256) {
                  ItemContainer.field750[var5] = MilliTimer.field2140[var5];
               } else {
                  ItemContainer.field750[var5] = GameEngine.method1050(MilliTimer.field2140[var5], MapLabel.field448[var5], 256 - class90.field1333);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               ItemContainer.field750[var5] = MapLabel.field448[var5];
            }
         }

         Rasterizer2D.setDrawRegion(class90.field1323, 9, class90.field1323 + 128, var28 + 7);
         Item.field1387.method5830(class90.field1323, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var31 = KeyFocusListener.rasterProvider.width * 9 + class90.field1323;

         for(var7 = 1; var7 < var28 - 1; ++var7) {
            var8 = class90.field1330[var7] * (var28 - var7) / var28;
            var34 = var8 + 22;
            if(var34 < 0) {
               var34 = 0;
            }

            var5 += var34;

            for(var35 = var34; var35 < 128; ++var35) {
               var11 = class228.field2670[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var38 = 256 - var11;
                  var11 = ItemContainer.field750[var11];
                  var40 = KeyFocusListener.rasterProvider.pixels[var31];
                  KeyFocusListener.rasterProvider.pixels[var31++] = ((var40 & 16711935) * var38 + (var11 & 16711935) * var12 & -16711936) + (var38 * (var40 & 65280) + var12 * (var11 & 65280) & 16711680) >> 8;
               } else {
                  ++var31;
               }
            }

            var31 += var34 + KeyFocusListener.rasterProvider.width - 128;
         }

         Rasterizer2D.setDrawRegion(class90.field1323 + 765 - 128, 9, class90.field1323 + 765, var28 + 7);
         class237.field2773.method5830(class90.field1323 + 382, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var31 = KeyFocusListener.rasterProvider.width * 9 + class90.field1323 + 637 + 24;

         for(var7 = 1; var7 < var28 - 1; ++var7) {
            var8 = class90.field1330[var7] * (var28 - var7) / var28;
            var34 = 103 - var8;
            var31 += var8;

            for(var35 = 0; var35 < var34; ++var35) {
               var11 = class228.field2670[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var38 = 256 - var11;
                  var11 = ItemContainer.field750[var11];
                  var40 = KeyFocusListener.rasterProvider.pixels[var31];
                  KeyFocusListener.rasterProvider.pixels[var31++] = ((var40 & 16711935) * var38 + (var11 & 16711935) * var12 & -16711936) + (var38 * (var40 & 65280) + var12 * (var11 & 65280) & 16711680) >> 8;
               } else {
                  ++var31;
               }
            }

            var5 += 128 - var34;
            var31 += KeyFocusListener.rasterProvider.width - var34 - var8;
         }

         class90.titlemuteSprite[MapIcon.preferences.muted?1:0].method5806(class90.field1323 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class156.field2117 != null) {
               var29 = class90.field1323 + 5;
               var30 = 463;
               byte var37 = 100;
               byte var36 = 35;
               class156.field2117.method5806(var29, var30);
               var0.drawTextCentered("World" + " " + Client.world, var37 / 2 + var29, var36 / 2 + var30 - 2, 16777215, 0);
               if(World.listFetcher != null) {
                  var1.drawTextCentered("Loading...", var37 / 2 + var29, var36 / 2 + var30 + 12, 16777215, 0);
               } else {
                  var1.drawTextCentered("Click to switch", var37 / 2 + var29, var36 / 2 + var30 + 12, 16777215, 0);
               }
            } else {
               class156.field2117 = Renderable.getSprite(WorldMapRegion.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcj;ZB)I",
      garbageValue = "-58"
   )
   static int method777(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         class81.intStack[++class5.intStackSize - 1] = SoundTaskDataProvider.method838();
         return 1;
      } else {
         int var3;
         if(var0 == 5307) {
            var3 = class81.intStack[--class5.intStackSize];
            if(var3 == 1 || var3 == 2) {
               MapIcon.method591(var3);
            }

            return 1;
         } else if(var0 == 5308) {
            class81.intStack[++class5.intStackSize - 1] = MapIcon.preferences.screenType;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var3 = class81.intStack[--class5.intStackSize];
            if(var3 == 1 || var3 == 2) {
               MapIcon.preferences.screenType = var3;
               class37.method538();
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   static void method789() {
      if(NetWriter.field1467 != null) {
         Client.field1114 = Client.gameCycle;
         NetWriter.field1467.method4726();

         for(int var0 = 0; var0 < Client.cachedPlayers.length; ++var0) {
            if(Client.cachedPlayers[var0] != null) {
               NetWriter.field1467.method4739((Client.cachedPlayers[var0].x >> 7) + class38.baseX, (Client.cachedPlayers[var0].y >> 7) + PlayerComposition.baseY);
            }
         }
      }

   }
}
