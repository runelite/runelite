import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("IndexCacheLoader")
public class IndexCacheLoader {
   @ObfuscatedName("pf")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static class310 field512;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("titlebuttonSprite")
   static IndexedSprite titlebuttonSprite;
   @ObfuscatedName("x")
   @Export("__bd_x")
   public static short[][] __bd_x;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 636454135
   )
   @Export("__bd_er")
   static int __bd_er;
   @ObfuscatedName("gw")
   @Export("regionMapArchiveIds")
   static int[] regionMapArchiveIds;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache")
   final IndexCache indexCache;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1459455501
   )
   @Export("__q")
   final int __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 782003089
   )
   @Export("__w")
   int __w;

   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;)V"
   )
   IndexCacheLoader(IndexCache var1, String var2) {
      this.__w = 0;
      this.indexCache = var1;
      this.__q = var1.__t_397();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1352221725"
   )
   @Export("__m_122")
   boolean __m_122() {
      this.__w = 0;

      for(int var1 = 0; var1 < this.__q; ++var1) {
         if(!this.indexCache.__df_408(var1) || this.indexCache.__dn_407(var1)) {
            ++this.__w;
         }
      }

      return this.__w >= this.__q;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkk;Lkk;Lkk;I)V",
      garbageValue = "839403460"
   )
   @Export("drawTitle")
   static void drawTitle(Font var0, Font var1, Font var2) {
      Login.xPadding = (SoundCache.canvasWidth - 765) / 2;
      Login.loginBoxX = Login.xPadding + 202;
      Varps.loginBoxCenter = Login.loginBoxX + 180;
      int var9;
      int var11;
      int var19;
      byte var23;
      int var24;
      int var27;
      int var28;
      int var48;
      if(Login.worldSelectOpen) {
         if(class30.worldSelectBackSprites == null) {
            class30.worldSelectBackSprites = class2.method20(WorldMapSection3.indexCache8, "sl_back", "");
         }

         IndexCache var36;
         int var37;
         int var39;
         IndexedSprite[] var40;
         if(Frames.worldSelectFlagSprites == null) {
            var36 = WorldMapSection3.indexCache8;
            var39 = var36.getArchiveId("sl_flags");
            var37 = var36.getRecordId(var39, "");
            if(!SpriteMask.loadSprite(var36, var39, var37)) {
               var40 = null;
            } else {
               var40 = WorldMapLabel.createIndexedSpriteArray();
            }

            Frames.worldSelectFlagSprites = var40;
         }

         if(AttackOption.worldSelectArrows == null) {
            var36 = WorldMapSection3.indexCache8;
            var39 = var36.getArchiveId("sl_arrows");
            var37 = var36.getRecordId(var39, "");
            if(!SpriteMask.loadSprite(var36, var39, var37)) {
               var40 = null;
            } else {
               var40 = WorldMapLabel.createIndexedSpriteArray();
            }

            AttackOption.worldSelectArrows = var40;
         }

         if(UrlRequest.worldSelectStars == null) {
            var36 = WorldMapSection3.indexCache8;
            var39 = var36.getArchiveId("sl_stars");
            var37 = var36.getRecordId(var39, "");
            if(!SpriteMask.loadSprite(var36, var39, var37)) {
               var40 = null;
            } else {
               var40 = WorldMapLabel.createIndexedSpriteArray();
            }

            UrlRequest.worldSelectStars = var40;
         }

         if(SecureRandomFuture.worldSelectLeftSprite == null) {
            SecureRandomFuture.worldSelectLeftSprite = MenuAction.loadIndexedSpriteByName(WorldMapSection3.indexCache8, "leftarrow", "");
         }

         if(NetSocket.worldSelectRightSprite == null) {
            NetSocket.worldSelectRightSprite = MenuAction.loadIndexedSpriteByName(WorldMapSection3.indexCache8, "rightarrow", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
         Rasterizer2D.drawGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.drawGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
         if(UrlRequest.worldSelectStars != null) {
            UrlRequest.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
            var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
            UrlRequest.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
            var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
         }

         if(AttackOption.worldSelectArrows != null) {
            var48 = Login.xPadding + 280;
            if(World.sortOption1[0] == 0 && World.sortOption2[0] == 0) {
               AttackOption.worldSelectArrows[2].drawAt(var48, 4);
            } else {
               AttackOption.worldSelectArrows[0].drawAt(var48, 4);
            }

            if(World.sortOption1[0] == 0 && World.sortOption2[0] == 1) {
               AttackOption.worldSelectArrows[3].drawAt(var48 + 15, 4);
            } else {
               AttackOption.worldSelectArrows[1].drawAt(var48 + 15, 4);
            }

            var0.draw("World", var48 + 32, 17, 16777215, -1);
            var24 = Login.xPadding + 390;
            if(World.sortOption1[0] == 1 && World.sortOption2[0] == 0) {
               AttackOption.worldSelectArrows[2].drawAt(var24, 4);
            } else {
               AttackOption.worldSelectArrows[0].drawAt(var24, 4);
            }

            if(World.sortOption1[0] == 1 && World.sortOption2[0] == 1) {
               AttackOption.worldSelectArrows[3].drawAt(var24 + 15, 4);
            } else {
               AttackOption.worldSelectArrows[1].drawAt(var24 + 15, 4);
            }

            var0.draw("Players", var24 + 32, 17, 16777215, -1);
            var39 = Login.xPadding + 500;
            if(World.sortOption1[0] == 2 && World.sortOption2[0] == 0) {
               AttackOption.worldSelectArrows[2].drawAt(var39, 4);
            } else {
               AttackOption.worldSelectArrows[0].drawAt(var39, 4);
            }

            if(World.sortOption1[0] == 2 && World.sortOption2[0] == 1) {
               AttackOption.worldSelectArrows[3].drawAt(var39 + 15, 4);
            } else {
               AttackOption.worldSelectArrows[1].drawAt(var39 + 15, 4);
            }

            var0.draw("Location", var39 + 32, 17, 16777215, -1);
            var37 = Login.xPadding + 610;
            if(World.sortOption1[0] == 3 && World.sortOption2[0] == 0) {
               AttackOption.worldSelectArrows[2].drawAt(var37, 4);
            } else {
               AttackOption.worldSelectArrows[0].drawAt(var37, 4);
            }

            if(World.sortOption1[0] == 3 && World.sortOption2[0] == 1) {
               AttackOption.worldSelectArrows[3].drawAt(var37 + 15, 4);
            } else {
               AttackOption.worldSelectArrows[1].drawAt(var37 + 15, 4);
            }

            var0.draw("Type", var37 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
         var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
         Login.hoveredWorldIndex = -1;
         if(class30.worldSelectBackSprites != null) {
            var23 = 88;
            byte var51 = 19;
            var39 = 765 / (var23 + 1) - 1;
            var37 = 480 / (var51 + 1);

            do {
               var27 = var37;
               var28 = var39;
               if(var37 * (var39 - 1) >= World.worldsCount) {
                  --var39;
               }

               if(var39 * (var37 - 1) >= World.worldsCount) {
                  --var37;
               }

               if(var39 * (var37 - 1) >= World.worldsCount) {
                  --var37;
               }
            } while(var37 != var27 || var39 != var28);

            var27 = (765 - var23 * var39) / (var39 + 1);
            if(var27 > 5) {
               var27 = 5;
            }

            var28 = (480 - var51 * var37) / (var37 + 1);
            if(var28 > 5) {
               var28 = 5;
            }

            var9 = (765 - var39 * var23 - var27 * (var39 - 1)) / 2;
            int var10 = (480 - var37 * var51 - var28 * (var37 - 1)) / 2;
            var11 = (var37 + World.worldsCount - 1) / var37;
            Login.worldSelectPagesCount = var11 - var39;
            if(SecureRandomFuture.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
               SecureRandomFuture.worldSelectLeftSprite.drawAt(8, Huffman.canvasHeight / 2 - SecureRandomFuture.worldSelectLeftSprite.subHeight / 2);
            }

            if(NetSocket.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
               NetSocket.worldSelectRightSprite.drawAt(SoundCache.canvasWidth - NetSocket.worldSelectRightSprite.subWidth - 8, Huffman.canvasHeight / 2 - NetSocket.worldSelectRightSprite.subHeight / 2);
            }

            int var41 = var10 + 23;
            int var42 = var9 + Login.xPadding;
            int var43 = 0;
            boolean var15 = false;
            int var16 = Login.worldSelectPage;

            int var44;
            for(var44 = var37 * var16; var44 < World.worldsCount && var16 - Login.worldSelectPage < var39; ++var44) {
               World var29 = ItemContainer.worlds[var44];
               boolean var46 = true;
               String var20 = Integer.toString(var29.population);
               if(var29.population == -1) {
                  var20 = "OFF";
                  var46 = false;
               } else if(var29.population > 1980) {
                  var20 = "FULL";
                  var46 = false;
               }

               int var22 = 0;
               byte var21;
               if(var29.isBeta()) {
                  if(var29.isMembersOnly()) {
                     var21 = 7;
                  } else {
                     var21 = 6;
                  }
               } else if(var29.isDeadman()) {
                  var22 = 0xff0000;
                  if(var29.isMembersOnly()) {
                     var21 = 5;
                  } else {
                     var21 = 4;
                  }
               } else if(var29.isPvp()) {
                  if(var29.isMembersOnly()) {
                     var21 = 3;
                  } else {
                     var21 = 2;
                  }
               } else if(var29.isMembersOnly()) {
                  var21 = 1;
               } else {
                  var21 = 0;
               }

               if(MouseHandler.MouseHandler_x >= var42 && MouseHandler.MouseHandler_y >= var41 && MouseHandler.MouseHandler_x < var42 + var23 && MouseHandler.MouseHandler_y < var51 + var41 && var46) {
                  Login.hoveredWorldIndex = var44;
                  class30.worldSelectBackSprites[var21].drawAtTransOverlay(var42, var41, 128, 0xffffff);
                  var15 = true;
               } else {
                  class30.worldSelectBackSprites[var21].drawAt(var42, var41);
               }

               if(Frames.worldSelectFlagSprites != null) {
                  Frames.worldSelectFlagSprites[(var29.isMembersOnly()?8:0) + var29.location].drawAt(var42 + 29, var41);
               }

               var0.drawCentered(Integer.toString(var29.id), var42 + 15, var51 / 2 + var41 + 5, var22, -1);
               var1.drawCentered(var20, var42 + 60, var51 / 2 + var41 + 5, 268435455, -1);
               var41 = var41 + var28 + var51;
               ++var43;
               if(var43 >= var37) {
                  var41 = var10 + 23;
                  var42 = var42 + var23 + var27;
                  var43 = 0;
                  ++var16;
               }
            }

            if(var15) {
               var44 = var1.stringWidth(ItemContainer.worlds[Login.hoveredWorldIndex].activity) + 6;
               int var45 = var1.ascent + 8;
               var19 = MouseHandler.MouseHandler_y + 25;
               if(var45 + var19 > 480) {
                  var19 = MouseHandler.MouseHandler_y - 25 - var45;
               }

               Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var44 / 2, var19, var44, var45, 16777120);
               Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var44 / 2, var19, var44, var45, 0);
               var1.drawCentered(ItemContainer.worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var19 + var1.ascent + 4, 0, -1);
            }
         }

         class197.rasterProvider.drawFull(0, 0);
      } else {
         Login.leftTitleSprite.drawAt(Login.xPadding, 0);
         Fonts.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
         WorldMapSectionType.logoSprite.drawAt(Login.xPadding + 382 - WorldMapSectionType.logoSprite.subWidth / 2, 18);
         if(Client.gameState == 0 || Client.gameState == 5) {
            var23 = 20;
            var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var23, 16777215, -1);
            var24 = 253 - var23;
            Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var24, 304, 34, 9179409);
            Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var24 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var24 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150 + Login.Login_loadingPercent * 3, var24 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
            var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var23, 16777215, -1);
         }

         String var7;
         String var8;
         String var25;
         String var30;
         String var31;
         short var47;
         short var49;
         if(Client.gameState == 20) {
            Login.titleboxSprite.drawAt(Login.loginBoxX + 180 - Login.titleboxSprite.subWidth / 2, 271 - Login.titleboxSprite.subHeight / 2);
            var47 = 201;
            var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16776960, 0);
            var48 = var47 + 15;
            var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16776960, 0);
            var48 += 15;
            var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16776960, 0);
            var48 += 15;
            var48 += 7;
            if(Login.loginIndex != 4) {
               var0.draw("Login: ", Login.loginBoxX + 180 - 110, var48, 16777215, 0);
               var49 = 200;
               if(ReflectionCheck.clientPreferences.hideUsername) {
                  var8 = Login.Login_username;
                  var7 = class168.method3450('*', var8.length());
                  var25 = var7;
               } else {
                  var25 = Login.Login_username;
               }

               for(var25 = var25; var0.stringWidth(var25) > var49; var25 = var25.substring(0, var25.length() - 1)) {
                  ;
               }

               var0.draw(AbstractFont.escapeBrackets(var25), Login.loginBoxX + 180 - 70, var48, 16777215, 0);
               var48 += 15;
               var8 = "Password: ";
               var30 = Login.Login_password;
               var31 = class168.method3450('*', var30.length());
               var0.draw(var8 + var31, Login.loginBoxX + 180 - 108, var48, 16777215, 0);
               var48 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            Login.titleboxSprite.drawAt(Login.loginBoxX, 171);
            short var5;
            if(Login.loginIndex == 0) {
               var47 = 251;
               var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var47, 16776960, 0);
               var48 = var47 + 30;
               var24 = Login.loginBoxX + 180 - 80;
               var5 = 291;
               titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawLines("New User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var24 = Login.loginBoxX + 180 + 80;
               titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawLines("Existing User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(Login.loginIndex == 1) {
               var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
               var47 = 236;
               var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16777215, 0);
               var48 = var47 + 15;
               var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16777215, 0);
               var48 += 15;
               var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16777215, 0);
               var48 += 15;
               var24 = Login.loginBoxX + 180 - 80;
               var5 = 321;
               titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawCentered("Continue", var24, var5 + 5, 16777215, 0);
               var24 = Login.loginBoxX + 180 + 80;
               titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawCentered("Cancel", var24, var5 + 5, 16777215, 0);
            } else if(Login.loginIndex == 2) {
               var47 = 201;
               var0.drawCentered(Login.Login_response1, Varps.loginBoxCenter, var47, 16776960, 0);
               var48 = var47 + 15;
               var0.drawCentered(Login.Login_response2, Varps.loginBoxCenter, var48, 16776960, 0);
               var48 += 15;
               var0.drawCentered(Login.Login_response3, Varps.loginBoxCenter, var48, 16776960, 0);
               var48 += 15;
               var48 += 7;
               var0.draw("Login: ", Varps.loginBoxCenter - 110, var48, 16777215, 0);
               var49 = 200;
               if(ReflectionCheck.clientPreferences.hideUsername) {
                  var8 = Login.Login_username;
                  var7 = class168.method3450('*', var8.length());
                  var25 = var7;
               } else {
                  var25 = Login.Login_username;
               }

               for(var25 = var25; var0.stringWidth(var25) > var49; var25 = var25.substring(1)) {
                  ;
               }

               var0.draw(AbstractFont.escapeBrackets(var25) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20?BufferedFile.colorStartTag(16776960) + "|":""), Varps.loginBoxCenter - 70, var48, 16777215, 0);
               var48 += 15;
               var8 = "Password: ";
               var30 = Login.Login_password;
               var31 = class168.method3450('*', var30.length());
               var0.draw(var8 + var31 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20?BufferedFile.colorStartTag(16776960) + "|":""), Varps.loginBoxCenter - 108, var48, 16777215, 0);
               var48 += 15;
               var47 = 277;
               var11 = Varps.loginBoxCenter + -117;
               boolean var13 = Client.Login_isUsernameRemembered;
               boolean var14 = Login.__cu_aa;
               IndexedSprite var32 = var13?(var14?KeyHandler.options_buttons_6Sprite :class308.options_buttons_2Sprite):(var14?GraphicsObject.options_buttons_4Sprite :Login.options_buttons_0Sprite);
               var32.drawAt(var11, var47);
               var11 = var11 + var32.subWidth + 5;
               var1.draw("Remember username", var11, var47 + 13, 16776960, 0);
               var11 = Varps.loginBoxCenter + 24;
               boolean var17 = ReflectionCheck.clientPreferences.hideUsername;
               boolean var18 = Login.__cu_ax;
               IndexedSprite var34 = var17?(var18?KeyHandler.options_buttons_6Sprite :class308.options_buttons_2Sprite):(var18?GraphicsObject.options_buttons_4Sprite :Login.options_buttons_0Sprite);
               var34.drawAt(var11, var47);
               var11 = var11 + var34.subWidth + 5;
               var1.draw("Hide username", var11, var47 + 13, 16776960, 0);
               var48 = var47 + 15;
               var19 = Varps.loginBoxCenter - 80;
               short var35 = 321;
               titlebuttonSprite.drawAt(var19 - 73, var35 - 20);
               var0.drawCentered("Login", var19, var35 + 5, 16777215, 0);
               var19 = Varps.loginBoxCenter + 80;
               titlebuttonSprite.drawAt(var19 - 73, var35 - 20);
               var0.drawCentered("Cancel", var19, var35 + 5, 16777215, 0);
               var47 = 357;
               switch(Login.__cu_ac) {
               case 2:
                  AttackOption.__cj_ay = "Having trouble logging in?";
                  break;
               default:
                  AttackOption.__cj_ay = "Can\'t login? Click here.";
               }

               TilePaint.__eb_ah = new Bounds(Varps.loginBoxCenter, var47, var1.stringWidth(AttackOption.__cj_ay), 11);
               UrlRequester.__eo_ak = new Bounds(Varps.loginBoxCenter, var47, var1.stringWidth("Still having trouble logging in?"), 11);
               var1.drawCentered(AttackOption.__cj_ay, Varps.loginBoxCenter, var47, 16777215, 0);
            } else if(Login.loginIndex == 3) {
               var47 = 201;
               var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var47, 16776960, 0);
               var48 = var47 + 20;
               var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var48, 16776960, 0);
               var48 += 15;
               var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var48, 16776960, 0);
               var48 += 15;
               var24 = Login.loginBoxX + 180;
               var5 = 276;
               titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var2.drawCentered("Try again", var24, var5 + 5, 16777215, 0);
               var24 = Login.loginBoxX + 180;
               var5 = 326;
               titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var2.drawCentered("Forgotten password?", var24, var5 + 5, 16777215, 0);
            } else {
               String var26;
               if(Login.loginIndex == 4) {
                  var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
                  var47 = 236;
                  var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16777215, 0);
                  var48 = var47 + 15;
                  var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16777215, 0);
                  var48 += 15;
                  var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16777215, 0);
                  var48 += 15;
                  var26 = "PIN: ";
                  var7 = Login.otp;
                  var25 = class168.method3450('*', var7.length());
                  var0.draw(var26 + var25 + (Client.cycle % 40 < 20?BufferedFile.colorStartTag(16776960) + "|":""), Login.loginBoxX + 180 - 108, var48, 16777215, 0);
                  var48 -= 8;
                  var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var48, 16776960, 0);
                  var48 += 15;
                  var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var48, 16776960, 0);
                  var28 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
                  var9 = var48 - var0.ascent;
                  IndexedSprite var52;
                  if(Login.__cu_ba) {
                     var52 = class308.options_buttons_2Sprite;
                  } else {
                     var52 = Login.options_buttons_0Sprite;
                  }

                  var52.drawAt(var28, var9);
                  var48 += 15;
                  var11 = Login.loginBoxX + 180 - 80;
                  short var12 = 321;
                  titlebuttonSprite.drawAt(var11 - 73, var12 - 20);
                  var0.drawCentered("Continue", var11, var12 + 5, 16777215, 0);
                  var11 = Login.loginBoxX + 180 + 80;
                  titlebuttonSprite.drawAt(var11 - 73, var12 - 20);
                  var0.drawCentered("Cancel", var11, var12 + 5, 16777215, 0);
                  var1.drawCentered("<u=ff>Can\'t Log In?</u>", Login.loginBoxX + 180, var12 + 36, 255, 0);
               } else {
                  short var50;
                  if(Login.loginIndex == 5) {
                     var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
                     var47 = 221;
                     var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16776960, 0);
                     var48 = var47 + 15;
                     var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16776960, 0);
                     var48 += 15;
                     var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16776960, 0);
                     var48 += 15;
                     var48 += 14;
                     var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var48, 16777215, 0);
                     var49 = 174;
                     if(ReflectionCheck.clientPreferences.hideUsername) {
                        var8 = Login.Login_username;
                        var7 = class168.method3450('*', var8.length());
                        var25 = var7;
                     } else {
                        var25 = Login.Login_username;
                     }

                     for(var25 = var25; var0.stringWidth(var25) > var49; var25 = var25.substring(1)) {
                        ;
                     }

                     var0.draw(AbstractFont.escapeBrackets(var25) + (Client.cycle % 40 < 20?BufferedFile.colorStartTag(16776960) + "|":""), Login.loginBoxX + 180 - 34, var48, 16777215, 0);
                     var48 += 15;
                     var27 = Login.loginBoxX + 180 - 80;
                     var50 = 321;
                     titlebuttonSprite.drawAt(var27 - 73, var50 - 20);
                     var0.drawCentered("Recover", var27, var50 + 5, 16777215, 0);
                     var27 = Login.loginBoxX + 180 + 80;
                     titlebuttonSprite.drawAt(var27 - 73, var50 - 20);
                     var0.drawCentered("Back", var27, var50 + 5, 16777215, 0);
                     var50 = 356;
                     var1.drawCentered("Still having trouble logging in?", Varps.loginBoxCenter, var50, 268435455, 0);
                  } else if(Login.loginIndex == 6) {
                     var47 = 201;
                     var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16776960, 0);
                     var48 = var47 + 15;
                     var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16776960, 0);
                     var48 += 15;
                     var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16776960, 0);
                     var48 += 15;
                     var24 = Login.loginBoxX + 180;
                     var5 = 321;
                     titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                     var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
                  } else if(Login.loginIndex == 7) {
                     var47 = 216;
                     var0.drawCentered("Your date of birth isn\'t set.", Login.loginBoxX + 180, var47, 16776960, 0);
                     var48 = var47 + 15;
                     var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var48, 16776960, 0);
                     var48 += 15;
                     var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var48, 16776960, 0);
                     var48 += 15;
                     var24 = Login.loginBoxX + 180 - 80;
                     var5 = 321;
                     titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                     var0.drawCentered("Set Date of Birth", var24, var5 + 5, 16777215, 0);
                     var24 = Login.loginBoxX + 180 + 80;
                     titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                     var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
                  } else if(Login.loginIndex == 8) {
                     var47 = 216;
                     var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var47, 16776960, 0);
                     var48 = var47 + 15;
                     var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var48, 16776960, 0);
                     var48 += 15;
                     var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var48, 16776960, 0);
                     var48 += 15;
                     var24 = Login.loginBoxX + 180 - 80;
                     var5 = 321;
                     titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                     var0.drawCentered("Privacy Policy", var24, var5 + 5, 16777215, 0);
                     var24 = Login.loginBoxX + 180 + 80;
                     titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                     var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
                  } else if(Login.loginIndex == 12) {
                     var47 = 201;
                     String var4 = "";
                     var26 = "";
                     var25 = "";
                     switch(Login.__cu_aj) {
                     case 0:
                        var4 = "Your account has been disabled.";
                        var26 = Strings.__id_bq;
                        var25 = "";
                        break;
                     case 1:
                        var4 = "Account locked as we suspect it has been stolen.";
                        var26 = Strings.__id_cp;
                        var25 = "";
                        break;
                     default:
                        MouseHandler.method1084(false);
                     }

                     var0.drawCentered(var4, Login.loginBoxX + 180, var47, 16776960, 0);
                     var48 = var47 + 15;
                     var2.drawCentered(var26, Login.loginBoxX + 180, var48, 16776960, 0);
                     var48 += 15;
                     var2.drawCentered(var25, Login.loginBoxX + 180, var48, 16776960, 0);
                     var48 += 15;
                     var27 = Login.loginBoxX + 180;
                     var50 = 276;
                     titlebuttonSprite.drawAt(var27 - 73, var50 - 20);
                     var0.drawCentered("Support Page", var27, var50 + 5, 16777215, 0);
                     var27 = Login.loginBoxX + 180;
                     var50 = 326;
                     titlebuttonSprite.drawAt(var27 - 73, var50 - 20);
                     var0.drawCentered("Back", var27, var50 + 5, 16777215, 0);
                  }
               }
            }
         }

         if(Client.gameState >= 10) {
            int[] var3 = new int[4];
            Rasterizer2D.Rasterizer2D_getClipArray(var3);
            Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, Huffman.canvasHeight);
            class16.loginScreenRunesAnimation.method1782(Login.xPadding - 22, Client.cycle);
            class16.loginScreenRunesAnimation.method1782(Login.xPadding + 22 + 765 - 128, Client.cycle);
            Rasterizer2D.Rasterizer2D_setClipArray(var3);
         }

         KeyHandler.title_muteSprite[ReflectionCheck.clientPreferences.titleMusicDisabled?1:0].drawAt(Login.xPadding + 765 - 40, 463);
         if(Client.gameState > 5 && Client.language == 0) {
            if(class277.__jn_by != null) {
               var48 = Login.xPadding + 5;
               var49 = 463;
               byte var38 = 100;
               byte var6 = 35;
               class277.__jn_by.drawAt(var48, var49);
               var0.drawCentered("World" + " " + Client.worldId, var38 / 2 + var48, var6 / 2 + var49 - 2, 16777215, 0);
               if(FriendLoginUpdate.__kn_x != null) {
                  var1.drawCentered("Loading...", var38 / 2 + var48, var6 / 2 + var49 + 12, 16777215, 0);
               } else {
                  var1.drawCentered("Click to switch", var38 / 2 + var48, var6 / 2 + var49 + 12, 16777215, 0);
               }
            } else {
               class277.__jn_by = MenuAction.loadIndexedSpriteByName(WorldMapSection3.indexCache8, "sl_button", "");
            }
         }

      }
   }
}
