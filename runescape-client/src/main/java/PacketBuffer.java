import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("x")
   static final int[] field2608;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2030484595
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2608 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "347473755"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(Lgc;B)V",
      garbageValue = "36"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1759738157"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "98"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-610034226"
   )
   public boolean method3876() {
      int var1 = super.payload[super.offset] - this.cipher.method3921() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method3877() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-857095195"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "30"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2608[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2608[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2608[var1];
      }

      return var4;
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "27"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1657394649"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("d")
   public static final void method3907(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkw;Lkw;Lkw;ZI)V",
      garbageValue = "499892083"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class90.field1336 = (GameEngine.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1336 + 202;
         NPC.field1290 = class90.loginWindowX + 180;
      }

      byte var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var11;
      int var12;
      int var14;
      boolean var18;
      int var36;
      if(class90.worldSelectShown) {
         if(GraphicsObject.field1281 == null) {
            GraphicsObject.field1281 = WorldMapType1.getSprites(Renderable.indexSprites, "sl_back", "");
         }

         if(ScriptEvent.slFlagSprites == null) {
            ScriptEvent.slFlagSprites = class254.getIndexedSprites(Renderable.indexSprites, "sl_flags", "");
         }

         if(class170.slArrowSprites == null) {
            class170.slArrowSprites = class254.getIndexedSprites(Renderable.indexSprites, "sl_arrows", "");
         }

         if(class178.slStarSprites == null) {
            class178.slStarSprites = class254.getIndexedSprites(Renderable.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class90.field1336, 23, 765, 480, 0);
         Rasterizer2D.method5810(class90.field1336, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method5810(class90.field1336 + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawTextCentered("Select a world", class90.field1336 + 62, 15, 0, -1);
         if(class178.slStarSprites != null) {
            class178.slStarSprites[1].method5899(class90.field1336 + 140, 1);
            var1.method5689("Members only world", class90.field1336 + 152, 10, 16777215, -1);
            class178.slStarSprites[0].method5899(class90.field1336 + 140, 12);
            var1.method5689("Free world", class90.field1336 + 152, 21, 16777215, -1);
         }

         int var40;
         if(class170.slArrowSprites != null) {
            var36 = class90.field1336 + 280;
            if(World.field1209[0] == 0 && World.field1211[0] == 0) {
               class170.slArrowSprites[2].method5899(var36, 4);
            } else {
               class170.slArrowSprites[0].method5899(var36, 4);
            }

            if(World.field1209[0] == 0 && World.field1211[0] == 1) {
               class170.slArrowSprites[3].method5899(var36 + 15, 4);
            } else {
               class170.slArrowSprites[1].method5899(var36 + 15, 4);
            }

            var0.method5689("World", var36 + 32, 17, 16777215, -1);
            var5 = class90.field1336 + 390;
            if(World.field1209[0] == 1 && World.field1211[0] == 0) {
               class170.slArrowSprites[2].method5899(var5, 4);
            } else {
               class170.slArrowSprites[0].method5899(var5, 4);
            }

            if(World.field1209[0] == 1 && World.field1211[0] == 1) {
               class170.slArrowSprites[3].method5899(var5 + 15, 4);
            } else {
               class170.slArrowSprites[1].method5899(var5 + 15, 4);
            }

            var0.method5689("Players", var5 + 32, 17, 16777215, -1);
            var40 = class90.field1336 + 500;
            if(World.field1209[0] == 2 && World.field1211[0] == 0) {
               class170.slArrowSprites[2].method5899(var40, 4);
            } else {
               class170.slArrowSprites[0].method5899(var40, 4);
            }

            if(World.field1209[0] == 2 && World.field1211[0] == 1) {
               class170.slArrowSprites[3].method5899(var40 + 15, 4);
            } else {
               class170.slArrowSprites[1].method5899(var40 + 15, 4);
            }

            var0.method5689("Location", var40 + 32, 17, 16777215, -1);
            var7 = class90.field1336 + 610;
            if(World.field1209[0] == 3 && World.field1211[0] == 0) {
               class170.slArrowSprites[2].method5899(var7, 4);
            } else {
               class170.slArrowSprites[0].method5899(var7, 4);
            }

            if(World.field1209[0] == 3 && World.field1211[0] == 1) {
               class170.slArrowSprites[3].method5899(var7 + 15, 4);
            } else {
               class170.slArrowSprites[1].method5899(var7 + 15, 4);
            }

            var0.method5689("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(class90.field1336 + 708, 4, 50, 16, 0);
         var1.drawTextCentered("Cancel", class90.field1336 + 708 + 25, 16, 16777215, -1);
         class90.field1368 = -1;
         if(GraphicsObject.field1281 != null) {
            var4 = 88;
            byte var42 = 19;
            var40 = 765 / (var4 + 1);
            var7 = 480 / (var42 + 1);

            int var41;
            do {
               var41 = var7;
               var9 = var40;
               if(var7 * (var40 - 1) >= World.worldCount) {
                  --var40;
               }

               if(var40 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }

               if(var40 * (var7 - 1) >= World.worldCount) {
                  --var7;
               }
            } while(var7 != var41 || var9 != var40);

            var41 = (765 - var4 * var40) / (var40 + 1);
            if(var41 > 5) {
               var41 = 5;
            }

            var9 = (480 - var42 * var7) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var40 * var4 - var41 * (var40 - 1)) / 2;
            var11 = (480 - var42 * var7 - var9 * (var7 - 1)) / 2;
            var12 = var11 + 23;
            int var44 = var10 + class90.field1336;
            var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.worldCount; ++var16) {
               World var17 = World.worldList[var16];
               var18 = true;
               String var19 = Integer.toString(var17.playerCount);
               if(var17.playerCount == -1) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var17.playerCount > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var21 = 0;
               byte var46;
               if(var17.method1682()) {
                  if(var17.method1653()) {
                     var46 = 7;
                  } else {
                     var46 = 6;
                  }
               } else if(var17.method1657()) {
                  var21 = 16711680;
                  if(var17.method1653()) {
                     var46 = 5;
                  } else {
                     var46 = 4;
                  }
               } else if(var17.method1655()) {
                  if(var17.method1653()) {
                     var46 = 3;
                  } else {
                     var46 = 2;
                  }
               } else if(var17.method1653()) {
                  var46 = 1;
               } else {
                  var46 = 0;
               }

               if(MouseInput.mouseLastX >= var44 && MouseInput.mouseLastY >= var12 && MouseInput.mouseLastX < var44 + var4 && MouseInput.mouseLastY < var42 + var12 && var18) {
                  class90.field1368 = var16;
                  GraphicsObject.field1281[var46].method5925(var44, var12, 128, 16777215);
                  var15 = true;
               } else {
                  GraphicsObject.field1281[var46].method6003(var44, var12);
               }

               if(ScriptEvent.slFlagSprites != null) {
                  ScriptEvent.slFlagSprites[(var17.method1653()?8:0) + var17.location].method5899(var44 + 29, var12);
               }

               var0.drawTextCentered(Integer.toString(var17.id), var44 + 15, var42 / 2 + var12 + 5, var21, -1);
               var1.drawTextCentered(var19, var44 + 60, var42 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var9 + var42;
               ++var14;
               if(var14 >= var7) {
                  var12 = var11 + 23;
                  var44 = var44 + var4 + var41;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.getTextWidth(World.worldList[class90.field1368].activity) + 6;
               int var47 = var1.verticalSpace + 8;
               Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY + 20 + 5, var16, var47, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.mouseLastX - var16 / 2, MouseInput.mouseLastY + 20 + 5, var16, var47, 0);
               var1.drawTextCentered(World.worldList[class90.field1368].activity, MouseInput.mouseLastX, MouseInput.mouseLastY + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
         }

         class20.rasterProvider.drawFull(0, 0);
      } else {
         if(var3) {
            class90.field1338.method6003(class90.field1336, 0);
            class90.field1340.method6003(class90.field1336 + 382, 0);
            class90.logoSprite.method5899(class90.field1336 + 382 - class90.logoSprite.originalWidth / 2, 18);
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

         String var23;
         String var25;
         String var26;
         char[] var27;
         String var28;
         short var35;
         short var37;
         if(Client.gameState == 20) {
            class90.field1356.method5899(class90.loginWindowX + 180 - class90.field1356.originalWidth / 2, 271 - class90.field1356.height / 2);
            var35 = 201;
            var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var35, 16776960, 0);
            var36 = var35 + 15;
            var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var36, 16776960, 0);
            var36 += 15;
            var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var36, 16776960, 0);
            var36 += 15;
            var36 += 7;
            if(class90.loginIndex != 4) {
               var0.method5689("Login: ", class90.loginWindowX + 180 - 110, var36, 16777215, 0);
               var37 = 200;

               for(var23 = GrandExchangeOffer.method119(); var0.getTextWidth(var23) > var37; var23 = var23.substring(0, var23.length() - 1)) {
                  ;
               }

               var0.method5689(FontTypeFace.appendTags(var23), class90.loginWindowX + 180 - 70, var36, 16777215, 0);
               var36 += 15;
               var25 = "Password: ";
               var26 = class90.password;
               var12 = var26.length();
               var27 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var27[var14] = '*';
               }

               var28 = new String(var27);
               var0.method5689(var25 + var28, class90.loginWindowX + 180 - 108, var36, 16777215, 0);
               var36 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class90.field1356.method5899(class90.loginWindowX, 171);
            short var6;
            if(class90.loginIndex == 0) {
               var35 = 251;
               var0.drawTextCentered("Welcome to RuneScape", class90.loginWindowX + 180, var35, 16776960, 0);
               var36 = var35 + 30;
               var5 = class90.loginWindowX + 180 - 80;
               var6 = 291;
               class19.field328.method5899(var5 - 73, var6 - 20);
               var0.method5627("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class19.field328.method5899(var5 - 73, var6 - 20);
               var0.method5627("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
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
               class19.field328.method5899(var5 - 73, var6 - 20);
               var0.drawTextCentered("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class19.field328.method5899(var5 - 73, var6 - 20);
               var0.drawTextCentered("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class90.loginIndex == 2) {
               var35 = 201;
               var0.drawTextCentered(class90.loginMessage1, NPC.field1290, var35, 16776960, 0);
               var36 = var35 + 15;
               var0.drawTextCentered(class90.loginMessage2, NPC.field1290, var36, 16776960, 0);
               var36 += 15;
               var0.drawTextCentered(class90.loginMessage3, NPC.field1290, var36, 16776960, 0);
               var36 += 15;
               var36 += 7;
               var0.method5689("Login: ", NPC.field1290 - 110, var36, 16777215, 0);
               var37 = 200;

               for(var23 = GrandExchangeOffer.method119(); var0.getTextWidth(var23) > var37; var23 = var23.substring(1)) {
                  ;
               }

               var0.method5689(FontTypeFace.appendTags(var23) + (class90.field1364 == 0 & Client.gameCycle % 40 < 20?IndexFile.getColTags(16776960) + "|":""), NPC.field1290 - 70, var36, 16777215, 0);
               var36 += 15;
               var25 = "Password: ";
               var26 = class90.password;
               var12 = var26.length();
               var27 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var27[var14] = '*';
               }

               var28 = new String(var27);
               var0.method5689(var25 + var28 + (class90.field1364 == 1 & Client.gameCycle % 40 < 20?IndexFile.getColTags(16776960) + "|":""), NPC.field1290 - 108, var36, 16777215, 0);
               var36 += 15;
               var35 = 277;
               var11 = NPC.field1290 + -117;
               boolean var13 = class90.Login_isUsernameRemembered;
               boolean var45 = class90.field1335;
               IndexedSprite var31 = var13?(var45?FileSystem.field3358:class90.field1342):(var45?CombatInfo1.field1199:class7.field235);
               var31.method5899(var11, var35);
               var11 = var11 + var31.originalWidth + 5;
               var1.method5689("Remember username", var11, var35 + 13, 16776960, 0);
               var11 = NPC.field1290 + 24;
               boolean var22 = class55.preferences.hideUsername;
               var18 = class90.field1362;
               IndexedSprite var33 = var22?(var18?FileSystem.field3358:class90.field1342):(var18?CombatInfo1.field1199:class7.field235);
               var33.method5899(var11, var35);
               var11 = var11 + var33.originalWidth + 5;
               var1.method5689("Hide username", var11, var35 + 13, 16776960, 0);
               var36 = var35 + 15;
               int var34 = NPC.field1290 - 80;
               short var20 = 321;
               class19.field328.method5899(var34 - 73, var20 - 20);
               var0.drawTextCentered("Login", var34, var20 + 5, 16777215, 0);
               var34 = NPC.field1290 + 80;
               class19.field328.method5899(var34 - 73, var20 - 20);
               var0.drawTextCentered("Cancel", var34, var20 + 5, 16777215, 0);
               var35 = 357;
               var1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", NPC.field1290, var35, 16776960, 0);
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
               class19.field328.method5899(var5 - 73, var6 - 20);
               var2.drawTextCentered("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180;
               var6 = 326;
               class19.field328.method5899(var5 - 73, var6 - 20);
               var2.drawTextCentered("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class90.loginIndex == 4) {
               var0.drawTextCentered("Authenticator", class90.loginWindowX + 180, 201, 16776960, 0);
               var35 = 236;
               var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var35, 16777215, 0);
               var36 = var35 + 15;
               var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var36, 16777215, 0);
               var36 += 15;
               var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var36, 16777215, 0);
               var36 += 15;
               var23 = "PIN: ";
               var25 = Sequence.field3752;
               var10 = var25.length();
               char[] var48 = new char[var10];

               for(var12 = 0; var12 < var10; ++var12) {
                  var48[var12] = '*';
               }

               String var29 = new String(var48);
               var0.method5689(var23 + var29 + (Client.gameCycle % 40 < 20?IndexFile.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 108, var36, 16777215, 0);
               var36 -= 8;
               var0.method5689("Trust this computer", class90.loginWindowX + 180 - 9, var36, 16776960, 0);
               var36 += 15;
               var0.method5689("for 30 days: ", class90.loginWindowX + 180 - 9, var36, 16776960, 0);
               var9 = 180 + class90.loginWindowX - 9 + var0.getTextWidth("for 30 days: ") + 15;
               var10 = var36 - var0.verticalSpace;
               IndexedSprite var49;
               if(class90.field1363) {
                  var49 = class90.field1342;
               } else {
                  var49 = class7.field235;
               }

               var49.method5899(var9, var10);
               var36 += 15;
               var12 = class90.loginWindowX + 180 - 80;
               short var43 = 321;
               class19.field328.method5899(var12 - 73, var43 - 20);
               var0.drawTextCentered("Continue", var12, var43 + 5, 16777215, 0);
               var12 = class90.loginWindowX + 180 + 80;
               class19.field328.method5899(var12 - 73, var43 - 20);
               var0.drawTextCentered("Cancel", var12, var43 + 5, 16777215, 0);
               var1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class90.loginWindowX + 180, var43 + 36, 255, 0);
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
               var0.method5689("Username/email: ", class90.loginWindowX + 180 - 145, var36, 16777215, 0);
               var37 = 174;

               for(var23 = GrandExchangeOffer.method119(); var0.getTextWidth(var23) > var37; var23 = var23.substring(1)) {
                  ;
               }

               var0.method5689(FontTypeFace.appendTags(var23) + (Client.gameCycle % 40 < 20?IndexFile.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 34, var36, 16777215, 0);
               var36 += 15;
               var7 = class90.loginWindowX + 180 - 80;
               short var8 = 321;
               class19.field328.method5899(var7 - 73, var8 - 20);
               var0.drawTextCentered("Recover", var7, var8 + 5, 16777215, 0);
               var7 = class90.loginWindowX + 180 + 80;
               class19.field328.method5899(var7 - 73, var8 - 20);
               var0.drawTextCentered("Back", var7, var8 + 5, 16777215, 0);
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
               class19.field328.method5899(var5 - 73, var6 - 20);
               var0.drawTextCentered("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class90.field1359 > 0) {
            NPC.method1878(class90.field1359);
            class90.field1359 = 0;
         }

         class80.method1769();
         ChatLineBuffer.titlemuteSprite[class55.preferences.muted?1:0].method5899(class90.field1336 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(IndexStoreActionHandler.field3390 != null) {
               var36 = class90.field1336 + 5;
               var37 = 463;
               byte var38 = 100;
               byte var39 = 35;
               IndexStoreActionHandler.field3390.method5899(var36, var37);
               var0.drawTextCentered("World" + " " + Client.world, var38 / 2 + var36, var39 / 2 + var37 - 2, 16777215, 0);
               if(World.listFetcher != null) {
                  var1.drawTextCentered("Loading...", var38 / 2 + var36, var39 / 2 + var37 + 12, 16777215, 0);
               } else {
                  var1.drawTextCentered("Click to switch", var38 / 2 + var36, var39 / 2 + var37 + 12, 16777215, 0);
               }
            } else {
               IndexStoreActionHandler.field3390 = class81.getSprite(Renderable.indexSprites, "sl_button", "");
            }
         }

      }
   }
}
