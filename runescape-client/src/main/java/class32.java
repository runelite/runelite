import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class32 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -9278083
   )
   int field285;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 727360665
   )
   int field282;
   @ObfuscatedName("q")
   int[][] field286;
   @ObfuscatedName("b")
   int[][] field284;
   @ObfuscatedName("f")
   int[][] field283;
   @ObfuscatedName("n")
   int[][] field281;

   class32(int var1, int var2) {
      this.field285 = var1;
      this.field282 = var2;
      this.field286 = new int[var1][var2];
      this.field284 = new int[var1][var2];
      this.field283 = new int[var1][var2];
      this.field281 = new int[var1][var2];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILij;B)V",
      garbageValue = "2"
   )
   void method587(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field285 && var2 - var3 <= this.field282) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field285, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field282, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field286[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field284[var9][var10] += var4.saturation;
                     this.field283[var9][var10] += var4.lightness;
                     ++this.field281[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1777051554"
   )
   int method596(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field285 && var2 < this.field282) {
         if(this.field283[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field286[var1][var2] / this.field281[var1][var2];
            int var4 = this.field284[var1][var2] / this.field281[var1][var2];
            int var5 = this.field283[var1][var2] / this.field281[var1][var2];
            return GrandExchangeEvents.method15((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
      garbageValue = "-95"
   )
   public static void method590(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class45.field368.startsWith("win") && !var3) {
            class178.method3534(var0, 0, "openjs");
            return;
         }

         if(class45.field368.startsWith("mac")) {
            class178.method3534(var0, 1, var2);
            return;
         }

         class178.method3534(var0, 2, "openjs");
      } else {
         class178.method3534(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "607558620"
   )
   static final boolean method599(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label69:
      while(true) {
         int var6 = var4.method3583();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.getUSmart();
               if(var9 == 0) {
                  continue label69;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = SoundTaskDataProvider.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.lowMemory || var15.int1 != 0 || var15.clipType == 1 || var15.obstructsGround) {
                     if(!var15.method5046()) {
                        ++Client.field647;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.getUSmart();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lkr;Lkr;Lkr;ZB)V",
      garbageValue = "2"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class78.field1104 = (class9.canvasWidth - 765) / 2;
         class78.loginWindowX = class78.field1104 + 202;
         class78.field1112 = class78.loginWindowX + 180;
      }

      if(class78.worldSelectShown) {
         Varcs.method1960(var0, var1);
      } else {
         if(var3) {
            class78.field1107.method5893(class78.field1104, 0);
            class24.field224.method5893(class78.field1104 + 382, 0);
            class78.logoSprite.method5873(class78.field1104 + 382 - class78.logoSprite.width / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.drawTextCentered("RuneScape is loading - please wait...", class78.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class78.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class78.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(class78.loginWindowX + 180 - 150, var5 + 2, class78.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(class78.loadingBarPercentage * 3 + (class78.loginWindowX + 180 - 150), var5 + 2, 300 - class78.loadingBarPercentage * 3, 30, 0);
            var0.drawTextCentered(class78.loadingText, class78.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var14;
         int var15;
         short var16;
         if(Client.gameState == 20) {
            class78.field1105.method5873(class78.loginWindowX + 180 - class78.field1105.width / 2, 271 - class78.field1105.height / 2);
            var14 = 201;
            var0.drawTextCentered(class78.loginMessage1, class78.loginWindowX + 180, var14, 16776960, 0);
            var15 = var14 + 15;
            var0.drawTextCentered(class78.loginMessage2, class78.loginWindowX + 180, var15, 16776960, 0);
            var15 += 15;
            var0.drawTextCentered(class78.loginMessage3, class78.loginWindowX + 180, var15, 16776960, 0);
            var15 += 15;
            var15 += 7;
            if(class78.loginIndex != 4) {
               var0.method5541("Login: ", class78.loginWindowX + 180 - 110, var15, 16777215, 0);
               var16 = 200;

               for(var6 = MouseRecorder.method1085(); var0.getTextWidth(var6) > var16; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method5541(FontTypeFace.appendTags(var6), class78.loginWindowX + 180 - 70, var15, 16777215, 0);
               var15 += 15;
               var0.method5541("Password: " + TextureProvider.method2592(class78.password), class78.loginWindowX + 180 - 108, var15, 16777215, 0);
               var15 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class78.field1105.method5873(class78.loginWindowX, 171);
            short var11;
            if(class78.loginIndex == 0) {
               var14 = 251;
               var0.drawTextCentered("Welcome to RuneScape", class78.loginWindowX + 180, var14, 16776960, 0);
               var15 = var14 + 30;
               var5 = class78.loginWindowX + 180 - 80;
               var11 = 291;
               class78.field1113.method5873(var5 - 73, var11 - 20);
               var0.method5595("New User", var5 - 73, var11 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class78.loginWindowX + 180 + 80;
               class78.field1113.method5873(var5 - 73, var11 - 20);
               var0.method5595("Existing User", var5 - 73, var11 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class78.loginIndex == 1) {
               var0.drawTextCentered(class78.Login_response0, class78.loginWindowX + 180, 201, 16776960, 0);
               var14 = 236;
               var0.drawTextCentered(class78.loginMessage1, class78.loginWindowX + 180, var14, 16777215, 0);
               var15 = var14 + 15;
               var0.drawTextCentered(class78.loginMessage2, class78.loginWindowX + 180, var15, 16777215, 0);
               var15 += 15;
               var0.drawTextCentered(class78.loginMessage3, class78.loginWindowX + 180, var15, 16777215, 0);
               var15 += 15;
               var5 = class78.loginWindowX + 180 - 80;
               var11 = 321;
               class78.field1113.method5873(var5 - 73, var11 - 20);
               var0.drawTextCentered("Continue", var5, var11 + 5, 16777215, 0);
               var5 = class78.loginWindowX + 180 + 80;
               class78.field1113.method5873(var5 - 73, var11 - 20);
               var0.drawTextCentered("Cancel", var5, var11 + 5, 16777215, 0);
            } else {
               int var7;
               if(class78.loginIndex == 2) {
                  var14 = 201;
                  var0.drawTextCentered(class78.loginMessage1, class78.field1112, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var0.drawTextCentered(class78.loginMessage2, class78.field1112, var15, 16776960, 0);
                  var15 += 15;
                  var0.drawTextCentered(class78.loginMessage3, class78.field1112, var15, 16776960, 0);
                  var15 += 15;
                  var15 += 7;
                  var0.method5541("Login: ", class78.field1112 - 110, var15, 16777215, 0);
                  var16 = 200;

                  for(var6 = MouseRecorder.method1085(); var0.getTextWidth(var6) > var16; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method5541(FontTypeFace.appendTags(var6) + (class78.currentLoginField == 0 & Client.gameCycle % 40 < 20?class50.getColTags(16776960) + "|":""), class78.field1112 - 70, var15, 16777215, 0);
                  var15 += 15;
                  var0.method5541("Password: " + TextureProvider.method2592(class78.password) + (class78.currentLoginField == 1 & Client.gameCycle % 40 < 20?class50.getColTags(16776960) + "|":""), class78.field1112 - 108, var15, 16777215, 0);
                  var15 += 15;
                  var14 = 277;
                  var7 = class78.field1112 + -117;
                  IndexedSprite var8 = GrandExchangeOffer.method54(class78.Login_isUsernameRemembered, class78.field1133);
                  var8.method5873(var7, var14);
                  var7 = var7 + var8.width + 5;
                  var1.method5541("Remember username", var7, var14 + 13, 16776960, 0);
                  var7 = class78.field1112 + 24;
                  var8 = GrandExchangeOffer.method54(ScriptState.preferences.hideUsername, class78.field1131);
                  var8.method5873(var7, var14);
                  var7 = var7 + var8.width + 5;
                  var1.method5541("Hide username", var7, var14 + 13, 16776960, 0);
                  var15 = var14 + 15;
                  int var9 = class78.field1112 - 80;
                  short var10 = 321;
                  class78.field1113.method5873(var9 - 73, var10 - 20);
                  var0.drawTextCentered("Login", var9, var10 + 5, 16777215, 0);
                  var9 = class78.field1112 + 80;
                  class78.field1113.method5873(var9 - 73, var10 - 20);
                  var0.drawTextCentered("Cancel", var9, var10 + 5, 16777215, 0);
                  var14 = 357;
                  var1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", class78.field1112, var14, 16776960, 0);
               } else if(class78.loginIndex == 3) {
                  var14 = 201;
                  var0.drawTextCentered("Invalid username or password.", class78.loginWindowX + 180, var14, 16776960, 0);
                  var15 = var14 + 20;
                  var1.drawTextCentered("For accounts created after 24th November 2010, please use your", class78.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var1.drawTextCentered("email address to login. Otherwise please login with your username.", class78.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var5 = class78.loginWindowX + 180;
                  var11 = 276;
                  class78.field1113.method5873(var5 - 73, var11 - 20);
                  var2.drawTextCentered("Try again", var5, var11 + 5, 16777215, 0);
                  var5 = class78.loginWindowX + 180;
                  var11 = 326;
                  class78.field1113.method5873(var5 - 73, var11 - 20);
                  var2.drawTextCentered("Forgotten password?", var5, var11 + 5, 16777215, 0);
               } else if(class78.loginIndex == 4) {
                  var0.drawTextCentered("Authenticator", class78.loginWindowX + 180, 201, 16776960, 0);
                  var14 = 236;
                  var0.drawTextCentered(class78.loginMessage1, class78.loginWindowX + 180, var14, 16777215, 0);
                  var15 = var14 + 15;
                  var0.drawTextCentered(class78.loginMessage2, class78.loginWindowX + 180, var15, 16777215, 0);
                  var15 += 15;
                  var0.drawTextCentered(class78.loginMessage3, class78.loginWindowX + 180, var15, 16777215, 0);
                  var15 += 15;
                  var0.method5541("PIN: " + TextureProvider.method2592(GameEngine.field414) + (Client.gameCycle % 40 < 20?class50.getColTags(16776960) + "|":""), class78.loginWindowX + 180 - 108, var15, 16777215, 0);
                  var15 -= 8;
                  var0.method5541("Trust this computer", class78.loginWindowX + 180 - 9, var15, 16776960, 0);
                  var15 += 15;
                  var0.method5541("for 30 days: ", class78.loginWindowX + 180 - 9, var15, 16776960, 0);
                  var5 = 180 + class78.loginWindowX - 9 + var0.getTextWidth("for 30 days: ") + 15;
                  int var19 = var15 - var0.verticalSpace;
                  IndexedSprite var12;
                  if(class78.field1132) {
                     var12 = class78.field1110;
                  } else {
                     var12 = class78.field1109;
                  }

                  var12.method5873(var5, var19);
                  var15 += 15;
                  int var13 = class78.loginWindowX + 180 - 80;
                  short var18 = 321;
                  class78.field1113.method5873(var13 - 73, var18 - 20);
                  var0.drawTextCentered("Continue", var13, var18 + 5, 16777215, 0);
                  var13 = class78.loginWindowX + 180 + 80;
                  class78.field1113.method5873(var13 - 73, var18 - 20);
                  var0.drawTextCentered("Cancel", var13, var18 + 5, 16777215, 0);
                  var1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class78.loginWindowX + 180, var18 + 36, 255, 0);
               } else if(class78.loginIndex == 5) {
                  var0.drawTextCentered("Forgotten your password?", class78.loginWindowX + 180, 201, 16776960, 0);
                  var14 = 221;
                  var2.drawTextCentered(class78.loginMessage1, class78.loginWindowX + 180, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var2.drawTextCentered(class78.loginMessage2, class78.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var2.drawTextCentered(class78.loginMessage3, class78.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var15 += 14;
                  var0.method5541("Username/email: ", class78.loginWindowX + 180 - 145, var15, 16777215, 0);
                  var16 = 174;

                  for(var6 = MouseRecorder.method1085(); var0.getTextWidth(var6) > var16; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method5541(FontTypeFace.appendTags(var6) + (Client.gameCycle % 40 < 20?class50.getColTags(16776960) + "|":""), class78.loginWindowX + 180 - 34, var15, 16777215, 0);
                  var15 += 15;
                  var7 = class78.loginWindowX + 180 - 80;
                  short var21 = 321;
                  class78.field1113.method5873(var7 - 73, var21 - 20);
                  var0.drawTextCentered("Recover", var7, var21 + 5, 16777215, 0);
                  var7 = class78.loginWindowX + 180 + 80;
                  class78.field1113.method5873(var7 - 73, var21 - 20);
                  var0.drawTextCentered("Back", var7, var21 + 5, 16777215, 0);
               } else if(class78.loginIndex == 6) {
                  var14 = 201;
                  var0.drawTextCentered(class78.loginMessage1, class78.loginWindowX + 180, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var0.drawTextCentered(class78.loginMessage2, class78.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var0.drawTextCentered(class78.loginMessage3, class78.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var5 = class78.loginWindowX + 180;
                  var11 = 321;
                  class78.field1113.method5873(var5 - 73, var11 - 20);
                  var0.drawTextCentered("Back", var5, var11 + 5, 16777215, 0);
               } else if(class78.loginIndex == 7) {
                  var14 = 216;
                  var0.drawTextCentered("Your date of birth isn\'t set.", class78.loginWindowX + 180, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var2.drawTextCentered("Please verify your account status by", class78.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var2.drawTextCentered("setting your date of birth.", class78.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var5 = class78.loginWindowX + 180 - 80;
                  var11 = 321;
                  class78.field1113.method5873(var5 - 73, var11 - 20);
                  var0.drawTextCentered("Set Date of Birth", var5, var11 + 5, 16777215, 0);
                  var5 = class78.loginWindowX + 180 + 80;
                  class78.field1113.method5873(var5 - 73, var11 - 20);
                  var0.drawTextCentered("Back", var5, var11 + 5, 16777215, 0);
               } else if(class78.loginIndex == 8) {
                  var14 = 216;
                  var0.drawTextCentered("Sorry, but your account is not eligible to play.", class78.loginWindowX + 180, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var2.drawTextCentered("For more information, please take a look at", class78.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var2.drawTextCentered("our privacy policy.", class78.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var5 = class78.loginWindowX + 180 - 80;
                  var11 = 321;
                  class78.field1113.method5873(var5 - 73, var11 - 20);
                  var0.drawTextCentered("Privacy Policy", var5, var11 + 5, 16777215, 0);
                  var5 = class78.loginWindowX + 180 + 80;
                  class78.field1113.method5873(var5 - 73, var11 - 20);
                  var0.drawTextCentered("Back", var5, var11 + 5, 16777215, 0);
               }
            }
         }

         if(class78.field1118 > 0) {
            class43.method791(class78.field1118);
            class78.field1118 = 0;
         }

         MessageNode.method1105();
         WidgetNode.titlemuteSprite[ScriptState.preferences.muted?1:0].method5873(class78.field1104 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(Occluder.field1844 != null) {
               var15 = class78.field1104 + 5;
               var16 = 463;
               byte var20 = 100;
               byte var17 = 35;
               Occluder.field1844.method5873(var15, var16);
               var0.drawTextCentered("World" + " " + Client.world, var20 / 2 + var15, var17 / 2 + var16 - 2, 16777215, 0);
               if(World.listFetcher != null) {
                  var1.drawTextCentered("Loading...", var20 / 2 + var15, var17 / 2 + var16 + 12, 16777215, 0);
               } else {
                  var1.drawTextCentered("Click to switch", var20 / 2 + var15, var17 / 2 + var16 + 12, 16777215, 0);
               }
            } else {
               Occluder.field1844 = GameEngine.getSprite(class59.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "-844828617"
   )
   static int method600(int var0, Script var1, boolean var2) {
      Widget var3 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
      if(var0 == 2600) {
         class69.intStack[++class45.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class69.intStack[++class45.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class69.intStack[++class45.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class69.intStack[++class45.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class69.intStack[++class45.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         class69.intStack[++class45.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class69.intStack[++class45.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class69.intStack[++class45.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class69.intStack[++class45.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class69.intStack[++class45.intStackSize - 1] = var3.field2649;
         return 1;
      } else if(var0 == 2611) {
         class69.intStack[++class45.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class69.intStack[++class45.intStackSize - 1] = var3.field2640;
         return 1;
      } else if(var0 == 2613) {
         class69.intStack[++class45.intStackSize - 1] = var3.field2700.rsOrdinal();
         return 1;
      } else if(var0 == 2614) {
         class69.intStack[++class45.intStackSize - 1] = var3.field2679?1:0;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(ILhh;ZI)V",
      garbageValue = "-1458690685"
   )
   static void method601(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = CombatInfoListHolder.method1821().getWorldMapDataByFileId(var0);
      int var4 = MilliTimer.localPlayer.field581;
      int var5 = (MilliTimer.localPlayer.x >> 7) + class178.baseX;
      int var6 = (MilliTimer.localPlayer.y >> 7) + CombatInfoListHolder.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      CombatInfoListHolder.method1821().method6112(var3, var7, var1, var2);
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(Lbu;ZI)V",
      garbageValue = "-1322367604"
   )
   static void method586(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         var0.isLowDetail = false;
         if((Client.lowMemory && class81.playerIndexesCount > 50 || class81.playerIndexesCount > 200) && var1 && var0.poseAnimation == var0.idlePoseAnimation) {
            var0.isLowDetail = true;
         }

         int var2 = var0.x >> 7;
         int var3 = var0.y >> 7;
         if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
            long var4 = class59.method1129(0, 0, 0, false, var0.playerId);
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field572 = class264.getTileHeight(var0.x, var0.y, class192.plane);
               var0.field905 = Client.gameCycle;
               ScriptEvent.region.method2971(class192.plane, var0.x, var0.y, var0.field572, 60, var0, var0.angle, var4, var0.field568, var0.field573, var0.field577, var0.field578);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field689[var2][var3] == Client.field690) {
                     return;
                  }

                  Client.field689[var2][var3] = Client.field690;
               }

               var0.field572 = class264.getTileHeight(var0.x, var0.y, class192.plane);
               var0.field905 = Client.gameCycle;
               ScriptEvent.region.method2945(class192.plane, var0.x, var0.y, var0.field572, 60, var0, var0.angle, var4, var0.field884);
            }
         }
      }

   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2117746287"
   )
   static final void method595() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var0.level == class192.plane && !var0.finished) {
            if(Client.gameCycle >= var0.startCycle) {
               var0.method1812(Client.field654);
               if(var0.finished) {
                  var0.unlink();
               } else {
                  ScriptEvent.region.method2945(var0.level, var0.x, var0.y, var0.height, 60, var0, 0, -1L, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "49130054"
   )
   static final String method598(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class50.getColTags(16711680):(var2 < -6?class50.getColTags(16723968):(var2 < -3?class50.getColTags(16740352):(var2 < 0?class50.getColTags(16756736):(var2 > 9?class50.getColTags(65280):(var2 > 6?class50.getColTags(4259584):(var2 > 3?class50.getColTags(8453888):(var2 > 0?class50.getColTags(12648192):class50.getColTags(16776960))))))));
   }
}
